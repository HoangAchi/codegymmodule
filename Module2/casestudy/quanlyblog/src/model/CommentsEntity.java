package model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "comments", schema = "quanlyblog", catalog = "")
public class CommentsEntity {
    private int id;
    private String contents;
    private Timestamp dateCreated;
    private Timestamp lastModifiedDate;
    private String creator;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "contents")
    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
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
    @Column(name = "lastModifiedDate")
    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Basic
    @Column(name = "creator")
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentsEntity that = (CommentsEntity) o;
        return id == that.id &&
                Objects.equals(contents, that.contents) &&
                Objects.equals(dateCreated, that.dateCreated) &&
                Objects.equals(lastModifiedDate, that.lastModifiedDate) &&
                Objects.equals(creator, that.creator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contents, dateCreated, lastModifiedDate, creator);
    }

    @ManyToOne
    @JoinColumn(name = "idPosts")
    private PostsEntity postsEntity;

    public PostsEntity getPostsEntity() {
        return postsEntity;
    }

    public void setPostsEntity(PostsEntity postsEntity) {
        this.postsEntity = postsEntity;
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
