package spring.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.dto.GioHangDTO;
import spring.entity.GioHangEntity;
import spring.dto.ObjLong;
import spring.repository.GioHangRepository;
import spring.repository.KhachHangRepository;
import spring.repository.SanPhamRepository;

@RestController
public class GioHangAPI {
	@Autowired
	GioHangRepository repo;
	@Autowired
	SanPhamRepository sanPhamRepo;
	@Autowired
	KhachHangRepository KHRepo;

	@GetMapping("/giohang")
	public List<GioHangDTO> getGioHang(HttpServletRequest request) {
		String idkh = request.getParameter("makh");
		long id;
		if (idkh == null) {
			System.out.print("null");

			return new ArrayList<GioHangDTO>();
		}

		else {
			try {
				id = Long.parseLong(idkh);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			List<GioHangEntity> list = repo.findByKhachHangMaKH(id);
			List<GioHangDTO> listDTO = new ArrayList<GioHangDTO>();
			for (GioHangEntity model : list) {
				GioHangDTO save = new GioHangDTO();
				save.setId(model.getId());
				save.setMaKH(id);
				save.setMaSP(model.getSp().getId());
				save.setSoLuong(model.getSoLuong());

				listDTO.add(save);
			}
			System.out.print(list.size());
			return listDTO;
		}
	}

	@GetMapping("/slgiohang")
	public ObjLong getSLGioHang(HttpServletRequest request) {
		ObjLong sl = new ObjLong();
		String idkh = request.getParameter("makh");
		long id=0;
		if (idkh == null) {
			System.out.print("null");

			sl.setObjLong(0);
		}

		else {
			try {
				id = Long.parseLong(idkh);
				List<GioHangEntity> list = repo.findByKhachHangMaKH(id);
				sl.setObjLong(list.size());

			} catch (Exception e) {
				e.printStackTrace();
				sl.setObjLong(0);
			}

		}
		return sl;
	}

	@PostMapping(value = "/giohang")
	public String createGioHang(@RequestBody GioHangDTO model) {

		GioHangEntity save = new GioHangEntity();
		GioHangEntity check = null;
		try {
			save.setKhachHang(KHRepo.findById(model.getMaKH()).get());
			save.setSp(sanPhamRepo.findById(model.getMaSP()).get());
			save.setSoLuong(model.getSoLuong());

			check = repo.save(save);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print(model.getMaKH());

			return "01";
		}
		if (check == null) {

			return "02";
		}
		return "00";
	}

	@PutMapping(value = "/giohang")
	public String updateGioHang(@RequestBody GioHangDTO model) {

		Optional<GioHangEntity> nvoption = repo.findById(model.getId());
		if (nvoption.isEmpty()) {

			System.out.print("ko tồn tại sp");
			return "404";
		}

		else {
			System.out.print("tồn tại sp");
			GioHangEntity save = nvoption.get();
			GioHangEntity check = null;
			try {

				save.setId(model.getId());
				save.setKhachHang(KHRepo.findById(model.getMaKH()).get());
				save.setSp(sanPhamRepo.findById(model.getMaSP()).get());
				save.setSoLuong(model.getSoLuong());
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

	@DeleteMapping(value = "/giohang")
	public String delete(@RequestBody ObjLong ids) {
		Optional<GioHangEntity> option = repo.findById(ids.getObjLong());
		if (option.isEmpty()) {

			System.out.print("ko tồn tại ");
			System.out.println(ids.getObjLong());

//			try {
//
//				repo.deleteById(ids.getObjLong());
//			} catch (Exception e) {
//				e.printStackTrace();
//				return "02";
//			}

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
