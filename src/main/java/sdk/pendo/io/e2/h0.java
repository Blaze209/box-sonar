package sdk.pendo.io.e2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H&¨\u0006\r"}, d2 = {"Lsdk/pendo/io/e2/h0;", "", "", "text", "", "send", "Lsdk/pendo/io/s2/g;", "bytes", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "code", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, HeaderElements.CLOSE, "okhttp"}, k = 1, mv = {1, 8, 0})
public interface h0 {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lsdk/pendo/io/e2/h0$a;", "", "Lsdk/pendo/io/e2/b0;", "request", "Lsdk/pendo/io/e2/i0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lsdk/pendo/io/e2/h0;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "okhttp"}, k = 1, mv = {1, 8, 0})
    public interface a {
        h0 a(b0 request, i0 listener);
    }

    boolean a(sdk.pendo.io.s2.g bytes);

    boolean close(int code, String reason);

    boolean send(String text);
}
