package com.aesc.animbuttonloading;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aesc.buttonloading.ButtonLoading;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener,
        ButtonLoading.MyLoadingButtonClick {

    private ButtonLoading mButtonLoading;
    private Button mButtonLoadings;
    private Button mButtonNormal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents() {
        mButtonLoading = findViewById(R.id.my_loading_button);
        mButtonLoadings = findViewById(R.id.loading_btn);
        mButtonNormal = findViewById(R.id.normal_btn);

        mButtonLoading.setMyButtonClickListener(this);
        mButtonLoadings.setOnClickListener(this);
        mButtonNormal.setOnClickListener(this);

        setLoadingButtonStyle();
    }

    private void setLoadingButtonStyle() {
        mButtonLoading.setAnimationDuration(1000)
                .setButtonColor(R.color.colorAccent)
                .setButtonLabel("Consulta")
                .setButtonLabelSize(20)
                .setProgressLoaderColor(Color.WHITE)
                .setButtonLabelColor(R.color.white);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.normal_btn:
                mButtonLoading.showNormalButton();
                break;
            case R.id.loading_btn:
                mButtonLoading.showLoadingButton();
                break;
        }
    }

    @Override
    public void onMyLoadingButtonClick() {
        Toast.makeText(this, "MyLoadingButton Click", Toast.LENGTH_SHORT).show();
    }
}
