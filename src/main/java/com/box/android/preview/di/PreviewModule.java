package com.box.android.preview.di;

import android.content.Context;
import com.box.android.base.cpl.ClipboardService;
import com.box.android.base.cpl.IClipboardService;
import com.box.android.base.cpl.IItemNameValidator;
import com.box.android.base.cpl.ItemNameValidator;
import com.box.android.boxai.voice.ISpeechRecognitionManager;
import com.box.android.boxai.voice.SpeechRecognitionManager;
import com.box.android.coreservices.models.CustomBoxSession;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.identity.PreviewExecutor;
import com.box.android.preview.BoxPreviewExecutor;
import com.box.android.preview.integration.media3.Media3DataSourceFactory;
import com.box.android.preview.integration.media3.WatermarkResolvingDataSourceFactory;
import com.box.android.preview.item.IScrollableFileTypeResolver;
import com.box.android.preview.item.ScrollableFileTypeResolver;
import com.box.android.preview.previewtype.video.VideoMediaSourceFactory;
import com.box.android.preview.wopi.IOfficeAppDetector;
import com.box.android.preview.wopi.IWopiService;
import com.box.android.preview.wopi.OfficeAppDetector;
import com.box.android.preview.wopi.WopiService;
import com.box.androidsdk.content.models.BoxSession;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewModule.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH'J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H'J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H'J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH'¨\u0006\u001d"}, d2 = {"Lcom/box/android/preview/di/PreviewModule;", "", "<init>", "()V", "providesScrollableFileTypeResolver", "Lcom/box/android/preview/item/IScrollableFileTypeResolver;", "scrollableFileTypeResolver", "Lcom/box/android/preview/item/ScrollableFileTypeResolver;", "providesItemNameValidator", "Lcom/box/android/base/cpl/IItemNameValidator;", "itemNameValidator", "Lcom/box/android/base/cpl/ItemNameValidator;", "providesClipboardService", "Lcom/box/android/base/cpl/IClipboardService;", "clipboardService", "Lcom/box/android/base/cpl/ClipboardService;", "providesSpeechRecognitionManager", "Lcom/box/android/boxai/voice/ISpeechRecognitionManager;", "speechRecognitionManager", "Lcom/box/android/boxai/voice/SpeechRecognitionManager;", "providesWopiService", "Lcom/box/android/preview/wopi/IWopiService;", "wopiService", "Lcom/box/android/preview/wopi/WopiService;", "providesOfficeAppDetector", "Lcom/box/android/preview/wopi/IOfficeAppDetector;", "officeAppDetector", "Lcom/box/android/preview/wopi/OfficeAppDetector;", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public abstract class PreviewModule {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Binds
    public abstract IClipboardService providesClipboardService(ClipboardService clipboardService);

    @Binds
    public abstract IItemNameValidator providesItemNameValidator(ItemNameValidator itemNameValidator);

    @Binds
    public abstract IOfficeAppDetector providesOfficeAppDetector(OfficeAppDetector officeAppDetector);

    @Binds
    public abstract IScrollableFileTypeResolver providesScrollableFileTypeResolver(ScrollableFileTypeResolver scrollableFileTypeResolver);

    @Binds
    public abstract ISpeechRecognitionManager providesSpeechRecognitionManager(SpeechRecognitionManager speechRecognitionManager);

    @Binds
    public abstract IWopiService providesWopiService(WopiService wopiService);

    /* JADX INFO: compiled from: PreviewModule.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/di/PreviewModule$Companion;", "", "<init>", "()V", "provideVideoMediaSourceFactory", "Lcom/box/android/preview/previewtype/video/VideoMediaSourceFactory;", "context", "Landroid/content/Context;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "media3DataSourceFactory", "Lcom/box/android/preview/integration/media3/Media3DataSourceFactory;", "watermarkDataSourceFactory", "Lcom/box/android/preview/integration/media3/WatermarkResolvingDataSourceFactory;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "providePreviewExecutor", "Lcom/box/android/domain/identity/PreviewExecutor;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Provides
        public final VideoMediaSourceFactory provideVideoMediaSourceFactory(Context context, IUserContextManager userContextManager, Media3DataSourceFactory media3DataSourceFactory, WatermarkResolvingDataSourceFactory watermarkDataSourceFactory, FeatureFlips featureFlips) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            Intrinsics.checkNotNullParameter(media3DataSourceFactory, "media3DataSourceFactory");
            Intrinsics.checkNotNullParameter(watermarkDataSourceFactory, "watermarkDataSourceFactory");
            Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
            BoxSession boxSession = userContextManager.getBoxSession(context);
            Intrinsics.checkNotNull(boxSession, "null cannot be cast to non-null type com.box.android.coreservices.models.CustomBoxSession");
            return new VideoMediaSourceFactory((CustomBoxSession) boxSession, media3DataSourceFactory, watermarkDataSourceFactory, featureFlips);
        }

        @Provides
        @Named("preview-executor")
        public final PreviewExecutor providePreviewExecutor(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new BoxPreviewExecutor(context, 3, 3, 10L, TimeUnit.MINUTES, new LinkedBlockingDeque<Runnable>() { // from class: com.box.android.preview.di.PreviewModule$Companion$providePreviewExecutor$1
                @Override // java.util.concurrent.LinkedBlockingDeque, java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
                public final /* bridge */ boolean contains(Object obj) {
                    if (obj == null ? true : obj instanceof Runnable) {
                        return contains((Runnable) obj);
                    }
                    return false;
                }

                public /* bridge */ boolean contains(Runnable runnable) {
                    return super.contains((Object) runnable);
                }

                public /* bridge */ int getSize() {
                    return super.size();
                }

                @Override // java.util.concurrent.LinkedBlockingDeque, java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
                public final /* bridge */ boolean remove(Object obj) {
                    if (obj == null ? true : obj instanceof Runnable) {
                        return remove((Runnable) obj);
                    }
                    return false;
                }

                public /* bridge */ boolean remove(Runnable runnable) {
                    return super.remove((Object) runnable);
                }

                @Override // java.util.concurrent.LinkedBlockingDeque, java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingDeque, java.util.Deque
                public final /* bridge */ int size() {
                    return getSize();
                }

                @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
                public final boolean offer(Runnable runnable) {
                    Intrinsics.checkNotNullParameter(runnable, "runnable");
                    return super.offerFirst(runnable);
                }
            });
        }
    }
}
