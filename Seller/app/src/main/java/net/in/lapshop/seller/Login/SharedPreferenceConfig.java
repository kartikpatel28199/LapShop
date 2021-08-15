package net.in.lapshop.seller.Login;

import android.content.Context;
import android.content.SharedPreferences;

import net.in.lapshop.seller.R;

/**
 * Created by Nikunj Ramani on 04/09/18.
 */

public class SharedPreferenceConfig {
    private static SharedPreferences sharedPreferences;
    Context ctx;

    public SharedPreferenceConfig(Context ctx) {
        this.ctx = ctx;
        sharedPreferences = ctx.getSharedPreferences(ctx.getResources().getString(R.string.login_preference), Context.MODE_PRIVATE);

    }

    void WriteLoginStatus(boolean status) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(ctx.getResources().getString(R.string.login_status_preference), status);
        editor.commit();
    }

    public boolean ReadLoginStatus() {
        boolean status = false;
        status = sharedPreferences.getBoolean(ctx.getResources().getString(R.string.login_status_preference), false);
        return status;
    }
    public static String getemail2()
    {
        return sharedPreferences.getString("email",null);
    }
    public void getEmaill(String email) {
        if (email.length() == 0) {
            String ss = email;
        } else {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("email",email);
            editor.commit();
        }
    }

}
