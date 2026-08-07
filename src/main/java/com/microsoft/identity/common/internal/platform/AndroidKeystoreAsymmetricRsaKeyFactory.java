package com.microsoft.identity.common.internal.platform;

import android.content.Context;
import com.microsoft.identity.common.components.AndroidPlatformComponentsFactory;
import com.microsoft.identity.common.java.exception.ClientException;

/* JADX INFO: loaded from: classes14.dex */
public class AndroidKeystoreAsymmetricRsaKeyFactory implements AsymmetricRsaKeyFactory {
    private final Context mContext;

    public AndroidKeystoreAsymmetricRsaKeyFactory(Context context) {
        this.mContext = context;
    }

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricRsaKeyFactory, com.microsoft.identity.common.internal.platform.AsymmetricKeyFactory
    public synchronized AsymmetricRsaKey generateAsymmetricKey(String str) throws ClientException {
        return new AndroidKeystoreAsymmetricRsaKey(AndroidPlatformComponentsFactory.createFromContext(this.mContext).getDevicePopManager(str), str);
    }

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricRsaKeyFactory, com.microsoft.identity.common.internal.platform.AsymmetricKeyFactory
    public synchronized AsymmetricRsaKey loadAsymmetricKey(String str) throws ClientException {
        return generateAsymmetricKey(str);
    }

    @Override // com.microsoft.identity.common.internal.platform.AsymmetricKeyFactory
    public synchronized boolean clearAsymmetricKey(String str) throws ClientException {
        return AndroidPlatformComponentsFactory.createFromContext(this.mContext).getDevicePopManager(str).clearAsymmetricKey();
    }
}
