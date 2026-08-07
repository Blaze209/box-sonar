package org.apache.hc.core5.ssl;

import java.util.Map;
import javax.net.ssl.SSLParameters;

/* JADX INFO: loaded from: classes5.dex */
public interface PrivateKeyStrategy {
    String chooseAlias(Map<String, PrivateKeyDetails> map, SSLParameters sSLParameters);
}
