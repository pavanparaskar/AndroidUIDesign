package com.example.abc.androiduidesign.fingerprint_auth;

import android.app.Activity;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abc.androiduidesign.R;

/**
 * Created by ABC on 12-11-2018.
 */

@RequiresApi(api = Build.VERSION_CODES.M)
public class FingerPrintHamdler extends FingerprintManager.AuthenticationCallback {
    protected Context context;

    public FingerPrintHamdler(Context context) {
        this.context = context;

    }

    public void startAuth(FingerprintManager fingerprintManager, FingerprintManager.CryptoObject object) {

        CancellationSignal cancellationSignal = new CancellationSignal();
        fingerprintManager.authenticate(object, cancellationSignal, 0, this, null);
    }

    @Override
    public void onAuthenticationError(int errorCode, CharSequence errString) {
        this.update("this is auth error" + errString, false);
    }

    @Override
    public void onAuthenticationFailed() {
        this.update("auth failed", false);
    }

    @Override
    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
        this.update("help " + helpCode, false);
    }

    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
        this.update("you can access", true);
    }

    private void update(String s, boolean b) {
        TextView textViewHead = (TextView) ((Activity) context).findViewById(R.id.textViewfingerAuth);
        TextView textViewleble = (TextView) ((Activity) context).findViewById(R.id.textViewparaleble);
        ImageView imageView = ((Activity) context).findViewById(R.id.imageViewfinger);
        textViewleble.setText(s);
        if (b == false) {
            textViewleble.setTextColor(ContextCompat.getColor(context, R.color.cardview_dark_background));

        } else {
            textViewleble.setTextColor(ContextCompat.getColor(context, R.color.cardview_shadow_start_color));
            imageView.setImageResource(R.mipmap.done);
        }

    }
}
