package sdk.pendo.io.i6;

import kotlin.Metadata;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H$¨\u0006\u0007"}, d2 = {"Lsdk/pendo/io/i6/a;", "Ljava/lang/Runnable;", "", "run", "execute", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public abstract class a implements Runnable {
    protected abstract void execute();

    @Override // java.lang.Runnable
    public void run() {
        try {
            execute();
        } catch (Exception e) {
            String message = e.getMessage();
            if (message != null) {
                PendoLogger.d(e, message, new Object[0]);
            }
        }
    }
}
