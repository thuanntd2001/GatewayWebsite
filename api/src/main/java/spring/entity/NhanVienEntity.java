package spring.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Data
@Entity
@Table(name = "NHANVIEN")
public class NhanVienEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MANV")
	private Long maNV;

	@Column(name = "HOTEN")
	private String hoTen;

	@Column(name = "NGAYSINH")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date ngaySinh;

	@Column(name = "GIOITINH")
	private int gioiTinh;

	@Column(name = "LUONG")
	private Integer luong;

	@Column(name = "SDT")
	private String sdt;

	@Column(name = "CMND")
	private String cmnd;

	@Column(name = "DIACHI")
	private String diaChi;

	@Column(name = "NGAYVAOLAM")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date ngayVaoLam;

	@Column(name = "TRANGTHAI")
	private Integer trangThai;

	@OneToMany(mappedBy = "nvThucHien", fetch = FetchType.LAZY)
	private Collection<DDHEntity> ddhs;
	
	@OneToMany(mappedBy = "nvTao", fetch = FetchType.LAZY)
	private Collection<SanPhamEntity> sps;
	
	@Column(name="USERNAME")
	private String userName;
	

	
	@Column(name="PASSWD")
	private String passwd;
	
	
	@ManyToMany
	@JoinTable(
			name="NHANVIEN_CHUCVU",
			joinColumns = @JoinColumn(name = "MANV"),
	        inverseJoinColumns = @JoinColumn(name = "ID")
			)
	private List<ChucVuEntity> chucVus;
	
	
	@ManyToOne
	@JoinColumn(name = "CHUCVUCHINH")
	private ChucVuEntity chucVuChinh;


	@Column(name ="EMAIL")
	private String email;
	
	@Column(name="ICON")
	private String icon;

	
	
	public Collection<SanPhamEntity> getSps() {
		return sps;
	}

	public void setSps(Collection<SanPhamEntity> sps) {
		this.sps = sps;
	}

	public ChucVuEntity getChucVuChinh() {
		return chucVuChinh;
	}

	public void setChucVuChinh(ChucVuEntity chucVuChinh) {
		this.chucVuChinh = chucVuChinh;
	}

	public Long getMaNV() {
		return maNV;
	}

	public void setMaNV(Long maNV) {
		this.maNV = maNV;
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

	public Integer getLuong() {
		return luong;
	}

	public void setLuong(Integer luong) {
		this.luong = luong;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Date getNgayVaoLam() {
		return ngayVaoLam;
	}

	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}

	public Integer getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Integer trangThai) {
		this.trangThai = trangThai;
	}

	public Collection<DDHEntity> getDdhs() {
		return ddhs;
	}

	public void setDdhs(Collection<DDHEntity> ddhs) {
		this.ddhs = ddhs;
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

	public List<ChucVuEntity> getChucVus() {
		return chucVus;
	}

	public void setChucVus(List<ChucVuEntity> chucVus) {
		this.chucVus = chucVus;
	}


	

}
