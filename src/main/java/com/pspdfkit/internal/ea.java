package com.pspdfkit.internal;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import com.google.android.material.timepicker.TimeModel;
import com.microsoft.intune.mam.client.widget.MAMPopupMenu;
import com.pspdfkit.R;
import com.pspdfkit.annotations.note.AnnotationReviewSummary;
import com.pspdfkit.annotations.note.AuthorState;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ea extends rs<ds> {
    public final TextView a;
    public final TextView b;
    public final ImageView c;
    public final EditText d;
    public final LinearLayout e;
    public final Button f;
    public final Button g;
    public final LinearLayout h;
    public final LinearLayout i;
    public final LinearLayout j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final View w;
    public boolean x;
    public final xs y;

    public static final class a implements TextWatcher {
        public final ds a;
        public final es b;
        public final Function1<Boolean, Unit> c;
        public boolean d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(ds dsVar, es esVar, Function1<? super Boolean, Unit> function1) {
            function1.getClass();
            this.a = dsVar;
            this.b = esVar;
            this.c = function1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.d = charSequence == null || charSequence.length() == 0;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String string = charSequence != null ? charSequence.toString() : null;
            if (string == null) {
                string = "";
            }
            es esVar = this.b;
            if (esVar != null) {
                esVar.a(this.a, string);
            }
            boolean z = string.length() == 0;
            if (z != this.d) {
                this.c.invoke(Boolean.valueOf(z));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ea(View view) {
        super(view);
        view.getClass();
        View viewFindViewById = view.findViewById(R.id.pspdf__note_editor_item_author_name);
        viewFindViewById.getClass();
        TextView textView = (TextView) viewFindViewById;
        this.a = textView;
        View viewFindViewById2 = view.findViewById(R.id.pspdf__note_editor_item_created_date);
        viewFindViewById2.getClass();
        TextView textView2 = (TextView) viewFindViewById2;
        this.b = textView2;
        View viewFindViewById3 = view.findViewById(R.id.pspdf__note_editor_item_options_item);
        viewFindViewById3.getClass();
        this.c = (ImageView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.pspdf__note_editor_item_content);
        viewFindViewById4.getClass();
        EditText editText = (EditText) viewFindViewById4;
        this.d = editText;
        View viewFindViewById5 = view.findViewById(R.id.pspdf__note_item_explicit_editing_controls_layout);
        viewFindViewById5.getClass();
        this.e = (LinearLayout) viewFindViewById5;
        View viewFindViewById6 = view.findViewById(R.id.pspdf__note_editor_item_cancel_button);
        viewFindViewById6.getClass();
        this.f = (Button) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.pspdf__note_editor_item_save_button);
        viewFindViewById7.getClass();
        this.g = (Button) viewFindViewById7;
        View viewFindViewById8 = view.findViewById(R.id.pspdf__note_item_reviews_layout);
        viewFindViewById8.getClass();
        this.h = (LinearLayout) viewFindViewById8;
        View viewFindViewById9 = view.findViewById(R.id.pspdf__note_item_review_state_list_layout);
        viewFindViewById9.getClass();
        this.i = (LinearLayout) viewFindViewById9;
        View viewFindViewById10 = view.findViewById(R.id.pspdf__note_item_status_details);
        viewFindViewById10.getClass();
        this.j = (LinearLayout) viewFindViewById10;
        View viewFindViewById11 = view.findViewById(R.id.pspdf__note_status_accepted_text_view);
        viewFindViewById11.getClass();
        this.k = (TextView) viewFindViewById11;
        View viewFindViewById12 = view.findViewById(R.id.pspdf__note_status_completed_text_view);
        viewFindViewById12.getClass();
        this.l = (TextView) viewFindViewById12;
        View viewFindViewById13 = view.findViewById(R.id.pspdf__note_status_cancelled_text_view);
        viewFindViewById13.getClass();
        this.m = (TextView) viewFindViewById13;
        View viewFindViewById14 = view.findViewById(R.id.pspdf__note_status_rejected_text_view);
        viewFindViewById14.getClass();
        this.n = (TextView) viewFindViewById14;
        View viewFindViewById15 = view.findViewById(R.id.pspdf__accepted_authors_label);
        viewFindViewById15.getClass();
        this.o = (TextView) viewFindViewById15;
        View viewFindViewById16 = view.findViewById(R.id.pspdf__completed_authors_label);
        viewFindViewById16.getClass();
        this.p = (TextView) viewFindViewById16;
        View viewFindViewById17 = view.findViewById(R.id.pspdf__cancelled_authors_label);
        viewFindViewById17.getClass();
        this.q = (TextView) viewFindViewById17;
        View viewFindViewById18 = view.findViewById(R.id.pspdf__rejected_authors_label);
        viewFindViewById18.getClass();
        this.r = (TextView) viewFindViewById18;
        View viewFindViewById19 = view.findViewById(R.id.pspdf__accepted_authors_text_box);
        viewFindViewById19.getClass();
        this.s = (TextView) viewFindViewById19;
        View viewFindViewById20 = view.findViewById(R.id.pspdf__completed_authors_text_box);
        viewFindViewById20.getClass();
        this.t = (TextView) viewFindViewById20;
        View viewFindViewById21 = view.findViewById(R.id.pspdf__cancelled_authors_text_box);
        viewFindViewById21.getClass();
        this.u = (TextView) viewFindViewById21;
        View viewFindViewById22 = view.findViewById(R.id.pspdf__rejected_authors_text_box);
        viewFindViewById22.getClass();
        this.v = (TextView) viewFindViewById22;
        View viewFindViewById23 = view.findViewById(R.id.pspdf__note_item_bottom_padding);
        viewFindViewById23.getClass();
        this.w = viewFindViewById23;
        Context context = view.getContext();
        context.getClass();
        xs xsVar = new xs(context);
        this.y = xsVar;
        textView.setTextColor(xsVar.a);
        textView2.setTextColor(xsVar.b);
        editText.setTextColor(xsVar.c);
    }

    public static final void b(es esVar, ea eaVar, View view) {
        esVar.c();
        eaVar.d.clearFocus();
    }

    public final void a(final ds dsVar, final is isVar) {
        boolean zB = dsVar.b();
        this.d.setEnabled(zB);
        EditText editText = this.d;
        editText.setHint(no.a(editText.getContext(), R.string.pspdf__hint_add_your_comment, null));
        this.i.setOnClickListener(null);
        if (dsVar.f()) {
            this.e.setVisibility(8);
            this.a.setVisibility(8);
            this.h.setVisibility(8);
            this.c.setVisibility(8);
            this.b.setVisibility(8);
            this.w.setVisibility(0);
            this.d.setText("");
            this.d.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.pspdfkit.internal.ea$$ExternalSyntheticLambda1
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    ea.a(isVar, this, view, z);
                }
            });
            return;
        }
        this.a.setVisibility(0);
        this.a.setText(dsVar.j());
        this.b.setVisibility(0);
        this.b.setText(dsVar.l());
        a(dsVar, (es) isVar);
        String strG = dsVar.g();
        this.d.setText(strG);
        this.d.setOnFocusChangeListener(null);
        this.d.addTextChangedListener(new a(dsVar, isVar, new Function1() { // from class: com.pspdfkit.internal.ea$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ea.a(this.f$0, ((Boolean) obj).booleanValue());
            }
        }));
        if (this.x) {
            if (zB) {
                this.d.post(new Runnable() { // from class: com.pspdfkit.internal.ea$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        ea.a(this.f$0);
                    }
                });
            }
            this.x = false;
        }
        this.g.setEnabled(!(strG == null || strG.length() == 0));
        boolean zH = dsVar.h();
        this.e.setVisibility(zH ? 0 : 8);
        this.w.setVisibility(zH ? 8 : 0);
        if (isVar != null) {
            this.g.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.ea$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ea.a(isVar, this, view);
                }
            });
            this.f.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.ea$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ea.b(isVar, this, view);
                }
            });
        }
        AnnotationReviewSummary annotationReviewSummaryM = dsVar.m();
        if (annotationReviewSummaryM == null) {
            this.h.setVisibility(8);
            return;
        }
        Iterator it = CollectionsKt.listOf((Object[]) new TextView[]{this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v}).iterator();
        while (it.hasNext()) {
            ((TextView) it.next()).setVisibility(8);
        }
        int i = 8;
        this.k.setSelected(false);
        this.l.setSelected(false);
        this.m.setSelected(false);
        this.n.setSelected(false);
        this.h.setVisibility(0);
        this.i.setClickable(true);
        this.i.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.ea$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ea.a(isVar, dsVar, view);
            }
        });
        Map<AuthorState, List<String>> reviewNames = annotationReviewSummaryM.getReviewNames();
        this.h.setVisibility(reviewNames.isEmpty() || (reviewNames.size() == 1 && reviewNames.containsKey(AuthorState.NONE)) ? 8 : 0);
        AuthorState currentUserState = annotationReviewSummaryM.getCurrentUserState();
        AuthorState authorState = AuthorState.ACCEPTED;
        a(reviewNames.get(authorState), this.k, this.s, this.o, currentUserState == authorState);
        AuthorState authorState2 = AuthorState.COMPLETED;
        a(reviewNames.get(authorState2), this.l, this.t, this.p, currentUserState == authorState2);
        AuthorState authorState3 = AuthorState.CANCELLED;
        a(reviewNames.get(authorState3), this.m, this.u, this.q, currentUserState == authorState3);
        AuthorState authorState4 = AuthorState.REJECTED;
        a(reviewNames.get(authorState4), this.n, this.v, this.r, currentUserState == authorState4);
        LinearLayout linearLayout = this.j;
        if (dsVar.k()) {
            i = 0;
        }
        linearLayout.setVisibility(i);
    }

    public static final void a(es esVar, ea eaVar, View view, boolean z) {
        if (esVar != null && z && esVar.b()) {
            eaVar.d.clearFocus();
        }
    }

    public static final Unit a(ea eaVar, boolean z) {
        eaVar.g.setEnabled(!z);
        return Unit.INSTANCE;
    }

    public static final void a(ea eaVar) {
        eaVar.d.requestFocus();
        hn.a(eaVar.d, (f7) null);
    }

    public static final void a(es esVar, ea eaVar, View view) {
        esVar.e();
        eaVar.d.clearFocus();
    }

    public static final void a(es esVar, ds dsVar, View view) {
        if (esVar != null) {
            esVar.a(dsVar);
        }
    }

    public static void a(List list, TextView textView, TextView textView2, TextView textView3, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        textView.setVisibility(0);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        textView.setText(String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(list.size())}, 1)));
        textView.setSelected(z);
        textView2.setVisibility(0);
        textView2.setText(CollectionsKt.joinToString$default(list, ", ", null, null, 0, null, null, 62, null));
        textView3.setVisibility(0);
    }

    public final void a(final ds dsVar, final es esVar) {
        final Set<fs.a> setA = dsVar.a();
        boolean zIsEmpty = setA.isEmpty();
        ImageView imageView = this.c;
        if (zIsEmpty) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            this.c.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.ea$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ea.a(this.f$0, setA, esVar, dsVar, view);
                }
            });
        }
    }

    public static final void a(final ea eaVar, Set set, final es esVar, final ds dsVar, View view) {
        MAMPopupMenu mAMPopupMenu = new MAMPopupMenu(eaVar.itemView.getContext(), eaVar.c);
        MenuInflater menuInflater = mAMPopupMenu.getMenuInflater();
        menuInflater.getClass();
        menuInflater.inflate(R.menu.pspdf__menu_note_annotation_editor_options, mAMPopupMenu.getMenu());
        Iterator it = set.iterator();
        while (it.hasNext()) {
            MenuItem menuItemFindItem = mAMPopupMenu.getMenu().findItem(((fs.a) it.next()).a);
            if (menuItemFindItem != null) {
                menuItemFindItem.setVisible(true);
                View actionView = menuItemFindItem.getActionView();
                TextView textView = actionView instanceof TextView ? (TextView) actionView : null;
                if (textView != null) {
                    textView.setTextColor(eaVar.y.a);
                }
            }
        }
        mAMPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.pspdfkit.internal.ea$$ExternalSyntheticLambda7
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return ea.a(this.f$0, esVar, dsVar, menuItem);
            }
        });
        mAMPopupMenu.show();
    }

    public static final boolean a(ea eaVar, es esVar, ds dsVar, MenuItem menuItem) {
        eaVar.d.clearFocus();
        hn.c(eaVar.d);
        int itemId = menuItem.getItemId();
        if (itemId == R.id.pspdf__note_editor_option_delete_reply) {
            if (esVar != null) {
                esVar.a(dsVar, fs.a.DELETE);
            }
            return true;
        }
        if (itemId == R.id.pspdf__note_editor_option_set_reply_status) {
            if (esVar != null) {
                esVar.a(dsVar, fs.a.SET_STATUS);
            }
            return true;
        }
        if (itemId != R.id.pspdf__note_editor_option_share) {
            return false;
        }
        if (esVar != null) {
            esVar.a(dsVar, fs.a.SHARE);
        }
        return true;
    }
}
