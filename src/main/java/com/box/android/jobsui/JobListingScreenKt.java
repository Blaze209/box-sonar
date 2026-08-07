package com.box.android.jobsui;

import android.content.Context;
import android.content.res.Configuration;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.FolderOpenKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.ConstraintLayoutScope;
import androidx.constraintlayout.compose.ConstraintSetForInlineDsl;
import androidx.constraintlayout.compose.Measurer;
import androidx.constraintlayout.compose.ToolingUtilsKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.media3.extractor.ts.PsExtractor;
import com.box.android.base.compose.ActionModeToolbarKt;
import com.box.android.base.compose.BoxCheckBoxKt;
import com.box.android.base.compose.BoxItemThumbnailKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.ItemStateScreensKt;
import com.box.android.base.compose.ItemThumbnail;
import com.box.android.base.compose.ItemsStateConfig;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.dialog.BoxAlertDialogKt;
import com.box.android.base.compose.divider.BoxHorizontalDividerKt;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.cpl.IdentifiedList;
import com.box.android.cpl.Store;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: JobListingScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aO\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r\u001a?\u0010\u000e\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH\u0003¢\u0006\u0002\u0010\u0010\u001a1\u0010\u0011\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0003¢\u0006\u0002\u0010\u0013\u001aE\u0010\u0014\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00032\b\b\u0002\u0010\u0017\u001a\u00020\f2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0003¢\u0006\u0002\u0010\u0019\u001a\u001d\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007¢\u0006\u0002\u0010\u001f\u001a%\u0010 \u001a\u00020\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\"¨\u0006#²\u0006\n\u0010\u0012\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010$\u001a\u00020\u0015X\u008a\u0084\u0002²\u0006\n\u0010%\u001a\u00020&X\u008a\u0084\u0002²\u0006\n\u0010'\u001a\u00020(X\u008a\u0084\u0002²\u0006\n\u0010)\u001a\u00020\fX\u008a\u0084\u0002"}, d2 = {"JobsUIScreen", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/jobsui/JobsReducer$State;", "Lcom/box/android/jobsui/JobsReducer$Action;", "handleClose", "Lkotlin/Function0;", "handleJobPreview", "Lkotlin/Function1;", "Lcom/box/android/jobsui/JobPreview;", "isRedesignedVersion", "", "(Lcom/box/android/cpl/Store;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)V", "JobsListScreen", "previewHelper", "(Lcom/box/android/cpl/Store;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;I)V", "JobItemsScreen", "jobsListState", "(Lcom/box/android/cpl/Store;Lcom/box/android/jobsui/JobsReducer$State;ZLandroidx/compose/runtime/Composer;I)V", "JobItem", "Lcom/box/android/jobsui/JobItemReducer$State;", "Lcom/box/android/jobsui/JobItemReducer$Action;", "isActionMode", "exitActionMode", "(Lcom/box/android/cpl/Store;ZLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;II)V", "ErrorText", "modifier", "Landroidx/compose/ui/Modifier;", "errorString", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "JobsUIToolbar", "onClose", "(Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;II)V", "jobsui_generalProdRelease", "jobState", "thumbnail", "Lcom/box/android/base/compose/ItemThumbnail;", "progressState", "Lcom/box/android/jobsui/JobStatusUIState;", "isEnabled"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class JobListingScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ErrorText$lambda$0(Modifier modifier, String str, int i, Composer composer, int i2) {
        ErrorText(modifier, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JobItem$lambda$10(Store store, boolean z, Function0 function0, boolean z2, int i, int i2, Composer composer, int i3) {
        JobItem(store, z, function0, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JobItemsScreen$lambda$1(Store store, JobsReducer.State state, boolean z, int i, Composer composer, int i2) {
        JobItemsScreen(store, state, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JobsListScreen$lambda$4(Store store, Function1 function1, boolean z, int i, Composer composer, int i2) {
        JobsListScreen(store, function1, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JobsUIScreen$lambda$2(Store store, Function0 function0, Function1 function1, boolean z, int i, int i2, Composer composer, int i3) {
        JobsUIScreen(store, function0, function1, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JobsUIToolbar$lambda$0(Function0 function0, boolean z, int i, int i2, Composer composer, int i3) {
        JobsUIToolbar(function0, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x007b  */
    /* JADX WARN: Code duplicated, block: B:38:0x007d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0086 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0088  */
    /* JADX WARN: Code duplicated, block: B:45:0x008f  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:49:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:55:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:56:0x0100  */
    /* JADX WARN: Code duplicated, block: B:59:0x010a  */
    /* JADX WARN: Code duplicated, block: B:61:? A[RETURN, SYNTHETIC] */
    public static final void JobsUIScreen(final Store<JobsReducer.State, JobsReducer.Action> store, final Function0<Unit> handleClose, final Function1<? super JobPreview, Unit> handleJobPreview, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        boolean z3;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final State stateCollectAsStateWithLifecycle;
        Object objConsume;
        boolean z5;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(handleClose, "handleClose");
        Intrinsics.checkNotNullParameter(handleJobPreview, "handleJobPreview");
        Composer composerStartRestartGroup = composer.startRestartGroup(318329140);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(JobsUIScreen)N(store,handleClose,handleJobPreview,isRedesignedVersion)72@3357L29,73@3422L11,73@3434L17,74@3495L7,80@3667L2363,80@3658L2372:JobListingScreen.kt#6w6mzd");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(handleClose) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(handleJobPreview) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 == 0) {
            if ((i & 3072) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
            }
            if ((i3 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z4 = z2;
            } else {
                if (i4 != 0) {
                    z2 = false;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(318329140, i3, -1, "com.box.android.jobsui.JobsUIScreen (JobListingScreen.kt:71)");
                }
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                final PaddingValues paddingValuesAsPaddingValues = WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getSafeDrawing(WindowInsets.INSTANCE, composerStartRestartGroup, 6), composerStartRestartGroup, 0);
                ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                objConsume = composerStartRestartGroup.consume(localConfiguration);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (((Configuration) objConsume).orientation == 2) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (JobsUIScreen$lambda$0(stateCollectAsStateWithLifecycle).isClosing()) {
                    handleClose.invoke();
                }
                z4 = z2;
                final boolean z6 = z5;
                BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(-840540417, true, new Function2() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return JobListingScreenKt.JobsUIScreen$lambda$1(z6, paddingValuesAsPaddingValues, store, z4, handleJobPreview, stateCollectAsStateWithLifecycle, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return JobListingScreenKt.JobsUIScreen$lambda$2(store, handleClose, handleJobPreview, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z2 = z;
        if ((i3 & 1171) != 1170) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            z4 = z2;
        } else {
            if (i4 != 0) {
                z2 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(318329140, i3, -1, "com.box.android.jobsui.JobsUIScreen (JobListingScreen.kt:71)");
            }
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            final PaddingValues paddingValuesAsPaddingValues2 = WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getSafeDrawing(WindowInsets.INSTANCE, composerStartRestartGroup, 6), composerStartRestartGroup, 0);
            ProvidableCompositionLocal<Configuration> localConfiguration2 = AndroidCompositionLocals_androidKt.getLocalConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            objConsume = composerStartRestartGroup.consume(localConfiguration2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (((Configuration) objConsume).orientation == 2) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (JobsUIScreen$lambda$0(stateCollectAsStateWithLifecycle).isClosing()) {
                handleClose.invoke();
            }
            z4 = z2;
            final boolean z7 = z5;
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(-840540417, true, new Function2() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return JobListingScreenKt.JobsUIScreen$lambda$1(z7, paddingValuesAsPaddingValues2, store, z4, handleJobPreview, stateCollectAsStateWithLifecycle, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return JobListingScreenKt.JobsUIScreen$lambda$2(store, handleClose, handleJobPreview, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JobsUIScreen$lambda$1(boolean z, PaddingValues paddingValues, final Store store, boolean z2, final Function1 function1, State state, Composer composer, int i) {
        Modifier.Companion companionM1222paddingqDBjuR0$default;
        boolean z3;
        int i2;
        ComposerKt.sourceInformation(composer, "C81@3677L2347:JobListingScreen.kt#6w6mzd");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-840540417, i, -1, "com.box.android.jobsui.JobsUIScreen.<anonymous> (JobListingScreen.kt:81)");
            }
            if (z) {
                companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, PaddingKt.calculateStartPadding(paddingValues, LayoutDirection.Ltr), 0.0f, PaddingKt.calculateEndPadding(paddingValues, LayoutDirection.Rtl), 0.0f, 10, null);
            } else {
                companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companionM1222paddingqDBjuR0$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, -2033773718, "C130@5815L126,128@5736L278:JobListingScreen.kt#6w6mzd");
            String str = "CC(remember):JobListingScreen.kt#9igjgp";
            if (JobsUIScreen$lambda$0(state).isActionMode()) {
                composer.startReplaceGroup(-2033758498);
                ComposerKt.sourceInformation(composer, "98@4358L49,101@4540L48,93@4136L639");
                int size = JobsUIScreen$lambda$0(state).getSelectedItems().size();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str2 = String.format(CommonBoxUtil.plural(R.array.n_items_selected, size), Arrays.copyOf(new Object[]{Integer.valueOf(size)}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                ComposerKt.sourceInformationMarkerStart(composer, 904234406, "CC(remember):JobListingScreen.kt#9igjgp");
                boolean zChanged = composer.changed(store);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return JobListingScreenKt.JobsUIScreen$lambda$1$0$0$0(store);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 904240229, "CC(remember):JobListingScreen.kt#9igjgp");
                boolean zChanged2 = composer.changed(store);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return JobListingScreenKt.JobsUIScreen$lambda$1$0$1$0(store);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                z3 = z2;
                ActionModeToolbarKt.ActionModeToolbar(str2, function0, CollectionsKt.listOf(new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue2, R.string.LS_Delete, 1, null)), z3, composer, 0, 0);
                if (!JobsUIScreen$lambda$0(state).isDeleting()) {
                    i2 = 0;
                    composer.startReplaceGroup(-2037830131);
                } else {
                    composer.startReplaceGroup(-2033024728);
                    ComposerKt.sourceInformation(composer, "113@5084L45,117@5326L49,108@4844L637");
                    int i3 = R.string.confirm_delete;
                    int i4 = R.string.job_delete_warning;
                    ComposerKt.sourceInformationMarkerStart(composer, 904257634, "CC(remember):JobListingScreen.kt#9igjgp");
                    boolean zChanged3 = composer.changed(store);
                    Object objRememberedValue3 = composer.rememberedValue();
                    if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return JobListingScreenKt.JobsUIScreen$lambda$1$0$2$0(store);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ButtonItem.TextButtonItem textButtonItem = new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue3, R.string.confirm_delete, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composer, 904265382, "CC(remember):JobListingScreen.kt#9igjgp");
                    boolean zChanged4 = composer.changed(store);
                    Object objRememberedValue4 = composer.rememberedValue();
                    if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return JobListingScreenKt.JobsUIScreen$lambda$1$0$3$0(store);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    i2 = 0;
                    BoxAlertDialogKt.m11705BoxAlertDialogSxpAMN0(i3, i4, textButtonItem, new ButtonItem.TextButtonItem(false, (Function0) objRememberedValue4, R.string.LO_Cancel, 1, null), null, null, 0L, 0L, composer, 0, PsExtractor.VIDEO_STREAM_MASK);
                }
                composer.endReplaceGroup();
                composer.endReplaceGroup();
            } else {
                z3 = z2;
                i2 = 0;
                str = "CC(remember):JobListingScreen.kt#9igjgp";
                composer.startReplaceGroup(-2032347967);
                ComposerKt.sourceInformation(composer, "124@5582L46,123@5537L172");
                ComposerKt.sourceInformationMarkerStart(composer, 904273571, str);
                boolean zChanged5 = composer.changed(store);
                Object objRememberedValue5 = composer.rememberedValue();
                if (zChanged5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return JobListingScreenKt.JobsUIScreen$lambda$1$0$4$0(store);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                JobsUIToolbar((Function0) objRememberedValue5, z3, composer, 0, 0);
                composer.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerStart(composer, 904281107, str);
            boolean zChanged6 = composer.changed(function1) | composer.changed(store);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChanged6 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return JobListingScreenKt.JobsUIScreen$lambda$1$0$5$0(function1, store, (JobPreview) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            JobsListScreen(store, (Function1) objRememberedValue6, z3, composer, i2);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JobsUIScreen$lambda$1$0$0$0(Store store) {
        store.send(JobsReducer.Action.ExitActionMode.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JobsUIScreen$lambda$1$0$1$0(Store store) {
        store.send(JobsReducer.Action.TriggerDelete.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JobsUIScreen$lambda$1$0$2$0(Store store) {
        store.send(JobsReducer.Action.DeleteJobs.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JobsUIScreen$lambda$1$0$3$0(Store store) {
        store.send(JobsReducer.Action.ExitActionMode.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JobsUIScreen$lambda$1$0$4$0(Store store) {
        store.send(JobsReducer.Action.CloseScreen.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JobsUIScreen$lambda$1$0$5$0(Function1 function1, Store store, JobPreview jobPreview) {
        function1.invoke(jobPreview);
        store.send(JobsReducer.Action.PreviewHandled.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final void JobsListScreen(final Store<JobsReducer.State, JobsReducer.Action> store, final Function1<? super JobPreview, Unit> function1, final boolean z, Composer composer, final int i) {
        int i2;
        int i3;
        int i4;
        boolean z2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1602822294);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(JobsListScreen)N(store,previewHelper,isRedesignedVersion)146@6247L29,179@7514L69,179@7466L117:JobListingScreen.kt#6w6mzd");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1602822294, i2, -1, "com.box.android.jobsui.JobsListScreen (JobListingScreen.kt:145)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            if (Intrinsics.areEqual(JobsListScreen$lambda$0(stateCollectAsStateWithLifecycle).getJobsLoadingState(), JobsReducer.JobsLoadingState.Loaded.INSTANCE)) {
                composerStartRestartGroup.startReplaceGroup(-1773442932);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1767133750);
                ComposerKt.sourceInformation(composerStartRestartGroup, "148@6387L61,148@6366L82");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1581024013, "CC(remember):JobListingScreen.kt#9igjgp");
                boolean z3 = (i2 & 14) == 4;
                JobListingScreenKt$JobsListScreen$1$1 jobListingScreenKt$JobsListScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (z3 || jobListingScreenKt$JobsListScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    jobListingScreenKt$JobsListScreen$1$1RememberedValue = new JobListingScreenKt$JobsListScreen$1$1(store, null);
                    composerStartRestartGroup.updateRememberedValue(jobListingScreenKt$JobsListScreen$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect((Object) true, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) jobListingScreenKt$JobsListScreen$1$1RememberedValue, composerStartRestartGroup, 6);
            }
            composerStartRestartGroup.endReplaceGroup();
            JobsReducer.JobsLoadingState jobsLoadingState = JobsListScreen$lambda$0(stateCollectAsStateWithLifecycle).getJobsLoadingState();
            if (jobsLoadingState instanceof JobsReducer.JobsLoadingState.Loading) {
                composerStartRestartGroup.startReplaceGroup(-1766941705);
                ComposerKt.sourceInformation(composerStartRestartGroup, "154@6564L61");
                ItemStateScreensKt.LoadingItemsScreen(null, z, composerStartRestartGroup, (i2 >> 3) & 112, 1);
                composerStartRestartGroup.endReplaceGroup();
                i3 = i2;
                i4 = 32;
                z2 = true;
            } else {
                if (!(jobsLoadingState instanceof JobsReducer.JobsLoadingState.Loaded)) {
                    composerStartRestartGroup.startReplaceGroup(-1581020769);
                    composerStartRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composerStartRestartGroup.startReplaceGroup(-1766784659);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if (JobsListScreen$lambda$0(stateCollectAsStateWithLifecycle).getJobsList().isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(-1766724922);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "159@6757L454");
                    z2 = true;
                    i3 = i2;
                    i4 = 32;
                    ItemStateScreensKt.m11654ItemsStateScreenV9fs2A(new ItemsStateConfig(R.drawable.ic_transfers140, CommonBoxUtil.LS(R.string.transfers_empty_headline), CommonBoxUtil.LS(R.string.transfers_empty_body), null, 8, null), "JobsEmptyScreen", SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), false, z, 0L, composerStartRestartGroup, ((i2 << 6) & 57344) | 432, 40);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    i3 = i2;
                    i4 = 32;
                    z2 = true;
                    composerStartRestartGroup.startReplaceGroup(-1766262185);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "170@7249L181");
                    JobItemsScreen(store, JobsListScreen$lambda$0(stateCollectAsStateWithLifecycle), z, composerStartRestartGroup, i3 & 910);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
            }
            JobPreview previewingJobItem = JobsListScreen$lambda$0(stateCollectAsStateWithLifecycle).getPreviewingJobItem();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1580987941, "CC(remember):JobListingScreen.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | ((i3 & 112) == i4 ? z2 : false);
            JobListingScreenKt$JobsListScreen$2$1 jobListingScreenKt$JobsListScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || jobListingScreenKt$JobsListScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                jobListingScreenKt$JobsListScreen$2$1RememberedValue = new JobListingScreenKt$JobsListScreen$2$1(function1, stateCollectAsStateWithLifecycle, null);
                composerStartRestartGroup.updateRememberedValue(jobListingScreenKt$JobsListScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(previewingJobItem, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) jobListingScreenKt$JobsListScreen$2$1RememberedValue, composerStartRestartGroup, 0);
            String errorText = JobsListScreen$lambda$0(stateCollectAsStateWithLifecycle).getErrorText();
            if (errorText == null) {
                composerStartRestartGroup.startReplaceGroup(-1765884792);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1765884791);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*184@7679L7");
                ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxPresentationUtils.displayToast(errorText, (Context) objConsume);
                store.send(JobsReducer.Action.HandledError.INSTANCE);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return JobListingScreenKt.JobsListScreen$lambda$4(store, function1, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void JobItemsScreen(final Store<JobsReducer.State, JobsReducer.Action> store, final JobsReducer.State state, final boolean z, Composer composer, final int i) {
        int i2;
        long jM11499getAppBackgroundAlt0d7_KjU;
        Composer composerStartRestartGroup = composer.startRestartGroup(-550335345);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(JobItemsScreen)N(store,jobsListState,isRedesignedVersion)199@8116L737,195@7925L928:JobListingScreen.kt#6w6mzd");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(state) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-550335345, i2, -1, "com.box.android.jobsui.JobItemsScreen (JobListingScreen.kt:194)");
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-591279908);
                ComposerKt.sourceInformation(composerStartRestartGroup, "198@8050L6");
                jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU();
            } else {
                composerStartRestartGroup.startReplaceGroup(-591278785);
                ComposerKt.sourceInformation(composerStartRestartGroup, "198@8085L6");
                jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11499getAppBackgroundAlt0d7_KjU();
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(modifierFillMaxSize$default, jM11499getAppBackgroundAlt0d7_KjU, null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -591277296, "CC(remember):JobListingScreen.kt#9igjgp");
            boolean zChangedInstance = ((i2 & 14) == 4) | composerStartRestartGroup.changedInstance(state) | ((i2 & 896) == 256);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return JobListingScreenKt.JobItemsScreen$lambda$0$0(state, store, z, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LazyDslKt.LazyColumn(modifierM589backgroundbw27NRU$default, null, null, false, null, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, 0, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return JobListingScreenKt.JobItemsScreen$lambda$1(store, state, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JobItemsScreen$lambda$0$0(JobsReducer.State state, final Store store, final boolean z, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final boolean zIsActionMode = state.isActionMode();
        final Function0 function0 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return JobListingScreenKt.JobItemsScreen$lambda$0$0$0(store);
            }
        };
        final IdentifiedList<String, JobItemReducer.State> jobsList = state.getJobsList();
        final Function1 function1 = new Function1() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobListingScreenKt.JobItemsScreen$lambda$0$0$1((JobItemReducer.State) obj);
            }
        };
        final JobListingScreenKt$JobItemsScreen$lambda$0$0$$inlined$items$default$1 jobListingScreenKt$JobItemsScreen$lambda$0$0$$inlined$items$default$1 = new Function1() { // from class: com.box.android.jobsui.JobListingScreenKt$JobItemsScreen$lambda$0$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(JobItemReducer.State state2) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((JobItemReducer.State) obj);
            }
        };
        LazyColumn.items(jobsList.size(), new Function1<Integer, Object>() { // from class: com.box.android.jobsui.JobListingScreenKt$JobItemsScreen$lambda$0$0$$inlined$items$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return function1.invoke(jobsList.get(i));
            }
        }, new Function1<Integer, Object>() { // from class: com.box.android.jobsui.JobListingScreenKt$JobItemsScreen$lambda$0$0$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return jobListingScreenKt$JobItemsScreen$lambda$0$0$$inlined$items$default$1.invoke(jobsList.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.box.android.jobsui.JobListingScreenKt$JobItemsScreen$lambda$0$0$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                if ((i2 & 6) == 0) {
                    i3 = (composer.changed(lazyItemScope) ? 4 : 2) | i2;
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= composer.changed(i) ? 32 : 16;
                }
                if (!composer.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                JobItemReducer.State state2 = (JobItemReducer.State) jobsList.get(i);
                composer.startReplaceGroup(1638883676);
                ComposerKt.sourceInformation(composer, "CN(job)*209@8526L33,205@8365L379:JobListingScreen.kt#6w6mzd");
                Store store2 = store;
                JobListingScreenKt$JobItemsScreen$1$1$2$1 jobListingScreenKt$JobItemsScreen$1$1$2$1 = new PropertyReference1Impl() { // from class: com.box.android.jobsui.JobListingScreenKt$JobItemsScreen$1$1$2$1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((JobsReducer.State) obj).getJobsList();
                    }
                };
                String identifier = state2.getJobItemId().getIdentifier();
                ComposerKt.sourceInformationMarkerStart(composer, -224222736, "CC(remember):JobListingScreen.kt#9igjgp");
                JobListingScreenKt$JobItemsScreen$1$1$2$2$1 jobListingScreenKt$JobItemsScreen$1$1$2$2$1RememberedValue = composer.rememberedValue();
                if (jobListingScreenKt$JobItemsScreen$1$1$2$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    jobListingScreenKt$JobItemsScreen$1$1$2$2$1RememberedValue = JobListingScreenKt$JobItemsScreen$1$1$2$2$1.INSTANCE;
                    composer.updateRememberedValue(jobListingScreenKt$JobItemsScreen$1$1$2$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                JobListingScreenKt.JobItem(store2.scope(jobListingScreenKt$JobItemsScreen$1$1$2$1, identifier, (Function2<? super String, ? super LocalAction, ? extends Action>) ((KFunction) jobListingScreenKt$JobItemsScreen$1$1$2$2$1RememberedValue)), zIsActionMode, function0, z, composer, 0, 0);
                if (z) {
                    composer.startReplaceGroup(1630569971);
                } else {
                    composer.startReplaceGroup(1639285373);
                    ComposerKt.sourceInformation(composer, "216@8801L22");
                    BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer, 0, 7);
                }
                composer.endReplaceGroup();
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JobItemsScreen$lambda$0$0$0(Store store) {
        store.send(JobsReducer.Action.ExitActionMode.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object JobItemsScreen$lambda$0$0$1(JobItemReducer.State it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getJobItemId().getIdentifier();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:101:0x01a6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:104:0x01b4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:105:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:106:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:108:0x01df  */
    /* JADX WARN: Code duplicated, block: B:112:0x020b  */
    /* JADX WARN: Code duplicated, block: B:113:0x020e  */
    /* JADX WARN: Code duplicated, block: B:116:0x0249  */
    /* JADX WARN: Code duplicated, block: B:118:0x0251  */
    /* JADX WARN: Code duplicated, block: B:121:0x025d  */
    /* JADX WARN: Code duplicated, block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:26:0x004b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0056  */
    /* JADX WARN: Code duplicated, block: B:34:0x0060  */
    /* JADX WARN: Code duplicated, block: B:35:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x0067  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0072  */
    /* JADX WARN: Code duplicated, block: B:45:0x0081  */
    /* JADX WARN: Code duplicated, block: B:46:0x0083  */
    /* JADX WARN: Code duplicated, block: B:49:0x008d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x008f  */
    /* JADX WARN: Code duplicated, block: B:51:0x0092  */
    /* JADX WARN: Code duplicated, block: B:54:0x0097  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:61:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:68:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:69:0x0101  */
    /* JADX WARN: Code duplicated, block: B:72:0x0109  */
    /* JADX WARN: Code duplicated, block: B:74:0x0111  */
    /* JADX WARN: Code duplicated, block: B:77:0x0126  */
    /* JADX WARN: Code duplicated, block: B:78:0x0129  */
    /* JADX WARN: Code duplicated, block: B:81:0x0131  */
    /* JADX WARN: Code duplicated, block: B:83:0x0139  */
    /* JADX WARN: Code duplicated, block: B:86:0x015e  */
    /* JADX WARN: Code duplicated, block: B:87:0x0161  */
    /* JADX WARN: Code duplicated, block: B:90:0x0169  */
    /* JADX WARN: Code duplicated, block: B:92:0x0171 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x0173 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:94:0x0175  */
    /* JADX WARN: Code duplicated, block: B:98:0x019f  */
    /* JADX WARN: Code duplicated, block: B:99:0x01a2  */
    public static final void JobItem(final Store<JobItemReducer.State, JobItemReducer.Action> store, boolean z, Function0<Unit> function0, boolean z2, Composer composer, final int i, final int i2) {
        int i3;
        boolean z3;
        int i4;
        Function0<Unit> function1;
        int i5;
        int i6;
        boolean z4;
        int i7;
        boolean z5;
        final boolean z6;
        final Function0<Unit> function2;
        final boolean z7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z8;
        Function0<Unit> function3;
        final boolean z9;
        int i8;
        boolean z10;
        Object objRememberedValue;
        Function0<Unit> function4;
        boolean z11;
        Object objRememberedValue2;
        Function0<Unit> function5;
        boolean zIsSelectableForAction;
        boolean z12;
        Object objRememberedValue3;
        MutableState mutableState;
        Function0<Unit> function6;
        Object objRememberedValue4;
        Function0<Unit> function7;
        float f;
        Object objRememberedValue5;
        Composer composerStartRestartGroup = composer.startRestartGroup(316914151);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(JobItem)N(store,isActionMode,exitActionMode,isRedesignedVersion)226@9021L2,229@9102L29,230@9172L29,231@9245L29,232@9311L51,233@9402L53,235@9547L162,261@10344L4015,240@9715L4644:JobListingScreen.kt#6w6mzd");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
            if ((i & 48) == 0) {
                z3 = z;
                i3 |= composerStartRestartGroup.changed(z3) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    function1 = function0;
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        z4 = z2;
                        if (composerStartRestartGroup.changed(z4)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((i3 & 1171) != 1170) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        z6 = z3;
                        function2 = function1;
                        z7 = z4;
                    } else {
                        if (i9 != 0) {
                            z8 = false;
                        } else {
                            z8 = z3;
                        }
                        if (i4 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388174295, "CC(remember):JobListingScreen.kt#9igjgp");
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function3 = (Function0) objRememberedValue5;
                        } else {
                            function3 = function1;
                        }
                        if (i6 != 0) {
                            z9 = false;
                        } else {
                            z9 = z4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(316914151, i3, -1, "com.box.android.jobsui.JobItem (JobListingScreen.kt:228)");
                        }
                        final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                        final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(JobItem$lambda$1(stateCollectAsStateWithLifecycle).getThumbnail(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                        final State stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(JobItem$lambda$1(stateCollectAsStateWithLifecycle).getProgress(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388164966, "CC(remember):JobListingScreen.kt#9igjgp");
                        i8 = i3 & 14;
                        if (i8 == 4) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return JobListingScreenKt.JobItem$lambda$4$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function4 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388162052, "CC(remember):JobListingScreen.kt#9igjgp");
                        if (i8 == 4) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z11 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return JobListingScreenKt.JobItem$lambda$5$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        function5 = (Function0) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        zIsSelectableForAction = JobItemReducer.INSTANCE.isSelectableForAction(JobItem$lambda$3(stateCollectAsStateWithLifecycle3).getJobStatus());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388157303, "CC(remember):JobListingScreen.kt#9igjgp");
                        if ((i3 & 112) == 32) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z12 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z8 || zIsSelectableForAction), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        mutableState = (MutableState) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, JobItem$lambda$1(stateCollectAsStateWithLifecycle).getTitle());
                        boolean zJobItem$lambda$7 = JobItem$lambda$7(mutableState);
                        if (z8) {
                            function6 = function5;
                        } else {
                            function6 = function4;
                        }
                        if (zIsSelectableForAction || z8) {
                            if (z8) {
                                composerStartRestartGroup.startReplaceGroup(-388137739);
                                composerStartRestartGroup.endReplaceGroup();
                                function7 = function3;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(852676745);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "256@10233L2");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388135511, "CC(remember):JobListingScreen.kt#9igjgp");
                                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue4 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda8
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                }
                                function5 = (Function0) objRememberedValue4;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            Modifier modifierM642combinedClickablehoGz1lA$default = ClickableKt.m642combinedClickablehoGz1lA$default(modifierTestTag, zJobItem$lambda$7, null, null, null, function7, null, false, null, function6, 238, null);
                            if (JobItem$lambda$7(mutableState)) {
                                f = 1.0f;
                            } else {
                                f = 0.5f;
                            }
                            final boolean z13 = z8;
                            SurfaceKt.m4323SurfaceT9BRK9s(AlphaKt.alpha(modifierM642combinedClickablehoGz1lA$default, f), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1644117524, true, new Function2() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return JobListingScreenKt.JobItem$lambda$9(z13, store, z9, stateCollectAsStateWithLifecycle, stateCollectAsStateWithLifecycle2, stateCollectAsStateWithLifecycle3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 126);
                            composerStartRestartGroup = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z13;
                            z7 = z9;
                            function2 = function3;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-388139465);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        function7 = function5;
                        Modifier modifierM642combinedClickablehoGz1lA$default2 = ClickableKt.m642combinedClickablehoGz1lA$default(modifierTestTag, zJobItem$lambda$7, null, null, null, function7, null, false, null, function6, 238, null);
                        if (JobItem$lambda$7(mutableState)) {
                            f = 1.0f;
                        } else {
                            f = 0.5f;
                        }
                        final boolean z14 = z8;
                        SurfaceKt.m4323SurfaceT9BRK9s(AlphaKt.alpha(modifierM642combinedClickablehoGz1lA$default2, f), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1644117524, true, new Function2() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return JobListingScreenKt.JobItem$lambda$9(z14, store, z9, stateCollectAsStateWithLifecycle, stateCollectAsStateWithLifecycle2, stateCollectAsStateWithLifecycle3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 126);
                        composerStartRestartGroup = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z14;
                        z7 = z9;
                        function2 = function3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return JobListingScreenKt.JobItem$lambda$10(store, z6, function2, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 3072;
                z4 = z2;
                if ((i3 & 1171) != 1170) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    z6 = z3;
                    function2 = function1;
                    z7 = z4;
                } else {
                    if (i9 != 0) {
                        z8 = false;
                    } else {
                        z8 = z3;
                    }
                    if (i4 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388174295, "CC(remember):JobListingScreen.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function3 = (Function0) objRememberedValue5;
                    } else {
                        function3 = function1;
                    }
                    if (i6 != 0) {
                        z9 = false;
                    } else {
                        z9 = z4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(316914151, i3, -1, "com.box.android.jobsui.JobItem (JobListingScreen.kt:228)");
                    }
                    final State stateCollectAsStateWithLifecycle4 = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    final State stateCollectAsStateWithLifecycle5 = FlowExtKt.collectAsStateWithLifecycle(JobItem$lambda$1(stateCollectAsStateWithLifecycle4).getThumbnail(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    final State stateCollectAsStateWithLifecycle6 = FlowExtKt.collectAsStateWithLifecycle(JobItem$lambda$1(stateCollectAsStateWithLifecycle4).getProgress(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388164966, "CC(remember):JobListingScreen.kt#9igjgp");
                    i8 = i3 & 14;
                    if (i8 == 4) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z10) {
                        objRememberedValue = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return JobListingScreenKt.JobItem$lambda$4$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return JobListingScreenKt.JobItem$lambda$4$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function4 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388162052, "CC(remember):JobListingScreen.kt#9igjgp");
                    if (i8 == 4) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z11) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return JobListingScreenKt.JobItem$lambda$5$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return JobListingScreenKt.JobItem$lambda$5$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    function5 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    zIsSelectableForAction = JobItemReducer.INSTANCE.isSelectableForAction(JobItem$lambda$3(stateCollectAsStateWithLifecycle6).getJobStatus());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388157303, "CC(remember):JobListingScreen.kt#9igjgp");
                    if ((i3 & 112) == 32) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z12) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z8 || zIsSelectableForAction), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z8 || zIsSelectableForAction), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState = (MutableState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierTestTag2 = TestTagKt.testTag(Modifier.INSTANCE, JobItem$lambda$1(stateCollectAsStateWithLifecycle4).getTitle());
                    boolean zJobItem$lambda$8 = JobItem$lambda$7(mutableState);
                    if (z8) {
                        function6 = function5;
                    } else {
                        function6 = function4;
                    }
                    if (zIsSelectableForAction) {
                        if (z8) {
                            composerStartRestartGroup.startReplaceGroup(-388137739);
                            composerStartRestartGroup.endReplaceGroup();
                            function7 = function3;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(852676745);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "256@10233L2");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388135511, "CC(remember):JobListingScreen.kt#9igjgp");
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            function5 = (Function0) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                            function7 = function5;
                        }
                    } else if (z8) {
                        composerStartRestartGroup.startReplaceGroup(-388137739);
                        composerStartRestartGroup.endReplaceGroup();
                        function7 = function3;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(852676745);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "256@10233L2");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388135511, "CC(remember):JobListingScreen.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        function5 = (Function0) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        function7 = function5;
                    }
                    Modifier modifierM642combinedClickablehoGz1lA$default3 = ClickableKt.m642combinedClickablehoGz1lA$default(modifierTestTag2, zJobItem$lambda$8, null, null, null, function7, null, false, null, function6, 238, null);
                    if (JobItem$lambda$7(mutableState)) {
                        f = 1.0f;
                    } else {
                        f = 0.5f;
                    }
                    final boolean z15 = z8;
                    SurfaceKt.m4323SurfaceT9BRK9s(AlphaKt.alpha(modifierM642combinedClickablehoGz1lA$default3, f), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1644117524, true, new Function2() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return JobListingScreenKt.JobItem$lambda$9(z15, store, z9, stateCollectAsStateWithLifecycle4, stateCollectAsStateWithLifecycle5, stateCollectAsStateWithLifecycle6, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 126);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z15;
                    z7 = z9;
                    function2 = function3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return JobListingScreenKt.JobItem$lambda$10(store, z6, function2, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            function1 = function0;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i3 & 1171) != 1170) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    z6 = z3;
                    function2 = function1;
                    z7 = z4;
                } else {
                    if (i9 != 0) {
                        z8 = false;
                    } else {
                        z8 = z3;
                    }
                    if (i4 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388174295, "CC(remember):JobListingScreen.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function3 = (Function0) objRememberedValue5;
                    } else {
                        function3 = function1;
                    }
                    if (i6 != 0) {
                        z9 = false;
                    } else {
                        z9 = z4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(316914151, i3, -1, "com.box.android.jobsui.JobItem (JobListingScreen.kt:228)");
                    }
                    final State stateCollectAsStateWithLifecycle7 = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    final State stateCollectAsStateWithLifecycle8 = FlowExtKt.collectAsStateWithLifecycle(JobItem$lambda$1(stateCollectAsStateWithLifecycle7).getThumbnail(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    final State stateCollectAsStateWithLifecycle9 = FlowExtKt.collectAsStateWithLifecycle(JobItem$lambda$1(stateCollectAsStateWithLifecycle7).getProgress(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388164966, "CC(remember):JobListingScreen.kt#9igjgp");
                    i8 = i3 & 14;
                    if (i8 == 4) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z10) {
                        objRememberedValue = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return JobListingScreenKt.JobItem$lambda$4$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return JobListingScreenKt.JobItem$lambda$4$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function4 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388162052, "CC(remember):JobListingScreen.kt#9igjgp");
                    if (i8 == 4) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z11) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return JobListingScreenKt.JobItem$lambda$5$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return JobListingScreenKt.JobItem$lambda$5$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    function5 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    zIsSelectableForAction = JobItemReducer.INSTANCE.isSelectableForAction(JobItem$lambda$3(stateCollectAsStateWithLifecycle9).getJobStatus());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388157303, "CC(remember):JobListingScreen.kt#9igjgp");
                    if ((i3 & 112) == 32) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z12) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z8 || zIsSelectableForAction), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z8 || zIsSelectableForAction), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState = (MutableState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierTestTag3 = TestTagKt.testTag(Modifier.INSTANCE, JobItem$lambda$1(stateCollectAsStateWithLifecycle7).getTitle());
                    boolean zJobItem$lambda$9 = JobItem$lambda$7(mutableState);
                    if (z8) {
                        function6 = function5;
                    } else {
                        function6 = function4;
                    }
                    if (zIsSelectableForAction) {
                        if (z8) {
                            composerStartRestartGroup.startReplaceGroup(-388137739);
                            composerStartRestartGroup.endReplaceGroup();
                            function7 = function3;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(852676745);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "256@10233L2");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388135511, "CC(remember):JobListingScreen.kt#9igjgp");
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            function5 = (Function0) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                            function7 = function5;
                        }
                    } else if (z8) {
                        composerStartRestartGroup.startReplaceGroup(-388137739);
                        composerStartRestartGroup.endReplaceGroup();
                        function7 = function3;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(852676745);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "256@10233L2");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388135511, "CC(remember):JobListingScreen.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        function5 = (Function0) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        function7 = function5;
                    }
                    Modifier modifierM642combinedClickablehoGz1lA$default4 = ClickableKt.m642combinedClickablehoGz1lA$default(modifierTestTag3, zJobItem$lambda$9, null, null, null, function7, null, false, null, function6, 238, null);
                    if (JobItem$lambda$7(mutableState)) {
                        f = 1.0f;
                    } else {
                        f = 0.5f;
                    }
                    final boolean z16 = z8;
                    SurfaceKt.m4323SurfaceT9BRK9s(AlphaKt.alpha(modifierM642combinedClickablehoGz1lA$default4, f), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1644117524, true, new Function2() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return JobListingScreenKt.JobItem$lambda$9(z16, store, z9, stateCollectAsStateWithLifecycle7, stateCollectAsStateWithLifecycle8, stateCollectAsStateWithLifecycle9, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 126);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z16;
                    z7 = z9;
                    function2 = function3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return JobListingScreenKt.JobItem$lambda$10(store, z6, function2, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z4 = z2;
            if ((i3 & 1171) != 1170) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z6 = z3;
                function2 = function1;
                z7 = z4;
            } else {
                if (i9 != 0) {
                    z8 = false;
                } else {
                    z8 = z3;
                }
                if (i4 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388174295, "CC(remember):JobListingScreen.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function3 = (Function0) objRememberedValue5;
                } else {
                    function3 = function1;
                }
                if (i6 != 0) {
                    z9 = false;
                } else {
                    z9 = z4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(316914151, i3, -1, "com.box.android.jobsui.JobItem (JobListingScreen.kt:228)");
                }
                final State stateCollectAsStateWithLifecycle10 = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                final State stateCollectAsStateWithLifecycle11 = FlowExtKt.collectAsStateWithLifecycle(JobItem$lambda$1(stateCollectAsStateWithLifecycle10).getThumbnail(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                final State stateCollectAsStateWithLifecycle12 = FlowExtKt.collectAsStateWithLifecycle(JobItem$lambda$1(stateCollectAsStateWithLifecycle10).getProgress(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388164966, "CC(remember):JobListingScreen.kt#9igjgp");
                i8 = i3 & 14;
                if (i8 == 4) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z10) {
                    objRememberedValue = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return JobListingScreenKt.JobItem$lambda$4$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return JobListingScreenKt.JobItem$lambda$4$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                function4 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388162052, "CC(remember):JobListingScreen.kt#9igjgp");
                if (i8 == 4) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z11) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return JobListingScreenKt.JobItem$lambda$5$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return JobListingScreenKt.JobItem$lambda$5$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                function5 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                zIsSelectableForAction = JobItemReducer.INSTANCE.isSelectableForAction(JobItem$lambda$3(stateCollectAsStateWithLifecycle12).getJobStatus());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388157303, "CC(remember):JobListingScreen.kt#9igjgp");
                if ((i3 & 112) == 32) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z12) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z8 || zIsSelectableForAction), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z8 || zIsSelectableForAction), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableState = (MutableState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierTestTag4 = TestTagKt.testTag(Modifier.INSTANCE, JobItem$lambda$1(stateCollectAsStateWithLifecycle10).getTitle());
                boolean zJobItem$lambda$10 = JobItem$lambda$7(mutableState);
                if (z8) {
                    function6 = function5;
                } else {
                    function6 = function4;
                }
                if (zIsSelectableForAction) {
                    if (z8) {
                        composerStartRestartGroup.startReplaceGroup(-388137739);
                        composerStartRestartGroup.endReplaceGroup();
                        function7 = function3;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(852676745);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "256@10233L2");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388135511, "CC(remember):JobListingScreen.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        function5 = (Function0) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        function7 = function5;
                    }
                } else if (z8) {
                    composerStartRestartGroup.startReplaceGroup(-388137739);
                    composerStartRestartGroup.endReplaceGroup();
                    function7 = function3;
                } else {
                    composerStartRestartGroup.startReplaceGroup(852676745);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "256@10233L2");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388135511, "CC(remember):JobListingScreen.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    function5 = (Function0) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    function7 = function5;
                }
                Modifier modifierM642combinedClickablehoGz1lA$default5 = ClickableKt.m642combinedClickablehoGz1lA$default(modifierTestTag4, zJobItem$lambda$10, null, null, null, function7, null, false, null, function6, 238, null);
                if (JobItem$lambda$7(mutableState)) {
                    f = 1.0f;
                } else {
                    f = 0.5f;
                }
                final boolean z17 = z8;
                SurfaceKt.m4323SurfaceT9BRK9s(AlphaKt.alpha(modifierM642combinedClickablehoGz1lA$default5, f), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1644117524, true, new Function2() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return JobListingScreenKt.JobItem$lambda$9(z17, store, z9, stateCollectAsStateWithLifecycle10, stateCollectAsStateWithLifecycle11, stateCollectAsStateWithLifecycle12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 126);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z17;
                z7 = z9;
                function2 = function3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return JobListingScreenKt.JobItem$lambda$10(store, z6, function2, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        z3 = z;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                function1 = function0;
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i3 & 1171) != 1170) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    z6 = z3;
                    function2 = function1;
                    z7 = z4;
                } else {
                    if (i9 != 0) {
                        z8 = false;
                    } else {
                        z8 = z3;
                    }
                    if (i4 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388174295, "CC(remember):JobListingScreen.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function3 = (Function0) objRememberedValue5;
                    } else {
                        function3 = function1;
                    }
                    if (i6 != 0) {
                        z9 = false;
                    } else {
                        z9 = z4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(316914151, i3, -1, "com.box.android.jobsui.JobItem (JobListingScreen.kt:228)");
                    }
                    final State stateCollectAsStateWithLifecycle13 = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    final State stateCollectAsStateWithLifecycle14 = FlowExtKt.collectAsStateWithLifecycle(JobItem$lambda$1(stateCollectAsStateWithLifecycle13).getThumbnail(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    final State stateCollectAsStateWithLifecycle15 = FlowExtKt.collectAsStateWithLifecycle(JobItem$lambda$1(stateCollectAsStateWithLifecycle13).getProgress(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388164966, "CC(remember):JobListingScreen.kt#9igjgp");
                    i8 = i3 & 14;
                    if (i8 == 4) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z10) {
                        objRememberedValue = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return JobListingScreenKt.JobItem$lambda$4$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return JobListingScreenKt.JobItem$lambda$4$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function4 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388162052, "CC(remember):JobListingScreen.kt#9igjgp");
                    if (i8 == 4) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z11) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return JobListingScreenKt.JobItem$lambda$5$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return JobListingScreenKt.JobItem$lambda$5$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    function5 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    zIsSelectableForAction = JobItemReducer.INSTANCE.isSelectableForAction(JobItem$lambda$3(stateCollectAsStateWithLifecycle15).getJobStatus());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388157303, "CC(remember):JobListingScreen.kt#9igjgp");
                    if ((i3 & 112) == 32) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z12) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z8 || zIsSelectableForAction), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z8 || zIsSelectableForAction), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState = (MutableState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierTestTag5 = TestTagKt.testTag(Modifier.INSTANCE, JobItem$lambda$1(stateCollectAsStateWithLifecycle13).getTitle());
                    boolean zJobItem$lambda$11 = JobItem$lambda$7(mutableState);
                    if (z8) {
                        function6 = function5;
                    } else {
                        function6 = function4;
                    }
                    if (zIsSelectableForAction) {
                        if (z8) {
                            composerStartRestartGroup.startReplaceGroup(-388137739);
                            composerStartRestartGroup.endReplaceGroup();
                            function7 = function3;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(852676745);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "256@10233L2");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388135511, "CC(remember):JobListingScreen.kt#9igjgp");
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            function5 = (Function0) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                            function7 = function5;
                        }
                    } else if (z8) {
                        composerStartRestartGroup.startReplaceGroup(-388137739);
                        composerStartRestartGroup.endReplaceGroup();
                        function7 = function3;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(852676745);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "256@10233L2");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388135511, "CC(remember):JobListingScreen.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        function5 = (Function0) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        function7 = function5;
                    }
                    Modifier modifierM642combinedClickablehoGz1lA$default6 = ClickableKt.m642combinedClickablehoGz1lA$default(modifierTestTag5, zJobItem$lambda$11, null, null, null, function7, null, false, null, function6, 238, null);
                    if (JobItem$lambda$7(mutableState)) {
                        f = 1.0f;
                    } else {
                        f = 0.5f;
                    }
                    final boolean z18 = z8;
                    SurfaceKt.m4323SurfaceT9BRK9s(AlphaKt.alpha(modifierM642combinedClickablehoGz1lA$default6, f), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1644117524, true, new Function2() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return JobListingScreenKt.JobItem$lambda$9(z18, store, z9, stateCollectAsStateWithLifecycle13, stateCollectAsStateWithLifecycle14, stateCollectAsStateWithLifecycle15, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 126);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z18;
                    z7 = z9;
                    function2 = function3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return JobListingScreenKt.JobItem$lambda$10(store, z6, function2, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z4 = z2;
            if ((i3 & 1171) != 1170) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z6 = z3;
                function2 = function1;
                z7 = z4;
            } else {
                if (i9 != 0) {
                    z8 = false;
                } else {
                    z8 = z3;
                }
                if (i4 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388174295, "CC(remember):JobListingScreen.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function3 = (Function0) objRememberedValue5;
                } else {
                    function3 = function1;
                }
                if (i6 != 0) {
                    z9 = false;
                } else {
                    z9 = z4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(316914151, i3, -1, "com.box.android.jobsui.JobItem (JobListingScreen.kt:228)");
                }
                final State stateCollectAsStateWithLifecycle16 = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                final State stateCollectAsStateWithLifecycle17 = FlowExtKt.collectAsStateWithLifecycle(JobItem$lambda$1(stateCollectAsStateWithLifecycle16).getThumbnail(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                final State stateCollectAsStateWithLifecycle18 = FlowExtKt.collectAsStateWithLifecycle(JobItem$lambda$1(stateCollectAsStateWithLifecycle16).getProgress(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388164966, "CC(remember):JobListingScreen.kt#9igjgp");
                i8 = i3 & 14;
                if (i8 == 4) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z10) {
                    objRememberedValue = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return JobListingScreenKt.JobItem$lambda$4$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return JobListingScreenKt.JobItem$lambda$4$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                function4 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388162052, "CC(remember):JobListingScreen.kt#9igjgp");
                if (i8 == 4) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z11) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return JobListingScreenKt.JobItem$lambda$5$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return JobListingScreenKt.JobItem$lambda$5$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                function5 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                zIsSelectableForAction = JobItemReducer.INSTANCE.isSelectableForAction(JobItem$lambda$3(stateCollectAsStateWithLifecycle18).getJobStatus());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388157303, "CC(remember):JobListingScreen.kt#9igjgp");
                if ((i3 & 112) == 32) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z12) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z8 || zIsSelectableForAction), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z8 || zIsSelectableForAction), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableState = (MutableState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierTestTag6 = TestTagKt.testTag(Modifier.INSTANCE, JobItem$lambda$1(stateCollectAsStateWithLifecycle16).getTitle());
                boolean zJobItem$lambda$12 = JobItem$lambda$7(mutableState);
                if (z8) {
                    function6 = function5;
                } else {
                    function6 = function4;
                }
                if (zIsSelectableForAction) {
                    if (z8) {
                        composerStartRestartGroup.startReplaceGroup(-388137739);
                        composerStartRestartGroup.endReplaceGroup();
                        function7 = function3;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(852676745);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "256@10233L2");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388135511, "CC(remember):JobListingScreen.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        function5 = (Function0) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        function7 = function5;
                    }
                } else if (z8) {
                    composerStartRestartGroup.startReplaceGroup(-388137739);
                    composerStartRestartGroup.endReplaceGroup();
                    function7 = function3;
                } else {
                    composerStartRestartGroup.startReplaceGroup(852676745);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "256@10233L2");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388135511, "CC(remember):JobListingScreen.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    function5 = (Function0) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    function7 = function5;
                }
                Modifier modifierM642combinedClickablehoGz1lA$default7 = ClickableKt.m642combinedClickablehoGz1lA$default(modifierTestTag6, zJobItem$lambda$12, null, null, null, function7, null, false, null, function6, 238, null);
                if (JobItem$lambda$7(mutableState)) {
                    f = 1.0f;
                } else {
                    f = 0.5f;
                }
                final boolean z19 = z8;
                SurfaceKt.m4323SurfaceT9BRK9s(AlphaKt.alpha(modifierM642combinedClickablehoGz1lA$default7, f), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1644117524, true, new Function2() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return JobListingScreenKt.JobItem$lambda$9(z19, store, z9, stateCollectAsStateWithLifecycle16, stateCollectAsStateWithLifecycle17, stateCollectAsStateWithLifecycle18, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 126);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z19;
                z7 = z9;
                function2 = function3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return JobListingScreenKt.JobItem$lambda$10(store, z6, function2, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        function1 = function0;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                z4 = z2;
                if (composerStartRestartGroup.changed(z4)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((i3 & 1171) != 1170) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z6 = z3;
                function2 = function1;
                z7 = z4;
            } else {
                if (i9 != 0) {
                    z8 = false;
                } else {
                    z8 = z3;
                }
                if (i4 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388174295, "CC(remember):JobListingScreen.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function3 = (Function0) objRememberedValue5;
                } else {
                    function3 = function1;
                }
                if (i6 != 0) {
                    z9 = false;
                } else {
                    z9 = z4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(316914151, i3, -1, "com.box.android.jobsui.JobItem (JobListingScreen.kt:228)");
                }
                final State stateCollectAsStateWithLifecycle19 = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                final State stateCollectAsStateWithLifecycle110 = FlowExtKt.collectAsStateWithLifecycle(JobItem$lambda$1(stateCollectAsStateWithLifecycle19).getThumbnail(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                final State stateCollectAsStateWithLifecycle111 = FlowExtKt.collectAsStateWithLifecycle(JobItem$lambda$1(stateCollectAsStateWithLifecycle19).getProgress(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388164966, "CC(remember):JobListingScreen.kt#9igjgp");
                i8 = i3 & 14;
                if (i8 == 4) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z10) {
                    objRememberedValue = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return JobListingScreenKt.JobItem$lambda$4$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return JobListingScreenKt.JobItem$lambda$4$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                function4 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388162052, "CC(remember):JobListingScreen.kt#9igjgp");
                if (i8 == 4) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z11) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return JobListingScreenKt.JobItem$lambda$5$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return JobListingScreenKt.JobItem$lambda$5$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                function5 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                zIsSelectableForAction = JobItemReducer.INSTANCE.isSelectableForAction(JobItem$lambda$3(stateCollectAsStateWithLifecycle111).getJobStatus());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388157303, "CC(remember):JobListingScreen.kt#9igjgp");
                if ((i3 & 112) == 32) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z12) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z8 || zIsSelectableForAction), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z8 || zIsSelectableForAction), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableState = (MutableState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierTestTag7 = TestTagKt.testTag(Modifier.INSTANCE, JobItem$lambda$1(stateCollectAsStateWithLifecycle19).getTitle());
                boolean zJobItem$lambda$13 = JobItem$lambda$7(mutableState);
                if (z8) {
                    function6 = function5;
                } else {
                    function6 = function4;
                }
                if (zIsSelectableForAction) {
                    if (z8) {
                        composerStartRestartGroup.startReplaceGroup(-388137739);
                        composerStartRestartGroup.endReplaceGroup();
                        function7 = function3;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(852676745);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "256@10233L2");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388135511, "CC(remember):JobListingScreen.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        function5 = (Function0) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        function7 = function5;
                    }
                } else if (z8) {
                    composerStartRestartGroup.startReplaceGroup(-388137739);
                    composerStartRestartGroup.endReplaceGroup();
                    function7 = function3;
                } else {
                    composerStartRestartGroup.startReplaceGroup(852676745);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "256@10233L2");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388135511, "CC(remember):JobListingScreen.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    function5 = (Function0) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    function7 = function5;
                }
                Modifier modifierM642combinedClickablehoGz1lA$default8 = ClickableKt.m642combinedClickablehoGz1lA$default(modifierTestTag7, zJobItem$lambda$13, null, null, null, function7, null, false, null, function6, 238, null);
                if (JobItem$lambda$7(mutableState)) {
                    f = 1.0f;
                } else {
                    f = 0.5f;
                }
                final boolean z110 = z8;
                SurfaceKt.m4323SurfaceT9BRK9s(AlphaKt.alpha(modifierM642combinedClickablehoGz1lA$default8, f), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1644117524, true, new Function2() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return JobListingScreenKt.JobItem$lambda$9(z110, store, z9, stateCollectAsStateWithLifecycle19, stateCollectAsStateWithLifecycle110, stateCollectAsStateWithLifecycle111, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 126);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z110;
                z7 = z9;
                function2 = function3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return JobListingScreenKt.JobItem$lambda$10(store, z6, function2, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z4 = z2;
        if ((i3 & 1171) != 1170) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            z6 = z3;
            function2 = function1;
            z7 = z4;
        } else {
            if (i9 != 0) {
                z8 = false;
            } else {
                z8 = z3;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388174295, "CC(remember):JobListingScreen.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function3 = (Function0) objRememberedValue5;
            } else {
                function3 = function1;
            }
            if (i6 != 0) {
                z9 = false;
            } else {
                z9 = z4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(316914151, i3, -1, "com.box.android.jobsui.JobItem (JobListingScreen.kt:228)");
            }
            final State stateCollectAsStateWithLifecycle112 = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            final State stateCollectAsStateWithLifecycle113 = FlowExtKt.collectAsStateWithLifecycle(JobItem$lambda$1(stateCollectAsStateWithLifecycle112).getThumbnail(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            final State stateCollectAsStateWithLifecycle114 = FlowExtKt.collectAsStateWithLifecycle(JobItem$lambda$1(stateCollectAsStateWithLifecycle112).getProgress(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388164966, "CC(remember):JobListingScreen.kt#9igjgp");
            i8 = i3 & 14;
            if (i8 == 4) {
                z10 = true;
            } else {
                z10 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z10) {
                objRememberedValue = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return JobListingScreenKt.JobItem$lambda$4$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return JobListingScreenKt.JobItem$lambda$4$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            function4 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388162052, "CC(remember):JobListingScreen.kt#9igjgp");
            if (i8 == 4) {
                z11 = true;
            } else {
                z11 = false;
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z11) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return JobListingScreenKt.JobItem$lambda$5$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return JobListingScreenKt.JobItem$lambda$5$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            function5 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            zIsSelectableForAction = JobItemReducer.INSTANCE.isSelectableForAction(JobItem$lambda$3(stateCollectAsStateWithLifecycle114).getJobStatus());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388157303, "CC(remember):JobListingScreen.kt#9igjgp");
            if ((i3 & 112) == 32) {
                z12 = true;
            } else {
                z12 = false;
            }
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!z12) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z8 || zIsSelectableForAction), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z8 || zIsSelectableForAction), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            mutableState = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierTestTag8 = TestTagKt.testTag(Modifier.INSTANCE, JobItem$lambda$1(stateCollectAsStateWithLifecycle112).getTitle());
            boolean zJobItem$lambda$14 = JobItem$lambda$7(mutableState);
            if (z8) {
                function6 = function5;
            } else {
                function6 = function4;
            }
            if (zIsSelectableForAction) {
                if (z8) {
                    composerStartRestartGroup.startReplaceGroup(-388137739);
                    composerStartRestartGroup.endReplaceGroup();
                    function7 = function3;
                } else {
                    composerStartRestartGroup.startReplaceGroup(852676745);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "256@10233L2");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388135511, "CC(remember):JobListingScreen.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    function5 = (Function0) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    function7 = function5;
                }
            } else if (z8) {
                composerStartRestartGroup.startReplaceGroup(-388137739);
                composerStartRestartGroup.endReplaceGroup();
                function7 = function3;
            } else {
                composerStartRestartGroup.startReplaceGroup(852676745);
                ComposerKt.sourceInformation(composerStartRestartGroup, "256@10233L2");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -388135511, "CC(remember):JobListingScreen.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                function5 = (Function0) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                function7 = function5;
            }
            Modifier modifierM642combinedClickablehoGz1lA$default9 = ClickableKt.m642combinedClickablehoGz1lA$default(modifierTestTag8, zJobItem$lambda$14, null, null, null, function7, null, false, null, function6, 238, null);
            if (JobItem$lambda$7(mutableState)) {
                f = 1.0f;
            } else {
                f = 0.5f;
            }
            final boolean z111 = z8;
            SurfaceKt.m4323SurfaceT9BRK9s(AlphaKt.alpha(modifierM642combinedClickablehoGz1lA$default9, f), null, 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1644117524, true, new Function2() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return JobListingScreenKt.JobItem$lambda$9(z111, store, z9, stateCollectAsStateWithLifecycle112, stateCollectAsStateWithLifecycle113, stateCollectAsStateWithLifecycle114, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 126);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z6 = z111;
            z7 = z9;
            function2 = function3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return JobListingScreenKt.JobItem$lambda$10(store, z6, function2, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JobItem$lambda$4$0(Store store) {
        store.send(JobItemReducer.Action.PrimaryAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JobItem$lambda$5$0(Store store) {
        store.send(JobItemReducer.Action.ToggleSelection.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final boolean JobItem$lambda$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JobItem$lambda$9(final boolean z, final Store store, final boolean z2, final State state, final State state2, final State state3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C264@10441L6,262@10354L3999:JobListingScreen.kt#6w6mzd");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1644117524, i, -1, "com.box.android.jobsui.JobItem.<anonymous> (JobListingScreen.kt:262)");
            }
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11530getItemListingContentBackground0d7_KjU(), null, 2, null), Dp.m9687constructorimpl(72)), 0.0f, 1, null), Dp.m9687constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null);
            composer.startReplaceGroup(-1003410150);
            ComposerKt.sourceInformation(composer, "CC(ConstraintLayout)P(3,4!1,2)414@18758L7,415@18785L30,416@18832L36,417@18903L34,418@18962L45,419@19033L53,421@19112L652,440@19793L288,449@20174L33,451@20266L729,448@20116L885:ConstraintLayout.kt#fysre8");
            composer.startReplaceGroup(212064437);
            ComposerKt.sourceInformation(composer, "359@16265L33,360@16347L33,361@16401L70,362@16501L53,363@16587L101,366@16711L54,368@16821L1432,399@18263L441");
            composer.endReplaceGroup();
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density = (Density) objConsume;
            ComposerKt.sourceInformationMarkerStart(composer, 212145251, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Measurer(density);
                composer.updateRememberedValue(objRememberedValue);
            }
            final Measurer measurer = (Measurer) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212146761, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new ConstraintLayoutScope();
                composer.updateRememberedValue(objRememberedValue2);
            }
            final ConstraintLayoutScope constraintLayoutScope = (ConstraintLayoutScope) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212149031, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composer.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212150930, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new ConstraintSetForInlineDsl(constraintLayoutScope);
                composer.updateRememberedValue(objRememberedValue4);
            }
            final ConstraintSetForInlineDsl constraintSetForInlineDsl = (ConstraintSetForInlineDsl) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212153210, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue5 = composer.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                composer.updateRememberedValue(objRememberedValue5);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212156337, "CC(remember):ConstraintLayout.kt#9igjgp");
            final int i2 = 257;
            boolean zChangedInstance = composer.changedInstance(measurer) | composer.changed(257);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = (MeasurePolicy) new MeasurePolicy() { // from class: com.box.android.jobsui.JobListingScreenKt$JobItem$lambda$9$$inlined$ConstraintLayout$2
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, final List<? extends Measurable> list, long j) {
                        mutableState2.getValue();
                        long jM10087performMeasure2eBlSMk = measurer.m10087performMeasure2eBlSMk(j, measureScope.getLayoutDirection(), constraintSetForInlineDsl, list, i2);
                        mutableState.getValue();
                        int iM9858getWidthimpl = IntSize.m9858getWidthimpl(jM10087performMeasure2eBlSMk);
                        int iM9857getHeightimpl = IntSize.m9857getHeightimpl(jM10087performMeasure2eBlSMk);
                        final Measurer measurer2 = measurer;
                        return MeasureScope.layout$default(measureScope, iM9858getWidthimpl, iM9857getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.box.android.jobsui.JobListingScreenKt$JobItem$lambda$9$$inlined$ConstraintLayout$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope placementScope) {
                                measurer2.performLayout(placementScope, list);
                            }
                        }, 4, null);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212177765, "CC(remember):ConstraintLayout.kt#9igjgp");
            Object objRememberedValue7 = composer.rememberedValue();
            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = (Function0) new Function0<Unit>() { // from class: com.box.android.jobsui.JobListingScreenKt$JobItem$lambda$9$$inlined$ConstraintLayout$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        MutableState mutableState3 = mutableState;
                        mutableState3.setValue(Boolean.valueOf(!((Boolean) mutableState3.getValue()).booleanValue()));
                        constraintSetForInlineDsl.setKnownDirty(true);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            final Function0 function0 = (Function0) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 212189702, "CC(remember):ConstraintLayout.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(measurer);
            Object objRememberedValue8 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.box.android.jobsui.JobListingScreenKt$JobItem$lambda$9$$inlined$ConstraintLayout$4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, measurer);
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifierM1222paddingqDBjuR0$default, false, (Function1) objRememberedValue8, 1, null), ComposableLambdaKt.rememberComposableLambda(1200550679, true, new Function2<Composer, Integer, Unit>() { // from class: com.box.android.jobsui.JobListingScreenKt$JobItem$lambda$9$$inlined$ConstraintLayout$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ConstrainedLayoutReference constrainedLayoutReference;
                    ConstraintLayoutScope constraintLayoutScope2;
                    ComposerKt.sourceInformation(composer2, "C457@20608L9,462@20943L28:ConstraintLayout.kt#fysre8");
                    if ((i3 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1200550679, i3, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:454)");
                        }
                        mutableState2.setValue(Unit.INSTANCE);
                        int helpersHashCode = constraintLayoutScope.getHelpersHashCode();
                        constraintLayoutScope.reset();
                        ConstraintLayoutScope constraintLayoutScope3 = constraintLayoutScope;
                        composer2.startReplaceGroup(-470151899);
                        ComposerKt.sourceInformation(composer2, "C271@10725L33,272@10816L6,275@10963L270,270@10692L555,287@11412L218,283@11261L383,297@11781L290,306@12243L6,294@11658L616,309@12344L294,339@13653L169:JobListingScreen.kt#6w6mzd");
                        ConstraintLayoutScope.ConstrainedLayoutReferences constrainedLayoutReferencesCreateRefs = constraintLayoutScope3.createRefs();
                        ConstrainedLayoutReference constrainedLayoutReferenceComponent1 = constrainedLayoutReferencesCreateRefs.component1();
                        ConstrainedLayoutReference constrainedLayoutReferenceComponent2 = constrainedLayoutReferencesCreateRefs.component2();
                        ConstrainedLayoutReference constrainedLayoutReferenceComponent3 = constrainedLayoutReferencesCreateRefs.component3();
                        ConstrainedLayoutReference constrainedLayoutReferenceComponent4 = constrainedLayoutReferencesCreateRefs.component4();
                        ConstrainedLayoutReference constrainedLayoutReferenceComponent5 = constrainedLayoutReferencesCreateRefs.component5();
                        Painter painterPainterResource = PainterResources_androidKt.painterResource(JobListingScreenKt.JobItem$lambda$1(state).getIconRes(), composer2, 0);
                        ColorFilter colorFilterM6855tintxETnrds$default = ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, BoxTheme.INSTANCE.getColors(composer2, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), 0, 2, null);
                        Modifier.Companion companion = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 400483825, "CC(remember):JobListingScreen.kt#9igjgp");
                        JobListingScreenKt$JobItem$3$1$1$1 jobListingScreenKt$JobItem$3$1$1$1RememberedValue = composer2.rememberedValue();
                        if (jobListingScreenKt$JobItem$3$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            jobListingScreenKt$JobItem$3$1$1$1RememberedValue = JobListingScreenKt$JobItem$3$1$1$1.INSTANCE;
                            composer2.updateRememberedValue(jobListingScreenKt$JobItem$3$1$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ImageKt.Image(painterPainterResource, (String) null, constraintLayoutScope3.constrainAs(companion, constrainedLayoutReferenceComponent1, (Function1) jobListingScreenKt$JobItem$3$1$1$1RememberedValue), (Alignment) null, (ContentScale) null, 0.0f, colorFilterM6855tintxETnrds$default, composer2, Painter.$stable | 48, 56);
                        ItemThumbnail itemThumbnailJobItem$lambda$2 = JobListingScreenKt.JobItem$lambda$2(state2);
                        Modifier modifierM1266size3ABfNKs = SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(40));
                        ComposerKt.sourceInformationMarkerStart(composer2, 400498141, "CC(remember):JobListingScreen.kt#9igjgp");
                        boolean zChanged = composer2.changed(constrainedLayoutReferenceComponent1);
                        JobListingScreenKt$JobItem$3$1$2$1 jobListingScreenKt$JobItem$3$1$2$1RememberedValue = composer2.rememberedValue();
                        if (zChanged || jobListingScreenKt$JobItem$3$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            jobListingScreenKt$JobItem$3$1$2$1RememberedValue = new JobListingScreenKt$JobItem$3$1$2$1(constrainedLayoutReferenceComponent1);
                            composer2.updateRememberedValue(jobListingScreenKt$JobItem$3$1$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        BoxItemThumbnailKt.m11589BoxItemThumbnailTN_CM5M(itemThumbnailJobItem$lambda$2, constraintLayoutScope3.constrainAs(modifierM1266size3ABfNKs, constrainedLayoutReferenceComponent2, (Function1) jobListingScreenKt$JobItem$3$1$2$1RememberedValue), 0.0f, null, null, composer2, ItemThumbnail.$stable, 28);
                        String title = JobListingScreenKt.JobItem$lambda$1(state).getTitle();
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 400510021, "CC(remember):JobListingScreen.kt#9igjgp");
                        boolean zChanged2 = composer2.changed(constrainedLayoutReferenceComponent2) | composer2.changed(constrainedLayoutReferenceComponent5);
                        JobListingScreenKt$JobItem$3$1$3$1 jobListingScreenKt$JobItem$3$1$3$1RememberedValue = composer2.rememberedValue();
                        if (zChanged2 || jobListingScreenKt$JobItem$3$1$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            jobListingScreenKt$JobItem$3$1$3$1RememberedValue = new JobListingScreenKt$JobItem$3$1$3$1(constrainedLayoutReferenceComponent2, constrainedLayoutReferenceComponent5);
                            composer2.updateRememberedValue(jobListingScreenKt$JobItem$3$1$3$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        TextKt.m4494TextNvy7gAk(title, constraintLayoutScope3.constrainAs(companion2, constrainedLayoutReferenceComponent3, (Function1) jobListingScreenKt$JobItem$3$1$3$1RememberedValue), BoxTheme.INSTANCE.getColors(composer2, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composer2, 0, 24960, 110584);
                        Composer composer3 = composer2;
                        Modifier.Companion companion3 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, 400528041, "CC(remember):JobListingScreen.kt#9igjgp");
                        boolean zChanged3 = composer3.changed(constrainedLayoutReferenceComponent3) | composer3.changed(constrainedLayoutReferenceComponent5);
                        JobListingScreenKt$JobItem$3$1$jobDescriptionModifier$1$1 jobListingScreenKt$JobItem$3$1$jobDescriptionModifier$1$1RememberedValue = composer3.rememberedValue();
                        if (zChanged3 || jobListingScreenKt$JobItem$3$1$jobDescriptionModifier$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            jobListingScreenKt$JobItem$3$1$jobDescriptionModifier$1$1RememberedValue = new JobListingScreenKt$JobItem$3$1$jobDescriptionModifier$1$1(constrainedLayoutReferenceComponent3, constrainedLayoutReferenceComponent5);
                            composer3.updateRememberedValue(jobListingScreenKt$JobItem$3$1$jobDescriptionModifier$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierConstrainAs = constraintLayoutScope3.constrainAs(companion3, constrainedLayoutReferenceComponent4, (Function1) jobListingScreenKt$JobItem$3$1$jobDescriptionModifier$1$1RememberedValue);
                        String errorText = JobListingScreenKt.JobItem$lambda$3(state3).getErrorText();
                        if (errorText == null || errorText.length() == 0) {
                            String description = JobListingScreenKt.JobItem$lambda$1(state).getDescription();
                            if (description == null || description.length() == 0) {
                                constrainedLayoutReference = constrainedLayoutReferenceComponent5;
                                constraintLayoutScope2 = constraintLayoutScope3;
                                composer3.startReplaceGroup(-480787969);
                            } else {
                                composer3.startReplaceGroup(-468028524);
                                ComposerKt.sourceInformation(composer3, "320@12857L683");
                                ComposerKt.sourceInformationMarkerStart(composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer3, 0);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierConstrainAs);
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor);
                                } else {
                                    composer3.useNode();
                                }
                                Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer3);
                                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, 1068833180, "C324@13080L6,321@12918L207,333@13477L6,327@13147L375:JobListingScreen.kt#6w6mzd");
                                IconKt.m3576Iconww6aTOc(FolderOpenKt.getFolderOpen(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, BoxTheme.INSTANCE.getColors(composer3, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), composer2, 48, 4);
                                String description2 = JobListingScreenKt.JobItem$lambda$1(state).getDescription();
                                Intrinsics.checkNotNull(description2);
                                constraintLayoutScope2 = constraintLayoutScope3;
                                constrainedLayoutReference = constrainedLayoutReferenceComponent5;
                                TextKt.m4494TextNvy7gAk(description2, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(4), 0.0f, 0.0f, 0.0f, 14, null), BoxTheme.INSTANCE.getColors(composer2, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal14(), composer2, 48, 24960, 110584);
                                composer3 = composer2;
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                            }
                            composer3.endReplaceGroup();
                        } else {
                            composer3.startReplaceGroup(-468187709);
                            ComposerKt.sourceInformation(composer3, "318@12716L60");
                            String errorText2 = JobListingScreenKt.JobItem$lambda$3(state3).getErrorText();
                            Intrinsics.checkNotNull(errorText2);
                            JobListingScreenKt.ErrorText(modifierConstrainAs, errorText2, composer3, 0);
                            composer3.endReplaceGroup();
                            constrainedLayoutReference = constrainedLayoutReferenceComponent5;
                            constraintLayoutScope2 = constraintLayoutScope3;
                        }
                        Modifier.Companion companion4 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, 400569804, "CC(remember):JobListingScreen.kt#9igjgp");
                        JobListingScreenKt$JobItem$3$1$secondaryActionModifier$1$1 jobListingScreenKt$JobItem$3$1$secondaryActionModifier$1$1RememberedValue = composer3.rememberedValue();
                        if (jobListingScreenKt$JobItem$3$1$secondaryActionModifier$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            jobListingScreenKt$JobItem$3$1$secondaryActionModifier$1$1RememberedValue = JobListingScreenKt$JobItem$3$1$secondaryActionModifier$1$1.INSTANCE;
                            composer3.updateRememberedValue(jobListingScreenKt$JobItem$3$1$secondaryActionModifier$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierConstrainAs2 = constraintLayoutScope2.constrainAs(companion4, constrainedLayoutReference, (Function1) jobListingScreenKt$JobItem$3$1$secondaryActionModifier$1$1RememberedValue);
                        if (z) {
                            composer3.startReplaceGroup(-467022729);
                            ComposerKt.sourceInformation(composer3, "345@13871L136");
                            BoxCheckBoxKt.BoxCheckbox(modifierConstrainAs2, JobListingScreenKt.JobItem$lambda$1(state).isSelected(), null, false, composer3, 0, 12);
                            composer3.endReplaceGroup();
                        } else {
                            composer3.startReplaceGroup(-466862397);
                            ComposerKt.sourceInformation(composer3, "353@14195L53,350@14045L284");
                            JobStatusUIState jobStatusUIStateJobItem$lambda$3 = JobListingScreenKt.JobItem$lambda$3(state3);
                            ComposerKt.sourceInformationMarkerStart(composer3, 400587032, "CC(remember):JobListingScreen.kt#9igjgp");
                            boolean zChanged4 = composer3.changed(store);
                            JobListingScreenKt$JobItem$3$1$5$1 jobListingScreenKt$JobItem$3$1$5$1RememberedValue = composer3.rememberedValue();
                            if (zChanged4 || jobListingScreenKt$JobItem$3$1$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                jobListingScreenKt$JobItem$3$1$5$1RememberedValue = new JobListingScreenKt$JobItem$3$1$5$1(store);
                                composer3.updateRememberedValue(jobListingScreenKt$JobItem$3$1$5$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            JobStatusIndicatorKt.JobStatusIndicator(jobStatusUIStateJobItem$lambda$3, modifierConstrainAs2, (Function0) jobListingScreenKt$JobItem$3$1$5$1RememberedValue, z2, composer3, 0, 0);
                            composer3.endReplaceGroup();
                        }
                        composer3.endReplaceGroup();
                        if (constraintLayoutScope.getHelpersHashCode() != helpersHashCode) {
                            EffectsKt.SideEffect(function0, composer3, 6);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composer, 54), measurePolicy, composer, 48, 0);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final void ErrorText(final Modifier modifier, final String errorString, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(errorString, "errorString");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1572281471);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ErrorText)N(modifier,errorString)367@14594L6,363@14436L256:JobListingScreen.kt#6w6mzd");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changed(modifier) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(errorString) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1572281471, i2, -1, "com.box.android.jobsui.ErrorText (JobListingScreen.kt:362)");
            }
            composer2 = composerStartRestartGroup;
            TextKt.m4494TextNvy7gAk(errorString, TestTagKt.testTag(modifier, "ErrorText"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11540getNotificationContainer0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium14(), composer2, (i2 >> 3) & 14, 24960, 110584);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return JobListingScreenKt.ErrorText$lambda$0(modifier, errorString, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void JobsUIToolbar(Function0<Unit> onClose, final boolean z, Composer composer, final int i, final int i2) {
        int i3;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1720280553);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(JobsUIToolbar)N(onClose,isRedesignedVersion)377@14851L34,375@14791L151:JobListingScreen.kt#6w6mzd");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(onClose) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            function0 = onClose;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                z = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1720280553, i3, -1, "com.box.android.jobsui.JobsUIToolbar (JobListingScreen.kt:374)");
            }
            function0 = onClose;
            boolean z2 = z;
            BoxSimpleTopBarKt.BoxSimpleTopBar(StringResources_androidKt.stringResource(R.string.transfers, composerStartRestartGroup, 0), function0, null, z2, null, composerStartRestartGroup, ((i3 << 3) & 112) | ((i3 << 6) & 7168), 20);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z = z2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.jobsui.JobListingScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return JobListingScreenKt.JobsUIToolbar$lambda$0(function0, z, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final JobsReducer.State JobsUIScreen$lambda$0(State<JobsReducer.State> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JobsReducer.State JobsListScreen$lambda$0(State<JobsReducer.State> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JobItemReducer.State JobItem$lambda$1(State<JobItemReducer.State> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ItemThumbnail JobItem$lambda$2(State<? extends ItemThumbnail> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JobStatusUIState JobItem$lambda$3(State<JobStatusUIState> state) {
        return state.getValue();
    }
}
