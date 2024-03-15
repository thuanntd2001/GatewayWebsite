package spring.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CHUCVU")
public class ChucVuEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="TENCHUCVU")
	private String tenChucVu;
	
	@ManyToMany(mappedBy="chucVus", fetch = FetchType.LAZY)
	private Collection<NhanVienEntity> nhanviens;
	
	@OneToMany(mappedBy = "chucVuChinh", fetch = FetchType.LAZY)
	private Collection<NhanVienEntity> nvs;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTenChucVu() {
		return tenChucVu;
	}

	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}

	public Collection<NhanVienEntity> getNhanviens() {
		return nhanviens;
	}

	public void setNhanviens(Collection<NhanVienEntity> nhanviens) {
		this.nhanviens = nhanviens;
	}





	
}
