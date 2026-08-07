package zipkin2.reporter;

import com.google.common.base.Ascii;
import com.yubico.yubikit.core.fido.CtapException;
import java.util.List;
import zipkin2.codec.Encoding;

/* JADX INFO: loaded from: classes6.dex */
public enum BytesMessageEncoder {
    JSON { // from class: zipkin2.reporter.BytesMessageEncoder.1
        @Override // zipkin2.reporter.BytesMessageEncoder
        public byte[] encode(List<byte[]> list) {
            int size = list.size();
            int length = 2;
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                length += list.get(i).length;
                if (i2 < size) {
                    length++;
                }
                i = i2;
            }
            byte[] bArr = new byte[length];
            bArr[0] = 91;
            int length2 = 1;
            int i3 = 0;
            while (i3 < size) {
                int i4 = i3 + 1;
                byte[] bArr2 = list.get(i3);
                System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
                length2 += bArr2.length;
                if (i4 < size) {
                    bArr[length2] = CtapException.ERR_INVALID_OPTION;
                    length2++;
                }
                i3 = i4;
            }
            bArr[length2] = 93;
            return bArr;
        }
    },
    THRIFT { // from class: zipkin2.reporter.BytesMessageEncoder.2
        @Override // zipkin2.reporter.BytesMessageEncoder
        public byte[] encode(List<byte[]> list) {
            int size = list.size();
            int length = 5;
            int length2 = 5;
            for (int i = 0; i < size; i++) {
                length2 += list.get(i).length;
            }
            byte[] bArr = new byte[length2];
            bArr[0] = Ascii.FF;
            bArr[1] = (byte) ((size >>> 24) & 255);
            bArr[2] = (byte) ((size >>> 16) & 255);
            bArr[3] = (byte) ((size >>> 8) & 255);
            bArr[4] = (byte) (size & 255);
            int i2 = 0;
            while (i2 < size) {
                int i3 = i2 + 1;
                byte[] bArr2 = list.get(i2);
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
                i2 = i3;
            }
            return bArr;
        }
    },
    PROTO3 { // from class: zipkin2.reporter.BytesMessageEncoder.3
        @Override // zipkin2.reporter.BytesMessageEncoder
        public byte[] encode(List<byte[]> list) {
            int size = list.size();
            int length = 0;
            for (int i = 0; i < size; i++) {
                length += list.get(i).length;
            }
            byte[] bArr = new byte[length];
            int i2 = 0;
            int length2 = 0;
            while (i2 < size) {
                int i3 = i2 + 1;
                byte[] bArr2 = list.get(i2);
                System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
                length2 += bArr2.length;
                i2 = i3;
            }
            return bArr;
        }
    };

    public abstract byte[] encode(List<byte[]> list);

    /* JADX INFO: renamed from: zipkin2.reporter.BytesMessageEncoder$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$zipkin2$codec$Encoding;

        static {
            int[] iArr = new int[Encoding.values().length];
            $SwitchMap$zipkin2$codec$Encoding = iArr;
            try {
                iArr[Encoding.JSON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$zipkin2$codec$Encoding[Encoding.PROTO3.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$zipkin2$codec$Encoding[Encoding.THRIFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static BytesMessageEncoder forEncoding(Encoding encoding) {
        if (encoding == null) {
            throw new NullPointerException("encoding == null");
        }
        int i = AnonymousClass4.$SwitchMap$zipkin2$codec$Encoding[encoding.ordinal()];
        if (i == 1) {
            return JSON;
        }
        if (i == 2) {
            return PROTO3;
        }
        if (i == 3) {
            return THRIFT;
        }
        throw new UnsupportedOperationException(encoding.name());
    }
}
