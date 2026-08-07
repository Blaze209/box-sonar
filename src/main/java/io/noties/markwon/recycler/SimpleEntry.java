package io.noties.markwon.recycler;

import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import io.noties.markwon.Markwon;
import io.noties.markwon.utils.NoCopySpannableFactory;
import java.util.HashMap;
import java.util.Map;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes4.dex */
public class SimpleEntry extends MarkwonAdapter.Entry<Node, Holder> {
    private final Map<Node, Spanned> cache = new HashMap();
    private final int layoutResId;
    private final int textViewIdRes;

    public static SimpleEntry createTextViewIsRoot(int i) {
        return new SimpleEntry(i, 0);
    }

    public static SimpleEntry create(int i, int i2) {
        return new SimpleEntry(i, i2);
    }

    public SimpleEntry(int i, int i2) {
        this.layoutResId = i;
        this.textViewIdRes = i2;
    }

    @Override // io.noties.markwon.recycler.MarkwonAdapter.Entry
    public Holder createHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new Holder(this.textViewIdRes, layoutInflater.inflate(this.layoutResId, viewGroup, false));
    }

    @Override // io.noties.markwon.recycler.MarkwonAdapter.Entry
    public void bindHolder(Markwon markwon, Holder holder, Node node) {
        Spanned spannedRender = this.cache.get(node);
        if (spannedRender == null) {
            spannedRender = markwon.render(node);
            this.cache.put(node, spannedRender);
        }
        markwon.setParsedMarkdown(holder.textView, spannedRender);
    }

    @Override // io.noties.markwon.recycler.MarkwonAdapter.Entry
    public void clear() {
        this.cache.clear();
    }

    public static class Holder extends MarkwonAdapter.Holder {
        final TextView textView;

        protected Holder(int i, View view) {
            TextView textView;
            super(view);
            if (i == 0) {
                if (!(view instanceof TextView)) {
                    throw new IllegalStateException("TextView is not root of layout (specify TextView ID explicitly): " + view);
                }
                textView = (TextView) view;
            } else {
                textView = (TextView) requireView(i);
            }
            this.textView = textView;
            textView.setSpannableFactory(NoCopySpannableFactory.getInstance());
        }
    }
}
