package nl.moviestarsv2.repository;

import nl.moviestarsv2.model.ImageUpload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageUploadRepository extends JpaRepository<ImageUpload, Long>{
}
