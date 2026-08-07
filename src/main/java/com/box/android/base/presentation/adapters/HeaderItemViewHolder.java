package com.box.android.base.presentation.adapters;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.box.android.base.databinding.ListItemHeaderBinding;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HeaderItemViewHolder.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/box/android/base/presentation/adapters/HeaderItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "binding", "Lcom/box/android/base/databinding/ListItemHeaderBinding;", "getBinding", "()Lcom/box/android/base/databinding/ListItemHeaderBinding;", "bindItem", "", BoxAnalyticsParams.CTA_LOCATION_HEADER, "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HeaderItemViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final ListItemHeaderBinding binding;
    private final View view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderItemViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        ListItemHeaderBinding listItemHeaderBindingBind = ListItemHeaderBinding.bind(view);
        Intrinsics.checkNotNullExpressionValue(listItemHeaderBindingBind, "bind(...)");
        this.binding = listItemHeaderBindingBind;
    }

    public final View getView() {
        return this.view;
    }

    public final ListItemHeaderBinding getBinding() {
        return this.binding;
    }

    public final void bindItem(String header) {
        Intrinsics.checkNotNullParameter(header, "header");
        this.binding.headerText.setText(header);
    }
}
