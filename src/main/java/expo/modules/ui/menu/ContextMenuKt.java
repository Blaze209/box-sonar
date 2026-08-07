package expo.modules.ui.menu;

import android.graphics.Color;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MenuDefaults;
import androidx.compose.material3.MenuItemColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.FunctionalComposableScope;
import expo.modules.ui.ModifierRegistry;
import expo.modules.ui.SwitchViewKt;
import expo.modules.ui.UtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContextMenu.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\n\u001a;\u0010\u000b\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0002\u0010\u0013\u001aU\u0010\u0014\u001a\u00020\u0007*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00070\u00192\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00070\u00192\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00070\u0019H\u0007¢\u0006\u0002\u0010\u001f\"\u001f\u0010\u0000\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006 "}, d2 = {"LocalContextMenuExpanded", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/runtime/MutableState;", "", "getLocalContextMenuExpanded", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "SectionTitle", "", "text", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "FlatMenu", "elements", "", "Lexpo/modules/ui/menu/ContextMenuElement;", "sectionTitle", "dispatchers", "Lexpo/modules/ui/menu/ContextMenuDispatchers;", "expanded", "([Lexpo/modules/ui/menu/ContextMenuElement;Ljava/lang/String;Lexpo/modules/ui/menu/ContextMenuDispatchers;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/Composer;I)V", "ContextMenuContent", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/menu/ContextMenuProps;", "onContextMenuButtonPressed", "Lkotlin/Function1;", "Lexpo/modules/ui/menu/ContextMenuButtonPressedEvent;", "onContextMenuSwitchValueChanged", "Lexpo/modules/ui/menu/ContextMenuSwitchValueChangeEvent;", "onExpandedChanged", "Lexpo/modules/ui/menu/ExpandedChangedEvent;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/menu/ContextMenuProps;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ContextMenuKt {
    private static final ProvidableCompositionLocal<MutableState<Boolean>> LocalContextMenuExpanded = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: expo.modules.ui.menu.ContextMenuKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ContextMenuKt.LocalContextMenuExpanded$lambda$0();
        }
    }, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContextMenuContent$lambda$16(FunctionalComposableScope functionalComposableScope, ContextMenuProps contextMenuProps, Function1 function1, Function1 function2, Function1 function3, int i, Composer composer, int i2) {
        ContextMenuContent(functionalComposableScope, contextMenuProps, function1, function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlatMenu$lambda$14(ContextMenuElement[] contextMenuElementArr, String str, ContextMenuDispatchers contextMenuDispatchers, MutableState mutableState, int i, Composer composer, int i2) {
        FlatMenu(contextMenuElementArr, str, contextMenuDispatchers, mutableState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState LocalContextMenuExpanded$lambda$0() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SectionTitle$lambda$1(String str, int i, Composer composer, int i2) {
        SectionTitle(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final ProvidableCompositionLocal<MutableState<Boolean>> getLocalContextMenuExpanded() {
        return LocalContextMenuExpanded;
    }

    private static final void SectionTitle(final String str, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1595321148);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SectionTitle)45@1880L10,46@1929L11,43@1831L247:ContextMenu.kt#xj3gtm");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changed(str) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1595321148, i2, -1, "expo.modules.ui.menu.SectionTitle (ContextMenu.kt:42)");
            }
            float f = 16;
            composer2 = composerStartRestartGroup;
            TextKt.m4494TextNvy7gAk(str, PaddingKt.m1221paddingqDBjuR0(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(8), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(4)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurfaceVariant(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall(), composer2, (i2 & 14) | 48, 0, 131064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.menu.ContextMenuKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ContextMenuKt.SectionTitle$lambda$1(str, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0099  */
    public static final void FlatMenu(final ContextMenuElement[] contextMenuElementArr, final String str, final ContextMenuDispatchers contextMenuDispatchers, final MutableState<Boolean> mutableState, Composer composer, final int i) {
        int i2;
        String str2;
        int i3;
        ComposableLambda composableLambdaRememberComposableLambda;
        int i4;
        String str3;
        String str4;
        int i5;
        int i6;
        boolean z;
        boolean z2;
        ContextMenuElement[] elements = contextMenuElementArr;
        final ContextMenuDispatchers dispatchers = contextMenuDispatchers;
        final MutableState<Boolean> expanded = mutableState;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        Intrinsics.checkNotNullParameter(expanded, "expanded");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1160066473);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FlatMenu)P(1,3):ContextMenu.kt#xj3gtm");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(elements) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(dispatchers) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(expanded) ? 2048 : 1024;
        }
        if ((i2 & 1171) != 1170 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1160066473, i2, -1, "expo.modules.ui.menu.FlatMenu (ContextMenu.kt:54)");
            }
            boolean z3 = false;
            boolean z4 = true;
            if (str == null) {
                str2 = null;
            } else {
                if (str.length() == 0) {
                    str2 = null;
                } else {
                    str2 = str;
                }
            }
            composerStartRestartGroup.startReplaceGroup(1867622805);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*56@2291L16");
            if (str2 != null) {
                SectionTitle(str2, composerStartRestartGroup, 0);
                Unit unit = Unit.INSTANCE;
            }
            composerStartRestartGroup.endReplaceGroup();
            int length = elements.length;
            int i7 = 0;
            while (i7 < length) {
                ContextMenuElement contextMenuElement = elements[i7];
                final String contextMenuElementID = contextMenuElement.getContextMenuElementID();
                final ContextMenuButtonProps button = contextMenuElement.getButton();
                composerStartRestartGroup.startReplaceGroup(1867628614);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*72@3065L17,93@3682L115,61@2432L1373");
                if (button == null) {
                    i4 = i2;
                    str4 = "CC(remember):ContextMenu.kt#9igjgp";
                    z = z3;
                    i6 = length;
                    str3 = contextMenuElementID;
                    i5 = 2;
                } else {
                    MenuItemColors menuItemColors = new MenuItemColors(UtilsKt.getCompose(button.getElementColors().getContentColor()), UtilsKt.getCompose(button.getElementColors().getContentColor()), UtilsKt.getCompose(button.getElementColors().getContentColor()), UtilsKt.getCompose(button.getElementColors().getDisabledContentColor()), UtilsKt.getCompose(button.getElementColors().getDisabledContentColor()), UtilsKt.getCompose(button.getElementColors().getDisabledContentColor()), null);
                    boolean z5 = !button.getDisabled();
                    Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, UtilsKt.getCompose(button.getElementColors().getContainerColor()), null, 2, null);
                    final String leadingIcon = button.getLeadingIcon();
                    composerStartRestartGroup.startReplaceGroup(812363065);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*74@3150L211");
                    ComposableLambda composableLambdaRememberComposableLambda2 = leadingIcon == null ? null : ComposableLambdaKt.rememberComposableLambda(-1251286114, z4, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.menu.ContextMenuKt$FlatMenu$3$1$1$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i8) {
                            ComposerKt.sourceInformation(composer2, "C*76@3225L110:ContextMenu.kt#xj3gtm");
                            if ((i8 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1251286114, i8, -1, "expo.modules.ui.menu.FlatMenu.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ContextMenu.kt:75)");
                            }
                            ImageVector imageVector = UtilsKt.getImageVector(leadingIcon);
                            if (imageVector != null) {
                                IconKt.m3576Iconww6aTOc(imageVector, leadingIcon, (Modifier) null, 0L, composer2, 0, 12);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                    final String trailingIcon = button.getTrailingIcon();
                    composerStartRestartGroup.startReplaceGroup(812372377);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*84@3441L211");
                    if (trailingIcon == null) {
                        i3 = 54;
                        composableLambdaRememberComposableLambda = null;
                    } else {
                        i3 = 54;
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1737388273, z4, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.menu.ContextMenuKt$FlatMenu$3$1$2$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i8) {
                                ComposerKt.sourceInformation(composer2, "C*86@3516L110:ContextMenu.kt#xj3gtm");
                                if ((i8 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1737388273, i8, -1, "expo.modules.ui.menu.FlatMenu.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ContextMenu.kt:85)");
                                }
                                ImageVector imageVector = UtilsKt.getImageVector(trailingIcon);
                                if (imageVector != null) {
                                    IconKt.m3576Iconww6aTOc(imageVector, trailingIcon, (Modifier) null, 0L, composer2, 0, 12);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1663927887, z4, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.menu.ContextMenuKt$FlatMenu$3$1$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i8) {
                            ComposerKt.sourceInformation(composer2, "C72@3067L13:ContextMenu.kt#xj3gtm");
                            if ((i8 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1663927887, i8, -1, "expo.modules.ui.menu.FlatMenu.<anonymous>.<anonymous>.<anonymous> (ContextMenu.kt:72)");
                            }
                            TextKt.m4494TextNvy7gAk(button.getText(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 262142);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, i3);
                    composerStartRestartGroup.startReplaceGroup(-1746271574);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ContextMenu.kt#9igjgp");
                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(dispatchers) | composerStartRestartGroup.changed(contextMenuElementID) | ((i2 & 7168) == 2048);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: expo.modules.ui.menu.ContextMenuKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ContextMenuKt.FlatMenu$lambda$13$lambda$8$lambda$7$lambda$6(dispatchers, contextMenuElementID, expanded);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposableLambda composableLambda = composableLambdaRememberComposableLambda;
                    i4 = i2;
                    str3 = contextMenuElementID;
                    str4 = "CC(remember):ContextMenu.kt#9igjgp";
                    i5 = 2;
                    i6 = length;
                    z = false;
                    AndroidMenu_androidKt.DropdownMenuItem(composableLambdaRememberComposableLambda3, (Function0) objRememberedValue, modifierM589backgroundbw27NRU$default, composableLambdaRememberComposableLambda2, composableLambda, z5, menuItemColors, null, null, composerStartRestartGroup, 6, 384);
                }
                composerStartRestartGroup.endReplaceGroup();
                final ContextMenuSwitchProps contextMenuSwitchProps = contextMenuElement.getSwitch();
                composerStartRestartGroup.startReplaceGroup(1867673310);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*102@3878L568,119@4529L161,101@3845L853");
                if (contextMenuSwitchProps == null) {
                    z2 = true;
                } else {
                    Modifier modifierWrapContentSize$default = SizeKt.wrapContentSize$default(Modifier.INSTANCE, Alignment.INSTANCE.getCenter(), z, i5, null);
                    ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(-1652309914, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.menu.ContextMenuKt$FlatMenu$3$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i8) {
                            ComposerKt.sourceInformation(composer2, "C103@3890L546:ContextMenu.kt#xj3gtm");
                            if ((i8 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1652309914, i8, -1, "expo.modules.ui.menu.FlatMenu.<anonymous>.<anonymous>.<anonymous> (ContextMenu.kt:103)");
                            }
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            ContextMenuSwitchProps contextMenuSwitchProps2 = contextMenuSwitchProps;
                            ComposerKt.sourceInformationMarkerStart(composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            Modifier.Companion companion = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
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
                            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, 2020854061, "C104@3956L14,105@3983L441:ContextMenu.kt#xj3gtm");
                            TextKt.m4494TextNvy7gAk(contextMenuSwitchProps2.getLabel(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 262142);
                            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                            Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                            ComposerKt.sourceInformationMarkerStart(composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(end, Alignment.INSTANCE.getTop(), composer2, 6);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default);
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor2);
                            } else {
                                composer2.useNode();
                            }
                            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composer2);
                            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, -106795621, "C106@4080L330:ContextMenu.kt#xj3gtm");
                            SwitchViewKt.ThemedHybridSwitch(contextMenuSwitchProps2.getVariant(), contextMenuSwitchProps2.getValue(), null, contextMenuSwitchProps2.getElementColors(), SizeKt.wrapContentSize$default(PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(5), 0.0f, 2, null), Alignment.INSTANCE.getCenterEnd(), false, 2, null), null, composer2, 24960, 32);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
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
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.startReplaceGroup(-1224400529);
                    ComposerKt.sourceInformation(composerStartRestartGroup, str4);
                    final String str5 = str3;
                    boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(dispatchers) | composerStartRestartGroup.changedInstance(contextMenuSwitchProps) | composerStartRestartGroup.changed(str5) | ((i4 & 7168) == 2048 ? true : z);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: expo.modules.ui.menu.ContextMenuKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ContextMenuKt.FlatMenu$lambda$13$lambda$11$lambda$10$lambda$9(dispatchers, contextMenuSwitchProps, str5, expanded);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    z2 = true;
                    AndroidMenu_androidKt.DropdownMenuItem(composableLambdaRememberComposableLambda4, (Function0) objRememberedValue2, modifierWrapContentSize$default, null, null, false, null, null, null, composerStartRestartGroup, 390, 504);
                }
                composerStartRestartGroup.endReplaceGroup();
                Submenu submenu = contextMenuElement.getSubmenu();
                composerStartRestartGroup.startReplaceGroup(1867701151);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*129@4739L19,130@4765L60");
                if (submenu != null) {
                    DividerKt.m3284HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composerStartRestartGroup, 0, 7);
                    FlatMenu(submenu.getElements(), submenu.getButton().getText(), contextMenuDispatchers, expanded, composerStartRestartGroup, i4 & 8064);
                }
                composerStartRestartGroup.endReplaceGroup();
                i7++;
                elements = contextMenuElementArr;
                dispatchers = contextMenuDispatchers;
                expanded = mutableState;
                z3 = z;
                length = i6;
                i2 = i4;
                z4 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.menu.ContextMenuKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ContextMenuKt.FlatMenu$lambda$14(contextMenuElementArr, str, contextMenuDispatchers, mutableState, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlatMenu$lambda$13$lambda$8$lambda$7$lambda$6(ContextMenuDispatchers contextMenuDispatchers, String str, MutableState mutableState) {
        contextMenuDispatchers.getButtonPressed().invoke(new ContextMenuButtonPressedEvent(str));
        mutableState.setValue(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlatMenu$lambda$13$lambda$11$lambda$10$lambda$9(ContextMenuDispatchers contextMenuDispatchers, ContextMenuSwitchProps contextMenuSwitchProps, String str, MutableState mutableState) {
        contextMenuDispatchers.getSwitchCheckedChanged().invoke(new ContextMenuSwitchValueChangeEvent(!contextMenuSwitchProps.getValue(), str));
        mutableState.setValue(false);
        return Unit.INSTANCE;
    }

    public static final void ContextMenuContent(final FunctionalComposableScope functionalComposableScope, final ContextMenuProps props, final Function1<? super ContextMenuButtonPressedEvent, Unit> onContextMenuButtonPressed, final Function1<? super ContextMenuSwitchValueChangeEvent, Unit> onContextMenuSwitchValueChanged, final Function1<? super ExpandedChangedEvent, Unit> onExpandedChanged, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onContextMenuButtonPressed, "onContextMenuButtonPressed");
        Intrinsics.checkNotNullParameter(onContextMenuSwitchValueChanged, "onContextMenuSwitchValueChanged");
        Intrinsics.checkNotNullParameter(onExpandedChanged, "onExpandedChanged");
        Composer composerStartRestartGroup = composer.startRestartGroup(-674350542);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ContextMenuContent)P(3)147@5342L34,153@5627L804,153@5558L873:ContextMenu.kt#xj3gtm");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onContextMenuButtonPressed) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onContextMenuSwitchValueChanged) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onExpandedChanged) ? 16384 : 8192;
        }
        if ((i2 & 9363) != 9362 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-674350542, i2, -1, "expo.modules.ui.menu.ContextMenuContent (ContextMenu.kt:146)");
            }
            composerStartRestartGroup.startReplaceGroup(1849434622);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):ContextMenu.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableState<Boolean> mutableState = (MutableState) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            CompositionLocalKt.CompositionLocalProvider(LocalContextMenuExpanded.provides(mutableState), ComposableLambdaKt.rememberComposableLambda(-1835208974, true, new AnonymousClass1(props, functionalComposableScope, props.getColor(), mutableState, onExpandedChanged, props.getElements(), onContextMenuButtonPressed, onContextMenuSwitchValueChanged), composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.menu.ContextMenuKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ContextMenuKt.ContextMenuContent$lambda$16(functionalComposableScope, props, onContextMenuButtonPressed, onContextMenuSwitchValueChanged, onExpandedChanged, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: expo.modules.ui.menu.ContextMenuKt$ContextMenuContent$1, reason: invalid class name */
    /* JADX INFO: compiled from: ContextMenu.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Color $color;
        final /* synthetic */ ContextMenuElement[] $elements;
        final /* synthetic */ MutableState<Boolean> $expanded;
        final /* synthetic */ Function1<ContextMenuButtonPressedEvent, Unit> $onContextMenuButtonPressed;
        final /* synthetic */ Function1<ContextMenuSwitchValueChangeEvent, Unit> $onContextMenuSwitchValueChanged;
        final /* synthetic */ Function1<ExpandedChangedEvent, Unit> $onExpandedChanged;
        final /* synthetic */ ContextMenuProps $props;
        final /* synthetic */ FunctionalComposableScope $this_ContextMenuContent;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(ContextMenuProps contextMenuProps, FunctionalComposableScope functionalComposableScope, Color color, MutableState<Boolean> mutableState, Function1<? super ExpandedChangedEvent, Unit> function1, ContextMenuElement[] contextMenuElementArr, Function1<? super ContextMenuButtonPressedEvent, Unit> function2, Function1<? super ContextMenuSwitchValueChangeEvent, Unit> function3) {
            this.$props = contextMenuProps;
            this.$this_ContextMenuContent = functionalComposableScope;
            this.$color = color;
            this.$expanded = mutableState;
            this.$onExpandedChanged = function1;
            this.$elements = contextMenuElementArr;
            this.$onContextMenuButtonPressed = function2;
            this.$onContextMenuSwitchValueChanged = function3;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$2$lambda$1$lambda$0(MutableState mutableState, Function1 function1) {
            mutableState.setValue(false);
            function1.invoke(new ExpandedChangedEvent(false));
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C154@5665L83,154@5633L794:ContextMenu.kt#xj3gtm");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1835208974, i, -1, "expo.modules.ui.menu.ContextMenuContent.<anonymous> (ContextMenu.kt:154)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(this.$props.getModifiers(), this.$this_ContextMenuContent.getAppContext(), this.$this_ContextMenuContent.getComposableScope(), this.$this_ContextMenuContent.getGlobalEventDispatcher(), composer, (ComposableScope.$stable << 6) | (AppContext.$stable << 3));
            FunctionalComposableScope functionalComposableScope = this.$this_ContextMenuContent;
            Color color = this.$color;
            final MutableState<Boolean> mutableState = this.$expanded;
            final Function1<ExpandedChangedEvent, Unit> function1 = this.$onExpandedChanged;
            final ContextMenuElement[] contextMenuElementArr = this.$elements;
            final Function1<ContextMenuButtonPressedEvent, Unit> function2 = this.$onContextMenuButtonPressed;
            final Function1<ContextMenuSwitchValueChangeEvent, Unit> function3 = this.$onContextMenuSwitchValueChanged;
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierApplyModifiers);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1437314785, "C156@5835L27,161@6024L101,165@6134L287,158@5870L551:ContextMenu.kt#xj3gtm");
            functionalComposableScope.Children(new ComposableScope(null, null, null, null, 15, null), composer, ComposableScope.$stable | (FunctionalComposableScope.$stable << 3));
            androidx.compose.ui.graphics.Color composeOrNull = color != null ? UtilsKt.getComposeOrNull(color) : null;
            composer.startReplaceGroup(1154745483);
            ComposerKt.sourceInformation(composer, "159@5946L14");
            long containerColor = composeOrNull == null ? MenuDefaults.INSTANCE.getContainerColor(composer, MenuDefaults.$stable) : composeOrNull.m6824unboximpl();
            composer.endReplaceGroup();
            boolean zBooleanValue = mutableState.getValue().booleanValue();
            composer.startReplaceGroup(-1633490746);
            ComposerKt.sourceInformation(composer, "CC(remember):ContextMenu.kt#9igjgp");
            boolean zChanged = composer.changed(function1);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.menu.ContextMenuKt$ContextMenuContent$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ContextMenuKt.AnonymousClass1.invoke$lambda$2$lambda$1$lambda$0(mutableState, function1);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceGroup();
            AndroidMenu_androidKt.m2743DropdownMenuIlH_yew(zBooleanValue, (Function0) objRememberedValue, null, 0L, null, null, null, containerColor, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-609986147, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: expo.modules.ui.menu.ContextMenuKt$ContextMenuContent$1$1$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                    invoke(columnScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope DropdownMenu, Composer composer2, int i2) {
                    Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
                    ComposerKt.sourceInformation(composer2, "C166@6144L269:ContextMenu.kt#xj3gtm");
                    if ((i2 & 17) == 16 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-609986147, i2, -1, "expo.modules.ui.menu.ContextMenuContent.<anonymous>.<anonymous>.<anonymous> (ContextMenu.kt:166)");
                    }
                    ContextMenuKt.FlatMenu(contextMenuElementArr, null, new ContextMenuDispatchers(new ContextMenuKt$sam$expo_modules_kotlin_viewevent_ViewEventCallback$0(function2), new ContextMenuKt$sam$expo_modules_kotlin_viewevent_ViewEventCallback$0(function3)), mutableState, composer2, 3120);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer, 54), composer, 0, 48, 1916);
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
    }
}
