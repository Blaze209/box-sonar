package io.noties.markwon.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import io.noties.markwon.Markwon;
import io.noties.markwon.MarkwonReducer;
import java.util.List;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MarkwonAdapter extends RecyclerView.Adapter<Holder> {

    public interface Builder {
        MarkwonAdapter build();

        <N extends Node> Builder include(Class<N> cls, Entry<? super N, ? extends Holder> entry);

        Builder reducer(MarkwonReducer markwonReducer);
    }

    public abstract int getNodeViewType(Class<? extends Node> cls);

    public abstract void setMarkdown(Markwon markwon, String str);

    public abstract void setParsedMarkdown(Markwon markwon, List<Node> list);

    public abstract void setParsedMarkdown(Markwon markwon, Node node);

    public static Builder builderTextViewIsRoot(int i) {
        return builder(SimpleEntry.createTextViewIsRoot(i));
    }

    public static Builder builder(int i, int i2) {
        return builder(SimpleEntry.create(i, i2));
    }

    public static Builder builder(Entry<? extends Node, ? extends Holder> entry) {
        return new MarkwonAdapterImpl.BuilderImpl(entry);
    }

    public static MarkwonAdapter createTextViewIsRoot(int i) {
        return builderTextViewIsRoot(i).build();
    }

    public static MarkwonAdapter create(int i, int i2) {
        return builder(i, i2).build();
    }

    public static MarkwonAdapter create(Entry<? extends Node, ? extends Holder> entry) {
        return builder(entry).build();
    }

    public static abstract class Entry<N extends Node, H extends Holder> {
        public abstract void bindHolder(Markwon markwon, H h, N n);

        public void clear() {
        }

        public abstract H createHolder(LayoutInflater layoutInflater, ViewGroup viewGroup);

        public void onViewRecycled(H h) {
        }

        public long id(N n) {
            return n.hashCode();
        }
    }

    public static class Holder extends RecyclerView.ViewHolder {
        public Holder(View view) {
            super(view);
        }

        protected <V extends View> V findView(int i) {
            return (V) this.itemView.findViewById(i);
        }

        protected <V extends View> V requireView(int i) {
            String strValueOf;
            V v = (V) this.itemView.findViewById(i);
            if (v != null) {
                return v;
            }
            if (i == 0 || i == -1) {
                strValueOf = String.valueOf(i);
            } else {
                strValueOf = "R.id." + this.itemView.getResources().getResourceName(i);
            }
            throw new NullPointerException(String.format("No view with id(R.id.%s) is found in layout: %s", strValueOf, this.itemView));
        }
    }
}
