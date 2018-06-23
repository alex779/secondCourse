/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uni.projectone.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hovercat
 *
 */
public interface ScheduleDao {

    Integer addSchedule(int runId, String depTime, String depDay, int seatNum, String route);

    void deleteSchedule(Integer id);

    void updateSchedule(Integer id);

    List<Schedule> getAllSchedules();

    Schedule getById(Integer id);

}
