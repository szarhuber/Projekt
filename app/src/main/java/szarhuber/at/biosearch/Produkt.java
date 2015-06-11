package szarhuber.at.biosearch;

import java.io.Serializable;

/**
 * Created by szarhuber on 11.06.2015.
 */
public class Produkt implements Serializable
{
    String name;
    double price;

    public Produkt(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Produkt: "+ name + ", "+price+",-";
    }
}
