package com.box.android.preview.preview.previewbar.topbar;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import com.box.android.cpl.Store;
import com.box.android.preview.fileactions.UpdateItemInfoReducer;
import com.box.android.preview.preview.PreviewReducer;
import com.box.android.preview.preview.PreviewReducerHelpersKt;
import com.box.android.preview.previewtype.document.search.DocumentSearchReducer;
import com.box.android.preview.routing.CloseSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: PreviewTopBar.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class PreviewTopBarKt$PreviewTopBar$1$2$1 implements Function3<Boolean, Composer, Integer, Unit> {
    final /* synthetic */ State<PreviewReducer.State> $state$delegate;
    final /* synthetic */ Store<PreviewReducer.State, PreviewReducer.Action> $store;

    PreviewTopBarKt$PreviewTopBar$1$2$1(Store<PreviewReducer.State, PreviewReducer.Action> store, State<PreviewReducer.State> state) {
        this.$store = store;
        this.$state$delegate = state;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Composer composer, Integer num) {
        invoke(bool.booleanValue(), composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "CN(isRenaming)95@4901L259,102@5203L72,103@5317L83,91@4610L808:PreviewTopBar.kt#l0df2e");
        if ((i & 6) == 0) {
            i |= composer.changed(z) ? 4 : 2;
        }
        boolean z2 = false;
        if (composer.shouldExecute((i & 19) != 18, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(518243432, i, -1, "com.box.android.preview.preview.previewbar.topbar.PreviewTopBar.<anonymous>.<anonymous>.<anonymous> (PreviewTopBar.kt:91)");
            }
            UpdateItemInfoReducer.State renameItemState = PreviewTopBarKt.PreviewTopBar$lambda$0(this.$state$delegate).getFileActionsState().getRenameItemState();
            if (renameItemState != null && renameItemState.isRenamePending()) {
                z2 = true;
            }
            boolean z3 = !z2;
            boolean isSearching = PreviewTopBarKt.PreviewTopBar$lambda$0(this.$state$delegate).getIsSearching();
            ComposerKt.sourceInformationMarkerStart(composer, -184257589, "CC(remember):PreviewTopBar.kt#9igjgp");
            boolean zChanged = composer.changed(this.$store);
            final Store<PreviewReducer.State, PreviewReducer.Action> store = this.$store;
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.box.android.preview.preview.previewbar.topbar.PreviewTopBarKt$PreviewTopBar$1$2$1$1$1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        store.send(PreviewReducerHelpersKt.rename(PreviewReducer.Action.FileActionsAction.INSTANCE, UpdateItemInfoReducer.Action.Finish.INSTANCE));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -184248112, "CC(remember):PreviewTopBar.kt#9igjgp");
            boolean zChanged2 = composer.changed(this.$store);
            final Store<PreviewReducer.State, PreviewReducer.Action> store2 = this.$store;
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.box.android.preview.preview.previewbar.topbar.PreviewTopBarKt$PreviewTopBar$1$2$1$2$1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        store2.send(new PreviewReducer.Action.BackClicked(CloseSource.AppButton.INSTANCE, false, 2, null));
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function1 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -184244453, "CC(remember):PreviewTopBar.kt#9igjgp");
            boolean zChanged3 = composer.changed(this.$store);
            final Store<PreviewReducer.State, PreviewReducer.Action> store3 = this.$store;
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: com.box.android.preview.preview.previewbar.topbar.PreviewTopBarKt$PreviewTopBar$1$2$1$3$1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        store3.send(PreviewReducerHelpersKt.searchAction(PreviewReducer.Action.SelectedItem.INSTANCE, DocumentSearchReducer.Action.CloseSearchClicked.INSTANCE));
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            PreviewTopBarKt.BackOrCancelRenameButton(z, z3, isSearching, function0, function1, (Function0) objRememberedValue3, composer, i & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
