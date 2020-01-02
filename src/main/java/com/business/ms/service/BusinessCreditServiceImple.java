package com.business.ms.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.business.ms.model.EntityBusinessCredit;
import com.business.ms.model.EntityTransaction;
import com.business.ms.repository.IBusinessCreditRepository;
import com.business.ms.webclient.CallWebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class BusinessCreditServiceImple implements IBusinessCreditService {

	@Autowired
	IBusinessCreditRepository repository;
	
	@Autowired
	@Qualifier("webClient")
	CallWebClient client;
	
	List<String> docs;
	EntityTransaction transaction;
	List<EntityTransaction> listTransaction;
	SimpleDateFormat format;
	
	
	@Override
	public Flux<EntityBusinessCredit> allEntityBusinessCredit() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Mono<EntityBusinessCredit> saveEntityBusinessCredit(EntityBusinessCredit businessCredi) {
		// TODO Auto-generated method stub
		docs = new ArrayList<>();
		docs.add(businessCredi.getCustomer().getRuc());
		
	/*	return client.responde(docs).flatMap(res ->{
			if(res.getMsj().equals("")) {*/
				return repository.save(businessCredi);
		/*	}else {
				return Mono.empty();
			}
		});*/
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
	public Flux<EntityBusinessCredit> findEntityBusinessCreditDocCli(String docCli) {
		// TODO Auto-generated method stub
		return repository.findByDocCli(docCli);
	}

	@Override
	public Mono<EntityBusinessCredit> transactionCreditBusiness(String numCred, String tipo, Double cash) {
		// TODO Auto-generated method stub
		return repository.findByNumCred(numCred)
			.flatMap(p ->{
			transaction = new EntityTransaction();
			transaction.setCashA(p.getCash());
			if(tipo.equals("c") && p.getCash() >= cash) {
				p.setCash(p.getCash() - cash);
			}else if (tipo.equals("p") && p.getCashPay() >= (p.getCash() + cash) ){
				p.setCash( p.getCash() + cash);
			}
			transaction.setType(tipo);
			 transaction.setCashO(cash);
			 transaction.setCashT(p.getCash());
			 transaction.setDateTra(new Date());
			listTransaction = new ArrayList<>();
			p.getTransactions().forEach(transac-> {
				listTransaction.add(transac);
			});
			listTransaction.add(transaction);
			p.setTransactions(listTransaction);
			return repository.save(p);
	});
	}

	@Override
	public Flux<EntityBusinessCredit> findEntityBusinessCreditDocCliList(List<String> docCli, String status) {
		// TODO Auto-generated method stub
		return repository.findByDocCliList(docCli, status);
	}

	@Override
	public Flux<EntityBusinessCredit> findByBankAndDateOpenBetween(String bank, String dt1, String dt2)
			throws ParseException {
		// TODO Auto-generated method stub
		format = new SimpleDateFormat("yyyy-MM-dd");
		return repository.findByBankAndDateOpenBetween(bank, format.parse(dt1), format.parse(dt2));
	}

	

}
