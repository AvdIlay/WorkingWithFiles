package com.example.workingwithfiles.fileReaders;

import com.aspose.words.Document;
import com.example.workingwithfiles.DocumentInterface;


public class DocReader implements DocumentInterface {
    private final Document document;

    public DocReader(String path) throws Exception {
        this.document = new Document(path);
    }

    @Override
    public Long countPages() throws Exception {
        return (long) this.document.getPageCount();
    }
}
