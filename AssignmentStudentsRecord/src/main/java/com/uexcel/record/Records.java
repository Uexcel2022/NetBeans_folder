/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uexcel.record;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Uexcel
 */
public class Records {

    ArrayList<String> selectedCourses = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    Map<String, String> student = new HashMap<>();
    Map<String, String> courseAndScore = new HashMap<>();
    List<String> courseList = Arrays.asList("SQL", "HTML5", "Cyber Security", "Python", "Java", "Logic");


    public void runRecords() {

        registration();
        courseRegistration();
        String response = "";

        do {

            if (courseAndScore.size() > 5 || courseAndScore.size() < 3) {
                System.out.println("The number of courses registerd fell short of expectatation.");
                System.out.println("Course Registeration: minimun  number of cources = 2 and Maximum = 4");
                System.out.println("Adjust the number of courses accordingly.");

                editRegisteredCourses();

                continue;
            }

            System.out.print("Edit course registration? Y/N : ");
            response = sc.nextLine().toUpperCase();

            if (!response.equals("Y") && !response.equals("N")) {
                System.out.println("You have not made a valid selection");
            }

            if (response.equals("Y")) {
                editRegisteredCourses();
            }

        } while (!response.equals("N"));

        System.out.println(courseAndScore);
        System.out.println(student);

        addScore();
        System.out.println(courseAndScore);
        
        do {

            System.out.print("Edit score? Y/N : ");
            response = sc.nextLine().toUpperCase();

            if (!response.equals("Y") && !response.equals("N")) {
                System.out.println("You have not made a valid selection");
            }

            if (response.equals("Y")) {
                editScore();
            }
          
        } while (!response.equals("N"));
        
         System.out.println(courseAndScore);
         
        addGrade(courseAndScore);
        
        String studentDetails = String.format("First name: %s \nMiddle name: %s \nLast name: %s  \nmatricNo: %s \nYear of admission: %s", student.get("firstName"),
                student.get("middleName"), student.get("lastName"), student.get("matricNo"), student.get("Year of admission"));

        String matriculationNumuber;
        int count = 0;
        do {
            System.out.print("Enter Matriculation numuber to view result: ");
            matriculationNumuber = sc.nextLine();

            if (student.containsValue(matriculationNumuber)
                    && courseAndScore.containsValue(matriculationNumuber)) {

                System.out.println("\nStatement Of Result");
                System.out.println(studentDetails);

                System.out.println("Course  :  Score");

                for (String key : courseAndScore.keySet()) {

                    if (key.equals("grade") || key.equals("matricNo")) {
                        continue;
                    }
                    System.out.println(key + " :  " + courseAndScore.get(key));
                }
                System.out.println(courseAndScore.get("grade"));

            } else {
                System.out.println("No student found!!!!");
            }
            count++;
        } while (!matriculationNumuber.equals(student.get("matricNo")) && count != 7);
    }
        
        
    public void registration() {
        List<String> inputLable = Arrays.asList("Enter first name: ", "Enter Middle name: ", "Enter Last name: "); // Arrays.asList(...items)
        System.out.print(inputLable.get(0));
        String firstName = sc.nextLine();
        System.out.print(inputLable.get(1));
        String middleName = sc.nextLine();
        System.out.print(inputLable.get(2));
        String lastName = sc.nextLine();
        String matricNo = generateMatricNumber();
        student.put("firstName", firstName);
        student.put("middleName", middleName);
        student.put("lastName", lastName);
        student.put("matricNo", matricNo);
        student.put("Year of admission", LocalDate.now().getYear() + "");
        courseAndScore.put("matricNo", matricNo);
        System.out.println("You have registered successfully..");
        System.out.println("\n******Your Matriculation Number********");
        System.out.println(matricNo);
        System.out.println("Please save it...");
        System.out.println(student.get("Year of Admission"));

    }

    public String generateMatricNumber() {
        Random random = new Random();
        String mt = "";
        for (int i = 0; i < 4; i++) {
            mt += String.valueOf(random.nextInt(1, 9));
            mt += String.valueOf(random.nextInt(1, 9));
        }

        return LocalDate.now().getYear() + "001" + mt + "R";
    }

    public void courseRegistration() {

        System.out.println("List of courses: " + courseList);

        System.out.println("Register; minimun  number of cources = 2 and Maximum = 4");
        String courseName;
        do {
            System.out.print("Enter course name or 0 to quit: ");
            courseName = sc.nextLine();

            if (courseName.equals("0")) {
                return;
            }

            if (selectedCourses.contains(courseName)) {
                System.out.println(courseName + " has been selected already.");
                continue;
            }

            if (courseList.contains(courseName)) {
                courseAndScore.putIfAbsent(courseName, null);
                selectedCourses.add(courseName);
                System.out.println(courseName + " added");
            } else {
                System.out.println("Invalid course name");
            }

        } while (selectedCourses.size() != 4);
    }

    public void editRegisteredCourses() {

        String courseName;
        String response;
        System.out.println(courseList);
        do {

            System.out.print("Enter the course name or 0 for done: ");

            courseName = sc.nextLine();
            if (courseName.equals("0")) {
                return;
            }

            if (selectedCourses.contains(courseName)) {

                System.out.print("Remove " + courseName + "? N/Y : ");
                response = sc.nextLine().toUpperCase();

                if (!response.equals("Y") && !response.equals("N")) {
                    System.out.println("You have not made a valid selection");
                    continue;
                }

                if (response.equals("Y")) {
                    courseAndScore.remove(courseName);
                    selectedCourses.remove(courseName);
                    System.out.println("Deleted");
                }

            } else if (courseList.contains(courseName)) {

                System.out.print("Add " + courseName + "? N/Y : ");
                response = sc.nextLine().toUpperCase();

                if (!response.equals("Y") && !response.equals("N")) {
                    System.out.println("You have not made a valid selection");
                }

                if (response.equals("Y")) {
                    courseAndScore.putIfAbsent(courseName, null);
                    selectedCourses.add(courseName);
                    System.out.println(courseName + " added");
                }
            }
        } while (true);

    }

    public void addScore() {

        for (int i = 0; i < selectedCourses.size(); i++) {
            System.out.print("Enter score for " + selectedCourses.get(i) + " :");
            String score = sc.nextLine();
            boolean isValidScore = checkScore(score);
            if (isValidScore) {
                courseAndScore.put(selectedCourses.get(i), score);
                System.out.println("Score addedd");
            } else {
                System.out.println("You have entered an invalid score");
                i = i - 1;
            }
        }

    }

    public void editScore() {

        String courseName = "";
        String newScore;
        System.out.println(selectedCourses);
        do {

            System.out.print("Enter the course name or 0 for done: ");

            if (courseName.isEmpty()) {
                courseName = sc.nextLine();
            }

            if (courseName.equals("0")) {
                return;
            }

            if (selectedCourses.contains(courseName)) {

                System.out.print("Enter new score " + courseName + ": ");

                newScore = sc.nextLine();

                boolean isValidScore = checkScore(newScore);

                if (isValidScore) {
                    courseAndScore.replace(courseName, newScore);
                    System.out.println("Score updated");
                    courseName="";
                } else {
                    System.out.println("You have entered an invalid score");
                }
            } else {
                System.out.println("Could not find the course");
                courseName = "";
            }
        } while (true);

    }

    public boolean checkScore(String score) {
        String pattern = "([0-9][0-9]?)||(100)";
        boolean valid = Pattern.matches(pattern, score);
        return valid;
    }
    
    public void addGrade(Map<String, String> map) {
        double totalScore = 0;
        for (String key : map.keySet()) {
                if (key.equals("matricNo")) {
                    continue;
                }
                totalScore += Integer.parseInt(map.get(key));

        }
        
        double AvarageScore = totalScore / (double)(courseAndScore.size() - 1);
        String grd = grade(AvarageScore);
        courseAndScore.put("grade", grd);
        selectedCourses.add("grade");
    }

    private String grade(Double score1) {
        System.out.println(score1);
        String score2;
        
        if (score1 < 0 || score1 > 100) {

            return "The score is invalid!!!";
        }
        
        String[] modifiedScore = String.valueOf(score1).split("\\.");
        System.out.println(Arrays.toString(modifiedScore));
        System.out.println("modifiedScore" + modifiedScore[1]);
        if(modifiedScore[1].equals("0")){
            score2 = modifiedScore[0];
        }else if(modifiedScore[1].length() <=2){
            score2 = score1.toString();
        } else{   
            if(Integer.parseInt(String.valueOf(modifiedScore[1].charAt(3)))>=5){
                
                int approx = Integer.parseInt(String.valueOf(modifiedScore[1].charAt(1)))+1;
               
              score2 = modifiedScore[0]+"."+ modifiedScore[1].charAt(0)  + approx;
              System.out.println("approx s2" + score2);
            } else{
                score2 = modifiedScore[0]+"."+ modifiedScore[1].substring(0, 2);
                System.out.println("last" + score2);
            }
        }
          
        if (score1 >= 90) {
            return "Average score: " + score2 + " Greade: A";
        }

        if (score1 >= 80) {
            return "Average score: " + score2 + " Grade: B";
        }

        if (score1 >= 70) {
            return "Average score: " + score2 + " Grade: C";
        }

        if (score1 >= 60) {
            return "Average score: " + score2 + " Grade: D";
        }

        if (score1 >= 50) {
            return "Avarage score: " + score2 + " Grade: E";
        }

        if (score1 < 50) {
            return "Avarage score: " + score2 + " Grade: F";
        }
        return null;
    }
    
}
