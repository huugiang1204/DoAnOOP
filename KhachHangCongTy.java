/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang;

import java.util.Scanner;

/**
 *
 * @author huugi
 */
public final class KhachHangCongTy extends ThongTinKhachHang{
    private int SO_LUONG_NHAN_VIEN;

    public int getSO_LUONG_NHAN_VIEN() {
        return SO_LUONG_NHAN_VIEN;
    }

    public void setSO_LUONG_NHAN_VIEN(int SO_LUONG_NHAN_VIEN) {
        this.SO_LUONG_NHAN_VIEN = SO_LUONG_NHAN_VIEN;
    }

    public KhachHangCongTy() {
        super();
    }

    public KhachHangCongTy(String MaKhachHang, String TenKhachHang, int SoLuong, long GIA_BAN, long ThanhTien, int SO_LUONG_NHAN_VIEN) {
        super(MaKhachHang, TenKhachHang, SoLuong, GIA_BAN, ThanhTien);
        setSO_LUONG_NHAN_VIEN(SO_LUONG_NHAN_VIEN);
    }

    
    @Override
    public void NhapThongTin() {
        Scanner sc = new Scanner(System.in);
        super.NhapThongTin();//To change body of generated methods, choose Tools | Templates.
        System.out.println("Nhập số lượng nhân viên trong công ty bạn: ");
        SO_LUONG_NHAN_VIEN = sc.nextInt();
    }

    @Override
    public String toString() {
        return super.toString()+" ,Số lương nhân viên công ty bạn: "+this.getSO_LUONG_NHAN_VIEN(); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public double ChietKhau() {
       
        long chietkhau=0;
        if(this.SO_LUONG_NHAN_VIEN >100 && this.SO_LUONG_NHAN_VIEN <=500){
            chietkhau =(long) ((this.getGIA_BAN()*this.getSoLuong()*3/100));
        }
        if(this.SO_LUONG_NHAN_VIEN > 500){
            chietkhau =(long) ((this.getGIA_BAN()*this.getSoLuong()*5/100));
        }
        return chietkhau;
    }

    @Override
    public double HoTroGia() {
        int hotrogia = 120000*this.getSoLuong();
        return hotrogia;
    }
    @Override
    public void XuatDuLieu(){
        super.XuatDuLieu();
        System.out.println("Số lượng nhân viên(người): "+SO_LUONG_NHAN_VIEN);
    }
}
