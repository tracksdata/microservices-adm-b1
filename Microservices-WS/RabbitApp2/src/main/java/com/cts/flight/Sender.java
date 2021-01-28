package com.cts.flight;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class Sender {

	@Autowired
	private RabbitMessagingTemplate rt;

	@Bean
	public Queue myQueue1() {
		return new Queue("TestQ1", false);
	}
	
	@Bean
	public Queue myQueue2() {
		return new Queue("TestQ2", false);
	}
	
	@Bean
	public Queue myQueue3() {
		return new Queue("TestQ3", false);
	}

	@Bean
	public void sendMessage() {
		Map<String, Object> messages=new HashMap<>();
		messages.put("m1","Test 111 from APP2.... at " + LocalDate.now());
		messages.put("m2","Test 222 from APP2.... at " + LocalDate.now());
		messages.put("m3","Test 333 from APP2.... at " + LocalDate.now());
		rt.convertAndSend("TestQ1",messages);
		rt.convertAndSend("TestQ2",messages);
		rt.convertAndSend("TestQ3",messages);
		
		
	}

}
