package com.codigosandroid.exemplointent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.codigosandroid.utils.activity.BaseActivity;

/**
 * Created by Tiago on 31/01/2018.
 */

public class TelaExemplo extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView text = new TextView(this);
        text.setText(R.string.label_1);
        setContentView(text);
        Intent it = new Intent();
        it.putExtra("msg", text.getText().toString());
        setResult(1, it);
    }
}
