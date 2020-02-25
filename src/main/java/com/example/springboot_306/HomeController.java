package com.example.springboot_306;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    DirectorRepository directorRepo;

    @RequestMapping("/")
    public String index(Model model){
        Director director = new Director();

        director.setName("Stephen Bullock");
        director.setGenre("Sci Fi");

        Movie movie = new Movie();
        movie.setTitle("Star Movie");
        movie.setYear(2017);
        movie.setDescription("About Stars..");

        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie);

        movie = new Movie();
        movie.setTitle("Deathstar Ewoks");
        movie.setYear(2011);
        movie.setDescription("About Ewoks");
        movies.add(movie);

        director.setMovies(movies);

        directorRepo.save(director);

        model.addAttribute("directors", directorRepo.findAll());
        return "index";

    }
}
