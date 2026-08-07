package com.pspdfkit.internal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;
import com.pspdfkit.signatures.ValidationStatus;

/* JADX INFO: loaded from: classes3.dex */
public final class e20 extends FrameLayout {
    public static final int f = R.attr.pspdf__sharingDialogStyle;
    public static final int g = R.style.PSPDFKit_SharingDialog;
    public final View a;
    public final ViewGroup b;
    public final f20 c;
    public final View d;
    public final TextView e;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ValidationStatus.values().length];
            a = iArr;
            try {
                iArr[ValidationStatus.VALID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ValidationStatus.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ValidationStatus.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public interface b {
        void a(e20 e20Var);
    }

    public e20(Context context, final b bVar) {
        super(new ContextThemeWrapper(context, f60.b(context, f, g)));
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.pspdf__signature_info_dialog, (ViewGroup) this, true);
        this.a = viewInflate;
        ViewGroup viewGroup = (ViewGroup) viewInflate.findViewById(R.id.pspdf__signature_info_content);
        this.b = viewGroup;
        this.d = viewInflate.findViewById(R.id.pspdf__signature_info_throbber);
        this.e = (TextView) viewInflate.findViewById(R.id.pspdf__signature_info_summary);
        f20 f20Var = new f20(context, new yq(context));
        this.c = f20Var;
        viewGroup.addView(f20Var, 0);
        viewInflate.findViewById(R.id.pspdf__positive_button).setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.e20$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(bVar, view);
            }
        });
    }

    public final /* synthetic */ void a(b bVar, View view) {
        bVar.a(this);
    }

    public final /* synthetic */ void b() {
        this.d.setVisibility(4);
    }

    public final void c() {
        this.d.animate().alpha(0.0f).withEndAction(new Runnable() { // from class: com.pspdfkit.internal.e20$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a();
            }
        });
        this.b.setVisibility(0);
        this.b.setAlpha(0.0f);
        this.b.animate().alpha(1.0f);
    }

    public final void d() {
        this.d.animate().alpha(0.0f).withEndAction(new Runnable() { // from class: com.pspdfkit.internal.e20$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b();
            }
        });
        this.c.setTitleColor(ContextCompat.getColor(getContext(), R.color.pspdf__errorLight));
        this.c.setTitleTextColor(-1);
        this.c.setTitle(R.string.pspdf__digital_signature_error_validation_failed);
        this.b.setVisibility(0);
        this.b.setAlpha(0.0f);
        this.e.setVisibility(8);
        this.b.animate().alpha(1.0f);
    }

    public void setOnDeleteSignatureHandler(final Runnable runnable) {
        View viewFindViewById = this.a.findViewById(R.id.pspdf__remove_signature_button);
        if (runnable == null) {
            viewFindViewById.setVisibility(8);
        } else {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.e20$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.a(runnable, view);
                }
            });
            viewFindViewById.setVisibility(0);
        }
    }

    public void setStatus(ValidationStatus validationStatus) {
        this.c.setTitle(R.string.pspdf__signature);
        int i = a.a[validationStatus.ordinal()];
        if (i == 1) {
            this.c.setTitleColor(ContextCompat.getColor(getContext(), R.color.pspdf__secondaryLight));
            this.c.setTitleTextColor(-1);
        } else if (i == 2) {
            this.c.setTitleColor(ContextCompat.getColor(getContext(), R.color.pspdf__tertiaryContainerLight));
            this.c.setTitleTextColor(-16777216);
        } else {
            if (i != 3) {
                return;
            }
            this.c.setTitleColor(ContextCompat.getColor(getContext(), R.color.pspdf__errorLight));
            this.c.setTitleTextColor(-1);
        }
    }

    public void setSummary(CharSequence charSequence) {
        this.e.setText(charSequence);
    }

    public final /* synthetic */ void a() {
        this.d.setVisibility(4);
    }

    public final /* synthetic */ void a(Runnable runnable, View view) {
        runnable.run();
        this.a.findViewById(R.id.pspdf__positive_button).callOnClick();
    }
}
