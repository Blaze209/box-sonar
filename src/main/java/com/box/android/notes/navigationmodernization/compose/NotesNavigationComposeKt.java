package com.box.android.notes.navigationmodernization.compose;

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
import com.box.android.base.presentation.components.topbar.component.settings.UserAvatarViewModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.notes.navigationmodernization.NotesDestination;
import com.box.android.notes.navigationmodernization.NotesNavigationConfig;
import com.box.android.notes.navigationmodernization.NotesNavigator;
import com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt;
import com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsViewModel;
import com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsViewModels;
import com.box.android.notes.presentation.cpl.NotesFavoritesViewModel;
import com.box.android.notes.presentation.cpl.NotesRecentsViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotesNavigationCompose.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0082\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\b2\u0013\b\u0002\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00120\u000b¢\u0006\u0002\b\u0013¢\u0006\u0002\u0010\u0014\u001a\r\u0010\u0015\u001a\u00020\u0012H\u0003¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"notesNavigationGraph", "", "Landroidx/navigation/NavGraphBuilder;", "notesNavigationConfig", "Lcom/box/android/notes/navigationmodernization/NotesNavigationConfig;", "navigator", "Lcom/box/android/notes/navigationmodernization/NotesNavigator;", "onNavigateToNote", "Lkotlin/Function1;", "Lcom/box/android/domain/models/item/ItemModel;", "onNavigateToSearch", "Lkotlin/Function0;", "onNavigateToSettings", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "onInnerTabChanged", "", "notesViewModelsProvider", "Lcom/box/android/notes/navigationmodernization/compose/NotesViewModels;", "Landroidx/compose/runtime/Composable;", "(Landroidx/navigation/NavGraphBuilder;Lcom/box/android/notes/navigationmodernization/NotesNavigationConfig;Lcom/box/android/notes/navigationmodernization/NotesNavigator;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SnackbarHostState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "defaultNotesViewModels", "(Landroidx/compose/runtime/Composer;I)Lcom/box/android/notes/navigationmodernization/compose/NotesViewModels;", "notes_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NotesNavigationComposeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit notesNavigationGraph$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotesViewModels notesNavigationGraph$lambda$1(Composer composer, int i) {
        composer.startReplaceGroup(-1703689314);
        ComposerKt.sourceInformation(composer, "C35@1737L24:NotesNavigationCompose.kt#3ok2kn");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1703689314, i, -1, "com.box.android.notes.navigationmodernization.compose.notesNavigationGraph.<anonymous> (NotesNavigationCompose.kt:35)");
        }
        NotesViewModels notesViewModelsDefaultNotesViewModels = defaultNotesViewModels(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return notesViewModelsDefaultNotesViewModels;
    }

    public static final void notesNavigationGraph(NavGraphBuilder navGraphBuilder, final NotesNavigationConfig notesNavigationConfig, final NotesNavigator navigator, final Function1<? super ItemModel, Unit> onNavigateToNote, final Function0<Unit> onNavigateToSearch, final Function0<Unit> onNavigateToSettings, final SnackbarHostState snackbarHostState, final Function1<? super String, Unit> onInnerTabChanged, final Function2<? super Composer, ? super Integer, NotesViewModels> notesViewModelsProvider) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "<this>");
        Intrinsics.checkNotNullParameter(notesNavigationConfig, "notesNavigationConfig");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(onNavigateToNote, "onNavigateToNote");
        Intrinsics.checkNotNullParameter(onNavigateToSearch, "onNavigateToSearch");
        Intrinsics.checkNotNullParameter(onNavigateToSettings, "onNavigateToSettings");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Intrinsics.checkNotNullParameter(onInnerTabChanged, "onInnerTabChanged");
        Intrinsics.checkNotNullParameter(notesViewModelsProvider, "notesViewModelsProvider");
        String strGraphToRoute = NotesNavigationMappingKt.graphToRoute(NotesDestination.INSTANCE);
        NavGraphBuilder navGraphBuilder2 = new NavGraphBuilder(navGraphBuilder.getProvider(), NotesNavigationMappingKt.toRoute(notesNavigationConfig.getStartDestination()), strGraphToRoute);
        NavGraphBuilderKt.composable$default(navGraphBuilder2, NotesNavigationMappingKt.toRoute(notesNavigationConfig.getStartDestination()), (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-1380742922, true, new Function4() { // from class: com.box.android.notes.navigationmodernization.compose.NotesNavigationComposeKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return NotesNavigationComposeKt.notesNavigationGraph$lambda$2$0(notesNavigationConfig, notesViewModelsProvider, navigator, onNavigateToNote, onNavigateToSearch, onNavigateToSettings, snackbarHostState, onInnerTabChanged, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, (Object) null);
        navGraphBuilder.destination(navGraphBuilder2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit notesNavigationGraph$lambda$2$0(NotesNavigationConfig notesNavigationConfig, Function2 function2, NotesNavigator notesNavigator, Function1 function1, Function0 function0, Function0 function3, SnackbarHostState snackbarHostState, Function1 function4, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)44@2131L25,42@2008L497:NotesNavigationCompose.kt#3ok2kn");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1380742922, i, -1, "com.box.android.notes.navigationmodernization.compose.notesNavigationGraph.<anonymous>.<anonymous> (NotesNavigationCompose.kt:42)");
        }
        NotesTabsScreenKt.NotesTabsScreen(notesNavigationConfig.getStartDestination(), ((NotesViewModels) function2.invoke(composer, 0)).getTabsViewModels(), notesNavigator, function1, function0, function3, snackbarHostState, null, function4, composer, 0, 128);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    private static final NotesViewModels defaultNotesViewModels(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 925863037, "C(defaultNotesViewModels)60@2689L400:NotesNavigationCompose.kt#3ok2kn");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(925863037, i, -1, "com.box.android.notes.navigationmodernization.compose.defaultNotesViewModels (NotesNavigationCompose.kt:60)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 696150221, "CC(remember):NotesNavigationCompose.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new NotesViewModels(new NotesTabsViewModels(new Function2() { // from class: com.box.android.notes.navigationmodernization.compose.NotesNavigationComposeKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesNavigationComposeKt.defaultNotesViewModels$lambda$0$0((Composer) obj, ((Integer) obj2).intValue());
                }
            }, new Function2() { // from class: com.box.android.notes.navigationmodernization.compose.NotesNavigationComposeKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesNavigationComposeKt.defaultNotesViewModels$lambda$0$1((Composer) obj, ((Integer) obj2).intValue());
                }
            }, new Function2() { // from class: com.box.android.notes.navigationmodernization.compose.NotesNavigationComposeKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesNavigationComposeKt.defaultNotesViewModels$lambda$0$2((Composer) obj, ((Integer) obj2).intValue());
                }
            }, new Function2() { // from class: com.box.android.notes.navigationmodernization.compose.NotesNavigationComposeKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesNavigationComposeKt.defaultNotesViewModels$lambda$0$3((Composer) obj, ((Integer) obj2).intValue());
                }
            }));
            composer.updateRememberedValue(objRememberedValue);
        }
        NotesViewModels notesViewModels = (NotesViewModels) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return notesViewModels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotesTabsViewModel defaultNotesViewModels$lambda$0$0(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(836559275);
        ComposerKt.sourceInformation(composer, "C63@2793L43:NotesNavigationCompose.kt#3ok2kn");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(836559275, i, -1, "com.box.android.notes.navigationmodernization.compose.defaultNotesViewModels.<anonymous>.<anonymous> (NotesNavigationCompose.kt:63)");
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
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) NotesTabsViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(composer);
        NotesTabsViewModel notesTabsViewModel = (NotesTabsViewModel) viewModel;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return notesTabsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotesRecentsViewModel defaultNotesViewModels$lambda$0$1(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(-315474632);
        ComposerKt.sourceInformation(composer, "C64@2873L46:NotesNavigationCompose.kt#3ok2kn");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-315474632, i, -1, "com.box.android.notes.navigationmodernization.compose.defaultNotesViewModels.<anonymous>.<anonymous> (NotesNavigationCompose.kt:64)");
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
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) NotesRecentsViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(composer);
        NotesRecentsViewModel notesRecentsViewModel = (NotesRecentsViewModel) viewModel;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return notesRecentsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotesFavoritesViewModel defaultNotesViewModels$lambda$0$2(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(-1850130502);
        ComposerKt.sourceInformation(composer, "C65@2958L48:NotesNavigationCompose.kt#3ok2kn");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1850130502, i, -1, "com.box.android.notes.navigationmodernization.compose.defaultNotesViewModels.<anonymous>.<anonymous> (NotesNavigationCompose.kt:65)");
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
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) NotesFavoritesViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(composer);
        NotesFavoritesViewModel notesFavoritesViewModel = (NotesFavoritesViewModel) viewModel;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return notesFavoritesViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UserAvatarViewModel defaultNotesViewModels$lambda$0$3(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(-58630771);
        ComposerKt.sourceInformation(composer, "C66@3046L23:NotesNavigationCompose.kt#3ok2kn");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-58630771, i, -1, "com.box.android.notes.navigationmodernization.compose.defaultNotesViewModels.<anonymous>.<anonymous> (NotesNavigationCompose.kt:66)");
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
