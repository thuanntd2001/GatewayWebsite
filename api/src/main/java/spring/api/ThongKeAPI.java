//package spring.api;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import spring.dto.DateDTO;
//import spring.dto.DDHDTO;
//import spring.dto.ThongKeDTO;
//import spring.entity.DDHEntity;
//import spring.repository.DDHRepository;
//
//@RestController
//public class ThongKeAPI {
//
//	@Autowired
//	DDHRepository ddhrepo;
//
//	@PostMapping(value = "/thongke")
//	public ThongKeDTO thongKe(HttpServletRequest request,@RequestBody DateDTO model) {
//		String flaglist = request.getParameter("flaglist");
//		List<DDHEntity> findHDEntity=null;
//		List<DDHDTO> hdDto=new ArrayList<DDHDTO>();
//		ThongKeDTO e = new ThongKeDTO();
//		System.out.println(model.getNam());
//
//		System.out.println(model.getThang());
//		System.out.println(model.getNgay());
//		try {
//			if (flaglist != null) {
//				if (model.getNgay()==-1) {
//					if (model.getThang() == -1)
//					{
//						findHDEntity=ddhrepo.getDDHNam(model.getNam());
//
//						
//					} else {
//						findHDEntity=ddhrepo.getDDHThang(model.getThang(),model.getNam());
//						
//						
//					}
//				} else {
//					findHDEntity=ddhrepo.getDDHNgay(model.getNgay(),model.getThang(),model.getNam());
//					
//				
//				}
//			
//				for (DDHEntity item: findHDEntity) {
//					hdDto.add(new DDHDTO(item));
//				}
//				
//				e.setDDHs(hdDto);
//			}
//			
//			else {
//				if (model.getNgay()==-1) {
//					if (model.getThang() == -1)
//					{
//						e.setDoanhThu(ddhrepo.doanhThuNam(model.getNam()));
//						e.setLoiNhuan(e.getDoanhThu()-e.getPhieuNhap());
//						e.setSoDDH(ddhrepo.soDDHNam(model.getNam()));
//					
//					} else {
//						e.setDoanhThu(ddhrepo.doanhThuThang(model.getThang(),model.getNam()));
//						e.setLoiNhuan(e.getDoanhThu()-e.getPhieuNhap());
//						e.setSoDDH(ddhrepo.soDDHThang(model.getThang(),model.getNam()));
//					}
//				} else {
////					System.out.println(pnrepo.tongPhieuNhapNgay(model.getNgay(),model.getThang(),model.getNam()));
//
//					e.setDoanhThu(ddhrepo.doanhThuNgay(model.getNgay(),model.getThang(),model.getNam()));
//					e.setLoiNhuan(e.getDoanhThu()-e.getPhieuNhap());
//					e.setSoDDH(ddhrepo.soDDHNgay(model.getNgay(),model.getThang(),model.getNam()));
//				}
//			}
//			
//			return e;
//			
//		}catch(
//
//	Exception ex)
//	{
//			ex.printStackTrace();
//		return new ThongKeDTO();
//	}
//}
//
//}
