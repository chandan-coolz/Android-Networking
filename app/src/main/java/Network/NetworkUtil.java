package Network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by rajesh on 4/23/2016.
 */
public class NetworkUtil {

    public void getConnectivityStatus(Context ctx){

        ConnectivityManager cm = (ConnectivityManager)ctx.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActivi




    }//getConnectivityStatus


}//NetworkUtil
