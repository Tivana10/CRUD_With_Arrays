package org.example;

import org.example.SeriesModel;

import java.util.Scanner;

public class Series {

    Scanner scanner = new Scanner(System.in);

    public void captureSeries() {
        //input
        System.out.print("Enter the series id: ");
        String id = scanner.nextLine();

        System.out.print("Enter the series name: ");
        String name = scanner.nextLine();

        String age;
        System.out.print("Enter the series age restriction: ");
        String ageInput = scanner.nextLine();
        //checks if age is valid
        while(!TestSeriesAgeRestriction(ageInput)){
            System.out.println("You have entered an incorrect age! Please re-enter:");
            ageInput = scanner.nextLine();
        }


        String episodes;
        while (true) {
            System.out.print("Enter the number of episodes for " + name + ": ");
            try {
                episodes = scanner.nextLine();
                break;
                // checks format of input
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input! Please enter a number:");
            }
        }

        Main.seriesList.add(new SeriesModel(id, name, ageInput, episodes));
        System.out.println("Series processed successfully!!!");
    }

    public String searchSeries(String ID) {
        boolean isFound = false;
        SeriesModel newSeries = new SeriesModel();
        for (SeriesModel seriesModel : Main.seriesList) {
            //check if id is valid and true
            if (seriesModel.seriesId.equals(ID)) {
                isFound = true;
                newSeries = seriesModel;
                break;
            }
        }
        if(!isFound){
            return "Series with series id " + ID + " was not found.";
        }
        else{
            return newSeries.toString();
        }

    }

    public String updateSeries(String id, String seriesName, String age, String episodes) {
//input updates
        for (SeriesModel seriesModel : Main.seriesList) {
            if (seriesModel.seriesId.equals(id)) {
                seriesModel.setSeriesName(seriesName);
                seriesModel.setSeriesAge(age);
                seriesModel.setNumberOfEpisodes(episodes);

            }
        }
        return "Series with Series ID " + id + " WAS updated!";
    }

    public String deleteSeries(String id) {
        boolean seriesFound = false;
        int count = -1;

        for (SeriesModel seriesModel: Main.seriesList){
            //inc
            count++;
            if (seriesModel.seriesId.equals(id)){
                seriesFound = true;
                break;

            }
        }
        if (seriesFound){
            //remove series
            Main.seriesList.remove(count);

            return "Series with Series ID " + id + " WAS deleted!";
        }else{
            return "Series with Series ID " + id + " WAS NOT found!";
        }

    }

    public void seriesReport() {
        if (Main.seriesList.isEmpty()) {
            System.out.println("No series available.");
            return;
        }
        int count = 1;
        for (SeriesModel seriesModel : Main.seriesList) {
            //display
            System.out.println("Series " + count++);
            System.out.println("Series ID: " + seriesModel.seriesId);
            System.out.println("Series name: " + seriesModel.seriesName);
            System.out.println("Series age restrictions: " + seriesModel.seriesAge);
            System.out.println("Number of episodes: " + seriesModel.seriesNumberOfEpisodes);
            System.out.println();
        }
    }

    public void exitSeriesApplication() {
        System.out.println("Exiting... Goodbye!");
        System.exit(0);
    }

    public boolean TestSeriesAgeRestriction(String age) {
        boolean isValid = false;

        try{
            int ageSeries = Integer.parseInt(age);
            //check age valid
            if(ageSeries >= 2 && ageSeries <= 18){
                isValid = true;
            }

        } catch (NumberFormatException ex) {
            return isValid;
        }
        return isValid;

    }
}
