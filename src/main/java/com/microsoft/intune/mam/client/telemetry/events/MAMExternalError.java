package com.microsoft.intune.mam.client.telemetry.events;

import com.microsoft.intune.mam.log.MAMErrorId;

/* JADX INFO: loaded from: classes3.dex */
public enum MAMExternalError implements MAMErrorId {
    AGENT_REINSTALL_TIMEOUT,
    AGENT_REQUIRED_NO_PRIMARY_IDENTITY,
    BACK_UP_MISSING_MAM_COPY,
    CLASSLOADER_PROXY_INVALID_OBJECT,
    STARTUP_BLOCKED_RESTART_WITHOUT_INTENT;

    @Override // com.microsoft.intune.mam.log.MAMErrorId
    public String getId() {
        return name();
    }
}
