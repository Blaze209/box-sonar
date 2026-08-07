package com.box.android.browse.cpl.copymove;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.ButtonBarKt;
import com.box.android.base.compose.SwipeableSnackbarHostKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.browse.R;
import com.box.android.browse.compose.BoxBrowseToolbarsKt;
import com.box.android.browse.compose.FolderListingScreenKt;
import com.box.android.browse.cpl.createfolder.CreateFolderDialogKt;
import com.box.android.cpl.Store;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: CopyOrMoveScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a;\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b²\u0006\n\u0010\f\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"CopyOrMoveScreen", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$State;", "Lcom/box/android/browse/cpl/copymove/CopyOrMoveReducer$Action;", "onClose", "Lkotlin/Function0;", "isRedesignedVersion", "", "(Lcom/box/android/cpl/Store;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;II)V", "browse_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CopyOrMoveScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CopyOrMoveScreen$lambda$8(Store store, Function0 function0, boolean z, int i, int i2, Composer composer, int i3) {
        CopyOrMoveScreen(store, function0, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0047  */
    /* JADX WARN: Code duplicated, block: B:24:0x004a  */
    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0056  */
    /* JADX WARN: Code duplicated, block: B:29:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x0067  */
    /* JADX WARN: Code duplicated, block: B:35:0x0069  */
    /* JADX WARN: Code duplicated, block: B:38:0x0072  */
    /* JADX WARN: Code duplicated, block: B:40:0x0076  */
    /* JADX WARN: Code duplicated, block: B:42:0x0088  */
    /* JADX WARN: Code duplicated, block: B:44:0x0096  */
    /* JADX WARN: Code duplicated, block: B:46:0x0099  */
    /* JADX WARN: Code duplicated, block: B:47:0x009b  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:53:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:56:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:60:0x0103  */
    /* JADX WARN: Code duplicated, block: B:63:0x011e  */
    /* JADX WARN: Code duplicated, block: B:66:0x0182  */
    /* JADX WARN: Code duplicated, block: B:68:0x0188  */
    /* JADX WARN: Code duplicated, block: B:71:0x0195  */
    /* JADX WARN: Code duplicated, block: B:73:? A[RETURN, SYNTHETIC] */
    public static final void CopyOrMoveScreen(final Store<CopyOrMoveReducer.State, CopyOrMoveReducer.Action> store, Function0<Unit> function0, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function1;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        Composer composer2;
        final Function0<Unit> function2;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function0<Unit> function3;
        final boolean z5;
        final State stateCollectAsStateWithLifecycle;
        Object objRememberedValue;
        CopyOrMoveScreenKt$CopyOrMoveScreen$3$1 copyOrMoveScreenKt$CopyOrMoveScreen$3$1RememberedValue;
        Object objRememberedValue2;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(2303293);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CopyOrMoveScreen)N(store,onClose,isRedesignedVersion)30@1309L2,33@1387L29,47@1778L32,50@1843L532,67@2506L593,64@2400L84,83@3106L1149,49@1816L2439:CopyOrMoveScreen.kt#oxn7jq");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 == 0) {
            if ((i & 48) == 0) {
                function1 = function0;
                i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i3 & Token.DOTQUERY) != 146) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function2 = function1;
                    z4 = z2;
                } else {
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2081498913, "CC(remember):CopyOrMoveScreen.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        function3 = (Function0) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function3 = function1;
                    }
                    if (i4 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2303293, i3, -1, "com.box.android.browse.cpl.copymove.CopyOrMoveScreen (CopyOrMoveScreen.kt:32)");
                    }
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    if (CopyOrMoveScreen$lambda$1(stateCollectAsStateWithLifecycle).isClosing()) {
                        function3.invoke();
                    }
                    if (CopyOrMoveScreen$lambda$1(stateCollectAsStateWithLifecycle).getCreateFolderState() != null) {
                        composerStartRestartGroup.startReplaceGroup(-103256443);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-101750153);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "42@1668L50,39@1520L222");
                        AnonymousClass2 anonymousClass2 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt.CopyOrMoveScreen.2
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj) {
                                return ((CopyOrMoveReducer.State) obj).getCreateFolderState();
                            }
                        };
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2081487377, "CC(remember):CopyOrMoveScreen.kt#9igjgp");
                        copyOrMoveScreenKt$CopyOrMoveScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (copyOrMoveScreenKt$CopyOrMoveScreen$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            copyOrMoveScreenKt$CopyOrMoveScreen$3$1RememberedValue = CopyOrMoveScreenKt$CopyOrMoveScreen$3$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(copyOrMoveScreenKt$CopyOrMoveScreen$3$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        CreateFolderDialogKt.CreateFolderDialog(store.ifScope(anonymousClass2, (Function1) ((KFunction) copyOrMoveScreenKt$CopyOrMoveScreen$3$1RememberedValue)), composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2081483875, "CC(remember):CopyOrMoveScreen.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new SnackbarHostState();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    final SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-782606087, true, new Function2() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CopyOrMoveScreenKt.CopyOrMoveScreen$lambda$4(store, stateCollectAsStateWithLifecycle, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1702457624, true, new Function2() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CopyOrMoveScreenKt.CopyOrMoveScreen$lambda$5(store, stateCollectAsStateWithLifecycle, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-107445961, true, new Function2() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CopyOrMoveScreenKt.CopyOrMoveScreen$lambda$6(snackbarHostState, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(-1856690802, true, new Function3() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return CopyOrMoveScreenKt.CopyOrMoveScreen$lambda$7(store, z5, stateCollectAsStateWithLifecycle, snackbarHostState, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composer2 = composerStartRestartGroup;
                    boolean z6 = z5;
                    ScaffoldKt.m4038ScaffoldTvnljyQ(null, composableLambdaRememberComposableLambda, composableLambdaRememberComposableLambda2, composableLambdaRememberComposableLambda3, null, 0, 0L, 0L, null, composableLambdaRememberComposableLambda4, composer2, 805309872, 497);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function2 = function3;
                    z4 = z6;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CopyOrMoveScreenKt.CopyOrMoveScreen$lambda$8(store, function2, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            z2 = z;
            if ((i3 & Token.DOTQUERY) != 146) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function2 = function1;
                z4 = z2;
            } else {
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2081498913, "CC(remember):CopyOrMoveScreen.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    function3 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function3 = function1;
                }
                if (i4 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2303293, i3, -1, "com.box.android.browse.cpl.copymove.CopyOrMoveScreen (CopyOrMoveScreen.kt:32)");
                }
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                if (CopyOrMoveScreen$lambda$1(stateCollectAsStateWithLifecycle).isClosing()) {
                    function3.invoke();
                }
                if (CopyOrMoveScreen$lambda$1(stateCollectAsStateWithLifecycle).getCreateFolderState() != null) {
                    composerStartRestartGroup.startReplaceGroup(-103256443);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-101750153);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "42@1668L50,39@1520L222");
                    AnonymousClass2 anonymousClass3 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt.CopyOrMoveScreen.2
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return ((CopyOrMoveReducer.State) obj).getCreateFolderState();
                        }
                    };
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2081487377, "CC(remember):CopyOrMoveScreen.kt#9igjgp");
                    copyOrMoveScreenKt$CopyOrMoveScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (copyOrMoveScreenKt$CopyOrMoveScreen$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        copyOrMoveScreenKt$CopyOrMoveScreen$3$1RememberedValue = CopyOrMoveScreenKt$CopyOrMoveScreen$3$1.INSTANCE;
                        composerStartRestartGroup.updateRememberedValue(copyOrMoveScreenKt$CopyOrMoveScreen$3$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    CreateFolderDialogKt.CreateFolderDialog(store.ifScope(anonymousClass3, (Function1) ((KFunction) copyOrMoveScreenKt$CopyOrMoveScreen$3$1RememberedValue)), composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2081483875, "CC(remember):CopyOrMoveScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new SnackbarHostState();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final SnackbarHostState snackbarHostState2 = (SnackbarHostState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposableLambda composableLambdaRememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(-782606087, true, new Function2() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CopyOrMoveScreenKt.CopyOrMoveScreen$lambda$4(store, stateCollectAsStateWithLifecycle, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposableLambda composableLambdaRememberComposableLambda6 = ComposableLambdaKt.rememberComposableLambda(1702457624, true, new Function2() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CopyOrMoveScreenKt.CopyOrMoveScreen$lambda$5(store, stateCollectAsStateWithLifecycle, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposableLambda composableLambdaRememberComposableLambda7 = ComposableLambdaKt.rememberComposableLambda(-107445961, true, new Function2() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CopyOrMoveScreenKt.CopyOrMoveScreen$lambda$6(snackbarHostState2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposableLambda composableLambdaRememberComposableLambda8 = ComposableLambdaKt.rememberComposableLambda(-1856690802, true, new Function3() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return CopyOrMoveScreenKt.CopyOrMoveScreen$lambda$7(store, z5, stateCollectAsStateWithLifecycle, snackbarHostState2, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composer2 = composerStartRestartGroup;
                boolean z7 = z5;
                ScaffoldKt.m4038ScaffoldTvnljyQ(null, composableLambdaRememberComposableLambda5, composableLambdaRememberComposableLambda6, composableLambdaRememberComposableLambda7, null, 0, 0L, 0L, null, composableLambdaRememberComposableLambda8, composer2, 805309872, 497);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function2 = function3;
                z4 = z7;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CopyOrMoveScreenKt.CopyOrMoveScreen$lambda$8(store, function2, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        function1 = function0;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function2 = function1;
                z4 = z2;
            } else {
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2081498913, "CC(remember):CopyOrMoveScreen.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    function3 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function3 = function1;
                }
                if (i4 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2303293, i3, -1, "com.box.android.browse.cpl.copymove.CopyOrMoveScreen (CopyOrMoveScreen.kt:32)");
                }
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                if (CopyOrMoveScreen$lambda$1(stateCollectAsStateWithLifecycle).isClosing()) {
                    function3.invoke();
                }
                if (CopyOrMoveScreen$lambda$1(stateCollectAsStateWithLifecycle).getCreateFolderState() != null) {
                    composerStartRestartGroup.startReplaceGroup(-103256443);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-101750153);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "42@1668L50,39@1520L222");
                    AnonymousClass2 anonymousClass4 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt.CopyOrMoveScreen.2
                        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                        public Object get(Object obj) {
                            return ((CopyOrMoveReducer.State) obj).getCreateFolderState();
                        }
                    };
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2081487377, "CC(remember):CopyOrMoveScreen.kt#9igjgp");
                    copyOrMoveScreenKt$CopyOrMoveScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (copyOrMoveScreenKt$CopyOrMoveScreen$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        copyOrMoveScreenKt$CopyOrMoveScreen$3$1RememberedValue = CopyOrMoveScreenKt$CopyOrMoveScreen$3$1.INSTANCE;
                        composerStartRestartGroup.updateRememberedValue(copyOrMoveScreenKt$CopyOrMoveScreen$3$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    CreateFolderDialogKt.CreateFolderDialog(store.ifScope(anonymousClass4, (Function1) ((KFunction) copyOrMoveScreenKt$CopyOrMoveScreen$3$1RememberedValue)), composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2081483875, "CC(remember):CopyOrMoveScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new SnackbarHostState();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final SnackbarHostState snackbarHostState3 = (SnackbarHostState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposableLambda composableLambdaRememberComposableLambda9 = ComposableLambdaKt.rememberComposableLambda(-782606087, true, new Function2() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CopyOrMoveScreenKt.CopyOrMoveScreen$lambda$4(store, stateCollectAsStateWithLifecycle, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposableLambda composableLambdaRememberComposableLambda10 = ComposableLambdaKt.rememberComposableLambda(1702457624, true, new Function2() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CopyOrMoveScreenKt.CopyOrMoveScreen$lambda$5(store, stateCollectAsStateWithLifecycle, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposableLambda composableLambdaRememberComposableLambda11 = ComposableLambdaKt.rememberComposableLambda(-107445961, true, new Function2() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CopyOrMoveScreenKt.CopyOrMoveScreen$lambda$6(snackbarHostState3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposableLambda composableLambdaRememberComposableLambda12 = ComposableLambdaKt.rememberComposableLambda(-1856690802, true, new Function3() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return CopyOrMoveScreenKt.CopyOrMoveScreen$lambda$7(store, z5, stateCollectAsStateWithLifecycle, snackbarHostState3, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composer2 = composerStartRestartGroup;
                boolean z8 = z5;
                ScaffoldKt.m4038ScaffoldTvnljyQ(null, composableLambdaRememberComposableLambda9, composableLambdaRememberComposableLambda10, composableLambdaRememberComposableLambda11, null, 0, 0L, 0L, null, composableLambdaRememberComposableLambda12, composer2, 805309872, 497);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function2 = function3;
                z4 = z8;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CopyOrMoveScreenKt.CopyOrMoveScreen$lambda$8(store, function2, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z2 = z;
        if ((i3 & Token.DOTQUERY) != 146) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function2 = function1;
            z4 = z2;
        } else {
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2081498913, "CC(remember):CopyOrMoveScreen.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                function3 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                function3 = function1;
            }
            if (i4 != 0) {
                z5 = false;
            } else {
                z5 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2303293, i3, -1, "com.box.android.browse.cpl.copymove.CopyOrMoveScreen (CopyOrMoveScreen.kt:32)");
            }
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            if (CopyOrMoveScreen$lambda$1(stateCollectAsStateWithLifecycle).isClosing()) {
                function3.invoke();
            }
            if (CopyOrMoveScreen$lambda$1(stateCollectAsStateWithLifecycle).getCreateFolderState() != null) {
                composerStartRestartGroup.startReplaceGroup(-103256443);
            } else {
                composerStartRestartGroup.startReplaceGroup(-101750153);
                ComposerKt.sourceInformation(composerStartRestartGroup, "42@1668L50,39@1520L222");
                AnonymousClass2 anonymousClass5 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt.CopyOrMoveScreen.2
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((CopyOrMoveReducer.State) obj).getCreateFolderState();
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2081487377, "CC(remember):CopyOrMoveScreen.kt#9igjgp");
                copyOrMoveScreenKt$CopyOrMoveScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (copyOrMoveScreenKt$CopyOrMoveScreen$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    copyOrMoveScreenKt$CopyOrMoveScreen$3$1RememberedValue = CopyOrMoveScreenKt$CopyOrMoveScreen$3$1.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(copyOrMoveScreenKt$CopyOrMoveScreen$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CreateFolderDialogKt.CreateFolderDialog(store.ifScope(anonymousClass5, (Function1) ((KFunction) copyOrMoveScreenKt$CopyOrMoveScreen$3$1RememberedValue)), composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2081483875, "CC(remember):CopyOrMoveScreen.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final SnackbarHostState snackbarHostState4 = (SnackbarHostState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposableLambda composableLambdaRememberComposableLambda13 = ComposableLambdaKt.rememberComposableLambda(-782606087, true, new Function2() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CopyOrMoveScreenKt.CopyOrMoveScreen$lambda$4(store, stateCollectAsStateWithLifecycle, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            ComposableLambda composableLambdaRememberComposableLambda14 = ComposableLambdaKt.rememberComposableLambda(1702457624, true, new Function2() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CopyOrMoveScreenKt.CopyOrMoveScreen$lambda$5(store, stateCollectAsStateWithLifecycle, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            ComposableLambda composableLambdaRememberComposableLambda15 = ComposableLambdaKt.rememberComposableLambda(-107445961, true, new Function2() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CopyOrMoveScreenKt.CopyOrMoveScreen$lambda$6(snackbarHostState4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            ComposableLambda composableLambdaRememberComposableLambda16 = ComposableLambdaKt.rememberComposableLambda(-1856690802, true, new Function3() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CopyOrMoveScreenKt.CopyOrMoveScreen$lambda$7(store, z5, stateCollectAsStateWithLifecycle, snackbarHostState4, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54);
            composer2 = composerStartRestartGroup;
            boolean z9 = z5;
            ScaffoldKt.m4038ScaffoldTvnljyQ(null, composableLambdaRememberComposableLambda13, composableLambdaRememberComposableLambda14, composableLambdaRememberComposableLambda15, null, 0, 0L, 0L, null, composableLambdaRememberComposableLambda16, composer2, 805309872, 497);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function2 = function3;
            z4 = z9;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CopyOrMoveScreenKt.CopyOrMoveScreen$lambda$8(store, function2, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CopyOrMoveScreen$lambda$4(final Store store, State state, Composer composer, int i) {
        Function0 function0;
        ComposerKt.sourceInformation(composer, "C52@1907L42,53@1985L41,54@2054L88,51@1857L508:CopyOrMoveScreen.kt#oxn7jq");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-782606087, i, -1, "com.box.android.browse.cpl.copymove.CopyOrMoveScreen.<anonymous> (CopyOrMoveScreen.kt:51)");
            }
            String strFolderName = BoxBrowseToolbarsKt.folderName(CopyOrMoveScreen$lambda$1(state).getCurrentlyDisplayedFolder(), composer, 0);
            String strStringResource = StringResources_androidKt.stringResource(R.string.pick_destination, composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -465165967, "CC(remember):CopyOrMoveScreen.kt#9igjgp");
            boolean zChanged = composer.changed(store);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CopyOrMoveScreenKt.CopyOrMoveScreen$lambda$4$0$0(store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function1 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (CopyOrMoveScreen$lambda$1(state).getCreateFolderEnabled()) {
                composer.startReplaceGroup(-1535090164);
                ComposerKt.sourceInformation(composer, "58@2230L53");
                ComposerKt.sourceInformationMarkerStart(composer, -465160370, "CC(remember):CopyOrMoveScreen.kt#9igjgp");
                boolean zChanged2 = composer.changed(store);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CopyOrMoveScreenKt.CopyOrMoveScreen$lambda$4$1$0(store);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                function0 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1534993475);
                composer.endReplaceGroup();
                function0 = null;
            }
            BoxBrowseToolbarsKt.ItemPickerToolbar(strFolderName, strStringResource, function1, function0, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CopyOrMoveScreen$lambda$4$0$0(Store store) {
        store.send(CopyOrMoveReducer.Action.CloseScreen.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CopyOrMoveScreen$lambda$4$1$0(Store store) {
        store.send(CopyOrMoveReducer.Action.CreateFolder.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CopyOrMoveScreen$lambda$6(SnackbarHostState snackbarHostState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C65@2414L60:CopyOrMoveScreen.kt#oxn7jq");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-107445961, i, -1, "com.box.android.browse.cpl.copymove.CopyOrMoveScreen.<anonymous> (CopyOrMoveScreen.kt:65)");
            }
            SwipeableSnackbarHostKt.SwipeableSnackbarHost(snackbarHostState, null, composer, 6, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CopyOrMoveScreen$lambda$5(final Store store, State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C72@2707L60,77@2952L60,81@3058L31:CopyOrMoveScreen.kt#oxn7jq");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1702457624, i, -1, "com.box.android.browse.cpl.copymove.CopyOrMoveScreen.<anonymous> (CopyOrMoveScreen.kt:68)");
            }
            ButtonItem.TextButtonItem[] textButtonItemArr = new ButtonItem.TextButtonItem[2];
            int i2 = R.string.Copy;
            boolean canCopy = CopyOrMoveScreen$lambda$1(state).getCanCopy();
            ComposerKt.sourceInformationMarkerStart(composer, -320756620, "CC(remember):CopyOrMoveScreen.kt#9igjgp");
            boolean zChanged = composer.changed(store);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CopyOrMoveScreenKt.CopyOrMoveScreen$lambda$5$0$0(store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            textButtonItemArr[0] = new ButtonItem.TextButtonItem(canCopy, (Function0) objRememberedValue, i2);
            int i3 = R.string.Move;
            boolean canMove = CopyOrMoveScreen$lambda$1(state).getCanMove();
            ComposerKt.sourceInformationMarkerStart(composer, -320748780, "CC(remember):CopyOrMoveScreen.kt#9igjgp");
            boolean zChanged2 = composer.changed(store);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CopyOrMoveScreenKt.CopyOrMoveScreen$lambda$5$1$0(store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            textButtonItemArr[1] = new ButtonItem.TextButtonItem(canMove, (Function0) objRememberedValue2, i3);
            ButtonBarKt.ButtonBar((List<ButtonItem.TextButtonItem>) CollectionsKt.listOf((Object[]) textButtonItemArr), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CopyOrMoveScreen$lambda$5$0$0(Store store) {
        store.send(CopyOrMoveReducer.Action.CopyActionTriggered.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CopyOrMoveScreen$lambda$5$1$0(Store store) {
        store.send(CopyOrMoveReducer.Action.MoveActionTriggered.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CopyOrMoveScreen$lambda$7(final Store store, boolean z, State state, SnackbarHostState snackbarHostState, PaddingValues padding, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(padding, "padding");
        ComposerKt.sourceInformation(composer, "CN(padding)84@3127L1027,111@4182L67,111@4164L85:CopyOrMoveScreen.kt#oxn7jq");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(padding) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1856690802, i2, -1, "com.box.android.browse.cpl.copymove.CopyOrMoveScreen.<anonymous> (CopyOrMoveScreen.kt:84)");
            }
            Modifier modifierPadding = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), padding);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierPadding);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1261902665, "C:CopyOrMoveScreen.kt#oxn7jq");
            composer.startMovableGroup(1760408780, Integer.valueOf(CopyOrMoveScreen$lambda$1(state).getStack().size()));
            ComposerKt.sourceInformation(composer, "91@3427L275,103@3945L104,98@3719L411");
            ComposerKt.sourceInformationMarkerStart(composer, 1760410167, "CC(remember):CopyOrMoveScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = store.scope(new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$CopyOrMoveScreen$7$1$currentStore$1$1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((CopyOrMoveReducer.State) obj).getStack();
                    }
                }, CopyOrMoveScreen$lambda$1(state).getStack().size() - 1, CopyOrMoveScreenKt$CopyOrMoveScreen$7$1$currentStore$1$2.INSTANCE);
                composer.updateRememberedValue(objRememberedValue);
            }
            Store store2 = (Store) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierTestTag = TestTagKt.testTag(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), "BrowseScreen");
            ComposerKt.sourceInformationMarkerStart(composer, 1760426572, "CC(remember):CopyOrMoveScreen.kt#9igjgp");
            CopyOrMoveScreenKt$CopyOrMoveScreen$7$1$1$1 copyOrMoveScreenKt$CopyOrMoveScreen$7$1$1$1RememberedValue = composer.rememberedValue();
            if (copyOrMoveScreenKt$CopyOrMoveScreen$7$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                copyOrMoveScreenKt$CopyOrMoveScreen$7$1$1$1RememberedValue = new CopyOrMoveScreenKt$CopyOrMoveScreen$7$1$1$1(snackbarHostState, null);
                composer.updateRememberedValue(copyOrMoveScreenKt$CopyOrMoveScreen$7$1$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FolderListingScreenKt.FolderListingScreen(store2, modifierTestTag, null, null, (Function4) copyOrMoveScreenKt$CopyOrMoveScreen$7$1$1$1RememberedValue, z, composer, 6, 12);
            composer.endMovableGroup();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1868398383, "CC(remember):CopyOrMoveScreen.kt#9igjgp");
            boolean zChanged = composer.changed(store);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.browse.cpl.copymove.CopyOrMoveScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CopyOrMoveScreenKt.CopyOrMoveScreen$lambda$7$1$0(store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BackHandlerKt.BackHandler(true, (Function0) objRememberedValue2, composer, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CopyOrMoveScreen$lambda$7$1$0(Store store) {
        store.send(CopyOrMoveReducer.Action.GoBack.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final CopyOrMoveReducer.State CopyOrMoveScreen$lambda$1(State<CopyOrMoveReducer.State> state) {
        return state.getValue();
    }
}
