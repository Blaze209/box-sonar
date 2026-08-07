package androidx.media3.effect;

import android.graphics.Bitmap;
import android.graphics.Gainmap;
import android.os.Build;
import androidx.media3.common.FrameInfo;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.TimestampIterator;
import com.google.common.base.Preconditions;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes8.dex */
final class BitmapTextureManager extends TextureManager {
    private boolean currentInputStreamEnded;
    private GlTextureInfo currentSdrGlTextureInfo;
    private int downstreamShaderProgramCapacity;
    private final GlObjectsProvider glObjectsProvider;
    private boolean isNextFrameInTexture;
    private final Queue<BitmapFrameSequenceInfo> pendingBitmaps;
    private RepeatingGainmapShaderProgram repeatingGainmapShaderProgram;
    private final boolean signalRepeatingSequence;

    @Override // androidx.media3.effect.TextureManager
    public int getPendingFrameCount() {
        return 0;
    }

    public BitmapTextureManager(GlObjectsProvider glObjectsProvider, VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor, boolean z) {
        super(videoFrameProcessingTaskExecutor);
        this.glObjectsProvider = glObjectsProvider;
        this.pendingBitmaps = new LinkedBlockingQueue();
        this.signalRepeatingSequence = z;
    }

    @Override // androidx.media3.effect.TextureManager
    public void setSamplingGlShaderProgram(GlShaderProgram glShaderProgram) {
        Preconditions.checkState(glShaderProgram instanceof RepeatingGainmapShaderProgram);
        this.downstreamShaderProgramCapacity = 0;
        this.repeatingGainmapShaderProgram = (RepeatingGainmapShaderProgram) glShaderProgram;
    }

    @Override // androidx.media3.effect.GlShaderProgram.InputListener
    public void onReadyToAcceptInputFrame() {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.BitmapTextureManager$$ExternalSyntheticLambda0
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f$0.m10356x5ebd0098();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onReadyToAcceptInputFrame$0$androidx-media3-effect-BitmapTextureManager, reason: not valid java name */
    /* synthetic */ void m10356x5ebd0098() throws VideoFrameProcessingException, GlUtil.GlException {
        this.downstreamShaderProgramCapacity++;
        maybeQueueToShaderProgram();
    }

    @Override // androidx.media3.effect.TextureManager
    public void queueInputBitmap(final Bitmap bitmap, final FrameInfo frameInfo, final TimestampIterator timestampIterator) {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.BitmapTextureManager$$ExternalSyntheticLambda3
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f$0.m10357xfa552d11(bitmap, frameInfo, timestampIterator);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$queueInputBitmap$1$androidx-media3-effect-BitmapTextureManager, reason: not valid java name */
    /* synthetic */ void m10357xfa552d11(Bitmap bitmap, FrameInfo frameInfo, TimestampIterator timestampIterator) throws VideoFrameProcessingException, GlUtil.GlException {
        setupBitmap(bitmap, frameInfo, timestampIterator);
        this.currentInputStreamEnded = false;
    }

    @Override // androidx.media3.effect.TextureManager
    public void signalEndOfCurrentInputStream() {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.BitmapTextureManager$$ExternalSyntheticLambda1
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f$0.m10359x7939514b();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$signalEndOfCurrentInputStream$2$androidx-media3-effect-BitmapTextureManager, reason: not valid java name */
    /* synthetic */ void m10359x7939514b() throws VideoFrameProcessingException, GlUtil.GlException {
        if (this.pendingBitmaps.isEmpty()) {
            ((RepeatingGainmapShaderProgram) Preconditions.checkNotNull(this.repeatingGainmapShaderProgram)).signalEndOfCurrentInputStream();
            DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_BITMAP_TEXTURE_MANAGER, DebugTraceUtil.EVENT_SIGNAL_EOS, Long.MIN_VALUE);
        } else {
            this.currentInputStreamEnded = true;
        }
    }

    @Override // androidx.media3.effect.TextureManager
    public void release() {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.BitmapTextureManager$$ExternalSyntheticLambda2
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f$0.m10358lambda$release$3$androidxmedia3effectBitmapTextureManager();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$release$3$androidx-media3-effect-BitmapTextureManager, reason: not valid java name */
    /* synthetic */ void m10358lambda$release$3$androidxmedia3effectBitmapTextureManager() throws VideoFrameProcessingException, GlUtil.GlException {
        GlTextureInfo glTextureInfo = this.currentSdrGlTextureInfo;
        if (glTextureInfo != null) {
            glTextureInfo.release();
        }
        this.pendingBitmaps.clear();
    }

    private void setupBitmap(Bitmap bitmap, FrameInfo frameInfo, TimestampIterator timestampIterator) throws VideoFrameProcessingException {
        Preconditions.checkArgument(timestampIterator.hasNext(), "Bitmap queued but no timestamps provided.");
        this.pendingBitmaps.add(new BitmapFrameSequenceInfo(bitmap, frameInfo, timestampIterator));
        maybeQueueToShaderProgram();
    }

    private void maybeQueueToShaderProgram() throws VideoFrameProcessingException {
        if (this.pendingBitmaps.isEmpty() || this.downstreamShaderProgramCapacity == 0) {
            return;
        }
        BitmapFrameSequenceInfo bitmapFrameSequenceInfoElement = this.pendingBitmaps.element();
        FrameInfo frameInfo = bitmapFrameSequenceInfoElement.frameInfo;
        TimestampIterator timestampIterator = bitmapFrameSequenceInfoElement.inStreamOffsetsUs;
        Preconditions.checkState(bitmapFrameSequenceInfoElement.inStreamOffsetsUs.hasNext());
        long next = bitmapFrameSequenceInfoElement.frameInfo.offsetToAddUs + timestampIterator.next();
        if (!this.isNextFrameInTexture) {
            this.isNextFrameInTexture = true;
            updateCurrentGlTextureInfo(frameInfo, bitmapFrameSequenceInfoElement.bitmap);
        }
        this.downstreamShaderProgramCapacity--;
        ((RepeatingGainmapShaderProgram) Preconditions.checkNotNull(this.repeatingGainmapShaderProgram)).queueInputFrame(this.glObjectsProvider, (GlTextureInfo) Preconditions.checkNotNull(this.currentSdrGlTextureInfo), next);
        DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_VFP, DebugTraceUtil.EVENT_QUEUE_BITMAP, next, "%dx%d", Integer.valueOf(frameInfo.format.width), Integer.valueOf(frameInfo.format.height));
        if (bitmapFrameSequenceInfoElement.inStreamOffsetsUs.hasNext()) {
            return;
        }
        this.isNextFrameInTexture = false;
        this.pendingBitmaps.remove().bitmap.recycle();
        if (this.pendingBitmaps.isEmpty() && this.currentInputStreamEnded) {
            ((RepeatingGainmapShaderProgram) Preconditions.checkNotNull(this.repeatingGainmapShaderProgram)).signalEndOfCurrentInputStream();
            DebugTraceUtil.logEvent(DebugTraceUtil.COMPONENT_BITMAP_TEXTURE_MANAGER, DebugTraceUtil.EVENT_SIGNAL_EOS, Long.MIN_VALUE);
            this.currentInputStreamEnded = false;
        }
    }

    @Override // androidx.media3.effect.TextureManager
    protected void flush() throws VideoFrameProcessingException {
        this.pendingBitmaps.clear();
        this.isNextFrameInTexture = false;
        this.currentInputStreamEnded = false;
        this.downstreamShaderProgramCapacity = 0;
        GlTextureInfo glTextureInfo = this.currentSdrGlTextureInfo;
        if (glTextureInfo != null) {
            try {
                glTextureInfo.release();
                this.currentSdrGlTextureInfo = null;
            } catch (GlUtil.GlException e) {
                throw VideoFrameProcessingException.from(e);
            }
        }
        super.flush();
    }

    private void updateCurrentGlTextureInfo(FrameInfo frameInfo, Bitmap bitmap) throws VideoFrameProcessingException {
        try {
            GlTextureInfo glTextureInfo = this.currentSdrGlTextureInfo;
            if (glTextureInfo != null) {
                glTextureInfo.release();
            }
            this.currentSdrGlTextureInfo = new GlTextureInfo(GlUtil.createTexture(bitmap), -1, -1, frameInfo.format.width, frameInfo.format.height);
            if (Build.VERSION.SDK_INT >= 34 && bitmap.hasGainmap()) {
                ((RepeatingGainmapShaderProgram) Preconditions.checkNotNull(this.repeatingGainmapShaderProgram)).setGainmap((Gainmap) Preconditions.checkNotNull(bitmap.getGainmap()));
            }
            if (this.signalRepeatingSequence) {
                ((RepeatingGainmapShaderProgram) Preconditions.checkNotNull(this.repeatingGainmapShaderProgram)).signalNewRepeatingFrameSequence();
            }
        } catch (GlUtil.GlException e) {
            throw VideoFrameProcessingException.from(e);
        }
    }

    private static final class BitmapFrameSequenceInfo {
        public final Bitmap bitmap;
        private final FrameInfo frameInfo;
        private final TimestampIterator inStreamOffsetsUs;

        public BitmapFrameSequenceInfo(Bitmap bitmap, FrameInfo frameInfo, TimestampIterator timestampIterator) {
            this.bitmap = bitmap;
            this.frameInfo = frameInfo;
            this.inStreamOffsetsUs = timestampIterator;
        }
    }
}
