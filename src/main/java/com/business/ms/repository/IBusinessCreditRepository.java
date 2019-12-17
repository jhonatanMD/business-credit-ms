package com.business.ms.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.business.ms.model.EntityBusinessCredit;

import reactor.core.publisher.Mono;

@Repository
public interface IBusinessCreditRepository extends ReactiveMongoRepository<EntityBusinessCredit,String> {

		
		@Query("{'customer.Ruc':?0}")
		Mono<EntityBusinessCredit> findByDocCli(String docCli);
		
		Mono<EntityBusinessCredit> findByNumCred(String numCred);
		
}
