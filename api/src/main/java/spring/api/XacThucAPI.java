package spring.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.bean.AuthToken;
import spring.config.TokenProvider;
import spring.dto.UserDTO;
import spring.entity.NhanVienEntity;
import spring.repository.NhanVienRepository;

@RestController
public class XacThucAPI {
	
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;
    

    
    @Autowired
    private NhanVienRepository nvrepo;

    @PostMapping("/authentication")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDTO.getUserName(),
                        userDTO.getPasswd()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        int mainRole = 4;
        
        NhanVienEntity nv= nvrepo.findOneByUserName(userDTO.getUserName());
        
        if (nv !=null) {
        	mainRole =  nv.getChucVuChinh().getId().intValue();
        }
        
 
        final String token = jwtTokenUtil.generateToken(authentication);
        
        
        return ResponseEntity.ok(new AuthToken(token,mainRole));
    }
}
