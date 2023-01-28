package com.driver;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    private Map<String, Movie> movieMap;
    private Map<String, Director> directorMap;
    private Map<String, List<String>> directorMovieMap;

    public MovieRepository(){
        this.directorMap = new HashMap<String, Director>();
        this.movieMap =  new HashMap<String, Movie>();
        this.directorMovieMap = new HashMap<String, List<String>>();
    }

    public void saveMovie(Movie movie){
        movieMap.put(movie.getName(), movie);
    }

    public void saveDirector(Director director){
        directorMap.put(director.getName(), director);
    }

    public void pairMovieDirector(String movie, String director){
        if(movieMap.containsKey(movie) && directorMap.containsKey(director)) {
            List<String> movieList = new ArrayList<>();
            if (directorMovieMap.containsKey(director))
                movieList = directorMovieMap.get(director);
            movieList.add(movie);
            directorMovieMap.put(director, movieList);
        }
    }

    public Movie getMovie(String name){
        return movieMap.get(name);
    }

    public Director getDirectory(String name){
        return directorMap.get(name);
    }

    public List<String> getMoviesByDirector(String name){
        List<String> movieList = new ArrayList<>();
        if(directorMovieMap.containsKey(name)){
            movieList = directorMovieMap.get(name);
        }
        return movieList;
    }

    public List<String> getMovies(){
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirector(String name){
        List<String> movieList = new ArrayList<>();
        if(directorMovieMap.containsKey(name)){
            movieList = directorMovieMap.get(name);
            for(String str : movieList)
                if(movieMap.containsKey(str))
                    movieMap.remove(str);
            directorMovieMap.remove(name);
        }
        if(directorMap.containsKey(name))
            directorMap.remove(name);
    }
    public void deleteAll(){
        directorMovieMap.clear();
    }
}
