package stem.shared.pref;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private EditText etEmail;
    private EditText etPassword;
    private Button btnSet;
    private Button btnGet;
    private Button btnChk;


    public static String SHARED_PREF_NAME = "Training Practice";

    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        context = this;

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnSet = (Button) findViewById(R.id.btnSet);
        btnGet = (Button) findViewById(R.id.btnGet);
        btnChk = (Button) findViewById(R.id.btnChk);


        setListener();

    }

    private void setListener() {
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (etEmail.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please provide email id", Toast.LENGTH_SHORT).show();

                } else {
                    setStringPrefVal(KEY_EMAIL, etEmail.getText().toString());
                }


                if (etPassword.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please provide password", Toast.LENGTH_SHORT).show();

                } else {
                    setStringPrefVal(KEY_PASSWORD, etPassword.getText().toString());
                }
                Toast.makeText(MainActivity.this, "Data Saved !", Toast.LENGTH_SHORT).show();


            }
        });

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getStringPrefValue(KEY_EMAIL) == null && getStringPrefValue(KEY_PASSWORD) == null)
                    Toast.makeText(MainActivity.this, "No data found !", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(MainActivity.this, getStringPrefValue(KEY_EMAIL), Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, getStringPrefValue(KEY_PASSWORD), Toast.LENGTH_SHORT).show();

                }

            }
        });


        btnChk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, ShowActivity.class));
            }
        });
    }


    private void setStringPrefVal(String key, String value) {
        SharedPreferences prefs = this.getSharedPreferences(SHARED_PREF_NAME,
                Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();

        editor.putString(key, value);

        editor.commit();
    }

    private String getStringPrefValue(String key) {
        SharedPreferences prefs = this.getSharedPreferences(SHARED_PREF_NAME,
                Context.MODE_PRIVATE);

        return prefs.getString(key, null);

    }


}
