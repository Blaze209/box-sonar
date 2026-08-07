package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;
import com.pspdfkit.internal.views.document.DocumentView;

/* JADX INFO: loaded from: classes3.dex */
public final class sp {
    public final vo a;
    public final TextView b;
    public final View c;
    public j10 d;

    public sp(Context context, DocumentView documentView, vo voVar) {
        context.getClass();
        documentView.getClass();
        voVar.getClass();
        this.a = voVar;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.pspdf__MeasurementTool, R.attr.pspdf__measurementToolsStyle, R.style.PSPDFKit_MeasurementTools);
        typedArrayObtainStyledAttributes.getClass();
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__MeasurementTool_pspdf__measurementValuePopupBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__primaryDark));
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__MeasurementTool_pspdf__scaleListItemBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight));
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__MeasurementTool_pspdf__scaleListItemCheckColor, ContextCompat.getColor(context, R.color.pspdf__primaryLight));
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__MeasurementTool_pspdf__scaleButtonForegroundColor, ContextCompat.getColor(context, R.color.pspdf__primaryLight));
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__MeasurementTool_pspdf__scaleButtonBackgroundColor, ContextCompat.getColor(context, R.color.pspdf__onPrimaryLight));
        final ViewGroup viewGroup = (ViewGroup) documentView.getRootView().findViewById(android.R.id.content);
        if (viewGroup == null) {
            throw new IllegalStateException("Can't initialise measurement popup without application root view.");
        }
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.pspdf__measurement_value_popup, viewGroup, false);
        if (viewInflate == null) {
            throw new IllegalStateException("Can't initialise measurement popup.");
        }
        this.c = viewInflate;
        TextView textView = (TextView) viewInflate.findViewById(R.id.pspdf__measurement_value_popup_text);
        if (textView == null) {
            throw new IllegalStateException("Can't initialise measurement popup. Can't find popup text view.");
        }
        this.b = textView;
        textView.getBackground().setTint(color);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.pspdfkit.internal.sp$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                sp.a(viewGroup, this);
            }
        });
    }

    public static final void a(ViewGroup viewGroup, sp spVar) {
        viewGroup.addView(spVar.c);
    }

    public final boolean a(String str) {
        vo voVar = this.a;
        if (!voVar.e) {
            return false;
        }
        Point pointG = voVar.g();
        if (pointG == null) {
            pointG = null;
        } else {
            pointG.x = ((this.a.h() / 2) - (this.b.getWidth() / 2)) + pointG.x;
            pointG.y = (pointG.y - this.b.getHeight()) - 10;
        }
        if (pointG == null) {
            return false;
        }
        this.b.setText(str);
        this.c.setVisibility(0);
        this.c.setX(pointG.x);
        this.c.setY(pointG.y);
        j10 j10Var = this.d;
        if (j10Var == null) {
            return true;
        }
        j10Var.a(false);
        return true;
    }

    public final void a() {
        this.c.post(new Runnable() { // from class: com.pspdfkit.internal.sp$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                sp.a(this.f$0);
            }
        });
    }

    public static final void a(sp spVar) {
        ViewParent parent = spVar.c.getParent();
        if (parent != null) {
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(spVar.c);
            }
        }
    }
}
