package com.microsoft.intune.mam.client.identity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DataProtectionManagerBehaviorBase implements DataProtectionManagerBehavior {
    protected final IdentityParamConverter mIdentityParamConverter;
    protected final MAMIdentityManager mMAMIdentityManager;

    public DataProtectionManagerBehaviorBase(MAMIdentityManager mAMIdentityManager, IdentityParamConverter identityParamConverter) {
        this.mMAMIdentityManager = mAMIdentityManager;
        this.mIdentityParamConverter = identityParamConverter;
    }

    @Override // com.microsoft.intune.mam.client.identity.DataProtectionManagerBehavior
    @Deprecated
    public byte[] protect(byte[] bArr, String str) throws IOException {
        InputStream inputStreamProtect = protect(new ByteArrayInputStream(bArr), str);
        try {
            return StreamUtils.readAllBytesFromStream(inputStreamProtect);
        } finally {
            inputStreamProtect.close();
        }
    }

    @Override // com.microsoft.intune.mam.client.identity.DataProtectionManagerBehavior
    public byte[] protect(byte[] bArr, MAMIdentity mAMIdentity) throws IOException {
        InputStream inputStreamProtect = protect(new ByteArrayInputStream(bArr), mAMIdentity);
        try {
            return StreamUtils.readAllBytesFromStream(inputStreamProtect);
        } finally {
            inputStreamProtect.close();
        }
    }

    @Override // com.microsoft.intune.mam.client.identity.DataProtectionManagerBehavior
    @Deprecated
    public InputStream protect(InputStream inputStream, String str) throws IOException {
        return protect(inputStream, this.mIdentityParamConverter.fromUpnParam(str));
    }

    @Override // com.microsoft.intune.mam.client.identity.DataProtectionManagerBehavior
    public byte[] unprotect(byte[] bArr) throws IOException {
        InputStream inputStreamUnprotect = unprotect(new ByteArrayInputStream(bArr));
        try {
            return StreamUtils.readAllBytesFromStream(inputStreamUnprotect);
        } finally {
            inputStreamUnprotect.close();
        }
    }

    @Override // com.microsoft.intune.mam.client.identity.DataProtectionManagerBehavior
    public MAMDataProtectionInfo getProtectionInfo(byte[] bArr) throws IOException {
        if (DataProtectionHeaderBase.isProtectedData(bArr)) {
            return protectionInfoFromHeader(new DataProtectionHeaderBase(bArr));
        }
        return null;
    }

    @Override // com.microsoft.intune.mam.client.identity.DataProtectionManagerBehavior
    public MAMDataProtectionInfo getProtectionInfo(InputStream inputStream) throws IOException {
        MAMDataProtectionInfo mAMDataProtectionInfoProtectionInfoFromHeader;
        if (!inputStream.markSupported()) {
            throw new IOException("Cannot get protection info on stream without changing stream position");
        }
        inputStream.mark(4096);
        try {
            mAMDataProtectionInfoProtectionInfoFromHeader = protectionInfoFromHeader(new DataProtectionHeaderBase(inputStream));
        } catch (NotProtectedDataException unused) {
            mAMDataProtectionInfoProtectionInfoFromHeader = null;
        }
        inputStream.reset();
        return mAMDataProtectionInfoProtectionInfoFromHeader;
    }

    protected MAMDataProtectionInfo protectionInfoFromHeader(DataProtectionHeaderBase dataProtectionHeaderBase) {
        return new MAMDataProtectionInfoImpl(this.mMAMIdentityManager.create(dataProtectionHeaderBase.getIdentity(), null));
    }

    protected static class IsProtectedAndStream {
        public boolean isProtected = false;
        public InputStream stream = null;
        public MAMIdentity identityIfKnown = null;

        protected IsProtectedAndStream() {
        }
    }

    protected IsProtectedAndStream getProtectionInfoAndNonAdvancedStream(InputStream inputStream) throws IOException {
        IsProtectedAndStream isProtectedAndStream = new IsProtectedAndStream();
        try {
            MAMDataProtectionInfo protectionInfo = getProtectionInfo(inputStream);
            isProtectedAndStream.stream = inputStream;
            isProtectedAndStream.isProtected = protectionInfo != null;
            if (protectionInfo != null) {
                isProtectedAndStream.identityIfKnown = this.mMAMIdentityManager.create(protectionInfo.getIdentity(), protectionInfo.getIdentityOID());
            }
            return isProtectedAndStream;
        } catch (IOException unused) {
            int length = DataProtectionHeaderBase.IDENT.length;
            byte[] bArr = new byte[length];
            int i = 0;
            while (i < length) {
                int i2 = inputStream.read(bArr, i, length - i);
                if (i2 < 0) {
                    break;
                }
                i += i2;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, 0, i);
            if (i < length) {
                isProtectedAndStream.stream = byteArrayInputStream;
                return isProtectedAndStream;
            }
            isProtectedAndStream.stream = new SequenceInputStream(byteArrayInputStream, inputStream);
            isProtectedAndStream.isProtected = DataProtectionHeaderBase.isProtectedData(bArr);
            return isProtectedAndStream;
        }
    }
}
