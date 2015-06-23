package szarhuber.at.biosearch;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class BioSearch extends ActionBarActivity
{
    Context context = this;
    HashMap<String, ArrayList<Markt>> hm4676 = new HashMap<>();
    HashMap<String, ArrayList<Markt>> hm4720 = new HashMap<>();
    EditText eingabe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio_search);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/agency_fb.ttf");
        TextView textView = (TextView) findViewById(R.id.textView);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView.setTypeface(type);
        textView2.setTypeface(type);
        hm4676.put("4676", fillArrayList4676());
        hm4720.put("4720", fillArrayList4720());
        eingabe = (EditText)findViewById(R.id.editText);
        Button button = (Button)findViewById(R.id.button);
        button.setTypeface(type);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String plz = eingabe.getText().toString();
                if(Integer.parseInt(plz) == 4676)
                {
                    Intent intent = new Intent(context, DetailClass.class);
                    intent.putExtra("4676", fillArrayList4676());
                    intent.putExtra("plz", 4676);
                    startActivity(intent);
                }
                else if(Integer.parseInt(plz) == 4720)
                {
                    Intent intent = new Intent(context, DetailClass.class);
                    intent.putExtra("4720", fillArrayList4720());
                    intent.putExtra("plz", 4720);
                    startActivity(intent);
                }
                else if(Integer.parseInt(plz) == 4600)
                {
                    Intent intent = new Intent(context, DetailClass.class);
                    intent.putExtra("4600", fillArrayList4600());
                    intent.putExtra("plz", 4600);
                    startActivity(intent);
                }
                else if(Integer.parseInt(plz) == 4701)
                {
                    Intent intent = new Intent(context, DetailClass.class);
                    intent.putExtra("4701", fillArrayList4701());
                    intent.putExtra("plz", 4701);
                    startActivity(intent);
                }
                else if(Integer.parseInt(plz) == 4675)
                {
                    Intent intent = new Intent(context, DetailClass.class);
                    intent.putExtra("4675", fillArrayList4675());
                    intent.putExtra("plz", 4675);
                    startActivity(intent);
                }
                else
                {
                    if(Integer.parseInt(plz) < 4600 )
                    {

                        Toast.makeText(context, "Falsche Eingabe für PLZ." + "-> Nächster Laden in 4600", Toast.LENGTH_LONG).show();
                    }
                    else if(Integer.parseInt(plz) > 4600 && Integer.parseInt(plz) < 4676)
                    {
                        Toast.makeText(context, "Falsche Eingabe für PLZ." + "-> Nächster Laden in 4675", Toast.LENGTH_LONG).show();
                    }
                    else if(Integer.parseInt(plz) > 4676 && Integer.parseInt(plz) < 4701)
                    {
                        Toast.makeText(context, "Falsche Eingabe für PLZ." + "-> Nächster Laden in 4701", Toast.LENGTH_LONG).show();
                    }
                    else if(Integer.parseInt(plz) > 4701 && Integer.parseInt(plz) < 4720)
                    {
                        Toast.makeText(context, "Falsche Eingabe für PLZ." + "-> Nächster Laden in 4720", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(context, "Kein Laden in diesem Ort, bzw. in der Nähe", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bio_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public ArrayList<Markt> fillArrayList4675()
    {
        Markt m1 = new Markt("BioWeibern", "Bio-Shop", "Weiberner Straße 7", "bioweibern@gmx.at", 4675, 07733234556, 48.18317, 13.69695);
        Markt m2 = new Markt("BioWeibern", "Bio - Farm - Oberbauer", "Niederndorf 7", "bioweibern@gmx.at", 4675, 07733234556, 48.18411, 13.63964);
        Markt m3 = new Markt("BioWeibern", "Bio - Roitinger", "Eifel 7", "bioweibern@gmx.at", 4675, 07733234556, 48.18392, 13.70338);

        ArrayList<Markt> al4675 = new ArrayList<>();
        al4675.add(m1);
        al4675.add(m2);
        al4675.add(m3);

        return al4675;
    }

    public ArrayList<Markt> fillArrayList4676()
    {
        Markt m1 = new Markt("BioAistersheim", "Biohof - Wiesinger", "Haidenheim 18", "bioaistersheim@gmx.at", 4676, 07733234556, 48.19293, 13.73193);
        Markt m2 = new Markt("BioAistersheim", "Aistersheim", "Thalheim 4", "bioaistersheim@gmx.at", 4676, 07733234556, 48.18097, 13.75502);
        Markt m3 = new Markt("BioAistersheim", "Bio - Shop", "Haid 10", "bioaistersheim@gmx.at", 4676, 07733234556, 48.18652, 13.75768);

        ArrayList<Markt> al4676 = new ArrayList<>();
        al4676.add(m1);
        al4676.add(m2);
        al4676.add(m3);

        return al4676;
    }

    public ArrayList<Markt> fillArrayList4720()
    {
        Markt m1 = new Markt("BioNeumarkt", "Neumarkt", "Marktplatz 3", "bioneumarkt@gmx.at", 4720, 077332004, 48.27341, 13.72641);
        Markt m2 = new Markt("BioGrün", "Neumarkt", "Schulstraße 3", "bioneumarkt@gmx.at", 4720, 07733234556, 48.27372, 13.72762);
        Markt m3 = new Markt("BioSumereder", "Neumarkt", "Kimplinger Straße 2", "bioneumarkt@gmx.at", 4720, 07733234556, 48.27274, 13.72212);

        ArrayList<Markt> al4720 = new ArrayList<>();
        al4720.add(m1);
        al4720.add(m2);
        al4720.add(m3);

        return al4720;
    }

    public ArrayList<Markt> fillArrayList4600()
    {
        Markt m1 = new Markt("Welser Bio Laden", "Wels", "Kaiser-Josef Platz 3", "biowels@gmx.at", 4600, 077332004, 48.16007, 14.02529);
        Markt m2 = new Markt("Bio am Welser Ende", "Wels", "Schulstraße 3", "welserende@gmx.at", 4600, 07733234556, 48.15562, 14.00414);
        Markt m3 = new Markt("Regionale Bauern", "Wels", "Kimplinger Straße 2", "regiobauern@gmx.at", 4600, 07733234556, 48.16542, 14.03664);

        ArrayList<Markt> al4600 = new ArrayList<>();
        al4600.add(m1);
        al4600.add(m2);
        al4600.add(m3);

        return al4600;
    }

    public ArrayList<Markt> fillArrayList4701()
    {
        Markt m1 = new Markt("BioSchallerbach", "Bad Schallerbach", "Stelzhamerstraße 4", "bioschallerbach@gmx.at", 4701, 07733234556, 48.22729, 13.91375);
        Markt m2 = new Markt("Schallerbacher Köstlichkeiten", "Bad Schallerbach", "Schulstraße 6", "koestlichkeiten@gmx.at", 4701, 07733234556, 48.23377, 13.91997);
        Markt m3 = new Markt("Regional & Gut", "Bad Schallerbach", "Gablstraße 7", "bioweibern@gmx.at", 4701, 07733234556, 48.22655, 13.92233);

        ArrayList<Markt> al4701 = new ArrayList<>();
        al4701.add(m1);
        al4701.add(m2);
        al4701.add(m3);

        return al4701;
    }
}
