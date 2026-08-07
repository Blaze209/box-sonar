package sdk.pendo.io.d7;

import android.view.View;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.b7.g;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000\u001a\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0003\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/view/View;", "view", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "obj", "", "(Ljava/lang/Object;)Ljava/lang/Float;", "pendoIO_release"}, k = 2, mv = {1, 9, 0})
public final class f {
    public static final boolean a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Float fA = a((Object) view);
        return fA != null && fA.floatValue() <= 0.0f;
    }

    private static final Float a(Object obj) {
        float fFloatValue;
        g gVar = g.a;
        Object objA = gVar.a(obj, "mBackfaceOpacity");
        if (objA == null) {
            objA = gVar.a(obj, "backfaceOpacity");
        }
        boolean z = objA instanceof Float;
        if (z) {
            return (Float) objA;
        }
        if (z) {
            fFloatValue = ((Float) objA).floatValue();
        } else {
            if (!(objA instanceof Number)) {
                return null;
            }
            fFloatValue = ((Number) objA).floatValue();
        }
        return Float.valueOf(fFloatValue);
    }
}
