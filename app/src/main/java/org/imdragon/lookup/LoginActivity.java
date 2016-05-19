package org.imdragon.lookup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    
    public void login(View v){
        startActivity(new Intent(this, MainActivity.class));
    }

    public void register(View v){
        Toast.makeText(LoginActivity.this, "This will send a registration request", Toast.LENGTH_SHORT).show();
    }

}
