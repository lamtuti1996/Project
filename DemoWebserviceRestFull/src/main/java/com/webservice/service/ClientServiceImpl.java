package com.webservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.dao.DataDao;

import com.webservice.model.Users;




@Service("clientService")
public class ClientServiceImpl implements ClientService {

	@Autowired
	DataDao dao;
	
/*	@Override
	public List<Client> findAddClient() {
		
		return dao.findAllClient();
	}*/

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
