package ArrayList;

import java.util.Arrays;
import Grade.CheckScore;

import java.util.Scanner;

public class Array {

    public static void main(String[] args) {
        Array ar = new Array();
//        System.out.println(ar.getClass());
//        System.out.println(ar.getClass().getName());
//        System.out.println(ar.getClass().getSimpleName());
        ar.singleArray();
//        ar.multiArray();
//        ar.multiArray2();

    }

    void singleArray() {
        CheckScore ck = new CheckScore();
        Scanner sc = new Scanner(System.in);
        int numberOfCources;
        String[] courseName = {"Java", "SQL", "HTML5", "Python", "Logic"};
        int j = 0;

        do {
            System.out.print("Number of courses: ");
            numberOfCources = sc.nextInt();
            if (numberOfCources < 1 || numberOfCources > 10) {
                System.err.println("Error! Minimum number of cources is 1  and Maximum is 10");
                numberOfCources = -1;
            }
        } while (numberOfCources < 1);

        String[] courses = new String[numberOfCources];
        int[] scores = new int[numberOfCources];
        sc.nextLine();

        while (j < numberOfCources) {
            boolean validCourseName = false;
            boolean repeated = false;
            System.out.print("Course name " + (j + 1) + ": ");
            String course = sc.nextLine();
                
            if (j>0){
                for (int i = 0; i < j; i++) {
                    if (courses[i].equalsIgnoreCase(course)) {
                        repeated = true;
                    }
                }
            }
            
            if (repeated == true) {
                System.err.println("You have entered " + course + " already");
                continue;
            }
            
            for (String name : courseName) {
                if (name.equalsIgnoreCase(course)) {
                    validCourseName = true;
                    break;
                }
            }
            if (validCourseName == true) {
                courses[j] = course;
            } else {
                System.err.println("You have entered an invalid course ");
                continue;
            }

            do {
                System.out.print("Score for " + course + ": ");
                int score = sc.nextInt();
                if (score > 100 || score < 0) {
                    String check = (score < 0) ? "Invalid score: Score(%) < 0"
                            : "Invalid score: Score(%) > 100";
                    System.err.println(check);
                } else {
                    scores[j] = score;
                    break;
                }

            } while (true);
            sc.nextLine();
            j++;
        }

        int totalScore = 0;
        for (int i = 0; i < numberOfCources; i++) {
            totalScore += scores[i];
            System.out.println(String.format("Score obtained in %s is %s ",
                    courses[i], scores[i]));
        }

        int avgScore = (int) (totalScore / courses.length);
        System.out.println("Average score is: " + avgScore);
        String grade = ck.checkScore2(avgScore);
        System.out.println("Overall Grade is: " + grade);
    }
    

    void multiArray() {
        System.out.println("Start");

        int obs[][] = new int[3][4];

        for (int i = 0; i < obs.length; i++) {
            for (int j = 0; j < obs[i].length; j++) {
                obs[i][j] = i + j + 2;
            }
        }

        System.out.println(Arrays.deepToString(obs));
        for (int i = 0; i < obs.length; i++) {
            for (int j = 0; j < obs[i].length; j++) {
                System.out.print(obs[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println("End");

    }

    void multiArray2() {
        int obs[][][] = new int[2][3][4];

        for (int i = 0; i < obs.length; i++) {
            for (int j = 0; j < obs[i].length; j++) {
                for (int k = 0; k < obs[i][j].length; k++) {
                    obs[i][j][k] = i + j + 2;
                }
            }
        }

        for (int i = 0; i < obs.length; i++) {
            for (int j = 0; j < obs[i].length; j++) {
                for (int k = 0; k < obs[i][j].length; k++) {
                    System.out.print(obs[i][j][k] + " ");
                }
                System.out.println("   ");

            }
            System.out.println(Arrays.deepToString(obs));
        }
    }
}
