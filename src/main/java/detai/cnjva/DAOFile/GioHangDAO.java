package detai.cnjva.DAOFile;

import java.sql.SQLException;
import java.util.ArrayList;

import detai.cnjva.modelFile.SanPham;

public class GioHangDAO {

	public ArrayList <SanPham> LayThongTinSanPhamTrongGioHang(ArrayList<SanPham> listgiohang) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
		SanPhamDAO  spDAO = new SanPhamDAO();
		ArrayList <SanPham> listsp = new ArrayList <SanPham>();
		for(SanPham spGH : listgiohang) {
			SanPham sp = spDAO.LaySanPhamTheoMa(spGH.getMaSanPham());
			sp.setSoLuong(spGH.getSoLuong());// Why
			listsp.add(sp);
		}
		return listsp;
	}
}
