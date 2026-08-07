package com.box.android.boxai.markdown;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.box.android.boxai.R;
import io.noties.markwon.recycler.SimpleEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MarkwonTextEntry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/boxai/markdown/MarkwonTextEntry;", "Lio/noties/markwon/recycler/SimpleEntry;", "style", "Lcom/box/android/boxai/markdown/MarkdownStyle;", "<init>", "(Lcom/box/android/boxai/markdown/MarkdownStyle;)V", "createHolder", "Lio/noties/markwon/recycler/SimpleEntry$Holder;", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MarkwonTextEntry extends SimpleEntry {
    public static final int $stable = 8;
    private final MarkdownStyle style;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarkwonTextEntry(MarkdownStyle style) {
        super(R.layout.markwon_entry_text, 0);
        Intrinsics.checkNotNullParameter(style, "style");
        this.style = style;
    }

    @Override // io.noties.markwon.recycler.SimpleEntry, io.noties.markwon.recycler.MarkwonAdapter.Entry
    public SimpleEntry.Holder createHolder(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(parent, "parent");
        SimpleEntry.Holder holderCreateHolder = super.createHolder(inflater, parent);
        Intrinsics.checkNotNullExpressionValue(holderCreateHolder, "createHolder(...)");
        View view = holderCreateHolder.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.TextView");
        MarkdownStyleKt.applyTo(this.style.getTextStyle(), (TextView) view);
        return holderCreateHolder;
    }
}
