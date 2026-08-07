package com.box.android.fragments.boxitem;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.box.android.R;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.DefaultAvatarControllerWrapper;
import com.box.android.base.presentation.BoxFragmentInterface;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.cpl.Store;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.fragments.NotificationsTasksTabFragment;
import com.box.android.inbox.MfaCallbackIntentHandler;
import com.box.android.inbox.notifications.InboxContentKt;
import com.box.android.inbox.notifications.InboxReducer;
import com.box.android.inbox.notifications.InboxViewModel;
import com.box.android.inbox.notifications.router.IInboxRouter;
import com.box.android.inbox.notifications.router.InboxNotificationRoutingMapper;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.views.DefaultAvatarController;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: InboxFragment.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010$\u001a\u00020%H\u0016J$\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020/H\u0016J\u0012\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000205H\u0016J\b\u00107\u001a\u000201H\u0016J\u0010\u00108\u001a\u00020%2\u0006\u00109\u001a\u000205H\u0016R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006:"}, d2 = {"Lcom/box/android/fragments/boxitem/InboxFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/box/android/base/presentation/BoxFragmentInterface;", "Lcom/box/android/fragments/NotificationsTasksTabFragment$TabVisibility;", "<init>", "()V", "inboxViewModel", "Lcom/box/android/inbox/notifications/InboxViewModel;", "getInboxViewModel", "()Lcom/box/android/inbox/notifications/InboxViewModel;", "inboxViewModel$delegate", "Lkotlin/Lazy;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "setUserContextManager", "(Lcom/box/android/domain/identity/IUserContextManager;)V", "inboxRouter", "Lcom/box/android/inbox/notifications/router/IInboxRouter;", "getInboxRouter", "()Lcom/box/android/inbox/notifications/router/IInboxRouter;", "setInboxRouter", "(Lcom/box/android/inbox/notifications/router/IInboxRouter;)V", "routingMapper", "Lcom/box/android/inbox/notifications/router/InboxNotificationRoutingMapper;", "getRoutingMapper", "()Lcom/box/android/inbox/notifications/router/InboxNotificationRoutingMapper;", "setRoutingMapper", "(Lcom/box/android/inbox/notifications/router/InboxNotificationRoutingMapper;)V", "mfaCallbackIntentHandler", "Lcom/box/android/inbox/MfaCallbackIntentHandler;", "getMfaCallbackIntentHandler", "()Lcom/box/android/inbox/MfaCallbackIntentHandler;", "setMfaCallbackIntentHandler", "(Lcom/box/android/inbox/MfaCallbackIntentHandler;)V", "onResume", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "getType", "", "getTitle", "", "context", "Landroid/content/Context;", "onBackPressed", "", "isFloatingMenuAvailable", "getAmplitudePageName", "setTabVisibility", "isTabVisible", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class InboxFragment extends Hilt_InboxFragment implements BoxFragmentInterface, NotificationsTasksTabFragment.TabVisibility {
    public static final int $stable = 8;

    @Inject
    public IInboxRouter inboxRouter;

    /* JADX INFO: renamed from: inboxViewModel$delegate, reason: from kotlin metadata */
    private final Lazy inboxViewModel;

    @Inject
    public MfaCallbackIntentHandler mfaCallbackIntentHandler;

    @Inject
    public InboxNotificationRoutingMapper routingMapper;

    @Inject
    public IUserContextManager userContextManager;

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public int getType() {
        return 6;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public boolean isFloatingMenuAvailable() {
        return false;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public boolean onBackPressed() {
        return false;
    }

    @Override // com.box.android.fragments.NotificationsTasksTabFragment.TabVisibility
    public void setTabVisibility(boolean isTabVisible) {
    }

    public InboxFragment() {
        final InboxFragment inboxFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.box.android.fragments.boxitem.InboxFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return inboxFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.box.android.fragments.boxitem.InboxFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function0.invoke();
            }
        });
        final Function0 function1 = null;
        this.inboxViewModel = FragmentViewModelLazyKt.createViewModelLazy(inboxFragment, Reflection.getOrCreateKotlinClass(InboxViewModel.class), new Function0<ViewModelStore>() { // from class: com.box.android.fragments.boxitem.InboxFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m10254viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.box.android.fragments.boxitem.InboxFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function2 = function1;
                if (function2 != null && (creationExtras = (CreationExtras) function2.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM10254viewModels$lambda1 = FragmentViewModelLazyKt.m10254viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM10254viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM10254viewModels$lambda1 : null;
                return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.box.android.fragments.boxitem.InboxFragment$special$$inlined$viewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory;
                ViewModelStoreOwner viewModelStoreOwnerM10254viewModels$lambda1 = FragmentViewModelLazyKt.m10254viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM10254viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM10254viewModels$lambda1 : null;
                return (hasDefaultViewModelProviderFactory == null || (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) == null) ? inboxFragment.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
            }
        });
    }

    private final InboxViewModel getInboxViewModel() {
        return (InboxViewModel) this.inboxViewModel.getValue();
    }

    public final IUserContextManager getUserContextManager() {
        IUserContextManager iUserContextManager = this.userContextManager;
        if (iUserContextManager != null) {
            return iUserContextManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userContextManager");
        return null;
    }

    public final void setUserContextManager(IUserContextManager iUserContextManager) {
        Intrinsics.checkNotNullParameter(iUserContextManager, "<set-?>");
        this.userContextManager = iUserContextManager;
    }

    public final IInboxRouter getInboxRouter() {
        IInboxRouter iInboxRouter = this.inboxRouter;
        if (iInboxRouter != null) {
            return iInboxRouter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("inboxRouter");
        return null;
    }

    public final void setInboxRouter(IInboxRouter iInboxRouter) {
        Intrinsics.checkNotNullParameter(iInboxRouter, "<set-?>");
        this.inboxRouter = iInboxRouter;
    }

    public final InboxNotificationRoutingMapper getRoutingMapper() {
        InboxNotificationRoutingMapper inboxNotificationRoutingMapper = this.routingMapper;
        if (inboxNotificationRoutingMapper != null) {
            return inboxNotificationRoutingMapper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("routingMapper");
        return null;
    }

    public final void setRoutingMapper(InboxNotificationRoutingMapper inboxNotificationRoutingMapper) {
        Intrinsics.checkNotNullParameter(inboxNotificationRoutingMapper, "<set-?>");
        this.routingMapper = inboxNotificationRoutingMapper;
    }

    public final MfaCallbackIntentHandler getMfaCallbackIntentHandler() {
        MfaCallbackIntentHandler mfaCallbackIntentHandler = this.mfaCallbackIntentHandler;
        if (mfaCallbackIntentHandler != null) {
            return mfaCallbackIntentHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mfaCallbackIntentHandler");
        return null;
    }

    public final void setMfaCallbackIntentHandler(MfaCallbackIntentHandler mfaCallbackIntentHandler) {
        Intrinsics.checkNotNullParameter(mfaCallbackIntentHandler, "<set-?>");
        this.mfaCallbackIntentHandler = mfaCallbackIntentHandler;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        try {
            Intent intent = requireActivity().getIntent();
            MfaCallbackIntentHandler mfaCallbackIntentHandler = getMfaCallbackIntentHandler();
            Store<InboxReducer.State, InboxReducer.Action> store = getInboxViewModel().getStore();
            Intrinsics.checkNotNull(intent);
            mfaCallbackIntentHandler.handleIntent(store, intent);
        } catch (Exception e) {
            String name = InboxFragment.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            BoxLogUtils.e(name, e);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextRequireContext, null, 0, 6, null);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-1581635364, true, new Function2() { // from class: com.box.android.fragments.boxitem.InboxFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return InboxFragment.onCreateView$lambda$0$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        return composeView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0(final InboxFragment inboxFragment, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C62@2297L509,62@2288L518:InboxFragment.kt#rft9a4");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1581635364, i, -1, "com.box.android.fragments.boxitem.InboxFragment.onCreateView.<anonymous>.<anonymous> (InboxFragment.kt:62)");
            }
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(516680049, true, new Function2() { // from class: com.box.android.fragments.boxitem.InboxFragment$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InboxFragment.onCreateView$lambda$0$0$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0(InboxFragment inboxFragment, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C63@2319L469:InboxFragment.kt#rft9a4");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(516680049, i, -1, "com.box.android.fragments.boxitem.InboxFragment.onCreateView.<anonymous>.<anonymous>.<anonymous> (InboxFragment.kt:63)");
            }
            InboxContentKt.InboxContent(inboxFragment.getInboxViewModel().getStore(), new DefaultAvatarControllerWrapper(new DefaultAvatarController(inboxFragment.getUserContextManager().getBoxSession(inboxFragment.requireContext()))), inboxFragment.getInboxRouter(), inboxFragment.getRoutingMapper(), null, false, composer, 0, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getTitle(Context context) {
        return CommonBoxUtil.LS(R.string.notifications);
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getAmplitudePageName() {
        return BoxAnalyticsParams.PAGE_NAME_NOTIFICATIONS;
    }
}
