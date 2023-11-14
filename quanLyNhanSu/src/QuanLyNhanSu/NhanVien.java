package QuanLyNhanSu;



import java.util.Scanner;

public class NhanVien {
    protected static final Scanner scanner = new Scanner(System.in);
    protected static final KiemTraDieuKien kt = new KiemTraDieuKien();
    protected static int thangLamViec = 9;
    protected static int namLamViec = 2022;
    protected String maSo;
    protected String hoTen;
    protected String soDienThoai;
    protected int soNgayLamViec = 0;
    protected double luongMotNgay = 0.0;

    public NhanVien() {
    }



    public void NhapThongTinNhanVien() {
        nhapMaSo();
        nhapHoTen();
        nhapSoDienThoai();
    }

    private void nhapMaSo() {
        System.out.println("Nhap ma so: ");
        String maSo = scanner.nextLine();
        while(true)
            if(kt.KiemTraChieuDaiChuoi(maSo, 8)) break;
            else maSo = scanner.nextLine();
        setMaSo(maSo);
    }

    private void nhapHoTen() {
        System.out.println("Nhap ho ten: ");
        String hoTen = scanner.nextLine();
        while(true)
            if(kt.KiemTraChuoiRong(hoTen)) break;
            else hoTen = scanner.nextLine();
        setHoTen(hoTen);
    }

    private void nhapSoDienThoai() {
        System.out.println("Nhap so dien thoai: ");
        String soDienThoai = scanner.nextLine();
        while(true)
            if(kt.KiemTraChieuDaiChuoi(soDienThoai, 10) && kt.KiemTraChuoiSo(soDienThoai)) break;
            else soDienThoai = scanner.nextLine();
        setSoDienThoai(soDienThoai);
    }

    protected void nhapSoNgayLamViec() {
        System.out.println("Nhap so ngay lam viec cua thang " + getThangLamViec() + " nam " + getNamLamViec() + ":");
        int soNgayLamViec = Integer.parseInt(scanner.nextLine());
        while(true)
            if(kt.KiemTraSoNgayLamViec(soNgayLamViec, getThangLamViec(), getNamLamViec())) break;
            else soNgayLamViec = Integer.parseInt(scanner.nextLine());
        setSoNgayLamViec(soNgayLamViec);
    }

    public void XuatThongTinNhanVien() {
        System.out.printf("%-10s | %-20s | %-10s | %-10d | %-10.2f | %-10.2f\n", maSo, hoTen, soDienThoai, soNgayLamViec, luongMotNgay, TinhLuong());
    }

    protected double TinhLuong() {
        return getLuongMotNgay() * getSoNgayLamViec();
    }

    public String LayTenNhanVien() {
        String[] hoTen = getHoTen().split(" ");
        return hoTen[hoTen.length-1];
    }

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public int getSoNgayLamViec() {
        return soNgayLamViec;
    }

    public void setSoNgayLamViec(int soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
    }

    public double getLuongMotNgay() {
        return luongMotNgay;
    }

    protected void setLuongMotNgay(double luongMotNgay) {
        this.luongMotNgay = luongMotNgay;
    }

    public static int getThangLamViec() {
        return thangLamViec;
    }

    public static void setThangLamViec(int thangLamViec) {
        NhanVien.thangLamViec = thangLamViec;
    }

    public static int getNamLamViec() {
        return namLamViec;
    }

    public static void setNamLamViec(int namLamViec) {
        NhanVien.namLamViec = namLamViec;
    }
}