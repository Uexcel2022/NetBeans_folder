package com.uexcel.assignmentstudentrecords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/*
MAP INTERFACE
It has key-vlaue pair attribute, the key and value can be of different data type. That is benefitial in storing course and score.
Course name being the key and the score the value.

Key-value pair allow to register courses with a provisional null score value and update when the scores are ready.

It does not record duplicate key and  value can be obtained simply by the key; whereby dupulate key is entered,
the current key-value pair will override the previous one.

It is easy to manipulate data stored in map. CRUD operation can be performed on the data. Data can be created, 
retrieved, updated and Delete that's remove from the map.

ARRAYLIST INTERFACE
Just as map data can easily be manipulaated using arraylist.
ArrayList Interface has index attribute which was very helpful to me when computing the scores.
Using for loop value in the array can be obtained by index  which could be the key of a map instead of looping 
through the map as map does not have index attribute. 

Using for loop you can go back and forth when inserting value in the map when the need arise,
like when invalid score is entered or none digit value which will throw exception.

 */
public class AssignmentStudentRecords {

    ArrayList<String> SelectedCources = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    Map<String, String> student = new HashMap<>();
    Map<String, String> courseAndScore = new HashMap<>();

    public static void main(String[] args) {
        new AssignmentStudentRecords().registration();
    }

    public void registration() {
        String[] inputLable = {"Enter first name: ", "Enter Midde name: ", "Enter Last name: "}; // Arrays.asList(...items)
        System.out.print(inputLable[0]);
        String firstName = sc.nextLine();
        System.out.print(inputLable[1]);
        String middleName = sc.nextLine();
        System.out.print(inputLable[2]);
        String lastName = sc.nextLine();
        String matricNo = generateMatricNumber();
        student.put("firstName", firstName);
        student.put("middleName", middleName);
        student.put("lastName", lastName);
        student.put("matricNo", matricNo);
        courseAndScore.put("matricNo", matricNo);
        System.out.println("\n******Your Matriculation Number********");
        System.out.println(matricNo);
        System.out.println("Please save it...");
        
        System.out.println("Please select the courses to register");
        System.out.println("minimun  number of cources = 2 and Maximum = 4");
        courseRegistration();

        System.out.println(student);
        System.out.println(courseAndScore);
      
        String CourseRegConfirmation;
        do {
            
            if(SelectedCources.size() <2 || SelectedCources.size() > 4){
                System.out.println(courseAndScore);
                System.out.println("minimun  number of cources = 2 and Maximum = 4");
                 EditCourseRegistration();
            }
            
            System.out.print("Select 1 to change course or 0 for ok: ");
            CourseRegConfirmation = sc.nextLine();
            if (CourseRegConfirmation.equals("1")) {
                EditCourseRegistration();
            }

        } while (!CourseRegConfirmation.equals("0"));

        score();

        System.out.println(student);
        System.out.println(courseAndScore);

        String scoreConfirmation;
        do {
            System.out.print("Select 1 to change score or 0 for ok: ");
            scoreConfirmation = sc.nextLine();
            if (scoreConfirmation.equals("1")) {
                editscore();
                System.out.println(courseAndScore);
            }

        } while (!scoreConfirmation.equals("0"));

        System.out.println(student);
        System.out.println(courseAndScore + "\n");

        AddGrade(courseAndScore);
        String studentDetails = String.format("First name: %s \nMiddle name: %s \nLast name: %s  \nmatricNo: %s", student.get("firstName"),
                student.get("middleName"), student.get("lastName"), student.get("matricNo"));

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

    public void courseRegistration() {
        String[] courseList = {"SQL", "HTML5", "Cyber Security", "Python", "Java", "Logic"};
        System.out.println("Enter 1 to select a course and or any key to skip: ");
        for (String n : courseList) {
            System.out.print(n + ": ");
            String choice = sc.nextLine();
            if (choice.equals("1")) {
                courseAndScore.put(n, "0");
                SelectedCources.add(n);
            }
            if(SelectedCources.size()==4){
                return;
            }
        }
    }

    public void EditCourseRegistration() {
        String[] courseList = {"SQL", "HTML5", "Cyber Security", "Python ", "Java", "Logic"};
        System.out.println("Enter 0 to remove course, 1 to add, 2 done or any key to skip: ");

        for (String n : courseList) {

            System.out.print(n + ": ");

            String choice = sc.nextLine();
            if (choice.equals("2")) {
                return;
            }

            if (choice.equals("0")) {
                courseAndScore.remove(n);
                SelectedCources.remove(n);
            }

            if (choice.equals("1")) {
                courseAndScore.putIfAbsent(n, "0");
                if (!SelectedCources.contains(n)) {
                    SelectedCources.add(n);
                }
                
            }
        }
    }

    public void score() {

        for (int i = 0; i < SelectedCources.size(); i++) {
            System.out.print("Enter score for " + SelectedCources.get(i) + ": ");

            String score = sc.nextLine();

            try {

                if (Integer.parseInt(score) < 0 || Integer.parseInt(score) > 100) {
                    System.out.println("Invalid score!!!");
                    i = i - 1;
                    continue;
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter only digit!!!");
                i = i - 1;
                continue;
            }

            courseAndScore.replace(SelectedCources.get(i), "0", score);
        }

    }

    public void editscore() {
        for (int i = 0; i < SelectedCources.size(); i++) {
            System.out.print(SelectedCources.get(i) + "- old score: " + courseAndScore.get(SelectedCources.get(i))
                    + " enter new score:" + " -1 skip -2 done: ");

            // use regex to check it contains numeric only
            String score = sc.nextLine();

            if (score.equals("-2")) {
                return;
            }

            if (score.equals("-1")) {
                continue;
            }
            // check numeric is redundant
            try {
                if (Integer.parseInt(score) < 0 || Integer.parseInt(score) > 100) {
                    System.out.println("Invalid score!!!");
                    i = i - 1;
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid score!!!");
                i = i - 1;
                continue;
            }

            courseAndScore.replace(SelectedCources.get(i),
                    courseAndScore.get(SelectedCources.get(i)), score);
        }

    }

    public void AddGrade(Map<String, String> map) {
        int totalScore = 0;
        for (String key : map.keySet()) {
            try {
                if (key.equals("matricNo")) {
                    continue;
                }
                totalScore += Integer.parseInt(map.get(key));
            } catch (NumberFormatException e) {
                System.out.println("Error occured, Can not sum non digit value!!!");
            }

        }
        int AvarageScore = totalScore / (courseAndScore.size() - 1);
        String grd = grade(AvarageScore);
        courseAndScore.put("grade", grd);
        SelectedCources.add("grade");
    }

    private String grade(int score) {

        if (score < 0 || score > 100) {

            return "The score is invalid!!!";
        }

        if (score >= 90) {
            return "Average score: " + score + " Greade: A";
        }

        if (score >= 80) {
            return "Average score: " + score + " Grade: B";
        }

        if (score >= 70) {
            return "Average score: " + score + " Grade: C";
        }

        if (score >= 60) {
            return "Average score: " + score + " Grade: D";
        }

        if (score >= 50) {
            return "Avarage score: " + score + " Grade: E";
        }

        if (score < 50) {
            return "Avarage score: " + score + " Grade: F";
        }
        return null;
    }

    public String generateMatricNumber() {
        Random random = new Random();
        String mt="";
        for (int i = 0; i < 4; i++) {
            mt += String.valueOf(random.nextInt(1, 9));
            mt += String.valueOf(random.nextInt(1, 9));
        }
        
        return  "2301"+mt + "R";
    }
}
