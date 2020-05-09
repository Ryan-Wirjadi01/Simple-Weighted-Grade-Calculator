//----------------------------------------------------------------------------------------------------------------------
//CSE 205: 11333 T TH @ 4:30
//Assignment #6
//Ryan Wirjadi, 1216345962
//Description: This class is one of the courses, and will calculate weighted grades and the final grade
//----------------------------------------------------------------------------------------------------------------------

import com.sun.source.tree.BreakTree;
import java.util.LinkedList;
import java.text.DecimalFormat;

public class MAT243<T extends Comparable <T> > implements Grades <T> {

    //Variable declaration

    //These variables make LinkedLists to add grades to specific categories
    //Also there are variables ___Total that are the weighted sum of the grades in their category
    private LinkedList<T> aList = new LinkedList<T>();
    private double assignmentTotal = 0.0;
    private LinkedList<T> qList = new LinkedList<T>();
    private double quizTotal = 0.0;
    private LinkedList<T> tList = new LinkedList<T>();
    private double testTotal = 0.0;
    private LinkedList<T> wList = new LinkedList<T>();
    private double webWorkTotal = 0.0;
    private LinkedList<T> fList = new LinkedList<T>();
    private double finalExamTotal = 0.0;

    //Dummy list to hold values for the merge sort
    private LinkedList<T> merged;

    //These variables create and initialize the Students class object
    private String name = "";
    private Students stu = new Students(name);

    //This Object creates a format to be two decimal places
    DecimalFormat fmt = new DecimalFormat("0.00");

    //These methods are adders that add grades to their specified category
    @Override
    public void addAssignment(T item) {
        aList.add(item);
    }

    @Override
    public void addQuiz(T item) {
        qList.add(item);
    }

    @Override
    public void addTest(T item) {
        tList.add(item);
    }

    public void addWebWork(T item) {
        wList.add(item);
    }

    public void addFinalExam(T item) {
        fList.add(item);
    }

    //This method calculates the sum of the grades but not weighted
    @Override
    public <T extends Number> double sum(LinkedList<T> list) {
        double sum = 0.0;
        for (T t : list) {
            sum += t.doubleValue();
        }
        return sum;
    }

    //These methods calculate the weighted grades of each category and store it in the global variables
    @Override
    public <T extends Number> String weightedAssignmentGrade(LinkedList<T> list, double weight, double points) {
        assignmentTotal =  sum(list) / (list.size() * points) * weight;
        return fmt.format(assignmentTotal / weight * 100);
    }

    @Override
    public <T extends Number> String weightedQuizGrade(LinkedList<T> list, double weight, double points) {
        quizTotal =  sum(list) / (list.size() * points) * weight;
        return fmt.format(quizTotal / weight * 100);
    }

    @Override
    public <T extends Number> String weightedTestGrade(LinkedList<T> list, double weight, double points) {
        testTotal =  sum(list) / (list.size() * points) * weight;
        return fmt.format(testTotal / weight * 100);
    }

    public <T extends Number> String weightedWebWorkGrade(LinkedList<T> list, double weight, double points) {
        webWorkTotal = sum(list) / (list.size() * points) * weight;
        return fmt.format(webWorkTotal / weight * 100);
    }

    public <T extends Number> String weightedFinalExamGrade(LinkedList<T> list, double weight, double points) {
        finalExamTotal = sum(list) / (list.size() * 100) * weight;
        return fmt.format(finalExamTotal / weight * 100);
    }

    //This method calculates the final weighted grade
    @Override
    public String finalGrade() {
        return fmt.format((assignmentTotal + quizTotal + testTotal + webWorkTotal + finalExamTotal) * 100);
    }

    //The next three methods sort the grades using recursion and merge sort
    public void mergesort(LinkedList<T> list) {
        merged = new LinkedList<T>();
        merged.addAll(list);
        split(list, 0, list.size() - 1);
    }
    public void split(LinkedList<T> list, int low, int high) {
        int mid = 0;
        if(low < high) {
            mid = low + (high - low) / 2;
            split(list, low, mid);
            split(list, mid + 1, high);
            merge(list, low, mid, high);
        }
    }
    public void merge(LinkedList<T> list, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            merged.set(i, list.get(i));
        }
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (merged.get(i).compareTo(merged.get(i)) <= 0) {
                list.set(k, merged.get(i));
                i++;
            } else {
                list.set(k, merged.get(j));
                j++;
            }
            k++;
        }
        while (i <= mid) {
            list.set(k, merged.get(i));
            k++;
            i++;
        }
    }

    //Getters
    @Override
    public T getLowestScore(LinkedList<T> list) {
        return list.getFirst();
    }

    @Override
    public T getHighestScore(LinkedList<T> list) {
        return list.getLast();
    }

    @Override
    public LinkedList<T> getAssignment() {
        return aList;
    }

    @Override
    public LinkedList<T> getQuiz() {
        return qList;
    }

    @Override
    public LinkedList<T> getTest() {
        return tList;
    }

    public LinkedList<T> getWebWork() {
        return wList;
    }

    public LinkedList<T> getFinalExam() {
        return fList;
    }

    @Override
    public String getName() {
        return name;
    }

    //Setter
    @Override
    public void setName(String name) {
        this.name = name;
    }
}
