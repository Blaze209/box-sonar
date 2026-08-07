package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.pspdfkit.R;
import java.text.NumberFormat;

/* JADX INFO: loaded from: classes3.dex */
public final class cx extends AlertDialog {
    public ProgressBar a;
    public TextView b;
    public int c;
    public TextView d;
    public String e;
    public TextView f;
    public NumberFormat g;
    public int h;
    public int i;
    public int j;
    public int k;
    public Drawable l;
    public CharSequence m;
    public boolean n;
    public boolean o;
    public a p;

    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            int progress = cx.this.a.getProgress();
            int max = cx.this.a.getMax();
            cx cxVar = cx.this;
            String str = cxVar.e;
            TextView textView = cxVar.d;
            if (str != null) {
                textView.setText(String.format(str, Integer.valueOf(progress), Integer.valueOf(max)));
            } else {
                textView.setText("");
            }
            cx cxVar2 = cx.this;
            if (cxVar2.g == null) {
                cxVar2.f.setText("");
                return;
            }
            SpannableString spannableString = new SpannableString(cx.this.g.format(((double) progress) / ((double) max)));
            spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            cx.this.f.setText(spannableString);
        }
    }

    public cx(Context context) {
        super(context);
        this.c = 0;
        this.e = "%1d/%2d";
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        this.g = percentInstance;
        percentInstance.setMaximumFractionDigits(0);
    }

    public final void a(boolean z) {
        ProgressBar progressBar = this.a;
        if (progressBar != null) {
            progressBar.setIndeterminate(z);
        } else {
            this.n = z;
        }
    }

    @Override // androidx.appcompat.app.AlertDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, com.microsoft.intune.mam.client.app.MAMDialog, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        if (this.c == 1) {
            this.p = new a();
            View viewInflate = layoutInflaterFrom.inflate(R.layout.pspdf__alert_dialog_progress, (ViewGroup) null);
            this.a = (ProgressBar) viewInflate.findViewById(R.id.pspdf__progress);
            this.d = (TextView) viewInflate.findViewById(R.id.pspdf__progress_number);
            this.f = (TextView) viewInflate.findViewById(R.id.pspdf__progress_percent);
            setView(viewInflate);
        } else {
            View viewInflate2 = layoutInflaterFrom.inflate(R.layout.pspdf__progress_dialog, (ViewGroup) null);
            this.a = (ProgressBar) viewInflate2.findViewById(R.id.pspdf__progress);
            this.b = (TextView) viewInflate2.findViewById(R.id.pspdf__message);
            setView(viewInflate2);
        }
        int i = this.h;
        if (i > 0) {
            ProgressBar progressBar = this.a;
            if (progressBar != null) {
                progressBar.setMax(i);
                a();
            } else {
                this.h = i;
            }
        }
        int i2 = this.i;
        if (i2 > 0) {
            if (this.o) {
                this.a.setProgress(i2);
                a();
            } else {
                this.i = i2;
            }
        }
        int i3 = this.j;
        if (i3 > 0) {
            ProgressBar progressBar2 = this.a;
            if (progressBar2 != null) {
                progressBar2.incrementProgressBy(i3);
                a();
            } else {
                this.j = i3 + i3;
            }
        }
        int i4 = this.k;
        if (i4 > 0) {
            ProgressBar progressBar3 = this.a;
            if (progressBar3 != null) {
                progressBar3.incrementSecondaryProgressBy(i4);
                a();
            } else {
                this.k = i4 + i4;
            }
        }
        Drawable drawable = this.l;
        if (drawable != null) {
            ProgressBar progressBar4 = this.a;
            if (progressBar4 != null) {
                progressBar4.setIndeterminateDrawable(drawable);
            } else {
                this.l = drawable;
            }
        }
        CharSequence charSequence = this.m;
        if (charSequence != null) {
            setMessage(charSequence);
        }
        a(this.n);
        a();
        super.onCreate(bundle);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public final void onStart() {
        super.onStart();
        this.o = true;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public final void onStop() {
        super.onStop();
        this.o = false;
    }

    @Override // androidx.appcompat.app.AlertDialog
    public final void setMessage(CharSequence charSequence) {
        if (this.a == null) {
            this.m = charSequence;
        } else if (this.c == 1) {
            super.setMessage(charSequence);
        } else {
            this.b.setText(charSequence);
        }
    }

    public final void a() {
        a aVar;
        if (this.c != 1 || (aVar = this.p) == null || aVar.hasMessages(0)) {
            return;
        }
        this.p.sendEmptyMessage(0);
    }
}
