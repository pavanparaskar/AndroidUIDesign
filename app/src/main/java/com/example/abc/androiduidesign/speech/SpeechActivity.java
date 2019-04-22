package com.example.abc.androiduidesign.speech;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abc.androiduidesign.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class SpeechActivity extends AppCompatActivity {

    private TextView txtSpeechInput;
    private ImageButton btnSpeak;
    private final int REQ_CODE_SPEECH_INPUT = 1040;
    HidBridge hidBridge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech);


        test();

    }

    private void test() {

        HidBridge hidBridge = new HidBridge(SpeechActivity.this, 24, 10374);

        hidBridge.OpenDevice();

    }

    @Override
    protected void onDestroy() {
        hidBridge.CloseTheDevice();
        super.onDestroy();
    }
}