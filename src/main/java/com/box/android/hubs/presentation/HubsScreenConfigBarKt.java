package com.box.android.hubs.presentation;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import com.box.android.base.compose.ItemListingScreenConfigBarKt;
import com.box.android.domain.localrepo.LocalSortPreferences;
import com.box.android.domain.models.ItemsScreenMode;
import com.box.android.domain.models.hubs.HubsDirection;
import com.box.android.domain.models.hubs.HubsSort;
import com.box.android.hubs.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HubsScreenConfigBar.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u001ay\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001aM\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\u0013\u001a\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0005H\u0002¨\u0006\u0016"}, d2 = {"HubsScreenConfigBar", "", "itemsScreenMode", "Lcom/box/android/domain/models/ItemsScreenMode;", "sortBy", "Lcom/box/android/domain/models/hubs/HubsSort;", "direction", "Lcom/box/android/domain/models/hubs/HubsDirection;", "onSortButtonClicked", "Lkotlin/Function0;", "sortByChanged", "Lkotlin/Function1;", "sortDirectionToggled", "onSearchBarClicked", "toggleScreenMode", "shouldShowSearchButton", "", "(Lcom/box/android/domain/models/ItemsScreenMode;Lcom/box/android/domain/models/hubs/HubsSort;Lcom/box/android/domain/models/hubs/HubsDirection;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "HubsSortOnlyConfigBar", "(Lcom/box/android/domain/models/hubs/HubsSort;Lcom/box/android/domain/models/hubs/HubsDirection;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "toLocalizedStringResource", "", "hubs_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class HubsScreenConfigBarKt {

    /* JADX INFO: compiled from: HubsScreenConfigBar.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[HubsDirection.values().length];
            try {
                iArr[HubsDirection.ASC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HubsDirection.DESC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[HubsSort.values().length];
            try {
                iArr2[HubsSort.Name.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[HubsSort.Views.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[HubsSort.DateUpdated.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubsScreenConfigBar$lambda$2(ItemsScreenMode itemsScreenMode, HubsSort hubsSort, HubsDirection hubsDirection, Function0 function0, Function1 function1, Function0 function2, Function0 function3, Function0 function4, boolean z, int i, Composer composer, int i2) {
        HubsScreenConfigBar(itemsScreenMode, hubsSort, hubsDirection, function0, function1, function2, function3, function4, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubsSortOnlyConfigBar$lambda$1(HubsSort hubsSort, HubsDirection hubsDirection, Function0 function0, Function1 function1, Function0 function2, int i, Composer composer, int i2) {
        HubsSortOnlyConfigBar(hubsSort, hubsDirection, function0, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void HubsScreenConfigBar(final ItemsScreenMode itemsScreenMode, final HubsSort sortBy, final HubsDirection direction, final Function0<Unit> onSortButtonClicked, final Function1<? super HubsSort, Unit> sortByChanged, final Function0<Unit> sortDirectionToggled, final Function0<Unit> onSearchBarClicked, final Function0<Unit> toggleScreenMode, final boolean z, Composer composer, final int i) {
        int i2;
        boolean z2;
        LocalSortPreferences.SortOrder sortOrder;
        Intrinsics.checkNotNullParameter(itemsScreenMode, "itemsScreenMode");
        Intrinsics.checkNotNullParameter(sortBy, "sortBy");
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(onSortButtonClicked, "onSortButtonClicked");
        Intrinsics.checkNotNullParameter(sortByChanged, "sortByChanged");
        Intrinsics.checkNotNullParameter(sortDirectionToggled, "sortDirectionToggled");
        Intrinsics.checkNotNullParameter(onSearchBarClicked, "onSearchBarClicked");
        Intrinsics.checkNotNullParameter(toggleScreenMode, "toggleScreenMode");
        Composer composerStartRestartGroup = composer.startRestartGroup(380443124);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HubsScreenConfigBar)N(itemsScreenMode,sortBy,direction,onSortButtonClicked,sortByChanged,sortDirectionToggled,onSearchBarClicked,toggleScreenMode,shouldShowSearchButton)41@1652L51,34@1244L718:HubsScreenConfigBar.kt#l88pwb");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(itemsScreenMode.ordinal()) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(sortBy.ordinal()) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(direction.ordinal()) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onSortButtonClicked) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(sortByChanged) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(sortDirectionToggled) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onSearchBarClicked) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(toggleScreenMode) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            z2 = z;
            i2 |= composerStartRestartGroup.changed(z2) ? 67108864 : 33554432;
        } else {
            z2 = z;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 38347923) != 38347922, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(380443124, i2, -1, "com.box.android.hubs.presentation.HubsScreenConfigBar (HubsScreenConfigBar.kt:28)");
            }
            int i3 = WhenMappings.$EnumSwitchMapping$0[direction.ordinal()];
            if (i3 == 1) {
                sortOrder = LocalSortPreferences.SortOrder.ASC;
            } else {
                if (i3 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                sortOrder = LocalSortPreferences.SortOrder.DESC;
            }
            Modifier modifierM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(16));
            int localizedStringResource = toLocalizedStringResource(sortBy);
            EnumEntries<HubsSort> entries = HubsSort.getEntries();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries, 10));
            Iterator<HubsSort> it = entries.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(toLocalizedStringResource(it.next())));
            }
            ArrayList arrayList2 = arrayList;
            int i4 = R.string.search_hubs;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 533651847, "CC(remember):HubsScreenConfigBar.kt#9igjgp");
            boolean z3 = (57344 & i2) == 16384;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.hubs.presentation.HubsScreenConfigBarKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return HubsScreenConfigBarKt.HubsScreenConfigBar$lambda$1$0(sortByChanged, ((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i5 = i2 << 6;
            ItemListingScreenConfigBarKt.ItemListingScreenConfigBar(modifierM1218padding3ABfNKs, itemsScreenMode, localizedStringResource, sortOrder, arrayList2, onSortButtonClicked, (Function1) objRememberedValue, sortDirectionToggled, i4, onSearchBarClicked, z2, toggleScreenMode, composerStartRestartGroup, ((i2 << 3) & 112) | 6 | (i5 & 458752) | (i5 & 29360128) | ((i2 << 9) & C.ENCODING_PCM_DOUBLE), ((i2 >> 24) & 14) | ((i2 >> 18) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.hubs.presentation.HubsScreenConfigBarKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HubsScreenConfigBarKt.HubsScreenConfigBar$lambda$2(itemsScreenMode, sortBy, direction, onSortButtonClicked, sortByChanged, sortDirectionToggled, onSearchBarClicked, toggleScreenMode, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubsScreenConfigBar$lambda$1$0(Function1 function1, int i) {
        function1.invoke(HubsSort.getEntries().get(i));
        return Unit.INSTANCE;
    }

    public static final void HubsSortOnlyConfigBar(final HubsSort sortBy, final HubsDirection direction, final Function0<Unit> onSortButtonClicked, final Function1<? super HubsSort, Unit> sortByChanged, final Function0<Unit> sortDirectionToggled, Composer composer, final int i) {
        int i2;
        LocalSortPreferences.SortOrder sortOrder;
        Intrinsics.checkNotNullParameter(sortBy, "sortBy");
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(onSortButtonClicked, "onSortButtonClicked");
        Intrinsics.checkNotNullParameter(sortByChanged, "sortByChanged");
        Intrinsics.checkNotNullParameter(sortDirectionToggled, "sortDirectionToggled");
        Composer composerStartRestartGroup = composer.startRestartGroup(896269287);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HubsSortOnlyConfigBar)N(sortBy,direction,onSortButtonClicked,sortByChanged,sortDirectionToggled)63@2358L477:HubsScreenConfigBar.kt#l88pwb");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(sortBy.ordinal()) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(direction.ordinal()) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onSortButtonClicked) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(sortByChanged) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(sortDirectionToggled) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(896269287, i2, -1, "com.box.android.hubs.presentation.HubsSortOnlyConfigBar (HubsScreenConfigBar.kt:57)");
            }
            int i3 = WhenMappings.$EnumSwitchMapping$0[direction.ordinal()];
            if (i3 == 1) {
                sortOrder = LocalSortPreferences.SortOrder.ASC;
            } else {
                if (i3 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                sortOrder = LocalSortPreferences.SortOrder.DESC;
            }
            Modifier modifierM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(8));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1883470885, "C69@2711L51,64@2396L433:HubsScreenConfigBar.kt#l88pwb");
            int localizedStringResource = toLocalizedStringResource(sortBy);
            EnumEntries<HubsSort> entries = HubsSort.getEntries();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries, 10));
            Iterator<HubsSort> it = entries.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(toLocalizedStringResource(it.next())));
            }
            ArrayList arrayList2 = arrayList;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 892050816, "CC(remember):HubsScreenConfigBar.kt#9igjgp");
            boolean z = (i2 & 7168) == 2048;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.hubs.presentation.HubsScreenConfigBarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return HubsScreenConfigBarKt.HubsSortOnlyConfigBar$lambda$0$1$0(sortByChanged, ((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ItemListingScreenConfigBarKt.SortOptionsButton(localizedStringResource, sortOrder, arrayList2, onSortButtonClicked, (Function1) objRememberedValue, sortDirectionToggled, composerStartRestartGroup, 465920 & (i2 << 3));
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.hubs.presentation.HubsScreenConfigBarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HubsScreenConfigBarKt.HubsSortOnlyConfigBar$lambda$1(sortBy, direction, onSortButtonClicked, sortByChanged, sortDirectionToggled, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HubsSortOnlyConfigBar$lambda$0$1$0(Function1 function1, int i) {
        function1.invoke(HubsSort.getEntries().get(i));
        return Unit.INSTANCE;
    }

    private static final int toLocalizedStringResource(HubsSort hubsSort) {
        int i = WhenMappings.$EnumSwitchMapping$1[hubsSort.ordinal()];
        if (i == 1) {
            return R.string.name;
        }
        if (i == 2) {
            return R.string.views;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return R.string.date_updated;
    }
}
