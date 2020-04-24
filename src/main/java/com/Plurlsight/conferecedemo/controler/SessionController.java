package com.Plurlsight.conferecedemo.controler;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Plurlsight.conferecedemo.models.Session;
import com.Plurlsight.conferecedemo.repositories.SessionRepository;

@RestController
@RequestMapping("/api/v1/seesions")

public class SessionController {
	@Autowired
	private SessionRepository sessionRepository;
	
	@GetMapping
	public List<Session> list(){
		return sessionRepository.findAll();
		
	}
	@GetMapping
	@RequestMapping("{id}")
	public Session get(@PathVariable Long id) {
		return sessionRepository.getOne(id);
	}

	@PostMapping
	public Session create(@RequestBody final Session session) {
		return sessionRepository.saveAndFlush(session);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		//also need to check for children record before deleteing 
		sessionRepository.deleteById(id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Session update(@PathVariable Long id, @RequestBody Session session) {
		//because this is a PUT, we expect all attricbute to be passed in 
		//TODD: Add validation that all attribute are passed in, otherewisee return 400 ba payload' 
		Session existSession = sessionRepository.getOne(id);
		BeanUtils.copyProperties(session, existSession, "session_id");

	return sessionRepository.saveAndFlush(existSession);
	}
	
	
	

}
