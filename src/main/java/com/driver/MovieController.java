package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("New Movie Added", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("Director Added", HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movie") String movie, @RequestParam("director") String director){
        movieService.pairMovieDirector(movie, director);
        return new ResponseEntity<>("Paired", HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovie(@PathVariable String name){

        Movie movie = movieService.getMovie(name);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirector(@PathVariable String name){

        Director director = movieService.getDirector(name);
        return new ResponseEntity<>(director, HttpStatus.OK);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirector(@PathVariable String director){
        List<String> movieList = movieService.getMoviesByDirector(director);
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity getAllMovies(){
        List<String> movieList = movieService.getMovies();
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirector(@RequestParam("name") String name){
        movieService.deleteDirector(name);
        return new ResponseEntity("Director deleted", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteDirectors(){
        movieService.deleteAll();
        return new ResponseEntity<>("Directors deleted", HttpStatus.ACCEPTED);
    }

}
