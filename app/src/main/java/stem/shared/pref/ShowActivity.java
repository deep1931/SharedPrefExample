package stem.shared.pref;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {


    private TextView txtEmail;
    private TextView txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        init();
    }

    private void init() {
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtPassword = (TextView) findViewById(R.id.txtPassword);

        txtEmail.setText(getStringPrefValue(MainActivity.KEY_EMAIL));
        txtPassword.setText(getStringPrefValue(MainActivity.KEY_PASSWORD));

    }


    private String getStringPrefValue(String key) {
        SharedPreferences prefs = this.getSharedPreferences(MainActivity.SHARED_PREF_NAME,
                Context.MODE_PRIVATE);

        return prefs.getString(key, null);

    }

}
