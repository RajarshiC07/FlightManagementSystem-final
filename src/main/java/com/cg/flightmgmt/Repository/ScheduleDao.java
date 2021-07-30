package com.cg.flightmgmt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.flightmgmt.Entity.Schedule;

public interface ScheduleDao extends JpaRepository<Schedule,Integer> {

}
