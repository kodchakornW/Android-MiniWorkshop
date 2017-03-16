package com.example.phuwarin.someapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextUsername;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextPasswordConfirm;
    private Button   buttonRegister;

    ApiService service;
    Call<ResponseModel> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initialUi();
        service = RetrofitCreation.getInstance().getService();
    }

    private void initialUi() {
        editTextUsername = (EditText) findViewById(R.id.edit_username_register);
        editTextEmail = (EditText) findViewById(R.id.edit_email_register);
        editTextPassword = (EditText) findViewById(R.id.edit_password_register);
        editTextPasswordConfirm = (EditText) findViewById(R.id.edit_password_confirmation_register);
        buttonRegister = (Button) findViewById(R.id.button_register);

        buttonRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // When user click register button it's will call here!
        String username = editTextUsername.getEditableText().toString();
        String email = editTextEmail.getEditableText().toString();
        String password = editTextPassword.getEditableText().toString();
        String passwordConfirm = editTextPasswordConfirm.getEditableText().toString();

        call = service.registerMember(username, email, password);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this,
                            response.body().getResult(),
                            Toast.LENGTH_SHORT)
                            .show();
                    finish();
                    startActivity(new Intent(RegisterActivity.this,
                            MainActivity.class));
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(RegisterActivity.this,
                        "Unable to connect server",
                        Toast.LENGTH_SHORT)
                        .show();
                Log.e("errorTag", t.getMessage());
            }
        });
    }
}
