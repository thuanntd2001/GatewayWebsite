package spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="GIOHANG")
public class GioHangEntity {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name="MAKH")
	private KhachHangEntity khachHang;

	@ManyToOne
	@JoinColumn(name="SANPHAM")
	private SanPhamEntity sp;
	
	
	
	@Column(name="SOLUONG")
	private Integer soLuong;
	




	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public KhachHangEntity getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHangEntity khachHang) {
		this.khachHang = khachHang;
	}

	public SanPhamEntity getSp() {
		return sp;
	}

	public void setSp(SanPhamEntity sp) {
		this.sp = sp;
	}



	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}
	
}
