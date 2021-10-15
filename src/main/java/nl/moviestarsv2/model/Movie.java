package nl.moviestarsv2.model;

import javax.persistence.*;


    @Entity
    @Table(name = "movies")
    public class Movie {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private long id;

        @Column(name = "movie_title")
        private String movieTitle;

        @Column(name = "movie_genre")
        private String movieGenre;

        @Column(name = "movie_description")
        private String movieDescription;

        @Column(name = "movie_image")
        private String movieImage;

        @Column(name = "movie_rating")
        private double movieRating;

        @Column(name = "movie_is_rated")
        private boolean movieIsRated;



        ////////////////
        //CONSTRUCTORS//
        ////////////////


        public Movie() {
        }

        public Movie(String movieTitle, String movieGenre) {
            this.movieTitle = movieTitle;
            this.movieGenre = movieGenre;
        }


        //////////////////////
        //GETTERS AN SETTERS//
        //////////////////////


        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getMovieTitle() {
            return movieTitle;
        }

        public void setMovieTitle(String movieTitle) {
            this.movieTitle = movieTitle;
        }

        public String getMovieGenre() {
            return movieGenre;
        }

        public void setMovieGenre(String movieGenre) {
            this.movieGenre = movieGenre;
        }

        public String getMovieDescription() {
            return movieDescription;
        }

        public void setMovieDescription(String movieDescription) {
            this.movieDescription = movieDescription;
        }

        public String getMovieImage() {
            return movieImage;
        }

        public void setMovieImage(String movieImage) {
            this.movieImage = movieImage;
        }

        public double getMovieRating() {
            return movieRating;
        }

        public void setMovieRating(double movieRating) {
            this.movieRating = movieRating;
        }

        public boolean isMovieIsRated() {
            return movieIsRated;
        }

        public void setMovieIsRated(boolean movieIsRated) {
            this.movieIsRated = movieIsRated;
        }
    }
