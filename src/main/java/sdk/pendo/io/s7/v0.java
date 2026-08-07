package sdk.pendo.io.s7;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\f\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u001a\u0016\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0000\u001a/\u0010\n\u001a\u00020\b*\u0004\u0018\u00010\u00002!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004\u001a1\u0010\u0002\u001a\u00020\b*\u0004\u0018\u00010\u00002#\u0010\t\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004¨\u0006\u000b"}, d2 = {"", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "other", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "string", "", "block", "b", "pendoIO_release"}, k = 2, mv = {1, 9, 0})
public final class v0 {
    public static final boolean a(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str != null) {
            return str.equals(str2);
        }
        return false;
    }

    public static final void b(String str, Function1<? super String, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (str == null || StringsKt.isBlank(str)) {
            return;
        }
        block.invoke(str);
    }

    public static final boolean a(String str) {
        if (str != null) {
            return StringsKt.isBlank(str);
        }
        return true;
    }

    public static final void a(String str, Function1<? super String, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (str == null || !StringsKt.isBlank(str)) {
            block.invoke(str);
        }
    }
}
