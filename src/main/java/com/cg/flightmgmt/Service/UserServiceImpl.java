package com.cg.flightmgmt.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flightmgmt.Entity.Users;
import com.cg.flightmgmt.Exceptions.RecordAlreadyPresentException;
import com.cg.flightmgmt.Exceptions.UserNotFoundException;
import com.cg.flightmgmt.Repository.UserDao;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userdao;
	
	@Override
	public List<Users> viewUser()
	{
		return userdao.findAll();
	}
	
	@Override
	public Users viewUser(BigInteger userId)
	{
		Users user=userdao.findById(userId).orElse(null);
		if(Objects.isNull(user))
			throw new UserNotFoundException("No user present with user Id"+userId);
		return user;
	}
	
	@Override
	public Users addUser(Users user)
	{
		user.setUserId(BigInteger.valueOf(0));
		Users userdb = userdao.findById(user.getUserId()).orElse(null);
		if(Objects.nonNull(userdb))
		{
			throw new RecordAlreadyPresentException("The user is already present.");
		}
		return userdao.save(user);
	}
	
	@Override
	public Users updateUser(Users user)
	{
		Users userdb = userdao.findById(user.getUserId()).orElse(null);
		
		if(Objects.isNull(userdb))
		{
			throw new UserNotFoundException("Enter valid User Id.");
		}
		else
		{
			if (Objects.nonNull(user.getUserType()) && !"".equalsIgnoreCase(user.getUserType())) 
			{
				userdb.setUserType(user.getUserType());
			}
			if (Objects.nonNull(user.getUserName()) && !"".equalsIgnoreCase(user.getUserName())) 
			{
				userdb.setUserName(user.getUserName());
			}
			if (Objects.nonNull(user.getUserPassword()) && !"".equalsIgnoreCase(user.getUserPassword())) 
			{
				userdb.setUserPassword(user.getUserPassword());
			}
			if (Objects.nonNull(user.getUserPhone())) 
			{
				userdb.setUserPhone(user.getUserPhone());
			}
			if (Objects.nonNull(user.getUserEmail()) && !"".equalsIgnoreCase(user.getUserEmail())) 
			{
				userdb.setUserEmail(user.getUserEmail());
			}
		
			return userdao.save(userdb);
		}
	}
	
	@Override
	public void deleteUser(BigInteger userId)
	{
		if(Objects.isNull(userdao.findById(userId).orElse(null)))
		{
			throw new UserNotFoundException("The User Id entered is not present.");
		}
		userdao.deleteById(userId);
	}
	
	@Override
	public void validateUser(Users user)
	{
		String s=String.valueOf(user.getUserPhone());
		Pattern p=Pattern.compile("^[1-9]{1}[0-9]{9}$");
		Matcher match=p.matcher(s);
		if(s.length()!=10 && !match.matches())
		{
			throw new UserNotFoundException("The Phone Number is invalid.");
		}
		
		String email=user.getUserEmail();
		Pattern pattern=Pattern.compile("^[a-zA-Z0-9+]+@[a-zA-Z0-9.-]+$");
		Matcher m=pattern.matcher(email);
		if(!m.matches())
		{
			throw new UserNotFoundException("The Email Address is invalid.");
		}
	}
	public Users loginDetails(BigInteger userId,String userPassword)
	{
		Users user = userdao.findByUserIdAndUserPassword(userId, userPassword);
		return user;
	}

}
