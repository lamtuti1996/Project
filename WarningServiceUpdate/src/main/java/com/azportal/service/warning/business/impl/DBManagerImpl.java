package com.azportal.service.warning.business.impl;

import com.azportal.service.warning.business.DBManager;
import com.azportal.service.warning.dao.TransactionDAO;

import com.azportal.service.warning.entity.WarningSerivceObj;

/**
 * @author ThangDQ
 *
 */

public class DBManagerImpl implements DBManager {

	private TransactionDAO transactionDao;

	public TransactionDAO getTransactionDao() {
		return transactionDao;
	}

	public void setTransactionDao(TransactionDAO transactionDao) {
		this.transactionDao = transactionDao;
	}

	public int test() throws Exception {
		return transactionDao.test();
	}

	public int insertRequest(WarningSerivceObj ws) {
		// TODO Auto-generated method stub
		return transactionDao.insertRequest(ws);
	}

}
