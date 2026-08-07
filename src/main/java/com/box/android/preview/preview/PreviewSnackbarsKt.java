package com.box.android.preview.preview;

import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.SnackbarAction;
import com.box.android.base.compose.SnackbarMessageKt;
import com.box.android.base.presentation.components.CopyTextReducer;
import com.box.android.base.presentation.components.fileactions.DownloadFilesReducer;
import com.box.android.base.presentation.components.fileactions.FileActionsError;
import com.box.android.base.presentation.components.fileactions.OfflineFilesReducer;
import com.box.android.cpl.Store;
import com.box.android.preview.R;
import com.box.android.preview.annotations.cpl.CreateAnnotationReducer;
import com.box.android.preview.fileactions.FileActionsReducer;
import com.box.android.preview.fileactions.UpdateItemInfoReducer;
import com.box.android.preview.fileactions.copylink.CopyLinkReducer;
import com.box.android.preview.fileactions.openin.OpenInReducer;
import com.box.android.preview.item.ItemPreviewReducer;
import com.box.android.preview.item.ItemState;
import com.box.android.preview.previewtype.audio.AudioPreviewReducer;
import com.box.android.preview.previewtype.code.CodePreviewReducer;
import com.box.android.preview.previewtype.document.DocumentPreviewReducer;
import com.box.android.preview.previewtype.document.print.PrintReducer;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PreviewSnackbars.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0002\u001a\f\u0010\t\u001a\u00020\n*\u00020\fH\u0002\u001a\f\u0010\t\u001a\u00020\n*\u00020\rH\u0002\u001a\u0013\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u000eH\u0002¢\u0006\u0002\u0010\u000f\u001a\f\u0010\t\u001a\u00020\n*\u00020\u0010H\u0002¨\u0006\u0011²\u0006\n\u0010\u0012\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"PreviewSnackbars", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/preview/PreviewReducer$State;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "(Lcom/box/android/cpl/Store;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/runtime/Composer;I)V", "toStringRes", "", "Lcom/box/android/preview/fileactions/UpdateItemInfoReducer$Message;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Message;", "Lcom/box/android/preview/previewtype/document/print/PrintReducer$Error;", "Lcom/box/android/base/presentation/components/fileactions/FileActionsError;", "(Lcom/box/android/base/presentation/components/fileactions/FileActionsError;)Ljava/lang/Integer;", "Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Message;", "preview_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PreviewSnackbarsKt {

    /* JADX INFO: compiled from: PreviewSnackbars.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;

        static {
            int[] iArr = new int[UpdateItemInfoReducer.Message.values().length];
            try {
                iArr[UpdateItemInfoReducer.Message.NAME_CHANGED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CreateAnnotationReducer.Message.values().length];
            try {
                iArr2[CreateAnnotationReducer.Message.SaveFailed.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[CreateAnnotationReducer.Message.SaveSuccess.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[CreateAnnotationReducer.Message.AnnotationDrawnOutsideActivePage.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[PrintReducer.Error.values().length];
            try {
                iArr3[PrintReducer.Error.PRINTING_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[PrintReducer.Error.FEATURE_DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[FileActionsError.values().length];
            try {
                iArr4[FileActionsError.FEATURE_DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr4[FileActionsError.ENCRYPTED_DEVICE_REQUIRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr4[FileActionsError.SAVE_TO_LOCATION_NOT_ALLOWED.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr4[FileActionsError.LARGE_FILE_SIZE.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$3 = iArr4;
            int[] iArr5 = new int[CodePreviewReducer.Message.values().length];
            try {
                iArr5[CodePreviewReducer.Message.CODE_PREVIEW_TOO_LARGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$4 = iArr5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewSnackbars$lambda$13(Store store, SnackbarHostState snackbarHostState, int i, Composer composer, int i2) {
        PreviewSnackbars(store, snackbarHostState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void PreviewSnackbars(final Store<PreviewReducer.State, PreviewReducer.Action> store, final SnackbarHostState snackbarHostState, Composer composer, final int i) {
        Composer composer2;
        PreviewSnackbar previewSnackbar;
        String strStringResource;
        AudioPreviewReducer.State state;
        UpdateItemInfoReducer.Message message;
        CreateAnnotationReducer.Message message2;
        FileActionsError error;
        Integer stringRes;
        PrintReducer.Error error2;
        FileActionsError error3;
        Integer stringRes2;
        CopyTextReducer.State copyTextState;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1507465340);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PreviewSnackbars)N(store,snackbarHostState)39@1978L29,154@6624L24,*163@6987L42,157@6728L301:PreviewSnackbars.kt#viiktp");
        int i2 = 4;
        int i3 = (i & 6) == 0 ? (composerStartRestartGroup.changed(store) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(snackbarHostState) ? 32 : 16;
        }
        int i4 = 0;
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1507465340, i3, -1, "com.box.android.preview.preview.PreviewSnackbars (PreviewSnackbars.kt:38)");
            }
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            PreviewSnackbar[] previewSnackbarArr = new PreviewSnackbar[11];
            PreviewSnackbar previewSnackbar2 = new PreviewSnackbar(Integer.valueOf(R.string.link_copied_to_clipboard), new PreviewReducer.Action.FileActionsAction(new FileActionsReducer.Action.CopyLink(CopyLinkReducer.Action.Finish.INSTANCE)), null, null, 12, null);
            CopyLinkReducer.State copyLinkState = PreviewSnackbars$lambda$0(stateCollectAsStateWithLifecycle).getFileActionsState().getCopyLinkState();
            if (copyLinkState == null || (copyTextState = copyLinkState.getCopyTextState()) == null || !copyTextState.getShowCopyNotification()) {
                previewSnackbar2 = null;
            }
            previewSnackbarArr[0] = previewSnackbar2;
            PreviewSnackbar previewSnackbar3 = new PreviewSnackbar(Integer.valueOf(R.string.failed_to_create_shared_link), new PreviewReducer.Action.FileActionsAction(new FileActionsReducer.Action.CopyLink(CopyLinkReducer.Action.Finish.INSTANCE)), null, null, 12, null);
            CopyLinkReducer.State copyLinkState2 = PreviewSnackbars$lambda$0(stateCollectAsStateWithLifecycle).getFileActionsState().getCopyLinkState();
            if ((copyLinkState2 != null ? copyLinkState2.getError() : null) == null) {
                previewSnackbar3 = null;
            }
            previewSnackbarArr[1] = previewSnackbar3;
            PreviewSnackbar previewSnackbar4 = new PreviewSnackbar(Integer.valueOf(R.string.feature_disabled_by_administrator), new PreviewReducer.Action.FileActionsAction(new FileActionsReducer.Action.OpenIn(OpenInReducer.Action.Finish.INSTANCE)), null, null, 12, null);
            OpenInReducer.State openInState = PreviewSnackbars$lambda$0(stateCollectAsStateWithLifecycle).getFileActionsState().getOpenInState();
            if ((openInState != null ? openInState.getError() : null) != OpenInReducer.Error.FEATURE_DISABLED) {
                previewSnackbar4 = null;
            }
            previewSnackbarArr[2] = previewSnackbar4;
            DownloadFilesReducer.State downloadState = PreviewSnackbars$lambda$0(stateCollectAsStateWithLifecycle).getFileActionsState().getDownloadState();
            previewSnackbarArr[3] = (downloadState == null || (error3 = downloadState.getError()) == null || (stringRes2 = toStringRes(error3)) == null) ? null : new PreviewSnackbar(Integer.valueOf(stringRes2.intValue()), new PreviewReducer.Action.FileActionsAction(new FileActionsReducer.Action.Download(DownloadFilesReducer.Action.Finish.INSTANCE)), null, null, 12, null);
            PrintReducer.State printState = PreviewSnackbars$lambda$0(stateCollectAsStateWithLifecycle).getPrintState();
            previewSnackbarArr[4] = (printState == null || (error2 = printState.getError()) == null) ? null : new PreviewSnackbar(Integer.valueOf(toStringRes(error2)), PreviewReducerHelpersKt.document(PreviewReducer.Action.SelectedItem.INSTANCE, new DocumentPreviewReducer.Action.Print(PrintReducer.Action.Finish.INSTANCE)), null, null, 12, null);
            OfflineFilesReducer.State offlineState = PreviewSnackbars$lambda$0(stateCollectAsStateWithLifecycle).getFileActionsState().getOfflineState();
            previewSnackbarArr[5] = (offlineState == null || (error = offlineState.getError()) == null || (stringRes = toStringRes(error)) == null) ? null : new PreviewSnackbar(Integer.valueOf(stringRes.intValue()), new PreviewReducer.Action.FileActionsAction(new FileActionsReducer.Action.Offline(OfflineFilesReducer.Action.Finish.INSTANCE)), null, null, 12, null);
            CreateAnnotationReducer.State createAnnotationState = PreviewSnackbars$lambda$0(stateCollectAsStateWithLifecycle).getCreateAnnotationState();
            previewSnackbarArr[6] = (createAnnotationState == null || (message2 = createAnnotationState.getMessage()) == null) ? null : new PreviewSnackbar(Integer.valueOf(toStringRes(message2)), PreviewReducerHelpersKt.createAnnotationAction(PreviewReducer.Action.SelectedItem.INSTANCE, PreviewSnackbars$lambda$0(stateCollectAsStateWithLifecycle).getPreviewItem(), CreateAnnotationReducer.Action.MessageShown.INSTANCE), null, null, 12, null);
            UpdateItemInfoReducer.State renameItemState = PreviewSnackbars$lambda$0(stateCollectAsStateWithLifecycle).getFileActionsState().getRenameItemState();
            previewSnackbarArr[7] = (renameItemState == null || (message = renameItemState.getMessage()) == null) ? null : new PreviewSnackbar(Integer.valueOf(toStringRes(message)), new PreviewReducer.Action.FileActionsAction(new FileActionsReducer.Action.Rename(UpdateItemInfoReducer.Action.SuccessMessageShown.INSTANCE)), null, null, 12, null);
            PreviewSnackbar previewSnackbar5 = new PreviewSnackbar(Integer.valueOf(com.box.android.tasks.R.string.add_task_success), PreviewReducer.Action.TaskCreatedSnackbarShown.INSTANCE, null, null, 12, null);
            if (!PreviewSnackbars$lambda$0(stateCollectAsStateWithLifecycle).getTaskCreatedSuccessfully()) {
                previewSnackbar5 = null;
            }
            previewSnackbarArr[8] = previewSnackbar5;
            CodePreviewReducer.Message codePreviewMessage = PreviewSnackbars$lambda$0(stateCollectAsStateWithLifecycle).getCodePreviewMessage();
            previewSnackbarArr[9] = codePreviewMessage != null ? new PreviewSnackbar(Integer.valueOf(toStringRes(codePreviewMessage)), new PreviewReducer.Action.Items(PreviewSnackbars$lambda$0(stateCollectAsStateWithLifecycle).getPreviewItem().getId(), new ItemPreviewReducer.Action.CodePreview(CodePreviewReducer.Action.MessageShown.INSTANCE)), SnackbarDuration.Indefinite, null, 8, null) : null;
            ItemState itemState = PreviewSnackbars$lambda$0(stateCollectAsStateWithLifecycle).getItemState();
            ItemState.Audio audio = itemState instanceof ItemState.Audio ? (ItemState.Audio) itemState : null;
            if (((audio == null || (state = audio.getState()) == null) ? null : state.getErrorWhenTryPlaying()) == null) {
                composerStartRestartGroup.startReplaceGroup(-717933210);
                composerStartRestartGroup.endReplaceGroup();
                previewSnackbar = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(-717933209);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*142@6223L30,142@6255L312");
                Integer numValueOf = Integer.valueOf(R.string.generic_audio_preview_error);
                PreviewReducer.Action.Items items = new PreviewReducer.Action.Items(PreviewSnackbars$lambda$0(stateCollectAsStateWithLifecycle).getPreviewItem().getId(), new ItemPreviewReducer.Action.AudioPreview(AudioPreviewReducer.Action.ErrorHandled.INSTANCE));
                SnackbarDuration snackbarDuration = SnackbarDuration.Indefinite;
                String strStringResource2 = StringResources_androidKt.stringResource(R.string.retry, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 347125674, "CC(remember):PreviewSnackbars.kt#9igjgp");
                boolean zChanged = ((i3 & 14) == 4) | composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.preview.preview.PreviewSnackbarsKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PreviewSnackbarsKt.PreviewSnackbars$lambda$11$0$0(store, stateCollectAsStateWithLifecycle);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                previewSnackbar = new PreviewSnackbar(numValueOf, items, snackbarDuration, new SnackbarAction(strStringResource2, (Function0) objRememberedValue));
                composerStartRestartGroup.endReplaceGroup();
            }
            previewSnackbarArr[10] = previewSnackbar;
            List<PreviewSnackbar> listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) previewSnackbarArr);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            for (PreviewSnackbar previewSnackbar6 : listListOfNotNull) {
                Integer messageRes = previewSnackbar6.getMessageRes();
                final PreviewReducer.Action action = previewSnackbar6.getAction();
                int i5 = i3;
                SnackbarDuration duration = previewSnackbar6.getDuration();
                SnackbarAction snackbarAction = previewSnackbar6.getSnackbarAction();
                if (messageRes == null) {
                    composerStartRestartGroup.startReplaceGroup(1640107801);
                    composerStartRestartGroup.endReplaceGroup();
                    strStringResource = null;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1640107802);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*158@6782L18");
                    strStringResource = StringResources_androidKt.stringResource(messageRes.intValue(), composerStartRestartGroup, i4);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 884197464, "CC(remember):PreviewSnackbars.kt#9igjgp");
                int i6 = ((i5 & 14) == i2 ? 1 : i4) | (composerStartRestartGroup.changed(action) ? 1 : 0);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (i6 != 0 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.preview.preview.PreviewSnackbarsKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PreviewSnackbarsKt.PreviewSnackbars$lambda$12$1$0(store, action);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Composer composer3 = composerStartRestartGroup;
                SnackbarMessageKt.SnackbarMessage(strStringResource, duration, snackbarHostState, coroutineScope, snackbarAction, (Function0) objRememberedValue3, composer3, ((i5 << 3) & 896) | (SnackbarAction.$stable << 12), 0);
                composerStartRestartGroup = composer3;
                i3 = i5;
                i2 = i2;
                i4 = i4;
            }
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.preview.PreviewSnackbarsKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewSnackbarsKt.PreviewSnackbars$lambda$13(store, snackbarHostState, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewSnackbars$lambda$11$0$0(Store store, State state) {
        store.send(new PreviewReducer.Action.Items(PreviewSnackbars$lambda$0(state).getPreviewItem().getId(), new ItemPreviewReducer.Action.AudioPreview(AudioPreviewReducer.Action.RetryClicked.INSTANCE)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewSnackbars$lambda$12$1$0(Store store, PreviewReducer.Action action) {
        store.send(action);
        return Unit.INSTANCE;
    }

    private static final int toStringRes(UpdateItemInfoReducer.Message message) {
        if (WhenMappings.$EnumSwitchMapping$0[message.ordinal()] != 1) {
            throw new NoWhenBranchMatchedException();
        }
        return R.string.file_rename_successful_snackbar_text;
    }

    private static final int toStringRes(CreateAnnotationReducer.Message message) {
        int i = WhenMappings.$EnumSwitchMapping$1[message.ordinal()];
        if (i == 1) {
            return R.string.annotation_creation_error;
        }
        if (i == 2) {
            return R.string.annotation_saved_toast_text;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return R.string.annotation_drawn_outside_active_page;
    }

    private static final int toStringRes(PrintReducer.Error error) {
        int i = WhenMappings.$EnumSwitchMapping$2[error.ordinal()];
        if (i == 1) {
            return R.string.generic_print_error;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return R.string.feature_disabled_by_administrator;
    }

    private static final Integer toStringRes(FileActionsError fileActionsError) {
        int i = WhenMappings.$EnumSwitchMapping$3[fileActionsError.ordinal()];
        if (i == 1) {
            return Integer.valueOf(R.string.feature_disabled_by_administrator);
        }
        if (i == 2) {
            return Integer.valueOf(R.string.Encrypted_device_requird_for_this_feature);
        }
        if (i == 3) {
            return Integer.valueOf(R.string.offline_sharing_blocked_by_organization);
        }
        if (i == 4) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final int toStringRes(CodePreviewReducer.Message message) {
        if (WhenMappings.$EnumSwitchMapping$4[message.ordinal()] != 1) {
            throw new NoWhenBranchMatchedException();
        }
        return R.string.file_truncated_due_to_size_limits;
    }

    private static final PreviewReducer.State PreviewSnackbars$lambda$0(State<PreviewReducer.State> state) {
        return state.getValue();
    }
}
