package com.microsoft.identity.common.java.crypto;

import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.microsoft.identity.common.java.exception.ClientException;
import kotlin.Metadata;

/* JADX INFO: compiled from: IKeyAccessorStringAdapter.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/microsoft/identity/common/java/crypto/IKeyAccessorStringAdapter;", "", BoxAnalyticsParams.ACTION_DECRYPT, "", "cipherText", BoxAnalyticsParams.ACTION_ENCRYPT, "plainText", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IKeyAccessorStringAdapter {
    String decrypt(String cipherText) throws ClientException;

    String encrypt(String plainText) throws ClientException;
}
