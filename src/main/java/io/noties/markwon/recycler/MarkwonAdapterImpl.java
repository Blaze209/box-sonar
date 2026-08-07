package io.noties.markwon.recycler;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import io.noties.markwon.Markwon;
import io.noties.markwon.MarkwonReducer;
import java.util.Collections;
import java.util.List;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes4.dex */
class MarkwonAdapterImpl extends MarkwonAdapter {
    private final MarkwonAdapter.Entry<Node, MarkwonAdapter.Holder> defaultEntry;
    private final SparseArray<MarkwonAdapter.Entry<Node, MarkwonAdapter.Holder>> entries;
    private LayoutInflater layoutInflater;
    private Markwon markwon;
    private List<Node> nodes;
    private final MarkwonReducer reducer;

    MarkwonAdapterImpl(SparseArray<MarkwonAdapter.Entry<Node, MarkwonAdapter.Holder>> sparseArray, MarkwonAdapter.Entry<Node, MarkwonAdapter.Holder> entry, MarkwonReducer markwonReducer) {
        this.entries = sparseArray;
        this.defaultEntry = entry;
        this.reducer = markwonReducer;
        setHasStableIds(true);
    }

    @Override // io.noties.markwon.recycler.MarkwonAdapter
    public void setMarkdown(Markwon markwon, String str) {
        setParsedMarkdown(markwon, markwon.parse(str));
    }

    @Override // io.noties.markwon.recycler.MarkwonAdapter
    public void setParsedMarkdown(Markwon markwon, Node node) {
        setParsedMarkdown(markwon, this.reducer.reduce(node));
    }

    @Override // io.noties.markwon.recycler.MarkwonAdapter
    public void setParsedMarkdown(Markwon markwon, List<Node> list) {
        this.defaultEntry.clear();
        int size = this.entries.size();
        for (int i = 0; i < size; i++) {
            this.entries.valueAt(i).clear();
        }
        this.markwon = markwon;
        this.nodes = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MarkwonAdapter.Holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.layoutInflater == null) {
            this.layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        return getEntry(i).createHolder(this.layoutInflater, viewGroup);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MarkwonAdapter.Holder holder, int i) {
        Node node = this.nodes.get(i);
        getEntry(getNodeViewType(node.getClass())).bindHolder(this.markwon, holder, node);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<Node> list = this.nodes;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(MarkwonAdapter.Holder holder) {
        super.onViewRecycled(holder);
        getEntry(holder.getItemViewType()).onViewRecycled(holder);
    }

    public List<Node> getItems() {
        List<Node> list = this.nodes;
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return getNodeViewType(this.nodes.get(i).getClass());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        Node node = this.nodes.get(i);
        return getEntry(getNodeViewType(node.getClass())).id(node);
    }

    @Override // io.noties.markwon.recycler.MarkwonAdapter
    public int getNodeViewType(Class<? extends Node> cls) {
        int iHashCode = cls.hashCode();
        if (this.entries.indexOfKey(iHashCode) > -1) {
            return iHashCode;
        }
        return 0;
    }

    private MarkwonAdapter.Entry<Node, MarkwonAdapter.Holder> getEntry(int i) {
        if (i == 0) {
            return this.defaultEntry;
        }
        return this.entries.get(i);
    }

    static class BuilderImpl implements MarkwonAdapter.Builder {
        private final MarkwonAdapter.Entry<Node, MarkwonAdapter.Holder> defaultEntry;
        private final SparseArray<MarkwonAdapter.Entry<Node, MarkwonAdapter.Holder>> entries = new SparseArray<>(3);
        private MarkwonReducer reducer;

        BuilderImpl(MarkwonAdapter.Entry<Node, MarkwonAdapter.Holder> entry) {
            this.defaultEntry = entry;
        }

        @Override // io.noties.markwon.recycler.MarkwonAdapter.Builder
        public <N extends Node> MarkwonAdapter.Builder include(Class<N> cls, MarkwonAdapter.Entry<? super N, ? extends MarkwonAdapter.Holder> entry) {
            this.entries.append(cls.hashCode(), entry);
            return this;
        }

        @Override // io.noties.markwon.recycler.MarkwonAdapter.Builder
        public MarkwonAdapter.Builder reducer(MarkwonReducer markwonReducer) {
            this.reducer = markwonReducer;
            return this;
        }

        @Override // io.noties.markwon.recycler.MarkwonAdapter.Builder
        public MarkwonAdapter build() {
            if (this.reducer == null) {
                this.reducer = MarkwonReducer.directChildren();
            }
            return new MarkwonAdapterImpl(this.entries, this.defaultEntry, this.reducer);
        }
    }
}
