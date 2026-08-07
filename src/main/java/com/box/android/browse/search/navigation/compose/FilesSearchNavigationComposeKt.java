package com.box.android.browse.search.navigation.compose;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.TestTagKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.compose.NavGraphBuilderKt;
import com.box.android.base.compose.ComposeAnimationUtilsKt;
import com.box.android.base.compose.ComposeFragmentInjector;
import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.base.presentation.message.BoxMessageDispatcher;
import com.box.android.browse.search.FilesSearchScreenKt;
import com.box.android.browse.search.navigation.FilesSearchDestination;
import com.box.android.browse.search.navigation.FilesSearchNavigator;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxSearchItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilesSearchNavigationCompose.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"filesSearchNavigationGraph", "", "Landroidx/navigation/NavGraphBuilder;", "navigator", "Lcom/box/android/browse/search/navigation/FilesSearchNavigator;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "composeFragmentInjector", "Lcom/box/android/base/compose/ComposeFragmentInjector;", "boxMessageDispatcher", "Lcom/box/android/base/presentation/message/BoxMessageDispatcher;", "browse_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FilesSearchNavigationComposeKt {
    public static final void filesSearchNavigationGraph(NavGraphBuilder navGraphBuilder, final FilesSearchNavigator navigator, final IUserContextManager userContextManager, final ComposeFragmentInjector composeFragmentInjector, final BoxMessageDispatcher boxMessageDispatcher) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(composeFragmentInjector, "composeFragmentInjector");
        Intrinsics.checkNotNullParameter(boxMessageDispatcher, "boxMessageDispatcher");
        String strGraphToRoute = FilesSearchNavigationMappingKt.graphToRoute(FilesSearchDestination.INSTANCE);
        NavGraphBuilderKt.navigation$default(navGraphBuilder, FilesSearchNavigationMappingKt.toRoute(FilesSearchDestination.InnerDestination.Search.INSTANCE), strGraphToRoute, (List) null, (List) null, ComposeAnimationUtilsKt.slidingNavGraphEnterTransition(strGraphToRoute), ComposeAnimationUtilsKt.slidingNavGraphExitTransition(strGraphToRoute), ComposeAnimationUtilsKt.slidingNavGraphEnterTransition(strGraphToRoute), ComposeAnimationUtilsKt.slidingNavGraphExitTransition(strGraphToRoute), (Function1) null, new Function1() { // from class: com.box.android.browse.search.navigation.compose.FilesSearchNavigationComposeKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FilesSearchNavigationComposeKt.filesSearchNavigationGraph$lambda$0(userContextManager, composeFragmentInjector, boxMessageDispatcher, navigator, (NavGraphBuilder) obj);
            }
        }, 268, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit filesSearchNavigationGraph$lambda$0(final IUserContextManager iUserContextManager, final ComposeFragmentInjector composeFragmentInjector, final BoxMessageDispatcher boxMessageDispatcher, final FilesSearchNavigator filesSearchNavigator, NavGraphBuilder navigation) {
        Intrinsics.checkNotNullParameter(navigation, "$this$navigation");
        NavGraphBuilderKt.composable$default(navigation, FilesSearchNavigationMappingKt.toRoute(FilesSearchDestination.InnerDestination.Search.INSTANCE), (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-1537905912, true, new Function4() { // from class: com.box.android.browse.search.navigation.compose.FilesSearchNavigationComposeKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return FilesSearchNavigationComposeKt.filesSearchNavigationGraph$lambda$0$0(iUserContextManager, composeFragmentInjector, boxMessageDispatcher, filesSearchNavigator, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit filesSearchNavigationGraph$lambda$0$0(final IUserContextManager iUserContextManager, final ComposeFragmentInjector composeFragmentInjector, final BoxMessageDispatcher boxMessageDispatcher, final FilesSearchNavigator filesSearchNavigator, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)39@2037L1250,39@1954L1333:FilesSearchNavigationCompose.kt#196djd");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1537905912, i, -1, "com.box.android.browse.search.navigation.compose.filesSearchNavigationGraph.<anonymous>.<anonymous> (FilesSearchNavigationCompose.kt:39)");
        }
        CompositionLocalKt.CompositionLocalProvider(ComposeAnimationUtilsKt.getLocalNavAnimatedVisibilityScope().provides(composable), ComposableLambdaKt.rememberComposableLambda(-1861279800, true, new Function2() { // from class: com.box.android.browse.search.navigation.compose.FilesSearchNavigationComposeKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return FilesSearchNavigationComposeKt.filesSearchNavigationGraph$lambda$0$0$0(iUserContextManager, composeFragmentInjector, boxMessageDispatcher, filesSearchNavigator, (Composer) obj, ((Integer) obj2).intValue());
            }
        }, composer, 54), composer, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit filesSearchNavigationGraph$lambda$0$0$0(IUserContextManager iUserContextManager, ComposeFragmentInjector composeFragmentInjector, BoxMessageDispatcher boxMessageDispatcher, final FilesSearchNavigator filesSearchNavigator, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C45@2382L72,48@2496L211,53@2759L426,40@2055L1218:FilesSearchNavigationCompose.kt#196djd");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1861279800, i, -1, "com.box.android.browse.search.navigation.compose.filesSearchNavigationGraph.<anonymous>.<anonymous>.<anonymous> (FilesSearchNavigationCompose.kt:40)");
            }
            BoxFolder boxFolderCreateFromId = BoxFolder.createFromId("0");
            ComposerKt.sourceInformationMarkerStart(composer, -1983481552, "CC(remember):FilesSearchNavigationCompose.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(filesSearchNavigator);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.browse.search.navigation.compose.FilesSearchNavigationComposeKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilesSearchNavigationComposeKt.filesSearchNavigationGraph$lambda$0$0$0$0$0(filesSearchNavigator);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1983477765, "CC(remember):FilesSearchNavigationCompose.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(filesSearchNavigator);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.browse.search.navigation.compose.FilesSearchNavigationComposeKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FilesSearchNavigationComposeKt.filesSearchNavigationGraph$lambda$0$0$0$1$0(filesSearchNavigator, (BoxSearchItem) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function1 function1 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1983469134, "CC(remember):FilesSearchNavigationCompose.kt#9igjgp");
            boolean zChangedInstance3 = composer.changedInstance(filesSearchNavigator);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.box.android.browse.search.navigation.compose.FilesSearchNavigationComposeKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FilesSearchNavigationComposeKt.filesSearchNavigationGraph$lambda$0$0$0$2$0(filesSearchNavigator, (BoxSearchItem) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FilesSearchScreenKt.FilesSearchScreen(iUserContextManager, boxFolderCreateFromId, composeFragmentInjector, boxMessageDispatcher, function0, function1, (Function1) objRememberedValue3, TestTagKt.testTag(Modifier.INSTANCE, "FilesSearchScreen"), null, composer, (BoxMessageDispatcher.$stable << 9) | 12582912, 256);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit filesSearchNavigationGraph$lambda$0$0$0$0$0(FilesSearchNavigator filesSearchNavigator) {
        filesSearchNavigator.popBackStack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit filesSearchNavigationGraph$lambda$0$0$0$1$0(FilesSearchNavigator filesSearchNavigator, BoxSearchItem boxSearchItem) {
        Intrinsics.checkNotNullParameter(boxSearchItem, "boxSearchItem");
        filesSearchNavigator.navigateTo(new FilesSearchDestination.OuterDestination.FilesSearchItem(boxSearchItem));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit filesSearchNavigationGraph$lambda$0$0$0$2$0(FilesSearchNavigator filesSearchNavigator, BoxSearchItem boxSearchItem) {
        Intrinsics.checkNotNullParameter(boxSearchItem, "boxSearchItem");
        filesSearchNavigator.navigateTo(new FilesSearchDestination.OuterDestination.FilesSearchItemMoreActionsMenu(boxSearchItem, BottomSheetAttributes.BottomSheetMenuType.AddRemoveCollectionItems.INSTANCE));
        return Unit.INSTANCE;
    }
}
