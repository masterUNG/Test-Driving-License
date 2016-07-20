package appewtc.masterung.testdrivinglicense;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private EditText userEditText, passwordEditText;
    private String userString, passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initial Widget
        userEditText = (EditText) findViewById(R.id.editText6);
        passwordEditText = (EditText) findViewById(R.id.editText7);


    }   // Main Method

    //Create Inner Class
    private class SynUser extends AsyncTask<Void, Void, String> {

        //Explicit
        private Context context;
        private String myUserString, myPasswordString,
                truePasswordString, loginNameString,
                loginAgeString, loginIDString;
        private static final String urlJSON = "http://swiftcodingthai.com/toey/get_user_master.php";
        private boolean statusABoolean = true;
        private String[] loginStrings;

        public SynUser(Context context, String myUserString, String myPasswordString) {
            this.context = context;
            this.myUserString = myUserString;
            this.myPasswordString = myPasswordString;
        }   // Constructor

        @Override
        protected String doInBackground(Void... voids) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(urlJSON).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();

            } catch (Exception e) {
                Log.d("20JulyV1", "e doIn ==> " + e.toString());
                return null;
            }
        }   // doInBack

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("20JulyV1", "JSON ==> " + s);

            try {

                JSONArray jsonArray = new JSONArray(s);
                for (int i=0;i<jsonArray.length();i+=1) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    if (myUserString.equals(jsonObject.getString("User"))) {

                        statusABoolean = false;
                        truePasswordString = jsonObject.getString("Password");
                        loginNameString = jsonObject.getString("Name") + " " +
                                jsonObject.getString("Surname");
                        loginAgeString = jsonObject.getString("Age");
                        loginIDString = jsonObject.getString("id");

                    }   // if
                }   // for

                //Check User
                if (statusABoolean) {
                    //User False
                    MyAlert myAlert = new MyAlert();
                    myAlert.myDialog(context, "User False",
                            "ไม่มี " + myUserString + " ในฐานข้อมูลของเรา");
                } else if (myPasswordString.equals(truePasswordString)) {
                    //Password True
                    Toast.makeText(context, "ยินดีต้อนรับ " + loginNameString,
                            Toast.LENGTH_SHORT).show();

                    //Intent to Service
                    loginStrings = new String[3];
                    loginStrings[0] = loginIDString;
                    loginStrings[1] = loginNameString;
                    loginStrings[2] = loginAgeString;

                    Intent intent = new Intent(MainActivity.this, ServiceActivity.class);
                    intent.putExtra("login", loginStrings);
                    startActivity(intent);
                    finish();

                } else {
                    //Password False
                    MyAlert myAlert = new MyAlert();
                    myAlert.myDialog(context, "Password False",
                            "ลองใหม่ อีกครั้ง Password ผิด");
                } //if

            } catch (Exception e) {
                e.printStackTrace();
            }

        }   // onPost

    }   // SynUser Class


    public void clickSignIn(View view) {

        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        //CheckSpace
        if (userString.equals("") || passwordString.equals("")) {
            //Have Space
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "Have Space", "Please Fill All Every Blank");

        } else {
            //No Space
            SynUser synUser = new SynUser(this, userString, passwordString);
            synUser.execute();

        }   // if

    }   // clickSign

    public void clickSignUpMain(View view) {
        startActivity(new Intent(MainActivity.this, SignUpActivity.class));
    }

}   // Main Class
