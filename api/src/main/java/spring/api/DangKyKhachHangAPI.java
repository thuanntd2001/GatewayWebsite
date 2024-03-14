package spring.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.entity.KhachHangEntity;
import spring.dto.ObjString;
import spring.repository.ChucVuRepository;
import spring.repository.KhachHangRepository;

@RestController
public class DangKyKhachHangAPI {
	@Autowired
	KhachHangRepository repo;
	@Autowired
	ChucVuRepository cvrepo;


	@PostMapping(value = "/userkh2")
	public String deleteNV(@RequestBody ObjString maXacNhan) {
		KhachHangEntity nvoption = repo.findByMaXacThucAndTrangThai(maXacNhan.getObjString(), 0);
		if (nvoption==null) {

			System.out.print("ko tồn tại code");
			return "404";
		}

		else {
			System.out.print("tồn tại code");
			KhachHangEntity check = null;
			try {

				nvoption.setTrangThai(1);
				check = repo.save(nvoption);

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
