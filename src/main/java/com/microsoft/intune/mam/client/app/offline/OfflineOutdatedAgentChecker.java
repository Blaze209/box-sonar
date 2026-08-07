package com.microsoft.intune.mam.client.app.offline;

import com.microsoft.intune.mam.client.OutdatedAgentChecker;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineOutdatedAgentChecker implements OutdatedAgentChecker {
    @Override // com.microsoft.intune.mam.client.OutdatedAgentChecker
    public String getUserFacingOutOfDateMessage() {
        return null;
    }

    @Override // com.microsoft.intune.mam.client.OutdatedAgentChecker
    public boolean isSDKNewerThanAgent() {
        return false;
    }
}
