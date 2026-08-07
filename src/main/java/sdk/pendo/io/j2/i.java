package sdk.pendo.io.j2;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\b\u0000\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R\u0017\u0010\t\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR$\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00038\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\u000b\u0010\b¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/j2/i;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "Ljava/io/IOException;", "e", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/io/IOException;", "()Ljava/io/IOException;", "firstConnectException", "<set-?>", "b", "lastConnectException", "<init>", "(Ljava/io/IOException;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class i extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final IOException firstConnectException;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private IOException lastConnectException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(IOException firstConnectException) {
        super(firstConnectException);
        Intrinsics.checkNotNullParameter(firstConnectException, "firstConnectException");
        this.firstConnectException = firstConnectException;
        this.lastConnectException = firstConnectException;
    }

    public final void a(IOException e) {
        Intrinsics.checkNotNullParameter(e, "e");
        ExceptionsKt.addSuppressed(this.firstConnectException, e);
        this.lastConnectException = e;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final IOException getLastConnectException() {
        return this.lastConnectException;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final IOException getFirstConnectException() {
        return this.firstConnectException;
    }
}
