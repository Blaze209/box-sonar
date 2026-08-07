package androidx.media3.exoplayer.source.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.AdViewProvider;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.source.ClippingMediaPeriod;
import androidx.media3.exoplayer.source.CompositeMediaSource;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MaskingMediaPeriod;
import androidx.media3.exoplayer.source.MaskingMediaSource;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: classes8.dex */
public final class AdsMediaSource extends CompositeMediaSource<MediaSource.MediaPeriodId> {
    private static final MediaSource.MediaPeriodId CHILD_SOURCE_MEDIA_PERIOD_ID = new MediaSource.MediaPeriodId(new Object());
    private final List<AdMediaSourceHolder> activeMediaSourceHolders;
    private final MediaSource.Factory adMediaSourceFactory;
    private AdMediaSourceHolder[][] adMediaSourceHolders;
    private AdPlaybackState adPlaybackState;
    private final DataSpec adTagDataSpec;
    private final AdViewProvider adViewProvider;
    private final Object adsId;
    private final AdsLoader adsLoader;
    private ComponentListener componentListener;
    final MediaItem.DrmConfiguration contentDrmConfiguration;
    private final MaskingMediaSource contentMediaSource;
    private Timeline contentTimeline;
    private final Handler mainHandler;
    private final Timeline.Period period;
    private Handler playerHandler;
    private final boolean useAdMediaSourceClipping;
    private final boolean useLazyContentSourcePreparation;

    public static final class AdLoadException extends IOException {
        public static final int TYPE_AD = 0;
        public static final int TYPE_AD_GROUP = 1;
        public static final int TYPE_ALL_ADS = 2;
        public static final int TYPE_UNEXPECTED = 3;
        public final int type;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
        }

        public static AdLoadException createForAd(Exception exc) {
            return new AdLoadException(0, exc);
        }

        public static AdLoadException createForAdGroup(Exception exc, int i) {
            return new AdLoadException(1, new IOException("Failed to load ad group " + i, exc));
        }

        public static AdLoadException createForAllAds(Exception exc) {
            return new AdLoadException(2, exc);
        }

        public static AdLoadException createForUnexpected(RuntimeException runtimeException) {
            return new AdLoadException(3, runtimeException);
        }

        private AdLoadException(int i, Exception exc) {
            super(exc);
            this.type = i;
        }

        public RuntimeException getRuntimeExceptionForUnexpected() {
            Preconditions.checkState(this.type == 3);
            return (RuntimeException) Preconditions.checkNotNull(getCause());
        }
    }

    public AdsMediaSource(MediaSource mediaSource, DataSpec dataSpec, Object obj, MediaSource.Factory factory, AdsLoader adsLoader, AdViewProvider adViewProvider) {
        this(mediaSource, dataSpec, obj, factory, adsLoader, adViewProvider, true, false);
    }

    public AdsMediaSource(MediaSource mediaSource, DataSpec dataSpec, Object obj, MediaSource.Factory factory, AdsLoader adsLoader, AdViewProvider adViewProvider, boolean z, boolean z2) {
        this.contentMediaSource = new MaskingMediaSource(mediaSource, z);
        this.contentDrmConfiguration = ((MediaItem.LocalConfiguration) Preconditions.checkNotNull(mediaSource.getMediaItem().localConfiguration)).drmConfiguration;
        this.adMediaSourceFactory = factory;
        this.adsLoader = adsLoader;
        this.adViewProvider = adViewProvider;
        this.adTagDataSpec = dataSpec;
        this.adsId = obj;
        this.useLazyContentSourcePreparation = z;
        this.useAdMediaSourceClipping = z2;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.period = new Timeline.Period();
        this.adMediaSourceHolders = new AdMediaSourceHolder[0][];
        this.activeMediaSourceHolders = new ArrayList();
        adsLoader.setSupportedContentTypes(factory.getSupportedTypes());
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public MediaItem getMediaItem() {
        return this.contentMediaSource.getMediaItem();
    }

    public Object getAdsId() {
        return this.adsId;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public boolean canUpdateMediaItem(MediaItem mediaItem) {
        return Objects.equals(getAdsConfiguration(getMediaItem()), getAdsConfiguration(mediaItem)) && this.contentMediaSource.canUpdateMediaItem(mediaItem);
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void updateMediaItem(MediaItem mediaItem) {
        this.contentMediaSource.updateMediaItem(mediaItem);
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    protected void prepareSourceInternal(TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        this.playerHandler = Util.createHandlerForCurrentLooper();
        final ComponentListener componentListener = new ComponentListener(this.playerHandler);
        this.componentListener = componentListener;
        this.contentTimeline = this.contentMediaSource.getTimeline();
        prepareChildSource(CHILD_SOURCE_MEDIA_PERIOD_ID, this.contentMediaSource);
        this.mainHandler.post(new Runnable() { // from class: androidx.media3.exoplayer.source.ads.AdsMediaSource$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m10560x9f9466de(componentListener);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$prepareSourceInternal$0$androidx-media3-exoplayer-source-ads-AdsMediaSource, reason: not valid java name */
    /* synthetic */ void m10560x9f9466de(ComponentListener componentListener) {
        this.adsLoader.start(this, this.adTagDataSpec, this.adsId, this.adViewProvider, componentListener);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004f  */
    @Override // androidx.media3.exoplayer.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        AdMediaSourceHolder adMediaSourceHolder;
        long j2;
        AdPlaybackState adPlaybackState = (AdPlaybackState) Preconditions.checkNotNull(this.adPlaybackState);
        if (adPlaybackState.adGroupCount > 0 && mediaPeriodId.isAd()) {
            int i = mediaPeriodId.adGroupIndex;
            int i2 = mediaPeriodId.adIndexInAdGroup;
            AdMediaSourceHolder[][] adMediaSourceHolderArr = this.adMediaSourceHolders;
            AdMediaSourceHolder[] adMediaSourceHolderArr2 = adMediaSourceHolderArr[i];
            if (adMediaSourceHolderArr2.length <= i2) {
                adMediaSourceHolderArr[i] = (AdMediaSourceHolder[]) Arrays.copyOf(adMediaSourceHolderArr2, i2 + 1);
            }
            AdMediaSourceHolder adMediaSourceHolder2 = this.adMediaSourceHolders[i][i2];
            if (adMediaSourceHolder2 == null) {
                if (this.useAdMediaSourceClipping) {
                    j2 = ((AdPlaybackState.AdGroup) Preconditions.checkNotNull(adPlaybackState.getAdGroup(mediaPeriodId.adGroupIndex))).durationsUs[mediaPeriodId.adIndexInAdGroup];
                    if (j2 == -9223372036854775807L) {
                        j2 = Long.MIN_VALUE;
                    }
                } else {
                    j2 = Long.MIN_VALUE;
                }
                adMediaSourceHolder = new AdMediaSourceHolder(mediaPeriodId, j2);
                this.adMediaSourceHolders[i][i2] = adMediaSourceHolder;
                this.activeMediaSourceHolders.add(adMediaSourceHolder);
                maybeUpdateAdMediaSources();
            } else {
                adMediaSourceHolder = adMediaSourceHolder2;
            }
            return adMediaSourceHolder.createMediaPeriod(mediaPeriodId, allocator, j, this.useAdMediaSourceClipping);
        }
        MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(mediaPeriodId, allocator, j);
        maskingMediaPeriod.setMediaSource(this.contentMediaSource);
        maskingMediaPeriod.createPeriod(mediaPeriodId);
        return maskingMediaPeriod;
    }

    @Override // androidx.media3.exoplayer.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        MaskingMediaPeriod maskingMediaPeriod = (MaskingMediaPeriod) (mediaPeriod instanceof ClippingMediaPeriod ? ((ClippingMediaPeriod) mediaPeriod).mediaPeriod : mediaPeriod);
        MediaSource.MediaPeriodId mediaPeriodId = maskingMediaPeriod.id;
        if (mediaPeriodId.isAd()) {
            AdMediaSourceHolder adMediaSourceHolder = (AdMediaSourceHolder) Preconditions.checkNotNull(this.adMediaSourceHolders[mediaPeriodId.adGroupIndex][mediaPeriodId.adIndexInAdGroup]);
            adMediaSourceHolder.releaseMediaPeriod(mediaPeriod);
            if (adMediaSourceHolder.isInactive()) {
                adMediaSourceHolder.release();
                this.adMediaSourceHolders[mediaPeriodId.adGroupIndex][mediaPeriodId.adIndexInAdGroup] = null;
                this.activeMediaSourceHolders.remove(adMediaSourceHolder);
                return;
            }
            return;
        }
        maskingMediaPeriod.releasePeriod();
    }

    @Override // androidx.media3.exoplayer.source.CompositeMediaSource, androidx.media3.exoplayer.source.BaseMediaSource
    protected void releaseSourceInternal() {
        super.releaseSourceInternal();
        final ComponentListener componentListener = (ComponentListener) Preconditions.checkNotNull(this.componentListener);
        this.componentListener = null;
        this.playerHandler = null;
        componentListener.stop();
        this.contentTimeline = null;
        this.adPlaybackState = null;
        this.adMediaSourceHolders = new AdMediaSourceHolder[0][];
        this.mainHandler.post(new Runnable() { // from class: androidx.media3.exoplayer.source.ads.AdsMediaSource$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m10561x4d6cb35f(componentListener);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$releaseSourceInternal$1$androidx-media3-exoplayer-source-ads-AdsMediaSource, reason: not valid java name */
    /* synthetic */ void m10561x4d6cb35f(ComponentListener componentListener) {
        this.adsLoader.stop(this, componentListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    /* JADX INFO: renamed from: onChildSourceInfoRefreshed, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void m10545x28f9175(MediaSource.MediaPeriodId mediaPeriodId, MediaSource mediaSource, final Timeline timeline) {
        if (mediaPeriodId.isAd()) {
            ((AdMediaSourceHolder) Preconditions.checkNotNull(this.adMediaSourceHolders[mediaPeriodId.adGroupIndex][mediaPeriodId.adIndexInAdGroup])).handleSourceInfoRefresh(timeline);
            maybeUpdateSourceInfo();
        } else {
            Preconditions.checkArgument(timeline.getPeriodCount() == 1);
            this.contentTimeline = timeline;
            this.mainHandler.post(new Runnable() { // from class: androidx.media3.exoplayer.source.ads.AdsMediaSource$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m10559xbe1bc96f(timeline);
                }
            });
            if (this.useLazyContentSourcePreparation) {
                maybeUpdateSourceInfo();
            }
        }
    }

    /* JADX INFO: renamed from: lambda$onChildSourceInfoRefreshed$2$androidx-media3-exoplayer-source-ads-AdsMediaSource, reason: not valid java name */
    /* synthetic */ void m10559xbe1bc96f(Timeline timeline) {
        boolean zHandleContentTimelineChanged = this.adsLoader.handleContentTimelineChanged(this, timeline);
        Preconditions.checkState((zHandleContentTimelineChanged && this.useLazyContentSourcePreparation) ? false : true);
        if (zHandleContentTimelineChanged || this.useLazyContentSourcePreparation) {
            return;
        }
        ((Handler) Preconditions.checkNotNull(this.playerHandler)).post(new Runnable() { // from class: androidx.media3.exoplayer.source.ads.AdsMediaSource$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.maybeUpdateSourceInfo();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.source.CompositeMediaSource
    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(MediaSource.MediaPeriodId mediaPeriodId, MediaSource.MediaPeriodId mediaPeriodId2) {
        return mediaPeriodId.isAd() ? mediaPeriodId : mediaPeriodId2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdPlaybackState(AdPlaybackState adPlaybackState) {
        AdPlaybackState adPlaybackState2 = this.adPlaybackState;
        if (adPlaybackState2 == null) {
            AdMediaSourceHolder[][] adMediaSourceHolderArr = new AdMediaSourceHolder[adPlaybackState.adGroupCount - (adPlaybackState.endsWithLivePostrollPlaceHolder() ? 1 : 0)][];
            this.adMediaSourceHolders = adMediaSourceHolderArr;
            Arrays.fill(adMediaSourceHolderArr, new AdMediaSourceHolder[0]);
        } else {
            int iCheckValidAdPlaybackStateUpdate = checkValidAdPlaybackStateUpdate(adPlaybackState2, adPlaybackState);
            if (iCheckValidAdPlaybackStateUpdate > 0) {
                this.adMediaSourceHolders = growAdMediaSourceHolderGrid(this.adMediaSourceHolders, iCheckValidAdPlaybackStateUpdate);
            }
            if (this.useAdMediaSourceClipping) {
                for (int i = 0; i < this.activeMediaSourceHolders.size(); i++) {
                    AdMediaSourceHolder adMediaSourceHolder = this.activeMediaSourceHolders.get(i);
                    MediaSource.MediaPeriodId mediaPeriodId = adMediaSourceHolder.id;
                    long j = adPlaybackState.getAdGroup(mediaPeriodId.adGroupIndex).durationsUs[mediaPeriodId.adIndexInAdGroup];
                    if (j != -9223372036854775807L) {
                        adMediaSourceHolder.setEndPositionUs(j);
                    }
                }
            }
        }
        this.adPlaybackState = adPlaybackState;
        maybeUpdateAdMediaSources();
        maybeUpdateSourceInfo();
    }

    private static int checkValidAdPlaybackStateUpdate(AdPlaybackState adPlaybackState, AdPlaybackState adPlaybackState2) {
        Preconditions.checkState(adPlaybackState.endsWithLivePostrollPlaceHolder() == adPlaybackState2.endsWithLivePostrollPlaceHolder());
        int i = adPlaybackState2.adGroupCount - adPlaybackState.adGroupCount;
        Preconditions.checkState(i >= 0);
        int i2 = adPlaybackState2.removedAdGroupCount;
        while (i2 < adPlaybackState.adGroupCount) {
            AdPlaybackState.AdGroup adGroup = adPlaybackState.getAdGroup(i2);
            if (adGroup.isLivePostrollPlaceholder()) {
                Preconditions.checkState(i2 == adPlaybackState.adGroupCount - 1);
                return i;
            }
            AdPlaybackState.AdGroup adGroup2 = adPlaybackState2.getAdGroup(i2);
            Preconditions.checkState(adGroup.count <= adGroup2.count);
            Preconditions.checkState(adGroup.timeUs == adGroup2.timeUs);
            for (int i3 = 0; i3 < adGroup.count; i3++) {
                if (adGroup.mediaItems[i3] != null) {
                    Preconditions.checkState(adGroup.mediaItems[i3].equals(adGroup2.mediaItems[i3]));
                }
            }
            i2++;
        }
        return i;
    }

    private static AdMediaSourceHolder[][] growAdMediaSourceHolderGrid(AdMediaSourceHolder[][] adMediaSourceHolderArr, int i) {
        int length = adMediaSourceHolderArr.length + i;
        AdMediaSourceHolder[][] adMediaSourceHolderArr2 = new AdMediaSourceHolder[length][];
        System.arraycopy(adMediaSourceHolderArr, 0, adMediaSourceHolderArr2, 0, adMediaSourceHolderArr.length);
        for (int length2 = adMediaSourceHolderArr.length; length2 < length; length2++) {
            adMediaSourceHolderArr2[length2] = new AdMediaSourceHolder[0];
        }
        return adMediaSourceHolderArr2;
    }

    private void maybeUpdateAdMediaSources() {
        MediaItem mediaItemBuild;
        AdPlaybackState adPlaybackState = this.adPlaybackState;
        if (adPlaybackState == null) {
            return;
        }
        for (int i = 0; i < this.adMediaSourceHolders.length; i++) {
            int i2 = 0;
            while (true) {
                AdMediaSourceHolder[] adMediaSourceHolderArr = this.adMediaSourceHolders[i];
                if (i2 < adMediaSourceHolderArr.length) {
                    AdMediaSourceHolder adMediaSourceHolder = adMediaSourceHolderArr[i2];
                    AdPlaybackState.AdGroup adGroup = adPlaybackState.getAdGroup(i);
                    if (adMediaSourceHolder != null && !adMediaSourceHolder.hasMediaSource() && i2 < adGroup.mediaItems.length && (mediaItemBuild = adGroup.mediaItems[i2]) != null) {
                        if (this.contentDrmConfiguration != null) {
                            mediaItemBuild = mediaItemBuild.buildUpon().setDrmConfiguration(this.contentDrmConfiguration).build();
                        }
                        adMediaSourceHolder.initializeWithMediaSource(this.adMediaSourceFactory.createMediaSource(mediaItemBuild), mediaItemBuild);
                    }
                    i2++;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeUpdateSourceInfo() {
        Timeline timeline = this.contentTimeline;
        AdPlaybackState adPlaybackState = this.adPlaybackState;
        if (adPlaybackState == null || timeline == null) {
            return;
        }
        if (adPlaybackState.adGroupCount == 0) {
            refreshSourceInfo(timeline);
        } else {
            this.adPlaybackState = this.adPlaybackState.withAdDurationsUs(getAdDurationsUs());
            refreshSourceInfo(new SinglePeriodAdTimeline(timeline, this.adPlaybackState));
        }
    }

    @RequiresNonNull({"adPlaybackState"})
    private long[][] getAdDurationsUs() {
        int length;
        AdMediaSourceHolder adMediaSourceHolder;
        AdPlaybackState adPlaybackState = (AdPlaybackState) Preconditions.checkNotNull(this.adPlaybackState);
        boolean zEndsWithLivePostrollPlaceHolder = adPlaybackState.endsWithLivePostrollPlaceHolder();
        int length2 = this.adMediaSourceHolders.length + (zEndsWithLivePostrollPlaceHolder ? 1 : 0);
        long[][] jArr = new long[length2][];
        int i = 0;
        while (true) {
            AdMediaSourceHolder[][] adMediaSourceHolderArr = this.adMediaSourceHolders;
            if (i >= adMediaSourceHolderArr.length) {
                break;
            }
            if (this.useAdMediaSourceClipping) {
                length = adPlaybackState.getAdGroup(i).count;
            } else {
                length = adMediaSourceHolderArr[i].length;
            }
            jArr[i] = new long[length];
            int i2 = 0;
            while (i2 < length) {
                long j = adPlaybackState.getAdGroup(i).durationsUs.length > i2 ? adPlaybackState.getAdGroup(i).durationsUs[i2] : -9223372036854775807L;
                if (j != -9223372036854775807L && this.useAdMediaSourceClipping) {
                    jArr[i][i2] = j;
                } else {
                    AdMediaSourceHolder[] adMediaSourceHolderArr2 = this.adMediaSourceHolders[i];
                    if (adMediaSourceHolderArr2.length <= i2 || (adMediaSourceHolder = adMediaSourceHolderArr2[i2]) == null) {
                        jArr[i][i2] = -9223372036854775807L;
                    } else {
                        jArr[i][i2] = adMediaSourceHolder.getDurationUs();
                    }
                }
                i2++;
            }
            i++;
        }
        if (zEndsWithLivePostrollPlaceHolder) {
            jArr[length2 - 1] = new long[0];
        }
        return jArr;
    }

    private static MediaItem.AdsConfiguration getAdsConfiguration(MediaItem mediaItem) {
        if (mediaItem.localConfiguration == null) {
            return null;
        }
        return mediaItem.localConfiguration.adsConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class ComponentListener implements AdsLoader.EventListener {
        private final Handler playerHandler;
        private volatile boolean stopped;

        public ComponentListener(Handler handler) {
            this.playerHandler = handler;
        }

        public void stop() {
            this.stopped = true;
            this.playerHandler.removeCallbacksAndMessages(null);
        }

        @Override // androidx.media3.exoplayer.source.ads.AdsLoader.EventListener
        public void onAdPlaybackState(final AdPlaybackState adPlaybackState) {
            if (this.stopped) {
                return;
            }
            this.playerHandler.post(new Runnable() { // from class: androidx.media3.exoplayer.source.ads.AdsMediaSource$ComponentListener$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m10564x6396e000(adPlaybackState);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdPlaybackState$0$androidx-media3-exoplayer-source-ads-AdsMediaSource$ComponentListener, reason: not valid java name */
        /* synthetic */ void m10564x6396e000(AdPlaybackState adPlaybackState) {
            if (this.stopped) {
                return;
            }
            AdsMediaSource.this.onAdPlaybackState(adPlaybackState);
        }

        @Override // androidx.media3.exoplayer.source.ads.AdsLoader.EventListener
        public void onAdLoadError(AdLoadException adLoadException, DataSpec dataSpec) {
            if (this.stopped) {
                return;
            }
            AdsMediaSource.this.createEventDispatcher(null).loadError(new LoadEventInfo(LoadEventInfo.getNewId(), dataSpec, SystemClock.elapsedRealtime()), 6, (IOException) adLoadException, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class AdPrepareListener implements MaskingMediaPeriod.PrepareListener {
        private final MediaItem adMediaItem;

        public AdPrepareListener(MediaItem mediaItem) {
            this.adMediaItem = mediaItem;
        }

        @Override // androidx.media3.exoplayer.source.MaskingMediaPeriod.PrepareListener
        public void onPrepareComplete(final MediaSource.MediaPeriodId mediaPeriodId) {
            AdsMediaSource.this.mainHandler.post(new Runnable() { // from class: androidx.media3.exoplayer.source.ads.AdsMediaSource$AdPrepareListener$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m10562x672fc1f4(mediaPeriodId);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onPrepareComplete$0$androidx-media3-exoplayer-source-ads-AdsMediaSource$AdPrepareListener, reason: not valid java name */
        /* synthetic */ void m10562x672fc1f4(MediaSource.MediaPeriodId mediaPeriodId) {
            AdsMediaSource.this.adsLoader.handlePrepareComplete(AdsMediaSource.this, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
        }

        @Override // androidx.media3.exoplayer.source.MaskingMediaPeriod.PrepareListener
        public void onPrepareError(final MediaSource.MediaPeriodId mediaPeriodId, final IOException iOException) {
            AdsMediaSource.this.createEventDispatcher(mediaPeriodId).loadError(new LoadEventInfo(LoadEventInfo.getNewId(), new DataSpec(((MediaItem.LocalConfiguration) Preconditions.checkNotNull(this.adMediaItem.localConfiguration)).uri), SystemClock.elapsedRealtime()), 6, (IOException) AdLoadException.createForAd(iOException), true);
            AdsMediaSource.this.mainHandler.post(new Runnable() { // from class: androidx.media3.exoplayer.source.ads.AdsMediaSource$AdPrepareListener$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m10563xa9898f8e(mediaPeriodId, iOException);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onPrepareError$1$androidx-media3-exoplayer-source-ads-AdsMediaSource$AdPrepareListener, reason: not valid java name */
        /* synthetic */ void m10563xa9898f8e(MediaSource.MediaPeriodId mediaPeriodId, IOException iOException) {
            AdsMediaSource.this.adsLoader.handlePrepareError(AdsMediaSource.this, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup, iOException);
        }
    }

    private final class AdMediaSourceHolder {
        private final List<MediaPeriod> activeMediaPeriods;
        private MediaItem adMediaItem;
        private MediaSource adMediaSource;
        private long endPositionUs;
        private final MediaSource.MediaPeriodId id;
        private Timeline timeline;

        private AdMediaSourceHolder(MediaSource.MediaPeriodId mediaPeriodId, long j) {
            this.id = mediaPeriodId;
            this.endPositionUs = j;
            this.activeMediaPeriods = new ArrayList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void initializeWithMediaSource(MediaSource mediaSource, MediaItem mediaItem) {
            this.adMediaSource = mediaSource;
            this.adMediaItem = mediaItem;
            for (int i = 0; i < this.activeMediaPeriods.size(); i++) {
                MaskingMediaPeriod activeMaskingMediaPeriod = getActiveMaskingMediaPeriod(i);
                activeMaskingMediaPeriod.setMediaSource(mediaSource);
                activeMaskingMediaPeriod.setPrepareListener(AdsMediaSource.this.new AdPrepareListener(mediaItem));
            }
            AdsMediaSource.this.prepareChildSource(this.id, mediaSource);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MediaPeriod createMediaPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j, boolean z) {
            MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(mediaPeriodId, allocator, j);
            MediaPeriod clippingMediaPeriod = z ? new ClippingMediaPeriod(maskingMediaPeriod, false, j, this.endPositionUs) : maskingMediaPeriod;
            this.activeMediaPeriods.add(clippingMediaPeriod);
            MediaSource mediaSource = this.adMediaSource;
            if (mediaSource != null) {
                maskingMediaPeriod.setMediaSource(mediaSource);
                maskingMediaPeriod.setPrepareListener(AdsMediaSource.this.new AdPrepareListener((MediaItem) Preconditions.checkNotNull(this.adMediaItem)));
            }
            Timeline timeline = this.timeline;
            if (timeline != null) {
                maskingMediaPeriod.createPeriod(new MediaSource.MediaPeriodId(timeline.getUidOfPeriod(0), mediaPeriodId.windowSequenceNumber));
            }
            return clippingMediaPeriod;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleSourceInfoRefresh(Timeline timeline) {
            Preconditions.checkArgument(timeline.getPeriodCount() == 1);
            if (this.timeline == null) {
                Object uidOfPeriod = timeline.getUidOfPeriod(0);
                for (int i = 0; i < this.activeMediaPeriods.size(); i++) {
                    MaskingMediaPeriod activeMaskingMediaPeriod = getActiveMaskingMediaPeriod(i);
                    activeMaskingMediaPeriod.createPeriod(new MediaSource.MediaPeriodId(uidOfPeriod, activeMaskingMediaPeriod.id.windowSequenceNumber));
                }
                setEndPositionUs(this.endPositionUs);
            }
            this.timeline = timeline;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndPositionUs(long j) {
            if (AdsMediaSource.this.useAdMediaSourceClipping && this.endPositionUs == Long.MIN_VALUE && j != Long.MIN_VALUE) {
                this.endPositionUs = j;
                for (int i = 0; i < this.activeMediaPeriods.size(); i++) {
                    if (this.activeMediaPeriods.get(i) instanceof ClippingMediaPeriod) {
                        ((ClippingMediaPeriod) this.activeMediaPeriods.get(i)).updateClipping(0L, j);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long getDurationUs() {
            Timeline timeline = this.timeline;
            if (timeline == null) {
                return -9223372036854775807L;
            }
            return timeline.getPeriod(0, AdsMediaSource.this.period).getDurationUs();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void releaseMediaPeriod(MediaPeriod mediaPeriod) {
            this.activeMediaPeriods.remove(mediaPeriod);
            if (mediaPeriod instanceof ClippingMediaPeriod) {
                mediaPeriod = ((ClippingMediaPeriod) mediaPeriod).mediaPeriod;
            }
            ((MaskingMediaPeriod) mediaPeriod).releasePeriod();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void release() {
            if (hasMediaSource()) {
                AdsMediaSource.this.releaseChildSource(this.id);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasMediaSource() {
            return this.adMediaSource != null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isInactive() {
            return this.activeMediaPeriods.isEmpty();
        }

        private MaskingMediaPeriod getActiveMaskingMediaPeriod(int i) {
            MediaPeriod mediaPeriod = this.activeMediaPeriods.get(i);
            if (mediaPeriod instanceof ClippingMediaPeriod) {
                mediaPeriod = ((ClippingMediaPeriod) mediaPeriod).mediaPeriod;
            }
            return (MaskingMediaPeriod) mediaPeriod;
        }
    }
}
