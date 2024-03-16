package spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import spring.entity.KhachHangEntity;





public interface KhachHangRepository extends JpaRepository<KhachHangEntity, Long>{
	@Query(
			  value = "SELECT * FROM khachhang item WHERE TRANGTHAI = 1", 
			  nativeQuery = true)
	List<KhachHangEntity> findAllActive();

	KhachHangEntity findByEmailAndPasswdAndTrangThai(String userName, String passwd,int status);

	KhachHangEntity findOneByEmailAndTrangThai(String username, int trangThai);

	KhachHangEntity findOneByEmail(String email) ;
	
    @Transactional
    @Modifying
    @Query("UPDATE KhachHangEntity a " +
            "SET a.TrangThai = 2 WHERE a.email = ?1")
    int enableAppUser(String email);


}
