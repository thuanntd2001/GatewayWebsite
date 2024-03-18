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

import spring.dto.DDHDTO;
import spring.dto.KhachHangDTO;
import spring.dto.NhanVienDTO;
import spring.entity.DDHEntity;
import spring.bean.ObjLong;
import spring.repository.DDHRepository;
import spring.repository.KhachHangRepository;
import spring.repository.NhanVienRepository;
import spring.repository.SanPhamRepository;
import spring.service.BookingEmailService;

@RestController
public class DDHAPI {
	@Autowired
	DDHRepository repo;
	@Autowired
	NhanVienRepository nvRepo;
	@Autowired
	KhachHangRepository khRepo;
	@Autowired
	SanPhamRepository spRepo;
	
	@Autowired
	BookingEmailService bkgEmailService;

	@GetMapping("/ddh")
	public List<DDHDTO> getDDH() {

		List<DDHEntity> list = repo.findByOrderByIdDesc();
		List<DDHDTO> listDTO = new ArrayList<DDHDTO>();
		for (DDHEntity model : list) {
			DDHDTO save = new DDHDTO();
			if (model.getKhThucHien() != null)
				save.setKhThucHien(model.getKhThucHien().getMaKH());
			if (model.getNvThucHien() != null)
				save.setNvThucHien(model.getNvThucHien().getMaNV());
			save.setNgayThucHien(model.getNgayThucHien());
			save.setId(model.getId());
			save.setTinhTrang(model.getTinhTrang());
			save.setDkgh(model.getDkgh());
			save.setDknh(model.getDknh());
			save.setIsfcl(model.getIsfcl());
			save.setLuuY(model.getMoTaHH());
			save.setMoTaHH(model.getMoTaHH());
			save.setNhomHang(model.getNhomHang());
			save.setTgkh(model.getTgkh());
			save.setSanPham(model.getSanPham().getTen());
			save.setSanPhamId(model.getSanPham().getId());
			

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
			if (model.getKhThucHien() != null)
				save.setKhThucHien(khRepo.findById(model.getKhThucHien()).get());
			if (model.getNvThucHien() != null) 
				save.setNvThucHien(nvRepo.findById(model.getNvThucHien()).get());
			if (model.getSanPhamId() != null) 
				save.setSanPham(spRepo.findById(model.getSanPhamId()).get());
			save.setNgayThucHien(model.getNgayThucHien());
			save.setTinhTrang(model.getTinhTrang());
			
			save.setDkgh(model.getDkgh());
			save.setDknh(model.getDknh());
			save.setIsfcl(model.getIsfcl());
			save.setLuuY(model.getMoTaHH());
			save.setMoTaHH(model.getMoTaHH());
			save.setNhomHang(model.getNhomHang());
			save.setTgkh(model.getTgkh());
			
			
			check = repo.save(save);
		} catch (Exception e) {
			e.printStackTrace();

			return "01";
		}
		if (check == null) {

			return "02";
		} else {
			
			KhachHangDTO kh = new KhachHangDTO(save.getKhThucHien());
			NhanVienDTO nv = new NhanVienDTO(save.getNvThucHien());
			bkgEmailService.booking(kh, model, nv);
			
			String flag = "00";
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

				if (model.getKhThucHien() != null)
					save.setKhThucHien(khRepo.findById(model.getKhThucHien()).get());
				if (model.getNvThucHien() != null) 
					save.setNvThucHien(nvRepo.findById(model.getNvThucHien()).get());
				save.setNgayThucHien(model.getNgayThucHien());
				save.setTinhTrang(model.getTinhTrang());
				
				save.setDkgh(model.getDkgh());
				save.setDknh(model.getDknh());
				save.setIsfcl(model.getIsfcl());
				save.setLuuY(model.getMoTaHH());
				save.setMoTaHH(model.getMoTaHH());
				save.setNhomHang(model.getNhomHang());
				save.setTgkh(model.getTgkh());

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
