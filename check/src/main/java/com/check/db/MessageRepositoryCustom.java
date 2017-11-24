package com.check.db;

import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepositoryCustom {
	
	public boolean checkIfMessageExists(Message message);

}
