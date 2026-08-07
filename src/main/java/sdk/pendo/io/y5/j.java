package sdk.pendo.io.y5;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.io.IOException;
import java.net.SocketException;
import kotlin.Metadata;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.s7.y0;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\b"}, d2 = {"Lsdk/pendo/io/y5/j;", "Lsdk/pendo/io/q3/e;", "", "e", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class j implements sdk.pendo.io.q3.e<Throwable> {
    @Override // sdk.pendo.io.q3.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(Throwable e) throws Throwable {
        Throwable cause;
        Throwable cause2;
        if (y0.a(e)) {
            PendoLogger.i("Throwable passed to RxJavaPlugins error handler", new Object[0]);
            if (e == null || (cause = e.getCause()) == null) {
                cause = e;
            }
            if ((cause instanceof d) && (cause2 = ((d) cause).getCause()) != null) {
                PendoLogger.e("RxJavaPlugins error handler: Exception thrown by app, Pendo is rethrowing it - " + cause, new Object[0]);
                throw cause2;
            }
            if (e instanceof sdk.pendo.io.p3.f) {
                PendoLogger.w("RxJavaPlugins error handler: UndeliverableException. Will not crash " + cause, new Object[0]);
                return;
            }
            if (e instanceof SocketException ? true : e instanceof IOException) {
                PendoLogger.d("RxJavaPlugins error handler: IOException or SocketException, " + cause + ". Will not crash", new Object[0]);
            } else if (e instanceof InterruptedException) {
                PendoLogger.d("RxJavaPlugins error handler: InterruptedException, " + cause + ". Will not crash", new Object[0]);
            } else {
                PendoLogger.e(e, "RxJavaPlugins error handler: " + cause + ". Will not crash, but will be reported", new Object[0]);
            }
        }
    }
}
