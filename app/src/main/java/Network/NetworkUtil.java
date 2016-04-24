package Network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import application_utility.ApplicationConstants;

/**
 * Created by rajesh on 4/23/2016.
 */
public class NetworkUtil {

    public static int getConnectivityStatus(Context ctx){

        ConnectivityManager cm = (ConnectivityManager)ctx.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
          if(activeNetwork != null){
                if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) return ApplicationConstants.TYPE_WIFI;
                if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)return ApplicationConstants.TYPE_MOBILE;
          }

        return ApplicationConstants.TYPE_NOT_CONNECTED;

    }//getConnectivityStatus


    public static String getConnectivityStatusString(Context ctx){

        int conn = NetworkUtil.getConnectivityStatus(ctx);
        String status = null;
        if(conn == ApplicationConstants.TYPE_WIFI){
            status = "Wifi enabled";
        } else if (conn == ApplicationConstants.TYPE_MOBILE){
            status = "Mobile data enabled";
        } else if(conn == ApplicationConstants.TYPE_NOT_CONNECTED){
            status = "Not connected to Internet";
        }

        return status;
    }//getConnectivityStatusString


}//NetworkUtil
