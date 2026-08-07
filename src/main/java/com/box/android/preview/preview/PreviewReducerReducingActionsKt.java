package com.box.android.preview.preview;

import com.box.android.base.presentation.components.commentbar.TimestampedCommentConfig;
import com.box.android.boxai.BoxAiReducer;
import com.box.android.cpl.Effect;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.models.item.FileVersionMiniModel;
import com.box.android.preview.fileactions.FileAction;
import com.box.android.preview.fileactions.FileActionsReducer;
import com.box.android.preview.item.ItemPreviewReducer;
import com.box.android.preview.item.ItemState;
import com.box.android.preview.previewtype.document.CitationHighlightReducer;
import com.box.android.preview.previewtype.document.DisplayMode;
import com.box.android.preview.previewtype.document.DocumentPreviewReducer;
import com.box.android.preview.routing.CloseSource;
import com.box.android.preview.routing.PreviewRoute;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewReducerReducingActions.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"reduceFileActions", "Lcom/box/android/cpl/ReducerResult;", "Lcom/box/android/preview/preview/PreviewReducer$State;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "state", Analytics.Data.ACTION, "Lcom/box/android/preview/fileactions/FileActionsReducer$Action;", "environment", "Lcom/box/android/preview/preview/PreviewEnvironment;", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PreviewReducerReducingActionsKt {

    /* JADX INFO: compiled from: PreviewReducerReducingActions.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FileAction.values().length];
            try {
                iArr[FileAction.PageView.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FileAction.ThumbnailsView.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FileAction.OutlineView.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FileAction.Search.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FileAction.Print.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FileAction.AddAnnotations.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0087  */
    public static final ReducerResult<PreviewReducer.State, PreviewReducer.Action> reduceFileActions(PreviewReducer.State state, FileActionsReducer.Action action, PreviewEnvironment environment) {
        Effect effectNone;
        DocumentPreviewReducer.Action.SwitchDisplayMode switchDisplayMode;
        Effect effectNone2;
        PreviewRoute.FileActivities route;
        String id;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(environment, "environment");
        if (action instanceof FileActionsReducer.Action.Navigate) {
            if (state.getItemState() instanceof ItemState.Video) {
                FileActionsReducer.Action.Navigate navigate = (FileActionsReducer.Action.Navigate) action;
                if ((navigate.getRoute() instanceof PreviewRoute.FileActivities) && environment.getFeatureFlips().getVideoAnnotations().getEnabled()) {
                    long currentPosition = environment.getItemPreviewEnvironment().getVideoPreviewEnvironment().getVideoPlayerInteractor().getCurrentPosition(state.getFileModel().getItemId());
                    PreviewRoute.FileActivities fileActivities = (PreviewRoute.FileActivities) navigate.getRoute();
                    FileVersionMiniModel fileVersion = state.getFileModel().getFileVersion();
                    route = PreviewRoute.FileActivities.copy$default(fileActivities, null, (fileVersion == null || (id = fileVersion.getId()) == null) ? null : new TimestampedCommentConfig(false, currentPosition, id, null, null, false, 56, null), 1, null);
                } else {
                    route = ((FileActionsReducer.Action.Navigate) action).getRoute();
                }
            } else {
                route = ((FileActionsReducer.Action.Navigate) action).getRoute();
            }
            return new ReducerResult<>(PreviewReducer.State.copy$default(state, null, null, null, false, null, null, null, null, false, route, false, false, 3583, null), null, 2, null);
        }
        if (action instanceof FileActionsReducer.Action.ClosePreview) {
            return new ReducerResult<>(PreviewReducer.State.copy$default(state, null, null, null, false, null, null, null, CloseSource.Delete.INSTANCE, false, null, false, false, 3967, null), null, 2, null);
        }
        if (action instanceof FileActionsReducer.Action.UpdateActions) {
            return new ReducerResult<>(state, Effect.INSTANCE.merge(PreviewReducerHelpersKt.update(PreviewReducer.Action.BottomBarAction.INSTANCE, state), PreviewReducerHelpersKt.update(PreviewReducer.Action.TopBarAction.INSTANCE, state)));
        }
        if (action instanceof FileActionsReducer.Action.DocumentPreviewAction) {
            int i = WhenMappings.$EnumSwitchMapping$0[((FileActionsReducer.Action.DocumentPreviewAction) action).getAction().ordinal()];
            if (i == 1) {
                switchDisplayMode = new DocumentPreviewReducer.Action.SwitchDisplayMode(DisplayMode.FullItem);
            } else if (i == 2) {
                switchDisplayMode = new DocumentPreviewReducer.Action.SwitchDisplayMode(DisplayMode.Thumbnails);
            } else if (i == 3) {
                switchDisplayMode = new DocumentPreviewReducer.Action.SwitchDisplayMode(DisplayMode.Outline);
            } else if (i == 4) {
                switchDisplayMode = DocumentPreviewReducer.Action.SearchDocumentClicked.INSTANCE;
            } else {
                switchDisplayMode = i != 5 ? null : DocumentPreviewReducer.Action.StartPrint.INSTANCE;
            }
            if (switchDisplayMode != null) {
                effectNone2 = new Effect(PreviewReducerHelpersKt.document(PreviewReducer.Action.SelectedItem.INSTANCE, switchDisplayMode));
            } else {
                effectNone2 = Effect.INSTANCE.none();
            }
            return new ReducerResult<>(state, effectNone2);
        }
        if (action instanceof FileActionsReducer.Action.ItemPreviewAction) {
            if (WhenMappings.$EnumSwitchMapping$0[((FileActionsReducer.Action.ItemPreviewAction) action).getAction().ordinal()] == 6) {
                effectNone = new Effect(new PreviewReducer.Action.SelectedItem(ItemPreviewReducer.Action.EnterAnnotationCreation.INSTANCE));
            } else {
                effectNone = Effect.INSTANCE.none();
            }
            return new ReducerResult<>(state, effectNone);
        }
        if (action instanceof FileActionsReducer.Action.BoxAi) {
            FileActionsReducer.Action.BoxAi boxAi = (FileActionsReducer.Action.BoxAi) action;
            BoxAiReducer.Action action2 = boxAi.getAction();
            if (action2 instanceof BoxAiReducer.Action.UpdateAppAlertAccepted) {
                return new ReducerResult<>(state, new Effect(new PreviewReducer.Action.Navigate(PreviewRoute.UpdateApp.INSTANCE)));
            }
            if (action2 instanceof BoxAiReducer.Action.HighlightCitation) {
                return new ReducerResult<>(state, new Effect(new PreviewReducer.Action.Items(state.getSelectedItemId(), new ItemPreviewReducer.Action.DocumentPreview(new DocumentPreviewReducer.Action.Citations(new CitationHighlightReducer.Action.HighlightText(((BoxAiReducer.Action.HighlightCitation) boxAi.getAction()).getCitation()))))));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }
}
