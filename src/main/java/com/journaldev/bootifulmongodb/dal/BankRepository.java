package com.journaldev.bootifulmongodb.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.journaldev.bootifulmongodb.model.Bank;


@Repository
public interface BankRepository extends MongoRepository<Bank, Integer> {

}
