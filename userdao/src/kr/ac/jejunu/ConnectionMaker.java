package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by sieun on 2017. 4. 21..
 */
public interface ConnectionMaker {

    public Connection getConnection() throws ClassNotFoundException, SQLException;

}
