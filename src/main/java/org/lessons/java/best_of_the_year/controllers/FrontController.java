package org.lessons.java.best_of_the_year.controllers;

import java.util.ArrayList;

import org.lessons.java.best_of_the_year.classes.Movie;
import org.lessons.java.best_of_the_year.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;


@Controller
@RequestMapping("/")
public class FrontController {

    @GetMapping
    public String home(Model model) {

        model.addAttribute("myName", "Alessandro");
        return "home";
    }
    
    @GetMapping("/movies")
    public String movies(Model model) {

        model.addAttribute("category", "movies");
        model.addAttribute("content", this.getBestMovies());
        return "list";
    }

    @GetMapping("/movies/{id}")
    public String moviesDetail(Model model, @PathVariable("id") int id) {

        model.addAttribute("category", "Movies");


        ArrayList<Movie> moviesList = new ArrayList<>(this.getBestMovies());
        Movie foundMovie = null;

        for(Movie movie : moviesList){
            if (movie.getId() == id) {
                foundMovie = movie;
                break;
            } 
        }
        
        model.addAttribute("content", foundMovie);
        return "detail";
    }

    @GetMapping("/songs")
    public String songs(Model model) {

        model.addAttribute("category", "songs");
        model.addAttribute("content", this.getBestSongs());
        return "list";
    }

    @GetMapping("/songs/{id}")
    public String songsDetail(Model model, @PathVariable("id") int id) {

        model.addAttribute("category", "Songs");


        ArrayList<Song> songsList = new ArrayList<>(this.getBestSongs());
        Song foundSong = null;

        for(Song song : songsList){
            if (song.getId() == id) {
                foundSong = song;
                break;
            } 
        }
        
        model.addAttribute("content", foundSong);
        return "detail";
    }

    // * Utility Methods
    
    private ArrayList<Movie> getBestMovies(){

        ArrayList<Movie> moviesList = new ArrayList<>();

        Movie godzilla = new Movie(1, "Godzilla");
        Movie harryPotter = new Movie(2, "Harry Potter");
        Movie lordOfTheRings = new Movie(3, "Lord of the Rings");
        Movie interstellar = new Movie(4, "Interstellar");

        moviesList.add(godzilla);
        moviesList.add(harryPotter);
        moviesList.add(lordOfTheRings);
        moviesList.add(interstellar);

        return moviesList;
    }

    private ArrayList<Song> getBestSongs(){

        ArrayList<Song> songsList = new ArrayList<>();

        Song happyHour = new Song(1, "Happy Hour");
        Song sultansOfSwing = new Song(2, "Sultans of Swing");
        Song thunderstruck = new Song(3, "Thunderstruck");
        Song walkOfLife = new Song(4, "Walk of Life");

        songsList.add(happyHour);
        songsList.add(sultansOfSwing);
        songsList.add(thunderstruck);
        songsList.add(walkOfLife);

        return songsList;
    }
}
