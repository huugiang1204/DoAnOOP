/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang;

//import java.io.File;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author huugi
 */
public abstract class ThongTinKhachHang {

    private String MaKhachHang;
    private String TenKhachHang;
    private int SoLuong;
    private long GIA_BAN;
    private long ThanhTien;

    public ThongTinKhachHang() {
    }

    public ThongTinKhachHang(String MaKhachHang, String TenKhachHang, int SoLuong, long GIA_BAN, long ThanhTien) {
        this.MaKhachHang = MaKhachHang;
        this.TenKhachHang = TenKhachHang;
        this.SoLuong = SoLuong;
        this.GIA_BAN = GIA_BAN;
        this.ThanhTien = ThanhTien;
    }

    public String getMaKhachHang() {
        
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public long getGIA_BAN() {
        return GIA_BAN;
    }

    public void setGIA_BAN(long GIA_BAN) {
        this.GIA_BAN = GIA_BAN;
    }

    public long getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(long ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public void NhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã khách hàng(gồm 6 chữ số):");
        MaKhachHang = sc.nextLine();
        System.out.println("Nhập tên khách hàng: ");
        TenKhachHang = sc.nextLine();
        System.out.println("Nhập số lượng: ");
        SoLuong = sc.nextInt();
        System.out.println("Nhập giá bán : ");
        GIA_BAN = sc.nextLong();
    }

    @Override
    public String toString() {
        return "ThongTinKhachHang : " + "MaKhachHang=" + MaKhachHang + ", TenKhachHang=" + TenKhachHang + ", SoLuong=" + SoLuong + ", GIA_BAN=" + GIA_BAN;
    }

    public abstract double ChietKhau();

    public abstract double HoTroGia();

    /**
     *
     * @return
     */
    public long ThanhTien() {
        double VAT = (this.SoLuong * this.GIA_BAN) / 10;
        double ck = ChietKhau();
        long thanhtien;
        return thanhtien = (long) ((this.SoLuong * this.GIA_BAN - ck + VAT) - HoTroGia());//đúng
    }
    public static Comparator<ThongTinKhachHang> SoLuongSort = new Comparator<ThongTinKhachHang>() {

        @Override
        public int compare(ThongTinKhachHang s1, ThongTinKhachHang s2) {
            if(s1.SoLuong > s1.SoLuong)
                return -1;
            else{
                if(s1.SoLuong==s2.SoLuong)
                    return 0;
                else{
                    return 1;
                }
            }

        }
    };
    

    public void XuatDuLieu() {
        System.out.println("Khách Hàng mã số :" + getMaKhachHang());
        System.out.println("Tên:" + getTenKhachHang());
        System.out.println("Số Lượng: " + getSoLuong());
        System.out.println("Giá Bán(Đơn Giá): " + getGIA_BAN());
        System.out.println("Thành Tiền: " + getThanhTien());
    }

}
