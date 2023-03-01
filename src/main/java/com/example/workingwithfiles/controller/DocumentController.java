package com.example.workingwithfiles.controller;


import com.example.workingwithfiles.service.DocumentManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

@RestController
public class DocumentController {

    @Autowired
    private final DocumentManagerService documentManagerService;

    public DocumentController(DocumentManagerService documentManagerService) {
        this.documentManagerService = documentManagerService;
    }

    @GetMapping("/documents")
    public HashMap<String, Long> getDocuments(@RequestParam("path") String path) throws IOException {
        System.out.println("Request params: " + path);
        return documentManagerService.countFilesAndPages(Path.of(path));
    }
}
