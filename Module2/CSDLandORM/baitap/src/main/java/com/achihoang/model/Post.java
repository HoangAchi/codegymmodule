package com.achihoang.model;
import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String category;
    private String context;

    public Post(){}

    public Post(Long id, String title, String category, String context) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.context = context;
    }

    @Override
    public String toString() {
        return String.format("Post[id=%d, title='%s', category='%s', context='%s']", id, title, category, context);
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
