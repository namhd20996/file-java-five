package com.example.email.model;

import lombok.Data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Data
public class MailModel {

    private String from = "hoangduynam20996@gmail.com";
    private String to;
    private String subject;
    private String body;
    private List<String> cc = new ArrayList<>();
    private List<String> bcc = new ArrayList<>();
    private List<File> files = new ArrayList<>();

    public MailModel(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    public MailModel(String from,
                     String to,
                     String subject,
                     String body,
                     List<String> cc,
                     List<String> bcc,
                     List<File> files
    ) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.cc = cc;
        this.bcc = bcc;
        this.files = files;
    }
}
