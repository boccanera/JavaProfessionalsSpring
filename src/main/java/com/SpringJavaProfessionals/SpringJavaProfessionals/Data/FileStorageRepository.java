package com.SpringJavaProfessionals.SpringJavaProfessionals.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@Repository
public class FileStorageRepository {

    @Value("${STORAGE_FOLDER}")
    private String storageFolder;

    public void save(){

    }

    public void save(String originalFilename, InputStream inputStream) {
        Path filePath = Path.of(storageFolder).resolve(originalFilename).normalize();
        try {
            Files.copy(inputStream, filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
