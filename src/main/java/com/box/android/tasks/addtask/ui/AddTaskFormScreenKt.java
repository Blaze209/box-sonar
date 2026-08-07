package com.box.android.tasks.addtask.ui;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.SwipeableSnackbarHostKt;
import com.box.android.base.compose.button.BoxIconButtonKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.button.model.ButtonItemIconResource;
import com.box.android.base.compose.divider.BoxHorizontalDividerKt;
import com.box.android.cpl.Store;
import com.box.android.domain.models.tasks.TaskType;
import com.box.android.tasks.R;
import com.box.android.tasks.addtask.cpl.AddTaskFormReducer;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AddTaskFormScreen.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a5\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\n\u001aA\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0012H\u0003¢\u0006\u0002\u0010\u0014¨\u0006\u0015²\u0006\n\u0010\u0016\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"AddTaskFormScreen", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$State;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action;", "modifier", "Landroidx/compose/ui/Modifier;", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "(Lcom/box/android/cpl/Store;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/runtime/Composer;II)V", "AddTaskFormTopBar", "titleRes", "", "isSubmitting", "", "isSaveEnabled", "onBackClick", "Lkotlin/Function0;", "onSaveClick", "(IZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "tasks_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AddTaskFormScreenKt {

    /* JADX INFO: compiled from: AddTaskFormScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TaskType.values().length];
            try {
                iArr[TaskType.GENERAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TaskType.APPROVAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskFormScreen$lambda$6(Store store, Modifier modifier, SnackbarHostState snackbarHostState, int i, int i2, Composer composer, int i3) {
        AddTaskFormScreen(store, modifier, snackbarHostState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskFormTopBar$lambda$1(int i, boolean z, boolean z2, Function0 function0, Function0 function1, int i2, Composer composer, int i3) {
        AddTaskFormTopBar(i, z, z2, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004b  */
    /* JADX WARN: Code duplicated, block: B:24:0x004e  */
    /* JADX WARN: Code duplicated, block: B:26:0x0052  */
    /* JADX WARN: Code duplicated, block: B:28:0x005a  */
    /* JADX WARN: Code duplicated, block: B:29:0x005c  */
    /* JADX WARN: Code duplicated, block: B:34:0x006a  */
    /* JADX WARN: Code duplicated, block: B:35:0x006c  */
    /* JADX WARN: Code duplicated, block: B:38:0x0075 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x0077  */
    /* JADX WARN: Code duplicated, block: B:40:0x007c  */
    /* JADX WARN: Code duplicated, block: B:43:0x0081  */
    /* JADX WARN: Code duplicated, block: B:45:0x0093  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:53:0x00d7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:55:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:60:0x0105  */
    /* JADX WARN: Code duplicated, block: B:61:0x0107  */
    /* JADX WARN: Code duplicated, block: B:64:0x0113  */
    /* JADX WARN: Code duplicated, block: B:65:0x0115  */
    /* JADX WARN: Code duplicated, block: B:68:0x011e  */
    /* JADX WARN: Code duplicated, block: B:72:0x012e  */
    /* JADX WARN: Code duplicated, block: B:75:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:77:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:80:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:82:? A[RETURN, SYNTHETIC] */
    public static final void AddTaskFormScreen(Store<AddTaskFormReducer.State, AddTaskFormReducer.Action> store, Modifier modifier, SnackbarHostState snackbarHostState, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        SnackbarHostState snackbarHostState2;
        int i5;
        boolean z;
        final Modifier modifier3;
        final SnackbarHostState snackbarHostState3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        final SnackbarHostState snackbarHostState4;
        State stateCollectAsStateWithLifecycle;
        int i6;
        int i7;
        String strStringResource;
        boolean z2;
        boolean z3;
        boolean z4;
        AddTaskFormScreenKt$AddTaskFormScreen$2$1 addTaskFormScreenKt$AddTaskFormScreen$2$1RememberedValue;
        Modifier modifier4;
        final State state;
        Object objRememberedValue;
        final Store<AddTaskFormReducer.State, AddTaskFormReducer.Action> store2 = store;
        Intrinsics.checkNotNullParameter(store2, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(-881919285);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AddTaskFormScreen)N(store,modifier,snackbarHostState)44@2029L32,46@2095L29,51@2337L41,52@2417L168,52@2383L202,63@2733L6,64@2798L11,66@2897L353,65@2834L44,75@3257L171,59@2591L837:AddTaskFormScreen.kt#184uln");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    snackbarHostState2 = snackbarHostState;
                    if (composerStartRestartGroup.changed(snackbarHostState2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i3 & Token.DOTQUERY) != 146) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    snackbarHostState3 = snackbarHostState2;
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1415870037, "CC(remember):AddTaskFormScreen.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new SnackbarHostState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        snackbarHostState4 = (SnackbarHostState) objRememberedValue;
                    } else {
                        snackbarHostState4 = snackbarHostState2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-881919285, i3, -1, "com.box.android.tasks.addtask.ui.AddTaskFormScreen (AddTaskFormScreen.kt:45)");
                    }
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    i6 = WhenMappings.$EnumSwitchMapping$0[AddTaskFormScreen$lambda$1(stateCollectAsStateWithLifecycle).getSelectedType().ordinal()];
                    if (i6 != 1) {
                        i7 = R.string.add_task_create_general_title;
                    } else {
                        if (i6 == 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        i7 = R.string.add_task_create_approval_title;
                    }
                    final int i9 = i7;
                    strStringResource = StringResources_androidKt.stringResource(R.string.add_task_failure, composerStartRestartGroup, 0);
                    Boolean boolValueOf = Boolean.valueOf(AddTaskFormScreen$lambda$1(stateCollectAsStateWithLifecycle).getSubmitError());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1415857485, "CC(remember):AddTaskFormScreen.kt#9igjgp");
                    boolean zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle);
                    if ((i3 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    boolean zChanged2 = zChanged | z2 | composerStartRestartGroup.changed(strStringResource);
                    if ((i3 & 14) == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    z4 = zChanged2 | z3;
                    addTaskFormScreenKt$AddTaskFormScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z4 || addTaskFormScreenKt$AddTaskFormScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        modifier4 = companion;
                        state = stateCollectAsStateWithLifecycle;
                        AddTaskFormScreenKt$AddTaskFormScreen$2$1 addTaskFormScreenKt$AddTaskFormScreen$2$1 = new AddTaskFormScreenKt$AddTaskFormScreen$2$1(snackbarHostState4, strStringResource, store, state, null);
                        store2 = store;
                        addTaskFormScreenKt$AddTaskFormScreen$2$1RememberedValue = addTaskFormScreenKt$AddTaskFormScreen$2$1;
                        composerStartRestartGroup.updateRememberedValue(addTaskFormScreenKt$AddTaskFormScreen$2$1RememberedValue);
                    } else {
                        state = stateCollectAsStateWithLifecycle;
                        store2 = store;
                        modifier4 = companion;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) addTaskFormScreenKt$AddTaskFormScreen$2$1RememberedValue, composerStartRestartGroup, 0);
                    Modifier modifier5 = modifier4;
                    ScaffoldKt.m4038ScaffoldTvnljyQ(TestTagKt.testTag(SizeKt.fillMaxSize$default(modifier4, 0.0f, r0, null), "AddTaskFormScreen"), ComposableLambdaKt.rememberComposableLambda(494713479, r0, new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AddTaskFormScreenKt.AddTaskFormScreen$lambda$3(i9, store2, state, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1641169723, r0, new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AddTaskFormScreenKt.AddTaskFormScreen$lambda$4(snackbarHostState4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, 0, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), 0L, WindowInsets_androidKt.getSafeDrawing(WindowInsets.INSTANCE, composerStartRestartGroup, 6), ComposableLambdaKt.rememberComposableLambda(-196601316, true, new Function3() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return AddTaskFormScreenKt.AddTaskFormScreen$lambda$5(store2, state, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 805309488, 180);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    snackbarHostState3 = snackbarHostState4;
                    modifier3 = modifier5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormScreenKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AddTaskFormScreenKt.AddTaskFormScreen$lambda$6(store2, modifier3, snackbarHostState3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            snackbarHostState2 = snackbarHostState;
            if ((i3 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                snackbarHostState3 = snackbarHostState2;
            } else {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1415870037, "CC(remember):AddTaskFormScreen.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new SnackbarHostState();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    snackbarHostState4 = (SnackbarHostState) objRememberedValue;
                } else {
                    snackbarHostState4 = snackbarHostState2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-881919285, i3, -1, "com.box.android.tasks.addtask.ui.AddTaskFormScreen (AddTaskFormScreen.kt:45)");
                }
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                i6 = WhenMappings.$EnumSwitchMapping$0[AddTaskFormScreen$lambda$1(stateCollectAsStateWithLifecycle).getSelectedType().ordinal()];
                if (i6 != 1) {
                    i7 = R.string.add_task_create_general_title;
                } else {
                    if (i6 == 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i7 = R.string.add_task_create_approval_title;
                }
                final int i10 = i7;
                strStringResource = StringResources_androidKt.stringResource(R.string.add_task_failure, composerStartRestartGroup, 0);
                Boolean boolValueOf2 = Boolean.valueOf(AddTaskFormScreen$lambda$1(stateCollectAsStateWithLifecycle).getSubmitError());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1415857485, "CC(remember):AddTaskFormScreen.kt#9igjgp");
                boolean zChanged3 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle);
                if ((i3 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean zChanged4 = zChanged3 | z2 | composerStartRestartGroup.changed(strStringResource);
                if ((i3 & 14) == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z4 = zChanged4 | z3;
                addTaskFormScreenKt$AddTaskFormScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (z4) {
                    modifier4 = companion;
                    state = stateCollectAsStateWithLifecycle;
                    AddTaskFormScreenKt$AddTaskFormScreen$2$1 addTaskFormScreenKt$AddTaskFormScreen$2$2 = new AddTaskFormScreenKt$AddTaskFormScreen$2$1(snackbarHostState4, strStringResource, store, state, null);
                    store2 = store;
                    addTaskFormScreenKt$AddTaskFormScreen$2$1RememberedValue = addTaskFormScreenKt$AddTaskFormScreen$2$2;
                    composerStartRestartGroup.updateRememberedValue(addTaskFormScreenKt$AddTaskFormScreen$2$1RememberedValue);
                } else {
                    modifier4 = companion;
                    state = stateCollectAsStateWithLifecycle;
                    AddTaskFormScreenKt$AddTaskFormScreen$2$1 addTaskFormScreenKt$AddTaskFormScreen$2$3 = new AddTaskFormScreenKt$AddTaskFormScreen$2$1(snackbarHostState4, strStringResource, store, state, null);
                    store2 = store;
                    addTaskFormScreenKt$AddTaskFormScreen$2$1RememberedValue = addTaskFormScreenKt$AddTaskFormScreen$2$3;
                    composerStartRestartGroup.updateRememberedValue(addTaskFormScreenKt$AddTaskFormScreen$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) addTaskFormScreenKt$AddTaskFormScreen$2$1RememberedValue, composerStartRestartGroup, 0);
                Modifier modifier6 = modifier4;
                ScaffoldKt.m4038ScaffoldTvnljyQ(TestTagKt.testTag(SizeKt.fillMaxSize$default(modifier4, 0.0f, r0, null), "AddTaskFormScreen"), ComposableLambdaKt.rememberComposableLambda(494713479, r0, new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AddTaskFormScreenKt.AddTaskFormScreen$lambda$3(i10, store2, state, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1641169723, r0, new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AddTaskFormScreenKt.AddTaskFormScreen$lambda$4(snackbarHostState4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, 0, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), 0L, WindowInsets_androidKt.getSafeDrawing(WindowInsets.INSTANCE, composerStartRestartGroup, 6), ComposableLambdaKt.rememberComposableLambda(-196601316, true, new Function3() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return AddTaskFormScreenKt.AddTaskFormScreen$lambda$5(store2, state, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805309488, 180);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                snackbarHostState3 = snackbarHostState4;
                modifier3 = modifier6;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AddTaskFormScreenKt.AddTaskFormScreen$lambda$6(store2, modifier3, snackbarHostState3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                snackbarHostState2 = snackbarHostState;
                if (composerStartRestartGroup.changed(snackbarHostState2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                snackbarHostState3 = snackbarHostState2;
            } else {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1415870037, "CC(remember):AddTaskFormScreen.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new SnackbarHostState();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    snackbarHostState4 = (SnackbarHostState) objRememberedValue;
                } else {
                    snackbarHostState4 = snackbarHostState2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-881919285, i3, -1, "com.box.android.tasks.addtask.ui.AddTaskFormScreen (AddTaskFormScreen.kt:45)");
                }
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                i6 = WhenMappings.$EnumSwitchMapping$0[AddTaskFormScreen$lambda$1(stateCollectAsStateWithLifecycle).getSelectedType().ordinal()];
                if (i6 != 1) {
                    i7 = R.string.add_task_create_general_title;
                } else {
                    if (i6 == 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i7 = R.string.add_task_create_approval_title;
                }
                final int i11 = i7;
                strStringResource = StringResources_androidKt.stringResource(R.string.add_task_failure, composerStartRestartGroup, 0);
                Boolean boolValueOf3 = Boolean.valueOf(AddTaskFormScreen$lambda$1(stateCollectAsStateWithLifecycle).getSubmitError());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1415857485, "CC(remember):AddTaskFormScreen.kt#9igjgp");
                boolean zChanged5 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle);
                if ((i3 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean zChanged6 = zChanged5 | z2 | composerStartRestartGroup.changed(strStringResource);
                if ((i3 & 14) == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z4 = zChanged6 | z3;
                addTaskFormScreenKt$AddTaskFormScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (z4) {
                    modifier4 = companion;
                    state = stateCollectAsStateWithLifecycle;
                    AddTaskFormScreenKt$AddTaskFormScreen$2$1 addTaskFormScreenKt$AddTaskFormScreen$2$4 = new AddTaskFormScreenKt$AddTaskFormScreen$2$1(snackbarHostState4, strStringResource, store, state, null);
                    store2 = store;
                    addTaskFormScreenKt$AddTaskFormScreen$2$1RememberedValue = addTaskFormScreenKt$AddTaskFormScreen$2$4;
                    composerStartRestartGroup.updateRememberedValue(addTaskFormScreenKt$AddTaskFormScreen$2$1RememberedValue);
                } else {
                    modifier4 = companion;
                    state = stateCollectAsStateWithLifecycle;
                    AddTaskFormScreenKt$AddTaskFormScreen$2$1 addTaskFormScreenKt$AddTaskFormScreen$2$5 = new AddTaskFormScreenKt$AddTaskFormScreen$2$1(snackbarHostState4, strStringResource, store, state, null);
                    store2 = store;
                    addTaskFormScreenKt$AddTaskFormScreen$2$1RememberedValue = addTaskFormScreenKt$AddTaskFormScreen$2$5;
                    composerStartRestartGroup.updateRememberedValue(addTaskFormScreenKt$AddTaskFormScreen$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) addTaskFormScreenKt$AddTaskFormScreen$2$1RememberedValue, composerStartRestartGroup, 0);
                Modifier modifier7 = modifier4;
                ScaffoldKt.m4038ScaffoldTvnljyQ(TestTagKt.testTag(SizeKt.fillMaxSize$default(modifier4, 0.0f, r0, null), "AddTaskFormScreen"), ComposableLambdaKt.rememberComposableLambda(494713479, r0, new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AddTaskFormScreenKt.AddTaskFormScreen$lambda$3(i11, store2, state, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1641169723, r0, new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AddTaskFormScreenKt.AddTaskFormScreen$lambda$4(snackbarHostState4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, 0, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), 0L, WindowInsets_androidKt.getSafeDrawing(WindowInsets.INSTANCE, composerStartRestartGroup, 6), ComposableLambdaKt.rememberComposableLambda(-196601316, true, new Function3() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return AddTaskFormScreenKt.AddTaskFormScreen$lambda$5(store2, state, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805309488, 180);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                snackbarHostState3 = snackbarHostState4;
                modifier3 = modifier7;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AddTaskFormScreenKt.AddTaskFormScreen$lambda$6(store2, modifier3, snackbarHostState3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        snackbarHostState2 = snackbarHostState;
        if ((i3 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            snackbarHostState3 = snackbarHostState2;
        } else {
            if (i8 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1415870037, "CC(remember):AddTaskFormScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new SnackbarHostState();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                snackbarHostState4 = (SnackbarHostState) objRememberedValue;
            } else {
                snackbarHostState4 = snackbarHostState2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-881919285, i3, -1, "com.box.android.tasks.addtask.ui.AddTaskFormScreen (AddTaskFormScreen.kt:45)");
            }
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            i6 = WhenMappings.$EnumSwitchMapping$0[AddTaskFormScreen$lambda$1(stateCollectAsStateWithLifecycle).getSelectedType().ordinal()];
            if (i6 != 1) {
                i7 = R.string.add_task_create_general_title;
            } else {
                if (i6 == 2) {
                    throw new NoWhenBranchMatchedException();
                }
                i7 = R.string.add_task_create_approval_title;
            }
            final int i12 = i7;
            strStringResource = StringResources_androidKt.stringResource(R.string.add_task_failure, composerStartRestartGroup, 0);
            Boolean boolValueOf4 = Boolean.valueOf(AddTaskFormScreen$lambda$1(stateCollectAsStateWithLifecycle).getSubmitError());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1415857485, "CC(remember):AddTaskFormScreen.kt#9igjgp");
            boolean zChanged7 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle);
            if ((i3 & 896) == 256) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean zChanged8 = zChanged7 | z2 | composerStartRestartGroup.changed(strStringResource);
            if ((i3 & 14) == 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            z4 = zChanged8 | z3;
            addTaskFormScreenKt$AddTaskFormScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z4) {
                modifier4 = companion;
                state = stateCollectAsStateWithLifecycle;
                AddTaskFormScreenKt$AddTaskFormScreen$2$1 addTaskFormScreenKt$AddTaskFormScreen$2$6 = new AddTaskFormScreenKt$AddTaskFormScreen$2$1(snackbarHostState4, strStringResource, store, state, null);
                store2 = store;
                addTaskFormScreenKt$AddTaskFormScreen$2$1RememberedValue = addTaskFormScreenKt$AddTaskFormScreen$2$6;
                composerStartRestartGroup.updateRememberedValue(addTaskFormScreenKt$AddTaskFormScreen$2$1RememberedValue);
            } else {
                modifier4 = companion;
                state = stateCollectAsStateWithLifecycle;
                AddTaskFormScreenKt$AddTaskFormScreen$2$1 addTaskFormScreenKt$AddTaskFormScreen$2$7 = new AddTaskFormScreenKt$AddTaskFormScreen$2$1(snackbarHostState4, strStringResource, store, state, null);
                store2 = store;
                addTaskFormScreenKt$AddTaskFormScreen$2$1RememberedValue = addTaskFormScreenKt$AddTaskFormScreen$2$7;
                composerStartRestartGroup.updateRememberedValue(addTaskFormScreenKt$AddTaskFormScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) addTaskFormScreenKt$AddTaskFormScreen$2$1RememberedValue, composerStartRestartGroup, 0);
            Modifier modifier8 = modifier4;
            ScaffoldKt.m4038ScaffoldTvnljyQ(TestTagKt.testTag(SizeKt.fillMaxSize$default(modifier4, 0.0f, r0, null), "AddTaskFormScreen"), ComposableLambdaKt.rememberComposableLambda(494713479, r0, new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddTaskFormScreenKt.AddTaskFormScreen$lambda$3(i12, store2, state, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1641169723, r0, new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddTaskFormScreenKt.AddTaskFormScreen$lambda$4(snackbarHostState4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, 0, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), 0L, WindowInsets_androidKt.getSafeDrawing(WindowInsets.INSTANCE, composerStartRestartGroup, 6), ComposableLambdaKt.rememberComposableLambda(-196601316, true, new Function3() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AddTaskFormScreenKt.AddTaskFormScreen$lambda$5(store2, state, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805309488, 180);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            snackbarHostState3 = snackbarHostState4;
            modifier3 = modifier8;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddTaskFormScreenKt.AddTaskFormScreen$lambda$6(store2, modifier3, snackbarHostState3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskFormScreen$lambda$4(SnackbarHostState snackbarHostState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C65@2836L40:AddTaskFormScreen.kt#184uln");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1641169723, i, -1, "com.box.android.tasks.addtask.ui.AddTaskFormScreen.<anonymous> (AddTaskFormScreen.kt:65)");
            }
            SwipeableSnackbarHostKt.SwipeableSnackbarHost(snackbarHostState, null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskFormScreen$lambda$3(int i, final Store store, State state, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C71@3097L49,72@3178L48,67@2911L329:AddTaskFormScreen.kt#184uln");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(494713479, i2, -1, "com.box.android.tasks.addtask.ui.AddTaskFormScreen.<anonymous> (AddTaskFormScreen.kt:67)");
            }
            boolean zIsSubmitting = AddTaskFormScreen$lambda$1(state).isSubmitting();
            boolean canSubmit = AddTaskFormScreen$lambda$1(state).getCanSubmit();
            ComposerKt.sourceInformationMarkerStart(composer, -1321710088, "CC(remember):AddTaskFormScreen.kt#9igjgp");
            boolean zChanged = composer.changed(store);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AddTaskFormScreenKt.AddTaskFormScreen$lambda$3$0$0(store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1321707497, "CC(remember):AddTaskFormScreen.kt#9igjgp");
            boolean zChanged2 = composer.changed(store);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AddTaskFormScreenKt.AddTaskFormScreen$lambda$3$1$0(store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AddTaskFormTopBar(i, zIsSubmitting, canSubmit, function0, (Function0) objRememberedValue2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskFormScreen$lambda$3$0$0(Store store) {
        store.send(AddTaskFormReducer.Action.Dismiss.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskFormScreen$lambda$3$1$0(Store store) {
        store.send(AddTaskFormReducer.Action.Submit.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskFormScreen$lambda$5(Store store, State state, PaddingValues paddingValues, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)76@3284L138:AddTaskFormScreen.kt#184uln");
        if ((i & 6) == 0) {
            i |= composer.changed(paddingValues) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-196601316, i, -1, "com.box.android.tasks.addtask.ui.AddTaskFormScreen.<anonymous> (AddTaskFormScreen.kt:76)");
            }
            AddTaskFormContentKt.AddTaskFormContent(AddTaskFormScreen$lambda$1(state), store, PaddingKt.padding(Modifier.INSTANCE, paddingValues), composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void AddTaskFormTopBar(final int i, final boolean z, final boolean z2, final Function0<Unit> function0, final Function0<Unit> function1, Composer composer, final int i2) {
        int i3;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-967540926);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AddTaskFormTopBar)N(titleRes,isSubmitting,isSaveEnabled,onBackClick,onSaveClick)93@3654L2241:AddTaskFormScreen.kt#184uln");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-967540926, i3, -1, "com.box.android.tasks.addtask.ui.AddTaskFormTopBar (AddTaskFormScreen.kt:92)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -950682207, "C95@3702L343,103@4076L495,113@4595L1107,138@5802L6,137@5743L105,94@3671L2187,141@5867L22:AddTaskFormScreen.kt#184uln");
            composer2 = composerStartRestartGroup;
            AppBarKt.m2784TopAppBarGHTll3U(ComposableLambdaKt.rememberComposableLambda(1051037044, true, new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddTaskFormScreenKt.AddTaskFormTopBar$lambda$0$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-879464782, true, new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddTaskFormScreenKt.AddTaskFormTopBar$lambda$0$1(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-549294935, true, new Function3() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AddTaskFormScreenKt.AddTaskFormTopBar$lambda$0$2(z, z2, function1, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), 0.0f, null, TopAppBarDefaults.INSTANCE.m4782topAppBarColors5tl4gsc(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11576getTopBarBackgroundSecondary0d7_KjU(), 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, TopAppBarDefaults.$stable << 18, 62), null, composer2, 3462, 178);
            BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer2, 0, 7);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddTaskFormScreenKt.AddTaskFormTopBar$lambda$1(i, z, z2, function0, function1, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskFormTopBar$lambda$0$0(int i, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C97@3753L24,98@3821L10,99@3920L6,96@3720L311:AddTaskFormScreen.kt#184uln");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1051037044, i2, -1, "com.box.android.tasks.addtask.ui.AddTaskFormTopBar.<anonymous>.<anonymous> (AddTaskFormScreen.kt:96)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(i, composer, 0), TestTagKt.testTag(Modifier.INSTANCE, "AddTaskFormScreen:Title"), BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m9104copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleLarge(), 0L, 0L, FontWeight.INSTANCE.getSemiBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 48, 0, 131064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskFormTopBar$lambda$0$1(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C108@4381L55,104@4094L463:AddTaskFormScreen.kt#184uln");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-879464782, i, -1, "com.box.android.tasks.addtask.ui.AddTaskFormTopBar.<anonymous>.<anonymous> (AddTaskFormScreen.kt:104)");
            }
            BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, function0, StringResources_androidKt.stringResource(com.box.android.base.R.string.back_button_talkback_label, composer, 0), new ButtonItemIconResource.DrawableResource(com.box.android.base.R.drawable.ic_arrow_left_secondary), false, 17, null), TestTagKt.testTag(Modifier.INSTANCE, "AddTaskFormScreen:BackButton"), null, 0L, 0.0f, composer, 48, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskFormTopBar$lambda$0$2(boolean z, boolean z2, Function0 function0, RowScope TopAppBar, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
        ComposerKt.sourceInformation(composer, "C:AddTaskFormScreen.kt#184uln");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-549294935, i, -1, "com.box.android.tasks.addtask.ui.AddTaskFormTopBar.<anonymous>.<anonymous> (AddTaskFormScreen.kt:114)");
            }
            if (z) {
                composer.startReplaceGroup(-219962494);
                ComposerKt.sourceInformation(composer, "120@4930L6,115@4653L367");
                ProgressIndicatorKt.m3993CircularProgressIndicator4lLiAd8(TestTagKt.testTag(SizeKt.m1266size3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(16), 0.0f, 11, null), Dp.m9687constructorimpl(24)), "AddTaskFormScreen:SubmitProgress"), BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), Dp.m9687constructorimpl(2), 0L, 0, 0.0f, composer, 390, 56);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-219545451);
                ComposerKt.sourceInformation(composer, "129@5411L47,124@5066L604");
                BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(z2, function0, StringResources_androidKt.stringResource(R.string.add_task_create_button, composer, 0), new ButtonItemIconResource.DrawableResource(com.box.android.base.R.drawable.ic_done_24), false, 16, null), TestTagKt.testTag(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(16), 0.0f, 11, null), "AddTaskFormScreen:SaveButton"), null, 0L, 0.0f, composer, 48, 28);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AddTaskFormReducer.State AddTaskFormScreen$lambda$1(State<AddTaskFormReducer.State> state) {
        return state.getValue();
    }
}
