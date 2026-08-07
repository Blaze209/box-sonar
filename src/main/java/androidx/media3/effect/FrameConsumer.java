package androidx.media3.effect;

import androidx.media3.effect.Frame;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes8.dex */
public interface FrameConsumer<I extends Frame> {
    void clearOnCapacityAvailableCallback();

    boolean queueFrame(I i);

    void setOnCapacityAvailableCallback(Executor executor, Runnable runnable);
}
