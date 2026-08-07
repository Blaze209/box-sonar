package com.geniusscansdk.readablecodeflow;

import android.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import com.facebook.react.uimanager.ViewProps;
import com.geniusscansdk.structureddata.ReadableCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReadableCodeAdapter.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"Lcom/geniusscansdk/readablecodeflow/ReadableCodeAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/geniusscansdk/structureddata/ReadableCode;", "Lcom/geniusscansdk/readablecodeflow/ReadableCodeViewHolder;", "<init>", "()V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", ViewProps.POSITION, "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReadableCodeAdapter extends ListAdapter<ReadableCode, ReadableCodeViewHolder> {
    public ReadableCodeAdapter() {
        super(new ReadableCodeDiffCallback());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ReadableCodeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_list_item_2, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new ReadableCodeViewHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ReadableCodeViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ReadableCode item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind(item);
    }
}
