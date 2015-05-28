package szarhuber.at.biosearch;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by szarhuber on 21.05.2015.
 */
public class DetailClass extends ListActivity
{
    ArrayList<Markt> markets;
    int plz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity_);
        ListView lv = getListView();

        Intent intent = getIntent();
        plz = intent.getIntExtra("plz", 1);
        switch (plz)
        {
            case 4676: markets = (ArrayList<Markt>)intent.getSerializableExtra("4676"); break;
            case 4720: markets = (ArrayList<Markt>)intent.getSerializableExtra("4720"); break;

            default: Log.i("SZARHUBER", "No available List");
        }
        displayItems();
    }

    public void displayItems()
    {
        ArrayAdapter<Markt> arrayAdapter = new ArrayAdapter<Markt>(this, android.R.layout.simple_list_item_1, markets);
        setListAdapter(arrayAdapter);
    }
}
