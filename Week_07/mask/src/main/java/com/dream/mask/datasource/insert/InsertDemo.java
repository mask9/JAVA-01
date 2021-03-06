package com.dream.mask.datasource.insert;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

/**
 * 批量插入 24s
 * 4线程 4连接 9s
 */
public class InsertDemo {
    
    private static String driver;
    private static String url;
    private static String userName;
    private static String password;
    
    static {
        try {
            InputStream in = InsertDemo.class.getClassLoader().getResourceAsStream("db.properties");
            Properties prop = new Properties();
            prop.load(in);
            
            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            userName = prop.getProperty("username");
            password = prop.getProperty("password");
            
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void test1() throws Exception {
        long start = System.currentTimeMillis();
        Connection conn = getConnection();
        conn.setAutoCommit(false);
        String sql = "insert into order_info(o_id, orderno, total_amount,pay_amount,u_id,state,pay_time,end_time,createtime,updatetime) values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        int key =1;
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 100000; j++) {
                pstmt.setInt(1,key);
                pstmt.setString(2,String.valueOf(key));
                pstmt.setDouble(3,100D);
                pstmt.setDouble(4,100D);
                pstmt.setInt(5,key);
                pstmt.setInt(6,1);
                pstmt.setInt(7,20210228);
                pstmt.setInt(8,20210228);
                pstmt.setInt(9,20210228);
                pstmt.setInt(10,20210228);
                key++;
                pstmt.addBatch();
            }
           
        }
        
        pstmt.executeBatch();
        conn.commit();
        conn.close();
        long end  = System.currentTimeMillis();
        System.out.println("耗时:"+(end-start));
    }
    
    @Test
    public void test1Values() throws Exception {
        long start = System.currentTimeMillis();
        Connection conn = getConnection();
        conn.setAutoCommit(false);
        String sql = "insert into order_info(o_id, orderno, total_amount,pay_amount,u_id,state,pay_time,end_time,createtime,updatetime) values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        int key =1;
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 100000; j++) {
                pstmt.setInt(1,key);
                pstmt.setString(2,String.valueOf(key));
                pstmt.setDouble(3,100D);
                pstmt.setDouble(4,100D);
                pstmt.setInt(5,key);
                pstmt.setInt(6,1);
                pstmt.setInt(7,20210228);
                pstmt.setInt(8,20210228);
                pstmt.setInt(9,20210228);
                pstmt.setInt(10,20210228);
                key++;
                pstmt.addBatch();
            }
            
        }
        
        pstmt.executeBatch();
        conn.commit();
        conn.close();
        long end  = System.currentTimeMillis();
        System.out.println("耗时:"+(end-start));
    }
    /**
     * 获得连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }
    
    @Test
    public void testThread() throws Exception {
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(4);
        new Thread(new InsertThread(countDownLatch,1,250000)).start();
        new Thread(new InsertThread(countDownLatch,250002,250000)).start();
        new Thread(new InsertThread(countDownLatch,500004,250000)).start();
        new Thread(new InsertThread(countDownLatch,750006,250000)).start();
        countDownLatch.await();
        long end  = System.currentTimeMillis();
        System.out.println("耗时:"+(end-start));
    }
    
    class InsertThread implements Runnable{
        
        private CountDownLatch countDownLatch;
        
        private int start;
        
        private int total;
        
        public InsertThread(CountDownLatch countDownLatch, int start, int total) {
            this.countDownLatch = countDownLatch;
            this.start = start;
            this.total = total;
        }
        
        @Override
        public void run() {
            try {
                Connection conn = getConnection();
                conn.setAutoCommit(false);
                String sql = "insert into order_info(o_id, orderno, total_amount,pay_amount,u_id,state,pay_time,end_time,createtime,updatetime) values(?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                for (int i = 0; i < total; i++) {
                    pstmt.setInt(1, start);
                    pstmt.setString(2, String.valueOf(start));
                    pstmt.setDouble(3, 100D);
                    pstmt.setDouble(4, 100D);
                    pstmt.setInt(5, start);
                    pstmt.setInt(6, 1);
                    pstmt.setInt(7, 20210228);
                    pstmt.setInt(8, 20210228);
                    pstmt.setInt(9, 20210228);
                    pstmt.setInt(10, 20210228);
                    pstmt.addBatch();
                    start++;
                }
                pstmt.executeBatch();
                conn.commit();
                conn.close();
                countDownLatch.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
