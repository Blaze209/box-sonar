package com.microsoft.intune.mam.client.identity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineDataProtectionManagerBehavior extends DataProtectionManagerBehaviorBase {
    @Override // com.microsoft.intune.mam.client.identity.DataProtectionManagerBehavior
    public boolean isBackupAllowed(InputStream inputStream) throws IOException {
        return true;
    }

    @Override // com.microsoft.intune.mam.client.identity.DataProtectionManagerBehavior
    public boolean isBackupAllowed(byte[] bArr) throws IOException {
        return true;
    }

    public OfflineDataProtectionManagerBehavior(MAMIdentityManager mAMIdentityManager, IdentityParamConverter identityParamConverter) {
        super(mAMIdentityManager, identityParamConverter);
    }

    @Override // com.microsoft.intune.mam.client.identity.DataProtectionManagerBehavior
    public InputStream protect(InputStream inputStream, MAMIdentity mAMIdentity) throws IOException {
        if (mAMIdentity == null) {
            throw new IOException("identity may not be null");
        }
        DataProtectionManagerBehaviorBase.IsProtectedAndStream protectionInfoAndNonAdvancedStream = getProtectionInfoAndNonAdvancedStream(inputStream);
        if (protectionInfoAndNonAdvancedStream.isProtected && protectionInfoAndNonAdvancedStream.identityIfKnown != null && mAMIdentity.equals(protectionInfoAndNonAdvancedStream.identityIfKnown)) {
            return inputStream;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new DataProtectionHeaderBase(mAMIdentity).getRawBytes());
        if (!protectionInfoAndNonAdvancedStream.isProtected) {
            return new SequenceInputStream(byteArrayInputStream, protectionInfoAndNonAdvancedStream.stream);
        }
        return new SequenceInputStream(byteArrayInputStream, unprotect(protectionInfoAndNonAdvancedStream.stream));
    }

    @Override // com.microsoft.intune.mam.client.identity.DataProtectionManagerBehavior
    public InputStream unprotect(InputStream inputStream) throws IOException {
        DataProtectionManagerBehaviorBase.IsProtectedAndStream protectionInfoAndNonAdvancedStream = getProtectionInfoAndNonAdvancedStream(inputStream);
        if (!protectionInfoAndNonAdvancedStream.isProtected) {
            return protectionInfoAndNonAdvancedStream.stream;
        }
        new DataProtectionHeaderBase().skipPastHeader(protectionInfoAndNonAdvancedStream.stream);
        return protectionInfoAndNonAdvancedStream.stream;
    }
}
