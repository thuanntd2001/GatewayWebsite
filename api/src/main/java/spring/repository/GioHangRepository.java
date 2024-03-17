package spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.entity.GioHangEntity;




@Repository
@Transactional(readOnly = true)
public interface GioHangRepository extends JpaRepository<GioHangEntity, Long>{
	List<GioHangEntity> findByKhachHangMaKH(Long maKH);
}
