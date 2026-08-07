package expo.modules.ui;

import androidx.compose.material3.ListItemDefaults;
import androidx.compose.material3.ListItemKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.ExpoComposeView;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListItemView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"ListItemContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/ListItemProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/ListItemProps;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ListItemViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListItemContent$lambda$5(FunctionalComposableScope functionalComposableScope, ListItemProps listItemProps, int i, Composer composer, int i2) {
        ListItemContent(functionalComposableScope, listItemProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ListItemContent(final FunctionalComposableScope functionalComposableScope, final ListItemProps props, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1333864526);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ListItemContent)33@1148L83,35@1272L8,36@1313L678,56@2227L31,55@2195L750:ListItemView.kt#v15e7d");
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
                ComposerKt.traceEventStart(-1333864526, i2, -1, "expo.modules.ui.ListItemContent (ListItemView.kt:32)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, (AppContext.$stable << 3) | (ComposableScope.$stable << 6));
            androidx.compose.material3.ListItemColors listItemColorsColors = ListItemDefaults.INSTANCE.colors(composerStartRestartGroup, ListItemDefaults.$stable);
            ListItemDefaults listItemDefaults = ListItemDefaults.INSTANCE;
            ListItemColors colors = props.getColors();
            Color composeOrNull = UtilsKt.getComposeOrNull(colors != null ? colors.getContainerColor() : null);
            long jM6824unboximpl = composeOrNull != null ? composeOrNull.m6824unboximpl() : listItemColorsColors.getContainerColor();
            ListItemColors colors2 = props.getColors();
            Color composeOrNull2 = UtilsKt.getComposeOrNull(colors2 != null ? colors2.getHeadlineColor() : null);
            long jM6824unboximpl2 = composeOrNull2 != null ? composeOrNull2.m6824unboximpl() : listItemColorsColors.getContentColor();
            ListItemColors colors3 = props.getColors();
            Color composeOrNull3 = UtilsKt.getComposeOrNull(colors3 != null ? colors3.getLeadingIconColor() : null);
            long jM6824unboximpl3 = composeOrNull3 != null ? composeOrNull3.m6824unboximpl() : listItemColorsColors.getLeadingContentColor();
            ListItemColors colors4 = props.getColors();
            Color composeOrNull4 = UtilsKt.getComposeOrNull(colors4 != null ? colors4.getTrailingIconColor() : null);
            long jM6824unboximpl4 = composeOrNull4 != null ? composeOrNull4.m6824unboximpl() : listItemColorsColors.getTrailingContentColor();
            ListItemColors colors5 = props.getColors();
            Color composeOrNull5 = UtilsKt.getComposeOrNull(colors5 != null ? colors5.getSupportingColor() : null);
            long jM6824unboximpl5 = composeOrNull5 != null ? composeOrNull5.m6824unboximpl() : listItemColorsColors.getSupportingContentColor();
            ListItemColors colors6 = props.getColors();
            Color composeOrNull6 = UtilsKt.getComposeOrNull(colors6 != null ? colors6.getOverlineColor() : null);
            androidx.compose.material3.ListItemColors listItemColorsM3669colorsLIdIuno = listItemDefaults.m3669colorsLIdIuno(jM6824unboximpl, jM6824unboximpl2, jM6824unboximpl3, jM6824unboximpl4, composeOrNull6 != null ? composeOrNull6.m6824unboximpl() : listItemColorsColors.m3651getOverlineContentColor0d7_KjU(), jM6824unboximpl5, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, ListItemDefaults.$stable << 12, 16777152);
            composerStartRestartGroup = composerStartRestartGroup;
            final SlotView slotViewFindChildSlotView = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "leading");
            final SlotView slotViewFindChildSlotView2 = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "trailing");
            final SlotView slotViewFindChildSlotView3 = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "supportingContent");
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1634643600, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.ListItemViewKt.ListItemContent.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C56@2229L27:ListItemView.kt#v15e7d");
                    if ((i3 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1634643600, i3, -1, "expo.modules.ui.ListItemContent.<anonymous> (ListItemView.kt:56)");
                    }
                    TextKt.m4494TextNvy7gAk(props.getHeadline(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 262142);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54);
            final String overlineText = props.getOverlineText();
            composerStartRestartGroup.startReplaceGroup(-1943513811);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*58@2333L19");
            ComposableLambda composableLambdaRememberComposableLambda2 = overlineText == null ? null : ComposableLambdaKt.rememberComposableLambda(2035652167, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.ListItemViewKt$ListItemContent$2$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C58@2335L15:ListItemView.kt#v15e7d");
                    if ((i3 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2035652167, i3, -1, "expo.modules.ui.ListItemContent.<anonymous>.<anonymous> (ListItemView.kt:58)");
                    }
                    TextKt.m4494TextNvy7gAk(overlineText, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 262142);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54);
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-1943511152);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*60@2419L108");
            ComposableLambda composableLambdaRememberComposableLambda3 = slotViewFindChildSlotView3 == null ? null : ComposableLambdaKt.rememberComposableLambda(-285758525, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.ListItemViewKt$ListItemContent$3$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C:ListItemView.kt#v15e7d");
                    if ((i3 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-285758525, i3, -1, "expo.modules.ui.ListItemContent.<anonymous>.<anonymous> (ListItemView.kt:61)");
                    }
                    ComposableScope composableScope = new ComposableScope(null, null, null, null, 15, null);
                    SlotView slotView = slotViewFindChildSlotView3;
                    composer2.startReplaceGroup(263965935);
                    ComposerKt.sourceInformation(composer2, "*63@2488L9");
                    slotView.Content(composableScope, composer2, ComposableScope.$stable | ((ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3));
                    composer2.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54);
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-1943511936);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*67@2565L19");
            if (composableLambdaRememberComposableLambda3 == null) {
                final String supportingText = props.getSupportingText();
                composableLambdaRememberComposableLambda3 = supportingText == null ? null : ComposableLambdaKt.rememberComposableLambda(-138335552, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.ListItemViewKt$ListItemContent$4$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i3) {
                        ComposerKt.sourceInformation(composer2, "C67@2567L15:ListItemView.kt#v15e7d");
                        if ((i3 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-138335552, i3, -1, "expo.modules.ui.ListItemContent.<anonymous>.<anonymous> (ListItemView.kt:67)");
                        }
                        TextKt.m4494TextNvy7gAk(supportingText, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 262142);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54);
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-1943504144);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*69@2638L108");
            ComposableLambda composableLambdaRememberComposableLambda4 = slotViewFindChildSlotView == null ? null : ComposableLambdaKt.rememberComposableLambda(1166612823, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.ListItemViewKt$ListItemContent$5$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C:ListItemView.kt#v15e7d");
                    if ((i3 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1166612823, i3, -1, "expo.modules.ui.ListItemContent.<anonymous>.<anonymous> (ListItemView.kt:70)");
                    }
                    ComposableScope composableScope = new ComposableScope(null, null, null, null, 15, null);
                    SlotView slotView = slotViewFindChildSlotView;
                    composer2.startReplaceGroup(128460163);
                    ComposerKt.sourceInformation(composer2, "*72@2707L9");
                    slotView.Content(composableScope, composer2, ComposableScope.$stable | ((ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3));
                    composer2.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54);
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-1943498768);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*78@2806L108");
            ComposableLambda composableLambdaRememberComposableLambda5 = slotViewFindChildSlotView2 != null ? ComposableLambdaKt.rememberComposableLambda(-736847272, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.ListItemViewKt$ListItemContent$6$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C:ListItemView.kt#v15e7d");
                    if ((i3 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-736847272, i3, -1, "expo.modules.ui.ListItemContent.<anonymous>.<anonymous> (ListItemView.kt:79)");
                    }
                    ComposableScope composableScope = new ComposableScope(null, null, null, null, 15, null);
                    SlotView slotView = slotViewFindChildSlotView2;
                    composer2.startReplaceGroup(559376964);
                    ComposerKt.sourceInformation(composer2, "*81@2875L9");
                    slotView.Content(composableScope, composer2, ComposableScope.$stable | ((ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3));
                    composer2.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54) : null;
            composerStartRestartGroup.endReplaceGroup();
            ListItemKt.m3695ListItemHXNGIdc(composableLambdaRememberComposableLambda, modifierApplyModifiers, composableLambdaRememberComposableLambda2, composableLambdaRememberComposableLambda3, composableLambdaRememberComposableLambda4, composableLambdaRememberComposableLambda5, listItemColorsM3669colorsLIdIuno, 0.0f, 0.0f, composerStartRestartGroup, 6, 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ListItemViewKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ListItemViewKt.ListItemContent$lambda$5(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
