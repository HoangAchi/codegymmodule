package com.achihoang.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "categoriesvi")
public class CategoryVi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false, name = "ten")
    private String name;
    @Column(nullable = false, updatable = false, name = "nguoitao")
    @Basic
    private String creator = "";
    @NotBlank
    @Column(nullable = false, name = "nguoisuacuoicung")
    private String lastEditor;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false, name = "ngaytao")
    private Date createDate;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ngaysuacuoicung")
    private Date lastDate;

    @OneToMany(mappedBy = "categoryVi")
    private Set<PostVi> postViSet;

    public CategoryVi() {
    }

    public CategoryVi(@NotBlank String name, String creator, @NotBlank String lastEditor, Date createDate, Date lastDate) {
        this.name = name;
        this.creator = creator;
        this.lastEditor = lastEditor;
        this.createDate = createDate;
        this.lastDate = lastDate;
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


    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public Set<PostVi> getPostViSet() {
        return postViSet;
    }

    public void setPostViSet(Set<PostVi> postViSet) {
        this.postViSet = postViSet;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
