package androidx.media3.inspector.frame;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.media3.common.Effect;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector;
import androidx.media3.exoplayer.source.MediaSource;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes8.dex */
public final class FrameExtractor implements AutoCloseable {
    private final Context context;
    private final ImmutableList<Effect> effects;
    private final boolean extractHdrFrames;
    private final GlObjectsProvider glObjectsProvider;
    private final MediaCodecSelector mediaCodecSelector;
    private final MediaItem mediaItem;
    private MediaSource.Factory mediaSourceFactory;
    private final AtomicBoolean released;
    private final SeekParameters seekParameters;

    static {
        MediaLibraryInfo.registerModule("media3.inspector.frame");
    }

    public static final class Builder {
        private final Context context;
        private GlObjectsProvider glObjectsProvider;
        private final MediaItem mediaItem;
        private MediaSource.Factory mediaSourceFactory;
        private List<Effect> effects = ImmutableList.of();
        private SeekParameters seekParameters = SeekParameters.DEFAULT;
        private MediaCodecSelector mediaCodecSelector = MediaCodecSelector.PREFER_SOFTWARE;
        private boolean extractHdrFrames = false;

        public Builder(Context context, MediaItem mediaItem) {
            this.context = context;
            this.mediaItem = mediaItem;
        }

        public Builder setEffects(List<Effect> list) {
            this.effects = list;
            return this;
        }

        public Builder setSeekParameters(SeekParameters seekParameters) {
            this.seekParameters = seekParameters;
            return this;
        }

        public Builder setMediaCodecSelector(MediaCodecSelector mediaCodecSelector) {
            this.mediaCodecSelector = mediaCodecSelector;
            return this;
        }

        public Builder setExtractHdrFrames(boolean z) {
            this.extractHdrFrames = z;
            return this;
        }

        public Builder setGlObjectsProvider(GlObjectsProvider glObjectsProvider) {
            this.glObjectsProvider = glObjectsProvider;
            return this;
        }

        public Builder setMediaSourceFactory(MediaSource.Factory factory) {
            this.mediaSourceFactory = (MediaSource.Factory) Preconditions.checkNotNull(factory);
            return this;
        }

        public FrameExtractor build() {
            return new FrameExtractor(this);
        }
    }

    public static final class Frame {
        public final Bitmap bitmap;
        public final long presentationTimeMs;

        Frame(long j, Bitmap bitmap) {
            this.presentationTimeMs = j;
            this.bitmap = bitmap;
        }
    }

    private FrameExtractor(Builder builder) {
        this.context = builder.context;
        this.mediaItem = builder.mediaItem;
        this.effects = ImmutableList.copyOf((Collection) builder.effects);
        this.seekParameters = builder.seekParameters;
        this.mediaCodecSelector = builder.mediaCodecSelector;
        this.extractHdrFrames = builder.extractHdrFrames;
        this.glObjectsProvider = builder.glObjectsProvider;
        this.mediaSourceFactory = builder.mediaSourceFactory;
        this.released = new AtomicBoolean(false);
        FrameExtractorInternal.getInstance().addReference();
    }

    public ListenableFuture<Frame> getFrame(long j) {
        if (this.released.get()) {
            return Futures.immediateFailedFuture(new IllegalStateException("getFrame() called on a released FrameExtractor."));
        }
        return FrameExtractorInternal.getInstance().submitTask(new FrameExtractorInternal.FrameExtractionRequest(this.context, this.mediaItem, this.effects, this.seekParameters, this.mediaCodecSelector, this.glObjectsProvider, this.mediaSourceFactory, this.extractHdrFrames, j));
    }

    public ListenableFuture<Frame> getThumbnail() {
        if (this.released.get()) {
            return Futures.immediateFailedFuture(new IllegalStateException("getThumbnail() called on a released FrameExtractor."));
        }
        return FrameExtractorInternal.getInstance().submitTask(new FrameExtractorInternal.FrameExtractionRequest(this.context, this.mediaItem, this.effects, SeekParameters.NEXT_SYNC, this.mediaCodecSelector, this.glObjectsProvider, this.mediaSourceFactory, this.extractHdrFrames, -9223372036854775807L));
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.released.getAndSet(true)) {
            return;
        }
        FrameExtractorInternal.getInstance().releaseReference();
    }

    ListenableFuture<DecoderCounters> getDecoderCounters() {
        return FrameExtractorInternal.getInstance().getDecoderCounters();
    }
}
