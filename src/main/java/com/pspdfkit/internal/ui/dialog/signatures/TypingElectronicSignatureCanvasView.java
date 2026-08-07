package com.pspdfkit.internal.ui.dialog.signatures;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pspdfkit.R;
import com.pspdfkit.internal.f7;
import com.pspdfkit.internal.hn;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.u60;
import com.pspdfkit.internal.uc;
import com.pspdfkit.internal.un;
import com.pspdfkit.signatures.Signature;
import com.pspdfkit.ui.fonts.Font;
import com.pspdfkit.ui.signatures.ElectronicSignatureOptions;
import com.pspdfkit.utils.ParcelExtensions;
import io.reactivex.rxjava3.core.Single;
import java.util.Iterator;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0002\"#B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\f2\b\b\u0001\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/pspdfkit/internal/ui/dialog/signatures/TypingElectronicSignatureCanvasView;", "Lcom/pspdfkit/internal/ui/dialog/signatures/e;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/pspdfkit/ui/fonts/Font;", "font", "", "setSelectedFont", "(Lcom/pspdfkit/ui/fonts/Font;)V", "Landroid/graphics/Typeface;", "typeFace", "setTypeFace", "(Landroid/graphics/Typeface;)V", "", "active", "setActive", "(Z)V", "getSelectedFontOrDefault", "()Lcom/pspdfkit/ui/fonts/Font;", "color", "setInkColor", "(I)V", "getSignHereStringRes", "()I", "Lcom/pspdfkit/internal/ui/dialog/signatures/TypingElectronicSignatureCanvasView$a;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnSignatureTypedListener", "(Lcom/pspdfkit/internal/ui/dialog/signatures/TypingElectronicSignatureCanvasView$a;)V", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TypingElectronicSignatureCanvasView extends e {
    public final boolean p;
    public final Paint q;
    public final String r;
    public EditText s;
    public TextView t;
    public TextView u;
    public a v;
    public int w;

    public interface a {
        void afterTextChanged(Editable editable);
    }

    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            a aVar = TypingElectronicSignatureCanvasView.this.v;
            if (aVar != null) {
                aVar.afterTextChanged(editable);
            }
            if (editable == null || StringsKt.trim(editable).length() == 0) {
                e.b bVar = TypingElectronicSignatureCanvasView.this.l;
                if (bVar != null) {
                    bVar.c();
                }
                TypingElectronicSignatureCanvasView.this.d();
                return;
            }
            e.b bVar2 = TypingElectronicSignatureCanvasView.this.l;
            if (bVar2 != null) {
                bVar2.b();
            }
            TypingElectronicSignatureCanvasView.this.f();
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TypingElectronicSignatureCanvasView(Context context) {
        this(context, null, 0, 6, null);
        context.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setActive$lambda$0(TypingElectronicSignatureCanvasView typingElectronicSignatureCanvasView) {
        typingElectronicSignatureCanvasView.requestFocus();
        EditText editText = typingElectronicSignatureCanvasView.s;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeSignature");
            editText = null;
        }
        hn.a(editText, (f7) null);
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public final void a(Paint paint) {
        paint.getClass();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(this.o.x);
        Context context = getContext();
        context.getClass();
        paint.setTextSize((int) TypedValue.applyDimension(2, 16.0f, context.getResources().getDisplayMetrics()));
        paint.setTextAlign(Paint.Align.CENTER);
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public final float b() {
        float height = getHeight();
        Context context = getContext();
        context.getClass();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        displayMetrics.getClass();
        return height - TypedValue.applyDimension(1, 1 + 18.0f, displayMetrics);
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public final void c() {
        EditText editText = this.s;
        TextView textView = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeSignature");
            editText = null;
        }
        editText.getText().clear();
        TextView textView2 = this.t;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeSignatureHint");
        } else {
            textView = textView2;
        }
        textView.setVisibility(0);
        super.c();
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public final void d() {
        TextView textView = this.t;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeSignatureHint");
            textView = null;
        }
        textView.setVisibility(0);
        this.m = true;
        invalidate();
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public final void f() {
        TextView textView = this.t;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeSignatureHint");
            textView = null;
        }
        textView.setVisibility(4);
        this.m = false;
        invalidate();
    }

    public final Font getSelectedFontOrDefault() {
        Object next;
        if (this.w == -1) {
            ElectronicSignatureOptions.Companion companion = ElectronicSignatureOptions.INSTANCE;
            Context context = getContext();
            context.getClass();
            return (Font) CollectionsKt.firstOrNull(companion.getAvailableFonts(context));
        }
        ElectronicSignatureOptions.Companion companion2 = ElectronicSignatureOptions.INSTANCE;
        Context context2 = getContext();
        context2.getClass();
        Iterator<T> it = companion2.getAvailableFonts(context2).iterator();
        while (it.hasNext()) {
            next = it.next();
            if (((Font) next).hashCode() == this.w) {
                return (Font) next;
            }
        }
        next = null;
        return (Font) next;
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public int getSignHereStringRes() {
        return R.string.pspdf__electronic_signature_type_your_signature_above;
    }

    public final float h() {
        Context context = getContext();
        context.getClass();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        displayMetrics.getClass();
        float fApplyDimension = TypedValue.applyDimension(1, 18.0f, displayMetrics) * 2;
        Context context2 = getContext();
        context2.getClass();
        return fApplyDimension + ((int) TypedValue.applyDimension(2, 16.0f, context2.getResources().getDisplayMetrics()));
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e, android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.getClass();
        if (this.m) {
            String strA = no.a(getContext(), getSignHereStringRes(), this);
            strA.getClass();
            canvas.drawText(strA, getWidth() / 2, b(), this.a);
        } else {
            a(canvas);
        }
        Context context = getContext();
        context.getClass();
        float fA = (int) un.a(context, 1, 12);
        float height = getHeight() - h();
        canvas.drawLine(fA, height, getWidth() - fA, height, this.a);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        View viewFindViewById = findViewById(R.id.pspdf__electronic_signature_type_signature);
        viewFindViewById.getClass();
        this.s = (EditText) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.pspdf__electronic_signature_type_signature_measure_helper);
        viewFindViewById2.getClass();
        TextView textView = (TextView) viewFindViewById2;
        this.u = textView;
        Context context = getContext();
        context.getClass();
        int iApplyDimension = (int) TypedValue.applyDimension(2, 12.0f, context.getResources().getDisplayMetrics());
        EditText editText = this.s;
        TextView textView2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeSignature");
            editText = null;
        }
        int iRoundToInt = MathKt.roundToInt(editText.getTextSize());
        Context context2 = getContext();
        context2.getClass();
        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(textView, iApplyDimension, iRoundToInt, (int) TypedValue.applyDimension(2, 2.0f, context2.getResources().getDisplayMetrics()), 0);
        TextView textView3 = this.u;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autosizeHelper");
            textView3 = null;
        }
        EditText editText2 = this.s;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeSignature");
            editText2 = null;
        }
        int left = editText2.getLeft();
        EditText editText3 = this.s;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeSignature");
            editText3 = null;
        }
        int top = editText3.getTop();
        EditText editText4 = this.s;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeSignature");
            editText4 = null;
        }
        int right = editText4.getRight();
        EditText editText5 = this.s;
        if (editText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeSignature");
            editText5 = null;
        }
        textView3.setPadding(left, top, right, editText5.getBottom());
        TextView textView4 = this.u;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autosizeHelper");
            textView4 = null;
        }
        EditText editText6 = this.s;
        if (editText6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeSignature");
            editText6 = null;
        }
        textView4.setLayoutParams(editText6.getLayoutParams());
        EditText editText7 = this.s;
        if (editText7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeSignature");
            editText7 = null;
        }
        editText7.addTextChangedListener(new u60(this));
        View viewFindViewById3 = findViewById(R.id.pspdf__electronic_signature_type_signature_hint);
        viewFindViewById3.getClass();
        this.t = (TextView) viewFindViewById3;
        Font selectedFontOrDefault = getSelectedFontOrDefault();
        Typeface defaultTypeface = selectedFontOrDefault != null ? selectedFontOrDefault.getDefaultTypeface() : null;
        EditText editText8 = this.s;
        if (editText8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeSignature");
            editText8 = null;
        }
        if (!editText8.getTypeface().equals(defaultTypeface)) {
            setTypeFace(defaultTypeface);
        }
        EditText editText9 = this.s;
        if (editText9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeSignature");
            editText9 = null;
        }
        editText9.addTextChangedListener(new c());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, 0, 0, (int) h());
        EditText editText10 = this.s;
        if (editText10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeSignature");
            editText10 = null;
        }
        editText10.setLayoutParams(layoutParams);
        TextView textView5 = this.t;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeSignatureHint");
        } else {
            textView2 = textView5;
        }
        textView2.setLayoutParams(layoutParams);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        if (!this.p && getResources().getConfiguration().orientation == 1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) (size * 0.6666667f), 1073741824);
        }
        super.onMeasure(i, iMakeMeasureSpec);
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof b) {
            b bVar = (b) parcelable;
            this.w = bVar.e;
            parcelable = bVar.getSuperState();
        }
        Font selectedFontOrDefault = getSelectedFontOrDefault();
        setTypeFace(selectedFontOrDefault != null ? selectedFontOrDefault.getDefaultTypeface() : null);
        super.onRestoreInstanceState(parcelable);
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e, android.view.View
    public final Parcelable onSaveInstanceState() {
        b bVar = new b((e.c) super.onSaveInstanceState());
        bVar.e = this.w;
        return bVar;
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public /* bridge */ /* synthetic */ void setActive(Boolean bool) {
        setActive(bool.booleanValue());
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public void setInkColor(int color) {
        super.setInkColor(color);
        EditText editText = this.s;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeSignature");
            editText = null;
        }
        editText.setTextColor(color);
    }

    public final void setOnSignatureTypedListener(a listener) {
        this.v = listener;
    }

    public final void setSelectedFont(Font font) {
        font.getClass();
        this.w = font.hashCode();
        setTypeFace(font.getDefaultTypeface());
    }

    public final void setTypeFace(Typeface typeFace) {
        EditText editText = this.s;
        TextView textView = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeSignature");
            editText = null;
        }
        editText.setTypeface(typeFace);
        TextView textView2 = this.t;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeSignatureHint");
            textView2 = null;
        }
        textView2.setTypeface(typeFace);
        TextView textView3 = this.u;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autosizeHelper");
        } else {
            textView = textView3;
        }
        textView.setTypeface(typeFace);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TypingElectronicSignatureCanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        context.getClass();
    }

    public void setActive(boolean active) {
        if (!active) {
            hn.c(this);
            return;
        }
        EditText editText = this.s;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeSignature");
            editText = null;
        }
        editText.post(new Runnable() { // from class: com.pspdfkit.internal.ui.dialog.signatures.TypingElectronicSignatureCanvasView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                TypingElectronicSignatureCanvasView.setActive$lambda$0(this.f$0);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypingElectronicSignatureCanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context.getClass();
        Paint paint = new Paint();
        this.q = paint;
        String strA = no.a(getContext(), R.string.pspdf__electronic_signature_clear_signature, this);
        strA.getClass();
        this.r = strA;
        this.w = -1;
        this.p = uc.a(getResources(), R.dimen.pspdf__electronic_signature_dialog_width, R.dimen.pspdf__electronic_signature_dialog_height);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(this.o.u);
        paint.setTextSize((int) TypedValue.applyDimension(2, 16.0f, context.getResources().getDisplayMetrics()));
        paint.setTextAlign(Paint.Align.CENTER);
    }

    public static final class b extends e.c {
        public static final Parcelable.Creator<b> CREATOR = new a();
        public final Parcelable d;
        public int e;

        public static final class a implements Parcelable.Creator<b> {
            @Override // android.os.Parcelable.Creator
            public final b createFromParcel(Parcel parcel) {
                parcel.getClass();
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final b[] newArray(int i) {
                return new b[i];
            }
        }

        public b(e.c cVar) {
            super(View.BaseSavedState.EMPTY_STATE);
            this.e = -1;
            this.d = cVar;
        }

        @Override // com.pspdfkit.internal.ui.dialog.signatures.e.c, android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.getClass();
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.d, i);
            parcel.writeInt(this.e);
        }

        public b(Parcel parcel) {
            super(parcel);
            this.e = -1;
            this.d = ParcelExtensions.readSupportParcelable(parcel, e.c.class.getClassLoader(), e.c.class);
            this.e = parcel.readInt();
        }
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public final void a(MotionEvent motionEvent) {
        if (this.m || motionEvent.getY() <= getHeight() - h()) {
            return;
        }
        c();
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public final float a() {
        return getHeight() - h();
    }

    @Override // com.pspdfkit.internal.ui.dialog.signatures.e
    public final void a(Canvas canvas) {
        canvas.getClass();
        canvas.drawText(this.r, getWidth() / 2, b(), this.q);
    }

    public static Single a(final String str, final Font font, final int i, final DisplayMetrics displayMetrics) {
        final float f = 1.0f;
        Single singleFromCallable = Single.fromCallable(new Callable() { // from class: com.pspdfkit.internal.ui.dialog.signatures.TypingElectronicSignatureCanvasView$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return TypingElectronicSignatureCanvasView.a(str, font, i, f, displayMetrics);
            }
        });
        singleFromCallable.getClass();
        return singleFromCallable;
    }

    public static final Bitmap a(String str, Font font, int i, float f, DisplayMetrics displayMetrics) {
        return Signature.INSTANCE.textToBitmap(str, font, i, f, displayMetrics);
    }

    public /* synthetic */ TypingElectronicSignatureCanvasView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
