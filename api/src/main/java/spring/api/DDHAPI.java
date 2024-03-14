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

import spring.config.Collector;
import spring.dto.CTDDHDTO;
import spring.dto.DDHDTO;
import spring.entity.DDHEntity;
import spring.dto.ObjLong;
import spring.repository.DDHRepository;
import spring.repository.KhachHangRepository;
import spring.repository.NhanVienRepository;

@RestController
public class DDHAPI {
	@Autowired
	DDHRepository repo;
	@Autowired
	NhanVienRepository nvRepo;
	@Autowired
	KhachHangRepository khRepo;

	@GetMapping("/ddh")
	public List<DDHDTO> getDDH() {

		List<DDHEntity> list = repo.findByOrderByIdDesc();
		List<DDHDTO> listDTO = new ArrayList<DDHDTO>();
		for (DDHEntity model : list) {
			DDHDTO save = new DDHDTO();
			save.setId(model.getId());
			save.setKhThucHien(model.getKhThucHien().getMaKH());
			save.setNgayThucHien(model.getNgayThucHien());
			System.out.println(model.getNvThucHien());
			if (model.getNvThucHien() != null)
				save.setNvThucHien(model.getNvThucHien().getMaNV());
			save.setTinhTrang(model.getTinhTrang());

			listDTO.add(save);
		}
		System.out.print(list.size());
		return listDTO;
	}

	@PostMapping(value = "/ddh")
	public String createDDH(@RequestBody DDHDTO model) {

		DDHEntity save = new DDHEntity();
		DDHEntity check = null;
		try {
			save.setKhThucHien(khRepo.findById(model.getKhThucHien()).get());
			save.setNgayThucHien(model.getNgayThucHien());
			if (model.getNvThucHien() != null) {
				save.setNvThucHien(nvRepo.findById(model.getNvThucHien()).get());

			}
			save.setTinhTrang(model.getTinhTrang());
			check = repo.save(save);
		} catch (Exception e) {
			e.printStackTrace();

			return "01";
		}
		if (check == null) {

			return "02";
		} else {
			String flag = "00";
			for (CTDDHDTO item : model.getCtddhs()) {
				item.setDdh(check.getId());
				item.setId(0l);
				flag = Collector.postMess("/ctddh", item);
			}

			return flag;
		}
	}

	@PutMapping(value = "/ddh")
	public String updateDDH(@RequestBody DDHDTO model) {

		Optional<DDHEntity> nvoption = repo.findById(model.getId());
		if (nvoption.isEmpty()) {

			System.out.print("ko tồn tại sp");
			return "404";
		}

		else {
			System.out.print("tồn tại sp");
			DDHEntity save = nvoption.get();
			DDHEntity check = null;
			try {

				save.setId(model.getId());

				save.setKhThucHien(khRepo.findById(model.getKhThucHien()).get());
				save.setNgayThucHien(model.getNgayThucHien());
				if (model.getNvThucHien() != null) {

					save.setNvThucHien(nvRepo.findById(model.getNvThucHien()).get());
				}
				save.setTinhTrang(model.getTinhTrang());
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

	@DeleteMapping(value = "/ddh")
	public String delete(@RequestBody ObjLong ids) {
		Optional<DDHEntity> option = repo.findById(ids.getObjLong());
		if (option.isEmpty()) {

			System.out.print("ko tồn tại");
			return "404";
		} else {
			System.out.print("tồn tại");

			try {

				repo.deleteById(ids.getObjLong());
			} catch (Exception e) {
				e.printStackTrace();
				return "02";
			}

			return "00";
		}
	}

}
