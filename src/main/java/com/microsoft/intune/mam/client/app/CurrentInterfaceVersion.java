package com.microsoft.intune.mam.client.app;

import com.microsoft.intune.mam.client.InterfaceVersion;

/* JADX INFO: loaded from: classes3.dex */
final class CurrentInterfaceVersion implements InterfaceVersion {
    public static final CurrentInterfaceVersion INSTANCE = new CurrentInterfaceVersion();

    @Override // com.microsoft.intune.mam.client.InterfaceVersion
    public int getMajor() {
        return 1;
    }

    @Override // com.microsoft.intune.mam.client.InterfaceVersion
    public int getMinor() {
        return 134;
    }

    private CurrentInterfaceVersion() {
    }
}
