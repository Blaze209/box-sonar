package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes8.dex */
final class TimestampWrapperShaderProgram implements GlShaderProgram, GlShaderProgram.InputListener {
    private final GlShaderProgram copyShaderProgram;
    private final long endTimeUs;
    private int pendingCopyGlShaderProgramFrames;
    private int pendingWrappedGlShaderProgramFrames;
    private final long startTimeUs;
    private final GlShaderProgram wrappedShaderProgram;
    private final WrappedShaderProgramInputListener wrappedShaderProgramInputListener;

    public TimestampWrapperShaderProgram(Context context, boolean z, TimestampWrapper timestampWrapper) throws VideoFrameProcessingException {
        this.startTimeUs = timestampWrapper.startTimeUs;
        this.endTimeUs = timestampWrapper.endTimeUs;
        GlShaderProgram glShaderProgram = timestampWrapper.glEffect.toGlShaderProgram(context, z);
        this.wrappedShaderProgram = glShaderProgram;
        WrappedShaderProgramInputListener wrappedShaderProgramInputListener = new WrappedShaderProgramInputListener();
        this.wrappedShaderProgramInputListener = wrappedShaderProgramInputListener;
        glShaderProgram.setInputListener(wrappedShaderProgramInputListener);
        this.copyShaderProgram = new FrameCache(wrappedShaderProgramInputListener.readyFrameCount).toGlShaderProgram(context, z);
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void setInputListener(GlShaderProgram.InputListener inputListener) {
        this.wrappedShaderProgramInputListener.setListener(inputListener);
        this.wrappedShaderProgramInputListener.setToForwardingMode(true);
        this.copyShaderProgram.setInputListener(inputListener);
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void setOutputListener(GlShaderProgram.OutputListener outputListener) {
        this.wrappedShaderProgram.setOutputListener(outputListener);
        this.copyShaderProgram.setOutputListener(outputListener);
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void setErrorListener(Executor executor, GlShaderProgram.ErrorListener errorListener) {
        this.wrappedShaderProgram.setErrorListener(executor, errorListener);
        this.copyShaderProgram.setErrorListener(executor, errorListener);
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j) {
        if (this.startTimeUs <= j && j <= this.endTimeUs) {
            this.pendingWrappedGlShaderProgramFrames++;
            this.wrappedShaderProgram.queueInputFrame(glObjectsProvider, glTextureInfo, j);
        } else {
            this.pendingCopyGlShaderProgramFrames++;
            this.copyShaderProgram.queueInputFrame(glObjectsProvider, glTextureInfo, j);
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void releaseOutputFrame(GlTextureInfo glTextureInfo) {
        if (this.pendingCopyGlShaderProgramFrames > 0) {
            this.copyShaderProgram.releaseOutputFrame(glTextureInfo);
            this.pendingCopyGlShaderProgramFrames--;
        } else {
            if (this.pendingWrappedGlShaderProgramFrames > 0) {
                this.wrappedShaderProgram.releaseOutputFrame(glTextureInfo);
                this.pendingWrappedGlShaderProgramFrames--;
                return;
            }
            throw new IllegalArgumentException("Output texture not contained in either shader.");
        }
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void signalEndOfCurrentInputStream() {
        this.wrappedShaderProgram.signalEndOfCurrentInputStream();
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void flush() {
        this.wrappedShaderProgramInputListener.setToForwardingMode(false);
        this.wrappedShaderProgram.flush();
        this.wrappedShaderProgramInputListener.setToForwardingMode(true);
        this.copyShaderProgram.flush();
        this.pendingCopyGlShaderProgramFrames = 0;
        this.pendingWrappedGlShaderProgramFrames = 0;
    }

    @Override // androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        this.copyShaderProgram.release();
        this.wrappedShaderProgram.release();
    }

    private static final class WrappedShaderProgramInputListener implements GlShaderProgram.InputListener {
        private boolean forwardCalls;
        private GlShaderProgram.InputListener listener;
        public int readyFrameCount;

        @Override // androidx.media3.effect.GlShaderProgram.InputListener
        public void onFlush() {
        }

        private WrappedShaderProgramInputListener() {
        }

        @Override // androidx.media3.effect.GlShaderProgram.InputListener
        public void onReadyToAcceptInputFrame() {
            GlShaderProgram.InputListener inputListener = this.listener;
            if (inputListener == null) {
                this.readyFrameCount++;
            }
            if (this.forwardCalls) {
                ((GlShaderProgram.InputListener) Preconditions.checkNotNull(inputListener)).onReadyToAcceptInputFrame();
            }
        }

        @Override // androidx.media3.effect.GlShaderProgram.InputListener
        public void onInputFrameProcessed(GlTextureInfo glTextureInfo) {
            ((GlShaderProgram.InputListener) Preconditions.checkNotNull(this.listener)).onInputFrameProcessed(glTextureInfo);
        }

        public void setListener(GlShaderProgram.InputListener inputListener) {
            this.listener = inputListener;
        }

        public void setToForwardingMode(boolean z) {
            Preconditions.checkState((z && this.listener == null) ? false : true);
            this.forwardCalls = z;
        }
    }
}
