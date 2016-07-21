package appewtc.masterung.testdrivinglicense;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CoauseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coause);
    }   // Main Method

    public void clickBackCoaurse(View view) {
        finish();
    }

}   // Main Class
