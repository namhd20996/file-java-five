package com.example.labs.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public interface IParamService {
    String getString(String name, String defaultValue);

    int getInt(String name, int defaultValue);

    double getDouble(String name, double defaultValue);

    boolean getBoolean(String name, boolean defaultValue);

    Date getDate(String name, String pattern);

    void save(MultipartFile multipartFile, String uploadDir, String fileName) throws IOException;
}
