package com.box.android.boxai.markdown;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.box.android.boxai.R;
import com.box.android.common.extensions.ViewGroupExtensionsKt;
import com.box.android.observability.DiagnosisParams;
import io.noties.markwon.Markwon;
import io.noties.markwon.recycler.MarkwonAdapter;
import io.noties.markwon.recycler.table.TableEntry;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.commonmark.ext.gfm.tables.TableBlock;

/* JADX INFO: compiled from: MarkwonTableEntry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/box/android/boxai/markdown/MarkwonTableEntry;", "Lio/noties/markwon/recycler/MarkwonAdapter$Entry;", "Lorg/commonmark/ext/gfm/tables/TableBlock;", "Lio/noties/markwon/recycler/table/TableEntry$Holder;", "style", "Lcom/box/android/boxai/markdown/MarkdownStyle;", "<init>", "(Lcom/box/android/boxai/markdown/MarkdownStyle;)V", "delegate", "Lio/noties/markwon/recycler/table/TableEntry;", "createHolder", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "bindHolder", "", "markwon", "Lio/noties/markwon/Markwon;", "holder", "node", DiagnosisParams.CLEAR_ON_LOGOUT, "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MarkwonTableEntry extends MarkwonAdapter.Entry<TableBlock, TableEntry.Holder> {
    public static final int $stable = 8;
    private final TableEntry delegate;
    private final MarkdownStyle style;

    public MarkwonTableEntry(MarkdownStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.style = style;
        TableEntry tableEntryCreate = TableEntry.create(new TableEntry.BuilderConfigure() { // from class: com.box.android.boxai.markdown.MarkwonTableEntry$$ExternalSyntheticLambda0
            @Override // io.noties.markwon.recycler.table.TableEntry.BuilderConfigure
            public final void configure(TableEntry.Builder builder) {
                MarkwonTableEntry.delegate$lambda$0(builder);
            }
        });
        Intrinsics.checkNotNullExpressionValue(tableEntryCreate, "create(...)");
        this.delegate = tableEntryCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void delegate$lambda$0(TableEntry.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.tableLayout(R.layout.markwon_entry_table, R.id.table_layout);
        builder.textLayoutIsRoot(R.layout.markwon_entry_text);
    }

    @Override // io.noties.markwon.recycler.MarkwonAdapter.Entry
    public TableEntry.Holder createHolder(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(parent, "parent");
        TableEntry.Holder holderCreateHolder = this.delegate.createHolder(inflater, parent);
        Intrinsics.checkNotNullExpressionValue(holderCreateHolder, "createHolder(...)");
        return holderCreateHolder;
    }

    @Override // io.noties.markwon.recycler.MarkwonAdapter.Entry
    public void bindHolder(Markwon markwon, TableEntry.Holder holder, TableBlock node) {
        Intrinsics.checkNotNullParameter(markwon, "markwon");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(node, "node");
        this.delegate.bindHolder(markwon, holder, node);
        View view = holder.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        Sequence sequenceFilter = SequencesKt.filter(ViewGroupExtensionsKt.recursiveChildren((ViewGroup) view), new Function1<Object, Boolean>() { // from class: com.box.android.boxai.markdown.MarkwonTableEntry$bindHolder$$inlined$filterIsInstance$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                return Boolean.valueOf(obj instanceof TextView);
            }
        });
        Intrinsics.checkNotNull(sequenceFilter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        Iterator it = sequenceFilter.iterator();
        while (it.hasNext()) {
            MarkdownStyleKt.applyTo(this.style.getTextStyle(), (TextView) it.next());
        }
    }

    @Override // io.noties.markwon.recycler.MarkwonAdapter.Entry
    public void clear() {
        this.delegate.clear();
    }
}
