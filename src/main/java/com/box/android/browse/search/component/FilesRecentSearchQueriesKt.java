package com.box.android.browse.search.component;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.rounded.AccessTimeKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.button.BoxIconButtonKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.button.model.ButtonItemIconResource;
import com.box.android.browse.R;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilesRecentSearchQueries.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aM\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001a=\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006H\u0003¢\u0006\u0002\u0010\r\u001a\r\u0010\u000e\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"FilesRecentSearchQueries", "", "recentSearchQueries", "", "", "onRecentSearchQueryClick", "Lkotlin/Function1;", "onDeleteRecentSearchQueryClick", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "RecentSearchQueryItem", "query", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "FilesRecentSearchQueriesPreview", "(Landroidx/compose/runtime/Composer;I)V", "browse_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FilesRecentSearchQueriesKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesRecentSearchQueries$lambda$1(List list, Function1 function1, Function1 function2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        FilesRecentSearchQueries(list, function1, function2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesRecentSearchQueriesPreview$lambda$0(int i, Composer composer, int i2) {
        FilesRecentSearchQueriesPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecentSearchQueryItem$lambda$2(String str, Function1 function1, Function1 function2, int i, Composer composer, int i2) {
        RecentSearchQueryItem(str, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x007b  */
    /* JADX WARN: Code duplicated, block: B:38:0x007d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0086 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0088  */
    /* JADX WARN: Code duplicated, block: B:43:0x008d  */
    /* JADX WARN: Code duplicated, block: B:46:0x0094  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:53:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:63:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:66:0x0106  */
    /* JADX WARN: Code duplicated, block: B:68:? A[RETURN, SYNTHETIC] */
    public static final void FilesRecentSearchQueries(final List<String> recentSearchQueries, final Function1<? super String, Unit> onRecentSearchQueryClick, final Function1<? super String, Unit> onDeleteRecentSearchQueryClick, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        boolean z2;
        boolean z3;
        Object objRememberedValue;
        Intrinsics.checkNotNullParameter(recentSearchQueries, "recentSearchQueries");
        Intrinsics.checkNotNullParameter(onRecentSearchQueryClick, "onRecentSearchQueryClick");
        Intrinsics.checkNotNullParameter(onDeleteRecentSearchQueryClick, "onDeleteRecentSearchQueryClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-823736707);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FilesRecentSearchQueries)N(recentSearchQueries,onRecentSearchQueryClick,onDeleteRecentSearchQueryClick,modifier)38@1676L386,38@1630L432:FilesRecentSearchQueries.kt#8xusuk");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(recentSearchQueries) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onRecentSearchQueryClick) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onDeleteRecentSearchQueryClick) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-823736707, i3, -1, "com.box.android.browse.search.component.FilesRecentSearchQueries (FilesRecentSearchQueries.kt:37)");
                }
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1336984289, "CC(remember):FilesRecentSearchQueries.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(recentSearchQueries);
                if ((i3 & 112) == 32) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = z2 | zChangedInstance | ((i3 & 896) == 256);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.browse.search.component.FilesRecentSearchQueriesKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return FilesRecentSearchQueriesKt.FilesRecentSearchQueries$lambda$0$0(recentSearchQueries, onRecentSearchQueryClick, onDeleteRecentSearchQueryClick, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifier4 = companion;
                composer2 = composerStartRestartGroup;
                LazyDslKt.LazyColumn(modifierFillMaxSize$default, null, null, false, null, null, null, false, null, (Function1) objRememberedValue, composer2, 0, 510);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.search.component.FilesRecentSearchQueriesKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FilesRecentSearchQueriesKt.FilesRecentSearchQueries$lambda$1(recentSearchQueries, onRecentSearchQueryClick, onDeleteRecentSearchQueryClick, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-823736707, i3, -1, "com.box.android.browse.search.component.FilesRecentSearchQueries (FilesRecentSearchQueries.kt:37)");
            }
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1336984289, "CC(remember):FilesRecentSearchQueries.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(recentSearchQueries);
            if ((i3 & 112) == 32) {
                z2 = true;
            } else {
                z2 = false;
            }
            z3 = z2 | zChangedInstance2 | ((i3 & 896) == 256);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z3) {
                objRememberedValue = new Function1() { // from class: com.box.android.browse.search.component.FilesRecentSearchQueriesKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FilesRecentSearchQueriesKt.FilesRecentSearchQueries$lambda$0$0(recentSearchQueries, onRecentSearchQueryClick, onDeleteRecentSearchQueryClick, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.box.android.browse.search.component.FilesRecentSearchQueriesKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FilesRecentSearchQueriesKt.FilesRecentSearchQueries$lambda$0$0(recentSearchQueries, onRecentSearchQueryClick, onDeleteRecentSearchQueryClick, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifier5 = companion;
            composer2 = composerStartRestartGroup;
            LazyDslKt.LazyColumn(modifierFillMaxSize$default2, null, null, false, null, null, null, false, null, (Function1) objRememberedValue, composer2, 0, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.search.component.FilesRecentSearchQueriesKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesRecentSearchQueriesKt.FilesRecentSearchQueries$lambda$1(recentSearchQueries, onRecentSearchQueryClick, onDeleteRecentSearchQueryClick, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RecentSearchQueryItem(String str, final Function1<? super String, Unit> function1, Function1<? super String, Unit> function2, Composer composer, final int i) {
        int i2;
        final Function1<? super String, Unit> function3;
        final String str2 = str;
        Composer composerStartRestartGroup = composer.startRestartGroup(1340153833);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RecentSearchQueryItem)N(query,onRecentSearchQueryClick,onDeleteRecentSearchQueryClick)60@2325L70,57@2241L1491:FilesRecentSearchQueries.kt#8xusuk");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            function3 = function2;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1340153833, i3, -1, "com.box.android.browse.search.component.RecentSearchQueryItem (FilesRecentSearchQueries.kt:56)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -602347569, "CC(remember):FilesRecentSearchQueries.kt#9igjgp");
            int i4 = i3 & 14;
            boolean z = ((i3 & 112) == 32) | (i4 == 4);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.browse.search.component.FilesRecentSearchQueriesKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilesRecentSearchQueriesKt.RecentSearchQueryItem$lambda$0$0(function1, str2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float f = 6;
            Modifier modifierM1219paddingVpY3zN4 = PaddingKt.m1219paddingVpY3zN4(ClickableKt.m632clickableoSLSa3U$default(modifierFillMaxWidth$default, false, null, null, null, (Function0) objRememberedValue, 15, null), Dp.m9687constructorimpl(16), Dp.m9687constructorimpl(f));
            float f2 = 12;
            Arrangement.Horizontal horizontalM1074spacedByD5KLDUw = Arrangement.INSTANCE.m1074spacedByD5KLDUw(Dp.m9687constructorimpl(f2), Alignment.INSTANCE.getCenterHorizontally());
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalM1074spacedByD5KLDUw, centerVertically, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1219paddingVpY3zN4);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1760248415, "C75@2866L6,77@2982L6,70@2671L345,82@3130L6,79@3025L257,89@3384L84,92@3507L51,95@3695L6,87@3291L435:FilesRecentSearchQueries.kt#8xusuk");
            IconKt.m3576Iconww6aTOc(AccessTimeKt.getAccessTime(Icons.Rounded.INSTANCE), (String) null, PaddingKt.m1218padding3ABfNKs(BackgroundKt.m588backgroundbw27NRU(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(36)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11551getSearchIconBackground0d7_KjU(), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f2))), Dp.m9687constructorimpl(f)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11552getSearchIconContent0d7_KjU(), composerStartRestartGroup, 48, 0);
            str2 = str;
            TextKt.m4494TextNvy7gAk(str2, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 2, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium16(), composerStartRestartGroup, i4, 24960, 110584);
            composerStartRestartGroup = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1303730041, "CC(remember):FilesRecentSearchQueries.kt#9igjgp");
            boolean z2 = ((i3 & 896) == 256) | (i4 == 4);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                function3 = function2;
                objRememberedValue2 = new Function0() { // from class: com.box.android.browse.search.component.FilesRecentSearchQueriesKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilesRecentSearchQueriesKt.RecentSearchQueryItem$lambda$1$0$0(function3, str2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                function3 = function2;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, (Function0) objRememberedValue2, StringResources_androidKt.stringResource(R.string.delete_recent_search_query, composerStartRestartGroup, 0), new ButtonItemIconResource.DrawableResource(R.drawable.ic_close), false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11543getPopupSecondary0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.search.component.FilesRecentSearchQueriesKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesRecentSearchQueriesKt.RecentSearchQueryItem$lambda$2(str2, function1, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecentSearchQueryItem$lambda$0$0(Function1 function1, String str) {
        function1.invoke(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecentSearchQueryItem$lambda$1$0$0(Function1 function1, String str) {
        function1.invoke(str);
        return Unit.INSTANCE;
    }

    private static final void FilesRecentSearchQueriesPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-173813030);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FilesRecentSearchQueriesPreview)104@3841L228:FilesRecentSearchQueries.kt#8xusuk");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-173813030, i, -1, "com.box.android.browse.search.component.FilesRecentSearchQueriesPreview (FilesRecentSearchQueries.kt:103)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$FilesRecentSearchQueriesKt.INSTANCE.getLambda$869976111$browse_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.search.component.FilesRecentSearchQueriesKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesRecentSearchQueriesKt.FilesRecentSearchQueriesPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesRecentSearchQueries$lambda$0$0(final List list, final Function1 function1, final Function1 function2, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final FilesRecentSearchQueriesKt$FilesRecentSearchQueries$lambda$0$0$$inlined$items$default$1 filesRecentSearchQueriesKt$FilesRecentSearchQueries$lambda$0$0$$inlined$items$default$1 = new Function1() { // from class: com.box.android.browse.search.component.FilesRecentSearchQueriesKt$FilesRecentSearchQueries$lambda$0$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(String str) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((String) obj);
            }
        };
        LazyColumn.items(list.size(), null, new Function1<Integer, Object>() { // from class: com.box.android.browse.search.component.FilesRecentSearchQueriesKt$FilesRecentSearchQueries$lambda$0$0$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return filesRecentSearchQueriesKt$FilesRecentSearchQueries$lambda$0$0$$inlined$items$default$1.invoke(list.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.box.android.browse.search.component.FilesRecentSearchQueriesKt$FilesRecentSearchQueries$lambda$0$0$$inlined$items$default$4
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
                String str = (String) list.get(i);
                composer.startReplaceGroup(-1818817592);
                ComposerKt.sourceInformation(composer, "CN(query)*40@1736L310:FilesRecentSearchQueries.kt#8xusuk");
                Alignment bottomStart = Alignment.INSTANCE.getBottomStart();
                ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(bottomStart, false);
                ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
                ComposerKt.sourceInformationMarkerStart(composer, -307954384, "C41@1800L232:FilesRecentSearchQueries.kt#8xusuk");
                FilesRecentSearchQueriesKt.RecentSearchQueryItem(str, function1, function2, composer, 0);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }
}
