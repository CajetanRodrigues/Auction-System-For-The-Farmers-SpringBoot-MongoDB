package com.journaldev.bootifulmongodb.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.journaldev.bootifulmongodb.model.Farmer;

@Repository
public interface FarmerRepository extends MongoRepository<Farmer,Integer> {

}
