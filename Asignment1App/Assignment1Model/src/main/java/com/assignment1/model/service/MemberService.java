package com.assignment1.model.service;

import java.util.Date;
import java.util.List;

import com.assignment1common.entity.MemberMemberRequestBook;
import com.assignment1common.model.Members;



public interface MemberService {

	List<Members> getAllMember();

	Members getMemberByID(int id);

	void saveMember(Members m);

	List<MemberMemberRequestBook> getAllMemberByPublication(Date date);
	
	void deleteMember(int id);
}
