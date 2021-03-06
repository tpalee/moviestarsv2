package nl.moviestarsv2.controller;

import nl.moviestarsv2.model.Review;
import nl.moviestarsv2.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    //get all reviews
    @GetMapping(value = "/reviews")
    public ResponseEntity<Object> getReviews() {
        return ResponseEntity.ok().body(reviewService.getReviews());
    }


    //find review by id
    @GetMapping(value = "/reviews/{id}")
    public ResponseEntity getReview(@PathVariable long id) {
        return ResponseEntity.ok().body(reviewService.findById(id));
    }


    //create a review
    @PostMapping(value = "/reviews")
    public ResponseEntity<Object> createReview(@RequestBody Review review) {
        long newId = reviewService.createReview(review);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();
        return ResponseEntity.created(location).build();
    }


    //update a review
    @PutMapping(value = "/reviews/{id}")
    public ResponseEntity updateReview(@PathVariable long id, @RequestBody Review review) {
        return ResponseEntity.ok("Review is aangepast");
    }


    //delete a review
    @DeleteMapping(value = "/reviews/{id}")
    public ResponseEntity deleteReview(@PathVariable long id) {
        reviewService.deleteById(id);
        return ResponseEntity.ok("Review is verwijderd");
    }


}