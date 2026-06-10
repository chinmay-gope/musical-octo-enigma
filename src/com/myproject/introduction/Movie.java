package com.myproject.introduction;

public class Movie {
    int movieID;
    String movieName;

    static String industryName = "Bollywood";

    void getMovieInfo(int movieID, String movieName, String industryName) {
        System.out.printf(" Movie ID: %d, MovieName: %s, Industry: %s%n", movieID, movieName, industryName);
    }

    void main() {
        Movie m1 = new Movie();
        Movie m2 = new Movie();
        Movie m3 = new Movie();

        m1.movieID = 101;
        m1.movieName = "DDLJ";
        getMovieInfo(m1.movieID, m1.movieName, industryName);

        m2.movieID = 102;
        m2.movieName = "Sachin A Billion Dreams";
        getMovieInfo(m2.movieID, m2.movieName, industryName);

        m3.movieID = 103;
        m3.movieName = "Harry Potter";
        industryName = "Hollywood";
        getMovieInfo(m3.movieID, m3.movieName, industryName);

        System.out.println("Industry Name: " + industryName);
        System.out.println("Industry Name: " + Movie.industryName);

        industryName = "Mollywood";
        System.out.println(industryName);
    }
}
