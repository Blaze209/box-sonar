package com.box.android.preview.preview;

import androidx.media3.common.MimeTypes;
import com.box.android.cpl.IdentifiedListKt;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.preview.annotations.cpl.AnnotationsReducer;
import com.box.android.preview.annotations.cpl.CreateAnnotationReducer;
import com.box.android.preview.fileactions.FileAction;
import com.box.android.preview.fileactions.FileActionsReducer;
import com.box.android.preview.fileactions.UpdateItemInfoReducer;
import com.box.android.preview.item.ItemPreviewReducer;
import com.box.android.preview.item.ItemState;
import com.box.android.preview.preview.previewbar.bottombar.BottomBarReducer;
import com.box.android.preview.preview.previewbar.topbar.TopBarReducer;
import com.box.android.preview.previewtype.boxnote.BoxNoteEditModeReducer;
import com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer;
import com.box.android.preview.previewtype.document.DocumentPreviewReducer;
import com.box.android.preview.previewtype.document.search.DocumentSearchReducer;
import com.box.android.preview.previewtype.image.ImagePreviewReducer;
import com.box.android.preview.previewtype.video.FrameAnnotationReducer;
import com.box.android.preview.previewtype.video.VideoPreviewReducer;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewReducerHelpers.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u001a\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\b\u001a\u0012\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\n\u001a\u0012\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\f\u001a\u0012\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000e\u001a\u0012\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0010\u001a\u0012\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u0012\u0010\u0016\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u0012\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u001c\u001a\n\u0010\u001d\u001a\u00020\u001a*\u00020\u001b\u001a\n\u0010\u001e\u001a\u00020\u001a*\u00020\u001b\u001a\u0012\u0010\u0019\u001a\u00020\u001f*\u00020 2\u0006\u0010\u0003\u001a\u00020\u001c\u001a\u0012\u0010!\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\"\u001a\u00020#\u001a\n\u0010$\u001a\u00020\u0001*\u00020\u0002\u001a\"\u0010%\u001a\u00020\u001c*\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,¨\u0006-"}, d2 = {"createAnnotationAction", "Lcom/box/android/preview/preview/PreviewReducer$Action$SelectedItem;", "Lcom/box/android/preview/preview/PreviewReducer$Action$SelectedItem$Companion;", "state", "Lcom/box/android/preview/item/ItemPreviewReducer$State;", Analytics.Data.ACTION, "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "annotationAction", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "searchAction", "Lcom/box/android/preview/previewtype/document/search/DocumentSearchReducer$Action;", "document", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", MimeTypes.BASE_TYPE_VIDEO, "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;", "boxNoteEdit", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "rename", "Lcom/box/android/preview/preview/PreviewReducer$Action$FileActionsAction;", "Lcom/box/android/preview/preview/PreviewReducer$Action$FileActionsAction$Companion;", "renameAction", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Action;", "performAction", "fileAction", "Lcom/box/android/preview/fileactions/FileAction;", "update", "Lcom/box/android/preview/preview/PreviewReducer$Action$TopBarAction;", "Lcom/box/android/preview/preview/PreviewReducer$Action$TopBarAction$Companion;", "Lcom/box/android/preview/preview/PreviewReducer$State;", "showMoreActionsMenu", "closeMoreActionsMenu", "Lcom/box/android/preview/preview/PreviewReducer$Action$BottomBarAction;", "Lcom/box/android/preview/preview/PreviewReducer$Action$BottomBarAction$Companion;", "evaluateFileActions", "itemState", "Lcom/box/android/preview/item/ItemState;", "refreshPdfPreviewConfiguration", "createState", "Lcom/box/android/preview/preview/PreviewReducer$State$Companion;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", "isNewlyCreatedFile", "", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PreviewReducerHelpersKt {
    public static final PreviewReducer.Action.SelectedItem createAnnotationAction(PreviewReducer.Action.SelectedItem.Companion companion, ItemPreviewReducer.State state, CreateAnnotationReducer.Action action) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        ItemState itemState = state.getItemState();
        if (itemState instanceof ItemState.Document) {
            return new PreviewReducer.Action.SelectedItem(new ItemPreviewReducer.Action.DocumentPreview(new DocumentPreviewReducer.Action.CreateAnnotation(action)));
        }
        if (itemState instanceof ItemState.Image) {
            return new PreviewReducer.Action.SelectedItem(new ItemPreviewReducer.Action.ImagePreview(new ImagePreviewReducer.Action.CreateAnnotation(action)));
        }
        return new PreviewReducer.Action.SelectedItem(new ItemPreviewReducer.Action.VideoPreview(new VideoPreviewReducer.Action.FrameAnnotation(new FrameAnnotationReducer.Action.CreateAnnotation(action))));
    }

    public static final PreviewReducer.Action.SelectedItem annotationAction(PreviewReducer.Action.SelectedItem.Companion companion, ItemPreviewReducer.State state, AnnotationsReducer.Action action) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        return new PreviewReducer.Action.SelectedItem(ItemPreviewReducer.INSTANCE.annotationAction(state, action));
    }

    public static final PreviewReducer.Action.SelectedItem searchAction(PreviewReducer.Action.SelectedItem.Companion companion, DocumentSearchReducer.Action action) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        return new PreviewReducer.Action.SelectedItem(new ItemPreviewReducer.Action.DocumentPreview(new DocumentPreviewReducer.Action.Search(action)));
    }

    public static final PreviewReducer.Action.SelectedItem document(PreviewReducer.Action.SelectedItem.Companion companion, DocumentPreviewReducer.Action action) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        return new PreviewReducer.Action.SelectedItem(new ItemPreviewReducer.Action.DocumentPreview(action));
    }

    public static final PreviewReducer.Action.SelectedItem video(PreviewReducer.Action.SelectedItem.Companion companion, VideoPreviewReducer.Action action) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        return new PreviewReducer.Action.SelectedItem(new ItemPreviewReducer.Action.VideoPreview(action));
    }

    public static final PreviewReducer.Action.SelectedItem boxNoteEdit(PreviewReducer.Action.SelectedItem.Companion companion, BoxNoteEditModeReducer.Action action) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        return new PreviewReducer.Action.SelectedItem(new ItemPreviewReducer.Action.BoxNotePreview(new BoxNotePreviewReducer.Action.EditModeAction(action)));
    }

    public static final PreviewReducer.Action.FileActionsAction rename(PreviewReducer.Action.FileActionsAction.Companion companion, UpdateItemInfoReducer.Action renameAction) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(renameAction, "renameAction");
        return new PreviewReducer.Action.FileActionsAction(new FileActionsReducer.Action.Rename(renameAction));
    }

    public static final PreviewReducer.Action.FileActionsAction performAction(PreviewReducer.Action.FileActionsAction.Companion companion, FileAction fileAction) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(fileAction, "fileAction");
        return new PreviewReducer.Action.FileActionsAction(new FileActionsReducer.Action.PerformAction(fileAction));
    }

    public static final PreviewReducer.Action.TopBarAction update(PreviewReducer.Action.TopBarAction.Companion companion, PreviewReducer.State state) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        return new PreviewReducer.Action.TopBarAction(new TopBarReducer.Action.Update(state.getFileModel(), state.getFileActionsState().getAvailableActions(), state.getHasUserLostAccessToFile(), !state.getIsCreateAnnotationMode()));
    }

    public static final PreviewReducer.Action.TopBarAction showMoreActionsMenu(PreviewReducer.Action.TopBarAction.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return new PreviewReducer.Action.TopBarAction(TopBarReducer.Action.ShowMoreActionsMenu.INSTANCE);
    }

    public static final PreviewReducer.Action.TopBarAction closeMoreActionsMenu(PreviewReducer.Action.TopBarAction.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return new PreviewReducer.Action.TopBarAction(TopBarReducer.Action.CloseMoreActionsMenu.INSTANCE);
    }

    public static final PreviewReducer.Action.BottomBarAction update(PreviewReducer.Action.BottomBarAction.Companion companion, PreviewReducer.State state) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        return new PreviewReducer.Action.BottomBarAction(new BottomBarReducer.Action.Update(state.getFileModel(), state.getFileActionsState().getAvailableActions(), state.getPreviewItem().isAiEnabled()));
    }

    public static final PreviewReducer.Action.FileActionsAction evaluateFileActions(PreviewReducer.Action.FileActionsAction.Companion companion, ItemState itemState) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(itemState, "itemState");
        return new PreviewReducer.Action.FileActionsAction(new FileActionsReducer.Action.EvaluateActions(itemState));
    }

    public static final PreviewReducer.Action.SelectedItem refreshPdfPreviewConfiguration(PreviewReducer.Action.SelectedItem.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return new PreviewReducer.Action.SelectedItem(new ItemPreviewReducer.Action.DocumentPreview(DocumentPreviewReducer.Action.RefreshPdfPreviewConfiguration.INSTANCE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final PreviewReducer.State createState(PreviewReducer.State.Companion companion, FileModel fileModel, PreviewSource previewSource, boolean z) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        Intrinsics.checkNotNullParameter(previewSource, "previewSource");
        return new PreviewReducer.State(IdentifiedListKt.identifiedListOf(new ItemPreviewReducer.State(new ItemState.Uninitialized(fileModel), null, null, false, null, 30, null)), fileModel.getItemId(), previewSource, z, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0, null, false, null, false, false, 4080, null);
    }
}
