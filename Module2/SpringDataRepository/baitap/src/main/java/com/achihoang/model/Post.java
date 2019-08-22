package com.achihoang.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String context;
    private Date dateCreated;

    @ManyToOne
    @JoinColumn(name = "categories_id")
    private Category category;

    public Post(){}

    public Post(String title, String context,Date dateCreated) {
        this.title = title;
        this.context = context;
        this.dateCreated= dateCreated;
    }

    @Override
    public  String toString(){
        return String.format("Post[id=%d, title='%s', context='%s', dateCreated='%d']",id,title,context, dateCreated);
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

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
