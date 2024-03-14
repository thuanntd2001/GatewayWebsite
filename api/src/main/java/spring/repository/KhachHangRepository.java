package spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import spring.entity.KhachHangEntity;





public interface KhachHangRepository extends JpaRepository<KhachHangEntity, Long>{
	@Query(
			  value = "SELECT * FROM khachhang item WHERE TRANGTHAI = 1", 
			  nativeQuery = true)
	List<KhachHangEntity> findAllActive();

	KhachHangEntity findByUserNameAndPasswdAndTrangThai(String userName, String passwd,int status);
	KhachHangEntity findByMaXacThucAndTrangThai(String maXacNhan,int status);

	KhachHangEntity findOneByUserNameAndTrangThai(String username, int trangThai);


}
