package sdk.pendo.io.v6;

import android.view.MotionEvent;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import sdk.pendo.io.s7.b0;
import sdk.pendo.io.x6.m;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/v6/g;", "Lsdk/pendo/io/s7/b0;", "Landroid/view/MotionEvent;", "event", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "Lsdk/pendo/io/v6/c;", "Lsdk/pendo/io/v6/c;", "composeHandler", "Lsdk/pendo/io/x6/m;", "b", "Lsdk/pendo/io/x6/m;", "viewHandler", "<init>", "(Lsdk/pendo/io/v6/c;Lsdk/pendo/io/x6/m;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class g implements b0 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final c composeHandler;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final m viewHandler;

    public g(c composeHandler, m viewHandler) {
        Intrinsics.checkNotNullParameter(composeHandler, "composeHandler");
        Intrinsics.checkNotNullParameter(viewHandler, "viewHandler");
        this.composeHandler = composeHandler;
        this.viewHandler = viewHandler;
    }

    @Override // sdk.pendo.io.s7.b0
    public boolean a(MotionEvent event) throws JSONException {
        if (this.composeHandler.a(event)) {
            return true;
        }
        this.viewHandler.a(event);
        return true;
    }

    @Override // sdk.pendo.io.s7.b0
    public void a() {
        this.composeHandler.a();
        this.viewHandler.a();
    }
}
