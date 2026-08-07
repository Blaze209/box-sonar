package com.benasher44.uuid;

import com.facebook.hermes.intl.Constants;
import java.nio.ByteBuffer;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: uuid.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u001a\r\u0010\u000b\u001a\u00060\u0002j\u0002`\fH\u0086\b\u001a\u0012\u0010\r\u001a\u00060\u0002j\u0002`\f2\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u0012\u0010\u0010\u001a\u00060\u0002j\u0002`\f2\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u001c\u0010\u0011\u001a\u00020\u0012*\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0005\u001a\u00020\u0006*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0016\u0010\t\u001a\u00020\u0006*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\b*\n\u0010\u0015\"\u00020\u00022\u00020\u0002¨\u0006\u0016"}, d2 = {"bytes", "", "Ljava/util/UUID;", "getBytes", "(Ljava/util/UUID;)[B", Constants.SENSITIVITY_VARIANT, "", "getVariant", "(Ljava/util/UUID;)I", "version", "getVersion", "uuid4", "Lcom/benasher44/uuid/Uuid;", "uuidFrom", "string", "", "uuidOf", "segmentToLong", "", "start", "end", "Uuid", "uuid"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class UuidKt {
    public static /* synthetic */ void Uuid$annotations() {
    }

    public static final UUID uuidOf(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (!(bytes.length == 16)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Invalid UUID bytes. Expected 16 bytes; found ", Integer.valueOf(bytes.length)).toString());
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bytes);
        return new UUID(byteBufferWrap.getLong(), byteBufferWrap.getLong());
    }

    public static final UUID uuidFrom(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        if (string.length() == 36) {
            return new UUID(segmentToLong(string, 0, 19), segmentToLong(string, 19, 36));
        }
        throw new IllegalArgumentException("Invalid UUID string, expected exactly 36 characters but got " + string.length() + ": " + string);
    }

    private static final long segmentToLong(String str, int i, int i2) {
        long j;
        long j2 = 0;
        do {
            if (str.charAt(i) == '-') {
                if (!(i == 8 || i == 13 || i == 18 || i == 23)) {
                    throw new IllegalArgumentException(("Invalid UUID string, encountered dash at index " + i + " but it can occur only at 8, 13, 18, or 23: " + str).toString());
                }
            } else {
                j2 *= (long) 16;
                char cCharAt = str.charAt(i);
                if (cCharAt != '0') {
                    if (cCharAt == '1') {
                        j = 1;
                    } else if (cCharAt == '2') {
                        j = 2;
                    } else if (cCharAt == '3') {
                        j = 3;
                    } else if (cCharAt == '4') {
                        j = 4;
                    } else if (cCharAt == '5') {
                        j = 5;
                    } else if (cCharAt == '6') {
                        j = 6;
                    } else if (cCharAt == '7') {
                        j = 7;
                    } else if (cCharAt == '8') {
                        j = 8;
                    } else if (cCharAt == '9') {
                        j = 9;
                    } else if (cCharAt == 'a' || cCharAt == 'A') {
                        j = 10;
                    } else if (cCharAt == 'b' || cCharAt == 'B') {
                        j = 11;
                    } else if (cCharAt == 'c' || cCharAt == 'C') {
                        j = 12;
                    } else if (cCharAt == 'd' || cCharAt == 'D') {
                        j = 13;
                    } else if (cCharAt == 'e' || cCharAt == 'E') {
                        j = 14;
                    } else {
                        if (cCharAt != 'f' && cCharAt != 'F') {
                            throw new IllegalArgumentException("Invalid UUID string, encountered non-hexadecimal digit `" + str.charAt(i) + "` at index " + i + " in: " + str);
                        }
                        j = 15;
                    }
                    j2 += j;
                }
            }
            i++;
        } while (i < i2);
        return j2;
    }

    public static final UUID uuid4() {
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        return uuidRandomUUID;
    }

    public static final byte[] getBytes(UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "<this>");
        byte[] bArrArray = ByteBuffer.allocate(16).putLong(uuid.getMostSignificantBits()).putLong(uuid.getLeastSignificantBits()).array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "allocate(16).putLong(mos…tSignificantBits).array()");
        return bArrArray;
    }

    public static final int getVersion(UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "<this>");
        return uuid.version();
    }

    public static final int getVariant(UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "<this>");
        return uuid.variant();
    }
}
