/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PlaneTicketReservation;

/**
 *
 * @author Ajie
 */
public class Ticket {
    private long idTicket;
    private String jam;
    private double hargaDws;
    private double hargaAnak2;
    private int jumTiket;

    public Ticket(long idTicket, String jam, double hargaDws, double hargaAnak2, int jumTiket) {
        this.idTicket = idTicket;
        this.jam = jam;
        this.hargaDws = hargaDws;
        this.hargaAnak2 = hargaAnak2;
        this.jumTiket = jumTiket;
    }

    public void setIdTicket(long idTicket) {
        this.idTicket = idTicket;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public void setHargaDws(double hargaDws) {
        this.hargaDws = hargaDws;
    }

    public void setHargaAnak2(double hargaAnak2) {
        this.hargaAnak2 = hargaAnak2;
    }

    public void setJumTiket(int jumTiket) {
        this.jumTiket = jumTiket;
    }

    public long getIdTicket() {
        return idTicket;
    }

    public String getJam() {
        return jam;
    }

    public double getHargaDws() {
        return hargaDws;
    }

    public double getHargaAnak2() {
        return hargaAnak2;
    }

    public int getJumTiket() {
        return jumTiket;
    }  

}
