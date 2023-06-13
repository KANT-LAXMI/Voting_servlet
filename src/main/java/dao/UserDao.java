package dao;

import java.sql.Date;
import java.sql.SQLException;

import pojos.User;

public interface UserDao {
//add a method for user authentication(login)
	User authenticateUser(String email, String password) throws SQLException;
// add a new method register user
	boolean addUser(String firstName, String lastName, String email, String password, Date dob) throws SQLException;
}
