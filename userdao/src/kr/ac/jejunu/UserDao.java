package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;


/**
 * Created by sieun on 2017. 3. 15..
 */

//런타임을 실행할때 만들어진다.

public class UserDao {

    private ConnectionMaker connectionMaker;


    public UserDao(ConnectionMaker connectionMaker){
        this.connectionMaker = connectionMaker;
    }


    public User get(String id) throws ClassNotFoundException, SQLException {

        Connection connection = connectionMaker.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id = ?");
        preparedStatement.setString(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        User user = new User();
        user.setId(resultSet.getString("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));


        resultSet.close();
        preparedStatement.close();
        connection.close();

        return user;
    }



    public void add(User user) throws ClassNotFoundException, SQLException {


        Connection connection = connectionMaker.getConnection();


        PreparedStatement preparedStatement = connection.prepareStatement("insert into user(id, name, password) VALUE (?, ?, ?)");
        preparedStatement.setString(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3,user.getPassword());



        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

    }

    public void setConnectionMaker(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    /*public Connection getConnection() throws ClassNotFoundException, SQLException{

          Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://117.17.102.106/sieun1","root","1234");
    }*/


}
