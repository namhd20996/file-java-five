package com.example.labs.service.impl;

import com.example.labs.service.IParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ParamServiceImpl implements IParamService {

    @Autowired
    private HttpServletRequest req;

    @Override
    public String getString(String name, String defaultValue) {
        String value = req.getParameter(name);
        return value == null ? defaultValue : value;
    }

    @Override
    public int getInt(String name, int defaultValue) {
        String value = getString(name, String.valueOf(defaultValue));
        return Integer.parseInt(value);
    }

    @Override
    public double getDouble(String name, double defaultValue) {
        String value = getString(name, String.valueOf(defaultValue));
        return Double.parseDouble(value);
    }

    @Override
    public boolean getBoolean(String name, boolean defaultValue) {
        String value = getString(name, String.valueOf(defaultValue));
        return Boolean.parseBoolean(value);
    }

    @Override
    public Date getDate(String name, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String date = req.getParameter(name);
        try {
            return sdf.parse(date);
        } catch (Exception e) {
            return null;
        }

    }


    public void save(MultipartFile multipartFile, String uploadDir, String fileName) throws IOException {
        Path path = Paths.get(uploadDir);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = path.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("Fail");
        }
    }
}
