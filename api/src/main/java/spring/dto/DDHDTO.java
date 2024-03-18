package spring.dto;

import java.util.Date;

import lombok.ToString;
import spring.entity.DDHEntity;

@ToString
public class DDHDTO {

	public DDHDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DDHDTO(DDHEntity model) {
		if (model.getKhThucHien() != null)
			this.setKhThucHien(model.getKhThucHien().getMaKH());
		if (model.getNvThucHien() != null)
			this.setNvThucHien(model.getNvThucHien().getMaNV());
		this.setNgayThucHien(model.getNgayThucHien());
		this.setId(model.getId());
		this.setTinhTrang(model.getTinhTrang());
		this.setDkgh(model.getDkgh());
		this.setDknh(model.getDknh());
		this.setIsfcl(model.getIsfcl());
		this.setLuuY(model.getMoTaHH());
		this.setMoTaHH(model.getMoTaHH());
		this.setNhomHang(model.getNhomHang());
		this.setTgkh(model.getTgkh());
		this.setSanPham(model.getSanPham().getTen());
		this.setSanPhamId(model.getSanPham().getId());
	}

	private Long nvThucHien;

	private Long khThucHien;

	private Long id;

	private Date ngayThucHien;

	private Integer tinhTrang;

	private Integer isfcl;

	private Integer dkgh;

	private Integer dknh;

	private Integer nhomHang;

	private String moTaHH;

	private String tgkh;

	private String luuY;

	private String sanPham;

	private Long sanPhamId;

	public Long getNvThucHien() {
		return nvThucHien;
	}

	public void setNvThucHien(Long nvThucHien) {
		this.nvThucHien = nvThucHien;
	}

	public Long getKhThucHien() {
		return khThucHien;
	}

	public void setKhThucHien(Long khThucHien) {
		this.khThucHien = khThucHien;
	}

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

	public String getSanPham() {
		return sanPham;
	}

	public void setSanPham(String sanPham) {
		this.sanPham = sanPham;
	}

	public Long getSanPhamId() {
		return sanPhamId;
	}

	public void setSanPhamId(Long sanPhamId) {
		this.sanPhamId = sanPhamId;
	}

}
