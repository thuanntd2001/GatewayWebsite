package spring.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.dto.KhachHangDTO;
import spring.dto.LoginKHDTO;
import spring.entity.KhachHangEntity;
import spring.repository.KhachHangRepository;

@RestController
public class LoginKHAPI {

	@Autowired
	KhachHangRepository khrepo;


	@PostMapping(value = "/loginkh")
	public LoginKHDTO checkUserNameAndPass(@RequestBody KhachHangDTO model) {

	
		KhachHangEntity user = khrepo.findByEmailAndPasswdAndTrangThai(model.getEmail(),model.getPasswd(),1);
		if (user==null) {
		return null;
		}
		else {
			
			LoginKHDTO e=new LoginKHDTO();
			e.setMaKH(user.getMaKH());
			e.setDiaChi(user.getDiaChi());
			e.setGioiTinh(user.getGioiTinh());
			e.setHoTen(user.getHoTen());
			e.setNgaySinh(user.getNgaySinh());
			e.setSdt(user.getSdt());
			e.setEmail(user.getEmail());
			e.setIcon(user.getIcon());
			e.setPasswd(user.getPasswd());
			e.setTrangThai(user.getTrangThai());
			return e;
		}
	}
	
	

	

}
