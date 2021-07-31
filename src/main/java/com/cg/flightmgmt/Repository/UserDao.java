package com.cg.flightmgmt.Repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.flightmgmt.Entity.Users;
@Repository("UserDao")
public interface UserDao  extends JpaRepository<Users,BigInteger>{
	public Users findByUserIdAndUserPassword(BigInteger userId,String userPassword);
}
