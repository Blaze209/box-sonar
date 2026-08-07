package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationFlags;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.annotations.FreeTextAnnotation;
import com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.ui.overlay.OverlayLayoutParams;
import com.pspdfkit.utils.PageRect;
import com.pspdfkit.utils.Size;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ObservableProperty;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes3.dex */
public final class li extends f7 implements z4<FreeTextAnnotation>, zs {
    public static final /* synthetic */ KProperty<Object>[] y = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(li.class, "applyAnnotationAlpha", "getApplyAnnotationAlpha()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(li.class, "drawBackground", "getDrawBackground()Z", 0))};
    public static final float z = o50.a[0];
    public final PdfDocument j;
    public final PdfConfiguration k;
    public final AnnotationConfigurationRegistry l;
    public at m;
    public final ft<FreeTextAnnotation> n;
    public FreeTextAnnotation o;
    public boolean p;
    public i3 q;
    public Disposable r;
    public Runnable s;
    public boolean t;
    public boolean u;
    public Job v;
    public final c w;
    public final d x;

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[FreeTextAnnotation.FreeTextTextJustification.values().length];
            try {
                iArr[FreeTextAnnotation.FreeTextTextJustification.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FreeTextAnnotation.FreeTextTextJustification.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FreeTextAnnotation.FreeTextTextJustification.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.views.annotations.FreeTextAnnotationView$exitWritingMode$1", f = "FreeTextAnnotationView.kt", i = {}, l = {376}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ FreeTextAnnotation c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FreeTextAnnotation freeTextAnnotation, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = freeTextAnnotation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return li.this.new b(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return li.this.new b(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnnotationProvider annotationProvider = li.this.j.getAnnotationProvider();
                FreeTextAnnotation freeTextAnnotation = this.c;
                this.a = 1;
                if (annotationProvider.removeAnnotationFromPage(freeTextAnnotation, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class c extends ObservableProperty<Boolean> {
        public final /* synthetic */ li a;

        /* JADX WARN: Illegal instructions before constructor call */
        public c(li liVar) {
            Boolean bool = Boolean.TRUE;
            this.a = liVar;
            super(bool);
        }

        @Override // kotlin.properties.ObservableProperty
        public final void afterChange(KProperty<?> kProperty, Boolean bool, Boolean bool2) {
            FreeTextAnnotation freeTextAnnotation;
            kProperty.getClass();
            if (Intrinsics.areEqual(bool, bool2)) {
                return;
            }
            boolean zBooleanValue = bool2.booleanValue();
            li liVar = this.a;
            liVar.setAlpha((!zBooleanValue || (freeTextAnnotation = liVar.o) == null) ? 1.0f : freeTextAnnotation.getAlpha());
        }
    }

    public static final class d extends ObservableProperty<Boolean> {
        public final /* synthetic */ li a;

        /* JADX WARN: Illegal instructions before constructor call */
        public d(li liVar) {
            Boolean bool = Boolean.TRUE;
            this.a = liVar;
            super(bool);
        }

        @Override // kotlin.properties.ObservableProperty
        public final void afterChange(KProperty<?> kProperty, Boolean bool, Boolean bool2) {
            kProperty.getClass();
            if (Intrinsics.areEqual(bool, bool2)) {
                return;
            }
            bool2.getClass();
            li liVar = this.a;
            liVar.setBackgroundColor(liVar.getDrawBackground() ? liVar.getAnnotationBackgroundColor() : 0);
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.views.annotations.FreeTextAnnotationView$updateEditTextFromBoundAnnotation$1", f = "FreeTextAnnotationView.kt", i = {}, l = {337}, m = "invokeSuspend", n = {}, nl = {338}, s = {}, v = 2)
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ FreeTextAnnotation b;
        public final /* synthetic */ li c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(FreeTextAnnotation freeTextAnnotation, li liVar, Continuation<? super e> continuation) {
            super(2, continuation);
            this.b = freeTextAnnotation;
            this.c = liVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new e(this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new e(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                e50 e50VarC = ar.c();
                FreeTextAnnotation freeTextAnnotation = this.b;
                this.a = 1;
                e50VarC.getClass();
                obj = BuildersKt.withContext(e50.f.getValue(), new g50(e50VarC, freeTextAnnotation, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Typeface typeface = (Typeface) obj;
            if (typeface != null) {
                this.c.setTypeface(typeface);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public li(Context context, PdfDocument pdfDocument, PdfConfiguration pdfConfiguration, AnnotationConfigurationRegistry annotationConfigurationRegistry) {
        super(context);
        context.getClass();
        pdfDocument.getClass();
        pdfConfiguration.getClass();
        annotationConfigurationRegistry.getClass();
        this.j = pdfDocument;
        this.k = pdfConfiguration;
        this.l = annotationConfigurationRegistry;
        this.n = new ft<>(this);
        this.t = true;
        setWillNotDraw(false);
        setGravity(1);
        this.w = new c(this);
        this.x = new d(this);
    }

    @Override // com.pspdfkit.internal.z4
    public final View a() {
        return this;
    }

    public final void a(String str) {
        DynamicLayout dynamicLayoutA;
        if (this.g) {
            this.u = false;
            setText(str);
            return;
        }
        if (getLayout() == null || str == null || getMeasuredHeight() <= 0) {
            this.u = false;
            setText(str);
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        FreeTextAnnotation freeTextAnnotation = this.o;
        if (freeTextAnnotation != null) {
            TextPaint paint = getPaint();
            paint.getClass();
            dynamicLayoutA = ji.a(freeTextAnnotation, spannableStringBuilder, paint, getLayout().getWidth());
        } else {
            dynamicLayoutA = null;
        }
        if (dynamicLayoutA == null) {
            return;
        }
        boolean z2 = false;
        while (str.length() > 0 && dynamicLayoutA.getLineCount() != 1 && dynamicLayoutA.getHeight() >= getMeasuredHeight()) {
            str = str.subSequence(0, str.length() - 1).toString();
            spannableStringBuilder.replace(0, spannableStringBuilder.length(), (CharSequence) str);
            z2 = true;
        }
        this.u = z2;
        setText(str);
    }

    @Override // com.pspdfkit.internal.z4
    public final void b() {
        if (this.p) {
            return;
        }
        FreeTextAnnotation annotation = getAnnotation();
        this.t = (annotation == null || annotation.hasFlag(AnnotationFlags.NOZOOM)) ? false : true;
        o();
    }

    @Override // com.pspdfkit.internal.z4
    public final boolean b(boolean z2) {
        return z2;
    }

    @Override // com.pspdfkit.internal.z4
    public final boolean e() {
        if (this.o == null) {
            return false;
        }
        super.c();
        FreeTextAnnotation freeTextAnnotation = this.o;
        a(freeTextAnnotation != null ? freeTextAnnotation.getContents() : null);
        Editable text = getText();
        setSelection(text != null ? text.length() : 0);
        return true;
    }

    @Override // com.pspdfkit.internal.z4
    public final void f() throws InterruptedException {
        j();
        i3 i3Var = this.q;
        if (i3Var != null) {
            i3Var.c();
        }
        this.q = null;
    }

    public final int getAnnotationBackgroundColor() {
        FreeTextAnnotation freeTextAnnotation = this.o;
        if (freeTextAnnotation == null) {
            return 0;
        }
        Integer numValueOf = Integer.valueOf(freeTextAnnotation.getFillColor());
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return ff.a(numValueOf.intValue(), this.k.isToGrayscale(), this.k.isInvertColors());
        }
        return 0;
    }

    public final boolean getApplyAnnotationAlpha() {
        return this.w.getValue(this, y[0]).booleanValue();
    }

    @Override // com.pspdfkit.internal.f7
    public RectF getBoundingBox() {
        RectF boundingBox;
        FreeTextAnnotation freeTextAnnotation = this.o;
        return (freeTextAnnotation == null || (boundingBox = freeTextAnnotation.getBoundingBox()) == null) ? new RectF() : boundingBox;
    }

    @Override // com.pspdfkit.internal.z4
    public /* bridge */ /* synthetic */ l1 getContentScaler() {
        return super.getContentScaler();
    }

    public final boolean getCurrentlyChangingText() {
        return this.p;
    }

    public final boolean getDrawBackground() {
        return this.x.getValue(this, y[1]).booleanValue();
    }

    public final at getOnEditRecordedListener() {
        return this.m;
    }

    @Override // com.pspdfkit.internal.z4
    public /* bridge */ /* synthetic */ PageRect getPageRect() {
        return super.getPageRect();
    }

    @Override // com.pspdfkit.internal.f7
    public Matrix getPdfToViewMatrix() {
        if (!this.t) {
            return new Matrix();
        }
        Matrix pdfToViewMatrix = super.getPdfToViewMatrix();
        pdfToViewMatrix.getClass();
        return pdfToViewMatrix;
    }

    @Override // com.pspdfkit.internal.z4
    public final boolean i() throws InterruptedException {
        j();
        FreeTextAnnotation freeTextAnnotation = this.o;
        boolean z2 = false;
        if (freeTextAnnotation == null) {
            return false;
        }
        String strValueOf = getText() != null ? String.valueOf(getText()) : "";
        boolean z3 = true;
        boolean z4 = this.s != null;
        if (!TextUtils.equals(freeTextAnnotation.getContents(), strValueOf) && !z4 && this.g) {
            freeTextAnnotation.setContents(strValueOf);
            z2 = true;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.getClass();
        OverlayLayoutParams overlayLayoutParams = (OverlayLayoutParams) layoutParams;
        if (Intrinsics.areEqual(freeTextAnnotation.getBoundingBox(), overlayLayoutParams.pageRect.getPageRect())) {
            z3 = z2;
        } else {
            RectF pageRect = overlayLayoutParams.pageRect.getPageRect();
            pageRect.getClass();
            freeTextAnnotation.setBoundingBox(pageRect);
        }
        freeTextAnnotation.getInternal().removeOnAnnotationPropertyChangeListener(this);
        return z3;
    }

    @Override // com.pspdfkit.internal.f7
    public final void j() throws InterruptedException {
        String contents;
        boolean z2 = this.g;
        super.j();
        FreeTextAnnotation freeTextAnnotation = this.o;
        String contents2 = freeTextAnnotation != null ? freeTextAnnotation.getContents() : null;
        if (!z2 || freeTextAnnotation == null || (contents = freeTextAnnotation.getContents()) == null || contents.length() != 0) {
            a(contents2);
        } else {
            BuildersKt__BuildersKt.runBlocking$default(null, new b(freeTextAnnotation, null), 1, null);
        }
    }

    @Override // com.pspdfkit.internal.z4
    public final void m() {
        FreeTextAnnotation freeTextAnnotation = this.o;
        a(freeTextAnnotation != null ? freeTextAnnotation.getContents() : null);
    }

    @Override // com.pspdfkit.internal.z4
    public final void n() {
        setLayoutParams(b5.a(this, false));
    }

    public final void o() {
        FreeTextAnnotation freeTextAnnotation = this.o;
        if (freeTextAnnotation == null) {
            return;
        }
        setRotation(freeTextAnnotation.getRotation());
        float textSize = freeTextAnnotation.getTextSize();
        setTextColor(ff.a(freeTextAnnotation.getColor(), this.k.isToGrayscale(), this.k.isInvertColors()));
        if (getApplyAnnotationAlpha()) {
            setAlpha(freeTextAnnotation.getAlpha());
        }
        Job job = this.v;
        int i = 1;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.v = null;
        this.v = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new e(freeTextAnnotation, this, null), 3, null);
        setBackgroundColor(getDrawBackground() ? getAnnotationBackgroundColor() : 0);
        int i2 = a.a[freeTextAnnotation.getTextJustification().ordinal()];
        if (i2 == 1) {
            i = 3;
        } else if (i2 != 2) {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i = 5;
        }
        setGravity(g7.a(freeTextAnnotation.getVerticalTextAlignment()) | i);
        int iFloor = (int) Math.floor(s60.a(getPdfToViewMatrix()) * ji.a(freeTextAnnotation.getBorderWidth()));
        setPadding(iFloor, iFloor, iFloor, iFloor);
        setLineSpacing(0.0f, ji.a(freeTextAnnotation));
        setTextSize(0, s60.a(getPdfToViewMatrix()) * textSize);
    }

    @Override // com.pspdfkit.internal.zs
    public final synchronized void onAnnotationPropertyChange(Annotation annotation, int i, Object obj, final Object obj2) {
        FreeTextAnnotation freeTextAnnotation;
        annotation.getClass();
        if (!this.p && (freeTextAnnotation = this.o) != null && Intrinsics.areEqual(annotation, freeTextAnnotation)) {
            if (i != 3) {
                if (i == 9 && obj != null && obj2 != null) {
                    RectF rectF = (RectF) obj;
                    RectF rectF2 = (RectF) obj2;
                    if (rectF2.width() < rectF.width() || (-rectF2.height()) < (-rectF.height())) {
                        freeTextAnnotation.getInternal().clearTextShouldFit();
                    }
                }
            } else if (obj2 != null && !Intrinsics.areEqual(getText(), obj2)) {
                i3 i3Var = this.q;
                if (i3Var != null) {
                    i3Var.c();
                }
                this.q = null;
                Runnable runnable = this.s;
                if (runnable != null) {
                    removeCallbacks(runnable);
                }
                Runnable runnable2 = new Runnable() { // from class: com.pspdfkit.internal.li$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        li.a(this.f$0, obj2);
                    }
                };
                this.s = runnable2;
                post(runnable2);
            }
        }
    }

    @Override // com.pspdfkit.internal.f7, android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z2) {
        view.getClass();
        if (this.g || !z2) {
            super.onFocusChange(view, z2);
        } else {
            setKeyboardVisible(false);
        }
    }

    @Override // com.pspdfkit.internal.f7, android.widget.TextView, android.view.View
    public final void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        o();
    }

    @Override // com.pspdfkit.internal.f7, android.widget.TextView, android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        charSequence.getClass();
        super.onTextChanged(charSequence, i, i2, i3);
        FreeTextAnnotation freeTextAnnotation = this.o;
        if (freeTextAnnotation == null || this.u) {
            return;
        }
        at atVar = this.m;
        if (this.q == null && atVar != null) {
            i3 i3Var = new i3(CollectionsKt.listOf(freeTextAnnotation), atVar);
            this.q = i3Var;
            i3Var.b();
        }
        yz.a(this.r);
        this.r = Observable.timer(300L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new mi(this));
        String string = charSequence.toString();
        if (Intrinsics.areEqual(string, freeTextAnnotation.getContents())) {
            return;
        }
        this.p = true;
        getPaint().setTextSize(freeTextAnnotation.getTextSize());
        StringsKt.contains$default((CharSequence) string, (CharSequence) "\n", false, 2, (Object) null);
        AnnotationConfigurationRegistry annotationConfigurationRegistry = this.l;
        Size pageSize = this.j.getPageSize(freeTextAnnotation.getPageIndex());
        pageSize.getClass();
        ji.a(freeTextAnnotation, annotationConfigurationRegistry, pageSize, getPaint(), string);
        freeTextAnnotation.setContents(string);
        this.p = false;
        setLayoutParams(b5.a(this, false));
    }

    @Override // com.pspdfkit.internal.f7, com.pspdfkit.internal.nx
    public final void recycle() {
        bm internal;
        super.recycle();
        FreeTextAnnotation freeTextAnnotation = this.o;
        if (freeTextAnnotation != null && (internal = freeTextAnnotation.getInternal()) != null) {
            internal.removeOnAnnotationPropertyChangeListener(this);
        }
        this.o = null;
        Job job = this.v;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.v = null;
        this.p = false;
        this.m = null;
        i3 i3Var = this.q;
        if (i3Var != null) {
            i3Var.c();
        }
        this.q = null;
        yz.a(this.r);
        this.r = null;
        this.n.b.clear();
    }

    public final void setApplyAnnotationAlpha(boolean z2) {
        this.w.setValue(this, y[0], Boolean.valueOf(z2));
    }

    public final void setDrawBackground(boolean z2) {
        this.x.setValue(this, y[1], Boolean.valueOf(z2));
    }

    public final void setOnEditRecordedListener(at atVar) {
        this.m = atVar;
    }

    @Override // com.pspdfkit.internal.z4
    public FreeTextAnnotation getAnnotation() {
        return this.o;
    }

    @Override // com.pspdfkit.internal.z4
    public void setAnnotation(FreeTextAnnotation freeTextAnnotation) {
        bm internal;
        freeTextAnnotation.getClass();
        if (Intrinsics.areEqual(freeTextAnnotation, this.o)) {
            return;
        }
        FreeTextAnnotation freeTextAnnotation2 = this.o;
        this.o = freeTextAnnotation;
        Job job = this.v;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.v = null;
        if (freeTextAnnotation2 != null && (internal = freeTextAnnotation2.getInternal()) != null) {
            internal.removeOnAnnotationPropertyChangeListener(this);
        }
        freeTextAnnotation.getInternal().addOnAnnotationPropertyChangeListener(this);
        getPaint().setTextSize(freeTextAnnotation.getTextSize());
        setLayoutParams(new OverlayLayoutParams(freeTextAnnotation.getBoundingBox(), OverlayLayoutParams.SizingMode.LAYOUT));
        a(freeTextAnnotation.getContents());
        FreeTextAnnotation freeTextAnnotation3 = this.o;
        if (freeTextAnnotation3 != null) {
            float textSize = freeTextAnnotation3.getTextSize();
            if (freeTextAnnotation3.isAttached()) {
                Size sizeA = ji.a(freeTextAnnotation3, new RectF());
                if (freeTextAnnotation3.getIntent() == FreeTextAnnotation.FreeTextAnnotationIntent.FREE_TEXT_CALLOUT && (((int) getRotation()) == 270 || ((int) getRotation()) == 90)) {
                    sizeA = new Size(sizeA.height, sizeA.width);
                }
                TextPaint textPaint = new TextPaint(getPaint());
                if (freeTextAnnotation3.getInternal().getTextShouldFit()) {
                    do {
                        float f = sizeA.width;
                        float f2 = sizeA.height;
                        textPaint.setTextSize(textSize);
                        float fCeil = (float) Math.ceil(f);
                        float fCeil2 = (float) Math.ceil(f2);
                        Size sizeA2 = ji.a(freeTextAnnotation3, fCeil, textPaint, (String) null);
                        if (sizeA2.width <= fCeil && sizeA2.height <= fCeil2) {
                            break;
                        } else {
                            textSize -= 0.5f;
                        }
                    } while (textSize > z);
                } else {
                    float f3 = sizeA.width;
                    float f4 = sizeA.height;
                    textPaint.setTextSize(textSize);
                    float fCeil3 = (float) Math.ceil(f3);
                    float fCeil4 = (float) Math.ceil(f4);
                    Size sizeA3 = ji.a(freeTextAnnotation3, fCeil3, textPaint, (String) null);
                    if (sizeA3.width <= fCeil3 && sizeA3.height <= fCeil4) {
                        freeTextAnnotation3.getInternal().setTextShouldFit(true);
                    }
                }
                RangesKt.coerceAtLeast(textSize, z);
            }
        }
        b();
        this.n.a();
    }

    @Override // com.pspdfkit.internal.f7, com.pspdfkit.internal.z4
    public final void a(Matrix matrix, float f) {
        matrix.getClass();
        if (Intrinsics.areEqual(getPdfToViewMatrix(), matrix)) {
            return;
        }
        this.b.set(matrix);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.pspdfkit.internal.z4
    public final void a(z4.a<FreeTextAnnotation> aVar) {
        aVar.getClass();
        this.n.b.a(aVar);
        if (this.o != null) {
            this.n.a();
        }
    }

    public static final void a(li liVar, Object obj) {
        liVar.s = null;
        liVar.a(obj.toString());
        Editable text = liVar.getText();
        liVar.setSelection(text != null ? text.length() : 0);
    }
}
