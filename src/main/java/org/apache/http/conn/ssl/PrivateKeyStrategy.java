package org.apache.http.conn.ssl;

import java.net.Socket;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface PrivateKeyStrategy {
    String chooseAlias(Map<String, PrivateKeyDetails> map, Socket socket);
}
