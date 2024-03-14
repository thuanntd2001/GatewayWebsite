package spring.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.dto.LoginDTO;
import spring.entity.NhanVienEntity;
import spring.repository.NhanVienRepository;

@RestController
public class LoginAPI {

	@Autowired
	NhanVienRepository nvrepo;


	@PostMapping(value = "/login")
	public LoginDTO checkUserNameAndPass(@RequestBody LoginDTO model) {

	
		NhanVienEntity user = nvrepo.findByUserNameAndPasswdAndTrangThai(model.getUserName(),model.getPasswd(),1);
		if (user==null) {
		return null;
		}
		else {
			
			LoginDTO e=new LoginDTO();
			e.setMaNV(user.getMaNV());
			e.setDiaChi(user.getDiaChi());
			e.setGioiTinh(user.getGioiTinh());
			e.setHoTen(user.getHoTen());
			e.setLuong(user.getLuong());
			e.setNgaySinh(user.getNgaySinh());
			e.setNgayVaoLam(user.getNgayVaoLam());
			e.setSdt(user.getSdt());
			e.setCmnd(user.getCmnd());
			e.setEmail(user.getEmail());
			e.setIcon(user.getIcon());
			e.setID(user.getUsernv().getMaNV());
			e.setPasswd(user.getPasswd());
			e.setRoleID(user.getChucVus().get(0).getId());
			e.setUserName(user.getUserName());
			e.setTrangThai(user.getTrangThai());
			
			return e;
		}
	}

	

}
