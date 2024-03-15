package spring.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.dto.NhanVienDTO;
import spring.entity.NhanVienEntity;
import spring.repository.ChucVuRepository;
import spring.repository.NhanVienRepository;

@RestController
public class NhanVienAPI {
	@Autowired
	NhanVienRepository repo;
	@Autowired
	ChucVuRepository cvrepo;

	@GetMapping("/nhanvien")
	public List<NhanVienDTO> getNhanVien() {
		List<NhanVienEntity> list = repo.findAllActive();
		List<NhanVienDTO> listDTO = new ArrayList<NhanVienDTO>();
		for (NhanVienEntity item : list) {
			NhanVienDTO e = new NhanVienDTO();
			e.setMaNV(item.getMaNV());
			e.setDiaChi(item.getDiaChi());
			e.setGioiTinh(item.getGioiTinh());
			e.setHoTen(item.getHoTen());
			e.setLuong(item.getLuong());
			e.setNgaySinh(item.getNgaySinh());
			e.setNgayVaoLam(item.getNgayVaoLam());
			e.setSdt(item.getSdt());
			e.setCmnd(item.getCmnd());
			e.setChucVuChinh(item.getChucVuChinh().getId());

			listDTO.add(e);
		}
		System.out.print(list.size());
		return listDTO;
	}

	@PostMapping(value = "/nhanvien")
	public String createNV(@RequestBody NhanVienDTO model) {

		NhanVienEntity save = new NhanVienEntity();
		NhanVienEntity check = null;
		try {
			save.setCmnd(model.getCmnd());
			save.setTrangThai(model.getTrangThai());
			save.setDiaChi(model.getDiaChi());
			save.setGioiTinh(model.isGioiTinh());
			save.setHoTen(model.getHoTen());
			save.setNgaySinh(model.getNgaySinh());
			save.setLuong(model.getLuong());
			save.setNgayVaoLam(model.getNgayVaoLam());
			save.setSdt(model.getSdt());
			
			if (model.getChucVuChinh()!=null)
				save.setChucVuChinh(cvrepo.getOne(model.getChucVuChinh()));


			check = repo.save(save);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print(model.getCmnd());
			System.out.print(model.getHoTen());
			return "01";
		}
		if (check == null) {

			return "02";
		}
		return "00";
	}

	@PutMapping(value = "/nhanvien")
	public String updateNV(@RequestBody NhanVienDTO model) {

		Optional<NhanVienEntity> nvoption = repo.findById(model.getMaNV());
		if (nvoption.isEmpty()) {

			System.out.print("ko tồn tại nv");
			return "404";
		}

		else {
			System.out.print("tồn tại nv");
			NhanVienEntity save = nvoption.get();
			NhanVienEntity check = null;
			try {

				save.setCmnd(model.getCmnd());
				save.setDiaChi(model.getDiaChi());
				save.setGioiTinh(model.isGioiTinh());
				save.setHoTen(model.getHoTen());
				save.setNgaySinh(model.getNgaySinh());
				save.setLuong(model.getLuong());
				save.setNgayVaoLam(model.getNgayVaoLam());
				save.setSdt(model.getSdt());
				save.setTrangThai(model.getTrangThai());
				if (model.getChucVuChinh()!=null)
					save.setChucVuChinh(cvrepo.getOne(model.getChucVuChinh()));
				check = repo.save(save);
			} catch (Exception e) {
				e.printStackTrace();
				return "01";
			}

			if (check == null) {
				return "02";
			}
			return "00";
		}

	}

	@DeleteMapping(value = "/nhanvien")
	public String deleteNV(@RequestBody NhanVienDTO ids) {
		Optional<NhanVienEntity> nvoption = repo.findById(ids.getMaNV());
		if (nvoption.isEmpty()) {

			System.out.print("ko tồn tại nv");
			return "404";
		}

		else {
			System.out.print("tồn tại nv");
			NhanVienEntity save = nvoption.get();
			NhanVienEntity check = null;
			try {

				save.setTrangThai(0);
				check = repo.save(save);

			} catch (Exception e) {
				e.printStackTrace();
				return "01";
			}

			if (check == null) {
				return "02";
			}
			return "00";
		}
	}

//	@PatchMapping(value = "/nhanvien")
//	public String themCV(@RequestBody ChucVuDTO ids) {
//		Optional<ChucVuEntity> option = cvrepo.findById(ids.getId());
//		if (option.isEmpty()) {
//
//			System.out.print("ko tồn tại cv");
//			return "404";
//		}
//
//		else {
//			System.out.print("tồn tại cv");
//			ChucVuEntity save = option.get();
//			ChucVuEntity check = null;
//			try {
//
//				save.setTrangThai(0);
//				check = repo.save(save);
//
//			} catch (Exception e) {
//				e.printStackTrace();
//				return "01";
//			}
//
//			if (check == null) {
//				return "02";
//			}
//			return "00";
//
//		}
//	}

}
