package oefening2;

import java.util.ArrayList;
import java.util.Collections;

public class VideoGame {
    private String name;
    private double price;
    private ArrayList<String> genres = new ArrayList<>();
    private double score;

    public VideoGame(String name, double price, double score, String[] genres) {
        this.name = name;
        this.price = price;
        this.score = score;
        for (int i = 0; i < genres.length; i++)
            this.genres.add(genres[i].toLowerCase());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        Collections.addAll(this.genres, genres);
    }
}
