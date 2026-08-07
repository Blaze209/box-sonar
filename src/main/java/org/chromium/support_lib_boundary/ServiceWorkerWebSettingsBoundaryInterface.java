package org.chromium.support_lib_boundary;

import org.jspecify.annotations.NullMarked;

/* JADX INFO: loaded from: classes5.dex */
@NullMarked
public interface ServiceWorkerWebSettingsBoundaryInterface {
    boolean getAllowContentAccess();

    boolean getAllowFileAccess();

    boolean getBlockNetworkLoads();

    int getCacheMode();

    boolean getIncludeCookiesOnIntercept();

    void setAllowContentAccess(boolean z);

    void setAllowFileAccess(boolean z);

    void setBlockNetworkLoads(boolean z);

    void setCacheMode(int i);

    void setIncludeCookiesOnIntercept(boolean z);
}
