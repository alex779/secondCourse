
import com.uni.projectone.utils.ValidationCheck;
import com.uni.projectone.utils.ValidationCheck.Day;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hovercat
 */
public class main {

    public static void main(String[] args) throws ParseException {

//        Console c = new Console();
//        c.commandsList();
        List<String> list = new ArrayList<>();
//        List<String> uniqueList = SetUniqueList.decorate(new ArrayList<String>());

        final Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();

//        while (!line.isEmpty()) {
//            try {
//                if (line.equals(Day.valueOf(line).getDay()));
//                l.add(line);
//            } catch (IllegalArgumentException e) {
//                System.out.println("Wrong input. Try again");
//            }
//        }
        for (String line = scanner.nextLine(); !line.isEmpty(); line = scanner.nextLine()) {

            Boolean result = false;
            final String s = line;
            String x = "1";

//            try {
            if (line.equals(x)) {

                Optional<String> queryResult = list.stream()
                        .filter(value -> value != null)
                        .filter(value -> value.equalsIgnoreCase(s))
                        .findFirst();

                if (queryResult.isPresent()) {
                    System.out.println("Found " + line + " in list\nItem not added");

                } else {
                    System.out.println("Could not find " + line + " in list");
                    list.add(line);
                    System.out.println("Item added");
                    
                }
            }
//            } catch (IllegalArgumentException e) {
//                System.out.println("Wrong input. Try again");
//            }
        }

//        final String query = "MON";
//        Optional<String> queryResult = list.stream()
//				.filter(value -> value != null)
//				.filter(value -> value.equalsIgnoreCase(query))
//				.findFirst();
//		if (queryResult.isPresent()) {
//			System.out.println("Found " + query + " in list");
//		} else {
//			System.out.println("Could not find " + query + " in list");
//		}
//
        list.forEach((t) -> {
            System.out.println("LIST " + t);
        });
    }
}
