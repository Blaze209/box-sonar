package org.apache.http.client;

import org.apache.http.conn.routing.HttpRoute;

/* JADX INFO: loaded from: classes5.dex */
public interface BackoffManager {
    void backOff(HttpRoute httpRoute);

    void probe(HttpRoute httpRoute);
}
