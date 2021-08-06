package com.cg.flightmgmt.Controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.Entity.Users;
import com.cg.flightmgmt.Service.UserService;
@RestController
public class UserServiceController {
	
	public static int logValidator = 0;
	public static String UserType = "";
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody Users user)
	{
		userService.validateUser(user);
		Users userdb= userService.addUser(user);
		return ResponseEntity.ok(userdb);
	}
	
	@GetMapping("/viewbyId/{userId}")
	public ResponseEntity<?> viewUser(@PathVariable("userId") BigInteger userId)
	{
		if(logValidator == 1) 
		{
			if(UserType.equalsIgnoreCase("admin"))
			{
				Users userdb=userService.viewUser(userId);
				return ResponseEntity.ok(userdb);
			}
			else
				return ResponseEntity.ok("You don't have admin privileges");
		}
		else
			return ResponseEntity.ok("You have not logged in yet");
	}
	
	@GetMapping("/viewallUsers")
	public ResponseEntity<?> viewUser()
	{
		if(logValidator == 1) 
		{
			if(UserType.equalsIgnoreCase("admin"))
			{
				List<Users> list= userService.viewUser();
				return ResponseEntity.ok(list);
			}
			else
				return ResponseEntity.ok("You don't have admin privileges");
		}
		else
			return ResponseEntity.ok("You have not logged in yet");
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody Users user)
	{
		if(logValidator == 1) 
		{
			userService.validateUser(user);
			Users userdb= userService.updateUser(user);
			return ResponseEntity.ok(userdb);
		}
		else
			return ResponseEntity.ok("You have not logged in yet");
	}
		
	@DeleteMapping("/deletebyId/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") BigInteger userId)
	{
		if(logValidator == 1) 
		{
			userService.deleteUser(userId);
			return ResponseEntity.ok("UserId"+userId+" has been deleted.");
		}
		else
			return ResponseEntity.ok("You have not logged in yet");
	}
	@GetMapping("/Login/{userId}/{userPassword}")
	public ResponseEntity<?> loggingUser(@PathVariable("userId") BigInteger userId,@PathVariable("userPassword") String userPassword)
	{
		boolean value = userService.loginDetails(userId, userPassword);
		if(value == true)
		{	
			logValidator = 1;
			UserType = userService.viewUser(userId).getUserType();
			return ResponseEntity.ok("Logged In");
		}
		else
			return ResponseEntity.ok("Invalid Credentials");
	}
	@GetMapping("/Logout")
	public ResponseEntity<?> logOutUser()
	{
		logValidator = 0;
		UserType = "";
		return ResponseEntity.ok("Logged Out");
	}
}