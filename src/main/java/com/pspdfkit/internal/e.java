package com.pspdfkit.internal;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.pspdfkit.R;
import com.pspdfkit.ui.actionmenu.ActionMenuItem;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends RecyclerView.Adapter<a> {
    public final g a;
    public final ArrayList b = new ArrayList();
    public final int c;
    public final int d;

    public class a extends RecyclerView.ViewHolder {
        public final ij a;

        public a(ij ijVar) {
            super(ijVar);
            this.a = ijVar;
            ijVar.setLabelTextColor(e.this.d);
            if (e.this.c != 0) {
                ijVar.setIconBackground(a80.a(ijVar.getContext(), R.drawable.pspdf__circle_shape, e.this.c));
                ijVar.setIconPadding(a80.a(ijVar.getContext(), 6));
            }
            ijVar.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.e$a$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.a(view);
                }
            });
            ijVar.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.pspdfkit.internal.e$a$$ExternalSyntheticLambda1
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return this.f$0.b(view);
                }
            });
        }

        public final void a(View view) {
            int adapterPosition;
            f.a aVar;
            if (e.this.a == null || (adapterPosition = getAdapterPosition()) < 0 || adapterPosition >= e.this.b.size()) {
                return;
            }
            e eVar = e.this;
            g gVar = eVar.a;
            ActionMenuItem actionMenuItem = (ActionMenuItem) eVar.b.get(adapterPosition);
            f fVar = gVar.a.a;
            fVar.getClass();
            if (!actionMenuItem.isEnabled() || (aVar = fVar.d) == null) {
                return;
            }
            aVar.onClickOnMenuItem(fVar, actionMenuItem);
        }

        public final boolean b(View view) {
            int adapterPosition;
            f.a aVar;
            if (e.this.a != null && (adapterPosition = getAdapterPosition()) >= 0 && adapterPosition < e.this.b.size()) {
                e eVar = e.this;
                g gVar = eVar.a;
                ActionMenuItem actionMenuItem = (ActionMenuItem) eVar.b.get(adapterPosition);
                f fVar = gVar.a.a;
                fVar.getClass();
                if (actionMenuItem.isEnabled() && (aVar = fVar.d) != null && aVar.onLongClickOnMenuItem(fVar, actionMenuItem)) {
                    return true;
                }
            }
            return false;
        }
    }

    public e(g gVar, int i, int i2) {
        this.a = gVar;
        this.c = i;
        this.d = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        a aVar = (a) viewHolder;
        ActionMenuItem actionMenuItem = (ActionMenuItem) this.b.get(i);
        aVar.a.setLabel(actionMenuItem.getLabel());
        aVar.a.setIcon(actionMenuItem.getIcon());
        aVar.a.setEnabled(actionMenuItem.isEnabled());
        actionMenuItem.isPrintItem();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(new ij(viewGroup.getContext()));
    }
}
