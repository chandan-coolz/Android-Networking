package Network;

import android.widget.Toast;

import net.sbbi.upnp.impls.InternetGatewayDevice;
import net.sbbi.upnp.messages.UPNPResponseException;

import java.io.IOException;

import application_utility.ApplicationConstants;

/**
 * Created by rajesh on 4/28/2016.
 */
public class UPnPPortMapper {

    private InternetGatewayDevice[] internetGatewayDevices;
    private InternetGatewayDevice foundGatewayDevice;

    public String findExternalIPAddress() {

        try {
            if (internetGatewayDevices == null) {

                internetGatewayDevices = InternetGatewayDevice.getDevices(ApplicationConstants.SCAN_TIMEOUT);
            }

            if (internetGatewayDevices != null) {

                for (InternetGatewayDevice IGD : internetGatewayDevices
                        ) {

                    foundGatewayDevice = IGD;
                    return IGD.getExternalIPAddress().toString();

                }//for

            }
        } catch (IOException e) {
            new Throwable(e.getMessage());
        } catch (UPNPResponseException e) {
            new Throwable(e.getMessage());
            ;
        }
        return "No device found";

    }//findExternalIPAddress ()

    public String findRouterName() {
        if (foundGatewayDevice != null) {
            return foundGatewayDevice.getIGDRootDevice().getFriendlyName().toString();
        }
        return "No IGD Name Found";
    }
}//UPnPPortMapper
