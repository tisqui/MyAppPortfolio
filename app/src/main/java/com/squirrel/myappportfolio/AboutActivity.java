package com.squirrel.myappportfolio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

/**
 * Created by squirrel on 1/12/16.
 */
public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        TextView aboutTextView = (TextView)findViewById(R.id.about_text);
        aboutTextView.setText(Html.fromHtml(getString(R.string.about_html_text)));
    }
}
