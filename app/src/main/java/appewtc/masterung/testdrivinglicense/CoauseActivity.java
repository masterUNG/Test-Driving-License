package appewtc.masterung.testdrivinglicense;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

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
        private String[] titleStrings, detailStrings, imageStrings;

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

            try {

                JSONArray jsonArray = new JSONArray(s);

                titleStrings = new String[jsonArray.length()];
                detailStrings = new String[jsonArray.length()];
                imageStrings = new String[jsonArray.length()];

                for (int i=0;i<jsonArray.length();i+=1) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    titleStrings[i] = jsonObject.getString("Title");
                    detailStrings[i] = jsonObject.getString("Detail");
                    imageStrings[i] = jsonObject.getString("Image");

                    Log.d("21JulyV2", "image(" + i + ")= " + imageStrings[i].length());

                }   // for

                CoaurseAdapter coaurseAdapter = new CoaurseAdapter(context, 0,
                        titleStrings, detailStrings);
                coaurseListView.setAdapter(coaurseAdapter);

                coaurseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Intent intent = new Intent(CoauseActivity.this, DetailCoaruseActivity.class);
                        intent.putExtra("Title", titleStrings[i]);
                        intent.putExtra("Detail", detailStrings[i]);
                        intent.putExtra("Image", imageStrings[i]);
                        startActivity(intent);

                    }   // onItemClick
                });

            } catch (Exception e) {
                e.printStackTrace();
            }

        }   // onPost

    }   // SynCoaurse Class


    public void clickBackCoaurse(View view) {
        finish();
    }

}   // Main Class
