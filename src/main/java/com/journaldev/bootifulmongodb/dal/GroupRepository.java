package com.journaldev.bootifulmongodb.dal;

import com.journaldev.bootifulmongodb.model.Group;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends  MongoRepository<Group,Integer> {

}
