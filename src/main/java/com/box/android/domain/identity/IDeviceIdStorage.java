package com.box.android.domain.identity;

import java.io.IOException;

/* JADX INFO: loaded from: classes11.dex */
public interface IDeviceIdStorage {
    String getAndroidId();

    String getInstallationId() throws IOException;

    void setAndroidId(String str);

    void setInstallationId(String str) throws IOException;
}
