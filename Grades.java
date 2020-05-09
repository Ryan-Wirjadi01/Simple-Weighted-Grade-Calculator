//----------------------------------------------------------------------------------------------------------------------
//CSE 205: 11333 T TH @ 4:30
//Assignment #6
//Ryan Wirjadi, 1216345962
//Description: This interface is the outline for the rest of concrete classes
//----------------------------------------------------------------------------------------------------------------------

import java.util.LinkedList;

public interface Grades <T extends Comparable <T> >{

    //These methods will grades to a Linked List for their specified category
    public void addAssignment(T item);
    public void addQuiz(T item);
    public void addTest(T item);

    //This method will calculate the sum of all the non weighted scores given a category
    public <T extends Number> double sum(LinkedList<T> list);

    //These methods will calculate the weighted grade for each category
    public <T extends Number> String weightedAssignmentGrade(LinkedList<T> list, double weight, double points);
    public <T extends Number> String weightedQuizGrade(LinkedList<T> list, double weight, double points);
    public <T extends Number> String weightedTestGrade(LinkedList<T> list, double weight, double points);

    //This method calculates the final weighted grade
    public String finalGrade();

    //Getters
    public T getLowestScore(LinkedList<T> list);
    public T getHighestScore(LinkedList<T> list);
    public LinkedList<T> getAssignment();
    public LinkedList<T> getQuiz();
    public LinkedList<T> getTest();
    public String getName();

    //Setter
    public void setName(String name);
}
