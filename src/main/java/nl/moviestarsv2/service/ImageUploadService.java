package nl.moviestarsv2.service;

import nl.moviestarsv2.File.ImageUploadFile;
import nl.moviestarsv2.exceptions.RecordNotFoundException;
import nl.moviestarsv2.repository.ImageUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class ImageUploadService {

    @Autowired
    private ImageUploadRepository repository;

    public Iterable<ImageUploadFile> getFiles() {
        return repository.findAll();
    }

    public long uploadFile(MultipartFile file) {

        String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());

        ImageUploadFile newFileToStore = new ImageUploadFile();
        newFileToStore.setFileName(originalFilename);

        ImageUploadFile storedFile = repository.save(newFileToStore);

        return storedFile.getId();
    }

    public void deleteFile(long id) {
        if (!repository.existsById(id)) throw new RecordNotFoundException();
        repository.deleteById(id);
    }

    public Optional<ImageUploadFile> getFileById(long id) {
        if (!repository.existsById(id)) throw new RecordNotFoundException();
        return repository.findById(id);
    }

    public boolean fileExistsById(long id) {
        return repository.existsById(id);
    }

}