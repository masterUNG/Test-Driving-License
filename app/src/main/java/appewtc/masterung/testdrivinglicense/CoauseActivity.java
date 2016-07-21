package appewtc.masterung.testdrivinglicense;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class CoauseActivity extends AppCompatActivity {

    //Explicit
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coause);

        listView = (ListView) findViewById(R.id.listView);

        SynCoaurse synCoaurse = new SynCoaurse(this, listView);
        synCoaurse.execute();

    }   // Main Method

    private class SynCoaurse extends AsyncTask<Void, Void, String> {

        //Explicit
        private Context context;
        private ListView coaurseListView;
        private static final String urlJSON = "http://swiftcodingthai.com/toey/get_coaurse_master.php";

        public SynCoaurse(Context context,
                          ListView coaurseListView) {
            this.context = context;
            this.coaurseListView = coaurseListView;
        }

        @Override
        protected String doInBackground(Void... voids) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(urlJSON).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();

            } catch (Exception e) {
                return null;
            }

        }   // doInBack

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("21JulyV1", "JSON ==> " + s);

        }   // onPost

    }   // SynCoaurse Class


    public void clickBackCoaurse(View view) {
        finish();
    }

}   // Main Class
