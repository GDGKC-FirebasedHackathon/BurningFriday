package com.gdgkorea.partispot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GetStartedActivity extends AppCompatActivity implements View.OnClickListener{

    Button adminVersion;
    Button partTimerVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        adminVersion = (Button) findViewById(R.id.adminVersion);
        partTimerVersion = (Button) findViewById(R.id.partTimerVersion);
        adminVersion.setOnClickListener(this);
        partTimerVersion.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.partTimerVersion) {
            Intent signIntent = new Intent(GetStartedActivity.this, SignInActivity.class);
            startActivity(signIntent);

        } else if (id == R.id.adminVersion) {
            Intent signIntent = new Intent(GetStartedActivity.this, SignInActivity.class);
            startActivity(signIntent);
        }
    }
}
