package com.box.android.collections.presentation.navigationmodernization.navigation.compose;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.LocalActivityKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation.NamedNavArgument;
import androidx.navigation.NamedNavArgumentKt;
import androidx.navigation.NavArgumentBuilder;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavType;
import androidx.navigation.compose.NavGraphBuilderKt;
import com.box.android.base.presentation.components.topbar.component.settings.UserAvatarViewModel;
import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.collections.presentation.navigationmodernization.CollectionsScreenKt;
import com.box.android.collections.presentation.navigationmodernization.CollectionsScreenViewModels;
import com.box.android.collections.presentation.navigationmodernization.CollectionsViewModel;
import com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt;
import com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListViewModel;
import com.box.android.collections.presentation.navigationmodernization.navigation.CollectionsDestination;
import com.box.android.collections.presentation.navigationmodernization.navigation.CollectionsNavigationConfig;
import com.box.android.collections.presentation.navigationmodernization.navigation.CollectionsNavigator;
import com.box.android.domain.models.CollectionType;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.preview.PreviewSource;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CollectionsNavigationCompose.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\u001aB\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0013\b\u0002\u0010\t\u001a\r\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\f\u001a\r\u0010\r\u001a\u00020\nH\u0003¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u008e\u0002"}, d2 = {"collectionsNavigationGraph", "", "Landroidx/navigation/NavGraphBuilder;", "collectionsNavigationConfig", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsNavigationConfig;", "navigator", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsNavigator;", "onNavigateToSettings", "Lkotlin/Function0;", "collectionsViewModelsProvider", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/compose/CollectionsViewModels;", "Landroidx/compose/runtime/Composable;", "(Landroidx/navigation/NavGraphBuilder;Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsNavigationConfig;Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsNavigator;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;)V", "defaultCollectionsViewModels", "(Landroidx/compose/runtime/Composer;I)Lcom/box/android/collections/presentation/navigationmodernization/navigation/compose/CollectionsViewModels;", "collections_generalProdRelease", "additionalDestinationsConsumed", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CollectionsNavigationComposeKt {

    /* JADX INFO: compiled from: CollectionsNavigationCompose.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CollectionType.values().length];
            try {
                iArr[CollectionType.FAVORITES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void collectionsNavigationGraph$default(NavGraphBuilder navGraphBuilder, CollectionsNavigationConfig collectionsNavigationConfig, CollectionsNavigator collectionsNavigator, Function0 function0, Function2 function2, int i, Object obj) {
        if ((i & 8) != 0) {
            function2 = new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.navigation.compose.CollectionsNavigationComposeKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return CollectionsNavigationComposeKt.collectionsNavigationGraph$lambda$0((Composer) obj2, ((Integer) obj3).intValue());
                }
            };
        }
        collectionsNavigationGraph(navGraphBuilder, collectionsNavigationConfig, collectionsNavigator, function0, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CollectionsViewModels collectionsNavigationGraph$lambda$0(Composer composer, int i) {
        composer.startReplaceGroup(1727136320);
        ComposerKt.sourceInformation(composer, "C40@2444L30:CollectionsNavigationCompose.kt#8az50f");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1727136320, i, -1, "com.box.android.collections.presentation.navigationmodernization.navigation.compose.collectionsNavigationGraph.<anonymous> (CollectionsNavigationCompose.kt:40)");
        }
        CollectionsViewModels collectionsViewModelsDefaultCollectionsViewModels = defaultCollectionsViewModels(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return collectionsViewModelsDefaultCollectionsViewModels;
    }

    public static final void collectionsNavigationGraph(NavGraphBuilder navGraphBuilder, final CollectionsNavigationConfig collectionsNavigationConfig, final CollectionsNavigator navigator, final Function0<Unit> onNavigateToSettings, final Function2<? super Composer, ? super Integer, CollectionsViewModels> collectionsViewModelsProvider) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(collectionsNavigationConfig, "collectionsNavigationConfig");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(onNavigateToSettings, "onNavigateToSettings");
        Intrinsics.checkNotNullParameter(collectionsViewModelsProvider, "collectionsViewModelsProvider");
        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navGraphBuilder.getProvider(), CollectionsNavigationMappingKt.toRoute(collectionsNavigationConfig.getStartDestination()), CollectionsNavigationMappingKt.graphToRoute(CollectionsDestination.INSTANCE));
        NavGraphBuilderKt.composable$default(navGraphBuilder2, CollectionsNavigationMappingKt.toRoute(CollectionsDestination.InnerDestination.Collections.INSTANCE), (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-1101539408, true, new Function4() { // from class: com.box.android.collections.presentation.navigationmodernization.navigation.compose.CollectionsNavigationComposeKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return CollectionsNavigationComposeKt.collectionsNavigationGraph$lambda$1$0(collectionsViewModelsProvider, collectionsNavigationConfig, navigator, onNavigateToSettings, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, (Object) null);
        NavGraphBuilderKt.composable$default(navGraphBuilder2, CollectionsNavigationMappingKt.toRoute(CollectionsDestination.InnerDestination.CollectionItemsList.INSTANCE), CollectionsKt.listOf((Object[]) new NamedNavArgument[]{NamedNavArgumentKt.navArgument("collection_id", new Function1() { // from class: com.box.android.collections.presentation.navigationmodernization.navigation.compose.CollectionsNavigationComposeKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CollectionsNavigationComposeKt.collectionsNavigationGraph$lambda$1$1((NavArgumentBuilder) obj);
            }
        }), NamedNavArgumentKt.navArgument(CollectionItemsNavArg.COLLECTION_NAME, new Function1() { // from class: com.box.android.collections.presentation.navigationmodernization.navigation.compose.CollectionsNavigationComposeKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CollectionsNavigationComposeKt.collectionsNavigationGraph$lambda$1$2((NavArgumentBuilder) obj);
            }
        }), NamedNavArgumentKt.navArgument("collection_type", new Function1() { // from class: com.box.android.collections.presentation.navigationmodernization.navigation.compose.CollectionsNavigationComposeKt$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CollectionsNavigationComposeKt.collectionsNavigationGraph$lambda$1$3((NavArgumentBuilder) obj);
            }
        })}), (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-1840802649, true, new Function4() { // from class: com.box.android.collections.presentation.navigationmodernization.navigation.compose.CollectionsNavigationComposeKt$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return CollectionsNavigationComposeKt.collectionsNavigationGraph$lambda$1$4(collectionsViewModelsProvider, navigator, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 252, (Object) null);
        navGraphBuilder.destination(navGraphBuilder2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit collectionsNavigationGraph$lambda$1$0(Function2 function2, CollectionsNavigationConfig collectionsNavigationConfig, CollectionsNavigator collectionsNavigator, Function0 function0, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)47@2763L31,48@2862L25,48@2845L42,51@3059L412,51@2992L479,62@3485L368:CollectionsNavigationCompose.kt#8az50f");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1101539408, i, -1, "com.box.android.collections.presentation.navigationmodernization.navigation.compose.collectionsNavigationGraph.<anonymous>.<anonymous> (CollectionsNavigationCompose.kt:47)");
        }
        CollectionsViewModels collectionsViewModels = (CollectionsViewModels) function2.invoke(composer, 0);
        Object[] objArr = new Object[0];
        ComposerKt.sourceInformationMarkerStart(composer, -2017412087, "CC(remember):CollectionsNavigationCompose.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.navigation.compose.CollectionsNavigationComposeKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CollectionsNavigationComposeKt.collectionsNavigationGraph$lambda$1$0$0$0();
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue, composer, 48);
        List<CollectionsDestination.InnerDestination> additionalDestinations = collectionsNavigationConfig.getAdditionalDestinations();
        ComposerKt.sourceInformationMarkerStart(composer, -2017405396, "CC(remember):CollectionsNavigationCompose.kt#9igjgp");
        boolean zChanged = composer.changed(mutableState) | composer.changedInstance(collectionsNavigationConfig) | composer.changedInstance(collectionsNavigator);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = (Function2) new CollectionsNavigationComposeKt$collectionsNavigationGraph$2$1$1$1(collectionsNavigationConfig, mutableState, collectionsNavigator, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(additionalDestinations, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composer, 0);
        CollectionsScreenKt.CollectionsScreen(collectionsNavigator, new CollectionsScreenViewModels(collectionsViewModels.getCollectionsViewModel(), collectionsViewModels.getUserAvatarViewModel()), function0, null, composer, 0, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState collectionsNavigationGraph$lambda$1$0$0$0() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean collectionsNavigationGraph$lambda$1$0$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void collectionsNavigationGraph$lambda$1$0$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit collectionsNavigationGraph$lambda$1$1(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(NavType.StringType);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit collectionsNavigationGraph$lambda$1$2(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(NavType.StringType);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit collectionsNavigationGraph$lambda$1$3(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.setType(new NavType.EnumType(CollectionType.class));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit collectionsNavigationGraph$lambda$1$4(Function2 function2, final CollectionsNavigator collectionsNavigator, AnimatedContentScope composable, NavBackStackEntry backStackEntry, Composer composer, int i) {
        Serializable serializable;
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
        ComposerKt.sourceInformation(composer, "CN(backStackEntry)91@4702L31,91@4734L30,92@4795L510,104@5351L317,112@5702L64,90@4647L1133:CollectionsNavigationCompose.kt#8az50f");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1840802649, i, -1, "com.box.android.collections.presentation.navigationmodernization.navigation.compose.collectionsNavigationGraph.<anonymous>.<anonymous> (CollectionsNavigationCompose.kt:86)");
        }
        Bundle arguments = backStackEntry.getArguments();
        final CollectionType collectionType = null;
        if (arguments != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                serializable = arguments.getSerializable("collection_type", CollectionType.class);
            } else {
                Serializable serializable2 = arguments.getSerializable("collection_type");
                serializable = (CollectionType) (serializable2 instanceof CollectionType ? serializable2 : null);
            }
            collectionType = (CollectionType) serializable;
        }
        CollectionItemsListViewModel collectionItemsListViewModelInvoke = ((CollectionsViewModels) function2.invoke(composer, 0)).getCollectionItemsListViewModel().invoke(composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, 515191589, "CC(remember):CollectionsNavigationCompose.kt#9igjgp");
        boolean zChanged = composer.changed(collectionType != null ? collectionType.ordinal() : -1) | composer.changedInstance(collectionsNavigator);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: com.box.android.collections.presentation.navigationmodernization.navigation.compose.CollectionsNavigationComposeKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CollectionsNavigationComposeKt.collectionsNavigationGraph$lambda$1$4$0$0(collectionType, collectionsNavigator, (ItemModel) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function1 function1 = (Function1) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 515209188, "CC(remember):CollectionsNavigationCompose.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(collectionsNavigator);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.navigation.compose.CollectionsNavigationComposeKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionsNavigationComposeKt.collectionsNavigationGraph$lambda$1$4$1$0(collectionsNavigator, (ItemModel) obj, (BottomSheetAttributes.BottomSheetMenuType) obj2);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        Function2 function3 = (Function2) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 515220167, "CC(remember):CollectionsNavigationCompose.kt#9igjgp");
        boolean zChangedInstance2 = composer.changedInstance(collectionsNavigator);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function0() { // from class: com.box.android.collections.presentation.navigationmodernization.navigation.compose.CollectionsNavigationComposeKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CollectionsNavigationComposeKt.collectionsNavigationGraph$lambda$1$4$2$0(collectionsNavigator);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        CollectionItemsListScreenKt.CollectionItemsListScreen(collectionItemsListViewModelInvoke, function1, function3, (Function0) objRememberedValue3, null, composer, 0, 16);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit collectionsNavigationGraph$lambda$1$4$0$0(CollectionType collectionType, CollectionsNavigator collectionsNavigator, ItemModel item) {
        PreviewSource.Collection collection;
        Intrinsics.checkNotNullParameter(item, "item");
        if ((collectionType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[collectionType.ordinal()]) == 1) {
            collection = PreviewSource.Favorites.INSTANCE;
        } else {
            collection = PreviewSource.Collection.INSTANCE;
        }
        collectionsNavigator.navigateTo(new CollectionsDestination.OuterDestination.Item(item, collection));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit collectionsNavigationGraph$lambda$1$4$1$0(CollectionsNavigator collectionsNavigator, ItemModel item, BottomSheetAttributes.BottomSheetMenuType menuType) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(menuType, "menuType");
        collectionsNavigator.navigateTo(new CollectionsDestination.OuterDestination.ItemMoreActionsMenu(item, menuType));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit collectionsNavigationGraph$lambda$1$4$2$0(CollectionsNavigator collectionsNavigator) {
        collectionsNavigator.popBackStack();
        return Unit.INSTANCE;
    }

    private static final CollectionsViewModels defaultCollectionsViewModels(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -853387799, "C(defaultCollectionsViewModels)128@6173L267:CollectionsNavigationCompose.kt#8az50f");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-853387799, i, -1, "com.box.android.collections.presentation.navigationmodernization.navigation.compose.defaultCollectionsViewModels (CollectionsNavigationCompose.kt:128)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 233080884, "CC(remember):CollectionsNavigationCompose.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new CollectionsViewModels(new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.navigation.compose.CollectionsNavigationComposeKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionsNavigationComposeKt.defaultCollectionsViewModels$lambda$0$0((Composer) obj, ((Integer) obj2).intValue());
                }
            }, new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.navigation.compose.CollectionsNavigationComposeKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionsNavigationComposeKt.defaultCollectionsViewModels$lambda$0$1((Composer) obj, ((Integer) obj2).intValue());
                }
            }, new Function2() { // from class: com.box.android.collections.presentation.navigationmodernization.navigation.compose.CollectionsNavigationComposeKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollectionsNavigationComposeKt.defaultCollectionsViewModels$lambda$0$2((Composer) obj, ((Integer) obj2).intValue());
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        CollectionsViewModels collectionsViewModels = (CollectionsViewModels) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return collectionsViewModels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CollectionsViewModel defaultCollectionsViewModels$lambda$0$0(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(-327514957);
        ComposerKt.sourceInformation(composer, "C130@6244L37:CollectionsNavigationCompose.kt#8az50f");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-327514957, i, -1, "com.box.android.collections.presentation.navigationmodernization.navigation.compose.defaultCollectionsViewModels.<anonymous>.<anonymous> (CollectionsNavigationCompose.kt:130)");
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
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) CollectionsViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        CollectionsViewModel collectionsViewModel = (CollectionsViewModel) viewModel;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return collectionsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CollectionItemsListViewModel defaultCollectionsViewModels$lambda$0$1(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(1183229033);
        ComposerKt.sourceInformation(composer, "C131@6326L45:CollectionsNavigationCompose.kt#8az50f");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1183229033, i, -1, "com.box.android.collections.presentation.navigationmodernization.navigation.compose.defaultCollectionsViewModels.<anonymous>.<anonymous> (CollectionsNavigationCompose.kt:131)");
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
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) CollectionItemsListViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        CollectionItemsListViewModel collectionItemsListViewModel = (CollectionItemsListViewModel) viewModel;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return collectionItemsListViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UserAvatarViewModel defaultCollectionsViewModels$lambda$0$2(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(-2122153974);
        ComposerKt.sourceInformation(composer, "C132@6407L23:CollectionsNavigationCompose.kt#8az50f");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2122153974, i, -1, "com.box.android.collections.presentation.navigationmodernization.navigation.compose.defaultCollectionsViewModels.<anonymous>.<anonymous> (CollectionsNavigationCompose.kt:132)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
        ProvidableCompositionLocal<Activity> localActivity = LocalActivityKt.getLocalActivity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localActivity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Intrinsics.checkNotNull(objConsume, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
        ComponentActivity componentActivity = (ComponentActivity) objConsume;
        composer.startReplaceableGroup(1890788296);
        ComposerKt.sourceInformation(composer, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
        ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(componentActivity, composer, 0);
        composer.startReplaceableGroup(1729797275);
        ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
        if (componentActivity instanceof HasDefaultViewModelProviderFactory) {
            defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
        } else {
            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
        }
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) UserAvatarViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(composer);
        UserAvatarViewModel userAvatarViewModel = (UserAvatarViewModel) viewModel;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return userAvatarViewModel;
    }
}
