package com.box.android.navigationmodernization.homescreen.component;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.NavigationBarItemColors;
import androidx.compose.material3.NavigationBarItemDefaults;
import androidx.compose.material3.NavigationBarKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.R;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.divider.BoxHorizontalDividerKt;
import com.box.android.navigationmodernization.homescreen.navigation.HomeNavigationBarDestination;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: HomeScreenNavigationBar.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a9\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u0014\u0010\t\u001a\u00020\n*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0015\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\u0003¢\u0006\u0002\u0010\u0013\u001a\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0017\u001a\r\u0010\u0018\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0019\"\u0018\u0010\r\u001a\u00020\n*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"HomeScreenNavigationBar", "", "currentGraph", "Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination;", "graphs", "", "onNavigationBarItemClick", "Lkotlin/Function1;", "(Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "drawableRes", "", "isSelected", "", "titleRes", "getTitleRes", "(Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination;)I", "BoxAiSelectedLabel", "label", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "navigationBarColorsForGraph", "Landroidx/compose/material3/NavigationBarItemColors;", "graph", "(Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/NavigationBarItemColors;", "HomeScreenNavigationBarPreview", "(Landroidx/compose/runtime/Composer;I)V", "box_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class HomeScreenNavigationBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiSelectedLabel$lambda$0(String str, int i, Composer composer, int i2) {
        BoxAiSelectedLabel(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreenNavigationBar$lambda$1(HomeNavigationBarDestination homeNavigationBarDestination, List list, Function1 function1, int i, Composer composer, int i2) {
        HomeScreenNavigationBar(homeNavigationBarDestination, list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreenNavigationBarPreview$lambda$0(int i, Composer composer, int i2) {
        HomeScreenNavigationBarPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void HomeScreenNavigationBar(final HomeNavigationBarDestination homeNavigationBarDestination, final List<? extends HomeNavigationBarDestination> graphs, final Function1<? super HomeNavigationBarDestination, Unit> onNavigationBarItemClick, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(graphs, "graphs");
        Intrinsics.checkNotNullParameter(onNavigationBarItemClick, "onNavigationBarItemClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1681526421);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HomeScreenNavigationBar)N(currentGraph,graphs,onNavigationBarItemClick)28@1198L1909:HomeScreenNavigationBar.kt#tptr0a");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(homeNavigationBarDestination) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(graphs) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onNavigationBarItemClick) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1681526421, i2, -1, "com.box.android.navigationmodernization.homescreen.component.HomeScreenNavigationBar (HomeScreenNavigationBar.kt:27)");
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1143678406, "C29@1215L22,30@1286L6,30@1313L1788,30@1246L1855:HomeScreenNavigationBar.kt#tptr0a");
            BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, 0.0f, 0L, composerStartRestartGroup, 0, 7);
            NavigationBarKt.m3841NavigationBarHsRjFd4(null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11581getTopLayerBackground0d7_KjU(), 0L, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(925779378, true, new Function3() { // from class: com.box.android.navigationmodernization.homescreen.component.HomeScreenNavigationBarKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return HomeScreenNavigationBarKt.HomeScreenNavigationBar$lambda$0$0(graphs, homeNavigationBarDestination, onNavigationBarItemClick, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 29);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.navigationmodernization.homescreen.component.HomeScreenNavigationBarKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HomeScreenNavigationBarKt.HomeScreenNavigationBar$lambda$1(homeNavigationBarDestination, graphs, onNavigationBarItemClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreenNavigationBar$lambda$0$0(List list, HomeNavigationBarDestination homeNavigationBarDestination, final Function1 function1, RowScope rowScope, Composer composer, int i) {
        int i2;
        RowScope NavigationBar = rowScope;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(NavigationBar, "$this$NavigationBar");
        ComposerKt.sourceInformation(composer2, "C*33@1435L46,34@1510L30,68@3025L34,38@1650L86,42@1862L651,57@2543L407,36@1558L1519:HomeScreenNavigationBar.kt#tptr0a");
        if ((i & 6) == 0) {
            i2 = i | (composer2.changed(NavigationBar) ? 4 : 2);
        } else {
            i2 = i;
        }
        int i3 = 0;
        if (!composer2.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(925779378, i2, -1, "com.box.android.navigationmodernization.homescreen.component.HomeScreenNavigationBar.<anonymous>.<anonymous> (HomeScreenNavigationBar.kt:31)");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final HomeNavigationBarDestination homeNavigationBarDestination2 = (HomeNavigationBarDestination) it.next();
                final boolean zAreEqual = Intrinsics.areEqual(homeNavigationBarDestination, homeNavigationBarDestination2);
                final Painter painterPainterResource = PainterResources_androidKt.painterResource(drawableRes(homeNavigationBarDestination2, zAreEqual), composer2, i3);
                final String strStringResource = StringResources_androidKt.stringResource(getTitleRes(homeNavigationBarDestination2), composer2, i3);
                Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, "NavigationBarItem:" + Reflection.getOrCreateKotlinClass(homeNavigationBarDestination2.getClass()).getSimpleName());
                NavigationBarItemColors navigationBarItemColorsNavigationBarColorsForGraph = navigationBarColorsForGraph(homeNavigationBarDestination2, composer2, i3);
                ComposerKt.sourceInformationMarkerStart(composer2, -93628747, "CC(remember):HomeScreenNavigationBar.kt#9igjgp");
                boolean zChanged = composer2.changed(function1) | composer2.changed(homeNavigationBarDestination2);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.navigationmodernization.homescreen.component.HomeScreenNavigationBarKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return HomeScreenNavigationBarKt.HomeScreenNavigationBar$lambda$0$0$0$0$0(function1, homeNavigationBarDestination2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                NavigationBarKt.NavigationBarItem(NavigationBar, zAreEqual, (Function0) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(-1547425702, true, new Function2() { // from class: com.box.android.navigationmodernization.homescreen.component.HomeScreenNavigationBarKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return HomeScreenNavigationBarKt.HomeScreenNavigationBar$lambda$0$0$0$1(homeNavigationBarDestination2, painterPainterResource, zAreEqual, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), modifierTestTag, false, ComposableLambdaKt.rememberComposableLambda(1310928925, true, new Function2() { // from class: com.box.android.navigationmodernization.homescreen.component.HomeScreenNavigationBarKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return HomeScreenNavigationBarKt.HomeScreenNavigationBar$lambda$0$0$0$2(homeNavigationBarDestination2, zAreEqual, strStringResource, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), true, navigationBarItemColorsNavigationBarColorsForGraph, null, composer2, (i2 & 14) | 14158848, 272);
                NavigationBar = rowScope;
                composer2 = composer;
                i3 = i3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreenNavigationBar$lambda$0$0$0$0$0(Function1 function1, HomeNavigationBarDestination homeNavigationBarDestination) {
        function1.invoke(homeNavigationBarDestination);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreenNavigationBar$lambda$0$0$0$1(HomeNavigationBarDestination homeNavigationBarDestination, Painter painter, boolean z, Composer composer, int i) {
        long jM11538getNavigationBarUnselectedContent0d7_KjU;
        ComposerKt.sourceInformation(composer, "C:HomeScreenNavigationBar.kt#tptr0a");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1547425702, i, -1, "com.box.android.navigationmodernization.homescreen.component.HomeScreenNavigationBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HomeScreenNavigationBar.kt:43)");
            }
            if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.BoxAi.INSTANCE)) {
                composer.startReplaceGroup(-1474983411);
                ComposerKt.sourceInformation(composer, "45@2003L283");
                if (z) {
                    composer.startReplaceGroup(-1017404731);
                    composer.endReplaceGroup();
                    jM11538getNavigationBarUnselectedContent0d7_KjU = Color.INSTANCE.m6850getUnspecified0d7_KjU();
                } else {
                    composer.startReplaceGroup(-1017403656);
                    ComposerKt.sourceInformation(composer, "48@2215L6");
                    jM11538getNavigationBarUnselectedContent0d7_KjU = BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11538getNavigationBarUnselectedContent0d7_KjU();
                    composer.endReplaceGroup();
                }
                IconKt.m3575Iconww6aTOc(painter, (String) null, (Modifier) null, jM11538getNavigationBarUnselectedContent0d7_KjU, composer, Painter.$stable | 48, 4);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1474608807);
                ComposerKt.sourceInformation(composer, "53@2388L47");
                IconKt.m3575Iconww6aTOc(painter, (String) null, (Modifier) null, 0L, composer, Painter.$stable | 48, 12);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreenNavigationBar$lambda$0$0$0$2(HomeNavigationBarDestination homeNavigationBarDestination, boolean z, String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:HomeScreenNavigationBar.kt#tptr0a");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1310928925, i, -1, "com.box.android.navigationmodernization.homescreen.component.HomeScreenNavigationBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HomeScreenNavigationBar.kt:58)");
            }
            if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.BoxAi.INSTANCE) && z) {
                composer.startReplaceGroup(-253927052);
                ComposerKt.sourceInformation(composer, "59@2662L25");
                BoxAiSelectedLabel(str, composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-253836780);
                ComposerKt.sourceInformation(composer, "61@2749L153");
                TextKt.m4494TextNvy7gAk(str, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium12(), composer, 0, 0, 131070);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final int drawableRes(HomeNavigationBarDestination homeNavigationBarDestination, boolean z) {
        if (z) {
            if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.Browse.INSTANCE)) {
                return R.drawable.ic_browse_selected_bottom_nav;
            }
            if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.Notes.INSTANCE)) {
                return R.drawable.ic_boxnotes_selected_bottom_nav;
            }
            if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.Hubs.INSTANCE)) {
                return R.drawable.ic_hubs;
            }
            if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.Collections.INSTANCE)) {
                return R.drawable.ic_collections_selected_bottom_nav;
            }
            if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.BoxAi.INSTANCE)) {
                return R.drawable.ic_box_ai_selected_bottom_nav;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.Browse.INSTANCE)) {
            return R.drawable.ic_browse_unselected_bottom_nav;
        }
        if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.Notes.INSTANCE)) {
            return R.drawable.ic_boxnotes_unselected_bottom_nav;
        }
        if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.Hubs.INSTANCE)) {
            return R.drawable.ic_hubs;
        }
        if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.Collections.INSTANCE)) {
            return R.drawable.ic_collections_unselected_bottom_nav;
        }
        if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.BoxAi.INSTANCE)) {
            return R.drawable.ic_box_ai_unselected_bottom_nav;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final int getTitleRes(HomeNavigationBarDestination homeNavigationBarDestination) {
        if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.Browse.INSTANCE)) {
            return R.string.files;
        }
        if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.Notes.INSTANCE)) {
            return R.string.notes;
        }
        if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.Hubs.INSTANCE)) {
            return R.string.hubs;
        }
        if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.Collections.INSTANCE)) {
            return R.string.Collections;
        }
        if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.BoxAi.INSTANCE)) {
            return R.string.box_ai;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final void BoxAiSelectedLabel(final String str, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(736448499);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiSelectedLabel)N(label)109@4782L6,110@4842L6,104@4594L323:HomeScreenNavigationBar.kt#tptr0a");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changed(str) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(736448499, i2, -1, "com.box.android.navigationmodernization.homescreen.component.BoxAiSelectedLabel (HomeScreenNavigationBar.kt:103)");
            }
            composer2 = composerStartRestartGroup;
            TextKt.m4494TextNvy7gAk(str, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m9102copyNs73l9s$default(BoxTheme.INSTANCE.getTypography().getBoxMedium12(), Brush.Companion.m6769verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m6804boximpl(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11502getBoxAiGradientTextStart0d7_KjU()), Color.m6804boximpl(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11501getBoxAiGradientTextEnd0d7_KjU())}), 0.0f, 0.0f, 0, 14, (Object) null), 0.0f, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 33554430, null), composer2, i2 & 14, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.navigationmodernization.homescreen.component.HomeScreenNavigationBarKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HomeScreenNavigationBarKt.BoxAiSelectedLabel$lambda$0(str, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final NavigationBarItemColors navigationBarColorsForGraph(HomeNavigationBarDestination homeNavigationBarDestination, Composer composer, int i) {
        long jM11534getMainActiveControlBackground0d7_KjU;
        ComposerKt.sourceInformationMarkerStart(composer, -1275387406, "C(navigationBarColorsForGraph)N(graph)118@5038L8,119@5086L6,120@5145L6,126@5403L6,127@5477L6:HomeScreenNavigationBar.kt#tptr0a");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1275387406, i, -1, "com.box.android.navigationmodernization.homescreen.component.navigationBarColorsForGraph (HomeScreenNavigationBar.kt:118)");
        }
        NavigationBarItemColors navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composer, NavigationBarItemDefaults.$stable);
        long jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU();
        long jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU();
        if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.BoxAi.INSTANCE)) {
            composer.startReplaceGroup(-1785204580);
            ComposerKt.sourceInformation(composer, "122@5268L6");
            jM11534getMainActiveControlBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11503getBoxAiLabelBackground0d7_KjU();
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-1785146827);
            ComposerKt.sourceInformation(composer, "124@5326L6");
            jM11534getMainActiveControlBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11534getMainActiveControlBackground0d7_KjU();
            composer.endReplaceGroup();
        }
        NavigationBarItemColors navigationBarItemColorsM3824copy4JmcsL4 = navigationBarItemColorsColors.m3824copy4JmcsL4((96 & 1) != 0 ? navigationBarItemColorsColors.selectedIconColor : jM11533getMainActiveControl0d7_KjU, (96 & 2) != 0 ? navigationBarItemColorsColors.selectedTextColor : jM11533getMainActiveControl0d7_KjU2, (96 & 4) != 0 ? navigationBarItemColorsColors.selectedIndicatorColor : jM11534getMainActiveControlBackground0d7_KjU, (96 & 8) != 0 ? navigationBarItemColorsColors.unselectedIconColor : BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11538getNavigationBarUnselectedContent0d7_KjU(), (96 & 16) != 0 ? navigationBarItemColorsColors.unselectedTextColor : BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11538getNavigationBarUnselectedContent0d7_KjU(), (96 & 32) != 0 ? navigationBarItemColorsColors.disabledIconColor : 0L, (96 & 64) != 0 ? navigationBarItemColorsColors.disabledTextColor : 0L);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return navigationBarItemColorsM3824copy4JmcsL4;
    }

    private static final void HomeScreenNavigationBarPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-740224748);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HomeScreenNavigationBarPreview)136@5653L475:HomeScreenNavigationBar.kt#tptr0a");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-740224748, i, -1, "com.box.android.navigationmodernization.homescreen.component.HomeScreenNavigationBarPreview (HomeScreenNavigationBar.kt:135)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$HomeScreenNavigationBarKt.INSTANCE.m12744getLambda$657446497$box_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.navigationmodernization.homescreen.component.HomeScreenNavigationBarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HomeScreenNavigationBarKt.HomeScreenNavigationBarPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
