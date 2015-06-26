// Copyright (c) Microsoft. All Rights Reserved. Licensed under the MIT License. See license.txt in the project root for further information.
package test.microsoft.com.wifitestpower;

import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.nsd.WifiP2pDnsSdServiceInfo;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by juksilve on 28.2.2015.
 */
public class WifiServiceAdvertiser {

    private WifiP2pManager p2p;
    private WifiP2pManager.Channel channel;

    int lastError = -1;
    public WifiServiceAdvertiser(WifiP2pManager Manager, WifiP2pManager.Channel Channel) {
        this.p2p = Manager;
        this.channel = Channel;
    }

    public int GetLastError(){
        return lastError;
    }
    public void Start(String instance,String service_type) {

        instance = "pow";

        Map<String, String> record = new HashMap<String, String>();
      record.put("0", "1111111111222222222233333333334444444444555555555566666666667777777777888888888899999999rTests4");

   /*     record.put("0", "11111111112222222222333333333344444444445555555555666666666677777777778888888888999999999900000000001111111111222222222233333333334444444444555555555566666666667777777777888888888899999999990000000000");
        record.put("1", "11111111112222222222333333333344444444445555555555666666666677777777778888888888999999999900000000001111111111222222222233333333334444444444555555555566666666667777777777888888888899999999990000000000");
        record.put("2", "11111111112222222222333333333344444444445555555555666666666677777777778888888888999999999900000000001111111111222222222233333333334444444444555555555566666666667777777777888888888899999999990000000000");
        record.put("3", "11111111112222222222333333333344444444445555555555666666666677777777778888888888999999999900000000001111111111222222222233333333334444444444555555555566666666667777777777888888888899999999990000000000");
    //    record.put("4", "111111111122222222223333333333444444444455555555556666666666777777777788888888889999999999000000000011111111112222222222333333333344444444445555555555666");
      //  record.put("4", "1111111111222222222233333333334444444444555555555566666666667777777777888888888899999999990000000000111111111122222222223333333333444444444455555555556");//

      //  record.put("4", "1111111111222222222233333333334444444444555555555566666666667777777777888888888899999999990000000000111111111122222222223");
        record.put("4", "1111111111222222222233333333334444444444555555555566666666667777777777888888888899999999990000000000111111111122222222223");
*/
        WifiP2pDnsSdServiceInfo service = WifiP2pDnsSdServiceInfo.newInstance(instance, service_type, record);

        debug_print("Add local service :" + instance);
        p2p.addLocalService(channel, service, new WifiP2pManager.ActionListener() {
            public void onSuccess() {
                lastError = -1;
                debug_print("Added local service");
            }

            public void onFailure(int reason) {
                lastError = reason;
                debug_print("Adding local service failed, error code " + reason);
            }
        });
    }

    public void Stop() {
        p2p.clearLocalServices(channel, new WifiP2pManager.ActionListener() {
            public void onSuccess() {
                lastError = -1;
                debug_print("Cleared local services");
            }

            public void onFailure(int reason) {
                lastError = reason;
                debug_print("Clearing local services failed, error code " + reason);
            }
        });
    }

    private void debug_print(String buffer) {
        Log.i("ACCESS point",buffer);
    }
}
