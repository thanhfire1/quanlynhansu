package QuanLyNhanSu;

public class NhanVienThuong extends NhanVien {
    private String maTruongPhong = null;

    public NhanVienThuong() {
        super();
        setLuongMotNgay(100);
    }

    @Override
    public void NhapThongTinNhanVien() {
        super.NhapThongTinNhanVien();
        nhapSoNgayLamViec();
        TinhLuong();
    }

    @Override
    public void XuatThongTinNhanVien() {
        System.out.printf("%-10s | %-20s | %-10s | %-10d | %-10.2f | %-10.2f\n", maSo, hoTen, soDienThoai, soNgayLamViec, luongMotNgay, TinhLuong());
    }

    public String getMaTruongPhong() {
        return maTruongPhong;
    }

    public void setMaTruongPhong(String maTruongPhong) {
        this.maTruongPhong = maTruongPhong;
    }
}