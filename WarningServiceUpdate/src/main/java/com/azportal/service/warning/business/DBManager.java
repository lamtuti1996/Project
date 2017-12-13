package com.azportal.service.warning.business;


import com.azportal.service.warning.entity.WarningSerivceObj;

/**
 * @author ThangDQ
 *
 */

public interface DBManager {
	int test() throws Exception;
	
	int insertRequest(WarningSerivceObj ws);
}