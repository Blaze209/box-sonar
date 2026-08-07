package zipkin2;

import com.google.common.base.Ascii;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import zipkin2.internal.HexCodec;
import zipkin2.internal.Nullable;
import zipkin2.internal.RecyclableBuffers;

/* JADX INFO: loaded from: classes6.dex */
public final class Endpoint implements Serializable {
    static final int IPV6_PART_COUNT = 8;
    private static final long serialVersionUID = 0;
    final String ipv4;
    final byte[] ipv4Bytes;
    final String ipv6;
    final byte[] ipv6Bytes;
    final int port;
    final String serviceName;

    enum IpFamily {
        Unknown,
        IPv4,
        IPv4Embedded,
        IPv6
    }

    static boolean isValidNumericChar(char c) {
        return c >= '0' && c <= '9';
    }

    static boolean notHex(char c) {
        if (c >= '0' && c <= '9') {
            return false;
        }
        if (c < 'a' || c > 'f') {
            return c < 'A' || c > 'F';
        }
        return false;
    }

    @Nullable
    public String serviceName() {
        return this.serviceName;
    }

    @Nullable
    public String ipv4() {
        return this.ipv4;
    }

    @Nullable
    public byte[] ipv4Bytes() {
        return this.ipv4Bytes;
    }

    @Nullable
    public String ipv6() {
        return this.ipv6;
    }

    @Nullable
    public byte[] ipv6Bytes() {
        return this.ipv6Bytes;
    }

    @Nullable
    public Integer port() {
        int i = this.port;
        if (i != 0) {
            return Integer.valueOf(i);
        }
        return null;
    }

    public int portAsInt() {
        return this.port;
    }

    public Builder toBuilder() {
        return new Builder(this);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        String ipv4;
        byte[] ipv4Bytes;
        String ipv6;
        byte[] ipv6Bytes;
        int port;
        String serviceName;

        Builder(Endpoint endpoint) {
            this.serviceName = endpoint.serviceName;
            this.ipv4 = endpoint.ipv4;
            this.ipv6 = endpoint.ipv6;
            this.ipv4Bytes = endpoint.ipv4Bytes;
            this.ipv6Bytes = endpoint.ipv6Bytes;
            this.port = endpoint.port;
        }

        Builder merge(Endpoint endpoint) {
            if (this.serviceName == null) {
                this.serviceName = endpoint.serviceName;
            }
            if (this.ipv4 == null) {
                this.ipv4 = endpoint.ipv4;
            }
            if (this.ipv6 == null) {
                this.ipv6 = endpoint.ipv6;
            }
            if (this.ipv4Bytes == null) {
                this.ipv4Bytes = endpoint.ipv4Bytes;
            }
            if (this.ipv6Bytes == null) {
                this.ipv6Bytes = endpoint.ipv6Bytes;
            }
            if (this.port == 0) {
                this.port = endpoint.port;
            }
            return this;
        }

        public Builder serviceName(@Nullable String str) {
            this.serviceName = (str == null || str.isEmpty()) ? null : str.toLowerCase(Locale.ROOT);
            return this;
        }

        public Builder ip(@Nullable InetAddress inetAddress) {
            parseIp(inetAddress);
            return this;
        }

        public final boolean parseIp(@Nullable InetAddress inetAddress) {
            if (inetAddress == null) {
                return false;
            }
            if (inetAddress instanceof Inet4Address) {
                this.ipv4 = inetAddress.getHostAddress();
                this.ipv4Bytes = inetAddress.getAddress();
                return true;
            }
            if (!(inetAddress instanceof Inet6Address)) {
                return false;
            }
            byte[] address = inetAddress.getAddress();
            if (parseEmbeddedIPv4(address)) {
                return true;
            }
            this.ipv6 = Endpoint.writeIpV6(address);
            this.ipv6Bytes = address;
            return true;
        }

        public final boolean parseIp(byte[] bArr) {
            if (bArr == null) {
                return false;
            }
            if (bArr.length == 4) {
                this.ipv4Bytes = bArr;
                this.ipv4 = writeIpV4(bArr);
                return true;
            }
            if (bArr.length != 16) {
                return false;
            }
            if (parseEmbeddedIPv4(bArr)) {
                return true;
            }
            this.ipv6 = Endpoint.writeIpV6(bArr);
            this.ipv6Bytes = bArr;
            return true;
        }

        static String writeIpV4(byte[] bArr) {
            char[] cArrShortStringBuffer = RecyclableBuffers.shortStringBuffer();
            int iWriteBackwards = writeBackwards(bArr[0] & 255, 0, cArrShortStringBuffer);
            cArrShortStringBuffer[iWriteBackwards] = '.';
            int iWriteBackwards2 = writeBackwards(bArr[1] & 255, iWriteBackwards + 1, cArrShortStringBuffer);
            cArrShortStringBuffer[iWriteBackwards2] = '.';
            int iWriteBackwards3 = writeBackwards(bArr[2] & 255, iWriteBackwards2 + 1, cArrShortStringBuffer);
            cArrShortStringBuffer[iWriteBackwards3] = '.';
            return new String(cArrShortStringBuffer, 0, writeBackwards(bArr[3] & 255, iWriteBackwards3 + 1, cArrShortStringBuffer));
        }

        static int writeBackwards(int i, int i2, char[] cArr) {
            if (i < 10) {
                cArr[i2] = HexCodec.HEX_DIGITS[i];
                return i2 + 1;
            }
            int i3 = i2 + (i < 100 ? 2 : 3);
            int i4 = i3;
            while (i != 0) {
                i4--;
                cArr[i4] = HexCodec.HEX_DIGITS[i % 10];
                i /= 10;
            }
            return i3;
        }

        public Builder ip(@Nullable String str) {
            parseIp(str);
            return this;
        }

        public final boolean parseIp(@Nullable String str) {
            byte[] bArrTextToNumericFormatV6;
            if (str != null && !str.isEmpty()) {
                IpFamily ipFamilyDetectFamily = Endpoint.detectFamily(str);
                if (ipFamilyDetectFamily == IpFamily.IPv4) {
                    this.ipv4 = str;
                    this.ipv4Bytes = Endpoint.getIpv4Bytes(str);
                } else if (ipFamilyDetectFamily == IpFamily.IPv4Embedded) {
                    String strSubstring = str.substring(str.lastIndexOf(58) + 1);
                    this.ipv4 = strSubstring;
                    this.ipv4Bytes = Endpoint.getIpv4Bytes(strSubstring);
                } else {
                    if (ipFamilyDetectFamily != IpFamily.IPv6 || (bArrTextToNumericFormatV6 = Endpoint.textToNumericFormatV6(str)) == null) {
                        return false;
                    }
                    this.ipv6 = Endpoint.writeIpV6(bArrTextToNumericFormatV6);
                    this.ipv6Bytes = bArrTextToNumericFormatV6;
                }
                return true;
            }
            return false;
        }

        public Builder port(@Nullable Integer num) {
            if (num != null) {
                if (num.intValue() > 65535) {
                    throw new IllegalArgumentException("invalid port " + num);
                }
                if (num.intValue() <= 0) {
                    num = 0;
                }
            }
            this.port = num != null ? num.intValue() : 0;
            return this;
        }

        public Builder port(int i) {
            if (i > 65535) {
                throw new IllegalArgumentException("invalid port " + i);
            }
            if (i < 0) {
                i = 0;
            }
            this.port = i;
            return this;
        }

        public Endpoint build() {
            return new Endpoint(this);
        }

        Builder() {
        }

        boolean parseEmbeddedIPv4(byte[] bArr) {
            for (int i = 0; i < 10; i++) {
                if (bArr[i] != 0) {
                    return false;
                }
            }
            if ((((bArr[10] & 255) << 8) | (bArr[11] & 255)) != 0) {
                return false;
            }
            byte b = bArr[12];
            byte b2 = bArr[13];
            byte b3 = bArr[14];
            byte b4 = bArr[15];
            if (b == 0 && b2 == 0 && b3 == 0 && b4 == 1) {
                return false;
            }
            this.ipv4 = String.valueOf(b & 255) + '.' + (b2 & 255) + '.' + (b3 & 255) + '.' + (b4 & 255);
            this.ipv4Bytes = new byte[]{b, b2, b3, b4};
            return true;
        }
    }

    static IpFamily detectFamily(String str) {
        int length = str.length();
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '.') {
                z2 = true;
            } else if (cCharAt == ':') {
                if (z2) {
                    return IpFamily.Unknown;
                }
                z = true;
            } else if (notHex(cCharAt)) {
                return IpFamily.Unknown;
            }
        }
        if (!z) {
            if (z2 && isValidIpV4Address(str, 0, str.length())) {
                return IpFamily.IPv4;
            }
            return IpFamily.Unknown;
        }
        if (z2) {
            int iLastIndexOf = str.lastIndexOf(58);
            if (!isValidIpV4Address(str, iLastIndexOf + 1, str.length())) {
                return IpFamily.Unknown;
            }
            if (iLastIndexOf == 1 && str.charAt(0) == ':') {
                return IpFamily.IPv4Embedded;
            }
            if (iLastIndexOf != 6 || str.charAt(0) != ':' || str.charAt(1) != ':') {
                return IpFamily.Unknown;
            }
            for (int i2 = 2; i2 < 6; i2++) {
                char cCharAt2 = str.charAt(i2);
                if (cCharAt2 != 'f' && cCharAt2 != 'F' && cCharAt2 != '0') {
                    return IpFamily.Unknown;
                }
            }
            return IpFamily.IPv4Embedded;
        }
        return IpFamily.IPv6;
    }

    static String writeIpV6(byte[] bArr) {
        int i;
        char[] cArrShortStringBuffer = RecyclableBuffers.shortStringBuffer();
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        boolean z = true;
        for (int i5 = 0; i5 < bArr.length; i5 += 2) {
            if (bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                if (i3 < 0) {
                    i3 = i5;
                }
            } else if (i3 >= 0) {
                int i6 = i5 - i3;
                if (i6 > i4) {
                    i4 = i6;
                    i2 = i3;
                }
                z = false;
                i3 = -1;
            } else {
                z = false;
            }
        }
        if (z) {
            return "::";
        }
        if (i2 == -1 && i3 != -1) {
            i4 = 16 - i3;
            i2 = i3;
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < bArr.length) {
            if (i7 == i2) {
                i = i8 + 1;
                cArrShortStringBuffer[i8] = AbstractJsonLexerKt.COLON;
                i7 += i4;
                if (i7 == bArr.length) {
                    i8 += 2;
                    cArrShortStringBuffer[i] = AbstractJsonLexerKt.COLON;
                }
            } else {
                if (i7 != 0) {
                    cArrShortStringBuffer[i8] = AbstractJsonLexerKt.COLON;
                    i8++;
                }
                int i9 = i7 + 1;
                byte b = bArr[i7];
                i7 += 2;
                byte b2 = bArr[i9];
                char c = HexCodec.HEX_DIGITS[(b >> 4) & 15];
                boolean z2 = c == '0';
                if (!z2) {
                    cArrShortStringBuffer[i8] = c;
                    i8++;
                }
                char c2 = HexCodec.HEX_DIGITS[b & Ascii.SI];
                boolean z3 = z2 && c2 == '0';
                if (!z3) {
                    cArrShortStringBuffer[i8] = c2;
                    i8++;
                }
                char c3 = HexCodec.HEX_DIGITS[(b2 >> 4) & 15];
                if (!z3 || c3 != '0') {
                    cArrShortStringBuffer[i8] = c3;
                    i8++;
                }
                i = i8 + 1;
                cArrShortStringBuffer[i8] = HexCodec.HEX_DIGITS[b2 & Ascii.SI];
            }
            i8 = i;
        }
        return new String(cArrShortStringBuffer, 0, i8);
    }

    @Nullable
    static byte[] textToNumericFormatV6(String str) {
        int length;
        int i;
        String[] strArrSplit = str.split(":", 10);
        if (strArrSplit.length < 3 || strArrSplit.length > 9) {
            return null;
        }
        int i2 = -1;
        for (int i3 = 1; i3 < strArrSplit.length - 1; i3++) {
            if (strArrSplit[i3].length() == 0) {
                if (i2 >= 0) {
                    return null;
                }
                i2 = i3;
            }
        }
        if (i2 >= 0) {
            int length2 = strArrSplit.length - i2;
            i = length2 - 1;
            if (strArrSplit[0].length() == 0) {
                length = i2 - 1;
                if (length != 0) {
                    return null;
                }
            } else {
                length = i2;
            }
            if (strArrSplit[strArrSplit.length - 1].length() == 0 && (i = length2 - 2) != 0) {
                return null;
            }
        } else {
            length = strArrSplit.length;
            i = 0;
        }
        int i4 = 8 - (length + i);
        if (i2 < 0 ? i4 != 0 : i4 < 1) {
            return null;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
        for (int i5 = 0; i5 < length; i5++) {
            try {
                byteBufferAllocate.putShort(parseHextet(strArrSplit[i5]));
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        for (int i6 = 0; i6 < i4; i6++) {
            byteBufferAllocate.putShort((short) 0);
        }
        while (i > 0) {
            byteBufferAllocate.putShort(parseHextet(strArrSplit[strArrSplit.length - i]));
            i--;
        }
        return byteBufferAllocate.array();
    }

    static short parseHextet(String str) {
        int i = Integer.parseInt(str, 16);
        if (i <= 65535) {
            return (short) i;
        }
        throw new NumberFormatException();
    }

    static boolean isValidIpV4Address(String str, int i, int i2) {
        int iIndexOf;
        int iIndexOf2;
        int iIndexOf3;
        int i3 = i2 - i;
        return i3 <= 15 && i3 >= 7 && (iIndexOf = str.indexOf(46, i + 1)) > 0 && isValidIpV4Word(str, i, iIndexOf) && (iIndexOf2 = str.indexOf(46, iIndexOf + 2)) > 0 && isValidIpV4Word(str, iIndexOf + 1, iIndexOf2) && (iIndexOf3 = str.indexOf(46, iIndexOf2 + 2)) > 0 && isValidIpV4Word(str, iIndexOf2 + 1, iIndexOf3) && isValidIpV4Word(str, iIndexOf3 + 1, i2);
    }

    static boolean isValidIpV4Word(CharSequence charSequence, int i, int i2) {
        char cCharAt;
        char cCharAt2;
        int i3 = i2 - i;
        if (i3 >= 1 && i3 <= 3 && (cCharAt = charSequence.charAt(i)) >= '0') {
            if (i3 == 3) {
                char cCharAt3 = charSequence.charAt(i + 1);
                return cCharAt3 >= '0' && (cCharAt2 = charSequence.charAt(i + 2)) >= '0' && ((cCharAt <= '1' && cCharAt3 <= '9' && cCharAt2 <= '9') || (cCharAt == '2' && cCharAt3 <= '5' && (cCharAt2 <= '5' || (cCharAt3 < '5' && cCharAt2 <= '9'))));
            }
            if (cCharAt <= '9' && (i3 == 1 || isValidNumericChar(charSequence.charAt(i + 1)))) {
                return true;
            }
        }
        return false;
    }

    Endpoint(Builder builder) {
        this.serviceName = builder.serviceName;
        this.ipv4 = builder.ipv4;
        this.ipv4Bytes = builder.ipv4Bytes;
        this.ipv6 = builder.ipv6;
        this.ipv6Bytes = builder.ipv6Bytes;
        this.port = builder.port;
    }

    Endpoint(SerializedForm serializedForm) {
        this.serviceName = serializedForm.serviceName;
        this.ipv4 = serializedForm.ipv4;
        this.ipv4Bytes = serializedForm.ipv4Bytes;
        this.ipv6 = serializedForm.ipv6;
        this.ipv6Bytes = serializedForm.ipv6Bytes;
        this.port = serializedForm.port;
    }

    public String toString() {
        return "Endpoint{serviceName=" + this.serviceName + ", ipv4=" + this.ipv4 + ", ipv6=" + this.ipv6 + ", port=" + this.port + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Endpoint)) {
            return false;
        }
        Endpoint endpoint = (Endpoint) obj;
        String str = this.serviceName;
        if (str != null ? str.equals(endpoint.serviceName) : endpoint.serviceName == null) {
            String str2 = this.ipv4;
            if (str2 != null ? str2.equals(endpoint.ipv4) : endpoint.ipv4 == null) {
                String str3 = this.ipv6;
                if (str3 != null ? str3.equals(endpoint.ipv6) : endpoint.ipv6 == null) {
                    if (this.port == endpoint.port) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.serviceName;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.ipv4;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.ipv6;
        return this.port ^ ((iHashCode2 ^ (str3 != null ? str3.hashCode() : 0)) * 1000003);
    }

    final Object writeReplace() throws ObjectStreamException {
        return new SerializedForm(this);
    }

    static final class SerializedForm implements Serializable {
        static final long serialVersionUID = 0;
        final String ipv4;
        final byte[] ipv4Bytes;
        final String ipv6;
        final byte[] ipv6Bytes;
        final int port;
        final String serviceName;

        SerializedForm(Endpoint endpoint) {
            this.serviceName = endpoint.serviceName;
            this.ipv4 = endpoint.ipv4;
            this.ipv4Bytes = endpoint.ipv4Bytes;
            this.ipv6 = endpoint.ipv6;
            this.ipv6Bytes = endpoint.ipv6Bytes;
            this.port = endpoint.port;
        }

        Object readResolve() throws ObjectStreamException {
            try {
                return new Endpoint(this);
            } catch (IllegalArgumentException e) {
                throw new StreamCorruptedException(e.getMessage());
            }
        }
    }

    static byte[] getIpv4Bytes(String str) {
        int i;
        byte[] bArr = new byte[4];
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i2 + 1;
            int iCharAt = str.charAt(i2) - '0';
            if (i4 != length) {
                int i5 = i2 + 2;
                char cCharAt = str.charAt(i4);
                if (cCharAt == '.') {
                    i2 = i5;
                } else {
                    int i6 = (iCharAt * 10) + (cCharAt - '0');
                    if (i5 != length) {
                        int i7 = i2 + 3;
                        char cCharAt2 = str.charAt(i5);
                        if (cCharAt2 == '.') {
                            i2 = i7;
                        } else {
                            i = i3 + 1;
                            bArr[i3] = (byte) ((i6 * 10) + (cCharAt2 - '0'));
                            i2 += 4;
                        }
                    } else {
                        i2 = i5;
                    }
                    i = i3 + 1;
                    bArr[i3] = (byte) i6;
                }
                i3 = i;
            } else {
                i2 = i4;
            }
            i = i3 + 1;
            bArr[i3] = (byte) iCharAt;
            i3 = i;
        }
        return bArr;
    }
}
