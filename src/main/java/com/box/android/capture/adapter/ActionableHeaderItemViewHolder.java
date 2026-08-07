package com.box.android.capture.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.box.android.base.presentation.adapters.listitem.AdapterItem;
import com.box.android.capture.databinding.ActionableHeaderItemBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActionableHeaderItemViewHolder.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/box/android/capture/adapter/ActionableHeaderItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "bindItem", "", "actionableHeaderItem", "Lcom/box/android/base/presentation/adapters/listitem/AdapterItem$ActionableHeaderItem;", "onAction", "Lkotlin/Function0;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ActionableHeaderItemViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final View view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionableHeaderItemViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    public final View getView() {
        return this.view;
    }

    public final void bindItem(AdapterItem.ActionableHeaderItem actionableHeaderItem, final Function0<Unit> onAction) {
        Intrinsics.checkNotNullParameter(actionableHeaderItem, "actionableHeaderItem");
        Intrinsics.checkNotNullParameter(onAction, "onAction");
        ActionableHeaderItemBinding actionableHeaderItemBindingBind = ActionableHeaderItemBinding.bind(this.view);
        Intrinsics.checkNotNullExpressionValue(actionableHeaderItemBindingBind, "bind(...)");
        actionableHeaderItemBindingBind.title.setText(actionableHeaderItem.getTitle());
        actionableHeaderItemBindingBind.action.setText(actionableHeaderItem.getAction());
        actionableHeaderItemBindingBind.action.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.adapter.ActionableHeaderItemViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onAction.invoke();
            }
        });
    }
}
