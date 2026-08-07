package androidx.media3.effect;

import androidx.media3.common.Format;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes8.dex */
public class GlTextureFrame implements Frame {
    public static final GlTextureFrame END_OF_STREAM_FRAME = new Builder(new GlTextureInfo(-1, -1, -1, -1, -1), MoreExecutors.directExecutor(), new Consumer() { // from class: androidx.media3.effect.GlTextureFrame$$ExternalSyntheticLambda1
        @Override // androidx.media3.common.util.Consumer
        public final void accept(Object obj) {
            GlTextureFrame.lambda$static$0((GlTextureInfo) obj);
        }
    }).build();
    private static final String TAG = "GlTextureFrame";
    public final long fenceSync;
    public final Format format;
    public final GlTextureInfo glTextureInfo;
    private final Frame.Metadata metadata;
    public final long presentationTimeUs;
    private final AtomicInteger referenceCount;
    public final Consumer<GlTextureInfo> releaseTextureCallback;
    public final Executor releaseTextureExecutor;
    public final long releaseTimeNs;

    static /* synthetic */ void lambda$static$0(GlTextureInfo glTextureInfo) {
    }

    public static final class Builder {
        private long fenceSync;
        private Format format;
        private final GlTextureInfo glTextureInfo;
        private Frame.Metadata metadata;
        private long presentationTimeUs;
        private final Consumer<GlTextureInfo> releaseTextureCallback;
        private final Executor releaseTextureExecutor;
        private long releaseTimeNs;

        public Builder(GlTextureInfo glTextureInfo, Executor executor, Consumer<GlTextureInfo> consumer) {
            this.glTextureInfo = glTextureInfo;
            this.releaseTextureExecutor = executor;
            this.releaseTextureCallback = consumer;
            this.metadata = new Frame.Metadata() { // from class: androidx.media3.effect.GlTextureFrame.Builder.1
            };
            this.presentationTimeUs = -9223372036854775807L;
            this.format = new Format.Builder().build();
            this.releaseTimeNs = -9223372036854775807L;
            this.fenceSync = -1L;
        }

        private Builder(GlTextureFrame glTextureFrame) {
            this(glTextureFrame.glTextureInfo, glTextureFrame.releaseTextureExecutor, glTextureFrame.releaseTextureCallback);
            this.metadata = glTextureFrame.metadata;
            this.presentationTimeUs = glTextureFrame.presentationTimeUs;
            this.format = glTextureFrame.format;
            this.releaseTimeNs = glTextureFrame.releaseTimeNs;
            this.fenceSync = glTextureFrame.fenceSync;
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

        public Builder setFenceSync(long j) {
            this.fenceSync = j;
            return this;
        }

        public GlTextureFrame build() {
            return new GlTextureFrame(this);
        }
    }

    private GlTextureFrame(Builder builder) {
        this.glTextureInfo = builder.glTextureInfo;
        this.presentationTimeUs = builder.presentationTimeUs;
        this.releaseTimeNs = builder.releaseTimeNs;
        this.format = builder.format;
        this.metadata = builder.metadata;
        this.releaseTextureExecutor = builder.releaseTextureExecutor;
        this.releaseTextureCallback = builder.releaseTextureCallback;
        this.fenceSync = builder.fenceSync;
        this.referenceCount = new AtomicInteger(1);
    }

    public Builder buildUpon() {
        return new Builder();
    }

    @Override // androidx.media3.effect.Frame
    public Frame.Metadata getMetadata() {
        return this.metadata;
    }

    @Override // androidx.media3.effect.Frame
    public void release(SyncFenceCompat syncFenceCompat) {
        int i;
        do {
            i = this.referenceCount.get();
            if (i == 0) {
                Log.d(TAG, "release() called on an already released frame.");
                return;
            }
        } while (!this.referenceCount.compareAndSet(i, i - 1));
        if (i == 1) {
            this.releaseTextureExecutor.execute(new Runnable() { // from class: androidx.media3.effect.GlTextureFrame$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m10408lambda$release$1$androidxmedia3effectGlTextureFrame();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$release$1$androidx-media3-effect-GlTextureFrame, reason: not valid java name */
    /* synthetic */ void m10408lambda$release$1$androidxmedia3effectGlTextureFrame() {
        this.releaseTextureCallback.accept(this.glTextureInfo);
    }

    public void retain() {
        int i;
        do {
            i = this.referenceCount.get();
            if (i <= 0) {
                throw new IllegalStateException("Cannot retain a frame that has already been released.");
            }
        } while (!this.referenceCount.compareAndSet(i, i + 1));
    }
}
