package model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "quanlyblog", catalog = "")
public class UsersEntity {
    private int id;
    private String username;
    private String password;
    private String role;
    private String salt;
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
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "salt")
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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
        UsersEntity that = (UsersEntity) o;
        return id == that.id &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(role, that.role) &&
                Objects.equals(salt, that.salt) &&
                Objects.equals(image, that.image) &&
                Objects.equals(creator, that.creator) &&
                Objects.equals(dateCreated, that.dateCreated) &&
                Objects.equals(finalEditor, that.finalEditor) &&
                Objects.equals(lastModifiedDate, that.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, role, salt, image, creator, dateCreated, finalEditor, lastModifiedDate);
    }

    @OneToMany(mappedBy = "usersEntity", fetch = FetchType.LAZY)
    private List<PostsEntity> postsEntityList;

    public List<PostsEntity> getPostsEntityList() {
        return postsEntityList;
    }

    public void setPostsEntityList(List<PostsEntity> postsEntityList) {
        this.postsEntityList = postsEntityList;
    }

    @OneToMany(mappedBy = "usersEntity", fetch = FetchType.LAZY)
    private List<CommentsEntity> commentsEntityList;

    public List<CommentsEntity> getCommentsEntityList() {
        return commentsEntityList;
    }

    public void setCommentsEntityList(List<CommentsEntity> commentsEntityList) {
        this.commentsEntityList = commentsEntityList;
    }
}
