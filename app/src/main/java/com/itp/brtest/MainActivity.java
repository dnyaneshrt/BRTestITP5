package com.itp.brtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


//step 1: create a class as a child of android.content.BroadcastReceiver
class BR extends BroadcastReceiver
{
    TextView tv;
    BR(TextView tv)
    {
        this.tv=tv;
    }
    @Override
    public void onReceive(Context context, Intent intent) {

     if(intent.getAction().equals(Intent.ACTION_CALL))
     {
         Toast.makeText(context, "--"+intent.getAction(), Toast.LENGTH_SHORT).show();
     }else if(intent.getAction().equals(Intent.ACTION_HEADSET_PLUG))
     {
         Toast.makeText(context, "--"+intent.getAction(), Toast.LENGTH_SHORT).show();
     }else if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED))
     {
         Toast.makeText(context, "--"+intent.getAction(), Toast.LENGTH_SHORT).show();
     }else {
         Toast.makeText(context, "--"+intent.getAction(), Toast.LENGTH_SHORT).show();
         tv.setText("--"+intent.getAction());
     }
    }
}
public class MainActivity extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textView);
        //IntentFilter: group of intents.
   /*
        Steps to work with Broadcast Receiver :
- create a class as a child of BroadcastReceiver class.
- it is an abstract class having an abstract method called onReceive() so provide the
implementation for onReceive() method.
- from Activity class for which event you want to get the broadcast announcements
configure the events by using IntentFilter[group of intents is called as IntentFilter].
         */

        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction(Intent.ACTION_CALL);
        intentFilter.addAction(Intent.ACTION_HEADSET_PLUG);
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);

        registerReceiver(new BR(tv),intentFilter);
        /*
        registerReceiver(new BroadcastReceiverClass(),filter);
- if any one of the configured events are happened it will invoke onReceive() method in the
broadcast receiver class.
         */

    }
}