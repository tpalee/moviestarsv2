package nl.moviestarsv2.service;

import nl.moviestarsv2.exceptions.RecordNotFoundException;
import nl.moviestarsv2.model.ImageUpload;
import nl.moviestarsv2.repository.ImageUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;


@Service
public class ImageUploadService {

    @Autowired
    private ImageUploadRepository imageUploadRepository;

    public ImageUploadService(ImageUploadRepository imageUploadRepository) {
        this.imageUploadRepository = imageUploadRepository;
    }

    public Long uploadFile(MultipartFile multipartFile) throws IOException {
        String fileName = multipartFile.getOriginalFilename();
        ImageUpload imageUpload = new ImageUpload(fileName, multipartFile.getContentType(), multipartFile.getBytes());
        imageUploadRepository.save(imageUpload);
        return imageUpload.getId();
    }

    public Optional<ImageUpload> getFileById(Long id){
        if (!imageUploadRepository.existsById(id)) throw new RecordNotFoundException();
        return imageUploadRepository.findById(id);
    }

    public Collection<ImageUpload> getAllFiles(){
        return imageUploadRepository.findAll();
    }



    //update an existing file
    public void updateFile(long id, MultipartFile newMultipartFile) throws IOException {
        if (!imageUploadRepository.existsById(id)) throw new RecordNotFoundException();
        ImageUpload imageUpload = imageUploadRepository.findById(id).get();
        imageUpload.setFileName(newMultipartFile.getOriginalFilename());
        imageUpload.setType(newMultipartFile.getContentType());
        imageUpload.setFile(newMultipartFile.getBytes());
        imageUploadRepository.save(imageUpload);
    }

    //delete an existing file
    public void deleteFile(long id)  {
        if (!imageUploadRepository.existsById(id)) throw new RecordNotFoundException();
        imageUploadRepository.deleteById(id);
    }



}
