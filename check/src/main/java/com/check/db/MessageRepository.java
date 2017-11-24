package com.check.db;

import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long>, MessageRepositoryCustom{

}
