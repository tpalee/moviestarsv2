package nl.moviestarsv2.repository;

import nl.moviestarsv2.File.ImageUploadFile;
import org.springframework.data.repository.CrudRepository;

public interface ImageUploadRepository extends CrudRepository<ImageUploadFile, Long> {
}
