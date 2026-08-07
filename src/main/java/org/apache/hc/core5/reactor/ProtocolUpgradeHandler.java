package org.apache.hc.core5.reactor;

import org.apache.hc.core5.concurrent.FutureCallback;

/* JADX INFO: loaded from: classes5.dex */
public interface ProtocolUpgradeHandler {
    void upgrade(ProtocolIOSession protocolIOSession, FutureCallback<ProtocolIOSession> futureCallback);
}
