package com.box.android.base.presentation.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.KeyEventDispatcher;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import com.box.android.base.databinding.BottomSheetItemListingBinding;
import com.box.android.base.databinding.FragmentItemListingBinding;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.base.presentation.presenters.BaseListingPresenter;
import com.box.android.base.presentation.utilities.ListingDialogFragmentInterface;
import com.box.android.base.presentation.widgets.BoxItemDividerDecoration;
import com.box.android.common.utilities.ErrorEvent;
import com.box.android.common.utilities.ErrorUIType;
import com.box.android.common.utilities.ListingAdapterInterface;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: BaseListingBottomSheetDialogFragment.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000 P*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\b\u0012\u0004\u0012\u0002H\u00010\u00072\u00020\b:\u0001PB\u0007¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J&\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020,H\u0016J\b\u0010.\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020,H\u0016J\b\u00100\u001a\u00020,H\u0016J \u00101\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u0014H$J\u0012\u00102\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u000303H$J\b\u00104\u001a\u00020\fH\u0014JP\u0010+\u001a\u00020,2\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020,06j\u0002`82\u0016\u00109\u001a\u0012\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020,06j\u0002`82\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020,06j\u0002`8H&J\b\u0010;\u001a\u00020,H\u0016J\b\u0010<\u001a\u00020\fH\u0016J\u0016\u0010=\u001a\u00020\f2\f\u0010>\u001a\b\u0012\u0002\b\u0003\u0018\u00010?H\u0017J\b\u0010@\u001a\u00020\fH\u0016J\u0016\u0010A\u001a\u00020,2\f\u0010>\u001a\b\u0012\u0002\b\u0003\u0018\u00010?H\u0017J\b\u0010B\u001a\u00020,H\u0016J\u0016\u0010C\u001a\u00020,2\f\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000EH\u0016J\u000e\u0010F\u001a\u00020,2\u0006\u0010>\u001a\u000207J\u0010\u0010G\u001a\u00020,2\u0006\u0010H\u001a\u00020IH\u0014J\u0010\u0010J\u001a\u00020,2\u0006\u0010H\u001a\u00020KH\u0014R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R2\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u0014X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00028\u00018DX\u0084\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\n\u001a\u0004\b \u0010!R\u0012\u0010L\u001a\u00020MX\u0096\u0005¢\u0006\u0006\u001a\u0004\bN\u0010O¨\u0006Q"}, d2 = {"Lcom/box/android/base/presentation/fragments/BaseListingBottomSheetDialogFragment;", ExifInterface.GPS_DIRECTION_TRUE, "VB", "Landroidx/viewbinding/ViewBinding;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/box/android/base/presentation/utilities/ListingDialogFragmentInterface;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "Lcom/box/android/base/presentation/presenters/BaseListingPresenter$BoxItemsView;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "waitingForConnection", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "presenter", "Lcom/box/android/base/presentation/presenters/BaseListingPresenter;", "getPresenter", "()Lcom/box/android/base/presentation/presenters/BaseListingPresenter;", "setPresenter", "(Lcom/box/android/base/presentation/presenters/BaseListingPresenter;)V", "commonBinding", "Lcom/box/android/base/databinding/BottomSheetItemListingBinding;", "mConnectivityReceiver", "Landroid/content/BroadcastReceiver;", "_binding", "binding", "getBinding$annotations", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onCreateView", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setupEmptyView", "", "setupRecyclerView", "onResume", "onPause", "dismissDialog", "createPresenter", "createAdapter", "Landroidx/paging/PagedListAdapter;", "isContentAvailable", "emptyImageSetter", "Lkotlin/Function1;", "", "Lcom/box/android/base/presentation/fragments/ResourceSetter;", "emptyTextSetter", "emptySubtextSetter", "updateUI", "onBackPressed", "shouldUpdateFragment", "message", "Lcom/box/android/coreservices/modelcontroller/messages/BoxMessage;", "isFloatingMenuAvailable", "updateFragment", "updateFromRemote", "renderNewList", "newList", "", "showToast", "handleError", "event", "Lcom/box/android/common/utilities/ErrorEvent;", "showSnackBar", "Lcom/box/android/common/utilities/ErrorUIType$Snackbar;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Companion", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class BaseListingBottomSheetDialogFragment<T, VB extends ViewBinding> extends BottomSheetDialogFragment implements ListingDialogFragmentInterface, SwipeRefreshLayout.OnRefreshListener, BaseListingPresenter.BoxItemsView<T>, CoroutineScope {
    private static final String LOG_TAG = "BaseListingBottomSheetDialogFragment";
    private ViewBinding _binding;
    protected RecyclerView.Adapter<?> adapter;
    private BottomSheetItemListingBinding commonBinding;
    protected BaseListingPresenter<T, BaseListingBottomSheetDialogFragment<T, VB>> presenter;
    private boolean waitingForConnection;
    public static final int $stable = 8;
    private final /* synthetic */ CoroutineScope $$delegate_0 = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    private final BroadcastReceiver mConnectivityReceiver = new MAMBroadcastReceiver(this) { // from class: com.box.android.base.presentation.fragments.BaseListingBottomSheetDialogFragment$mConnectivityReceiver$1
        final /* synthetic */ BaseListingBottomSheetDialogFragment<T, VB> this$0;

        {
            this.this$0 = this;
        }

        @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
        public void onMAMReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (Intrinsics.areEqual(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
                Object systemService = context.getSystemService("connectivity");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
                boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnected();
                if (((BaseListingBottomSheetDialogFragment) this.this$0).waitingForConnection && z) {
                    ((BaseListingBottomSheetDialogFragment) this.this$0).waitingForConnection = false;
                    this.this$0.onRefresh();
                }
            }
        }
    };

    protected static /* synthetic */ void getBinding$annotations() {
    }

    protected abstract PagedListAdapter<T, ?> createAdapter();

    protected abstract BaseListingPresenter<T, BaseListingBottomSheetDialogFragment<T, VB>> createPresenter();

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

    protected void showSnackBar(ErrorUIType.Snackbar event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    protected final RecyclerView.Adapter<?> getAdapter() {
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

    protected final BaseListingPresenter<T, BaseListingBottomSheetDialogFragment<T, VB>> getPresenter() {
        BaseListingPresenter<T, BaseListingBottomSheetDialogFragment<T, VB>> baseListingPresenter = this.presenter;
        if (baseListingPresenter != null) {
            return baseListingPresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
        return null;
    }

    protected final void setPresenter(BaseListingPresenter<T, BaseListingBottomSheetDialogFragment<T, VB>> baseListingPresenter) {
        Intrinsics.checkNotNullParameter(baseListingPresenter, "<set-?>");
        this.presenter = baseListingPresenter;
    }

    protected final VB getBinding() {
        VB vb = (VB) this._binding;
        Intrinsics.checkNotNull(vb, "null cannot be cast to non-null type VB of com.box.android.base.presentation.fragments.BaseListingBottomSheetDialogFragment");
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
        BottomSheetItemListingBinding bottomSheetItemListingBindingBind = BottomSheetItemListingBinding.bind(getBinding().getRoot());
        Intrinsics.checkNotNullExpressionValue(bottomSheetItemListingBindingBind, "bind(...)");
        this.commonBinding = bottomSheetItemListingBindingBind;
        setupEmptyView();
        setupRecyclerView();
        setPresenter(createPresenter());
        getPresenter().attachView(this, getViewLifecycleOwner().getLifecycle());
        updateUI();
        return getBinding().getRoot();
    }

    private final void setupEmptyView() {
        setupEmptyView(new Function1() { // from class: com.box.android.base.presentation.fragments.BaseListingBottomSheetDialogFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseListingBottomSheetDialogFragment.setupEmptyView$lambda$2(this.f$0, ((Integer) obj).intValue());
            }
        }, new Function1() { // from class: com.box.android.base.presentation.fragments.BaseListingBottomSheetDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseListingBottomSheetDialogFragment.setupEmptyView$lambda$0(this.f$0, ((Integer) obj).intValue());
            }
        }, new Function1() { // from class: com.box.android.base.presentation.fragments.BaseListingBottomSheetDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseListingBottomSheetDialogFragment.setupEmptyView$lambda$1(this.f$0, ((Integer) obj).intValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupEmptyView$lambda$0(BaseListingBottomSheetDialogFragment baseListingBottomSheetDialogFragment, int i) {
        BottomSheetItemListingBinding bottomSheetItemListingBinding = baseListingBottomSheetDialogFragment.commonBinding;
        if (bottomSheetItemListingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
            bottomSheetItemListingBinding = null;
        }
        bottomSheetItemListingBinding.emptyText.setText(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupEmptyView$lambda$1(BaseListingBottomSheetDialogFragment baseListingBottomSheetDialogFragment, int i) {
        BottomSheetItemListingBinding bottomSheetItemListingBinding = baseListingBottomSheetDialogFragment.commonBinding;
        if (bottomSheetItemListingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
            bottomSheetItemListingBinding = null;
        }
        bottomSheetItemListingBinding.emptySubtext.setText(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupEmptyView$lambda$2(BaseListingBottomSheetDialogFragment baseListingBottomSheetDialogFragment, int i) {
        BottomSheetItemListingBinding bottomSheetItemListingBinding = baseListingBottomSheetDialogFragment.commonBinding;
        if (bottomSheetItemListingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
            bottomSheetItemListingBinding = null;
        }
        bottomSheetItemListingBinding.emptyImage.setImageResource(i);
        return Unit.INSTANCE;
    }

    public void setupRecyclerView() {
        BottomSheetItemListingBinding bottomSheetItemListingBinding = this.commonBinding;
        BottomSheetItemListingBinding bottomSheetItemListingBinding2 = null;
        if (bottomSheetItemListingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
            bottomSheetItemListingBinding = null;
        }
        bottomSheetItemListingBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        BottomSheetItemListingBinding bottomSheetItemListingBinding3 = this.commonBinding;
        if (bottomSheetItemListingBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
            bottomSheetItemListingBinding3 = null;
        }
        RecyclerView recyclerView = bottomSheetItemListingBinding3.recyclerView;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        BottomSheetItemListingBinding bottomSheetItemListingBinding4 = this.commonBinding;
        if (bottomSheetItemListingBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
            bottomSheetItemListingBinding4 = null;
        }
        Resources.Theme theme = bottomSheetItemListingBinding4.recyclerView.getContext().getTheme();
        Intrinsics.checkNotNullExpressionValue(theme, "getTheme(...)");
        recyclerView.addItemDecoration(new BoxItemDividerDecoration(resources, theme));
        BottomSheetItemListingBinding bottomSheetItemListingBinding5 = this.commonBinding;
        if (bottomSheetItemListingBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
            bottomSheetItemListingBinding5 = null;
        }
        bottomSheetItemListingBinding5.recyclerView.setClipToPadding(false);
        if (this.adapter == null) {
            setAdapter(createAdapter());
        }
        getAdapter().registerAdapterDataObserver(new RecyclerView.AdapterDataObserver(this) { // from class: com.box.android.base.presentation.fragments.BaseListingBottomSheetDialogFragment.setupRecyclerView.1
            final /* synthetic */ BaseListingBottomSheetDialogFragment<T, VB> this$0;

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
        BottomSheetItemListingBinding bottomSheetItemListingBinding6 = this.commonBinding;
        if (bottomSheetItemListingBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
        } else {
            bottomSheetItemListingBinding2 = bottomSheetItemListingBinding6;
        }
        bottomSheetItemListingBinding2.recyclerView.setAdapter(getAdapter());
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

    @Override // com.box.android.base.presentation.utilities.ListingDialogFragmentInterface
    public void dismissDialog() {
        dismiss();
    }

    protected boolean isContentAvailable() {
        return this.presenter != null && getPresenter().isContentAvailable();
    }

    @Override // com.box.android.base.presentation.ListingFragmentInterface
    public void updateUI() {
        BottomSheetItemListingBinding bottomSheetItemListingBinding = null;
        if (!isContentAvailable()) {
            BottomSheetItemListingBinding bottomSheetItemListingBinding2 = this.commonBinding;
            if (bottomSheetItemListingBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
            } else {
                bottomSheetItemListingBinding = bottomSheetItemListingBinding2;
            }
            bottomSheetItemListingBinding.progressBar.setVisibility(0);
            return;
        }
        if (getAdapter().getItemCount() == 0) {
            BottomSheetItemListingBinding bottomSheetItemListingBinding3 = this.commonBinding;
            if (bottomSheetItemListingBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
                bottomSheetItemListingBinding3 = null;
            }
            bottomSheetItemListingBinding3.emptyItemLayout.setVisibility(0);
            BottomSheetItemListingBinding bottomSheetItemListingBinding4 = this.commonBinding;
            if (bottomSheetItemListingBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
                bottomSheetItemListingBinding4 = null;
            }
            bottomSheetItemListingBinding4.recyclerView.setVisibility(8);
        } else {
            BottomSheetItemListingBinding bottomSheetItemListingBinding5 = this.commonBinding;
            if (bottomSheetItemListingBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
                bottomSheetItemListingBinding5 = null;
            }
            bottomSheetItemListingBinding5.emptyItemLayout.setVisibility(8);
            BottomSheetItemListingBinding bottomSheetItemListingBinding6 = this.commonBinding;
            if (bottomSheetItemListingBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
                bottomSheetItemListingBinding6 = null;
            }
            bottomSheetItemListingBinding6.recyclerView.setVisibility(0);
        }
        BottomSheetItemListingBinding bottomSheetItemListingBinding7 = this.commonBinding;
        if (bottomSheetItemListingBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonBinding");
        } else {
            bottomSheetItemListingBinding = bottomSheetItemListingBinding7;
        }
        bottomSheetItemListingBinding.progressBar.setVisibility(8);
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    @Deprecated(message = "Deprecated in Java")
    public void updateFragment(BoxMessage<?> message) {
        BaseListingPresenter<T, BaseListingBottomSheetDialogFragment<T, VB>> presenter = getPresenter();
        Intrinsics.checkNotNull(message);
        presenter.handleBroadcastMessage(message);
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.fragments.BaseListingBottomSheetDialogFragment$updateFromRemote$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseListingBottomSheetDialogFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.fragments.BaseListingBottomSheetDialogFragment$updateFromRemote$1", f = "BaseListingBottomSheetDialogFragment.kt", i = {}, l = {191}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BaseListingBottomSheetDialogFragment<T, VB> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09301(BaseListingBottomSheetDialogFragment<T, VB> baseListingBottomSheetDialogFragment, Continuation<? super C09301> continuation) {
            super(2, continuation);
            this.this$0 = baseListingBottomSheetDialogFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09301(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09301) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.this$0.presenter != null) {
                    if (this.this$0.getActivity() instanceof IMainParent) {
                        KeyEventDispatcher.Component activity = this.this$0.getActivity();
                        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.box.android.base.presentation.fragments.IMainParent");
                        ((IMainParent) activity).dismissSnackbar();
                    }
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
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new C09301(this, null), 3, null);
    }

    @Override // com.box.android.base.presentation.presenters.BaseListingPresenter.BoxItemsView
    public void renderNewList(List<? extends T> newList) {
        Intrinsics.checkNotNullParameter(newList, "newList");
        if (getAdapter() instanceof PagedListAdapter) {
            RecyclerView.Adapter<?> adapter = getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type androidx.paging.PagedListAdapter<T of com.box.android.base.presentation.fragments.BaseListingBottomSheetDialogFragment, *>");
            ((PagedListAdapter) adapter).submitList((PagedList) newList);
        } else {
            Object adapter2 = getAdapter();
            Intrinsics.checkNotNull(adapter2, "null cannot be cast to non-null type com.box.android.common.utilities.ListingAdapterInterface<T of com.box.android.base.presentation.fragments.BaseListingBottomSheetDialogFragment>");
            ((ListingAdapterInterface) adapter2).updateItems(newList);
        }
        updateUI();
    }

    public final void showToast(int message) {
        BoxPresentationUtils.displayToast(message, getContext(), new String[0]);
    }

    protected void handleError(ErrorEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        updateUI();
        if (event instanceof ErrorEvent.SnackbarWithButton) {
            ErrorUIType value = event.getValue();
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.box.android.common.utilities.ErrorUIType.Snackbar");
            showSnackBar((ErrorUIType.Snackbar) value);
        } else {
            if (!(event instanceof ErrorEvent.Toast)) {
                BoxLogUtils.e(LOG_TAG, "Unexpected else branch");
                return;
            }
            ErrorUIType value2 = event.getValue();
            Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type com.box.android.common.utilities.ErrorUIType.Toast");
            showToast(((ErrorUIType.Toast) value2).getMessage());
        }
    }
}
