package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Matrix;
import com.pspdfkit.internal.jni.NativeFormNotifications;
import com.pspdfkit.ui.drawable.PdfDrawable;
import com.pspdfkit.ui.drawable.PdfDrawableProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.page.pageview.data.providers.DrawableStateProvider$setDrawableProviders$1", f = "DrawableStateProvider.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {87, 88}, m = "invokeSuspend", n = {"$this$launch", "deferredDrawables", "newDrawableMap", "$this$launch", "deferredDrawables", "newDrawableMap", "$this$forEach$iv", "element$iv", NativeFormNotifications.PROVIDER_INDEX_INFO_KEY, "drawables", "$i$f$forEach", "$i$a$-forEach-DrawableStateProvider$setDrawableProviders$1$1"}, nl = {193, 96}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$6", "L$7", "L$8", "I$0", "I$1"}, v = 2)
public final class cf extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public Object a;
    public Map b;
    public Object c;
    public bf d;
    public Iterator e;
    public Object f;
    public Object g;
    public Object h;
    public int i;
    public int j;
    public /* synthetic */ Object k;
    public final /* synthetic */ List<PdfDrawableProvider> l;
    public final /* synthetic */ bf m;
    public final /* synthetic */ m40 n;

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.pageview.data.providers.DrawableStateProvider$setDrawableProviders$1$1$1", f = "DrawableStateProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ bf a;
        public final /* synthetic */ List<PdfDrawable> b;
        public final /* synthetic */ Map<PdfDrawableProvider, List<PdfDrawable>> c;
        public final /* synthetic */ PdfDrawableProvider d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(bf bfVar, List<? extends PdfDrawable> list, Map<PdfDrawableProvider, List<PdfDrawable>> map, PdfDrawableProvider pdfDrawableProvider, Continuation<? super a> continuation) {
            super(2, continuation);
            this.a = bfVar;
            this.b = list;
            this.c = map;
            this.d = pdfDrawableProvider;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.a, this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            Matrix matrixInvoke = this.a.b.invoke();
            List<PdfDrawable> list = this.b;
            bf bfVar = this.a;
            for (PdfDrawable pdfDrawable : list) {
                pdfDrawable.updatePdfToViewTransformation(matrixInvoke);
                pdfDrawable.setCallback(bfVar.a);
            }
            this.c.put(this.d, this.b);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.views.page.pageview.data.providers.DrawableStateProvider$setDrawableProviders$1$deferredDrawables$1$1", f = "DrawableStateProvider.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, nl = {78}, s = {}, v = 2)
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends PdfDrawableProvider, ? extends List<? extends PdfDrawable>>>, Object> {
        public int a;
        public final /* synthetic */ PdfDrawableProvider b;
        public final /* synthetic */ bf c;
        public final /* synthetic */ m40 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PdfDrawableProvider pdfDrawableProvider, bf bfVar, m40 m40Var, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = pdfDrawableProvider;
            this.c = bfVar;
            this.d = m40Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends PdfDrawableProvider, ? extends List<? extends PdfDrawable>>> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.b.registerDrawableProviderObserver(this.c);
                PdfDrawableProvider pdfDrawableProvider = this.b;
                Context context = this.c.a.getContext();
                context.getClass();
                m40 m40Var = this.d;
                lm lmVar = m40Var.a;
                int i2 = m40Var.b;
                this.a = 1;
                obj = pdfDrawableProvider.getDrawablesForPage(context, lmVar, i2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            List listEmptyList = (List) obj;
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            return TuplesKt.to(this.b, listEmptyList);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public cf(List<? extends PdfDrawableProvider> list, bf bfVar, m40 m40Var, Continuation<? super cf> continuation) {
        super(2, continuation);
        this.l = list;
        this.m = bfVar;
        this.n = m40Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        cf cfVar = new cf(this.l, this.m, this.n, continuation);
        cfVar.k = obj;
        return cfVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((cf) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:28:0x0103 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:? A[LOOP:0: B:20:0x00aa->B:29:?, LOOP_END, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Map<PdfDrawableProvider, List<PdfDrawable>> map;
        List list;
        Iterable iterable;
        bf bfVar;
        Iterator it;
        int i;
        bf bfVar2;
        Map<PdfDrawableProvider, List<PdfDrawable>> map2;
        List list2;
        MainCoroutineDispatcher main;
        a aVar;
        CoroutineScope coroutineScope = (CoroutineScope) this.k;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.j;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            List<PdfDrawableProvider> list3 = this.l;
            bf bfVar3 = this.m;
            m40 m40Var = this.n;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator<T> it2 = list3.iterator();
            while (it2.hasNext()) {
                arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getIO(), null, new b((PdfDrawableProvider) it2.next(), bfVar3, m40Var, null), 2, null));
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            this.k = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.a = SpillingKt.nullOutSpilledVariable(arrayList);
            this.b = linkedHashMap;
            this.j = 1;
            Object objAwaitAll = AwaitKt.awaitAll(arrayList, this);
            if (objAwaitAll != coroutine_suspended) {
                map = linkedHashMap;
                obj = objAwaitAll;
                list = arrayList;
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            Map<PdfDrawableProvider, List<PdfDrawable>> map3 = this.b;
            List list4 = (List) this.a;
            ResultKt.throwOnFailure(obj);
            map = map3;
            list = list4;
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.i;
            it = this.e;
            bfVar = this.d;
            iterable = (Iterable) this.c;
            map = this.b;
            list = (List) this.a;
            ResultKt.throwOnFailure(obj);
        }
        bfVar2 = bfVar;
        map2 = map;
        list2 = list;
        while (it.hasNext()) {
            Object next = it.next();
            Pair pair = (Pair) next;
            PdfDrawableProvider pdfDrawableProvider = (PdfDrawableProvider) pair.component1();
            List list5 = (List) pair.component2();
            main = Dispatchers.getMain();
            aVar = new a(bfVar2, list5, map2, pdfDrawableProvider, null);
            this.k = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.a = SpillingKt.nullOutSpilledVariable(list2);
            this.b = map2;
            this.c = SpillingKt.nullOutSpilledVariable(iterable);
            this.d = bfVar2;
            this.e = it;
            this.f = SpillingKt.nullOutSpilledVariable(next);
            this.g = SpillingKt.nullOutSpilledVariable(pdfDrawableProvider);
            this.h = SpillingKt.nullOutSpilledVariable(list5);
            this.i = i;
            this.j = 2;
            if (BuildersKt.withContext(main, aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        this.m.e.setValue(map2);
        this.m.c.invoke();
        return Unit.INSTANCE;
        iterable = (Iterable) obj;
        bfVar = this.m;
        it = iterable.iterator();
        i = 0;
        bfVar2 = bfVar;
        map2 = map;
        list2 = list;
        while (it.hasNext()) {
            Object next2 = it.next();
            Pair pair2 = (Pair) next2;
            PdfDrawableProvider pdfDrawableProvider2 = (PdfDrawableProvider) pair2.component1();
            List list6 = (List) pair2.component2();
            main = Dispatchers.getMain();
            aVar = new a(bfVar2, list6, map2, pdfDrawableProvider2, null);
            this.k = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.a = SpillingKt.nullOutSpilledVariable(list2);
            this.b = map2;
            this.c = SpillingKt.nullOutSpilledVariable(iterable);
            this.d = bfVar2;
            this.e = it;
            this.f = SpillingKt.nullOutSpilledVariable(next2);
            this.g = SpillingKt.nullOutSpilledVariable(pdfDrawableProvider2);
            this.h = SpillingKt.nullOutSpilledVariable(list6);
            this.i = i;
            this.j = 2;
            if (BuildersKt.withContext(main, aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        this.m.e.setValue(map2);
        this.m.c.invoke();
        return Unit.INSTANCE;
    }
}
