package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.ActionResolver;
import com.pspdfkit.annotations.actions.ActionSender;
import com.pspdfkit.annotations.actions.AnnotationTriggerEvent;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.exceptions.NutrientException;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.forms.FormType;
import com.pspdfkit.forms.SignatureFormElement;
import com.pspdfkit.forms.TextFormElement;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.ui.special_mode.controller.FormEditingController;
import com.pspdfkit.ui.special_mode.manager.FormManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes3.dex */
public final class mh implements f7.a, rj.a, FormManager.OnFormElementEditingModeChangeListener, FormManager.OnFormElementClickedListener {
    public final au a;
    public final lm b;
    public final PdfConfiguration c;
    public final b20 d;
    public final vh e;
    public final ActionResolver f;
    public final ci g;
    public final boolean h;
    public final Matrix i;
    public final CoroutineScope j;
    public FormElement k;
    public boolean l;
    public final a m;
    public final ArrayList n;
    public final wh o;
    public final nf p;

    public final class a extends w20 {
        public FormElement a;

        public a() {
        }

        @Override // com.pspdfkit.internal.w20, com.pspdfkit.internal.xi
        public final boolean a(MotionEvent motionEvent) {
            motionEvent.getClass();
            ArrayList arrayList = mh.this.n;
            if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
                return false;
            }
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                if (a80.b(((uh) obj).a(), motionEvent)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.pspdfkit.internal.w20, com.pspdfkit.internal.xi
        public final void b(MotionEvent motionEvent) {
            motionEvent.getClass();
            mh.this.o.setVisibility(8);
        }

        @Override // com.pspdfkit.internal.w20, com.pspdfkit.internal.xi
        public final void c(MotionEvent motionEvent) {
            motionEvent.getClass();
            mh.this.o.setVisibility(8);
        }

        @Override // com.pspdfkit.internal.w20, com.pspdfkit.internal.xi
        public final boolean d(MotionEvent motionEvent) {
            motionEvent.getClass();
            FormElement formElement = this.a;
            if (formElement != null) {
                return mh.this.b(formElement);
            }
            return false;
        }

        @Override // com.pspdfkit.internal.w20
        public final boolean f(MotionEvent motionEvent) {
            motionEvent.getClass();
            return this.a != null;
        }

        @Override // com.pspdfkit.internal.w20
        public final boolean h(MotionEvent motionEvent) {
            motionEvent.getClass();
            return this.a != null;
        }

        @Override // com.pspdfkit.internal.w20, com.pspdfkit.internal.xi
        public final void onDown(MotionEvent motionEvent) {
            motionEvent.getClass();
            FormElement formElement = null;
            this.a = null;
            mh mhVar = mh.this;
            if (mhVar.h) {
                vt pageEditor = mhVar.a.getPageEditor();
                pageEditor.getClass();
                Annotation annotationA = pageEditor.a(motionEvent, true);
                if (annotationA == null || annotationA.getType() == AnnotationType.WIDGET) {
                    FormElement formElementA = mh.this.a(motionEvent);
                    if (formElementA != null) {
                        yh yhVar = (yh) mh.this.e;
                        yhVar.getClass();
                        yh.a();
                        Iterator<FormManager.OnFormElementClickedListener> it = yhVar.e.iterator();
                        do {
                            if (!it.hasNext()) {
                                formElement = formElementA;
                                break;
                            }
                        } while (it.next().isFormElementClickable(formElementA));
                    }
                    this.a = formElement;
                    if (formElement != null && ((!formElement.isReadOnly() || formElement.getType() == FormType.SIGNATURE) && (formElement.getType() != FormType.PUSHBUTTON || formElement.getAnnotation().getAction() != null))) {
                        mh.this.o.setHighlightRect(formElement.getAnnotation().getBoundingBox());
                        if (mh.this.o.getParent() == null) {
                            mh mhVar2 = mh.this;
                            mhVar2.a.addView(mhVar2.o);
                        }
                        mh.this.o.setVisibility(0);
                        mh.this.o.bringToFront();
                    }
                    mh.this.a(this.a, AnnotationTriggerEvent.MOUSE_DOWN);
                }
            }
        }

        @Override // com.pspdfkit.internal.w20, com.pspdfkit.internal.xi
        public final boolean onLongPress(MotionEvent motionEvent) {
            motionEvent.getClass();
            return true;
        }
    }

    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[FormType.values().length];
            try {
                iArr[FormType.PUSHBUTTON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FormType.RADIOBUTTON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FormType.CHECKBOX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FormType.TEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FormType.LISTBOX.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FormType.COMBOBOX.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[FormType.SIGNATURE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            a = iArr;
        }
    }

    public static final class c implements nf.a {
        public c() {
        }

        @Override // com.pspdfkit.internal.nf.a
        public final boolean a(Annotation annotation) {
            annotation.getClass();
            return mh.this.h && annotation.getType() == AnnotationType.WIDGET && mh.this.b.g.hasFieldsCache();
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.FormEditor$clearSelection$1", f = "FormEditor.kt", i = {0}, l = {182}, m = "invokeSuspend", n = {"$this$launch"}, nl = {184}, s = {"L$0"}, v = 2)
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public /* synthetic */ Object b;
        public final /* synthetic */ List<uh<?>> c;
        public final /* synthetic */ mh d;
        public final /* synthetic */ FormElement e;

        @DebugMetadata(c = "com.pspdfkit.internal.views.page.FormEditor$clearSelection$1$1$1", f = "FormEditor.kt", i = {}, l = {181}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int a;
            public final /* synthetic */ mh b;
            public final /* synthetic */ uh<?> c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(mh mhVar, uh<?> uhVar, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = mhVar;
                this.c = uhVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return new a(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    mh mhVar = this.b;
                    uh<?> uhVar = this.c;
                    this.a = 1;
                    if (mhVar.a(uhVar, this) == coroutine_suspended) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(List<? extends uh<?>> list, mh mhVar, FormElement formElement, Continuation<? super d> continuation) {
            super(2, continuation);
            this.c = list;
            this.d = mhVar;
            this.e = formElement;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            d dVar = new d(this.c, this.d, this.e, continuation);
            dVar.b = obj;
            return dVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.b;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List<uh<?>> list = this.c;
                mh mhVar = this.d;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new a(mhVar, (uh) it.next(), null), 3, null));
                }
                this.b = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.a = 1;
                if (AwaitKt.awaitAll(arrayList, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.d.a(this.e, AnnotationTriggerEvent.LOOSE_FOCUS);
            return Unit.INSTANCE;
        }
    }

    public mh(au auVar, lm lmVar, PdfConfiguration pdfConfiguration, b20 b20Var, vh vhVar, ActionResolver actionResolver, k2 k2Var) {
        pdfConfiguration.getClass();
        b20Var.getClass();
        vhVar.getClass();
        this.a = auVar;
        this.b = lmVar;
        this.c = pdfConfiguration;
        this.d = b20Var;
        this.e = vhVar;
        this.f = actionResolver;
        ci ciVar = ca.b;
        if (ciVar == null) {
            throw new NutrientException("Make sure to call ConfigurationUtils#parseThemeConfigurations() before calling getFormSelectionThemeConfiguration()");
        }
        this.g = ciVar;
        this.h = ar.b().b(pdfConfiguration, lmVar);
        this.i = new Matrix();
        this.j = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.m = new a();
        this.n = new ArrayList();
        this.o = new wh(auVar.getContext(), ciVar.c);
        nf nfVar = new nf(k2Var);
        EnumSet<AnnotationType> enumSetOf = EnumSet.of(AnnotationType.WIDGET);
        enumSetOf.getClass();
        nfVar.b = enumSetOf;
        nfVar.c = new c();
        this.p = nfVar;
    }

    public final boolean a(boolean z) {
        FormElement formElement = this.k;
        if (formElement == null) {
            return false;
        }
        this.l = z;
        this.k = null;
        yh yhVar = (yh) this.e;
        yhVar.getClass();
        yh.a();
        Iterator<FormManager.OnFormElementDeselectedListener> it = yhVar.b.iterator();
        while (it.hasNext()) {
            it.next().onFormElementDeselected(formElement, z);
        }
        List list = CollectionsKt.toList(this.n);
        this.n.clear();
        BuildersKt__Builders_commonKt.launch$default(this.j, null, null, new d(list, this, formElement, null), 3, null);
        return true;
    }

    public final boolean b(FormElement formElement) {
        formElement.getClass();
        yh yhVar = (yh) this.e;
        yhVar.getClass();
        yh.a();
        Iterator<FormManager.OnFormElementClickedListener> it = yhVar.e.iterator();
        while (it.hasNext()) {
            if (it.next().onFormElementClicked(formElement)) {
                return true;
            }
        }
        boolean z = ar.b().a(NativeLicenseFeatures.DIGITAL_SIGNATURES) && (formElement instanceof SignatureFormElement) && ((SignatureFormElement) formElement).isSigned();
        if (!ww.a(formElement) && !z) {
            return false;
        }
        switch (b.a[formElement.getType().ordinal()]) {
            case 1:
                a(false);
                break;
            case 2:
                c(formElement);
                BuildersKt__Builders_commonKt.launch$default(this.j, null, null, new qh(formElement, null), 3, null);
                break;
            case 3:
                c(formElement);
                BuildersKt__Builders_commonKt.launch$default(this.j, null, null, new ph(formElement, null), 3, null);
                break;
            case 4:
            case 5:
            case 6:
                c(formElement);
                break;
            case 7:
                this.d.onFormElementClicked(formElement);
                break;
            default:
                return false;
        }
        Action action = formElement.getAnnotation().getAction();
        if (action != null) {
            this.f.executeAction(action, new ActionSender(formElement));
        } else {
            a(formElement, AnnotationTriggerEvent.MOUSE_UP);
        }
        return true;
    }

    @Override // com.pspdfkit.internal.f7.a
    public final boolean c() {
        return this.l;
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public final void onChangeFormElementEditingMode(FormEditingController formEditingController) {
        formEditingController.getClass();
        ArrayList arrayList = this.n;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((uh) obj).onChangeFormElementEditingMode(formEditingController);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public final void onEnterFormElementEditingMode(FormEditingController formEditingController) {
        formEditingController.getClass();
        ArrayList arrayList = this.n;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((uh) obj).onEnterFormElementEditingMode(formEditingController);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public final void onExitFormElementEditingMode(FormEditingController formEditingController) {
        formEditingController.getClass();
        ArrayList arrayList = this.n;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((uh) obj).onExitFormElementEditingMode(formEditingController);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementClickedListener
    public final boolean onFormElementClicked(FormElement formElement) {
        formElement.getClass();
        m40 state = this.a.getState();
        if (state == null) {
            a(false);
            return false;
        }
        if (formElement.getAnnotation().getPageIndex() != state.b || this.k != formElement) {
            a(formElement.getType() != FormType.PUSHBUTTON);
        }
        return false;
    }

    public final void c(FormElement formElement) {
        formElement.getClass();
        if (this.h && this.k != formElement && ww.a(formElement)) {
            a(true);
            yh yhVar = (yh) this.e;
            yhVar.getClass();
            yh.a();
            Iterator<FormManager.OnFormElementSelectedListener> it = yhVar.a.iterator();
            while (it.hasNext()) {
                if (!it.next().onPrepareFormElementSelection(formElement)) {
                    return;
                }
            }
            this.k = formElement;
            a(formElement, AnnotationTriggerEvent.RECEIVE_FOCUS);
            this.n.clear();
            try {
                Iterator<T> it2 = a(formElement).iterator();
                while (it2.hasNext()) {
                    uh uhVar = (uh) it2.next();
                    this.n.add(uhVar);
                    this.a.addView(uhVar.a());
                    uhVar.l();
                }
                yh yhVar2 = (yh) this.e;
                yhVar2.getClass();
                yh.a();
                Iterator<FormManager.OnFormElementSelectedListener> it3 = yhVar2.a.iterator();
                while (it3.hasNext()) {
                    it3.next().onFormElementSelected(formElement);
                }
            } catch (IllegalStateException unused) {
                a(false);
            }
        }
    }

    @Override // com.pspdfkit.internal.f7.a, com.pspdfkit.internal.rj.a
    public final void a(final RectF rectF) {
        rectF.getClass();
        this.a.postOnAnimation(new Runnable() { // from class: com.pspdfkit.internal.mh$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                mh.a(this.f$0, rectF);
            }
        });
    }

    public static final void a(mh mhVar, RectF rectF) {
        m40 state;
        if (mhVar.n.isEmpty() || (state = mhVar.a.getState()) == null) {
            return;
        }
        DocumentView parentView = mhVar.a.getParentView();
        int i = state.b;
        ln lnVar = parentView.C;
        if (lnVar != null) {
            lnVar.a(rectF, i, 200L, false);
        }
    }

    public final FormElement a(MotionEvent motionEvent) {
        FormElement formElement;
        motionEvent.getClass();
        this.a.a(this.i);
        Annotation annotationA = this.p.a(motionEvent, this.i, true);
        WidgetAnnotation widgetAnnotation = annotationA instanceof WidgetAnnotation ? (WidgetAnnotation) annotationA : null;
        if (widgetAnnotation == null || (formElement = widgetAnnotation.getFormElement()) == null || !this.b.g.hasFieldsCache()) {
            return null;
        }
        return formElement;
    }

    public final void a(FormElement formElement, AnnotationTriggerEvent annotationTriggerEvent) {
        WidgetAnnotation annotation;
        bm internal;
        Action additionalAction;
        if (formElement == null || (annotation = formElement.getAnnotation()) == null || (internal = annotation.getInternal()) == null || (additionalAction = internal.getAdditionalAction(annotationTriggerEvent)) == null) {
            return;
        }
        this.f.executeAction(additionalAction, new ActionSender(formElement));
    }

    public static final void b(mh mhVar, uh uhVar) {
        mhVar.a.removeView(uhVar.a());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(final uh uhVar, ContinuationImpl continuationImpl) {
        nh nhVar;
        FormElement formElement;
        Object objA;
        Object obj;
        if (continuationImpl instanceof nh) {
            nhVar = (nh) continuationImpl;
            int i = nhVar.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                nhVar.e = i - Integer.MIN_VALUE;
            } else {
                nhVar = new nh(this, continuationImpl);
            }
        } else {
            nhVar = new nh(this, continuationImpl);
        }
        Object obj2 = nhVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = nhVar.e;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            formElement = uhVar.getFormElement();
            nhVar.a = uhVar;
            nhVar.b = formElement;
            nhVar.e = 1;
            objA = uhVar.a(nhVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            FormElement formElement2 = nhVar.b;
            uh uhVar2 = nhVar.a;
            ResultKt.throwOnFailure(obj2);
            formElement = formElement2;
            uhVar = uhVar2;
            objA = obj2;
        }
        boolean zBooleanValue = ((Boolean) objA).booleanValue();
        uhVar.d();
        if (this.a.getState() == null) {
            this.a.removeView(uhVar.a());
            return Unit.INSTANCE;
        }
        if (formElement != null && zBooleanValue) {
            i4 annotationRenderingCoordinator = this.a.getAnnotationRenderingCoordinator();
            WidgetAnnotation annotation = formElement.getAnnotation();
            annotation.getClass();
            annotationRenderingCoordinator.getClass();
            z4<?> z4VarA = annotationRenderingCoordinator.l.a(annotation);
            if (z4VarA == null) {
                ArrayList arrayList = annotationRenderingCoordinator.d;
                int size = arrayList.size();
                int i3 = 0;
                do {
                    if (i3 >= size) {
                        obj = null;
                        break;
                    }
                    obj = arrayList.get(i3);
                    i3++;
                } while (((z4) obj).getAnnotation() != annotation);
                z4VarA = (z4) obj;
            }
            if (z4VarA != null) {
                z4VarA.b();
            }
            this.a.getAnnotationRenderingCoordinator().a(CollectionsKt.listOf(formElement.getAnnotation()), false, new Function0() { // from class: com.pspdfkit.internal.mh$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return mh.a(this.f$0, uhVar);
                }
            });
        } else if (!this.a.post(new Runnable() { // from class: com.pspdfkit.internal.mh$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                mh.b(this.f$0, uhVar);
            }
        })) {
            this.a.removeView(uhVar.a());
        }
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.f7.a
    public final int b() {
        m40 state = this.a.getState();
        if (state != null) {
            return state.b;
        }
        return -1;
    }

    public static final Unit a(mh mhVar, uh uhVar) {
        mhVar.a.removeView(uhVar.a());
        return Unit.INSTANCE;
    }

    public final List<uh<?>> a(FormElement formElement) {
        m40 state = this.a.getState();
        if (state == null) {
            return CollectionsKt.emptyList();
        }
        int i = b.a[formElement.getType().ordinal()];
        if (i != 3) {
            if (i == 4) {
                int pageRotation = this.b.getPageRotation(state.b);
                Context context = this.a.getContext();
                context.getClass();
                q50 q50Var = new q50(context, this.c, this.g, pageRotation, this.e);
                q50Var.setEditTextViewListener(this);
                q50Var.setFormElement((TextFormElement) formElement);
                return CollectionsKt.listOf(q50Var);
            }
            if (i != 5 && i != 6) {
                if (i != 7) {
                    Context context2 = this.a.getContext();
                    context2.getClass();
                    rj rjVar = new rj(context2, this.g.c, this);
                    rjVar.setFormElement(formElement);
                    return CollectionsKt.listOf(rjVar);
                }
                return CollectionsKt.emptyList();
            }
        }
        i4 annotationRenderingCoordinator = this.a.getAnnotationRenderingCoordinator();
        WidgetAnnotation annotation = formElement.getAnnotation();
        annotation.getClass();
        annotationRenderingCoordinator.getClass();
        g4 g4VarA = !annotationRenderingCoordinator.a() ? null : i4.a(annotation, annotationRenderingCoordinator.n);
        if (g4VarA == null) {
            return CollectionsKt.emptyList();
        }
        if (g4VarA == g4.PAGE) {
            Context context3 = this.a.getContext();
            context3.getClass();
            og ogVar = new og(context3, this.c, this.b, this.g.c, this);
            ogVar.setFormElement(formElement);
            return CollectionsKt.listOf(ogVar);
        }
        Context context4 = this.a.getContext();
        context4.getClass();
        rj rjVar2 = new rj(context4, this.g.c, this);
        rjVar2.setFormElement(formElement);
        return CollectionsKt.listOf(rjVar2);
    }
}
