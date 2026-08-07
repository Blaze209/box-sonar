package androidx.media3.effect;

import android.content.Context;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.util.SparseArray;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.OverlaySettings;
import androidx.media3.common.VideoCompositorSettings;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.LongArrayQueue;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.Util;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes8.dex */
public final class DefaultVideoCompositor implements VideoCompositor {
    private static final String TAG = "DefaultVideoCompositor";
    private boolean allInputsEnded;
    private final DefaultCompositorGlProgram compositorGlProgram;
    private ColorInfo configuredColorInfo;
    private EGLDisplay eglDisplay;
    private final GlObjectsProvider glObjectsProvider;
    private final VideoCompositor.Listener listener;
    private final TexturePool outputTexturePool;
    private final LongArrayQueue outputTextureTimestamps;
    private EGLSurface placeholderEglSurface;
    private final LongArrayQueue syncObjects;
    private final GlTextureProducer.Listener textureOutputListener;
    private final VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor;
    private int primaryInputIndex = -1;
    private final SparseArray<InputSource> inputSources = new SparseArray<>();
    private VideoCompositorSettings videoCompositorSettings = VideoCompositorSettings.DEFAULT;

    public DefaultVideoCompositor(Context context, GlObjectsProvider glObjectsProvider, ExecutorService executorService, final VideoCompositor.Listener listener, GlTextureProducer.Listener listener2, int i) {
        this.listener = listener;
        this.textureOutputListener = listener2;
        this.glObjectsProvider = glObjectsProvider;
        this.compositorGlProgram = new DefaultCompositorGlProgram(context);
        this.outputTexturePool = new TexturePool(false, i);
        this.outputTextureTimestamps = new LongArrayQueue(i);
        this.syncObjects = new LongArrayQueue(i);
        Objects.requireNonNull(listener);
        VideoFrameProcessingTaskExecutor videoFrameProcessingTaskExecutor = new VideoFrameProcessingTaskExecutor(executorService, false, new VideoFrameProcessingTaskExecutor.ErrorListener() { // from class: androidx.media3.effect.DefaultVideoCompositor$$ExternalSyntheticLambda4
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.ErrorListener
            public final void onError(VideoFrameProcessingException videoFrameProcessingException) {
                listener.onError(videoFrameProcessingException);
            }
        });
        this.videoFrameProcessingTaskExecutor = videoFrameProcessingTaskExecutor;
        videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.DefaultVideoCompositor$$ExternalSyntheticLambda5
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws GlUtil.GlException {
                this.f$0.setupGlObjects();
            }
        });
    }

    @Override // androidx.media3.effect.VideoCompositor
    public synchronized void registerInputSource(int i) {
        Preconditions.checkState(!Util.contains(this.inputSources, i));
        this.inputSources.put(i, new InputSource());
        if (this.primaryInputIndex == -1) {
            this.primaryInputIndex = i;
        }
    }

    @Override // androidx.media3.effect.VideoCompositor
    public void setVideoCompositorSettings(VideoCompositorSettings videoCompositorSettings) {
        this.videoCompositorSettings = videoCompositorSettings;
    }

    @Override // androidx.media3.effect.VideoCompositor
    public synchronized void signalEndOfInputSource(int i) {
        Preconditions.checkState(Util.contains(this.inputSources, i));
        boolean z = false;
        Preconditions.checkState(this.primaryInputIndex != -1);
        this.inputSources.get(i).isInputEnded = true;
        int i2 = 0;
        while (true) {
            if (i2 >= this.inputSources.size()) {
                z = true;
                break;
            } else if (!this.inputSources.valueAt(i2).isInputEnded) {
                break;
            } else {
                i2++;
            }
        }
        this.allInputsEnded = z;
        if (this.inputSources.get(this.primaryInputIndex).frameInfos.isEmpty()) {
            if (i == this.primaryInputIndex) {
                releaseExcessFramesInAllSecondaryStreams();
            }
            if (z) {
                this.listener.onEnded();
                return;
            }
        }
        if (i != this.primaryInputIndex && this.inputSources.get(i).frameInfos.size() == 1) {
            this.videoFrameProcessingTaskExecutor.submit(new DefaultVideoCompositor$$ExternalSyntheticLambda2(this));
        }
    }

    @Override // androidx.media3.effect.VideoCompositor
    public synchronized void queueInputTexture(int i, GlTextureProducer glTextureProducer, GlTextureInfo glTextureInfo, ColorInfo colorInfo, long j) {
        Preconditions.checkState(Util.contains(this.inputSources, i));
        InputSource inputSource = this.inputSources.get(i);
        Preconditions.checkState(!inputSource.isInputEnded);
        Preconditions.checkState(!ColorInfo.isTransferHdr(colorInfo), "HDR input is not supported.");
        if (this.configuredColorInfo == null) {
            this.configuredColorInfo = colorInfo;
        }
        Preconditions.checkState(this.configuredColorInfo.equals(colorInfo), "Mixing different ColorInfos is not supported.");
        inputSource.frameInfos.add(new FrameInfo(glTextureProducer, new TimedGlTextureInfo(glTextureInfo, j), this.videoCompositorSettings.getOverlaySettings(i, j)));
        if (i == this.primaryInputIndex) {
            releaseExcessFramesInAllSecondaryStreams();
        } else {
            releaseExcessFramesInSecondaryStream(inputSource);
        }
        this.videoFrameProcessingTaskExecutor.submit(new DefaultVideoCompositor$$ExternalSyntheticLambda2(this));
    }

    @Override // androidx.media3.effect.VideoCompositor
    public synchronized void release() {
        try {
            this.videoFrameProcessingTaskExecutor.release(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.DefaultVideoCompositor$$ExternalSyntheticLambda1
                @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
                public final void run() {
                    this.f$0.releaseGlObjects();
                }
            });
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException(e);
        }
    }

    @Override // androidx.media3.effect.GlTextureProducer
    public void releaseOutputTexture(final long j) {
        this.videoFrameProcessingTaskExecutor.submit(new VideoFrameProcessingTaskExecutor.Task() { // from class: androidx.media3.effect.DefaultVideoCompositor$$ExternalSyntheticLambda0
            @Override // androidx.media3.effect.VideoFrameProcessingTaskExecutor.Task
            public final void run() throws VideoFrameProcessingException, GlUtil.GlException {
                this.f$0.m10367xf71d0bd5(j);
            }
        });
    }

    private synchronized void releaseExcessFramesInAllSecondaryStreams() {
        for (int i = 0; i < this.inputSources.size(); i++) {
            if (this.inputSources.keyAt(i) != this.primaryInputIndex) {
                releaseExcessFramesInSecondaryStream(this.inputSources.valueAt(i));
            }
        }
    }

    private synchronized void releaseExcessFramesInSecondaryStream(InputSource inputSource) {
        InputSource inputSource2 = this.inputSources.get(this.primaryInputIndex);
        if (inputSource2.frameInfos.isEmpty() && inputSource2.isInputEnded) {
            releaseFrames(inputSource, inputSource.frameInfos.size());
            return;
        }
        FrameInfo frameInfo = (FrameInfo) inputSource2.frameInfos.peek();
        final long j = frameInfo != null ? frameInfo.timedGlTextureInfo.presentationTimeUs : -9223372036854775807L;
        releaseFrames(inputSource, Math.max(Iterables.size(Iterables.filter(inputSource.frameInfos, new Predicate() { // from class: androidx.media3.effect.DefaultVideoCompositor$$ExternalSyntheticLambda3
            @Override // com.google.common.base.Predicate
            public final boolean apply(Object obj) {
                return DefaultVideoCompositor.lambda$releaseExcessFramesInSecondaryStream$1(j, (DefaultVideoCompositor.FrameInfo) obj);
            }
        })) - 1, 0));
    }

    static /* synthetic */ boolean lambda$releaseExcessFramesInSecondaryStream$1(long j, FrameInfo frameInfo) {
        return frameInfo.timedGlTextureInfo.presentationTimeUs <= j;
    }

    private synchronized void releaseFrames(InputSource inputSource, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            FrameInfo frameInfo = (FrameInfo) inputSource.frameInfos.remove();
            ((GlTextureProducer) Preconditions.checkNotNull(frameInfo.textureProducer)).releaseOutputTexture(frameInfo.timedGlTextureInfo.presentationTimeUs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupGlObjects() throws GlUtil.GlException {
        EGLDisplay defaultEglDisplay = GlUtil.getDefaultEglDisplay();
        this.eglDisplay = defaultEglDisplay;
        this.placeholderEglSurface = this.glObjectsProvider.createFocusedPlaceholderEglSurface(this.glObjectsProvider.createEglContext(defaultEglDisplay, 2, GlUtil.EGL_CONFIG_ATTRIBUTES_RGBA_8888), this.eglDisplay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void maybeComposite() throws Throwable {
        try {
            try {
                ImmutableList<FrameInfo> framesToComposite = getFramesToComposite();
                if (framesToComposite.isEmpty()) {
                    return;
                }
                FrameInfo frameInfo = framesToComposite.get(this.primaryInputIndex);
                ImmutableList.Builder builder = new ImmutableList.Builder();
                for (int i = 0; i < framesToComposite.size(); i++) {
                    GlTextureInfo glTextureInfo = framesToComposite.get(i).timedGlTextureInfo.glTextureInfo;
                    builder.add(new Size(glTextureInfo.width, glTextureInfo.height));
                }
                Size outputSize = this.videoCompositorSettings.getOutputSize(builder.build());
                this.outputTexturePool.ensureConfigured(this.glObjectsProvider, outputSize.getWidth(), outputSize.getHeight());
                GlTextureInfo glTextureInfoUseTexture = this.outputTexturePool.useTexture();
                long j = frameInfo.timedGlTextureInfo.presentationTimeUs;
                this.outputTextureTimestamps.add(j);
                ImmutableList.Builder builder2 = new ImmutableList.Builder();
                for (int i2 = 0; i2 < framesToComposite.size(); i2++) {
                    builder2.add(new DefaultCompositorGlProgram.InputFrameInfo(framesToComposite.get(i2).timedGlTextureInfo.glTextureInfo, framesToComposite.get(i2).overlaySettings));
                }
                this.compositorGlProgram.drawFrame(builder2.build(), glTextureInfoUseTexture);
                long jCreateGlSyncFence = GlUtil.createGlSyncFence();
                this.syncObjects.add(jCreateGlSyncFence);
                this.textureOutputListener.onTextureRendered(this, glTextureInfoUseTexture, j, jCreateGlSyncFence);
                InputSource inputSource = this.inputSources.get(this.primaryInputIndex);
                releaseFrames(inputSource, 1);
                releaseExcessFramesInAllSecondaryStreams();
                if (this.allInputsEnded && inputSource.frameInfos.isEmpty()) {
                    this.listener.onEnded();
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private synchronized ImmutableList<FrameInfo> getFramesToComposite() {
        if (this.outputTexturePool.freeTextureCount() == 0) {
            return ImmutableList.of();
        }
        for (int i = 0; i < this.inputSources.size(); i++) {
            if (this.inputSources.valueAt(i).frameInfos.isEmpty()) {
                return ImmutableList.of();
            }
        }
        ImmutableList.Builder builder = new ImmutableList.Builder();
        FrameInfo frameInfo = (FrameInfo) this.inputSources.get(this.primaryInputIndex).frameInfos.element();
        builder.add(frameInfo);
        for (int i2 = 0; i2 < this.inputSources.size(); i2++) {
            if (this.inputSources.keyAt(i2) != this.primaryInputIndex) {
                InputSource inputSourceValueAt = this.inputSources.valueAt(i2);
                if (inputSourceValueAt.frameInfos.size() == 1 && !inputSourceValueAt.isInputEnded) {
                    return ImmutableList.of();
                }
                Iterator it = inputSourceValueAt.frameInfos.iterator();
                long j = Long.MAX_VALUE;
                FrameInfo frameInfo2 = null;
                while (it.hasNext()) {
                    FrameInfo frameInfo3 = (FrameInfo) it.next();
                    long j2 = frameInfo3.timedGlTextureInfo.presentationTimeUs;
                    long jAbs = Math.abs(j2 - frameInfo.timedGlTextureInfo.presentationTimeUs);
                    if (jAbs < j) {
                        frameInfo2 = frameInfo3;
                        j = jAbs;
                    }
                    if (j2 > frameInfo.timedGlTextureInfo.presentationTimeUs || (!it.hasNext() && inputSourceValueAt.isInputEnded)) {
                        builder.add((FrameInfo) Preconditions.checkNotNull(frameInfo2));
                        break;
                    }
                }
            }
        }
        ImmutableList<FrameInfo> immutableListBuild = builder.build();
        if (immutableListBuild.size() == this.inputSources.size()) {
            return immutableListBuild;
        }
        return ImmutableList.of();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: releaseOutputTextureInternal, reason: merged with bridge method [inline-methods] */
    public synchronized void m10367xf71d0bd5(long j) throws VideoFrameProcessingException, GlUtil.GlException {
        while (this.outputTexturePool.freeTextureCount() < this.outputTexturePool.capacity() && this.outputTextureTimestamps.element() <= j) {
            this.outputTexturePool.freeTexture();
            this.outputTextureTimestamps.remove();
            GlUtil.deleteSyncObject(this.syncObjects.remove());
        }
        maybeComposite();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseGlObjects() {
        try {
            this.compositorGlProgram.release();
            this.outputTexturePool.deleteAllTextures();
            GlUtil.destroyEglSurface(this.eglDisplay, this.placeholderEglSurface);
        } catch (GlUtil.GlException e) {
            Log.e(TAG, "Error releasing GL resources", e);
        }
    }

    private static final class InputSource {
        private final Queue<FrameInfo> frameInfos = new ArrayDeque();
        public boolean isInputEnded;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class FrameInfo {
        public final OverlaySettings overlaySettings;
        public final GlTextureProducer textureProducer;
        public final TimedGlTextureInfo timedGlTextureInfo;

        private FrameInfo(GlTextureProducer glTextureProducer, TimedGlTextureInfo timedGlTextureInfo, OverlaySettings overlaySettings) {
            this.textureProducer = glTextureProducer;
            this.timedGlTextureInfo = timedGlTextureInfo;
            this.overlaySettings = overlaySettings;
        }
    }
}
