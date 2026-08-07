package com.box.android.collections.presentation.navigationmodernization.collectionitemslist;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.pulltorefresh.PullToRefreshKt;
import androidx.compose.material3.pulltorefresh.PullToRefreshState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnVisibilityChangedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.EmptyItemsWithPullToRefreshWorkaroundKt;
import com.box.android.base.compose.BoxListViewItemKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.ItemStateScreensKt;
import com.box.android.base.compose.ItemsStateConfig;
import com.box.android.base.compose.SwipeableSnackbarHostKt;
import com.box.android.base.compose.analytics.AnalyticsUtilsKt;
import com.box.android.base.compose.divider.BoxItemListingDividerKt;
import com.box.android.base.compose.pulltorefresh.BoxPullToRefreshIndicatorKt;
import com.box.android.base.models.ClickActionsConfig;
import com.box.android.base.models.ListItemInfo;
import com.box.android.base.models.SecondaryActionType;
import com.box.android.base.presentation.components.snackbar.ErrorSnackbarKt;
import com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt;
import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.base.presentation.multiselect.MultiselectReducer;
import com.box.android.browse.cpl.itemsList.ItemReducer;
import com.box.android.collections.R;
import com.box.android.cpl.IdentifiedList;
import com.box.android.cpl.Store;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DomainErrorKt;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemModel;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CollectionItemsListScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u001ay\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u000526\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a\u0083\u0001\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00152\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u000526\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007¢\u0006\u0002\u0010\u001a\u001aW\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00162\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010\"\u001a)\u0010#\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00162\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010$\u001a9\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u001f2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010*\u001a\r\u0010+\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010,¨\u0006-²\u0006\n\u0010\u001c\u001a\u00020\u0016X\u008a\u0084\u0002²\u0006\n\u0010\u001c\u001a\u00020\u0016X\u008a\u0084\u0002"}, d2 = {"CollectionItemsListScreen", "", "viewModel", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListViewModel;", "onOpenItem", "Lkotlin/Function1;", "Lcom/box/android/domain/models/item/ItemModel;", "onOpenItemMoreActionsMenu", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "itemModel", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType;", "bottomSheetMenuType", "onGoBackClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListViewModel;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "CollectionItemsListContent", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$State;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action;", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "(Lcom/box/android/cpl/Store;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/runtime/Composer;II)V", "CollectionItemsListWithPullToRefresh", "state", "sendAction", "isRefreshing", "", "onSilentRefresh", "onPullToRefresh", "(Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$State;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "CollectionItemsList", "(Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$State;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "CollectionItem", "item", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$State;", "isSelecting", "isChecked", "(Lcom/box/android/browse/cpl/itemsList/ItemReducer$State;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "EmptyCollectionItemsListScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "collections_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CollectionItemsListScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItem$lambda$3(ItemReducer.State state, boolean z, boolean z2, Function1 function1, int i, Composer composer, int i2) {
        CollectionItem(state, z, z2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemsList$lambda$0(CollectionItemsListReducer.State state, Function1 function1, int i, Composer composer, int i2) {
        CollectionItemsList(state, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemsList$lambda$2(CollectionItemsListReducer.State state, Function1 function1, int i, Composer composer, int i2) {
        CollectionItemsList(state, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemsListContent$lambda$9(Store store, Function1 function1, Function2 function2, Modifier modifier, SnackbarHostState snackbarHostState, int i, int i2, Composer composer, int i3) {
        CollectionItemsListContent(store, function1, function2, modifier, snackbarHostState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemsListScreen$lambda$5(CollectionItemsListViewModel collectionItemsListViewModel, Function1 function1, Function2 function2, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CollectionItemsListScreen(collectionItemsListViewModel, function1, function2, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemsListWithPullToRefresh$lambda$2(CollectionItemsListReducer.State state, Function1 function1, boolean z, Function0 function0, Function0 function2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CollectionItemsListWithPullToRefresh(state, function1, z, function0, function2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EmptyCollectionItemsListScreenPreview$lambda$0(int i, Composer composer, int i2) {
        EmptyCollectionItemsListScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x008f  */
    /* JADX WARN: Code duplicated, block: B:45:0x0091  */
    /* JADX WARN: Code duplicated, block: B:48:0x009a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x009c  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:61:0x0101  */
    /* JADX WARN: Code duplicated, block: B:64:0x016d  */
    /* JADX WARN: Code duplicated, block: B:66:0x0172  */
    /* JADX WARN: Code duplicated, block: B:69:0x017c  */
    /* JADX WARN: Code duplicated, block: B:71:? A[RETURN, SYNTHETIC] */
    public static final void CollectionItemsListScreen(final CollectionItemsListViewModel viewModel, final Function1<? super ItemModel, Unit> onOpenItem, final Function2<? super ItemModel, ? super BottomSheetAttributes.BottomSheetMenuType, Unit> onOpenItemMoreActionsMenu, final Function0<Unit> onGoBackClick, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        final Store<CollectionItemsListReducer.State, CollectionItemsListReducer.Action> store;
        Object objRememberedValue;
        boolean zChanged;
        Object objRememberedValue2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(onOpenItem, "onOpenItem");
        Intrinsics.checkNotNullParameter(onOpenItemMoreActionsMenu, "onOpenItemMoreActionsMenu");
        Intrinsics.checkNotNullParameter(onGoBackClick, "onGoBackClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1643752117);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CollectionItemsListScreen)N(viewModel,onOpenItem,onOpenItemMoreActionsMenu,onGoBackClick,modifier)72@3679L29,73@3737L32,78@3868L90,78@3853L105,81@3983L84,84@4103L6,86@4176L647,75@3775L1048:CollectionItemsListScreen.kt#avvpft");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(viewModel) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onOpenItem) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onOpenItemMoreActionsMenu) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onGoBackClick) ? 2048 : 1024;
        }
        int i4 = i2 & 16;
        if (i4 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1643752117, i3, -1, "com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreen (CollectionItemsListScreen.kt:70)");
                }
                store = viewModel.getStore();
                final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -902167467, "CC(remember):CollectionItemsListScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new SnackbarHostState();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -902163217, "CC(remember):CollectionItemsListScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(store);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CollectionItemsListScreenKt.CollectionItemsListScreen$lambda$2$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifier5 = modifier4;
                ScaffoldKt.m4038ScaffoldTvnljyQ(AnalyticsUtilsKt.trackOnVisible(modifierFillMaxSize$default, null, (Function0) objRememberedValue2, composerStartRestartGroup, 0, 1), null, null, ComposableLambdaKt.rememberComposableLambda(1990710139, true, new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CollectionItemsListScreenKt.CollectionItemsListScreen$lambda$3(snackbarHostState, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, 0, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), 0L, WindowInsetsKt.WindowInsets(), ComposableLambdaKt.rememberComposableLambda(1348528708, true, new Function3() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return CollectionItemsListScreenKt.CollectionItemsListScreen$lambda$4(onGoBackClick, store, onOpenItem, onOpenItemMoreActionsMenu, snackbarHostState, stateCollectAsStateWithLifecycle, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805309440, 182);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CollectionItemsListScreenKt.CollectionItemsListScreen$lambda$5(viewModel, onOpenItem, onOpenItemMoreActionsMenu, onGoBackClick, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        modifier2 = modifier;
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1643752117, i3, -1, "com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreen (CollectionItemsListScreen.kt:70)");
            }
            store = viewModel.getStore();
            final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -902167467, "CC(remember):CollectionItemsListScreen.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final SnackbarHostState snackbarHostState2 = (SnackbarHostState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -902163217, "CC(remember):CollectionItemsListScreen.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(store);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CollectionItemsListScreenKt.CollectionItemsListScreen$lambda$2$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CollectionItemsListScreenKt.CollectionItemsListScreen$lambda$2$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifier6 = modifier4;
            ScaffoldKt.m4038ScaffoldTvnljyQ(AnalyticsUtilsKt.trackOnVisible(modifierFillMaxSize$default2, null, (Function0) objRememberedValue2, composerStartRestartGroup, 0, 1), null, null, ComposableLambdaKt.rememberComposableLambda(1990710139, true, new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionItemsListScreenKt.CollectionItemsListScreen$lambda$3(snackbarHostState2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, 0, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), 0L, WindowInsetsKt.WindowInsets(), ComposableLambdaKt.rememberComposableLambda(1348528708, true, new Function3() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CollectionItemsListScreenKt.CollectionItemsListScreen$lambda$4(onGoBackClick, store, onOpenItem, onOpenItemMoreActionsMenu, snackbarHostState2, stateCollectAsStateWithLifecycle2, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805309440, 182);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionItemsListScreenKt.CollectionItemsListScreen$lambda$5(viewModel, onOpenItem, onOpenItemMoreActionsMenu, onGoBackClick, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemsListScreen$lambda$2$0(Store store) {
        store.send(CollectionItemsListReducer.Action.ScreenViewed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemsListScreen$lambda$3(SnackbarHostState snackbarHostState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C82@3997L60:CollectionItemsListScreen.kt#avvpft");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1990710139, i, -1, "com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreen.<anonymous> (CollectionItemsListScreen.kt:82)");
            }
            SwipeableSnackbarHostKt.SwipeableSnackbarHost(snackbarHostState, null, composer, 6, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemsListScreen$lambda$4(Function0 function0, Store store, Function1 function1, Function2 function2, SnackbarHostState snackbarHostState, State state, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)87@4203L614:CollectionItemsListScreen.kt#avvpft");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1348528708, i2, -1, "com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreen.<anonymous> (CollectionItemsListScreen.kt:87)");
            }
            Modifier modifierPadding = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierPadding);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1300177472, "C92@4338L218,98@4569L238:CollectionItemsListScreen.kt#avvpft");
            BoxSimpleTopBarKt.BoxSimpleTopBar(CollectionItemsListScreen$lambda$0(state).getCollection().getName(), function0, WindowInsetsPadding_androidKt.statusBarsPadding(Modifier.INSTANCE), true, null, composer, 3072, 16);
            CollectionItemsListContent(store, function1, function2, null, snackbarHostState, composer, 24576, 8);
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

    /* JADX WARN: Code duplicated, block: B:101:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:103:0x020e  */
    /* JADX WARN: Code duplicated, block: B:104:0x0210  */
    /* JADX WARN: Code duplicated, block: B:107:0x0217  */
    /* JADX WARN: Code duplicated, block: B:109:0x021f  */
    /* JADX WARN: Code duplicated, block: B:112:0x0242  */
    /* JADX WARN: Code duplicated, block: B:113:0x0244  */
    /* JADX WARN: Code duplicated, block: B:116:0x024b  */
    /* JADX WARN: Code duplicated, block: B:118:0x0253  */
    /* JADX WARN: Code duplicated, block: B:121:0x0269  */
    /* JADX WARN: Code duplicated, block: B:122:0x026b  */
    /* JADX WARN: Code duplicated, block: B:125:0x0272  */
    /* JADX WARN: Code duplicated, block: B:127:0x027a  */
    /* JADX WARN: Code duplicated, block: B:130:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:132:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:133:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:135:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:136:0x02df  */
    /* JADX WARN: Code duplicated, block: B:139:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:141:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:144:0x0305  */
    /* JADX WARN: Code duplicated, block: B:145:0x0308  */
    /* JADX WARN: Code duplicated, block: B:148:0x030f  */
    /* JADX WARN: Code duplicated, block: B:150:0x0317  */
    /* JADX WARN: Code duplicated, block: B:152:0x0332  */
    /* JADX WARN: Code duplicated, block: B:156:0x035a  */
    /* JADX WARN: Code duplicated, block: B:157:0x035d  */
    /* JADX WARN: Code duplicated, block: B:160:0x0364  */
    /* JADX WARN: Code duplicated, block: B:161:0x0367  */
    /* JADX WARN: Code duplicated, block: B:164:0x036f  */
    /* JADX WARN: Code duplicated, block: B:165:0x0372  */
    /* JADX WARN: Code duplicated, block: B:168:0x037a  */
    /* JADX WARN: Code duplicated, block: B:170:0x0382  */
    /* JADX WARN: Code duplicated, block: B:173:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:175:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:177:0x03ba  */
    /* JADX WARN: Code duplicated, block: B:180:0x03c5  */
    /* JADX WARN: Code duplicated, block: B:182:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0076  */
    /* JADX WARN: Code duplicated, block: B:38:0x0079  */
    /* JADX WARN: Code duplicated, block: B:40:0x007d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0085  */
    /* JADX WARN: Code duplicated, block: B:43:0x0088  */
    /* JADX WARN: Code duplicated, block: B:48:0x0095  */
    /* JADX WARN: Code duplicated, block: B:49:0x0097  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:56:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:63:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:65:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:66:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:69:0x0104  */
    /* JADX WARN: Code duplicated, block: B:71:0x010c  */
    /* JADX WARN: Code duplicated, block: B:74:0x0131  */
    /* JADX WARN: Code duplicated, block: B:76:0x0137  */
    /* JADX WARN: Code duplicated, block: B:78:0x014c  */
    /* JADX WARN: Code duplicated, block: B:80:0x0161  */
    /* JADX WARN: Code duplicated, block: B:81:0x0163  */
    /* JADX WARN: Code duplicated, block: B:84:0x016a  */
    /* JADX WARN: Code duplicated, block: B:86:0x0172  */
    /* JADX WARN: Code duplicated, block: B:88:0x018b  */
    /* JADX WARN: Code duplicated, block: B:90:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:91:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:94:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:96:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:99:0x01e8  */
    public static final void CollectionItemsListContent(final Store<CollectionItemsListReducer.State, CollectionItemsListReducer.Action> store, final Function1<? super ItemModel, Unit> onOpenItem, final Function2<? super ItemModel, ? super BottomSheetAttributes.BottomSheetMenuType, Unit> onOpenItemMoreActionsMenu, Modifier modifier, SnackbarHostState snackbarHostState, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        SnackbarHostState snackbarHostState2;
        int i5;
        boolean z;
        final Modifier modifier3;
        final SnackbarHostState snackbarHostState3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        SnackbarHostState snackbarHostState4;
        Modifier modifier4;
        State stateCollectAsStateWithLifecycle;
        CollectionItemsListReducer.LoadingState loadingState;
        String str;
        int i6;
        boolean z2;
        CollectionItemsListScreenKt$CollectionItemsListContent$4$1 collectionItemsListScreenKt$CollectionItemsListContent$4$1RememberedValue;
        boolean z3;
        Object objRememberedValue;
        boolean z4;
        Object objRememberedValue2;
        boolean z5;
        SnackbarHostState snackbarHostState5;
        DomainError error;
        boolean z6;
        Object objRememberedValue3;
        boolean z7;
        Object objRememberedValue4;
        boolean z8;
        Object objRememberedValue5;
        boolean z9;
        boolean z10;
        Object objRememberedValue6;
        State state;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        CollectionItemsListScreenKt$CollectionItemsListContent$8$1 collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue;
        boolean z15;
        CollectionItemsListScreenKt$CollectionItemsListContent$1$1 collectionItemsListScreenKt$CollectionItemsListContent$1$1RememberedValue;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(onOpenItem, "onOpenItem");
        Intrinsics.checkNotNullParameter(onOpenItemMoreActionsMenu, "onOpenItemMoreActionsMenu");
        Composer composerStartRestartGroup = composer.startRestartGroup(364980391);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CollectionItemsListContent)N(store,onOpenItem,onOpenItemMoreActionsMenu,modifier,snackbarHostState)122@5419L29,179@7646L627,179@7608L665:CollectionItemsListScreen.kt#avvpft");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onOpenItem) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onOpenItemMoreActionsMenu) ? 256 : 128;
        }
        int i7 = i2 & 8;
        if (i7 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    snackbarHostState2 = snackbarHostState;
                    if (composerStartRestartGroup.changed(snackbarHostState2)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    snackbarHostState3 = snackbarHostState2;
                } else {
                    if (i7 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        snackbarHostState4 = null;
                    } else {
                        snackbarHostState4 = snackbarHostState2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(364980391, i3, -1, "com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListContent (CollectionItemsListScreen.kt:121)");
                    }
                    modifier4 = modifier2;
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    loadingState = CollectionItemsListContent$lambda$0(stateCollectAsStateWithLifecycle).getLoadingState();
                    if (Intrinsics.areEqual(loadingState, CollectionItemsListReducer.LoadingState.Loading.INSTANCE)) {
                        composerStartRestartGroup.startReplaceGroup(-1725844420);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "126@5595L87,126@5574L108,129@5695L46");
                        Unit unit = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441144706, "CC(remember):CollectionItemsListScreen.kt#9igjgp");
                        if ((i3 & 14) == 4) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        collectionItemsListScreenKt$CollectionItemsListContent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z15 || collectionItemsListScreenKt$CollectionItemsListContent$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            collectionItemsListScreenKt$CollectionItemsListContent$1$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$1$1(store, null);
                            composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) collectionItemsListScreenKt$CollectionItemsListContent$1$1RememberedValue, composerStartRestartGroup, 6);
                        ItemStateScreensKt.LoadingItemsScreen(null, true, composerStartRestartGroup, 48, 1);
                        composerStartRestartGroup.endReplaceGroup();
                        stateCollectAsStateWithLifecycle = stateCollectAsStateWithLifecycle;
                        str = "CC(remember):CollectionItemsListScreen.kt#9igjgp";
                        z5 = true;
                    } else {
                        if (loadingState instanceof CollectionItemsListReducer.LoadingState.Error) {
                            composerStartRestartGroup.startReplaceGroup(-1725583338);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "");
                            if (DomainErrorKt.isNetworkConnectionError(((CollectionItemsListReducer.LoadingState.Error) loadingState).getError())) {
                                composerStartRestartGroup.startReplaceGroup(-1725528065);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "135@5954L64,134@5896L188");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441133241, "CC(remember):CollectionItemsListScreen.kt#9igjgp");
                                if ((i3 & 14) == 4) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                if (!z10 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue6 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$2$0(store);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ItemStateScreensKt.NetworkConnectionError((Function0) objRememberedValue6, true, composerStartRestartGroup, 48, 0);
                                composerStartRestartGroup.endReplaceGroup();
                                str = "CC(remember):CollectionItemsListScreen.kt#9igjgp";
                                z9 = true;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-1725303997);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "140@6176L64,139@6122L184");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441126137, "CC(remember):CollectionItemsListScreen.kt#9igjgp");
                                if ((i3 & 14) == 4) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                if (!z8 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue5 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda11
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$3$0(store);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                z9 = true;
                                str = "CC(remember):CollectionItemsListScreen.kt#9igjgp";
                                ItemStateScreensKt.GenericErrorScreen((Function0) objRememberedValue5, true, 0, null, 0, null, composerStartRestartGroup, 48, 60);
                                composerStartRestartGroup = composerStartRestartGroup;
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            z5 = z9;
                        } else {
                            stateCollectAsStateWithLifecycle = stateCollectAsStateWithLifecycle;
                            str = "CC(remember):CollectionItemsListScreen.kt#9igjgp";
                            if (Intrinsics.areEqual(loadingState, CollectionItemsListReducer.LoadingState.Loaded.INSTANCE)) {
                                composerStartRestartGroup.startReplaceGroup(-1441147157);
                                composerStartRestartGroup.endReplaceGroup();
                                throw new NoWhenBranchMatchedException();
                            }
                            composerStartRestartGroup.startReplaceGroup(-1724989595);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "149@6502L11,151@6600L105,154@6741L104,147@6404L581");
                            CollectionItemsListReducer.State stateCollectionItemsListContent$lambda$0 = CollectionItemsListContent$lambda$0(stateCollectAsStateWithLifecycle);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441115758, str);
                            i6 = i3 & 14;
                            if (i6 == 4) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            collectionItemsListScreenKt$CollectionItemsListContent$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z2 || collectionItemsListScreenKt$CollectionItemsListContent$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                collectionItemsListScreenKt$CollectionItemsListContent$4$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$4$1(store);
                                composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$4$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Function1 function1 = (Function1) ((KFunction) collectionItemsListScreenKt$CollectionItemsListContent$4$1RememberedValue);
                            boolean zIsRefreshing = CollectionItemsListContent$lambda$0(stateCollectAsStateWithLifecycle).isRefreshing();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441112528, str);
                            if (i6 == 4) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda13
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$5$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            Function0 function0 = (Function0) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441108017, str);
                            if (i6 == 4) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!z4 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda14
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$6$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            z5 = true;
                            modifier4 = modifier4;
                            CollectionItemsListWithPullToRefresh(stateCollectionItemsListContent$lambda$0, function1, zIsRefreshing, function0, (Function0) objRememberedValue2, TestTagKt.testTag(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null), "CollectionItemsScreen"), composerStartRestartGroup, 0, 0);
                            composerStartRestartGroup = composerStartRestartGroup;
                            if (snackbarHostState4 != null) {
                                composerStartRestartGroup.startReplaceGroup(-1441097370);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                                error = CollectionItemsListContent$lambda$0(stateCollectAsStateWithLifecycle).getError();
                                if (error == null) {
                                    composerStartRestartGroup.startReplaceGroup(-1724345509);
                                    composerStartRestartGroup.endReplaceGroup();
                                    snackbarHostState5 = snackbarHostState4;
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(-1724345508);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "*167@7259L121,170@7418L114,164@7096L458");
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -257248134, str);
                                    if (i6 == 4) {
                                        z6 = true;
                                    } else {
                                        z6 = false;
                                    }
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (!z6 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue3 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda15
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$7$0$0(store);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                    }
                                    Function0 function2 = (Function0) objRememberedValue3;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -257243053, str);
                                    if (i6 == 4) {
                                        z7 = true;
                                    } else {
                                        z7 = false;
                                    }
                                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                    if (!z7 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue4 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda16
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$7$1$0(store);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    snackbarHostState5 = snackbarHostState4;
                                    ErrorSnackbarKt.ErrorSnackbar(error, snackbarHostState5, function2, (Function0) objRememberedValue4, composerStartRestartGroup, (i3 >> 9) & 112);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                            } else {
                                snackbarHostState5 = snackbarHostState4;
                                composerStartRestartGroup.startReplaceGroup(-1731366853);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        CollectionItemsListReducer.Route navigationRoute = CollectionItemsListContent$lambda$0(stateCollectAsStateWithLifecycle).getNavigationRoute();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441078534, str);
                        state = stateCollectAsStateWithLifecycle;
                        boolean zChanged = composerStartRestartGroup.changed(state);
                        if ((i3 & 112) == 32) {
                            z11 = z5;
                        } else {
                            z11 = false;
                        }
                        boolean z16 = zChanged | z11;
                        if ((i3 & 14) == 4) {
                            z12 = z5;
                        } else {
                            z12 = false;
                        }
                        boolean z17 = z16 | z12;
                        if ((i3 & 896) == 256) {
                            z13 = z5;
                        } else {
                            z13 = false;
                        }
                        z14 = z17 | z13;
                        collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z14 || collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$8$1(onOpenItem, store, onOpenItemMoreActionsMenu, state, null);
                            composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(navigationRoute, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue, composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        snackbarHostState3 = snackbarHostState5;
                        modifier3 = modifier4;
                    }
                    snackbarHostState5 = snackbarHostState4;
                    CollectionItemsListReducer.Route navigationRoute2 = CollectionItemsListContent$lambda$0(stateCollectAsStateWithLifecycle).getNavigationRoute();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441078534, str);
                    state = stateCollectAsStateWithLifecycle;
                    boolean zChanged2 = composerStartRestartGroup.changed(state);
                    if ((i3 & 112) == 32) {
                        z11 = z5;
                    } else {
                        z11 = false;
                    }
                    boolean z18 = zChanged2 | z11;
                    if ((i3 & 14) == 4) {
                        z12 = z5;
                    } else {
                        z12 = false;
                    }
                    boolean z19 = z18 | z12;
                    if ((i3 & 896) == 256) {
                        z13 = z5;
                    } else {
                        z13 = false;
                    }
                    z14 = z19 | z13;
                    collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z14) {
                        collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$8$1(onOpenItem, store, onOpenItemMoreActionsMenu, state, null);
                        composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue);
                    } else {
                        collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$8$1(onOpenItem, store, onOpenItemMoreActionsMenu, state, null);
                        composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(navigationRoute2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    snackbarHostState3 = snackbarHostState5;
                    modifier3 = modifier4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$9(store, onOpenItem, onOpenItemMoreActionsMenu, modifier3, snackbarHostState3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            snackbarHostState2 = snackbarHostState;
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                snackbarHostState3 = snackbarHostState2;
            } else {
                if (i7 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    snackbarHostState4 = null;
                } else {
                    snackbarHostState4 = snackbarHostState2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(364980391, i3, -1, "com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListContent (CollectionItemsListScreen.kt:121)");
                }
                modifier4 = modifier2;
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                loadingState = CollectionItemsListContent$lambda$0(stateCollectAsStateWithLifecycle).getLoadingState();
                if (Intrinsics.areEqual(loadingState, CollectionItemsListReducer.LoadingState.Loading.INSTANCE)) {
                    composerStartRestartGroup.startReplaceGroup(-1725844420);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "126@5595L87,126@5574L108,129@5695L46");
                    Unit unit2 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441144706, "CC(remember):CollectionItemsListScreen.kt#9igjgp");
                    if ((i3 & 14) == 4) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    collectionItemsListScreenKt$CollectionItemsListContent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z15) {
                        collectionItemsListScreenKt$CollectionItemsListContent$1$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$1$1(store, null);
                        composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$1$1RememberedValue);
                    } else {
                        collectionItemsListScreenKt$CollectionItemsListContent$1$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$1$1(store, null);
                        composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) collectionItemsListScreenKt$CollectionItemsListContent$1$1RememberedValue, composerStartRestartGroup, 6);
                    ItemStateScreensKt.LoadingItemsScreen(null, true, composerStartRestartGroup, 48, 1);
                    composerStartRestartGroup.endReplaceGroup();
                    stateCollectAsStateWithLifecycle = stateCollectAsStateWithLifecycle;
                    str = "CC(remember):CollectionItemsListScreen.kt#9igjgp";
                    z5 = true;
                } else {
                    if (loadingState instanceof CollectionItemsListReducer.LoadingState.Error) {
                        composerStartRestartGroup.startReplaceGroup(-1725583338);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        if (DomainErrorKt.isNetworkConnectionError(((CollectionItemsListReducer.LoadingState.Error) loadingState).getError())) {
                            composerStartRestartGroup.startReplaceGroup(-1725528065);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "135@5954L64,134@5896L188");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441133241, "CC(remember):CollectionItemsListScreen.kt#9igjgp");
                            if ((i3 & 14) == 4) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (!z10) {
                                objRememberedValue6 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$2$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            } else {
                                objRememberedValue6 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$2$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ItemStateScreensKt.NetworkConnectionError((Function0) objRememberedValue6, true, composerStartRestartGroup, 48, 0);
                            composerStartRestartGroup.endReplaceGroup();
                            str = "CC(remember):CollectionItemsListScreen.kt#9igjgp";
                            z9 = true;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1725303997);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "140@6176L64,139@6122L184");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441126137, "CC(remember):CollectionItemsListScreen.kt#9igjgp");
                            if ((i3 & 14) == 4) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (!z8) {
                                objRememberedValue5 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$3$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            } else {
                                objRememberedValue5 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$3$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            z9 = true;
                            str = "CC(remember):CollectionItemsListScreen.kt#9igjgp";
                            ItemStateScreensKt.GenericErrorScreen((Function0) objRememberedValue5, true, 0, null, 0, null, composerStartRestartGroup, 48, 60);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        z5 = z9;
                    } else {
                        stateCollectAsStateWithLifecycle = stateCollectAsStateWithLifecycle;
                        str = "CC(remember):CollectionItemsListScreen.kt#9igjgp";
                        if (Intrinsics.areEqual(loadingState, CollectionItemsListReducer.LoadingState.Loaded.INSTANCE)) {
                            composerStartRestartGroup.startReplaceGroup(-1441147157);
                            composerStartRestartGroup.endReplaceGroup();
                            throw new NoWhenBranchMatchedException();
                        }
                        composerStartRestartGroup.startReplaceGroup(-1724989595);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "149@6502L11,151@6600L105,154@6741L104,147@6404L581");
                        CollectionItemsListReducer.State stateCollectionItemsListContent$lambda$1 = CollectionItemsListContent$lambda$0(stateCollectAsStateWithLifecycle);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441115758, str);
                        i6 = i3 & 14;
                        if (i6 == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        collectionItemsListScreenKt$CollectionItemsListContent$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            collectionItemsListScreenKt$CollectionItemsListContent$4$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$4$1(store);
                            composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$4$1RememberedValue);
                        } else {
                            collectionItemsListScreenKt$CollectionItemsListContent$4$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$4$1(store);
                            composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$4$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Function1 function3 = (Function1) ((KFunction) collectionItemsListScreenKt$CollectionItemsListContent$4$1RememberedValue);
                        boolean zIsRefreshing2 = CollectionItemsListContent$lambda$0(stateCollectAsStateWithLifecycle).isRefreshing();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441112528, str);
                        if (i6 == 4) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z3) {
                            objRememberedValue = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$5$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$5$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        Function0 function4 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441108017, str);
                        if (i6 == 4) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z4) {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$6$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$6$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        z5 = true;
                        modifier4 = modifier4;
                        CollectionItemsListWithPullToRefresh(stateCollectionItemsListContent$lambda$1, function3, zIsRefreshing2, function4, (Function0) objRememberedValue2, TestTagKt.testTag(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null), "CollectionItemsScreen"), composerStartRestartGroup, 0, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        if (snackbarHostState4 != null) {
                            composerStartRestartGroup.startReplaceGroup(-1441097370);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "");
                            error = CollectionItemsListContent$lambda$0(stateCollectAsStateWithLifecycle).getError();
                            if (error == null) {
                                composerStartRestartGroup.startReplaceGroup(-1724345509);
                                composerStartRestartGroup.endReplaceGroup();
                                snackbarHostState5 = snackbarHostState4;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-1724345508);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*167@7259L121,170@7418L114,164@7096L458");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -257248134, str);
                                if (i6 == 4) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (!z6) {
                                    objRememberedValue3 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda15
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$7$0$0(store);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                } else {
                                    objRememberedValue3 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda15
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$7$0$0(store);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                Function0 function5 = (Function0) objRememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -257243053, str);
                                if (i6 == 4) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                if (!z7) {
                                    objRememberedValue4 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda16
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$7$1$0(store);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                } else {
                                    objRememberedValue4 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda16
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$7$1$0(store);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                snackbarHostState5 = snackbarHostState4;
                                ErrorSnackbarKt.ErrorSnackbar(error, snackbarHostState5, function5, (Function0) objRememberedValue4, composerStartRestartGroup, (i3 >> 9) & 112);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        } else {
                            snackbarHostState5 = snackbarHostState4;
                            composerStartRestartGroup.startReplaceGroup(-1731366853);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    CollectionItemsListReducer.Route navigationRoute3 = CollectionItemsListContent$lambda$0(stateCollectAsStateWithLifecycle).getNavigationRoute();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441078534, str);
                    state = stateCollectAsStateWithLifecycle;
                    boolean zChanged3 = composerStartRestartGroup.changed(state);
                    if ((i3 & 112) == 32) {
                        z11 = z5;
                    } else {
                        z11 = false;
                    }
                    boolean z110 = zChanged3 | z11;
                    if ((i3 & 14) == 4) {
                        z12 = z5;
                    } else {
                        z12 = false;
                    }
                    boolean z111 = z110 | z12;
                    if ((i3 & 896) == 256) {
                        z13 = z5;
                    } else {
                        z13 = false;
                    }
                    z14 = z111 | z13;
                    collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z14) {
                        collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$8$1(onOpenItem, store, onOpenItemMoreActionsMenu, state, null);
                        composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue);
                    } else {
                        collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$8$1(onOpenItem, store, onOpenItemMoreActionsMenu, state, null);
                        composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(navigationRoute3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    snackbarHostState3 = snackbarHostState5;
                    modifier3 = modifier4;
                }
                snackbarHostState5 = snackbarHostState4;
                CollectionItemsListReducer.Route navigationRoute4 = CollectionItemsListContent$lambda$0(stateCollectAsStateWithLifecycle).getNavigationRoute();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441078534, str);
                state = stateCollectAsStateWithLifecycle;
                boolean zChanged4 = composerStartRestartGroup.changed(state);
                if ((i3 & 112) == 32) {
                    z11 = z5;
                } else {
                    z11 = false;
                }
                boolean z112 = zChanged4 | z11;
                if ((i3 & 14) == 4) {
                    z12 = z5;
                } else {
                    z12 = false;
                }
                boolean z113 = z112 | z12;
                if ((i3 & 896) == 256) {
                    z13 = z5;
                } else {
                    z13 = false;
                }
                z14 = z113 | z13;
                collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z14) {
                    collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$8$1(onOpenItem, store, onOpenItemMoreActionsMenu, state, null);
                    composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue);
                } else {
                    collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$8$1(onOpenItem, store, onOpenItemMoreActionsMenu, state, null);
                    composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(navigationRoute4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                snackbarHostState3 = snackbarHostState5;
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$9(store, onOpenItem, onOpenItemMoreActionsMenu, modifier3, snackbarHostState3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                snackbarHostState2 = snackbarHostState;
                if (composerStartRestartGroup.changed(snackbarHostState2)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                snackbarHostState3 = snackbarHostState2;
            } else {
                if (i7 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    snackbarHostState4 = null;
                } else {
                    snackbarHostState4 = snackbarHostState2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(364980391, i3, -1, "com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListContent (CollectionItemsListScreen.kt:121)");
                }
                modifier4 = modifier2;
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                loadingState = CollectionItemsListContent$lambda$0(stateCollectAsStateWithLifecycle).getLoadingState();
                if (Intrinsics.areEqual(loadingState, CollectionItemsListReducer.LoadingState.Loading.INSTANCE)) {
                    composerStartRestartGroup.startReplaceGroup(-1725844420);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "126@5595L87,126@5574L108,129@5695L46");
                    Unit unit3 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441144706, "CC(remember):CollectionItemsListScreen.kt#9igjgp");
                    if ((i3 & 14) == 4) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    collectionItemsListScreenKt$CollectionItemsListContent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z15) {
                        collectionItemsListScreenKt$CollectionItemsListContent$1$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$1$1(store, null);
                        composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$1$1RememberedValue);
                    } else {
                        collectionItemsListScreenKt$CollectionItemsListContent$1$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$1$1(store, null);
                        composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) collectionItemsListScreenKt$CollectionItemsListContent$1$1RememberedValue, composerStartRestartGroup, 6);
                    ItemStateScreensKt.LoadingItemsScreen(null, true, composerStartRestartGroup, 48, 1);
                    composerStartRestartGroup.endReplaceGroup();
                    stateCollectAsStateWithLifecycle = stateCollectAsStateWithLifecycle;
                    str = "CC(remember):CollectionItemsListScreen.kt#9igjgp";
                    z5 = true;
                } else {
                    if (loadingState instanceof CollectionItemsListReducer.LoadingState.Error) {
                        composerStartRestartGroup.startReplaceGroup(-1725583338);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        if (DomainErrorKt.isNetworkConnectionError(((CollectionItemsListReducer.LoadingState.Error) loadingState).getError())) {
                            composerStartRestartGroup.startReplaceGroup(-1725528065);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "135@5954L64,134@5896L188");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441133241, "CC(remember):CollectionItemsListScreen.kt#9igjgp");
                            if ((i3 & 14) == 4) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (!z10) {
                                objRememberedValue6 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$2$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            } else {
                                objRememberedValue6 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$2$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ItemStateScreensKt.NetworkConnectionError((Function0) objRememberedValue6, true, composerStartRestartGroup, 48, 0);
                            composerStartRestartGroup.endReplaceGroup();
                            str = "CC(remember):CollectionItemsListScreen.kt#9igjgp";
                            z9 = true;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1725303997);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "140@6176L64,139@6122L184");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441126137, "CC(remember):CollectionItemsListScreen.kt#9igjgp");
                            if ((i3 & 14) == 4) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (!z8) {
                                objRememberedValue5 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$3$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            } else {
                                objRememberedValue5 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$3$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            z9 = true;
                            str = "CC(remember):CollectionItemsListScreen.kt#9igjgp";
                            ItemStateScreensKt.GenericErrorScreen((Function0) objRememberedValue5, true, 0, null, 0, null, composerStartRestartGroup, 48, 60);
                            composerStartRestartGroup = composerStartRestartGroup;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        z5 = z9;
                    } else {
                        stateCollectAsStateWithLifecycle = stateCollectAsStateWithLifecycle;
                        str = "CC(remember):CollectionItemsListScreen.kt#9igjgp";
                        if (Intrinsics.areEqual(loadingState, CollectionItemsListReducer.LoadingState.Loaded.INSTANCE)) {
                            composerStartRestartGroup.startReplaceGroup(-1441147157);
                            composerStartRestartGroup.endReplaceGroup();
                            throw new NoWhenBranchMatchedException();
                        }
                        composerStartRestartGroup.startReplaceGroup(-1724989595);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "149@6502L11,151@6600L105,154@6741L104,147@6404L581");
                        CollectionItemsListReducer.State stateCollectionItemsListContent$lambda$2 = CollectionItemsListContent$lambda$0(stateCollectAsStateWithLifecycle);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441115758, str);
                        i6 = i3 & 14;
                        if (i6 == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        collectionItemsListScreenKt$CollectionItemsListContent$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            collectionItemsListScreenKt$CollectionItemsListContent$4$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$4$1(store);
                            composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$4$1RememberedValue);
                        } else {
                            collectionItemsListScreenKt$CollectionItemsListContent$4$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$4$1(store);
                            composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$4$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Function1 function6 = (Function1) ((KFunction) collectionItemsListScreenKt$CollectionItemsListContent$4$1RememberedValue);
                        boolean zIsRefreshing3 = CollectionItemsListContent$lambda$0(stateCollectAsStateWithLifecycle).isRefreshing();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441112528, str);
                        if (i6 == 4) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z3) {
                            objRememberedValue = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$5$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$5$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        Function0 function7 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441108017, str);
                        if (i6 == 4) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z4) {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$6$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$6$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        z5 = true;
                        modifier4 = modifier4;
                        CollectionItemsListWithPullToRefresh(stateCollectionItemsListContent$lambda$2, function6, zIsRefreshing3, function7, (Function0) objRememberedValue2, TestTagKt.testTag(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null), "CollectionItemsScreen"), composerStartRestartGroup, 0, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        if (snackbarHostState4 != null) {
                            composerStartRestartGroup.startReplaceGroup(-1441097370);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "");
                            error = CollectionItemsListContent$lambda$0(stateCollectAsStateWithLifecycle).getError();
                            if (error == null) {
                                composerStartRestartGroup.startReplaceGroup(-1724345509);
                                composerStartRestartGroup.endReplaceGroup();
                                snackbarHostState5 = snackbarHostState4;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-1724345508);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*167@7259L121,170@7418L114,164@7096L458");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -257248134, str);
                                if (i6 == 4) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (!z6) {
                                    objRememberedValue3 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda15
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$7$0$0(store);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                } else {
                                    objRememberedValue3 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda15
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$7$0$0(store);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                Function0 function8 = (Function0) objRememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -257243053, str);
                                if (i6 == 4) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                if (!z7) {
                                    objRememberedValue4 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda16
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$7$1$0(store);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                } else {
                                    objRememberedValue4 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda16
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$7$1$0(store);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                snackbarHostState5 = snackbarHostState4;
                                ErrorSnackbarKt.ErrorSnackbar(error, snackbarHostState5, function8, (Function0) objRememberedValue4, composerStartRestartGroup, (i3 >> 9) & 112);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        } else {
                            snackbarHostState5 = snackbarHostState4;
                            composerStartRestartGroup.startReplaceGroup(-1731366853);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    CollectionItemsListReducer.Route navigationRoute5 = CollectionItemsListContent$lambda$0(stateCollectAsStateWithLifecycle).getNavigationRoute();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441078534, str);
                    state = stateCollectAsStateWithLifecycle;
                    boolean zChanged5 = composerStartRestartGroup.changed(state);
                    if ((i3 & 112) == 32) {
                        z11 = z5;
                    } else {
                        z11 = false;
                    }
                    boolean z114 = zChanged5 | z11;
                    if ((i3 & 14) == 4) {
                        z12 = z5;
                    } else {
                        z12 = false;
                    }
                    boolean z115 = z114 | z12;
                    if ((i3 & 896) == 256) {
                        z13 = z5;
                    } else {
                        z13 = false;
                    }
                    z14 = z115 | z13;
                    collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z14) {
                        collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$8$1(onOpenItem, store, onOpenItemMoreActionsMenu, state, null);
                        composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue);
                    } else {
                        collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$8$1(onOpenItem, store, onOpenItemMoreActionsMenu, state, null);
                        composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(navigationRoute5, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    snackbarHostState3 = snackbarHostState5;
                    modifier3 = modifier4;
                }
                snackbarHostState5 = snackbarHostState4;
                CollectionItemsListReducer.Route navigationRoute6 = CollectionItemsListContent$lambda$0(stateCollectAsStateWithLifecycle).getNavigationRoute();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441078534, str);
                state = stateCollectAsStateWithLifecycle;
                boolean zChanged6 = composerStartRestartGroup.changed(state);
                if ((i3 & 112) == 32) {
                    z11 = z5;
                } else {
                    z11 = false;
                }
                boolean z116 = zChanged6 | z11;
                if ((i3 & 14) == 4) {
                    z12 = z5;
                } else {
                    z12 = false;
                }
                boolean z117 = z116 | z12;
                if ((i3 & 896) == 256) {
                    z13 = z5;
                } else {
                    z13 = false;
                }
                z14 = z117 | z13;
                collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z14) {
                    collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$8$1(onOpenItem, store, onOpenItemMoreActionsMenu, state, null);
                    composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue);
                } else {
                    collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$8$1(onOpenItem, store, onOpenItemMoreActionsMenu, state, null);
                    composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(navigationRoute6, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                snackbarHostState3 = snackbarHostState5;
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$9(store, onOpenItem, onOpenItemMoreActionsMenu, modifier3, snackbarHostState3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        snackbarHostState2 = snackbarHostState;
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            snackbarHostState3 = snackbarHostState2;
        } else {
            if (i7 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (i4 != 0) {
                snackbarHostState4 = null;
            } else {
                snackbarHostState4 = snackbarHostState2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(364980391, i3, -1, "com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListContent (CollectionItemsListScreen.kt:121)");
            }
            modifier4 = modifier2;
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            loadingState = CollectionItemsListContent$lambda$0(stateCollectAsStateWithLifecycle).getLoadingState();
            if (Intrinsics.areEqual(loadingState, CollectionItemsListReducer.LoadingState.Loading.INSTANCE)) {
                composerStartRestartGroup.startReplaceGroup(-1725844420);
                ComposerKt.sourceInformation(composerStartRestartGroup, "126@5595L87,126@5574L108,129@5695L46");
                Unit unit4 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441144706, "CC(remember):CollectionItemsListScreen.kt#9igjgp");
                if ((i3 & 14) == 4) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                collectionItemsListScreenKt$CollectionItemsListContent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z15) {
                    collectionItemsListScreenKt$CollectionItemsListContent$1$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$1$1(store, null);
                    composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$1$1RememberedValue);
                } else {
                    collectionItemsListScreenKt$CollectionItemsListContent$1$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$1$1(store, null);
                    composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) collectionItemsListScreenKt$CollectionItemsListContent$1$1RememberedValue, composerStartRestartGroup, 6);
                ItemStateScreensKt.LoadingItemsScreen(null, true, composerStartRestartGroup, 48, 1);
                composerStartRestartGroup.endReplaceGroup();
                stateCollectAsStateWithLifecycle = stateCollectAsStateWithLifecycle;
                str = "CC(remember):CollectionItemsListScreen.kt#9igjgp";
                z5 = true;
            } else {
                if (loadingState instanceof CollectionItemsListReducer.LoadingState.Error) {
                    composerStartRestartGroup.startReplaceGroup(-1725583338);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (DomainErrorKt.isNetworkConnectionError(((CollectionItemsListReducer.LoadingState.Error) loadingState).getError())) {
                        composerStartRestartGroup.startReplaceGroup(-1725528065);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "135@5954L64,134@5896L188");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441133241, "CC(remember):CollectionItemsListScreen.kt#9igjgp");
                        if ((i3 & 14) == 4) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (!z10) {
                            objRememberedValue6 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$2$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        } else {
                            objRememberedValue6 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$2$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ItemStateScreensKt.NetworkConnectionError((Function0) objRememberedValue6, true, composerStartRestartGroup, 48, 0);
                        composerStartRestartGroup.endReplaceGroup();
                        str = "CC(remember):CollectionItemsListScreen.kt#9igjgp";
                        z9 = true;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1725303997);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "140@6176L64,139@6122L184");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441126137, "CC(remember):CollectionItemsListScreen.kt#9igjgp");
                        if ((i3 & 14) == 4) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (!z8) {
                            objRememberedValue5 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$3$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$3$0(store);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        z9 = true;
                        str = "CC(remember):CollectionItemsListScreen.kt#9igjgp";
                        ItemStateScreensKt.GenericErrorScreen((Function0) objRememberedValue5, true, 0, null, 0, null, composerStartRestartGroup, 48, 60);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    z5 = z9;
                } else {
                    stateCollectAsStateWithLifecycle = stateCollectAsStateWithLifecycle;
                    str = "CC(remember):CollectionItemsListScreen.kt#9igjgp";
                    if (Intrinsics.areEqual(loadingState, CollectionItemsListReducer.LoadingState.Loaded.INSTANCE)) {
                        composerStartRestartGroup.startReplaceGroup(-1441147157);
                        composerStartRestartGroup.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composerStartRestartGroup.startReplaceGroup(-1724989595);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "149@6502L11,151@6600L105,154@6741L104,147@6404L581");
                    CollectionItemsListReducer.State stateCollectionItemsListContent$lambda$3 = CollectionItemsListContent$lambda$0(stateCollectAsStateWithLifecycle);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441115758, str);
                    i6 = i3 & 14;
                    if (i6 == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    collectionItemsListScreenKt$CollectionItemsListContent$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        collectionItemsListScreenKt$CollectionItemsListContent$4$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$4$1(store);
                        composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$4$1RememberedValue);
                    } else {
                        collectionItemsListScreenKt$CollectionItemsListContent$4$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$4$1(store);
                        composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$4$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Function1 function9 = (Function1) ((KFunction) collectionItemsListScreenKt$CollectionItemsListContent$4$1RememberedValue);
                    boolean zIsRefreshing4 = CollectionItemsListContent$lambda$0(stateCollectAsStateWithLifecycle).isRefreshing();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441112528, str);
                    if (i6 == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z3) {
                        objRememberedValue = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$5$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$5$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function10 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441108017, str);
                    if (i6 == 4) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z4) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$6$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$6$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    z5 = true;
                    modifier4 = modifier4;
                    CollectionItemsListWithPullToRefresh(stateCollectionItemsListContent$lambda$3, function9, zIsRefreshing4, function10, (Function0) objRememberedValue2, TestTagKt.testTag(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, null), "CollectionItemsScreen"), composerStartRestartGroup, 0, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (snackbarHostState4 != null) {
                        composerStartRestartGroup.startReplaceGroup(-1441097370);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        error = CollectionItemsListContent$lambda$0(stateCollectAsStateWithLifecycle).getError();
                        if (error == null) {
                            composerStartRestartGroup.startReplaceGroup(-1724345509);
                            composerStartRestartGroup.endReplaceGroup();
                            snackbarHostState5 = snackbarHostState4;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1724345508);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*167@7259L121,170@7418L114,164@7096L458");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -257248134, str);
                            if (i6 == 4) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z6) {
                                objRememberedValue3 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda15
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$7$0$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda15
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$7$0$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            Function0 function11 = (Function0) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -257243053, str);
                            if (i6 == 4) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (!z7) {
                                objRememberedValue4 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda16
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$7$1$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            } else {
                                objRememberedValue4 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda16
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$7$1$0(store);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            snackbarHostState5 = snackbarHostState4;
                            ErrorSnackbarKt.ErrorSnackbar(error, snackbarHostState5, function11, (Function0) objRememberedValue4, composerStartRestartGroup, (i3 >> 9) & 112);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                    } else {
                        snackbarHostState5 = snackbarHostState4;
                        composerStartRestartGroup.startReplaceGroup(-1731366853);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.endReplaceGroup();
                }
                CollectionItemsListReducer.Route navigationRoute7 = CollectionItemsListContent$lambda$0(stateCollectAsStateWithLifecycle).getNavigationRoute();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441078534, str);
                state = stateCollectAsStateWithLifecycle;
                boolean zChanged7 = composerStartRestartGroup.changed(state);
                if ((i3 & 112) == 32) {
                    z11 = z5;
                } else {
                    z11 = false;
                }
                boolean z118 = zChanged7 | z11;
                if ((i3 & 14) == 4) {
                    z12 = z5;
                } else {
                    z12 = false;
                }
                boolean z119 = z118 | z12;
                if ((i3 & 896) == 256) {
                    z13 = z5;
                } else {
                    z13 = false;
                }
                z14 = z119 | z13;
                collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z14) {
                    collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$8$1(onOpenItem, store, onOpenItemMoreActionsMenu, state, null);
                    composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue);
                } else {
                    collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$8$1(onOpenItem, store, onOpenItemMoreActionsMenu, state, null);
                    composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(navigationRoute7, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                snackbarHostState3 = snackbarHostState5;
                modifier3 = modifier4;
            }
            snackbarHostState5 = snackbarHostState4;
            CollectionItemsListReducer.Route navigationRoute8 = CollectionItemsListContent$lambda$0(stateCollectAsStateWithLifecycle).getNavigationRoute();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1441078534, str);
            state = stateCollectAsStateWithLifecycle;
            boolean zChanged8 = composerStartRestartGroup.changed(state);
            if ((i3 & 112) == 32) {
                z11 = z5;
            } else {
                z11 = false;
            }
            boolean z1110 = zChanged8 | z11;
            if ((i3 & 14) == 4) {
                z12 = z5;
            } else {
                z12 = false;
            }
            boolean z1111 = z1110 | z12;
            if ((i3 & 896) == 256) {
                z13 = z5;
            } else {
                z13 = false;
            }
            z14 = z1111 | z13;
            collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z14) {
                collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$8$1(onOpenItem, store, onOpenItemMoreActionsMenu, state, null);
                composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue);
            } else {
                collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue = new CollectionItemsListScreenKt$CollectionItemsListContent$8$1(onOpenItem, store, onOpenItemMoreActionsMenu, state, null);
                composerStartRestartGroup.updateRememberedValue(collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(navigationRoute8, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) collectionItemsListScreenKt$CollectionItemsListContent$8$1RememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            snackbarHostState3 = snackbarHostState5;
            modifier3 = modifier4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionItemsListScreenKt.CollectionItemsListContent$lambda$9(store, onOpenItem, onOpenItemMoreActionsMenu, modifier3, snackbarHostState3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemsListContent$lambda$2$0(Store store) {
        store.send(new CollectionItemsListReducer.Action.RefreshItems(false, 1, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemsListContent$lambda$3$0(Store store) {
        store.send(new CollectionItemsListReducer.Action.RefreshItems(false, 1, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemsListContent$lambda$5$0(Store store) {
        store.send(new CollectionItemsListReducer.Action.RefreshItems(false));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemsListContent$lambda$6$0(Store store) {
        store.send(new CollectionItemsListReducer.Action.RefreshItems(true));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemsListContent$lambda$7$0$0(Store store) {
        store.send(new CollectionItemsListReducer.Action.RefreshItems(false));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemsListContent$lambda$7$1$0(Store store) {
        store.send(CollectionItemsListReducer.Action.ErrorHandled.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:52:0x0095  */
    /* JADX WARN: Code duplicated, block: B:53:0x0097  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:65:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:70:0x00da  */
    /* JADX WARN: Code duplicated, block: B:73:0x015b  */
    /* JADX WARN: Code duplicated, block: B:76:0x0167  */
    /* JADX WARN: Code duplicated, block: B:77:0x016b  */
    /* JADX WARN: Code duplicated, block: B:80:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:82:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:85:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:87:? A[RETURN, SYNTHETIC] */
    public static final void CollectionItemsListWithPullToRefresh(final CollectionItemsListReducer.State state, final Function1<? super CollectionItemsListReducer.Action, Unit> function1, final boolean z, final Function0<Unit> function0, final Function0<Unit> function2, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function3;
        Modifier modifier2;
        boolean z2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        boolean z3;
        Object objRememberedValue;
        Function0<ComposeUiNode> constructor;
        Composer composerStartRestartGroup = composer.startRestartGroup(1359355165);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CollectionItemsListWithPullToRefresh)N(state,sendAction,isRefreshing,onSilentRefresh,onPullToRefresh,modifier)208@8605L28,213@8723L213,224@9145L6,210@8639L829:CollectionItemsListScreen.kt#avvpft");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(state) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            function3 = function2;
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
        } else {
            function3 = function2;
        }
        int i4 = i2 & 32;
        if (i4 == 0) {
            if ((196608 & i) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 131072 : 65536;
            }
            if ((74899 & i3) != 74898) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1359355165, i3, -1, "com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListWithPullToRefresh (CollectionItemsListScreen.kt:207)");
                }
                PullToRefreshState pullToRefreshStateRememberPullToRefreshState = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 670269426, "CC(remember):CollectionItemsListScreen.kt#9igjgp");
                z3 = (i3 & 7168) == 2048;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CollectionItemsListScreenKt.CollectionItemsListWithPullToRefresh$lambda$0$0(function0, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifierFillMaxHeight$default, 0L, 0.0f, null, (Function1) objRememberedValue, 7, null), z, pullToRefreshStateRememberPullToRefreshState, false, 0.0f, function3, 12, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), null, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 717916809, "C226@9183L93,231@9286L176:CollectionItemsListScreen.kt#avvpft");
                CollectionItemsList(state, function1, composerStartRestartGroup, i3 & 126);
                Modifier modifier4 = companion;
                BoxPullToRefreshIndicatorKt.BoxPullToRefreshIndicator(pullToRefreshStateRememberPullToRefreshState, z, boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), composerStartRestartGroup, (i3 >> 3) & 112, 0);
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
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CollectionItemsListScreenKt.CollectionItemsListWithPullToRefresh$lambda$2(state, function1, z, function0, function2, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        modifier2 = modifier;
        if ((74899 & i3) != 74898) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1359355165, i3, -1, "com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListWithPullToRefresh (CollectionItemsListScreen.kt:207)");
            }
            PullToRefreshState pullToRefreshStateRememberPullToRefreshState2 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
            Modifier modifierFillMaxHeight$default2 = SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 670269426, "CC(remember):CollectionItemsListScreen.kt#9igjgp");
            if ((i3 & 7168) == 2048) {
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z3) {
                objRememberedValue = new Function1() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CollectionItemsListScreenKt.CollectionItemsListWithPullToRefresh$lambda$0$0(function0, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CollectionItemsListScreenKt.CollectionItemsListWithPullToRefresh$lambda$0$0(function0, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM589backgroundbw27NRU$default2 = BackgroundKt.m589backgroundbw27NRU$default(PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifierFillMaxHeight$default2, 0L, 0.0f, null, (Function1) objRememberedValue, 7, null), z, pullToRefreshStateRememberPullToRefreshState2, false, 0.0f, function3, 12, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default2);
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
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 717916809, "C226@9183L93,231@9286L176:CollectionItemsListScreen.kt#avvpft");
            CollectionItemsList(state, function1, composerStartRestartGroup, i3 & 126);
            Modifier modifier5 = companion;
            BoxPullToRefreshIndicatorKt.BoxPullToRefreshIndicator(pullToRefreshStateRememberPullToRefreshState2, z, boxScopeInstance2.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), composerStartRestartGroup, (i3 >> 3) & 112, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionItemsListScreenKt.CollectionItemsListWithPullToRefresh$lambda$2(state, function1, z, function0, function2, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemsListWithPullToRefresh$lambda$0$0(Function0 function0, boolean z) {
        if (z) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    private static final void CollectionItemsList(final CollectionItemsListReducer.State state, final Function1<? super CollectionItemsListReducer.Action, Unit> function1, Composer composer, final int i) {
        int i2;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1509257103);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CollectionItemsList)N(state,sendAction)241@9640L23,263@10421L1090,259@10240L1271:CollectionItemsListScreen.kt#avvpft");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1509257103, i2, -1, "com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsList (CollectionItemsListScreen.kt:240)");
            }
            final LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            int i3 = i2;
            final IdentifiedList<ItemId.Remote, ItemReducer.State> items = state.getItems();
            if (items.isEmpty()) {
                composerStartRestartGroup.startReplaceGroup(-1734028610);
                ComposerKt.sourceInformation(composerStartRestartGroup, "248@9883L52,249@9963L55,245@9728L406");
                EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(new ItemsStateConfig(R.drawable.ic_collectionstar140, StringResources_androidKt.stringResource(R.string.empty_collection_items_text, composerStartRestartGroup, 0), StringResources_androidKt.stringResource(R.string.empty_collection_items_subtext, composerStartRestartGroup, 0), null, 8, null), "EmptyCollectionItemsScreen", true, composerStartRestartGroup, 432, 0);
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CollectionItemsListScreenKt.CollectionItemsList$lambda$0(state, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            } else {
                composerStartRestartGroup.startReplaceGroup(-1743683405);
                composerStartRestartGroup.endReplaceGroup();
                final boolean z = state.getMultiselect() instanceof MultiselectReducer.State.Selecting;
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                PaddingValues paddingValuesM1215PaddingValuesa9UjIt4$default = PaddingKt.m1215PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, BoxTheme.INSTANCE.getSizes().m11611getListContentBottomPaddingD9Ej5fM(), 7, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1302839247, "CC(remember):CollectionItemsListScreen.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(items) | composerStartRestartGroup.changed(lazyListStateRememberLazyListState) | ((i3 & 112) == 32) | composerStartRestartGroup.changed(z) | composerStartRestartGroup.changedInstance(state);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    Function1 function3 = new Function1() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CollectionItemsListScreenKt.CollectionItemsList$lambda$1$0(items, lazyListStateRememberLazyListState, function1, z, state, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function3);
                    objRememberedValue = function3;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                LazyDslKt.LazyColumn(modifierFillMaxSize$default, lazyListStateRememberLazyListState, paddingValuesM1215PaddingValuesa9UjIt4$default, false, null, null, null, false, null, (Function1) objRememberedValue, composer2, 6, 504);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionItemsListScreenKt.CollectionItemsList$lambda$2(state, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItemsList$lambda$1$0(IdentifiedList identifiedList, final LazyListState lazyListState, final Function1 function1, final boolean z, final CollectionItemsListReducer.State state, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final IdentifiedList identifiedList2 = identifiedList;
        final CollectionItemsListScreenKt$CollectionItemsList$lambda$1$0$$inlined$items$default$1 collectionItemsListScreenKt$CollectionItemsList$lambda$1$0$$inlined$items$default$1 = new Function1() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$CollectionItemsList$lambda$1$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(ItemReducer.State state2) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((ItemReducer.State) obj);
            }
        };
        LazyColumn.items(identifiedList2.size(), null, new Function1<Integer, Object>() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$CollectionItemsList$lambda$1$0$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return collectionItemsListScreenKt$CollectionItemsList$lambda$1$0$$inlined$items$default$1.invoke(identifiedList2.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$CollectionItemsList$lambda$1$0$$inlined$items$default$4
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
                ItemReducer.State state2 = (ItemReducer.State) identifiedList2.get(i);
                composer.startReplaceGroup(986850735);
                ComposerKt.sourceInformation(composer, "CN(item)*265@10466L1029:CollectionItemsListScreen.kt#avvpft");
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
                ComposerKt.sourceInformationMarkerStart(composer, -67167636, "C279@11144L219:CollectionItemsListScreen.kt#avvpft");
                if (state2.getThumbnailState().isThumbnailFetchAttempted() || lazyListState.isScrollInProgress()) {
                    composer.startReplaceGroup(-77694803);
                } else {
                    composer.startReplaceGroup(-67043141);
                    ComposerKt.sourceInformation(composer, "269@10767L341,269@10746L362");
                    Unit unit = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer, 1106217290, "CC(remember):CollectionItemsListScreen.kt#9igjgp");
                    boolean zChanged = composer.changed(function1) | composer.changedInstance(state2);
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function2) new CollectionItemsListScreenKt$CollectionItemsList$2$1$1$1$1$1(function1, state2, null);
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue, composer, 6);
                }
                composer.endReplaceGroup();
                CollectionItemsListScreenKt.CollectionItem(state2, z, state.isItemChecked(state2.getId()), function1, composer, ItemReducer.State.$stable);
                if (Intrinsics.areEqual(state2.getId(), ((ItemReducer.State) CollectionsKt.last((List) state.getItems())).getId())) {
                    composer.startReplaceGroup(-77694803);
                } else {
                    composer.startReplaceGroup(-66365202);
                    ComposerKt.sourceInformation(composer, "286@11440L23");
                    BoxItemListingDividerKt.m11726BoxItemListingDivideryajeYGU(0.0f, 0.0f, 0.0f, composer, 0, 7);
                }
                composer.endReplaceGroup();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CollectionItem(final ItemReducer.State state, final boolean z, final boolean z2, final Function1<? super CollectionItemsListReducer.Action, Unit> function1, Composer composer, final int i) {
        int i2;
        final SecondaryActionType.BottomSheetMenu bottomSheetMenu;
        Composer composerStartRestartGroup = composer.startRestartGroup(2142267188);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CollectionItem)N(item,isSelecting,isChecked,sendAction)316@12243L125,319@12407L515,332@12950L3,306@11852L1168:CollectionItemsListScreen.kt#avvpft");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(state) : composerStartRestartGroup.changedInstance(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2142267188, i2, -1, "com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItem (CollectionItemsListScreen.kt:299)");
            }
            if (z) {
                bottomSheetMenu = SecondaryActionType.Checkbox.INSTANCE;
            } else {
                bottomSheetMenu = SecondaryActionType.BottomSheetMenu.INSTANCE;
            }
            ListItemInfo listItemInfo = new ListItemInfo(state.getName(), state.getItemThumbnail(), state.getFormattedDescription(), "CollectionItem_" + state.getId(), null, false, 0L, false, PsExtractor.VIDEO_STREAM_MASK, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1429455665, "CC(remember):CollectionItemsListScreen.kt#9igjgp");
            int i3 = i2 & 7168;
            int i4 = i2 & 14;
            boolean z3 = (i3 == 2048) | (i4 == 4 || ((i2 & 8) != 0 && composerStartRestartGroup.changedInstance(state)));
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CollectionItemsListScreenKt.CollectionItem$lambda$0$0(function1, state);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1429461303, "CC(remember):CollectionItemsListScreen.kt#9igjgp");
            boolean zChangedInstance = (i3 == 2048) | composerStartRestartGroup.changedInstance(bottomSheetMenu) | (i4 == 4 || ((i2 & 8) != 0 && composerStartRestartGroup.changedInstance(state)));
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CollectionItemsListScreenKt.CollectionItem$lambda$1$0(bottomSheetMenu, function1, state);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function0 function2 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1429478167, "CC(remember):CollectionItemsListScreen.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxListViewItemKt.m11597BoxListViewItemXSU6r7E(listItemInfo, false, z2, false, new ClickActionsConfig(function0, function2, (Function0) objRememberedValue3, null, 8, null), bottomSheetMenu, 0, true, null, composerStartRestartGroup, (i2 & 896) | 12582912 | (SecondaryActionType.$stable << 15), 330);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionItemsListScreenKt.CollectionItem$lambda$3(state, z, z2, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItem$lambda$0$0(Function1 function1, ItemReducer.State state) {
        function1.invoke(new CollectionItemsListReducer.Action.ItemAction(state.getId(), ItemReducer.Action.Clicked.INSTANCE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollectionItem$lambda$1$0(SecondaryActionType secondaryActionType, Function1 function1, ItemReducer.State state) {
        if (Intrinsics.areEqual(secondaryActionType, SecondaryActionType.Checkbox.INSTANCE)) {
            function1.invoke(new CollectionItemsListReducer.Action.ItemAction(state.getId(), ItemReducer.Action.CheckboxClicked.INSTANCE));
        } else if (Intrinsics.areEqual(secondaryActionType, SecondaryActionType.BottomSheetMenu.INSTANCE)) {
            function1.invoke(new CollectionItemsListReducer.Action.ItemAction(state.getId(), ItemReducer.Action.MenuClicked.INSTANCE));
        }
        return Unit.INSTANCE;
    }

    private static final void EmptyCollectionItemsListScreenPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1020083412);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EmptyCollectionItemsListScreenPreview)343@13165L615:CollectionItemsListScreen.kt#avvpft");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1020083412, i, -1, "com.box.android.collections.presentation.navigationmodernization.collectionitemslist.EmptyCollectionItemsListScreenPreview (CollectionItemsListScreen.kt:342)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$CollectionItemsListScreenKt.INSTANCE.m12391getLambda$60776023$collections_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionItemsListScreenKt.EmptyCollectionItemsListScreenPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final CollectionItemsListReducer.State CollectionItemsListScreen$lambda$0(State<CollectionItemsListReducer.State> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CollectionItemsListReducer.State CollectionItemsListContent$lambda$0(State<CollectionItemsListReducer.State> state) {
        return state.getValue();
    }
}
