package com.learn.learnMongo.Repository;

import com.learn.learnMongo.Model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book,Integer> {
}
