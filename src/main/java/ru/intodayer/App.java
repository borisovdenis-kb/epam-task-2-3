package ru.intodayer;

import java.util.*;
import java.util.Scanner;
import java.util.function.Predicate;


public class App {
    public static void main(String args[]) {
        TestFilteredIterator test1 = new TestFilteredIterator();
        test1.runTests();
        TestMapReduce test2 = new TestMapReduce();
        test2.runTests();
    }
}