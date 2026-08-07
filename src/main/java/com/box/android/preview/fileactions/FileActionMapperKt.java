package com.box.android.preview.fileactions;

import androidx.compose.foundation.layout.PaddingValues;
import com.box.android.base.compose.popup.model.PopupMenuItem;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.preview.preview.PreviewReducer;
import com.box.android.preview.preview.PreviewReducerHelpersKt;
import com.pspdfkit.analytics.Analytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActionMapper.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u001a*\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\u000b\u001a\u00020\u0003H\u0002\u001a\u0012\u0010\f\u001a\u00020\r*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010"}, d2 = {"mapToPopupMenuItem", "", "Lcom/box/android/base/compose/popup/model/PopupMenuItem;", "Lcom/box/android/preview/fileactions/FileAction;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/preview/PreviewReducer$State;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "sendActionAndCloseMenuLambda", "Lkotlin/Function0;", "", Analytics.Data.ACTION, "mapToFileActionItem", "Lcom/box/android/preview/fileactions/FileActionUIItem;", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FileActionMapperKt {

    /* JADX INFO: compiled from: FileActionMapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FileAction.values().length];
            try {
                iArr[FileAction.Rename.ordinal()] = 1;
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
                iArr[FileAction.PageView.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FileAction.MoveOrCopy.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FileAction.MakeAvailableOffline.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[FileAction.RemoveFromOffline.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[FileAction.FileInformation.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[FileAction.ViewContainingFolder.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[FileAction.Download.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[FileAction.Print.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[FileAction.ViewSettings.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[FileAction.Watermarking.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[FileAction.Delete.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[FileAction.EndCollaboration.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[FileAction.Search.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[FileAction.Share.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[FileAction.OpenIn.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[FileAction.Collections.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[FileAction.CopySharedLink.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[FileAction.AddAnnotations.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[FileAction.AddComment.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[FileAction.BoxAi.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[FileAction.AddTask.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[FileAction.Gallery.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[FileAction.Playlist.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final List<PopupMenuItem> mapToPopupMenuItem(List<? extends FileAction> list, Store<PreviewReducer.State, PreviewReducer.Action> store) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(store, "store");
        List<? extends FileAction> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (FileAction fileAction : list2) {
            FileActionUIItem fileActionUIItemMapToFileActionItem = mapToFileActionItem(fileAction, ((PreviewReducer.State) StoreKt.stateValue(store)).getPreviewSource());
            arrayList.add(new PopupMenuItem(fileActionUIItemMapToFileActionItem.getTitleRes(), (Function0) sendActionAndCloseMenuLambda(store, fileAction), Integer.valueOf(fileActionUIItemMapToFileActionItem.getIconRes()), (Integer) null, (PaddingValues) null, false, 56, (DefaultConstructorMarker) null));
        }
        return arrayList;
    }

    private static final Function0<Unit> sendActionAndCloseMenuLambda(final Store<PreviewReducer.State, PreviewReducer.Action> store, final FileAction fileAction) {
        return new Function0() { // from class: com.box.android.preview.fileactions.FileActionMapperKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FileActionMapperKt.sendActionAndCloseMenuLambda$lambda$0(store, fileAction);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendActionAndCloseMenuLambda$lambda$0(Store store, FileAction fileAction) {
        store.send(PreviewReducerHelpersKt.performAction(PreviewReducer.Action.FileActionsAction.INSTANCE, fileAction));
        store.send(PreviewReducerHelpersKt.closeMoreActionsMenu(PreviewReducer.Action.TopBarAction.INSTANCE));
        return Unit.INSTANCE;
    }

    public static final FileActionUIItem mapToFileActionItem(FileAction fileAction, PreviewSource previewSource) {
        Intrinsics.checkNotNullParameter(fileAction, "<this>");
        Intrinsics.checkNotNullParameter(previewSource, "previewSource");
        switch (WhenMappings.$EnumSwitchMapping$0[fileAction.ordinal()]) {
            case 1:
                return FileActionUIItem.RenameFile;
            case 2:
                return FileActionUIItem.ThumbnailsView;
            case 3:
                return FileActionUIItem.OutlineView;
            case 4:
                return FileActionUIItem.PageView;
            case 5:
                return FileActionUIItem.MoveOrCopy;
            case 6:
                return FileActionUIItem.MakeAvailableOffline;
            case 7:
                return FileActionUIItem.RemoveFromOffline;
            case 8:
                return FileActionUIItem.FileInformation;
            case 9:
                return FileActionUIItem.ViewContainingFolder;
            case 10:
                return FileActionUIItem.Download;
            case 11:
                return FileActionUIItem.Print;
            case 12:
                return FileActionUIItem.ViewSettings;
            case 13:
                return FileActionUIItem.Watermarking;
            case 14:
                return FileActionUIItem.Delete;
            case 15:
                return FileActionUIItem.EndCollaboration;
            case 16:
                return FileActionUIItem.Search;
            case 17:
                return FileActionUIItem.Share;
            case 18:
                return FileActionUIItem.OpenIn;
            case 19:
                return FileActionUIItem.Collections;
            case 20:
                return FileActionUIItem.CopySharedLink;
            case 21:
                return FileActionUIItem.AddAnnotation;
            case 22:
                return FileActionUIItem.FileActivity;
            case 23:
                return FileActionUIItem.BoxAi;
            case 24:
                return FileActionUIItem.AddTask;
            case 25:
                if (Intrinsics.areEqual(previewSource, PreviewSource.Offline.INSTANCE)) {
                    return FileActionUIItem.OfflineGallery;
                }
                if (Intrinsics.areEqual(previewSource, PreviewSource.Recents.INSTANCE)) {
                    return FileActionUIItem.RecentGallery;
                }
                return Intrinsics.areEqual(previewSource, PreviewSource.CaptureHistory.INSTANCE) ? FileActionUIItem.CaptureHistoryGallery : FileActionUIItem.FolderGallery;
            case 26:
                return FileActionUIItem.Playlist;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
