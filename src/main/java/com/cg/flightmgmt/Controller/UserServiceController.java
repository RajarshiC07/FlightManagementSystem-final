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
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody Users user)
	{
		userService.validateUser(user);
		System.out.println(user);
		Users userdb= userService.addUser(user);
		return ResponseEntity.ok(userdb);
	}
	
	@GetMapping("/viewbyId/{userId}")
	public ResponseEntity<?> viewUser(@PathVariable("userId") BigInteger userId)
	{
		Users userdb=userService.viewUser(userId);
		return ResponseEntity.ok(userdb);
	}
	
	@GetMapping("/viewallUsers")
	public ResponseEntity<?> viewUser()
	{
		List<Users> list= userService.viewUser();
		return ResponseEntity.ok(list);
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody Users user)
	{
		userService.validateUser(user);
		Users userdb= userService.updateUser(user);
		return ResponseEntity.ok(userdb);
		
	}
	
	@DeleteMapping("/deletebyId/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") BigInteger userId)
	{
		userService.deleteUser(userId);
		return ResponseEntity.ok("UserId"+userId+" has been deleted.");
	}

}