package androidx.media3.exoplayer.upstream.contentsteering;

import android.net.Uri;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UriUtil;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import androidx.media3.exoplayer.util.ReleasableExecutor;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class SteeringManifestTracker {
    static final long FALLBACK_DELAY_UNTIL_NEXT_LOAD_MS = 300000;
    private static final String RETRY_AFTER_HEADER = "Retry-After";
    private static final String TAG = "SteeringManifestTracker";
    private Callback callback;
    private final Clock clock;
    private final DataSource.Factory dataSourceFactory;
    private final Supplier<ReleasableExecutor> downloadExecutorSupplier;
    private MediaSourceEventListener.EventDispatcher eventDispatcher;
    private boolean hasStarted;
    private SteeringManifest steeringManifest;
    private Loader steeringManifestLoader;
    private final SteeringManifestLoaderCallback steeringManifestLoaderCallback;
    private HandlerWrapper steeringManifestReloadHandler;
    private Uri steeringManifestUrl;

    public interface Callback {
        ImmutableMap<String, String> getSteeringQueryParameters();

        void onSteeringManifestUpdated(SteeringManifest steeringManifest);
    }

    public SteeringManifestTracker(DataSource.Factory factory, Supplier<ReleasableExecutor> supplier) {
        this(factory, supplier, Clock.DEFAULT);
    }

    SteeringManifestTracker(DataSource.Factory factory, Supplier<ReleasableExecutor> supplier, Clock clock) {
        this.dataSourceFactory = factory;
        this.downloadExecutorSupplier = supplier;
        this.clock = clock;
        this.steeringManifestLoaderCallback = new SteeringManifestLoaderCallback();
    }

    public void start(Uri uri, Callback callback, MediaSourceEventListener.EventDispatcher eventDispatcher) {
        Loader loader;
        this.steeringManifestUrl = uri;
        this.callback = callback;
        this.eventDispatcher = eventDispatcher;
        this.steeringManifestReloadHandler = this.clock.createHandler(Util.getCurrentOrMainLooper(), null);
        if (this.downloadExecutorSupplier != null) {
            loader = new Loader(this.downloadExecutorSupplier.get());
        } else {
            loader = new Loader(TAG);
        }
        this.steeringManifestLoader = loader;
        this.hasStarted = true;
        loadSteeringManifestImmediately();
    }

    public void stop() {
        this.steeringManifest = null;
        Loader loader = this.steeringManifestLoader;
        if (loader != null) {
            loader.release();
            this.steeringManifestLoader = null;
        }
        HandlerWrapper handlerWrapper = this.steeringManifestReloadHandler;
        if (handlerWrapper != null) {
            handlerWrapper.removeCallbacksAndMessages(null);
            this.steeringManifestReloadHandler = null;
        }
        this.callback = null;
        this.eventDispatcher = null;
        this.hasStarted = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadSteeringManifestImmediately() {
        Preconditions.checkState(this.hasStarted);
        Uri.Builder builderBuildUpon = ((Uri) Preconditions.checkNotNull(this.steeringManifestUrl)).buildUpon();
        UnmodifiableIterator<Map.Entry<String, String>> it = ((Callback) Preconditions.checkNotNull(this.callback)).getSteeringQueryParameters().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            builderBuildUpon.appendQueryParameter(next.getKey(), next.getValue());
        }
        ((Loader) Preconditions.checkNotNull(this.steeringManifestLoader)).startLoading(new ParsingLoadable(this.dataSourceFactory.createDataSource(), new DataSpec.Builder().setUri((Uri) Preconditions.checkNotNull(builderBuildUpon.build())).build(), 8, new SteeringManifestParser()), this.steeringManifestLoaderCallback, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Uri getSteeringManifestUrl(Uri uri, Uri uri2) {
        if (uri2 == null) {
            return uri;
        }
        return UriUtil.isAbsolute(uri2.toString()) ? uri2 : UriUtil.resolveToUri(uri.toString(), uri2.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LoadEventInfo buildLoadEventInfo(ParsingLoadable<SteeringManifest> parsingLoadable, long j, long j2) {
        return new LoadEventInfo(parsingLoadable.loadTaskId, parsingLoadable.dataSpec, parsingLoadable.getUri(), parsingLoadable.getResponseHeaders(), j, j2, parsingLoadable.bytesLoaded());
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SteeringManifestLoaderCallback implements Loader.Callback<ParsingLoadable<SteeringManifest>> {
        private SteeringManifestLoaderCallback() {
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Callback
        public void onLoadStarted(ParsingLoadable<SteeringManifest> parsingLoadable, long j, long j2, int i) {
            if (SteeringManifestTracker.this.hasStarted) {
                ((MediaSourceEventListener.EventDispatcher) Preconditions.checkNotNull(SteeringManifestTracker.this.eventDispatcher)).loadStarted(SteeringManifestTracker.buildLoadEventInfo(parsingLoadable, j, j2), 8, i);
            }
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Callback
        public void onLoadCompleted(ParsingLoadable<SteeringManifest> parsingLoadable, long j, long j2) {
            if (SteeringManifestTracker.this.hasStarted) {
                SteeringManifest steeringManifest = (SteeringManifest) Preconditions.checkNotNull(parsingLoadable.getResult());
                SteeringManifestTracker.this.steeringManifest = steeringManifest;
                ((Callback) Preconditions.checkNotNull(SteeringManifestTracker.this.callback)).onSteeringManifestUpdated(steeringManifest);
                SteeringManifestTracker steeringManifestTracker = SteeringManifestTracker.this;
                steeringManifestTracker.steeringManifestUrl = SteeringManifestTracker.getSteeringManifestUrl((Uri) Preconditions.checkNotNull(steeringManifestTracker.steeringManifestUrl), steeringManifest.reloadUri);
                long j3 = steeringManifest.timeToLiveMs != -9223372036854775807L ? steeringManifest.timeToLiveMs : 300000L;
                HandlerWrapper handlerWrapper = (HandlerWrapper) Preconditions.checkNotNull(SteeringManifestTracker.this.steeringManifestReloadHandler);
                final SteeringManifestTracker steeringManifestTracker2 = SteeringManifestTracker.this;
                handlerWrapper.postDelayed(new Runnable() { // from class: androidx.media3.exoplayer.upstream.contentsteering.SteeringManifestTracker$SteeringManifestLoaderCallback$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        steeringManifestTracker2.loadSteeringManifestImmediately();
                    }
                }, j3);
                ((MediaSourceEventListener.EventDispatcher) Preconditions.checkNotNull(SteeringManifestTracker.this.eventDispatcher)).loadCompleted(SteeringManifestTracker.buildLoadEventInfo(parsingLoadable, j, j2), 8);
            }
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Callback
        public void onLoadCanceled(ParsingLoadable<SteeringManifest> parsingLoadable, long j, long j2, boolean z) {
            if (SteeringManifestTracker.this.hasStarted) {
                ((MediaSourceEventListener.EventDispatcher) Preconditions.checkNotNull(SteeringManifestTracker.this.eventDispatcher)).loadCanceled(SteeringManifestTracker.buildLoadEventInfo(parsingLoadable, j, j2), 8);
            }
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.Callback
        public Loader.LoadErrorAction onLoadError(ParsingLoadable<SteeringManifest> parsingLoadable, long j, long j2, IOException iOException, int i) {
            long j3;
            if (!SteeringManifestTracker.this.hasStarted) {
                return Loader.DONT_RETRY;
            }
            int i2 = iOException instanceof HttpDataSource.InvalidResponseCodeException ? ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode : Integer.MAX_VALUE;
            if (i2 == 410) {
                ((Loader) Preconditions.checkNotNull(SteeringManifestTracker.this.steeringManifestLoader)).release();
                ((HandlerWrapper) Preconditions.checkNotNull(SteeringManifestTracker.this.steeringManifestReloadHandler)).removeCallbacksAndMessages(null);
                j3 = -9223372036854775807L;
            } else {
                j3 = 300000;
                if (i2 != 429) {
                    if (SteeringManifestTracker.this.steeringManifest != null && SteeringManifestTracker.this.steeringManifest.timeToLiveMs != -9223372036854775807L) {
                        j3 = SteeringManifestTracker.this.steeringManifest.timeToLiveMs;
                    }
                } else {
                    List<String> list = parsingLoadable.getResponseHeaders().get("Retry-After");
                    if (list != null) {
                        try {
                            j3 = Long.parseLong(list.get(0)) * 1000;
                        } catch (NumberFormatException unused) {
                            Log.w(SteeringManifestTracker.TAG, "Retry-After header string doesn't contain a parsable long");
                        }
                    }
                }
            }
            if (j3 != -9223372036854775807L) {
                HandlerWrapper handlerWrapper = (HandlerWrapper) Preconditions.checkNotNull(SteeringManifestTracker.this.steeringManifestReloadHandler);
                final SteeringManifestTracker steeringManifestTracker = SteeringManifestTracker.this;
                handlerWrapper.postDelayed(new Runnable() { // from class: androidx.media3.exoplayer.upstream.contentsteering.SteeringManifestTracker$SteeringManifestLoaderCallback$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        steeringManifestTracker.loadSteeringManifestImmediately();
                    }
                }, j3);
            }
            ((MediaSourceEventListener.EventDispatcher) Preconditions.checkNotNull(SteeringManifestTracker.this.eventDispatcher)).loadError(SteeringManifestTracker.buildLoadEventInfo(parsingLoadable, j, j2), 8, iOException, j3 == -9223372036854775807L);
            return Loader.DONT_RETRY;
        }
    }
}
