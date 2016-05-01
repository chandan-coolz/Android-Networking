package AsyncTask;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import Network.NetworkUtil;
import Network.UPnPPortMapper;
import application_utility.ApplicationConstants;
import application_utility.GlobalData;
import dialog.CustomDialog;

/**
 * Created by rajesh on 4/28/2016.
 */
public class ReceiveInfoAsync extends AsyncTask<Void, Void, Void> {


    private final ProgressDialog progressDialog;
    private Context context;
    private UPnPPortMapper uPnPPortMapper;

    public ReceiveInfoAsync(Context ctx) {
        context = ctx;
        progressDialog = CustomDialog.creator(ctx);


    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.show();
        uPnPPortMapper = new UPnPPortMapper();
    }

    @Override
    protected Void doInBackground(Void... params) {
        String status = NetworkUtil.getConnectivityStatusString(context);
        String externalIP = uPnPPortMapper.findExternalIPAddress();
        String friendlyName = uPnPPortMapper.findRouterName();

        if (externalIP != null && !externalIP.isEmpty()) {
            GlobalData.Data.setExternalIP(externalIP);
        }
        if (friendlyName != null && !friendlyName.isEmpty()) {
            GlobalData.Data.setFriendlyName(friendlyName);
        }
        if (status != null && !status.isEmpty()) {
            GlobalData.Data.setNetworkStatus(status);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Intent i = new Intent(ApplicationConstants.APPLICATION_ENCODING_TEXT);
        context.sendBroadcast(i);
        progressDialog.dismiss();
    }
}//ReceiveInfoAsync

