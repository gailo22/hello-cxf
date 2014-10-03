package com.gailo22.hello;

import javax.jws.WebService;

@WebService
public interface HelloWorld {
    String sayHi(String text);
}

