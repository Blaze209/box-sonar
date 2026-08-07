package com.box.android.preview.previousversion;

import android.content.res.Configuration;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
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
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.BoxSizes;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.ComposeUtilsKt;
import com.box.android.base.compose.SwipeableSnackbarHostKt;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.cpl.Wrapped;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.preview.item.ItemState;
import com.box.android.preview.item.LoadingPlaceholder;
import com.box.android.preview.item.error.PreviewErrorScreenKt;
import com.box.android.preview.item.labels.classification.ClassificationLabelKt;
import com.box.android.preview.item.loading.PreviewLoadingScreenKt;
import com.box.android.preview.preview.ImmersiveModeUtilsKt;
import com.box.android.preview.preview.previewbar.AnimatedPreviewBarKt;
import com.box.android.preview.preview.previewbar.PreviewBarType;
import com.box.android.preview.previewtype.document.DocumentPreviewReducer;
import com.box.android.preview.previewtype.document.DocumentPreviewScreenKt;
import com.box.android.preview.previewtype.image.ImagePreviewReducer;
import com.box.android.preview.previewtype.image.ImagePreviewScreenKt;
import com.box.android.preview.previewtype.video.Media3VideoPlayerManager;
import com.box.android.preview.previewtype.video.VideoPlayersProvider;
import com.box.android.preview.previewtype.video.VideoPreviewReducer;
import com.box.android.preview.previewtype.video.VideoPreviewScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.jvm.KClassesJvm;

/* JADX INFO: compiled from: PreviousVersionPreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a)\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a;\u0010\t\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e\u001a\u0019\u0010\u000f\u001a\u00020\r*\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010\u0012¨\u0006\u0013²\u0006\n\u0010\u0014\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"PreviousVersionPreviewScreen", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$State;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action;", "dependencyProvider", "Lcom/box/android/preview/previousversion/PreviousVersionUIDependencyProvider;", "(Lcom/box/android/cpl/Store;Lcom/box/android/preview/previousversion/PreviousVersionUIDependencyProvider;Landroidx/compose/runtime/Composer;I)V", "PreviousVersionItemPreview", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/android/cpl/Store;Lcom/box/android/preview/previousversion/PreviousVersionUIDependencyProvider;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "immersiveModeAwarePadding", "isImmersiveMode", "", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "preview_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PreviousVersionPreviewScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviousVersionItemPreview$lambda$2(Store store, PreviousVersionUIDependencyProvider previousVersionUIDependencyProvider, SnackbarHostState snackbarHostState, Modifier modifier, int i, int i2, Composer composer, int i3) {
        PreviousVersionItemPreview(store, previousVersionUIDependencyProvider, snackbarHostState, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviousVersionPreviewScreen$lambda$5(Store store, PreviousVersionUIDependencyProvider previousVersionUIDependencyProvider, int i, Composer composer, int i2) {
        PreviousVersionPreviewScreen(store, previousVersionUIDependencyProvider, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void PreviousVersionPreviewScreen(final Store<PreviousVersionReducer.State, PreviousVersionReducer.Action> store, final PreviousVersionUIDependencyProvider dependencyProvider, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(dependencyProvider, "dependencyProvider");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1704338312);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PreviousVersionPreviewScreen)N(store,dependencyProvider)44@2244L29,45@2302L32,60@2842L6,62@2929L6,63@2968L45,48@2367L370,59@2762L44,64@3020L759,47@2340L1439:PreviousVersionPreviewScreen.kt#k0omno");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(dependencyProvider) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1704338312, i2, -1, "com.box.android.preview.previousversion.PreviousVersionPreviewScreen (PreviousVersionPreviewScreen.kt:43)");
            }
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1486571368, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            ScaffoldKt.m4038ScaffoldTvnljyQ(ImmersiveModeUtilsKt.landscapeSystemPadding(BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11511getContentBackground0d7_KjU(), null, 2, null), PreviousVersionPreviewScreen$lambda$0(stateCollectAsStateWithLifecycle).isImmersiveMode(), composerStartRestartGroup, 0), ComposableLambdaKt.rememberComposableLambda(1340469044, true, new Function2() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviousVersionPreviewScreenKt.PreviousVersionPreviewScreen$lambda$2(stateCollectAsStateWithLifecycle, store, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(1946243826, true, new Function2() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviousVersionPreviewScreenKt.PreviousVersionPreviewScreen$lambda$3(snackbarHostState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, 0, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11544getPreviewBackground0d7_KjU(), 0L, null, ComposableLambdaKt.rememberComposableLambda(264369929, true, new Function3() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PreviousVersionPreviewScreenKt.PreviousVersionPreviewScreen$lambda$4(stateCollectAsStateWithLifecycle, store, dependencyProvider, snackbarHostState, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 805309488, 436);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviousVersionPreviewScreenKt.PreviousVersionPreviewScreen$lambda$5(store, dependencyProvider, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviousVersionPreviewScreen$lambda$2(final State state, final Store store, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C52@2507L220,49@2381L346:PreviousVersionPreviewScreen.kt#k0omno");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1340469044, i, -1, "com.box.android.preview.previousversion.PreviousVersionPreviewScreen.<anonymous> (PreviousVersionPreviewScreen.kt:49)");
            }
            AnimatedPreviewBarKt.AnimatedPreviewBar(!PreviousVersionPreviewScreen$lambda$0(state).isImmersiveMode(), PreviewBarType.TOP, null, ComposableLambdaKt.rememberComposableLambda(-1077466186, true, new Function2() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviousVersionPreviewScreenKt.PreviousVersionPreviewScreen$lambda$2$0(store, state, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviousVersionPreviewScreen$lambda$2$0(final Store store, State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C55@2636L59,53@2525L188:PreviousVersionPreviewScreen.kt#k0omno");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1077466186, i, -1, "com.box.android.preview.previousversion.PreviousVersionPreviewScreen.<anonymous>.<anonymous> (PreviousVersionPreviewScreen.kt:53)");
            }
            PreviousVersionReducer.VersionInfo versionInfo = PreviousVersionPreviewScreen$lambda$0(state).getVersionInfo();
            ComposerKt.sourceInformationMarkerStart(composer, -357882223, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
            boolean zChanged = composer.changed(store);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PreviousVersionPreviewScreenKt.PreviousVersionPreviewScreen$lambda$2$0$0$0(store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            PreviousVersionTopBarKt.PreviousVersionTopBar(versionInfo, (Function0) objRememberedValue, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviousVersionPreviewScreen$lambda$2$0$0$0(Store store) {
        store.send(new PreviousVersionReducer.Action.Navigate(PreviousVersionReducer.PreviousVersionRoute.Close.INSTANCE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviousVersionPreviewScreen$lambda$3(SnackbarHostState snackbarHostState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C59@2764L40:PreviousVersionPreviewScreen.kt#k0omno");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1946243826, i, -1, "com.box.android.preview.previousversion.PreviousVersionPreviewScreen.<anonymous> (PreviousVersionPreviewScreen.kt:59)");
            }
            SwipeableSnackbarHostKt.SwipeableSnackbarHost(snackbarHostState, null, composer, 6, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviousVersionPreviewScreen$lambda$4(State state, Store store, PreviousVersionUIDependencyProvider previousVersionUIDependencyProvider, SnackbarHostState snackbarHostState, PaddingValues unused$var$, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        ComposerKt.sourceInformation(composer, "C68@3120L48,65@3035L738:PreviousVersionPreviewScreen.kt#k0omno");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(264369929, i, -1, "com.box.android.preview.previousversion.PreviousVersionPreviewScreen.<anonymous> (PreviousVersionPreviewScreen.kt:65)");
            }
            Modifier modifierImmersiveModeAwarePadding = immersiveModeAwarePadding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), PreviousVersionPreviewScreen$lambda$0(state).isImmersiveMode(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierImmersiveModeAwarePadding);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1176060070, "C70@3193L220:PreviousVersionPreviewScreen.kt#k0omno");
            PreviousVersionItemPreview(store, previousVersionUIDependencyProvider, snackbarHostState, Modifier.INSTANCE, composer, 3456, 0);
            if (PreviousVersionPreviewScreen$lambda$0(state).isImmersiveMode()) {
                composer.startReplaceGroup(-1179246189);
            } else {
                composer.startReplaceGroup(-1175809250);
                ComposerKt.sourceInformation(composer, "78@3563L22,77@3472L277");
                PreviousVersionPreviewScreenKt$PreviousVersionPreviewScreen$3$1$1 previousVersionPreviewScreenKt$PreviousVersionPreviewScreen$3$1$1 = new PropertyReference1Impl() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewScreenKt$PreviousVersionPreviewScreen$3$1$1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((PreviousVersionReducer.State) obj).getClassification();
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composer, -1423399451, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                PreviousVersionPreviewScreenKt$PreviousVersionPreviewScreen$3$1$2$1 previousVersionPreviewScreenKt$PreviousVersionPreviewScreen$3$1$2$1RememberedValue = composer.rememberedValue();
                if (previousVersionPreviewScreenKt$PreviousVersionPreviewScreen$3$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    previousVersionPreviewScreenKt$PreviousVersionPreviewScreen$3$1$2$1RememberedValue = PreviousVersionPreviewScreenKt$PreviousVersionPreviewScreen$3$1$2$1.INSTANCE;
                    composer.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionPreviewScreen$3$1$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ClassificationLabelKt.PreviewClassificationLabel(store.scope(previousVersionPreviewScreenKt$PreviousVersionPreviewScreen$3$1$1, (Function1) ((KFunction) previousVersionPreviewScreenKt$PreviousVersionPreviewScreen$3$1$2$1RememberedValue)), PaddingKt.m1222paddingqDBjuR0$default(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomCenter()), 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(40), 7, null), composer, 0, 0);
            }
            composer.endReplaceGroup();
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

    /* JADX WARN: Code duplicated, block: B:103:0x0278  */
    /* JADX WARN: Code duplicated, block: B:106:0x0294  */
    /* JADX WARN: Code duplicated, block: B:107:0x0297  */
    /* JADX WARN: Code duplicated, block: B:112:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:115:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:116:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:121:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:123:0x0305  */
    /* JADX WARN: Code duplicated, block: B:125:0x030e  */
    /* JADX WARN: Code duplicated, block: B:127:0x0331  */
    /* JADX WARN: Code duplicated, block: B:130:0x034b  */
    /* JADX WARN: Code duplicated, block: B:133:0x0352  */
    /* JADX WARN: Code duplicated, block: B:134:0x035f  */
    /* JADX WARN: Code duplicated, block: B:136:0x0362  */
    /* JADX WARN: Code duplicated, block: B:137:0x036a  */
    /* JADX WARN: Code duplicated, block: B:139:0x0376  */
    /* JADX WARN: Code duplicated, block: B:140:0x0378  */
    /* JADX WARN: Code duplicated, block: B:145:0x0387  */
    /* JADX WARN: Code duplicated, block: B:148:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:149:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:154:0x03b7  */
    /* JADX WARN: Code duplicated, block: B:156:0x03d9  */
    /* JADX WARN: Code duplicated, block: B:158:0x03dd  */
    /* JADX WARN: Code duplicated, block: B:160:0x0400  */
    /* JADX WARN: Code duplicated, block: B:163:0x041a  */
    /* JADX WARN: Code duplicated, block: B:166:0x0421  */
    /* JADX WARN: Code duplicated, block: B:167:0x042e  */
    /* JADX WARN: Code duplicated, block: B:169:0x0431  */
    /* JADX WARN: Code duplicated, block: B:170:0x0439  */
    /* JADX WARN: Code duplicated, block: B:172:0x044d  */
    /* JADX WARN: Code duplicated, block: B:173:0x044f  */
    /* JADX WARN: Code duplicated, block: B:178:0x045e  */
    /* JADX WARN: Code duplicated, block: B:181:0x0478  */
    /* JADX WARN: Code duplicated, block: B:182:0x047b  */
    /* JADX WARN: Code duplicated, block: B:187:0x048b  */
    /* JADX WARN: Code duplicated, block: B:189:0x04bb  */
    /* JADX WARN: Code duplicated, block: B:191:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:193:0x04e3  */
    /* JADX WARN: Code duplicated, block: B:194:0x04e6  */
    /* JADX WARN: Code duplicated, block: B:199:0x04f6  */
    /* JADX WARN: Code duplicated, block: B:201:0x050f  */
    /* JADX WARN: Code duplicated, block: B:204:0x0526  */
    /* JADX WARN: Code duplicated, block: B:205:0x0530  */
    /* JADX WARN: Code duplicated, block: B:209:0x0598  */
    /* JADX WARN: Code duplicated, block: B:211:0x059d  */
    /* JADX WARN: Code duplicated, block: B:214:0x05a7  */
    /* JADX WARN: Code duplicated, block: B:216:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x007b  */
    /* JADX WARN: Code duplicated, block: B:38:0x007d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0086 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0088  */
    /* JADX WARN: Code duplicated, block: B:43:0x008d  */
    /* JADX WARN: Code duplicated, block: B:46:0x0094  */
    /* JADX WARN: Code duplicated, block: B:49:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:52:0x0109  */
    /* JADX WARN: Code duplicated, block: B:53:0x010d  */
    /* JADX WARN: Code duplicated, block: B:56:0x016a  */
    /* JADX WARN: Code duplicated, block: B:58:0x018d  */
    /* JADX WARN: Code duplicated, block: B:61:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:64:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:65:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:67:0x01be  */
    /* JADX WARN: Code duplicated, block: B:68:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:70:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:71:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:76:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:79:0x020a  */
    /* JADX WARN: Code duplicated, block: B:80:0x020d  */
    /* JADX WARN: Code duplicated, block: B:85:0x021c  */
    /* JADX WARN: Code duplicated, block: B:88:0x0238  */
    /* JADX WARN: Code duplicated, block: B:89:0x023b  */
    /* JADX WARN: Code duplicated, block: B:94:0x024a  */
    /* JADX WARN: Code duplicated, block: B:97:0x0266  */
    /* JADX WARN: Code duplicated, block: B:98:0x0269  */
    public static final void PreviousVersionItemPreview(final Store<PreviousVersionReducer.State, PreviousVersionReducer.Action> store, final PreviousVersionUIDependencyProvider dependencyProvider, final SnackbarHostState snackbarHostState, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Modifier modifier4;
        State stateCollectAsStateWithLifecycle;
        Store<LocalState, PreviousVersionReducer.Action> storeScope;
        Function0<ComposeUiNode> constructor;
        ItemState itemState;
        Modifier modifier5;
        Object obj;
        float f;
        int i5;
        boolean z2;
        Object objRememberedValue;
        KClass orCreateKotlinClass;
        PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$11$1 previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$11$1RememberedValue;
        Function1 function1;
        Object value;
        Store storeScope2;
        int i6;
        boolean z3;
        PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$12$1 previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$12$1RememberedValue;
        boolean z4;
        PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$13$1 previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$13$1RememberedValue;
        KClass orCreateKotlinClass2;
        PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$8$1 previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$8$1RememberedValue;
        Function1 function2;
        Object value2;
        Store storeScope3;
        int i7;
        boolean z5;
        PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$9$1 previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$9$1RememberedValue;
        boolean z6;
        PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$10$1 previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$10$1RememberedValue;
        LoadingPlaceholder loadingPlaceholder;
        KClass orCreateKotlinClass3;
        PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$1$1 previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$1$1RememberedValue;
        Function1 function3;
        Object value3;
        Store storeScope4;
        int i8;
        boolean z7;
        PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$2$1 previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$2$1RememberedValue;
        boolean z8;
        PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$3$1 previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$3$1RememberedValue;
        boolean z9;
        PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$4$1 previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$4$1RememberedValue;
        boolean z10;
        PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$5$1 previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$5$1RememberedValue;
        boolean z11;
        PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$6$1 previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$6$1RememberedValue;
        boolean z12;
        PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$7$1 previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$7$1RememberedValue;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(dependencyProvider, "dependencyProvider");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Composer composerStartRestartGroup = composer.startRestartGroup(1168420100);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PreviousVersionItemPreview)N(store,dependencyProvider,snackbarHostState,modifier)95@4030L29,97@4114L3016:PreviousVersionPreviewScreen.kt#k0omno");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(dependencyProvider) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(snackbarHostState) ? 256 : 128;
        }
        int i9 = i2 & 8;
        if (i9 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i3;
            if ((i4 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1168420100, i4, -1, "com.box.android.preview.previousversion.PreviousVersionItemPreview (PreviousVersionPreviewScreen.kt:94)");
                }
                modifier4 = companion;
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                storeScope = store.scope(new PropertyReference1Impl() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$itemStore$1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj2) {
                        return ((PreviousVersionReducer.State) obj2).getItemState();
                    }
                });
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                composerStartRestartGroup.startReplaceGroup(346060118);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C:PreviousVersionPreviewScreen.kt#k0omno");
                itemState = PreviousVersionItemPreview$lambda$0(stateCollectAsStateWithLifecycle).getItemState();
                if (itemState instanceof ItemState.Document) {
                    composerStartRestartGroup.startReplaceGroup(346092946);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "106@4436L16,110@4661L43,111@4755L46,112@4854L48,113@4947L40,114@5035L43,115@5129L46,103@4291L902");
                    orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(ItemState.Document.class);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -543020742, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                    previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$1$1RememberedValue = PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$1$1.INSTANCE;
                        composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function3 = (Function1) ((KFunction) previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$1$1RememberedValue);
                    value3 = storeScope.getState().getValue();
                    if (!(value3 instanceof ItemState.Document)) {
                        value3 = null;
                    }
                    if (((ItemState.Document) value3) != null) {
                        storeScope4 = storeScope.scope(KClassesJvm.getJvmName(orCreateKotlinClass3), new Function1<ItemState, Wrapped<DocumentPreviewReducer.State>>() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$lambda$1$$inlined$caseLet$1
                            @Override // kotlin.jvm.functions.Function1
                            public final Wrapped<DocumentPreviewReducer.State> invoke(ItemState globalState) {
                                DocumentPreviewReducer.State action;
                                Intrinsics.checkNotNullParameter(globalState, "globalState");
                                if (!(globalState instanceof ItemState.Document)) {
                                    globalState = null;
                                }
                                ItemState.Document document = (ItemState.Document) globalState;
                                if (document == null || (action = document.getAction()) == null) {
                                    return null;
                                }
                                return StoreKt.wrap(action);
                            }
                        }, (Function1<? super LocalAction, ? extends PreviousVersionReducer.Action>) function3);
                    } else {
                        storeScope4 = null;
                    }
                    if (storeScope4 == null) {
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.endReplaceGroup();
                        modifier5 = modifier4;
                    } else {
                        boolean z13 = !PreviousVersionItemPreview$lambda$0(stateCollectAsStateWithLifecycle).isImmersiveMode();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -543013515, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                        i8 = i4 & 112;
                        if (i8 == 32) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z7 || previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$2$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$2$1(dependencyProvider);
                            composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Function0 function0 = (Function0) ((KFunction) previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$2$1RememberedValue);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -543010504, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                        if (i8 == 32) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z8 || previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$3$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$3$1(dependencyProvider);
                            composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$3$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Function0 function4 = (Function0) ((KFunction) previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$3$1RememberedValue);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -543007334, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                        if (i8 == 32) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z9 || previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$4$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$4$1(dependencyProvider);
                            composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$4$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Function0 function5 = (Function0) ((KFunction) previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$4$1RememberedValue);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -543004366, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                        if (i8 == 32) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z10 || previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$5$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$5$1(dependencyProvider);
                            composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$5$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Function0 function6 = (Function0) ((KFunction) previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$5$1RememberedValue);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -543001547, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                        if (i8 == 32) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z11 || previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$6$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$6$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$6$1(dependencyProvider);
                            composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$6$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Function1 function7 = (Function1) ((KFunction) previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$6$1RememberedValue);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -542998536, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                        if (i8 == 32) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z12 || previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$7$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$7$1(dependencyProvider);
                            composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$7$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        modifier5 = modifier4;
                        obj = null;
                        DocumentPreviewScreenKt.DocumentPreviewScreen(storeScope4, z13, snackbarHostState, function0, function4, function5, function6, function7, (Function1) ((KFunction) previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$7$1RememberedValue), composerStartRestartGroup, i4 & 896);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                        i5 = 1;
                        f = 0.0f;
                        loadingPlaceholder = PreviousVersionItemPreview$lambda$0(stateCollectAsStateWithLifecycle).getItemState().getLoadingPlaceholder();
                        if (loadingPlaceholder == null) {
                            composerStartRestartGroup.startReplaceGroup(348627908);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(348627909);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*158@6867L247");
                            Composer composer2 = composerStartRestartGroup;
                            PreviewLoadingScreenKt.m12836PreviewLoadingScreenFJfuzF0(loadingPlaceholder.getIcon(), PreviousVersionItemPreview$lambda$0(stateCollectAsStateWithLifecycle).getFileModel().getItemId().toString(), SizeKt.fillMaxSize$default(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(42), 7, null), f, i5, obj), null, 0.0f, composer2, 384, 24);
                            composerStartRestartGroup = composer2;
                            Unit unit = Unit.INSTANCE;
                            composerStartRestartGroup.endReplaceGroup();
                            Unit unit2 = Unit.INSTANCE;
                        }
                        composerStartRestartGroup.endReplaceGroup();
                    }
                } else {
                    modifier5 = modifier4;
                    obj = null;
                    f = 0.0f;
                    if (itemState instanceof ItemState.Image) {
                        composerStartRestartGroup.startReplaceGroup(347041267);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "123@5400L13,126@5556L43,127@5650L46,120@5261L453");
                        orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(ItemState.Image.class);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -542989897, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                        previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$8$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$8$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$8$1RememberedValue = PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$8$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$8$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function2 = (Function1) ((KFunction) previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$8$1RememberedValue);
                        value2 = storeScope.getState().getValue();
                        if (!(value2 instanceof ItemState.Image)) {
                            value2 = null;
                        }
                        if (((ItemState.Image) value2) != null) {
                            storeScope3 = storeScope.scope(KClassesJvm.getJvmName(orCreateKotlinClass2), new Function1<ItemState, Wrapped<ImagePreviewReducer.State>>() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$lambda$1$$inlined$caseLet$2
                                @Override // kotlin.jvm.functions.Function1
                                public final Wrapped<ImagePreviewReducer.State> invoke(ItemState globalState) {
                                    ImagePreviewReducer.State action;
                                    Intrinsics.checkNotNullParameter(globalState, "globalState");
                                    if (!(globalState instanceof ItemState.Image)) {
                                        globalState = null;
                                    }
                                    ItemState.Image image = (ItemState.Image) globalState;
                                    if (image == null || (action = image.getAction()) == null) {
                                        return null;
                                    }
                                    return StoreKt.wrap(action);
                                }
                            }, (Function1<? super LocalAction, ? extends PreviousVersionReducer.Action>) function2);
                        } else {
                            storeScope3 = null;
                        }
                        if (storeScope3 == null) {
                            composerStartRestartGroup.endReplaceGroup();
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -542984875, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                            i7 = i4 & 112;
                            if (i7 == 32) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$9$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z5 || previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$9$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$9$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$9$1(dependencyProvider);
                                composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$9$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Function1 function8 = (Function1) ((KFunction) previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$9$1RememberedValue);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -542981864, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                            if (i7 == 32) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$10$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z6 || previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$10$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$10$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$10$1(dependencyProvider);
                                composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$10$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ImagePreviewScreenKt.ImagePreviewScreen(storeScope3, snackbarHostState, function8, (Function1) ((KFunction) previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$10$1RememberedValue), composerStartRestartGroup, (i4 >> 3) & 112);
                            composerStartRestartGroup.endReplaceGroup();
                            i5 = 1;
                            loadingPlaceholder = PreviousVersionItemPreview$lambda$0(stateCollectAsStateWithLifecycle).getItemState().getLoadingPlaceholder();
                            if (loadingPlaceholder == null) {
                                composerStartRestartGroup.startReplaceGroup(348627908);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(348627909);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*158@6867L247");
                                Composer composer3 = composerStartRestartGroup;
                                PreviewLoadingScreenKt.m12836PreviewLoadingScreenFJfuzF0(loadingPlaceholder.getIcon(), PreviousVersionItemPreview$lambda$0(stateCollectAsStateWithLifecycle).getFileModel().getItemId().toString(), SizeKt.fillMaxSize$default(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(42), 7, null), f, i5, obj), null, 0.0f, composer3, 384, 24);
                                composerStartRestartGroup = composer3;
                                Unit unit3 = Unit.INSTANCE;
                                composerStartRestartGroup.endReplaceGroup();
                                Unit unit4 = Unit.INSTANCE;
                            }
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    } else {
                        if (itemState instanceof ItemState.Video) {
                            composerStartRestartGroup.startReplaceGroup(347582434);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "135@5921L13,139@6185L46,140@6277L43,132@5782L694");
                            orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ItemState.Video.class);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -542973225, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                            previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$11$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$11$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$11$1RememberedValue = PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$11$1.INSTANCE;
                                composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$11$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function1 = (Function1) ((KFunction) previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$11$1RememberedValue);
                            value = storeScope.getState().getValue();
                            if (!(value instanceof ItemState.Video)) {
                                value = null;
                            }
                            if (((ItemState.Video) value) != null) {
                                storeScope2 = storeScope.scope(KClassesJvm.getJvmName(orCreateKotlinClass), new Function1<ItemState, Wrapped<VideoPreviewReducer.State>>() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$lambda$1$$inlined$caseLet$3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Wrapped<VideoPreviewReducer.State> invoke(ItemState globalState) {
                                        VideoPreviewReducer.State action;
                                        Intrinsics.checkNotNullParameter(globalState, "globalState");
                                        if (!(globalState instanceof ItemState.Video)) {
                                            globalState = null;
                                        }
                                        ItemState.Video video = (ItemState.Video) globalState;
                                        if (video == null || (action = video.getAction()) == null) {
                                            return null;
                                        }
                                        return StoreKt.wrap(action);
                                    }
                                }, (Function1<? super LocalAction, ? extends PreviousVersionReducer.Action>) function1);
                            } else {
                                storeScope2 = null;
                            }
                            if (storeScope2 == null) {
                                composerStartRestartGroup.endReplaceGroup();
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                Media3VideoPlayerManager videoPlayerManager = dependencyProvider.getVideoPlayerManager();
                                VideoPlayersProvider videoPlayersProvider = dependencyProvider.getVideoPlayersProvider();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -542964744, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                                i6 = i4 & 112;
                                if (i6 == 32) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$12$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                if (z3 || previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$12$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$12$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$12$1(dependencyProvider);
                                    composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$12$1RememberedValue);
                                }
                                KFunction kFunction = (KFunction) previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$12$1RememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -542961803, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                                if (i6 == 32) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$13$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                if (z4 || previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$13$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$13$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$13$1(dependencyProvider);
                                    composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$13$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                VideoPreviewScreenKt.VideoPreviewScreen(storeScope2, videoPlayerManager, videoPlayersProvider, (Function1) ((KFunction) previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$13$1RememberedValue), (Function1) kFunction, snackbarHostState, PreviousVersionItemPreview$lambda$0(stateCollectAsStateWithLifecycle).getEnqueuedAnnotationNavigation(), composerStartRestartGroup, (i4 << 9) & 458752);
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceGroup();
                                i5 = 1;
                            }
                        } else {
                            i5 = 1;
                            if (itemState instanceof ItemState.Error) {
                                composerStartRestartGroup.startReplaceGroup(348306284);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "150@6702L28,147@6544L204");
                                ItemState.Error error = (ItemState.Error) itemState;
                                ItemId itemId = error.getFileModel().getItemId();
                                DomainError error2 = error.getError();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -542948218, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                                if ((i4 & 14) == 4) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function0() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewScreenKt$$ExternalSyntheticLambda6
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return PreviousVersionPreviewScreenKt.PreviousVersionItemPreview$lambda$1$13$0(store);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                PreviewErrorScreenKt.PreviewErrorScreen(itemId, error2, (Function0) objRememberedValue, null, composerStartRestartGroup, 0, 8);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-542945618);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        }
                        loadingPlaceholder = PreviousVersionItemPreview$lambda$0(stateCollectAsStateWithLifecycle).getItemState().getLoadingPlaceholder();
                        if (loadingPlaceholder == null) {
                            composerStartRestartGroup.startReplaceGroup(348627908);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(348627909);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*158@6867L247");
                            Composer composer4 = composerStartRestartGroup;
                            PreviewLoadingScreenKt.m12836PreviewLoadingScreenFJfuzF0(loadingPlaceholder.getIcon(), PreviousVersionItemPreview$lambda$0(stateCollectAsStateWithLifecycle).getFileModel().getItemId().toString(), SizeKt.fillMaxSize$default(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(42), 7, null), f, i5, obj), null, 0.0f, composer4, 384, 24);
                            composerStartRestartGroup = composer4;
                            Unit unit5 = Unit.INSTANCE;
                            composerStartRestartGroup.endReplaceGroup();
                            Unit unit6 = Unit.INSTANCE;
                        }
                        composerStartRestartGroup.endReplaceGroup();
                    }
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return PreviousVersionPreviewScreenKt.PreviousVersionItemPreview$lambda$2(store, dependencyProvider, snackbarHostState, modifier3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        i4 = i3;
        if ((i4 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            if (i9 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1168420100, i4, -1, "com.box.android.preview.previousversion.PreviousVersionItemPreview (PreviousVersionPreviewScreen.kt:94)");
            }
            modifier4 = companion;
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            storeScope = store.scope(new PropertyReference1Impl() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$itemStore$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj2) {
                    return ((PreviousVersionReducer.State) obj2).getItemState();
                }
            });
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceGroup(346060118);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C:PreviousVersionPreviewScreen.kt#k0omno");
            itemState = PreviousVersionItemPreview$lambda$0(stateCollectAsStateWithLifecycle).getItemState();
            if (itemState instanceof ItemState.Document) {
                composerStartRestartGroup.startReplaceGroup(346092946);
                ComposerKt.sourceInformation(composerStartRestartGroup, "106@4436L16,110@4661L43,111@4755L46,112@4854L48,113@4947L40,114@5035L43,115@5129L46,103@4291L902");
                orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(ItemState.Document.class);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -543020742, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$1$1RememberedValue = PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$1$1.INSTANCE;
                    composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function3 = (Function1) ((KFunction) previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$1$1RememberedValue);
                value3 = storeScope.getState().getValue();
                if (!(value3 instanceof ItemState.Document)) {
                    value3 = null;
                }
                if (((ItemState.Document) value3) != null) {
                    storeScope4 = storeScope.scope(KClassesJvm.getJvmName(orCreateKotlinClass3), new Function1<ItemState, Wrapped<DocumentPreviewReducer.State>>() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$lambda$1$$inlined$caseLet$1
                        @Override // kotlin.jvm.functions.Function1
                        public final Wrapped<DocumentPreviewReducer.State> invoke(ItemState globalState) {
                            DocumentPreviewReducer.State action;
                            Intrinsics.checkNotNullParameter(globalState, "globalState");
                            if (!(globalState instanceof ItemState.Document)) {
                                globalState = null;
                            }
                            ItemState.Document document = (ItemState.Document) globalState;
                            if (document == null || (action = document.getAction()) == null) {
                                return null;
                            }
                            return StoreKt.wrap(action);
                        }
                    }, (Function1<? super LocalAction, ? extends PreviousVersionReducer.Action>) function3);
                } else {
                    storeScope4 = null;
                }
                if (storeScope4 == null) {
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.endReplaceGroup();
                    modifier5 = modifier4;
                } else {
                    boolean z14 = !PreviousVersionItemPreview$lambda$0(stateCollectAsStateWithLifecycle).isImmersiveMode();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -543013515, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                    i8 = i4 & 112;
                    if (i8 == 32) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z7) {
                        previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$2$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$2$1(dependencyProvider);
                        composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$2$1RememberedValue);
                    } else {
                        previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$2$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$2$1(dependencyProvider);
                        composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Function0 function9 = (Function0) ((KFunction) previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$2$1RememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -543010504, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                    if (i8 == 32) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z8) {
                        previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$3$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$3$1(dependencyProvider);
                        composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$3$1RememberedValue);
                    } else {
                        previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$3$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$3$1(dependencyProvider);
                        composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$3$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Function0 function10 = (Function0) ((KFunction) previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$3$1RememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -543007334, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                    if (i8 == 32) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z9) {
                        previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$4$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$4$1(dependencyProvider);
                        composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$4$1RememberedValue);
                    } else {
                        previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$4$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$4$1(dependencyProvider);
                        composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$4$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Function0 function11 = (Function0) ((KFunction) previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$4$1RememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -543004366, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                    if (i8 == 32) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z10) {
                        previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$5$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$5$1(dependencyProvider);
                        composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$5$1RememberedValue);
                    } else {
                        previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$5$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$5$1(dependencyProvider);
                        composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$5$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Function0 function12 = (Function0) ((KFunction) previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$5$1RememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -543001547, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                    if (i8 == 32) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z11) {
                        previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$6$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$6$1(dependencyProvider);
                        composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$6$1RememberedValue);
                    } else {
                        previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$6$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$6$1(dependencyProvider);
                        composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$6$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Function1 function13 = (Function1) ((KFunction) previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$6$1RememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -542998536, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                    if (i8 == 32) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z12) {
                        previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$7$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$7$1(dependencyProvider);
                        composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$7$1RememberedValue);
                    } else {
                        previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$7$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$7$1(dependencyProvider);
                        composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$7$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    modifier5 = modifier4;
                    obj = null;
                    DocumentPreviewScreenKt.DocumentPreviewScreen(storeScope4, z14, snackbarHostState, function9, function10, function11, function12, function13, (Function1) ((KFunction) previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$7$1RememberedValue), composerStartRestartGroup, i4 & 896);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                    i5 = 1;
                    f = 0.0f;
                    loadingPlaceholder = PreviousVersionItemPreview$lambda$0(stateCollectAsStateWithLifecycle).getItemState().getLoadingPlaceholder();
                    if (loadingPlaceholder == null) {
                        composerStartRestartGroup.startReplaceGroup(348627908);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(348627909);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*158@6867L247");
                        Composer composer5 = composerStartRestartGroup;
                        PreviewLoadingScreenKt.m12836PreviewLoadingScreenFJfuzF0(loadingPlaceholder.getIcon(), PreviousVersionItemPreview$lambda$0(stateCollectAsStateWithLifecycle).getFileModel().getItemId().toString(), SizeKt.fillMaxSize$default(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(42), 7, null), f, i5, obj), null, 0.0f, composer5, 384, 24);
                        composerStartRestartGroup = composer5;
                        Unit unit7 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit8 = Unit.INSTANCE;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                }
            } else {
                modifier5 = modifier4;
                obj = null;
                f = 0.0f;
                if (itemState instanceof ItemState.Image) {
                    composerStartRestartGroup.startReplaceGroup(347041267);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "123@5400L13,126@5556L43,127@5650L46,120@5261L453");
                    orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(ItemState.Image.class);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -542989897, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                    previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$8$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$8$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$8$1RememberedValue = PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$8$1.INSTANCE;
                        composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$8$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function2 = (Function1) ((KFunction) previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$8$1RememberedValue);
                    value2 = storeScope.getState().getValue();
                    if (!(value2 instanceof ItemState.Image)) {
                        value2 = null;
                    }
                    if (((ItemState.Image) value2) != null) {
                        storeScope3 = storeScope.scope(KClassesJvm.getJvmName(orCreateKotlinClass2), new Function1<ItemState, Wrapped<ImagePreviewReducer.State>>() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$lambda$1$$inlined$caseLet$2
                            @Override // kotlin.jvm.functions.Function1
                            public final Wrapped<ImagePreviewReducer.State> invoke(ItemState globalState) {
                                ImagePreviewReducer.State action;
                                Intrinsics.checkNotNullParameter(globalState, "globalState");
                                if (!(globalState instanceof ItemState.Image)) {
                                    globalState = null;
                                }
                                ItemState.Image image = (ItemState.Image) globalState;
                                if (image == null || (action = image.getAction()) == null) {
                                    return null;
                                }
                                return StoreKt.wrap(action);
                            }
                        }, (Function1<? super LocalAction, ? extends PreviousVersionReducer.Action>) function2);
                    } else {
                        storeScope3 = null;
                    }
                    if (storeScope3 == null) {
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -542984875, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                        i7 = i4 & 112;
                        if (i7 == 32) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$9$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z5) {
                            previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$9$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$9$1(dependencyProvider);
                            composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$9$1RememberedValue);
                        } else {
                            previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$9$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$9$1(dependencyProvider);
                            composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$9$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Function1 function14 = (Function1) ((KFunction) previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$9$1RememberedValue);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -542981864, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                        if (i7 == 32) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$10$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z6) {
                            previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$10$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$10$1(dependencyProvider);
                            composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$10$1RememberedValue);
                        } else {
                            previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$10$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$10$1(dependencyProvider);
                            composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$10$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ImagePreviewScreenKt.ImagePreviewScreen(storeScope3, snackbarHostState, function14, (Function1) ((KFunction) previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$10$1RememberedValue), composerStartRestartGroup, (i4 >> 3) & 112);
                        composerStartRestartGroup.endReplaceGroup();
                        i5 = 1;
                        loadingPlaceholder = PreviousVersionItemPreview$lambda$0(stateCollectAsStateWithLifecycle).getItemState().getLoadingPlaceholder();
                        if (loadingPlaceholder == null) {
                            composerStartRestartGroup.startReplaceGroup(348627908);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(348627909);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*158@6867L247");
                            Composer composer6 = composerStartRestartGroup;
                            PreviewLoadingScreenKt.m12836PreviewLoadingScreenFJfuzF0(loadingPlaceholder.getIcon(), PreviousVersionItemPreview$lambda$0(stateCollectAsStateWithLifecycle).getFileModel().getItemId().toString(), SizeKt.fillMaxSize$default(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(42), 7, null), f, i5, obj), null, 0.0f, composer6, 384, 24);
                            composerStartRestartGroup = composer6;
                            Unit unit9 = Unit.INSTANCE;
                            composerStartRestartGroup.endReplaceGroup();
                            Unit unit10 = Unit.INSTANCE;
                        }
                        composerStartRestartGroup.endReplaceGroup();
                    }
                } else {
                    if (itemState instanceof ItemState.Video) {
                        composerStartRestartGroup.startReplaceGroup(347582434);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "135@5921L13,139@6185L46,140@6277L43,132@5782L694");
                        orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ItemState.Video.class);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -542973225, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                        previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$11$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$11$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$11$1RememberedValue = PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$11$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$11$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function1 = (Function1) ((KFunction) previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$11$1RememberedValue);
                        value = storeScope.getState().getValue();
                        if (!(value instanceof ItemState.Video)) {
                            value = null;
                        }
                        if (((ItemState.Video) value) != null) {
                            storeScope2 = storeScope.scope(KClassesJvm.getJvmName(orCreateKotlinClass), new Function1<ItemState, Wrapped<VideoPreviewReducer.State>>() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$lambda$1$$inlined$caseLet$3
                                @Override // kotlin.jvm.functions.Function1
                                public final Wrapped<VideoPreviewReducer.State> invoke(ItemState globalState) {
                                    VideoPreviewReducer.State action;
                                    Intrinsics.checkNotNullParameter(globalState, "globalState");
                                    if (!(globalState instanceof ItemState.Video)) {
                                        globalState = null;
                                    }
                                    ItemState.Video video = (ItemState.Video) globalState;
                                    if (video == null || (action = video.getAction()) == null) {
                                        return null;
                                    }
                                    return StoreKt.wrap(action);
                                }
                            }, (Function1<? super LocalAction, ? extends PreviousVersionReducer.Action>) function1);
                        } else {
                            storeScope2 = null;
                        }
                        if (storeScope2 == null) {
                            composerStartRestartGroup.endReplaceGroup();
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            Media3VideoPlayerManager videoPlayerManager2 = dependencyProvider.getVideoPlayerManager();
                            VideoPlayersProvider videoPlayersProvider2 = dependencyProvider.getVideoPlayersProvider();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -542964744, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                            i6 = i4 & 112;
                            if (i6 == 32) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$12$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z3) {
                                previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$12$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$12$1(dependencyProvider);
                                composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$12$1RememberedValue);
                            } else {
                                previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$12$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$12$1(dependencyProvider);
                                composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$12$1RememberedValue);
                            }
                            KFunction kFunction2 = (KFunction) previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$12$1RememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -542961803, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                            if (i6 == 32) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$13$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z4) {
                                previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$13$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$13$1(dependencyProvider);
                                composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$13$1RememberedValue);
                            } else {
                                previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$13$1RememberedValue = new PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$13$1(dependencyProvider);
                                composerStartRestartGroup.updateRememberedValue(previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$13$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            VideoPreviewScreenKt.VideoPreviewScreen(storeScope2, videoPlayerManager2, videoPlayersProvider2, (Function1) ((KFunction) previousVersionPreviewScreenKt$PreviousVersionItemPreview$1$13$1RememberedValue), (Function1) kFunction2, snackbarHostState, PreviousVersionItemPreview$lambda$0(stateCollectAsStateWithLifecycle).getEnqueuedAnnotationNavigation(), composerStartRestartGroup, (i4 << 9) & 458752);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                            i5 = 1;
                        }
                    } else {
                        i5 = 1;
                        if (itemState instanceof ItemState.Error) {
                            composerStartRestartGroup.startReplaceGroup(348306284);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "150@6702L28,147@6544L204");
                            ItemState.Error error3 = (ItemState.Error) itemState;
                            ItemId itemId2 = error3.getFileModel().getItemId();
                            DomainError error4 = error3.getError();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -542948218, "CC(remember):PreviousVersionPreviewScreen.kt#9igjgp");
                            if ((i4 & 14) == 4) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (z2) {
                                objRememberedValue = new Function0() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewScreenKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return PreviousVersionPreviewScreenKt.PreviousVersionItemPreview$lambda$1$13$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = new Function0() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewScreenKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return PreviousVersionPreviewScreenKt.PreviousVersionItemPreview$lambda$1$13$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            PreviewErrorScreenKt.PreviewErrorScreen(itemId2, error4, (Function0) objRememberedValue, null, composerStartRestartGroup, 0, 8);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-542945618);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    }
                    loadingPlaceholder = PreviousVersionItemPreview$lambda$0(stateCollectAsStateWithLifecycle).getItemState().getLoadingPlaceholder();
                    if (loadingPlaceholder == null) {
                        composerStartRestartGroup.startReplaceGroup(348627908);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(348627909);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*158@6867L247");
                        Composer composer7 = composerStartRestartGroup;
                        PreviewLoadingScreenKt.m12836PreviewLoadingScreenFJfuzF0(loadingPlaceholder.getIcon(), PreviousVersionItemPreview$lambda$0(stateCollectAsStateWithLifecycle).getFileModel().getItemId().toString(), SizeKt.fillMaxSize$default(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(42), 7, null), f, i5, obj), null, 0.0f, composer7, 384, 24);
                        composerStartRestartGroup = composer7;
                        Unit unit11 = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                        Unit unit12 = Unit.INSTANCE;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                }
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previousversion.PreviousVersionPreviewScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return PreviousVersionPreviewScreenKt.PreviousVersionItemPreview$lambda$2(store, dependencyProvider, snackbarHostState, modifier3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviousVersionItemPreview$lambda$1$13$0(Store store) {
        store.send(PreviousVersionReducer.Action.Retry.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final Modifier immersiveModeAwarePadding(Modifier modifier, boolean z, Composer composer, int i) {
        Modifier.Companion companionM1222paddingqDBjuR0$default;
        ComposerKt.sourceInformationMarkerStart(composer, 709635022, "C(immersiveModeAwarePadding)N(isImmersiveMode)171@7272L7,172@7322L10,173@7364L7,174@7414L6,175@7469L6:PreviousVersionPreviewScreen.kt#k0omno");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(709635022, i, -1, "com.box.android.preview.previousversion.immersiveModeAwarePadding (PreviousVersionPreviewScreen.kt:170)");
        }
        ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i2 = ((Configuration) objConsume).orientation;
        WindowInsets systemBars = WindowInsets_androidKt.getSystemBars(WindowInsets.INSTANCE, composer, 6);
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) objConsume2;
        float dp = ComposeUtilsKt.toDp(systemBars.getTop(density), composer, 0);
        float dp2 = ComposeUtilsKt.toDp(systemBars.getBottom(density), composer, 0);
        float fM9687constructorimpl = Dp.m9687constructorimpl(BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM() + dp);
        if (i2 == 2) {
            dp2 = Dp.m9687constructorimpl(0);
        }
        float f = dp2;
        if (!z) {
            companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, fM9687constructorimpl, 0.0f, f, 5, null);
        } else {
            companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
        }
        Modifier modifierThen = modifier.then(companionM1222paddingqDBjuR0$default);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return modifierThen;
    }

    private static final PreviousVersionReducer.State PreviousVersionPreviewScreen$lambda$0(State<PreviousVersionReducer.State> state) {
        return state.getValue();
    }

    private static final PreviousVersionReducer.State PreviousVersionItemPreview$lambda$0(State<PreviousVersionReducer.State> state) {
        return state.getValue();
    }
}
