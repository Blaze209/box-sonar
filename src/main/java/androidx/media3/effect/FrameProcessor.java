package androidx.media3.effect;

import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Consumer;
import androidx.media3.effect.Frame;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes8.dex */
interface FrameProcessor<I extends Frame, O extends Frame> {
    void clearOnErrorCallback();

    FrameConsumer<I> getInput();

    ListenableFuture<Void> releaseAsync();

    void setOnErrorCallback(Executor executor, Consumer<VideoFrameProcessingException> consumer);

    ListenableFuture<Void> setOutputAsync(FrameConsumer<O> frameConsumer);
}
