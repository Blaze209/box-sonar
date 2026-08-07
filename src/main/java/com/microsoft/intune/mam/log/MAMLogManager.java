package com.microsoft.intune.mam.log;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMLogManager {
    File[] getLogFiles();

    void init();
}
