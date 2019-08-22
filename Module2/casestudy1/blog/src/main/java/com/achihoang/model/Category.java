package com.achihoang.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(nullable = false)
    private String name;

    @NotEmpty
    @Column(nullable = false)
    private String creator;
    @NotEmpty
    @Column(nullable = false)
    private String finalEditor;
    @Column(nullable = false)
    private Date dateCreate;
    @Column(nullable = false)
    private Date dateLast;

    @OneToMany(mappedBy = "category")
    private Set<Post> postSet;

    public Category() {
    }

    public Category(String name, @NotEmpty String creator, @NotEmpty String finalEditor, Date dateCreate, Date dateLast) {
        this.name = name;
        this.creator = creator;
        this.finalEditor = finalEditor;
        this.dateCreate = dateCreate;
        this.dateLast = dateLast;
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

    public Set<Post> getPostSet() {
        return postSet;
    }

    public void setPostSet(Set<Post> postSet) {
        this.postSet = postSet;
    }
}
