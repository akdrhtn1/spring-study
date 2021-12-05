package com.mystudy.firstproject;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBTest {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://database-3.c3d3xxl4ffv3.ap-northeast-2.rds.amazonaws.com/mother737?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
    private static final String USER = "admin";
    private static final String PASSWORD = "tkdals737";

    @Test
    public void testConnection() throws Exception{
        Class.forName(DRIVER);

        try(Connection con = DriverManager.getConnection(URL,USER,PASSWORD)){
            System.out.println("성공");
            System.out.println(con);
        }catch (Exception e){
            System.out.println("에러발생");
            e.printStackTrace();
        }
    }
}
