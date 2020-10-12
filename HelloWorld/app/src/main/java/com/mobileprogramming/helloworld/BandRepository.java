package com.mobileprogramming.helloworld;

import com.mobileprogramming.helloworld.Band;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class BandRepository {
    private HashMap<String, Band> bands = new HashMap<>();

    private static BandRepository instance;

    private BandRepository() {
        Band[] bandArr = new Band[]{
                new Band(
                        "Metallica",
                        "1981",
                        "Los Angeles,USA",
                        "Metal"
                ),
                new Band(
                        "Guns n Roses",
                        "1985",
                        "Los Angeles,USA",
                        "Rock"
                ),
                new Band(
                        "The Beatles",
                        "1957",
                        "Liverpool,UK",
                        "Pop/rock"
                ),
                new Band(
                        "Queen",
                        "1970",
                        "London,UK",
                        "Rock"
                ),
                new Band(
                        "The Rolling Stones",
                        "1962",
                        "London,UK",
                        "Rock"
                )
        };
        for (Band band : bandArr) {
            this.bands.put(band.getName(), band);
        }
    }

    public static BandRepository getInstance() {
        if (instance == null) {
            instance = new BandRepository();
        }
        return instance;
    }

    public List<String> getBands() {
        return this.bands.values()
                .stream()
                .map(Band::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    public Band getBandDetails(String name) {
        return this.bands.get(name);
    }
}
