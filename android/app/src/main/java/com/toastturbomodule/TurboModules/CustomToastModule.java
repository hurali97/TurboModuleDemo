package com.toastturbomodule.TurboModules;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class CustomToastModule extends ReactContextBaseJavaModule {

    public static final String NAME = "Toast";
    private String TAG = "CustomToastModule";

    @NonNull
    @Override
    public String getName() {
        return NAME;
    }

    public CustomToastModule(ReactApplicationContext context) {
        super(context);
    }

    @ReactMethod
    public void show(String message) {

        if (message == null) {
            Log.e(TAG, "Message is required");
        } else {
            Toast.makeText(getReactApplicationContext(), message,
                    Toast.LENGTH_LONG).show();
        }


    }

}
