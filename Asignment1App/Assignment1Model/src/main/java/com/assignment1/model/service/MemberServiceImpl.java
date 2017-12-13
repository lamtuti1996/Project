package com.assignment1.model.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment1.model.dao.DataDAO;
import com.assignment1common.entity.MemberMemberRequestBook;
import com.assignment1common.model.Members;




@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	DataDAO dao;
	
	
	@Override
	public List<Members> getAllMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Members getMemberByID(int id) {
		// TODO Auto-generated method stub
		return dao.getMemberID(id);
	}

	@Override
	public void saveMember(Members m) {
		dao.addMember(m);
		
	}



	@Override
	public void deleteMember(int id) {
		dao.deleteMember(id);
		
	}

	@Override
	public List<MemberMemberRequestBook> getAllMemberByPublication(Date date) {
		// TODO Auto-generated method stub
		return dao.getMemberByDatePublication(date);
	}

}
