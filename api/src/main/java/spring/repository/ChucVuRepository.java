package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.entity.ChucVuEntity;


@Repository
@Transactional(readOnly = true)
public interface ChucVuRepository extends JpaRepository<ChucVuEntity, Long>{

}
