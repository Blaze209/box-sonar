package sdk.pendo.io.s2;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import java.io.Closeable;
import java.io.Flushable;
import kotlin.Metadata;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0007H&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lsdk/pendo/io/s2/y;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "Lsdk/pendo/io/s2/d;", "source", "", "byteCount", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "flush", "Lsdk/pendo/io/s2/b0;", ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE, HeaderElements.CLOSE, "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
public interface y extends Closeable, Flushable {
    void a(d source, long byteCount);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();

    b0 timeout();
}
