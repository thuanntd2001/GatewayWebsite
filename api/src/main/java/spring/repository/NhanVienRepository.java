package spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.entity.NhanVienEntity;




@Repository
@Transactional(readOnly = true)
public interface NhanVienRepository extends JpaRepository<NhanVienEntity, Long>{
	@Query(
			  value = "SELECT * FROM nhanvien item WHERE TRANGTHAI = 1", 
			  nativeQuery = true)
	List<NhanVienEntity> findAllActive();
	NhanVienEntity findByUserNameAndPasswdAndTrangThai(String userName, String passwd,int status);
	NhanVienEntity findOneByUserNameAndTrangThai(String username, int trangThai);
	NhanVienEntity findOneByUserName(String username);


}
