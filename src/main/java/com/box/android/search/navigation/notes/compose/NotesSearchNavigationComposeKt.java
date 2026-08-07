package com.box.android.search.navigation.notes.compose;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.compose.NavGraphBuilderKt;
import com.box.android.base.compose.ComposeAnimationUtilsKt;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.search.navigation.SearchDestination;
import com.box.android.search.navigation.SearchNavigator;
import com.box.android.search.navigation.notes.NotesSearchDestination;
import com.box.android.search.presentation.cpl.SearchReducer;
import com.box.android.search.presentation.ui.SearchScreenKt;
import com.box.android.search.presentation.vm.NotesSearchViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotesSearchNavigationCompose.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006¨\u0006\u0007"}, d2 = {"notesSearchNavigationGraph", "", "Landroidx/navigation/NavGraphBuilder;", "navigator", "Lcom/box/android/search/navigation/SearchNavigator;", "onDismissSearch", "Lkotlin/Function0;", "search_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NotesSearchNavigationComposeKt {
    public static final void notesSearchNavigationGraph(NavGraphBuilder navGraphBuilder, final SearchNavigator navigator, final Function0<Unit> onDismissSearch) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(onDismissSearch, "onDismissSearch");
        String strGraphToRoute = NotesSearchNavigationMappingKt.graphToRoute(NotesSearchDestination.INSTANCE);
        NavGraphBuilderKt.navigation$default(navGraphBuilder, NotesSearchNavigationMappingKt.toRoute(NotesSearchDestination.InnerDestination.Search.INSTANCE), strGraphToRoute, (List) null, (List) null, ComposeAnimationUtilsKt.slidingNavGraphEnterTransition(strGraphToRoute), ComposeAnimationUtilsKt.slidingNavGraphExitTransition(strGraphToRoute), ComposeAnimationUtilsKt.slidingNavGraphEnterTransition(strGraphToRoute), ComposeAnimationUtilsKt.slidingNavGraphExitTransition(strGraphToRoute), (Function1) null, new Function1() { // from class: com.box.android.search.navigation.notes.compose.NotesSearchNavigationComposeKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NotesSearchNavigationComposeKt.notesSearchNavigationGraph$lambda$0(onDismissSearch, navigator, (NavGraphBuilder) obj);
            }
        }, 268, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit notesSearchNavigationGraph$lambda$0(final Function0 function0, final SearchNavigator searchNavigator, NavGraphBuilder navigation) {
        Intrinsics.checkNotNullParameter(navigation, "$this$navigation");
        NavGraphBuilderKt.composable$default(navigation, NotesSearchNavigationMappingKt.toRoute(NotesSearchDestination.InnerDestination.Search.INSTANCE), (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(1339964077, true, new Function4() { // from class: com.box.android.search.navigation.notes.compose.NotesSearchNavigationComposeKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return NotesSearchNavigationComposeKt.notesSearchNavigationGraph$lambda$0$0(function0, searchNavigator, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit notesSearchNavigationGraph$lambda$0$0(final Function0 function0, final SearchNavigator searchNavigator, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)31@1717L15,32@1828L733,32@1745L816:NotesSearchNavigationCompose.kt#e2tgxu");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1339964077, i, -1, "com.box.android.search.navigation.notes.compose.notesSearchNavigationGraph.<anonymous>.<anonymous> (NotesSearchNavigationCompose.kt:31)");
        }
        composer.startReplaceableGroup(1890788296);
        ComposerKt.sourceInformation(composer, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
        if (current == null) {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
        }
        ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
        composer.startReplaceableGroup(1729797275);
        ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
        if (current instanceof HasDefaultViewModelProviderFactory) {
            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
        } else {
            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
        }
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) NotesSearchViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        final NotesSearchViewModel notesSearchViewModel = (NotesSearchViewModel) viewModel;
        CompositionLocalKt.CompositionLocalProvider(ComposeAnimationUtilsKt.getLocalNavAnimatedVisibilityScope().provides(composable), ComposableLambdaKt.rememberComposableLambda(-2132193811, true, new Function2() { // from class: com.box.android.search.navigation.notes.compose.NotesSearchNavigationComposeKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NotesSearchNavigationComposeKt.notesSearchNavigationGraph$lambda$0$0$0(notesSearchViewModel, function0, searchNavigator, (Composer) obj, ((Integer) obj2).intValue());
            }
        }, composer, 54), composer, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit notesSearchNavigationGraph$lambda$0$0$0(NotesSearchViewModel notesSearchViewModel, Function0 function0, final SearchNavigator searchNavigator, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C33@1846L701:NotesSearchNavigationCompose.kt#e2tgxu");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2132193811, i, -1, "com.box.android.search.navigation.notes.compose.notesSearchNavigationGraph.<anonymous>.<anonymous>.<anonymous> (NotesSearchNavigationCompose.kt:33)");
            }
            Modifier modifierTestTag = TestTagKt.testTag(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), "NotesSearchScreen");
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierTestTag);
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
            ComposerKt.sourceInformationMarkerStart(composer, -2003800989, "C42@2235L272,38@2024L505:NotesSearchNavigationCompose.kt#e2tgxu");
            Store<SearchReducer.State, SearchReducer.Action> store = notesSearchViewModel.getStore();
            ComposerKt.sourceInformationMarkerStart(composer, 1736483095, "CC(remember):NotesSearchNavigationCompose.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(searchNavigator);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function2() { // from class: com.box.android.search.navigation.notes.compose.NotesSearchNavigationComposeKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NotesSearchNavigationComposeKt.notesSearchNavigationGraph$lambda$0$0$0$0$0$0(searchNavigator, (ItemModel) obj, (String) obj2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SearchScreenKt.SearchScreen(store, true, function0, (Function2) objRememberedValue, null, null, null, null, composer, 48, PsExtractor.VIDEO_STREAM_MASK);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit notesSearchNavigationGraph$lambda$0$0$0$0$0$0(SearchNavigator searchNavigator, ItemModel item, String str) {
        Intrinsics.checkNotNullParameter(item, "item");
        searchNavigator.navigateTo(new SearchDestination.OuterDestination.Item(item, str));
        return Unit.INSTANCE;
    }
}
