package com.example.ropos;

import com.example.domain.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/*
 This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
 CRUD refers Create, Read, Update, Delete
 */
public interface MessageRepo extends CrudRepository<Message, Long> {

    Page<Message> findAll(Pageable pageable);

    Page<Message> findByTag(String tag, Pageable pageable);

}
