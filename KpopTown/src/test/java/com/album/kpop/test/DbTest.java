package com.album.kpop.test;


import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
public class DbTest {

	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://127.0.0.1:3306/pro?serverTimezone=Asia/Seoul";
	private static final String USER = "Seung";
	private static final String PW = "1234";
	
	@Test
	public void testConnection() throws Exception{
		
		Class.forName(DRIVER);
		
		try(Connection con = DriverManager.getConnection(URL, USER, PW)) {
			System.out.println("데이터베이스 연결 테스트" + con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
