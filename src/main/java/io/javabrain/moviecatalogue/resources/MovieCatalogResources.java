package io.javabrain.moviecatalogue.resources;

import io.javabrain.moviecatalogue.models.CatalogItem;
import io.javabrain.moviecatalogue.models.MovieInfo;
import io.javabrain.moviecatalogue.models.Rating;
import io.javabrain.moviecatalogue.models.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResources {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalogue(@PathVariable("userId") String userId){

        UserRatings ratings = restTemplate.getForObject("http://localhost:8083/movie/rating/"+userId,UserRatings.class);

       return ratings.getUserRating().stream().map(rating -> {
           MovieInfo movieInfo = restTemplate.getForObject("http://localhost:8082/movie/desc/"+rating.getMovieId(), MovieInfo.class);
            return new CatalogItem(movieInfo.getMovieId(),movieInfo.getDesc(),rating.getRating());
        }).collect(Collectors.toList());
    }

}
