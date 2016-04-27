package application_utility;

/**
 * Created by rajesh on 4/25/2016.
 */
public enum GlobalData {
   Data;

    private String networkStatus;
    private String externalIP;
    private String friendlyName;

    public String getNetworkStatus() {
        return networkStatus;
    }

    public void setNetworkStatus(String networkStatus) {
        this.networkStatus = networkStatus;
    }

    public String getExternalIP() {
        return externalIP;
    }

    public void setExternalIP(String externalIP) {
        this.externalIP = externalIP;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }
}//Global Data
