package com.example.email.service;

import com.example.email.model.MailModel;

public interface IMailService {

    void push(String to, String subject, String body);

    void push(MailModel mail);

    void run();
}
