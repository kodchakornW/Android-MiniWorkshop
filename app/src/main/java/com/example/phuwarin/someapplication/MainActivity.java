package com.example.phuwarin.someapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editUsername;
    private EditText editPassword;
    private EditText editEmail;
    private Button buttonSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUsername = (EditText) findViewById(R.id.edit_username);
        editPassword = (EditText) findViewById(R.id.edit_password);
        editEmail = (EditText) findViewById(R.id.edit_email);
        buttonSubmit = (Button) findViewById(R.id.button_login);

        buttonSubmit.setOnClickListener(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.34/member_database/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService service = retrofit.create(ApiService.class);
        Call<List<Member>> call = service.retrieveMember();
        
        call.enqueue(new Callback<List<Member>>() {
            @Override
            public void onResponse(Call<List<Member>> call, Response<List<Member>> response) {
                Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Member>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == buttonSubmit) {
            // When click it's call here.
            String username = editUsername.getText().toString();
            String password = editPassword.getText().toString();
            String email = editEmail.getText().toString();

            Toast.makeText(this, "username = " + username +
                            "  password = " + password +
                            "  email = " + email, Toast.LENGTH_LONG).show();
        }
    }
}
