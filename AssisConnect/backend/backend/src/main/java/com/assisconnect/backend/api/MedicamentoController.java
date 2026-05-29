package com.assisconnect.backend.api;

import com.assisconnect.backend.domain.Medicamento;
import com.assisconnect.backend.service.MedicamentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/medicamentos")
@CrossOrigin(origins = "*")
public class MedicamentoController {

    private final MedicamentoService service;

    public MedicamentoController(MedicamentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<MedicamentoResponse> listar(@RequestParam(required = false) Long residenteId) {
        List<Medicamento> meds;
        if (residenteId != null) {
            meds = service.buscarPorResidente(residenteId);
        } else {
            meds = service.listarTodos();
        }
        return meds.stream().map(MedicamentoResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MedicamentoResponse buscarPorId(@PathVariable Long id) {
        return new MedicamentoResponse(service.buscarPorId(id));
    }

    @PostMapping
    public MedicamentoResponse criar(@RequestBody MedicamentoRequest request) {
        Medicamento med = new Medicamento();
        med.setNome(request.getNome());
        med.setDosagem(request.getDosagem());
        med.setVia(request.getVia());
        med.setHorarioPrevisto(request.getHorarioPrevisto());
        med.setStatus(request.getStatus() != null ? request.getStatus() : "pendente");
        med.setObservacoes(request.getObservacoes());

        Medicamento salvo = service.criar(request.getResidenteId(), med);
        return new MedicamentoResponse(salvo);
    }

    @PutMapping("/{id}")
    public MedicamentoResponse atualizar(@PathVariable Long id, @RequestBody MedicamentoRequest request) {
        Medicamento med = new Medicamento();
        med.setNome(request.getNome());
        med.setDosagem(request.getDosagem());
        med.setVia(request.getVia());
        med.setHorarioPrevisto(request.getHorarioPrevisto());
        med.setStatus(request.getStatus());
        med.setObservacoes(request.getObservacoes());

        Medicamento atualizado = service.atualizar(id, med);
        return new MedicamentoResponse(atualizado);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
