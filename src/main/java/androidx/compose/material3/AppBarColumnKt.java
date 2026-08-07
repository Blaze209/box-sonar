package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.node.ComposeUiNode;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppBarColumn.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u001aU\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0019\b\u0002\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\r\u001aS\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00072\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u0084\u0002"}, d2 = {"AppBarColumn", "", "modifier", "Landroidx/compose/ui/Modifier;", "overflowIndicator", "Lkotlin/Function1;", "Landroidx/compose/material3/AppBarMenuState;", "Landroidx/compose/runtime/Composable;", "maxItemCount", "", "content", "Landroidx/compose/material3/AppBarColumnScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "material3", "scope", "Landroidx/compose/material3/AppBarColumnScopeImpl;"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AppBarColumnKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppBarColumn$lambda$6(Modifier modifier, Function3 function3, int i, Function1 function1, int i2, int i3, Composer composer, int i4) {
        AppBarColumn(modifier, (Function3<? super AppBarMenuState, ? super Composer, ? super Integer, Unit>) function3, i, (Function1<? super AppBarColumnScope, Unit>) function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppBarColumn$lambda$7(Function3 function3, Modifier modifier, int i, Function1 function1, int i2, int i3, Composer composer, int i4) {
        AppBarColumn(function3, modifier, i, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0052  */
    /* JADX WARN: Code duplicated, block: B:27:0x0055  */
    /* JADX WARN: Code duplicated, block: B:29:0x0059  */
    /* JADX WARN: Code duplicated, block: B:31:0x0061  */
    /* JADX WARN: Code duplicated, block: B:32:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x006d  */
    /* JADX WARN: Code duplicated, block: B:39:0x0073  */
    /* JADX WARN: Code duplicated, block: B:40:0x0076  */
    /* JADX WARN: Code duplicated, block: B:44:0x0081  */
    /* JADX WARN: Code duplicated, block: B:45:0x0083  */
    /* JADX WARN: Code duplicated, block: B:48:0x008c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x008e  */
    /* JADX WARN: Code duplicated, block: B:50:0x0093  */
    /* JADX WARN: Code duplicated, block: B:52:0x0096  */
    /* JADX WARN: Code duplicated, block: B:54:0x009f  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:60:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:66:0x010d  */
    /* JADX WARN: Code duplicated, block: B:67:0x010f  */
    /* JADX WARN: Code duplicated, block: B:70:0x0117  */
    /* JADX WARN: Code duplicated, block: B:72:0x011f  */
    /* JADX WARN: Code duplicated, block: B:75:0x0171  */
    /* JADX WARN: Code duplicated, block: B:77:0x0179  */
    /* JADX WARN: Code duplicated, block: B:80:0x01af  */
    /* JADX WARN: Code duplicated, block: B:83:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:84:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:87:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:89:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:92:0x0222  */
    /* JADX WARN: Code duplicated, block: B:93:0x0226  */
    /* JADX WARN: Code duplicated, block: B:96:0x0231  */
    /* JADX WARN: Code duplicated, block: B:98:? A[RETURN, SYNTHETIC] */
    public static final void AppBarColumn(Modifier modifier, Function3<? super AppBarMenuState, ? super Composer, ? super Integer, Unit> function3, int i, final Function1<? super AppBarColumnScope, Unit> function1, Composer composer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        final Function3<? super AppBarMenuState, ? super Composer, ? super Integer, Unit> lambda$479541071$material3;
        int i5;
        int i6;
        int i7;
        boolean z;
        Modifier.Companion companion;
        final int i8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final State stateRememberUpdatedState;
        Object objRememberedValue;
        Object objRememberedValue2;
        final AppBarOverflowState appBarOverflowStateRememberAppBarOverflowState;
        boolean z2;
        boolean z3;
        Object objRememberedValue3;
        OverflowMeasurePolicy overflowMeasurePolicy;
        boolean zChanged;
        Object objRememberedValue4;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(1875457254);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AppBarColumn)N(modifier,overflowIndicator,maxItemCount,content)57@2764L29,58@2811L111,61@2943L30,62@2998L29,64@3060L131,71@3260L50,72@3328L679,68@3197L900:AppBarColumn.kt#uh7d8r");
        int i10 = i3 & 1;
        if (i10 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        int i11 = i3 & 2;
        if (i11 == 0) {
            if ((i2 & 48) == 0) {
                lambda$479541071$material3 = function3;
                i4 |= composerStartRestartGroup.changedInstance(lambda$479541071$material3) ? 32 : 16;
            }
            i5 = i3 & 4;
            if (i5 != 0) {
                if ((i2 & 384) == 0) {
                    i6 = i;
                    if (composerStartRestartGroup.changed(i6)) {
                        i7 = 256;
                    } else {
                        i7 = 128;
                    }
                    i4 |= i7;
                }
                if ((i2 & 3072) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i9 = 2048;
                    } else {
                        i9 = 1024;
                    }
                    i4 |= i9;
                }
                if ((i4 & 1171) != 1170) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    companion = modifier2;
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i11 != 0) {
                        lambda$479541071$material3 = ComposableSingletons$AppBarColumnKt.INSTANCE.getLambda$479541071$material3();
                    }
                    if (i5 != 0) {
                        i6 = Integer.MAX_VALUE;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1875457254, i4, -1, "androidx.compose.material3.AppBarColumn (AppBarColumn.kt:56)");
                    }
                    stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composerStartRestartGroup, (i4 >> 9) & 14);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1571832299, "CC(remember):AppBarColumn.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.AppBarColumnKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return AppBarColumnKt.AppBarColumn$lambda$0$0(stateRememberUpdatedState);
                            }
                        });
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    final State state = (State) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1571828156, "CC(remember):AppBarColumn.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new AppBarMenuState();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    final AppBarMenuState appBarMenuState = (AppBarMenuState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    appBarOverflowStateRememberAppBarOverflowState = AppBarDslKt.rememberAppBarOverflowState(composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1571824311, "CC(remember):AppBarColumn.kt#9igjgp");
                    boolean zChanged2 = composerStartRestartGroup.changed(appBarOverflowStateRememberAppBarOverflowState);
                    if ((i4 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = z2 | zChanged2;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new OverflowMeasurePolicy(appBarOverflowStateRememberAppBarOverflowState, i6, true);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    List listListOf = CollectionsKt.listOf((Object[]) new Function2[]{ComposableLambdaKt.rememberComposableLambda(1370109943, true, new Function2() { // from class: androidx.compose.material3.AppBarColumnKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AppBarColumnKt.AppBarColumn$lambda$4(state, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(2072044536, true, new Function2() { // from class: androidx.compose.material3.AppBarColumnKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AppBarColumnKt.AppBarColumn$lambda$5(lambda$479541071$material3, appBarMenuState, appBarOverflowStateRememberAppBarOverflowState, state, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54)});
                    overflowMeasurePolicy = (OverflowMeasurePolicy) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
                    Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listListOf);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -290764973, "CC(remember):Layout.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(overflowMeasurePolicy);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = MultiContentMeasurePolicyKt.createMeasurePolicy(overflowMeasurePolicy);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    function2CombineAsVirtualLayouts.invoke(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                i8 = i6;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier3 = companion;
                    final Function3<? super AppBarMenuState, ? super Composer, ? super Integer, Unit> function4 = lambda$479541071$material3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarColumnKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AppBarColumnKt.AppBarColumn$lambda$6(modifier3, function4, i8, function1, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 384;
            i6 = i;
            if ((i2 & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i9 = 2048;
                } else {
                    i9 = 1024;
                }
                i4 |= i9;
            }
            if ((i4 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i11 != 0) {
                    lambda$479541071$material3 = ComposableSingletons$AppBarColumnKt.INSTANCE.getLambda$479541071$material3();
                }
                if (i5 != 0) {
                    i6 = Integer.MAX_VALUE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1875457254, i4, -1, "androidx.compose.material3.AppBarColumn (AppBarColumn.kt:56)");
                }
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composerStartRestartGroup, (i4 >> 9) & 14);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1571832299, "CC(remember):AppBarColumn.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.AppBarColumnKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AppBarColumnKt.AppBarColumn$lambda$0$0(stateRememberUpdatedState);
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final State state2 = (State) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1571828156, "CC(remember):AppBarColumn.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new AppBarMenuState();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final AppBarMenuState appBarMenuState2 = (AppBarMenuState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                appBarOverflowStateRememberAppBarOverflowState = AppBarDslKt.rememberAppBarOverflowState(composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1571824311, "CC(remember):AppBarColumn.kt#9igjgp");
                boolean zChanged3 = composerStartRestartGroup.changed(appBarOverflowStateRememberAppBarOverflowState);
                if ((i4 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = z2 | zChanged3;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    objRememberedValue3 = new OverflowMeasurePolicy(appBarOverflowStateRememberAppBarOverflowState, i6, true);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new OverflowMeasurePolicy(appBarOverflowStateRememberAppBarOverflowState, i6, true);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                List listListOf2 = CollectionsKt.listOf((Object[]) new Function2[]{ComposableLambdaKt.rememberComposableLambda(1370109943, true, new Function2() { // from class: androidx.compose.material3.AppBarColumnKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarColumnKt.AppBarColumn$lambda$4(state2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(2072044536, true, new Function2() { // from class: androidx.compose.material3.AppBarColumnKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarColumnKt.AppBarColumn$lambda$5(lambda$479541071$material3, appBarMenuState2, appBarOverflowStateRememberAppBarOverflowState, state2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54)});
                overflowMeasurePolicy = (OverflowMeasurePolicy) objRememberedValue3;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
                Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts2 = LayoutKt.combineAsVirtualLayouts(listListOf2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -290764973, "CC(remember):Layout.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(overflowMeasurePolicy);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue4 = MultiContentMeasurePolicyKt.createMeasurePolicy(overflowMeasurePolicy);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = MultiContentMeasurePolicyKt.createMeasurePolicy(overflowMeasurePolicy);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                MeasurePolicy measurePolicy2 = (MeasurePolicy) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                function2CombineAsVirtualLayouts2.invoke(composerStartRestartGroup, 0);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            i8 = i6;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier4 = companion;
                final Function3 function5 = lambda$479541071$material3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarColumnKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarColumnKt.AppBarColumn$lambda$6(modifier4, function5, i8, function1, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        lambda$479541071$material3 = function3;
        i5 = i3 & 4;
        if (i5 != 0) {
            if ((i2 & 384) == 0) {
                i6 = i;
                if (composerStartRestartGroup.changed(i6)) {
                    i7 = 256;
                } else {
                    i7 = 128;
                }
                i4 |= i7;
            }
            if ((i2 & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i9 = 2048;
                } else {
                    i9 = 1024;
                }
                i4 |= i9;
            }
            if ((i4 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i11 != 0) {
                    lambda$479541071$material3 = ComposableSingletons$AppBarColumnKt.INSTANCE.getLambda$479541071$material3();
                }
                if (i5 != 0) {
                    i6 = Integer.MAX_VALUE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1875457254, i4, -1, "androidx.compose.material3.AppBarColumn (AppBarColumn.kt:56)");
                }
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composerStartRestartGroup, (i4 >> 9) & 14);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1571832299, "CC(remember):AppBarColumn.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.AppBarColumnKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AppBarColumnKt.AppBarColumn$lambda$0$0(stateRememberUpdatedState);
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final State state3 = (State) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1571828156, "CC(remember):AppBarColumn.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new AppBarMenuState();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final AppBarMenuState appBarMenuState3 = (AppBarMenuState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                appBarOverflowStateRememberAppBarOverflowState = AppBarDslKt.rememberAppBarOverflowState(composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1571824311, "CC(remember):AppBarColumn.kt#9igjgp");
                boolean zChanged4 = composerStartRestartGroup.changed(appBarOverflowStateRememberAppBarOverflowState);
                if ((i4 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = z2 | zChanged4;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    objRememberedValue3 = new OverflowMeasurePolicy(appBarOverflowStateRememberAppBarOverflowState, i6, true);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new OverflowMeasurePolicy(appBarOverflowStateRememberAppBarOverflowState, i6, true);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                List listListOf3 = CollectionsKt.listOf((Object[]) new Function2[]{ComposableLambdaKt.rememberComposableLambda(1370109943, true, new Function2() { // from class: androidx.compose.material3.AppBarColumnKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarColumnKt.AppBarColumn$lambda$4(state3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(2072044536, true, new Function2() { // from class: androidx.compose.material3.AppBarColumnKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarColumnKt.AppBarColumn$lambda$5(lambda$479541071$material3, appBarMenuState3, appBarOverflowStateRememberAppBarOverflowState, state3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54)});
                overflowMeasurePolicy = (OverflowMeasurePolicy) objRememberedValue3;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
                Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts3 = LayoutKt.combineAsVirtualLayouts(listListOf3);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -290764973, "CC(remember):Layout.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(overflowMeasurePolicy);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue4 = MultiContentMeasurePolicyKt.createMeasurePolicy(overflowMeasurePolicy);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = MultiContentMeasurePolicyKt.createMeasurePolicy(overflowMeasurePolicy);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                MeasurePolicy measurePolicy3 = (MeasurePolicy) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                function2CombineAsVirtualLayouts3.invoke(composerStartRestartGroup, 0);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            i8 = i6;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier5 = companion;
                final Function3 function6 = lambda$479541071$material3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarColumnKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarColumnKt.AppBarColumn$lambda$6(modifier5, function6, i8, function1, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 384;
        i6 = i;
        if ((i2 & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(function1)) {
                i9 = 2048;
            } else {
                i9 = 1024;
            }
            i4 |= i9;
        }
        if ((i4 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier2;
        } else {
            if (i10 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i11 != 0) {
                lambda$479541071$material3 = ComposableSingletons$AppBarColumnKt.INSTANCE.getLambda$479541071$material3();
            }
            if (i5 != 0) {
                i6 = Integer.MAX_VALUE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1875457254, i4, -1, "androidx.compose.material3.AppBarColumn (AppBarColumn.kt:56)");
            }
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composerStartRestartGroup, (i4 >> 9) & 14);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1571832299, "CC(remember):AppBarColumn.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.AppBarColumnKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AppBarColumnKt.AppBarColumn$lambda$0$0(stateRememberUpdatedState);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final State state4 = (State) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1571828156, "CC(remember):AppBarColumn.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new AppBarMenuState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final AppBarMenuState appBarMenuState4 = (AppBarMenuState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            appBarOverflowStateRememberAppBarOverflowState = AppBarDslKt.rememberAppBarOverflowState(composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1571824311, "CC(remember):AppBarColumn.kt#9igjgp");
            boolean zChanged5 = composerStartRestartGroup.changed(appBarOverflowStateRememberAppBarOverflowState);
            if ((i4 & 896) == 256) {
                z2 = true;
            } else {
                z2 = false;
            }
            z3 = z2 | zChanged5;
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!z3) {
                objRememberedValue3 = new OverflowMeasurePolicy(appBarOverflowStateRememberAppBarOverflowState, i6, true);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new OverflowMeasurePolicy(appBarOverflowStateRememberAppBarOverflowState, i6, true);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            List listListOf4 = CollectionsKt.listOf((Object[]) new Function2[]{ComposableLambdaKt.rememberComposableLambda(1370109943, true, new Function2() { // from class: androidx.compose.material3.AppBarColumnKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBarColumnKt.AppBarColumn$lambda$4(state4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(2072044536, true, new Function2() { // from class: androidx.compose.material3.AppBarColumnKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBarColumnKt.AppBarColumn$lambda$5(lambda$479541071$material3, appBarMenuState4, appBarOverflowStateRememberAppBarOverflowState, state4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54)});
            overflowMeasurePolicy = (OverflowMeasurePolicy) objRememberedValue3;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
            Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts4 = LayoutKt.combineAsVirtualLayouts(listListOf4);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -290764973, "CC(remember):Layout.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(overflowMeasurePolicy);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue4 = MultiContentMeasurePolicyKt.createMeasurePolicy(overflowMeasurePolicy);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = MultiContentMeasurePolicyKt.createMeasurePolicy(overflowMeasurePolicy);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            MeasurePolicy measurePolicy4 = (MeasurePolicy) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl.getInserting()) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            function2CombineAsVirtualLayouts4.invoke(composerStartRestartGroup, 0);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        i8 = i6;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = companion;
            final Function3 function7 = lambda$479541071$material3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarColumnKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBarColumnKt.AppBarColumn$lambda$6(modifier6, function7, i8, function1, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppBarColumnScopeImpl AppBarColumn$lambda$0$0(State state) {
        AppBarColumnScopeImpl appBarColumnScopeImpl = new AppBarColumnScopeImpl(new AppBarScopeImpl());
        ((Function1) state.getValue()).invoke(appBarColumnScopeImpl);
        return appBarColumnScopeImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppBarColumn$lambda$4(State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C*71@3291L15:AppBarColumn.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1370109943, i, -1, "androidx.compose.material3.AppBarColumn.<anonymous> (AppBarColumn.kt:71)");
            }
            List<AppBarItem> items = AppBarColumn$lambda$1(state).getItems();
            int size = items.size();
            for (int i2 = 0; i2 < size; i2++) {
                items.get(i2).AppbarContent(composer, 0);
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
    public static final Unit AppBarColumn$lambda$5(Function3 function3, final AppBarMenuState appBarMenuState, final AppBarOverflowState appBarOverflowState, final State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C73@3350L639:AppBarColumn.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2072044536, i, -1, "androidx.compose.material3.AppBarColumn.<anonymous> (AppBarColumn.kt:73)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1623888026, "C74@3380L28,77@3554L23,78@3605L362,75@3433L534:AppBarColumn.kt#uh7d8r");
            function3.invoke(appBarMenuState, composer, 0);
            boolean zIsExpanded = appBarMenuState.isExpanded();
            ComposerKt.sourceInformationMarkerStart(composer, 468030485, "CC(remember):AppBarColumn.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(appBarMenuState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.AppBarColumnKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AppBarColumnKt.AppBarColumn$lambda$5$0$0$0(appBarMenuState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AndroidMenu_androidKt.m2743DropdownMenuIlH_yew(zIsExpanded, (Function0) objRememberedValue, null, 0L, null, null, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1094324771, true, new Function3() { // from class: androidx.compose.material3.AppBarColumnKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AppBarColumnKt.AppBarColumn$lambda$5$0$1(appBarOverflowState, state, appBarMenuState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 0, 48, 2044);
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
    public static final Unit AppBarColumn$lambda$5$0$0$0(AppBarMenuState appBarMenuState) {
        appBarMenuState.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppBarColumn$lambda$5$0$1(AppBarOverflowState appBarOverflowState, State state, AppBarMenuState appBarMenuState, ColumnScope columnScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C*84@3917L22:AppBarColumn.kt#uh7d8r");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1094324771, i, -1, "androidx.compose.material3.AppBarColumn.<anonymous>.<anonymous>.<anonymous> (AppBarColumn.kt:79)");
            }
            List<AppBarItem> listSubList = AppBarColumn$lambda$1(state).getItems().subList(appBarOverflowState.getVisibleItemCount(), appBarOverflowState.getTotalItemCount());
            int size = listSubList.size();
            for (int i2 = 0; i2 < size; i2++) {
                listSubList.get(i2).MenuContent(appBarMenuState, composer, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility.")
    public static final /* synthetic */ void AppBarColumn(Function3 function3, Modifier modifier, int i, Function1 function1, Composer composer, final int i2, final int i3) {
        int i4;
        Function3 function4;
        final Function1 function2;
        final int i5;
        final Modifier modifier2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1484836710);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AppBarColumn)N(overflowIndicator,modifier,maxItemCount,content)102@4487L64:AppBarColumn.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(function3) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i6 = i3 & 2;
        if (i6 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i7 = i3 & 4;
        if (i7 != 0) {
            i4 |= 384;
        } else if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i4 & 1171) != 1170, i4 & 1)) {
            function4 = function3;
            function2 = function1;
            composerStartRestartGroup.skipToGroupEnd();
            i5 = i;
            modifier2 = modifier;
        } else {
            if (i6 != 0) {
                modifier = Modifier.INSTANCE;
            }
            Modifier modifier3 = modifier;
            if (i7 != 0) {
                i = Integer.MAX_VALUE;
            }
            int i8 = i;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1484836710, i4, -1, "androidx.compose.material3.AppBarColumn (AppBarColumn.kt:102)");
            }
            function4 = function3;
            AppBarColumn(modifier3, (Function3<? super AppBarMenuState, ? super Composer, ? super Integer, Unit>) function4, i8, (Function1<? super AppBarColumnScope, Unit>) function1, composerStartRestartGroup, ((i4 >> 3) & 14) | ((i4 << 3) & 112) | (i4 & 896) | (i4 & 7168), 0);
            function2 = function1;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            i5 = i8;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function3 function5 = function4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarColumnKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBarColumnKt.AppBarColumn$lambda$7(function5, modifier2, i5, function2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final AppBarColumnScopeImpl AppBarColumn$lambda$1(State<AppBarColumnScopeImpl> state) {
        return state.getValue();
    }
}
