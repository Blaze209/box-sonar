package com.box.android.collections.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.box.android.collections.databinding.ListItemMultiSelectDialogBinding;
import com.box.android.collections.presentation.viewmodel.CollectionMembershipModel;
import com.box.android.domain.models.CollectionModel;
import com.box.androidsdk.content.models.BoxCollection;
import com.facebook.react.uimanager.ViewProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionMembershipsAdapter.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0018\u0019B-\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0014H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/box/android/collections/presentation/adapter/CollectionMembershipsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/box/android/collections/presentation/viewmodel/CollectionMembershipModel;", "Lcom/box/android/collections/presentation/adapter/CollectionMembershipsAdapter$CollectionMembershipsViewHolder;", "models", "", "onCheckChange", "Lkotlin/Function1;", "", "Lcom/box/android/collections/presentation/adapter/CheckCallBack;", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getModels", "()Ljava/util/List;", "getOnCheckChange", "()Lkotlin/jvm/functions/Function1;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", ViewProps.POSITION, "Companion", "CollectionMembershipsViewHolder", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionMembershipsAdapter extends ListAdapter<CollectionMembershipModel, CollectionMembershipsViewHolder> {
    private final List<CollectionMembershipModel> models;
    private final Function1<CollectionMembershipModel, Unit> onCheckChange;
    public static final int $stable = 8;
    private static final CollectionMembershipsAdapter$Companion$diffCallback$1 diffCallback = new DiffUtil.ItemCallback<CollectionMembershipModel>() { // from class: com.box.android.collections.presentation.adapter.CollectionMembershipsAdapter$Companion$diffCallback$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(CollectionMembershipModel oldItem, CollectionMembershipModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getCollectionModel().getId(), newItem.getCollectionModel().getId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(CollectionMembershipModel oldItem, CollectionMembershipModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.isChecked() == newItem.isChecked() && Intrinsics.areEqual(oldItem, newItem);
        }
    };

    public final List<CollectionMembershipModel> getModels() {
        return this.models;
    }

    public final Function1<CollectionMembershipModel, Unit> getOnCheckChange() {
        return this.onCheckChange;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CollectionMembershipsAdapter(List<CollectionMembershipModel> models, Function1<? super CollectionMembershipModel, Unit> onCheckChange) {
        super(diffCallback);
        Intrinsics.checkNotNullParameter(models, "models");
        Intrinsics.checkNotNullParameter(onCheckChange, "onCheckChange");
        this.models = models;
        this.onCheckChange = onCheckChange;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CollectionMembershipsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ListItemMultiSelectDialogBinding listItemMultiSelectDialogBindingInflate = ListItemMultiSelectDialogBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(listItemMultiSelectDialogBindingInflate, "inflate(...)");
        return new CollectionMembershipsViewHolder(listItemMultiSelectDialogBindingInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CollectionMembershipsViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final CollectionMembershipModel item = getItem(position);
        holder.bindCollection(item);
        if (item != null) {
            holder.getViewBinding().multiSelectCheckbox.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.collections.presentation.adapter.CollectionMembershipsAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CollectionMembershipsAdapter.onBindViewHolder$lambda$0$0$0(this.f$0, item, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$0$0(CollectionMembershipsAdapter collectionMembershipsAdapter, CollectionMembershipModel collectionMembershipModel, View view) {
        collectionMembershipsAdapter.onCheckChange.invoke(collectionMembershipModel);
    }

    /* JADX INFO: compiled from: CollectionMembershipsAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/box/android/collections/presentation/adapter/CollectionMembershipsAdapter$CollectionMembershipsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewBinding", "Lcom/box/android/collections/databinding/ListItemMultiSelectDialogBinding;", "<init>", "(Lcom/box/android/collections/databinding/ListItemMultiSelectDialogBinding;)V", "getViewBinding", "()Lcom/box/android/collections/databinding/ListItemMultiSelectDialogBinding;", BoxCollection.TYPE, "Lcom/box/android/domain/models/CollectionModel;", "bindCollection", "", "Lcom/box/android/collections/presentation/viewmodel/CollectionMembershipModel;", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class CollectionMembershipsViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private CollectionModel collection;
        private final ListItemMultiSelectDialogBinding viewBinding;

        public final ListItemMultiSelectDialogBinding getViewBinding() {
            return this.viewBinding;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CollectionMembershipsViewHolder(ListItemMultiSelectDialogBinding viewBinding) {
            super(viewBinding.getRoot());
            Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
            this.viewBinding = viewBinding;
        }

        public final void bindCollection(CollectionMembershipModel collection) {
            String name;
            CollectionModel collectionModel;
            this.collection = collection != null ? collection.getCollectionModel() : null;
            AppCompatCheckBox appCompatCheckBox = this.viewBinding.multiSelectCheckbox;
            if (collection == null || (collectionModel = collection.getCollectionModel()) == null || (name = collectionModel.getName()) == null) {
                name = "";
            }
            appCompatCheckBox.setText(name);
            appCompatCheckBox.setChecked(collection != null ? collection.isChecked() : false);
        }
    }
}
