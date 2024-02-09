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
        //  new UserDaoJDBCImpl().createUsersTable();
//        new UserDaoJDBCImpl().saveUser("Lola","Han",(byte) 27);
//        System.out.println("Пользователь с именем Лола добавлен в базу данных");
//        new UserDaoJDBCImpl().saveUser("Vlad", "Tsoy", (byte)28);
//        System.out.println("Пользователь с именем VLAD добавлен в базу данных");
//        new UserDaoJDBCImpl().saveUser("Tema","Tsoy",(byte) 1);
//        System.out.println("Пользователь с именем Tema добавлен в базу данных");
//        new UserDaoJDBCImpl().saveUser("Artur","Han",(byte) 20);
//        System.out.println("Пользователь с именем Artur добавлен в базу данных");
//        System.out.println(new UserDaoJDBCImpl().getAllUsers());
//        new UserDaoJDBCImpl().cleanUsersTable();
//        new UserDaoJDBCImpl().dropUsersTable();
        new UserServiceImpl().createUsersTable();
        UserServiceImpl user1 = new UserServiceImpl();
        user1.saveUser("Lola","Han",(byte) 27);
        System.out.println("Пользователь с именем -  добавлен в базу данных");
        new UserServiceImpl().saveUser("Vlad", "Tsoy", (byte)28);
        System.out.println("Пользователь с именем - Vlad добавлен в базу данных");
        new UserServiceImpl().saveUser("Tema","Tsoy",(byte) 1);
        System.out.println("Пользователь с именем - Tema добавлен в базу данных");
        new UserServiceImpl().saveUser("Artur","Han",(byte) 20);
        System.out.println("Пользователь с именем - Artur добавлен в базу данных");
        System.out.println(new UserServiceImpl().getAllUsers());
        new UserServiceImpl().cleanUsersTable();
        new UserServiceImpl().dropUsersTable();
    }
}
