package com.smartplace.ahorrolibre.init;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.smartplace.ahorrolibre.R;
import com.smartplace.ahorrolibre.main.MainActivity;

import java.io.File;


public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getActionBar().hide();

        ImageButton imageBtnFacebook = (ImageButton)findViewById(R.id.btn_login_facebook);
        ImageButton imageBtnEmail = (ImageButton)findViewById(R.id.btn_login_email);
        ImageButton imageBtnGoogle = (ImageButton)findViewById(R.id.btn_login_google);
        TextView txtBtnLoginNow = (TextView)findViewById(R.id.btn_txt_login_now);

        imageBtnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), MainActivity.class);
                startActivity(i);
            }
        });

        imageBtnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRegisterDialog();
            }
        });

        imageBtnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), MainActivity.class);
                startActivity(i);
            }
        });

        txtBtnLoginNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLoginDialog();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showLoginDialog()
    {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View promptView = inflater.inflate(R.layout.prompt_login, null);
        alertDialogBuilder.setView(promptView);

        //Get layout references
        TextView txtWelcome = (TextView) promptView.findViewById(R.id.txt_welcome);
        TextView txtAppName = (TextView) promptView.findViewById(R.id.txt_app_name);
        TextView txtHeaderLogin = (TextView)promptView.findViewById(R.id.header_login);
        TextView txtBtnRecoverPassword = (TextView)promptView.findViewById(R.id.txt_btn_recover_password);
        final EditText editEmail = (EditText)promptView.findViewById(R.id.edit_email);
        final EditText editPassword = (EditText)promptView.findViewById(R.id.edit_pasword);
        Button btnSignIn = (Button)promptView.findViewById(R.id.btn_sign_in);

        //Set type faces
        Typeface titleFont= Typeface.createFromAsset(getAssets(), "fonts/MicroExtendFLF.ttf");
        txtAppName.setTypeface(titleFont);
        titleFont= Typeface.createFromAsset(getAssets(), "fonts/OpenSansLight.ttf");
        txtWelcome.setTypeface(titleFont);
        txtHeaderLogin.setTypeface(titleFont);
        txtBtnRecoverPassword.setTypeface(titleFont);
        editEmail.setTypeface(titleFont);
        editPassword.setTypeface(titleFont);
        btnSignIn.setTypeface(titleFont);
        //Set animations
        YoYo.with(Techniques.SlideInRight).duration(700).playOn(txtWelcome);
        YoYo.with(Techniques.SlideInRight).duration(700).playOn(txtAppName);
        YoYo.with(Techniques.SlideInLeft).duration(700).playOn(promptView.findViewById(R.id.image_logo));
        YoYo.with(Techniques.SlideInLeft).duration(700).playOn(promptView.findViewById(R.id.layout_main_info));
        YoYo.with(Techniques.SlideInLeft).duration(700).playOn(txtHeaderLogin);
        YoYo.with(Techniques.SlideInRight).duration(700).playOn(txtBtnRecoverPassword);
        YoYo.with(Techniques.SlideInRight).duration(700).playOn(btnSignIn);

        //Set click listeners
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), MainActivity.class);
                startActivity(i);
            }
        });
        txtBtnRecoverPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }
    public void showRegisterDialog()
    {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View promptView = inflater.inflate(R.layout.prompt_register, null);
        alertDialogBuilder.setView(promptView);

        //Get layout references
        TextView txtWelcome = (TextView) promptView.findViewById(R.id.txt_welcome);
        TextView txtAppName = (TextView) promptView.findViewById(R.id.txt_app_name);
        TextView txtHeaderRegister = (TextView)promptView.findViewById(R.id.header_register);
        final EditText editEmail = (EditText)promptView.findViewById(R.id.edit_email);
        final EditText editName = (EditText)promptView.findViewById(R.id.edit_name);
        final EditText editLastName = (EditText)promptView.findViewById(R.id.edit_last_name);
        final EditText editPhoneNumber = (EditText)promptView.findViewById(R.id.edit_phone_number);
        final EditText editPassword = (EditText)promptView.findViewById(R.id.edit_password);
        final EditText editPasswordConfirm = (EditText)promptView.findViewById(R.id.edit_password_confirm);
        Button btnSignUp = (Button)promptView.findViewById(R.id.btn_sign_up);

        //Set type faces
        Typeface titleFont= Typeface.createFromAsset(getAssets(), "fonts/MicroExtendFLF.ttf");
        txtAppName.setTypeface(titleFont);
        titleFont= Typeface.createFromAsset(getAssets(), "fonts/OpenSansLight.ttf");
        txtWelcome.setTypeface(titleFont);
        txtHeaderRegister.setTypeface(titleFont);
        editEmail.setTypeface(titleFont);
        editName.setTypeface(titleFont);
        editLastName.setTypeface(titleFont);
        editPhoneNumber.setTypeface(titleFont);
        editPassword.setTypeface(titleFont);
        editPasswordConfirm.setTypeface(titleFont);
        btnSignUp.setTypeface(titleFont);
        //Set animations
        YoYo.with(Techniques.SlideInRight).duration(700).playOn(txtWelcome);
        YoYo.with(Techniques.SlideInRight).duration(700).playOn(txtAppName);
        YoYo.with(Techniques.SlideInLeft).duration(700).playOn(promptView.findViewById(R.id.image_logo));
        YoYo.with(Techniques.SlideInLeft).duration(700).playOn(promptView.findViewById(R.id.layout_main_info));
        YoYo.with(Techniques.SlideInLeft).duration(700).playOn(txtHeaderRegister);
        YoYo.with(Techniques.SlideInRight).duration(700).playOn(btnSignUp);

        //Set click listeners
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), MainActivity.class);
                startActivity(i);
            }
        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }

}
