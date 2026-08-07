package com.pspdfkit.internal;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.method.DigitsKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowMetrics;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.GravityCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.microsoft.intune.mam.client.widget.MAMPopupWindow;
import com.microsoft.intune.mam.client.widget.MAMTextView;
import com.pspdfkit.R;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.VerticalTextAlignment;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.annotations.actions.AnnotationTriggerEvent;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.forms.TextFormElement;
import com.pspdfkit.forms.TextInputFormat;
import com.pspdfkit.ui.overlay.OverlayLayoutParams;
import com.pspdfkit.ui.special_mode.controller.FormEditingController;
import com.pspdfkit.ui.special_mode.controller.FormElementViewController;
import com.pspdfkit.ui.special_mode.manager.FormManager;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes3.dex */
public final class q50 extends f7 implements uh<TextFormElement>, FormElementViewController {
    public static final /* synthetic */ int O = 0;
    public String A;
    public final CoroutineScope B;
    public Job C;
    public boolean D;
    public float E;
    public float F;
    public final LruCache<String, Integer> G;
    public List<String> H;
    public final ArrayList I;
    public final LruCache<String, List<String>> J;
    public String K;
    public PopupWindow L;
    public c M;
    public int N;
    public final ci j;
    public final int k;
    public final vh l;
    public final int m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final xh q;
    public final ShapeDrawable r;
    public TextFormElement s;
    public ColorDrawable t;
    public final Drawable u;
    public Runnable v;
    public String w;
    public FormEditingController x;
    public float y;
    public final b z;

    public static final class a extends ListView {
        public int a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(context);
            context.getClass();
            this.a = Integer.MAX_VALUE;
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
        public final void onMeasure(int i, int i2) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.a, Integer.MIN_VALUE));
        }
    }

    public final class b extends x20 {
        public String a;

        public b() {
        }

        @Override // com.pspdfkit.internal.dn
        public final bn a(String str, String str2) {
            str.getClass();
            str2.getClass();
            if (!q50.this.isAttachedToWindow()) {
                return null;
            }
            this.a = str2;
            return bn.OK;
        }
    }

    public static final class c extends ArrayAdapter<String> {
        public c(Context context, ArrayList arrayList) {
            super(context, 0, arrayList);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public final View getView(int i, View view, ViewGroup viewGroup) {
            TextView mAMTextView;
            viewGroup.getClass();
            if (view instanceof TextView) {
                mAMTextView = (TextView) view;
            } else {
                mAMTextView = new MAMTextView(getContext());
                mAMTextView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                Context context = mAMTextView.getContext();
                context.getClass();
                float f = 16;
                int iA = (int) un.a(context, 1, f);
                Context context2 = mAMTextView.getContext();
                context2.getClass();
                float f2 = 12;
                int iA2 = (int) un.a(context2, 1, f2);
                Context context3 = mAMTextView.getContext();
                context3.getClass();
                int iApplyDimension = (int) TypedValue.applyDimension(1, f, context3.getResources().getDisplayMetrics());
                Context context4 = mAMTextView.getContext();
                context4.getClass();
                mAMTextView.setPadding(iA, iA2, iApplyDimension, (int) TypedValue.applyDimension(1, f2, context4.getResources().getDisplayMetrics()));
                mAMTextView.setGravity(16);
                mAMTextView.setTextSize(2, 16.0f);
            }
            String item = getItem(i);
            if (item == null) {
                item = "";
            }
            mAMTextView.setText(item);
            mAMTextView.setTextColor(q50.this.N);
            return mAMTextView;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.views.forms.TextFormElementView", f = "TextFormElementView.kt", i = {}, l = {341}, m = "disableAndApplyChanges", n = {}, nl = {342}, s = {}, v = 2)
    public static final class d extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int c;

        public d(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return q50.this.a(this);
        }
    }

    public static final class e implements zs {
        public final /* synthetic */ TextFormElement b;

        public e(TextFormElement textFormElement) {
            this.b = textFormElement;
        }

        @Override // com.pspdfkit.internal.zs
        public final void onAnnotationPropertyChange(Annotation annotation, int i, Object obj, Object obj2) {
            annotation.getClass();
            if (i == 1002 && !Intrinsics.areEqual(obj2, obj) && obj2 != null) {
                q50.this.setViewTextSizeFromAnnotationFontSize(((Float) obj2).floatValue());
            }
            if (i != 1006 || Intrinsics.areEqual(obj2, obj) || obj2 == null || !this.b.isMultiLine()) {
                return;
            }
            q50.this.setGravity(g7.a((VerticalTextAlignment) obj2) | GravityCompat.START);
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.views.forms.TextFormElementView$updateFormElement$1", f = "TextFormElementView.kt", i = {}, l = {350}, m = "invokeSuspend", n = {}, nl = {351}, s = {}, v = 2)
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, Continuation<? super f> continuation) {
            super(2, continuation);
            this.c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return q50.this.new f(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return q50.this.new f(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                q50 q50Var = q50.this;
                String str = this.c;
                this.a = 1;
                int i2 = q50.O;
                obj = q50Var.a(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            q50 q50Var2 = q50.this;
            b bVar = q50Var2.z;
            if (zBooleanValue) {
                bVar.a = null;
                q50Var2.setErrorMessage(null);
            } else {
                String str2 = bVar.a;
                if (str2 != null) {
                    q50Var2.setErrorMessage(str2);
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q50(Context context, PdfConfiguration pdfConfiguration, ci ciVar, int i, vh vhVar) {
        super(context);
        context.getClass();
        pdfConfiguration.getClass();
        ciVar.getClass();
        vhVar.getClass();
        this.j = ciVar;
        this.k = i;
        this.l = vhVar;
        this.m = pdfConfiguration.getBackgroundColor();
        this.n = pdfConfiguration.isInvertColors();
        this.o = pdfConfiguration.isToGrayscale();
        this.p = pdfConfiguration.isFormElementDateAndTimePickerEnabled();
        this.q = new xh();
        this.r = new ShapeDrawable(new RectShape());
        this.u = a80.a(context, R.drawable.pspdf__ic_input_error, ContextCompat.getColor(context, R.color.pspdf__errorContainerLight));
        this.z = new b();
        this.B = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.D = true;
        this.G = new LruCache<>(25);
        this.H = CollectionsKt.emptyList();
        this.I = new ArrayList();
        this.J = new LruCache<>(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setErrorMessage(String str) {
        boolean zEquals;
        String str2 = this.A;
        Charset charset = u40.a;
        if (str2 == null && str == null) {
            zEquals = true;
        } else {
            zEquals = (str2 == null || str == null) ? false : str2.equals(str);
        }
        if (zEquals) {
            return;
        }
        this.A = str;
        if (this.u == null || str == null) {
            setCompoundDrawablesRelative(null, null, null, null);
        } else {
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            this.u.setBounds(0, 0, height, height);
            setCompoundDrawablesRelative(null, null, this.u, null);
        }
        TextFormElement formElement = getFormElement();
        if (formElement == null) {
            return;
        }
        vh vhVar = this.l;
        if (str != null) {
            yh yhVar = (yh) vhVar;
            yhVar.getClass();
            yh.a();
            Iterator<FormManager.OnFormElementViewUpdatedListener> it = yhVar.f.iterator();
            while (it.hasNext()) {
                it.next().onFormElementValidationFailed(formElement, str);
            }
            return;
        }
        yh yhVar2 = (yh) vhVar;
        yhVar2.getClass();
        yh.a();
        Iterator<FormManager.OnFormElementViewUpdatedListener> it2 = yhVar2.f.iterator();
        while (it2.hasNext()) {
            it2.next().onFormElementValidationSuccess(formElement);
        }
    }

    private final void setSuppressJavaScriptAlerts(boolean z) {
        lm internalDocument;
        TextFormElement formElement = getFormElement();
        if (formElement == null || (internalDocument = formElement.getAnnotation().getInternal().getInternalDocument()) == null) {
            return;
        }
        an anVar = internalDocument.l;
        b bVar = this.z;
        if (z) {
            anVar.getClass();
            bVar.getClass();
            or orVar = anVar.b;
            orVar.getClass();
            orVar.a.addFirst(bVar);
            return;
        }
        anVar.getClass();
        bVar.getClass();
        or orVar2 = anVar.b;
        orVar2.getClass();
        orVar2.a.b(bVar);
    }

    private final void setUpWidgetAnnotationObserver(TextFormElement textFormElement) {
        WidgetAnnotation annotation = textFormElement.getAnnotation();
        annotation.getClass();
        annotation.getInternal().addOnAnnotationPropertyChangeListener(new e(textFormElement));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setViewTextSizeFromAnnotationFontSize(float f2) {
        String string;
        TextFormElement formElement = getFormElement();
        if (formElement == null) {
            return;
        }
        if (f2 == 0.0f) {
            Editable text = getText();
            if (text == null || (string = text.toString()) == null) {
                string = "";
            }
            f2 = a(formElement, string);
        }
        setTextSize(0, s60.a(getPdfToViewMatrix()) * f2);
    }

    @Override // com.pspdfkit.internal.uh
    public final View a() {
        return this;
    }

    public final void b(String str) {
        Job job = this.C;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.C = null;
        if (getFormElement() != null) {
            TextFormElement formElement = getFormElement();
            String text = formElement != null ? formElement.getText() : null;
            Charset charset = u40.a;
            if (!Intrinsics.areEqual(str, text == null ? "" : text.toString())) {
                this.C = BuildersKt__Builders_commonKt.launch$default(this.B, null, null, new f(str, null), 3, null);
                return;
            }
        }
        this.z.a = null;
        setErrorMessage(null);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.FormElementViewController
    public final boolean canClearFormField() {
        String string;
        Editable text = getText();
        return (text == null || (string = text.toString()) == null || string.length() <= 0) ? false : true;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.FormElementViewController
    public final boolean clearFormField() {
        if (!canClearFormField()) {
            return false;
        }
        setText("");
        b("");
        return true;
    }

    @Override // com.pspdfkit.internal.uh
    public final void d() {
        j();
        setSuppressJavaScriptAlerts(false);
        PopupWindow popupWindow = this.L;
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
        CoroutineScopeKt.cancel$default(this.B, null, 1, null);
    }

    @Override // com.pspdfkit.internal.uh
    public final void g() {
    }

    @Override // com.pspdfkit.internal.f7
    public RectF getBoundingBox() {
        WidgetAnnotation annotation;
        RectF boundingBox;
        TextFormElement formElement = getFormElement();
        return (formElement == null || (annotation = formElement.getAnnotation()) == null || (boundingBox = annotation.getBoundingBox()) == null) ? new RectF() : boundingBox;
    }

    @Override // com.pspdfkit.internal.f7
    public final void j() {
        super.j();
        Runnable runnable = this.v;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.v = null;
        setBackgroundColor(ff.a(this.m, this.o, this.n));
        this.t = new ColorDrawable(ff.a(this.j.a, this.o, this.n));
        p();
        PopupWindow popupWindow = this.L;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        popupWindow.dismiss();
    }

    @Override // com.pspdfkit.internal.uh
    public final void l() {
        super.c();
        int i = this.j.d;
        if (i != 0) {
            ColorDrawable colorDrawable = new ColorDrawable(ff.a(i, this.o, this.n));
            setBackground(Color.alpha(this.j.d) == 255 ? new LayerDrawable(new ColorDrawable[]{new ColorDrawable(ff.a(-1, this.o, this.n)), colorDrawable}) : new LayerDrawable(new Drawable[]{colorDrawable}));
            q();
            TextFormElement formElement = getFormElement();
            if (formElement != null && !this.H.isEmpty()) {
                yh yhVar = (yh) this.l;
                yhVar.getClass();
                yh.a();
                Iterator<FormManager.OnTextFormElementSuggestionRequestListener> it = yhVar.g.iterator();
                while (it.hasNext()) {
                    if (it.next().shouldShowSuggestionsImmediately(formElement)) {
                        r();
                        break;
                    }
                }
            }
        }
        setSuppressJavaScriptAlerts(true);
    }

    public final void o() {
        float fA;
        int iMax;
        Context context = getContext();
        context.getClass();
        a aVar = new a(context);
        try {
            Context context2 = getContext();
            Activity activity = context2 instanceof Activity ? (Activity) context2 : null;
            if (activity == null) {
                Context context3 = getContext();
                context3.getClass();
                fA = TypedValue.applyDimension(1, 200, context3.getResources().getDisplayMetrics());
                iMax = (int) fA;
            } else {
                WindowMetrics currentWindowMetrics = activity.getWindowManager().getCurrentWindowMetrics();
                currentWindowMetrics.getClass();
                int iHeight = currentWindowMetrics.getBounds().height();
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                int height = iHeight - (iArr[1] + getHeight());
                Context context4 = getContext();
                context4.getClass();
                int iApplyDimension = height - ((int) TypedValue.applyDimension(1, 100, context4.getResources().getDisplayMetrics()));
                Context context5 = getContext();
                context5.getClass();
                int iApplyDimension2 = iApplyDimension - ((int) TypedValue.applyDimension(1, 20, context5.getResources().getDisplayMetrics()));
                Context context6 = getContext();
                context6.getClass();
                int iApplyDimension3 = (int) TypedValue.applyDimension(1, 150, context6.getResources().getDisplayMetrics());
                Context context7 = getContext();
                context7.getClass();
                iMax = Math.max(iApplyDimension3, Math.min(iApplyDimension2, (int) TypedValue.applyDimension(1, 250, context7.getResources().getDisplayMetrics())));
            }
        } catch (Exception unused) {
            Context context8 = getContext();
            context8.getClass();
            fA = un.a(context8, 1, 200);
        }
        aVar.a = iMax;
        aVar.setBackgroundColor(this.j.h);
        aVar.setDivider(null);
        Context context9 = getContext();
        context9.getClass();
        float f2 = 8;
        int iA = (int) un.a(context9, 1, f2);
        Context context10 = getContext();
        context10.getClass();
        float f3 = 4;
        int iA2 = (int) un.a(context10, 1, f3);
        Context context11 = getContext();
        context11.getClass();
        int iApplyDimension4 = (int) TypedValue.applyDimension(1, f2, context11.getResources().getDisplayMetrics());
        Context context12 = getContext();
        context12.getClass();
        aVar.setPadding(iA, iA2, iApplyDimension4, (int) TypedValue.applyDimension(1, f3, context12.getResources().getDisplayMetrics()));
        MAMPopupWindow mAMPopupWindow = new MAMPopupWindow(aVar, -2, -2);
        mAMPopupWindow.setFocusable(false);
        mAMPopupWindow.setOutsideTouchable(true);
        Context context13 = getContext();
        context13.getClass();
        mAMPopupWindow.setElevation((int) TypedValue.applyDimension(1, f3, context13.getResources().getDisplayMetrics()));
        this.L = mAMPopupWindow;
        this.N = this.j.i;
        c cVar = new c(getContext(), this.I);
        this.M = cVar;
        aVar.setAdapter((ListAdapter) cVar);
        aVar.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.pspdfkit.internal.q50$$ExternalSyntheticLambda4
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                q50.a(this.f$0, adapterView, view, i, j);
            }
        });
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public final void onChangeFormElementEditingMode(FormEditingController formEditingController) {
        formEditingController.getClass();
        this.x = formEditingController;
        if (formEditingController != null) {
            formEditingController.bindFormElementViewController(this);
        }
        xh xhVar = this.q;
        xhVar.getClass();
        formEditingController.getClass();
        xhVar.b = formEditingController;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.getClass();
        super.onDraw(canvas);
        ColorDrawable colorDrawable = this.t;
        if (colorDrawable != null) {
            colorDrawable.setBounds(getScrollX(), getScrollY(), getWidth() + getScrollX(), getHeight() + getScrollY());
            colorDrawable.draw(canvas);
        }
        float f2 = this.y;
        if (f2 > 0.0f) {
            int i = (int) (f2 / 2);
            this.r.setBounds(getScrollX() - i, getScrollY() - i, getWidth() + getScrollX() + i, getHeight() + getScrollY() + i);
            this.r.draw(canvas);
        }
    }

    @Override // android.widget.TextView
    public final void onEditorAction(int i) {
        FormEditingController formEditingController;
        if (i == 6 && (formEditingController = this.x) != null) {
            if (formEditingController != null && formEditingController.getFragment().getConfiguration().isAutoSelectNextFormElementEnabled() && formEditingController.hasNextElement()) {
                formEditingController.selectNextFormElement();
            } else {
                FormEditingController formEditingController2 = this.x;
                if (formEditingController2 != null) {
                    formEditingController2.finishEditing();
                }
            }
        }
        super.onEditorAction(i);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public final void onEnterFormElementEditingMode(FormEditingController formEditingController) {
        formEditingController.getClass();
        this.x = formEditingController;
        if (formEditingController != null) {
            formEditingController.bindFormElementViewController(this);
        }
        xh xhVar = this.q;
        xhVar.getClass();
        formEditingController.getClass();
        xhVar.b = formEditingController;
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public final void onExitFormElementEditingMode(FormEditingController formEditingController) {
        formEditingController.getClass();
        FormEditingController formEditingController2 = this.x;
        if (formEditingController2 != null) {
            formEditingController2.unbindFormElementViewController();
        }
        this.x = null;
        xh xhVar = this.q;
        xhVar.getClass();
        formEditingController.getClass();
        xhVar.b = null;
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        keyEvent.getClass();
        return this.q.a(i, keyEvent) || super.onKeyDown(i, keyEvent);
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        keyEvent.getClass();
        return this.q.b(i, keyEvent) || super.onKeyUp(i, keyEvent);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005f  */
    @Override // com.pspdfkit.internal.f7, android.widget.TextView, android.text.TextWatcher
    public final void onTextChanged(final CharSequence charSequence, int i, int i2, int i3) {
        WidgetAnnotation annotation;
        charSequence.getClass();
        super.onTextChanged(charSequence, i, i2, i3);
        TextFormElement formElement = getFormElement();
        if (formElement != null) {
            yh yhVar = (yh) this.l;
            yhVar.getClass();
            yh.a();
            Iterator<FormManager.OnFormElementViewUpdatedListener> it = yhVar.f.iterator();
            while (it.hasNext()) {
                it.next().onFormElementViewUpdated(formElement);
            }
            Runnable runnable = this.v;
            if (runnable != null) {
                removeCallbacks(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: com.pspdfkit.internal.q50$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    q50.a(this.f$0, charSequence);
                }
            };
            this.v = runnable2;
            postDelayed(runnable2, 500L);
            if (this.p && getFormElement() != null) {
                TextFormElement formElement2 = getFormElement();
                TextInputFormat inputFormat = formElement2 != null ? formElement2.getInputFormat() : null;
                if (inputFormat != TextInputFormat.DATE && inputFormat != TextInputFormat.TIME) {
                    if (!this.H.isEmpty()) {
                        r();
                    }
                }
            } else if (!this.H.isEmpty() && this.g) {
                r();
            }
            TextFormElement formElement3 = getFormElement();
            if (Intrinsics.areEqual((formElement3 == null || (annotation = formElement3.getAnnotation()) == null) ? null : Float.valueOf(annotation.getFontSize()), 0.0f)) {
                setViewTextSizeFromAnnotationFontSize(formElement.getAnnotation().getFontSize());
            }
            if (getFormElement() == null) {
                return;
            }
            int iRound = Math.round(s60.a(getPdfToViewMatrix()) * Math.max(1.0f, 1.0f) * 1.5f);
            Object text = getText();
            if (text == null) {
                text = "";
            }
            TextFormElement formElement4 = getFormElement();
            setPadding(iRound, (formElement4 != null && formElement4.isMultiLine() && StringsKt.contains$default((CharSequence) text.toString(), (CharSequence) "\n", false, 2, (Object) null)) ? Math.round(s60.a(getPdfToViewMatrix()) * Math.max(1.0f, 1.0f) * 1.5f) : 0, iRound, 0);
        }
    }

    public final void p() {
        TextFormElement formElement = getFormElement();
        if (formElement == null) {
            return;
        }
        int i = this.j.d;
        int iArgb = Color.argb(255, Color.red(i), Color.green(i), Color.blue(i));
        setTextColor(ff.a(ColorUtils.calculateContrast(-16777216, iArgb) <= ColorUtils.calculateContrast(-1, iArgb) ? -1 : -16777216, this.o, this.n));
        setViewTextSizeFromAnnotationFontSize(formElement.getAnnotation().getFontSize());
        if (formElement.isMultiLine()) {
            VerticalTextAlignment verticalTextAlignment = formElement.getAnnotation().getVerticalTextAlignment();
            verticalTextAlignment.getClass();
            setGravity(g7.a(verticalTextAlignment) | GravityCompat.START);
            WidgetAnnotation annotation = formElement.getAnnotation();
            annotation.getClass();
            setLineSpacing(0.0f, ji.a(annotation));
        } else {
            setGravity(16);
        }
        int i2 = 0;
        if (getFormElement() != null) {
            int iRound = Math.round(s60.a(getPdfToViewMatrix()) * Math.max(1.0f, 1.0f) * 1.5f);
            Object text = getText();
            if (text == null) {
                text = "";
            }
            TextFormElement formElement2 = getFormElement();
            setPadding(iRound, (formElement2 != null && formElement2.isMultiLine() && StringsKt.contains$default((CharSequence) text.toString(), (CharSequence) "\n", false, 2, (Object) null)) ? Math.round(s60.a(getPdfToViewMatrix()) * Math.max(1.0f, 1.0f) * 1.5f) : 0, iRound, 0);
        }
        Paint paint = this.r.getPaint();
        if (paint != null) {
            paint.setStyle(Paint.Style.STROKE);
            float fA = s60.a(getPdfToViewMatrix()) * 2.0f;
            this.y = fA;
            paint.setStrokeWidth(fA);
            if (formElement.isRequired()) {
                i2 = this.j.f;
            } else if (this.g) {
                i2 = this.j.e;
            } else {
                this.y = 0.0f;
            }
            paint.setColor(ff.a(i2, this.o, this.n));
        }
    }

    public final void q() {
        List<String> listOnTextFormElementGetSuggestions;
        TextFormElement formElement = getFormElement();
        if (formElement == null) {
            return;
        }
        if (this.p && getFormElement() != null) {
            TextFormElement formElement2 = getFormElement();
            TextInputFormat inputFormat = formElement2 != null ? formElement2.getInputFormat() : null;
            if (inputFormat == TextInputFormat.DATE || inputFormat == TextInputFormat.TIME) {
                return;
            }
        }
        yh yhVar = (yh) this.l;
        yhVar.getClass();
        yh.a();
        Iterator<FormManager.OnTextFormElementSuggestionRequestListener> it = yhVar.g.iterator();
        do {
            if (!it.hasNext()) {
                listOnTextFormElementGetSuggestions = Collections.EMPTY_LIST;
                break;
            }
            listOnTextFormElementGetSuggestions = it.next().onTextFormElementGetSuggestions(formElement);
        } while (listOnTextFormElementGetSuggestions.isEmpty());
        listOnTextFormElementGetSuggestions.getClass();
        this.H = listOnTextFormElementGetSuggestions;
        if (listOnTextFormElementGetSuggestions.isEmpty()) {
            return;
        }
        if (this.L == null) {
            o();
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.q50$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q50.a(this.f$0, view);
            }
        });
    }

    public final void r() {
        String string;
        if (this.H.isEmpty()) {
            return;
        }
        Editable text = getText();
        if (text == null || (string = text.toString()) == null) {
            string = "";
        }
        if (Intrinsics.areEqual(string, this.K)) {
            return;
        }
        this.K = string;
        Locale locale = Locale.getDefault();
        locale.getClass();
        String lowerCase = string.toLowerCase(locale);
        lowerCase.getClass();
        List list = this.J.get(lowerCase);
        if (list == null) {
            List<String> list2 = this.H;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list2) {
                String lowerCase2 = ((String) obj).toLowerCase(locale);
                lowerCase2.getClass();
                if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) lowerCase, false, 2, (Object) null)) {
                    arrayList.add(obj);
                }
            }
            this.J.put(lowerCase, arrayList);
            list = arrayList;
        }
        boolean zIsEmpty = list.isEmpty();
        PopupWindow popupWindow = this.L;
        if (zIsEmpty) {
            if (popupWindow == null || !popupWindow.isShowing()) {
                return;
            }
            popupWindow.dismiss();
            return;
        }
        c cVar = this.M;
        if (popupWindow == null || cVar == null) {
            if (popupWindow == null || !popupWindow.isShowing()) {
                return;
            }
            popupWindow.dismiss();
            return;
        }
        this.I.clear();
        this.I.addAll(list);
        cVar.notifyDataSetChanged();
        int width = getWidth();
        if (width <= 0) {
            Context context = getContext();
            context.getClass();
            width = (int) un.a(context, 1, 200);
        }
        popupWindow.setWidth(width);
        if (popupWindow.isShowing()) {
            return;
        }
        popupWindow.showAsDropDown(this);
    }

    @Override // android.view.View
    public final void scrollTo(int i, int i2) {
        if (this.D) {
            super.scrollTo(i, i2);
        } else {
            super.scrollTo(0, 0);
        }
    }

    @Override // android.view.View
    public final boolean willNotDraw() {
        return super.willNotDraw() && this.t == null;
    }

    @Override // com.pspdfkit.internal.uh
    public TextFormElement getFormElement() {
        return this.s;
    }

    public void setFormElement(TextFormElement textFormElement) {
        String inputFormatString;
        lm internalDocument;
        an anVar;
        this.s = textFormElement;
        if (textFormElement != null) {
            xh xhVar = this.q;
            xhVar.getClass();
            xhVar.a = textFormElement;
            Matrix matrix = new Matrix();
            RectF boundingBox = getBoundingBox();
            matrix.postRotate(-this.k, boundingBox.centerX(), boundingBox.centerY());
            matrix.mapRect(boundingBox);
            float f2 = boundingBox.bottom;
            float f3 = boundingBox.top;
            if (f2 > f3) {
                boundingBox.top = f2;
                boundingBox.bottom = f3;
            }
            OverlayLayoutParams.SizingMode sizingMode = OverlayLayoutParams.SizingMode.LAYOUT;
            setLayoutParams(new OverlayLayoutParams(boundingBox, sizingMode));
            int rotation = textFormElement.getAnnotation().getInternal().getRotation();
            Matrix matrix2 = new Matrix();
            RectF boundingBox2 = getBoundingBox();
            float f4 = rotation;
            matrix2.postRotate(f4, boundingBox2.centerX(), boundingBox2.centerY());
            matrix2.mapRect(boundingBox2);
            float f5 = boundingBox2.bottom;
            float f6 = boundingBox2.top;
            if (f5 > f6) {
                boundingBox2.top = f5;
                boundingBox2.bottom = f6;
            }
            setLayoutParams(new OverlayLayoutParams(boundingBox2, sizingMode));
            setRotation(f4);
            WidgetAnnotation annotation = textFormElement.getAnnotation();
            annotation.getClass();
            AnnotationTriggerEvent annotationTriggerEvent = AnnotationTriggerEvent.FIELD_FORMAT;
            if (annotation.getAdditionalAction(annotationTriggerEvent) != null && (internalDocument = annotation.getInternal().getInternalDocument()) != null && (anVar = internalDocument.l) != null) {
                annotationTriggerEvent.getClass();
                if (anVar.a()) {
                    WidgetAnnotation annotation2 = textFormElement.getAnnotation();
                    annotation2.getClass();
                    ce ceVarA = anVar.a(annotation2);
                    if (ceVarA != null) {
                        ceVarA.a(textFormElement, annotationTriggerEvent);
                    }
                }
            }
            setUpWidgetAnnotationObserver(textFormElement);
            String editingContents = textFormElement.getEditingContents();
            if (editingContents == null) {
                editingContents = textFormElement.getText();
            }
            this.w = editingContents;
            setText(editingContents);
            this.D = textFormElement.isScrollEnabled();
            setTransformationMethod(null);
            ContentResolver contentResolver = getContext().getContentResolver();
            contentResolver.getClass();
            int i = textFormElement.isSpellCheckEnabled() ? 32768 : 524288;
            if (textFormElement.isMultiLine()) {
                i |= 131072;
            }
            if (textFormElement.isPassword()) {
                i |= 524288;
            }
            TextInputFormat inputFormat = textFormElement.getInputFormat();
            inputFormat.getClass();
            setInputType(th.a(inputFormat, contentResolver) | i);
            if ((getInputType() & 2) != 0) {
                setKeyListener(DigitsKeyListener.getInstance("0123456789,.-"));
            }
            setSingleLine(!textFormElement.isMultiLine());
            if (!textFormElement.isMultiLine()) {
                setImeOptions(6);
            }
            if (textFormElement.isPassword()) {
                setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            ArrayList arrayList = new ArrayList();
            if (textFormElement.getMaxLength() != 0) {
                arrayList.add(new InputFilter.LengthFilter(textFormElement.getMaxLength()));
            }
            if (!this.D) {
                arrayList.add(new ur(this));
            }
            lm internalDocument2 = textFormElement.getAnnotation().getInternal().getInternalDocument();
            if (internalDocument2 != null && internalDocument2.l.d) {
                arrayList.add(new p50(textFormElement));
            }
            setFilters((InputFilter[]) arrayList.toArray(new InputFilter[0]));
            if (this.p) {
                TextInputFormat inputFormat2 = textFormElement.getInputFormat();
                inputFormat2.getClass();
                if ((inputFormat2 == TextInputFormat.DATE || inputFormat2 == TextInputFormat.TIME) && (inputFormatString = textFormElement.getInputFormatString()) != null) {
                    a(inputFormatString);
                }
            }
            p();
        }
    }

    public static final void a(q50 q50Var, View view) {
        PopupWindow popupWindow;
        if (!q50Var.g || q50Var.H.isEmpty() || (popupWindow = q50Var.L) == null || popupWindow.isShowing()) {
            return;
        }
        q50Var.r();
    }

    @Override // com.pspdfkit.internal.f7, com.pspdfkit.internal.z4
    public final void a(Matrix matrix, float f2) {
        matrix.getClass();
        this.b.set(matrix);
        if (this.u != null && this.A != null) {
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            this.u.setBounds(0, 0, height, height);
            setCompoundDrawablesRelative(null, null, this.u, null);
        } else {
            setCompoundDrawablesRelative(null, null, null, null);
        }
        p();
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0080  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.pspdfkit.internal.uh
    public final Object a(Continuation<? super Boolean> continuation) {
        d dVar;
        boolean z;
        boolean zEquals;
        if (continuation instanceof d) {
            dVar = (d) continuation;
            int i = dVar.c;
            if ((i & Integer.MIN_VALUE) != 0) {
                dVar.c = i - Integer.MIN_VALUE;
            } else {
                dVar = new d((ContinuationImpl) continuation);
            }
        } else {
            dVar = new d((ContinuationImpl) continuation);
        }
        Object obj = dVar.a;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = dVar.c;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            j();
            Job job = this.C;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.C = null;
            setErrorMessage(null);
            String strValueOf = String.valueOf(getText());
            dVar.c = 1;
            if (a(strValueOf, dVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (getFormElement() != null) {
            TextFormElement formElement = getFormElement();
            String text = formElement != null ? formElement.getText() : null;
            Object obj2 = this.w;
            Charset charset = u40.a;
            if (text == null && obj2 == null) {
                zEquals = true;
            } else {
                zEquals = (text == null || obj2 == null) ? false : text.equals(obj2);
            }
            z = zEquals ? false : true;
        }
        return Boxing.boxBoolean(z);
    }

    public static final void b(q50 q50Var, DialogInterface dialogInterface, int i) {
        q50Var.clearFormField();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(String str, ContinuationImpl continuationImpl) {
        r50 r50Var;
        if (continuationImpl instanceof r50) {
            r50Var = (r50) continuationImpl;
            int i = r50Var.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                r50Var.d = i - Integer.MIN_VALUE;
            } else {
                r50Var = new r50(this, continuationImpl);
            }
        } else {
            r50Var = new r50(this, continuationImpl);
        }
        Object objA = r50Var.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = r50Var.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            TextFormElement formElement = getFormElement();
            if (formElement == null) {
                return Boxing.boxBoolean(false);
            }
            String text = formElement.getText();
            Charset charset = u40.a;
            if (Intrinsics.areEqual(str, text == null ? "" : text.toString())) {
                return Boxing.boxBoolean(false);
            }
            r50Var.a = SpillingKt.nullOutSpilledVariable(formElement);
            r50Var.d = 1;
            objA = sh.a(formElement, str, r50Var);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objA);
        }
        return Boxing.boxBoolean(((Boolean) objA).booleanValue());
    }

    public static final void a(q50 q50Var, CharSequence charSequence) {
        q50Var.b(charSequence.toString());
    }

    public final float a(TextFormElement textFormElement, String str) {
        float fontSize = textFormElement.getAnnotation().getFontSize();
        if (fontSize > 0.0f) {
            return fontSize;
        }
        RectF boundingBox = textFormElement.getAnnotation().getBoundingBox();
        float f2 = (-boundingBox.height()) - 4.0f;
        float fWidth = boundingBox.width() - 4.0f;
        boolean z = this.E == fWidth && this.F == f2;
        Integer num = this.G.get(str);
        if (z && num != null) {
            return num.intValue();
        }
        if (!z) {
            this.E = fWidth;
            this.F = f2;
            this.G.evictAll();
        }
        TextPaint paint = getPaint();
        paint.getClass();
        float fA = o50.a(str, paint, fWidth, f2, textFormElement.isMultiLine(), !textFormElement.isScrollEnabled(), 192);
        this.G.put(str, Integer.valueOf((int) fA));
        return fA;
    }

    public final void a(String str) {
        final boolean z = true;
        final boolean z2 = StringsKt.contains$default((CharSequence) str, (CharSequence) "y", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) CmcdData.OBJECT_TYPE_MANIFEST, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "d", false, 2, (Object) null);
        if (!StringsKt.contains$default((CharSequence) str, (CharSequence) "H", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) str, (CharSequence) CmcdData.STREAMING_FORMAT_HLS, false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) str, (CharSequence) "M", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) str, (CharSequence) "s", false, 2, (Object) null)) {
            z = false;
        }
        if (z2 || z) {
            ArrayList arrayList = new ArrayList(str.length());
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt == 'M') {
                    cCharAt = 'm';
                } else if (cCharAt == 'm') {
                    cCharAt = 'M';
                }
                arrayList.add(Character.valueOf(cCharAt));
            }
            final String strReplace$default = StringsKt.replace$default(CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, null, 62, null), TtmlNode.TAG_TT, CmcdData.OBJECT_TYPE_AUDIO_ONLY, false, 4, (Object) null);
            setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.pspdfkit.internal.q50$$ExternalSyntheticLambda2
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z3) {
                    q50.a(this.f$0, strReplace$default, z2, z, view, z3);
                }
            });
            setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.q50$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q50.a(this.f$0, strReplace$default, z2, z, view);
                }
            });
        }
    }

    public static final void a(q50 q50Var, String str, boolean z, boolean z2, View view, boolean z3) {
        if (z3) {
            q50Var.a(str, z, z2);
        }
    }

    public static final void a(q50 q50Var, String str, boolean z, boolean z2, View view) {
        q50Var.a(str, z, z2);
    }

    public final void a(String str, boolean z, final boolean z2) {
        Date time;
        TextFormElement formElement = getFormElement();
        if (formElement == null) {
            return;
        }
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
        final Calendar calendar = Calendar.getInstance();
        final boolean z3 = (StringsKt.contains$default((CharSequence) str, (CharSequence) CmcdData.STREAMING_FORMAT_HLS, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) CmcdData.OBJECT_TYPE_AUDIO_ONLY, false, 2, (Object) null)) ? false : true;
        String text = formElement.getText();
        try {
            text.getClass();
            time = simpleDateFormat.parse(text);
            time.getClass();
        } catch (Exception unused) {
            time = Calendar.getInstance().getTime();
            time.getClass();
        }
        calendar.setTime(time);
        if (!z) {
            if (z2) {
                a(calendar, simpleDateFormat, z3);
            }
        } else {
            DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() { // from class: com.pspdfkit.internal.q50$$ExternalSyntheticLambda0
                @Override // android.app.DatePickerDialog.OnDateSetListener
                public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                    q50.a(calendar, z2, this, simpleDateFormat, z3, datePicker, i, i2, i3);
                }
            }, calendar.get(1), calendar.get(2), calendar.get(5));
            String text2 = formElement.getText();
            if (text2 != null && text2.length() != 0) {
                datePickerDialog.setButton(-3, no.a(getContext(), R.string.pspdf__clear, null), new DialogInterface.OnClickListener() { // from class: com.pspdfkit.internal.q50$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        q50.a(this.f$0, dialogInterface, i);
                    }
                });
            }
            datePickerDialog.show();
        }
    }

    public static final void a(Calendar calendar, boolean z, q50 q50Var, SimpleDateFormat simpleDateFormat, boolean z2, DatePicker datePicker, int i, int i2, int i3) {
        calendar.set(i, i2, i3);
        if (z) {
            q50Var.a(calendar, simpleDateFormat, z2);
            return;
        }
        Date time = calendar.getTime();
        time.getClass();
        q50Var.getClass();
        String str = simpleDateFormat.format(time);
        q50Var.setText(str);
        str.getClass();
        q50Var.b(str);
        FormEditingController formEditingController = q50Var.x;
        if (formEditingController != null && formEditingController.getFragment().getConfiguration().isAutoSelectNextFormElementEnabled() && formEditingController.hasNextElement()) {
            formEditingController.selectNextFormElement();
        }
    }

    public static final void a(q50 q50Var, DialogInterface dialogInterface, int i) {
        q50Var.clearFormField();
    }

    public final void a(final Calendar calendar, final SimpleDateFormat simpleDateFormat, boolean z) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() { // from class: com.pspdfkit.internal.q50$$ExternalSyntheticLambda5
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public final void onTimeSet(TimePicker timePicker, int i, int i2) {
                q50.a(calendar, this, simpleDateFormat, timePicker, i, i2);
            }
        }, calendar.get(11), calendar.get(12), z);
        TextFormElement formElement = getFormElement();
        String text = formElement != null ? formElement.getText() : null;
        if (text != null && text.length() != 0) {
            timePickerDialog.setButton(-3, no.a(getContext(), R.string.pspdf__clear, null), new DialogInterface.OnClickListener() { // from class: com.pspdfkit.internal.q50$$ExternalSyntheticLambda6
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    q50.b(this.f$0, dialogInterface, i);
                }
            });
        }
        timePickerDialog.show();
    }

    public static final void a(Calendar calendar, q50 q50Var, SimpleDateFormat simpleDateFormat, TimePicker timePicker, int i, int i2) {
        calendar.set(11, i);
        calendar.set(12, i2);
        Date time = calendar.getTime();
        time.getClass();
        q50Var.getClass();
        String str = simpleDateFormat.format(time);
        q50Var.setText(str);
        str.getClass();
        q50Var.b(str);
        FormEditingController formEditingController = q50Var.x;
        if (formEditingController != null && formEditingController.getFragment().getConfiguration().isAutoSelectNextFormElementEnabled() && formEditingController.hasNextElement()) {
            formEditingController.selectNextFormElement();
        }
    }

    public static final void a(q50 q50Var, AdapterView adapterView, View view, int i, long j) {
        String item;
        c cVar = q50Var.M;
        if (cVar == null || (item = cVar.getItem(i)) == null) {
            return;
        }
        q50Var.setText(item);
        q50Var.setSelection(item.length());
        PopupWindow popupWindow = q50Var.L;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        popupWindow.dismiss();
    }
}
