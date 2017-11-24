package com.check.kafka;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.check.db.Message;
import com.check.db.MessageRepository;

public class Receiver {

	@Autowired
	private MessageRepository messageRepository;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(Receiver.class);

	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}

	@KafkaListener(topics = "${spring.kafka.template.default-topic}")
	public void receive(String payload) {
		LOGGER.info("received payload='{}'", payload);
		System.err.println(("received payload='{}'" + payload));
		Message me = new Message();
		me.setMsg(payload);

		messageRepository.save(me);
		
		latch.countDown();
	}
}
