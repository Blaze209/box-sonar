package com.box.android.base.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
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
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.media3.common.C;
import com.box.android.base.R;
import com.box.android.base.compose.popup.BoxPopupMenuKt;
import com.box.android.base.compose.popup.model.PopupMenuItem;
import com.box.android.domain.localrepo.LocalSortPreferences;
import com.box.android.domain.models.ItemsScreenMode;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.ComposeIdentificationData;

/* JADX INFO: compiled from: ItemListingScreenConfigBar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0099\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u0011\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0007¢\u0006\u0002\u0010\u0016\u001a[\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0007¢\u0006\u0002\u0010\u0019\u001aE\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0007¢\u0006\u0002\u0010\u001f\u001a#\u0010 \u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0003¢\u0006\u0002\u0010!\u001ai\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u00072\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010%\u001a\u00020\u00072\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u000f2\u0006\u0010'\u001a\u00020\u00072\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020*H\u0003¢\u0006\u0002\u0010,\u001a6\u0010-\u001a\u00020\u00012\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b/2\u0006\u0010)\u001a\u00020*2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0003¢\u0006\u0002\u00101\u001a\r\u00102\u001a\u00020\u0001H\u0003¢\u0006\u0002\u00103\u001a\r\u00104\u001a\u00020\u0001H\u0003¢\u0006\u0002\u00103\u001a\r\u00105\u001a\u00020\u0001H\u0003¢\u0006\u0002\u00103¨\u00066²\u0006\n\u00107\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u00108\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010\u0006\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010\b\u001a\u00020\tX\u008a\u008e\u0002²\u0006\n\u00109\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010\b\u001a\u00020\tX\u008a\u008e\u0002²\u0006\n\u0010:\u001a\u00020\u0007X\u008a\u008e\u0002"}, d2 = {"ItemListingScreenConfigBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "itemsScreenMode", "Lcom/box/android/domain/models/ItemsScreenMode;", "selectedSortByTextRes", "", "selectedSortDirection", "Lcom/box/android/domain/localrepo/LocalSortPreferences$SortOrder;", "sortByOptionsTextRes", "", "onSortButtonClicked", "Lkotlin/Function0;", "sortByChanged", "Lkotlin/Function1;", "sortDirectionToggled", "searchBarTextRes", "onSearchBarClicked", "shouldShowSearchButton", "", "toggleScreenMode", "(Landroidx/compose/ui/Modifier;Lcom/box/android/domain/models/ItemsScreenMode;ILcom/box/android/domain/localrepo/LocalSortPreferences$SortOrder;Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;ILkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;III)V", "SortOptionsButton", "sortOptionsTextRes", "(ILcom/box/android/domain/localrepo/LocalSortPreferences$SortOrder;Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "FilterOptionsButon", "selectedFilterTextRes", "filterOptions", "filterChanged", "onFilterButtonClicked", "(ILjava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SearchButton", "(ILkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "DropdownButton", "selectedTextRes", "optionsTextRes", "selectedOptionIndex", "onOptionSelected", "trailingIconForSelectedRes", "onButtonClick", ComposeIdentificationData.FIELD_TEST_TAG_HASHED, "", "dropdownMenuTestTag", "(ILjava/util/List;ILkotlin/jvm/functions/Function1;ILkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "BoxItemListConfigBarButtonWrapper", "content", "Landroidx/compose/runtime/Composable;", ViewProps.ON_CLICK, "(Lkotlin/jvm/functions/Function2;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ItemListingScreenConfigBarPreview", "(Landroidx/compose/runtime/Composer;I)V", "SortOptionsButtonPreview", "FilterOptionsButtonPreview", "base_generalProdRelease", "expanded", "screenMode", "selectedSortBy", "selected"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ItemListingScreenConfigBarKt {

    /* JADX INFO: compiled from: ItemListingScreenConfigBar.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<LocalSortPreferences.SortOrder> entries$0 = EnumEntriesKt.enumEntries(LocalSortPreferences.SortOrder.values());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxItemListConfigBarButtonWrapper$lambda$2(Function2 function2, String str, Function0 function0, int i, Composer composer, int i2) {
        BoxItemListConfigBarButtonWrapper(function2, str, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownButton$lambda$4(int i, List list, int i2, Function1 function1, int i3, Function0 function0, String str, String str2, int i4, int i5, Composer composer, int i6) {
        DropdownButton(i, list, i2, function1, i3, function0, str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilterOptionsButon$lambda$1(int i, List list, Function1 function1, Function0 function0, int i2, Composer composer, int i3) {
        FilterOptionsButon(i, list, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilterOptionsButtonPreview$lambda$5(int i, Composer composer, int i2) {
        FilterOptionsButtonPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemListingScreenConfigBar$lambda$1(Modifier modifier, ItemsScreenMode itemsScreenMode, int i, LocalSortPreferences.SortOrder sortOrder, List list, Function0 function0, Function1 function1, Function0 function2, int i2, Function0 function3, boolean z, Function0 function4, int i3, int i4, int i5, Composer composer, int i6) {
        ItemListingScreenConfigBar(modifier, itemsScreenMode, i, sortOrder, list, function0, function1, function2, i2, function3, z, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemListingScreenConfigBarPreview$lambda$10(int i, Composer composer, int i2) {
        ItemListingScreenConfigBarPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchButton$lambda$1(int i, Function0 function0, int i2, Composer composer, int i3) {
        SearchButton(i, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SortOptionsButton$lambda$1(int i, LocalSortPreferences.SortOrder sortOrder, List list, Function0 function0, Function1 function1, Function0 function2, int i2, Composer composer, int i3) {
        SortOptionsButton(i, sortOrder, list, function0, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SortOptionsButtonPreview$lambda$9(int i, Composer composer, int i2) {
        SortOptionsButtonPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ItemListingScreenConfigBar(Modifier modifier, final ItemsScreenMode itemsScreenMode, final int i, final LocalSortPreferences.SortOrder selectedSortDirection, final List<Integer> sortByOptionsTextRes, final Function0<Unit> onSortButtonClicked, final Function1<? super Integer, Unit> sortByChanged, final Function0<Unit> sortDirectionToggled, final int i2, final Function0<Unit> onSearchBarClicked, final boolean z, final Function0<Unit> toggleScreenMode, Composer composer, final int i3, final int i4, final int i5) {
        Modifier modifier2;
        int i6;
        int i7;
        int i8;
        Intrinsics.checkNotNullParameter(itemsScreenMode, "itemsScreenMode");
        Intrinsics.checkNotNullParameter(selectedSortDirection, "selectedSortDirection");
        Intrinsics.checkNotNullParameter(sortByOptionsTextRes, "sortByOptionsTextRes");
        Intrinsics.checkNotNullParameter(onSortButtonClicked, "onSortButtonClicked");
        Intrinsics.checkNotNullParameter(sortByChanged, "sortByChanged");
        Intrinsics.checkNotNullParameter(sortDirectionToggled, "sortDirectionToggled");
        Intrinsics.checkNotNullParameter(onSearchBarClicked, "onSearchBarClicked");
        Intrinsics.checkNotNullParameter(toggleScreenMode, "toggleScreenMode");
        Composer composerStartRestartGroup = composer.startRestartGroup(1438180539);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ItemListingScreenConfigBar)N(modifier,itemsScreenMode,selectedSortByTextRes,selectedSortDirection,sortByOptionsTextRes,onSortButtonClicked,sortByChanged,sortDirectionToggled,searchBarTextRes,onSearchBarClicked,shouldShowSearchButton,toggleScreenMode)66@3018L1358:ItemListingScreenConfigBar.kt#vejmn0");
        int i9 = i5 & 1;
        if (i9 != 0) {
            i6 = i3 | 6;
            modifier2 = modifier;
        } else {
            modifier2 = modifier;
            if ((i3 & 6) == 0) {
                i6 = i3 | (composerStartRestartGroup.changed(modifier2) ? 4 : 2);
            } else {
                i6 = i3;
            }
        }
        if ((i3 & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(itemsScreenMode.ordinal()) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i7 = i;
            i6 |= composerStartRestartGroup.changed(i7) ? 256 : 128;
        } else {
            i7 = i;
        }
        if ((i3 & 3072) == 0) {
            i6 |= composerStartRestartGroup.changed(selectedSortDirection.ordinal()) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(sortByOptionsTextRes) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(onSortButtonClicked) ? 131072 : 65536;
        }
        if ((1572864 & i3) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(sortByChanged) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(sortDirectionToggled) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            i6 |= composerStartRestartGroup.changed(i2) ? 67108864 : 33554432;
        }
        if ((805306368 & i3) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(onSearchBarClicked) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        int i10 = i6;
        if ((i4 & 6) == 0) {
            i8 = i4 | (composerStartRestartGroup.changed(z) ? 4 : 2);
        } else {
            i8 = i4;
        }
        if ((i4 & 48) == 0) {
            i8 |= composerStartRestartGroup.changedInstance(toggleScreenMode) ? 32 : 16;
        }
        int i11 = i8;
        if (!composerStartRestartGroup.shouldExecute(((i10 & 306783379) == 306783378 && (i11 & 19) == 18) ? false : true, i10 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i9 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1438180539, i10, i11, "com.box.android.base.compose.ItemListingScreenConfigBar (ItemListingScreenConfigBar.kt:65)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -660083180, "C68@3099L709,67@3042L859,89@3911L29,91@3950L225,100@4185L27:ItemListingScreenConfigBar.kt#vejmn0");
            BoxItemListConfigBarButtonWrapper(ComposableLambdaKt.rememberComposableLambda(2062982240, true, new Function2() { // from class: com.box.android.base.compose.ItemListingScreenConfigBarKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemListingScreenConfigBarKt.ItemListingScreenConfigBar$lambda$0$0(itemsScreenMode, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), "ToggleDisplayMode", toggleScreenMode, composerStartRestartGroup, ((i11 << 3) & 896) | 54);
            SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(12)), composerStartRestartGroup, 6);
            SortOptionsButton(i7, selectedSortDirection, sortByOptionsTextRes, onSortButtonClicked, sortByChanged, sortDirectionToggled, composerStartRestartGroup, (i10 >> 6) & 524286);
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0);
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-658922293);
                ComposerKt.sourceInformation(composerStartRestartGroup, "103@4264L96");
                SearchButton(i2, onSearchBarClicked, composerStartRestartGroup, (i10 >> 24) & 126);
            } else {
                composerStartRestartGroup.startReplaceGroup(-663143005);
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
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemListingScreenConfigBarKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemListingScreenConfigBarKt.ItemListingScreenConfigBar$lambda$1(modifier3, itemsScreenMode, i, selectedSortDirection, sortByOptionsTextRes, onSortButtonClicked, sortByChanged, sortDirectionToggled, i2, onSearchBarClicked, z, toggleScreenMode, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemListingScreenConfigBar$lambda$0$0(ItemsScreenMode itemsScreenMode, Composer composer, int i) {
        int i2;
        int i3;
        ComposerKt.sourceInformation(composer, "C80@3587L39,81@3669L34,82@3741L6,79@3551L243:ItemListingScreenConfigBar.kt#vejmn0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2062982240, i, -1, "com.box.android.base.compose.ItemListingScreenConfigBar.<anonymous>.<anonymous> (ItemListingScreenConfigBar.kt:69)");
            }
            if (itemsScreenMode == ItemsScreenMode.LIST) {
                i2 = R.drawable.ic_gridview24_blue;
            } else {
                i2 = R.drawable.ic_listview24;
            }
            if (itemsScreenMode == ItemsScreenMode.LIST) {
                i3 = R.string.grid_view;
            } else {
                i3 = R.string.list_view;
            }
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(i2, composer, 0), StringResources_androidKt.stringResource(i3, composer, 0), (Modifier) null, BoxTheme.INSTANCE.getColors(composer, 6).m11584getTopLayerInteractiveSecondary0d7_KjU(), composer, Painter.$stable, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void SortOptionsButton(final int i, final LocalSortPreferences.SortOrder selectedSortDirection, final List<Integer> sortOptionsTextRes, final Function0<Unit> onSortButtonClicked, final Function1<? super Integer, Unit> sortByChanged, final Function0<Unit> sortDirectionToggled, Composer composer, final int i2) {
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(selectedSortDirection, "selectedSortDirection");
        Intrinsics.checkNotNullParameter(sortOptionsTextRes, "sortOptionsTextRes");
        Intrinsics.checkNotNullParameter(onSortButtonClicked, "onSortButtonClicked");
        Intrinsics.checkNotNullParameter(sortByChanged, "sortByChanged");
        Intrinsics.checkNotNullParameter(sortDirectionToggled, "sortDirectionToggled");
        Composer composerStartRestartGroup = composer.startRestartGroup(543087546);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SortOptionsButton)N(selectedSortByTextRes,selectedSortDirection,sortOptionsTextRes,onSortButtonClicked,sortByChanged,sortDirectionToggled)140@5626L173,136@5444L551:ItemListingScreenConfigBar.kt#vejmn0");
        if ((i2 & 6) == 0) {
            i3 = i;
            i4 = (composerStartRestartGroup.changed(i3) ? 4 : 2) | i2;
        } else {
            i3 = i;
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(selectedSortDirection.ordinal()) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(sortOptionsTextRes) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(onSortButtonClicked) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(sortByChanged) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(sortDirectionToggled) ? 131072 : 65536;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i4) != 74898, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(543087546, i4, -1, "com.box.android.base.compose.SortOptionsButton (ItemListingScreenConfigBar.kt:127)");
            }
            if (selectedSortDirection == LocalSortPreferences.SortOrder.ASC) {
                i5 = R.drawable.ic_arrow_up;
            } else {
                i5 = R.drawable.ic_arrow_down;
            }
            int i6 = i5;
            final int iIndexOf = sortOptionsTextRes.indexOf(Integer.valueOf(i3));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2078855705, "CC(remember):ItemListingScreenConfigBar.kt#9igjgp");
            boolean zChanged = ((i4 & 458752) == 131072) | composerStartRestartGroup.changed(iIndexOf) | ((57344 & i4) == 16384);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.base.compose.ItemListingScreenConfigBarKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ItemListingScreenConfigBarKt.SortOptionsButton$lambda$0$0(iIndexOf, sortDirectionToggled, sortByChanged, ((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            DropdownButton(i3, sortOptionsTextRes, iIndexOf, (Function1) objRememberedValue, i6, onSortButtonClicked, "SortByButton", "SortByDropDownMenu", composerStartRestartGroup, (i4 & 14) | 14155776 | ((i4 >> 3) & 112) | ((i4 << 6) & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemListingScreenConfigBarKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemListingScreenConfigBarKt.SortOptionsButton$lambda$1(i, selectedSortDirection, sortOptionsTextRes, onSortButtonClicked, sortByChanged, sortDirectionToggled, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SortOptionsButton$lambda$0$0(int i, Function0 function0, Function1 function1, int i2) {
        if (i2 == i) {
            function0.invoke();
        } else {
            function1.invoke(Integer.valueOf(i2));
        }
        return Unit.INSTANCE;
    }

    public static final void FilterOptionsButon(final int i, final List<Integer> filterOptions, final Function1<? super Integer, Unit> filterChanged, final Function0<Unit> onFilterButtonClicked, Composer composer, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(filterOptions, "filterOptions");
        Intrinsics.checkNotNullParameter(filterChanged, "filterChanged");
        Intrinsics.checkNotNullParameter(onFilterButtonClicked, "onFilterButtonClicked");
        Composer composerStartRestartGroup = composer.startRestartGroup(-56016218);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FilterOptionsButon)N(selectedFilterTextRes,filterOptions,filterChanged,onFilterButtonClicked)167@6424L53,163@6247L436:ItemListingScreenConfigBar.kt#vejmn0");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(filterOptions) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(filterChanged) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onFilterButtonClicked) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-56016218, i3, -1, "com.box.android.base.compose.FilterOptionsButon (ItemListingScreenConfigBar.kt:160)");
            }
            int iIndexOf = filterOptions.indexOf(Integer.valueOf(i));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2003002619, "CC(remember):ItemListingScreenConfigBar.kt#9igjgp");
            boolean z = (i3 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.base.compose.ItemListingScreenConfigBarKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ItemListingScreenConfigBarKt.FilterOptionsButon$lambda$0$0(filterChanged, ((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            DropdownButton(i, filterOptions, iIndexOf, (Function1) objRememberedValue, R.drawable.search_filter, onFilterButtonClicked, "FilterByButton", "FilterByDropDownMenu", composerStartRestartGroup, (i3 & 14) | 14155776 | (i3 & 112) | ((i3 << 6) & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemListingScreenConfigBarKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemListingScreenConfigBarKt.FilterOptionsButon$lambda$1(i, filterOptions, filterChanged, onFilterButtonClicked, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilterOptionsButon$lambda$0$0(Function1 function1, int i) {
        function1.invoke(Integer.valueOf(i));
        return Unit.INSTANCE;
    }

    private static final void SearchButton(final int i, final Function0<Unit> function0, Composer composer, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1271318911);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SearchButton)N(searchBarTextRes,onSearchBarClicked)180@6838L607,179@6785L738:ItemListingScreenConfigBar.kt#vejmn0");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1271318911, i3, -1, "com.box.android.base.compose.SearchButton (ItemListingScreenConfigBar.kt:178)");
            }
            BoxItemListConfigBarButtonWrapper(ComposableLambdaKt.rememberComposableLambda(337614784, true, new Function2() { // from class: com.box.android.base.compose.ItemListingScreenConfigBarKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemListingScreenConfigBarKt.SearchButton$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), "SearchButton", function0, composerStartRestartGroup, ((i3 << 3) & 896) | 54);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemListingScreenConfigBarKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemListingScreenConfigBarKt.SearchButton$lambda$1(i, function0, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchButton$lambda$0(int i, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C181@6852L583:ItemListingScreenConfigBar.kt#vejmn0");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(337614784, i2, -1, "com.box.android.base.compose.SearchButton.<anonymous> (ItemListingScreenConfigBar.kt:181)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -2103598892, "C183@6955L32,185@7087L6,182@6922L218,187@7157L28,189@7238L45,191@7368L6,188@7202L219:ItemListingScreenConfigBar.kt#vejmn0");
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(i, composer, 0), null, BoxTheme.INSTANCE.getColors(composer, 6).m11584getTopLayerInteractiveSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium12(), composer, 0, 12582912, 131066);
            SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composer, 6);
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_search_24, composer, 0), (String) null, (Modifier) null, BoxTheme.INSTANCE.getColors(composer, 6).m11584getTopLayerInteractiveSecondary0d7_KjU(), composer, Painter.$stable | 48, 4);
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

    private static final void DropdownButton(final int i, final List<Integer> list, final int i2, final Function1<? super Integer, Unit> function1, final int i3, final Function0<Unit> function0, String str, String str2, Composer composer, final int i4, final int i5) {
        String str3;
        String str4;
        Function1<? super Integer, Unit> function2;
        Composer composer2;
        final String str5;
        final String str6;
        Composer composerStartRestartGroup = composer.startRestartGroup(1116201449);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownButton)N(selectedTextRes,optionsTextRes,selectedOptionIndex,onOptionSelected,trailingIconForSelectedRes,onButtonClick,testTag,dropdownMenuTestTag)222@8567L34,224@8657L1900:ItemListingScreenConfigBar.kt#vejmn0");
        int i6 = (i4 & 6) == 0 ? (composerStartRestartGroup.changed(i) ? 4 : 2) | i4 : i4;
        if ((i4 & 48) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(list) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i6 |= composerStartRestartGroup.changed(i2) ? 256 : 128;
        }
        if ((i4 & 3072) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i6 |= composerStartRestartGroup.changed(i3) ? 16384 : 8192;
        }
        if ((196608 & i4) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(function0) ? 131072 : 65536;
        }
        int i7 = i5 & 64;
        if (i7 != 0) {
            i6 |= 1572864;
            str3 = str;
        } else {
            str3 = str;
            if ((i4 & 1572864) == 0) {
                i6 |= composerStartRestartGroup.changed(str3) ? 1048576 : 524288;
            }
        }
        int i8 = i5 & 128;
        if (i8 != 0) {
            i6 |= 12582912;
            str4 = str2;
        } else {
            str4 = str2;
            if ((i4 & 12582912) == 0) {
                i6 |= composerStartRestartGroup.changed(str4) ? 8388608 : 4194304;
            }
        }
        if (!composerStartRestartGroup.shouldExecute((i6 & 4793491) != 4793490, i6 & 1)) {
            function2 = function1;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            str5 = str4;
            str6 = str3;
        } else {
            String str7 = i7 != 0 ? "DropdownButton" : str3;
            if (i8 != 0) {
                str4 = "DropdownMenu";
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1116201449, i6, -1, "com.box.android.base.compose.DropdownButton (ItemListingScreenConfigBar.kt:221)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1072221077, "CC(remember):ItemListingScreenConfigBar.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            RoundedCornerShape roundedCornerShapeM1573RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(8));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            String str8 = str4;
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1928911128, "C230@8883L6,232@9003L91,225@8671L988,257@9802L48,254@9669L882:ItemListingScreenConfigBar.kt#vejmn0");
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            String str9 = str7;
            RoundedCornerShape roundedCornerShape = roundedCornerShapeM1573RoundedCornerShape0680j_4;
            Modifier modifierClip = ClipKt.clip(BackgroundKt.m588backgroundbw27NRU(PaddingKt.m1220paddingVpY3zN4$default(TestTagKt.testTag(Modifier.INSTANCE, str7), Dp.m9687constructorimpl(6), 0.0f, 2, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11530getItemListingContentBackground0d7_KjU(), roundedCornerShape), roundedCornerShape);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447687426, "CC(remember):ItemListingScreenConfigBar.kt#9igjgp");
            boolean z = (458752 & i6) == 131072;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.compose.ItemListingScreenConfigBarKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ItemListingScreenConfigBarKt.DropdownButton$lambda$3$0$0(function0, mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float f = 10;
            Modifier modifierM1219paddingVpY3zN4 = PaddingKt.m1219paddingVpY3zN4(ClickableKt.m632clickableoSLSa3U$default(modifierClip, false, null, null, null, (Function0) objRememberedValue2, 15, null), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1219paddingVpY3zN4);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1885210801, "C239@9204L31,241@9327L6,238@9182L176,244@9372L28,248@9495L48,250@9618L6,246@9414L235:ItemListingScreenConfigBar.kt#vejmn0");
            String str10 = str8;
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(i, composerStartRestartGroup, i6 & 14), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium16(), composerStartRestartGroup, 0, 12582912, 131066);
            SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composerStartRestartGroup, 6);
            float f2 = 16;
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(i3, composerStartRestartGroup, (i6 >> 12) & 14), "", SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f2)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), composerStartRestartGroup, Painter.$stable | 432, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, str10);
            boolean zDropdownButton$lambda$1 = DropdownButton$lambda$1(mutableState);
            long jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(2))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f2))) << 32));
            composerStartRestartGroup.startReplaceGroup(-1447656839);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*265@10157L112");
            List<Integer> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            final int i9 = 0;
            for (Object obj : list2) {
                int i10 = i9 + 1;
                if (i9 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                int iIntValue = ((Number) obj).intValue();
                boolean z2 = i9 == i2;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 810512146, "CC(remember):ItemListingScreenConfigBar.kt#9igjgp");
                String str11 = str10;
                boolean zChanged = ((i6 & 7168) == 2048) | composerStartRestartGroup.changed(i9);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.base.compose.ItemListingScreenConfigBarKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ItemListingScreenConfigBarKt.DropdownButton$lambda$3$2$0$0(function1, i9, mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Function0 function3 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                arrayList.add(new PopupMenuItem(iIntValue, function3, (Integer) null, z2 ? Integer.valueOf(i3) : null, (PaddingValues) null, false, 48, (DefaultConstructorMarker) null));
                i9 = i10;
                str10 = str11;
            }
            function2 = function1;
            String str12 = str10;
            ArrayList arrayList2 = arrayList;
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447661901, "CC(remember):ItemListingScreenConfigBar.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: com.box.android.base.compose.ItemListingScreenConfigBarKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ItemListingScreenConfigBarKt.DropdownButton$lambda$3$3$0(mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxPopupMenuKt.m11733BoxPopupMenuUTokNlU(zDropdownButton$lambda$1, (Function0) objRememberedValue4, arrayList2, modifierTestTag, null, jM9743constructorimpl, composerStartRestartGroup, 196656, 16);
            composer2 = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str6 = str9;
            str5 = str12;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function1<? super Integer, Unit> function4 = function2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemListingScreenConfigBarKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return ItemListingScreenConfigBarKt.DropdownButton$lambda$4(i, list, i2, function4, i3, function0, str6, str5, i4, i5, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final boolean DropdownButton$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void DropdownButton$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownButton$lambda$3$0$0(Function0 function0, MutableState mutableState) {
        DropdownButton$lambda$2(mutableState, true);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownButton$lambda$3$3$0(MutableState mutableState) {
        DropdownButton$lambda$2(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownButton$lambda$3$2$0$0(Function1 function1, int i, MutableState mutableState) {
        function1.invoke(Integer.valueOf(i));
        DropdownButton$lambda$2(mutableState, false);
        return Unit.INSTANCE;
    }

    private static final void BoxItemListConfigBarButtonWrapper(final Function2<? super Composer, ? super Integer, Unit> function2, final String str, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Modifier.Companion companionM604borderxT4_qwU;
        Composer composerStartRestartGroup = composer.startRestartGroup(1915574898);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxItemListConfigBarButtonWrapper)N(content,testTag,onClick)288@10870L6,291@11039L11,284@10747L481:ItemListingScreenConfigBar.kt#vejmn0");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1915574898, i3, -1, "com.box.android.base.compose.BoxItemListConfigBarButtonWrapper (ItemListingScreenConfigBar.kt:282)");
            }
            RoundedCornerShape roundedCornerShapeM1573RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(6));
            Modifier modifierM632clickableoSLSa3U$default = ClickableKt.m632clickableoSLSa3U$default(ClipKt.clip(BackgroundKt.m588backgroundbw27NRU(SizeKt.m1252height3ABfNKs(TestTagKt.testTag(Modifier.INSTANCE, str), Dp.m9687constructorimpl(36)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11530getItemListingContentBackground0d7_KjU(), roundedCornerShapeM1573RoundedCornerShape0680j_4), roundedCornerShapeM1573RoundedCornerShape0680j_4), false, null, null, null, function0, 15, null);
            if (!BoxTheme.INSTANCE.isDarkTheme(composerStartRestartGroup, 6)) {
                companionM604borderxT4_qwU = BorderKt.m604borderxT4_qwU(Modifier.INSTANCE, Dp.m9687constructorimpl(1), BoxColorPalette.INSTANCE.m11363getBOX_GRAY_100d7_KjU(), roundedCornerShapeM1573RoundedCornerShape0680j_4);
            } else {
                companionM604borderxT4_qwU = Modifier.INSTANCE;
            }
            Modifier modifierM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(modifierM632clickableoSLSa3U$default.then(companionM604borderxT4_qwU), Dp.m9687constructorimpl(8));
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1277796578, "C296@11213L9:ItemListingScreenConfigBar.kt#vejmn0");
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i3 & 14));
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemListingScreenConfigBarKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemListingScreenConfigBarKt.BoxItemListConfigBarButtonWrapper$lambda$2(function2, str, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void ItemListingScreenConfigBarPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1233431656);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ItemListingScreenConfigBarPreview)306@11388L61,309@11483L54,313@11572L75,321@11844L6,318@11758L1213:ItemListingScreenConfigBar.kt#vejmn0");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1233431656, i, -1, "com.box.android.base.compose.ItemListingScreenConfigBarPreview (ItemListingScreenConfigBar.kt:305)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 83154389, "CC(remember):ItemListingScreenConfigBar.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ItemsScreenMode.LIST, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 83157422, "CC(remember):ItemListingScreenConfigBar.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(R.string.name), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 83160291, "CC(remember):ItemListingScreenConfigBar.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(LocalSortPreferences.SortOrder.ASC, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final List listListOf = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.string.name), Integer.valueOf(R.string.date_updated), Integer.valueOf(R.string.views), Integer.valueOf(R.string.size)});
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(400)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 788559514, "C328@12159L3,329@12192L78,332@12307L276,340@12666L2,341@12701L211,323@11882L1083:ItemListingScreenConfigBar.kt#vejmn0");
            ItemsScreenMode itemsScreenModeItemListingScreenConfigBarPreview$lambda$1 = ItemListingScreenConfigBarPreview$lambda$1(mutableState);
            int iItemListingScreenConfigBarPreview$lambda$4 = ItemListingScreenConfigBarPreview$lambda$4(mutableState2);
            LocalSortPreferences.SortOrder sortOrderItemListingScreenConfigBarPreview$lambda$7 = ItemListingScreenConfigBarPreview$lambda$7(mutableState3);
            int i2 = R.string.search;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1549465841, "CC(remember):ItemListingScreenConfigBar.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: com.box.android.base.compose.ItemListingScreenConfigBarKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function0 function0 = (Function0) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1549466972, "CC(remember):ItemListingScreenConfigBar.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(listListOf);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.box.android.base.compose.ItemListingScreenConfigBarKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ItemListingScreenConfigBarKt.ItemListingScreenConfigBarPreview$lambda$9$1$0(listListOf, mutableState2, ((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            Function1 function1 = (Function1) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1549470850, "CC(remember):ItemListingScreenConfigBar.kt#9igjgp");
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function0() { // from class: com.box.android.base.compose.ItemListingScreenConfigBarKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ItemListingScreenConfigBarKt.ItemListingScreenConfigBarPreview$lambda$9$2$0(mutableState3);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            Function0 function2 = (Function0) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1549482064, "CC(remember):ItemListingScreenConfigBar.kt#9igjgp");
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Function0() { // from class: com.box.android.base.compose.ItemListingScreenConfigBarKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            Function0 function3 = (Function0) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1549483393, "CC(remember):ItemListingScreenConfigBar.kt#9igjgp");
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function0() { // from class: com.box.android.base.compose.ItemListingScreenConfigBarKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ItemListingScreenConfigBarKt.ItemListingScreenConfigBarPreview$lambda$9$4$0(mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ItemListingScreenConfigBar(null, itemsScreenModeItemListingScreenConfigBarPreview$lambda$1, iItemListingScreenConfigBarPreview$lambda$4, sortOrderItemListingScreenConfigBarPreview$lambda$7, listListOf, function0, function1, function2, i2, function3, true, (Function0) objRememberedValue8, composerStartRestartGroup, 818085888, 54, 1);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemListingScreenConfigBarKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemListingScreenConfigBarKt.ItemListingScreenConfigBarPreview$lambda$10(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final ItemsScreenMode ItemListingScreenConfigBarPreview$lambda$1(MutableState<ItemsScreenMode> mutableState) {
        return mutableState.getValue();
    }

    private static final int ItemListingScreenConfigBarPreview$lambda$4(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    private static final void ItemListingScreenConfigBarPreview$lambda$5(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    private static final LocalSortPreferences.SortOrder ItemListingScreenConfigBarPreview$lambda$7(MutableState<LocalSortPreferences.SortOrder> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemListingScreenConfigBarPreview$lambda$9$1$0(List list, MutableState mutableState, int i) {
        ItemListingScreenConfigBarPreview$lambda$5(mutableState, ((Number) list.get(i)).intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemListingScreenConfigBarPreview$lambda$9$2$0(MutableState mutableState) {
        LocalSortPreferences.SortOrder sortOrder;
        if (ItemListingScreenConfigBarPreview$lambda$7(mutableState) == LocalSortPreferences.SortOrder.ASC) {
            sortOrder = LocalSortPreferences.SortOrder.DESC;
        } else {
            sortOrder = LocalSortPreferences.SortOrder.ASC;
        }
        mutableState.setValue(sortOrder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemListingScreenConfigBarPreview$lambda$9$4$0(MutableState mutableState) {
        ItemsScreenMode itemsScreenMode;
        if (ItemListingScreenConfigBarPreview$lambda$1(mutableState) == ItemsScreenMode.LIST) {
            itemsScreenMode = ItemsScreenMode.GRID;
        } else {
            itemsScreenMode = ItemsScreenMode.LIST;
        }
        mutableState.setValue(itemsScreenMode);
        return Unit.INSTANCE;
    }

    private static final void SortOptionsButtonPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1789991350);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SortOptionsButtonPreview)356@13072L42,357@13148L63,364@13544L3,365@13573L52,368@13658L111,360@13354L421:ItemListingScreenConfigBar.kt#vejmn0");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1789991350, i, -1, "com.box.android.base.compose.SortOptionsButtonPreview (ItemListingScreenConfigBar.kt:355)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2100196416, "CC(remember):ItemListingScreenConfigBar.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(R.string.name), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2100193963, "CC(remember):ItemListingScreenConfigBar.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(LocalSortPreferences.SortOrder.ASC, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final List listListOf = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.string.name), Integer.valueOf(R.string.date_updated)});
            final LocalSortPreferences.SortOrder[] sortOrderArr = (LocalSortPreferences.SortOrder[]) EntriesMappings.entries$0.toArray(new LocalSortPreferences.SortOrder[0]);
            int iSortOptionsButtonPreview$lambda$1 = SortOptionsButtonPreview$lambda$1(mutableState);
            LocalSortPreferences.SortOrder sortOrderSortOptionsButtonPreview$lambda$4 = SortOptionsButtonPreview$lambda$4(mutableState2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2100181351, "CC(remember):ItemListingScreenConfigBar.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.base.compose.ItemListingScreenConfigBarKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function0 function0 = (Function0) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2100180374, "CC(remember):ItemListingScreenConfigBar.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(listListOf);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.box.android.base.compose.ItemListingScreenConfigBarKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ItemListingScreenConfigBarKt.SortOptionsButtonPreview$lambda$7$0(listListOf, mutableState, ((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function1 function1 = (Function1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2100177595, "CC(remember):ItemListingScreenConfigBar.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(sortOrderArr);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: com.box.android.base.compose.ItemListingScreenConfigBarKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ItemListingScreenConfigBarKt.SortOptionsButtonPreview$lambda$8$0(sortOrderArr, mutableState2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SortOptionsButton(iSortOptionsButtonPreview$lambda$1, sortOrderSortOptionsButtonPreview$lambda$4, listListOf, function0, function1, (Function0) objRememberedValue5, composerStartRestartGroup, 3072);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemListingScreenConfigBarKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemListingScreenConfigBarKt.SortOptionsButtonPreview$lambda$9(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final int SortOptionsButtonPreview$lambda$1(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    private static final void SortOptionsButtonPreview$lambda$2(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    private static final LocalSortPreferences.SortOrder SortOptionsButtonPreview$lambda$4(MutableState<LocalSortPreferences.SortOrder> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SortOptionsButtonPreview$lambda$7$0(List list, MutableState mutableState, int i) {
        SortOptionsButtonPreview$lambda$2(mutableState, ((Number) list.get(i)).intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SortOptionsButtonPreview$lambda$8$0(LocalSortPreferences.SortOrder[] sortOrderArr, MutableState mutableState) {
        mutableState.setValue(sortOrderArr[SortOptionsButtonPreview$lambda$4(mutableState).ordinal() + (1 % sortOrderArr.length)]);
        return Unit.INSTANCE;
    }

    private static final void FilterOptionsButtonPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-130690416);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FilterOptionsButtonPreview)377@13872L56,382@14128L26,383@14188L3,379@14009L188:ItemListingScreenConfigBar.kt#vejmn0");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-130690416, i, -1, "com.box.android.base.compose.FilterOptionsButtonPreview (ItemListingScreenConfigBar.kt:376)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1039436376, "CC(remember):ItemListingScreenConfigBar.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(R.string.all_recents_filter), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final List listListOf = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.string.all_recents_filter), Integer.valueOf(R.string.shared_with)});
            int iFilterOptionsButtonPreview$lambda$1 = FilterOptionsButtonPreview$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1039428214, "CC(remember):ItemListingScreenConfigBar.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(listListOf);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.base.compose.ItemListingScreenConfigBarKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ItemListingScreenConfigBarKt.FilterOptionsButtonPreview$lambda$3$0(listListOf, mutableState, ((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function1 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1039426317, "CC(remember):ItemListingScreenConfigBar.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.base.compose.ItemListingScreenConfigBarKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            FilterOptionsButon(iFilterOptionsButtonPreview$lambda$1, listListOf, function1, (Function0) objRememberedValue3, composerStartRestartGroup, 3072);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemListingScreenConfigBarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemListingScreenConfigBarKt.FilterOptionsButtonPreview$lambda$5(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final int FilterOptionsButtonPreview$lambda$1(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    private static final void FilterOptionsButtonPreview$lambda$2(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilterOptionsButtonPreview$lambda$3$0(List list, MutableState mutableState, int i) {
        FilterOptionsButtonPreview$lambda$2(mutableState, ((Number) list.get(i)).intValue());
        return Unit.INSTANCE;
    }
}
