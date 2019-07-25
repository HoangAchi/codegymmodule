package model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "categories", schema = "quanlyblog")
public class CategoriesEntity {
    private int id;
    private String nameCategories;
    private String creator;
    private Timestamp dateCreated;
    private String finalEditor;
    private Timestamp lastModifiedDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nameCategories")
    public String getNameCategories() {
        return nameCategories;
    }

    public void setNameCategories(String nameCategories) {
        this.nameCategories = nameCategories;
    }

    @Basic
    @Column(name = "creator")
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Basic
    @Column(name = "dateCreated")
    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Basic
    @Column(name = "finalEditor")
    public String getFinalEditor() {
        return finalEditor;
    }

    public void setFinalEditor(String finalEditor) {
        this.finalEditor = finalEditor;
    }

    @Basic
    @Column(name = "lastModifiedDate")
    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriesEntity that = (CategoriesEntity) o;
        return id == that.id &&
                Objects.equals(nameCategories, that.nameCategories) &&
                Objects.equals(creator, that.creator) &&
                Objects.equals(dateCreated, that.dateCreated) &&
                Objects.equals(finalEditor, that.finalEditor) &&
                Objects.equals(lastModifiedDate, that.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameCategories, creator, dateCreated, finalEditor, lastModifiedDate);
    }

    @OneToMany(mappedBy = "categoriesEntity", fetch = FetchType.LAZY)
    private List<PostsEntity> postsEntityList;


    public List<PostsEntity> getPostsEntityList() {
        return postsEntityList;
    }

    public void setPostsEntityList(List<PostsEntity> postsEntityList) {
        this.postsEntityList = postsEntityList;
    }
}
