package com.pspdfkit.internal.ui.dialog.signatures;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.pspdfkit.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/pspdfkit/internal/ui/dialog/signatures/LegacySignatureCanvasView;", "Lcom/pspdfkit/internal/ui/dialog/signatures/e;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getSignHereStringRes", "()I", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LegacySignatureCanvasView extends e {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LegacySignatureCanvasView(Context context) {
        this(context, null, 0, 6, null);
        context.getClass();
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public final void a(Canvas canvas) {
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public final float b() {
        float height = getHeight() * 0.6666667f;
        Context context = getContext();
        context.getClass();
        return height + ((int) TypedValue.applyDimension(2, 16.0f, context.getResources().getDisplayMetrics()));
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public final void d() {
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public final void f() {
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public int getSignHereStringRes() {
        return R.string.pspdf__signature_sign_here;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LegacySignatureCanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        context.getClass();
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public final void a(Paint paint) {
        paint.getClass();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(-3355444);
        Context context = getContext();
        context.getClass();
        paint.setTextSize((int) TypedValue.applyDimension(2, 16.0f, context.getResources().getDisplayMetrics()));
        paint.setTextSkewX(-0.25f);
        paint.setTextAlign(Paint.Align.CENTER);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LegacySignatureCanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context.getClass();
    }

    public /* synthetic */ LegacySignatureCanvasView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public final float a() {
        return getHeight() * 0.6666667f;
    }
}
