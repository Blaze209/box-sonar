package com.box.android.boxai.homescreen;

import android.app.Activity;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.LocalActivityKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.compose.NavGraphBuilderKt;
import com.box.android.base.cpl.IPreviewLauncher;
import com.box.android.coreservices.services.IntentServices;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiNavigationCompose.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aD\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0013\b\u0002\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u000f\u001a\r\u0010\u0010\u001a\u00020\rH\u0003¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"boxAiNavigationGraph", "", "Landroidx/navigation/NavGraphBuilder;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "previewLauncher", "Lcom/box/android/base/cpl/IPreviewLauncher;", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "aiCenterViewFactory", "Lcom/box/android/boxai/homescreen/AiCenterViewFactory;", "viewModelsProvider", "Lkotlin/Function0;", "Lcom/box/android/boxai/homescreen/BoxAiViewModels;", "Landroidx/compose/runtime/Composable;", "(Landroidx/navigation/NavGraphBuilder;Lcom/box/android/coreservices/services/IntentServices;Lcom/box/android/base/cpl/IPreviewLauncher;Landroidx/compose/material3/SnackbarHostState;Lcom/box/android/boxai/homescreen/AiCenterViewFactory;Lkotlin/jvm/functions/Function2;)V", "defaultBoxAiViewModels", "(Landroidx/compose/runtime/Composer;I)Lcom/box/android/boxai/homescreen/BoxAiViewModels;", "boxai_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxAiNavigationComposeKt {
    public static /* synthetic */ void boxAiNavigationGraph$default(NavGraphBuilder navGraphBuilder, IntentServices intentServices, IPreviewLauncher iPreviewLauncher, SnackbarHostState snackbarHostState, AiCenterViewFactory aiCenterViewFactory, Function2 function2, int i, Object obj) {
        if ((i & 16) != 0) {
            function2 = new Function2() { // from class: com.box.android.boxai.homescreen.BoxAiNavigationComposeKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return BoxAiNavigationComposeKt.boxAiNavigationGraph$lambda$0((Composer) obj2, ((Integer) obj3).intValue());
                }
            };
        }
        boxAiNavigationGraph(navGraphBuilder, intentServices, iPreviewLauncher, snackbarHostState, aiCenterViewFactory, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BoxAiViewModels boxAiNavigationGraph$lambda$0(Composer composer, int i) {
        composer.startReplaceGroup(1219421039);
        ComposerKt.sourceInformation(composer, "C17@740L24:BoxAiNavigationCompose.kt#ti6sa3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1219421039, i, -1, "com.box.android.boxai.homescreen.boxAiNavigationGraph.<anonymous> (BoxAiNavigationCompose.kt:17)");
        }
        BoxAiViewModels boxAiViewModelsDefaultBoxAiViewModels = defaultBoxAiViewModels(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return boxAiViewModelsDefaultBoxAiViewModels;
    }

    public static final void boxAiNavigationGraph(NavGraphBuilder navGraphBuilder, final IntentServices intentServices, final IPreviewLauncher previewLauncher, final SnackbarHostState snackbarHostState, final AiCenterViewFactory aiCenterViewFactory, final Function2<? super Composer, ? super Integer, BoxAiViewModels> viewModelsProvider) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Intrinsics.checkNotNullParameter(previewLauncher, "previewLauncher");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Intrinsics.checkNotNullParameter(aiCenterViewFactory, "aiCenterViewFactory");
        Intrinsics.checkNotNullParameter(viewModelsProvider, "viewModelsProvider");
        String strGraphToRoute = BoxAINavigationMappingKt.graphToRoute(BoxAiDestination.INSTANCE);
        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navGraphBuilder.getProvider(), BoxAINavigationMappingKt.toRoute(BoxAiDestination.HomeScreen.INSTANCE), strGraphToRoute);
        NavGraphBuilderKt.composable$default(navGraphBuilder2, BoxAINavigationMappingKt.toRoute(BoxAiDestination.HomeScreen.INSTANCE), (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(881934080, true, new Function4() { // from class: com.box.android.boxai.homescreen.BoxAiNavigationComposeKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BoxAiNavigationComposeKt.boxAiNavigationGraph$lambda$1$0(viewModelsProvider, intentServices, aiCenterViewFactory, previewLauncher, snackbarHostState, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, (Object) null);
        navGraphBuilder.destination(navGraphBuilder2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit boxAiNavigationGraph$lambda$1$0(Function2 function2, IntentServices intentServices, AiCenterViewFactory aiCenterViewFactory, IPreviewLauncher iPreviewLauncher, SnackbarHostState snackbarHostState, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)29@1248L20,29@1269L11,24@989L305:BoxAiNavigationCompose.kt#ti6sa3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(881934080, i, -1, "com.box.android.boxai.homescreen.boxAiNavigationGraph.<anonymous>.<anonymous> (BoxAiNavigationCompose.kt:24)");
        }
        BoxAiHomeScreenKt.BoxAiHomeScreen(intentServices, null, aiCenterViewFactory, null, null, iPreviewLauncher, snackbarHostState, ((BoxAiViewModels) function2.invoke(composer, 0)).getViewModel().invoke(composer, 0), null, null, composer, 0, 794);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    private static final BoxAiViewModels defaultBoxAiViewModels(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1417128119, "C(defaultBoxAiViewModels)39@1492L60:BoxAiNavigationCompose.kt#ti6sa3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1417128119, i, -1, "com.box.android.boxai.homescreen.defaultBoxAiViewModels (BoxAiNavigationCompose.kt:39)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 355491123, "CC(remember):BoxAiNavigationCompose.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new BoxAiViewModels(new Function2() { // from class: com.box.android.boxai.homescreen.BoxAiNavigationComposeKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiNavigationComposeKt.defaultBoxAiViewModels$lambda$0$0((Composer) obj, ((Integer) obj2).intValue());
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        BoxAiViewModels boxAiViewModels = (BoxAiViewModels) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return boxAiViewModels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BoxAiHomeViewModel defaultBoxAiViewModels$lambda$0$0(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(993099304);
        ComposerKt.sourceInformation(composer, "C40@1525L23:BoxAiNavigationCompose.kt#ti6sa3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(993099304, i, -1, "com.box.android.boxai.homescreen.defaultBoxAiViewModels.<anonymous>.<anonymous> (BoxAiNavigationCompose.kt:40)");
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
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) BoxAiHomeViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(composer);
        BoxAiHomeViewModel boxAiHomeViewModel = (BoxAiHomeViewModel) viewModel;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return boxAiHomeViewModel;
    }
}
