package androidx.media3.effect;

import android.hardware.HardwareBuffer;
import android.os.Build;
import androidx.media3.common.Format;
import androidx.media3.common.SurfaceInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Consumer;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
public class PacketConsumerHardwareBufferFrameQueue implements HardwareBufferFrameQueue {
    private static final int CAPACITY = 5;
    private int allocatedBufferCount;
    private boolean isReleased;
    private boolean isRenderSurfaceInfoSet;
    private final Listener listener;
    private final PacketConsumerCaller<HardwareBufferFrame> output;
    private final RenderingPacketConsumer<HardwareBufferFrame, SurfaceInfo> packetRenderer;
    private final Executor releaseFrameExecutor;
    private Runnable wakeupListener;
    private final Object lock = new Object();
    private final Queue<HardwareBufferFrame> pool = new ArrayDeque(5);

    public interface Listener {
        SurfaceInfo getRendererSurfaceInfo(Format format) throws VideoFrameProcessingException;

        void onEndOfStream();

        void onError(VideoFrameProcessingException videoFrameProcessingException);
    }

    private long adjustUsageFlags(long j) {
        return j | 256;
    }

    public PacketConsumerHardwareBufferFrameQueue(Executor executor, RenderingPacketConsumer<HardwareBufferFrame, SurfaceInfo> renderingPacketConsumer, final Listener listener) {
        this.releaseFrameExecutor = executor;
        this.packetRenderer = renderingPacketConsumer;
        this.listener = listener;
        renderingPacketConsumer.setErrorConsumer(new Consumer() { // from class: androidx.media3.effect.PacketConsumerHardwareBufferFrameQueue$$ExternalSyntheticLambda2
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                listener.onError(VideoFrameProcessingException.from((Exception) obj));
            }
        });
        PacketConsumerCaller<HardwareBufferFrame> packetConsumerCallerCreate = PacketConsumerCaller.create(renderingPacketConsumer, MoreExecutors.newDirectExecutorService(), new Consumer() { // from class: androidx.media3.effect.PacketConsumerHardwareBufferFrameQueue$$ExternalSyntheticLambda3
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                listener.onError(VideoFrameProcessingException.from((Exception) obj));
            }
        });
        this.output = packetConsumerCallerCreate;
        packetConsumerCallerCreate.run();
    }

    @Override // androidx.media3.effect.HardwareBufferFrameQueue
    public HardwareBufferFrame dequeue(HardwareBufferFrameQueue.FrameFormat frameFormat, Runnable runnable) {
        synchronized (this.lock) {
            while (true) {
                HardwareBufferFrame hardwareBufferFramePoll = this.pool.poll();
                if (hardwareBufferFramePoll != null) {
                    HardwareBuffer hardwareBuffer = (HardwareBuffer) Preconditions.checkNotNull(hardwareBufferFramePoll.hardwareBuffer);
                    if (isCompatible(hardwareBuffer, frameFormat)) {
                        return hardwareBufferFramePoll;
                    }
                    hardwareBuffer.close();
                    closeFence(hardwareBufferFramePoll.acquireFence);
                    this.allocatedBufferCount--;
                } else {
                    int i = this.allocatedBufferCount;
                    if (i >= 5) {
                        this.wakeupListener = runnable;
                        return null;
                    }
                    this.allocatedBufferCount = i + 1;
                    return createNewBuffer(frameFormat);
                }
            }
        }
    }

    @Override // androidx.media3.effect.HardwareBufferFrameQueue
    public void queue(final HardwareBufferFrame hardwareBufferFrame) {
        if (!this.isRenderSurfaceInfoSet) {
            try {
                SurfaceInfo rendererSurfaceInfo = this.listener.getRendererSurfaceInfo(hardwareBufferFrame.format);
                this.isRenderSurfaceInfoSet = true;
                ((RenderingPacketConsumer) Preconditions.checkNotNull(this.packetRenderer)).setRenderOutput(rendererSurfaceInfo);
            } catch (VideoFrameProcessingException e) {
                this.listener.onError(e);
                return;
            }
        }
        sendDownstream(PacketConsumer.Packet.of(new HardwareBufferFrame.Builder(hardwareBufferFrame.hardwareBuffer, this.releaseFrameExecutor, new HardwareBufferFrame.ReleaseCallback() { // from class: androidx.media3.effect.PacketConsumerHardwareBufferFrameQueue$$ExternalSyntheticLambda4
            @Override // androidx.media3.effect.HardwareBufferFrame.ReleaseCallback
            public final void release(SyncFenceCompat syncFenceCompat) {
                this.f$0.m10422x3bfee3ea(hardwareBufferFrame, syncFenceCompat);
            }
        }).setPresentationTimeUs(hardwareBufferFrame.presentationTimeUs).setReleaseTimeNs(hardwareBufferFrame.releaseTimeNs).setAcquireFence(hardwareBufferFrame.acquireFence).setMetadata(hardwareBufferFrame.getMetadata()).setInternalFrame(hardwareBufferFrame.internalFrame).setFormat(hardwareBufferFrame.format).build()));
    }

    /* JADX INFO: renamed from: lambda$queue$2$androidx-media3-effect-PacketConsumerHardwareBufferFrameQueue, reason: not valid java name */
    /* synthetic */ void m10422x3bfee3ea(HardwareBufferFrame hardwareBufferFrame, SyncFenceCompat syncFenceCompat) {
        m10423xe4f564cd((HardwareBuffer) Preconditions.checkNotNull(hardwareBufferFrame.hardwareBuffer), syncFenceCompat);
    }

    @Override // androidx.media3.effect.HardwareBufferFrameQueue
    public void signalEndOfStream() {
        this.listener.onEndOfStream();
        sendDownstream(PacketConsumer.Packet.EndOfStream.INSTANCE);
    }

    @Override // androidx.media3.effect.HardwareBufferFrameQueue
    public void release() {
        if (this.isReleased) {
            return;
        }
        this.isReleased = true;
        this.output.release();
        try {
            PacketConsumerUtil.release(this.packetRenderer, MoreExecutors.newDirectExecutorService()).get(500L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e = e;
            Thread.currentThread().interrupt();
            this.listener.onError(VideoFrameProcessingException.from(e));
        } catch (Exception e2) {
            e = e2;
            this.listener.onError(VideoFrameProcessingException.from(e));
        }
        synchronized (this.lock) {
            while (true) {
                HardwareBufferFrame hardwareBufferFramePoll = this.pool.poll();
                if (hardwareBufferFramePoll != null) {
                    HardwareBuffer hardwareBuffer = (HardwareBuffer) Preconditions.checkNotNull(hardwareBufferFramePoll.hardwareBuffer);
                    if (!hardwareBuffer.isClosed()) {
                        hardwareBuffer.close();
                    }
                }
            }
        }
    }

    private HardwareBufferFrame createNewBuffer(HardwareBufferFrameQueue.FrameFormat frameFormat) {
        final HardwareBuffer hardwareBufferCreate = HardwareBuffer.create(frameFormat.width, frameFormat.height, frameFormat.pixelFormat, 1, adjustUsageFlags(frameFormat.usageFlags));
        Preconditions.checkState(!hardwareBufferCreate.isClosed());
        return new HardwareBufferFrame.Builder(hardwareBufferCreate, this.releaseFrameExecutor, new HardwareBufferFrame.ReleaseCallback() { // from class: androidx.media3.effect.PacketConsumerHardwareBufferFrameQueue$$ExternalSyntheticLambda0
            @Override // androidx.media3.effect.HardwareBufferFrame.ReleaseCallback
            public final void release(SyncFenceCompat syncFenceCompat) {
                this.f$0.m10421xd6d603be(hardwareBufferCreate, syncFenceCompat);
            }
        }).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: returnHardwareBuffer, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void m10423xe4f564cd(final HardwareBuffer hardwareBuffer, SyncFenceCompat syncFenceCompat) {
        Runnable runnable;
        Preconditions.checkArgument(!hardwareBuffer.isClosed());
        closeFence(syncFenceCompat);
        if (this.isReleased) {
            if (hardwareBuffer.isClosed()) {
                return;
            }
            hardwareBuffer.close();
            return;
        }
        synchronized (this.lock) {
            runnable = null;
            if (!poolContainsBuffer(hardwareBuffer)) {
                this.pool.add(new HardwareBufferFrame.Builder(hardwareBuffer, this.releaseFrameExecutor, new HardwareBufferFrame.ReleaseCallback() { // from class: androidx.media3.effect.PacketConsumerHardwareBufferFrameQueue$$ExternalSyntheticLambda1
                    @Override // androidx.media3.effect.HardwareBufferFrame.ReleaseCallback
                    public final void release(SyncFenceCompat syncFenceCompat2) {
                        this.f$0.m10423xe4f564cd(hardwareBuffer, syncFenceCompat2);
                    }
                }).build());
                Runnable runnable2 = this.wakeupListener;
                if (runnable2 != null) {
                    this.wakeupListener = null;
                    runnable = runnable2;
                }
            }
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    private void sendDownstream(PacketConsumer.Packet<HardwareBufferFrame> packet) {
        ((PacketConsumerCaller) Preconditions.checkNotNull(this.output)).queuePacket(packet);
    }

    private void closeFence(SyncFenceCompat syncFenceCompat) {
        if (Build.VERSION.SDK_INT < 33 || syncFenceCompat == null) {
            return;
        }
        try {
            syncFenceCompat.close();
        } catch (IOException e) {
            this.listener.onError(VideoFrameProcessingException.from(e));
        }
    }

    private boolean poolContainsBuffer(HardwareBuffer hardwareBuffer) {
        Iterator<HardwareBufferFrame> it = this.pool.iterator();
        while (it.hasNext()) {
            if (it.next().hardwareBuffer == hardwareBuffer) {
                return true;
            }
        }
        return false;
    }

    private boolean isCompatible(HardwareBuffer hardwareBuffer, HardwareBufferFrameQueue.FrameFormat frameFormat) {
        return hardwareBuffer.getWidth() == frameFormat.width && hardwareBuffer.getHeight() == frameFormat.height && hardwareBuffer.getFormat() == frameFormat.pixelFormat && hardwareBuffer.getUsage() == adjustUsageFlags(frameFormat.usageFlags);
    }
}
