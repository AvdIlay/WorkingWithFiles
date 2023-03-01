package com.example.workingwithfiles.fileReaders;

import com.aspose.pdf.Document;
import com.example.workingwithfiles.DocumentInterface;


public class PdfReader implements DocumentInterface {
    private final Document document;

    public PdfReader(String path) {
        this.document = new Document(path);
    }

    @Override
    public Long countPages() {
        return (long) this.document.getPages().size();
    }
}
