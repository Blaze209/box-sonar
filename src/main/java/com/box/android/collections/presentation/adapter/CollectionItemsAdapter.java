package com.box.android.collections.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.base.presentation.adapters.BoxItemBrowseViewHolder;
import com.box.android.base.presentation.utilities.ItemActionListener;
import com.box.android.collections.R;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.utils.ExtensionsKt;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionItemsAdapter.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002#$B5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001cH\u0016J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/box/android/collections/presentation/adapter/CollectionItemsAdapter;", "Landroidx/paging/PagedListAdapter;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/collections/presentation/adapter/CollectionItemsAdapter$CollectionItemViewHolder;", "context", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/box/android/base/presentation/utilities/ItemActionListener;", "thumbnailManager", "Lcom/box/android/base/presentation/ThumbnailManager;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "<init>", "(Landroid/content/Context;Lcom/box/android/base/presentation/utilities/ItemActionListener;Lcom/box/android/base/presentation/ThumbnailManager;Lcom/box/android/domain/configuration/FeatureFlips;Lcom/box/android/domain/identity/IUserContextManager;)V", "getContext", "()Landroid/content/Context;", "getListener", "()Lcom/box/android/base/presentation/utilities/ItemActionListener;", "getThumbnailManager", "()Lcom/box/android/base/presentation/ThumbnailManager;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", ViewProps.POSITION, "updateItem", "item", "Companion", "CollectionItemViewHolder", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class CollectionItemsAdapter extends PagedListAdapter<ItemModel, CollectionItemViewHolder> {
    private final Context context;
    private final FeatureFlips featureFlips;
    private final ItemActionListener<ItemModel> listener;
    private final ThumbnailManager thumbnailManager;
    private final IUserContextManager userContextManager;
    public static final int $stable = 8;
    private static final CollectionItemsAdapter$Companion$diffCallback$1 diffCallback = new DiffUtil.ItemCallback<ItemModel>() { // from class: com.box.android.collections.presentation.adapter.CollectionItemsAdapter$Companion$diffCallback$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(ItemModel oldItem, ItemModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getItemId(), newItem.getItemId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(ItemModel oldItem, ItemModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    public final Context getContext() {
        return this.context;
    }

    public final ItemActionListener<ItemModel> getListener() {
        return this.listener;
    }

    public final ThumbnailManager getThumbnailManager() {
        return this.thumbnailManager;
    }

    public final IUserContextManager getUserContextManager() {
        return this.userContextManager;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionItemsAdapter(Context context, ItemActionListener<ItemModel> listener, ThumbnailManager thumbnailManager, FeatureFlips featureFlips, IUserContextManager userContextManager) {
        super(diffCallback);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(thumbnailManager, "thumbnailManager");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        this.context = context;
        this.listener = listener;
        this.thumbnailManager = thumbnailManager;
        this.featureFlips = featureFlips;
        this.userContextManager = userContextManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CollectionItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.browse_list_item_legacy, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return new CollectionItemViewHolder(viewInflate, this.thumbnailManager, this.featureFlips, this.userContextManager);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CollectionItemViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ItemModel item = getItem(position);
        Intrinsics.checkNotNull(item);
        final ItemModel itemModel = item;
        holder.bindItem(itemModel);
        holder.getCommonBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.box.android.collections.presentation.adapter.CollectionItemsAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionItemsAdapter.onBindViewHolder$lambda$0$0(this.f$0, itemModel, view);
            }
        });
        holder.getSecondaryActionView().setVisibility(0);
        holder.getSecondaryActionView().setOnClickListener(new View.OnClickListener() { // from class: com.box.android.collections.presentation.adapter.CollectionItemsAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionItemsAdapter.onBindViewHolder$lambda$0$1(this.f$0, itemModel, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$0(CollectionItemsAdapter collectionItemsAdapter, ItemModel itemModel, View view) {
        collectionItemsAdapter.listener.onPrimaryAction(itemModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$1(CollectionItemsAdapter collectionItemsAdapter, ItemModel itemModel, View view) {
        collectionItemsAdapter.listener.onSecondaryAction(itemModel);
    }

    public final void updateItem(ItemModel item) {
        Integer numValueOf;
        Intrinsics.checkNotNullParameter(item, "item");
        PagedList<ItemModel> currentList = getCurrentList();
        if (currentList != null) {
            Iterator<ItemModel> it = currentList.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (Intrinsics.areEqual(it.next().getItemId(), item.getItemId())) {
                    break;
                } else {
                    i++;
                }
            }
            numValueOf = Integer.valueOf(i);
        } else {
            numValueOf = null;
        }
        if (numValueOf == null || numValueOf.intValue() == -1) {
            return;
        }
        ExtensionsKt.getTAG(this);
        notifyItemChanged(numValueOf.intValue(), item);
    }

    /* JADX INFO: compiled from: CollectionItemsAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/box/android/collections/presentation/adapter/CollectionItemsAdapter$CollectionItemViewHolder;", "Lcom/box/android/base/presentation/adapters/BoxItemBrowseViewHolder;", "view", "Landroid/view/View;", "thumbnailManager", "Lcom/box/android/base/presentation/ThumbnailManager;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "<init>", "(Landroid/view/View;Lcom/box/android/base/presentation/ThumbnailManager;Lcom/box/android/domain/configuration/FeatureFlips;Lcom/box/android/domain/identity/IUserContextManager;)V", "bindItem", "", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static class CollectionItemViewHolder extends BoxItemBrowseViewHolder {
        public static final int $stable = BoxItemBrowseViewHolder.$stable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CollectionItemViewHolder(View view, ThumbnailManager thumbnailManager, FeatureFlips featureFlips, IUserContextManager userContextManager) {
            super(view, thumbnailManager, featureFlips, userContextManager, null, null, null, 112, null);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(thumbnailManager, "thumbnailManager");
            Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        }

        @Override // com.box.android.base.presentation.adapters.BoxItemBrowseViewHolder
        public void bindItem(ItemModel itemModel) {
            Intrinsics.checkNotNullParameter(itemModel, "itemModel");
            super.bindItem(itemModel);
            getCommonBinding().icCollectionsLink.setVisibility(0);
        }
    }
}
