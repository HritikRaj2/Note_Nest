package com.notenest.notenest.repository;

import com.notenest.notenest.entity.InformationEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InformationEntryRepository extends MongoRepository<InformationEntry, Object>{
}
