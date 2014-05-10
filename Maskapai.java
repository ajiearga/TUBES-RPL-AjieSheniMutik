package PlaneTicketReservation;

import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ajie
 */
public class Maskapai {
    private String idMaskapai;
    private String nama;
    private Manager manager;
    private ArrayList<Jadwal> listJadwal;
        
    public Maskapai(String idMaskapai, String nama) {
        this.idMaskapai = idMaskapai;
        this.nama = nama;
        this.manager = new Manager(null,null,null, null, 0, 0, 0);
        this.listJadwal = new ArrayList<>();
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
    
    public void setListJadwal(ArrayList<Jadwal> listJadwal) {
        this.listJadwal = listJadwal;
    }

    public Manager getManager() {
        return manager;
    }
    
    public ArrayList<Jadwal> getListJadwal() {
        return listJadwal;
    }

    public String getIdMaskapai() {
        return idMaskapai;
    }

    public String getNama() {
        return nama;
    }

    public void setIdMaskapai(String idMaskapai) {
        this.idMaskapai = idMaskapai;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
}
