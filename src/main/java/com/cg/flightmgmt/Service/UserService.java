package com.cg.flightmgmt.Service;

import java.math.BigInteger;
import java.util.List;

import com.cg.flightmgmt.Entity.Users;

public interface UserService {
	public Users addUser(Users user);
	
	public Users viewUser(BigInteger userId);
	
	public List<Users> viewUser();
	
	public Users updateUser(Users user);
	
	public void deleteUser(BigInteger userId);
	
	public void validateUser(Users user); 

	public Users loginDetails(BigInteger userId,String userPassword);
}
