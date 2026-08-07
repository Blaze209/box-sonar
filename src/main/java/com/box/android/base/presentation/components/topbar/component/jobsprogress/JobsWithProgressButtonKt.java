package com.box.android.base.presentation.components.topbar.component.jobsprogress;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.InteractiveComponentSizeKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.compose.LifecycleEffectKt;
import com.box.android.base.R;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.progressbar.BoxCircularProgressBarKt;
import com.box.android.cpl.Store;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: JobsWithProgressButton.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a9\u0010\u0000\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\r\u001a\r\u0010\u000e\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000f\u001a\r\u0010\u0010\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000f\u001a\r\u0010\u0011\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000f¨\u0006\u0012²\u0006\n\u0010\u0013\u001a\u00020\u000bX\u008a\u0084\u0002"}, d2 = {"JobsWithProgressButton", "", "viewModel", "Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressViewModel;", ViewProps.ON_CLICK, "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$State;", "Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressReducer$Action;", "(Lcom/box/android/cpl/Store;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "JobsButtonWithProgressPreview", "(Landroidx/compose/runtime/Composer;I)V", "JobsButtonWithProgressFailedPreview", "JobsButtonWithProgressDonePreview", "base_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class JobsWithProgressButtonKt {

    /* JADX INFO: compiled from: JobsWithProgressButton.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JobsProgressReducer.JobsCollectiveStatus.values().length];
            try {
                iArr[JobsProgressReducer.JobsCollectiveStatus.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JobsProgressReducer.JobsCollectiveStatus.DONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[JobsProgressReducer.JobsCollectiveStatus.IN_PROGRESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JobsButtonWithProgressDonePreview$lambda$0(int i, Composer composer, int i2) {
        JobsButtonWithProgressDonePreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JobsButtonWithProgressFailedPreview$lambda$0(int i, Composer composer, int i2) {
        JobsButtonWithProgressFailedPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JobsButtonWithProgressPreview$lambda$0(int i, Composer composer, int i2) {
        JobsButtonWithProgressPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JobsWithProgressButton$lambda$0(JobsProgressViewModel jobsProgressViewModel, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        JobsWithProgressButton(jobsProgressViewModel, (Function0<Unit>) function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JobsWithProgressButton$lambda$5(Store store, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        JobsWithProgressButton((Store<JobsProgressReducer.State, JobsProgressReducer.Action>) store, (Function0<Unit>) function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void JobsWithProgressButton(final JobsProgressViewModel viewModel, Function0<Unit> onClick, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function0;
        final Modifier modifier2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1044508112);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(JobsWithProgressButton)N(viewModel,onClick,modifier)33@1576L58:JobsWithProgressButton.kt#ojl5fy");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(viewModel) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            function0 = onClick;
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            Modifier modifier3 = modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1044508112, i3, -1, "com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsWithProgressButton (JobsWithProgressButton.kt:32)");
            }
            function0 = onClick;
            JobsWithProgressButton(viewModel.getStore(), function0, modifier3, composerStartRestartGroup, i3 & 1008, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function0<Unit> function1 = function0;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsWithProgressButtonKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return JobsWithProgressButtonKt.JobsWithProgressButton$lambda$0(viewModel, function1, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:30:0x0059  */
    /* JADX WARN: Code duplicated, block: B:31:0x005b  */
    /* JADX WARN: Code duplicated, block: B:34:0x0064 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0066  */
    /* JADX WARN: Code duplicated, block: B:36:0x006d  */
    /* JADX WARN: Code duplicated, block: B:39:0x0075  */
    /* JADX WARN: Code duplicated, block: B:42:0x0097  */
    /* JADX WARN: Code duplicated, block: B:43:0x0099  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:59:0x012b  */
    /* JADX WARN: Code duplicated, block: B:61:0x0131  */
    /* JADX WARN: Code duplicated, block: B:64:0x013b  */
    /* JADX WARN: Code duplicated, block: B:66:? A[RETURN, SYNTHETIC] */
    public static final void JobsWithProgressButton(final Store<JobsProgressReducer.State, JobsProgressReducer.Action> store, final Function0<Unit> function0, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        int i4;
        boolean z2;
        JobsWithProgressButtonKt$JobsWithProgressButton$2$1 jobsWithProgressButtonKt$JobsWithProgressButton$2$1RememberedValue;
        boolean z3;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(635956880);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(JobsWithProgressButton)N(store,onClick,modifier)42@1851L29,44@1907L77,44@1886L98,47@2037L59,47@1989L107,58@2293L1462,53@2148L1607:JobsWithProgressButton.kt#ojl5fy");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i5 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(635956880, i3, -1, "com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsWithProgressButton (JobsWithProgressButton.kt:41)");
                }
                State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1269213693, "CC(remember):JobsWithProgressButton.kt#9igjgp");
                i4 = i3 & 14;
                if (i4 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                jobsWithProgressButtonKt$JobsWithProgressButton$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2 || jobsWithProgressButtonKt$JobsWithProgressButton$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    jobsWithProgressButtonKt$JobsWithProgressButton$2$1RememberedValue = new JobsWithProgressButtonKt$JobsWithProgressButton$2$1(store, null);
                    composerStartRestartGroup.updateRememberedValue(jobsWithProgressButtonKt$JobsWithProgressButton$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) jobsWithProgressButtonKt$JobsWithProgressButton$2$1RememberedValue, composerStartRestartGroup, 6);
                Lifecycle.Event event = Lifecycle.Event.ON_RESUME;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1269217835, "CC(remember):JobsWithProgressButton.kt#9igjgp");
                z3 = i4 == 4;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsWithProgressButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return JobsWithProgressButtonKt.JobsWithProgressButton$lambda$3$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LifecycleEffectKt.LifecycleEventEffect(event, null, (Function0) objRememberedValue, composerStartRestartGroup, 6, 2);
                final JobsProgressReducer.StatusIndicationState status = JobsWithProgressButton$lambda$1(stateCollectAsStateWithLifecycle).getStatus();
                IconButtonKt.IconButton(function0, SizeKt.m1266size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier4), Dp.m9687constructorimpl(48)), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(1609355058, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsWithProgressButtonKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return JobsWithProgressButtonKt.JobsWithProgressButton$lambda$4(status, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 14) | 1572864, 60);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsWithProgressButtonKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return JobsWithProgressButtonKt.JobsWithProgressButton$lambda$5(store, function0, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i3 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i5 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(635956880, i3, -1, "com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsWithProgressButton (JobsWithProgressButton.kt:41)");
            }
            State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1269213693, "CC(remember):JobsWithProgressButton.kt#9igjgp");
            i4 = i3 & 14;
            if (i4 == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            jobsWithProgressButtonKt$JobsWithProgressButton$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                jobsWithProgressButtonKt$JobsWithProgressButton$2$1RememberedValue = new JobsWithProgressButtonKt$JobsWithProgressButton$2$1(store, null);
                composerStartRestartGroup.updateRememberedValue(jobsWithProgressButtonKt$JobsWithProgressButton$2$1RememberedValue);
            } else {
                jobsWithProgressButtonKt$JobsWithProgressButton$2$1RememberedValue = new JobsWithProgressButtonKt$JobsWithProgressButton$2$1(store, null);
                composerStartRestartGroup.updateRememberedValue(jobsWithProgressButtonKt$JobsWithProgressButton$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) jobsWithProgressButtonKt$JobsWithProgressButton$2$1RememberedValue, composerStartRestartGroup, 6);
            Lifecycle.Event event2 = Lifecycle.Event.ON_RESUME;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1269217835, "CC(remember):JobsWithProgressButton.kt#9igjgp");
            if (i4 == 4) {
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z3) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsWithProgressButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return JobsWithProgressButtonKt.JobsWithProgressButton$lambda$3$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsWithProgressButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return JobsWithProgressButtonKt.JobsWithProgressButton$lambda$3$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LifecycleEffectKt.LifecycleEventEffect(event2, null, (Function0) objRememberedValue, composerStartRestartGroup, 6, 2);
            final JobsProgressReducer.StatusIndicationState status2 = JobsWithProgressButton$lambda$1(stateCollectAsStateWithLifecycle2).getStatus();
            IconButtonKt.IconButton(function0, SizeKt.m1266size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier4), Dp.m9687constructorimpl(48)), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(1609355058, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsWithProgressButtonKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return JobsWithProgressButtonKt.JobsWithProgressButton$lambda$4(status2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 14) | 1572864, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsWithProgressButtonKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return JobsWithProgressButtonKt.JobsWithProgressButton$lambda$5(store, function0, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JobsWithProgressButton$lambda$3$0(Store store) {
        store.send(JobsProgressReducer.Action.Load.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JobsWithProgressButton$lambda$4(final JobsProgressReducer.StatusIndicationState statusIndicationState, Composer composer, int i) {
        BoxScopeInstance boxScopeInstance;
        int i2;
        int i3;
        long jM11540getNotificationContainer0d7_KjU;
        Composer composer2 = composer;
        ComposerKt.sourceInformation(composer2, "C59@2303L1446:JobsWithProgressButton.kt#ojl5fy");
        if (!composer2.shouldExecute((i & 3) != 2, i & 1)) {
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1609355058, i, -1, "com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsWithProgressButton.<anonymous> (JobsWithProgressButton.kt:59)");
            }
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer2);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -222299886, "C71@2842L48,72@2929L34,73@2997L6,70@2810L218:JobsWithProgressButton.kt#ojl5fy");
            if (statusIndicationState != null) {
                composer2.startReplaceGroup(-222278621);
                ComposerKt.sourceInformation(composer2, "64@2613L6,65@2681L6,63@2519L55,61@2411L371");
                Modifier modifierM1266size3ABfNKs = SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(40));
                long jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composer2, 6).m11533getMainActiveControl0d7_KjU();
                long jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(BoxTheme.INSTANCE.getColors(composer2, 6).m11533getMainActiveControl0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null);
                float fM9687constructorimpl = Dp.m9687constructorimpl(1);
                ComposerKt.sourceInformationMarkerStart(composer2, 1239758851, "CC(remember):JobsWithProgressButton.kt#9igjgp");
                boolean zChanged = composer2.changed(statusIndicationState);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsWithProgressButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(JobsWithProgressButtonKt.JobsWithProgressButton$lambda$4$0$0$0(statusIndicationState));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                i3 = 6;
                i2 = -224682826;
                boxScopeInstance = boxScopeInstance2;
                BoxCircularProgressBarKt.m11734BoxCircularProgressBarO8KfPlw(modifierM1266size3ABfNKs, null, jM11533getMainActiveControl0d7_KjU, jM6813copywmQWz5c$default, fM9687constructorimpl, 0, (Function0) objRememberedValue, composer, 24582, 34);
                composer2 = composer;
            } else {
                boxScopeInstance = boxScopeInstance2;
                i2 = -224682826;
                i3 = 6;
                composer2.startReplaceGroup(-224682826);
            }
            composer2.endReplaceGroup();
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_transfers_toolbar, composer2, 0), StringResources_androidKt.stringResource(R.string.transfers, composer2, 0), (Modifier) null, BoxTheme.INSTANCE.getColors(composer2, i3).m11500getAppPrimary0d7_KjU(), composer2, Painter.$stable, 4);
            if (statusIndicationState != null) {
                composer2.startReplaceGroup(-221608928);
                ComposerKt.sourceInformation(composer2, "83@3450L275");
                int i4 = WhenMappings.$EnumSwitchMapping$0[statusIndicationState.getCollectiveJobsStatus().ordinal()];
                if (i4 == 1) {
                    composer2.startReplaceGroup(1239781505);
                    ComposerKt.sourceInformation(composer2, "78@3221L6");
                    jM11540getNotificationContainer0d7_KjU = BoxTheme.INSTANCE.getColors(composer2, i3).m11540getNotificationContainer0d7_KjU();
                    composer2.endReplaceGroup();
                } else if (i4 == 2) {
                    composer2.startReplaceGroup(1239784278);
                    ComposerKt.sourceInformation(composer2, "79@3308L6");
                    jM11540getNotificationContainer0d7_KjU = BoxTheme.INSTANCE.getColors(composer2, i3).m11558getStatusDone0d7_KjU();
                    composer2.endReplaceGroup();
                } else {
                    if (i4 != 3) {
                        composer2.startReplaceGroup(1239778030);
                        composer2.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composer2.startReplaceGroup(1239786940);
                    ComposerKt.sourceInformation(composer2, "80@3391L6");
                    jM11540getNotificationContainer0d7_KjU = BoxTheme.INSTANCE.getColors(composer2, i3).m11559getStatusInProgress0d7_KjU();
                    composer2.endReplaceGroup();
                }
                BoxKt.Box(BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1266size3ABfNKs(PaddingKt.m1218padding3ABfNKs(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopEnd()), Dp.m9687constructorimpl(2)), Dp.m9687constructorimpl(9)), RoundedCornerShapeKt.getCircleShape()), jM11540getNotificationContainer0d7_KjU, null, 2, null), composer2, 0);
            } else {
                composer2.startReplaceGroup(i2);
            }
            composer2.endReplaceGroup();
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float JobsWithProgressButton$lambda$4$0$0$0(JobsProgressReducer.StatusIndicationState statusIndicationState) {
        return statusIndicationState.getCollectiveJobsProgress() / 100.0f;
    }

    private static final void JobsButtonWithProgressPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(746663356);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(JobsButtonWithProgressPreview)101@3892L432:JobsWithProgressButton.kt#ojl5fy");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(746663356, i, -1, "com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsButtonWithProgressPreview (JobsWithProgressButton.kt:100)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$JobsWithProgressButtonKt.INSTANCE.getLambda$212913607$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsWithProgressButtonKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return JobsWithProgressButtonKt.JobsButtonWithProgressPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void JobsButtonWithProgressFailedPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1730217473);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(JobsButtonWithProgressFailedPreview)119@4414L427:JobsWithProgressButton.kt#ojl5fy");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1730217473, i, -1, "com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsButtonWithProgressFailedPreview (JobsWithProgressButton.kt:118)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$JobsWithProgressButtonKt.INSTANCE.m11843getLambda$2068109878$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsWithProgressButtonKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return JobsWithProgressButtonKt.JobsButtonWithProgressFailedPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void JobsButtonWithProgressDonePreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1164719450);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(JobsButtonWithProgressDonePreview)137@4929L426:JobsWithProgressButton.kt#ojl5fy");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1164719450, i, -1, "com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsButtonWithProgressDonePreview (JobsWithProgressButton.kt:136)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$JobsWithProgressButtonKt.INSTANCE.getLambda$1164367845$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsWithProgressButtonKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return JobsWithProgressButtonKt.JobsButtonWithProgressDonePreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final JobsProgressReducer.State JobsWithProgressButton$lambda$1(State<JobsProgressReducer.State> state) {
        return state.getValue();
    }
}
