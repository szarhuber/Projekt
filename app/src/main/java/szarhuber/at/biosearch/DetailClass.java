package szarhuber.at.biosearch;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by szarhuber on 21.05.2015.
 */
public class DetailClass extends ListActivity
{
    ArrayList<Markt> markets;
    int plz;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity_);
        ListView lv = getListView();
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/agency_fb.ttf");


        final Intent intent = getIntent();
        plz = intent.getIntExtra("plz", 1);
        switch (plz)
        {
            case 4676: markets = (ArrayList<Markt>)intent.getSerializableExtra("4676"); break;
            case 4720: markets = (ArrayList<Markt>)intent.getSerializableExtra("4720"); break;
            case 4600: markets = (ArrayList<Markt>)intent.getSerializableExtra("4600"); break;
            case 4701: markets = (ArrayList<Markt>)intent.getSerializableExtra("4701"); break;

            default: Log.i("SZARHUBER", "No available List");
        }
        displayItems();

        Button map = (Button)findViewById(R.id.button);
        map.setTypeface(type);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MapViewActivity.class);
                intent.putExtra("MarketList", markets);
                intent.putExtra("All", 1);
                startActivity(intent);
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(context, MapViewActivity.class);
                intent1.putExtra("Markt", markets.get(i));
                intent1.putExtra("All", 2);
                startActivity(intent1);
            }
        });
    }

    public void displayItems()
    {
        ArrayAdapter<Markt> arrayAdapter = new ArrayAdapter<Markt>(this, android.R.layout.simple_list_item_1, markets);
        setListAdapter(arrayAdapter);
    }
}
