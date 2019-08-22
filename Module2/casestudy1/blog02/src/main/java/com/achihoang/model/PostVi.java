package com.achihoang.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "postvi")
public class PostVi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @Column(nullable = false, length = 150)
    private String modau;
    @NotEmpty
    @Column(nullable = false, length = 100)
    private String tieude;
    @NotEmpty
    @Column(nullable = false, length = 100000)
    private String noidung;
    private String hinhanh;
    @Column(nullable = false, updatable = false)
    @Basic
    private String nguoitao = "";
    @NotEmpty
    @Column(nullable = false)
    private String nguoisuacuoicung;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date ngaytao;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaysuacuoicung;
    @ManyToOne
    @JoinColumn(name = "categoriesvi_id")
    private CategoryVi categoryVi;

    public PostVi() {
    }

    public PostVi(@NotEmpty String modau, @NotEmpty String tieude, @NotEmpty String noidung, String hinhanh, @NotEmpty String nguoisuacuoicung, Date ngaytao, Date ngaysuacuoicung) {
        this.modau = modau;
        this.tieude = tieude;
        this.noidung = noidung;
        this.hinhanh = hinhanh;
        this.nguoisuacuoicung = nguoisuacuoicung;
        this.ngaytao = ngaytao;
        this.ngaysuacuoicung = ngaysuacuoicung;
    }

    public String getModau() {
        return modau;
    }

    public void setModau(String modau) {
        this.modau = modau;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getNguoitao() {
        return nguoitao;
    }

    public void setNguoitao(String nguoitao) {
        this.nguoitao = nguoitao;
    }

    public String getNguoisuacuoicung() {
        return nguoisuacuoicung;
    }

    public void setNguoisuacuoicung(String nguoisuacuoicung) {
        this.nguoisuacuoicung = nguoisuacuoicung;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public Date getNgaysuacuoicung() {
        return ngaysuacuoicung;
    }

    public void setNgaysuacuoicung(Date ngaysuacuoicung) {
        this.ngaysuacuoicung = ngaysuacuoicung;
    }

    public CategoryVi getCategoryVi() {
        return categoryVi;
    }

    public void setCategoryVi(CategoryVi categoryVi) {
        this.categoryVi = categoryVi;
    }
}
