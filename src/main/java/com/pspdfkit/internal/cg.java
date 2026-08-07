package com.pspdfkit.internal;

import androidx.lifecycle.ViewModelKt;
import com.pspdfkit.document.files.EmbeddedFile;
import com.pspdfkit.document.files.EmbeddedFilesProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.views.outline.embed.EmbeddedFilesViewModel$getEmbeddedFiles$2", f = "EmbeddedFilesViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
public final class cg extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ fg a;
    public final /* synthetic */ EmbeddedFilesProvider b;

    public static final class a implements EmbeddedFilesProvider.EmbeddedFilesCallback {
        public final /* synthetic */ fg a;

        /* JADX INFO: renamed from: com.pspdfkit.internal.cg$a$a, reason: collision with other inner class name */
        @DebugMetadata(c = "com.pspdfkit.internal.views.outline.embed.EmbeddedFilesViewModel$getEmbeddedFiles$2$2$onError$1", f = "EmbeddedFilesViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        public static final class C0259a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public /* synthetic */ Object a;
            public final /* synthetic */ fg b;
            public final /* synthetic */ Throwable c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0259a(fg fgVar, Throwable th, Continuation<? super C0259a> continuation) {
                super(2, continuation);
                this.b = fgVar;
                this.c = th;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C0259a c0259a = new C0259a(this.b, this.c, continuation);
                c0259a.a = obj;
                return c0259a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C0259a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                ag value;
                CoroutineScope coroutineScope = (CoroutineScope) this.a;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(obj);
                if (!CoroutineScopeKt.isActive(coroutineScope)) {
                    return Unit.INSTANCE;
                }
                MutableStateFlow<ag> mutableStateFlow = this.b.a;
                Throwable th = this.c;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, ag.a(value, CollectionsKt.emptyList(), null, false, 0, 0, th, null, 90)));
                return Unit.INSTANCE;
            }
        }

        @DebugMetadata(c = "com.pspdfkit.internal.views.outline.embed.EmbeddedFilesViewModel$getEmbeddedFiles$2$2$onFilesFound$1", f = "EmbeddedFilesViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public /* synthetic */ Object a;
            public final /* synthetic */ Collection<EmbeddedFile> b;
            public final /* synthetic */ fg c;
            public final /* synthetic */ int d;
            public final /* synthetic */ Collection<EmbeddedFile> e;
            public final /* synthetic */ boolean f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public b(Collection<? extends EmbeddedFile> collection, fg fgVar, int i, Collection<? extends EmbeddedFile> collection2, boolean z, Continuation<? super b> continuation) {
                super(2, continuation);
                this.b = collection;
                this.c = fgVar;
                this.d = i;
                this.e = collection2;
                this.f = z;
            }

            public static final boolean a(int i, vf vfVar) {
                return vfVar.a == i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                b bVar = new b(this.b, this.c, this.d, this.e, this.f, continuation);
                bVar.a = obj;
                return bVar;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                ag value;
                CoroutineScope coroutineScope = (CoroutineScope) this.a;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(obj);
                if (!CoroutineScopeKt.isActive(coroutineScope)) {
                    return Unit.INSTANCE;
                }
                if (!this.b.isEmpty()) {
                    ArrayList arrayList = this.c.d;
                    final int i = this.d;
                    CollectionsKt.removeAll((List) arrayList, new Function1() { // from class: com.pspdfkit.internal.cg$a$b$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Boolean.valueOf(cg.a.b.a(i, (vf) obj2));
                        }
                    });
                    vf vfVar = new vf(this.d, CollectionsKt.toList(this.b));
                    ArrayList arrayList2 = this.c.d;
                    int i2 = this.d;
                    int size = arrayList2.size();
                    int i3 = 0;
                    int i4 = 0;
                    while (true) {
                        if (i3 >= size) {
                            i4 = -1;
                            break;
                        }
                        Object obj2 = arrayList2.get(i3);
                        i3++;
                        if (((vf) obj2).a > i2) {
                            break;
                        }
                        i4++;
                    }
                    fg fgVar = this.c;
                    if (i4 >= 0) {
                        fgVar.d.add(i4, vfVar);
                    } else {
                        Boxing.boxBoolean(fgVar.d.add(vfVar));
                    }
                }
                fg fgVar2 = this.c;
                MutableStateFlow<ag> mutableStateFlow = fgVar2.a;
                Collection<EmbeddedFile> collection = this.e;
                boolean z = this.f;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, ag.a(value, CollectionsKt.toList(collection), CollectionsKt.toList(fgVar2.d), !z, 0, 0, null, null, 120)));
                return Unit.INSTANCE;
            }
        }

        @DebugMetadata(c = "com.pspdfkit.internal.views.outline.embed.EmbeddedFilesViewModel$getEmbeddedFiles$2$2$onPageProgress$1", f = "EmbeddedFilesViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public /* synthetic */ Object a;
            public final /* synthetic */ fg b;
            public final /* synthetic */ int c;
            public final /* synthetic */ int d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(fg fgVar, int i, int i2, Continuation<? super c> continuation) {
                super(2, continuation);
                this.b = fgVar;
                this.c = i;
                this.d = i2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                c cVar = new c(this.b, this.c, this.d, continuation);
                cVar.a = obj;
                return cVar;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                ag value;
                CoroutineScope coroutineScope = (CoroutineScope) this.a;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(obj);
                if (!CoroutineScopeKt.isActive(coroutineScope)) {
                    return Unit.INSTANCE;
                }
                MutableStateFlow<ag> mutableStateFlow = this.b.a;
                int i = this.c;
                int i2 = this.d;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, ag.a(value, null, null, false, i, i2, null, null, 103)));
                return Unit.INSTANCE;
            }
        }

        public a(fg fgVar) {
            this.a = fgVar;
        }

        @Override // com.pspdfkit.document.files.EmbeddedFilesProvider.EmbeddedFilesCallback
        public final void onError(Throwable th) {
            th.getClass();
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.a), Dispatchers.getMain(), null, new C0259a(this.a, th, null), 2, null);
        }

        @Override // com.pspdfkit.document.files.EmbeddedFilesProvider.EmbeddedFilesCallback
        public final boolean onFilesFound(Collection<? extends EmbeddedFile> collection, Collection<? extends EmbeddedFile> collection2, int i, boolean z) {
            collection.getClass();
            collection2.getClass();
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.a), Dispatchers.getMain(), null, new b(collection2, this.a, i, collection, z, null), 2, null);
            return !this.a.c;
        }

        @Override // com.pspdfkit.document.files.EmbeddedFilesProvider.EmbeddedFilesCallback
        public final boolean onPageProgress(int i, int i2) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.a), Dispatchers.getMain(), null, new c(this.a, i, i2, null), 2, null);
            return !this.a.c;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cg(fg fgVar, EmbeddedFilesProvider embeddedFilesProvider, Continuation continuation) {
        super(2, continuation);
        this.a = fgVar;
        this.b = embeddedFilesProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new cg(this.a, this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new cg(this.a, this.b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ag value;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        MutableStateFlow<ag> mutableStateFlow = this.a.a;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ag.a(value, CollectionsKt.emptyList(), CollectionsKt.emptyList(), true, 0, 0, null, null, 88)));
        this.b.getEmbeddedFilesProgressive(true, new a(this.a));
        return Unit.INSTANCE;
    }
}
