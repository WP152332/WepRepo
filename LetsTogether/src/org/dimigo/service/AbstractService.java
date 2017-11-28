package org.dimigo.service;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public abstract class AbstractService {
	public Connection getConnection() throws Exception{
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
		
			return ds.getConnection();
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("DB 연결에 실패하였습니다.");
		}
	}
}
