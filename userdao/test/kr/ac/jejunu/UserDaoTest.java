package kr.ac.jejunu;

import org.junit.Test;

import java.sql.SQLException;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by sieun on 2017. 3. 15..
 */
public class UserDaoTest {

    @Test
    public void get() throws ClassNotFoundException, SQLException {

        String id = "1";
        String name = "이시은";
        String password = "1111";

        UserDao userDao = new JejuUserDao();
        User user = userDao.get(id);
        assertThat(id, is(user.getId()));
        assertThat(name, is(user.getName()));
        assertThat(password, is(user.getPassword()));

    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {

        User user = new User();
        String id = String.valueOf(new Random().nextInt());
        String name = "시봉이";
        String password = "1234";

        user.setId(id);
        user.setName(name);
        user.setPassword(password);

        UserDao userDao = new JejuUserDao();
        userDao.add(user);
        User addedUser = userDao.get(id);

        assertThat(id,is(addedUser.getId()));
        assertThat(name,is(addedUser.getName()));
        assertThat(password,is(addedUser.getPassword()));

    }

    @Test
    public void getHalla() throws ClassNotFoundException, SQLException {

        String id = "1";
        String name = "이시은";
        String password = "1111";

        UserDao userDao = new HallaUserDao();
        User user = userDao.get(id);
        assertThat(id, is(user.getId()));
        assertThat(name, is(user.getName()));
        assertThat(password, is(user.getPassword()));

    }

    @Test
    public void addHalla() throws SQLException, ClassNotFoundException {

        User user = new User();
        String id = String.valueOf(new Random().nextInt());
        String name = "시봉이";
        String password = "1234";

        user.setId(id);
        user.setName(name);
        user.setPassword(password);

        UserDao userDao = new HallaUserDao();
        userDao.add(user);
        User addedUser = userDao.get(id);

        assertThat(id,is(addedUser.getId()));
        assertThat(name,is(addedUser.getName()));
        assertThat(password,is(addedUser.getPassword()));

    }








}
