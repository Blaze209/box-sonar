package com.microsoft.identity.common.base64;

import android.util.Base64;
import com.microsoft.identity.common.java.base64.Base64Flags;
import com.microsoft.identity.common.java.base64.IBase64;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidBase64.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0002¢\u0006\u0002\u0010\bJ)\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0016¢\u0006\u0002\u0010\fJ)\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0016¢\u0006\u0002\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/microsoft/identity/common/base64/AndroidBase64;", "Lcom/microsoft/identity/common/java/base64/IBase64;", "()V", "combineFlags", "", "flags", "", "Lcom/microsoft/identity/common/java/base64/Base64Flags;", "([Lcom/microsoft/identity/common/java/base64/Base64Flags;)I", "decode", "", "input", "([B[Lcom/microsoft/identity/common/java/base64/Base64Flags;)[B", "encode", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidBase64 implements IBase64 {
    @Override // com.microsoft.identity.common.java.base64.IBase64
    public byte[] encode(byte[] input, Base64Flags... flags) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(flags, "flags");
        byte[] bArrEncode = Base64.encode(input, combineFlags((Base64Flags[]) Arrays.copyOf(flags, flags.length)));
        Intrinsics.checkNotNullExpressionValue(bArrEncode, "encode(input, combineFlags(*flags))");
        return bArrEncode;
    }

    @Override // com.microsoft.identity.common.java.base64.IBase64
    public byte[] decode(byte[] input, Base64Flags... flags) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(flags, "flags");
        byte[] bArrDecode = Base64.decode(input, combineFlags((Base64Flags[]) Arrays.copyOf(flags, flags.length)));
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(input, combineFlags(*flags))");
        return bArrDecode;
    }

    private final int combineFlags(Base64Flags... flags) {
        int i = ArraysKt.contains(flags, Base64Flags.URL_SAFE) ? 8 : 0;
        if (ArraysKt.contains(flags, Base64Flags.NO_WRAP)) {
            i |= 2;
        }
        return ArraysKt.contains(flags, Base64Flags.NO_PADDING) ? i | 1 : i;
    }
}
