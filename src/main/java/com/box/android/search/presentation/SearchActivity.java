package com.box.android.search.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.activity.EdgeToEdge;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.box.android.base.presentation.utilities.IItemClickHandler;
import com.box.android.base.presentation.utilities.IItemMoreActionsHandler;
import com.box.android.browse.utilities.BoxSearchItemClickHandler;
import com.box.android.common.utilities.IntentConstants;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.search.SearchMode;
import com.box.android.search.navigation.SearchDestination;
import com.box.android.search.navigation.SearchNavigationConfig;
import com.box.android.search.navigation.compose.SearchNavigationComposeKt;
import com.box.android.search.navigation.compose.SearchViewModels;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.swmansion.rnscreens.fragment.restoration.RNScreensFragmentFactory;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchActivity.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 L2\u00020\u00012\u00020\u0002:\u0001LB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u00103\u001a\u0004\u0018\u000104H\u0014¢\u0006\u0002\u00105J\u0012\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109H\u0014J\u0015\u0010:\u001a\u0002072\u0006\u0010;\u001a\u00020<H\u0001¢\u0006\u0002\b=J\u0015\u0010>\u001a\u0002072\u0006\u0010?\u001a\u00020@H\u0001¢\u0006\u0002\bAJ\b\u0010B\u001a\u000207H\u0016J\b\u0010C\u001a\u000207H\u0016J\"\u0010D\u001a\u0002072\u0006\u0010E\u001a\u0002042\u0006\u0010F\u001a\u0002042\b\u0010G\u001a\u0004\u0018\u00010HH\u0014J\b\u0010I\u001a\u00020JH\u0016J\b\u0010K\u001a\u000207H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b%\u0010&R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010(\u001a\u0004\b+\u0010,R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010(\u001a\u0004\b0\u00101¨\u0006M"}, d2 = {"Lcom/box/android/search/presentation/SearchActivity;", "Lcom/box/android/base/presentation/activities/BoxFragmentActivity;", "Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;", "<init>", "()V", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "getIntentServices", "()Lcom/box/android/coreservices/services/IntentServices;", "setIntentServices", "(Lcom/box/android/coreservices/services/IntentServices;)V", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "getFeatureFlips", "()Lcom/box/android/domain/configuration/FeatureFlips;", "setFeatureFlips", "(Lcom/box/android/domain/configuration/FeatureFlips;)V", "itemClickHandlerFactory", "Lcom/box/android/base/presentation/utilities/IItemClickHandler$Factory;", "getItemClickHandlerFactory", "()Lcom/box/android/base/presentation/utilities/IItemClickHandler$Factory;", "setItemClickHandlerFactory", "(Lcom/box/android/base/presentation/utilities/IItemClickHandler$Factory;)V", "boxSearchItemClickHandlerFactory", "Lcom/box/android/browse/utilities/BoxSearchItemClickHandler$Factory;", "getBoxSearchItemClickHandlerFactory", "()Lcom/box/android/browse/utilities/BoxSearchItemClickHandler$Factory;", "setBoxSearchItemClickHandlerFactory", "(Lcom/box/android/browse/utilities/BoxSearchItemClickHandler$Factory;)V", "itemMoreActionsHandlerFactory", "Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler$Factory;", "getItemMoreActionsHandlerFactory", "()Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler$Factory;", "setItemMoreActionsHandlerFactory", "(Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler$Factory;)V", "itemClickHandler", "Lcom/box/android/base/presentation/utilities/IItemClickHandler;", "getItemClickHandler", "()Lcom/box/android/base/presentation/utilities/IItemClickHandler;", "itemClickHandler$delegate", "Lkotlin/Lazy;", "boxSearchItemClickHandler", "Lcom/box/android/browse/utilities/BoxSearchItemClickHandler;", "getBoxSearchItemClickHandler", "()Lcom/box/android/browse/utilities/BoxSearchItemClickHandler;", "boxSearchItemClickHandler$delegate", "itemMoreActionsHandler", "Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler;", "getItemMoreActionsHandler", "()Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler;", "itemMoreActionsHandler$delegate", "getActivityLayoutId", "", "()Ljava/lang/Integer;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "finishWithSelectedFolder", "folder", "Lcom/box/android/domain/models/item/FolderModel;", "finishWithSelectedFolder$search_generalProdRelease", "finishWithSelectedFile", "file", "Lcom/box/android/domain/models/item/FileModel;", "finishWithSelectedFile$search_generalProdRelease", "onBoxResume", "onPause", "handleOnActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "amplitudeSetCurrentPage", "", "invokeDefaultOnBackPressed", "Companion", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class SearchActivity extends Hilt_SearchActivity implements DefaultHardwareBackBtnHandler {
    public static final String ACTIVITY_INITIAL_SEARCH_MODE_KEY = "ACTIVITY_INITIAL_SEARCH_MODE_KEY";

    @Inject
    public BoxSearchItemClickHandler.Factory boxSearchItemClickHandlerFactory;

    @Inject
    public FeatureFlips featureFlips;

    @Inject
    public IntentServices intentServices;

    @Inject
    public IItemClickHandler.Factory itemClickHandlerFactory;

    @Inject
    public IItemMoreActionsHandler.Factory itemMoreActionsHandlerFactory;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: itemClickHandler$delegate, reason: from kotlin metadata */
    private final Lazy itemClickHandler = LazyKt.lazy(new Function0() { // from class: com.box.android.search.presentation.SearchActivity$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SearchActivity.itemClickHandler_delegate$lambda$0(this.f$0);
        }
    });

    /* JADX INFO: renamed from: boxSearchItemClickHandler$delegate, reason: from kotlin metadata */
    private final Lazy boxSearchItemClickHandler = LazyKt.lazy(new Function0() { // from class: com.box.android.search.presentation.SearchActivity$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SearchActivity.boxSearchItemClickHandler_delegate$lambda$0(this.f$0);
        }
    });

    /* JADX INFO: renamed from: itemMoreActionsHandler$delegate, reason: from kotlin metadata */
    private final Lazy itemMoreActionsHandler = LazyKt.lazy(new Function0() { // from class: com.box.android.search.presentation.SearchActivity$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SearchActivity.itemMoreActionsHandler_delegate$lambda$0(this.f$0);
        }
    });

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return null;
    }

    public final IntentServices getIntentServices() {
        IntentServices intentServices = this.intentServices;
        if (intentServices != null) {
            return intentServices;
        }
        Intrinsics.throwUninitializedPropertyAccessException("intentServices");
        return null;
    }

    public final void setIntentServices(IntentServices intentServices) {
        Intrinsics.checkNotNullParameter(intentServices, "<set-?>");
        this.intentServices = intentServices;
    }

    public final FeatureFlips getFeatureFlips() {
        FeatureFlips featureFlips = this.featureFlips;
        if (featureFlips != null) {
            return featureFlips;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureFlips");
        return null;
    }

    public final void setFeatureFlips(FeatureFlips featureFlips) {
        Intrinsics.checkNotNullParameter(featureFlips, "<set-?>");
        this.featureFlips = featureFlips;
    }

    public final IItemClickHandler.Factory getItemClickHandlerFactory() {
        IItemClickHandler.Factory factory = this.itemClickHandlerFactory;
        if (factory != null) {
            return factory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("itemClickHandlerFactory");
        return null;
    }

    public final void setItemClickHandlerFactory(IItemClickHandler.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.itemClickHandlerFactory = factory;
    }

    public final BoxSearchItemClickHandler.Factory getBoxSearchItemClickHandlerFactory() {
        BoxSearchItemClickHandler.Factory factory = this.boxSearchItemClickHandlerFactory;
        if (factory != null) {
            return factory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("boxSearchItemClickHandlerFactory");
        return null;
    }

    public final void setBoxSearchItemClickHandlerFactory(BoxSearchItemClickHandler.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.boxSearchItemClickHandlerFactory = factory;
    }

    public final IItemMoreActionsHandler.Factory getItemMoreActionsHandlerFactory() {
        IItemMoreActionsHandler.Factory factory = this.itemMoreActionsHandlerFactory;
        if (factory != null) {
            return factory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("itemMoreActionsHandlerFactory");
        return null;
    }

    public final void setItemMoreActionsHandlerFactory(IItemMoreActionsHandler.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.itemMoreActionsHandlerFactory = factory;
    }

    private final IItemClickHandler getItemClickHandler() {
        return (IItemClickHandler) this.itemClickHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IItemClickHandler itemClickHandler_delegate$lambda$0(SearchActivity searchActivity) {
        return searchActivity.getItemClickHandlerFactory().create(searchActivity);
    }

    private final BoxSearchItemClickHandler getBoxSearchItemClickHandler() {
        return (BoxSearchItemClickHandler) this.boxSearchItemClickHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BoxSearchItemClickHandler boxSearchItemClickHandler_delegate$lambda$0(SearchActivity searchActivity) {
        return searchActivity.getBoxSearchItemClickHandlerFactory().create(searchActivity, searchActivity.getItemClickHandler());
    }

    private final IItemMoreActionsHandler getItemMoreActionsHandler() {
        return (IItemMoreActionsHandler) this.itemMoreActionsHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IItemMoreActionsHandler itemMoreActionsHandler_delegate$lambda$0(SearchActivity searchActivity) {
        return searchActivity.getItemMoreActionsHandlerFactory().create(searchActivity);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        Parcelable parcelable;
        EdgeToEdge.enable$default(this, null, null, 3, null);
        getSupportFragmentManager().setFragmentFactory(new RNScreensFragmentFactory());
        super.onMAMCreate(bundle);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable = (Parcelable) intent.getParcelableExtra(ACTIVITY_INITIAL_SEARCH_MODE_KEY, SearchMode.class);
        } else {
            Parcelable parcelableExtra = intent.getParcelableExtra(ACTIVITY_INITIAL_SEARCH_MODE_KEY);
            if (!(parcelableExtra instanceof SearchMode)) {
                parcelableExtra = null;
            }
            parcelable = (SearchMode) parcelableExtra;
        }
        SearchMode.Files files = (SearchMode) parcelable;
        if (files == null) {
            files = new SearchMode.Files(null, 1, null);
        }
        boolean booleanExtra = getIntent().getBooleanExtra(IntentConstants.EXTRA_RETURN_FOLDER_TO_CALLER, false);
        boolean booleanExtra2 = getIntent().getBooleanExtra(IntentConstants.EXTRA_RETURN_FILE_TO_CALLER, false);
        SearchNavigationConfig searchNavigationConfig = new SearchNavigationConfig(new SearchDestination.InnerDestination.Search(files, !booleanExtra2));
        boolean booleanExtra3 = getIntent().getBooleanExtra("ai_center_enabled", true);
        IntentServices intentServices = getIntentServices();
        BoxSearchItemClickHandler boxSearchItemClickHandler = getBoxSearchItemClickHandler();
        IItemMoreActionsHandler itemMoreActionsHandler = getItemMoreActionsHandler();
        SearchActivity$onCreate$1 searchActivity$onCreate$1 = new SearchActivity$onCreate$1(this);
        if (!booleanExtra) {
            searchActivity$onCreate$1 = null;
        }
        new SearchScreenContent(this, searchNavigationConfig, intentServices, new Function2() { // from class: com.box.android.search.presentation.SearchActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SearchActivity.onCreate$lambda$2((Composer) obj, ((Integer) obj2).intValue());
            }
        }, boxSearchItemClickHandler, itemMoreActionsHandler, searchActivity$onCreate$1, booleanExtra2 ? new SearchActivity$onCreate$3(this) : null, booleanExtra3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchViewModels onCreate$lambda$2(Composer composer, int i) {
        composer.startReplaceGroup(1193949595);
        ComposerKt.sourceInformation(composer, "C109@5160L25:SearchActivity.kt#42y6p");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1193949595, i, -1, "com.box.android.search.presentation.SearchActivity.onCreate.<anonymous> (SearchActivity.kt:109)");
        }
        SearchViewModels searchViewModelsDefaultSearchViewModels = SearchNavigationComposeKt.defaultSearchViewModels(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return searchViewModelsDefaultSearchViewModels;
    }

    public final void finishWithSelectedFolder$search_generalProdRelease(FolderModel folder) {
        Intrinsics.checkNotNullParameter(folder, "folder");
        Intent intent = new Intent();
        intent.putExtra(IntentConstants.EXTRA_INIT_FOLDER_ID, folder.getItemId().toString());
        intent.putExtra(IntentConstants.EXTRA_ITEM_NAME, folder.getName());
        setResult(-1, intent);
        finish();
    }

    public final void finishWithSelectedFile$search_generalProdRelease(FileModel file) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intent intent = new Intent();
        intent.putExtra(IntentConstants.EXTRA_PICKED_FILE, file);
        setResult(-1, intent);
        finish();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxResume() {
        super.onBoxResume();
        getItemMoreActionsHandler().registerMoreActionsHandler();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMPause() {
        super.onMAMPause();
        getItemMoreActionsHandler().unregisterMoreActionsHandler();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void handleOnActivityResult(int requestCode, int resultCode, Intent data) {
        super.handleOnActivityResult(requestCode, resultCode, data);
        getItemMoreActionsHandler().handleMoreActionsResult(requestCode, resultCode, data);
    }

    @Override // com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity
    public boolean amplitudeSetCurrentPage() {
        return BoxAmplitudeAnalytics.getInstance().setCurrentPage(BoxAnalyticsParams.PAGE_NAME_SEARCH);
    }

    @Override // com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
    public void invokeDefaultOnBackPressed() {
        getOnBackPressedDispatcher().onBackPressed();
    }

    /* JADX INFO: compiled from: SearchActivity.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/search/presentation/SearchActivity$Companion;", "", "<init>", "()V", "getIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "searchMode", "Lcom/box/android/domain/models/search/SearchMode;", SearchActivity.ACTIVITY_INITIAL_SEARCH_MODE_KEY, "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent getIntent(Context context, SearchMode searchMode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(searchMode, "searchMode");
            Intent intent = new Intent(context, (Class<?>) SearchActivity.class);
            intent.putExtra(SearchActivity.ACTIVITY_INITIAL_SEARCH_MODE_KEY, searchMode);
            return intent;
        }
    }
}
