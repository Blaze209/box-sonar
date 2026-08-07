package com.box.android.capture.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.base.presentation.adapters.BoxItemBrowseViewHolder;
import com.box.android.base.presentation.adapters.HeaderItemViewHolder;
import com.box.android.base.presentation.adapters.listitem.AdapterItem;
import com.box.android.base.presentation.adapters.listitem.AdapterItemDiffCallback;
import com.box.android.base.presentation.utilities.ItemActionListener;
import com.box.android.capture.CaptureHistoryFragment;
import com.box.android.capture.R;
import com.box.android.common.utilities.ListingAdapterInterface;
import com.box.android.coreservices.models.BoxModelOfflineManagerWrapper;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.mappers.FolderModelMapper;
import com.box.android.domain.models.CaptureHistoryModel;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.services.ICaptureThumbnailService;
import com.box.android.domain.services.IOfflineService;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.utils.SdkUtils;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.imageview.ShapeableImageView;
import java.io.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: UploadedCaptureFilesAdapter.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u00012\b\u0012\u0004\u0012\u00020\u00030\u0005:\u000267Be\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\u0010\b\u001a\u00060\tR\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020'H\u0016J\u0010\u0010,\u001a\u00020'2\u0006\u0010+\u001a\u00020'H\u0016J\b\u0010-\u001a\u00020'H\u0016J\u0016\u0010.\u001a\u00020)2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000300H\u0016J\u0010\u00101\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0004H\u0016J\u0010\u00102\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0004H\u0016J\u000e\u00103\u001a\u00020)2\u0006\u00104\u001a\u000205R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0012\u0010\b\u001a\u00060\tR\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/box/android/capture/adapter/UploadedCaptureFilesAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/box/android/base/presentation/adapters/listitem/AdapterItem;", "Lcom/box/android/domain/models/CaptureHistoryModel;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/box/android/common/utilities/ListingAdapterInterface;", "context", "Landroid/content/Context;", "multiSelectHandler", "Lcom/box/android/capture/CaptureHistoryFragment$MultiSelectHandler;", "Lcom/box/android/capture/CaptureHistoryFragment;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/box/android/base/presentation/utilities/ItemActionListener;", "thumbnailManager", "Lcom/box/android/base/presentation/ThumbnailManager;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "offlineManagerWrapper", "Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;", "offlineService", "Lcom/box/android/domain/services/IOfflineService;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroid/content/Context;Lcom/box/android/capture/CaptureHistoryFragment$MultiSelectHandler;Lcom/box/android/base/presentation/utilities/ItemActionListener;Lcom/box/android/base/presentation/ThumbnailManager;Lcom/box/android/domain/configuration/FeatureFlips;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;Lcom/box/android/domain/services/IOfflineService;Lkotlinx/coroutines/CoroutineScope;)V", "getContext", "()Landroid/content/Context;", "getListener", "()Lcom/box/android/base/presentation/utilities/ItemActionListener;", "getThumbnailManager", "()Lcom/box/android/base/presentation/ThumbnailManager;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", ViewProps.POSITION, "getItemViewType", "getItemCount", "updateItems", "newList", "", "onViewRecycled", "onViewDetachedFromWindow", "updateItem", "itemId", "Lcom/box/android/domain/models/ItemId;", "CaptureHistoryViewHolder", "CaptureHistoryDiffCallback", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UploadedCaptureFilesAdapter extends ListAdapter<AdapterItem<? extends CaptureHistoryModel>, RecyclerView.ViewHolder> implements ListingAdapterInterface<CaptureHistoryModel> {
    public static final int $stable = 8;
    private final Context context;
    private final CoroutineScope coroutineScope;
    private final FeatureFlips featureFlips;
    private final ItemActionListener<CaptureHistoryModel> listener;
    private final CaptureHistoryFragment.MultiSelectHandler multiSelectHandler;
    private final BoxModelOfflineManagerWrapper offlineManagerWrapper;
    private final IOfflineService offlineService;
    private final ThumbnailManager thumbnailManager;
    private final IUserContextManager userContextManager;

    public /* synthetic */ UploadedCaptureFilesAdapter(Context context, CaptureHistoryFragment.MultiSelectHandler multiSelectHandler, ItemActionListener itemActionListener, ThumbnailManager thumbnailManager, FeatureFlips featureFlips, IUserContextManager iUserContextManager, BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper, IOfflineService iOfflineService, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, multiSelectHandler, itemActionListener, thumbnailManager, featureFlips, iUserContextManager, (i & 64) != 0 ? null : boxModelOfflineManagerWrapper, (i & 128) != 0 ? null : iOfflineService, (i & 256) != 0 ? null : coroutineScope);
    }

    public final Context getContext() {
        return this.context;
    }

    public final ItemActionListener<CaptureHistoryModel> getListener() {
        return this.listener;
    }

    public final ThumbnailManager getThumbnailManager() {
        return this.thumbnailManager;
    }

    public final IUserContextManager getUserContextManager() {
        return this.userContextManager;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadedCaptureFilesAdapter(Context context, CaptureHistoryFragment.MultiSelectHandler multiSelectHandler, ItemActionListener<CaptureHistoryModel> listener, ThumbnailManager thumbnailManager, FeatureFlips featureFlips, IUserContextManager userContextManager, BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper, IOfflineService iOfflineService, CoroutineScope coroutineScope) {
        super(new CaptureHistoryDiffCallback());
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(multiSelectHandler, "multiSelectHandler");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(thumbnailManager, "thumbnailManager");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        this.context = context;
        this.multiSelectHandler = multiSelectHandler;
        this.listener = listener;
        this.thumbnailManager = thumbnailManager;
        this.featureFlips = featureFlips;
        this.userContextManager = userContextManager;
        this.offlineManagerWrapper = boxModelOfflineManagerWrapper;
        this.offlineService = iOfflineService;
        this.coroutineScope = coroutineScope;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(this.featureFlips.getMainScreenRedesign().getEnabled() ? R.layout.browse_list_item : R.layout.browse_list_item_legacy, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new CaptureHistoryViewHolder(viewInflate, this.thumbnailManager, this.featureFlips, this.userContextManager, this.offlineManagerWrapper, this.coroutineScope, new Function1() { // from class: com.box.android.capture.adapter.UploadedCaptureFilesAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return UploadedCaptureFilesAdapter.onCreateViewHolder$lambda$0(this.f$0, (ItemModel) obj);
                }
            });
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_header, parent, false);
        Intrinsics.checkNotNull(viewInflate2);
        return new HeaderItemViewHolder(viewInflate2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateViewHolder$lambda$0(UploadedCaptureFilesAdapter uploadedCaptureFilesAdapter, ItemModel item) {
        CoroutineScope coroutineScope;
        Intrinsics.checkNotNullParameter(item, "item");
        if (uploadedCaptureFilesAdapter.offlineService != null && (coroutineScope = uploadedCaptureFilesAdapter.coroutineScope) != null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new UploadedCaptureFilesAdapter$onCreateViewHolder$1$1(uploadedCaptureFilesAdapter, item, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        AdapterItem<? extends CaptureHistoryModel> adapterItem = getCurrentList().get(position);
        if (adapterItem instanceof AdapterItem.DataItem) {
            final CaptureHistoryModel captureHistoryModel = (CaptureHistoryModel) ((AdapterItem.DataItem) adapterItem).getValue();
            CaptureHistoryViewHolder captureHistoryViewHolder = (CaptureHistoryViewHolder) holder;
            captureHistoryViewHolder.bindItem(captureHistoryModel);
            captureHistoryViewHolder.handleMultiSelectMode(this.multiSelectHandler.get_isActionModeEnabled(), this.multiSelectHandler.isItemSelected(captureHistoryModel), this.multiSelectHandler.get_isActionModeEnabled() || this.multiSelectHandler.isItemSelectable(captureHistoryModel));
            if (captureHistoryViewHolder.getCaptureHistoryModel().getJobInfo() != null) {
                captureHistoryViewHolder.disableView();
            }
            captureHistoryViewHolder.getView().setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.adapter.UploadedCaptureFilesAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UploadedCaptureFilesAdapter.onBindViewHolder$lambda$0$0(this.f$0, captureHistoryModel, view);
                }
            });
            captureHistoryViewHolder.getView().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.box.android.capture.adapter.UploadedCaptureFilesAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return UploadedCaptureFilesAdapter.onBindViewHolder$lambda$0$1(this.f$0, captureHistoryModel, view);
                }
            });
            captureHistoryViewHolder.getSecondaryActionView().setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.adapter.UploadedCaptureFilesAdapter$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UploadedCaptureFilesAdapter.onBindViewHolder$lambda$0$2(this.f$0, captureHistoryModel, view);
                }
            });
            return;
        }
        if (adapterItem instanceof AdapterItem.HeaderItem) {
            ((HeaderItemViewHolder) holder).bindItem(((AdapterItem.HeaderItem) adapterItem).getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$0(UploadedCaptureFilesAdapter uploadedCaptureFilesAdapter, CaptureHistoryModel captureHistoryModel, View view) {
        uploadedCaptureFilesAdapter.listener.onPrimaryAction(captureHistoryModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onBindViewHolder$lambda$0$1(UploadedCaptureFilesAdapter uploadedCaptureFilesAdapter, CaptureHistoryModel captureHistoryModel, View view) {
        return uploadedCaptureFilesAdapter.listener.onLongClick(captureHistoryModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$2(UploadedCaptureFilesAdapter uploadedCaptureFilesAdapter, CaptureHistoryModel captureHistoryModel, View view) {
        uploadedCaptureFilesAdapter.listener.onSecondaryAction(captureHistoryModel);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return getCurrentList().get(position) instanceof AdapterItem.HeaderItem ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.ListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getCurrentList().size();
    }

    @Override // com.box.android.common.utilities.ListingAdapterInterface
    public void updateItems(List<? extends CaptureHistoryModel> newList) {
        AdapterItem.HeaderItem headerItem;
        Intrinsics.checkNotNullParameter(newList, "newList");
        ArrayList arrayList = new ArrayList();
        String str = DateFormat.getDateInstance(2).format(new Date());
        String str2 = null;
        for (CaptureHistoryModel captureHistoryModel : newList) {
            DateFormat dateInstance = DateFormat.getDateInstance(2);
            Date contentCreatedDate = captureHistoryModel.getFileModel().getContentCreatedDate();
            Intrinsics.checkNotNull(contentCreatedDate);
            String str3 = dateInstance.format(contentCreatedDate);
            if (!Intrinsics.areEqual(str2, str3)) {
                if (Intrinsics.areEqual(str, str3)) {
                    String string = this.context.getString(R.string.today);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    headerItem = new AdapterItem.HeaderItem(string);
                } else {
                    Intrinsics.checkNotNull(str3);
                    headerItem = new AdapterItem.HeaderItem(str3);
                }
                arrayList.add(headerItem);
                str2 = str3;
            }
            arrayList.add(new AdapterItem.DataItem(captureHistoryModel));
        }
        submitList(arrayList);
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

    /* JADX INFO: compiled from: UploadedCaptureFilesAdapter.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0015J\b\u0010\u001c\u001a\u00020\u0011H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0016R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006 "}, d2 = {"Lcom/box/android/capture/adapter/UploadedCaptureFilesAdapter$CaptureHistoryViewHolder;", "Lcom/box/android/base/presentation/adapters/BoxItemBrowseViewHolder;", "view", "Landroid/view/View;", "thumbnailManager", "Lcom/box/android/base/presentation/ThumbnailManager;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "offlineManagerWrapper", "Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "onUpdateClick", "Lkotlin/Function1;", "Lcom/box/android/domain/models/item/ItemModel;", "", "<init>", "(Landroid/view/View;Lcom/box/android/base/presentation/ThumbnailManager;Lcom/box/android/domain/configuration/FeatureFlips;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;)V", "captureHistoryModel", "Lcom/box/android/domain/models/CaptureHistoryModel;", "getCaptureHistoryModel", "()Lcom/box/android/domain/models/CaptureHistoryModel;", "setCaptureHistoryModel", "(Lcom/box/android/domain/models/CaptureHistoryModel;)V", "bindItem", "item", "setDescription", "loadFromKnownThumbnailCache", "", "loadFileThumbnail", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static class CaptureHistoryViewHolder extends BoxItemBrowseViewHolder {
        public static final int $stable = 8;
        public CaptureHistoryModel captureHistoryModel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CaptureHistoryViewHolder(View view, ThumbnailManager thumbnailManager, FeatureFlips featureFlips, IUserContextManager userContextManager, BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper, CoroutineScope coroutineScope, Function1<? super ItemModel, Unit> function1) {
            super(view, thumbnailManager, featureFlips, userContextManager, boxModelOfflineManagerWrapper, coroutineScope, function1);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(thumbnailManager, "thumbnailManager");
            Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        }

        public /* synthetic */ CaptureHistoryViewHolder(View view, ThumbnailManager thumbnailManager, FeatureFlips featureFlips, IUserContextManager iUserContextManager, BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper, CoroutineScope coroutineScope, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(view, thumbnailManager, featureFlips, iUserContextManager, (i & 16) != 0 ? null : boxModelOfflineManagerWrapper, (i & 32) != 0 ? null : coroutineScope, (i & 64) != 0 ? null : function1);
        }

        public final CaptureHistoryModel getCaptureHistoryModel() {
            CaptureHistoryModel captureHistoryModel = this.captureHistoryModel;
            if (captureHistoryModel != null) {
                return captureHistoryModel;
            }
            Intrinsics.throwUninitializedPropertyAccessException("captureHistoryModel");
            return null;
        }

        public final void setCaptureHistoryModel(CaptureHistoryModel captureHistoryModel) {
            Intrinsics.checkNotNullParameter(captureHistoryModel, "<set-?>");
            this.captureHistoryModel = captureHistoryModel;
        }

        public final void bindItem(CaptureHistoryModel item) {
            Intrinsics.checkNotNullParameter(item, "item");
            super.bindItem(item.getFileModel());
            setCaptureHistoryModel(item);
            getCommonBinding().parentFolderIcon.setVisibility(0);
            ThumbnailManager thumbnailManager = getThumbnailManager();
            FolderModelMapper folderModelMapper = FolderModelMapper.INSTANCE;
            FolderModel parentFolder = getItemModel().getParentFolder();
            Intrinsics.checkNotNull(parentFolder);
            BoxFolder boxFolder$default = FolderModelMapper.toBoxFolder$default(folderModelMapper, parentFolder, false, 1, null);
            ImageView parentFolderIcon = getCommonBinding().parentFolderIcon;
            Intrinsics.checkNotNullExpressionValue(parentFolderIcon, "parentFolderIcon");
            thumbnailManager.loadThumbnail(boxFolder$default, parentFolderIcon);
            ItemModel itemModel = getItemModel();
            FileModel fileModel = itemModel instanceof FileModel ? (FileModel) itemModel : null;
            if (fileModel != null) {
                List<CollectionModel> collections = fileModel.getCollections();
                getCommonBinding().badgeCollection.setVisibility((collections == null || collections.isEmpty()) ? 8 : 0);
            }
        }

        @Override // com.box.android.base.presentation.adapters.BoxItemBrowseViewHolder
        public void setDescription() {
            String name;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            FolderModel parentFolder = getItemModel().getParentFolder();
            if (parentFolder == null || (name = parentFolder.getName()) == null) {
                name = "";
            }
            Context context = getView().getContext();
            Long size = getItemModel().getSize();
            String str = String.format(BoxItemBrowseViewHolder.DESCRIPTION_TEMPLATE, Arrays.copyOf(new Object[]{name, SdkUtils.getLocalizedFileSize(context, size != null ? size.longValue() : 0.0d)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            getCommonBinding().metalineDescription.setText(str);
        }

        private final boolean loadFromKnownThumbnailCache() {
            ThumbnailManager thumbnailManager = getThumbnailManager();
            ICaptureThumbnailService.Companion companion = ICaptureThumbnailService.INSTANCE;
            ItemModel itemModel = getItemModel();
            Intrinsics.checkNotNull(itemModel, "null cannot be cast to non-null type com.box.android.domain.models.item.FileModel");
            File thumbnailForBoxFile$default = ThumbnailManager.getThumbnailForBoxFile$default(thumbnailManager, companion.getBoxFileForCaptureThumbnail(((FileModel) itemModel).getSha1()), false, 2, null);
            if (thumbnailForBoxFile$default == null || thumbnailForBoxFile$default.length() <= 0) {
                return false;
            }
            ThumbnailManager thumbnailManager2 = getThumbnailManager();
            String path = thumbnailForBoxFile$default.getPath();
            ShapeableImageView boxBrowsesdkThumbImage = getCommonBinding().boxBrowsesdkThumbImage;
            Intrinsics.checkNotNullExpressionValue(boxBrowsesdkThumbImage, "boxBrowsesdkThumbImage");
            thumbnailManager2.loadKnownThumbnail(path, boxBrowsesdkThumbImage);
            return true;
        }

        @Override // com.box.android.base.presentation.adapters.BoxItemBrowseViewHolder
        public void loadFileThumbnail() {
            if (loadFromKnownThumbnailCache()) {
                return;
            }
            super.loadFileThumbnail();
        }
    }

    /* JADX INFO: compiled from: UploadedCaptureFilesAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/box/android/capture/adapter/UploadedCaptureFilesAdapter$CaptureHistoryDiffCallback;", "Lcom/box/android/base/presentation/adapters/listitem/AdapterItemDiffCallback;", "Lcom/box/android/domain/models/CaptureHistoryModel;", "<init>", "()V", "getId", "", "item", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class CaptureHistoryDiffCallback extends AdapterItemDiffCallback<CaptureHistoryModel> {
        public static final int $stable = AdapterItemDiffCallback.$stable;

        @Override // com.box.android.base.presentation.adapters.listitem.AdapterItemDiffCallback
        public String getId(CaptureHistoryModel item) {
            Intrinsics.checkNotNullParameter(item, "item");
            return item.getFileModel().getItemId().toString();
        }
    }
}
