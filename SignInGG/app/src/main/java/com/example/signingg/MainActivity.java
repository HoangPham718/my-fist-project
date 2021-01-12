package com.example.signingg;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
private SignInButton btnSignIn;
private GoogleApiClient googleApiClient;
private int SIGNED_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignIn = findViewById(R.id.btnsignin);
        btnSignIn.setSize(SignInButton.SIZE_STANDARD);

        //Yêu cầu người dùng cung cấp tt email
        GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        //kết nối tới ggapi client

        googleApiClient=new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,gso).build();


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signIn=Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(signIn,SIGNED_CODE);
                if(googleApiClient.isConnected()==true)
                    Toast.makeText(getApplicationContext(),"kết nối thành công",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(this,"Kết nối thất bại",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==SIGNED_CODE)
        {
            data.getType();
            //đăng nhập
            GoogleSignInResult result=Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if(result.isSuccess())
            {

                Toast.makeText(this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,SIGNED.class));
            }
            else
            {
                Toast.makeText(this,"Đăng nhập thất bại",Toast.LENGTH_SHORT).show();
            }
        }
    }

}