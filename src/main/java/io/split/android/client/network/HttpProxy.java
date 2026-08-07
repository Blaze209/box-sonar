package io.split.android.client.network;

import io.split.android.client.utils.Utils;

/* JADX INFO: loaded from: classes4.dex */
public class HttpProxy {
    private final String host;
    private final String password;
    private final int port;
    private final String username;

    public HttpProxy(String host, int port) {
        this(host, port, null, null);
    }

    public HttpProxy(String host, int port, String username, String password) {
        Utils.checkNotNull(host);
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean usesCredentials() {
        return this.username == null;
    }
}
