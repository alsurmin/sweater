package com.example.ropos;

import com.example.domain.Message;
import com.example.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/*
 This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
 CRUD refers Create, Read, Update, Delete
 */
public interface MessageRepo extends CrudRepository<Message, Long> {

    Page<Message> findAll(Pageable pageable);

    Page<Message> findByTag(String tag, Pageable pageable);

    @Query("from Message m where m.author = :author")
    Page<Message> findByUser(Pageable pageable, @Param("author") User author);
}
