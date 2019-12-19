package com.business.ms.service;

import com.business.ms.model.EntityBusinessCredit;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBusinessCreditService {

	Flux<EntityBusinessCredit> allEntityBusinessCredit();
	
	Mono<EntityBusinessCredit> saveEntityBusinessCredit(final EntityBusinessCredit businessCredi);
	
	Mono<EntityBusinessCredit> updEntityBusinessCredit(final EntityBusinessCredit businessCredi);
	
	Mono<Void> dltEntityBusinessCredit(String id);
	
	Flux<EntityBusinessCredit> findEntityBusinessCreditDocCli(String docCli);
	
	Mono<EntityBusinessCredit> transactionCreditBusiness(String numCred,String tipo,Double cash);
}
