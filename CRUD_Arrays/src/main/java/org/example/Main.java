package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<SeriesModel> seriesList = new ArrayList<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Series seriesManager = new Series();

        while (true) {
            System.out.println("Latest Series - 2025 ");
            System.out.println("Enter 1 to launch menu or any other key to exit");
            String launchChoice = scanner.nextLine();
            if (launchChoice.equals("1")) {
//menu
                System.out.println("(1) Capture a new series");
                System.out.println("(2) Search for a series");
                System.out.println("(3) Update series age restriction");
                System.out.println("(4) Delete a series");
                System.out.println("(5) Print series report -2025 ");
                System.out.println("(6) Exit Application");
                System.out.print("Enter choice: ");

                String choice = scanner.nextLine();
                SeriesModel seriesModel = new SeriesModel();

//inputs
                switch (choice) {
                    case "1":
                        seriesManager.captureSeries();
                        break;
                    case "2":
                        System.out.print("Enter the series id to search: ");
                        String id = scanner.nextLine();
                        System.out.println(seriesManager.searchSeries(id));
                        break;
                    case "3":
                        System.out.println("Enter the series ID: ");
                        String seriesID = scanner.nextLine();
                        System.out.println("Enter the series name: ");
                        String seriesName = scanner.nextLine();

                        System.out.print("Enter the series age restriction: ");
                        Series series = new Series();
                        String ageInput = scanner.nextLine();
                        while(!series.TestSeriesAgeRestriction(ageInput)){
                            System.out.println("You have entered an incorrect age! Please re-enter:");
                            ageInput = scanner.nextLine();
                        }
                        System.out.println("Enter the number of episodes: ");
                        String episodes = scanner.nextLine();
                        seriesManager.updateSeries(seriesID, seriesName, ageInput, episodes);
                        break;
                    case "4":
                        System.out.println("Please enter the series id to delete");
                        seriesID = scanner.nextLine();
                        System.out.println("Are you sure you want to delete the series id " + seriesID + "? Type Yes (y) to continue.");
                        char response = scanner.nextLine().charAt(0);
//uppercase or lowercase
                        if (response == 'y' || response == 'Y'){
                            System.out.println(seriesManager.deleteSeries(seriesID));
                        }

                        break;
                    case "5":
                        seriesManager.seriesReport();
                        break;
                    case "6":
                        seriesManager.exitSeriesApplication();
                        break;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                }
                System.out.println();
            } else {
                break;
            }
        }
    }
}
