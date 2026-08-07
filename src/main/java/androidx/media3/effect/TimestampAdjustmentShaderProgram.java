package androidx.media3.effect;

import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.TimestampConsumer;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public class TimestampAdjustmentShaderProgram implements GlShaderProgram {
    private GlTextureInfo inputTexture;
    private final TimestampAdjustment.TimestampMap timestampMap;
    private GlShaderProgram.InputListener inputListener = new GlShaderProgram.InputListener() { // from class: androidx.media3.effect.TimestampAdjustmentShaderProgram.1
    };
    private GlShaderProgram.OutputListener outputListener = new GlShaderProgram.OutputListener() { // from class: androidx.media3.effect.TimestampAdjustmentShaderProgram.2
    };
    private final AtomicInteger pendingCallbacksCount = new AtomicInteger();
    private final AtomicBoolean pendingEndOfStream = new AtomicBoolean();

    @Override // androidx.media3.effect.GlShaderProgram
    public void setErrorListener(Executor executor, GlShaderProgram.ErrorListener errorListener) {
    }

    public TimestampAdjustmentShaderProgram(TimestampAdjustment.TimestampMap timestampMap) {
        this.timestampMap = timestampMap;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void setInputListener(GlShaderProgram.InputListener inputListener) {
        this.inputListener = inputListener;
        if (this.inputTexture == null) {
            inputListener.onReadyToAcceptInputFrame();
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void setOutputListener(GlShaderProgram.OutputListener outputListener) {
        this.outputListener = outputListener;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j) {
        this.inputTexture = glTextureInfo;
        this.timestampMap.calculateOutputTimeUs(j, new TimestampConsumer() { // from class: androidx.media3.effect.TimestampAdjustmentShaderProgram$$ExternalSyntheticLambda0
            @Override // androidx.media3.common.util.TimestampConsumer
            public final void onTimestamp(long j2) {
                this.f$0.onOutputTimeAvailable(j2);
            }
        });
        this.pendingCallbacksCount.incrementAndGet();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void signalEndOfCurrentInputStream() {
        if (this.pendingCallbacksCount.get() == 0) {
            this.outputListener.onCurrentOutputStreamEnded();
        } else {
            this.pendingEndOfStream.set(true);
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void releaseOutputFrame(GlTextureInfo glTextureInfo) {
        Preconditions.checkState(glTextureInfo.texId == ((GlTextureInfo) Preconditions.checkNotNull(this.inputTexture)).texId);
        this.inputListener.onInputFrameProcessed(glTextureInfo);
        this.inputListener.onReadyToAcceptInputFrame();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void flush() {
        throw new UnsupportedOperationException("This effect is not supported for previewing.");
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        this.inputTexture = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onOutputTimeAvailable(long j) {
        this.outputListener.onOutputFrameAvailable((GlTextureInfo) Preconditions.checkNotNull(this.inputTexture), j);
        if (this.pendingEndOfStream.get()) {
            this.outputListener.onCurrentOutputStreamEnded();
            this.pendingEndOfStream.set(false);
        }
        this.pendingCallbacksCount.decrementAndGet();
    }
}
