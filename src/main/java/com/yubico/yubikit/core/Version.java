package com.yubico.yubikit.core;

import com.google.common.base.Ascii;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class Version implements Comparable<Version> {
    private static final Pattern VERSION_STRING_PATTERN = Pattern.compile("\\b(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\b");
    public final byte major;
    public final byte micro;
    public final byte minor;

    private static byte checkRange(int i) {
        if (i < 0 || i > 127) {
            throw new IllegalArgumentException("Version component out of supported range (0-127)");
        }
        return (byte) i;
    }

    public Version(int i, int i2, int i3) {
        this(checkRange(i), checkRange(i2), checkRange(i3));
    }

    public Version(byte b, byte b2, byte b3) {
        this.major = b;
        this.minor = b2;
        this.micro = b3;
    }

    public byte[] getBytes() {
        return new byte[]{this.major, this.minor, this.micro};
    }

    private int compareToVersion(int i, int i2, int i3) {
        return Integer.compare(this.micro | (this.major << Ascii.DLE) | (this.minor << 8), (i << 16) | (i2 << 8) | i3);
    }

    @Override // java.lang.Comparable
    public int compareTo(Version version) {
        return compareToVersion(version.major, version.minor, version.micro);
    }

    public boolean isLessThan(int i, int i2, int i3) {
        return compareToVersion(i, i2, i3) < 0;
    }

    public boolean isAtLeast(int i, int i2, int i3) {
        return compareToVersion(i, i2, i3) >= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Version version = (Version) obj;
            if (this.major == version.major && this.minor == version.minor && this.micro == version.micro) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Byte.valueOf(this.major), Byte.valueOf(this.minor), Byte.valueOf(this.micro));
    }

    public String toString() {
        return String.format(Locale.ROOT, "%d.%d.%d", Integer.valueOf(this.major & 255), Integer.valueOf(this.minor & 255), Integer.valueOf(this.micro & 255));
    }

    public static Version fromBytes(byte[] bArr) {
        if (bArr.length < 3) {
            throw new IllegalArgumentException("Version byte array must contain 3 bytes.");
        }
        return new Version(bArr[0], bArr[1], bArr[2]);
    }

    public static Version parse(String str) {
        Matcher matcher = VERSION_STRING_PATTERN.matcher(str);
        if (matcher.find()) {
            return new Version(Byte.parseByte(matcher.group(1)), Byte.parseByte(matcher.group(2)), Byte.parseByte(matcher.group(3)));
        }
        throw new IllegalArgumentException("Invalid version string");
    }
}
