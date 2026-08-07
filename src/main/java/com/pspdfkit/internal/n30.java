package com.pspdfkit.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.datastructures.TextSelection;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public final class n30 implements Parcelable {
    public static final Parcelable.Creator<n30> CREATOR = new a();
    public final AnnotationTool a;
    public final AnnotationToolVariant b;
    public final ArrayList c;
    public final wu d;
    public final TextSelection e;
    public final cb f;

    public static final class a implements Parcelable.Creator<n30> {
        @Override // android.os.Parcelable.Creator
        public final n30 createFromParcel(Parcel parcel) {
            parcel.getClass();
            AnnotationTool annotationToolValueOf = parcel.readInt() == 0 ? null : AnnotationTool.valueOf(parcel.readString());
            AnnotationToolVariant annotationToolVariant = (AnnotationToolVariant) parcel.readParcelable(n30.class.getClassLoader());
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(wu.CREATOR.createFromParcel(parcel));
            }
            return new n30(annotationToolValueOf, annotationToolVariant, arrayList, parcel.readInt() != 0 ? wu.CREATOR.createFromParcel(parcel) : null, (TextSelection) parcel.readParcelable(n30.class.getClassLoader()), (cb) parcel.readParcelable(n30.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final n30[] newArray(int i) {
            return new n30[i];
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.views.document.SpecialModeState$getSelectedFormElement$1$resolved$1", f = "SpecialModeState.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Annotation>, Object> {
        public int a;
        public final /* synthetic */ lm c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(lm lmVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = lmVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return n30.this.new b(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Annotation> continuation) {
            return n30.this.new b(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            wu wuVar = n30.this.d;
            lm lmVar = this.c;
            this.a = 1;
            Object objA = wuVar.a(lmVar, this);
            return objA == coroutine_suspended ? coroutine_suspended : objA;
        }
    }

    public static final class c<T, R> implements Function {
        public static final c<T, R> a = new c<>();

        @Override // io.reactivex.rxjava3.functions.Function
        public final Object apply(Object obj) {
            Annotation annotation = (Annotation) obj;
            annotation.getClass();
            return annotation.getType() == AnnotationType.WIDGET ? ((WidgetAnnotation) annotation).getFormElementAsync() : Maybe.empty();
        }
    }

    public n30(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, ArrayList arrayList, wu wuVar, TextSelection textSelection, cb cbVar) {
        this.a = annotationTool;
        this.b = annotationToolVariant;
        this.c = arrayList;
        this.d = wuVar;
        this.e = textSelection;
        this.f = cbVar;
    }

    public final Maybe<FormElement> a(final lm lmVar) {
        if (this.d == null || lmVar == null) {
            Maybe<FormElement> maybeEmpty = Maybe.empty();
            maybeEmpty.getClass();
            return maybeEmpty;
        }
        Maybe<FormElement> maybeFlatMap = Maybe.defer(new Supplier() { // from class: com.pspdfkit.internal.n30$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return n30.a(this.f$0, lmVar);
            }
        }).flatMap(c.a);
        maybeFlatMap.getClass();
        return maybeFlatMap;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        AnnotationTool annotationTool = this.a;
        if (annotationTool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(annotationTool.name());
        }
        parcel.writeParcelable(this.b, i);
        ArrayList arrayList = this.c;
        parcel.writeInt(arrayList.size());
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            wu wuVar = (wu) obj;
            wuVar.getClass();
            parcel.writeInt(wuVar.a);
            parcel.writeString(wuVar.b);
            parcel.writeInt(wuVar.c);
        }
        wu wuVar2 = this.d;
        if (wuVar2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(wuVar2.a);
            parcel.writeString(wuVar2.b);
            parcel.writeInt(wuVar2.c);
        }
        parcel.writeParcelable(this.e, i);
        parcel.writeParcelable(this.f, i);
    }

    public n30(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant, List<? extends Annotation> list, FormElement formElement, TextSelection textSelection, cb cbVar) {
        wu wuVar;
        WidgetAnnotation annotation;
        list.getClass();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new wu((Annotation) it.next()));
        }
        if (formElement == null || (annotation = formElement.getAnnotation()) == null) {
            wuVar = null;
        } else {
            wuVar = new wu(annotation.getPageIndex(), annotation.getInternal().getUuid(), annotation.getObjectNumber());
            wuVar.d = annotation;
        }
        this.a = annotationTool;
        this.b = annotationToolVariant;
        this.c = arrayList;
        this.d = wuVar;
        this.e = textSelection;
        this.f = cbVar;
    }

    public static final MaybeSource a(n30 n30Var, lm lmVar) {
        Annotation annotation = (Annotation) BuildersKt__BuildersKt.runBlocking$default(null, n30Var.new b(lmVar, null), 1, null);
        if (annotation != null) {
            return Maybe.just(annotation);
        }
        return Maybe.empty();
    }
}
