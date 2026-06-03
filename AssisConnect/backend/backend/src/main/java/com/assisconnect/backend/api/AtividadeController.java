
package com.assisconnect.backend.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assisconnect.backend.domain.Atividade;
import com.assisconnect.backend.domain.User;
import com.assisconnect.backend.domain.UserRepository;
import com.assisconnect.backend.service.AlocacaoService;
import com.assisconnect.backend.service.AtividadeService;

@RestController
@RequestMapping("/api/atividades")
public class AtividadeController {

    private final AtividadeService atividadeService;
    private final UserRepository userRepository;
    private final AlocacaoService alocacaoService;

    public AtividadeController(AtividadeService atividadeService,
                               UserRepository userRepository,
                               AlocacaoService alocacaoService) {
        this.atividadeService = atividadeService;
        this.userRepository = userRepository;
        this.alocacaoService = alocacaoService;
    }

   
    @GetMapping
    public ResponseEntity<List<AtividadeDTO>> getAllAtividades(
            @RequestParam(value = "idosoId", required = false) Long idosoId) {

        List<Atividade> list;
        if (idosoId != null) {
            list = alocacaoService.listarAtividadesDoIdoso(idosoId);
        } else {
            list = atividadeService.getAllAtividades();
        }

        var dtos = list.stream()
            .map(a -> new AtividadeDTO(
                a.getId(),
                a.getNome(),
                a.getData(),
                a.getHorario_inicio(),
                a.getHorario_fim(),
                a.getResponsavel() != null ? a.getResponsavel().getId() : null,
                a.getResponsavel() != null ? a.getResponsavel().getName() : null,
                a.getObservacoes(),
                a.getStatus()
            ))
            .toList();

        return ResponseEntity.ok(dtos);
    }

    private User resolveResponsavel(AtividadeRequest req) {
        User resp = null;
        if (req.getResponsavelNome() != null && !req.getResponsavelNome().isBlank()) {
            String nome = req.getResponsavelNome().trim();
            resp = userRepository.findByNameIgnoreCase(nome).orElse(null);
            if (resp == null) {
                resp = new User();
                resp.setName(nome);
                String baseEmail = nome.toLowerCase().replaceAll("[^a-z0-9]", ".");
                if (baseEmail.isEmpty()) {
                    baseEmail = "usuario";
                }
                String email = baseEmail + "@assisconnect.com";
                int count = 1;
                while (userRepository.existsByEmail(email)) {
                    email = baseEmail + count + "@assisconnect.com";
                    count++;
                }
                resp.setEmail(email);
                resp.setPasswordHash("$2a$10$8.t7yS5d9i2W3Xp9yH1uGuW4.b1Lp2Jc7H4FwS1N3j5K6o8p9qR2y"); // senhaPadrao123
                resp.setRole("funcionario");
                resp = userRepository.save(resp);
            }
        } else if (req.getResponsavelId() != null) {
            resp = userRepository.findById(req.getResponsavelId()).orElse(null);
        }

        if (resp == null) {
            resp = userRepository.findAll().stream()
                .filter(u -> "funcionario".equalsIgnoreCase(u.getRole()) || "admin".equalsIgnoreCase(u.getRole()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nenhum usuário cadastrado para ser responsável."));
        }
        return resp;
    }

    @PostMapping
    public ResponseEntity<?> createAtividade(@RequestBody AtividadeRequest req) {
        try {
            User resp = resolveResponsavel(req);

            Atividade a = new Atividade();
            a.setNome(req.getNome());
            a.setData(req.getData());
            a.setHorario_inicio(req.parseInicio());
            a.setHorario_fim(req.parseFim());
            a.setObservacoes(req.getObservacoes());
            a.setStatus(req.getStatus() != null ? req.getStatus() : "pendente");
            a.setResponsavel(resp);

            var salvo = atividadeService.createAtividade(a);

            var dto = new AtividadeDTO(
                salvo.getId(), salvo.getNome(), salvo.getData(),
                salvo.getHorario_inicio(), salvo.getHorario_fim(),
                resp.getId(), resp.getName(), salvo.getObservacoes(),
                salvo.getStatus()
            );

            return ResponseEntity.status(HttpStatus.CREATED).body(dto);

        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Erro ao criar atividade: " + ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAtividade(@PathVariable Long id, @RequestBody AtividadeRequest req) {
        try {
            User resp = resolveResponsavel(req);

            Atividade a = new Atividade();
            a.setNome(req.getNome());
            a.setData(req.getData());
            a.setHorario_inicio(req.parseInicio());
            a.setHorario_fim(req.parseFim());
            a.setObservacoes(req.getObservacoes());
            a.setStatus(req.getStatus() != null ? req.getStatus() : "pendente");
            a.setResponsavel(resp);

            return atividadeService.updateAtividade(id, a)
                .map(salvo -> {
                    var dto = new AtividadeDTO(
                        salvo.getId(), salvo.getNome(), salvo.getData(),
                        salvo.getHorario_inicio(), salvo.getHorario_fim(),
                        salvo.getResponsavel() != null ? salvo.getResponsavel().getId() : null,
                        salvo.getResponsavel() != null ? salvo.getResponsavel().getName() : null,
                        salvo.getObservacoes(),
                        salvo.getStatus()
                    );
                    return ResponseEntity.ok(dto);
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());

        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Erro ao atualizar atividade: " + ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtividade(@PathVariable Long id) {
        return atividadeService.deleteAtividade(id)
            ? ResponseEntity.noContent().build()
            : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
