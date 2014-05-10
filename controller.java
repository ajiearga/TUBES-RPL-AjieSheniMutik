/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;
import PlaneTicketReservation.*;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Ajie
 */
public class Controller implements ActionListener{
    private GUIReservation FUtama;
    private GUIPesan FPesan;
    private GUIBayar FBayar;
    private GUILogin FLogin;
    private Aplikasi app;
    
    public Controller(){}

    public void setFUtama(GUIReservation FUtama) {
        this.FUtama = FUtama;
    }

    public void setFPesan(GUIPesan FPesan) {
        this.FPesan = FPesan;
    }

    public void setFBayar(GUIBayar FBayar) {
        this.FBayar = FBayar;
    }
    
    public void setFLogin(GUILogin FLogin) {
        this.FLogin = FLogin;
    }

    public void setApp(Aplikasi app) {
        this.app = app;
    }
    
    public GUIReservation getFUtama() {
        return FUtama;
    }

    public GUIPesan getFPesan() {
        return FPesan;
    }
    
    public GUIBayar getFBayar() {
        return FBayar;
    }
    
    public GUILogin getFLogin(){
        return FLogin;
    }

    public Aplikasi getApp() {
        return app;
    }
    
    public void setListener(){
        getFUtama().addListener(this);
        getFLogin().addListener(this);
        getFPesan().addListener(this);
    }
    
        
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem mTemp = null;;
        JButton bTemp = null;
        
        //Buat mengetahui tombol atau menu file
        if(e.getSource() instanceof JMenuItem){
            mTemp = (JMenuItem) e.getSource();
        }else{
            bTemp = (JButton) e.getSource();
        }
        String id2=null;
        //Action dari tombol atau menu file
        if(bTemp == getFUtama().getbPesan()){
            getFPesan().setVisible(true); //menampilkan form pesan
            getFPesan().getLbDari().setText((String)getFUtama().getCbdari().getSelectedItem());
            getFPesan().getLbTujuan().setText((String)getFUtama().getCbKe().getSelectedItem());
            getFPesan().getLbPesawat().setText((String) getFUtama().getTTicket().getValueAt(getFUtama().getTTicket().getSelectedRow(), 0));
            getFPesan().getLbJam().setText((String) getFUtama().getTTicket().getValueAt(getFUtama().getTTicket().getSelectedRow(), 2));
            getFPesan().getLbTanggal().setText((String)getFUtama().getCbTanggal().getSelectedItem());
            id2 = (String)getFUtama().getTTicket().getValueAt(getFUtama().getTTicket().getSelectedRow(), 5);
        }else if(bTemp == getFUtama().getbBayar()){
            getFBayar().setVisible(true); //menampilkan form bayar
        }else if(mTemp == getFUtama().getMenuFileLogin()){
            getFLogin().setVisible(true); //menampilkan login
        }else if(bTemp == getFLogin().getBLogin()){ //aktifasi login
            String id=getFLogin().getTId().getText();
            String pass = getFLogin().getTPass().getText();
            if(getApp().login(id, pass) == false){ //jika salah clear textfield
                getFLogin().getTId().setText(null);
                getFLogin().getTPass().setText(null);
            }else{
                getFLogin().dispose();
                getFUtama().getMenuKelola().setVisible(true);
                getFUtama().getMenuFileLogin().setEnabled(false);
                getFUtama().getMenuFileLogout().setEnabled(true);
                getFUtama().getlbAkun().setText(id);
                getFLogin().getTId().setText(null);
                getFLogin().getTPass().setText(null);
            }
        }else if(bTemp == getFLogin().getBCancel()){ //tidak jadi login
            getFLogin().getTId().setText(null);
            getFLogin().getTPass().setText(null);
        }else if(mTemp == getFUtama().getMenuFileLogout()){ //logout
            getFUtama().getMenuFileLogin().setEnabled(true);
            getFUtama().getMenuFileLogout().setEnabled(false);
            JOptionPane.showMessageDialog(null, "Anda berhasil logout");
            getFUtama().getlbAkun().setText(null);
            getApp().setAkunAktif(null);
            getApp().setStatAkun(false);
        }else if(bTemp == getFUtama().getbtSearch()){
            Maskapai makstemp = null;
            Jadwal jd = null;
            Ticket t = null ;
            int jum=0;
            String tanggal = (String)getFUtama().getCbTanggal().getSelectedItem();
            String dari = (String)getFUtama().getCbdari().getSelectedItem();
            String ke = (String)getFUtama().getCbKe().getSelectedItem();
            for(int i=0;i<getApp().getListMaskapai().size();i++){    
                for(int j=0;j<getApp().getListMaskapai().get(i).getListJadwal().size();j++){
                    for(int k=0;k<getApp().getListMaskapai().get(i).getListJadwal().get(j).getListTicket().size();k++){
                        if((getApp().getListMaskapai().get(i).getListJadwal().get(j).getTanggal().equals(tanggal)&&(getApp().getListMaskapai().get(i).getListJadwal().get(j).getDari().equals(dari))&&(getApp().getListMaskapai().get(i).getListJadwal().get(j).getKe().equals(ke)))){
                            getFUtama().getTTicket().setValueAt(getApp().getListMaskapai().get(i).getNama(),jum, 0);
                            getFUtama().getTTicket().setValueAt(getApp().getListMaskapai().get(i).getListJadwal().get(j).getTanggal(),jum, 1);
                            getFUtama().getTTicket().setValueAt(getApp().getListMaskapai().get(i).getListJadwal().get(j).getListTicket().get(k).getJam(), jum, 2);
                            getFUtama().getTTicket().setValueAt(getApp().getListMaskapai().get(i).getListJadwal().get(j).getListTicket().get(k).getHargaDws(), jum, 3);
                            getFUtama().getTTicket().setValueAt(getApp().getListMaskapai().get(i).getListJadwal().get(j).getListTicket().get(k).getHargaAnak2(), jum, 4);
                            getFUtama().getTTicket().setValueAt(getApp().getListMaskapai().get(i).getListJadwal().get(j).getListTicket().get(k).getIdTicket(), jum, 5);
                            
                            jum++;
                        }
                    }
                    
                }
            }
        }else if(bTemp == getFPesan().getBPesan()){
            try{
            int jum = Integer.parseInt(getFPesan().getTDws().getText())+Integer.parseInt(getFPesan().getTAnak2().getText())+Integer.parseInt(getFPesan().getTBayi().getText());
            double total = Integer.parseInt(getFPesan().getTDws().getText())*(double)getFUtama().getTTicket().getValueAt(getFUtama().getTTicket().getSelectedRow(), 3);
            double total2 = Integer.parseInt(getFPesan().getTAnak2().getText())*(double)getFUtama().getTTicket().getValueAt(getFUtama().getTTicket().getSelectedRow(), 4);
            double totAkhir = total +total2;
            String ktp = getFPesan().getTNoKTP().getText();
            int usia = Integer.parseInt(getFPesan().getTUsia().getText());
            
            getApp().pesanTiket(getFPesan().getTNama().getText(),ktp,usia, getFPesan().getTAlamat().getText(),getFPesan().getTNoHP().getText(),id2,jum,totAkhir );
            }catch(Exception z){
                System.out.println(z.getMessage());
            }
        }else if(mTemp == getFUtama().getMenuFileExit()){
            System.exit(0); //keluar dari aplikasi
        }
    }
    
}
