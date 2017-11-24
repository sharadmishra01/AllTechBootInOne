package com.check.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.check.db.Message;
import com.check.db.MessageRepository;

@RestController
public class HelloController {

	@Autowired
	MessageRepository repo;

	@RequestMapping("/hshsh")
	public String sayHi() {

		return "hi sharad: I am printing the received messages now";
	}

	@RequestMapping(path = "/messages")
	public @ResponseBody Iterable<Message> getAllMsgs() {
		// This returns a JSON or XML with the users
		return repo.findAll();
	}
	
	@RequestMapping(path = "/find/{msg}")
	public boolean  findMessage(@PathVariable("msg") String msg ) {
		// This returns a JSON or XML with the users
		Message messageObject = new Message();
		messageObject.setMsg(msg);
		return repo.checkIfMessageExists(messageObject);
	}

}
