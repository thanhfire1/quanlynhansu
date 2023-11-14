package QuanLyNhanSu;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CongTy {
    private static final Scanner scanner = new Scanner(System.in);
    private static final KiemTraDieuKien kt = new KiemTraDieuKien();
    private String tenCongTy;
    private String maSoThue;
    private double doanhThuThang = 100000;
    private List<NhanVien> dsNhanVien;

    public CongTy() {
        dsNhanVien = new ArrayList<>();
    }

    // Chuc nang 1: Nhap thong tin cong ty.
    public void NhapThongTinCongTy() {
        NhapTenCongTy();
        NhapMaSoThue();
        NhapDoanhThuThang();
    }

    private void NhapTenCongTy() {
        System.out.println("Nhap ten cong ty: ");
        String tenCT = scanner.nextLine();
        while(true)
            if(kt.KiemTraChuoiRong(tenCT)) break;
            else tenCT = scanner.nextLine();
        setTenCongTy(tenCT);
    }

    private void NhapMaSoThue() {
        System.out.println("Nhap ma so thue: ");
        String maSoThue = scanner.nextLine();
        while(true)
            if(kt.KiemTraChieuDaiChuoi(maSoThue, 10) && kt.KiemTraChuoiSo(maSoThue)) break;
            else maSoThue = scanner.nextLine();
        setMaSoThue(maSoThue);
    }

    private void NhapDoanhThuThang() {
        System.out.println("Nhap doanh thu thang: ");
        double doanhThuThang = Double.parseDouble(scanner.nextLine());
        while(true)
            if(kt.KiemTraLaSoDuong(doanhThuThang)) break;
            else doanhThuThang = Double.parseDouble(scanner.nextLine());
        setDoanhThuThang(doanhThuThang);
    }

    public void XuatThongTinCongTy() {
        System.out.printf("%-20s | %-20s | %-20s\n", "Ten cong ty", "Ma so thue", "Doanh thu thang");
        System.out.printf("%-20s | %-20s | %-20.2f", tenCongTy, maSoThue, doanhThuThang);
    }

    // Chuc nang 2: Phan bo nhan vien vao truong phong.
    public void PhanBoNhanVienVaoTruongPhong() {
        DSNhanVienChuaCoTruongPhong();
        System.out.println("Nhan ma nhan vien thuong can phan bo: ");
        String maNVThuong = scanner.nextLine();
        NhanVienThuong nvtTimDuoc = (NhanVienThuong) TimNVThuongTheoMa(maNVThuong);
        if(nvtTimDuoc == null) {
            System.out.println("Khong tim thay nhan vien thuong co ma la " + maNVThuong);
        } else {
            DSTruongPhong();
            System.out.println("Nhap ma truong phong tiep nhan: ");
            String maTrP = scanner.nextLine();
            TruongPhong trPTimDuoc = (TruongPhong) TimTruongPhongTheoMa(maTrP);
            if(trPTimDuoc == null) {
                System.out.println("Khong tim thay truong phong co ma la " + maTrP);
            } else {
                nvtTimDuoc.setMaTruongPhong(maTrP);
                trPTimDuoc.TiepNhanNhanVien(nvtTimDuoc);
            }
        }

    }

    private void DSNhanVienChuaCoTruongPhong() {
        System.out.println("DANH SACH NHAN VIEN THUONG");
        System.out.printf("%-10s | %-20s | %-10s | %-10s\n", "Ma So", "Ho Ten", "SDT", "Ma TrPh");
        for (NhanVien nv: dsNhanVien)
            if(nv instanceof NhanVienThuong)
                System.out.printf("%-10s | %-20s | %-10s | %-10s\n", nv.getMaSo(), nv.getHoTen(), nv.getSoDienThoai(), ((NhanVienThuong) nv).getMaTruongPhong());
    }

    private void DSTruongPhong() {
        System.out.println("DANH SACH TRUONG PHONG");
        System.out.printf("%-10s | %-20s | %-10s\n", "Ma So", "Ho Ten", "SDT");
        for (NhanVien nv: dsNhanVien)
            if(nv instanceof TruongPhong)
                System.out.printf("%-10s | %-20s | %-10s\n", nv.getMaSo(), nv.getHoTen(), nv.getSoDienThoai());
    }

    private NhanVien TimNVThuongTheoMa(String maNV) {
        for (NhanVien nv: dsNhanVien)
            if(nv instanceof NhanVienThuong && nv.getMaSo().equalsIgnoreCase(maNV))
                return nv;
        return null;
    }

    private NhanVien TimTruongPhongTheoMa(String maNV) {
        for (NhanVien nv: dsNhanVien)
            if(nv instanceof TruongPhong && nv.getMaSo().equalsIgnoreCase(maNV))
                return nv;
        return null;
    }

    // Chuc nang 3: them nhan su
    public void ThemMotNhanSu() {
        NhanVien nvThem;
        int luaChon;
            MenuLuaChonLoaiNhanVien();
            luaChon = Integer.parseInt(scanner.nextLine());
            switch (luaChon) {
                case 1:
                    nvThem = new NhanVienThuong();
                    ((NhanVienThuong)nvThem).NhapThongTinNhanVien();
                    if(KiemTraNhanVienTonTai(nvThem))
                        System.out.println("Nhan vien co ma " + nvThem.getMaSo() + " da ton tai.");
                    else
                        dsNhanVien.add(nvThem);
                    break;
                case 2:
                    nvThem = new TruongPhong();
                    ((TruongPhong)nvThem).NhapThongTinNhanVien();
                    if(KiemTraNhanVienTonTai(nvThem))
                        System.out.println("Nhan vien co ma " + nvThem.getMaSo() + " da ton tai.");
                    else
                        dsNhanVien.add(nvThem);
                    break;
                case 3:
                    nvThem = new GiamDoc();
                    ((GiamDoc)nvThem).NhapThongTinNhanVien();
                    if(KiemTraNhanVienTonTai(nvThem))
                        System.out.println("Nhan vien co ma " + nvThem.getMaSo() + " da ton tai.");
                    else
                        dsNhanVien.add(nvThem);
                    break;
                default:
                    System.out.println("Khong co loai nhan vien ban lua chon.");
                    break;
            }
    }

    private void MenuLuaChonLoaiNhanVien() {
        System.out.println("Lua chon loai nhan vien muon them");
        System.out.println("1. Nhan vien thuong.");
        System.out.println("2. Truong phong.");
        System.out.println("3. Giam doc");
        System.out.println("Nhap lua chon: ");
    }

    private boolean KiemTraNhanVienTonTai(NhanVien nvKT) {
        for (NhanVien nv: dsNhanVien)
            if(nv.getMaSo().equalsIgnoreCase(nvKT.getMaSo()))
                return true;
        return false;
    }

    // Chuc nang 4: Xoa nhan su
    public void XoaNhanSu() {
        System.out.println("Nhap ma so nhan su can xoa");
        String maSoXoa = scanner.nextLine();
        NhanVien nvXoa = TimNhanVienTheoMa(maSoXoa);
        if(nvXoa == null) {
            System.out.println("Khong tim thay nhan su co ma " + maSoXoa);
        } else {
            if(nvXoa instanceof TruongPhong) {
                XoaTruongPhong((TruongPhong) nvXoa);
            } else if (nvXoa instanceof NhanVienThuong) {
                XoaNhanVienThuong((NhanVienThuong) nvXoa);
            } else {
                XoaGiamDoc((GiamDoc) nvXoa);
            }
        }
    }

    private NhanVien TimNhanVienTheoMa(String maNV) {
        for (NhanVien nv: dsNhanVien)
            if(nv.getMaSo().equalsIgnoreCase(maNV))
                return nv;
        return null;
    }

    private void XoaTruongPhong(TruongPhong truongPhong) {
            for (NhanVien nv: dsNhanVien)
                if(nv instanceof NhanVienThuong && ((NhanVienThuong) nv).getMaTruongPhong() != null && ((NhanVienThuong) nv).getMaTruongPhong().equalsIgnoreCase(truongPhong.getMaSo()))
                    ((NhanVienThuong) nv).setMaTruongPhong(null);
        dsNhanVien.remove(truongPhong);
    }

    private void XoaNhanVienThuong(NhanVienThuong nhanVienThuong) {
        if(nhanVienThuong.getMaTruongPhong() != null) {
            TruongPhong truongPhongQL = (TruongPhong) TimTruongPhongTheoMa(nhanVienThuong.getMaTruongPhong());
            if (truongPhongQL != null)
                truongPhongQL.LoaiBoNhanVien(nhanVienThuong);
        }
        dsNhanVien.remove(nhanVienThuong);
    }

    private void XoaGiamDoc(GiamDoc giamDoc) {
        dsNhanVien.remove(giamDoc);
    }

    // Chuc nang 5: Xuat thong tin toan bo nhan su trong cong ty.
    public void XuatThongTinToanNhanVien() {
        System.out.printf("%-10s | %-20s | %-10s | %-10s | %-10s | %-10s\n", "Ma So", "Ho Ten", "SDT", "So Ngay", "Luong CB", "Luong Thang");
        for (NhanVien nv: dsNhanVien) {
            nv.XuatThongTinNhanVien();
        }
    }

    // Chuc nang 6: Tinh va xuat tong luong cho toan cong ty
    public double TongLuongToanCongTy() {
        double tongLuongCT = 0;
        for (NhanVien nv: dsNhanVien)
            tongLuongCT += nv.TinhLuong();
        return tongLuongCT;
    }

    // Chuc nang 7: Tim nhan vien thuong co luong cao nhat
    public void NhanVienThuongCoLuongCaoNhat() {
        System.out.printf("%-10s | %-20s | %-10s | %-10s | %-10s | %-10s\n", "Ma So", "Ho Ten", "SDT", "So Ngay", "Luong CB", "Thuc Lanh");
        for (NhanVien nv: dsNhanVien)
            if(nv instanceof NhanVienThuong && ((NhanVienThuong)nv).TinhLuong() == luongNhanVienThuongCaoNhat())
                nv.XuatThongTinNhanVien();
        System.out.println("Nhan vien thuong co luong cao nhat la:" + luongNhanVienThuongCaoNhat());
    }

    private Double luongNhanVienThuongCaoNhat() {
        double luongNVTCaoNhat = 0;
        for (NhanVien nv: dsNhanVien)
            if(nv instanceof NhanVienThuong && ((NhanVienThuong)nv).TinhLuong() > luongNVTCaoNhat)
                luongNVTCaoNhat = nv.TinhLuong();
        return luongNVTCaoNhat;
    }

    // Chuc nang 8: Tim truong phong co so luong nhan vien duoi quyen nhieu nhat
    public void TruongPhongCoNhieuNhanVienNhat() {
        System.out.printf("%-10s | %-20s | %-10s | %-10s | %-10s | %-10s\n", "Ma So", "Ho Ten", "SDT", "So Ngay", "Luong CB", "Thuc Lanh");
        for (NhanVien nv: dsNhanVien)
            if(nv instanceof TruongPhong && ((TruongPhong)nv).getSoLuongNhanVien() == soLuongNhanVienDuoiQuyenNhieuNhat())
                nv.XuatThongTinNhanVien();
        System.out.println("So luong nhan vien duoi quyen nhieu nhat la: " + soLuongNhanVienDuoiQuyenNhieuNhat());
    }

    private int soLuongNhanVienDuoiQuyenNhieuNhat() {
        int soLuongNhieuNhat = 0;
        for (NhanVien nv: dsNhanVien)
            if(nv instanceof TruongPhong && ((TruongPhong) nv).getSoLuongNhanVien() > soLuongNhieuNhat)
                soLuongNhieuNhat = ((TruongPhong) nv).getSoLuongNhanVien();
        return soLuongNhieuNhat;
    }

    // Chuc nang 9: Sap xep nhan vien toan cong ty theo ten.
    public void SapXepNhanVienTheoTen() {
        Collections.sort(dsNhanVien, (nv1, nv2) -> nv1.LayTenNhanVien().compareTo(nv2.LayTenNhanVien()));
        XuatThongTinToanNhanVien();
    }

    // Chuc nang 10: Sap xep nhan vien toan cong ty giam dan theo luong
    public void SapXeoNhanVienGiamDanTheoLuong() {
        Collections.sort(dsNhanVien, (nv1, nv2) -> (int) (nv1.TinhLuong() - nv2.TinhLuong()));
        XuatThongTinToanNhanVien();
    }

    // Chuc nang 11: Tim giam doc co co phan nhieu nhat
    public void GiamDocCoCPNhieuNhat() {
        System.out.printf("%-10s | %-20s | %-10s | %-10s | %-10s | %-10s\n", "Ma So", "Ho Ten", "SDT", "So Ngay", "Luong CB", "Thuc Lanh");
        for (NhanVien nv: dsNhanVien)
            if(nv instanceof GiamDoc && ((GiamDoc)nv).getPhanTramCoPhan() == phanTramCoPhanNhieuNhat())
                nv.XuatThongTinNhanVien();
        System.out.println("Phan tram co phan nhieu nhat la " + phanTramCoPhanNhieuNhat());
    }

    private float phanTramCoPhanNhieuNhat() {
        float ptNhieuNhat = 0;
        for (NhanVien nv: dsNhanVien)
            if(nv instanceof GiamDoc && ((GiamDoc) nv).getPhanTramCoPhan() > ptNhieuNhat)
                ptNhieuNhat = ((GiamDoc) nv).getPhanTramCoPhan();
        return ptNhieuNhat;
    }

    // Chuc nang 12: Tinh tong thu nhap tung giam doc.
    public void TongThuNhapTungGiamDoc() {
        System.out.printf("%-10s | %-20s | %-10s | %-10s\n", "Ma So", "Ho Ten", "SDT", "Thu nhap");
        for (NhanVien nv: dsNhanVien) {
            if(nv instanceof GiamDoc) {
                System.out.printf("%-10s | %-20s | %-10s | %-10.2f\n", nv.getMaSo(), nv.getHoTen(), nv.getSoDienThoai(), nv.TinhLuong() + ((GiamDoc) nv).getPhanTramCoPhan()/100*LoiNhuanCongTy());
            }
        }
    }

    private double LoiNhuanCongTy() {
        return getDoanhThuThang() - TongLuongToanCongTy();
    }

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public double getDoanhThuThang() {
        return doanhThuThang;
    }

    public void setDoanhThuThang(double doanhThuThang) {
        this.doanhThuThang = doanhThuThang;
    }

    public List<NhanVien> getDsNhanVien() {
        return dsNhanVien;
    }

    public void setDsNhanVien(List<NhanVien> dsNhanVien) {
        this.dsNhanVien = dsNhanVien;
    }

	
}