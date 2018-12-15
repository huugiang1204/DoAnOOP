/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author huugi
 */
public class main {

    public static void main(String[] args) {

        DanhSachKhachHang dskh = new DanhSachKhachHang();
        //ArrayList<ThongTinKhachHang> alKH = dskh.dsKhachHang;
        //ThongTinKhachHang ttkh12 = new DaiLyCap1();
        //ttkh12.NhapThongTin();
        //System.out.println("số tiền cần thanh toán là: "+ttkh12.ThanhTien());
        try {
            /* 
             ThongTinKhachHang ttkh = new KhachHangCaNhan();
             ttkh.NhapThongTin();
             System.out.println("Hỗ trợ giá : "+ttkh.HoTroGia());//đúng
             System.out.println("số tiền cần thanh toán là: " + ttkh.ThanhTien());//đúng
             ThongTinKhachHang ttkh1 = new DaiLyCap1();
             ttkh1.NhapThongTin();
             System.out.println("số tiền cần thanh toán là: "+ttkh1.ThanhTien());
             ThongTinKhachHang ttkh2 = new KhachHangCongTy();
            
             ttkh2.NhapThongTin();
             System.out.println("số tiền cần thanh toán là: "+ttkh2.ThanhTien());
             }*/

            dskh.ReadXML();
            dskh.xuatXML();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }

        int choose, Continue;
        do {
            System.out.println("---------MENU THỰC HIỆN-----------");
            System.out.println("1  : Tổng thành tiền tất cả hóa đơn.");
            System.out.println("2  : Tổng tiền trợ giá mà công ty hổ trợ.");
            System.out.println("3  : Thông tin khách hàng có số lượng mua nhiều nhất.");
            System.out.println("4  : Thông tin hóa đơn có thành tiền cao nhất.");
            System.out.println("5  : Tổng chiết khấu của công ty đối với khách hàng công ty.");
            System.out.println("6  : Danh sách hóa đơn tăng dần theo số lượng(nếu số lượng bằng nhau thì xắp sếp giảm dần theo thành tiền).");
            System.out.println("7  : Tổng số khách hàng là ĐẠI LÍ CẤP 1.");

            Scanner sc = new Scanner(System.in);
            System.out.print("Mời bạn chọn: ");
            choose = sc.nextInt();
            System.out.println("----------------------------------");

            switch (choose) {
                case 1: {

                    ArrayList<ThongTinKhachHang> alKH1 = dskh.dsKhachHang;
                    long tongTT = 0;

                    for (ThongTinKhachHang khachHang : alKH1) {
                        tongTT = tongTT + khachHang.getThanhTien();
                    }

                    System.out.println("Tổng thành tiền tất cả hóa đơn là:" + tongTT);
                    break;
                }
                case 2: {
                    ArrayList<ThongTinKhachHang> alKH2 = dskh.dsKhachHang;
                    long TongTG = 0;
                    for (ThongTinKhachHang khachHang : alKH2) {
                        TongTG = (long) (TongTG + khachHang.HoTroGia());
                    }
                    System.out.println("Tổng tiền trợ giá mà công ty hổ trợ la :" + TongTG);
                    break;
                }
                case 3: {
                    ArrayList<ThongTinKhachHang> alKH3 = dskh.dsKhachHang;
                    ArrayList<ThongTinKhachHang> TTMaxSL = new ArrayList<>();
                    int SoLuongMax = 0;
                    for (ThongTinKhachHang KH : alKH3) {
                        if (KH.getSoLuong() > SoLuongMax) {
                            SoLuongMax = KH.getSoLuong();
                        }
                    }
                    for (ThongTinKhachHang ttkh : alKH3) {
                        if (ttkh.getSoLuong() == SoLuongMax) {
                            TTMaxSL.add(ttkh);
                        }
                    }

                    //System.out.println(""+SoLuongMax);
                    System.out.println("Thông tin khách hàng có số lượng mua lớn nhất là:");
                    for (ThongTinKhachHang KH : TTMaxSL) {
                        KH.XuatDuLieu();
                    }
                    break;
                }
                case 4: {
                    ArrayList<ThongTinKhachHang> alKH4 = dskh.dsKhachHang;
                    ArrayList<ThongTinKhachHang> TTMaxThanhTien = new ArrayList<>();
                    long ThanhTienMax = 0;
                    for (ThongTinKhachHang KH : alKH4) {
                        if (KH.getThanhTien() > ThanhTienMax) {
                            ThanhTienMax = KH.ThanhTien();
                        }
                    }
                    for (ThongTinKhachHang ttkh : alKH4) {
                        if (ttkh.ThanhTien() == ThanhTienMax) {
                            TTMaxThanhTien.add(ttkh);
                        }
                    }

                    System.out.println("Thông tin hóa đơn có thành tiền cao nhất :");
                    for (ThongTinKhachHang kh : TTMaxThanhTien) {
                        kh.XuatDuLieu();
                    }
                    break;
                }
                case 5: {
                    ArrayList<ThongTinKhachHang> alKH5 = dskh.dsKhachHang;
                    long TongChietKhauKHCT = 0;
                    for (ThongTinKhachHang KH : alKH5) {
                        if (KH instanceof KhachHangCongTy) {
                            //System.out.println("" + KH.ChietKhau());
                            TongChietKhauKHCT = (long) (TongChietKhauKHCT + KH.ChietKhau());
                        }//?????????????
                    }
                    System.out.println("Tổng chiết khấu của công ty đối với khách hàng công ty là:" + TongChietKhauKHCT);
                    break;
                }
                case 6: {
                    System.out.println("Danh sách hóa đơn tăng dần theo số lương :");
                    dskh.XapSep();
                    break;
                }
                case 7: {
                    ArrayList<ThongTinKhachHang> alKH7 = dskh.dsKhachHang;
                    //ArrayList<ThongTinKhachHang> KhachHangDLC1 = new ArrayList<>();
                    int dem = 0;
                    for (ThongTinKhachHang KH : alKH7) {
                        if (KH instanceof DaiLyCap1) {
                            dem++;
                        }
                    }
                    System.out.println("Tổn số khách hàng là ĐẠI LÍ CẤP 1 là : " + dem);
                    break;
                }
                default: {
                    System.out.println("Bạn Nhập sai chức năng.vui lòng chọn lại.");
                }

            }
            System.out.println("-----------------------------------------------");
            System.out.println("Bạn có muốn tiếp tục không?( 1-Tiếp Tục , 0-Thoát):");
            Continue = sc.nextInt();
        } while (Continue == 1);
    }
}
