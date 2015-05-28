package szarhuber.at.biosearch;

import java.io.Serializable;

/**
 * Created by szarhuber on 28.05.2015.
 */
public class Markt implements Serializable
{
    String name, ort, straße, email;
    int plz, telNr;

    public Markt(String name, String ort, String straße, String email, int plz, int telNr) {
        this.name = name;
        this.ort = ort;
        this.straße = straße;
        this.email = email;
        this.plz = plz;
        this.telNr = telNr;
    }

    @Override
    public String toString() {
        return "Markt: "+name + " " + ort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getStraße() {
        return straße;
    }

    public void setStraße(String straße) {
        this.straße = straße;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public int getTelNr() {
        return telNr;
    }

    public void setTelNr(int telNr) {
        this.telNr = telNr;
    }
}
