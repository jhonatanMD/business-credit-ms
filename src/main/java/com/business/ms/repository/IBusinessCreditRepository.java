package com.business.ms.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.business.ms.model.EntityBusinessCredit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface IBusinessCreditRepository extends ReactiveMongoRepository<EntityBusinessCredit,String> {

		
		@Query("{'customer.Ruc':?0}")
		Flux<EntityBusinessCredit> findByDocCli(String docCli);
		
		
		@Query("{'customer.Ruc':{$in:[ ?0 ]} , status :?1}")
		Flux<EntityBusinessCredit> findByDocCliList(List<String> docCli , String status);
		
		Mono<EntityBusinessCredit> findByNumCred(String numCred);
		
}
