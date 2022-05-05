package com.haizhi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author wangjia
 * @Date 2022/5/4
 */
public class JdbcTests {
    public static void main(String[] args) {

        //声明Connection对象
        Connection con;
        //驱动程序名
        String driver = "com.mysql.jdbc.Driver";    
        //URL指向要访问的数据库名test
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123456";
        //遍历查询结果集
            try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库
            con = DriverManager.getConnection(url,user,password);

            //2.创建statement类对象，用来执行SQL语句
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = "select * from person";
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            String name = "";
            int id = 0;
            while(rs.next()){
                //获取name这列数据
                name = rs.getString("per_name");
                //获取uid这列数据
                id = rs.getInt("per_id");
            }
            System.out.println("name:" + name + ", id:" + id);

            rs.close();
            con.close();
        } catch(ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            System.out.println("数据库数据成功获取！！");
        }
    }
}
