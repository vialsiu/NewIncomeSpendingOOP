package org.example.oopjavafxuserdetailsdao.BusinessObjects;


import org.example.oopjavafxuserdetailsdao.DAOs.MySqlUserDao;
import org.example.oopjavafxuserdetailsdao.DAOs.UserDaoInterface;
import org.example.oopjavafxuserdetailsdao.DTOs.User;
import org.example.oopjavafxuserdetailsdao.Exceptions.DaoException;

import java.util.List;

public class AppMain
{
    public static void main(String[] args)
    {
        UserDaoInterface IUserDao = new MySqlUserDao();



        try
        {
            System.out.println("\nCall findAllUsers()");
            List<User> users = IUserDao.findAllUsers();

            if( users.isEmpty() )
                System.out.println("There are no Users");
            else {
                for (User user : users)
                    System.out.println("User: " + user.toString());
            }

            System.out.println("\nCall: findUserByUsernamePassword()");
            String username = "smithj";
            String password = "password";

            User user = IUserDao.findUserByUsernamePassword(username, password);

            if( user != null )
                System.out.println("User found: " + user);
            else
                System.out.println("Username with that password not found");

            username = "madmax";
            password = "thunderdome";

            user = IUserDao.findUserByUsernamePassword(username, password);

            if(user != null)
                System.out.println("Username: " + username + " was found: " + user);
            else
                System.out.println("Username: " + username + ", password: " + password +" : NO match found");
        }
        catch( DaoException e )
        {
            e.printStackTrace();
        }
    }
}
