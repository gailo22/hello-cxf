
package com.gailo22.hello;

import javax.jws.WebService;

@WebService(endpointInterface = "com.gailo22.hello.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        return "Hello " + text;
    }
}

