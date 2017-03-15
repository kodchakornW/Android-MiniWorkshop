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
    private Button buttonSubmit;

    private List<Member> listMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://161.246.103.128/member_database/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService service = retrofit.create(ApiService.class);
        Call<List<Member>> call = service.retrieveMember();

        call.enqueue(new Callback<List<Member>>() {
            @Override
            public void onResponse(Call<List<Member>> call,
                                   Response<List<Member>> response) {
                if (response.isSuccessful()) {
                    listMember = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<Member>> call,
                                  Throwable t) {
                Toast.makeText(getApplicationContext(),
                        "Unable to load data",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == buttonSubmit) {
            // When click it's call here.
            String username = editUsername.getText().toString();
            String password = editPassword.getText().toString();
            boolean hasUser = false;

            for (Member aMember : listMember) {
                if (aMember.getUsername().equals(username)) {
                    hasUser = true;
                    if (aMember.getPassword().equals(password)) {
                        Toast.makeText(getApplicationContext(),
                                "Login Successful",
                                Toast.LENGTH_SHORT)
                                .show();
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Password Incorrect",
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                }
            }
            if (!hasUser) {
                Toast.makeText(getApplicationContext(),
                        "Not has this user",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }

    private void initUi() {
        editUsername = (EditText) findViewById(R.id.edit_username);
        editPassword = (EditText) findViewById(R.id.edit_password);
        buttonSubmit = (Button) findViewById(R.id.button_login);

        buttonSubmit.setOnClickListener(this);
    }
}
