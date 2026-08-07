package com.microsoft.intune.mam.client;

/* JADX INFO: loaded from: classes3.dex */
public interface OutdatedAgentChecker {
    String getUserFacingOutOfDateMessage();

    boolean isSDKNewerThanAgent();
}
