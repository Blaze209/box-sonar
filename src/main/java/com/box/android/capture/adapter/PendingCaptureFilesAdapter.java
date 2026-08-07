package com.box.android.capture.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.base.presentation.adapters.BoxItemBrowseViewHolder;
import com.box.android.base.presentation.adapters.HeaderItemViewHolder;
import com.box.android.base.presentation.adapters.listitem.AdapterItem;
import com.box.android.base.presentation.adapters.listitem.AdapterItemDiffCallback;
import com.box.android.base.presentation.utilities.HeaderActionListener;
import com.box.android.base.presentation.utilities.ItemActionListener;
import com.box.android.base.views.JobStatusView;
import com.box.android.capture.CaptureHistoryFragment;
import com.box.android.capture.R;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.FlowExtensionsKt;
import com.box.android.common.utilities.ListingAdapterInterface;
import com.box.android.coreservices.models.BoxModelOfflineManagerWrapper;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.CaptureHistoryModel;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.JobInfo;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.services.IOfflineService;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.imageview.ShapeableImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: PendingCaptureFilesAdapter.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u00012\b\u0012\u0004\u0012\u00020\u00030\u0005:\u0002:;Bm\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\u0010\b\u001a\u00060\tR\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020)H\u0016J\u0010\u0010.\u001a\u00020)2\u0006\u0010-\u001a\u00020)H\u0016J\b\u0010/\u001a\u00020)H\u0016J\u0010\u00100\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0004H\u0016J\u0010\u00101\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0004H\u0016J\u0006\u00102\u001a\u00020+J\u0006\u00103\u001a\u00020+J\u0016\u00104\u001a\u00020+2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000306H\u0016J\u000e\u00107\u001a\u00020+2\u0006\u00108\u001a\u000209R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00060\tR\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/box/android/capture/adapter/PendingCaptureFilesAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/box/android/base/presentation/adapters/listitem/AdapterItem;", "Lcom/box/android/domain/models/CaptureHistoryModel;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/box/android/common/utilities/ListingAdapterInterface;", "context", "Landroid/content/Context;", "multiSelectHandler", "Lcom/box/android/capture/CaptureHistoryFragment$MultiSelectHandler;", "Lcom/box/android/capture/CaptureHistoryFragment;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/box/android/base/presentation/utilities/ItemActionListener;", "thumbnailManager", "Lcom/box/android/base/presentation/ThumbnailManager;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "actionListener", "Lcom/box/android/base/presentation/utilities/HeaderActionListener;", "offlineManagerWrapper", "Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;", "offlineService", "Lcom/box/android/domain/services/IOfflineService;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroid/content/Context;Lcom/box/android/capture/CaptureHistoryFragment$MultiSelectHandler;Lcom/box/android/base/presentation/utilities/ItemActionListener;Lcom/box/android/base/presentation/ThumbnailManager;Lcom/box/android/domain/configuration/FeatureFlips;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/base/presentation/utilities/HeaderActionListener;Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;Lcom/box/android/domain/services/IOfflineService;Lkotlinx/coroutines/CoroutineScope;)V", "getThumbnailManager", "()Lcom/box/android/base/presentation/ThumbnailManager;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "lifeCycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "changeUploadFolderActionableHeaderItem", "Lcom/box/android/base/presentation/adapters/listitem/AdapterItem$ActionableHeaderItem;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", ViewProps.POSITION, "getItemViewType", "getItemCount", "onViewRecycled", "onViewDetachedFromWindow", "showErrorRecovery", "hideErrorRecovery", "updateItems", "newList", "", "updateItem", "itemId", "Lcom/box/android/domain/models/ItemId;", "PendingHistoryDiffCallback", "PendingJobViewHolder", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PendingCaptureFilesAdapter extends ListAdapter<AdapterItem<? extends CaptureHistoryModel>, RecyclerView.ViewHolder> implements ListingAdapterInterface<CaptureHistoryModel> {
    public static final int $stable = 8;
    private final HeaderActionListener actionListener;
    private final AdapterItem.ActionableHeaderItem changeUploadFolderActionableHeaderItem;
    private final Context context;
    private final CoroutineScope coroutineScope;
    private final FeatureFlips featureFlips;
    private final LifecycleCoroutineScope lifeCycleScope;
    private final ItemActionListener<CaptureHistoryModel> listener;
    private final CaptureHistoryFragment.MultiSelectHandler multiSelectHandler;
    private final BoxModelOfflineManagerWrapper offlineManagerWrapper;
    private final IOfflineService offlineService;
    private final ThumbnailManager thumbnailManager;
    private final IUserContextManager userContextManager;

    public /* synthetic */ PendingCaptureFilesAdapter(Context context, CaptureHistoryFragment.MultiSelectHandler multiSelectHandler, ItemActionListener itemActionListener, ThumbnailManager thumbnailManager, FeatureFlips featureFlips, IUserContextManager iUserContextManager, HeaderActionListener headerActionListener, BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper, IOfflineService iOfflineService, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, multiSelectHandler, itemActionListener, thumbnailManager, featureFlips, iUserContextManager, headerActionListener, (i & 128) != 0 ? null : boxModelOfflineManagerWrapper, (i & 256) != 0 ? null : iOfflineService, (i & 512) != 0 ? null : coroutineScope);
    }

    public final ThumbnailManager getThumbnailManager() {
        return this.thumbnailManager;
    }

    public final IUserContextManager getUserContextManager() {
        return this.userContextManager;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PendingCaptureFilesAdapter(Context context, CaptureHistoryFragment.MultiSelectHandler multiSelectHandler, ItemActionListener<CaptureHistoryModel> listener, ThumbnailManager thumbnailManager, FeatureFlips featureFlips, IUserContextManager userContextManager, HeaderActionListener actionListener, BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper, IOfflineService iOfflineService, CoroutineScope coroutineScope) {
        super(new PendingHistoryDiffCallback());
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(multiSelectHandler, "multiSelectHandler");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(thumbnailManager, "thumbnailManager");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(actionListener, "actionListener");
        this.context = context;
        this.multiSelectHandler = multiSelectHandler;
        this.listener = listener;
        this.thumbnailManager = thumbnailManager;
        this.featureFlips = featureFlips;
        this.userContextManager = userContextManager;
        this.actionListener = actionListener;
        this.offlineManagerWrapper = boxModelOfflineManagerWrapper;
        this.offlineService = iOfflineService;
        this.coroutineScope = coroutineScope;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        this.lifeCycleScope = LifecycleOwnerKt.getLifecycleScope((AppCompatActivity) context);
        String string = context.getString(R.string.select_upload_folder);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getString(R.string.select);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.changeUploadFolderActionableHeaderItem = new AdapterItem.ActionableHeaderItem(string, string2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$0(PendingCaptureFilesAdapter pendingCaptureFilesAdapter, ItemModel item) {
        CoroutineScope coroutineScope;
        Intrinsics.checkNotNullParameter(item, "item");
        if (pendingCaptureFilesAdapter.offlineService != null && (coroutineScope = pendingCaptureFilesAdapter.coroutineScope) != null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PendingCaptureFilesAdapter$onCreateViewHolder$1$1(pendingCaptureFilesAdapter, item, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int i;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            if (this.featureFlips.getMainScreenRedesign().getEnabled()) {
                i = R.layout.browse_list_item;
            } else {
                i = R.layout.browse_list_item_legacy;
            }
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(i, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new PendingJobViewHolder(viewInflate, this.thumbnailManager, this.featureFlips, this.userContextManager, this.offlineManagerWrapper, this.coroutineScope, new Function1() { // from class: com.box.android.capture.adapter.PendingCaptureFilesAdapter$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PendingCaptureFilesAdapter.onCreateViewHolder$lambda$0(this.f$0, (ItemModel) obj);
                }
            });
        }
        if (viewType == 2) {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.actionable_header_item, parent, false);
            Intrinsics.checkNotNull(viewInflate2);
            return new ActionableHeaderItemViewHolder(viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_header, parent, false);
        Intrinsics.checkNotNull(viewInflate3);
        return new HeaderItemViewHolder(viewInflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        AdapterItem<? extends CaptureHistoryModel> adapterItem = getCurrentList().get(position);
        if (adapterItem instanceof AdapterItem.DataItem) {
            final CaptureHistoryModel captureHistoryModel = (CaptureHistoryModel) ((AdapterItem.DataItem) adapterItem).getValue();
            PendingJobViewHolder pendingJobViewHolder = (PendingJobViewHolder) holder;
            pendingJobViewHolder.bindItem(captureHistoryModel, this.lifeCycleScope);
            pendingJobViewHolder.handleMultiSelectMode(this.multiSelectHandler.get_isActionModeEnabled(), this.multiSelectHandler.isItemSelected(captureHistoryModel), this.multiSelectHandler.isItemSelectable(captureHistoryModel));
            pendingJobViewHolder.getView().setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.adapter.PendingCaptureFilesAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PendingCaptureFilesAdapter.onBindViewHolder$lambda$0$0(this.f$0, captureHistoryModel, view);
                }
            });
            pendingJobViewHolder.getView().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.box.android.capture.adapter.PendingCaptureFilesAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return PendingCaptureFilesAdapter.onBindViewHolder$lambda$0$1(this.f$0, captureHistoryModel, view);
                }
            });
            pendingJobViewHolder.getSecondaryActionView().setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.adapter.PendingCaptureFilesAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PendingCaptureFilesAdapter.onBindViewHolder$lambda$0$2(this.f$0, captureHistoryModel, view);
                }
            });
            return;
        }
        if (adapterItem instanceof AdapterItem.ActionableHeaderItem) {
            ((ActionableHeaderItemViewHolder) holder).bindItem((AdapterItem.ActionableHeaderItem) adapterItem, new Function0() { // from class: com.box.android.capture.adapter.PendingCaptureFilesAdapter$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PendingCaptureFilesAdapter.onBindViewHolder$lambda$1$0(this.f$0);
                }
            });
        } else {
            if (!(adapterItem instanceof AdapterItem.HeaderItem)) {
                throw new NoWhenBranchMatchedException();
            }
            ((HeaderItemViewHolder) holder).bindItem(((AdapterItem.HeaderItem) adapterItem).getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$0(PendingCaptureFilesAdapter pendingCaptureFilesAdapter, CaptureHistoryModel captureHistoryModel, View view) {
        pendingCaptureFilesAdapter.listener.onPrimaryAction(captureHistoryModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onBindViewHolder$lambda$0$1(PendingCaptureFilesAdapter pendingCaptureFilesAdapter, CaptureHistoryModel captureHistoryModel, View view) {
        return pendingCaptureFilesAdapter.listener.onLongClick(captureHistoryModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$2(PendingCaptureFilesAdapter pendingCaptureFilesAdapter, CaptureHistoryModel captureHistoryModel, View view) {
        pendingCaptureFilesAdapter.listener.onSecondaryAction(captureHistoryModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$1$0(PendingCaptureFilesAdapter pendingCaptureFilesAdapter) {
        pendingCaptureFilesAdapter.actionListener.onPrimaryAction();
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        AdapterItem<? extends CaptureHistoryModel> adapterItem = getCurrentList().get(position);
        if (adapterItem instanceof AdapterItem.ActionableHeaderItem) {
            return 2;
        }
        if (adapterItem instanceof AdapterItem.HeaderItem) {
            return 1;
        }
        if (adapterItem instanceof AdapterItem.DataItem) {
            return 0;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.ListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getCurrentList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        BoxItemBrowseViewHolder boxItemBrowseViewHolder = holder instanceof BoxItemBrowseViewHolder ? (BoxItemBrowseViewHolder) holder : null;
        if (boxItemBrowseViewHolder != null) {
            boxItemBrowseViewHolder.cancelOfflineObservation();
        }
        super.onViewRecycled(holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        BoxItemBrowseViewHolder boxItemBrowseViewHolder = holder instanceof BoxItemBrowseViewHolder ? (BoxItemBrowseViewHolder) holder : null;
        if (boxItemBrowseViewHolder != null) {
            boxItemBrowseViewHolder.cancelOfflineObservation();
        }
        super.onViewDetachedFromWindow(holder);
    }

    public final void showErrorRecovery() {
        List<AdapterItem<? extends CaptureHistoryModel>> currentList = getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        if (Intrinsics.areEqual(CollectionsKt.firstOrNull((List) currentList), this.changeUploadFolderActionableHeaderItem)) {
            return;
        }
        List listListOf = CollectionsKt.listOf(this.changeUploadFolderActionableHeaderItem);
        List<AdapterItem<? extends CaptureHistoryModel>> currentList2 = getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList2, "getCurrentList(...)");
        submitList(CollectionsKt.plus((Collection) listListOf, (Iterable) currentList2));
    }

    public final void hideErrorRecovery() {
        List<AdapterItem<? extends CaptureHistoryModel>> currentList = getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        if (Intrinsics.areEqual(CollectionsKt.firstOrNull((List) currentList), this.changeUploadFolderActionableHeaderItem)) {
            List<AdapterItem<? extends CaptureHistoryModel>> currentList2 = getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList2, "getCurrentList(...)");
            submitList(CollectionsKt.minus((Iterable) currentList2, (Iterable) CollectionsKt.listOf(this.changeUploadFolderActionableHeaderItem)));
        }
    }

    @Override // com.box.android.common.utilities.ListingAdapterInterface
    public void updateItems(List<? extends CaptureHistoryModel> newList) {
        Intrinsics.checkNotNullParameter(newList, "newList");
        ArrayList arrayList = new ArrayList();
        List<AdapterItem<? extends CaptureHistoryModel>> currentList = getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        if (Intrinsics.areEqual(CollectionsKt.firstOrNull((List) currentList), this.changeUploadFolderActionableHeaderItem)) {
            arrayList.add(0, this.changeUploadFolderActionableHeaderItem);
        }
        if (newList.isEmpty()) {
            submitList(arrayList);
            return;
        }
        String string = this.context.getString(R.string.pending);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        arrayList.add(new AdapterItem.HeaderItem(string));
        Iterator<T> it = newList.iterator();
        while (it.hasNext()) {
            arrayList.add(new AdapterItem.DataItem((CaptureHistoryModel) it.next()));
        }
        submitList(arrayList);
    }

    public final void updateItem(ItemId itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        List<AdapterItem<? extends CaptureHistoryModel>> currentList = getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
        Iterator<AdapterItem<? extends CaptureHistoryModel>> it = currentList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            AdapterItem<? extends CaptureHistoryModel> next = it.next();
            if ((next instanceof AdapterItem.DataItem) && Intrinsics.areEqual(((CaptureHistoryModel) ((AdapterItem.DataItem) next).getValue()).getFileModel().getItemId(), itemId)) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            notifyItemChanged(i);
        }
    }

    /* JADX INFO: compiled from: PendingCaptureFilesAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/box/android/capture/adapter/PendingCaptureFilesAdapter$PendingHistoryDiffCallback;", "Lcom/box/android/base/presentation/adapters/listitem/AdapterItemDiffCallback;", "Lcom/box/android/domain/models/CaptureHistoryModel;", "<init>", "()V", "getId", "", "item", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class PendingHistoryDiffCallback extends AdapterItemDiffCallback<CaptureHistoryModel> {
        public static final int $stable = AdapterItemDiffCallback.$stable;

        @Override // com.box.android.base.presentation.adapters.listitem.AdapterItemDiffCallback
        public String getId(CaptureHistoryModel item) {
            Intrinsics.checkNotNullParameter(item, "item");
            JobInfo jobInfo = item.getJobInfo();
            Intrinsics.checkNotNull(jobInfo);
            return jobInfo.getId().toString();
        }
    }

    /* JADX INFO: compiled from: PendingCaptureFilesAdapter.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\rJ\b\u0010\u001e\u001a\u00020\u0003H\u0016J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!H\u0002R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/box/android/capture/adapter/PendingCaptureFilesAdapter$PendingJobViewHolder;", "Lcom/box/android/capture/adapter/UploadedCaptureFilesAdapter$CaptureHistoryViewHolder;", "view", "Landroid/view/View;", "thumbnailManager", "Lcom/box/android/base/presentation/ThumbnailManager;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "offlineManagerWrapper", "Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "onUpdateClick", "Lkotlin/Function1;", "Lcom/box/android/domain/models/item/ItemModel;", "", "<init>", "(Landroid/view/View;Lcom/box/android/base/presentation/ThumbnailManager;Lcom/box/android/domain/configuration/FeatureFlips;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;)V", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "setJob", "(Lkotlinx/coroutines/Job;)V", "bindItem", "item", "Lcom/box/android/domain/models/CaptureHistoryModel;", "lifeCycleScope", "getSecondaryActionView", "updateIndicator", "status", "Lcom/box/android/domain/models/JobInfo$Status;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class PendingJobViewHolder extends UploadedCaptureFilesAdapter.CaptureHistoryViewHolder {
        public static final int $stable = 8;
        private Job job;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PendingJobViewHolder(View view, ThumbnailManager thumbnailManager, FeatureFlips featureFlips, IUserContextManager userContextManager, BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper, CoroutineScope coroutineScope, Function1<? super ItemModel, Unit> function1) {
            super(view, thumbnailManager, featureFlips, userContextManager, boxModelOfflineManagerWrapper, coroutineScope, function1);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(thumbnailManager, "thumbnailManager");
            Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        }

        public /* synthetic */ PendingJobViewHolder(View view, ThumbnailManager thumbnailManager, FeatureFlips featureFlips, IUserContextManager iUserContextManager, BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper, CoroutineScope coroutineScope, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(view, thumbnailManager, featureFlips, iUserContextManager, (i & 16) != 0 ? null : boxModelOfflineManagerWrapper, (i & 32) != 0 ? null : coroutineScope, (i & 64) != 0 ? null : function1);
        }

        public final Job getJob() {
            return this.job;
        }

        public final void setJob(Job job) {
            this.job = job;
        }

        public final void bindItem(CaptureHistoryModel item, CoroutineScope lifeCycleScope) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(lifeCycleScope, "lifeCycleScope");
            super.bindItem(item);
            Job job = this.job;
            if (job != null) {
                FlowExtensionsKt.cancelIfActive(job);
            }
            this.job = BuildersKt__Builders_commonKt.launch$default(lifeCycleScope, Dispatchers.getMain(), null, new PendingCaptureFilesAdapter$PendingJobViewHolder$bindItem$1(this, null), 2, null);
        }

        @Override // com.box.android.base.presentation.adapters.BoxItemBrowseViewHolder
        public View getSecondaryActionView() {
            JobStatusView jobProgressView = getCommonBinding().jobProgressView;
            Intrinsics.checkNotNullExpressionValue(jobProgressView, "jobProgressView");
            return jobProgressView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void updateIndicator(JobInfo.Status status) {
            Pair pair;
            ShapeableImageView shapeableImageView = getCommonBinding().icJobIndicator;
            if (status instanceof JobInfo.Status.Failed) {
                Integer numValueOf = Integer.valueOf(R.drawable.ic_job_alert_badge);
                Context context = shapeableImageView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                pair = new Pair(numValueOf, Integer.valueOf(CommonBoxUtil.getColorFromAttribute(context, R.attr.notification)));
            } else if (status instanceof JobInfo.Status.Paused) {
                Integer numValueOf2 = Integer.valueOf(R.drawable.ic_job_pause_badge);
                Context context2 = shapeableImageView.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                pair = new Pair(numValueOf2, Integer.valueOf(CommonBoxUtil.getColorFromAttribute(context2, R.attr.contentSecondary)));
            } else if (status instanceof JobInfo.Status.Running) {
                Integer numValueOf3 = Integer.valueOf(R.drawable.ic_job_progress);
                Context context3 = shapeableImageView.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                pair = new Pair(numValueOf3, Integer.valueOf(CommonBoxUtil.getColorFromAttribute(context3, R.attr.statusProgress)));
            } else {
                pair = new Pair(-1, -1);
            }
            int iIntValue = ((Number) pair.component1()).intValue();
            int iIntValue2 = ((Number) pair.component2()).intValue();
            if (iIntValue == -1) {
                shapeableImageView.setVisibility(8);
                return;
            }
            shapeableImageView.setVisibility(0);
            shapeableImageView.setImageResource(iIntValue);
            shapeableImageView.setBackgroundColor(iIntValue2);
        }
    }
}
