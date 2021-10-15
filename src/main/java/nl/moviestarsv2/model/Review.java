package nl.moviestarsv2.model;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "review", nullable = false)
    private String review;

    @Column(name = "review_rating",nullable = false)
    private double reviewRating;

    @Column(name = "bad_language")
    private boolean badLanguage=true;


    ////////////////
    //CONSTRUCTORS//
    ////////////////
    public Review() {
    }

    public Review(long id, String review, double reviewRating) {
        this.id = id;
        this.review = review;
        this.reviewRating = reviewRating;
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

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public double getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(double reviewRating) {
        this.reviewRating = reviewRating;
    }

    public boolean isBadLanguage() {
        return badLanguage;
    }

    public void setBadLanguage(boolean badLanguage) {
        this.badLanguage = badLanguage;
    }
}
