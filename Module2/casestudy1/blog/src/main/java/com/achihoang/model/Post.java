package com.achihoang.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table (name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @Column(nullable = false)
    private String introduce;
    @NotEmpty
    @Column(nullable = false)
    private String title;
    @NotEmpty
    @Column(nullable = false)
    private String content;
    private String image;

    @ManyToOne
    @JoinColumn(name = "categories_id")
    private Category category;

    public Post(){}

    public Post(String introduce, String title, String content, String image) {
        this.introduce = introduce;
        this.title = title;
        this.content = content;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
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
}
