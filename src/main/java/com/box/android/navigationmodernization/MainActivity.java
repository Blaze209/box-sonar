package com.box.android.navigationmodernization;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ComposeView;
import androidx.core.content.IntentCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.ComposeFragmentInjectorImpl;
import com.box.android.base.cpl.IPreviewLauncher;
import com.box.android.base.presentation.message.BoxMessageDispatcher;
import com.box.android.boxai.homescreen.AiCenterViewFactory;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.ITabPersistenceService;
import com.box.android.navigationmodernization.homescreen.navigation.compose.HomeScreenInnerNavigatorsProviderFactory;
import com.box.android.navigationmodernization.navigation.RootNavigationDependencies;
import com.box.android.navigationmodernization.navigation.RootNavigationDependenciesKt;
import com.box.android.navigationmodernization.navigation.compose.RootNavHostKt;
import com.box.android.navigationmodernization.navigation.configuration.MainNavigationTargetConfigFactory;
import com.box.android.navigationmodernization.navigation.navigator.RootInnerNavigatorsProviderFactory;
import com.box.android.navigationmodernization.utils.ActionModeDarkModeRecreator;
import com.box.android.navigationmodernization.utils.XmlFragmentDarkModeRecreator;
import com.box.android.observability.DiagnosisParams;
import com.box.android.utilities.ItemClickHandler;
import com.box.brownfieldApi.ReactNativeHostManager;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.swmansion.rnscreens.fragment.restoration.RNScreensFragmentFactory;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0001EB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:H\u0014J\u0010\u0010;\u001a\u0002082\u0006\u0010<\u001a\u00020=H\u0016J\u0012\u0010>\u001a\u0002082\b\u0010?\u001a\u0004\u0018\u00010@H\u0014J\b\u0010A\u001a\u000208H\u0016J\u0010\u0010B\u001a\u0002082\u0006\u0010C\u001a\u00020DH\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b+\u0010,R\u001a\u0010/\u001a\u000200X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/box/android/navigationmodernization/MainActivity;", "Lcom/box/android/navigationmodernization/MainBaseActivity;", "Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;", "<init>", "()V", "itemClickHandlerFactory", "Lcom/box/android/utilities/ItemClickHandler$Factory;", "getItemClickHandlerFactory", "()Lcom/box/android/utilities/ItemClickHandler$Factory;", "setItemClickHandlerFactory", "(Lcom/box/android/utilities/ItemClickHandler$Factory;)V", "rootInnerNavigatorsProviderFactory", "Lcom/box/android/navigationmodernization/navigation/navigator/RootInnerNavigatorsProviderFactory$Factory;", "getRootInnerNavigatorsProviderFactory", "()Lcom/box/android/navigationmodernization/navigation/navigator/RootInnerNavigatorsProviderFactory$Factory;", "setRootInnerNavigatorsProviderFactory", "(Lcom/box/android/navigationmodernization/navigation/navigator/RootInnerNavigatorsProviderFactory$Factory;)V", "homeScreenInnerNavigatorsProviderFactory", "Lcom/box/android/navigationmodernization/homescreen/navigation/compose/HomeScreenInnerNavigatorsProviderFactory$Factory;", "getHomeScreenInnerNavigatorsProviderFactory", "()Lcom/box/android/navigationmodernization/homescreen/navigation/compose/HomeScreenInnerNavigatorsProviderFactory$Factory;", "setHomeScreenInnerNavigatorsProviderFactory", "(Lcom/box/android/navigationmodernization/homescreen/navigation/compose/HomeScreenInnerNavigatorsProviderFactory$Factory;)V", "tabPersistenceService", "Lcom/box/android/domain/services/ITabPersistenceService;", "getTabPersistenceService", "()Lcom/box/android/domain/services/ITabPersistenceService;", "setTabPersistenceService", "(Lcom/box/android/domain/services/ITabPersistenceService;)V", "previewLauncher", "Lcom/box/android/base/cpl/IPreviewLauncher;", "getPreviewLauncher", "()Lcom/box/android/base/cpl/IPreviewLauncher;", "setPreviewLauncher", "(Lcom/box/android/base/cpl/IPreviewLauncher;)V", "mainNavigationTargetConfigFactory", "Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationTargetConfigFactory;", "getMainNavigationTargetConfigFactory", "()Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationTargetConfigFactory;", "setMainNavigationTargetConfigFactory", "(Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationTargetConfigFactory;)V", "mainNavigationViewModel", "Lcom/box/android/navigationmodernization/MainNavigationViewModel;", "getMainNavigationViewModel", "()Lcom/box/android/navigationmodernization/MainNavigationViewModel;", "mainNavigationViewModel$delegate", "Lkotlin/Lazy;", "xmlFragmentDarkModeRecreator", "Lcom/box/android/navigationmodernization/utils/XmlFragmentDarkModeRecreator;", "getXmlFragmentDarkModeRecreator", "()Lcom/box/android/navigationmodernization/utils/XmlFragmentDarkModeRecreator;", "setXmlFragmentDarkModeRecreator", "(Lcom/box/android/navigationmodernization/utils/XmlFragmentDarkModeRecreator;)V", "actionModeDarkModeRecreator", "Lcom/box/android/navigationmodernization/utils/ActionModeDarkModeRecreator;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "handleOnNewIntent", "intent", "Landroid/content/Intent;", "invokeDefaultOnBackPressed", "onSupportActionModeStarted", DiagnosisParams.DIAGNOSIS_MODE, "Landroidx/appcompat/view/ActionMode;", "Companion", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class MainActivity extends Hilt_MainActivity implements DefaultHardwareBackBtnHandler {
    public static final String MAIN_NAVIGATION_TARGET = "MAIN_NAVIGATION_TARGET";
    private final ActionModeDarkModeRecreator actionModeDarkModeRecreator = new ActionModeDarkModeRecreator(this);

    @Inject
    public HomeScreenInnerNavigatorsProviderFactory.Factory homeScreenInnerNavigatorsProviderFactory;

    @Inject
    public ItemClickHandler.Factory itemClickHandlerFactory;

    @Inject
    public MainNavigationTargetConfigFactory mainNavigationTargetConfigFactory;

    /* JADX INFO: renamed from: mainNavigationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy mainNavigationViewModel;

    @Inject
    public IPreviewLauncher previewLauncher;

    @Inject
    public RootInnerNavigatorsProviderFactory.Factory rootInnerNavigatorsProviderFactory;

    @Inject
    public ITabPersistenceService tabPersistenceService;
    public XmlFragmentDarkModeRecreator xmlFragmentDarkModeRecreator;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public MainActivity() {
        final MainActivity mainActivity = this;
        final Function0 function0 = null;
        this.mainNavigationViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(MainNavigationViewModel.class), new Function0<ViewModelStore>() { // from class: com.box.android.navigationmodernization.MainActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return mainActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.box.android.navigationmodernization.MainActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return mainActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.box.android.navigationmodernization.MainActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? mainActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    public final ItemClickHandler.Factory getItemClickHandlerFactory() {
        ItemClickHandler.Factory factory = this.itemClickHandlerFactory;
        if (factory != null) {
            return factory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("itemClickHandlerFactory");
        return null;
    }

    public final void setItemClickHandlerFactory(ItemClickHandler.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.itemClickHandlerFactory = factory;
    }

    public final RootInnerNavigatorsProviderFactory.Factory getRootInnerNavigatorsProviderFactory() {
        RootInnerNavigatorsProviderFactory.Factory factory = this.rootInnerNavigatorsProviderFactory;
        if (factory != null) {
            return factory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rootInnerNavigatorsProviderFactory");
        return null;
    }

    public final void setRootInnerNavigatorsProviderFactory(RootInnerNavigatorsProviderFactory.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.rootInnerNavigatorsProviderFactory = factory;
    }

    public final HomeScreenInnerNavigatorsProviderFactory.Factory getHomeScreenInnerNavigatorsProviderFactory() {
        HomeScreenInnerNavigatorsProviderFactory.Factory factory = this.homeScreenInnerNavigatorsProviderFactory;
        if (factory != null) {
            return factory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("homeScreenInnerNavigatorsProviderFactory");
        return null;
    }

    public final void setHomeScreenInnerNavigatorsProviderFactory(HomeScreenInnerNavigatorsProviderFactory.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.homeScreenInnerNavigatorsProviderFactory = factory;
    }

    public final ITabPersistenceService getTabPersistenceService() {
        ITabPersistenceService iTabPersistenceService = this.tabPersistenceService;
        if (iTabPersistenceService != null) {
            return iTabPersistenceService;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tabPersistenceService");
        return null;
    }

    public final void setTabPersistenceService(ITabPersistenceService iTabPersistenceService) {
        Intrinsics.checkNotNullParameter(iTabPersistenceService, "<set-?>");
        this.tabPersistenceService = iTabPersistenceService;
    }

    public final IPreviewLauncher getPreviewLauncher() {
        IPreviewLauncher iPreviewLauncher = this.previewLauncher;
        if (iPreviewLauncher != null) {
            return iPreviewLauncher;
        }
        Intrinsics.throwUninitializedPropertyAccessException("previewLauncher");
        return null;
    }

    public final void setPreviewLauncher(IPreviewLauncher iPreviewLauncher) {
        Intrinsics.checkNotNullParameter(iPreviewLauncher, "<set-?>");
        this.previewLauncher = iPreviewLauncher;
    }

    public final MainNavigationTargetConfigFactory getMainNavigationTargetConfigFactory() {
        MainNavigationTargetConfigFactory mainNavigationTargetConfigFactory = this.mainNavigationTargetConfigFactory;
        if (mainNavigationTargetConfigFactory != null) {
            return mainNavigationTargetConfigFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mainNavigationTargetConfigFactory");
        return null;
    }

    public final void setMainNavigationTargetConfigFactory(MainNavigationTargetConfigFactory mainNavigationTargetConfigFactory) {
        Intrinsics.checkNotNullParameter(mainNavigationTargetConfigFactory, "<set-?>");
        this.mainNavigationTargetConfigFactory = mainNavigationTargetConfigFactory;
    }

    private final MainNavigationViewModel getMainNavigationViewModel() {
        return (MainNavigationViewModel) this.mainNavigationViewModel.getValue();
    }

    public final XmlFragmentDarkModeRecreator getXmlFragmentDarkModeRecreator() {
        XmlFragmentDarkModeRecreator xmlFragmentDarkModeRecreator = this.xmlFragmentDarkModeRecreator;
        if (xmlFragmentDarkModeRecreator != null) {
            return xmlFragmentDarkModeRecreator;
        }
        Intrinsics.throwUninitializedPropertyAccessException("xmlFragmentDarkModeRecreator");
        return null;
    }

    public final void setXmlFragmentDarkModeRecreator(XmlFragmentDarkModeRecreator xmlFragmentDarkModeRecreator) {
        Intrinsics.checkNotNullParameter(xmlFragmentDarkModeRecreator, "<set-?>");
        this.xmlFragmentDarkModeRecreator = xmlFragmentDarkModeRecreator;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        getSupportFragmentManager().setFragmentFactory(new RNScreensFragmentFactory());
        super.onMAMCreate(bundle);
        EdgeToEdge.enable$default(this, null, null, 3, null);
        MainActivity mainActivity = this;
        final ItemClickHandler itemClickHandlerCreate = getItemClickHandlerFactory().create((AppCompatActivity) mainActivity);
        ItemClickHandler itemClickHandler = itemClickHandlerCreate;
        final RootInnerNavigatorsProviderFactory rootInnerNavigatorsProviderFactoryCreate = getRootInnerNavigatorsProviderFactory().create(mainActivity, itemClickHandler, getItemMoreActionsHandler());
        final HomeScreenInnerNavigatorsProviderFactory homeScreenInnerNavigatorsProviderFactoryCreate = getHomeScreenInnerNavigatorsProviderFactory().create(mainActivity, itemClickHandler, getItemMoreActionsHandler());
        final MainNavigationTarget mainNavigationTarget = (MainNavigationTarget) IntentCompat.getParcelableExtra(getIntent(), MAIN_NAVIGATION_TARGET, MainNavigationTarget.class);
        final AiCenterViewFactory aiCenterViewFactory = new AiCenterViewFactory();
        int i = getResources().getConfiguration().uiMode & 48;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        setXmlFragmentDarkModeRecreator(new XmlFragmentDarkModeRecreator(supportFragmentManager, i));
        ComposeView composeView = new ComposeView(this, null, 0, 6, null);
        WindowInsets_androidKt.setConsumeWindowInsets((AbstractComposeView) composeView, false);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-605020961, true, new Function2() { // from class: com.box.android.navigationmodernization.MainActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return MainActivity.onCreate$lambda$0$0(this.f$0, mainNavigationTarget, rootInnerNavigatorsProviderFactoryCreate, homeScreenInnerNavigatorsProviderFactoryCreate, itemClickHandlerCreate, aiCenterViewFactory, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        setContentView(composeView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0(final MainActivity mainActivity, final MainNavigationTarget mainNavigationTarget, final RootInnerNavigatorsProviderFactory rootInnerNavigatorsProviderFactory, final HomeScreenInnerNavigatorsProviderFactory homeScreenInnerNavigatorsProviderFactory, final ItemClickHandler itemClickHandler, final AiCenterViewFactory aiCenterViewFactory, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C83@4293L1363,83@4284L1372:MainActivity.kt#gykqpu");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-605020961, i, -1, "com.box.android.navigationmodernization.MainActivity.onCreate.<anonymous>.<anonymous> (MainActivity.kt:83)");
            }
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(18247402, true, new Function2() { // from class: com.box.android.navigationmodernization.MainActivity$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivity.onCreate$lambda$0$0$0(this.f$0, mainNavigationTarget, rootInnerNavigatorsProviderFactory, homeScreenInnerNavigatorsProviderFactory, itemClickHandler, aiCenterViewFactory, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$0(MainActivity mainActivity, MainNavigationTarget mainNavigationTarget, RootInnerNavigatorsProviderFactory rootInnerNavigatorsProviderFactory, HomeScreenInnerNavigatorsProviderFactory homeScreenInnerNavigatorsProviderFactory, ItemClickHandler itemClickHandler, AiCenterViewFactory aiCenterViewFactory, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C84@4352L711,96@5089L545:MainActivity.kt#gykqpu");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(18247402, i, -1, "com.box.android.navigationmodernization.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:84)");
            }
            FeatureFlips mFeatureFlips = mainActivity.mFeatureFlips;
            Intrinsics.checkNotNullExpressionValue(mFeatureFlips, "mFeatureFlips");
            RootNavigationDependencies rootNavigationDependenciesRememberRootNavigationDependencies = RootNavigationDependenciesKt.rememberRootNavigationDependencies(mFeatureFlips, mainActivity.getBoxAccountSettings(), mainActivity.getTabPersistenceService(), mainNavigationTarget, rootInnerNavigatorsProviderFactory, homeScreenInnerNavigatorsProviderFactory, mainActivity, itemClickHandler, mainActivity.getMainNavigationTargetConfigFactory(), null, null, composer, 0, 0, 1536);
            ComposeFragmentInjectorImpl composeFragmentInjectorImpl = new ComposeFragmentInjectorImpl();
            IntentServices intentServices = mainActivity.getIntentServices();
            IPreviewLauncher previewLauncher = mainActivity.getPreviewLauncher();
            IUserContextManager mUserContextManager = mainActivity.mUserContextManager;
            Intrinsics.checkNotNullExpressionValue(mUserContextManager, "mUserContextManager");
            RootNavHostKt.RootNavHost(rootNavigationDependenciesRememberRootNavigationDependencies, composeFragmentInjectorImpl, intentServices, previewLauncher, mUserContextManager, mainActivity.getBoxMessageDispatcher(), aiCenterViewFactory, null, null, composer, (ComposeFragmentInjectorImpl.$stable << 3) | (BoxMessageDispatcher.$stable << 15) | (AiCenterViewFactory.$stable << 18), 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        ReactNativeHostManager.INSTANCE.onConfigurationChanged(this);
        if (getXmlFragmentDarkModeRecreator().onConfigurationChanged(newConfig)) {
            EdgeToEdge.enable$default(this, null, null, 3, null);
        }
    }

    @Override // com.box.android.navigationmodernization.MainBaseActivity, com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void handleOnNewIntent(Intent intent) {
        super.handleOnNewIntent(intent);
        if (isDifferentUserAccessed()) {
            return;
        }
        MainNavigationTarget mainNavigationTarget = intent != null ? (MainNavigationTarget) IntentCompat.getParcelableExtra(intent, MAIN_NAVIGATION_TARGET, MainNavigationTarget.class) : null;
        if (mainNavigationTarget != null) {
            getMainNavigationViewModel().submit(mainNavigationTarget);
        }
    }

    @Override // com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
    public void invokeDefaultOnBackPressed() {
        getOnBackPressedDispatcher().onBackPressed();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeStarted(ActionMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        super.onSupportActionModeStarted(mode);
        this.actionModeDarkModeRecreator.refreshActionModeColors();
    }

    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/navigationmodernization/MainActivity$Companion;", "", "<init>", "()V", MainActivity.MAIN_NAVIGATION_TARGET, "", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "mainNavigationTarget", "Lcom/box/android/navigationmodernization/MainNavigationTarget;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Intent createIntent$default(Companion companion, Context context, MainNavigationTarget mainNavigationTarget, int i, Object obj) {
            if ((i & 2) != 0) {
                mainNavigationTarget = null;
            }
            return companion.createIntent(context, mainNavigationTarget);
        }

        public final Intent createIntent(Context context, MainNavigationTarget mainNavigationTarget) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) MainActivity.class);
            if (mainNavigationTarget != null) {
                intent.putExtra(MainActivity.MAIN_NAVIGATION_TARGET, mainNavigationTarget);
            }
            intent.addFlags(67108864);
            return intent;
        }
    }
}
