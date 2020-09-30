/*
 * CS 2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Mota
 * Description: Prg 04 - QuizApp class
 * Author:
 */

import java.io.*;
import java.util.*;

public class QuizApp {

    private static final String STUDENTS_FILE_NAME = "src/students.csv";
    private static final String QUIZ_FILE_NAME = "src/quiz.txt";
    private static final double TOLLERANCE = 0.0001;
    public static Scanner sc = new Scanner(System.in);

    // instance variables
    private Hashtable<String, Student> students;
    private LinkedList<Question> quiz;
    private String title;

    public QuizApp() throws FileNotFoundException {
        loadStudents();
        loadQuiz();
    }

    // TODOs: finish the implementation of the method
    public void loadStudents() throws FileNotFoundException {
        students = new Hashtable<>();
        File f = new File("src/students.csv");
        Scanner in = new Scanner(f);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String data[] = line.split(",");
            String name = data[0].trim();
            String grade = (data[1] + data[2] + data[3] + data[4]);
            Student student = new Student(name);
            students.put(grade,student);
        }
        in.close();
        System.out.println(students);
    }

//note that if a student grade is empty it means that the student can still retake the quiz

    // TODO: finish the implementation of the method
    public void saveStudents() throws FileNotFoundException {
        File f = new File("src/students.csv");
        PrintStream p = new PrintStream(f);
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            String name = it.next().getName();
            p.print(name + ",");
            int retakes = it.next().getRetakes();
            p.print(retakes + ",");
            double finalGrade = it.next().finalGrade();
            p.print(finalGrade + ",");
        }
    }

    // TODO: finish the implementation of the method
    public void loadQuiz() throws FileNotFoundException {
        quiz = new LinkedList<>();
        File f = new File("src/quiz.txt");
        Scanner scanner = new Scanner(f);
        scanner.useDelimiter(",");
        while (scanner.hasNext()) {
            String title = scanner.next();
            Question question = new Question(title);
        }
            scanner.close();
       // System.out.println(quiz);
            }

    public void runQuiz() {
        System.out.println("This quiz is about: " + title);
        System.out.print("What's your name? ");
        String name = sc.nextLine();
        Student student = students.get(name);
        if (student == null) {
            student = new Student(name);
            students.put(name, student);
        }
        int correct = 0;
        if (student.canTakeQuiz()) {
            Iterator<Question> it = quiz.iterator();
            while (it.hasNext()) {
                Question question = it.next();
                System.out.println(question);
                System.out.print("Answer: ");
                int answer = sc.nextLine().toLowerCase().charAt(0) - 'a';
                if (answer == question.getCorrect()) {
                    correct++;
                    System.out.println("Correct!");
                }
                else
                    System.out.println("Incorrect!");
                System.out.println();
            }
            double grade = (double) correct / quiz.size() * 100;
            System.out.println("Your grade this time was: " + String.format("%.2f", grade));
            student.addResult(grade);
        }
        else
            System.out.println("Sorry but you cannot take this quiz anymore!");
    }

    public static void main(String[] args) throws FileNotFoundException {
        QuizApp quizApp = new QuizApp();
        quizApp.runQuiz();
        quizApp.saveStudents();
    }
}
