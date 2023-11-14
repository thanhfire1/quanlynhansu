package QuanLyNhanSu;

public class GiamDoc extends NhanVien{
    private float phanTramCoPhan;

    public GiamDoc() {
        super();
        setLuongMotNgay(300);
    }

    @Override
    public void NhapThongTinNhanVien() {
        super.NhapThongTinNhanVien();
        nhapSoNgayLamViec();
        NhapPhanTramCoPhieu();
        TinhLuong();
    }

    private void NhapPhanTramCoPhieu() {
        System.out.println("Nhap phan tram co phieu: ");
        float ptCoPhieu = Float.parseFloat(scanner.nextLine());
        while(true)
            if(kt.KiemTraPhanTramCoPhieu(ptCoPhieu)) break;
            else ptCoPhieu = Float.parseFloat(scanner.nextLine());
        setPhanTramCoPhan(ptCoPhieu);
    }

    public float getPhanTramCoPhan() {
        return phanTramCoPhan;
    }

    public void setPhanTramCoPhan(float phanTramCoPhan) {
        this.phanTramCoPhan = phanTramCoPhan;
    }
}