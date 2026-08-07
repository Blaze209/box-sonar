package com.geniusscansdk.readablecodeflow;

import android.R;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.geniusscansdk.structureddata.ReadableCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReadableCodeAdapter.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/geniusscansdk/readablecodeflow/ReadableCodeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "valueText", "Landroid/widget/TextView;", "typeText", "bind", "", "code", "Lcom/geniusscansdk/structureddata/ReadableCode;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReadableCodeViewHolder extends RecyclerView.ViewHolder {
    private final TextView typeText;
    private final TextView valueText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadableCodeViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(R.id.text1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.valueText = (TextView) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.text2);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.typeText = (TextView) viewFindViewById2;
    }

    public final void bind(ReadableCode code) {
        Intrinsics.checkNotNullParameter(code, "code");
        this.valueText.setText(code.getValue());
        this.typeText.setText(code.getType().getDisplayName());
    }
}
