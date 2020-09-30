/*
 * CS 2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Mota
 * Description: Prg 04 - Question class
 * Author:
 */

import java.util.Iterator;

public class Question {

    private String text;
    private LinkedList<String> options;
    private int correct;
    private static final int DEFAULT_CORRECT = 0;
    private static final int MAX_NUMBER_OPTIONS = 5;
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public Question(String text) {
        this.text = text;
        options = new LinkedList<>();
        correct = DEFAULT_CORRECT;
    }

    // TODO: finish the implementation of the method
    public void addOption(String option) {
     options.append(option);
    }

    // TODO: finish the implementation of the method
    public int numberOptions() {
        return  MAX_NUMBER_OPTIONS;
    }

    // TODO: finish the implementation of the method
    public int getCorrect() {
        return correct;
    }

    // TODO: finish the implementation of the method (need to validate input parameter)
    public void setCorrect(int correct) {
       this.correct = correct;


    }

    @Override
    public String toString() {
        String str = text + "\n";
        Iterator<String> it = options.iterator();
        int i = 0;
        while (it.hasNext()) {
            String option = it.next();
            str += ALPHABET.charAt(i++) + ". " + option + "\n";
        }
        str = str.substring(0, str.length() - 1);
        return str;
    }
}

