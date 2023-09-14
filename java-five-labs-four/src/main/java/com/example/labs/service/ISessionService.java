package com.example.labs.service;

public interface ISessionService {

    <T> T get(String name);

    void set(String name, Object value);

    void remove(String name);

}
