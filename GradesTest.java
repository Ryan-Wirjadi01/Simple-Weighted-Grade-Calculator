//----------------------------------------------------------------------------------------------------------------------
//CSE 205: 11333 T TH @ 4:30
//Assignment #6
//Ryan Wirjadi, 1216345962
//Description: This is the main test class that will print menus and ask for user input to calculate the final grade
//----------------------------------------------------------------------------------------------------------------------

import java.util.Scanner;
public class GradesTest {
    public static void main(String[] args) {

        //Variable declaration
        double assignmentPoints = 0.0;
        double quizPoints = 0.0;
        double testPoints = 0.0;
        double webWorkPoints = 0.0;
        double finalPoints = 0.0;

        //Creating scanner object for user input
        Scanner sc = new Scanner(System.in);

        //Creating objects for the two different courses
        CSE205 class1 = new CSE205();
        MAT243 class2 = new MAT243();

            //Printing out the possible courses to choose from
            System.out.println("------------------------------------------");
            System.out.println("------------------ Menu ------------------");
            System.out.println("Select the course: 1 for CSE 205" + '\n' +
                               "                   2 for MAT 243");
            System.out.println("------------------------------------------");
                int input = sc.nextInt();

            //If user chose CSE205
            if(input == 1 ) {
                int menu;
                //Asking for student's name
                sc.nextLine();
                System.out.println("Enter Student's Full Name: ");
                    class1.setName(sc.nextLine());
                do {
                    //Printing out the menu to add grades and print report
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("Student: " + class1.getName());
                    System.out.println("-------------------------------- Menu --------------------------------");
                    System.out.println("1 to add an Assignment" + "\n2 to add a Quiz" + "\n3 to add a Test" + "\n4 to Print Report" + "\n0 to Quit");
                        menu = sc.nextInt();
                    switch(menu) {
                        //Adding assignments
                        case 1:
                            System.out.println("How many scores? ");
                                int m = sc.nextInt();
                            System.out.println("How many points is it out of? ");
                                assignmentPoints = sc.nextDouble();
                            for(int i = 0; i < m; i++) {
                                System.out.println("Enter the score for assignment " + (i + 1) + ": ");
                                    class1.addAssignment(sc.nextDouble());
                            }
                            break;
                        //Adding quizzes
                        case 2:
                            System.out.println("How many scores? ");
                                int n = sc.nextInt();
                            System.out.println("How many points is it out of? ");
                                quizPoints = sc.nextDouble();
                            for(int i = 0; i < n; i++) {
                                System.out.println("Enter the score for quiz " + (i + 1) + ": ");
                                    class1.addQuiz(sc.nextDouble());
                            }
                            break;
                        //Adding tests
                        case 3:
                            System.out.println("How many scores? ");
                                int o = sc.nextInt();
                            System.out.println("How many points is it out of? ");
                                testPoints = sc.nextDouble();
                            for(int i = 0; i < o; i++) {
                                System.out.println("Enter the score for test " + (i + 1) + ": ");
                                    class1.addTest(sc.nextDouble());
                            }
                            break;
                        //Printing out the grade report
                        case 4:
                            class1.quickSort(class1.getAssignment());
                            class1.quickSort(class1.getQuiz());
                            class1.quickSort(class1.getTest());
                            System.out.println("---------------------------------------------------------------------");
                            System.out.println("Name: " + class1.getName());
                            System.out.println("---------------------------------------------------------------------");
                            System.out.println("Weighted assignment grade: \t\t" + class1.weightedAssignmentGrade(class1.getAssignment(), .5, assignmentPoints));
                            System.out.println("\tLowest assignment grade: \t" + class1.getLowestScore(class1.getAssignment()) + "\n\tHighest assignment grade: \t" + class1.getHighestScore(class1.getAssignment()));
                            System.out.println("Weighted quiz grade: \t\t\t" + class1.weightedQuizGrade(class1.getQuiz(), .1, quizPoints));
                            System.out.println("\tLowest quiz grade: \t\t\t" + class1.getLowestScore(class1.getQuiz()) + "\n\tHighest quiz grade: \t\t" + class1.getHighestScore(class1.getQuiz()));
                            System.out.println("Weighted test grade: \t\t\t" + class1.weightedTestGrade(class1.getTest(), .4, testPoints));
                            System.out.println("\tLowest test grade: \t\t\t" + class1.getLowestScore(class1.getTest()) + "\n\tHighest test grade: \t\t" + class1.getHighestScore(class1.getTest()));
                            System.out.println("Final grade: \t\t\t\t\t" + class1.finalGrade());
                            System.out.println("---------------------------------------------------------------------");
                            System.out.println("");
                            break;

                        default:
                    }
                } while(menu != 0);
            }
            //If user choose MAT243
            else if(input == 2) {
                int menu2;
                //Asking for student's name
                sc.nextLine();
                System.out.println("Enter Student's Full Name: ");
                    class2.setName(sc.nextLine());
                do {
                    //Printing out the menu to add grades and print report
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("Student: " + class2.getName());
                    System.out.println("-------------------------------- Menu --------------------------------");
                    System.out.println("1 to add an Homework" + "\n2 to add a Quiz" + "\n3 to add a Test" + "\n4 to add a WebWork" + "\n5 to add a Final Exam" + "\n6 to Print Report" + "\n0 to Quit");
                        menu2 = sc.nextInt();
                    switch(menu2) {
                        //Adding homeworks
                        case 1:
                            System.out.println("How many scores? ");
                                int m = sc.nextInt();
                            System.out.println("How many points is it out of? ");
                                assignmentPoints = sc.nextDouble();
                            for(int i = 0; i < m; i++) {
                                System.out.println("Enter the score for homework " + (i + 1) + ": ");
                                    class2.addAssignment(sc.nextDouble());
                            }
                            break;
                        //Adding quizzes
                        case 2:
                            System.out.println("How many scores? ");
                                int n = sc.nextInt();
                            System.out.println("How many points is it out of? ");
                                quizPoints = sc.nextDouble();
                            for(int i = 0; i < n; i++) {
                                System.out.println("Enter the score for quiz " + (i + 1) + ": ");
                                    class2.addQuiz(sc.nextDouble());
                            }
                            break;
                        //Adding tests
                        case 3:
                            System.out.println("How many scores? ");
                                int o = sc.nextInt();
                            System.out.println("How many points is it out of? ");
                                testPoints = sc.nextDouble();
                            for(int i = 0; i < o; i++) {
                                System.out.println("Enter the score for test " + (i + 1) + ": ");
                                    class2.addTest(sc.nextDouble());
                            }
                            break;
                        //Adding WebWorks
                        case 4:
                            System.out.println("How many scores? ");
                                int p = sc.nextInt();
                            System.out.println("How many points is it out of? ");
                                webWorkPoints = sc.nextDouble();
                            for(int i = 0; i < p; i++) {
                                System.out.println("Enter the score for WebWork " + (i + 1) + ": ");
                                    class2.addWebWork(sc.nextDouble());
                            }
                            break;
                        //Adding final exam
                        case 5:
                            System.out.println("How many points is it out of? ");
                                finalPoints = sc.nextDouble();
                            System.out.println("Enter the score for the Final: ");
                                class2.addFinalExam(sc.nextDouble());
                            break;
                        //Printing out grade report
                        case 6:
                            class2.mergesort(class2.getAssignment());
                            class2.mergesort(class2.getQuiz());
                            class2.mergesort(class2.getTest());
                            class2.mergesort(class2.getWebWork());
                            System.out.println("---------------------------------------------------------------------");
                            System.out.println("Name: " + class2.getName());
                            System.out.println("---------------------------------------------------------------------");
                            System.out.println("Weighted homework grade: \t\t" + class2.weightedAssignmentGrade(class2.getAssignment(), .1, assignmentPoints));
                            System.out.println("\tLowest homework grade: \t\t" + class2.getLowestScore(class2.getAssignment()) + "\n\tHighest homework grade: \t" + class2.getHighestScore(class2.getAssignment()));
                            System.out.println("Weighted quiz grade: \t\t\t" + class2.weightedQuizGrade(class2.getQuiz(), .1, quizPoints));
                            System.out.println("\tLowest quiz grade: \t\t\t" + class2.getLowestScore(class2.getQuiz()) + "\n\tHighest quiz grade: \t\t" + class2.getHighestScore(class2.getQuiz()));
                            System.out.println("Weighted test grade: \t\t\t" + class2.weightedTestGrade(class2.getTest(), .5, testPoints));
                            System.out.println("\tLowest test grade: \t\t\t" + class2.getLowestScore(class2.getTest()) + "\n\tHighest test grade: \t\t" + class2.getHighestScore(class2.getTest()));
                            System.out.println("Weighted webWork grade: \t\t" + class2.weightedWebWorkGrade(class2.getWebWork(), .05, webWorkPoints));
                            System.out.println("\tLowest webWork grade: \t\t" + class2.getLowestScore(class2.getWebWork()) + "\n\tHighest webWorkGrade: \t\t" + class2.getHighestScore(class2.getWebWork()));
                            System.out.println("Weighted Final exam grade: \t\t" + class2.weightedFinalExamGrade(class2.getFinalExam(), .25, finalPoints));
                            System.out.println("Final grade: \t\t\t\t\t" + class2.finalGrade());
                            System.out.println("---------------------------------------------------------------------");
                            System.out.println("");
                            break;

                        default:
                    }
                } while(menu2 != 0);

            }
        }
    }
