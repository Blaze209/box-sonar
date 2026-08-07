package external.sdk.pendo.io.glide.request.target;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import external.sdk.pendo.io.glide.RequestManager;

/* JADX INFO: loaded from: classes4.dex */
public final class PreloadTarget<Z> extends CustomTarget<Z> {
    private static final Handler HANDLER = new Handler(Looper.getMainLooper(), new a());
    private static final int MESSAGE_CLEAR = 1;
    private final RequestManager requestManager;

    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((PreloadTarget) message.obj).clear();
            return true;
        }
    }

    private PreloadTarget(RequestManager requestManager, int i, int i2) {
        super(i, i2);
        this.requestManager = requestManager;
    }

    public static <Z> PreloadTarget<Z> obtain(RequestManager requestManager, int i, int i2) {
        return new PreloadTarget<>(requestManager, i, i2);
    }

    void clear() {
        this.requestManager.clear(this);
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public void onResourceReady(Z z, external.sdk.pendo.io.glide.request.transition.a<? super Z> aVar) {
        sdk.pendo.io.u.a request = getRequest();
        if (request == null || !request.isComplete()) {
            return;
        }
        HANDLER.obtainMessage(1, this).sendToTarget();
    }
}
