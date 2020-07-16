package com.golovin.sample;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.golovin.fluentstackbar.FluentSnackbar;
import com.google.android.material.snackbar.Snackbar;

@SuppressWarnings("ConstantConditions")
public class MainActivity extends AppCompatActivity {

    private FluentSnackbar mFluentSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFluentSnackbar = FluentSnackbar.create(this);

        findViewById(R.id.button_show_success).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFluentSnackbar.create("Success")
                        .successBackgroundColor()
                        .show();
            }
        });

        findViewById(R.id.button_show_error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFluentSnackbar.create("Error")
                        .errorBackgroundColor()
                        .show();
            }
        });

        findViewById(R.id.button_show_warning).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFluentSnackbar.create("Warning")
                        .warningBackgroundColor()
                        .show();
            }
        });

        findViewById(R.id.button_show_warning_important).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFluentSnackbar.create("Important warning")
                        .warningBackgroundColor()
                        .important()
                        .setSnackbarCallbackListener(new Snackbar.Callback() {
                            @Override
                            public void onDismissed(Snackbar transientBottomBar, int event) {
                                super.onDismissed(transientBottomBar, event);
                                Toast.makeText(MainActivity.this, "Snackbar dismissed", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });

        findViewById(R.id.button_show_styled).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFluentSnackbar.create("Styled")
                        .backgroundColorRes(R.color.purple_500)
                        .actionTextColorRes(R.color.colorAccent)
                        .duration(Snackbar.LENGTH_SHORT)
                        .important()
                        .action(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "Action clicked", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setSnackbarCallbackListener(new Snackbar.Callback() {
                            @Override
                            public void onDismissed(Snackbar transientBottomBar, int event) {
                                super.onDismissed(transientBottomBar, event);
                                Toast.makeText(MainActivity.this, "Snackbar dismissed", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
    }
}
