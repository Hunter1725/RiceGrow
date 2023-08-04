package com.example.ricegrow.Activity.Main;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;

public class NetworkUtils {

    private Context context;
    private final ConnectivityManager connectivityManager;
    private boolean isRegistered = false;
    private boolean isConnected = false;
    private OnConnectivityChangeListener listener;

    private Handler mainHandler = new Handler(Looper.getMainLooper());

    public NetworkUtils(Context context) {
        this.context = context;
        connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public void setListener(OnConnectivityChangeListener listener) {
        this.listener = listener;
    }

    public void register() {
        NetworkRequest networkRequest = new NetworkRequest.Builder().build();

        connectivityManager.registerNetworkCallback(
                networkRequest,
                new ConnectivityManager.NetworkCallback() {
                    @Override
                    public void onCapabilitiesChanged(@NonNull Network network, @NonNull NetworkCapabilities networkCapabilities) {
                        isConnected = networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                                networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED);
                        notifyListener();
                    }

                    @Override
                    public void onLost(@NonNull Network network) {
                        isConnected = false;
                        notifyListener();
                    }
                }
        );

        isRegistered = true;
    }

    public void unregister() {
        if (isRegistered) {
            connectivityManager.unregisterNetworkCallback(new ConnectivityManager.NetworkCallback());
            isRegistered = false;
        }
    }

    public boolean isConnected() {
        return isConnected;
    }

    private void notifyListener() {
        if (listener != null) {
            mainHandler.post(new Runnable() {
                @Override
                public void run() {
                    listener.onConnectivityChanged(isConnected);
                }
            });
        }
    }

    public interface OnConnectivityChangeListener {
        void onConnectivityChanged(boolean isConnected);
    }
}
