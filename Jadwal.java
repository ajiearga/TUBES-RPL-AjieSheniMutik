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
public class Jadwal {
    private String idJadwal;
    private String tanggal;
    private String dari;
    private String ke;
    private ArrayList<Ticket> listTicket;

    public Jadwal(String idJadwal, String tanggal, String dari, String ke) {
        this.idJadwal = idJadwal;
        this.tanggal = tanggal;
        this.dari = dari;
        this.ke = ke;
        this.listTicket = new ArrayList<>();
    }

    public void setIdJadwal(String idJadwal) {
        this.idJadwal = idJadwal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setDari(String dari) {
        this.dari = dari;
    }

    public void setKe(String ke) {
        this.ke = ke;
    }

    public String getIdJadwal() {
        return idJadwal;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getDari() {
        return dari;
    }

    public String getKe() {
        return ke;
    }

    public ArrayList<Ticket> getListTicket() {
        return listTicket;
    }
}
