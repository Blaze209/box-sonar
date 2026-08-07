package androidx.media3.effect;

import android.hardware.HardwareBuffer;
import androidx.media3.common.Format;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes8.dex */
public final class HardwareBufferFrame implements Frame {
    public static final HardwareBufferFrame END_OF_STREAM_FRAME = new Builder(null, MoreExecutors.directExecutor(), new ReleaseCallback() { // from class: androidx.media3.effect.HardwareBufferFrame$$ExternalSyntheticLambda0
        @Override // androidx.media3.effect.HardwareBufferFrame.ReleaseCallback
        public final void release(SyncFenceCompat syncFenceCompat) {
            HardwareBufferFrame.lambda$static$0(syncFenceCompat);
        }
    }).setInternalFrame(new Object()).build();
    public final SyncFenceCompat acquireFence;
    public final Format format;
    public final HardwareBuffer hardwareBuffer;
    public final Object internalFrame;
    private final Frame.Metadata metadata;
    public final long presentationTimeUs;
    private final ReleaseCallback releaseCallback;
    private final Executor releaseExecutor;
    public final long releaseTimeNs;

    public interface ReleaseCallback {
        void release(SyncFenceCompat syncFenceCompat);
    }

    static /* synthetic */ void lambda$static$0(SyncFenceCompat syncFenceCompat) {
    }

    public static final class Builder {
        private SyncFenceCompat acquireFence;
        private Format format;
        private final HardwareBuffer hardwareBuffer;
        private Object internalFrame;
        private Frame.Metadata metadata;
        private long presentationTimeUs;
        private final ReleaseCallback releaseCallback;
        private final Executor releaseExecutor;
        private long releaseTimeNs;

        public Builder(HardwareBuffer hardwareBuffer, Executor executor, ReleaseCallback releaseCallback) {
            this.hardwareBuffer = hardwareBuffer;
            this.releaseExecutor = executor;
            this.releaseCallback = releaseCallback;
            this.metadata = new Frame.Metadata() { // from class: androidx.media3.effect.HardwareBufferFrame.Builder.1
            };
            this.presentationTimeUs = -9223372036854775807L;
            this.format = new Format.Builder().build();
            this.releaseTimeNs = -9223372036854775807L;
        }

        private Builder(HardwareBufferFrame hardwareBufferFrame) {
            this(hardwareBufferFrame.hardwareBuffer, hardwareBufferFrame.releaseExecutor, hardwareBufferFrame.releaseCallback);
            this.metadata = hardwareBufferFrame.metadata;
            this.presentationTimeUs = hardwareBufferFrame.presentationTimeUs;
            this.format = hardwareBufferFrame.format;
            this.releaseTimeNs = hardwareBufferFrame.releaseTimeNs;
            this.acquireFence = hardwareBufferFrame.acquireFence;
            this.internalFrame = hardwareBufferFrame.internalFrame;
        }

        public Builder setPresentationTimeUs(long j) {
            this.presentationTimeUs = j;
            return this;
        }

        public Builder setFormat(Format format) {
            this.format = format;
            return this;
        }

        public Builder setReleaseTimeNs(long j) {
            this.releaseTimeNs = j;
            return this;
        }

        public Builder setMetadata(Frame.Metadata metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder setAcquireFence(SyncFenceCompat syncFenceCompat) {
            this.acquireFence = syncFenceCompat;
            return this;
        }

        public Builder setInternalFrame(Object obj) {
            this.internalFrame = obj;
            return this;
        }

        public HardwareBufferFrame build() {
            return new HardwareBufferFrame(this);
        }
    }

    private HardwareBufferFrame(Builder builder) {
        Preconditions.checkArgument((builder.hardwareBuffer == null && builder.internalFrame == null) ? false : true);
        this.hardwareBuffer = builder.hardwareBuffer;
        this.presentationTimeUs = builder.presentationTimeUs;
        this.releaseTimeNs = builder.releaseTimeNs;
        this.format = builder.format;
        this.metadata = builder.metadata;
        this.releaseExecutor = builder.releaseExecutor;
        this.releaseCallback = builder.releaseCallback;
        this.acquireFence = builder.acquireFence;
        this.internalFrame = builder.internalFrame;
    }

    public Builder buildUpon() {
        return new Builder();
    }

    @Override // androidx.media3.effect.Frame
    public Frame.Metadata getMetadata() {
        return this.metadata;
    }

    /* JADX INFO: renamed from: lambda$release$1$androidx-media3-effect-HardwareBufferFrame, reason: not valid java name */
    /* synthetic */ void m10413lambda$release$1$androidxmedia3effectHardwareBufferFrame(SyncFenceCompat syncFenceCompat) {
        this.releaseCallback.release(syncFenceCompat);
    }

    @Override // androidx.media3.effect.Frame
    public void release(final SyncFenceCompat syncFenceCompat) {
        this.releaseExecutor.execute(new Runnable() { // from class: androidx.media3.effect.HardwareBufferFrame$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m10413lambda$release$1$androidxmedia3effectHardwareBufferFrame(syncFenceCompat);
            }
        });
    }
}
