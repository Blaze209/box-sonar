package sdk.pendo.io.s2;

import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lsdk/pendo/io/s2/z;", "Lsdk/pendo/io/s2/c;", "Ljava/io/IOException;", "cause", "b", "", "n", "Ljava/net/Socket;", "o", "Ljava/net/Socket;", "socket", "<init>", "(Ljava/net/Socket;)V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
final class z extends c {

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private final Socket socket;

    public z(Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        this.socket = socket;
    }

    @Override // sdk.pendo.io.s2.c
    protected IOException b(IOException cause) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException(ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE);
        if (cause != null) {
            socketTimeoutException.initCause(cause);
        }
        return socketTimeoutException;
    }

    @Override // sdk.pendo.io.s2.c
    protected void n() {
        Level level;
        StringBuilder sb;
        Logger logger;
        Throwable th;
        try {
            this.socket.close();
        } catch (AssertionError e) {
            if (!o.a(e)) {
                throw e;
            }
            Logger logger2 = p.a;
            level = Level.WARNING;
            sb = new StringBuilder("Failed to close timed out socket ");
            th = e;
            logger = logger2;
            logger.log(level, sb.append(this.socket).toString(), th);
        } catch (Exception e2) {
            Logger logger3 = p.a;
            level = Level.WARNING;
            sb = new StringBuilder("Failed to close timed out socket ");
            th = e2;
            logger = logger3;
            logger.log(level, sb.append(this.socket).toString(), th);
        }
    }
}
