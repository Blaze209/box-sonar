package com.box.android.navigationmodernization.navigation.compose;

import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.animation.SharedTransitionScopeKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProduceStateScope;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavHostKt;
import com.box.android.R;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.ComposeAnimationUtilsKt;
import com.box.android.base.compose.ComposeFragmentInjector;
import com.box.android.base.compose.SwipeableSnackbarHostKt;
import com.box.android.base.cpl.IPreviewLauncher;
import com.box.android.base.presentation.message.BoxMessageDispatcher;
import com.box.android.boxai.homescreen.AiCenterViewFactory;
import com.box.android.browse.search.navigation.compose.FilesSearchNavigationComposeKt;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DomainErrorKt;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.inbox.InboxNavigationComposeKt;
import com.box.android.navigationmodernization.MainNavigationViewModel;
import com.box.android.navigationmodernization.homescreen.HomeNavigationComposeKt;
import com.box.android.navigationmodernization.navigation.MainNavigationTargetRequestHandler;
import com.box.android.navigationmodernization.navigation.RootNavigationConfig;
import com.box.android.navigationmodernization.navigation.RootNavigationDependencies;
import com.box.android.navigationmodernization.navigation.RootNavigationDestination;
import com.box.android.navigationmodernization.navigation.configuration.RootNavigationConfigurator;
import com.box.android.navigationmodernization.navigation.navigator.RootNavigator;
import com.box.android.search.navigation.compose.SearchNavigationComposeKt;
import com.box.android.search.navigation.notes.compose.NotesSearchNavigationComposeKt;
import com.box.brownfieldApi.featuresNavigator.AiCenterLaunchMode;
import com.box.brownfieldApi.featuresNavigator.HostSurface;
import com.margelo.nitro.boxcontext.providers.StyleVariant;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RootNavHost.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001aY\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010\u0018\u001a\f\u0010\u0019\u001a\u00020\u001a*\u00020\u001bH\u0002¨\u0006\u001c²\u0006\n\u0010\u001d\u001a\u00020\u001eX\u008a\u0084\u0002²\u0006\n\u0010\u001f\u001a\u00020\u001eX\u008a\u008e\u0002²\u0006\f\u0010 \u001a\u0004\u0018\u00010\u001bX\u008a\u008e\u0002"}, d2 = {"RootNavHost", "", "rootNavigationDependencies", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDependencies;", "composeFragmentInjector", "Lcom/box/android/base/compose/ComposeFragmentInjector;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "previewLauncher", "Lcom/box/android/base/cpl/IPreviewLauncher;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "boxMessageDispatcher", "Lcom/box/android/base/presentation/message/BoxMessageDispatcher;", "aiCenterViewFactory", "Lcom/box/android/boxai/homescreen/AiCenterViewFactory;", "modifier", "Landroidx/compose/ui/Modifier;", "mainNavigationViewModel", "Lcom/box/android/navigationmodernization/MainNavigationViewModel;", "(Lcom/box/android/navigationmodernization/navigation/RootNavigationDependencies;Lcom/box/android/base/compose/ComposeFragmentInjector;Lcom/box/android/coreservices/services/IntentServices;Lcom/box/android/base/cpl/IPreviewLauncher;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/base/presentation/message/BoxMessageDispatcher;Lcom/box/android/boxai/homescreen/AiCenterViewFactory;Landroidx/compose/ui/Modifier;Lcom/box/android/navigationmodernization/MainNavigationViewModel;Landroidx/compose/runtime/Composer;II)V", "MainNavigationTargetHandling", "rootSnackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "(Lcom/box/android/navigationmodernization/navigation/RootNavigationDependencies;Lcom/box/android/navigationmodernization/MainNavigationViewModel;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/runtime/Composer;I)V", "toNavigationErrorMessageRes", "", "Lcom/box/android/domain/models/DomainError;", "box_generalProdRelease", "initialized", "", "additionalDestinationsConsumed", "navigationError"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RootNavHostKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainNavigationTargetHandling$lambda$7(RootNavigationDependencies rootNavigationDependencies, MainNavigationViewModel mainNavigationViewModel, SnackbarHostState snackbarHostState, int i, Composer composer, int i2) {
        MainNavigationTargetHandling(rootNavigationDependencies, mainNavigationViewModel, snackbarHostState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RootNavHost$lambda$2(RootNavigationDependencies rootNavigationDependencies, ComposeFragmentInjector composeFragmentInjector, IntentServices intentServices, IPreviewLauncher iPreviewLauncher, IUserContextManager iUserContextManager, BoxMessageDispatcher boxMessageDispatcher, AiCenterViewFactory aiCenterViewFactory, Modifier modifier, MainNavigationViewModel mainNavigationViewModel, int i, int i2, Composer composer, int i3) {
        RootNavHost(rootNavigationDependencies, composeFragmentInjector, intentServices, iPreviewLauncher, iUserContextManager, boxMessageDispatcher, aiCenterViewFactory, modifier, mainNavigationViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RootNavHost$lambda$7(RootNavigationDependencies rootNavigationDependencies, ComposeFragmentInjector composeFragmentInjector, IntentServices intentServices, IPreviewLauncher iPreviewLauncher, IUserContextManager iUserContextManager, BoxMessageDispatcher boxMessageDispatcher, AiCenterViewFactory aiCenterViewFactory, Modifier modifier, MainNavigationViewModel mainNavigationViewModel, int i, int i2, Composer composer, int i3) {
        RootNavHost(rootNavigationDependencies, composeFragmentInjector, intentServices, iPreviewLauncher, iUserContextManager, boxMessageDispatcher, aiCenterViewFactory, modifier, mainNavigationViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x014e  */
    /* JADX WARN: Code duplicated, block: B:102:0x0163  */
    /* JADX WARN: Code duplicated, block: B:104:0x0176  */
    /* JADX WARN: Code duplicated, block: B:105:0x017e  */
    /* JADX WARN: Code duplicated, block: B:107:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:109:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:112:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:117:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:120:0x020f  */
    /* JADX WARN: Code duplicated, block: B:122:0x0215  */
    /* JADX WARN: Code duplicated, block: B:125:0x021e  */
    /* JADX WARN: Code duplicated, block: B:128:0x022b  */
    /* JADX WARN: Code duplicated, block: B:130:0x024e  */
    /* JADX WARN: Code duplicated, block: B:133:0x026e  */
    /* JADX WARN: Code duplicated, block: B:136:0x031c  */
    /* JADX WARN: Code duplicated, block: B:139:0x0328  */
    /* JADX WARN: Code duplicated, block: B:140:0x032c  */
    /* JADX WARN: Code duplicated, block: B:143:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:145:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:148:0x03ba  */
    /* JADX WARN: Code duplicated, block: B:149:0x03d3 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:79:0x0102  */
    /* JADX WARN: Code duplicated, block: B:82:0x010e  */
    /* JADX WARN: Code duplicated, block: B:83:0x0110  */
    /* JADX WARN: Code duplicated, block: B:86:0x0119  */
    /* JADX WARN: Code duplicated, block: B:95:0x0142 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:96:0x0144  */
    /* JADX WARN: Code duplicated, block: B:97:0x0149  */
    public static final void RootNavHost(final RootNavigationDependencies rootNavigationDependencies, final ComposeFragmentInjector composeFragmentInjector, final IntentServices intentServices, final IPreviewLauncher previewLauncher, final IUserContextManager userContextManager, final BoxMessageDispatcher boxMessageDispatcher, final AiCenterViewFactory aiCenterViewFactory, Modifier modifier, MainNavigationViewModel mainNavigationViewModel, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        Composer composer2;
        final MainNavigationViewModel mainNavigationViewModel2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        Modifier.Companion companion;
        Composer composer3;
        boolean z2;
        int i4;
        final MainNavigationViewModel mainNavigationViewModel3;
        ViewModelStoreOwner current;
        CreationExtras.Empty defaultViewModelCreationExtras;
        RootNavigationConfigurator navigationConfigurator;
        Boolean boolValueOf;
        final Modifier modifier4;
        boolean zChangedInstance;
        RootNavHostKt$RootNavHost$initialized$2$1 rootNavHostKt$RootNavHost$initialized$2$1RememberedValue;
        int i5;
        Object objRememberedValue;
        Object objRememberedValue2;
        Function0<ComposeUiNode> constructor;
        Intrinsics.checkNotNullParameter(rootNavigationDependencies, "rootNavigationDependencies");
        Intrinsics.checkNotNullParameter(composeFragmentInjector, "composeFragmentInjector");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Intrinsics.checkNotNullParameter(previewLauncher, "previewLauncher");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(boxMessageDispatcher, "boxMessageDispatcher");
        Intrinsics.checkNotNullParameter(aiCenterViewFactory, "aiCenterViewFactory");
        Composer composerStartRestartGroup = composer.startRestartGroup(-831764453);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RootNavHost)N(rootNavigationDependencies,composeFragmentInjector,intentServices,previewLauncher,userContextManager,boxMessageDispatcher,aiCenterViewFactory,modifier,mainNavigationViewModel)68@3659L66,68@3621L104,76@3953L32,77@4018L32,79@4056L213,85@4295L132,91@4456L4946,91@4433L4969,179@9407L262:RootNavHost.kt#giu8m4");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(rootNavigationDependencies) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(composeFragmentInjector) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(intentServices) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(previewLauncher) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(userContextManager) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= (262144 & i) == 0 ? composerStartRestartGroup.changed(boxMessageDispatcher) : composerStartRestartGroup.changedInstance(boxMessageDispatcher) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= (2097152 & i) == 0 ? composerStartRestartGroup.changed(aiCenterViewFactory) : composerStartRestartGroup.changedInstance(aiCenterViewFactory) ? 1048576 : 524288;
        }
        int i6 = i2 & 128;
        if (i6 == 0) {
            if ((12582912 & i) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 8388608 : 4194304;
            }
            if ((100663296 & i) != 0) {
                i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changedInstance(mainNavigationViewModel)) ? 33554432 : 67108864;
            }
            if ((38347923 & i3) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "65@3473L15");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 256) != 0) {
                        composerStartRestartGroup.startReplaceableGroup(1890788296);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                        current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
                        if (current == null) {
                            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                        }
                        ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composerStartRestartGroup, 0);
                        composerStartRestartGroup.startReplaceableGroup(1729797275);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                        if (current instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        z2 = false;
                        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) MainNavigationViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                        composer3 = composerStartRestartGroup;
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        MainNavigationViewModel mainNavigationViewModel4 = (MainNavigationViewModel) viewModel;
                        i4 = i3 & (-234881025);
                        mainNavigationViewModel3 = mainNavigationViewModel4;
                    } else {
                        composer3 = composerStartRestartGroup;
                        z2 = false;
                        i4 = i3;
                        mainNavigationViewModel3 = mainNavigationViewModel;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                    }
                    i4 = i3;
                    companion = modifier2;
                    z2 = false;
                    mainNavigationViewModel3 = mainNavigationViewModel;
                    composer3 = composerStartRestartGroup;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-831764453, i4, -1, "com.box.android.navigationmodernization.navigation.compose.RootNavHost (RootNavHost.kt:66)");
                }
                navigationConfigurator = rootNavigationDependencies.getNavigationConfigurator();
                boolValueOf = Boolean.valueOf(z2);
                modifier4 = companion;
                ComposerKt.sourceInformationMarkerStart(composer3, -461702339, "CC(remember):RootNavHost.kt#9igjgp");
                zChangedInstance = composer3.changedInstance(navigationConfigurator);
                rootNavHostKt$RootNavHost$initialized$2$1RememberedValue = composer3.rememberedValue();
                i5 = i4;
                if (!zChangedInstance || rootNavHostKt$RootNavHost$initialized$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    rootNavHostKt$RootNavHost$initialized$2$1RememberedValue = new RootNavHostKt$RootNavHost$initialized$2$1(navigationConfigurator, null);
                    composer3.updateRememberedValue(rootNavHostKt$RootNavHost$initialized$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                if (!RootNavHost$lambda$1(SnapshotStateKt.produceState(boolValueOf, navigationConfigurator, (Function2<? super ProduceStateScope<Boolean>, ? super Continuation<? super Unit>, ? extends Object>) rootNavHostKt$RootNavHost$initialized$2$1RememberedValue, composer3, 6))) {
                    MainNavigationViewModel mainNavigationViewModel5 = mainNavigationViewModel3;
                    final RootNavigator navigator = rootNavigationDependencies.getNavigator();
                    final RootNavigationConfig startNavigationConfig = rootNavigationDependencies.getNavigationConfigurator().getStartNavigationConfig();
                    ComposerKt.sourceInformationMarkerStart(composer3, -461692965, "CC(remember):RootNavHost.kt#9igjgp");
                    objRememberedValue = composer3.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new SnackbarHostState();
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    final SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -461690885, "CC(remember):RootNavHost.kt#9igjgp");
                    objRememberedValue2 = composer3.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new SnackbarHostState();
                        composer3.updateRememberedValue(objRememberedValue2);
                    }
                    SnackbarHostState snackbarHostState2 = (SnackbarHostState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    MainNavigationTargetHandling(rootNavigationDependencies, mainNavigationViewModel5, snackbarHostState2, composer3, (i5 & 14) | 384 | ((i5 >> 21) & 112));
                    Composer composer4 = composer3;
                    aiCenterViewFactory.RememberAiCenterView(HostSurface.AI_HOME, StyleVariant.FULL_PAGE, new AiCenterLaunchMode.NewSession(null), composer4, ((i5 >> 9) & 7168) | (AiCenterLaunchMode.NewSession.$stable << 6) | 54 | (AiCenterViewFactory.$stable << 9));
                    composer2 = composer4;
                    modifier3 = modifier4;
                    SharedTransitionScopeKt.SharedTransitionLayout(null, ComposableLambdaKt.rememberComposableLambda(-1860805091, true, new Function3() { // from class: com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return RootNavHostKt.RootNavHost$lambda$5(rootNavigationDependencies, startNavigationConfig, modifier4, intentServices, previewLauncher, boxMessageDispatcher, aiCenterViewFactory, navigator, userContextManager, composeFragmentInjector, snackbarHostState, (SharedTransitionScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer2, 54), composer2, 48, 1);
                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    boolean z3 = z2;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), z3);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, z3 ? 1 : 0));
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxSize$default);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer2);
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 510722399, "C180@9456L207:RootNavHost.kt#giu8m4");
                    SwipeableSnackbarHostKt.SwipeableSnackbarHost(snackbarHostState2, WindowInsetsPadding_androidKt.navigationBarsPadding(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomCenter())), composer2, 6, z3 ? 1 : 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mainNavigationViewModel2 = mainNavigationViewModel5;
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        return;
                    } else {
                        function2 = new Function2() { // from class: com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return RootNavHostKt.RootNavHost$lambda$2(rootNavigationDependencies, composeFragmentInjector, intentServices, previewLauncher, userContextManager, boxMessageDispatcher, aiCenterViewFactory, modifier4, mainNavigationViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                    }
                }
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            mainNavigationViewModel2 = mainNavigationViewModel;
            modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                function2 = new Function2() { // from class: com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RootNavHostKt.RootNavHost$lambda$7(rootNavigationDependencies, composeFragmentInjector, intentServices, previewLauncher, userContextManager, boxMessageDispatcher, aiCenterViewFactory, modifier3, mainNavigationViewModel2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
        }
        i3 |= 12582912;
        modifier2 = modifier;
        if ((100663296 & i) != 0) {
            i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changedInstance(mainNavigationViewModel)) ? 33554432 : 67108864;
        }
        if ((38347923 & i3) != 38347922) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "65@3473L15");
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 256) != 0) {
                    composerStartRestartGroup.startReplaceableGroup(1890788296);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                    current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                    }
                    ViewModelProvider.Factory factoryCreateHiltViewModelFactory2 = HiltViewModelKt.createHiltViewModelFactory(current, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(1729797275);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    z2 = false;
                    ViewModel viewModel2 = ViewModelKt.viewModel((Class<ViewModel>) MainNavigationViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory2, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                    composer3 = composerStartRestartGroup;
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    MainNavigationViewModel mainNavigationViewModel6 = (MainNavigationViewModel) viewModel2;
                    i4 = i3 & (-234881025);
                    mainNavigationViewModel3 = mainNavigationViewModel6;
                } else {
                    composer3 = composerStartRestartGroup;
                    z2 = false;
                    i4 = i3;
                    mainNavigationViewModel3 = mainNavigationViewModel;
                }
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 256) != 0) {
                    composerStartRestartGroup.startReplaceableGroup(1890788296);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                    current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, LocalViewModelStoreOwner.$stable);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                    }
                    ViewModelProvider.Factory factoryCreateHiltViewModelFactory3 = HiltViewModelKt.createHiltViewModelFactory(current, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(1729797275);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    z2 = false;
                    ViewModel viewModel3 = ViewModelKt.viewModel((Class<ViewModel>) MainNavigationViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory3, defaultViewModelCreationExtras, composerStartRestartGroup, 36936, 0);
                    composer3 = composerStartRestartGroup;
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    MainNavigationViewModel mainNavigationViewModel7 = (MainNavigationViewModel) viewModel3;
                    i4 = i3 & (-234881025);
                    mainNavigationViewModel3 = mainNavigationViewModel7;
                } else {
                    composer3 = composerStartRestartGroup;
                    z2 = false;
                    i4 = i3;
                    mainNavigationViewModel3 = mainNavigationViewModel;
                }
            }
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-831764453, i4, -1, "com.box.android.navigationmodernization.navigation.compose.RootNavHost (RootNavHost.kt:66)");
            }
            navigationConfigurator = rootNavigationDependencies.getNavigationConfigurator();
            boolValueOf = Boolean.valueOf(z2);
            modifier4 = companion;
            ComposerKt.sourceInformationMarkerStart(composer3, -461702339, "CC(remember):RootNavHost.kt#9igjgp");
            zChangedInstance = composer3.changedInstance(navigationConfigurator);
            rootNavHostKt$RootNavHost$initialized$2$1RememberedValue = composer3.rememberedValue();
            i5 = i4;
            if (!zChangedInstance) {
                rootNavHostKt$RootNavHost$initialized$2$1RememberedValue = new RootNavHostKt$RootNavHost$initialized$2$1(navigationConfigurator, null);
                composer3.updateRememberedValue(rootNavHostKt$RootNavHost$initialized$2$1RememberedValue);
            } else {
                rootNavHostKt$RootNavHost$initialized$2$1RememberedValue = new RootNavHostKt$RootNavHost$initialized$2$1(navigationConfigurator, null);
                composer3.updateRememberedValue(rootNavHostKt$RootNavHost$initialized$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            if (!RootNavHost$lambda$1(SnapshotStateKt.produceState(boolValueOf, navigationConfigurator, (Function2<? super ProduceStateScope<Boolean>, ? super Continuation<? super Unit>, ? extends Object>) rootNavHostKt$RootNavHost$initialized$2$1RememberedValue, composer3, 6))) {
                MainNavigationViewModel mainNavigationViewModel8 = mainNavigationViewModel3;
                final RootNavigator navigator2 = rootNavigationDependencies.getNavigator();
                final RootNavigationConfig startNavigationConfig2 = rootNavigationDependencies.getNavigationConfigurator().getStartNavigationConfig();
                ComposerKt.sourceInformationMarkerStart(composer3, -461692965, "CC(remember):RootNavHost.kt#9igjgp");
                objRememberedValue = composer3.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new SnackbarHostState();
                    composer3.updateRememberedValue(objRememberedValue);
                }
                final SnackbarHostState snackbarHostState3 = (SnackbarHostState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -461690885, "CC(remember):RootNavHost.kt#9igjgp");
                objRememberedValue2 = composer3.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new SnackbarHostState();
                    composer3.updateRememberedValue(objRememberedValue2);
                }
                SnackbarHostState snackbarHostState4 = (SnackbarHostState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                MainNavigationTargetHandling(rootNavigationDependencies, mainNavigationViewModel8, snackbarHostState4, composer3, (i5 & 14) | 384 | ((i5 >> 21) & 112));
                Composer composer5 = composer3;
                aiCenterViewFactory.RememberAiCenterView(HostSurface.AI_HOME, StyleVariant.FULL_PAGE, new AiCenterLaunchMode.NewSession(null), composer5, ((i5 >> 9) & 7168) | (AiCenterLaunchMode.NewSession.$stable << 6) | 54 | (AiCenterViewFactory.$stable << 9));
                composer2 = composer5;
                modifier3 = modifier4;
                SharedTransitionScopeKt.SharedTransitionLayout(null, ComposableLambdaKt.rememberComposableLambda(-1860805091, true, new Function3() { // from class: com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return RootNavHostKt.RootNavHost$lambda$5(rootNavigationDependencies, startNavigationConfig2, modifier4, intentServices, previewLauncher, boxMessageDispatcher, aiCenterViewFactory, navigator2, userContextManager, composeFragmentInjector, snackbarHostState3, (SharedTransitionScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54), composer2, 48, 1);
                Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                boolean z4 = z2;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), z4);
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, z4 ? 1 : 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxSize$default2);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composer2);
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 510722399, "C180@9456L207:RootNavHost.kt#giu8m4");
                SwipeableSnackbarHostKt.SwipeableSnackbarHost(snackbarHostState4, WindowInsetsPadding_androidKt.navigationBarsPadding(boxScopeInstance2.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomCenter())), composer2, 6, z4 ? 1 : 0);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mainNavigationViewModel2 = mainNavigationViewModel8;
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return RootNavHostKt.RootNavHost$lambda$2(rootNavigationDependencies, composeFragmentInjector, intentServices, previewLauncher, userContextManager, boxMessageDispatcher, aiCenterViewFactory, modifier4, mainNavigationViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        composer2 = composerStartRestartGroup;
        composer2.skipToGroupEnd();
        mainNavigationViewModel2 = mainNavigationViewModel;
        modifier3 = modifier2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RootNavHostKt.RootNavHost$lambda$7(rootNavigationDependencies, composeFragmentInjector, intentServices, previewLauncher, userContextManager, boxMessageDispatcher, aiCenterViewFactory, modifier3, mainNavigationViewModel2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RootNavHost$lambda$5(final RootNavigationDependencies rootNavigationDependencies, final RootNavigationConfig rootNavigationConfig, final Modifier modifier, final IntentServices intentServices, final IPreviewLauncher iPreviewLauncher, final BoxMessageDispatcher boxMessageDispatcher, final AiCenterViewFactory aiCenterViewFactory, final RootNavigator rootNavigator, final IUserContextManager iUserContextManager, final ComposeFragmentInjector composeFragmentInjector, final SnackbarHostState snackbarHostState, SharedTransitionScope SharedTransitionLayout, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(SharedTransitionLayout, "$this$SharedTransitionLayout");
        ComposerKt.sourceInformation(composer, "C92@4533L4863,92@4466L4930:RootNavHost.kt#giu8m4");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(SharedTransitionLayout) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1860805091, i2, -1, "com.box.android.navigationmodernization.navigation.compose.RootNavHost.<anonymous> (RootNavHost.kt:92)");
            }
            CompositionLocalKt.CompositionLocalProvider(ComposeAnimationUtilsKt.getLocalSharedTransitionScope().provides(SharedTransitionLayout), ComposableLambdaKt.rememberComposableLambda(-10608291, true, new Function2() { // from class: com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RootNavHostKt.RootNavHost$lambda$5$0(rootNavigationDependencies, rootNavigationConfig, modifier, intentServices, iPreviewLauncher, boxMessageDispatcher, aiCenterViewFactory, rootNavigator, iUserContextManager, composeFragmentInjector, snackbarHostState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RootNavHost$lambda$5$0(final RootNavigationDependencies rootNavigationDependencies, RootNavigationConfig rootNavigationConfig, Modifier modifier, final IntentServices intentServices, final IPreviewLauncher iPreviewLauncher, final BoxMessageDispatcher boxMessageDispatcher, final AiCenterViewFactory aiCenterViewFactory, final RootNavigator rootNavigator, final IUserContextManager iUserContextManager, final ComposeFragmentInjector composeFragmentInjector, final SnackbarHostState snackbarHostState, Composer composer, int i) {
        Object obj;
        ComposerKt.sourceInformation(composer, "C98@4826L6,100@5024L11,101@5086L3640,93@4547L4179,166@8886L25,166@8869L42,167@8984L402,167@8924L462:RootNavHost.kt#giu8m4");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-10608291, i, -1, "com.box.android.navigationmodernization.navigation.compose.RootNavHost.<anonymous>.<anonymous> (RootNavHost.kt:93)");
            }
            NavHostController navController = rootNavigationDependencies.getNavController();
            String route = RootNavigationMappingKt.toRoute(rootNavigationConfig.getStartDestination());
            Modifier modifierWindowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier, 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), null, 2, null), WindowInsetsKt.m1294onlybOOhFvg(WindowInsets_androidKt.getSafeDrawing(WindowInsets.INSTANCE, composer, 6), WindowInsetsSides.INSTANCE.m1321getHorizontalJoeWqyM()));
            ComposerKt.sourceInformationMarkerStart(composer, -1604611723, "CC(remember):RootNavHost.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(rootNavigationDependencies) | composer.changedInstance(intentServices) | composer.changedInstance(iPreviewLauncher) | composer.changedInstance(boxMessageDispatcher) | composer.changedInstance(aiCenterViewFactory) | composer.changedInstance(rootNavigator) | composer.changedInstance(iUserContextManager) | composer.changedInstance(composeFragmentInjector);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function1() { // from class: com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return RootNavHostKt.RootNavHost$lambda$5$0$0$0(rootNavigationDependencies, intentServices, iPreviewLauncher, boxMessageDispatcher, aiCenterViewFactory, iUserContextManager, composeFragmentInjector, snackbarHostState, rootNavigator, (NavGraphBuilder) obj2);
                    }
                };
                composer.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            NavHostKt.NavHost(navController, route, modifierWindowInsetsPadding, null, null, null, null, null, null, null, (Function1) obj, composer, 0, 0, 1016);
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(composer, -1604493738, "CC(remember):RootNavHost.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RootNavHostKt.RootNavHost$lambda$5$0$1$0();
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue2, composer, 48);
            List<RootNavigationDestination.InnerDestination> additionalDestinations = rootNavigationConfig.getAdditionalDestinations();
            ComposerKt.sourceInformationMarkerStart(composer, -1604490225, "CC(remember):RootNavHost.kt#9igjgp");
            boolean zChanged = composer.changed(mutableState) | composer.changedInstance(rootNavigationConfig) | composer.changedInstance(rootNavigator);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = (Function2) new RootNavHostKt$RootNavHost$2$1$2$1(rootNavigationConfig, mutableState, rootNavigator, null);
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.LaunchedEffect(additionalDestinations, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RootNavHost$lambda$5$0$0$0(RootNavigationDependencies rootNavigationDependencies, IntentServices intentServices, IPreviewLauncher iPreviewLauncher, BoxMessageDispatcher boxMessageDispatcher, AiCenterViewFactory aiCenterViewFactory, IUserContextManager iUserContextManager, ComposeFragmentInjector composeFragmentInjector, SnackbarHostState snackbarHostState, final RootNavigator rootNavigator, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        HomeNavigationComposeKt.homeScreenDestination(NavHost, rootNavigationDependencies.getHomeScreenNavigationDependencies(), intentServices, iPreviewLauncher, boxMessageDispatcher, aiCenterViewFactory, new Function0() { // from class: com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RootNavHostKt.RootNavHost$lambda$5$0$0$0$0(rootNavigator);
            }
        }, new Function0() { // from class: com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RootNavHostKt.RootNavHost$lambda$5$0$0$0$1(rootNavigator);
            }
        }, new Function0() { // from class: com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RootNavHostKt.RootNavHost$lambda$5$0$0$0$2(rootNavigator);
            }
        }, new Function0() { // from class: com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RootNavHostKt.RootNavHost$lambda$5$0$0$0$3(rootNavigator);
            }
        }, new Function0() { // from class: com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RootNavHostKt.RootNavHost$lambda$5$0$0$0$4(rootNavigator);
            }
        }, new Function2() { // from class: com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return RootNavHostKt.RootNavHost$lambda$5$0$0$0$5(rootNavigator, (ItemModel) obj, (PreviewSource) obj2);
            }
        }, rootNavigationDependencies.getHomeScreenNavigationDependencies().getBrowseTabsSelector());
        FilesSearchNavigationComposeKt.filesSearchNavigationGraph(NavHost, rootNavigationDependencies.getNavigatorsProvider().getFilesSearchNavigator(), iUserContextManager, composeFragmentInjector, boxMessageDispatcher);
        SearchNavigationComposeKt.searchNavigationGraph$default(NavHost, rootNavigationDependencies.getNavigationConfigurator().getSearchNavigationConfig(), rootNavigationDependencies.getNavigatorsProvider().getSearchNavigator(), new Function0() { // from class: com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RootNavHostKt.RootNavHost$lambda$5$0$0$0$6(rootNavigator);
            }
        }, composeFragmentInjector, true, false, null, 96, null);
        NotesSearchNavigationComposeKt.notesSearchNavigationGraph(NavHost, rootNavigationDependencies.getNavigatorsProvider().getSearchNavigator(), new Function0() { // from class: com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RootNavHostKt.RootNavHost$lambda$5$0$0$0$7(rootNavigator);
            }
        });
        InboxNavigationComposeKt.inboxNavigationGraph(NavHost, rootNavigationDependencies.getNavigationConfigurator().getInboxNavigationConfig(), composeFragmentInjector, intentServices, iUserContextManager, new Function2() { // from class: com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return RootNavHostKt.RootNavHost$lambda$5$0$0$0$8(rootNavigator, (ItemModel) obj, (PreviewSource) obj2);
            }
        }, snackbarHostState, new Function0() { // from class: com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RootNavHostKt.RootNavHost$lambda$5$0$0$0$9(rootNavigator);
            }
        }, (256 & 128) != 0 ? null : rootNavigationDependencies.getInboxTabsSelector(), (256 & 256) != 0 ? 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a0: INVOKE 
              (r23v0 'NavHost' androidx.navigation.NavGraphBuilder)
              (wrap com.box.android.inbox.InboxNavigationConfig:0x0081: INVOKE 
              (wrap com.box.android.navigationmodernization.navigation.configuration.RootNavigationConfigurator:0x007d: INVOKE (r14v0 'rootNavigationDependencies' com.box.android.navigationmodernization.navigation.RootNavigationDependencies) VIRTUAL call: com.box.android.navigationmodernization.navigation.RootNavigationDependencies.getNavigationConfigurator():com.box.android.navigationmodernization.navigation.configuration.RootNavigationConfigurator A[MD:():com.box.android.navigationmodernization.navigation.configuration.RootNavigationConfigurator (m), WRAPPED] (LINE:153))
             VIRTUAL call: com.box.android.navigationmodernization.navigation.configuration.RootNavigationConfigurator.getInboxNavigationConfig():com.box.android.inbox.InboxNavigationConfig A[MD:():com.box.android.inbox.InboxNavigationConfig (m), WRAPPED] (LINE:153))
              (r20v0 'composeFragmentInjector' com.box.android.base.compose.ComposeFragmentInjector)
              (r15v0 'intentServices' com.box.android.coreservices.services.IntentServices)
              (r19v0 'iUserContextManager' com.box.android.domain.identity.IUserContextManager)
              (wrap kotlin.jvm.functions.Function2:0x0087: CONSTRUCTOR (r22v0 'rootNavigator' com.box.android.navigationmodernization.navigation.navigator.RootNavigator A[DONT_INLINE]) A[MD:(com.box.android.navigationmodernization.navigation.navigator.RootNavigator):void (m), WRAPPED] (LINE:152) call: com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda3.<init>(com.box.android.navigationmodernization.navigation.navigator.RootNavigator):void type: CONSTRUCTOR)
              (r21v0 'snackbarHostState' androidx.compose.material3.SnackbarHostState)
              (wrap kotlin.jvm.functions.Function0:0x008c: CONSTRUCTOR (r22v0 'rootNavigator' com.box.android.navigationmodernization.navigation.navigator.RootNavigator A[DONT_INLINE]) A[MD:(com.box.android.navigationmodernization.navigation.navigator.RootNavigator):void (m), WRAPPED] call: com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda4.<init>(com.box.android.navigationmodernization.navigation.navigator.RootNavigator):void type: CONSTRUCTOR)
              (wrap com.box.android.base.presentation.components.tabscreen.TabsSelector:?: TERNARY null = ((wrap int:0x0002: ARITH (256 int) & (128 int) A[WRAPPED]) != (0 int)) ? (null com.box.android.base.presentation.components.tabscreen.TabsSelector) : (wrap com.box.android.base.presentation.components.tabscreen.TabsSelector<com.box.android.inbox.InboxDestination$TabsScreen$InboxTab>:0x008f: INVOKE (r14v0 'rootNavigationDependencies' com.box.android.navigationmodernization.navigation.RootNavigationDependencies) VIRTUAL call: com.box.android.navigationmodernization.navigation.RootNavigationDependencies.getInboxTabsSelector():com.box.android.base.presentation.components.tabscreen.TabsSelector A[MD:():com.box.android.base.presentation.components.tabscreen.TabsSelector<com.box.android.inbox.InboxDestination$TabsScreen$InboxTab> (m), WRAPPED] (LINE:162)))
              (wrap kotlin.jvm.functions.Function2:?: TERNARY null = ((wrap int:0x000b: ARITH (256 int) & (256 int) A[WRAPPED]) != (0 int)) ? (wrap ??:0x0014: CONSTRUCTOR  A[MD:():void (m), WRAPPED] (LINE:39) call: com.box.android.inbox.InboxNavigationComposeKt$$ExternalSyntheticLambda3.<init>():void type: CONSTRUCTOR) : (null kotlin.jvm.functions.Function2))
             STATIC call: com.box.android.inbox.InboxNavigationComposeKt.inboxNavigationGraph(androidx.navigation.NavGraphBuilder, com.box.android.inbox.InboxNavigationConfig, com.box.android.base.compose.ComposeFragmentInjector, com.box.android.coreservices.services.IntentServices, com.box.android.domain.identity.IUserContextManager, kotlin.jvm.functions.Function2, androidx.compose.material3.SnackbarHostState, kotlin.jvm.functions.Function0, com.box.android.base.presentation.components.tabscreen.TabsSelector, kotlin.jvm.functions.Function2):void A[MD:(androidx.navigation.NavGraphBuilder, com.box.android.inbox.InboxNavigationConfig, com.box.android.base.compose.ComposeFragmentInjector, com.box.android.coreservices.services.IntentServices, com.box.android.domain.identity.IUserContextManager, kotlin.jvm.functions.Function2<? super com.box.android.domain.models.item.ItemModel, ? super com.box.android.domain.models.preview.PreviewSource, kotlin.Unit>, androidx.compose.material3.SnackbarHostState, kotlin.jvm.functions.Function0<kotlin.Unit>, com.box.android.base.presentation.components.tabscreen.TabsSelector<com.box.android.inbox.InboxDestination$TabsScreen$InboxTab>, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, com.box.android.inbox.InboxViewModels>):void (m)] (LINE:30) in method: com.box.android.navigationmodernization.navigation.compose.RootNavHostKt.RootNavHost$lambda$5$0$0$0(com.box.android.navigationmodernization.navigation.RootNavigationDependencies, com.box.android.coreservices.services.IntentServices, com.box.android.base.cpl.IPreviewLauncher, com.box.android.base.presentation.message.BoxMessageDispatcher, com.box.android.boxai.homescreen.AiCenterViewFactory, com.box.android.domain.identity.IUserContextManager, com.box.android.base.compose.ComposeFragmentInjector, androidx.compose.material3.SnackbarHostState, com.box.android.navigationmodernization.navigation.navigator.RootNavigator, androidx.navigation.NavGraphBuilder):kotlin.Unit, file: classes12.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.box.android.inbox.InboxNavigationComposeKt$$ExternalSyntheticLambda3, state: NOT_LOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
            	at jadx.core.codegen.InsnGen.makeTernary(InsnGen.java:1187)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:536)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
            	... 35 more
            */
        /*
            r0 = r22
            r1 = r23
            java.lang.String r2 = "$this$NavHost"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            com.box.android.navigationmodernization.homescreen.navigation.HomeScreenNavigationDependencies r2 = r14.getHomeScreenNavigationDependencies()
            com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda11 r7 = new com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda11
            r7.<init>()
            com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda12 r8 = new com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda12
            r8.<init>()
            com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda13 r9 = new com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda13
            r9.<init>()
            com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda14 r10 = new com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda14
            r10.<init>()
            com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda15 r11 = new com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda15
            r11.<init>()
            com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda16 r12 = new com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda16
            r12.<init>()
            com.box.android.navigationmodernization.homescreen.navigation.HomeScreenNavigationDependencies r3 = r14.getHomeScreenNavigationDependencies()
            com.box.android.base.presentation.components.tabscreen.TabsSelector r13 = r3.getBrowseTabsSelector()
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            com.box.android.navigationmodernization.homescreen.HomeNavigationComposeKt.homeScreenDestination(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            com.box.android.navigationmodernization.navigation.navigator.RootInnerNavigatorsProvider r2 = r14.getNavigatorsProvider()
            com.box.android.browse.search.navigation.FilesSearchNavigator r2 = r2.getFilesSearchNavigator()
            r11 = r19
            r3 = r20
            com.box.android.browse.search.navigation.compose.FilesSearchNavigationComposeKt.filesSearchNavigationGraph(r1, r2, r11, r3, r5)
            com.box.android.navigationmodernization.navigation.configuration.RootNavigationConfigurator r2 = r14.getNavigationConfigurator()
            com.box.android.search.navigation.SearchNavigationConfig r2 = r2.getSearchNavigationConfig()
            com.box.android.navigationmodernization.navigation.navigator.RootInnerNavigatorsProvider r4 = r14.getNavigatorsProvider()
            com.box.android.search.navigation.SearchNavigator r4 = r4.getSearchNavigator()
            r3 = r4
            com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda1 r4 = new com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda1
            r4.<init>()
            r9 = 96
            r10 = 0
            r6 = 1
            r7 = 0
            r8 = 0
            r5 = r20
            com.box.android.search.navigation.compose.SearchNavigationComposeKt.searchNavigationGraph$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            com.box.android.navigationmodernization.navigation.navigator.RootInnerNavigatorsProvider r2 = r14.getNavigatorsProvider()
            com.box.android.search.navigation.SearchNavigator r2 = r2.getSearchNavigator()
            com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda2 r3 = new com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda2
            r3.<init>()
            com.box.android.search.navigation.notes.compose.NotesSearchNavigationComposeKt.notesSearchNavigationGraph(r1, r2, r3)
            com.box.android.navigationmodernization.navigation.configuration.RootNavigationConfigurator r2 = r14.getNavigationConfigurator()
            com.box.android.inbox.InboxNavigationConfig r2 = r2.getInboxNavigationConfig()
            com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda3 r5 = new com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda3
            r5.<init>()
            com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda4 r7 = new com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda4
            r7.<init>()
            com.box.android.base.presentation.components.tabscreen.TabsSelector r8 = r14.getInboxTabsSelector()
            r10 = 256(0x100, float:3.59E-43)
            r11 = 0
            r9 = 0
            r3 = r15
            r4 = r19
            r6 = r21
            r0 = r1
            r1 = r2
            r2 = r20
            com.box.android.inbox.InboxNavigationComposeKt.inboxNavigationGraph$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.navigationmodernization.navigation.compose.RootNavHostKt.RootNavHost$lambda$5$0$0$0(com.box.android.navigationmodernization.navigation.RootNavigationDependencies, com.box.android.coreservices.services.IntentServices, com.box.android.base.cpl.IPreviewLauncher, com.box.android.base.presentation.message.BoxMessageDispatcher, com.box.android.boxai.homescreen.AiCenterViewFactory, com.box.android.domain.identity.IUserContextManager, com.box.android.base.compose.ComposeFragmentInjector, androidx.compose.material3.SnackbarHostState, com.box.android.navigationmodernization.navigation.navigator.RootNavigator, androidx.navigation.NavGraphBuilder):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RootNavHost$lambda$5$0$0$0$0(RootNavigator rootNavigator) {
        rootNavigator.navigateTo(RootNavigationDestination.InnerDestination.Search.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RootNavHost$lambda$5$0$0$0$1(RootNavigator rootNavigator) {
        rootNavigator.navigateTo(RootNavigationDestination.InnerDestination.NotesSearch.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RootNavHost$lambda$5$0$0$0$2(RootNavigator rootNavigator) {
        rootNavigator.navigateTo(RootNavigationDestination.OuterDestination.Settings.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RootNavHost$lambda$5$0$0$0$3(RootNavigator rootNavigator) {
        rootNavigator.navigateTo(RootNavigationDestination.OuterDestination.JobsUI.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RootNavHost$lambda$5$0$0$0$4(RootNavigator rootNavigator) {
        rootNavigator.navigateTo(RootNavigationDestination.InnerDestination.Inbox.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RootNavHost$lambda$5$0$0$0$5(RootNavigator rootNavigator, ItemModel itemModel, PreviewSource previewSource) {
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        Intrinsics.checkNotNullParameter(previewSource, "previewSource");
        rootNavigator.navigateTo(new RootNavigationDestination.OuterDestination.Item(itemModel, previewSource));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RootNavHost$lambda$5$0$0$0$6(RootNavigator rootNavigator) {
        rootNavigator.popBackStack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RootNavHost$lambda$5$0$0$0$7(RootNavigator rootNavigator) {
        rootNavigator.popBackStack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RootNavHost$lambda$5$0$0$0$8(RootNavigator rootNavigator, ItemModel itemModel, PreviewSource previewSource) {
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        Intrinsics.checkNotNullParameter(previewSource, "previewSource");
        rootNavigator.navigateTo(new RootNavigationDestination.OuterDestination.Item(itemModel, previewSource));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RootNavHost$lambda$5$0$0$0$9(RootNavigator rootNavigator) {
        rootNavigator.popBackStack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState RootNavHost$lambda$5$0$1$0() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean RootNavHost$lambda$5$0$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RootNavHost$lambda$5$0$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final void MainNavigationTargetHandling(final RootNavigationDependencies rootNavigationDependencies, final MainNavigationViewModel mainNavigationViewModel, final SnackbarHostState snackbarHostState, Composer composer, final int i) {
        int i2;
        String strStringResource;
        Composer composerStartRestartGroup = composer.startRestartGroup(-483563696);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MainNavigationTargetHandling)N(rootNavigationDependencies,mainNavigationViewModel,rootSnackbarHostState)202@10272L33,213@10807L75,213@10774L108,219@11165L287,219@11099L353:RootNavHost.kt#giu8m4");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(rootNavigationDependencies) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(mainNavigationViewModel) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(snackbarHostState) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-483563696, i2, -1, "com.box.android.navigationmodernization.navigation.compose.MainNavigationTargetHandling (RootNavHost.kt:201)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -848236239, "CC(remember):RootNavHost.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            DomainError domainErrorMainNavigationTargetHandling$lambda$1 = MainNavigationTargetHandling$lambda$1(mutableState);
            if (domainErrorMainNavigationTargetHandling$lambda$1 == null) {
                composerStartRestartGroup.startReplaceGroup(-525435591);
                composerStartRestartGroup.endReplaceGroup();
                strStringResource = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(-525435590);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*203@10362L48");
                strStringResource = StringResources_androidKt.stringResource(toNavigationErrorMessageRes(domainErrorMainNavigationTargetHandling$lambda$1), composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (strStringResource != null) {
                composerStartRestartGroup.startReplaceGroup(-525335770);
                ComposerKt.sourceInformation(composerStartRestartGroup, "205@10502L117,205@10463L156");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -848228795, "CC(remember):RootNavHost.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(strStringResource) | ((i2 & 896) == 256);
                RootNavHostKt$MainNavigationTargetHandling$1$1 rootNavHostKt$MainNavigationTargetHandling$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || rootNavHostKt$MainNavigationTargetHandling$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    rootNavHostKt$MainNavigationTargetHandling$1$1RememberedValue = new RootNavHostKt$MainNavigationTargetHandling$1$1(snackbarHostState, strStringResource, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(rootNavHostKt$MainNavigationTargetHandling$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(strStringResource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rootNavHostKt$MainNavigationTargetHandling$1$1RememberedValue, composerStartRestartGroup, 0);
            } else {
                composerStartRestartGroup.startReplaceGroup(-535711470);
            }
            composerStartRestartGroup.endReplaceGroup();
            RootNavigationConfigurator navigationConfigurator = rootNavigationDependencies.getNavigationConfigurator();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -848219077, "CC(remember):RootNavHost.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(navigationConfigurator);
            RootNavHostKt$MainNavigationTargetHandling$2$1 rootNavHostKt$MainNavigationTargetHandling$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || rootNavHostKt$MainNavigationTargetHandling$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                rootNavHostKt$MainNavigationTargetHandling$2$1RememberedValue = new RootNavHostKt$MainNavigationTargetHandling$2$1(navigationConfigurator, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(rootNavHostKt$MainNavigationTargetHandling$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(navigationConfigurator, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rootNavHostKt$MainNavigationTargetHandling$2$1RememberedValue, composerStartRestartGroup, 0);
            MainNavigationTargetRequestHandler mainNavigationTargetRequestHandler = rootNavigationDependencies.getMainNavigationTargetRequestHandler();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -848207409, "CC(remember):RootNavHost.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(mainNavigationViewModel) | composerStartRestartGroup.changedInstance(mainNavigationTargetRequestHandler);
            RootNavHostKt$MainNavigationTargetHandling$3$1 rootNavHostKt$MainNavigationTargetHandling$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || rootNavHostKt$MainNavigationTargetHandling$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                rootNavHostKt$MainNavigationTargetHandling$3$1RememberedValue = new RootNavHostKt$MainNavigationTargetHandling$3$1(mainNavigationViewModel, mainNavigationTargetRequestHandler, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(rootNavHostKt$MainNavigationTargetHandling$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(mainNavigationViewModel, mainNavigationTargetRequestHandler, (Function2) rootNavHostKt$MainNavigationTargetHandling$3$1RememberedValue, composerStartRestartGroup, (i2 >> 3) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RootNavHostKt.MainNavigationTargetHandling$lambda$7(rootNavigationDependencies, mainNavigationViewModel, snackbarHostState, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final DomainError MainNavigationTargetHandling$lambda$1(MutableState<DomainError> mutableState) {
        return mutableState.getValue();
    }

    private static final int toNavigationErrorMessageRes(DomainError domainError) {
        return DomainErrorKt.isNetworkConnectionError(domainError) ? R.string.box_sharesdk_network_error : R.string.box_sharesdk_generic_error;
    }

    private static final boolean RootNavHost$lambda$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
