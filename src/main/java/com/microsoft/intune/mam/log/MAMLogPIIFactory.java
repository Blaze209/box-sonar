package com.microsoft.intune.mam.log;

import android.content.Intent;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMLogPIIFactory {
    PIIObj getPIIADAL(String str);

    PIIObj getPIIFilePath(File file);

    PIIObj getPIIFilePath(String str);

    PIIObj getPIIIntent(Intent intent);

    PIIObj getPIIIntent(String str);

    PIIObj getPIIUPN(MAMIdentity mAMIdentity);

    @Deprecated
    PIIObj getPIIUPN(String str);

    PIIObj getPIIUPN(String str, String str2);
}
