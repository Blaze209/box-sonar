package com.box.android.preview.preview;

import android.content.Context;
import com.box.android.base.compose.DefaultAvatarControllerWrapper;
import com.box.android.coreservices.models.CustomBoxSession;
import com.box.android.domain.configuration.ConfigManager;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.models.ItemId;
import com.box.android.preview.annotations.managers.AnnotationManagersProvider;
import com.box.android.preview.annotations.managers.BoxPdfAnnotationManager;
import com.box.android.preview.annotations.managers.CreateAnnotationsManager;
import com.box.android.preview.previewtype.audio.Media3AudioPlayerManager;
import com.box.android.preview.previewtype.document.DocumentPreviewEnvironment;
import com.box.android.preview.previewtype.document.copytext.TextSelectionManager;
import com.box.android.preview.previewtype.document.search.TextSearchManager;
import com.box.android.preview.previewtype.video.Media3VideoPlayerManager;
import com.box.android.preview.previewtype.video.VideoMediaSourceFactory;
import com.box.android.preview.previewtype.video.VideoPlayersProvider;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.views.DefaultAvatarController;
import com.pspdfkit.ui.search.SearchResultHighlighter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewUIDependencyProvider.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202J\u000e\u00103\u001a\u0002042\u0006\u00101\u001a\u000202J\u0006\u00105\u001a\u000206J\u0006\u00107\u001a\u000208J\u0006\u00109\u001a\u00020\u001dJ\u0006\u0010:\u001a\u00020#J\u0006\u0010;\u001a\u00020#J\u000e\u0010<\u001a\n >*\u0004\u0018\u00010=0=J\u0006\u0010?\u001a\u00020\u0007J\u0006\u0010@\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b$\u0010%R\u001b\u0010'\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010!\u001a\u0004\b(\u0010%R\u001b\u0010*\u001a\u00020+8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b.\u0010!\u001a\u0004\b,\u0010-¨\u0006A"}, d2 = {"Lcom/box/android/preview/preview/PreviewUIDependencyProvider;", "", "context", "Landroid/content/Context;", "session", "Lcom/box/android/coreservices/models/CustomBoxSession;", "audioPlayerManager", "Lcom/box/android/preview/previewtype/audio/Media3AudioPlayerManager;", "documentPreviewEnvironment", "Lcom/box/android/preview/previewtype/document/DocumentPreviewEnvironment;", "videoPlayersProvider", "Lcom/box/android/preview/previewtype/video/VideoPlayersProvider;", "videoMediaSourceFactory", "Lcom/box/android/preview/previewtype/video/VideoMediaSourceFactory;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "configManager", "Lcom/box/android/domain/configuration/ConfigManager;", "<init>", "(Landroid/content/Context;Lcom/box/android/coreservices/models/CustomBoxSession;Lcom/box/android/preview/previewtype/audio/Media3AudioPlayerManager;Lcom/box/android/preview/previewtype/document/DocumentPreviewEnvironment;Lcom/box/android/preview/previewtype/video/VideoPlayersProvider;Lcom/box/android/preview/previewtype/video/VideoMediaSourceFactory;Lcom/box/android/domain/configuration/FeatureFlips;Lcom/box/android/domain/configuration/ConfigManager;)V", "getSession", "()Lcom/box/android/coreservices/models/CustomBoxSession;", "getVideoPlayersProvider", "()Lcom/box/android/preview/previewtype/video/VideoPlayersProvider;", "annotationManagersProvider", "Lcom/box/android/preview/annotations/managers/AnnotationManagersProvider;", "getAnnotationManagersProvider", "()Lcom/box/android/preview/annotations/managers/AnnotationManagersProvider;", "avatarControllerWrapper", "Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;", "getAvatarControllerWrapper", "()Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;", "avatarControllerWrapper$delegate", "Lkotlin/Lazy;", "searchResultsHighlighter", "Lcom/pspdfkit/ui/search/SearchResultHighlighter;", "getSearchResultsHighlighter", "()Lcom/pspdfkit/ui/search/SearchResultHighlighter;", "searchResultsHighlighter$delegate", "citationResultsHighlighter", "getCitationResultsHighlighter", "citationResultsHighlighter$delegate", "videoPlayerManager", "Lcom/box/android/preview/previewtype/video/Media3VideoPlayerManager;", "getVideoPlayerManager", "()Lcom/box/android/preview/previewtype/video/Media3VideoPlayerManager;", "videoPlayerManager$delegate", "getCreateAnnotationManager", "Lcom/box/android/preview/annotations/managers/CreateAnnotationsManager;", "itemId", "Lcom/box/android/domain/models/ItemId;", "getPdfAnnotationManager", "Lcom/box/android/preview/annotations/managers/BoxPdfAnnotationManager;", "getTextSelectionManager", "Lcom/box/android/preview/previewtype/document/copytext/TextSelectionManager;", "getTextSearchManager", "Lcom/box/android/preview/previewtype/document/search/TextSearchManager;", "getAvatarWrapper", "getSearchResultHighlighter", "getCitationResultHighlighter", "getCurrentUser", "Lcom/box/androidsdk/content/models/BoxUser;", "kotlin.jvm.PlatformType", "getAudioPlayerManager", "getConfigManager", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewUIDependencyProvider {
    public static final int $stable = 0;
    private final AnnotationManagersProvider annotationManagersProvider;
    private final Media3AudioPlayerManager audioPlayerManager;

    /* JADX INFO: renamed from: avatarControllerWrapper$delegate, reason: from kotlin metadata */
    private final Lazy avatarControllerWrapper;

    /* JADX INFO: renamed from: citationResultsHighlighter$delegate, reason: from kotlin metadata */
    private final Lazy citationResultsHighlighter;
    private final ConfigManager configManager;
    private final Context context;
    private final DocumentPreviewEnvironment documentPreviewEnvironment;
    private final FeatureFlips featureFlips;

    /* JADX INFO: renamed from: searchResultsHighlighter$delegate, reason: from kotlin metadata */
    private final Lazy searchResultsHighlighter;
    private final CustomBoxSession session;
    private final VideoMediaSourceFactory videoMediaSourceFactory;

    /* JADX INFO: renamed from: videoPlayerManager$delegate, reason: from kotlin metadata */
    private final Lazy videoPlayerManager;
    private final VideoPlayersProvider videoPlayersProvider;

    public PreviewUIDependencyProvider(Context context, CustomBoxSession session, Media3AudioPlayerManager audioPlayerManager, DocumentPreviewEnvironment documentPreviewEnvironment, VideoPlayersProvider videoPlayersProvider, VideoMediaSourceFactory videoMediaSourceFactory, FeatureFlips featureFlips, ConfigManager configManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(audioPlayerManager, "audioPlayerManager");
        Intrinsics.checkNotNullParameter(documentPreviewEnvironment, "documentPreviewEnvironment");
        Intrinsics.checkNotNullParameter(videoPlayersProvider, "videoPlayersProvider");
        Intrinsics.checkNotNullParameter(videoMediaSourceFactory, "videoMediaSourceFactory");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        Intrinsics.checkNotNullParameter(configManager, "configManager");
        this.context = context;
        this.session = session;
        this.audioPlayerManager = audioPlayerManager;
        this.documentPreviewEnvironment = documentPreviewEnvironment;
        this.videoPlayersProvider = videoPlayersProvider;
        this.videoMediaSourceFactory = videoMediaSourceFactory;
        this.featureFlips = featureFlips;
        this.configManager = configManager;
        this.annotationManagersProvider = documentPreviewEnvironment.getAnnotationsEnvironment().getAnnotationManagersProvider();
        this.avatarControllerWrapper = LazyKt.lazy(new Function0() { // from class: com.box.android.preview.preview.PreviewUIDependencyProvider$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PreviewUIDependencyProvider.avatarControllerWrapper_delegate$lambda$0(this.f$0);
            }
        });
        this.searchResultsHighlighter = LazyKt.lazy(new Function0() { // from class: com.box.android.preview.preview.PreviewUIDependencyProvider$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PreviewUIDependencyProvider.searchResultsHighlighter_delegate$lambda$0(this.f$0);
            }
        });
        this.citationResultsHighlighter = LazyKt.lazy(new Function0() { // from class: com.box.android.preview.preview.PreviewUIDependencyProvider$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PreviewUIDependencyProvider.citationResultsHighlighter_delegate$lambda$0(this.f$0);
            }
        });
        this.videoPlayerManager = LazyKt.lazy(new Function0() { // from class: com.box.android.preview.preview.PreviewUIDependencyProvider$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PreviewUIDependencyProvider.videoPlayerManager_delegate$lambda$0(this.f$0);
            }
        });
    }

    public final CustomBoxSession getSession() {
        return this.session;
    }

    public final VideoPlayersProvider getVideoPlayersProvider() {
        return this.videoPlayersProvider;
    }

    public final AnnotationManagersProvider getAnnotationManagersProvider() {
        return this.annotationManagersProvider;
    }

    private final DefaultAvatarControllerWrapper getAvatarControllerWrapper() {
        return (DefaultAvatarControllerWrapper) this.avatarControllerWrapper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DefaultAvatarControllerWrapper avatarControllerWrapper_delegate$lambda$0(PreviewUIDependencyProvider previewUIDependencyProvider) {
        return new DefaultAvatarControllerWrapper(new DefaultAvatarController(previewUIDependencyProvider.session));
    }

    private final SearchResultHighlighter getSearchResultsHighlighter() {
        return (SearchResultHighlighter) this.searchResultsHighlighter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchResultHighlighter searchResultsHighlighter_delegate$lambda$0(PreviewUIDependencyProvider previewUIDependencyProvider) {
        return new SearchResultHighlighter(previewUIDependencyProvider.context);
    }

    private final SearchResultHighlighter getCitationResultsHighlighter() {
        return (SearchResultHighlighter) this.citationResultsHighlighter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchResultHighlighter citationResultsHighlighter_delegate$lambda$0(PreviewUIDependencyProvider previewUIDependencyProvider) {
        return new SearchResultHighlighter(previewUIDependencyProvider.context);
    }

    public final Media3VideoPlayerManager getVideoPlayerManager() {
        return (Media3VideoPlayerManager) this.videoPlayerManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Media3VideoPlayerManager videoPlayerManager_delegate$lambda$0(PreviewUIDependencyProvider previewUIDependencyProvider) {
        return new Media3VideoPlayerManager(previewUIDependencyProvider.context, previewUIDependencyProvider.videoMediaSourceFactory);
    }

    public final CreateAnnotationsManager getCreateAnnotationManager(ItemId itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        return this.annotationManagersProvider.getCreateAnnotationManager(itemId);
    }

    public final BoxPdfAnnotationManager getPdfAnnotationManager(ItemId itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        return this.annotationManagersProvider.getPdfAnnotationManager(itemId);
    }

    public final TextSelectionManager getTextSelectionManager() {
        return this.documentPreviewEnvironment.getCopyTextEnvironment().getTextSelectionManager();
    }

    public final TextSearchManager getTextSearchManager() {
        return this.documentPreviewEnvironment.getSearchEnvironment().getTextSearchManager();
    }

    public final DefaultAvatarControllerWrapper getAvatarWrapper() {
        return getAvatarControllerWrapper();
    }

    public final SearchResultHighlighter getSearchResultHighlighter() {
        return getSearchResultsHighlighter();
    }

    public final SearchResultHighlighter getCitationResultHighlighter() {
        return getCitationResultsHighlighter();
    }

    public final BoxUser getCurrentUser() {
        BoxUser user = this.session.getUser();
        return user == null ? BoxUser.createFromId("-1") : user;
    }

    public final Media3AudioPlayerManager getAudioPlayerManager() {
        return this.audioPlayerManager;
    }

    public final ConfigManager getConfigManager() {
        return this.configManager;
    }
}
