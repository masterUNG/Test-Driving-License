package appewtc.masterung.testdrivinglicense;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailCoaruseActivity extends AppCompatActivity {

    //Explicit
    private TextView titleTextView, detailTextView;
    private ImageView imageView;
    private String titleString, detailString, imageString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_coaruse);

        //Initial Widget
        titleTextView = (TextView) findViewById(R.id.textView15);
        detailTextView = (TextView) findViewById(R.id.textView16);
        imageView = (ImageView) findViewById(R.id.imageView6);

        //Get Value From Intent
        titleString = getIntent().getStringExtra("Title");
        detailString = getIntent().getStringExtra("Detail");
        imageString = getIntent().getStringExtra("Image");

        //Show Text
        titleTextView.setText(titleString);
        detailTextView.setText(detailString);

        //Show Image
        if (imageString.length() != 0) {

            try {

                Picasso.with(this)
                        .load(imageString)
                        .resize(400,300)
                        .into(imageView);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }   // if

    }   // Main Method

    public void clickBackDetailCoaurse(View view) {
        finish();
    }

}   // Main Class
