package spring.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.dto.KhachHangDTO;
import spring.dto.LoginKHDTO;
import spring.entity.KhachHangEntity;
import spring.repository.KhachHangRepository;

@RestController
public class KhachHangAPI {
	@Autowired
	KhachHangRepository repo;

	@GetMapping("/khachhang")
	public List<KhachHangDTO> getKhachHang() {
		List<KhachHangEntity> list = repo.findAllActive();
		List<KhachHangDTO> listDTO = new ArrayList<KhachHangDTO>();
		for (KhachHangEntity item : list) {
			KhachHangDTO e = new KhachHangDTO();
			e.setMaKH(item.getMaKH());
			e.setDiaChi(item.getDiaChi());
			e.setGioiTinh(item.getGioiTinh());
			e.setNgaySinh(item.getNgaySinh());
			e.setSdt(item.getSdt());
			e.setEmail(item.getEmail());
			e.setHoTen(item.getHoTen());


			listDTO.add(e);
		}
		System.out.print(list.size());
		return listDTO;
	}

	@PostMapping(value = "/khachhang")
	public String createKH(@RequestBody LoginKHDTO model) {

		KhachHangEntity save = new KhachHangEntity();
		KhachHangEntity check = null;
		try {
			save.setTrangThai(model.getTrangThai());
			save.setDiaChi(model.getDiaChi());
			save.setGioiTinh(model.getGioiTinh());
			save.setHoTen(model.getHoTen());
			save.setNgaySinh(model.getNgaySinh());
			save.setSdt(model.getSdt());
			save.setEmail(model.getEmail());
			save.setPasswd(model.getPasswd());
			save.setIcon("logo.webp");
			save.setNgayDangKy(model.getNgayDangKy());

			check = repo.save(save);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print(model.getHoTen());
			return "01";
		}
		if (check == null) {

			return "02";
		}

		else {
			return "00";
		}

	}

	@PutMapping(value = "/khachhang")
	public String updateKH(@RequestBody LoginKHDTO model) {

		Optional<KhachHangEntity> khoption = repo.findById(model.getMaKH());
		if (khoption.isEmpty()) {

			System.out.print("ko tồn tại kh");
			return "404";
		}

		else {
			System.out.print("tồn tại kh");
			KhachHangEntity save = khoption.get();
			KhachHangEntity check = null;
			try {

				save.setDiaChi(model.getDiaChi());
				save.setGioiTinh(model.getGioiTinh());
				save.setHoTen(model.getHoTen());
				save.setNgaySinh(model.getNgaySinh());
				save.setSdt(model.getSdt());
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

	@PutMapping(value = "/khachhang2")
	public String updateKH2(@RequestBody LoginKHDTO model) {

		Optional<KhachHangEntity> khoption = repo.findById(model.getMaKH());
		if (khoption.isEmpty()) {

			System.out.print("ko tồn tại kh");
			return "404";
		}

		else {
			System.out.print("tồn tại kh");
			KhachHangEntity save = khoption.get();
			KhachHangEntity check = null;
			try {

				save.setDiaChi(model.getDiaChi());
				save.setGioiTinh(model.getGioiTinh());
				save.setHoTen(model.getHoTen());
				save.setSdt(model.getSdt());
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

	@PatchMapping(value = "/khachhang")
	public String deleteKH(@RequestBody KhachHangDTO ids) {
		Optional<KhachHangEntity> khoption = repo.findById(ids.getMaKH());
		if (khoption.isEmpty()) {

			System.out.print("ko tồn tại kh");
			return "404";
		}

		else {
			System.out.print("tồn tại kh");
			KhachHangEntity save = khoption.get();
			KhachHangEntity check = null;
			try {

				save.setTrangThai(1);
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
