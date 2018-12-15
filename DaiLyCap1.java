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
public final class DaiLyCap1 extends ThongTinKhachHang{
    private int THOI_GIAN_HOP_TAC;
    //private final long GIA_BAN = 5690000;

    

    public int getTHOI_GIAN_HOP_TAC() {
        return THOI_GIAN_HOP_TAC;
    }

    public void setTHOI_GIAN_HOP_TAC(int THOI_GIAN_HOP_TAC) {
        this.THOI_GIAN_HOP_TAC = THOI_GIAN_HOP_TAC;
    }

    public DaiLyCap1() {
        super();
    }

    public DaiLyCap1(String MaKhachHang, String TenKhachHang, int SoLuong, long GIA_BAN, long ThanhTien, int THOI_GIAN_HOP_TAC) {
        super(MaKhachHang, TenKhachHang, SoLuong, GIA_BAN, ThanhTien);
        setTHOI_GIAN_HOP_TAC(THOI_GIAN_HOP_TAC);
    }
    

    @Override
    public void NhapThongTin() {
        Scanner sc = new Scanner(System.in);
        super.NhapThongTin(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Vui lòng nhập số năm bạn muốn hợp tác với chúng tôi: ");
        THOI_GIAN_HOP_TAC = sc.nextInt();
    }
    @Override
    public void XuatDuLieu(){
        super.XuatDuLieu();
        System.out.println("Hợp tác(năm): "+THOI_GIAN_HOP_TAC);
    }

    @Override
    public String toString() {
        return super.toString()+",số năm bạn muốn hợp tác: "+this.THOI_GIAN_HOP_TAC; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public double ChietKhau() {
        int chietkhau;
        chietkhau = (int) (this.getGIA_BAN()*30/100);
        int CHIET_KHAU_THEM = (int) (this.getGIA_BAN()/100);
        if(this.THOI_GIAN_HOP_TAC>3 &&this.THOI_GIAN_HOP_TAC <= 5){
            for(int i=1;i<=this.THOI_GIAN_HOP_TAC;i++)
            {
                chietkhau =chietkhau +CHIET_KHAU_THEM;
            }
        } 
        return chietkhau;
    }

    @Override
    public double HoTroGia() {
        int hotrogia =0;
        return hotrogia;
    }
    
}
