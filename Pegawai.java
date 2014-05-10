/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PlaneTicketReservation;

/**
 *
 * @author Ajie
 */
public class Pegawai {
    private String idPegawai;
    private String username;
    private String password;
    private String nama;
    private String jabatan;
    private double gaji;
    private double bonus;

    public Pegawai(String idPegawai, String username, String password, String nama, String jabatan, double gaji, double bonus) {
        this.idPegawai = idPegawai;
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.jabatan = jabatan;
        this.gaji = gaji;
        this.bonus = bonus;
    }

    public String getIdPegawai() {
        return idPegawai;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNama() {
        return nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public double getGaji() {
        return gaji;
    }

    public double getBonus() {
        return bonus;
    }

    public void setIdPegawai(String idPegawai) {
        this.idPegawai = idPegawai;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    
}
