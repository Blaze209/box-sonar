package com.microsoft.identity.common.java.crypto;

import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.exception.ClientException;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyAccessorStringAdapter.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/microsoft/identity/common/java/crypto/KeyAccessorStringAdapter;", "Lcom/microsoft/identity/common/java/crypto/IKeyAccessorStringAdapter;", "mKeyAccessor", "Lcom/microsoft/identity/common/java/crypto/IKeyAccessor;", "(Lcom/microsoft/identity/common/java/crypto/IKeyAccessor;)V", BoxAnalyticsParams.ACTION_DECRYPT, "", "cipherText", BoxAnalyticsParams.ACTION_ENCRYPT, "plainText", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class KeyAccessorStringAdapter implements IKeyAccessorStringAdapter {
    private final IKeyAccessor mKeyAccessor;

    public KeyAccessorStringAdapter(IKeyAccessor mKeyAccessor) {
        Intrinsics.checkNotNullParameter(mKeyAccessor, "mKeyAccessor");
        this.mKeyAccessor = mKeyAccessor;
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyAccessorStringAdapter
    public String encrypt(String plainText) throws ClientException {
        Intrinsics.checkNotNullParameter(plainText, "plainText");
        IKeyAccessor iKeyAccessor = this.mKeyAccessor;
        Charset CHARSET_UTF8 = AuthenticationConstants.CHARSET_UTF8;
        Intrinsics.checkNotNullExpressionValue(CHARSET_UTF8, "CHARSET_UTF8");
        byte[] bytes = plainText.getBytes(CHARSET_UTF8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] result = iKeyAccessor.encrypt(bytes);
        Intrinsics.checkNotNullExpressionValue(result, "result");
        Charset CHARSET_UTF9 = AuthenticationConstants.CHARSET_UTF8;
        Intrinsics.checkNotNullExpressionValue(CHARSET_UTF9, "CHARSET_UTF8");
        return new String(result, CHARSET_UTF9);
    }

    @Override // com.microsoft.identity.common.java.crypto.IKeyAccessorStringAdapter
    public String decrypt(String cipherText) throws ClientException {
        Intrinsics.checkNotNullParameter(cipherText, "cipherText");
        IKeyAccessor iKeyAccessor = this.mKeyAccessor;
        Charset CHARSET_UTF8 = AuthenticationConstants.CHARSET_UTF8;
        Intrinsics.checkNotNullExpressionValue(CHARSET_UTF8, "CHARSET_UTF8");
        byte[] bytes = cipherText.getBytes(CHARSET_UTF8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] result = iKeyAccessor.decrypt(bytes);
        Intrinsics.checkNotNullExpressionValue(result, "result");
        Charset CHARSET_UTF9 = AuthenticationConstants.CHARSET_UTF8;
        Intrinsics.checkNotNullExpressionValue(CHARSET_UTF9, "CHARSET_UTF8");
        return new String(result, CHARSET_UTF9);
    }
}
