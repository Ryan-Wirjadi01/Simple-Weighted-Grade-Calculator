//----------------------------------------------------------------------------------------------------------------------
//CSE 205: 11333 T TH @ 4:30
//Assignment #6
//Ryan Wirjadi, 1216345962
//Description: This class is one of the courses, and will calculate weighted grades and the final grade
//----------------------------------------------------------------------------------------------------------------------

import java.util.LinkedList;
import java.text.DecimalFormat;

public class CSE205 <T extends Comparable <T> > implements Grades <T> {

    //Variable declaration

    //These variables make LinkedLists to add grades to specific categories
    //Also there are variables ___Total that are the weighted sum of the grades in their category
    private LinkedList<T> aList = new LinkedList<T>();
    private double assignmentTotal = 0.0;
    private LinkedList<T> qList = new LinkedList<T>();
    private double quizTotal = 0.0;
    private LinkedList<T> tList = new LinkedList<T>();
    private double testTotal = 0.0;

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

    //This method calculates the sum of the grades but not weighted
    @Override
    public <T extends Number> double sum(LinkedList<T> list) {
        double sum = 0.0;
        for (T t : list) {
            sum += t.doubleValue();
        }
        return sum;
    }

    //The next three methods calculate the weighted grades of each category and store it in the global variables
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
        return fmt.format(testTotal / weight* 100);
    }

    //This method calculates the final weighted grade
    @Override
    public String finalGrade() {
        return fmt.format((assignmentTotal + quizTotal + testTotal) * 100);
    }

    //The next three methods sort the grades using recursion and quick sort
    public <T extends Number> void quickSort(LinkedList<T> list) {
        if(list.size() == 0) {
            return;
        }
        divide(list,0, list.size() - 1);
    }

    public <T extends Number> void divide(LinkedList<T> list, int low, int high) {
        int i = low;
        int j = high;
        double pivot = (double) list.get(low + (high - low) / 2);
        while (i <= j) {
            while (list.get(i).doubleValue() < pivot) {
                i++;
            }
            while (list.get(j).doubleValue() > pivot) {
                j--;
            }
            if (i <= j) {
                exchange(list, i, j);
                i++;
                j--;
            }
        }
        if (low < j)
            divide(list, low, j);
        if (i < high)
            divide(list, i, high);
    }

    public <T extends Number> void exchange(LinkedList<T> list, int small, int big) {
        T temp = list.get(small);
        list.set(small, list.get(big));
        list.set(big, temp);
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
