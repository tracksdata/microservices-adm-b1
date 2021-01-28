package com.cts.flight;

import java.util.Map;

import javax.management.Query;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class Receiver {

	@Bean
	public Queue myQueue1() {
		return new Queue("TestQ1",false);
	}
	@Bean
	public Queue myQueue2() {
		return new Queue("TestQ2",false);
	}

	
	@Bean
	public Queue myQueue3() {
		return new Queue("TestQ3",false);
	}
	
	@RabbitListener(queues = "TestQ1")
	public void processMessage(Map<String, Object> messages) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("processMessage executed");
		System.out.println(messages.get("m1"));
		System.out.println(messages.get("m2"));
		System.out.println(messages.get("m3"));

		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<");
	}
	
	

}
