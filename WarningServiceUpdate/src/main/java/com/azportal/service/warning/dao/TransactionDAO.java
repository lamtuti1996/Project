package com.azportal.service.warning.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import com.azportal.service.warning.common.JDBCDAOHelper;
import com.azportal.service.warning.entity.WarningSerivceObj;

/**
 * @author ThangDQ
 *
 */

public class TransactionDAO extends BaseDAOImpl {

	public int test() throws Exception {
		String sql = "select count(*) from Users";

		DataSource datasource = this.getDataSource();

		int result = JDBCDAOHelper.query4Int(datasource, sql, new HashMap<Object, Object>());
		return result;
	}

	public int insertRequest(WarningSerivceObj ws) {

		String sql = "";
		Map m = null;
		if (ws.getTimeDiff() >= 0) {
			sql = " insert into WarningService(Message,AddressService,TimeReqeust,TimeDiff,Status) values (:message,:addressService,:timeRequest,:timeDiff,:status)";
			m = new HashMap();

			m.put("message", ws.getMessage());
			m.put("addressService", ws.getAdressService());
			m.put("timeRequest", ws.getTimeRequest());
			m.put("timeDiff", ws.getTimeDiff());
			m.put("status", ws.getStatus());

		} else {

			sql = " insert into WarningService(Message,AddressService,TimeReqeust,Status) values (:message,:addressService,:timeRequest,:status)";

			m = new HashMap();

			m.put("message", ws.getMessage());
			m.put("addressService", ws.getAdressService());
			m.put("timeRequest", ws.getTimeRequest());
			m.put("status", ws.getStatus());
		}
		DataSource datasource = this.getDataSource();

		int result = JDBCDAOHelper.insertData(datasource, sql, m);

		return result;

	}
}
