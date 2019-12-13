package com.business.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.ms.model.EntityBusinessCredit;
import com.business.ms.repository.IBusinessCreditRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class BusinessCreditServiceImple implements IBusinessCreditService {

	@Autowired
	IBusinessCreditRepository repository;
	
	
	@Override
	public Flux<EntityBusinessCredit> allEntityBusinessCredit() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Mono<EntityBusinessCredit> saveEntityBusinessCredit(EntityBusinessCredit businessCredi) {
		// TODO Auto-generated method stub
		return repository.save(businessCredi);
	}

	@Override
	public Mono<EntityBusinessCredit> updEntityBusinessCredit(EntityBusinessCredit businessCredi) {
		// TODO Auto-generated method stub
		return  repository.save(businessCredi);
	}

	@Override
	public Mono<Void> dltEntityBusinessCredit(String id) {
		// TODO Auto-generated method stub
		return repository.deleteById(id);
	}

	@Override
	public Mono<EntityBusinessCredit> findEntityBusinessCreditDocCli(String docCli) {
		// TODO Auto-generated method stub
		return repository.findByDocCli(docCli);
	}

	

}
