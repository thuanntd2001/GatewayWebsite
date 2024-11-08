package spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import spring.bean.MyUser;
import spring.entity.ChucVuEntity;
import spring.entity.KhachHangEntity;
import spring.entity.NhanVienEntity;
import spring.repository.KhachHangRepository;
import spring.repository.NhanVienRepository;

@Service(value = "userCustomService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private NhanVienRepository nvRepository;

	@Autowired
	private KhachHangRepository khRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		NhanVienEntity NhanVien = nvRepository.findOneByUserNameAndTrangThai(username, 1);
		
		KhachHangEntity KhachHang = khRepository.findOneByEmail(username);
		System.out.println("username");

		System.out.println(username);

		if (NhanVien != null) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			for (ChucVuEntity item : NhanVien.getChucVus()) {
				authorities.add(new SimpleGrantedAuthority("ROLE_" + item.getTenChucVu()));
			}
			MyUser myUserDetail = new MyUser(NhanVien.getUserName(), NhanVien.getPasswd(), chuyenDoiTrangThaiEnable(NhanVien.getTrangThai()), true, true,
					true, authorities);
			BeanUtils.copyProperties(NhanVien, myUserDetail);
			return myUserDetail;
		} 
		
		else if (KhachHang!=null) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			
				authorities.add(new SimpleGrantedAuthority("ROLE_" + "khachhang"));
			
			MyUser myUserDetail = new MyUser(KhachHang.getEmail(), KhachHang.getPasswd(), KhachHang.isEnable(), true, true,
					!KhachHang.isLocked(), authorities);
			BeanUtils.copyProperties(KhachHang, myUserDetail);
			return myUserDetail;

		}
		
		else {
			throw new UsernameNotFoundException("User not found");
		}
	}
	
	public boolean chuyenDoiTrangThaiLock(int trangThai) {
		if (trangThai==-1) return false;
		else return true;
	}
	public boolean chuyenDoiTrangThaiEnable(int trangThai) {
		if (trangThai==0) return false;
		else return true;
	}
}
