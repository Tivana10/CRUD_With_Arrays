package org.example;

public class SeriesModel {
    public String seriesId;
    public String seriesName;
    public String seriesAge;
    public String seriesNumberOfEpisodes;

    public SeriesModel() {
    }
    public SeriesModel(String id, String name, String age, String episodes) {
        this.seriesId = id;
        this.seriesName = name;
        this.seriesAge = age;
        this.seriesNumberOfEpisodes = episodes;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getSeriesName() {

        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getSeriesAge() {
        return seriesAge;
    }

    public void setSeriesAge(String seriesAge) {
        this.seriesAge = seriesAge;
    }

    public String getNumberOfEpisodes() {
        return seriesNumberOfEpisodes;
    }

    public void setNumberOfEpisodes(String numberOfEpisodes) {
        this.seriesNumberOfEpisodes = numberOfEpisodes;
    }

    @Override
    public String toString() {
        return "SERIES MODEL{" +
                "SERIES ID:'" + seriesId + '\'' +
                ", SERIES NAME:'" + seriesName + '\'' +
                ", SERIES AGE:" + seriesAge +
                ", NUMBER OF EPISODES:" + seriesNumberOfEpisodes +
                '}';
    }
}


