package com.box.android.tasks.addtask.ui;

import android.content.Context;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.ModalBottomSheetKt;
import androidx.compose.material3.SheetState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.BoxModalBottomSheetKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.cpl.Wrapped;
import com.box.android.domain.models.tasks.TaskType;
import com.box.android.tasks.addtask.cpl.AddTaskFormReducer;
import com.box.android.tasks.addtask.cpl.AddTaskReducer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.jvm.KClassesJvm;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AddTaskScreen.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\n\u0010\b\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"AddTaskScreen", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$State;", "Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$Action;", "(Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "tasks_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AddTaskScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskScreen$lambda$6(Store store, int i, Composer composer, int i2) {
        AddTaskScreen(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void AddTaskScreen(final Store<AddTaskReducer.State, AddTaskReducer.Action> store, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(-175388718);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AddTaskScreen)N(store)33@1500L29,34@1561L7,36@1639L59,38@1716L57,38@1704L69:AddTaskScreen.kt#184uln");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-175388718, i2, -1, "com.box.android.tasks.addtask.ui.AddTaskScreen (AddTaskScreen.kt:32)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Context context = (Context) objConsume;
            ComponentActivity componentActivity = context instanceof ComponentActivity ? (ComponentActivity) context : null;
            SheetState sheetStateRememberModalBottomSheetState = ModalBottomSheetKt.rememberModalBottomSheetState(true, null, composerStartRestartGroup, 6, 2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1044823029, "CC(remember):AddTaskScreen.kt#9igjgp");
            int i3 = i2 & 14;
            boolean z = i3 == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.tasks.addtask.ui.AddTaskScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AddTaskScreenKt.AddTaskScreen$lambda$1$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BackHandlerKt.BackHandler(false, (Function0) objRememberedValue, composerStartRestartGroup, 0, 1);
            AddTaskReducer.State stateAddTaskScreen$lambda$0 = AddTaskScreen$lambda$0(stateCollectAsStateWithLifecycle);
            if (stateAddTaskScreen$lambda$0 instanceof AddTaskReducer.State.Done) {
                composerStartRestartGroup.startReplaceGroup(1970365955);
                ComposerKt.sourceInformation(composerStartRestartGroup, "44@1906L174,44@1867L213");
                Boolean boolValueOf = Boolean.valueOf(((AddTaskReducer.State.Done) stateAddTaskScreen$lambda$0).getSucceeded());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1044816832, "CC(remember):AddTaskScreen.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(stateAddTaskScreen$lambda$0) | composerStartRestartGroup.changedInstance(componentActivity);
                AddTaskScreenKt$AddTaskScreen$2$1 addTaskScreenKt$AddTaskScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || addTaskScreenKt$AddTaskScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    addTaskScreenKt$AddTaskScreen$2$1RememberedValue = new AddTaskScreenKt$AddTaskScreen$2$1(stateAddTaskScreen$lambda$0, componentActivity, null);
                    composerStartRestartGroup.updateRememberedValue(addTaskScreenKt$AddTaskScreen$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) addTaskScreenKt$AddTaskScreen$2$1RememberedValue, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (stateAddTaskScreen$lambda$0 instanceof AddTaskReducer.State.PickType) {
                composerStartRestartGroup.startReplaceGroup(1970678559);
                ComposerKt.sourceInformation(composerStartRestartGroup, "57@2368L11,63@2662L6,64@2723L6,54@2206L45,66@2806L161,53@2150L817");
                Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.INSTANCE, WindowInsetsKt.m1294onlybOOhFvg(WindowInsets_androidKt.getSafeDrawing(WindowInsets.INSTANCE, composerStartRestartGroup, 6), WindowInsetsSides.m1311plusgK_yJZ4(WindowInsetsSides.INSTANCE.m1321getHorizontalJoeWqyM(), WindowInsetsSides.INSTANCE.m1325getTopJoeWqyM()))), 0.0f, Dp.m9687constructorimpl(32), 0.0f, 0.0f, 13, null);
                long jM6849getTransparent0d7_KjU = Color.INSTANCE.m6849getTransparent0d7_KjU();
                long jM11500getAppPrimary0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU();
                long jM11498getAppBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU();
                float fM9707getUnspecifiedD9Ej5fM = Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1044807361, "CC(remember):AddTaskScreen.kt#9igjgp");
                boolean z2 = i3 == 4;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.tasks.addtask.ui.AddTaskScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AddTaskScreenKt.AddTaskScreen$lambda$3$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxModalBottomSheetKt.m11602BoxModalBottomSheet4erKP6g((Function0) objRememberedValue2, modifierM1222paddingqDBjuR0$default, sheetStateRememberModalBottomSheetState, fM9707getUnspecifiedD9Ej5fM, jM11498getAppBackground0d7_KjU, jM6849getTransparent0d7_KjU, jM11500getAppPrimary0d7_KjU, ComposableLambdaKt.rememberComposableLambda(-1484423677, true, new Function3() { // from class: com.box.android.tasks.addtask.ui.AddTaskScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return AddTaskScreenKt.AddTaskScreen$lambda$4(store, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 12782592, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                if (!(stateAddTaskScreen$lambda$0 instanceof AddTaskReducer.State.Form)) {
                    composerStartRestartGroup.startReplaceGroup(-1044819558);
                    composerStartRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composerStartRestartGroup.startReplaceGroup(1971523526);
                ComposerKt.sourceInformation(composerStartRestartGroup, "76@3130L27");
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(AddTaskReducer.State.Form.class);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1044777811, "CC(remember):AddTaskScreen.kt#9igjgp");
                AddTaskScreenKt$AddTaskScreen$formStore$1$1 addTaskScreenKt$AddTaskScreen$formStore$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (addTaskScreenKt$AddTaskScreen$formStore$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    addTaskScreenKt$AddTaskScreen$formStore$1$1RememberedValue = AddTaskScreenKt$AddTaskScreen$formStore$1$1.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(addTaskScreenKt$AddTaskScreen$formStore$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Function1<? super LocalAction, ? extends AddTaskReducer.Action> function1 = (Function1) ((KFunction) addTaskScreenKt$AddTaskScreen$formStore$1$1RememberedValue);
                AddTaskReducer.State value = store.getState().getValue();
                if (!(value instanceof AddTaskReducer.State.Form)) {
                    value = null;
                }
                Store storeScope = ((AddTaskReducer.State.Form) value) != null ? store.scope(KClassesJvm.getJvmName(orCreateKotlinClass), new Function1<AddTaskReducer.State, Wrapped<AddTaskFormReducer.State>>() { // from class: com.box.android.tasks.addtask.ui.AddTaskScreenKt$AddTaskScreen$$inlined$caseLet$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Wrapped<AddTaskFormReducer.State> invoke(AddTaskReducer.State globalState) {
                        AddTaskFormReducer.State action;
                        Intrinsics.checkNotNullParameter(globalState, "globalState");
                        if (!(globalState instanceof AddTaskReducer.State.Form)) {
                            globalState = null;
                        }
                        AddTaskReducer.State.Form form = (AddTaskReducer.State.Form) globalState;
                        if (form == null || (action = form.getAction()) == null) {
                            return null;
                        }
                        return StoreKt.wrap(action);
                    }
                }, function1) : null;
                if (storeScope != null) {
                    composerStartRestartGroup.startReplaceGroup(1971703884);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "79@3225L36");
                    AddTaskFormScreenKt.AddTaskFormScreen(storeScope, null, null, composerStartRestartGroup, 0, 6);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1968519440);
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddTaskScreenKt.AddTaskScreen$lambda$6(store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskScreen$lambda$1$0(Store store) {
        store.send(AddTaskReducer.Action.Dismiss.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskScreen$lambda$3$0(Store store) {
        store.send(AddTaskReducer.Action.Dismiss.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskScreen$lambda$4(final Store store, ColumnScope BoxModalBottomSheet, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(BoxModalBottomSheet, "$this$BoxModalBottomSheet");
        ComposerKt.sourceInformation(composer, "C68@2881L54,67@2824L129:AddTaskScreen.kt#184uln");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1484423677, i, -1, "com.box.android.tasks.addtask.ui.AddTaskScreen.<anonymous> (AddTaskScreen.kt:67)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -602008871, "CC(remember):AddTaskScreen.kt#9igjgp");
            boolean zChanged = composer.changed(store);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.tasks.addtask.ui.AddTaskScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AddTaskScreenKt.AddTaskScreen$lambda$4$0$0(store, (TaskType) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AddTaskTypePickerKt.AddTaskTypePickerContent((Function1) objRememberedValue, null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskScreen$lambda$4$0$0(Store store, TaskType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        store.send(new AddTaskReducer.Action.TypeSelected(it));
        return Unit.INSTANCE;
    }

    private static final AddTaskReducer.State AddTaskScreen$lambda$0(State<? extends AddTaskReducer.State> state) {
        return state.getValue();
    }
}
