package com.example.workingwithfiles;

import com.example.workingwithfiles.fileReaders.DocReader;
import com.example.workingwithfiles.fileReaders.PdfReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class DocumentManager {
    public enum DocumentType {
        DOC,
        PDF,
        OTHER
    }

    public static long getCountPagesDocument(Path path) throws Exception {
        String fileName = String.valueOf(path.getFileName());
        String stringPath = String.valueOf(path);

        DocumentType documentType = getDocumentType(fileName);
        long countPage = 0L;

        switch (documentType) {
            case DOC -> {
                Long docPages = new DocReader(stringPath).countPages();
                countPage += docPages;
            }
            case PDF -> {
                Long pdfPages = new PdfReader(stringPath).countPages();
                countPage += pdfPages;
            }
        }

        return countPage;
    }

    public static long countTotalPages(List<Path> documents) {
        return documents.stream()
                .map(x -> {
                    try {
                        return DocumentManager.getCountPagesDocument(x);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .reduce(Long::sum)
                .orElse(-1L);
    }

    //Method counting documents
    public static List<Path> getCountDocuments(Path path) throws IOException {
        return Files.walk(path)
                .filter(Files::isReadable)
                .filter(x -> filterDocuments(getDocumentType(String.valueOf(x))))
                .collect(Collectors.toList());
    }

    private static DocumentType getDocumentType(String s) {
        if (s.endsWith(".doc") || s.endsWith(".docx")) {
            return DocumentType.DOC;
        } else if (s.endsWith(".pdf")) {
            return DocumentType.PDF;
        } else {
            return DocumentType.OTHER;
        }
    }

    private static boolean filterDocuments(DocumentType documentType) {
        return documentType != DocumentType.OTHER;
    }
}
