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

import spring.dto.SanPhamDTO;
import spring.entity.SanPhamEntity;
import spring.bean.ObjLong;
import spring.repository.NhanVienRepository;
import spring.repository.SanPhamRepository;

@RestController
public class SanPhamAPI {
	@Autowired
	SanPhamRepository repo;
	@Autowired
	NhanVienRepository nvRepo;
	


	@GetMapping("/sanpham")
	public List<SanPhamDTO> getSanPham() {
		List<SanPhamEntity> list = repo.findAllActive();
		List<SanPhamDTO> listDTO = new ArrayList<SanPhamDTO>();
		for (SanPhamEntity model: list) {
			SanPhamDTO save = new SanPhamDTO();
			
			save.setNvTao(model.getNvTao().getMaNV());

			save.setIcon(model.getIcon());
			save.setId(model.getId());
			save.setTen(model.getTen());
			save.setTrangThai(1);
			save.setMoTa(model.getMoTa());
			save.setCuocvc(model.getCuocvc());
			save.setDVVC(model.getDVVC());
			save.setEtd(model.getEtd());
			save.setLoai(model.getLoai());
			save.setNoiDen(model.getNoiDen());
			save.setNoiDi(model.getNoiDi());
			save.setNotePhiDen(model.getNotePhiDen());
			save.setNotePhiDi(model.getNotePhiDi());
			save.setPhiDenBl(model.getPhiDenBl());
			save.setPhiDenCMB(model.getPhiDenCMB());
			save.setPhiDenCont(model.getPhiDenCont());
			save.setPhiDenSet(model.getPhiDenSet());
			save.setPhiDiBl(model.getPhiDiBl());
			save.setPhiDiCMB(model.getPhiDiCMB());
			save.setPhiDiCont(model.getPhiDiCont());
			save.setPhiDiSet(model.getPhiDiSet());
			save.setTen(model.getTen());
			save.setTgvc(model.getTgvc());
			save.setTrangThai(model.getTrangThai());
	
			
			
			listDTO.add(save);
		}
		System.out.print(list.size());
		return listDTO;
	}

	@PostMapping(value = "/sanpham")
	public String createSP(@RequestBody SanPhamDTO model) {

		SanPhamEntity save = new SanPhamEntity();
		SanPhamEntity check = null;
		try {
			if (model.getNvTao() != null) {
				save.setNvTao(nvRepo.findById(model.getNvTao()).get());

			}

			save.setIcon(model.getIcon());
			save.setTen(model.getTen());
			save.setTrangThai(1);
			save.setMoTa(model.getMoTa());
			save.setCuocvc(model.getCuocvc());
			save.setDVVC(model.getDVVC());
			save.setEtd(model.getEtd());
			save.setLoai(model.getLoai());
			save.setNoiDen(model.getNoiDen());
			save.setNoiDi(model.getNoiDi());
			save.setNotePhiDen(model.getNotePhiDen());
			save.setNotePhiDi(model.getNotePhiDi());
			save.setPhiDenBl(model.getPhiDenBl());
			save.setPhiDenCMB(model.getPhiDenCMB());
			save.setPhiDenCont(model.getPhiDenCont());
			save.setPhiDenSet(model.getPhiDenSet());
			save.setPhiDiBl(model.getPhiDiBl());
			save.setPhiDiCMB(model.getPhiDiCMB());
			save.setPhiDiCont(model.getPhiDiCont());
			save.setPhiDiSet(model.getPhiDiSet());
			save.setTen(model.getTen());
			save.setTgvc(model.getTgvc());
			save.setTrangThai(model.getTrangThai());

			check = repo.save(save);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print(model.getTen());
		
			return "01";
		}
		if (check == null) {

			return "02";
		}
		return "00";
	}

	@PutMapping(value = "/sanpham")
	public String updateSP(@RequestBody SanPhamDTO model) {

		Optional<SanPhamEntity> nvoption = repo.findById(model.getId());
		if (nvoption.isEmpty()) {

			System.out.print("ko tồn tại sp");
			return "404";
		}

		else {
			System.out.print("tồn tại sp");
			SanPhamEntity save = nvoption.get();
			SanPhamEntity check = null;
			try {

				if (model.getNvTao() != null) {
					save.setNvTao(nvRepo.findById(model.getNvTao()).get());

				}

				save.setIcon(model.getIcon());
				save.setTen(model.getTen());
				save.setTrangThai(1);
				save.setMoTa(model.getMoTa());
				save.setCuocvc(model.getCuocvc());
				save.setDVVC(model.getDVVC());
				save.setEtd(model.getEtd());
				save.setLoai(model.getLoai());
				save.setNoiDen(model.getNoiDen());
				save.setNoiDi(model.getNoiDi());
				save.setNotePhiDen(model.getNotePhiDen());
				save.setNotePhiDi(model.getNotePhiDi());
				save.setPhiDenBl(model.getPhiDenBl());
				save.setPhiDenCMB(model.getPhiDenCMB());
				save.setPhiDenCont(model.getPhiDenCont());
				save.setPhiDenSet(model.getPhiDenSet());
				save.setPhiDiBl(model.getPhiDiBl());
				save.setPhiDiCMB(model.getPhiDiCMB());
				save.setPhiDiCont(model.getPhiDiCont());
				save.setPhiDiSet(model.getPhiDiSet());
				save.setTen(model.getTen());
				save.setTgvc(model.getTgvc());
				save.setTrangThai(model.getTrangThai());

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

	@DeleteMapping(value = "/sanpham")
	public String deleteSP(@RequestBody ObjLong ids) {
		Optional<SanPhamEntity> nvoption = repo.findById(ids.getObjLong());
		if (nvoption.isEmpty()) {

			System.out.print("ko tồn tại sp");
			return "404";
		}

		else {
			System.out.print("tồn tại sp");
			SanPhamEntity save = nvoption.get();
			SanPhamEntity check = null;
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

}
