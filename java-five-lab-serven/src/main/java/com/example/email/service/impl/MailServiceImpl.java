package com.example.email.service.impl;

import com.example.email.model.MailModel;
import com.example.email.service.IMailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements IMailService {

    private final JavaMailSender sender;

    private final List<MimeMessage> queue = new ArrayList<>();

    @Override
    public void push(String to, String subject, String body) {
        MailModel mail = new MailModel(to, subject, body);
        push(mail);
    }

    @Override
    public void push(MailModel mail) {
        try {
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setFrom(mail.getFrom());
            helper.setTo(mail.getTo());
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getBody(), true);
            helper.setReplyTo(mail.getFrom());
            for (String email : mail.getCc()) {
                helper.addCc(email);
            }
            for (String email : mail.getBcc()) {
                helper.addCc(email);
            }
            for (File file : mail.getFiles()) {
                helper.addAttachment(file.getName(), file);
            }
            queue.add(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Scheduled(fixedDelay = 10000)
    public void run() {
        int success = 0, error = 0;
        while (!queue.isEmpty()) {
            MimeMessage message = queue.remove(0);
            try {
                sender.send(message);
                success++;
            } catch (Exception e) {
                error++;
                e.printStackTrace();
            }
            System.out.println("Sent: " + success + " Error: " + error);
        }
    }

    public File convert(MultipartFile multipartFile) throws Exception {
        File file = new File(multipartFile.getOriginalFilename());
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(multipartFile.getBytes());
        fileOutputStream.close();
        return file;
    }
}
