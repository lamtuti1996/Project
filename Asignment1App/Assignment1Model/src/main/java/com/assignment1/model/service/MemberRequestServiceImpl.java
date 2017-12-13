package com.assignment1.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment1.model.dao.DataDAO;
import com.assignment1common.model.MemberRequests;


@Service
public class MemberRequestServiceImpl implements MemberRequestService {

	@Autowired
	DataDAO dao;

	@Override
	public List<MemberRequests> getAllMemberRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveMemberRequest(MemberRequests mr) {
		dao.addMemberRequest(mr);

	}

	@Override
	public MemberRequests getMemberRequestByID(int id) {
		// TODO Auto-generated method stub
		return dao.getMemberRequestByMemberID(id);
	}

}
