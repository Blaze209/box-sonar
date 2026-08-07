package com.pspdfkit.internal;

import android.util.SparseArray;
import com.pspdfkit.forms.ChoiceFormElement;
import com.pspdfkit.forms.ChoiceFormField;
import com.pspdfkit.forms.EditableButtonFormElement;
import com.pspdfkit.forms.EditableButtonFormField;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.forms.FormField;
import com.pspdfkit.forms.FormListeners;
import com.pspdfkit.forms.FormProviderImpl;
import com.pspdfkit.forms.TextFormElement;
import com.pspdfkit.forms.TextFormField;
import com.pspdfkit.internal.jni.NativeDocument;
import com.pspdfkit.internal.jni.NativeFormField;
import com.pspdfkit.internal.jni.NativeFormObserver;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class zh extends NativeFormObserver {
    public final WeakReference<fm> a;
    public final WeakReference<lm> b;
    public final go<FormListeners.OnButtonFormFieldUpdatedListener> c;
    public final go<FormListeners.OnChoiceFormFieldUpdatedListener> d;
    public final go<FormListeners.OnTextFormFieldUpdatedListener> e;
    public final go<FormListeners.OnFormFieldUpdatedListener> f;
    public final go<FormListeners.OnFormTabOrderUpdatedListener> g;

    public static final class a<T> implements Consumer {
        public a() {
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            FormField formField = (FormField) obj;
            formField.getClass();
            Iterator<FormListeners.OnFormFieldUpdatedListener> it = zh.this.f.iterator();
            while (it.hasNext()) {
                it.next().onFormFieldUpdated(formField);
            }
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ int a;
        public final /* synthetic */ zh b;
        public final /* synthetic */ boolean c;

        public b(int i, zh zhVar, boolean z) {
            this.a = i;
            this.b = zhVar;
            this.c = z;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            EditableButtonFormElement editableButtonFormElement;
            FormField formField = (FormField) obj;
            formField.getClass();
            if ((formField instanceof EditableButtonFormField) && (editableButtonFormElement = (EditableButtonFormElement) bi.a(formField, this.a)) != null) {
                go<FormListeners.OnButtonFormFieldUpdatedListener> goVar = this.b.c;
                boolean z = this.c;
                Iterator<FormListeners.OnButtonFormFieldUpdatedListener> it = goVar.iterator();
                while (it.hasNext()) {
                    it.next().onButtonSelected((EditableButtonFormField) formField, editableButtonFormElement, z);
                }
            }
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ int a;
        public final /* synthetic */ zh b;

        public c(int i, zh zhVar) {
            this.a = i;
            this.b = zhVar;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            FormElement formElementA;
            FormField formField = (FormField) obj;
            if (formField == null || (formElementA = bi.a(formField, this.a)) == null) {
                return;
            }
            Iterator<FormListeners.OnFormFieldUpdatedListener> it = this.b.f.iterator();
            while (it.hasNext()) {
                it.next().onFormFieldReset(formField, formElementA);
            }
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ int a;
        public final /* synthetic */ zh b;
        public final /* synthetic */ ArrayList<Integer> c;

        public d(int i, zh zhVar, ArrayList<Integer> arrayList) {
            this.a = i;
            this.b = zhVar;
            this.c = arrayList;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            ChoiceFormElement choiceFormElement;
            FormField formField = (FormField) obj;
            formField.getClass();
            if ((formField instanceof ChoiceFormField) && (choiceFormElement = (ChoiceFormElement) bi.a(formField, this.a)) != null) {
                go<FormListeners.OnChoiceFormFieldUpdatedListener> goVar = this.b.d;
                ArrayList<Integer> arrayList = this.c;
                Iterator<FormListeners.OnChoiceFormFieldUpdatedListener> it = goVar.iterator();
                while (it.hasNext()) {
                    it.next().onOptionSelected((ChoiceFormField) formField, choiceFormElement, arrayList);
                }
            }
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ int a;
        public final /* synthetic */ zh b;
        public final /* synthetic */ String c;

        public e(int i, zh zhVar, String str) {
            this.a = i;
            this.b = zhVar;
            this.c = str;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            ChoiceFormElement choiceFormElement;
            FormField formField = (FormField) obj;
            formField.getClass();
            if ((formField instanceof ChoiceFormField) && (choiceFormElement = (ChoiceFormElement) bi.a(formField, this.a)) != null) {
                go<FormListeners.OnChoiceFormFieldUpdatedListener> goVar = this.b.d;
                String str = this.c;
                Iterator<FormListeners.OnChoiceFormFieldUpdatedListener> it = goVar.iterator();
                while (it.hasNext()) {
                    it.next().onCustomOptionSet((ChoiceFormField) formField, choiceFormElement, str);
                }
            }
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ int a;
        public final /* synthetic */ zh b;
        public final /* synthetic */ int c;

        public f(int i, zh zhVar, int i2) {
            this.a = i;
            this.b = zhVar;
            this.c = i2;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            TextFormElement textFormElement;
            FormField formField = (FormField) obj;
            formField.getClass();
            if ((formField instanceof TextFormField) && (textFormElement = (TextFormElement) bi.a(formField, this.a)) != null) {
                go<FormListeners.OnTextFormFieldUpdatedListener> goVar = this.b.e;
                int i = this.c;
                Iterator<FormListeners.OnTextFormFieldUpdatedListener> it = goVar.iterator();
                while (it.hasNext()) {
                    it.next().onMaxLengthChanged((TextFormField) formField, textFormElement, i);
                }
            }
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ int a;
        public final /* synthetic */ zh b;
        public final /* synthetic */ String c;

        public g(int i, zh zhVar, String str) {
            this.a = i;
            this.b = zhVar;
            this.c = str;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            TextFormElement textFormElement;
            FormField formField = (FormField) obj;
            formField.getClass();
            if ((formField instanceof TextFormField) && (textFormElement = (TextFormElement) bi.a(formField, this.a)) != null) {
                go<FormListeners.OnTextFormFieldUpdatedListener> goVar = this.b.e;
                String str = this.c;
                Iterator<FormListeners.OnTextFormFieldUpdatedListener> it = goVar.iterator();
                while (it.hasNext()) {
                    it.next().onRichTextChanged((TextFormField) formField, textFormElement, str);
                }
            }
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ int a;
        public final /* synthetic */ zh b;
        public final /* synthetic */ String c;

        public h(int i, zh zhVar, String str) {
            this.a = i;
            this.b = zhVar;
            this.c = str;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            TextFormElement textFormElement;
            FormField formField = (FormField) obj;
            formField.getClass();
            if ((formField instanceof TextFormField) && (textFormElement = (TextFormElement) bi.a(formField, this.a)) != null) {
                go<FormListeners.OnTextFormFieldUpdatedListener> goVar = this.b.e;
                String str = this.c;
                Iterator<FormListeners.OnTextFormFieldUpdatedListener> it = goVar.iterator();
                while (it.hasNext()) {
                    it.next().onTextChanged((TextFormField) formField, textFormElement, str);
                }
            }
        }
    }

    public static final class i<T> implements Consumer {
        public static final i<T> a = new i<>();

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            Throwable th = (Throwable) obj;
            th.getClass();
            PdfLog.e("Nutri.FormObserver", th, "Error while processing a tab order that has changed.", new Object[0]);
        }
    }

    public static final class j<T, R> implements Function {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;

        public j(String str, int i) {
            this.a = str;
            this.b = i;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Maybe apply(Throwable th) {
            th.getClass();
            PdfLog.e("Nutri.FormObserver", th, "Error while retrieving the field " + this.a + " on page " + this.b + ".", new Object[0]);
            return Maybe.empty();
        }
    }

    public static final class k<T> implements Consumer {
        public static final k<T> a = new k<>();

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            FormElement formElement = (FormElement) obj;
            formElement.getClass();
            formElement.getAnnotation().getInternal().syncPropertiesWithNative();
        }
    }

    public static final class l<T> implements Consumer {
        public l() {
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            FormElement formElement = (FormElement) obj;
            formElement.getClass();
            Iterator<FormListeners.OnFormFieldUpdatedListener> it = zh.this.f.iterator();
            while (it.hasNext()) {
                it.next().onFormFieldUpdated(formElement.getFormField());
            }
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        public m(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(Throwable th) {
            th.getClass();
            PdfLog.e("Nutri.FormObserver", th, "Error while processing the form element with id " + this.a + " on page " + this.b + ".", new Object[0]);
        }
    }

    public zh(FormProviderImpl formProviderImpl, lm lmVar) {
        lmVar.getClass();
        this.a = new WeakReference<>(formProviderImpl);
        this.b = new WeakReference<>(lmVar);
        this.c = new go<>();
        this.d = new go<>();
        this.e = new go<>();
        this.f = new go<>();
        this.g = new go<>();
    }

    public static final MaybeSource b(Function0 function0) {
        Object objInvoke = function0.invoke();
        return objInvoke == null ? Maybe.empty() : Maybe.just(objInvoke);
    }

    public static final void d(Function0 function0) {
        function0.invoke();
    }

    public final void a(final FormField formField) {
        h60.a(new Runnable() { // from class: com.pspdfkit.internal.zh$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                zh.a(this.f$0, formField);
            }
        });
    }

    public final Completable c(final Function0 function0) {
        lm lmVar = this.b.get();
        if (lmVar == null) {
            Completable completableComplete = Completable.complete();
            completableComplete.getClass();
            return completableComplete;
        }
        Completable completableSubscribeOn = Completable.fromAction(new Action() { // from class: com.pspdfkit.internal.zh$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() {
                zh.d(function0);
            }
        }).subscribeOn(lmVar.b(5));
        completableSubscribeOn.getClass();
        return completableSubscribeOn;
    }

    @Override // com.pspdfkit.internal.jni.NativeFormObserver
    public final void formDidAddFormField(NativeDocument nativeDocument, final int i2, final NativeFormField nativeFormField) {
        nativeDocument.getClass();
        nativeFormField.getClass();
        final fm fmVar = this.a.get();
        if (fmVar == null) {
            return;
        }
        a(new Function0() { // from class: com.pspdfkit.internal.zh$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return zh.a(fmVar, i2, nativeFormField);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new a());
    }

    @Override // com.pspdfkit.internal.jni.NativeFormObserver
    public final void formDidChange(NativeDocument nativeDocument, int i2, String str) {
        nativeDocument.getClass();
        str.getClass();
        fm fmVar = this.a.get();
        if (fmVar == null) {
            return;
        }
        fmVar.setDirty(true);
        if (this.f.a.isEmpty()) {
            return;
        }
        a(i2, str).subscribe(new ai(this));
    }

    @Override // com.pspdfkit.internal.jni.NativeFormObserver
    public final void formDidChangeAction(NativeDocument nativeDocument, int i2, int i3) {
        nativeDocument.getClass();
        a(i2, i3);
    }

    @Override // com.pspdfkit.internal.jni.NativeFormObserver
    public final void formDidChangeButtonSelection(NativeDocument nativeDocument, int i2, String str, int i3, boolean z) {
        nativeDocument.getClass();
        str.getClass();
        if (this.c.a.isEmpty()) {
            return;
        }
        a(i2, str).subscribe(new b(i3, this, z));
    }

    @Override // com.pspdfkit.internal.jni.NativeFormObserver
    public final void formDidChangeFlags(NativeDocument nativeDocument, int i2, int i3) {
        nativeDocument.getClass();
        a(i2, i3);
    }

    @Override // com.pspdfkit.internal.jni.NativeFormObserver
    public final void formDidReset(NativeDocument nativeDocument, int i2, String str, int i3) {
        nativeDocument.getClass();
        str.getClass();
        if (this.f.a.isEmpty()) {
            return;
        }
        a(i2, str).subscribe(new c(i3, this));
    }

    @Override // com.pspdfkit.internal.jni.NativeFormObserver
    public final void formDidSelectOption(NativeDocument nativeDocument, int i2, String str, int i3, ArrayList<Integer> arrayList) {
        nativeDocument.getClass();
        str.getClass();
        arrayList.getClass();
        if (this.d.a.isEmpty()) {
            return;
        }
        a(i2, str).subscribe(new d(i3, this, arrayList));
    }

    @Override // com.pspdfkit.internal.jni.NativeFormObserver
    public final void formDidSetCustomOption(NativeDocument nativeDocument, int i2, String str, int i3, String str2) {
        nativeDocument.getClass();
        str.getClass();
        if (this.d.a.isEmpty()) {
            return;
        }
        a(i2, str).subscribe(new e(i3, this, str2));
    }

    @Override // com.pspdfkit.internal.jni.NativeFormObserver
    public final void formDidSetMaxLength(NativeDocument nativeDocument, int i2, String str, int i3, int i4) {
        nativeDocument.getClass();
        str.getClass();
        if (this.e.a.isEmpty()) {
            return;
        }
        a(i2, str).subscribe(new f(i3, this, i4));
    }

    @Override // com.pspdfkit.internal.jni.NativeFormObserver
    public final void formDidSetRichText(NativeDocument nativeDocument, int i2, String str, int i3, String str2) {
        nativeDocument.getClass();
        str.getClass();
        if (this.e.a.isEmpty()) {
            return;
        }
        a(i2, str).subscribe(new g(i3, this, str2));
    }

    @Override // com.pspdfkit.internal.jni.NativeFormObserver
    public final void formDidSetText(NativeDocument nativeDocument, int i2, String str, int i3, String str2) {
        nativeDocument.getClass();
        str.getClass();
        if (this.e.a.isEmpty()) {
            return;
        }
        a(i2, str).subscribe(new h(i3, this, str2));
    }

    @Override // com.pspdfkit.internal.jni.NativeFormObserver
    public final void formDidSetValue(NativeDocument nativeDocument, int i2, String str) {
        nativeDocument.getClass();
        str.getClass();
        fm fmVar = this.a.get();
        if (fmVar == null) {
            return;
        }
        fmVar.setDirty(true);
        if (this.f.a.isEmpty()) {
            return;
        }
        a(i2, str).subscribe(new ai(this));
    }

    @Override // com.pspdfkit.internal.jni.NativeFormObserver
    public final void formTabOrderDidRecalculate(NativeDocument nativeDocument, final int i2) {
        nativeDocument.getClass();
        final fm fmVar = this.a.get();
        if (fmVar == null) {
            return;
        }
        c(new Function0() { // from class: com.pspdfkit.internal.zh$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return zh.a(fmVar, i2);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action() { // from class: com.pspdfkit.internal.zh$$ExternalSyntheticLambda4
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() {
                zh.a(this.f$0);
            }
        }, i.a);
    }

    public static final void a(zh zhVar, FormField formField) {
        Iterator<FormListeners.OnFormFieldUpdatedListener> it = zhVar.f.iterator();
        while (it.hasNext()) {
            it.next().onFormFieldUpdated(formField);
        }
    }

    public static final Unit a(fm fmVar, int i2) {
        fmVar.getFormCache().a(i2);
        return Unit.INSTANCE;
    }

    public static final void a(zh zhVar) {
        Iterator<FormListeners.OnFormTabOrderUpdatedListener> it = zhVar.g.iterator();
        while (it.hasNext()) {
            it.next().onFormTabOrderUpdated();
        }
    }

    public static final FormField a(fm fmVar, int i2, NativeFormField nativeFormField) {
        return fmVar.onFormFieldAdded(i2, nativeFormField);
    }

    public final void a(final int i2, final int i3) {
        final fm fmVar = this.a.get();
        if (fmVar == null) {
            return;
        }
        a(new Function0() { // from class: com.pspdfkit.internal.zh$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return zh.a(fmVar, i2, i3);
            }
        }).doOnSuccess(k.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new l(), new m(i3, i2));
    }

    public static final FormElement a(fm fmVar, int i2, int i3) {
        return (FormElement) ((SparseArray) fmVar.getFormCache().g.get(i2)).get(i3);
    }

    public final Maybe<FormField> a(final int i2, final String str) {
        final fm fmVar = this.a.get();
        if (fmVar == null) {
            Maybe<FormField> maybeEmpty = Maybe.empty();
            maybeEmpty.getClass();
            return maybeEmpty;
        }
        Maybe<FormField> maybeObserveOn = a(new Function0() { // from class: com.pspdfkit.internal.zh$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return zh.a(fmVar, i2, str);
            }
        }).onErrorResumeNext(new j(str, i2)).observeOn(AndroidSchedulers.mainThread());
        maybeObserveOn.getClass();
        return maybeObserveOn;
    }

    public static final FormField a(fm fmVar, int i2, String str) {
        kh formCache = fmVar.getFormCache();
        formCache.getClass();
        str.getClass();
        return (FormField) ((Map) formCache.e.get(i2)).get(str);
    }

    public final <T> Maybe<T> a(final Function0<? extends T> function0) {
        lm lmVar = this.b.get();
        if (lmVar == null) {
            Maybe<T> maybeEmpty = Maybe.empty();
            maybeEmpty.getClass();
            return maybeEmpty;
        }
        Maybe<T> maybeSubscribeOn = Maybe.defer(new Supplier() { // from class: com.pspdfkit.internal.zh$$ExternalSyntheticLambda2
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return zh.b(function0);
            }
        }).subscribeOn(lmVar.b(15));
        maybeSubscribeOn.getClass();
        return maybeSubscribeOn;
    }
}
