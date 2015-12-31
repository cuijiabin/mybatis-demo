package com.cuijiabin.test;

import java.io.Reader;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.Test;

import com.cuijiabin.util.MyBatisSqlSessionFactory;


public class UtilTest {

	@Test
	public void initDatabase() {
//		executeSql("sql/drop_tables.sql");
//		executeSql("sql/create_tables.sql");
		executeSql("sql/sample_data.sql");
	}
	
	public static void executeSql(String sql){
		Connection connection = null;
		Reader reader = null;
		try {
			connection = MyBatisSqlSessionFactory.getConnection();
			ScriptRunner scriptRunner = new ScriptRunner(connection);
			reader = Resources.getResourceAsReader(sql);
			scriptRunner.runScript(reader);
			connection.commit();
			reader.close();
			scriptRunner.closeConnection();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
