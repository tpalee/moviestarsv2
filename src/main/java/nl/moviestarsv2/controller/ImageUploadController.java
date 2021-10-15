package nl.moviestarsv2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/files")
@CrossOrigin
public class ImageUploadController {

    @GetMapping
    public ResponseEntity<Object> getFiles() {
        return ResponseEntity.noContent().build();
    }

    @GetMapping("id")
    public ResponseEntity<Object> getFileInfo(@PathVariable long id) {
        return ResponseEntity.noContent().build();
    }

    @GetMapping("id/file")
    public ResponseEntity<Object> getFileData(@PathVariable long id) {
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Object> uploadFile() {
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteFile() {
        return ResponseEntity.noContent().build();
    }

}
