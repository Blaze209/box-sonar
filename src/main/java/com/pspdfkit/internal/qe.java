package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;
import com.pspdfkit.datastructures.Range;
import com.pspdfkit.document.processor.PdfProcessorTask;
import com.pspdfkit.document.sharing.SharingOptions;
import com.pspdfkit.ui.dialog.DocumentSharingDialogConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class qe extends FrameLayout {
    public static final int[] q = R.styleable.pspdf__SharingDialog;
    public static final int r = R.attr.pspdf__sharingDialogStyle;
    public static final int s = R.style.PSPDFKit_SharingDialog;
    public final DocumentSharingDialogConfiguration a;
    public final List<a> b;
    public final int c;
    public final int d;
    public b e;
    public View f;
    public EditText g;
    public Spinner h;
    public ArrayAdapter<c> i;
    public EditText j;
    public c k;
    public Spinner l;
    public ArrayAdapter<a> m;
    public TextView n;
    public int o;
    public int p;

    public static class a {
        public final PdfProcessorTask.AnnotationProcessingMode a;
        public final int b;
        public final int c;
        public Context d;

        public a(PdfProcessorTask.AnnotationProcessingMode annotationProcessingMode, int i, int i2) {
            this.a = annotationProcessingMode;
            this.b = i;
            this.c = i2;
        }

        public final String toString() {
            Context context = this.d;
            return context != null ? no.a(context, this.b, null) : "";
        }
    }

    public interface b {
        void a(qe qeVar);
    }

    public class c {
        public final int a;
        public final int b;
        public final int c;
        public List<Range> d;

        public c(int i, int i2, int i3, Range range) {
            this.a = i;
            this.c = i3;
            this.b = i2;
            ArrayList arrayList = new ArrayList();
            this.d = arrayList;
            arrayList.add(range);
        }

        public final String toString() {
            Context context = qe.this.getContext();
            int iA = y30.a(this.a);
            if (iA == 0) {
                return no.a(context, R.string.pspdf__current_page, (View) null, Integer.valueOf(this.b + 1));
            }
            if (iA == 1) {
                return no.a(context, R.string.pspdf__page_range, null);
            }
            if (iA != 2) {
                return super.toString();
            }
            int i = this.c;
            return no.a(context, R.plurals.pspdf__pages_number, i, Integer.valueOf(i));
        }
    }

    public qe(Context context, DocumentSharingDialogConfiguration documentSharingDialogConfiguration, ArrayList arrayList) {
        super(new ContextThemeWrapper(context, f60.b(context, r, s)));
        this.a = documentSharingDialogConfiguration;
        this.c = documentSharingDialogConfiguration.getCurrentPage();
        this.d = documentSharingDialogConfiguration.getDocumentPages();
        this.b = arrayList;
        a();
    }

    private PdfProcessorTask.AnnotationProcessingMode getAnnotationProcessingMode() {
        return this.m.getItem(this.l.getSelectedItemPosition()).a;
    }

    private List<a> getAnnotationSpinnerItems() {
        ArrayList arrayList = new ArrayList();
        List<a> list = this.b;
        if (list == null || list.isEmpty()) {
            arrayList.add(new a(PdfProcessorTask.AnnotationProcessingMode.KEEP, R.string.pspdf__annotation_editing_embed, R.string.pspdf__annotation_editing_embed_description));
            arrayList.add(new a(PdfProcessorTask.AnnotationProcessingMode.FLATTEN, R.string.pspdf__annotation_editing_flatten, R.string.pspdf__annotation_editing_flatten_description));
            arrayList.add(new a(PdfProcessorTask.AnnotationProcessingMode.DELETE, R.string.pspdf__annotation_editing_ignore, R.string.pspdf__annotation_editing_ignore_description));
        } else {
            Iterator<a> it = this.b.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((a) obj).d = getContext();
        }
        return arrayList;
    }

    public final void a() {
        this.f = LayoutInflater.from(getContext()).inflate(R.layout.pspdf__share_dialog, (ViewGroup) this, true);
        yq yqVar = new yq(getContext());
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(null, q, r, s);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SharingDialog_pspdf__backgroundColor, f60.a(getContext(), android.R.attr.colorBackground, R.color.pspdf__onPrimaryLight));
        this.p = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__SharingDialog_pspdf__errorColor, ContextCompat.getColor(getContext(), R.color.pspdf__errorContainerLight));
        typedArrayObtainStyledAttributes.recycle();
        this.o = f60.a(getContext(), androidx.appcompat.R.attr.colorAccent, R.color.pspdf__primaryLight);
        wc wcVar = new wc(getContext(), yqVar);
        wcVar.setTitle(this.a.getDialogTitle());
        int i = 0;
        ((ViewGroup) this.f.findViewById(R.id.pspdf__dialog_root)).addView(wcVar, 0);
        yq.setRoundedBackground(this.f, wcVar, color, yqVar.getCornerRadius(), false);
        EditText editText = (EditText) this.f.findViewById(R.id.pspdf__share_dialog_document_name);
        this.g = editText;
        editText.setText(this.a.getInitialDocumentName().replaceAll("[:\\\\/*\"?|<>']", ""));
        a80.a(this.g, this.o);
        this.g.addTextChangedListener(new me(this));
        this.g.clearFocus();
        this.h = (Spinner) this.f.findViewById(R.id.pspdf__share_dialog_pages_spinner);
        this.k = new c(2, 0, this.d, new Range(0, this.d));
        c cVar = new c(3, this.c, this.d, new Range(0, this.d));
        ArrayAdapter<c> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, new c[]{new c(1, this.c, this.d, new Range(this.c, 1)), this.k, cVar});
        this.i = arrayAdapter;
        this.h.setAdapter((SpinnerAdapter) arrayAdapter);
        EditText editText2 = (EditText) this.f.findViewById(R.id.pspdf__share_dialog_pages_range);
        this.j = editText2;
        a80.a(editText2, this.o);
        this.j.setText(String.format(Locale.getDefault(), "%d-%d", 1, Integer.valueOf(this.d)));
        this.j.addTextChangedListener(new ne(this));
        if (this.a.isInitialPagesSpinnerAllPages()) {
            this.h.setSelection(this.i.getPosition(cVar));
        }
        this.h.setOnItemSelectedListener(new oe(this));
        this.l = (Spinner) this.f.findViewById(R.id.pspdf__share_dialog_annotations_spinner);
        ArrayAdapter<a> arrayAdapter2 = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, getAnnotationSpinnerItems());
        this.m = arrayAdapter2;
        this.l.setAdapter((SpinnerAdapter) arrayAdapter2);
        TextView textView = (TextView) this.f.findViewById(R.id.pspdf__share_dialog_annotations_description);
        while (true) {
            if (i >= this.m.getCount()) {
                this.l.setOnItemSelectedListener(new pe(this, textView));
                break;
            } else {
                if (this.m.getItem(i).c <= 0) {
                    textView.setVisibility(8);
                    break;
                }
                i++;
            }
        }
        TextView textView2 = (TextView) this.f.findViewById(R.id.pspdf__positive_button);
        this.n = textView2;
        textView2.setText(this.a.getPositiveButtonText());
        this.n.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.qe$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
        TextView textView3 = this.n;
        int i2 = this.o;
        textView3.setTextColor(new ColorStateList(new int[][]{new int[]{android.R.attr.state_enabled}, FrameLayout.EMPTY_STATE_SET}, new int[]{i2, textView3.getTextColors() != null ? textView3.getTextColors().getColorForState(FrameLayout.EMPTY_STATE_SET, i2) : i2}));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x004b  */
    public final void b() {
        boolean z;
        TextView textView = this.n;
        if ((this.i.getItem(this.h.getSelectedItemPosition()).a == 2 && this.k.d.isEmpty()) || TextUtils.isEmpty(this.g.getText())) {
            z = false;
        } else {
            String string = this.g.getText().toString();
            if (TextUtils.isEmpty(string) || !string.replaceAll("[:\\\\/*\"?|<>']", "").equals(string)) {
                z = false;
            } else {
                z = true;
            }
        }
        textView.setEnabled(z);
    }

    public SharingOptions getSharingOptions() {
        return new SharingOptions(getAnnotationProcessingMode(), this.i.getItem(this.h.getSelectedItemPosition()).d, this.g.getText().toString());
    }

    public void setOnConfirmDocumentSharingListener(b bVar) {
        this.e = bVar;
    }

    public final /* synthetic */ void a(View view) {
        b bVar = this.e;
        if (bVar != null) {
            bVar.a(this);
        }
    }
}
