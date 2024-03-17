package spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.entity.SanPhamEntity;




@Repository
@Transactional(readOnly = true)
public interface SanPhamRepository extends JpaRepository<SanPhamEntity, Long>{
	@Query(
			  value = "SELECT * FROM sanpham item WHERE TRANGTHAI = 1", 
			  nativeQuery = true)
	List<SanPhamEntity> findAllActive();

}
