package com.example.labs.service.impl;

import com.example.labs.service.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class SessionServiceImpl implements ISessionService {
    @Autowired
    HttpSession session;

    @Override
    public <T> T get(String name) {
        return (T) session.getAttribute(name);
    }

    @Override
    public void set(String name, Object value) {
        session.setAttribute(name, value);
    }

    @Override
    public void remove(String name) {
        session.removeAttribute(name);
    }
}
