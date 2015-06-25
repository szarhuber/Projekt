package szarhuber.at.biosearch;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.xmlpull.v1.XmlSerializer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;


/**
 * Created by pnobis on 18.06.2015.
 */
public class WishList extends ListActivity {

    ArrayList<Produkt> cachingList = new ArrayList<Produkt>();
    final static String TAG = "Success";
    ArrayAdapter<Produkt> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wish_activity);

        Intent intent = getIntent();
        cachingList = (ArrayList<Produkt>) intent.getSerializableExtra("Wunschliste");
        displayItems();
        showMessage();

        final ListView listView = getListView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cachingList.remove(position);
                listView.setAdapter(adapter);
            }
        });
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/agency_fb.ttf");
        Button button = (Button)findViewById(R.id.button4);
        Button button1 = (Button)findViewById(R.id.button5);

        button.setTypeface(type);
        button1.setTypeface(type);
    }

    private void showMessage() {

        Toast t = Toast.makeText(this, R.string.orderSuccess, Toast.LENGTH_LONG);
        t.show();
    }

    public void displayItems()
    {
        adapter = new ArrayAdapter<Produkt>(this, android.R.layout.simple_list_item_1, cachingList);
        setListAdapter(adapter);
    }

    public void onClickXML(final View view)
    {
        try {
            XmlSerializer xmlSerializer = Xml.newSerializer();
            StringWriter write = new StringWriter();

            Produkt p = cachingList.get(0);
            String artikel = p.getName();
            double preis = p.getPrice();

            xmlSerializer.setOutput(new FileWriter(String.valueOf(getAssets().open("fahrzeuge.xml"))));
            //start Document
            xmlSerializer.startDocument("UTF-8", false);
            //open tag <items>
            xmlSerializer.startTag("", "Wunschliste");

            xmlSerializer.startTag("", "Wunsch");
            xmlSerializer.attribute("", "Artikel", artikel);
            xmlSerializer.endTag("", "Wunsch");

            xmlSerializer.startTag("", "Preis");
            xmlSerializer.text("" + preis);
            xmlSerializer.endTag("", "Preis");



            xmlSerializer.flush();
            File file = new File(Environment.getExternalStorageDirectory().getPath() + "/data.xml");
            if (file.exists()) {
                try {

                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] array = line.split(";");
                        Log.i("szarhuber", line);
                    }

                } catch (IOException ex) {
                    Log.i("szarhuber", "Fehler!");
                }
                Log.i("szarhuber", "Geklappt!");

            } else {
                Log.i("szarhuber", "Nicht geklappt!");
            }
            Log.i("szarhuber", "Fertig!");
        }
        catch(IOException ex)
        {
            Log.i("SZARHUBER", ex.getMessage());
        }
    }

    public void onClickCancel1(final View view)
    {
        Intent intent = new Intent(this, BioSearch.class);
        startActivity(intent);
    }
}
