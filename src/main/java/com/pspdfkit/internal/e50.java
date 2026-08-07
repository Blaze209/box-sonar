package com.pspdfkit.internal;

import android.os.Environment;
import androidx.media3.common.C;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.pspdfkit.ui.fonts.Font;
import com.pspdfkit.ui.fonts.FontManager;
import com.pspdfkit.utils.PdfLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes3.dex */
public final class e50 implements FontManager {
    public static final Map<String, Integer> e = MapsKt.mapOf(TuplesKt.to("bold", -1), TuplesKt.to("italic", -1), TuplesKt.to("_subset", -1), TuplesKt.to("regular", 1));
    public static final Lazy<ExecutorCoroutineDispatcher> f = LazyKt.lazy(new Function0() { // from class: com.pspdfkit.internal.e50$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return e50.a();
        }
    });
    public final List<String> a;
    public final Deferred<List<Font>> b;
    public final Font c;
    public final Deferred<Font> d;

    public static final class a {
        public static boolean a(String str) {
            str.getClass();
            return StringsKt.startsWith(str, "Noto", true) || StringsKt.startsWith(str, "DroidSans", true) || StringsKt.contains$default((CharSequence) str, (CharSequence) "Clock", false, 2, (Object) null) || StringsKt.startsWith(str, "RobotoNum", false) || StringsKt.startsWith(str, "SEC", false) || StringsKt.startsWith(str, "Samsung", false);
        }
    }

    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt.compareValues(((Font) t).getName(), ((Font) t2).getName());
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.ui.fonts.SystemFontManager$defaultAnnotationFontDeferred$1", f = "SystemFontManager.kt", i = {0, 0, 0}, l = {67}, m = "invokeSuspend", n = {"$this$async", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-SystemFontManager$defaultAnnotationFontDeferred$1$1"}, nl = {68}, s = {"L$0", "L$2", "I$0"}, v = 2)
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Font>, Object> {
        public e50 a;
        public Object b;
        public int c;
        public /* synthetic */ Object d;

        public c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            c cVar = e50.this.new c(continuation);
            cVar.d = obj;
            return cVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Font> continuation) {
            c cVar = e50.this.new c(continuation);
            cVar.d = coroutineScope;
            return cVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM14780constructorimpl;
            e50 e50Var;
            CoroutineScope coroutineScope = (CoroutineScope) this.d;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.c;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    e50 e50Var2 = e50.this;
                    Result.Companion companion = Result.INSTANCE;
                    Deferred<List<Font>> deferred = e50Var2.b;
                    this.d = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.a = e50Var2;
                    this.b = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.c = 1;
                    Object objAwait = deferred.await(this);
                    if (objAwait == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    e50Var = e50Var2;
                    obj = objAwait;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    e50Var = this.a;
                    ResultKt.throwOnFailure(obj);
                }
                Font fontA = e50.a(e50Var, (List) obj, "Roboto");
                if (fontA == null) {
                    fontA = e50Var.c;
                }
                objM14780constructorimpl = Result.m14780constructorimpl(fontA);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(th));
            }
            return Result.m14783exceptionOrNullimpl(objM14780constructorimpl) == null ? objM14780constructorimpl : e50.this.c;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.ui.fonts.SystemFontManager$fontsDeferred$1", f = "SystemFontManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Font>>, Object> {
        public /* synthetic */ Object a;

        public static final class a<T> implements Comparator {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((Font) t).getName(), ((Font) t2).getName());
            }
        }

        public d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            d dVar = e50.this.new d(continuation);
            dVar.a = obj;
            return dVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Font>> continuation) {
            d dVar = e50.this.new d(continuation);
            dVar.a = coroutineScope;
            return dVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM14780constructorimpl;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            e50 e50Var = e50.this;
            try {
                Result.Companion companion = Result.INSTANCE;
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(e50.a(new File(Environment.getRootDirectory(), "fonts")));
                Iterator<String> it = e50Var.a.iterator();
                while (it.hasNext()) {
                    arrayList.addAll(e50.a(new File(it.next())));
                }
                objM14780constructorimpl = Result.m14780constructorimpl(CollectionsKt.sortedWith(arrayList, new a()));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM14783exceptionOrNullimpl = Result.m14783exceptionOrNullimpl(objM14780constructorimpl);
            if (thM14783exceptionOrNullimpl == null) {
                return objM14780constructorimpl;
            }
            PdfLog.w("Nutri.SystemFontManager", thM14783exceptionOrNullimpl, "System fonts could not be loaded", new Object[0]);
            return CollectionsKt.emptyList();
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.ui.fonts.SystemFontManager$getAvailableFonts$1", f = "SystemFontManager.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Font>>, Object> {
        public int a;

        public e(Continuation<? super e> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e50.this.new e(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Font>> continuation) {
            return e50.this.new e(continuation).invokeSuspend(Unit.INSTANCE);
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
            Deferred<List<Font>> deferred = e50.this.b;
            this.a = 1;
            Object objAwait = deferred.await(this);
            return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.ui.fonts.SystemFontManager$getDefaultAnnotationFontBlocking$1", f = "SystemFontManager.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Font>, Object> {
        public int a;

        public f(Continuation<? super f> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e50.this.new f(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Font> continuation) {
            return e50.this.new f(continuation).invokeSuspend(Unit.INSTANCE);
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
            Deferred<Font> deferred = e50.this.d;
            this.a = 1;
            Object objAwait = deferred.await(this);
            return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.ui.fonts.SystemFontManager$getFontByName$1", f = "SystemFontManager.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Font>, Object> {
        public e50 a;
        public int b;
        public final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, Continuation<? super g> continuation) {
            super(2, continuation);
            this.d = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e50.this.new g(this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Font> continuation) {
            return e50.this.new g(this.d, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            e50 e50Var;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                e50 e50Var2 = e50.this;
                Deferred<List<Font>> deferred = e50Var2.b;
                this.a = e50Var2;
                this.b = 1;
                Object objAwait = deferred.await(this);
                if (objAwait == coroutine_suspended) {
                    return coroutine_suspended;
                }
                e50Var = e50Var2;
                obj = objAwait;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e50Var = this.a;
                ResultKt.throwOnFailure(obj);
            }
            return e50.a(e50Var, (List) obj, this.d);
        }
    }

    public e50(List<String> list) {
        list.getClass();
        this.a = list;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(f.getValue()));
        CoroutineStart coroutineStart = CoroutineStart.LAZY;
        Deferred<List<Font>> deferredAsync$default = BuildersKt__Builders_commonKt.async$default(CoroutineScope, null, coroutineStart, new d(null), 1, null);
        deferredAsync$default.start();
        this.b = deferredAsync$default;
        this.c = new Font(C.SANS_SERIF_NAME, null, null, 6, null);
        Deferred<Font> deferredAsync$default2 = BuildersKt__Builders_commonKt.async$default(CoroutineScope, null, coroutineStart, new c(null), 1, null);
        deferredAsync$default2.start();
        this.d = deferredAsync$default2;
    }

    public static final Font a(e50 e50Var, List list, String str) {
        Object next;
        e50Var.getClass();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            next = it.next();
            Font font = (Font) next;
            if (!Intrinsics.areEqual(font.getName(), str)) {
                List<File> fontFiles = font.getFontFiles();
                if (!(fontFiles instanceof Collection) || !fontFiles.isEmpty()) {
                    Iterator<T> it2 = fontFiles.iterator();
                    while (it2.hasNext()) {
                        if (Intrinsics.areEqual(FilesKt.getNameWithoutExtension((File) it2.next()), str)) {
                        }
                    }
                }
            }
            return (Font) next;
        }
        next = null;
        return (Font) next;
    }

    public final Font b() {
        return (Font) BuildersKt__BuildersKt.runBlocking$default(null, new f(null), 1, null);
    }

    @Override // com.pspdfkit.ui.fonts.FontManager
    public final List<Font> getAvailableFonts() {
        return (List) BuildersKt__BuildersKt.runBlocking$default(null, new e(null), 1, null);
    }

    @Override // com.pspdfkit.ui.fonts.FontManager
    public final Font getFontByName(String str) {
        if (str == null) {
            return null;
        }
        return (Font) BuildersKt__BuildersKt.runBlocking$default(null, new g(str, null), 1, null);
    }

    public static List a(File file) {
        Font font;
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (File file2 : fileArrListFiles) {
            String strSubstringBeforeLast$default = StringsKt.substringBeforeLast$default(FilesKt.getNameWithoutExtension(file2), CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, (String) null, 2, (Object) null);
            Object arrayList = linkedHashMap.get(strSubstringBeforeLast$default);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(strSubstringBeforeLast$default, arrayList);
            }
            ((List) arrayList).add(file2);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            List list = (List) entry.getValue();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                File file3 = (File) obj;
                file3.getClass();
                String name = file3.getName();
                name.getClass();
                if (!a.a(name)) {
                    arrayList2.add(obj);
                }
            }
            linkedHashMap2.put(key, arrayList2);
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            if (!((List) entry2.getValue()).isEmpty()) {
                linkedHashMap3.put(entry2.getKey(), entry2.getValue());
            }
        }
        Comparator comparator = new Comparator() { // from class: com.pspdfkit.internal.e50$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj2, Object obj3) {
                return e50.a((File) obj2, (File) obj3);
            }
        };
        ArrayList arrayList3 = new ArrayList();
        for (Map.Entry entry3 : linkedHashMap3.entrySet()) {
            String str = (String) entry3.getKey();
            try {
                font = new Font(str, (List<? extends File>) CollectionsKt.sortedWith((List) entry3.getValue(), comparator));
            } catch (Throwable th) {
                PdfLog.w("Nutri.SystemFontManager", th, "System font `%s` could not be loaded. This font will not be available for selection.", str);
                font = null;
            }
            if (font != null) {
                arrayList3.add(font);
            }
        }
        return CollectionsKt.sortedWith(arrayList3, new b());
    }

    public static final int a(File file, File file2) {
        int iIntValue;
        int iIntValue2;
        file.getClass();
        Iterator<T> it = e.keySet().iterator();
        while (true) {
            if (it.hasNext()) {
                String str = (String) it.next();
                String name = file.getName();
                name.getClass();
                if (StringsKt.contains((CharSequence) name, (CharSequence) str, true)) {
                    Integer num = e.get(str);
                    if (num != null) {
                        iIntValue = num.intValue();
                        break;
                    }
                }
            }
            iIntValue = 0;
            break;
        }
        file2.getClass();
        Iterator<T> it2 = e.keySet().iterator();
        while (true) {
            if (it2.hasNext()) {
                String str2 = (String) it2.next();
                String name2 = file2.getName();
                name2.getClass();
                if (StringsKt.contains((CharSequence) name2, (CharSequence) str2, true)) {
                    Integer num2 = e.get(str2);
                    if (num2 != null) {
                        iIntValue2 = num2.intValue();
                        break;
                    }
                }
            }
            iIntValue2 = 0;
            break;
        }
        if (iIntValue == iIntValue2) {
            return 0;
        }
        return iIntValue > iIntValue2 ? -1 : 1;
    }

    public static final ExecutorCoroutineDispatcher a() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.pspdfkit.internal.e50$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return e50.a(runnable);
            }
        });
        executorServiceNewSingleThreadExecutor.getClass();
        return ExecutorsKt.from(executorServiceNewSingleThreadExecutor);
    }

    public static final Thread a(Runnable runnable) {
        return new Thread(runnable, "nutrient-font-loading");
    }
}
