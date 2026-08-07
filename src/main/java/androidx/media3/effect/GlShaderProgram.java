package androidx.media3.effect;

import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes8.dex */
public interface GlShaderProgram {

    public interface ErrorListener {
        void onError(VideoFrameProcessingException videoFrameProcessingException);
    }

    public interface InputListener {
        default void onFlush() {
        }

        default void onInputFrameProcessed(GlTextureInfo glTextureInfo) {
        }

        default void onReadyToAcceptInputFrame() {
        }
    }

    public interface OutputListener {
        default void onCurrentOutputStreamEnded() {
        }

        default void onOutputFrameAvailable(GlTextureInfo glTextureInfo, long j) {
        }
    }

    void flush();

    void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j);

    void release() throws VideoFrameProcessingException;

    void releaseOutputFrame(GlTextureInfo glTextureInfo);

    void setErrorListener(Executor executor, ErrorListener errorListener);

    void setInputListener(InputListener inputListener);

    void setOutputListener(OutputListener outputListener);

    void signalEndOfCurrentInputStream();
}
