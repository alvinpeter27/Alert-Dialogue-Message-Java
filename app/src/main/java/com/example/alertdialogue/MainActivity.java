    package com.example.alertdialogue;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button closeButton;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        closeButton=(Button) findViewById(R.id.fbutton);
        builder=new AlertDialog.Builder(this);

            closeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    builder.setMessage("Do you want to close this application")
                            .setCancelable(false)
                            .setPositiveButton("yes", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                    Toast.makeText(getApplicationContext(), "you choose yes action for alertbox", Toast.LENGTH_SHORT).show();
                                }
                            })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            Toast.makeText(getApplicationContext(), "you choose no action for alertbox", Toast.LENGTH_SHORT).show();
                        }
                    });

                    AlertDialog alert=builder.create();
                    alert.setTitle("AlertDialogExample");
                    alert.show();


                }
            });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}