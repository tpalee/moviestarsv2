package nl.moviestarsv2.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "files")
public class ImageUpload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "type")
    private String type;

    @Column(name = "file")
    @Lob
    private byte[] file;

    public ImageUpload() {
    }

    public ImageUpload(String fileName, String type, byte[] file) {
        this.fileName = fileName;
        this.type = type;
        this.file = file;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
