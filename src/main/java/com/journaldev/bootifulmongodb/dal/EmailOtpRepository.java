package com.journaldev.bootifulmongodb.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.journaldev.bootifulmongodb.model.EmailOtp;



@Repository
public interface EmailOtpRepository extends MongoRepository<EmailOtp, String >{
		@Query("{ 'name' : ?0 , 'otp' : ?1  })")
		EmailOtp checkEmailOtp(@Param("emailData")String emailData,@Param("otpData") String otpData);
}
	

