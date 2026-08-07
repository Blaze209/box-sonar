package com.box.android.preview.previewtype.code;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.FileModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CodePreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\n\u0010\b\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"CodePreviewScreen", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/previewtype/code/CodePreviewReducer$State;", "Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action;", "(Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "preview_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CodePreviewScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CodePreviewScreen$lambda$4(Store store, int i, Composer composer, int i2) {
        CodePreviewScreen(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void CodePreviewScreen(final Store<CodePreviewReducer.State, CodePreviewReducer.Action> store, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2095938379);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CodePreviewScreen)N(store)10@394L29:CodePreviewScreen.kt#mz3i3y");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2095938379, i2, -1, "com.box.android.preview.previewtype.code.CodePreviewScreen (CodePreviewScreen.kt:9)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            if (CodePreviewScreen$lambda$0(stateCollectAsStateWithLifecycle).isPreviewLoaded()) {
                composerStartRestartGroup.startReplaceGroup(134501930);
                ComposerKt.sourceInformation(composerStartRestartGroup, "16@584L57,18@752L59,17@667L58,13@466L355");
                FileModel file = CodePreviewScreen$lambda$0(stateCollectAsStateWithLifecycle).getFile();
                String fileContent = CodePreviewScreen$lambda$0(stateCollectAsStateWithLifecycle).getFileContent();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 142889582, "CC(remember):CodePreviewScreen.kt#9igjgp");
                int i3 = i2 & 14;
                boolean z = i3 == 4;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.preview.previewtype.code.CodePreviewScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CodePreviewScreenKt.CodePreviewScreen$lambda$1$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 142894960, "CC(remember):CodePreviewScreen.kt#9igjgp");
                boolean z2 = i3 == 4;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.preview.previewtype.code.CodePreviewScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CodePreviewScreenKt.CodePreviewScreen$lambda$2$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function0 function1 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 142892239, "CC(remember):CodePreviewScreen.kt#9igjgp");
                boolean z3 = i3 == 4;
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.preview.previewtype.code.CodePreviewScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CodePreviewScreenKt.CodePreviewScreen$lambda$3$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CodePreviewerKt.CodePreviewer(file, fileContent, function0, function1, (Function0) objRememberedValue3, composerStartRestartGroup, 0);
                composerStartRestartGroup = composerStartRestartGroup;
            } else {
                composerStartRestartGroup.startReplaceGroup(134027661);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.code.CodePreviewScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CodePreviewScreenKt.CodePreviewScreen$lambda$4(store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CodePreviewScreen$lambda$1$0(Store store) {
        store.send(CodePreviewReducer.Action.OnPreviewLoaded.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CodePreviewScreen$lambda$3$0(Store store) {
        store.send(CodePreviewReducer.Action.OnPreviewPressed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CodePreviewScreen$lambda$2$0(Store store) {
        store.send(CodePreviewReducer.Action.OnPreviewScrolled.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final CodePreviewReducer.State CodePreviewScreen$lambda$0(State<CodePreviewReducer.State> state) {
        return state.getValue();
    }
}
