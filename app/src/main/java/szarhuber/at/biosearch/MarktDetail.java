package szarhuber.at.biosearch;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pnobis on 28.05.2015.
 */
public class MarktDetail extends ListActivity implements AdapterView.OnItemClickListener
{
    Produkt produkt1 = new Produkt("Kartoffel", 2.5);
    Produkt produkt2 = new Produkt("Mais", 3.4);
    Produkt produkt3 = new Produkt("Aertischocken", 1.5);
    Produkt produkt4 = new Produkt("Eier", 4.5);
    Produkt produkt5 = new Produkt("Brot", 3.6);
    Produkt produkt6 = new Produkt("Bio-Nudeln", 2.7);

    ArrayList<Produkt> alWishlist = new ArrayList<Produkt>();
    ArrayList<Produkt> produktAuswahl = new ArrayList<Produkt>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.market_list);
        alWishlist.add(0, produkt1);
        alWishlist.add(1, produkt2);
        alWishlist.add(2, produkt3);
        alWishlist.add(3, produkt4);
        alWishlist.add(4, produkt5);
        alWishlist.add(5, produkt6);

        displayItems();
    }

    public void displayItems()
    {
        ArrayAdapter<Produkt> arrayAdapter = new ArrayAdapter<Produkt>(this, android.R.layout.simple_list_item_1, alWishlist);
        setListAdapter(arrayAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        int i = 0;
         produktAuswahl.add(i, alWishlist.get(position));
        i++;
    }

    public void onClickWunschliste(final View view)
    {
        //TODO Intent schreiben, produktAuswahl hinzufügen und Wunschliste-Klasse erstellen
        //TODO --> Oben genanntes ist Arbeit fürn Philipp
    }

    public void onClickCancel(final View view)
    {
        Intent intent = new Intent(this, BioSearch.class);
        startActivity(intent);
    }
}
