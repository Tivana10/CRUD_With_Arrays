package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class SeriesTest {

    @Test
    public void TestAgeRestriction_AgeValid() {
        Series series = new Series();
        assertTrue(series.TestSeriesAgeRestriction("12"));
    }

    @Test
    public void TestAgeRestriction_AgeInvalid() {
        Series series = new Series();
        assertFalse(series.TestSeriesAgeRestriction("1"));
        assertFalse(series.TestSeriesAgeRestriction("twelve"));
    }

    @Test
    public void TestSearchSeries_SeriesNotFound() {
        Main.seriesList.clear();
        Series series = new Series();
        String expected = "Series with series id 999 was not found.";
        String actual = series.searchSeries("999");
        assertEquals(expected, actual);

    }

    @Test
    public void TestSearchSeries() {
        SeriesModel seriesModel = new SeriesModel("101", "Sinister", "18", "1");
        Main.seriesList.clear();
        Main.seriesList.add(seriesModel);
        Series series = new Series();

        String actual = series.searchSeries("101");
        String expected = "SERIES MODEL{" +
                "SERIES ID:'" + "101" + '\'' +
                ", SERIES NAME:'" + "Sinister" + '\'' +
                ", SERIES AGE:" + "18" +
                ", NUMBER OF EPISODES:" + "1" +
                '}';
        assertEquals(expected, actual);

    }

    @Test
    public void TestUpdateSeries() {
        SeriesModel seriesModel = new SeriesModel("101", "Sinister", "18", "1");
        Main.seriesList.clear();
        Main.seriesList.add(seriesModel);
        Series series = new Series();

        series.updateSeries("101", "Sinister Updated", "16", "2");
        SeriesModel updated = Main.seriesList.get(0);

        assertEquals("Sinister Updated", updated.getSeriesName());
        assertEquals("16", updated.getSeriesAge());
        assertEquals("2", updated.getNumberOfEpisodes());
    }

    @Test
    public void TestDeleteSeries() {
        SeriesModel seriesModel = new SeriesModel("101", "Sinister", "18", "1");
        Main.seriesList.clear();
        Main.seriesList.add(seriesModel);
        Series series = new Series();
        assertEquals("Series with Series ID 101 WAS deleted!", series.deleteSeries("101"));
        int expected = 0;

        int actual = Main.seriesList.size();

        assertEquals(expected, actual);

    }

    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        SeriesModel seriesModel = new SeriesModel("101", "Sinister", "18", "1");
        Main.seriesList.clear();
        Main.seriesList.add(seriesModel);
        Series series = new Series();

        String expected = "Series with Series ID 102 WAS NOT found!";
        String actual = series.deleteSeries("102");

        assertEquals(expected, actual);


    }
}
