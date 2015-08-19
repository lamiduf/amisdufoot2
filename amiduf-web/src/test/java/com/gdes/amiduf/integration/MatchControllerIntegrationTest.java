package com.gdes.amiduf.integration;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.gdes.amiduf.AmidufWebApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AmidufWebApplication.class)
@WebIntegrationTest(randomPort=true)
public class MatchControllerIntegrationTest {
	
	@Value("${local.server.port}")
	private int port;

	@Test
	public void runAndInvokeHello() {
		String url = "http://localhost:"+ port + "/";
		String body = new RestTemplate().getForObject(url, String.class);
		assertEquals("hello GDES", body);
	}
	
}
