package QuanLyNhanSu;

import java.util.ArrayList;

public class TruongPhong extends NhanVien {

    private int soLuongNhanVien = 0;
    private ArrayList<NhanVienThuong> danhSachNhanVien;

    public TruongPhong() {
        super();
        danhSachNhanVien = new ArrayList<>();
        setLuongMotNgay(200);
    }

    @Override
    public void NhapThongTinNhanVien() {
        super.NhapThongTinNhanVien();
        nhapSoNgayLamViec();
        TinhLuong();
    }

    @Override
    protected double TinhLuong() {
        return super.TinhLuong() + 100 * danhSachNhanVien.size();
    }

    public void TiepNhanNhanVien(NhanVienThuong nv) {
        danhSachNhanVien.add(nv);
        setSoLuongNhanVien(getDanhSachNhanVien().size());
    }

    public void LoaiBoNhanVien(NhanVienThuong nv) {
        danhSachNhanVien.remove(nv);
        setSoLuongNhanVien(getDanhSachNhanVien().size());
    }

    public ArrayList<NhanVienThuong> getDanhSachNhanVien() {
        return danhSachNhanVien;
    }

    public void setDanhSachNhanVien(ArrayList<NhanVienThuong> danhSachNhanVien) {
        this.danhSachNhanVien = danhSachNhanVien;
    }

    public int getSoLuongNhanVien() {
        return soLuongNhanVien;
    }

    public void setSoLuongNhanVien(int soLuongNhanVien) {
        this.soLuongNhanVien = soLuongNhanVien;
    }
}