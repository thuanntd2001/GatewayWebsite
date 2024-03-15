package spring.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "SANPHAM")
public class SanPhamEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "NVTAO")
	private NhanVienEntity nvTao;
	
	@OneToMany(mappedBy = "sanPham", fetch = FetchType.LAZY)
	private Collection<DDHEntity> ddhs;
	
	@Column(name = "LOAI") //mod 2 = 0 di thang, mod 2 = 1 chuyen tai, <2 lcl, >2 FCL
	private Long loai;

	@Column(name = "TEN")
	private String ten;

	@Column(name = "ICON")
	private String icon;

	@Column(name = "TRANGTHAI")
	private Integer trangThai;

	@Column(name = "MOTA")
	@Type(type = "text")
	private String moTa;
	
	
	@Column(name = "NOIDI")
	private String noiDi;	
	@Column(name = "NOIDEN")
	private String noiDen;
	
	
	
	@Column(name = "PHIDICMB")
	private Integer phiDiCMB;
	@Column(name = "PHIDENCMB")
	private Integer phiDenCMB;

	@Column(name = "PHIDISET")
	private Integer phiDiSet;
	@Column(name = "PHIDENSET")
	private Integer phiDenSet;

	@Column(name = "PHIDICONT")
	private Integer phiDiCont;
	@Column(name = "PHIDENCONT")
	private Integer phiDenCont;

	@Column(name = "PHIDIBL")
	private Integer phiDiBl;
	@Column(name = "PHIDENBL")
	private Integer phiDenBl;
	
	
	@Column(name = "NOTEPHIDI")
	private String notePhiDi;
	@Column(name = "NOTEPHIDEN")
	private String notePhiDen;
	
	@Column(name = "DVVC")
	private String DVVC;
	
	@Column(name = "CUOCVC")
	private Integer cuocvc;
	
	@Column(name = "TGVC")
	private Integer tgvc;
	
	@Column(name = "ETD")
	private Integer etd;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLoai() {
		return loai;
	}

	public void setLoai(Long loai) {
		this.loai = loai;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(Integer trangThai) {
		this.trangThai = trangThai;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getNoiDi() {
		return noiDi;
	}

	public void setNoiDi(String noiDi) {
		this.noiDi = noiDi;
	}

	public String getNoiDen() {
		return noiDen;
	}

	public void setNoiDen(String noiDen) {
		this.noiDen = noiDen;
	}

	public Integer getPhiDiCMB() {
		return phiDiCMB;
	}

	public void setPhiDiCMB(Integer phiDiCMB) {
		this.phiDiCMB = phiDiCMB;
	}

	public Integer getPhiDenCMB() {
		return phiDenCMB;
	}

	public void setPhiDenCMB(Integer phiDenCMB) {
		this.phiDenCMB = phiDenCMB;
	}

	public Integer getPhiDiSet() {
		return phiDiSet;
	}

	public void setPhiDiSet(Integer phiDiSet) {
		this.phiDiSet = phiDiSet;
	}

	public Integer getPhiDenSet() {
		return phiDenSet;
	}

	public void setPhiDenSet(Integer phiDenSet) {
		this.phiDenSet = phiDenSet;
	}

	public Integer getPhiDiCont() {
		return phiDiCont;
	}

	public void setPhiDiCont(Integer phiDiCont) {
		this.phiDiCont = phiDiCont;
	}

	public Integer getPhiDenCont() {
		return phiDenCont;
	}

	public void setPhiDenCont(Integer phiDenCont) {
		this.phiDenCont = phiDenCont;
	}

	public Integer getPhiDiBl() {
		return phiDiBl;
	}

	public void setPhiDiBl(Integer phiDiBl) {
		this.phiDiBl = phiDiBl;
	}

	public Integer getPhiDenBl() {
		return phiDenBl;
	}

	public void setPhiDenBl(Integer phiDenBl) {
		this.phiDenBl = phiDenBl;
	}

	public String getNotePhiDi() {
		return notePhiDi;
	}

	public void setNotePhiDi(String notePhiDi) {
		this.notePhiDi = notePhiDi;
	}

	public String getNotePhiDen() {
		return notePhiDen;
	}

	public void setNotePhiDen(String notePhiDen) {
		this.notePhiDen = notePhiDen;
	}

	public String getDVVC() {
		return DVVC;
	}

	public void setDVVC(String dVVC) {
		DVVC = dVVC;
	}

	public Integer getCuocvc() {
		return cuocvc;
	}

	public void setCuocvc(Integer cuocvc) {
		this.cuocvc = cuocvc;
	}

	public Integer getTgvc() {
		return tgvc;
	}

	public void setTgvc(Integer tgvc) {
		this.tgvc = tgvc;
	}

	public Integer getEtd() {
		return etd;
	}

	public void setEtd(Integer etd) {
		this.etd = etd;
	}

	public NhanVienEntity getNvTao() {
		return nvTao;
	}

	public void setNvTao(NhanVienEntity nvTao) {
		this.nvTao = nvTao;
	}

	
}
