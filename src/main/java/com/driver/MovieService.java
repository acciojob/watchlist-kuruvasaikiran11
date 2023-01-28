package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.saveMovie(movie);
    }
    public void addDirector(Director director){
        movieRepository.saveDirector(director);
    }

    public void pairMovieDirector(String movie, String director){
        movieRepository.pairMovieDirector(movie, director);
    }

    public Movie getMovie(String name){
        return movieRepository.getMovie(name);
    }

    public Director getDirector(String name){
        return movieRepository.getDirectory(name);
    }

    public List<String> getMoviesByDirector(String name){
        return movieRepository.getMoviesByDirector(name);
    }


    public List<String> getMovies(){
        return movieRepository.getMovies();
    }

    public void deleteDirector(String name){
        movieRepository.deleteDirector(name);
    }

    public void deleteAll(){
        movieRepository.deleteAll();
    }
}
