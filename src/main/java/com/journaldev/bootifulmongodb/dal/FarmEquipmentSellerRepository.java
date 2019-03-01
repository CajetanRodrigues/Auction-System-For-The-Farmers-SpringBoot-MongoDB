package com.journaldev.bootifulmongodb.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmEquipmentSellerRepository extends MongoRepository<FarmEquipmentSellerRepository, Integer> {

}
