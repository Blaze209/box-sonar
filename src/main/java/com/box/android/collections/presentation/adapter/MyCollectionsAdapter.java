package com.box.android.collections.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.box.android.base.presentation.utilities.ItemActionListener;
import com.box.android.collections.databinding.ListItemMyCollectionsBinding;
import com.box.android.domain.models.CollectionModel;
import com.box.androidsdk.content.models.BoxCollection;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MyCollectionsAdapter.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/box/android/collections/presentation/adapter/MyCollectionsAdapter;", "Landroidx/paging/PagedListAdapter;", "Lcom/box/android/domain/models/CollectionModel;", "Lcom/box/android/collections/presentation/adapter/MyCollectionsAdapter$MyCollectionsViewHolder;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/box/android/base/presentation/utilities/ItemActionListener;", "<init>", "(Lcom/box/android/base/presentation/utilities/ItemActionListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", ViewProps.POSITION, "Companion", "MyCollectionsViewHolder", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MyCollectionsAdapter extends PagedListAdapter<CollectionModel, MyCollectionsViewHolder> {
    private final ItemActionListener<CollectionModel> listener;
    public static final int $stable = 8;
    private static final MyCollectionsAdapter$Companion$diffCallback$1 diffCallback = new DiffUtil.ItemCallback<CollectionModel>() { // from class: com.box.android.collections.presentation.adapter.MyCollectionsAdapter$Companion$diffCallback$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(CollectionModel oldItem, CollectionModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getId(), newItem.getId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(CollectionModel oldItem, CollectionModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyCollectionsAdapter(ItemActionListener<CollectionModel> listener) {
        super(diffCallback);
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MyCollectionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ListItemMyCollectionsBinding listItemMyCollectionsBindingInflate = ListItemMyCollectionsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(listItemMyCollectionsBindingInflate, "inflate(...)");
        return new MyCollectionsViewHolder(listItemMyCollectionsBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MyCollectionsViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final CollectionModel item = getItem(position);
        holder.bindCollection(item);
        if (item != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.collections.presentation.adapter.MyCollectionsAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MyCollectionsAdapter.onBindViewHolder$lambda$0$0$0(this.f$0, item, view);
                }
            });
            holder.getViewBinding().myCollectionsMenu.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.collections.presentation.adapter.MyCollectionsAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MyCollectionsAdapter.onBindViewHolder$lambda$0$0$1(this.f$0, item, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$0$0(MyCollectionsAdapter myCollectionsAdapter, CollectionModel collectionModel, View view) {
        myCollectionsAdapter.listener.onPrimaryAction(collectionModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$0$1(MyCollectionsAdapter myCollectionsAdapter, CollectionModel collectionModel, View view) {
        myCollectionsAdapter.listener.onSecondaryAction(collectionModel);
    }

    /* JADX INFO: compiled from: MyCollectionsAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/collections/presentation/adapter/MyCollectionsAdapter$MyCollectionsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewBinding", "Lcom/box/android/collections/databinding/ListItemMyCollectionsBinding;", "<init>", "(Lcom/box/android/collections/databinding/ListItemMyCollectionsBinding;)V", "getViewBinding", "()Lcom/box/android/collections/databinding/ListItemMyCollectionsBinding;", BoxCollection.TYPE, "Lcom/box/android/domain/models/CollectionModel;", "bindCollection", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class MyCollectionsViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private CollectionModel collection;
        private final ListItemMyCollectionsBinding viewBinding;

        public final ListItemMyCollectionsBinding getViewBinding() {
            return this.viewBinding;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyCollectionsViewHolder(ListItemMyCollectionsBinding viewBinding) {
            super(viewBinding.getRoot());
            Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
            this.viewBinding = viewBinding;
        }

        public final void bindCollection(CollectionModel collection) {
            String name;
            this.collection = collection;
            TextView textView = this.viewBinding.myCollectionsTitle;
            if (collection == null || (name = collection.getName()) == null) {
                name = "";
            }
            textView.setText(name);
            this.viewBinding.myCollectionsMenu.setVisibility(8);
        }
    }
}
