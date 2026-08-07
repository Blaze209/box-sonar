package expo.modules.ui;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.FloatingToolbarDefaults;
import androidx.compose.material3.FloatingToolbarExitDirection;
import androidx.compose.material3.FloatingToolbarScrollBehavior;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.types.Either;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.ExpoComposeViewKt;
import expo.modules.kotlin.views.FunctionalComposableScope;
import expo.modules.ui.convertibles.ArrangementKt;
import expo.modules.ui.convertibles.ContentAlignment;
import expo.modules.ui.convertibles.HorizontalAlignment;
import expo.modules.ui.convertibles.HorizontalArrangementCustom;
import expo.modules.ui.convertibles.HorizontalArrangementDefault;
import expo.modules.ui.convertibles.VerticalAlignment;
import expo.modules.ui.convertibles.VerticalArrangementCustom;
import expo.modules.ui.convertibles.VerticalArrangementDefault;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ComposeViews.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\t"}, d2 = {"RowContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/LayoutProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/LayoutProps;Landroidx/compose/runtime/Composer;I)V", "FlowRowContent", "ColumnContent", "BoxContent", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ComposeViewsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxContent$lambda$12(FunctionalComposableScope functionalComposableScope, LayoutProps layoutProps, int i, Composer composer, int i2) {
        BoxContent(functionalComposableScope, layoutProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ColumnContent$lambda$8(FunctionalComposableScope functionalComposableScope, LayoutProps layoutProps, int i, Composer composer, int i2) {
        ColumnContent(functionalComposableScope, layoutProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlowRowContent$lambda$4(FunctionalComposableScope functionalComposableScope, LayoutProps layoutProps, int i, Composer composer, int i2) {
        FlowRowContent(functionalComposableScope, layoutProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RowContent$lambda$3(FunctionalComposableScope functionalComposableScope, LayoutProps layoutProps, int i, Composer composer, int i2) {
        RowContent(functionalComposableScope, layoutProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void RowContent(final FunctionalComposableScope functionalComposableScope, final LayoutProps props, Composer composer, final int i) {
        int i2;
        Arrangement.Horizontal start;
        Alignment.Vertical top;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(1660310426);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RowContent)67@2812L83,63@2578L609:ComposeViews.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        int i3 = i2;
        if ((i3 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1660310426, i3, -1, "expo.modules.ui.RowContent (ComposeViews.kt:57)");
            }
            FloatingToolbarExitAlwaysScrollBehavior floatingToolbarExitAlwaysScrollBehavior = props.getFloatingToolbarExitAlwaysScrollBehavior();
            FloatingToolbarExitDirection floatingToolbarExitDirectionM3442boximpl = floatingToolbarExitAlwaysScrollBehavior != null ? FloatingToolbarExitDirection.m3442boximpl(floatingToolbarExitAlwaysScrollBehavior.m14650toComposeExitDirection8LIK8E()) : null;
            composerStartRestartGroup.startReplaceGroup(2125458736);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*61@2525L44");
            FloatingToolbarScrollBehavior floatingToolbarScrollBehaviorM3423exitAlwaysScrollBehaviorYyGo6vs = floatingToolbarExitDirectionM3442boximpl == null ? null : FloatingToolbarDefaults.INSTANCE.m3423exitAlwaysScrollBehaviorYyGo6vs(floatingToolbarExitDirectionM3442boximpl.getValue(), null, null, null, composerStartRestartGroup, FloatingToolbarDefaults.$stable << 12, 14);
            composerStartRestartGroup.endReplaceGroup();
            Either<HorizontalArrangementDefault, HorizontalArrangementCustom> horizontalArrangement = props.getHorizontalArrangement();
            if (horizontalArrangement == null || (start = ArrangementKt.toComposeArrangement(horizontalArrangement)) == null) {
                start = Arrangement.INSTANCE.getStart();
            }
            Arrangement.Horizontal horizontal = start;
            VerticalAlignment verticalAlignment = props.getVerticalAlignment();
            if (verticalAlignment == null || (top = verticalAlignment.toComposeAlignment()) == null) {
                top = Alignment.INSTANCE.getTop();
            }
            Alignment.Vertical vertical = top;
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, (AppContext.$stable << 3) | (ComposableScope.$stable << 6));
            Modifier.Companion companionNestedScroll$default = Modifier.INSTANCE;
            if (floatingToolbarScrollBehaviorM3423exitAlwaysScrollBehaviorYyGo6vs != null) {
                companionNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(companionNestedScroll$default, floatingToolbarScrollBehaviorM3423exitAlwaysScrollBehaviorYyGo6vs, null, 2, null);
            }
            Modifier modifierThen = modifierApplyModifiers.then(companionNestedScroll$default);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontal, vertical, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -486044139, "C75@3168L15:ComposeViews.kt#v15e7d");
            ComposableScope composableScopeWith = ExpoComposeViewKt.with(new ComposableScope(null, null, null, null, 15, null), rowScopeInstance);
            if (floatingToolbarScrollBehaviorM3423exitAlwaysScrollBehaviorYyGo6vs != null) {
                composableScopeWith = ExpoComposeViewKt.with(composableScopeWith, floatingToolbarScrollBehaviorM3423exitAlwaysScrollBehaviorYyGo6vs);
            }
            functionalComposableScope.Children(composableScopeWith, composerStartRestartGroup, ComposableScope.$stable | (FunctionalComposableScope.$stable << 3) | ((i3 << 3) & 112));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ComposeViewsKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeViewsKt.RowContent$lambda$3(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void FlowRowContent(final FunctionalComposableScope functionalComposableScope, final LayoutProps props, Composer composer, final int i) {
        int i2;
        Arrangement.Horizontal start;
        Arrangement.Vertical top;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(-139151896);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FlowRowContent)85@3527L83,86@3615L96,81@3281L430:ComposeViews.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-139151896, i2, -1, "expo.modules.ui.FlowRowContent (ComposeViews.kt:80)");
            }
            Either<HorizontalArrangementDefault, HorizontalArrangementCustom> horizontalArrangement = props.getHorizontalArrangement();
            if (horizontalArrangement == null || (start = ArrangementKt.toComposeArrangement(horizontalArrangement)) == null) {
                start = Arrangement.INSTANCE.getStart();
            }
            Either<VerticalArrangementDefault, VerticalArrangementCustom> verticalArrangement = props.getVerticalArrangement();
            if (verticalArrangement == null || (top = ArrangementKt.m14684toComposeArrangement(verticalArrangement)) == null) {
                top = Arrangement.INSTANCE.getTop();
            }
            FlowLayoutKt.FlowRow(ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, (AppContext.$stable << 3) | (ComposableScope.$stable << 6)), start, top, null, 0, 0, ComposableLambdaKt.rememberComposableLambda(55865379, true, new Function3<FlowRowScope, Composer, Integer, Unit>() { // from class: expo.modules.ui.ComposeViewsKt.FlowRowContent.1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(FlowRowScope flowRowScope, Composer composer2, Integer num) {
                    invoke(flowRowScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(FlowRowScope FlowRow, Composer composer2, int i3) {
                    Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
                    ComposerKt.sourceInformation(composer2, "C89@3692L15:ComposeViews.kt#v15e7d");
                    if ((i3 & 6) == 0) {
                        i3 |= composer2.changed(FlowRow) ? 4 : 2;
                    }
                    if ((i3 & 19) == 18 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(55865379, i3, -1, "expo.modules.ui.FlowRowContent.<anonymous> (ComposeViews.kt:87)");
                    }
                    functionalComposableScope.Children(ExpoComposeViewKt.with(new ComposableScope(null, null, null, null, 15, null), FlowRow), composer2, ComposableScope.$stable | (FunctionalComposableScope.$stable << 3));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 1572864, 56);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ComposeViewsKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeViewsKt.FlowRowContent$lambda$4(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void ColumnContent(final FunctionalComposableScope functionalComposableScope, final LayoutProps props, Composer composer, final int i) {
        int i2;
        Arrangement.Vertical top;
        Alignment.Horizontal start;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(578012206);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ColumnContent)104@4234L83,100@3997L618:ComposeViews.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        int i3 = i2;
        if ((i3 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(578012206, i3, -1, "expo.modules.ui.ColumnContent (ComposeViews.kt:94)");
            }
            FloatingToolbarExitAlwaysScrollBehavior floatingToolbarExitAlwaysScrollBehavior = props.getFloatingToolbarExitAlwaysScrollBehavior();
            FloatingToolbarExitDirection floatingToolbarExitDirectionM3442boximpl = floatingToolbarExitAlwaysScrollBehavior != null ? FloatingToolbarExitDirection.m3442boximpl(floatingToolbarExitAlwaysScrollBehavior.m14650toComposeExitDirection8LIK8E()) : null;
            composerStartRestartGroup.startReplaceGroup(1418955044);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*98@3944L44");
            FloatingToolbarScrollBehavior floatingToolbarScrollBehaviorM3423exitAlwaysScrollBehaviorYyGo6vs = floatingToolbarExitDirectionM3442boximpl == null ? null : FloatingToolbarDefaults.INSTANCE.m3423exitAlwaysScrollBehaviorYyGo6vs(floatingToolbarExitDirectionM3442boximpl.getValue(), null, null, null, composerStartRestartGroup, FloatingToolbarDefaults.$stable << 12, 14);
            composerStartRestartGroup.endReplaceGroup();
            Either<VerticalArrangementDefault, VerticalArrangementCustom> verticalArrangement = props.getVerticalArrangement();
            if (verticalArrangement == null || (top = ArrangementKt.m14684toComposeArrangement(verticalArrangement)) == null) {
                top = Arrangement.INSTANCE.getTop();
            }
            Arrangement.Vertical vertical = top;
            HorizontalAlignment horizontalAlignment = props.getHorizontalAlignment();
            if (horizontalAlignment == null || (start = horizontalAlignment.toComposeAlignment()) == null) {
                start = Alignment.INSTANCE.getStart();
            }
            Alignment.Horizontal horizontal = start;
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, (AppContext.$stable << 3) | (ComposableScope.$stable << 6));
            Modifier.Companion companionNestedScroll$default = Modifier.INSTANCE;
            if (floatingToolbarScrollBehaviorM3423exitAlwaysScrollBehaviorYyGo6vs != null) {
                companionNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(companionNestedScroll$default, floatingToolbarScrollBehaviorM3423exitAlwaysScrollBehaviorYyGo6vs, null, 2, null);
            }
            Modifier modifierThen = modifierApplyModifiers.then(companionNestedScroll$default);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(vertical, horizontal, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1471779039, "C112@4596L15:ComposeViews.kt#v15e7d");
            ComposableScope composableScopeWith = ExpoComposeViewKt.with(new ComposableScope(null, null, null, null, 15, null), columnScopeInstance);
            if (floatingToolbarScrollBehaviorM3423exitAlwaysScrollBehaviorYyGo6vs != null) {
                composableScopeWith = ExpoComposeViewKt.with(composableScopeWith, floatingToolbarScrollBehaviorM3423exitAlwaysScrollBehaviorYyGo6vs);
            }
            functionalComposableScope.Children(composableScopeWith, composerStartRestartGroup, ComposableScope.$stable | (FunctionalComposableScope.$stable << 3) | ((i3 << 3) & 112));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ComposeViewsKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeViewsKt.ColumnContent$lambda$8(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void BoxContent(final FunctionalComposableScope functionalComposableScope, final LayoutProps props, Composer composer, final int i) {
        int i2;
        Alignment topStart;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(105256393);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxContent)126@5024L83,123@4889L510:ComposeViews.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        int i3 = i2;
        if ((i3 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(105256393, i3, -1, "expo.modules.ui.BoxContent (ComposeViews.kt:117)");
            }
            FloatingToolbarExitAlwaysScrollBehavior floatingToolbarExitAlwaysScrollBehavior = props.getFloatingToolbarExitAlwaysScrollBehavior();
            FloatingToolbarExitDirection floatingToolbarExitDirectionM3442boximpl = floatingToolbarExitAlwaysScrollBehavior != null ? FloatingToolbarExitDirection.m3442boximpl(floatingToolbarExitAlwaysScrollBehavior.m14650toComposeExitDirection8LIK8E()) : null;
            composerStartRestartGroup.startReplaceGroup(-1927815553);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*121@4836L44");
            FloatingToolbarScrollBehavior floatingToolbarScrollBehaviorM3423exitAlwaysScrollBehaviorYyGo6vs = floatingToolbarExitDirectionM3442boximpl == null ? null : FloatingToolbarDefaults.INSTANCE.m3423exitAlwaysScrollBehaviorYyGo6vs(floatingToolbarExitDirectionM3442boximpl.getValue(), null, null, null, composerStartRestartGroup, FloatingToolbarDefaults.$stable << 12, 14);
            composerStartRestartGroup.endReplaceGroup();
            ContentAlignment contentAlignment = props.getContentAlignment();
            if (contentAlignment == null || (topStart = contentAlignment.toComposeAlignment()) == null) {
                topStart = Alignment.INSTANCE.getTopStart();
            }
            Alignment alignment = topStart;
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, (AppContext.$stable << 3) | (ComposableScope.$stable << 6));
            Modifier.Companion companionNestedScroll$default = Modifier.INSTANCE;
            if (floatingToolbarScrollBehaviorM3423exitAlwaysScrollBehaviorYyGo6vs != null) {
                companionNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(companionNestedScroll$default, floatingToolbarScrollBehaviorM3423exitAlwaysScrollBehaviorYyGo6vs, null, 2, null);
            }
            Modifier modifierThen = modifierApplyModifiers.then(companionNestedScroll$default);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(alignment, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -595690712, "C134@5380L15:ComposeViews.kt#v15e7d");
            ComposableScope composableScopeWith = ExpoComposeViewKt.with(new ComposableScope(null, null, null, null, 15, null), boxScopeInstance);
            if (floatingToolbarScrollBehaviorM3423exitAlwaysScrollBehaviorYyGo6vs != null) {
                composableScopeWith = ExpoComposeViewKt.with(composableScopeWith, floatingToolbarScrollBehaviorM3423exitAlwaysScrollBehaviorYyGo6vs);
            }
            functionalComposableScope.Children(composableScopeWith, composerStartRestartGroup, ComposableScope.$stable | (FunctionalComposableScope.$stable << 3) | ((i3 << 3) & 112));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ComposeViewsKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeViewsKt.BoxContent$lambda$12(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
