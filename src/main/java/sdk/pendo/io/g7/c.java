package sdk.pendo.io.g7;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.ViewGroup;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.b7.f;
import sdk.pendo.io.b7.j;
import sdk.pendo.io.e7.h;
import sdk.pendo.io.h7.s;
import sdk.pendo.io.j7.g;
import sdk.pendo.io.j7.o;
import sdk.pendo.io.j7.v;
import sdk.pendo.io.j7.y;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u000b\u0010\fJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lsdk/pendo/io/g7/c;", "Lsdk/pendo/io/e7/h;", "Landroid/view/ViewGroup;", "", "id", "view", ViewProps.Z_INDEX, "Lsdk/pendo/io/h7/s;", "privacyConfig", "Lsdk/pendo/io/j7/v;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class c implements h<ViewGroup> {
    @Override // sdk.pendo.io.e7.h
    public v a(int id, ViewGroup view, int zIndex, s privacyConfig) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(privacyConfig, "privacyConfig");
        Rect rectB = j.a.b(view);
        sdk.pendo.io.f7.a aVar = sdk.pendo.io.f7.a.a;
        sdk.pendo.io.j7.c cVarA = sdk.pendo.io.f7.a.a(aVar, id + 1, zIndex, rectB, view, null, 16, null);
        Bitmap bitmapA = f.a.a(view, privacyConfig.c(), "ViewGroupBackground");
        if (bitmapA != null) {
            sdk.pendo.io.j7.h hVarA = aVar.a(id + 2, zIndex, (Rect) null, bitmapA, "ViewGroupBackground");
            hVarA.a(new y(100, y.a.PERCENT));
            hVarA.a(new g(100, g.a.PERCENT));
            hVarA.a(new o(o.a.FILL));
            cVarA.a(hVarA);
        }
        return cVarA;
    }
}
