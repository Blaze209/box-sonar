package com.microsoft.intune.mam.client.app.offline;

import android.content.Intent;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.log.MAMLogPIIFactory;
import com.microsoft.intune.mam.log.PIIADAL;
import com.microsoft.intune.mam.log.PIIFile;
import com.microsoft.intune.mam.log.PIIIntent;
import com.microsoft.intune.mam.log.PIIObj;
import com.microsoft.intune.mam.log.PIIUPN;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineMAMLogPIIFactory implements MAMLogPIIFactory {
    @Override // com.microsoft.intune.mam.log.MAMLogPIIFactory
    public PIIObj getPIIFilePath(String str) {
        return new PIIFile(str);
    }

    @Override // com.microsoft.intune.mam.log.MAMLogPIIFactory
    public PIIObj getPIIFilePath(File file) {
        return new PIIFile(file);
    }

    @Override // com.microsoft.intune.mam.log.MAMLogPIIFactory
    @Deprecated
    public PIIObj getPIIUPN(String str) {
        return new PIIUPN(str, null);
    }

    @Override // com.microsoft.intune.mam.log.MAMLogPIIFactory
    public PIIObj getPIIUPN(String str, String str2) {
        return new PIIUPN(str, str2);
    }

    @Override // com.microsoft.intune.mam.log.MAMLogPIIFactory
    public PIIObj getPIIUPN(MAMIdentity mAMIdentity) {
        return new PIIUPN(mAMIdentity);
    }

    @Override // com.microsoft.intune.mam.log.MAMLogPIIFactory
    public PIIObj getPIIIntent(String str) {
        return new PIIIntent(str);
    }

    @Override // com.microsoft.intune.mam.log.MAMLogPIIFactory
    public PIIObj getPIIIntent(Intent intent) {
        return new PIIIntent(intent);
    }

    @Override // com.microsoft.intune.mam.log.MAMLogPIIFactory
    public PIIObj getPIIADAL(String str) {
        return new PIIADAL(str);
    }
}
