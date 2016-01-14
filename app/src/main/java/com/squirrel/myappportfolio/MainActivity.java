package com.squirrel.myappportfolio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LinearLayout buttonsLayout = (LinearLayout) findViewById(R.id.buttons_linear_layout);
        int buttonsNumber = buttonsLayout.getChildCount();

        for(int i =0; i < buttonsNumber; i++){
            View buttonView = buttonsLayout.getChildAt(i);
            if (buttonView instanceof Button) {
                setButton((Button) buttonView);
            }
        }
    }

    /**
     * Sets button onClick Listener and toast message
     * @param button
     */
    private void setButton(Button button){
        String appName = button.getText().toString();

        if(appName ==""){
            Log.e(LOG_TAG, "Button has no application assigned or no text!");
            button.setClickable(false);
            return;
        }

        final String message = getMessage(appName);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });


    }

    /**
     * Get toast message which will be shown when button is pressed
     * @param appName - name of the application which is shown on the button
     * @return toasm message text
     */
    private String getMessage(String appName){
        return getString(R.string.toast_message_beginning) + appName + getString(R.string.toast_message_end);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_about) {
            //When the About action is pressed on the Action bar
            Intent aboutIntent = new Intent(this, AboutActivity.class);
            startActivity(aboutIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
