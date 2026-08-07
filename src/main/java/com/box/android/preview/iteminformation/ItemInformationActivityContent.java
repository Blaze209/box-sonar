package com.box.android.preview.iteminformation;

import android.content.Intent;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.activity.result.ActivityResultLauncher;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.LifecycleOwnerKt;
import com.box.android.base.compose.DefaultAvatarControllerWrapper;
import com.box.android.base.presentation.activities.BoxFragmentActivity;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.configuration.IFeatureFlip;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.item.ItemModel;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.views.DefaultAvatarController;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: compiled from: ItemInformationActivity.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/box/android/preview/iteminformation/ItemInformationActivityContent;", "", "activity", "Landroidx/activity/ComponentActivity;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$State;", "Lcom/box/android/preview/iteminformation/ItemInformationReducer$Action;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "collaborationsLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "<init>", "(Landroidx/activity/ComponentActivity;Lcom/box/android/cpl/Store;Lcom/box/android/coreservices/services/IntentServices;Lcom/box/android/domain/identity/IUserContextManager;Landroidx/activity/result/ActivityResultLauncher;)V", "getActivity", "()Landroidx/activity/ComponentActivity;", "getStore", "()Lcom/box/android/cpl/Store;", "getIntentServices", "()Lcom/box/android/coreservices/services/IntentServices;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemInformationActivityContent {
    public static final int $stable = 8;
    private final ComponentActivity activity;
    private final ActivityResultLauncher<Intent> collaborationsLauncher;
    private final IntentServices intentServices;
    private final Store<ItemInformationReducer.State, ItemInformationReducer.Action> store;
    private final IUserContextManager userContextManager;

    public ItemInformationActivityContent(ComponentActivity activity, Store<ItemInformationReducer.State, ItemInformationReducer.Action> store, IntentServices intentServices, IUserContextManager userContextManager, ActivityResultLauncher<Intent> collaborationsLauncher) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(collaborationsLauncher, "collaborationsLauncher");
        this.activity = activity;
        this.store = store;
        this.intentServices = intentServices;
        this.userContextManager = userContextManager;
        this.collaborationsLauncher = collaborationsLauncher;
        final BoxSession boxSession = userContextManager.getBoxSession(activity);
        ComponentActivityKt.setContent$default(activity, null, ComposableLambdaKt.composableLambdaInstance(-583975834, true, new Function2() { // from class: com.box.android.preview.iteminformation.ItemInformationActivityContent$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ItemInformationActivityContent._init_$lambda$0(this.f$0, boxSession, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
        StoreKt.observe(store, new PropertyReference1Impl() { // from class: com.box.android.preview.iteminformation.ItemInformationActivityContent.2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((ItemInformationReducer.State) obj).getNavigationRoute();
            }
        }, LifecycleOwnerKt.getLifecycleScope(activity), new Function1() { // from class: com.box.android.preview.iteminformation.ItemInformationActivityContent$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ItemInformationActivityContent._init_$lambda$1(this.f$0, (ItemInformationReducer.Route) obj);
            }
        });
    }

    public final ComponentActivity getActivity() {
        return this.activity;
    }

    public final Store<ItemInformationReducer.State, ItemInformationReducer.Action> getStore() {
        return this.store;
    }

    public final IntentServices getIntentServices() {
        return this.intentServices;
    }

    public final IUserContextManager getUserContextManager() {
        return this.userContextManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(ItemInformationActivityContent itemInformationActivityContent, BoxSession boxSession, Composer composer, int i) {
        FeatureFlips featureFlips;
        IFeatureFlip mainScreenRedesign;
        ComposerKt.sourceInformation(composer, "C91@3556L326:ItemInformationActivity.kt#kcqqv0");
        boolean enabled = false;
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-583975834, i, -1, "com.box.android.preview.iteminformation.ItemInformationActivityContent.<anonymous> (ItemInformationActivity.kt:91)");
            }
            Store<ItemInformationReducer.State, ItemInformationReducer.Action> store = itemInformationActivityContent.store;
            DefaultAvatarControllerWrapper defaultAvatarControllerWrapper = new DefaultAvatarControllerWrapper(new DefaultAvatarController(boxSession));
            ComponentActivity componentActivity = itemInformationActivityContent.activity;
            BoxFragmentActivity boxFragmentActivity = componentActivity instanceof BoxFragmentActivity ? (BoxFragmentActivity) componentActivity : null;
            if (boxFragmentActivity != null && (featureFlips = boxFragmentActivity.mFeatureFlips) != null && (mainScreenRedesign = featureFlips.getMainScreenRedesign()) != null) {
                enabled = mainScreenRedesign.getEnabled();
            }
            ItemInformationActivityKt.ItemInformationScreenWithBackHandler(store, defaultAvatarControllerWrapper, enabled, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$1(ItemInformationActivityContent itemInformationActivityContent, ItemInformationReducer.Route it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it instanceof ItemInformationReducer.Route.Collaborators) {
            ActivityResultLauncher<Intent> activityResultLauncher = itemInformationActivityContent.collaborationsLauncher;
            IntentServices intentServices = itemInformationActivityContent.intentServices;
            ComponentActivity componentActivity = itemInformationActivityContent.activity;
            ItemModel itemModel = ((ItemInformationReducer.State) StoreKt.stateValue(itemInformationActivityContent.store)).getItemModel();
            BoxSession boxSession = itemInformationActivityContent.userContextManager.getBoxSession(itemInformationActivityContent.activity);
            Intrinsics.checkNotNullExpressionValue(boxSession, "getBoxSession(...)");
            activityResultLauncher.launch(IntentServices.collaborationsActivityIntent$default(intentServices, componentActivity, itemModel, boxSession, null, 8, null));
        } else {
            if (!(it instanceof ItemInformationReducer.Route.Exit)) {
                if (!(it instanceof ItemInformationReducer.Route.None)) {
                    throw new NoWhenBranchMatchedException();
                }
                return Unit.INSTANCE;
            }
            itemInformationActivityContent.activity.finish();
        }
        itemInformationActivityContent.store.send(new ItemInformationReducer.Action.Navigate(ItemInformationReducer.Route.None.INSTANCE));
        return Unit.INSTANCE;
    }
}
