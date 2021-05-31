package com.ck.anagrams.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileValidator {
    private static final Logger logger = LoggerFactory.getLogger(FileValidator.class);
    private static final String MIME_TYPE_TEXT = "text/plain";

    public boolean isExistingFile(String path) {
        var file = new File(path);
        return file.exists() && !file.isDirectory();
    }

    public boolean isTextFile(String path) {
        try {
            return Files.probeContentType(Paths.get(path)).equals(MIME_TYPE_TEXT);
        } catch (IOException e) {
            logger.error("Error reading file {} !", path, e);
            return false;
        }
    }
}
