package com.assignment1.model.service;

import java.util.List;

import com.assignment1common.model.MemberRequests;


public interface MemberRequestService {
    List<MemberRequests> getAllMemberRequest();
    
	void saveMemberRequest(MemberRequests mr);
    
    MemberRequests getMemberRequestByID(int id);
}
