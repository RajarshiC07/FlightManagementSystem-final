package com.cg.flightmgmt.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.cg.flightmgmt.Entity.Users;
import com.cg.flightmgmt.Repository.UserDao;

@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private TestEntityManager entityManager; 
	
	@BeforeEach
    void setUp() throws Exception
    {
		Users users=Users.builder().userType("Admin").userId(BigInteger.valueOf(1L)).userName("Anwesha").userPassword("Qwerty").userPhone(BigInteger.valueOf(55L)).userEmail("an@gmail.com").build();
		entityManager.persist(users);
    }
	
	@Test
	public void saveUsersTest()
	{
		Users users=Users.builder().userType("Admin").userId(BigInteger.valueOf(1L)).userName("Anwesha").userPassword("Qwerty").userPhone(BigInteger.valueOf(55L)).userEmail("an@gmail.com").build();
		assertEquals(users,userdao.save(users));
	}
		
	@Test
	public void getUserTest() {
		BigInteger userId=BigInteger.valueOf(1L);
		Users users=userdao.findById(userId).get();
	}
		
	@Test
	public void getListOfUsersTest ()
	{
		List<Users> users=userdao.findAll();
	}

}