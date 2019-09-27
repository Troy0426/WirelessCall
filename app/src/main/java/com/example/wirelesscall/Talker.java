package com.example.wirelesscall;

public class Talker {

    private String talker_name, talker_wifi_addr;
    public Talker(Person person)
    {
        this.talker_name      = person.getName();
        this.talker_wifi_addr = person.getWifi_Addr();
    }

    public void Talking()
    {

    }
}
