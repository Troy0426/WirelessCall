package com.example.wirelesscall;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;


public class WiFi {

    public static String getWiFiAddr(Context context)
    {
        WifiManager wifiManager = (WifiManager) context.getSystemService(context.WIFI_SERVICE);
        if (wifiManager == null) {
            return "wifiManager not found";
        }

        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        if (wifiInfo == null) {
            return "wifiInfo not found";
        }

        int ipAddress = wifiInfo.getIpAddress();
        String ipString = String.format("%d.%d.%d.%d", (ipAddress & 0xff), (ipAddress >> 8 & 0xff), (ipAddress >> 16 & 0xff), (ipAddress >> 24 & 0xff));

        return ipString;
    }

    public boolean checkIsSameAddr(Person talker, Person listener)
    {
        if(talker.getWifi_Addr() != "" && listener.getWifi_Addr() != "")
        {
            if (talker.getWifi_Addr() == listener.getWifi_Addr())
                return true;
            else return false;
        }
        else return false;
    }
}
