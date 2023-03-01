package com.example.workingwithfiles.cli;

import com.example.workingwithfiles.DocumentManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class CLIDocumentParser {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(new Scanner(System.in).nextLine());

        // Check if directory exists
        if (!Files.isDirectory(path)) {
            System.out.printf(path.toAbsolutePath() + " - Directory not found");
            return;
        }

        // Calls a method to draw existing files in the directory
        List<Path> documentsPaths = DocumentManager.getCountDocuments(path);
        System.out.println("Documents: " + documentsPaths.size());

        // Calls a method to draw existing pages in the directory
        long pages = DocumentManager.countTotalPages(documentsPaths);

        System.out.println("Pages: " + pages);
    }
}
