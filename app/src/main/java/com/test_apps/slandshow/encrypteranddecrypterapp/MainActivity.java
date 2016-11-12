package com.test_apps.slandshow.encrypteranddecrypterapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Base64;

import java.io.UnsupportedEncodingException;


public class MainActivity extends AppCompatActivity {

    private static String message;
    private static String encodedMessage;
    private static String encodedMessageResult;
    private static String decodedMessage;
    private static String decodedMessageResult;
    private static EditText et1;
    private static EditText et2;
    private static TextView textViewEncoded;
    private static TextView textViewDecoded;

    // TODO init here
    static {
        message = "";
        encodedMessage = "";

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // if we want to encode message
    public void onClickEncode(View v) {

        et1 = (EditText) findViewById(R.id.encodeTxt);
        encodedMessage = et1.getText().toString();
        textViewEncoded = (TextView) findViewById(R.id.encodedResultTxt);

        // String to be encoded with Base64
        String text = encodedMessage;
        // Sending side
        byte[] data = null;
        try {
            data = text.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        String base64 = Base64.encodeToString(data, Base64.DEFAULT);

        encodedMessageResult = base64;

        // show encoded messahe on screen
        textViewEncoded.setText(encodedMessageResult);

    }


    // if we want to decode message
    public void onClickDecode(View v) {

        et2 = (EditText) findViewById(R.id.decodeTxt);
        decodedMessage = et2.getText().toString();
        textViewDecoded = (TextView) findViewById(R.id.decodeResultTxt);


        // Receiving side
        byte[] data1 = Base64.decode(decodedMessage, Base64.DEFAULT);
        String text1 = null;
        try {
            text1 = new String(data1, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        decodedMessageResult = text1;

        textViewDecoded.setText(decodedMessageResult);
    }

}
