package ra.model.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class BlogDto {
    private Long id;
    private String title;
    private String content;
    private MultipartFile image;
    private String cateName;
    private Date createDate = new Date();

    public BlogDto() {
    }

    public BlogDto(Long id, String title, String content, MultipartFile image, String cateName, Date createDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.cateName = cateName;
        this.createDate = createDate;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}