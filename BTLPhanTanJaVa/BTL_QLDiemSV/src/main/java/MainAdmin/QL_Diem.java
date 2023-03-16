/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainAdmin;

import entity.DataSQL;
import entity.DiemThi;
import entity.MonHoc;
import entity.SinhVien;

import Check.MessageHelper;
import dao.DiemThiDao;
import dao.MaHoaDes;
import dao.MonHocDao;
import dao.SinhvienDao;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author Yahiko
 */
public class QL_Diem extends javax.swing.JPanel {
    String user,pass,port;
    private MainFrame parentform;
    private DefaultTableModel tblTableModell;
    DataSQL datasql=new DataSQL();
    String[] arr=new String[100];
    String[] arr1=new String[100];
    String[] arr2=new String[100];
    int i=0,i1=0;
    /**
     * Creates new form QL_Diem
     */
    public QL_Diem() {
        initComponents();
    }
    public QL_Diem(DataSQL dt)
    {
        initComponents();
        datasql.setUsername(dt.getUsername());
        datasql.setPassword(dt.getPassword());
        datasql.setPort(dt.getPort());
        initTable();
        LoadDataTable();
        itemMH();
        itemSV(); 
    }
    public void itemSV(){
        cbb_masv.removeAllItems();
        try {
           
            SinhvienDao SV = new SinhvienDao();
            List<SinhVien> list = SV.FindAllSV(datasql);
            for (SinhVien cb : list){
               arr[i]=MaHoaDes.Decrypt(cb.getMaSV(),cb.getMaSV()); 
               i++;
               }      
            
         } catch (Exception e) {
         }
         for (int j = 0; j<i; j++) cbb_masv.addItem(arr[j]);
    }
    public void itemMH(){
       cbb_monhoc.removeAllItems();
        try {
            MonHocDao SV1 = new MonHocDao();
            List<MonHoc> list1 = SV1.FindAllMH(datasql);
            for (MonHoc cb1 : list1){
               arr1[i1]=cb1.getTenMH(); 
               arr2[i1]=cb1.getMaMH();
               i1++;
               }             
        } catch (Exception e) {
        }
        for (int j = 0; j<i1; j++) cbb_monhoc.addItem(arr1[j]);
    }
    public void initTable(){
        tblTableModell = new DefaultTableModel();
        JScrollPane pane=new JScrollPane();
        tbl_diemthi.add(pane,BorderLayout.CENTER);
        tblTableModell.setColumnIdentifiers(new String[]{"Mã Sinh Viên","Họ Và Tên",
            "Giới Tính","SĐT","Email","Môn Học","Giữa Kì","Cuối Kì","Tổng Kết"});
        tbl_diemthi.setModel(tblTableModell);
        tbl_diemthi.getTableHeader().setFont(new java.awt.Font("Times New Roman", 3, 14));
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        tbl_diemthi.setDefaultRenderer(Object.class,rightRenderer);
    }
    private void LoadDataTable(){
        try {
           DiemThiDao sinhvien=new DiemThiDao();
           List <DiemThi> list=sinhvien.FindAllSV(datasql);
           tblTableModell.setRowCount(0);
           String gioitinh;
           for(DiemThi sb :list){
               String Masv=MaHoaDes.Decrypt(sb.getMaSV(),sb.getMaSV());
               SinhvienDao sb1=new SinhvienDao();
               SinhVien sb2=sb1.FindSV(sb.getMaSV(),datasql);
               String email=MaHoaDes.Decrypt(sb2.getEmail(),sb.getMaSV());
               String sdt=MaHoaDes.Decrypt(sb2.getSDT(),sb.getMaSV());
               MonHocDao sb3=new MonHocDao();
               MonHoc sb4=sb3.FindMH(sb.getMaMH(), datasql);
               if (sb2.getGioiTinh()==1) {
                   gioitinh="Nam";
               }
               else 
                   gioitinh="Nữ";
               tblTableModell.addRow(new Object[]{
                   Masv,sb2.getHoTen(),gioitinh,sdt,email,sb4.getTenMH(),sb.getDiemGK(),sb.getDiemCK(),sb.getDiemTK()});
           }
           tblTableModell.fireTableDataChanged();
        } catch (Exception e) {
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_diemthi = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_hoten = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbb_monhoc = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_cuoiki = new javax.swing.JTextField();
        txt_giuaki = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        cbb_masv = new javax.swing.JComboBox<>();

        tbl_diemthi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_diemthi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_diemthiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_diemthi);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Account/id-card.png"))); // NOI18N
        jLabel1.setText("Mã Sinh Viên :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Account/edit-user.png"))); // NOI18N
        jLabel2.setText("Họ Và Tên :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Account/phone.png"))); // NOI18N
        jLabel3.setText("Số Điện Thoại :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Account/gmail.png"))); // NOI18N
        jLabel4.setText("Email :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Account/monhoc.png"))); // NOI18N
        jLabel5.setText("Môn Học :");

        cbb_monhoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbb_monhoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_monhocActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Account/score2.png"))); // NOI18N
        jLabel6.setText("Điểm Giữa Kì :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Account/score3.png"))); // NOI18N
        jLabel7.setText("Điểm Cuối Kì :");

        btn_them.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Account/add.png"))); // NOI18N
        btn_them.setText("Thêm ");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Account/edit.png"))); // NOI18N
        btn_update.setText("Cập Nhật");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        cbb_masv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbb_masv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_masvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(55)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(btn_them)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(btn_update)
        					.addGap(44))
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel2)
        						.addComponent(jLabel1)
        						.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel4)
        						.addComponent(jLabel5)
        						.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
        					.addGap(31)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(cbb_monhoc, 0, 130, Short.MAX_VALUE)
        						.addComponent(txt_hoten, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        						.addComponent(txt_email, 130, 130, 130)
        						.addComponent(txt_sdt, 130, 130, 130)
        						.addComponent(cbb_masv, 0, 130, Short.MAX_VALUE)
        						.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        							.addComponent(txt_cuoiki, Alignment.LEADING)
        							.addComponent(txt_giuaki, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)))))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 686, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 429, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel1)
        						.addComponent(cbb_masv, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(txt_hoten)
        						.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel3)
        						.addComponent(txt_sdt, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel4)
        						.addComponent(txt_email, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel5)
        						.addComponent(cbb_monhoc, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel6)
        						.addComponent(txt_giuaki, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel7)
        						.addComponent(txt_cuoiki, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btn_update)
        						.addComponent(btn_them))))
        			.addContainerGap(36, Short.MAX_VALUE))
        );
        this.setLayout(layout);
    }// </editor-fold>//GEN-END:initComponents

    private void cbb_masvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_masvActionPerformed
        if (cbb_masv.getSelectedItem()!=null) {
            
            SinhvienDao sv=new SinhvienDao();
            try {
                String masv=MaHoaDes.Encrypt(cbb_masv.getSelectedItem().toString(),cbb_masv.getSelectedItem().toString());
                SinhVien sinhvien=sv.FindSV(masv,datasql);
                String email=MaHoaDes.Decrypt(sinhvien.getEmail(),masv);
                String sdt=MaHoaDes.Decrypt(sinhvien.getSDT(),masv);
                txt_hoten.setText(sinhvien.getHoTen());
                txt_sdt.setText(sdt);
                txt_email.setText(email);
            } catch (Exception ex) {
                Logger.getLogger(QL_Diem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cbb_masvActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        DiemThi SV=new DiemThi();
        SV.setMaSV(cbb_masv.getSelectedItem().toString());
        SV.setMaMH(arr2[cbb_monhoc.getSelectedIndex()]);
        SV.setDiemGK(Float.parseFloat(txt_giuaki.getText()));
        SV.setDiemCK(Float.parseFloat(txt_cuoiki.getText()));
            try {
                Socket client = new Socket("localhost" ,9999) ;
                DataInputStream DT=new DataInputStream(client.getInputStream());
                DataOutputStream OT=new DataOutputStream(client.getOutputStream());
                ObjectOutputStream OOS = new ObjectOutputStream(client.getOutputStream()) ;
                ObjectInputStream  IS = new ObjectInputStream(client.getInputStream()) ;
                    OT.writeInt(4);
                    OOS.writeObject(SV);
                    OOS.writeObject(datasql);
                    boolean check=DT.readBoolean();
                    System.out.println(check);
                    if (check==true) {
                        MessageHelper.showMesage(parentform,"Thêm thành công","Thông Báo");
                        LoadDataTable();
                    }
                    else 
                        {
                            MessageHelper.showMesage(parentform,"Sinh viên này đã có điểm"+"Vui Lòng Chọn cập nhật điểm","Thông Báo"); 
                            LoadDataTable();
                        }     
                } 
                
            catch (IOException ex) {
            MessageHelper.showMesage(parentform,"Sinh viên này đã có điểm"+"Vui Lòng Chọn cập nhật điểm","Thông Báo");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void tbl_diemthiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_diemthiMouseClicked
        try {
            int row=tbl_diemthi.getSelectedRow();
            if (row>=0) 
            {
                String id=(String) tblTableModell.getValueAt(row,0);
                String id1=MaHoaDes.Encrypt(id,id);
                String tg=(String) tblTableModell.getValueAt(row,5);
                int indd=0;
                for (int j = 0; j < i1; j++) 
                    if (arr[j].equals(id)) indd=j;
                cbb_masv.setSelectedIndex(indd);
                int ind=0;
                for (int j = 0; j < i1; j++) 
                    if (arr1[j].equals(tg)) ind=j;
                cbb_monhoc.setSelectedIndex(ind);
                txt_hoten.setText((String) tblTableModell.getValueAt(row,1));
                txt_sdt.setText((String) tblTableModell.getValueAt(row,3));
                txt_email.setText((String) tblTableModell.getValueAt(row,4));
                Float tgg=(Float) tblTableModell.getValueAt(row,6);
                txt_giuaki.setText(String.valueOf(tgg));
                Float tg1=(Float) tblTableModell.getValueAt(row,7);
                txt_cuoiki.setText(String.valueOf(tg1));

            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageHelper.ErrorMesage(parentform,"Lỗi","Lỗi");
        }
    }//GEN-LAST:event_tbl_diemthiMouseClicked

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        DiemThi SV=new DiemThi();
        SV.setMaSV(cbb_masv.getSelectedItem().toString());
        SV.setMaMH(arr2[cbb_monhoc.getSelectedIndex()]);
        SV.setDiemGK(Float.parseFloat(txt_giuaki.getText()));
        SV.setDiemCK(Float.parseFloat(txt_cuoiki.getText()));
            try {
                Socket client = new Socket("localhost" ,9999) ;
                DataInputStream DT=new DataInputStream(client.getInputStream());
                DataOutputStream OT=new DataOutputStream(client.getOutputStream());
                ObjectOutputStream OOS = new ObjectOutputStream(client.getOutputStream()) ;
                ObjectInputStream  IS = new ObjectInputStream(client.getInputStream()) ;
                    OT.writeInt(5);
                    OOS.writeObject(SV);
                    OOS.writeObject(datasql);
                    boolean check=DT.readBoolean();
                    if (check==true) {
                        MessageHelper.showMesage(parentform,"Cập Nhật thành công","Thông Báo");
                        LoadDataTable();
                    }
                    else MessageHelper.showMesage(parentform,"Không Cập Nhật được do lỗi","Thông Báo"); 
                } 
                
            catch (IOException ex) {
            ex.printStackTrace();
            }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void cbb_monhocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_monhocActionPerformed
        if (cbb_monhoc.getSelectedItem()!=null){
            String masv=cbb_masv.getSelectedItem().toString();
            String mamh=arr2[cbb_monhoc.getSelectedIndex()];
            System.out.println(masv);
            System.out.println(mamh);
            try {
                DiemThiDao dt=new DiemThiDao();
                DiemThi diem=dt.FindDiem(mamh, MaHoaDes.Encrypt(masv,masv), datasql);  
                if (diem!=null)
                {    
                txt_giuaki.setText(String.valueOf(diem.getDiemGK()));
                txt_cuoiki.setText(String.valueOf(diem.getDiemCK()));
                }
                else
                {
                    txt_giuaki.setText("");
                    txt_cuoiki.setText("");
                }
                    
            } catch (Exception e) 
            {
            }  
        }
        
        
    }//GEN-LAST:event_cbb_monhocActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cbb_masv;
    private javax.swing.JComboBox<String> cbb_monhoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_diemthi;
    private javax.swing.JTextField txt_cuoiki;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_giuaki;
    private javax.swing.JTextField txt_hoten;
    private javax.swing.JTextField txt_sdt;
    // End of variables declaration//GEN-END:variables
}