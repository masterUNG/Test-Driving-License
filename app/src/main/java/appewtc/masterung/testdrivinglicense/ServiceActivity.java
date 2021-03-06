package appewtc.masterung.testdrivinglicense;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private String[] loginStrings;
    private TextView textView;
    private ImageView hub1ImageView, hub2ImageView,
            hub3ImageView, hub4ImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        //Get Value From Intent
        loginStrings = getIntent().getStringArrayExtra("login");
        Log.d("20JulyV3", "name Login ==> " + loginStrings[1]);

        //Initial Widget
        textView = (TextView) findViewById(R.id.textView8);
        hub1ImageView = (ImageView) findViewById(R.id.imageView2);
        hub2ImageView = (ImageView) findViewById(R.id.imageView3);
        hub3ImageView = (ImageView) findViewById(R.id.imageView4);
        hub4ImageView = (ImageView) findViewById(R.id.imageView5);

        //Show Name
        textView.setText("Welcome " + loginStrings[1]);

        //Image Controller
        hub1ImageView.setOnClickListener(this);
        hub2ImageView.setOnClickListener(this);
        hub3ImageView.setOnClickListener(this);
        hub4ImageView.setOnClickListener(this);

    }   // Main Method

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.imageView2:
                startActivity(new Intent(ServiceActivity.this, CoauseActivity.class));
                break;
            case R.id.imageView3:
                startActivity(new Intent(ServiceActivity.this, LabalActivity.class));
                break;
            case R.id.imageView4:
                startActivity(new Intent(ServiceActivity.this, IshiharaActivity.class));
                break;
            case R.id.imageView5:

                chooseTimes();

                break;

        }   // switch

    }   // onClick

    private void chooseTimes() {

        CharSequence[] charSequences = new CharSequence[]{"20 ข้อ", "30 ข้อ", "40 ข้อ", "50 ข้อ"};
//        final int[] intTimes = new int[]{20, 30, 40, 50}; นี่คือต้นฉบับ
        final int[] intTimes = new int[]{2, 3, 4, 5};   // ลองให้ทำงานก่อน

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.nobita48);
        builder.setTitle("โปรดเลือกจำนวนข้อที่จะทดสอบ");
        builder.setSingleChoiceItems(charSequences, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                intentToTest(intTimes[i]);
                dialogInterface.dismiss();

            }   // onClick
        });
        builder.show();

    }   // chooseTimes

    private void intentToTest(int intTimes) {

        Intent intent = new Intent(ServiceActivity.this, TestActivity.class);
        intent.putExtra("login", loginStrings);
        intent.putExtra("Times", intTimes);
        startActivity(intent);
        finish();

    }

}   // Main Class
