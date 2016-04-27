package com.example.cool.android_networking;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import Network.NetworkUtil;
import application_utility.ApplicationConstants;
import application_utility.GlobalData;

public class MainActivity extends Activity {

    TextView network_state, external_ip , igd_name;
    BroadcastReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initData();

    } //create

    private void initUI(){
        network_state=(TextView) findViewById(R.id.network_state_info);
        external_ip = (TextView)findViewById(R.id.external_ip_info);
        igd_name = (TextView)findViewById(R.id.igd_name_info);

    }//initUI

    private void initData(){
        network_state.setText(NetworkUtil.getConnectivityStatusString(this));
        IntentFilter intentFilter = new IntentFilter(ApplicationConstants.APPLICATION_ENCODING_TEXT);

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                 network_state.setText(GlobalData.Data.getNetworkStatus());
                external_ip.setText(GlobalData.Data.getExternalIP());
                igd_name.setText(GlobalData.Data.getFriendlyName());


            }
        };

    this.registerReceiver(broadcastReceiver,intentFilter);



    }//initData


    public void getIgd(View view){

    String networkStatus = NetworkUtil.getConnectivityStatusString(this);
        if(networkStatus == "Wifi enabled"){

        }


    }//getIgd


}//MainActivity
