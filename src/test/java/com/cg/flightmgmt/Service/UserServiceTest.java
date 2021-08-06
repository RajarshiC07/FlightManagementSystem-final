package com.cg.flightmgmt.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.flightmgmt.Entity.Users;
import com.cg.flightmgmt.Repository.UserDao;
import com.cg.flightmgmt.Service.UserService;


@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@MockBean
	private UserDao userdao;
	
	Users users;
	
	@BeforeEach
    void setUp() throws Exception
    {
		users=Users.builder().userType("Admin").userId(BigInteger.valueOf(20L)).userName("Anwesha").userPassword("Qwerty").userPhone(BigInteger.valueOf(55L)).userEmail("an@gmail.com").build();
		List<Users> list = new ArrayList<Users>(){ {add(users);}};
        Mockito.when(userdao.save(users)).thenReturn(users);
        Mockito.when(userdao.findAll()).thenReturn(list);
        Mockito.when(userdao.findById(BigInteger.valueOf(20L))).thenReturn(Optional.of(users));
    }
	
	@Test
    @DisplayName("testing adding the Users")
	void addUserTest() {
		Mockito.when(userdao.findById(BigInteger.valueOf(20L))).thenReturn(Optional.ofNullable(null));
		assertEquals(users,userService.addUser(users));    
	}
	
	@Test
    @DisplayName("testing viewing all the user")
    void viewUserTest()
    {
		List<Users> list = new ArrayList<Users>(){{add(users);}};
        assertEquals(list,userService.viewUser());
    }
	
	@Test
    @DisplayName("testing update all users")
    void updateUserTest()
    {
        assertEquals(users,userService.updateUser(users));
    }
}