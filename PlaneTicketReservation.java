/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PlaneTicketReservation;

import Controller.*;
import view.*;

/**
 *
 * @author Ajie
 */
public class PlaneTicketReservation {

    /**
     * @param args the command line arguments
     */
    public static void addJadwalReserv(Aplikasi app,GUIReservation FUtama){
        boolean statJwl =false;
        for(int i=0;i<app.getListMaskapai().size();i++){
            for(int j=0;j<app.getListMaskapai().get(i).getListJadwal().size();j++){
                int k=0;
                while(k<FUtama.getCbTanggal().getItemCount()){
                    if(FUtama.getCbTanggal().getItemAt(k).equals(app.getListMaskapai().get(i).getListJadwal().get(j).getTanggal())){
                        statJwl=true;
                    }
                    k++;
                }
                if(statJwl==false){
                    FUtama.getCbTanggal().addItem(app.getListMaskapai().get(i).getListJadwal().get(j).getTanggal());
                }
            }
        }
        statJwl=false;
        for(int i=0;i<app.getListMaskapai().size();i++){
            for(int j=0;j<app.getListMaskapai().get(i).getListJadwal().size();j++){
                int k=0;
                while(k<FUtama.getCbdari().getItemCount()){
                    if(FUtama.getCbdari().getItemAt(k).equals(app.getListMaskapai().get(i).getListJadwal().get(j).getDari())){
                        statJwl=true;
                    }
                    k++;
                }
                if(statJwl==false){
                    FUtama.getCbdari().addItem(app.getListMaskapai().get(i).getListJadwal().get(j).getDari());
                }
            }
        }
        statJwl = false;
        for(int i=0;i<app.getListMaskapai().size();i++){
            for(int j=0;j<app.getListMaskapai().get(i).getListJadwal().size();j++){
                int k=0;
                while(k<FUtama.getCbKe().getItemCount()){
                    if(FUtama.getCbKe().getItemAt(k).equals(app.getListMaskapai().get(i).getListJadwal().get(j).getKe())){
                        statJwl=true;
                    }
                    k++;
                }
                if(statJwl==false){
                    FUtama.getCbKe().addItem(app.getListMaskapai().get(i).getListJadwal().get(j).getKe());
                }
                System.out.println(app.getListMaskapai().get(i).getListJadwal().get(j).getKe());
            }
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
        //inisialisasi object
        GUIReservation FUtama = new GUIReservation();
        GUIPesan FPesan = new GUIPesan();
        GUIBayar FBayar = new GUIBayar();
        GUILogin FLogin = new GUILogin();
        Aplikasi app = new Aplikasi();
        Controller control = new Controller();
        
        control.setFUtama(FUtama); //set guiUtama kedalam control
        control.setFPesan(FPesan);
        control.setFBayar(FBayar);
        control.setFLogin(FLogin);
        control.setApp(app);
        
        FUtama.getMenuKelola().setVisible(false);
        FUtama.getMenuFileLogout().setEnabled(false);
        app.addMaskapai();
        app.addJadwal();
        app.addTicket();
        addJadwalReserv(app,FUtama);
        
        control.setListener(); //memanggil method setListener
        FUtama.setVisible(true); //menampilkan gui
    }
}
