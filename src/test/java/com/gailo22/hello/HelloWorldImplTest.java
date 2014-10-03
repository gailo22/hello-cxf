package com.gailo22.hello;

import static org.junit.Assert.assertEquals;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

public class HelloWorldImplTest {

	@Test
	public void testSayHi() {
		HelloWorldImpl helloWorldImpl = new HelloWorldImpl();
		String response = helloWorldImpl.sayHi("Sam");
		assertEquals("HelloWorldImpl not properly saying hi", "Hello Sam",
				response);
	}

	@Test
	public void test() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(HelloWorld.class);
		factory.setAddress("http://localhost:8080/hello-cxf/HelloWorld");
		HelloWorld client = (HelloWorld) factory.create();

		String reply = client.sayHi("HI");
		System.out.println("Server said: " + reply);
	}
}
