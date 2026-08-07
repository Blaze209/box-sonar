package androidx.media3.effect;

import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageWriter;
import android.system.ErrnoException;
import android.view.SurfaceHolder;
import androidx.media3.common.Format;
import androidx.media3.common.VideoFrameProcessingException;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes8.dex */
public final class SurfaceHolderHardwareBufferFrameQueue implements HardwareBufferFrameQueue, SurfaceHolder.Callback {
    private HardwareBufferFrameQueue.FrameFormat currentFormat;
    private ImageWriter imageWriter;
    private boolean isSurfaceChangeRequested;
    private final Listener listener;
    private final Executor listenerExecutor;
    private final Object lock = new Object();
    private final SurfaceHolder surfaceHolder;
    private final Executor surfaceHolderExecutor;
    private Runnable wakeupListener;

    public interface Listener {
        void onEnded();

        void onError(VideoFrameProcessingException videoFrameProcessingException);

        void onFrameAboutToBeRendered(long j, long j2, Format format);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public SurfaceHolderHardwareBufferFrameQueue(SurfaceHolder surfaceHolder, Executor executor, Listener listener, Executor executor2) {
        this.surfaceHolder = surfaceHolder;
        this.surfaceHolderExecutor = executor;
        this.listener = listener;
        this.listenerExecutor = executor2;
        surfaceHolder.addCallback(this);
    }

    @Override // androidx.media3.effect.HardwareBufferFrameQueue
    public HardwareBufferFrame dequeue(HardwareBufferFrameQueue.FrameFormat frameFormat, Runnable runnable) {
        ImageWriter imageWriter;
        synchronized (this.lock) {
            if (frameFormat.equals(this.currentFormat) && (imageWriter = this.imageWriter) != null) {
                try {
                    Image imageDequeueInputImage = imageWriter.dequeueInputImage();
                    return new HardwareBufferFrame.Builder((HardwareBuffer) Preconditions.checkNotNull(imageDequeueInputImage.getHardwareBuffer()), MoreExecutors.directExecutor(), new HardwareBufferFrame.ReleaseCallback() { // from class: androidx.media3.effect.SurfaceHolderHardwareBufferFrameQueue$$ExternalSyntheticLambda1
                        @Override // androidx.media3.effect.HardwareBufferFrame.ReleaseCallback
                        public final void release(SyncFenceCompat syncFenceCompat) {
                            SurfaceHolderHardwareBufferFrameQueue.lambda$dequeue$0(syncFenceCompat);
                        }
                    }).setInternalFrame(imageDequeueInputImage).build();
                } catch (IllegalStateException e) {
                    this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.SurfaceHolderHardwareBufferFrameQueue$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m10432x4f67e5e7(e);
                        }
                    });
                    return null;
                }
            }
            if (this.isSurfaceChangeRequested) {
                this.wakeupListener = runnable;
                return null;
            }
            this.isSurfaceChangeRequested = true;
            this.currentFormat = frameFormat;
            ImageWriter imageWriter2 = this.imageWriter;
            if (imageWriter2 != null) {
                imageWriter2.close();
                this.imageWriter = null;
            }
            this.wakeupListener = runnable;
            this.surfaceHolderExecutor.execute(new Runnable() { // from class: androidx.media3.effect.SurfaceHolderHardwareBufferFrameQueue$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m10433xe3a65586();
                }
            });
            return null;
        }
    }

    static /* synthetic */ void lambda$dequeue$0(SyncFenceCompat syncFenceCompat) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: lambda$dequeue$1$androidx-media3-effect-SurfaceHolderHardwareBufferFrameQueue, reason: not valid java name */
    /* synthetic */ void m10432x4f67e5e7(IllegalStateException illegalStateException) {
        this.listener.onError(new VideoFrameProcessingException(illegalStateException));
    }

    /* JADX INFO: renamed from: lambda$dequeue$2$androidx-media3-effect-SurfaceHolderHardwareBufferFrameQueue, reason: not valid java name */
    /* synthetic */ void m10433xe3a65586() {
        this.surfaceHolder.setFixedSize(1, 1);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0033 A[Catch: all -> 0x0058, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x000b, B:6:0x000f, B:8:0x0013, B:12:0x002f, B:14:0x0033, B:15:0x0038, B:18:0x0042, B:11:0x0025, B:19:0x004c), top: B:27:0x000b, inners: #0, #2 }] */
    @Override // androidx.media3.effect.HardwareBufferFrameQueue
    public void queue(final HardwareBufferFrame hardwareBufferFrame) {
        Image image = (Image) Preconditions.checkNotNull(hardwareBufferFrame.internalFrame);
        synchronized (this.lock) {
            ImageWriter imageWriter = this.imageWriter;
            if (imageWriter != null) {
                if (hardwareBufferFrame.acquireFence != null) {
                    try {
                        Preconditions.checkState(hardwareBufferFrame.acquireFence.await(500));
                        hardwareBufferFrame.acquireFence.close();
                    } catch (ErrnoException | IOException | IllegalStateException e) {
                        this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.SurfaceHolderHardwareBufferFrameQueue$$ExternalSyntheticLambda4
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.m10434x242c2464(e);
                            }
                        });
                    }
                    if (hardwareBufferFrame.hardwareBuffer != null) {
                        hardwareBufferFrame.hardwareBuffer.close();
                    }
                    try {
                        image.setTimestamp(hardwareBufferFrame.releaseTimeNs);
                        imageWriter.queueInputImage(image);
                    } catch (IllegalStateException e2) {
                        this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.SurfaceHolderHardwareBufferFrameQueue$$ExternalSyntheticLambda5
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.m10435xb86a9403(e2);
                            }
                        });
                    }
                } else {
                    if (hardwareBufferFrame.hardwareBuffer != null) {
                        hardwareBufferFrame.hardwareBuffer.close();
                    }
                    image.setTimestamp(hardwareBufferFrame.releaseTimeNs);
                    imageWriter.queueInputImage(image);
                }
                throw th;
            }
        }
        this.listenerExecutor.execute(new Runnable() { // from class: androidx.media3.effect.SurfaceHolderHardwareBufferFrameQueue$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m10436x4ca903a2(hardwareBufferFrame);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$queue$3$androidx-media3-effect-SurfaceHolderHardwareBufferFrameQueue, reason: not valid java name */
    /* synthetic */ void m10434x242c2464(Exception exc) {
        this.listener.onError(new VideoFrameProcessingException(exc));
    }

    /* JADX INFO: renamed from: lambda$queue$4$androidx-media3-effect-SurfaceHolderHardwareBufferFrameQueue, reason: not valid java name */
    /* synthetic */ void m10435xb86a9403(IllegalStateException illegalStateException) {
        this.listener.onError(new VideoFrameProcessingException(illegalStateException));
    }

    /* JADX INFO: renamed from: lambda$queue$5$androidx-media3-effect-SurfaceHolderHardwareBufferFrameQueue, reason: not valid java name */
    /* synthetic */ void m10436x4ca903a2(HardwareBufferFrame hardwareBufferFrame) {
        this.listener.onFrameAboutToBeRendered(hardwareBufferFrame.presentationTimeUs, hardwareBufferFrame.releaseTimeNs, hardwareBufferFrame.format);
    }

    @Override // androidx.media3.effect.HardwareBufferFrameQueue
    public void signalEndOfStream() {
        Executor executor = this.listenerExecutor;
        final Listener listener = this.listener;
        Objects.requireNonNull(listener);
        executor.execute(new Runnable() { // from class: androidx.media3.effect.SurfaceHolderHardwareBufferFrameQueue$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                listener.onEnded();
            }
        });
    }

    @Override // androidx.media3.effect.HardwareBufferFrameQueue
    public void release() {
        synchronized (this.lock) {
            ImageWriter imageWriter = this.imageWriter;
            if (imageWriter != null) {
                imageWriter.close();
                this.imageWriter = null;
            }
        }
        this.surfaceHolder.removeCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        synchronized (this.lock) {
            HardwareBufferFrameQueue.FrameFormat frameFormat = this.currentFormat;
            if (frameFormat != null && i2 == frameFormat.width && i3 == frameFormat.height && i == frameFormat.pixelFormat) {
                ImageWriter imageWriter = this.imageWriter;
                if (imageWriter != null) {
                    imageWriter.close();
                }
                this.imageWriter = new ImageWriter.Builder(surfaceHolder.getSurface()).setUsage(frameFormat.usageFlags).build();
                this.isSurfaceChangeRequested = false;
                Runnable runnable = this.wakeupListener;
                this.wakeupListener = null;
                if (runnable != null) {
                    runnable.run();
                }
                return;
            }
            if (frameFormat != null) {
                surfaceHolder.setFixedSize(frameFormat.width, frameFormat.height);
                surfaceHolder.setFormat(frameFormat.pixelFormat);
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        synchronized (this.lock) {
            ImageWriter imageWriter = this.imageWriter;
            if (imageWriter != null) {
                imageWriter.close();
                this.imageWriter = null;
            }
        }
    }
}
