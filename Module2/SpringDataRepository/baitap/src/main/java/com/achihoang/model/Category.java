package com.achihoang.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Post> postset;

    public Category(){}

    public Category(String name){
        this.name=name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Post> getPostset() {
        return postset;
    }

    public void setPostset(Set<Post> postset) {
        this.postset = postset;
    }
}
