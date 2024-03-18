package spring.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.bean.EmailValidator;
import spring.bean.itf.EmailSender;
import spring.dto.DDHDTO;
import spring.dto.KhachHangDTO;
import spring.dto.NhanVienDTO;
import spring.entity.ConfirmationTokenEntity;
import spring.repository.KhachHangRepository;

@Service

public class BookingEmailService {
	@Autowired
	private EmailValidator emailValidator;
	@Autowired
	private ConfirmationTokenService confirmationTokenService;
	@Autowired
	private EmailSender emailSender;
	

	@Autowired
	KhachHangRepository khrepo;

	public String booking(KhachHangDTO kh, DDHDTO bkg, NhanVienDTO nv) {
		boolean isValidEmail = emailValidator.test(kh.getEmail());

		if (!isValidEmail) {
			throw new IllegalStateException("email not valid");
		}


		emailSender.sendNM(nv.getEmail(), buildSalesBkgEmail("",kh,bkg), "Someone Order on web");
		emailSender.sendNM(kh.getEmail(), buildKHBGKEmail("",kh,bkg), "Thank you for order on Gateway website");


		return "Sent Email to Client and Sales";
	}

	@Transactional
	public String confirmToken(String token) {
		ConfirmationTokenEntity confirmationToken = confirmationTokenService.getToken(token)
				.orElseThrow(() -> new IllegalStateException("token not found"));

		if (confirmationToken.getConfirmedAt() != null) {
			throw new IllegalStateException("email already confirmed");
		}

		LocalDateTime expiredAt = confirmationToken.getExpiresAt();

		if (expiredAt.isBefore(LocalDateTime.now())) {
			throw new IllegalStateException("token expired");
		}

		confirmationTokenService.setConfirmedAt(token);
		this.enableAppUser(confirmationToken.getKhachHangEntity().getEmail());
		return "confirmed";
	}

	private String buildSalesBkgEmail(String name,  KhachHangDTO kh, DDHDTO bkg) {
		return "Hi SALES " + name
				+ "\n Khack hang: "
				+ kh.toString()
				+ "\n da book sp "
	
				+ " voi booking: "
				+ bkg.toString()
				+ "\n Hay xem xet xac nhan ";

		
	
	}
	
	private String buildKHBGKEmail(String name, KhachHangDTO kh, DDHDTO bkg) {
		return "Hi " + name
				+ "\n Ban da book sp: "
				+ bkg.toString()
				+ "\n Cam on ban da dat hang, ban se nhan duoc lien he som ";

		
	
	}



	public int enableAppUser(String email) {
		return khrepo.enableAppUser(email);
	}
}
