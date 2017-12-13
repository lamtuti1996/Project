package com.azportal.service.warning.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * @author ThangDQ
 *
 */

public class JDBCDAOHelper {

	public static int query4Int(DataSource datasource, String sql, Map paramMap) throws Exception {
		try {

			NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(datasource);

			int result = template.queryForObject(sql, paramMap == null ? new HashMap() : paramMap, Integer.class);

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static int insertData(DataSource datasource, String sql, Map paramMap) {
		try {

			NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(datasource);

			int result = template.update(sql, paramMap);

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;

		}
	}

	/**
	 * 
	 * @param processedSql
	 * @param start
	 * @param limit
	 * @return
	 */
	private static String preprocessSQL(String sql, int start, int limit) throws Exception {
		if (start > -1 && limit > -1) {
			String strROWNUM = "RN_" + System.currentTimeMillis();
			String strTBL = "TBL_" + System.currentTimeMillis();
			StringBuffer strBuf = new StringBuffer();
			strBuf.append("SELECT * FROM (").append(sql).append(") " + strTBL + " LIMIT " + start + "," + limit);
			return strBuf.toString();
		}
		return sql;

	}
}
