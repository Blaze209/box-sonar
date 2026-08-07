package sdk.pendo.io.e2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J \u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bH\u0016J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\"\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/e2/i0;", "", "Lsdk/pendo/io/e2/h0;", "webSocket", "Lsdk/pendo/io/e2/d0;", "response", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "text", "Lsdk/pendo/io/s2/g;", "bytes", "", "code", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, "b", "", "t", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
public abstract class i0 {
    public abstract void a(h0 webSocket, int code, String reason);

    public abstract void a(h0 webSocket, String text);

    public abstract void a(h0 webSocket, Throwable t, d0 response);

    public abstract void a(h0 webSocket, d0 response);

    public abstract void a(h0 webSocket, sdk.pendo.io.s2.g bytes);

    public void b(h0 webSocket, int code, String reason) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(reason, "reason");
    }
}
