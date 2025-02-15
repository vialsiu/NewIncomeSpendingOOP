package org.example.oopjavafxuserdetailsdao.DAOs;

import org.example.oopjavafxuserdetailsdao.DTOs.User;
import org.example.oopjavafxuserdetailsdao.Exceptions.DaoException;

import java.util.List;

public interface UserDaoInterface
{
    public List<User> findAllUsers() throws DaoException;

    public User findUserByUsernamePassword(String username, String password) throws DaoException;

}

