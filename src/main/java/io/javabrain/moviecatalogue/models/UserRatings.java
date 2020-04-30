package io.javabrain.moviecatalogue.models;

import java.util.List;

public class UserRatings {
    List<Rating> userRating;

    public UserRatings() {
    }

    public List<Rating> getUserRating() {
        return userRating;
    }

    public void setUserRating(List<Rating> userRating) {
        this.userRating = userRating;
    }
}
