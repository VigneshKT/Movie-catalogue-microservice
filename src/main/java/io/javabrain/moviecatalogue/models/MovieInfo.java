package io.javabrain.moviecatalogue.models;

public class MovieInfo {
   String movieId;
   String desc;

   public MovieInfo(){

   }
    public MovieInfo(String movieId, String desc) {
        this.movieId = movieId;
        this.desc = desc;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
