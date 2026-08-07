package com.box.android.preview.fileactions;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.dialog.BoxActionConfirmationDialogKt;
import com.box.android.base.presentation.components.fileactions.OfflineLargeFileErrorDialogKt;
import com.box.android.cpl.Store;
import com.box.android.preview.fileactions.openin.WopiDialogKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: FileActionsDialogs.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\n\u0010\b\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"FileActionsDialogs", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/fileactions/FileActionsReducer$State;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action;", "(Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "preview_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FileActionsDialogsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileActionsDialogs$lambda$5(Store store, int i, Composer composer, int i2) {
        FileActionsDialogs(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void FileActionsDialogs(final Store<FileActionsReducer.State, FileActionsReducer.Action> store, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(-579445965);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FileActionsDialogs)N(store)16@792L29:FileActionsDialogs.kt#bq3m7o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-579445965, i2, -1, "com.box.android.preview.fileactions.FileActionsDialogs (FileActionsDialogs.kt:15)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            if (FileActionsDialogs$lambda$0(stateCollectAsStateWithLifecycle).getDeleteItemState() == null) {
                composerStartRestartGroup.startReplaceGroup(-801885009);
            } else {
                composerStartRestartGroup.startReplaceGroup(-801024728);
                ComposerKt.sourceInformation(composerStartRestartGroup, "21@984L14,18@871L151");
                AnonymousClass1 anonymousClass1 = new PropertyReference1Impl() { // from class: com.box.android.preview.fileactions.FileActionsDialogsKt.FileActionsDialogs.1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((FileActionsReducer.State) obj).getDeleteItemState();
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1498184929, "CC(remember):FileActionsDialogs.kt#9igjgp");
                FileActionsDialogsKt$FileActionsDialogs$2$1 fileActionsDialogsKt$FileActionsDialogs$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (fileActionsDialogsKt$FileActionsDialogs$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    fileActionsDialogsKt$FileActionsDialogs$2$1RememberedValue = FileActionsDialogsKt$FileActionsDialogs$2$1.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(fileActionsDialogsKt$FileActionsDialogs$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxActionConfirmationDialogKt.DeleteItemConfirmationDialog(store.ifScope(anonymousClass1, (Function1) ((KFunction) fileActionsDialogsKt$FileActionsDialogs$2$1RememberedValue)), composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (FileActionsDialogs$lambda$0(stateCollectAsStateWithLifecycle).getEndCollaborationState() == null) {
                composerStartRestartGroup.startReplaceGroup(-801885009);
            } else {
                composerStartRestartGroup.startReplaceGroup(-800814176);
                ComposerKt.sourceInformation(composerStartRestartGroup, "27@1176L24,26@1084L127");
                AnonymousClass3 anonymousClass3 = new PropertyReference1Impl() { // from class: com.box.android.preview.fileactions.FileActionsDialogsKt.FileActionsDialogs.3
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((FileActionsReducer.State) obj).getEndCollaborationState();
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1498191083, "CC(remember):FileActionsDialogs.kt#9igjgp");
                FileActionsDialogsKt$FileActionsDialogs$4$1 fileActionsDialogsKt$FileActionsDialogs$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (fileActionsDialogsKt$FileActionsDialogs$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    fileActionsDialogsKt$FileActionsDialogs$4$1RememberedValue = FileActionsDialogsKt$FileActionsDialogs$4$1.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(fileActionsDialogsKt$FileActionsDialogs$4$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxActionConfirmationDialogKt.EndCollaborationConfirmationDialog(store.ifScope(anonymousClass3, (Function1) ((KFunction) fileActionsDialogsKt$FileActionsDialogs$4$1RememberedValue)), composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (FileActionsDialogs$lambda$0(stateCollectAsStateWithLifecycle).getOpenInState() == null) {
                composerStartRestartGroup.startReplaceGroup(-801885009);
            } else {
                composerStartRestartGroup.startReplaceGroup(-800638654);
                ComposerKt.sourceInformation(composerStartRestartGroup, "31@1308L14,31@1263L61");
                AnonymousClass5 anonymousClass5 = new PropertyReference1Impl() { // from class: com.box.android.preview.fileactions.FileActionsDialogsKt.FileActionsDialogs.5
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((FileActionsReducer.State) obj).getOpenInState();
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1498195297, "CC(remember):FileActionsDialogs.kt#9igjgp");
                FileActionsDialogsKt$FileActionsDialogs$6$1 fileActionsDialogsKt$FileActionsDialogs$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (fileActionsDialogsKt$FileActionsDialogs$6$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    fileActionsDialogsKt$FileActionsDialogs$6$1RememberedValue = FileActionsDialogsKt$FileActionsDialogs$6$1.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(fileActionsDialogsKt$FileActionsDialogs$6$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                WopiDialogKt.WopiDialog(store.ifScope(anonymousClass5, (Function1) ((KFunction) fileActionsDialogsKt$FileActionsDialogs$6$1RememberedValue)), composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (FileActionsDialogs$lambda$0(stateCollectAsStateWithLifecycle).getOfflineState() == null) {
                composerStartRestartGroup.startReplaceGroup(-801885009);
            } else {
                composerStartRestartGroup.startReplaceGroup(-800522869);
                ComposerKt.sourceInformation(composerStartRestartGroup, "37@1486L15,34@1377L148");
                AnonymousClass7 anonymousClass7 = new PropertyReference1Impl() { // from class: com.box.android.preview.fileactions.FileActionsDialogsKt.FileActionsDialogs.7
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((FileActionsReducer.State) obj).getOfflineState();
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1498200994, "CC(remember):FileActionsDialogs.kt#9igjgp");
                FileActionsDialogsKt$FileActionsDialogs$8$1 fileActionsDialogsKt$FileActionsDialogs$8$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (fileActionsDialogsKt$FileActionsDialogs$8$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    fileActionsDialogsKt$FileActionsDialogs$8$1RememberedValue = FileActionsDialogsKt$FileActionsDialogs$8$1.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(fileActionsDialogsKt$FileActionsDialogs$8$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                OfflineLargeFileErrorDialogKt.OfflineLargeFileErrorDialog(store.ifScope(anonymousClass7, (Function1) ((KFunction) fileActionsDialogsKt$FileActionsDialogs$8$1RememberedValue)), composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.fileactions.FileActionsDialogsKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileActionsDialogsKt.FileActionsDialogs$lambda$5(store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final FileActionsReducer.State FileActionsDialogs$lambda$0(State<FileActionsReducer.State> state) {
        return state.getValue();
    }
}
