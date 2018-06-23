/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uni.projectone.domain;

import com.uni.projectone.config.HibernateUtil;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author hovercat
 */
public class ScheduleDaoImpl implements ScheduleDao {

    @Override
    public Integer addSchedule(int runId, String depTime, String depDay, int seatNum, String route) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer scheduleID = null;
        try {
            tx = session.beginTransaction();
            Schedule schedule = new Schedule(runId, depTime, depDay, seatNum, route);
            scheduleID = (Integer) session.save(schedule);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return scheduleID;
    }

    @Override
    public void deleteSchedule(Integer id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Schedule schedule = (Schedule) session.load(Schedule.class, id);
            session.delete(schedule);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    @Override
    public void updateSchedule(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Schedule schedule = (Schedule) session.load(Schedule.class, id);
            session.update(schedule);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.flush();
            session.close();
        }
    }

    @Override
    public List<Schedule> getAllSchedules() {
        List<Schedule> schedules = new ArrayList<>();
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            tx = session.beginTransaction();
            schedules = session.createCriteria(Schedule.class).list();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return schedules;
    }

    @Override
    public Schedule getById(Integer id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Schedule schedule = null;
        try {
            tx = session.beginTransaction();
            schedule = (Schedule) session.createCriteria(Schedule.class).add(Restrictions.eq("runId", id)).uniqueResult();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }

        return schedule;
    }
}
