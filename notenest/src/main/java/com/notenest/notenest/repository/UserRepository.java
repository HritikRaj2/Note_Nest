package com.notenest.notenest.repository;

import com.notenest.notenest.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

//public interface UserRepository extends MongoRepository<User, ObjectId> {
//    User findByUsername(String username);
//    void deleteByUsername(String username);
//}
public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByUsername(String username);
    public User findByEmail(String email);
}


