package com.pspdfkit.internal;

import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.pspdfkit.R;
import com.pspdfkit.document.search.SearchResult;
import com.pspdfkit.ui.search.PdfSearchViewModular;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class l00 extends BaseAdapter {
    public final BackgroundColorSpan a;
    public final ForegroundColorSpan b;
    public final ArrayList c = new ArrayList();
    public final PdfSearchViewModular d;
    public final LayoutInflater e;
    public final int f;
    public final a g;
    public final boolean h;

    public static class a {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
    }

    public static class b {
        public final TextView a;
        public final TextView b;

        public b(TextView textView, TextView textView2, a aVar) {
            this.b = textView2;
            this.a = textView;
            if (textView2 != null) {
                textView2.setTextColor(aVar.c);
            }
            if (textView != null) {
                textView.setTextColor(aVar.b);
            }
        }
    }

    public l00(PdfSearchViewModular pdfSearchViewModular, a aVar, int i, boolean z) {
        this.d = pdfSearchViewModular;
        this.e = (LayoutInflater) pdfSearchViewModular.getContext().getSystemService("layout_inflater");
        this.a = new BackgroundColorSpan(aVar.d);
        this.b = new ForegroundColorSpan(aVar.e);
        this.g = aVar;
        this.f = i;
        this.h = z;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.c.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return (SearchResult) this.c.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return ((SearchResult) this.c.get(i)).hashCode();
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.e.inflate(this.f, viewGroup, false);
            view.setBackgroundColor(this.g.a);
            view.setTag(new b((TextView) view.findViewById(R.id.pspdf__search_item_page), (TextView) view.findViewById(R.id.pspdf__search_item_snippet), this.g));
        }
        b bVar = (b) view.getTag();
        SearchResult searchResult = (SearchResult) this.c.get(i);
        TextView textView = bVar.a;
        if (textView != null) {
            String pageLabel = this.h ? searchResult.document.getPageLabel(searchResult.pageIndex, false) : null;
            if (pageLabel == null) {
                pageLabel = no.a(this.d.getContext(), R.string.pspdf__page_with_number, textView, Integer.valueOf(searchResult.pageIndex + 1));
            }
            textView.setText(pageLabel);
        }
        TextView textView2 = bVar.b;
        if (textView2 != null) {
            SearchResult.TextSnippet textSnippet = searchResult.snippet;
            if (textSnippet != null) {
                SpannableString spannableString = new SpannableString(textSnippet.text);
                int startPosition = textSnippet.rangeInSnippet.getStartPosition();
                int endPosition = textSnippet.rangeInSnippet.getEndPosition();
                spannableString.setSpan(this.a, startPosition, endPosition, 18);
                spannableString.setSpan(this.b, startPosition, endPosition, 33);
                bVar.b.setText(spannableString);
                return view;
            }
            textView2.setText("");
        }
        return view;
    }
}
