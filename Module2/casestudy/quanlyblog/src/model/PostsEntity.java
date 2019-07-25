package model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "posts", schema = "quanlyblog", catalog = "")
public class PostsEntity {
    private int id;
    private String introduce;
    private String title;
    private String content;
    private String image;
    private String creator;
    private Timestamp dateCreated;
    private String finalEditor;
    private Timestamp lastModifiedDate;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "introduce")
    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        PostsEntity that = (PostsEntity) o;
        return id == that.id &&
                Objects.equals(introduce, that.introduce) &&
                Objects.equals(title, that.title) &&
                Objects.equals(content, that.content) &&
                Objects.equals(image, that.image) &&
                Objects.equals(creator, that.creator) &&
                Objects.equals(dateCreated, that.dateCreated) &&
                Objects.equals(finalEditor, that.finalEditor) &&
                Objects.equals(lastModifiedDate, that.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, introduce, title, content, image, creator, dateCreated, finalEditor, lastModifiedDate);
    }

    @ManyToOne
    @JoinColumn(name = "idCategories")
    private CategoriesEntity categoriesEntity;


    public CategoriesEntity getCategoriesEntity() {
        return categoriesEntity;
    }

    public void setCategoriesEntity(CategoriesEntity categoriesEntity) {
        this.categoriesEntity = categoriesEntity;
    }

    @OneToMany(mappedBy = "postsEntity", fetch = FetchType.LAZY)
    private List<CommentsEntity> commentsEntityList;

    public List<CommentsEntity> getCommentsEntityList() {
        return commentsEntityList;
    }

    public void setCommentsEntityList(List<CommentsEntity> commentsEntityList) {
        this.commentsEntityList = commentsEntityList;
    }

    @ManyToOne
    @JoinColumn(name = "idUsers")
    private UsersEntity usersEntity;

    public UsersEntity getUsersEntity() {
        return usersEntity;
    }

    public void setUsersEntity(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
    }
}
