package com.business.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business.ms.model.EntityBusinessCredit;
import com.business.ms.service.BusinessCreditServiceImple;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api")
public class ControllerBusinessCredit {
	
	@Autowired
	BusinessCreditServiceImple imple;
	
	@GetMapping("/getBusinessCredit")
	Flux<EntityBusinessCredit> getBusinessCredit(){
		return imple.allEntityBusinessCredit();
	}
	
	@GetMapping("/getBusinessCrediDoc/{docCli}")
	Mono<EntityBusinessCredit> getBusinessCrediDoc(@PathVariable("docCli") String docCli){
		return imple.findEntityBusinessCreditDocCli(docCli);
	}
	@PostMapping("/postBusinessCredit")
	Mono<EntityBusinessCredit> postBusinessCredit(@RequestBody EntityBusinessCredit businessCredit)
	{
		return imple.saveEntityBusinessCredit(businessCredit);
	}
	
	@PutMapping("/updBusinessCredit")
	Mono<EntityBusinessCredit> updBusinessCredit(@RequestBody EntityBusinessCredit businessCredit)
	{
		return imple.updEntityBusinessCredit(businessCredit);
	}
	
	@DeleteMapping("/dltBusinessCredit/{id}")
	Mono<Void> dltBusinessCredit(@PathVariable String id){
		return imple.dltEntityBusinessCredit(id);
	}
	
	@PostMapping("/updTransancionesBusinessCredit/{doc}/{tipo}/{cash}")
	public Mono<EntityBusinessCredit> updTransancionesBusinessCredit(@PathVariable("doc") String doc 
			,@PathVariable("tipo") String tipo ,@PathVariable("cash")  Double cash){
			return imple.findEntityBusinessCreditDocCli(doc)
					.flatMap(p ->{
						if(tipo.equals("r") && p.getCash() >= cash) {
							p.setCash(p.getCash() - cash);
						}else if (tipo.equals("d")){
							p.setCash( p.getCash() + cash);
						}
				return imple.updEntityBusinessCredit(p);
				});

	}

}
