/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PlaneTicketReservation;

import java.util.ArrayList;

/**
 *
 * @author Ajie
 */
public class Manager {
    private String idManager;
    private String username;
    private String password;
    private String nama;
    private int umur;
    private double gaji;
    private double tunjangan;
    private ArrayList<Pegawai> listPegawai;

    public Manager(String idManager, String username, String password, String nama, int umur, double gaji, double tunjangan) {
        this.idManager = idManager;
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.umur = umur;
        this.gaji = gaji;
        this.tunjangan = tunjangan;
        this.listPegawai = new ArrayList<>();
    }    

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdManager() {
        return idManager;
    }

    public String getNama() {
        return nama;
    }

    public int getUmur() {
        return umur;
    }

    public double getGaji() {
        return gaji;
    }

    public double getTunjangan() {
        return tunjangan;
    }

    public ArrayList<Pegawai> getListPegawai() {
        return listPegawai;
    }

    public void setIdManager(String idManager) {
        this.idManager = idManager;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }

    public void setTunjangan(double tunjangan) {
        this.tunjangan = tunjangan;
    }

    public void setListPegawai(ArrayList<Pegawai> listPegawai) {
        this.listPegawai = listPegawai;
    }
    
    
}
