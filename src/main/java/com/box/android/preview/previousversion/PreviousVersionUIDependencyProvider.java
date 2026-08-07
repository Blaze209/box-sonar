package com.box.android.preview.previousversion;

import android.content.Context;
import com.box.android.domain.models.ItemId;
import com.box.android.preview.annotations.managers.AnnotationManagersProvider;
import com.box.android.preview.annotations.managers.BoxPdfAnnotationManager;
import com.box.android.preview.annotations.managers.CreateAnnotationsManager;
import com.box.android.preview.previewtype.document.DocumentPreviewEnvironment;
import com.box.android.preview.previewtype.document.copytext.TextSelectionManager;
import com.box.android.preview.previewtype.document.search.TextSearchManager;
import com.box.android.preview.previewtype.video.Media3VideoPlayerManager;
import com.box.android.preview.previewtype.video.VideoMediaSourceFactory;
import com.box.android.preview.previewtype.video.VideoPlayersProvider;
import com.pspdfkit.ui.search.SearchResultHighlighter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviousVersionUIDependencyProvider.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020%2\u0006\u0010\"\u001a\u00020#J\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020\u0013J\u0006\u0010+\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u0019\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u001c8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b\u001d\u0010\u001e¨\u0006,"}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionUIDependencyProvider;", "", "context", "Landroid/content/Context;", "documentPreviewEnvironment", "Lcom/box/android/preview/previewtype/document/DocumentPreviewEnvironment;", "videoPlayersProvider", "Lcom/box/android/preview/previewtype/video/VideoPlayersProvider;", "videoMediaSourceFactory", "Lcom/box/android/preview/previewtype/video/VideoMediaSourceFactory;", "<init>", "(Landroid/content/Context;Lcom/box/android/preview/previewtype/document/DocumentPreviewEnvironment;Lcom/box/android/preview/previewtype/video/VideoPlayersProvider;Lcom/box/android/preview/previewtype/video/VideoMediaSourceFactory;)V", "getVideoPlayersProvider", "()Lcom/box/android/preview/previewtype/video/VideoPlayersProvider;", "annotationManagersProvider", "Lcom/box/android/preview/annotations/managers/AnnotationManagersProvider;", "getAnnotationManagersProvider", "()Lcom/box/android/preview/annotations/managers/AnnotationManagersProvider;", "searchResultsHighlighter", "Lcom/pspdfkit/ui/search/SearchResultHighlighter;", "getSearchResultsHighlighter", "()Lcom/pspdfkit/ui/search/SearchResultHighlighter;", "searchResultsHighlighter$delegate", "Lkotlin/Lazy;", "citationResultsHighlighter", "getCitationResultsHighlighter", "citationResultsHighlighter$delegate", "videoPlayerManager", "Lcom/box/android/preview/previewtype/video/Media3VideoPlayerManager;", "getVideoPlayerManager", "()Lcom/box/android/preview/previewtype/video/Media3VideoPlayerManager;", "videoPlayerManager$delegate", "getCreateAnnotationManager", "Lcom/box/android/preview/annotations/managers/CreateAnnotationsManager;", "itemId", "Lcom/box/android/domain/models/ItemId;", "getPdfAnnotationManager", "Lcom/box/android/preview/annotations/managers/BoxPdfAnnotationManager;", "getTextSelectionManager", "Lcom/box/android/preview/previewtype/document/copytext/TextSelectionManager;", "getTextSearchManager", "Lcom/box/android/preview/previewtype/document/search/TextSearchManager;", "getSearchResultHighlighter", "getCitationResultHighlighter", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviousVersionUIDependencyProvider {
    public static final int $stable = 0;
    private final AnnotationManagersProvider annotationManagersProvider;

    /* JADX INFO: renamed from: citationResultsHighlighter$delegate, reason: from kotlin metadata */
    private final Lazy citationResultsHighlighter;
    private final Context context;
    private final DocumentPreviewEnvironment documentPreviewEnvironment;

    /* JADX INFO: renamed from: searchResultsHighlighter$delegate, reason: from kotlin metadata */
    private final Lazy searchResultsHighlighter;
    private final VideoMediaSourceFactory videoMediaSourceFactory;

    /* JADX INFO: renamed from: videoPlayerManager$delegate, reason: from kotlin metadata */
    private final Lazy videoPlayerManager;
    private final VideoPlayersProvider videoPlayersProvider;

    public PreviousVersionUIDependencyProvider(Context context, DocumentPreviewEnvironment documentPreviewEnvironment, VideoPlayersProvider videoPlayersProvider, VideoMediaSourceFactory videoMediaSourceFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(documentPreviewEnvironment, "documentPreviewEnvironment");
        Intrinsics.checkNotNullParameter(videoPlayersProvider, "videoPlayersProvider");
        Intrinsics.checkNotNullParameter(videoMediaSourceFactory, "videoMediaSourceFactory");
        this.context = context;
        this.documentPreviewEnvironment = documentPreviewEnvironment;
        this.videoPlayersProvider = videoPlayersProvider;
        this.videoMediaSourceFactory = videoMediaSourceFactory;
        this.annotationManagersProvider = documentPreviewEnvironment.getAnnotationsEnvironment().getAnnotationManagersProvider();
        this.searchResultsHighlighter = LazyKt.lazy(new Function0() { // from class: com.box.android.preview.previousversion.PreviousVersionUIDependencyProvider$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PreviousVersionUIDependencyProvider.searchResultsHighlighter_delegate$lambda$0(this.f$0);
            }
        });
        this.citationResultsHighlighter = LazyKt.lazy(new Function0() { // from class: com.box.android.preview.previousversion.PreviousVersionUIDependencyProvider$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PreviousVersionUIDependencyProvider.citationResultsHighlighter_delegate$lambda$0(this.f$0);
            }
        });
        this.videoPlayerManager = LazyKt.lazy(new Function0() { // from class: com.box.android.preview.previousversion.PreviousVersionUIDependencyProvider$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PreviousVersionUIDependencyProvider.videoPlayerManager_delegate$lambda$0(this.f$0);
            }
        });
    }

    public final VideoPlayersProvider getVideoPlayersProvider() {
        return this.videoPlayersProvider;
    }

    public final AnnotationManagersProvider getAnnotationManagersProvider() {
        return this.annotationManagersProvider;
    }

    private final SearchResultHighlighter getSearchResultsHighlighter() {
        return (SearchResultHighlighter) this.searchResultsHighlighter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchResultHighlighter searchResultsHighlighter_delegate$lambda$0(PreviousVersionUIDependencyProvider previousVersionUIDependencyProvider) {
        return new SearchResultHighlighter(previousVersionUIDependencyProvider.context);
    }

    private final SearchResultHighlighter getCitationResultsHighlighter() {
        return (SearchResultHighlighter) this.citationResultsHighlighter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchResultHighlighter citationResultsHighlighter_delegate$lambda$0(PreviousVersionUIDependencyProvider previousVersionUIDependencyProvider) {
        return new SearchResultHighlighter(previousVersionUIDependencyProvider.context);
    }

    public final Media3VideoPlayerManager getVideoPlayerManager() {
        return (Media3VideoPlayerManager) this.videoPlayerManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Media3VideoPlayerManager videoPlayerManager_delegate$lambda$0(PreviousVersionUIDependencyProvider previousVersionUIDependencyProvider) {
        return new Media3VideoPlayerManager(previousVersionUIDependencyProvider.context, previousVersionUIDependencyProvider.videoMediaSourceFactory);
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

    public final SearchResultHighlighter getSearchResultHighlighter() {
        return getSearchResultsHighlighter();
    }

    public final SearchResultHighlighter getCitationResultHighlighter() {
        return getCitationResultsHighlighter();
    }
}
