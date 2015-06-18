package szarhuber.at.biosearch;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
}
