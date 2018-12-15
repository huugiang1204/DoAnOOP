/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLiBanHang;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author huugi
 */
public class DanhSachKhachHang {

    ArrayList<ThongTinKhachHang> dsKhachHang = new ArrayList<>();
 public static Comparator<ThongTinKhachHang> SoLuongSort = new Comparator<ThongTinKhachHang>() {

        @Override
        public int compare(ThongTinKhachHang s1, ThongTinKhachHang s2) {
            if (s1.getSoLuong() < s2.getSoLuong()) {
                return -1;
            } else if (s1.getSoLuong() == s2.getSoLuong()) {
                return 0;
            } else {
                return 1;
            }
        }
    };

    public DanhSachKhachHang() {
        super();
        this.dsKhachHang = new ArrayList<>();
    }

    public ArrayList<ThongTinKhachHang> getDsKhachHang() {
        return dsKhachHang;
    }

    public void setDsKhachHang(ArrayList<ThongTinKhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    public void ReadXML() throws ParserConfigurationException, SAXException, IOException {
        File xmlfile = new File("src/QuanLiBanHang/DSHOADON.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlfile);
        //KHÁCH HÀNG CÁ NHÂN
        NodeList nodeList_KHCN = doc.getElementsByTagName("KHCN");
        for (int i = 0; i < nodeList_KHCN.getLength(); i++) {

            ThongTinKhachHang ttkh;
            Node node = nodeList_KHCN.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String MaKhachHang;
                String TenKhachHang;
                int SoLuong;
                long GIA_BAN;
                long ThanhTien;
                int KhoangCach;
                MaKhachHang = (element.getElementsByTagName("MaKhachHang").item(0).getTextContent());
                TenKhachHang = (element.getElementsByTagName("TenKhachHang").item(0).getTextContent());
                SoLuong = Integer.parseInt(element.getElementsByTagName("SoLuong").item(0).getTextContent());
                GIA_BAN = Long.parseLong(element.getElementsByTagName("GIA_BAN").item(0).getTextContent());
                ThanhTien = Long.parseLong(element.getElementsByTagName("ThanhTien").item(0).getTextContent());
                KhoangCach = Integer.parseInt(element.getElementsByTagName("KhoangCach").item(0).getTextContent());
                
                ttkh = new KhachHangCaNhan(MaKhachHang, TenKhachHang, SoLuong, GIA_BAN, ThanhTien, KhoangCach);
                dsKhachHang.add(ttkh);

            }

        }
        //KHÁCH HÀNG CÔNG TY
        NodeList nodeList_KHCT = doc.getElementsByTagName("KHCT");
        for(int j=0;j<nodeList_KHCT.getLength();j++){
            ThongTinKhachHang ttkh1;
            Node node = nodeList_KHCT.item(j);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String MaKhachHang;
                String TenKhachHang;
                int SoLuong;
                long GIA_BAN;
                long ThanhTien;
                int SO_LUONG_NHAN_VIEN;
                MaKhachHang = (element.getElementsByTagName("MaKhachHang").item(0).getTextContent());
                TenKhachHang = (element.getElementsByTagName("TenKhachHang").item(0).getTextContent());
                SoLuong = Integer.parseInt(element.getElementsByTagName("SoLuong").item(0).getTextContent());
                GIA_BAN = Long.parseLong(element.getElementsByTagName("GIA_BAN").item(0).getTextContent());
                ThanhTien = Long.parseLong(element.getElementsByTagName("ThanhTien").item(0).getTextContent());
                SO_LUONG_NHAN_VIEN = Integer.parseInt(element.getElementsByTagName("SoNhanVien").item(0).getTextContent());
                
                ttkh1 = new KhachHangCongTy(MaKhachHang, TenKhachHang, SoLuong, GIA_BAN, ThanhTien, SO_LUONG_NHAN_VIEN);
                dsKhachHang.add(ttkh1);
            }
        }
        //ĐẠI LÝ CẤP 1
        NodeList nodeList_DLC1 = doc.getElementsByTagName("DLC1");
        for(int k=0;k<nodeList_DLC1.getLength();k++){
            ThongTinKhachHang ttkh2;
            Node node = nodeList_DLC1.item(k);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String MaKhachHang;
                String TenKhachHang;
                int SoLuong;
                long GIA_BAN;
                long ThanhTien;
                int THOI_GIAN_HOP_TAC;
                MaKhachHang = (element.getElementsByTagName("MaKhachHang").item(0).getTextContent());
                TenKhachHang = (element.getElementsByTagName("TenKhachHang").item(0).getTextContent());
                SoLuong = Integer.parseInt(element.getElementsByTagName("SoLuong").item(0).getTextContent());
                GIA_BAN = Long.parseLong(element.getElementsByTagName("GIA_BAN").item(0).getTextContent());
                ThanhTien = Long.parseLong(element.getElementsByTagName("ThanhTien").item(0).getTextContent());
                THOI_GIAN_HOP_TAC= Integer.parseInt(element.getElementsByTagName("HopTac").item(0).getTextContent());
                
                ttkh2 = new DaiLyCap1(MaKhachHang, TenKhachHang, SoLuong, GIA_BAN, ThanhTien, THOI_GIAN_HOP_TAC);
                dsKhachHang.add(ttkh2);
            }
        }

    }

    public void xuatXML() {
        System.out.println("-------------DANH SÁCH KHÁCH HÀNG----------------");
        System.out.println("-------------------------------");
        for (ThongTinKhachHang khachHang : dsKhachHang) {
            khachHang.XuatDuLieu();
            System.out.println("--------------------------------------------");
        }
    }
    public void XuatXapSep(){
        for (ThongTinKhachHang khachHang : dsKhachHang){
            System.out.println("Mã Khách hàng : "+khachHang.getMaKhachHang()+", Tên : "+khachHang.getTenKhachHang()+", Số Lượng : "+khachHang.getSoLuong());
        }
                
    }
    public void XapSep(){
        Collections.sort(dsKhachHang, SoLuongSort);
        XuatXapSep();
    }
}
