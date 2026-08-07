package external.sdk.pendo.io.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes4.dex */
class t {
    private boolean a;
    private final Handler b = new Handler(Looper.getMainLooper(), new a());

    private static final class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((sdk.pendo.io.h.c) message.obj).recycle();
            return true;
        }
    }

    t() {
    }

    synchronized void a(sdk.pendo.io.h.c<?> cVar, boolean z) {
        if (this.a || z) {
            this.b.obtainMessage(1, cVar).sendToTarget();
        } else {
            this.a = true;
            cVar.recycle();
            this.a = false;
        }
    }
}
