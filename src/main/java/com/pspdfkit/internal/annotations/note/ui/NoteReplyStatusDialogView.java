package com.pspdfkit.internal.annotations.note.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pspdfkit.R;
import com.pspdfkit.internal.fs;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0003\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/pspdfkit/internal/annotations/note/ui/NoteReplyStatusDialogView;", "Landroid/widget/ListView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "", "Lcom/pspdfkit/internal/fs$b;", "states", "", "setItems", "(Ljava/util/List;)V", "Lcom/pspdfkit/internal/annotations/note/ui/NoteReplyStatusDialogView$b;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnReviewStateSelectedListener", "(Lcom/pspdfkit/internal/annotations/note/ui/NoteReplyStatusDialogView$b;)V", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NoteReplyStatusDialogView extends ListView {
    public final ArrayList a;
    public b b;
    public final a c;

    public final class a extends ArrayAdapter<fs.b> {
        public final /* synthetic */ NoteReplyStatusDialogView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NoteReplyStatusDialogView noteReplyStatusDialogView, Context context) {
            super(context, 0);
            context.getClass();
            this.a = noteReplyStatusDialogView;
        }

        public static final void a(NoteReplyStatusDialogView noteReplyStatusDialogView, fs.b bVar, View view) {
            b bVar2 = noteReplyStatusDialogView.b;
            if (bVar2 != null) {
                bVar2.a(bVar);
            }
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public final int getCount() {
            return this.a.a.size();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public final Object getItem(int i) {
            return (fs.b) this.a.a.get(i);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public final View getView(int i, View view, ViewGroup viewGroup) {
            viewGroup.getClass();
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.pspdf__note_editor_set_status_dialog_layout_item, viewGroup, false);
            }
            final fs.b bVar = (fs.b) this.a.a.get(i);
            View viewFindViewById = view.findViewById(R.id.pspdf__status_title);
            viewFindViewById.getClass();
            TextView textView = (TextView) viewFindViewById;
            textView.setText(getContext().getString(bVar.b));
            textView.setCompoundDrawablesWithIntrinsicBounds(bVar.a, 0, 0, 0);
            View viewFindViewById2 = view.findViewById(R.id.pspdf__status_layout);
            viewFindViewById2.getClass();
            final NoteReplyStatusDialogView noteReplyStatusDialogView = this.a;
            ((LinearLayout) viewFindViewById2).setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.annotations.note.ui.NoteReplyStatusDialogView$a$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    NoteReplyStatusDialogView.a.a(noteReplyStatusDialogView, bVar, view2);
                }
            });
            return view;
        }
    }

    public interface b {
        void a(fs.b bVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NoteReplyStatusDialogView(Context context) {
        this(context, null, 0, 0, 14, null);
        context.getClass();
    }

    public final void setItems(List<? extends fs.b> states) {
        states.getClass();
        ArrayList arrayList = this.a;
        arrayList.clear();
        arrayList.addAll(states);
        this.c.notifyDataSetChanged();
    }

    public final void setOnReviewStateSelectedListener(b listener) {
        this.b = listener;
        this.c.notifyDataSetChanged();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NoteReplyStatusDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        context.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NoteReplyStatusDialogView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        context.getClass();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoteReplyStatusDialogView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        context.getClass();
        this.a = new ArrayList();
        a aVar = new a(this, context);
        this.c = aVar;
        setAdapter((ListAdapter) aVar);
    }

    public /* synthetic */ NoteReplyStatusDialogView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }
}
