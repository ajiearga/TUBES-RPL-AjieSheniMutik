/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PlaneTicketReservation;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Database.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ajie
 */
public class Aplikasi {
    private ArrayList<Maskapai> listMaskapai;
    private ArrayList<Customer> listCustomer;
    private String akunAktif;
    private boolean statAkun;
    private Database db;
    
    public Aplikasi() {
        this.listMaskapai = new ArrayList<>();
        this.listCustomer = new ArrayList<>();
        db = new Database();
    }

    public void setAkunAktif(String akunAktif) {
        this.akunAktif = akunAktif;
    }

    public void setStatAkun(boolean statAkun) {
        this.statAkun = statAkun;
    }

    public String getAkunAktif() {
        return akunAktif;
    }

    public boolean isStatAkun() {
        return statAkun;
    }

    public ArrayList<Maskapai> getListMaskapai() {
        return listMaskapai;
    }
    
    public void addMaskapai(){
        try {
            String stmt = "select * from maskapai";
            ResultSet rs = db.getData(stmt);
            int i = 0;
            while(rs.next()){
                getListMaskapai().add(new Maskapai(null,null));
                getListMaskapai().get(i).setIdMaskapai(rs.getString("idMaskapai"));
                getListMaskapai().get(i).setNama(rs.getString("namaMaskapai"));
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addJadwal(){
        try {
            for(int i=0;i<getListMaskapai().size();i++){
                String stmt = "select m.idMaskapai,j.idjadwal,j.tanggal,j.dari,j.ke from maskapai m,jadwal j where m.idMaskapai=j.idMaskapai and m.idMaskapai='"+getListMaskapai().get(i).getIdMaskapai()+"'";
                ResultSet rs = db.getData(stmt);
                int j=0;
                while(rs.next()){
                    getListMaskapai().get(i).getListJadwal().add(new Jadwal(null, null, null, null));                    
                    getListMaskapai().get(i).getListJadwal().get(j).setIdJadwal(rs.getString(2));
                    getListMaskapai().get(i).getListJadwal().get(j).setTanggal(rs.getString(3));
                    getListMaskapai().get(i).getListJadwal().get(j).setDari(rs.getString(4));
                    getListMaskapai().get(i).getListJadwal().get(j).setKe(rs.getString(5));
                    j++;
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addTicket(){
        try {
            ResultSet rs = null;
            String stmt = null;
            for(int i=0;i<getListMaskapai().size();i++){
                System.out.println(getListMaskapai().get(i).getNama());
                for(int j=0;j<getListMaskapai().get(i).getListJadwal().size();j++){
                    System.out.println(getListMaskapai().get(i).getListJadwal().get(j).getTanggal());
                    stmt = "SELECT t.idTicket,j.tanggal,t.jam,t.hargaDewasa,t.hargaAnak,t.jumTiket FROM jadwal j ,ticket t,Maskapai m where m.idMaskapai=j.idMaskapai and j.idjadwal=t.idjadwal and m.idMaskapai='"+getListMaskapai().get(i).getIdMaskapai()+"' and j.tanggal='"+getListMaskapai().get(i).getListJadwal().get(j).getTanggal()+"'";
                    rs = db.getData(stmt);
                    int k=0;
                    while(rs.next()){
                        getListMaskapai().get(i).getListJadwal().get(j).getListTicket().add(new Ticket(0, null, 0, 0, 0));                    
                        getListMaskapai().get(i).getListJadwal().get(j).getListTicket().get(k).setIdTicket(Long.parseLong(rs.getString(1)));
                        getListMaskapai().get(i).getListJadwal().get(j).getListTicket().get(k).setJam(rs.getString(3));
                        getListMaskapai().get(i).getListJadwal().get(j).getListTicket().get(k).setHargaDws(Double.parseDouble(rs.getString(4)));
                        getListMaskapai().get(i).getListJadwal().get(j).getListTicket().get(k).setHargaAnak2(Double.parseDouble(rs.getString(5)));
                        getListMaskapai().get(i).getListJadwal().get(j).getListTicket().get(k).setJumTiket(Integer.parseInt(rs.getString(6)));
                        
                        System.out.println(getListMaskapai().get(i).getListJadwal().get(j).getListTicket().get(k).getJam());
                        k++;
                    }
                }   
            }            
        } catch (SQLException ex) {
            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addManager(){
        try {
            for(int i=0;i<getListMaskapai().size();i++){
                String stmt = "SELECT m.idMaskapai,mng.idManager,mng.username,mng.password,mng.nama,mng.umur,mng.gaji,mng.tunjangan FROM Maskapai m, manager mng where m.idMaskapai = mng.idMaskapai and m.idMaskapai='"+getListMaskapai().get(i).getIdMaskapai()+"'";
                ResultSet rs = db.getData(stmt);
                int j=0;
                while(rs.next()){
                    getListMaskapai().get(i).setManager(new Manager(null,null,null, null, 0, 0, 0));
                    getListMaskapai().get(i).getManager().setIdManager(rs.getString(2));
                    getListMaskapai().get(i).getManager().setUsername(rs.getString(3));
                    getListMaskapai().get(i).getManager().setPassword(rs.getString(4));
                    getListMaskapai().get(i).getManager().setNama(rs.getString(5));
                    getListMaskapai().get(i).getManager().setUmur(Integer.parseInt(rs.getString(6)));
                    getListMaskapai().get(i).getManager().setGaji(Double.parseDouble(rs.getString(7)));
                    getListMaskapai().get(i).getManager().setTunjangan(Double.parseDouble(rs.getString(8)));
                    j++;
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addPegawai(){
        try {
            for(int i=0;i<getListMaskapai().size();i++){
                String stmt = "SELECT m.idMaskapai,mng.idManager,p.idPegawai,p.username,p.password,p.nama,p.gaji,p.bonus FROM Maskapai m, manager mng,pegawai p where m.idMaskapai = mng.idMaskapai and mng.idManager=p.idManager and m.idMaskapai='"+getListMaskapai().get(i).getIdMaskapai()+"'";
                ResultSet rs = db.getData(stmt);
                int j=0;
                while(rs.next()){
                    getListMaskapai().get(i).getManager().getListPegawai().add(new Pegawai(null, null, null, null, null, 0, 0));
                    getListMaskapai().get(i).getManager().getListPegawai().get(j).setIdPegawai(rs.getString(3));
                    getListMaskapai().get(i).getManager().getListPegawai().get(j).setUsername(rs.getString(4));
                    getListMaskapai().get(i).getManager().getListPegawai().get(j).setPassword(rs.getString(5));
                    getListMaskapai().get(i).getManager().getListPegawai().get(j).setNama(rs.getString(6));
                    getListMaskapai().get(i).getManager().getListPegawai().get(j).setGaji(Double.parseDouble(rs.getString(7)));
                    getListMaskapai().get(i).getManager().getListPegawai().get(j).setBonus(Double.parseDouble(rs.getString(7)));
                    j++;
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void pesanTiket(String nama,String noKTP,int usia,String alamat,String noHp,String idTicket,int jumlah,double total){
        try {
            String s = "insert into Customer values(null,'"+nama+"','"+noKTP+"','"+usia+"','"+alamat+"','"+noHp+"')";
            db.query(s);
            db = new Database();
            String stmt = "select * from Customer";
            ResultSet rs = db.getData(stmt); 
            String a=null;
            while(rs.next()){
                 a = rs.getString("idCustomer");
            }
            String s1 = "insert into transaksi values(null,'"+idTicket+"','"+a+"','"+jumlah+"','"+total+"','Pesan')";
            db = new Database();
            db.query(s1);
            String s2 = "update Ticket set jumTiket = jumTiket - "+jumlah+" where idTicket='"+idTicket+"'";
            db = new Database();
            db.query(s2);
            JOptionPane.showMessageDialog(null, "Pesan berhasil");
        } catch (SQLException ex) {
            Logger.getLogger(Aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean login(String id,String pass){
        if(id.equals("001") && pass.equals("ajie")){
            JOptionPane.showMessageDialog(null, "Selamat datang "+id);
            setAkunAktif(id);
            setStatAkun(true);
        }else{
            JOptionPane.showMessageDialog(null, "id dan password salah!!");
            setStatAkun(false);
        }
        return isStatAkun();
    }
    
    
    
    public Customer cariCustomer(){
        return null;
    }
}
