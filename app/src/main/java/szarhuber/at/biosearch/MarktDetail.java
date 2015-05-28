package szarhuber.at.biosearch;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pnobis on 28.05.2015.
 */
public class MarktDetail extends Activity {

    TextView name, ort, strasse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        name = (TextView) findViewById(R.id.textView3);
        ort = (TextView) findViewById(R.id.textView4);
        strasse = (TextView) findViewById(R.id.textView5);


    }

    public void phone(View v) {

    }

    public void mail(View v) {

    }
}
