package com.achihoang.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(nullable = false,length = 150)
    private String introduce;
    @NotEmpty
    @Column(nullable = false,length = 100)
    private String title;
    @NotEmpty
    @Column(nullable = false,length = 100000)
    private String context;
    private String image;
    @Column(nullable = false, updatable = false)
    @Basic
    private String creator = "";
    @NotEmpty
    @Column(nullable = false)
    private String lastEditor;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createDate;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastDate;

    @ManyToOne
    @JoinColumn(name = "categories_id")
    private Category category;

    public Post(){}

    public Post(@NotEmpty String introduce, @NotEmpty String title, @NotEmpty String context, String image, @NotEmpty String creator, @NotEmpty String lastEditor, Date createDate, Date lastDate, Category category) {
        this.introduce = introduce;
        this.title = title;
        this.context = context;
        this.image = image;
        this.creator = creator;
        this.lastEditor = lastEditor;
        this.createDate = createDate;
        this.lastDate = lastDate;
        this.category = category;
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

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getLastEditor() {
        return lastEditor;
    }

    public void setLastEditor(String lastEditor) {
        this.lastEditor = lastEditor;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
