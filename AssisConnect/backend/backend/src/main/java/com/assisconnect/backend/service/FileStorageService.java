package com.assisconnect.backend.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {

    private final String uploadDir = "uploads/idosos";

    public String salvarArquivo(MultipartFile file) {
        try {
            // Criar pasta se não existir
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Gerar nome único
            String nomeArquivo = UUID.randomUUID() + "_" + file.getOriginalFilename();

            // Caminho completo
            Path filePath = uploadPath.resolve(nomeArquivo);

            // Salvar arquivo
            Files.copy(file.getInputStream(), filePath);

            // Retornar caminho (isso vai pro banco)
            return uploadDir + "/" + nomeArquivo;

        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar arquivo", e);
        }
    }
}