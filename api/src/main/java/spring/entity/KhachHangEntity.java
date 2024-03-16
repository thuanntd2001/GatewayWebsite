package spring.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "KHACHHANG")
public class KhachHangEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MAKH")
	private Long maKH;
	
	@Column(name = "EMAIL", unique = true, columnDefinition = "VARCHAR(100)")
	private String email;
	
	@Column(name = "PASSWD")
	private String passwd;
	
	@Column(name = "ICON")
	private String icon;

	@Column(name = "HOTEN")
	private String hoTen;

	@Column(name = "NGAYSINH")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date ngaySinh;

	@Column(name = "GIOITINH")
	private int gioiTinh;

	@Column(name = "SDT")
	private String sdt;

	@Column(name = "DIACHI")
	private String diaChi;

	@Column(name = "ISLOCKED") 
	private boolean isLocked;
	
	@Column(name = "ISENABLE") 
	private boolean isEnable;

	@OneToMany(mappedBy = "khThucHien", fetch = FetchType.LAZY)
	private Collection<DDHEntity> ddhs;

	@OneToMany(mappedBy = "khachHang", fetch = FetchType.LAZY)
	private Collection<GioHangEntity> gioHangs;
	
	@Column(name = "NGAYDANGKY")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	private Date ngayDangKy;
	
	@Column(name = "TRANGTHAI", columnDefinition = "INT DEFAULT 1") 
	private int trangThai;

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public Long getMaKH() {
		return maKH;
	}

	public void setMaKH(Long maKH) {
		this.maKH = maKH;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public int getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}



	public Collection<DDHEntity> getDdhs() {
		return ddhs;
	}

	public void setDdhs(Collection<DDHEntity> ddhs) {
		this.ddhs = ddhs;
	}

	public Collection<GioHangEntity> getGioHangs() {
		return gioHangs;
	}

	public void setGioHangs(Collection<GioHangEntity> gioHangs) {
		this.gioHangs = gioHangs;
	}


	public boolean isLocked() {
		return isLocked;
	}
	
	public boolean isNonLocked() {
		return !isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public boolean isEnable() {
		return isEnable;
	}

	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Date getNgayDangKy() {
		return ngayDangKy;
	}

	public void setNgayDangKy(Date ngayDangKy) {
		this.ngayDangKy = ngayDangKy;
	}


	
	

}
