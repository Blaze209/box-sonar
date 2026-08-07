package com.box.android.search.presentation.ui.components;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.button.BoxIconButtonKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.button.model.ButtonItemIconResource;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.search.FilesSearchFilters;
import com.box.android.search.R;
import com.box.android.search.presentation.cpl.FilesSearchReducer;
import com.box.android.search.presentation.cpl.HubsSearchReducer;
import com.box.android.search.presentation.cpl.NotesSearchReducer;
import com.box.android.search.presentation.cpl.SearchModeState;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: SearchResultsHeader.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0001¢\u0006\u0002\u0010\t\u001aA\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u001e\b\u0002\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0003¢\u0006\u0002\u0010\u0013\u001aC\u0010\u0014\u001a\u00020\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\u001b\u001a-\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u000e2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0003¢\u0006\u0002\u0010\u001f\u001a\u0012\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!*\u00020\u0018H\u0002\u001a\f\u0010#\u001a\u00020$*\u00020%H\u0002\u001a\f\u0010#\u001a\u00020$*\u00020&H\u0002\u001a\f\u0010#\u001a\u00020$*\u00020'H\u0002¨\u0006("}, d2 = {"SearchResultsHeader", "", "searchModeState", "Lcom/box/android/search/presentation/cpl/SearchModeState;", "onFilesFilterButtonClick", "Lkotlin/Function0;", "onRemoveFilesFilter", "Lkotlin/Function1;", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterType;", "(Lcom/box/android/search/presentation/cpl/SearchModeState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "SearchResultsRow", "modifier", "Landroidx/compose/ui/Modifier;", "text", "", "filtersButton", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FilesSearchResultsHeader", "parentFolder", "Lcom/box/android/domain/models/item/FolderModel;", "filters", "Lcom/box/android/domain/models/search/FilesSearchFilters;", "onFilterButtonClick", "onRemoveFilter", "(Lcom/box/android/domain/models/item/FolderModel;Lcom/box/android/domain/models/search/FilesSearchFilters;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "SearchFilterChip", "label", ViewProps.ON_CLICK, "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "toChips", "", "Lcom/box/android/search/presentation/ui/components/FilterChipUi;", "toLabelRes", "", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType;", "Lcom/box/android/domain/models/search/FilesSearchFilters$ModifiedAfterDate;", "Lcom/box/android/domain/models/search/FilesSearchFilters$Size;", "search_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SearchResultsHeaderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesSearchResultsHeader$lambda$1(FolderModel folderModel, FilesSearchFilters filesSearchFilters, Function0 function0, Function1 function1, int i, Composer composer, int i2) {
        FilesSearchResultsHeader(folderModel, filesSearchFilters, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchFilterChip$lambda$1(String str, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SearchFilterChip(str, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchResultsHeader$lambda$0(SearchModeState searchModeState, Function0 function0, Function1 function1, int i, Composer composer, int i2) {
        SearchResultsHeader(searchModeState, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchResultsRow$lambda$1(Modifier modifier, String str, Function3 function3, int i, int i2, Composer composer, int i3) {
        SearchResultsRow(modifier, str, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void SearchResultsHeader(final SearchModeState searchModeState, final Function0<Unit> onFilesFilterButtonClick, final Function1<? super FilesSearchFilters.FilterType, Unit> onRemoveFilesFilter, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(searchModeState, "searchModeState");
        Intrinsics.checkNotNullParameter(onFilesFilterButtonClick, "onFilesFilterButtonClick");
        Intrinsics.checkNotNullParameter(onRemoveFilesFilter, "onRemoveFilesFilter");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1951542966);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SearchResultsHeader)N(searchModeState,onFilesFilterButtonClick,onRemoveFilesFilter):SearchResultsHeader.kt#1mmsr7");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(searchModeState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onFilesFilterButtonClick) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onRemoveFilesFilter) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1951542966, i2, -1, "com.box.android.search.presentation.ui.components.SearchResultsHeader (SearchResultsHeader.kt:45)");
            }
            if (searchModeState instanceof FilesSearchReducer.State) {
                composerStartRestartGroup.startReplaceGroup(1467926018);
                ComposerKt.sourceInformation(composerStartRestartGroup, "47@2177L248");
                FilesSearchReducer.State state = (FilesSearchReducer.State) searchModeState;
                FilesSearchResultsHeader(state.getParentFolder(), state.getFilters(), onFilesFilterButtonClick, onRemoveFilesFilter, composerStartRestartGroup, (i2 << 3) & 8064);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                if (!(searchModeState instanceof HubsSearchReducer.State) && !(searchModeState instanceof NotesSearchReducer.State)) {
                    composerStartRestartGroup.startReplaceGroup(1467924159);
                    composerStartRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composerStartRestartGroup.startReplaceGroup(-1738617682);
                ComposerKt.sourceInformation(composerStartRestartGroup, "56@2516L18");
                SearchResultsRow(null, null, null, composerStartRestartGroup, 0, 7);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.components.SearchResultsHeaderKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchResultsHeaderKt.SearchResultsHeader$lambda$0(searchModeState, onFilesFilterButtonClick, onRemoveFilesFilter, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x006e  */
    /* JADX WARN: Code duplicated, block: B:38:0x0070  */
    /* JADX WARN: Code duplicated, block: B:41:0x0079  */
    /* JADX WARN: Code duplicated, block: B:51:0x009b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x009d  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:66:0x0140  */
    /* JADX WARN: Code duplicated, block: B:69:0x014c  */
    /* JADX WARN: Code duplicated, block: B:70:0x0150  */
    /* JADX WARN: Code duplicated, block: B:73:0x0214  */
    /* JADX WARN: Code duplicated, block: B:74:0x0218  */
    /* JADX WARN: Code duplicated, block: B:77:0x0224  */
    /* JADX WARN: Code duplicated, block: B:79:? A[RETURN, SYNTHETIC] */
    private static final void SearchResultsRow(Modifier modifier, String str, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        String str2;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4;
        boolean z;
        Modifier.Companion companion;
        String str3;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> lambda$1203588223$search_generalProdRelease;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        String strStringResource;
        int i4;
        Function0<ComposeUiNode> constructor;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(1986442518);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SearchResultsRow)N(modifier,text,filtersButton)67@2755L496:SearchResultsHeader.kt#1mmsr7");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                str2 = str;
                if (composerStartRestartGroup.changed(str2)) {
                    i5 = 32;
                }
                i3 |= i5;
            } else {
                str2 = str;
            }
            i5 = 16;
            i3 |= i5;
        } else {
            str2 = str;
        }
        int i7 = i2 & 4;
        if (i7 == 0) {
            if ((i & 384) == 0) {
                function4 = function3;
                i3 |= composerStartRestartGroup.changedInstance(function4) ? 256 : 128;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "64@2650L39");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        strStringResource = StringResources_androidKt.stringResource(R.string.search_results, composerStartRestartGroup, 0);
                        i3 &= -113;
                    } else {
                        strStringResource = str2;
                    }
                    if (i7 != 0) {
                        int i8 = i3;
                        str3 = strStringResource;
                        lambda$1203588223$search_generalProdRelease = ComposableSingletons$SearchResultsHeaderKt.INSTANCE.getLambda$1203588223$search_generalProdRelease();
                        i4 = i8;
                    } else {
                        i4 = i3;
                        str3 = strStringResource;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1986442518, i4, -1, "com.box.android.search.presentation.ui.components.SearchResultsRow (SearchResultsHeader.kt:66)");
                    }
                    Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m9687constructorimpl(48)), Dp.m9687constructorimpl(16), 0.0f, Dp.m9687constructorimpl(8), 0.0f, 10, null);
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1222paddingqDBjuR0$default);
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
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1902605359, "C77@3078L6,74@2963L258,82@3230L15:SearchResultsHeader.kt#1mmsr7");
                    int i9 = i4 >> 3;
                    TextKt.m4494TextNvy7gAk(str3, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxSemiBold14(), composerStartRestartGroup, i9 & 14, 24960, 110584);
                    lambda$1203588223$search_generalProdRelease.invoke(rowScopeInstance, composerStartRestartGroup, Integer.valueOf((i9 & 112) | 6));
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
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    String str4 = str2;
                    i4 = i3;
                    str3 = str4;
                    companion = modifier2;
                }
                lambda$1203588223$search_generalProdRelease = function4;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1986442518, i4, -1, "com.box.android.search.presentation.ui.components.SearchResultsRow (SearchResultsHeader.kt:66)");
                }
                Modifier modifierM1222paddingqDBjuR0$default2 = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m9687constructorimpl(48)), Dp.m9687constructorimpl(16), 0.0f, Dp.m9687constructorimpl(8), 0.0f, 10, null);
                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1222paddingqDBjuR0$default2);
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
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1902605359, "C77@3078L6,74@2963L258,82@3230L15:SearchResultsHeader.kt#1mmsr7");
                int i10 = i4 >> 3;
                TextKt.m4494TextNvy7gAk(str3, RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxSemiBold14(), composerStartRestartGroup, i10 & 14, 24960, 110584);
                lambda$1203588223$search_generalProdRelease.invoke(rowScopeInstance2, composerStartRestartGroup, Integer.valueOf((i10 & 112) | 6));
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
                companion = modifier2;
                str3 = str2;
                lambda$1203588223$search_generalProdRelease = function4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier3 = companion;
                final String str5 = str3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.components.SearchResultsHeaderKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SearchResultsHeaderKt.SearchResultsRow$lambda$1(modifier3, str5, lambda$1203588223$search_generalProdRelease, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        function4 = function3;
        if ((i3 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "64@2650L39");
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    strStringResource = StringResources_androidKt.stringResource(R.string.search_results, composerStartRestartGroup, 0);
                    i3 &= -113;
                } else {
                    strStringResource = str2;
                }
                if (i7 != 0) {
                    int i11 = i3;
                    str3 = strStringResource;
                    lambda$1203588223$search_generalProdRelease = ComposableSingletons$SearchResultsHeaderKt.INSTANCE.getLambda$1203588223$search_generalProdRelease();
                    i4 = i11;
                } else {
                    i4 = i3;
                    str3 = strStringResource;
                    lambda$1203588223$search_generalProdRelease = function4;
                }
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    strStringResource = StringResources_androidKt.stringResource(R.string.search_results, composerStartRestartGroup, 0);
                    i3 &= -113;
                } else {
                    strStringResource = str2;
                }
                if (i7 != 0) {
                    int i12 = i3;
                    str3 = strStringResource;
                    lambda$1203588223$search_generalProdRelease = ComposableSingletons$SearchResultsHeaderKt.INSTANCE.getLambda$1203588223$search_generalProdRelease();
                    i4 = i12;
                } else {
                    i4 = i3;
                    str3 = strStringResource;
                    lambda$1203588223$search_generalProdRelease = function4;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1986442518, i4, -1, "com.box.android.search.presentation.ui.components.SearchResultsRow (SearchResultsHeader.kt:66)");
            }
            Modifier modifierM1222paddingqDBjuR0$default3 = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m9687constructorimpl(48)), Dp.m9687constructorimpl(16), 0.0f, Dp.m9687constructorimpl(8), 0.0f, 10, null);
            Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically3, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1222paddingqDBjuR0$default3);
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
            Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1902605359, "C77@3078L6,74@2963L258,82@3230L15:SearchResultsHeader.kt#1mmsr7");
            int i13 = i4 >> 3;
            TextKt.m4494TextNvy7gAk(str3, RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxSemiBold14(), composerStartRestartGroup, i13 & 14, 24960, 110584);
            lambda$1203588223$search_generalProdRelease.invoke(rowScopeInstance3, composerStartRestartGroup, Integer.valueOf((i13 & 112) | 6));
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
            companion = modifier2;
            str3 = str2;
            lambda$1203588223$search_generalProdRelease = function4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = companion;
            final String str6 = str3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.components.SearchResultsHeaderKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchResultsHeaderKt.SearchResultsRow$lambda$1(modifier4, str6, lambda$1203588223$search_generalProdRelease, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void FilesSearchResultsHeader(final FolderModel folderModel, final FilesSearchFilters filesSearchFilters, final Function0<Unit> function0, final Function1<? super FilesSearchFilters.FilterType, Unit> function1, Composer composer, final int i) {
        int i2;
        String strStringResource;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1928437038);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FilesSearchResultsHeader)N(parentFolder,filters,onFilterButtonClick,onRemoveFilter)99@3693L1476:SearchResultsHeader.kt#1mmsr7");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(folderModel) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(filesSearchFilters) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1928437038, i3, -1, "com.box.android.search.presentation.ui.components.FilesSearchResultsHeader (SearchResultsHeader.kt:92)");
            }
            if (folderModel != null && !folderModel.isRoot()) {
                composerStartRestartGroup.startReplaceGroup(-584980292);
                ComposerKt.sourceInformation(composerStartRestartGroup, "94@3552L68");
                strStringResource = StringResources_androidKt.stringResource(R.string.search_results_in_folder, new Object[]{folderModel.getName()}, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-584891911);
                ComposerKt.sourceInformation(composerStartRestartGroup, "96@3642L39");
                strStringResource = StringResources_androidKt.stringResource(R.string.search_results, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            String str = strStringResource;
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 7, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1222paddingqDBjuR0$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 687853844, "C104@3844L609,102@3768L695:SearchResultsHeader.kt#1mmsr7");
            boolean z = true;
            SearchResultsRow(null, str, ComposableLambdaKt.rememberComposableLambda(-226730567, true, new Function3() { // from class: com.box.android.search.presentation.ui.components.SearchResultsHeaderKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SearchResultsHeaderKt.FilesSearchResultsHeader$lambda$0$0(filesSearchFilters, function0, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 384, 1);
            if (filesSearchFilters == null || !filesSearchFilters.isAnyFilterApplied()) {
                composerStartRestartGroup.startReplaceGroup(684071750);
            } else {
                composerStartRestartGroup.startReplaceGroup(688581320);
                ComposerKt.sourceInformation(composerStartRestartGroup, "124@4809L344,120@4581L572");
                final List<FilterChipUi> chips = toChips(filesSearchFilters);
                Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, "FilesSearchFiltersRow");
                PaddingValues paddingValuesM1213PaddingValuesYgX7TsA$default = PaddingKt.m1213PaddingValuesYgX7TsA$default(Dp.m9687constructorimpl(16), 0.0f, 2, null);
                Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_4 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(6));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1546241748, "CC(remember):SearchResultsHeader.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(chips);
                if ((i3 & 7168) != 2048) {
                    z = false;
                }
                boolean z2 = z | zChangedInstance;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.search.presentation.ui.components.SearchResultsHeaderKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchResultsHeaderKt.FilesSearchResultsHeader$lambda$0$1$0(chips, function1, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LazyDslKt.LazyRow(modifierTestTag, null, paddingValuesM1213PaddingValuesYgX7TsA$default, false, horizontalOrVerticalM1073spacedBy0680j_4, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, 24966, 490);
                composerStartRestartGroup = composerStartRestartGroup;
            }
            composerStartRestartGroup.endReplaceGroup();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.components.SearchResultsHeaderKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchResultsHeaderKt.FilesSearchResultsHeader$lambda$1(folderModel, filesSearchFilters, function0, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesSearchResultsHeader$lambda$0$0(FilesSearchFilters filesSearchFilters, Function0 function0, RowScope SearchResultsRow, Composer composer, int i) {
        Composer composer2;
        Intrinsics.checkNotNullParameter(SearchResultsRow, "$this$SearchResultsRow");
        ComposerKt.sourceInformation(composer, "C:SearchResultsHeader.kt#1mmsr7");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-226730567, i, -1, "com.box.android.search.presentation.ui.components.FilesSearchResultsHeader.<anonymous>.<anonymous> (SearchResultsHeader.kt:105)");
            }
            if (filesSearchFilters != null) {
                composer.startReplaceGroup(1453311621);
                ComposerKt.sourceInformation(composer, "109@4092L51,112@4321L6,106@3905L516");
                composer2 = composer;
                BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, function0, StringResources_androidKt.stringResource(R.string.filters_button_description, composer, 0), new ButtonItemIconResource.DrawableResource(R.drawable.search_filter), false, 17, null), null, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(16)), BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), 0.0f, composer2, 384, 18);
            } else {
                composer2 = composer;
                composer2.startReplaceGroup(1449420873);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesSearchResultsHeader$lambda$0$1$0(final List list, final Function1 function1, LazyListScope LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        final Function1 function2 = new Function1() { // from class: com.box.android.search.presentation.ui.components.SearchResultsHeaderKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchResultsHeaderKt.FilesSearchResultsHeader$lambda$0$1$0$0((FilterChipUi) obj);
            }
        };
        final SearchResultsHeaderKt$FilesSearchResultsHeader$lambda$0$1$0$$inlined$items$default$1 searchResultsHeaderKt$FilesSearchResultsHeader$lambda$0$1$0$$inlined$items$default$1 = new Function1() { // from class: com.box.android.search.presentation.ui.components.SearchResultsHeaderKt$FilesSearchResultsHeader$lambda$0$1$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(FilterChipUi filterChipUi) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((FilterChipUi) obj);
            }
        };
        LazyRow.items(list.size(), new Function1<Integer, Object>() { // from class: com.box.android.search.presentation.ui.components.SearchResultsHeaderKt$FilesSearchResultsHeader$lambda$0$1$0$$inlined$items$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return function2.invoke(list.get(i));
            }
        }, new Function1<Integer, Object>() { // from class: com.box.android.search.presentation.ui.components.SearchResultsHeaderKt$FilesSearchResultsHeader$lambda$0$1$0$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return searchResultsHeaderKt$FilesSearchResultsHeader$lambda$0$1$0$$inlined$items$default$1.invoke(list.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.box.android.search.presentation.ui.components.SearchResultsHeaderKt$FilesSearchResultsHeader$lambda$0$1$0$$inlined$items$default$4
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
                final FilterChipUi filterChipUi = (FilterChipUi) list.get(i);
                composer.startReplaceGroup(-116697844);
                ComposerKt.sourceInformation(composer, "CN(chip)*127@4938L29,128@5003L37,126@4888L233:SearchResultsHeader.kt#1mmsr7");
                String strStringResource = StringResources_androidKt.stringResource(filterChipUi.getLabelRes(), composer, 0);
                ComposerKt.sourceInformationMarkerStart(composer, 1797354355, "CC(remember):SearchResultsHeader.kt#9igjgp");
                boolean zChanged = composer.changed(function1) | composer.changedInstance(filterChipUi);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    final Function1 function3 = function1;
                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.box.android.search.presentation.ui.components.SearchResultsHeaderKt$FilesSearchResultsHeader$1$2$1$2$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function3.invoke(filterChipUi.getChipToRemove());
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                SearchResultsHeaderKt.SearchFilterChip(strStringResource, (Function0) objRememberedValue, LazyItemScope.animateItem$default(lazyItemScope, Modifier.INSTANCE, null, null, null, 7, null), composer, 0, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object FilesSearchResultsHeader$lambda$0$1$0$0(FilterChipUi it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:32:0x005f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0068 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x006a  */
    /* JADX WARN: Code duplicated, block: B:37:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0076  */
    /* JADX WARN: Code duplicated, block: B:43:0x010c  */
    /* JADX WARN: Code duplicated, block: B:46:0x0118  */
    /* JADX WARN: Code duplicated, block: B:47:0x011c  */
    /* JADX WARN: Code duplicated, block: B:50:0x0207  */
    /* JADX WARN: Code duplicated, block: B:52:0x020c  */
    /* JADX WARN: Code duplicated, block: B:55:0x0216  */
    /* JADX WARN: Code duplicated, block: B:57:? A[RETURN, SYNTHETIC] */
    public static final void SearchFilterChip(final String str, final Function0<Unit> function0, Modifier modifier, Composer composer, final int i, final int i2) {
        String str2;
        int i3;
        Function0<Unit> function1;
        Modifier modifier2;
        boolean z;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Function0<ComposeUiNode> constructor;
        Composer composerStartRestartGroup = composer.startRestartGroup(1717960438);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SearchFilterChip)N(label,onClick,modifier)142@5397L6,139@5287L830:SearchResultsHeader.kt#1mmsr7");
        if ((i & 6) == 0) {
            str2 = str;
            i3 = (composerStartRestartGroup.changed(str2) ? 4 : 2) | i;
        } else {
            str2 = str;
            i3 = i;
        }
        if ((i & 48) == 0) {
            function1 = function0;
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        } else {
            function1 = function0;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
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
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1717960438, i3, -1, "com.box.android.search.presentation.ui.components.SearchFilterChip (SearchResultsHeader.kt:138)");
                }
                float f = 8;
                Modifier modifierM1219paddingVpY3zN4 = PaddingKt.m1219paddingVpY3zN4(ClickableKt.m632clickableoSLSa3U$default(BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(companion, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f))), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11549getSearchFilterChipBackground0d7_KjU(), null, 2, null), false, null, null, null, function1, 15, null), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f));
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                float f2 = 4;
                Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_4 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(f2));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_4, centerVertically, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1219paddingVpY3zN4);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1459772055, "C151@5777L6,148@5663L221,155@5921L36,157@6026L6,154@5893L218:SearchResultsHeader.kt#1mmsr7");
                Modifier modifier4 = companion;
                TextKt.m4494TextNvy7gAk(str2, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f2), 0.0f, Dp.m9687constructorimpl(f), 0.0f, 10, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11550getSearchFilterChipContent0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium14(), composerStartRestartGroup, (i3 & 14) | 48, 0, 131064);
                composerStartRestartGroup = composerStartRestartGroup;
                IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_close, composerStartRestartGroup, 0), (String) null, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(18)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11550getSearchFilterChipContent0d7_KjU(), composerStartRestartGroup, Painter.$stable | 432, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.components.SearchResultsHeaderKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SearchResultsHeaderKt.SearchFilterChip$lambda$1(str, function0, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
            if (i4 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1717960438, i3, -1, "com.box.android.search.presentation.ui.components.SearchFilterChip (SearchResultsHeader.kt:138)");
            }
            float f3 = 8;
            Modifier modifierM1219paddingVpY3zN5 = PaddingKt.m1219paddingVpY3zN4(ClickableKt.m632clickableoSLSa3U$default(BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(companion, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f3))), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11549getSearchFilterChipBackground0d7_KjU(), null, 2, null), false, null, null, null, function1, 15, null), Dp.m9687constructorimpl(f3), Dp.m9687constructorimpl(f3));
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            float f4 = 4;
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_5 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(f4));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_5, centerVertically2, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1219paddingVpY3zN5);
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
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1459772055, "C151@5777L6,148@5663L221,155@5921L36,157@6026L6,154@5893L218:SearchResultsHeader.kt#1mmsr7");
            Modifier modifier5 = companion;
            TextKt.m4494TextNvy7gAk(str2, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f4), 0.0f, Dp.m9687constructorimpl(f3), 0.0f, 10, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11550getSearchFilterChipContent0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium14(), composerStartRestartGroup, (i3 & 14) | 48, 0, 131064);
            composerStartRestartGroup = composerStartRestartGroup;
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_close, composerStartRestartGroup, 0), (String) null, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(18)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11550getSearchFilterChipContent0d7_KjU(), composerStartRestartGroup, Painter.$stable | 432, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.components.SearchResultsHeaderKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchResultsHeaderKt.SearchFilterChip$lambda$1(str, function0, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final List<FilterChipUi> toChips(FilesSearchFilters filesSearchFilters) {
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        for (FilesSearchFilters.FilterItemType filterItemType : filesSearchFilters.getItemTypes()) {
            listCreateListBuilder.add(new FilterChipUi("item_type_" + Reflection.getOrCreateKotlinClass(filterItemType.getClass()).getSimpleName(), toLabelRes(filterItemType), filterItemType));
        }
        if (!Intrinsics.areEqual(filesSearchFilters.getModifiedDate(), FilesSearchFilters.ModifiedAfterDate.Any.INSTANCE)) {
            listCreateListBuilder.add(new FilterChipUi("modified_date", toLabelRes(filesSearchFilters.getModifiedDate()), filesSearchFilters.getModifiedDate()));
        }
        if (!Intrinsics.areEqual(filesSearchFilters.getSize(), FilesSearchFilters.Size.Any.INSTANCE)) {
            listCreateListBuilder.add(new FilterChipUi("size", toLabelRes(filesSearchFilters.getSize()), filesSearchFilters.getSize()));
        }
        return CollectionsKt.build(listCreateListBuilder);
    }

    private static final int toLabelRes(FilesSearchFilters.FilterItemType filterItemType) {
        if (filterItemType instanceof FilesSearchFilters.FilterItemType.Folder) {
            return com.box.android.coreservices.R.string.search_filter_file_type_folder;
        }
        if (filterItemType instanceof FilesSearchFilters.FilterItemType.FileType.Audio) {
            return com.box.android.coreservices.R.string.search_filter_file_type_audio;
        }
        if (filterItemType instanceof FilesSearchFilters.FilterItemType.FileType.BoxNote) {
            return com.box.android.coreservices.R.string.search_filter_file_type_boxnote;
        }
        if (filterItemType instanceof FilesSearchFilters.FilterItemType.FileType.Document) {
            return com.box.android.coreservices.R.string.search_filter_file_type_document;
        }
        if (filterItemType instanceof FilesSearchFilters.FilterItemType.FileType.Autocad) {
            return com.box.android.coreservices.R.string.search_filter_file_type_autocad;
        }
        if (filterItemType instanceof FilesSearchFilters.FilterItemType.FileType.Image) {
            return com.box.android.coreservices.R.string.search_filter_file_type_image;
        }
        if (filterItemType instanceof FilesSearchFilters.FilterItemType.FileType.Pdf) {
            return com.box.android.coreservices.R.string.search_filter_file_type_pdf;
        }
        if (filterItemType instanceof FilesSearchFilters.FilterItemType.FileType.Presentation) {
            return com.box.android.coreservices.R.string.search_filter_file_type_presentation;
        }
        if (filterItemType instanceof FilesSearchFilters.FilterItemType.FileType.Spreadsheet) {
            return com.box.android.coreservices.R.string.search_filter_file_type_spreadsheet;
        }
        if (filterItemType instanceof FilesSearchFilters.FilterItemType.FileType.Video) {
            return com.box.android.coreservices.R.string.search_filter_file_type_video;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final int toLabelRes(FilesSearchFilters.ModifiedAfterDate modifiedAfterDate) {
        if (Intrinsics.areEqual(modifiedAfterDate, FilesSearchFilters.ModifiedAfterDate.Any.INSTANCE)) {
            return com.box.android.coreservices.R.string.any_time;
        }
        if (Intrinsics.areEqual(modifiedAfterDate, FilesSearchFilters.ModifiedAfterDate.PastDay.INSTANCE)) {
            return com.box.android.coreservices.R.string.past_day;
        }
        if (Intrinsics.areEqual(modifiedAfterDate, FilesSearchFilters.ModifiedAfterDate.PastWeek.INSTANCE)) {
            return com.box.android.coreservices.R.string.past_week;
        }
        if (Intrinsics.areEqual(modifiedAfterDate, FilesSearchFilters.ModifiedAfterDate.PastMonth.INSTANCE)) {
            return com.box.android.coreservices.R.string.past_month;
        }
        if (Intrinsics.areEqual(modifiedAfterDate, FilesSearchFilters.ModifiedAfterDate.PastYear.INSTANCE)) {
            return com.box.android.coreservices.R.string.past_year;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final int toLabelRes(FilesSearchFilters.Size size) {
        if (Intrinsics.areEqual(size, FilesSearchFilters.Size.Any.INSTANCE)) {
            return com.box.android.coreservices.R.string.item_size_any;
        }
        if (Intrinsics.areEqual(size, FilesSearchFilters.Size.LessThan1Mb.INSTANCE)) {
            return com.box.android.coreservices.R.string.item_size_0_to_1;
        }
        if (Intrinsics.areEqual(size, FilesSearchFilters.Size.From1To5Mb.INSTANCE)) {
            return com.box.android.coreservices.R.string.item_size_1_to_5;
        }
        if (Intrinsics.areEqual(size, FilesSearchFilters.Size.From5To25Mb.INSTANCE)) {
            return com.box.android.coreservices.R.string.item_size_5_to_25;
        }
        if (Intrinsics.areEqual(size, FilesSearchFilters.Size.From25To100Mb.INSTANCE)) {
            return com.box.android.coreservices.R.string.item_size_25_to_100;
        }
        if (Intrinsics.areEqual(size, FilesSearchFilters.Size.From100MbTo1Gb.INSTANCE)) {
            return com.box.android.coreservices.R.string.item_size_100_to_1000;
        }
        throw new NoWhenBranchMatchedException();
    }
}
