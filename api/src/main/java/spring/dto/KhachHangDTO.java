package spring.dto;

import java.util.Date;

import lombok.Data;

@Data
public class KhachHangDTO {
	private Long maKH;
	private String hoTen;
	private Date ngaySinh;
	private int gioiTinh;
	private String sdt;
	private String diaChi;
	private int trangThai;
	
	private String userName;

	private String passwd;

	private Integer status;

	private String email;

	private String icon;

	private String maXacThuc;
	private Date ngayDangKy;
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
	public int isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(int i) {
		this.gioiTinh = i;
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
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public String getMaXacThuc() {
		return maXacThuc;
	}
	public void setMaXacThuc(String maXacThuc) {
		this.maXacThuc = maXacThuc;
	}
	public Date getNgayDangKy() {
		return ngayDangKy;
	}
	public void setNgayDangKy(Date ngayDangKy) {
		this.ngayDangKy = ngayDangKy;
	}

	
	
	
}
