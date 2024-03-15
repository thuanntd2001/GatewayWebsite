package spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "DONDATHANG")
public class DDHEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MADDH")
	private Long id;

	@Column(name = "NGAYTHUCHIEN")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	private Date ngayThucHien;

	@ManyToOne
	@JoinColumn(name = "NVXACNHAN")
	private NhanVienEntity nvThucHien;

	@ManyToOne
	@JoinColumn(name = "MAKH")
	private KhachHangEntity khThucHien;
	
	@ManyToOne
	@JoinColumn(name = "SANPHAM")
	private SanPhamEntity sanPham;

	@Column(name = "TINHTRANG")
	private Integer tinhTrang;

	@Column(name = "ISFCL")
	private Integer isfcl;
	
	@Column(name = "DKGH")
	private Integer dkgh;
	
	@Column(name = "DKNH")
	private Integer dknh;
	
	@Column(name = "NHOMHANG")
	private Integer nhomHang;
	
	@Column(name = "MOTAHH")
	private String moTaHH;
	
	@Column(name = "TGKH")
	private String tgkh;
	
	@Column(name = "LUUY")
	private String luuY;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getNgayThucHien() {
		return ngayThucHien;
	}

	public void setNgayThucHien(Date ngayThucHien) {
		this.ngayThucHien = ngayThucHien;
	}

	public NhanVienEntity getNvThucHien() {
		return nvThucHien;
	}

	public void setNvThucHien(NhanVienEntity nvThucHien) {
		this.nvThucHien = nvThucHien;
	}

	public KhachHangEntity getKhThucHien() {
		return khThucHien;
	}

	public void setKhThucHien(KhachHangEntity khThucHien) {
		this.khThucHien = khThucHien;
	}

	public Integer getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(Integer tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public Integer getIsfcl() {
		return isfcl;
	}

	public void setIsfcl(Integer isfcl) {
		this.isfcl = isfcl;
	}

	public Integer getDkgh() {
		return dkgh;
	}

	public void setDkgh(Integer dkgh) {
		this.dkgh = dkgh;
	}

	public Integer getDknh() {
		return dknh;
	}

	public void setDknh(Integer dknh) {
		this.dknh = dknh;
	}

	public Integer getNhomHang() {
		return nhomHang;
	}

	public void setNhomHang(Integer nhomHang) {
		this.nhomHang = nhomHang;
	}

	public String getMoTaHH() {
		return moTaHH;
	}

	public void setMoTaHH(String moTaHH) {
		this.moTaHH = moTaHH;
	}

	public String getTgkh() {
		return tgkh;
	}

	public void setTgkh(String tgkh) {
		this.tgkh = tgkh;
	}

	public String getLuuY() {
		return luuY;
	}

	public void setLuuY(String luuY) {
		this.luuY = luuY;
	}

	
}
