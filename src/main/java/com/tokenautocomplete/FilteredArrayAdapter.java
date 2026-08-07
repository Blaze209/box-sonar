package com.tokenautocomplete;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FilteredArrayAdapter<T> extends ArrayAdapter<T> {
    private Filter filter;
    private List<T> originalObjects;

    protected abstract boolean keepObject(T t, String str);

    public FilteredArrayAdapter(Context context, int i, T[] tArr) {
        this(context, i, 0, tArr);
    }

    public FilteredArrayAdapter(Context context, int i, int i2, T[] tArr) {
        this(context, i, i2, new ArrayList(Arrays.asList(tArr)));
    }

    public FilteredArrayAdapter(Context context, int i, List<T> list) {
        this(context, i, 0, list);
    }

    public FilteredArrayAdapter(Context context, int i, int i2, List<T> list) {
        super(context, i, i2, new ArrayList(list));
        this.originalObjects = list;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Filterable
    public Filter getFilter() {
        if (this.filter == null) {
            this.filter = new AppFilter();
        }
        return this.filter;
    }

    private class AppFilter extends Filter {
        private AppFilter() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.widget.Filter
        protected Filter.FilterResults performFiltering(CharSequence charSequence) {
            ArrayList arrayList = new ArrayList(FilteredArrayAdapter.this.originalObjects);
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence != null && charSequence.length() > 0) {
                String string = charSequence.toString();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : arrayList) {
                    if (FilteredArrayAdapter.this.keepObject(obj, string)) {
                        arrayList2.add(obj);
                    }
                }
                filterResults.count = arrayList2.size();
                filterResults.values = arrayList2;
                return filterResults;
            }
            filterResults.values = arrayList;
            filterResults.count = arrayList.size();
            return filterResults;
        }

        @Override // android.widget.Filter
        protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            FilteredArrayAdapter.this.clear();
            if (filterResults.count > 0) {
                FilteredArrayAdapter.this.addAll((Collection) filterResults.values);
                FilteredArrayAdapter.this.notifyDataSetChanged();
            } else {
                FilteredArrayAdapter.this.notifyDataSetInvalidated();
            }
        }
    }
}
