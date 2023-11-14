package QuanLyNhanSu;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CongTy congTy = new CongTy();
        congTy.setDsNhanVien(taoDuLieu());
        int luaChon;

        do {
            showMenu();
            luaChon = Integer.parseInt(scanner.nextLine());
            switch (luaChon) {
                case 1:
                    System.out.println("NHAP THONG TIN NHAN VIEN");
                    congTy.NhapThongTinCongTy();
                    System.out.println("THONG TIN NHAN VIEN VUA NHAP LA");
                    congTy.XuatThongTinCongTy();
                    break;
                case 2:
                    System.out.println("PHAN BO NHAN VIEN VAO TRUONG PHONG");
                    congTy.PhanBoNhanVienVaoTruongPhong();
                    break;
                case 3:
                    System.out.println("THEM NHAN SU");
                    congTy.ThemMotNhanSu();
                    break;
                case 4:
                    System.out.println("XOA NHAN SU");
                    congTy.XoaNhanSu();
                    break;
                case 5:
                    System.out.println("THONG TIN TOAN BO NHAN SU TRONG CONG TY");
                    congTy.XuatThongTinToanNhanVien();
                    break;
                case 6:
                    System.out.println("TONG LUONG TOAN CONG TY : " + congTy.TongLuongToanCongTy());
                    break;
                case 7:
                    System.out.println("NHAN VIEN THUONG CO LUONG CAO NHAT");
                    congTy.NhanVienThuongCoLuongCaoNhat();
                    break;
                case 8:
                    // Mac dinh nhan vien thuong chua duoc phan cong
                    // Can dung chuc case 2 de phan cong
                    System.out.println("TRUONG PHONG CO NHIEU NHAN VIEN DUOI QUYEN NHAT");
                    congTy.TruongPhongCoNhieuNhanVienNhat();
                    break;
                case 9:
                    System.out.println("SAP XEP NHAN VIEN THEO TEN");
                    congTy.SapXepNhanVienTheoTen();
                    break;
                case 10:
                    System.out.println("SAP XEP NHAN VIEN GIAM DAN THEO LUONG");
                    congTy.SapXeoNhanVienGiamDanTheoLuong();
                    break;
                case 11:
                    System.out.println("GIAM DOC CO PHAN TRAM CO PHAN NHIEU NHAT");
                    congTy.GiamDocCoCPNhieuNhat();
                    break;
                case 12:
                    System.out.println("THU NHAP CUA TUNG GIAM DOC");
                    congTy.TongThuNhapTungGiamDoc();
                    break;
                case 13:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Can nhap dung chuc nang, nhap lai:");
                    break;
            }

        } while (luaChon != 13);
    }

    public static void showMenu() {
        System.out.println("\n==========MENU==========");
        System.out.println("1. Nhap thong tin cong ty.");
        System.out.println("2. Phan bo nhan vien vao truong phong.");
        System.out.println("3. Them nhan su.");
        System.out.println("4. Xoa nhan su.");
        System.out.println("5. Xuat thong tin toan bo nguoi trong cong ty.");
        System.out.println("6. Tinh va xuat tong luong cho toan cong ty.");
        System.out.println("7. Tim nhan vien thuong co luong cao nhat.");
        System.out.println("8. Tim truong phong co so luong nhan vien duoi quyen nhieu nhat.");
        System.out.println("9. Sap xep nhan vien toan cong ty theo thu tu abc");
        System.out.println("10. Sap xep nhan vien toan cong ty theo thu tu luong giam dan.");
        System.out.println("11. Tim giam doc co so luong co phan nhieu nhat");
        System.out.println("12. Tinh va xuat tong thu nhap cua tung giam doc.");
        System.out.println("13. Thoat chuong trinh.");
        System.out.println("Nhap lua chon: ");
    }


   public static ArrayList<NhanVien> taoDuLieu() {
        ArrayList<NhanVien> duLieu = new ArrayList<>();

        NhanVien nv1 = new NhanVienThuong();
        nv1.setMaSo("nv000001");
        nv1.setHoTen("Nguyen Van Khang");
        nv1.setSoDienThoai("0325478165");
        nv1.setSoNgayLamViec(23);
        ((NhanVienThuong)nv1).setMaTruongPhong("nv000003");

        duLieu.add(nv1);

        NhanVien nv2 = new NhanVienThuong();
        nv2.setMaSo("nv000002");
        nv2.setHoTen("Hoang Thi Loan");
        nv2.setSoDienThoai("0325478456");
        nv2.setSoNgayLamViec(20);

        duLieu.add(nv2);

        NhanVien nv3 = new TruongPhong();
        nv3.setMaSo("nv000003");
        nv3.setHoTen("Le Van Bo");
        nv3.setSoDienThoai("0325478456");
        nv3.setSoNgayLamViec(25);

        duLieu.add(nv3);

        NhanVien nv4 = new GiamDoc();
        nv4.setMaSo("nv000004");
        nv4.setHoTen("Le Hoang Dieu");
        nv4.setSoDienThoai("0325478456");
        nv4.setSoNgayLamViec(12);
        ((GiamDoc)nv4).setPhanTramCoPhan(20);

        duLieu.add(nv4);

        NhanVien nv5 = new NhanVienThuong();
        nv5.setMaSo("nv000005");
        nv5.setHoTen("Nguyen Van Minh");
        nv5.setSoDienThoai("0325408165");
        nv5.setSoNgayLamViec(23);

        duLieu.add(nv5);

        NhanVien nv6 = new TruongPhong();
        nv6.setMaSo("nv000006");
        nv6.setHoTen("Le Van An");
        nv6.setSoDienThoai("0325478456");
        nv6.setSoNgayLamViec(23);

        duLieu.add(nv6);

        NhanVien nv7 = new GiamDoc();
        nv7.setMaSo("nv000007");
        nv7.setHoTen("Bui Viet Phuc");
        nv7.setSoDienThoai("0325478456");
        nv7.setSoNgayLamViec(20);
        ((GiamDoc)nv7).setPhanTramCoPhan(40);

        duLieu.add(nv7);

        return duLieu;
    }

}