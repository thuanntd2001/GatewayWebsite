package spring.dto;

public class GioHangDTO {

	
		private Long Id;
		

		private Long maKH;


		private Long MaSP;
		
		
		private Integer soLuong;

		

		public Long getId() {
			return Id;
		}

		public void setId(Long id) {
			Id = id;
		}

		public Long getMaKH() {
			return maKH;
		}

		public void setMaKH(Long maKH) {
			this.maKH = maKH;
		}

		public Long getMaSP() {
			return MaSP;
		}

		public void setMaSP(Long maSP) {
			MaSP = maSP;
		}

		public Integer getSoLuong() {
			return soLuong;
		}

		public void setSoLuong(Integer soLuong) {
			this.soLuong = soLuong;
		}

	
}
