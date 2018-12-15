/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang;

import java.util.Scanner;

/**private final long GIA_BAN = 5690000;
 *
 * @author huugi
 */
public final class KhachHangCaNhan extends ThongTinKhachHang{
     private int KhoangCach;//chi khach hang ca nhan moi co 

   // private final long GIA_BAN = 5690000;
    public int getKhoangCach() {
        return KhoangCach;
    }

    public void setKhoangCach(int KhoangCach) {
        this.KhoangCach = KhoangCach;
    }
    public KhachHangCaNhan(){
        super();
    }
    public KhachHangCaNhan (String MaKhachHang, String TenKhachHang, int SoLuong, long GIA_BAN, long ThanhTien, int KhoangCach){
       super(MaKhachHang, TenKhachHang, SoLuong, GIA_BAN, ThanhTien);
       setKhoangCach(KhoangCach);
    }

   
    @Override
    public void NhapThongTin() {
        Scanner sc = new Scanner(System.in);
        super.NhapThongTin(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Nhập khoảng cách mà từ nhà bạn đến của hàng chúng tôi(KM): ");
        KhoangCach =sc.nextInt();
    }

    @Override
    public String toString() {
        return super.toString()+", quảng đường bạn đến cửa hàng chúng tôi: "+this.getKhoangCach(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public double ChietKhau() {
       
        int chietkhau = 0;
        if(this.getSoLuong()<7 &&this.KhoangCach < 10 )
        {
            chietkhau = (int) (10000*this.getSoLuong());
        }
        if(this.getSoLuong()>7 && this.KhoangCach < 10){
                chietkhau =(int)(this.getGIA_BAN()*this.getSoLuong()*5/100+10000);
        }
        
        if(this.getSoLuong()<7 &&this.KhoangCach > 10){
            chietkhau = 0;
        }
        if(this.getSoLuong()>7 && this.KhoangCach >10){
            chietkhau =(int) (this.getGIA_BAN()*this.getSoLuong()*5/100);
        }
        return chietkhau;
     
    }

    @Override
    public double HoTroGia() {
       int hotrogia;
       hotrogia = (int) (this.getGIA_BAN()*2/100);
       if(this.getSoLuong() > 2 ){
           hotrogia = (hotrogia + 100000)*this.getSoLuong();
       }
       return hotrogia;
    }
    @Override
    public void XuatDuLieu(){
        super.XuatDuLieu();
        System.out.println("Khoảng Cách(KM): "+KhoangCach);
    }
}
    
