package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        // implement algorithm here
          new UserDaoJDBCImpl().createUsersTable();
        new UserDaoJDBCImpl().saveUser("Lola","Han",(byte) 27);
        new UserDaoJDBCImpl().saveUser("Vlad", "Tsoy", (byte)28);
        new UserDaoJDBCImpl().saveUser("Tema","Tsoy",(byte) 1);
        new UserDaoJDBCImpl().saveUser("Artur","Han",(byte) 20);
        new UserDaoJDBCImpl().getAllUsers();
        new UserDaoJDBCImpl().cleanUsersTable();
        new UserDaoJDBCImpl().dropUsersTable();

    }
}
