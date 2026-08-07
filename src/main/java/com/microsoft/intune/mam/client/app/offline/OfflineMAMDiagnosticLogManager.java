package com.microsoft.intune.mam.client.app.offline;

import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import com.microsoft.intune.mam.policy.MAMDiagnosticLogManager;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineMAMDiagnosticLogManager implements MAMDiagnosticLogManager {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(OfflineMAMDiagnosticLogManager.class);

    @Override // com.microsoft.intune.mam.policy.MAMDiagnosticLogManager
    public void reportStatus(String str, String str2, MAMDiagnosticLogManager.ServiceType serviceType, MAMDiagnosticLogManager.Result result, String str3) {
        LOGGER.info("App is trying to report diagnostic status in offline mode. Ignored.", new Object[0]);
    }
}
