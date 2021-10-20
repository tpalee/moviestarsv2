package nl.moviestarsv2.controller;

import nl.moviestarsv2.exceptions.RecordNotFoundException;
import nl.moviestarsv2.model.ImageUpload;
import nl.moviestarsv2.model.Movie;
import nl.moviestarsv2.service.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/files")
@CrossOrigin




public class ImageUploadController {

    //connect Service to Controller
    @Autowired
    private ImageUploadService imageUploadService;

    public ImageUploadController(ImageUploadService imageUploadService) {
        this.imageUploadService = imageUploadService;
    }

    // get all Images from db
    @GetMapping
    public ResponseEntity<Collection<ImageUpload>> getAllFiles(){
            return ResponseEntity.ok().body(imageUploadService.getAllFiles());
    }

    // find Image by Id from db
    @GetMapping(value = "/{id}")
    public ResponseEntity getFileById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(imageUploadService.getFileById(id));
    }

    // Upload an image to db
    @PostMapping
    public ResponseEntity<Object> upLoadFile(@RequestParam("file")MultipartFile multipartFile) throws IOException {
        imageUploadService.uploadFile(multipartFile);
        return ResponseEntity.noContent().build();
    }

    //replace an existing image
    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateFile(@PathVariable("id") long id, @RequestBody MultipartFile multipartFile) throws IOException {
        imageUploadService.updateFile(id, multipartFile);
        return ResponseEntity.noContent().build();
    }

    //delete movie
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteMovie(@PathVariable("id") int id) {
        imageUploadService.deleteFile(id);
        return ResponseEntity.noContent().build();
    }








}
