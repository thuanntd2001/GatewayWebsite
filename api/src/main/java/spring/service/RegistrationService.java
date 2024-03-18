package spring.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.bean.EmailValidator;
import spring.bean.NoOpPasswordEncoder;
import spring.bean.itf.EmailSender;
import spring.dto.KhachHangDTO;
import spring.entity.ConfirmationTokenEntity;
import spring.entity.KhachHangEntity;
import spring.repository.KhachHangRepository;

@Service

public class RegistrationService {
	@Autowired
	private EmailValidator emailValidator;
	@Autowired
	private ConfirmationTokenService confirmationTokenService;
	@Autowired
	private EmailSender emailSender;

	@Autowired
	KhachHangRepository khrepo;

	public String register(KhachHangDTO request) {
		boolean isValidEmail = emailValidator.test(request.getEmail());

		if (!isValidEmail) {
			throw new IllegalStateException("email not valid");
		}

		String token = this.signUpUser(request);

		String link = "http://api.gatewayviet.com/api/v1/registration/confirm?token=" + token;
		emailSender.sendRegiter(request.getEmail(), buildRGEmail(request.getHoTen(), link));
		System.out.println(request.getEmail());

		return token;
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

	private String buildRGEmail(String name, String link) {
		return "<div style=\"font-family:Helvetica,Arial,sans-serif;font-size:16px;margin:0;color:#0b0c0c\">\n" + "\n"
				+ "<span style=\"display:none;font-size:1px;color:#fff;max-height:0\"></span>\n" + "\n"
				+ "  <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;min-width:100%;width:100%!important\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n"
				+ "    <tbody><tr>\n" + "      <td width=\"100%\" height=\"53\" bgcolor=\"#0b0c0c\">\n" + "        \n"
				+ "        <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;max-width:580px\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n"
				+ "          <tbody><tr>\n" + "            <td width=\"70\" bgcolor=\"#0b0c0c\" valign=\"middle\">\n"
				+ "                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n"
				+ "                  <tbody><tr>\n" + "                    <td style=\"padding-left:10px\">\n"
				+ "                  \n" + "                    </td>\n"
				+ "                    <td style=\"font-size:28px;line-height:1.315789474;Margin-top:4px;padding-left:10px\">\n"
				+ "                      <span style=\"font-family:Helvetica,Arial,sans-serif;font-weight:700;color:#ffffff;text-decoration:none;vertical-align:top;display:inline-block\">Confirm your email</span>\n"
				+ "                    </td>\n" + "                  </tr>\n" + "                </tbody></table>\n"
				+ "              </a>\n" + "            </td>\n" + "          </tr>\n" + "        </tbody></table>\n"
				+ "        \n" + "      </td>\n" + "    </tr>\n" + "  </tbody></table>\n"
				+ "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n"
				+ "    <tbody><tr>\n" + "      <td width=\"10\" height=\"10\" valign=\"middle\"></td>\n"
				+ "      <td>\n" + "        \n"
				+ "                <table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n"
				+ "                  <tbody><tr>\n"
				+ "                    <td bgcolor=\"#1D70B8\" width=\"100%\" height=\"10\"></td>\n"
				+ "                  </tr>\n" + "                </tbody></table>\n" + "        \n" + "      </td>\n"
				+ "      <td width=\"10\" valign=\"middle\" height=\"10\"></td>\n" + "    </tr>\n"
				+ "  </tbody></table>\n" + "\n" + "\n" + "\n"
				+ "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n"
				+ "    <tbody><tr>\n" + "      <td height=\"30\"><br></td>\n" + "    </tr>\n" + "    <tr>\n"
				+ "      <td width=\"10\" valign=\"middle\"><br></td>\n"
				+ "      <td style=\"font-family:Helvetica,Arial,sans-serif;font-size:19px;line-height:1.315789474;max-width:560px\">\n"
				+ "        \n"
				+ "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">Hi " + name
				+ ",</p><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> Thank you for registering at Gateway Logistics website. Please click on the below link to activate your account: </p><blockquote style=\"Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px\"><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> <a href=\""
				+ link + "\">Activate Now</a> </p></blockquote>\n Link will expire in 15 minutes. <p>See you soon</p>"
				+ "        \n" + "      </td>\n" + "      <td width=\"10\" valign=\"middle\"><br></td>\n"
				+ "    </tr>\n" + "    <tr>\n" + "      <td height=\"30\"><br></td>\n" + "    </tr>\n"
				+ "  </tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n" + "\n" + "</div></div>";
	}

	public String signUpUser(KhachHangDTO khachHang) {
		KhachHangEntity userExists = khrepo.findOneByEmail(khachHang.getEmail());

		if (userExists != null) {
			// TODO check of attributes are the same and
			// TODO if email not confirmed send confirmation email.

			throw new IllegalStateException("email already taken");
		}
		NoOpPasswordEncoder pwEncoder = new NoOpPasswordEncoder();
		String encodedPassword = pwEncoder.encode(khachHang.getPasswd());

		KhachHangEntity save = new KhachHangEntity();

		save.setTrangThai(1);
		save.setPasswd(encodedPassword);
		save.setEmail(khachHang.getEmail());

		save.setSdt(khachHang.getSdt());
		save.setHoTen(khachHang.getHoTen());

		save.setDiaChi(khachHang.getDiaChi());
		save.setGioiTinh(khachHang.getGioiTinh());
		save.setNgaySinh(khachHang.getNgaySinh());
		save.setIcon("logo.webp");
		save.setNgayDangKy(khachHang.getNgayDangKy());
		save.setEnable(true);
		save.setLocked(false);


		khrepo.save(save);

		String token = UUID.randomUUID().toString();

		ConfirmationTokenEntity confirmationToken = new ConfirmationTokenEntity(token, LocalDateTime.now(),
				LocalDateTime.now().plusMinutes(15), save);

		confirmationTokenService.saveConfirmationToken(confirmationToken);

//	        TODO: SEND EMAIL

		return token;

	}

	public int enableAppUser(String email) {
		return khrepo.enableAppUser(email);
	}
}
