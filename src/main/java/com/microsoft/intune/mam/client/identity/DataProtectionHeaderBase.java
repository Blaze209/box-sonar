package com.microsoft.intune.mam.client.identity;

import com.microsoft.intune.mam.client.OfflineReasonStore;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
class DataProtectionHeaderBase {
    protected static final int CURRENT_VER_MAJOR = 1;
    static final byte[] IDENT;
    static final int MAX_HEADER_SIZE = 4096;
    protected static final int MIN_HEADER_SIZE;
    protected short mCipherBlockSize;
    protected String mCipherSpec;
    protected short mCipherSpecLength;
    protected int mHeaderSize;
    protected byte[] mIV;
    protected String mIdentity;
    protected int mIdentityLength;
    protected byte[] mKey;
    protected short mKeyLength;
    protected int mVerMajor;
    protected int mVerMinor;

    static {
        byte[] bArr = {0, 77, 83, 77, 65, 77, 65, 82, 80, 68, 65, 84, 65, 0};
        IDENT = bArr;
        MIN_HEADER_SIZE = bArr.length + 22;
    }

    protected DataProtectionHeaderBase() {
        this.mVerMajor = 1;
        this.mVerMinor = 0;
        this.mCipherSpecLength = (short) 0;
        this.mKeyLength = (short) 0;
        this.mCipherBlockSize = (short) 0;
        this.mIdentityLength = 0;
    }

    public DataProtectionHeaderBase(MAMIdentity mAMIdentity) {
        this.mVerMajor = 1;
        this.mVerMinor = 0;
        this.mCipherSpecLength = (short) 0;
        this.mKeyLength = (short) 0;
        this.mCipherBlockSize = (short) 0;
        this.mIdentityLength = 0;
        this.mCipherSpec = "";
        this.mKey = new byte[0];
        this.mIV = new byte[0];
        String strRawUPN = mAMIdentity.rawUPN();
        this.mIdentity = strRawUPN;
        try {
            this.mIdentityLength = strRawUPN.getBytes("UTF-8").length;
            this.mHeaderSize = computeHeaderSize();
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError("UTF-8 charset should always be available");
        }
    }

    public DataProtectionHeaderBase(byte[] bArr) throws IOException {
        this.mVerMajor = 1;
        this.mVerMinor = 0;
        this.mCipherSpecLength = (short) 0;
        this.mKeyLength = (short) 0;
        this.mCipherBlockSize = (short) 0;
        this.mIdentityLength = 0;
        if (bArr.length < MIN_HEADER_SIZE) {
            throw new NotProtectedDataException();
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byte[] bArr2 = IDENT;
        byte[] bArr3 = new byte[bArr2.length];
        byteBufferWrap.get(bArr3);
        if (!Arrays.equals(bArr2, bArr3)) {
            throw new NotProtectedDataException();
        }
        this.mHeaderSize = byteBufferWrap.getInt();
        initializeHeaderDetails(byteBufferWrap);
    }

    public DataProtectionHeaderBase(InputStream inputStream) throws IOException {
        this.mVerMajor = 1;
        this.mVerMinor = 0;
        this.mCipherSpecLength = (short) 0;
        this.mKeyLength = (short) 0;
        this.mCipherBlockSize = (short) 0;
        this.mIdentityLength = 0;
        readHeaderSize(inputStream);
        byte[] bArr = new byte[(this.mHeaderSize - 4) - IDENT.length];
        if (!StreamUtils.exactRead(inputStream, bArr)) {
            throw new IOException("Data MAM protection info could not be read");
        }
        initializeHeaderDetails(ByteBuffer.wrap(bArr));
    }

    public void skipPastHeader(InputStream inputStream) throws IOException {
        readHeaderSize(inputStream);
        byte[] bArr = new byte[(this.mHeaderSize - 4) - IDENT.length];
        if (!StreamUtils.exactRead(inputStream, bArr)) {
            throw new IOException("Data MAM protection info could not be read");
        }
        initializeHeaderBase(ByteBuffer.wrap(bArr));
        if (this.mCipherSpecLength > 0) {
            throw new MAMDataProtectionUnavailableException("Protected data is encrypted but MAM is in offline mode.\n" + OfflineReasonStore.getOfflineReasonForLog());
        }
    }

    public static boolean isProtectedData(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = IDENT;
        if (length < bArr2.length) {
            return false;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byte[] bArr3 = new byte[bArr2.length];
        byteBufferWrap.get(bArr3);
        return Arrays.equals(bArr2, bArr3);
    }

    public String getIdentity() {
        return this.mIdentity;
    }

    public byte[] getRawBytes() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.mHeaderSize);
        try {
            byteBufferAllocate.put(IDENT);
            byteBufferAllocate.putInt(this.mHeaderSize);
            byteBufferAllocate.putInt(this.mVerMajor);
            byteBufferAllocate.putInt(this.mVerMinor);
            byteBufferAllocate.putShort(this.mCipherSpecLength);
            byteBufferAllocate.putShort(this.mKeyLength);
            byteBufferAllocate.putShort(this.mCipherBlockSize);
            byteBufferAllocate.putInt(this.mIdentityLength);
            byteBufferAllocate.put(this.mCipherSpec.getBytes("UTF-8"));
            byteBufferAllocate.put(this.mKey);
            byteBufferAllocate.put(this.mIV);
            byteBufferAllocate.put(this.mIdentity.getBytes("UTF-8"));
            return byteBufferAllocate.array();
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError("UTF-8 charset should always be available");
        }
    }

    protected void readHeaderSize(InputStream inputStream) throws IOException {
        byte[] bArr = IDENT;
        byte[] bArr2 = new byte[bArr.length];
        if (!StreamUtils.exactRead(inputStream, bArr2) || !Arrays.equals(bArr2, bArr)) {
            throw new NotProtectedDataException();
        }
        byte[] bArr3 = new byte[4];
        if (!StreamUtils.exactRead(inputStream, bArr3)) {
            throw new IOException("Data MAM protection info is malformed");
        }
        int i = ByteBuffer.wrap(bArr3).getInt();
        this.mHeaderSize = i;
        if (i > 4096 || i < MIN_HEADER_SIZE) {
            throw new IOException("Data MAM protection info is malformed");
        }
    }

    protected void initializeHeaderDetails(ByteBuffer byteBuffer) throws IOException {
        initializeHeaderBase(byteBuffer);
        byte[] bArr = new byte[this.mCipherSpecLength];
        byteBuffer.get(bArr);
        this.mCipherSpec = new String(bArr, "UTF-8");
        byte[] bArr2 = new byte[this.mKeyLength];
        this.mKey = bArr2;
        byteBuffer.get(bArr2);
        byte[] bArr3 = new byte[this.mCipherBlockSize];
        this.mIV = bArr3;
        byteBuffer.get(bArr3);
        byte[] bArr4 = new byte[this.mIdentityLength];
        byteBuffer.get(bArr4);
        this.mIdentity = new String(bArr4, "UTF-8");
    }

    protected void initializeHeaderBase(ByteBuffer byteBuffer) throws IOException {
        int i = byteBuffer.getInt();
        this.mVerMajor = i;
        if (i != 1) {
            throw new IOException("Data has MAM protection info with unknown version");
        }
        this.mVerMinor = byteBuffer.getInt();
        this.mCipherSpecLength = byteBuffer.getShort();
        this.mKeyLength = byteBuffer.getShort();
        this.mCipherBlockSize = byteBuffer.getShort();
        this.mIdentityLength = byteBuffer.getInt();
        if (this.mHeaderSize < computeHeaderSize()) {
            throw new IOException("Data MAM protection info is malformed");
        }
    }

    protected int computeHeaderSize() {
        return MIN_HEADER_SIZE + this.mCipherSpecLength + this.mKeyLength + this.mCipherBlockSize + this.mIdentityLength;
    }
}
