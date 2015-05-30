package szarhuber.at.biosearch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Manfred on 27.05.2015.
 */
public class MapViewActivity extends Activity
{
    private int selection = 0;
    protected MapView mapView;
    protected IMapController mapController;
    protected boolean useOnlineMap = true;
    private int zoom = 16;
    ArrayList<Markt> al;
    Context context = this;
    int switchCase;
    Markt markt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);

        Intent intent = getIntent();
        switchCase = intent.getIntExtra("All", 1);

        switch(switchCase)
        {
            case 1: al = (ArrayList<Markt>)intent.getSerializableExtra("MarketList");
            case 2: markt = (Markt)intent.getSerializableExtra("Markt");
        }
        mapView = (MapView)findViewById(R.id.map);
        initMap();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private void initMap()
    {
        mapController = mapView.getController();
        mapView.setTileSource(TileSourceFactory.MAPQUESTOSM);
        mapView.setMultiTouchControls(true);
        mapView.setBuiltInZoomControls(true);
        mapView.setUseDataConnection(useOnlineMap);
        mapController.setZoom(zoom);

        if(switchCase == 1)
        {
            Markt markt1 = al.get(2);
            addMarkers(markt1);
        }
        else
        {
            addMarkers(markt);
        }
    }

    private void addMarkers(final Markt markt)
    {
        final OverlayItem overlayItem = new OverlayItem(markt.getName(), markt.getOrt(), new GeoPoint(markt.getLongi(), markt.getLati()));
        overlayItem.setMarker(getResources().getDrawable(R.drawable.marker));
        ItemizedOverlayWithFocus<OverlayItem> itemList = new ItemizedOverlayWithFocus<OverlayItem>(Arrays.asList(overlayItem),
                new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
                    @Override
                    public boolean onItemSingleTapUp(int index, OverlayItem item) {
                        if(switchCase == 1)
                        {
                            Markt markt1 = al.get(index);
                            Toast.makeText(context, "Markt: " + markt1.getName(), Toast.LENGTH_LONG).show();
                        }
                        else if(switchCase == 2)
                        {
                            Toast.makeText(context, "Markt: " + markt.getName(), Toast.LENGTH_LONG).show();
                        }

                        return false;
                    }

                    @Override
                    public boolean onItemLongPress(int index, OverlayItem item) {
                        return false;
                    }

                }, new DefaultResourceProxyImpl(this.getApplicationContext()));
        itemList.setFocusItemsOnTap(true);
        mapView.getOverlays().add(itemList);
    }
}
