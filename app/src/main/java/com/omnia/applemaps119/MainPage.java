package com.omnia.applemaps119;

import android.content.Intent;
import android.view.View;

//todo: everything

public class MainPage extends BaseActivity
{

    public void toLogIn(View view)
    {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}
