package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes8.dex */
final class ReplayableFrameCacheGlShaderProgram extends FrameCacheGlShaderProgram {
    private static final int CAPACITY = 2;
    private static final int REGULAR_FRAME_INDEX = 1;
    private static final int REPLAY_FRAME_INDEX = 0;
    private int cacheSize;
    private final TimedGlTextureInfo[] cachedFrames;

    @Override // androidx.media3.effect.BaseGlShaderProgram, androidx.media3.effect.GlShaderProgram
    public void releaseOutputFrame(GlTextureInfo glTextureInfo) {
    }

    public ReplayableFrameCacheGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
        super(context, 2, z);
        this.cachedFrames = new TimedGlTextureInfo[2];
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram, androidx.media3.effect.GlShaderProgram
    public void queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, long j) {
        Preconditions.checkState(this.cacheSize < 2);
        super.queueInputFrame(glObjectsProvider, glTextureInfo, j);
        TimedGlTextureInfo[] timedGlTextureInfoArr = this.cachedFrames;
        int i = this.cacheSize;
        this.cacheSize = i + 1;
        timedGlTextureInfoArr[i] = new TimedGlTextureInfo((GlTextureInfo) Preconditions.checkNotNull(this.outputTexturePool.getMostRecentlyUsedTexture()), j);
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram, androidx.media3.effect.GlShaderProgram
    public void flush() {
        this.cacheSize = 0;
        super.flush();
    }

    public void onNewInputStream() {
        for (int i = 0; i < this.cacheSize; i++) {
            super.releaseOutputFrame(this.cachedFrames[i].glTextureInfo);
        }
        this.cacheSize = 0;
    }

    public boolean isEmpty() {
        return this.cacheSize == 0;
    }

    public long getReplayFramePresentationTimeUs() {
        if (isEmpty()) {
            return -9223372036854775807L;
        }
        return this.cachedFrames[0].presentationTimeUs;
    }

    public void replayFrame() {
        if (isEmpty()) {
            return;
        }
        TimedGlTextureInfo timedGlTextureInfo = this.cachedFrames[0];
        getOutputListener().onOutputFrameAvailable(timedGlTextureInfo.glTextureInfo, timedGlTextureInfo.presentationTimeUs);
        if (this.cacheSize > 1) {
            TimedGlTextureInfo timedGlTextureInfo2 = this.cachedFrames[1];
            getOutputListener().onOutputFrameAvailable(timedGlTextureInfo2.glTextureInfo, timedGlTextureInfo2.presentationTimeUs);
        }
    }

    public void onFrameRendered(long j) {
        if (this.cacheSize < 2 || j < this.cachedFrames[1].presentationTimeUs) {
            return;
        }
        TimedGlTextureInfo[] timedGlTextureInfoArr = this.cachedFrames;
        TimedGlTextureInfo timedGlTextureInfo = timedGlTextureInfoArr[0];
        timedGlTextureInfoArr[0] = timedGlTextureInfoArr[1];
        this.cacheSize--;
        super.releaseOutputFrame(timedGlTextureInfo.glTextureInfo);
    }
}
