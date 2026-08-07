package com.box.android.browse.cpl.browse;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.R;
import com.box.android.base.compose.ItemListingScreenConfigBarKt;
import com.box.android.browse.cpl.helpers.ItemsFilter;
import com.box.android.browse.cpl.itemsList.FilesDisplayConfigReducer;
import com.box.android.cpl.Store;
import com.box.android.domain.localrepo.LocalSortPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilesListingConfigBar.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0007¢\u0006\u0002\u0010\b\u001a)\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0007¢\u0006\u0002\u0010\b\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\fH\u0002¨\u0006\r²\u0006\n\u0010\u000e\u001a\u00020\u0006X\u008a\u0084\u0002²\u0006\n\u0010\u000e\u001a\u00020\u0006X\u008a\u0084\u0002"}, d2 = {"SortFilesConfigBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$State;", "Lcom/box/android/browse/cpl/itemsList/FilesDisplayConfigReducer$Action;", "(Landroidx/compose/ui/Modifier;Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "FilterFilesConfigBar", "toLocalizedStringResource", "", "Lcom/box/android/domain/localrepo/LocalSortPreferences$SortBy;", "browse_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FilesListingConfigBarKt {

    /* JADX INFO: compiled from: FilesListingConfigBar.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<LocalSortPreferences.SortBy> entries$0 = EnumEntriesKt.enumEntries(LocalSortPreferences.SortBy.values());
    }

    /* JADX INFO: compiled from: FilesListingConfigBar.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LocalSortPreferences.SortBy.values().length];
            try {
                iArr[LocalSortPreferences.SortBy.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LocalSortPreferences.SortBy.SIZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LocalSortPreferences.SortBy.MODIFIED_AT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilterFilesConfigBar$lambda$2(Modifier modifier, Store store, int i, Composer composer, int i2) {
        FilterFilesConfigBar(modifier, store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SortFilesConfigBar$lambda$2(Modifier modifier, Store store, int i, Composer composer, int i2) {
        SortFilesConfigBar(modifier, store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SortFilesConfigBar(final Modifier modifier, final Store<FilesDisplayConfigReducer.State, FilesDisplayConfigReducer.Action> store, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(-681736590);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SortFilesConfigBar)N(modifier,store)18@835L29,21@924L733:FilesListingConfigBar.kt#89mwni");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(store) ? 32 : 16;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-681736590, i3, -1, "com.box.android.browse.cpl.browse.SortFilesConfigBar (FilesListingConfigBar.kt:17)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            final EnumEntries<LocalSortPreferences.SortBy> enumEntries = EntriesMappings.entries$0;
            Alignment centerStart = Alignment.INSTANCE.getCenterStart();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(centerStart, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 330976802, "C26@1271L91,29@1392L115,32@1544L97,22@990L661:FilesListingConfigBar.kt#89mwni");
            int localizedStringResource = toLocalizedStringResource(SortFilesConfigBar$lambda$0(stateCollectAsStateWithLifecycle).getSelectedSortBy());
            LocalSortPreferences.SortOrder selectedSortOrder = SortFilesConfigBar$lambda$0(stateCollectAsStateWithLifecycle).getSelectedSortOrder();
            EnumEntries<LocalSortPreferences.SortBy> enumEntries2 = enumEntries;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(enumEntries2, 10));
            Iterator<LocalSortPreferences.SortBy> it = enumEntries2.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(toLocalizedStringResource(it.next())));
            }
            ArrayList arrayList2 = arrayList;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2067524889, "CC(remember):FilesListingConfigBar.kt#9igjgp");
            int i4 = i3 & 112;
            boolean z = i4 == 32;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.browse.cpl.browse.FilesListingConfigBarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilesListingConfigBarKt.SortFilesConfigBar$lambda$1$1$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2067520993, "CC(remember):FilesListingConfigBar.kt#9igjgp");
            boolean zChangedInstance = (i4 == 32) | composerStartRestartGroup.changedInstance(enumEntries);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.browse.cpl.browse.FilesListingConfigBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FilesListingConfigBarKt.SortFilesConfigBar$lambda$1$2$0(store, enumEntries, ((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function1 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2067516147, "CC(remember):FilesListingConfigBar.kt#9igjgp");
            boolean z2 = i4 == 32;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.browse.cpl.browse.FilesListingConfigBarKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilesListingConfigBarKt.SortFilesConfigBar$lambda$1$3$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ItemListingScreenConfigBarKt.SortOptionsButton(localizedStringResource, selectedSortOrder, arrayList2, function0, function1, (Function0) objRememberedValue3, composerStartRestartGroup, 0);
            composerStartRestartGroup = composerStartRestartGroup;
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.FilesListingConfigBarKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesListingConfigBarKt.SortFilesConfigBar$lambda$2(modifier, store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SortFilesConfigBar$lambda$1$1$0(Store store) {
        store.send(FilesDisplayConfigReducer.Action.SortingClicked.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit SortFilesConfigBar$lambda$1$2$0(Store store, EnumEntries enumEntries, int i) {
        store.send(new FilesDisplayConfigReducer.Action.SortByChanged((LocalSortPreferences.SortBy) enumEntries.get(i)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SortFilesConfigBar$lambda$1$3$0(Store store) {
        store.send(FilesDisplayConfigReducer.Action.SortDirectionToggled.INSTANCE);
        return Unit.INSTANCE;
    }

    public static final void FilterFilesConfigBar(final Modifier modifier, final Store<FilesDisplayConfigReducer.State, FilesDisplayConfigReducer.Action> store, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(317769036);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FilterFilesConfigBar)N(modifier,store)41@1830L29,51@2045L551:FilesListingConfigBar.kt#89mwni");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(store) ? 32 : 16;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(317769036, i3, -1, "com.box.android.browse.cpl.browse.FilterFilesConfigBar (FilesListingConfigBar.kt:40)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            final List listListOf = CollectionsKt.listOf((Object[]) new ItemsFilter[]{ItemsFilter.AllRecents.INSTANCE, ItemsFilter.BoxNotes.INSTANCE, ItemsFilter.SharedLinks.INSTANCE});
            ItemsFilter selectedFilter = FilterFilesConfigBar$lambda$0(stateCollectAsStateWithLifecycle).getSelectedFilter();
            Alignment centerStart = Alignment.INSTANCE.getCenterStart();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(centerStart, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2035111554, "C58@2416L164,55@2293L93,52@2111L479:FilesListingConfigBar.kt#89mwni");
            int stringRes = selectedFilter.getStringRes();
            List list = listListOf;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((ItemsFilter) it.next()).getStringRes()));
            }
            ArrayList arrayList2 = arrayList;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 904192010, "CC(remember):FilesListingConfigBar.kt#9igjgp");
            int i4 = i3 & 112;
            boolean z = i4 == 32;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.browse.cpl.browse.FilesListingConfigBarKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FilesListingConfigBarKt.FilterFilesConfigBar$lambda$1$1$0(listListOf, store, ((Integer) obj).intValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 904188003, "CC(remember):FilesListingConfigBar.kt#9igjgp");
            boolean z2 = i4 == 32;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.browse.cpl.browse.FilesListingConfigBarKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilesListingConfigBarKt.FilterFilesConfigBar$lambda$1$2$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ItemListingScreenConfigBarKt.FilterOptionsButon(stringRes, arrayList2, function1, (Function0) objRememberedValue2, composerStartRestartGroup, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.FilesListingConfigBarKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesListingConfigBarKt.FilterFilesConfigBar$lambda$2(modifier, store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilterFilesConfigBar$lambda$1$2$0(Store store) {
        store.send(FilesDisplayConfigReducer.Action.FilteringClicked.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilterFilesConfigBar$lambda$1$1$0(List list, Store store, int i) {
        store.send(new FilesDisplayConfigReducer.Action.FilterSelected((ItemsFilter) list.get(i)));
        return Unit.INSTANCE;
    }

    private static final int toLocalizedStringResource(LocalSortPreferences.SortBy sortBy) {
        int i = WhenMappings.$EnumSwitchMapping$0[sortBy.ordinal()];
        if (i == 1) {
            return R.string.name;
        }
        if (i == 2) {
            return R.string.size;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return R.string.date;
    }

    private static final FilesDisplayConfigReducer.State SortFilesConfigBar$lambda$0(State<FilesDisplayConfigReducer.State> state) {
        return state.getValue();
    }

    private static final FilesDisplayConfigReducer.State FilterFilesConfigBar$lambda$0(State<FilesDisplayConfigReducer.State> state) {
        return state.getValue();
    }
}
