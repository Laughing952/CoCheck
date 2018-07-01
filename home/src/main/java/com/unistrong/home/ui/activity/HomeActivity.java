package com.unistrong.home.ui.activity;

import android.os.Bundle;

import com.unistrong.home.R;
import com.waterbase.ui.BaseTitleActivity;

public class HomeActivity extends BaseTitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView(R.layout.activity_home);
    }
}
