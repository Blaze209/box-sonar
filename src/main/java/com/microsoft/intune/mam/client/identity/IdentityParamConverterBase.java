package com.microsoft.intune.mam.client.identity;

import com.microsoft.intune.mam.client.MAMInfo;
import com.microsoft.intune.mam.client.telemetry.events.MAMInterfaceError;
import com.microsoft.intune.mam.log.MAMLogPIIFactory;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import com.microsoft.intune.mam.log.PIIObj;

/* JADX INFO: loaded from: classes3.dex */
public class IdentityParamConverterBase implements IdentityParamConverter {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(IdentityParamConverterBase.class);
    private final MAMIdentityManager mIdentityManager;
    private final MAMLogPIIFactory mLogPIIFactory;

    public IdentityParamConverterBase(MAMIdentityManager mAMIdentityManager, MAMLogPIIFactory mAMLogPIIFactory) {
        this.mIdentityManager = mAMIdentityManager;
        this.mLogPIIFactory = mAMLogPIIFactory;
    }

    @Override // com.microsoft.intune.mam.client.identity.IdentityParamConverter
    public MAMIdentity fromUpnParam(String str) {
        emitUpnUsageWarnings(str);
        if (str == null) {
            return null;
        }
        return this.mIdentityManager.create(str, "");
    }

    @Override // com.microsoft.intune.mam.client.identity.IdentityParamConverter
    public void emitUpnUsageWarnings(String str) {
        PIIObj piiupn = this.mLogPIIFactory.getPIIUPN(str, null);
        if (MAMInfo.isMMAEnabled()) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("UPN parameters are not supported in MMA mode. Use OID-based API instead.");
            LOGGER.error(MAMInterfaceError.UPN_USED_IN_MMA_APP, "UPN-based method called in MMA app for " + piiupn, unsupportedOperationException);
            throw unsupportedOperationException;
        }
        if (shouldWarn()) {
            LOGGER.warning("UPN-based method called for {0}; identity may be ambiguous.", piiupn);
        } else {
            LOGGER.fine("UPN-based method called for {0}; identity may be ambiguous.", piiupn);
        }
    }

    private boolean shouldWarn() {
        MAMIdentityManager mAMIdentityManager = this.mIdentityManager;
        if (mAMIdentityManager instanceof MAMIdentityManagerBase) {
            return ((MAMIdentityManagerBase) mAMIdentityManager).hasUpnConflicts();
        }
        return false;
    }

    @Override // com.microsoft.intune.mam.client.identity.IdentityParamConverter
    public MAMIdentity fromOidParam(String str) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return MAMIdentity.EMPTY;
        }
        MAMIdentity mAMIdentityFetch = this.mIdentityManager.fetch(str);
        return mAMIdentityFetch != null ? mAMIdentityFetch : MAMIdentityManagerBase.createDirect("", str, null, null);
    }

    @Override // com.microsoft.intune.mam.client.identity.IdentityParamConverter
    public MAMIdentity fromUpnAndOid(String str, String str2) {
        if (str2 != null && (str == null || str.isEmpty())) {
            return fromOidParam(str2);
        }
        if (str2 == null) {
            str2 = "";
        }
        return this.mIdentityManager.create(str, str2);
    }
}
