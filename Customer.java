/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PlaneTicketReservation;

/**
 *
 * @author Ajie
 */
public class Customer {
    private long idCustomer;
    private String nama;
    private int umur;

    public Customer(long idCustomer, String nama, int umur) {
        this.idCustomer = idCustomer;
        this.nama = nama;
        this.umur = umur;
    }

    public long getIdCustomer() {
        return idCustomer;
    }

    public String getNama() {
        return nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }
    
    
}
