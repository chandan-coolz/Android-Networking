package AsyncTask;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import Network.UPnPPortMapper;
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
        uPnPPortMapper =  new UPnPPortMapper();
    }

    @Override
    protected Void doInBackground(Void... params) {
        return null;
    }
}//ReceiveInfoAsync

