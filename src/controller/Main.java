package controller;

import java.util.Scanner;
import view.Menu;
import model.Algorithm;

public class Main {

    Scanner sc = new Scanner(System.in);
    int[] arr;
    Algorithm algorithm = new Algorithm();

    public void getInput_createArray() {
        System.out.println("Enter number of array: ");
        int number = sc.nextInt();
        arr = new int[number];
        algorithm.generateRandomArray(arr);
        System.out.println("Unsorted array: ");
        algorithm.printArray(arr);
    }

    public void displayMainMenu() {
        Menu<String> mainMenu = new Menu<>("Choose sorting & searching algorithm", new String[]{
            "Bubble Sort",
            "Quick Sort",
            "Binary Search",
            "Linear Search",
            "Get new array",
            "Exit"
        }) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1 ->
                        algorithm.bubbleSort(arr);
                    case 2 ->
                        algorithm.quickSort(arr, 0, arr.length - 1);
                    case 3 ->
                        binarySearchExe();
                    case 4 ->
                        linearSearchExe();
                    case 5 -> {
                        getInput_createArray();
                    }
                    case 6 ->
                        System.exit(0);
                    default ->
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        };
        mainMenu.run();
    }

    public void binarySearchExe() {
        System.out.println("Enter search element: ");
        int element = sc.nextInt();
        int result = algorithm.binarySearch(arr, 0, arr.length, element);
        System.out.println("Index: " + result);
    }
    
    public void linearSearchExe(){
        System.out.println("Enter search element: ");
        int element = sc.nextInt();
        int result = algorithm.linearSearch(arr, element);
        System.out.println("Index: " + result);
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.getInput_createArray();
        main.displayMainMenu();
    }

}
