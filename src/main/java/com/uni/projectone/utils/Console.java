/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uni.projectone.utils;

import com.uni.projectone.domain.Schedule;
import com.uni.projectone.domain.ScheduleDaoImpl;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author hovercat
 */
public class Console {

    ScheduleDaoImpl sdi = new ScheduleDaoImpl();
    Scanner keyboard = new Scanner(System.in);
    String commandNum;
    boolean result = false;

    Integer runId;
    Integer seatNum;
    Integer ID;

    String depTime;
    String depDate;

    public void commandsList() {

        while (!result) {
            System.out.print("Availabe commands:\n"
                    + "1 - Add new schedule\n"
                    + "2 - Update existing schedule\n"
                    + "3 - Delete existing schedule\n"
                    + "4 - Show schedule with particular ID\n"
                    + "5 - Show all existing schedules\n"
                    + "6 - Exit program\n\n"
                    + "Enter command number to proceed: ");

            commandNum = keyboard.next();
            result = ValidationCheck.numValidator(commandNum);
            if (!result) {
                System.out.println("Sorry, that's not valid. Please try again.");
            }
        }

        result = false;

        switch (Integer.valueOf(commandNum)) {
            case 1:

                System.out.print("=Create a new run=\n");

                while (!result || sdi.getById(runId) != null) {
                    System.out.print("Enter run number: ");

                    try {
                        runId = keyboard.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("invalid input. Please try again.");
                        keyboard.next(); // clear scanner wrong input
                        continue; // continues to loop if exception is found
                    }

                    result = ValidationCheck.numValidator(String.valueOf(runId));

                    if (sdi.getById(runId) != null) {
                        System.out.print("duplicate run ID. Try another number");
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////
                result = false;
                String h;
                String m;

                while (!result) {

                    System.out.print("\nEnter departure time (00:00 - 23:59):\nEnter hour: "); //TODO
                    
                    h = keyboard.next();

                    System.out.print("Enter minutes: ");
                    m = keyboard.next();

                    depTime = h + ":" + m;

                    result = ValidationCheck.timeValidator(depTime);
                    if (!result) {
                        System.out.println("Invalid input. Please try again.");
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////
                result = false;

                while (!result) {
                    System.out.print("Enter departure day: ");  //TODO

                    depDate = keyboard.next();

                    result = ValidationCheck.dayValidator(depDate);
                    if (!result) {
                        System.out.println("Invalid input. Please try again.");
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////
                result = false;

                while (!result) {
                    System.out.print("Enter seats number: ");
                    try {
                        seatNum = keyboard.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Sorry, that's not valid. Please try again.");
                        keyboard.next(); 
                        continue; 
                    }
                    result = ValidationCheck.numValidator(String.valueOf(seatNum));
                }

                System.out.print("Enter route: "); //TODO
                String route = keyboard.next();

                sdi.addSchedule(runId, depTime, depDate, seatNum, route);

                System.out.println("Run successfully added");
                break;
            case 2:
                System.out.print("Edit existing run\n");
                sdi.updateSchedule(null); //TODO
                break;
            case 3:
                System.out.print("Delete existing run by ID\n");
                sdi.deleteSchedule(null); //TODO
                break;
            case 4:
                result = false;

                while (!result) {
                    System.out.print("Enter neccessary ID: ");
                    try {
                        ID = keyboard.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Sorry, that's not valid. Please try again.");
                        keyboard.next(); 
                        continue; 
                    }
                    result = ValidationCheck.numValidator(String.valueOf(ID));

                    if (!result) {
                        System.out.println("Sorry, that's not valid. Please try again.");
                    } else if (sdi.getById(ID) == null) {
                        System.out.println("No such ID");
                    } else {
                        System.out.println(sdi.getById(ID));
                    }
                }

                //TODO
                break;
            case 5:
                System.out.print("List of all runs\n");
                sdi.getAllSchedules();
                break;
            case 6:
                break;
            default:
                System.out.println("No such command");
                break;
        }
    }
}