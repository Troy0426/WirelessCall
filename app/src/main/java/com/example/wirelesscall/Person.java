package com.example.wirelesscall;

import android.content.Context;
import android.widget.EditText;

public class Person {

    private String name, wifi_addr;

    public void setName(EditText editText)
    {
        this.name = editText.getText().toString();
    }

    public String getName()
    {
        return this.name;
    }

    public void setWifi_Addr(WiFi device, Context context)
    {
        this.wifi_addr = device.getWiFiAddr(context);
    }

    public String getWifi_Addr()
    {
        return this.wifi_addr;
    }
}
