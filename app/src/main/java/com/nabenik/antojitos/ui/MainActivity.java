package com.nabenik.antojitos.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.nabenik.antojitos.R;

public class MainActivity extends AppCompatActivity {

    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = FirebaseAuth.getInstance().getCurrentUser();
        showUserName();
        findViewById(R.id.btn_logout).setOnClickListener(view -> doLogout());
    }


    private void showUserName() {
        if(user != null) {
            findViewById(R.id.btn_login).setVisibility(View.INVISIBLE);
            ((TextView)findViewById(R.id.tv_hello)).setText(
                    String.format("Hola %s!!!", user.getDisplayName())
            );
        }
    }

    private void doLogout() {
        AuthUI.getInstance()
                .signOut(this)
                .addOnCompleteListener(task -> finish());
    }
}
