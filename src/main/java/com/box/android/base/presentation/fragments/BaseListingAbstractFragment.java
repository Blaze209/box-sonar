package com.box.android.base.presentation.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarResult;
import androidx.core.view.KeyEventDispatcher;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import com.box.android.base.R;
import com.box.android.base.databinding.FragmentItemListingBinding;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.base.presentation.ListingFragmentInterface;
import com.box.android.base.presentation.activities.BoxFragmentActivity;
import com.box.android.base.presentation.presenters.BaseListingPresenter;
import com.box.android.base.presentation.utilities.AddFabHelper;
import com.box.android.base.presentation.widgets.BoxItemDividerDecoration;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.ErrorEvent;
import com.box.android.common.utilities.ErrorUIType;
import com.box.android.common.utilities.ListingAdapterInterface;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;
import java.util.Arrays;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: BaseListingAbstractFragment.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000 r*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\b\u0012\u0004\u0012\u0002H\u00010\u00072\u00020\b2\u00020\t:\u0001rB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?H\u0014J&\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\b\u0010D\u001a\u00020-H\u0002J\b\u0010E\u001a\u00020-H\u0002J\b\u0010F\u001a\u00020-H\u0016J\n\u0010G\u001a\u0004\u0018\u00010HH\u0016J\u0018\u0010I\u001a\u00020-2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0004J\u0018\u0010N\u001a\u00020-2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020MH\u0004J\b\u0010O\u001a\u00020-H\u0016J\b\u0010P\u001a\u00020-H\u0016J \u0010Q\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u0015H$J\f\u0010R\u001a\u0006\u0012\u0002\b\u00030\u000fH$J\b\u0010S\u001a\u00020\rH\u0014JP\u0010D\u001a\u00020-2\u0016\u0010T\u001a\u0012\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020-0Uj\u0002`V2\u0016\u0010W\u001a\u0012\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020-0Uj\u0002`V2\u0016\u0010X\u001a\u0012\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020-0Uj\u0002`VH&J\b\u0010Y\u001a\u00020-H\u0016J\b\u0010Z\u001a\u00020-H\u0016J\b\u0010[\u001a\u00020\rH\u0016J\u0016\u0010\\\u001a\u00020\r2\f\u0010\u001f\u001a\b\u0012\u0002\b\u0003\u0018\u00010]H\u0017J\b\u0010^\u001a\u00020\rH\u0016J\u0016\u0010_\u001a\u00020-2\f\u0010\u001f\u001a\b\u0012\u0002\b\u0003\u0018\u00010]H\u0017J\b\u0010`\u001a\u00020-H\u0016J\u0016\u0010a\u001a\u00020-2\f\u0010b\u001a\b\u0012\u0004\u0012\u00028\u00000cH\u0016J'\u0010d\u001a\u00020-2\u0006\u0010\u001f\u001a\u00020M2\u0012\u0010e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001c0f\"\u00020\u001c¢\u0006\u0002\u0010gJ\u000e\u0010h\u001a\u00020-2\u0006\u0010i\u001a\u00020jJ\u0010\u0010k\u001a\u00020-2\u0006\u0010i\u001a\u00020lH\u0002J\b\u0010m\u001a\u00020-H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R2\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u0015X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019Ru\u0010\u001a\u001a[\b\u0001\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0013\u0012\u00110!¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010\u001bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u00028\u00018DX\u0084\u0004¢\u0006\f\u0012\u0004\b6\u0010\u000b\u001a\u0004\b7\u00108R\u000e\u00109\u001a\u00020:X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010n\u001a\u00020oX\u0096\u0005¢\u0006\u0006\u001a\u0004\bp\u0010q¨\u0006s"}, d2 = {"Lcom/box/android/base/presentation/fragments/BaseListingAbstractFragment;", ExifInterface.GPS_DIRECTION_TRUE, "VB", "Landroidx/viewbinding/ViewBinding;", "Landroidx/fragment/app/Fragment;", "Lcom/box/android/base/presentation/ListingFragmentInterface;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "Lcom/box/android/base/presentation/presenters/BaseListingPresenter$BoxItemsView;", "Lcom/box/android/base/presentation/utilities/AddFabHelper;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "waitingForConnection", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "presenter", "Lcom/box/android/base/presentation/presenters/BaseListingPresenter;", "getPresenter", "()Lcom/box/android/base/presentation/presenters/BaseListingPresenter;", "setPresenter", "(Lcom/box/android/base/presentation/presenters/BaseListingPresenter;)V", "showSnackbarListener", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "message", "actionLabel", "Landroidx/compose/material3/SnackbarDuration;", "duration", "Lkotlin/coroutines/Continuation;", "Landroidx/compose/material3/SnackbarResult;", "", "getShowSnackbarListener", "()Lkotlin/jvm/functions/Function4;", "setShowSnackbarListener", "(Lkotlin/jvm/functions/Function4;)V", "Lkotlin/jvm/functions/Function4;", "dismissSnackbarListener", "Lkotlin/Function0;", "", "getDismissSnackbarListener", "()Lkotlin/jvm/functions/Function0;", "setDismissSnackbarListener", "(Lkotlin/jvm/functions/Function0;)V", "mConnectivityReceiver", "Landroid/content/BroadcastReceiver;", "_binding", "binding", "getBinding$annotations", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "commonBinding", "Lcom/box/android/base/databinding/FragmentItemListingBinding;", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onCreateView", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setupEmptyView", "setupSwipeRefresh", "setupRecyclerView", "getItemDividerDecoration", "Lcom/box/android/base/presentation/widgets/BoxItemDividerDecoration;", "disableMenuItem", "menu", "Landroid/view/Menu;", "itemId", "", "enableMenuItem", "onResume", "onPause", "createPresenter", "createAdapter", "isContentAvailable", "emptyImageSetter", "Lkotlin/Function1;", "Lcom/box/android/base/presentation/fragments/ResourceSetter;", "emptyTextSetter", "emptySubtextSetter", "onRefresh", "updateUI", "onBackPressed", "shouldUpdateFragment", "Lcom/box/android/coreservices/modelcontroller/messages/BoxMessage;", "isFloatingMenuAvailable", "updateFragment", "updateFromRemote", "renderNewList", "newList", "", "showToast", "args", "", "(I[Ljava/lang/String;)V", "handleError", "event", "Lcom/box/android/common/utilities/ErrorEvent;", "showSnackBar", "Lcom/box/android/common/utilities/ErrorUIType$Snackbar;", "dismissSnackbar", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Companion", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class BaseListingAbstractFragment<T, VB extends ViewBinding> extends Fragment implements ListingFragmentInterface, SwipeRefreshLayout.OnRefreshListener, BaseListingPresenter.BoxItemsView<T>, AddFabHelper, CoroutineScope {
    private static final String LOG_TAG = "BaseListingAbstractFragment";
    private ViewBinding _binding;
    protected RecyclerView.Adapter<?> adapter;
    private FragmentItemListingBinding commonBinding;
    private Function0<Unit> dismissSnackbarListener;
    protected BaseListingPresenter<T, BaseListingAbstractFragment<T, VB>> presenter;
    private Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> showSnackbarListener;
    private boolean waitingForConnection;
    public static final int $stable = 8;
    private final /* synthetic */ CoroutineScope $$delegate_0 = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    private final BroadcastReceiver mConnectivityReceiver = new MAMBroadcastReceiver(this) { // from class: com.box.android.base.presentation.fragments.BaseListingAbstractFragment$mConnectivityReceiver$1
        final /* synthetic */ BaseListingAbstractFragment<T, VB> this$0;

        {
            this.this$0 = this;
        }

        @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
        public void onMAMReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (Intrinsics.areEqual(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
                Object systemService = ApplicationProvider.getApplication().getSystemService("connectivity");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
                boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnected();
                if (((BaseListingAbstractFragment) this.this$0).waitingForConnection && z) {
                    ((BaseListingAbstractFragment) this.this$0).waitingForConnection = false;
                    this.this$0.onRefresh();
                }
            }
        }
    };

    protected static /* synthetic */ void getBinding$annotations() {
    }

    protected abstract RecyclerView.Adapter<?> createAdapter();

    protected abstract BaseListingPresenter<T, BaseListingAbstractFragment<T, VB>> createPresenter();

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public boolean isFloatingMenuAvailable() {
        return false;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public boolean onBackPressed() {
        return false;
    }

    public abstract void setupEmptyView(Function1<? super Integer, Unit> emptyImageSetter, Function1<? super Integer, Unit> emptyTextSetter, Function1<? super Integer, Unit> emptySubtextSetter);

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    @Deprecated(message = "Deprecated in Java")
    public boolean shouldUpdateFragment(BoxMessage<?> message) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RecyclerView.Adapter<?> getAdapter() {
        RecyclerView.Adapter<?> adapter = this.adapter;
        if (adapter != null) {
            return adapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        return null;
    }

    protected final void setAdapter(RecyclerView.Adapter<?> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "<set-?>");
        this.adapter = adapter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BaseListingPresenter<T, BaseListingAbstractFragment<T, VB>> getPresenter() {
        BaseListingPresenter<T, BaseListingAbstractFragment<T, VB>> baseListingPresenter = this.presenter;
        if (baseListingPresenter != null) {
            return baseListingPresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
        return null;
    }

    protected final void setPresenter(BaseListingPresenter<T, BaseListingAbstractFragment<T, VB>> baseListingPresenter) {
        Intrinsics.checkNotNullParameter(baseListingPresenter, "<set-?>");
        this.presenter = baseListingPresenter;
    }

    public final Function4<String, String, SnackbarDuration, Continuation<? super SnackbarResult>, Object> getShowSnackbarListener() {
        return this.showSnackbarListener;
    }

    public final void setShowSnackbarListener(Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function4) {
        this.showSnackbarListener = function4;
    }

    public final Function0<Unit> getDismissSnackbarListener() {
        return this.dismissSnackbarListener;
    }

    public final void setDismissSnackbarListener(Function0<Unit> function0) {
        this.dismissSnackbarListener = function0;
    }

    protected final VB getBinding() {
        VB vb = (VB) this._binding;
        Intrinsics.checkNotNull(vb, "null cannot be cast to non-null type VB of com.box.android.base.presentation.fragments.BaseListingAbstractFragment");
        return vb;
    }

    protected ViewBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentItemListingBinding fragmentItemListingBindingInflate = FragmentItemListingBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentItemListingBindingInflate, "inflate(...)");
        return fragmentItemListingBindingInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = inflateBinding(inflater, container);
        FragmentItemListingBinding fragmentItemListingBindingBind = FragmentItemListingBinding.bind(getBinding().getRoot());
        Intrinsics.checkNotNullExpressionValue(fragmentItemListingBindingBind, "bind(...)");
        this.commonBinding = fragmentItemListingBindingBind;
        setupEmptyView();
        setupSwipeRefresh();
        setupRecyclerView();
        setPresenter(createPresenter());
        getPresenter().attachView(this, getViewLifecycleOwner().getLifecycleRegistry());
        updateUI();
        return getBinding().getRoot();
    }

    private final void setupEmptyView() {
        setupEmptyView(new Function1() { // from class: com.box.android.base.presentation.fragments.BaseListingAbstractFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseListingAbstractFragment.setupEmptyView$lambda$2(this.f$0, ((Integer) obj).intValue());
            }
        }, new Function1() { // from class: com.box.android.base.presentation.fragments.BaseListingAbstractFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseListingAbstractFragment.setupEmptyView$lambda$0(this.f$0, ((Integer) obj).intValue());
            }
        }, new Function1() { // from class: com.box.android.base.presentation.fragments.BaseListingAbstractFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseListingAbstractFragment.setupEmptyView$lambda$1(this.f$0, ((Integer) obj).intValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupEmptyView$lambda$0(BaseListingAbstractFragment baseListingAbstractFragment, int i) {
        FragmentItemListingBinding fragmentItemListingBinding = baseListingAbstractFragment.commonBinding;
        if (fragmentItemListingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
            fragmentItemListingBinding = null;
        }
        fragmentItemListingBinding.emptyText.setText(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupEmptyView$lambda$1(BaseListingAbstractFragment baseListingAbstractFragment, int i) {
        FragmentItemListingBinding fragmentItemListingBinding = baseListingAbstractFragment.commonBinding;
        if (fragmentItemListingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
            fragmentItemListingBinding = null;
        }
        fragmentItemListingBinding.emptySubtext.setText(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupEmptyView$lambda$2(BaseListingAbstractFragment baseListingAbstractFragment, int i) {
        FragmentItemListingBinding fragmentItemListingBinding = baseListingAbstractFragment.commonBinding;
        if (fragmentItemListingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
            fragmentItemListingBinding = null;
        }
        fragmentItemListingBinding.emptyImage.setImageResource(i);
        return Unit.INSTANCE;
    }

    private final void setupSwipeRefresh() {
        FragmentItemListingBinding fragmentItemListingBinding = this.commonBinding;
        FragmentItemListingBinding fragmentItemListingBinding2 = null;
        if (fragmentItemListingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
            fragmentItemListingBinding = null;
        }
        fragmentItemListingBinding.swipeRefreshView.setOnRefreshListener(this);
        FragmentItemListingBinding fragmentItemListingBinding3 = this.commonBinding;
        if (fragmentItemListingBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
            fragmentItemListingBinding3 = null;
        }
        SwipeRefreshLayout swipeRefreshLayout = fragmentItemListingBinding3.swipeRefreshView;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        swipeRefreshLayout.setColorSchemeColors(CommonBoxUtil.getColorFromAttribute(contextRequireContext, R.attr.colorAccent));
        FragmentItemListingBinding fragmentItemListingBinding4 = this.commonBinding;
        if (fragmentItemListingBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
        } else {
            fragmentItemListingBinding2 = fragmentItemListingBinding4;
        }
        fragmentItemListingBinding2.swipeRefreshView.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics()));
    }

    public void setupRecyclerView() {
        FragmentItemListingBinding fragmentItemListingBinding = this.commonBinding;
        FragmentItemListingBinding fragmentItemListingBinding2 = null;
        if (fragmentItemListingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
            fragmentItemListingBinding = null;
        }
        fragmentItemListingBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        BoxItemDividerDecoration itemDividerDecoration = getItemDividerDecoration();
        if (itemDividerDecoration != null) {
            FragmentItemListingBinding fragmentItemListingBinding3 = this.commonBinding;
            if (fragmentItemListingBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
                fragmentItemListingBinding3 = null;
            }
            fragmentItemListingBinding3.recyclerView.addItemDecoration(itemDividerDecoration);
        }
        FragmentItemListingBinding fragmentItemListingBinding4 = this.commonBinding;
        if (fragmentItemListingBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
            fragmentItemListingBinding4 = null;
        }
        fragmentItemListingBinding4.recyclerView.setClipToPadding(false);
        int dimension = (int) getResources().getDimension(R.dimen.box_browsesdk_list_footer_padding);
        FragmentItemListingBinding fragmentItemListingBinding5 = this.commonBinding;
        if (fragmentItemListingBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
            fragmentItemListingBinding5 = null;
        }
        RecyclerView recyclerView = fragmentItemListingBinding5.recyclerView;
        FragmentItemListingBinding fragmentItemListingBinding6 = this.commonBinding;
        if (fragmentItemListingBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
            fragmentItemListingBinding6 = null;
        }
        int paddingLeft = fragmentItemListingBinding6.recyclerView.getPaddingLeft();
        FragmentItemListingBinding fragmentItemListingBinding7 = this.commonBinding;
        if (fragmentItemListingBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
            fragmentItemListingBinding7 = null;
        }
        int paddingTop = fragmentItemListingBinding7.recyclerView.getPaddingTop();
        FragmentItemListingBinding fragmentItemListingBinding8 = this.commonBinding;
        if (fragmentItemListingBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
            fragmentItemListingBinding8 = null;
        }
        recyclerView.setPadding(paddingLeft, paddingTop, fragmentItemListingBinding8.recyclerView.getPaddingRight(), dimension);
        if (this.adapter == null) {
            setAdapter(createAdapter());
        }
        getAdapter().registerAdapterDataObserver(new RecyclerView.AdapterDataObserver(this) { // from class: com.box.android.base.presentation.fragments.BaseListingAbstractFragment.setupRecyclerView.2
            final /* synthetic */ BaseListingAbstractFragment<T, VB> this$0;

            {
                this.this$0 = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int positionStart, int itemCount) {
                this.this$0.updateUI();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int positionStart, int itemCount) {
                this.this$0.updateUI();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int positionStart, int itemCount) {
                this.this$0.updateUI();
            }
        });
        FragmentItemListingBinding fragmentItemListingBinding9 = this.commonBinding;
        if (fragmentItemListingBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
        } else {
            fragmentItemListingBinding2 = fragmentItemListingBinding9;
        }
        fragmentItemListingBinding2.recyclerView.setAdapter(getAdapter());
    }

    public BoxItemDividerDecoration getItemDividerDecoration() {
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        Resources.Theme theme = requireContext().getTheme();
        Intrinsics.checkNotNullExpressionValue(theme, "getTheme(...)");
        return new BoxItemDividerDecoration(resources, theme);
    }

    protected final void disableMenuItem(Menu menu, int itemId) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        MenuItem menuItemFindItem = menu.findItem(itemId);
        if (menuItemFindItem != null) {
            menuItemFindItem.setEnabled(false);
            menuItemFindItem.setVisible(false);
        }
    }

    protected final void enableMenuItem(Menu menu, int itemId) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        MenuItem menuItemFindItem = menu.findItem(itemId);
        if (menuItemFindItem != null) {
            menuItemFindItem.setEnabled(true);
            menuItemFindItem.setVisible(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        requireActivity().registerReceiver(this.mConnectivityReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        requireActivity().unregisterReceiver(this.mConnectivityReceiver);
        super.onPause();
    }

    protected boolean isContentAvailable() {
        return this.presenter != null && getPresenter().isContentAvailable();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        FragmentItemListingBinding fragmentItemListingBinding = this.commonBinding;
        if (fragmentItemListingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
            fragmentItemListingBinding = null;
        }
        fragmentItemListingBinding.swipeRefreshView.setRefreshing(true);
        dismissSnackbar();
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.fragments.BaseListingAbstractFragment$onRefresh$1, reason: invalid class name */
    /* JADX INFO: compiled from: BaseListingAbstractFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.fragments.BaseListingAbstractFragment$onRefresh$1", f = "BaseListingAbstractFragment.kt", i = {}, l = {223}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BaseListingAbstractFragment<T, VB> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BaseListingAbstractFragment<T, VB> baseListingAbstractFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = baseListingAbstractFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.this$0.getPresenter().refresh(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.fragments.BaseListingAbstractFragment$updateUI$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseListingAbstractFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.fragments.BaseListingAbstractFragment$updateUI$1", f = "BaseListingAbstractFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BaseListingAbstractFragment<T, VB> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09291(BaseListingAbstractFragment<T, VB> baseListingAbstractFragment, Continuation<? super C09291> continuation) {
            super(2, continuation);
            this.this$0 = baseListingAbstractFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09291(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09291) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FragmentItemListingBinding fragmentItemListingBinding = null;
            if (!this.this$0.isContentAvailable()) {
                FragmentItemListingBinding fragmentItemListingBinding2 = ((BaseListingAbstractFragment) this.this$0).commonBinding;
                if (fragmentItemListingBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
                } else {
                    fragmentItemListingBinding = fragmentItemListingBinding2;
                }
                fragmentItemListingBinding.progressBar.setVisibility(0);
                return Unit.INSTANCE;
            }
            FragmentItemListingBinding fragmentItemListingBinding3 = ((BaseListingAbstractFragment) this.this$0).commonBinding;
            if (fragmentItemListingBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
                fragmentItemListingBinding3 = null;
            }
            fragmentItemListingBinding3.emptyItemLayout.setVisibility(this.this$0.getAdapter().getItemCount() == 0 ? 0 : 8);
            FragmentItemListingBinding fragmentItemListingBinding4 = ((BaseListingAbstractFragment) this.this$0).commonBinding;
            if (fragmentItemListingBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
                fragmentItemListingBinding4 = null;
            }
            fragmentItemListingBinding4.progressBar.setVisibility(8);
            FragmentItemListingBinding fragmentItemListingBinding5 = ((BaseListingAbstractFragment) this.this$0).commonBinding;
            if (fragmentItemListingBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
            } else {
                fragmentItemListingBinding = fragmentItemListingBinding5;
            }
            fragmentItemListingBinding.swipeRefreshView.setRefreshing(false);
            return Unit.INSTANCE;
        }
    }

    @Override // com.box.android.base.presentation.ListingFragmentInterface
    public void updateUI() {
        BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getMain(), null, new C09291(this, null), 2, null);
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    @Deprecated(message = "Deprecated in Java")
    public void updateFragment(BoxMessage<?> message) {
        BaseListingPresenter<T, BaseListingAbstractFragment<T, VB>> presenter = getPresenter();
        Intrinsics.checkNotNull(message);
        presenter.handleBroadcastMessage(message);
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.fragments.BaseListingAbstractFragment$updateFromRemote$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseListingAbstractFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.fragments.BaseListingAbstractFragment$updateFromRemote$1", f = "BaseListingAbstractFragment.kt", i = {}, l = {255}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BaseListingAbstractFragment<T, VB> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09281(BaseListingAbstractFragment<T, VB> baseListingAbstractFragment, Continuation<? super C09281> continuation) {
            super(2, continuation);
            this.this$0 = baseListingAbstractFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09281(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09281) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.this$0.presenter != null) {
                    this.this$0.dismissSnackbar();
                    this.label = 1;
                    if (this.this$0.getPresenter().fetchItems(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public void updateFromRemote() {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new C09281(this, null), 3, null);
    }

    @Override // com.box.android.base.presentation.presenters.BaseListingPresenter.BoxItemsView
    public void renderNewList(List<? extends T> newList) {
        Intrinsics.checkNotNullParameter(newList, "newList");
        if (getAdapter() instanceof PagedListAdapter) {
            RecyclerView.Adapter<?> adapter = getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type androidx.paging.PagedListAdapter<T of com.box.android.base.presentation.fragments.BaseListingAbstractFragment, *>");
            ((PagedListAdapter) adapter).submitList((PagedList) newList);
        } else {
            Object adapter2 = getAdapter();
            Intrinsics.checkNotNull(adapter2, "null cannot be cast to non-null type com.box.android.common.utilities.ListingAdapterInterface<T of com.box.android.base.presentation.fragments.BaseListingAbstractFragment>");
            ((ListingAdapterInterface) adapter2).updateItems(newList);
        }
        updateUI();
    }

    public final void showToast(int message, String... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        BoxPresentationUtils.displayToast(message, getContext(), (String[]) Arrays.copyOf(args, args.length));
    }

    public final void handleError(ErrorEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        updateUI();
        if (event instanceof ErrorEvent.SnackbarWithButton) {
            ErrorUIType value = event.getValue();
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.box.android.common.utilities.ErrorUIType.Snackbar");
            showSnackBar((ErrorUIType.Snackbar) value);
        } else {
            if (event instanceof ErrorEvent.Toast) {
                ErrorUIType value2 = event.getValue();
                Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type com.box.android.common.utilities.ErrorUIType.Toast");
                int message = ((ErrorUIType.Toast) value2).getMessage();
                ErrorUIType value3 = event.getValue();
                Intrinsics.checkNotNull(value3, "null cannot be cast to non-null type com.box.android.common.utilities.ErrorUIType.Toast");
                String[] args = ((ErrorUIType.Toast) value3).getArgs();
                showToast(message, (String[]) Arrays.copyOf(args, args.length));
                return;
            }
            BoxLogUtils.e(LOG_TAG, "Unexpected else branch");
        }
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.fragments.BaseListingAbstractFragment$showSnackBar$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseListingAbstractFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.fragments.BaseListingAbstractFragment$showSnackBar$1", f = "BaseListingAbstractFragment.kt", i = {1}, l = {BoxCommonConstants.REQUEST_OPEN_FILE, 301}, m = "invokeSuspend", n = {"snackbarResult"}, s = {"L$0"}, v = 1)
    static final class C09271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ErrorUIType.Snackbar $event;
        Object L$0;
        int label;
        final /* synthetic */ BaseListingAbstractFragment<T, VB> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09271(BaseListingAbstractFragment<T, VB> baseListingAbstractFragment, ErrorUIType.Snackbar snackbar, Continuation<? super C09271> continuation) {
            super(2, continuation);
            this.this$0 = baseListingAbstractFragment;
            this.$event = snackbar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09271(this.this$0, this.$event, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09271) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x0055  */
        /* JADX WARN: Code duplicated, block: B:21:0x005d  */
        /* JADX WARN: Code duplicated, block: B:22:0x0063  */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x004a, code lost:
        
            if (r8 == r0) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x007f, code lost:
        
            if (r7.this$0.getPresenter().fetchItems(r7) == r0) goto L25;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L23
                if (r1 == r4) goto L1f
                if (r1 != r3) goto L17
                java.lang.Object r7 = r7.L$0
                androidx.compose.material3.SnackbarResult r7 = (androidx.compose.material3.SnackbarResult) r7
                kotlin.ResultKt.throwOnFailure(r8)
                goto L82
            L17:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1f:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L4d
            L23:
                kotlin.ResultKt.throwOnFailure(r8)
                com.box.android.base.presentation.fragments.BaseListingAbstractFragment<T, VB extends androidx.viewbinding.ViewBinding> r8 = r7.this$0
                kotlin.jvm.functions.Function4 r8 = r8.getShowSnackbarListener()
                if (r8 == 0) goto L50
                com.box.android.common.utilities.ErrorUIType$Snackbar r1 = r7.$event
                int r1 = r1.getMessage()
                java.lang.String r1 = com.box.android.common.utilities.CommonBoxUtil.LS(r1)
                com.box.android.common.utilities.ErrorUIType$Snackbar r5 = r7.$event
                int r5 = r5.getButtonText()
                java.lang.String r5 = com.box.android.common.utilities.CommonBoxUtil.LS(r5)
                androidx.compose.material3.SnackbarDuration r6 = androidx.compose.material3.SnackbarDuration.Indefinite
                r7.label = r4
                java.lang.Object r8 = r8.invoke(r1, r5, r6, r7)
                if (r8 != r0) goto L4d
                goto L81
            L4d:
                androidx.compose.material3.SnackbarResult r8 = (androidx.compose.material3.SnackbarResult) r8
                goto L51
            L50:
                r8 = r2
            L51:
                androidx.compose.material3.SnackbarResult r1 = androidx.compose.material3.SnackbarResult.ActionPerformed
                if (r8 != r1) goto L82
                com.box.android.base.presentation.fragments.BaseListingAbstractFragment<T, VB extends androidx.viewbinding.ViewBinding> r1 = r7.this$0
                com.box.android.base.databinding.FragmentItemListingBinding r1 = com.box.android.base.presentation.fragments.BaseListingAbstractFragment.access$getCommonBinding$p(r1)
                if (r1 != 0) goto L63
                java.lang.String r1 = "commonBinding"
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
                goto L64
            L63:
                r2 = r1
            L64:
                android.widget.ProgressBar r1 = r2.progressBar
                r2 = 0
                r1.setVisibility(r2)
                com.box.android.base.presentation.fragments.BaseListingAbstractFragment<T, VB extends androidx.viewbinding.ViewBinding> r1 = r7.this$0
                com.box.android.base.presentation.presenters.BaseListingPresenter r1 = r1.getPresenter()
                r2 = r7
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
                r7.L$0 = r8
                r7.label = r3
                java.lang.Object r7 = r1.fetchItems(r2)
                if (r7 != r0) goto L82
            L81:
                return r0
            L82:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.base.presentation.fragments.BaseListingAbstractFragment.C09271.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final void showSnackBar(ErrorUIType.Snackbar event) {
        if (this.showSnackbarListener != null) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09271(this, event, null), 3, null);
        } else if (getActivity() instanceof IMainParent) {
            KeyEventDispatcher.Component activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.box.android.base.presentation.fragments.IMainParent");
            if (Intrinsics.areEqual(((IMainParent) activity).getCurrentVisibleFragment(), this)) {
                FragmentActivity activity2 = getActivity();
                Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type com.box.android.base.presentation.activities.BoxFragmentActivity");
                ((BoxFragmentActivity) activity2).displaySnackbar(event.getMessage(), event.getButtonText(), new View.OnClickListener() { // from class: com.box.android.base.presentation.fragments.BaseListingAbstractFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BaseListingAbstractFragment.showSnackBar$lambda$0(this.f$0, view);
                    }
                }, -2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSnackBar$lambda$0(BaseListingAbstractFragment baseListingAbstractFragment, View view) {
        FragmentItemListingBinding fragmentItemListingBinding = baseListingAbstractFragment.commonBinding;
        if (fragmentItemListingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
            fragmentItemListingBinding = null;
        }
        fragmentItemListingBinding.progressBar.setVisibility(0);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(baseListingAbstractFragment), null, null, new BaseListingAbstractFragment$showSnackBar$2$1(baseListingAbstractFragment, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissSnackbar() {
        Function0<Unit> function0 = this.dismissSnackbarListener;
        if (function0 != null) {
            if (function0 != null) {
                function0.invoke();
            }
        } else if (getActivity() instanceof IMainParent) {
            KeyEventDispatcher.Component activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.box.android.base.presentation.fragments.IMainParent");
            ((IMainParent) activity).dismissSnackbar();
        }
    }
}
