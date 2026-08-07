package com.microsoft.intune.mam.client;

import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public enum AgentType {
    PRODUCTION,
    TEST;

    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(AgentType.class);

    public static AgentType fromString(String str) {
        if (str == null) {
            return null;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        if (lowerCase.equals("prod")) {
            return PRODUCTION;
        }
        if (lowerCase.equals("test")) {
            return TEST;
        }
        LOGGER.warning("Unknown agent type " + str, new Object[0]);
        return null;
    }
}
