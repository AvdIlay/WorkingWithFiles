package com.example.workingwithfiles.service;


import com.example.workingwithfiles.DocumentManager;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

@Service
public class DocumentManagerService extends DocumentManager {
    public HashMap<String, Long> countFilesAndPages(Path path) throws IOException {
        List<Path> documents = getCountDocuments(path);
        long pages = countTotalPages(documents);

        return new HashMap<>() {{
            put("Documents", (long) documents.size());
            put("Pages", pages);
        }};
    }
}
