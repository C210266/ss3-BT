package ra.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    private String image;
    private String cateName;
    private Date creatAtDate;

    public Blog(Long id, String title, String content, String image, String cateName, Date creatAtDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.cateName = cateName;
        this.creatAtDate = creatAtDate;
    }

    public Blog() {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreatAtDate() {
        return creatAtDate;
    }

    public void setCreatAtDate(Date creatAtDate) {
        this.creatAtDate = creatAtDate;
    }
}
