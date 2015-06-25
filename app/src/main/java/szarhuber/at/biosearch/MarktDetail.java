package szarhuber.at.biosearch;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
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
        alWishlist.add(produkt1);
        alWishlist.add(produkt2);
        alWishlist.add(produkt3);
        alWishlist.add(produkt4);
        alWishlist.add(produkt5);
        alWishlist.add(produkt6);

        displayItems();

        ListView listView = getListView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                produktAuswahl.add(alWishlist.get(position));
            }
        });

        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/agency_fb.ttf");
        Button button = (Button)findViewById(R.id.button2);
        Button button1 = (Button)findViewById(R.id.button3);

        button.setTypeface(type);
        button1.setTypeface(type);
    }

    public void displayItems()
    {
        ArrayAdapter<Produkt> arrayAdapter = new ArrayAdapter<Produkt>(this, android.R.layout.simple_list_item_1, alWishlist);
        setListAdapter(arrayAdapter);
    }

    public void onClickWunschliste(final View view)
    {
        Intent wunschIntent = new Intent(this, WishList.class);
        wunschIntent.putExtra("Wunschliste", produktAuswahl);
        startActivity(wunschIntent);
    }

    public void onClickCancel(final View view)
    {
        Intent intent = new Intent(this, BioSearch.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
