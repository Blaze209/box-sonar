package com.microsoft.identity.common.components;

import android.content.Context;
import com.microsoft.identity.common.internal.platform.AndroidDevicePopManager;
import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.interfaces.IPopManagerSupplier;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/* JADX INFO: loaded from: classes14.dex */
public class AndroidPopManagerSupplier implements IPopManagerSupplier {
    private final Context mContext;

    public AndroidPopManagerSupplier(Context context) {
        if (context == null) {
            throw new NullPointerException("mContext is marked non-null but is null");
        }
        this.mContext = context;
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPopManagerSupplier
    public IDevicePopManager getDevicePopManager(String str) throws ClientException {
        String str2;
        try {
            if (str == null) {
                return new AndroidDevicePopManager(this.mContext);
            }
            return new AndroidDevicePopManager(this.mContext, str);
        } catch (IOException e) {
            e = e;
            str2 = "io_error";
            throw new ClientException(str2, "Failed to initialize DevicePoPManager = " + e.getMessage(), e);
        } catch (KeyStoreException e2) {
            e = e2;
            str2 = ClientException.KEYSTORE_NOT_INITIALIZED;
            throw new ClientException(str2, "Failed to initialize DevicePoPManager = " + e.getMessage(), e);
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            str2 = "no_such_algorithm";
            throw new ClientException(str2, "Failed to initialize DevicePoPManager = " + e.getMessage(), e);
        } catch (CertificateException e4) {
            e = e4;
            str2 = ClientException.CERTIFICATE_LOAD_FAILURE;
            throw new ClientException(str2, "Failed to initialize DevicePoPManager = " + e.getMessage(), e);
        }
    }
}
