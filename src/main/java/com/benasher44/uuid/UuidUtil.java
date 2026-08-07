package com.benasher44.uuid;

import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: uuid.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0011\u001a\u00060\u0012j\u0002`\u00132\n\u0010\u0014\u001a\u00060\u0012j\u0002`\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00038\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u00038\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\b\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"UUID_BYTES", "", "UUID_CHARS", "", "", "getUUID_CHARS$annotations", "()V", "getUUID_CHARS", "()Ljava/util/List;", "UUID_CHAR_RANGES", "Lkotlin/ranges/IntRange;", "getUUID_CHAR_RANGES$annotations", "getUUID_CHAR_RANGES", "UUID_HYPHEN_INDICES", "getUUID_HYPHEN_INDICES$annotations", "getUUID_HYPHEN_INDICES", "UUID_STRING_LENGTH", "nameBasedUuidOf", "Ljava/util/UUID;", "Lcom/benasher44/uuid/Uuid;", "namespace", "name", "", "hasher", "Lcom/benasher44/uuid/UuidHasher;", "uuid"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class UuidUtil {
    public static final int UUID_BYTES = 16;
    public static final int UUID_STRING_LENGTH = 36;
    private static final List<IntRange> UUID_CHAR_RANGES = CollectionsKt.listOf((Object[]) new IntRange[]{RangesKt.until(0, 8), RangesKt.until(9, 13), RangesKt.until(14, 18), RangesKt.until(19, 23), RangesKt.until(24, 36)});
    private static final List<Integer> UUID_HYPHEN_INDICES = CollectionsKt.listOf((Object[]) new Integer[]{8, 13, 18, 23});
    private static final List<Character> UUID_CHARS = CollectionsKt.plus((Iterable) new CharRange('0', '9'), (Iterable) new CharRange('a', 'f'));

    public static /* synthetic */ void getUUID_CHARS$annotations() {
    }

    public static /* synthetic */ void getUUID_CHAR_RANGES$annotations() {
    }

    public static /* synthetic */ void getUUID_HYPHEN_INDICES$annotations() {
    }

    public static final List<IntRange> getUUID_CHAR_RANGES() {
        return UUID_CHAR_RANGES;
    }

    public static final List<Integer> getUUID_HYPHEN_INDICES() {
        return UUID_HYPHEN_INDICES;
    }

    public static final List<Character> getUUID_CHARS() {
        return UUID_CHARS;
    }

    public static final UUID nameBasedUuidOf(UUID namespace, String name, UuidHasher hasher) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(hasher, "hasher");
        hasher.update(UuidKt.getBytes(namespace));
        hasher.update(StringsKt.encodeToByteArray(name));
        byte[] bArrDigest = hasher.digest();
        bArrDigest[6] = (byte) (((byte) (hasher.getVersion() << 4)) | ((byte) (bArrDigest[6] & Ascii.SI)));
        bArrDigest[8] = (byte) (((byte) (bArrDigest[8] & 63)) | (-128));
        byte[] bArrCopyOf = Arrays.copyOf(bArrDigest, 16);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        return UuidKt.uuidOf(bArrCopyOf);
    }
}
