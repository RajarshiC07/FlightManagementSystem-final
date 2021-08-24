package com.cg.flightmgmt.Controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200")
public class UserServiceController {
	
	public static int logValidator = 0;
	public static String UserType = "";
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public Users addUser(@RequestBody Users user)
	{
		userService.validateUser(user);
		Users userdb= userService.addUser(user);
		return userdb;
	}
	
	@GetMapping("/viewbyId/{userId}")
	public Users viewUser(@PathVariable("userId") BigInteger userId)
	{
			Users userdb = new Users();
			userdb=userService.viewUser(userId);
			return userdb;

	}
	
	@GetMapping("/viewallUsers")
	public ResponseEntity<?> viewUser()
	{
				List<Users> list= userService.viewUser();
				return ResponseEntity.ok(list);
	}
	
	@PutMapping("/updateUser")
	public Users updateUser(@RequestBody Users user)
	{

			userService.validateUser(user);
			Users userdb= userService.updateUser(user);
			return userdb;

	}
		
	@DeleteMapping("/deletebyId/{userId}")
	public String deleteUser(@PathVariable("userId") String userId)
	{

			userService.deleteUser(BigInteger.valueOf(Long.parseLong(userId)));
			return ("UserId"+userId+" has been deleted.");
	}
	@GetMapping("/Login/{userId}/{userPassword}")
	public String loggingUser(@PathVariable("userId") BigInteger userId,@PathVariable("userPassword") String userPassword)
	{
		Users user = userService.loginDetails(userId, userPassword);
		if(Objects.nonNull(user))
		{	
			logValidator = 1;
			UserType = userService.viewUser(userId).getUserType();
			return user.getUserType();
		}
		else
			return "no user";
	}
	@GetMapping("/Logout")
	public ResponseEntity<?> logOutUser()
	{
		logValidator = 0;
		UserType = "";
		return ResponseEntity.ok("Logged Out");
	}
}