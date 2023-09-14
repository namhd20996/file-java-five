package com.example.labs.service;

import javax.servlet.http.Cookie;

public interface ICookieService {
    Cookie get(String name);

    String getValue(String name);

    Cookie add(String name, String value, int hours);

    void remove(String name);
}
