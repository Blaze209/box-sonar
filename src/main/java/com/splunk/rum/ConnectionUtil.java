package com.splunk.rum;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
class ConnectionUtil {
    static final CurrentNetwork NO_NETWORK = CurrentNetwork.builder(NetworkState.NO_NETWORK_AVAILABLE).build();
    static final CurrentNetwork UNKNOWN_NETWORK = CurrentNetwork.builder(NetworkState.TRANSPORT_UNKNOWN).build();
    private volatile CurrentNetwork currentNetwork = UNKNOWN_NETWORK;
    private final List<NetworkChangeListener> listeners = new CopyOnWriteArrayList();
    private final NetworkDetector networkDetector;

    ConnectionUtil(NetworkDetector networkDetector) {
        this.networkDetector = networkDetector;
    }

    void startMonitoring(Supplier<NetworkRequest> supplier, ConnectivityManager connectivityManager) {
        refreshNetworkStatus();
        try {
            registerNetworkCallbacks(supplier, connectivityManager);
        } catch (Exception e) {
            Log.w("SplunkRum", "Failed to register network callbacks. Automatic network monitoring is disabled.", e);
        }
    }

    private void registerNetworkCallbacks(Supplier<NetworkRequest> supplier, ConnectivityManager connectivityManager) {
        connectivityManager.registerDefaultNetworkCallback(new ConnectionMonitor());
    }

    CurrentNetwork refreshNetworkStatus() {
        try {
            this.currentNetwork = this.networkDetector.detectCurrentNetwork();
        } catch (Exception unused) {
            this.currentNetwork = UNKNOWN_NETWORK;
        }
        return this.currentNetwork;
    }

    static NetworkRequest createNetworkMonitoringRequest() {
        return new NetworkRequest.Builder().addTransportType(0).addTransportType(1).addTransportType(2).addTransportType(3).addTransportType(4).build();
    }

    CurrentNetwork getActiveNetwork() {
        return this.currentNetwork;
    }

    void addNetworkChangeListener(NetworkChangeListener networkChangeListener) {
        this.listeners.add(networkChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyListeners(CurrentNetwork currentNetwork) {
        Iterator<NetworkChangeListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onNetworkChange(currentNetwork);
        }
    }

    private class ConnectionMonitor extends ConnectivityManager.NetworkCallback {
        private ConnectionMonitor() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            CurrentNetwork currentNetworkRefreshNetworkStatus = ConnectionUtil.this.refreshNetworkStatus();
            Log.d("SplunkRum", "  onAvailable: activeNetwork=" + currentNetworkRefreshNetworkStatus);
            ConnectionUtil.this.notifyListeners(currentNetworkRefreshNetworkStatus);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            CurrentNetwork currentNetwork = ConnectionUtil.NO_NETWORK;
            ConnectionUtil.this.currentNetwork = currentNetwork;
            Log.d("SplunkRum", "  onLost: activeNetwork=" + currentNetwork);
            ConnectionUtil.this.notifyListeners(currentNetwork);
        }
    }

    static class Factory {
        Factory() {
        }

        ConnectionUtil createAndStart(Application application) {
            Context applicationContext = application.getApplicationContext();
            ConnectionUtil connectionUtil = new ConnectionUtil(NetworkDetector.create(applicationContext));
            connectionUtil.startMonitoring(new Supplier() { // from class: com.splunk.rum.ConnectionUtil$Factory$$ExternalSyntheticLambda0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return ConnectionUtil.createNetworkMonitoringRequest();
                }
            }, (ConnectivityManager) applicationContext.getSystemService("connectivity"));
            return connectionUtil;
        }
    }
}
