package com.pspdfkit.annotations;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import java.util.EnumSet;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.rx3.RxCompletableKt;
import kotlinx.coroutines.rx3.RxObservableKt;
import kotlinx.coroutines.rx3.RxSingleKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0003*\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007\u001a0\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0003*\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0007\u001a\u0014\u0010\u000f\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0005H\u0007\u001a\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013*\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0001H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"ANNOTATION_PROVIDER_RX_DEPRECATION_MESSAGE", "", "getAnnotationsObservable", "Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/pspdfkit/annotations/Annotation;", "Lcom/pspdfkit/annotations/AnnotationProvider;", "pageIndex", "", "getAllAnnotationsOfTypeObservable", "types", "Ljava/util/EnumSet;", "Lcom/pspdfkit/annotations/AnnotationType;", "startIndex", "pageCount", "addAnnotationToPageCompletable", "Lio/reactivex/rxjava3/core/Completable;", "annotation", "createAnnotationFromInstantJsonSingle", "Lio/reactivex/rxjava3/core/Single;", "annotationJson", "sdk-nutrient"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class AnnotationProviderRxJava {
    private static final String ANNOTATION_PROVIDER_RX_DEPRECATION_MESSAGE = "AnnotationProviderRxJava is temporary and will be removed in a future release. Migrate to the suspend APIs on AnnotationProvider.";

    /* JADX INFO: renamed from: com.pspdfkit.annotations.AnnotationProviderRxJava$addAnnotationToPageCompletable$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.annotations.AnnotationProviderRxJava$addAnnotationToPageCompletable$1", f = "AnnotationProviderRxJava.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Annotation $annotation;
        final /* synthetic */ AnnotationProvider $this_addAnnotationToPageCompletable;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AnnotationProvider annotationProvider, Annotation annotation, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_addAnnotationToPageCompletable = annotationProvider;
            this.$annotation = annotation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$this_addAnnotationToPageCompletable, this.$annotation, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnnotationProvider annotationProvider = this.$this_addAnnotationToPageCompletable;
                Annotation annotation = this.$annotation;
                this.label = 1;
                if (annotationProvider.addAnnotationToPage(annotation, this) == coroutine_suspended) {
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

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.annotations.AnnotationProviderRxJava$createAnnotationFromInstantJsonSingle$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/pspdfkit/annotations/Annotation;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.annotations.AnnotationProviderRxJava$createAnnotationFromInstantJsonSingle$1", f = "AnnotationProviderRxJava.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class C18451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Annotation>, Object> {
        final /* synthetic */ String $annotationJson;
        final /* synthetic */ AnnotationProvider $this_createAnnotationFromInstantJsonSingle;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C18451(AnnotationProvider annotationProvider, String str, Continuation<? super C18451> continuation) {
            super(2, continuation);
            this.$this_createAnnotationFromInstantJsonSingle = annotationProvider;
            this.$annotationJson = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C18451(this.$this_createAnnotationFromInstantJsonSingle, this.$annotationJson, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            AnnotationProvider annotationProvider = this.$this_createAnnotationFromInstantJsonSingle;
            String str = this.$annotationJson;
            this.label = 1;
            Object objCreateAnnotationFromInstantJson = annotationProvider.createAnnotationFromInstantJson(str, this);
            return objCreateAnnotationFromInstantJson == coroutine_suspended ? coroutine_suspended : objCreateAnnotationFromInstantJson;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Annotation> continuation) {
            return ((C18451) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.annotations.AnnotationProviderRxJava$getAllAnnotationsOfTypeObservable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/pspdfkit/annotations/Annotation;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.annotations.AnnotationProviderRxJava$getAllAnnotationsOfTypeObservable$1", f = "AnnotationProviderRxJava.kt", i = {0, 1, 1, 1, 1, 1, 1}, l = {45, 45}, m = "invokeSuspend", n = {"$this$rxObservable", "$this$rxObservable", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-AnnotationProviderRxJava$getAllAnnotationsOfTypeObservable$1$1"}, nl = {76, 76}, s = {"L$0", "L$0", "L$1", "L$3", "L$4", "I$0", "I$1"}, v = 2)
    public static final class C18461 extends SuspendLambda implements Function2<ProducerScope<? super Annotation>, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnnotationProvider $this_getAllAnnotationsOfTypeObservable;
        final /* synthetic */ EnumSet<AnnotationType> $types;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C18461(AnnotationProvider annotationProvider, EnumSet<AnnotationType> enumSet, Continuation<? super C18461> continuation) {
            super(2, continuation);
            this.$this_getAllAnnotationsOfTypeObservable = annotationProvider;
            this.$types = enumSet;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C18461 c18461 = new C18461(this.$this_getAllAnnotationsOfTypeObservable, this.$types, continuation);
            c18461.L$0 = obj;
            return c18461;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0051  */
        /* JADX WARN: Code duplicated, block: B:21:0x007a A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:24:? A[LOOP:0: B:14:0x004b->B:24:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
        
            if (r10 == r1) goto L18;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = r9.L$0
                kotlinx.coroutines.channels.ProducerScope r0 = (kotlinx.coroutines.channels.ProducerScope) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r9.label
                r3 = 2
                r4 = 0
                r5 = 1
                if (r2 == 0) goto L31
                if (r2 == r5) goto L2d
                if (r2 != r3) goto L25
                int r2 = r9.I$0
                java.lang.Object r5 = r9.L$4
                com.pspdfkit.annotations.Annotation r5 = (com.pspdfkit.annotations.Annotation) r5
                java.lang.Object r5 = r9.L$2
                java.util.Iterator r5 = (java.util.Iterator) r5
                java.lang.Object r6 = r9.L$1
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                kotlin.ResultKt.throwOnFailure(r10)
                goto L4b
            L25:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L2d:
                kotlin.ResultKt.throwOnFailure(r10)
                goto L43
            L31:
                kotlin.ResultKt.throwOnFailure(r10)
                com.pspdfkit.annotations.AnnotationProvider r10 = r9.$this_getAllAnnotationsOfTypeObservable
                java.util.EnumSet<com.pspdfkit.annotations.AnnotationType> r2 = r9.$types
                r9.L$0 = r0
                r9.label = r5
                java.lang.Object r10 = r10.getAllAnnotationsOfType(r2, r9)
                if (r10 != r1) goto L43
                goto L7a
            L43:
                r6 = r10
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                java.util.Iterator r5 = r6.iterator()
                r2 = r4
            L4b:
                boolean r10 = r5.hasNext()
                if (r10 == 0) goto L7b
                java.lang.Object r10 = r5.next()
                r7 = r10
                com.pspdfkit.annotations.Annotation r7 = (com.pspdfkit.annotations.Annotation) r7
                r9.L$0 = r0
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
                r9.L$1 = r8
                r9.L$2 = r5
                java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
                r9.L$3 = r10
                java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                r9.L$4 = r10
                r9.I$0 = r2
                r9.I$1 = r4
                r9.label = r3
                java.lang.Object r10 = r0.send(r7, r9)
                if (r10 != r1) goto L4b
            L7a:
                return r1
            L7b:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.annotations.AnnotationProviderRxJava.C18461.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super Annotation> producerScope, Continuation<? super Unit> continuation) {
            return ((C18461) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.annotations.AnnotationProviderRxJava$getAllAnnotationsOfTypeObservable$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/pspdfkit/annotations/Annotation;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.annotations.AnnotationProviderRxJava$getAllAnnotationsOfTypeObservable$2", f = "AnnotationProviderRxJava.kt", i = {0, 1, 1, 1, 1, 1, 1}, l = {58, 58}, m = "invokeSuspend", n = {"$this$rxObservable", "$this$rxObservable", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-AnnotationProviderRxJava$getAllAnnotationsOfTypeObservable$2$1"}, nl = {76, 76}, s = {"L$0", "L$0", "L$1", "L$3", "L$4", "I$0", "I$1"}, v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<ProducerScope<? super Annotation>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $pageCount;
        final /* synthetic */ int $startIndex;
        final /* synthetic */ AnnotationProvider $this_getAllAnnotationsOfTypeObservable;
        final /* synthetic */ EnumSet<AnnotationType> $types;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(AnnotationProvider annotationProvider, EnumSet<AnnotationType> enumSet, int i, int i2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$this_getAllAnnotationsOfTypeObservable = annotationProvider;
            this.$types = enumSet;
            this.$startIndex = i;
            this.$pageCount = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_getAllAnnotationsOfTypeObservable, this.$types, this.$startIndex, this.$pageCount, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0055  */
        /* JADX WARN: Code duplicated, block: B:21:0x007e A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:24:? A[LOOP:0: B:14:0x004f->B:24:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0044, code lost:
        
            if (r10 == r1) goto L18;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = r9.L$0
                kotlinx.coroutines.channels.ProducerScope r0 = (kotlinx.coroutines.channels.ProducerScope) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r9.label
                r3 = 2
                r4 = 0
                r5 = 1
                if (r2 == 0) goto L31
                if (r2 == r5) goto L2d
                if (r2 != r3) goto L25
                int r2 = r9.I$0
                java.lang.Object r5 = r9.L$4
                com.pspdfkit.annotations.Annotation r5 = (com.pspdfkit.annotations.Annotation) r5
                java.lang.Object r5 = r9.L$2
                java.util.Iterator r5 = (java.util.Iterator) r5
                java.lang.Object r6 = r9.L$1
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                kotlin.ResultKt.throwOnFailure(r10)
                goto L4f
            L25:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L2d:
                kotlin.ResultKt.throwOnFailure(r10)
                goto L47
            L31:
                kotlin.ResultKt.throwOnFailure(r10)
                com.pspdfkit.annotations.AnnotationProvider r10 = r9.$this_getAllAnnotationsOfTypeObservable
                java.util.EnumSet<com.pspdfkit.annotations.AnnotationType> r2 = r9.$types
                int r6 = r9.$startIndex
                int r7 = r9.$pageCount
                r9.L$0 = r0
                r9.label = r5
                java.lang.Object r10 = r10.getAllAnnotationsOfType(r2, r6, r7, r9)
                if (r10 != r1) goto L47
                goto L7e
            L47:
                r6 = r10
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                java.util.Iterator r5 = r6.iterator()
                r2 = r4
            L4f:
                boolean r10 = r5.hasNext()
                if (r10 == 0) goto L7f
                java.lang.Object r10 = r5.next()
                r7 = r10
                com.pspdfkit.annotations.Annotation r7 = (com.pspdfkit.annotations.Annotation) r7
                r9.L$0 = r0
                java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
                r9.L$1 = r8
                r9.L$2 = r5
                java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
                r9.L$3 = r10
                java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                r9.L$4 = r10
                r9.I$0 = r2
                r9.I$1 = r4
                r9.label = r3
                java.lang.Object r10 = r0.send(r7, r9)
                if (r10 != r1) goto L4f
            L7e:
                return r1
            L7f:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.annotations.AnnotationProviderRxJava.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super Annotation> producerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.annotations.AnnotationProviderRxJava$getAnnotationsObservable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "", "Lcom/pspdfkit/annotations/Annotation;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.annotations.AnnotationProviderRxJava$getAnnotationsObservable$1", f = "AnnotationProviderRxJava.kt", i = {0, 1}, l = {36, 36}, m = "invokeSuspend", n = {"$this$rxObservable", "$this$rxObservable"}, nl = {36, -1}, s = {"L$0", "L$0"}, v = 2)
    public static final class C18471 extends SuspendLambda implements Function2<ProducerScope<? super List<? extends Annotation>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $pageIndex;
        final /* synthetic */ AnnotationProvider $this_getAnnotationsObservable;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C18471(AnnotationProvider annotationProvider, int i, Continuation<? super C18471> continuation) {
            super(2, continuation);
            this.$this_getAnnotationsObservable = annotationProvider;
            this.$pageIndex = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C18471 c18471 = new C18471(this.$this_getAnnotationsObservable, this.$pageIndex, continuation);
            c18471.L$0 = obj;
            return c18471;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x004e, code lost:
        
            if (r2.send(r7, r6) == r1) goto L16;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = r6.L$0
                kotlinx.coroutines.channels.ProducerScope r0 = (kotlinx.coroutines.channels.ProducerScope) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r6.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L26
                if (r2 == r4) goto L1e
                if (r2 != r3) goto L16
                kotlin.ResultKt.throwOnFailure(r7)
                goto L51
            L16:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1e:
                java.lang.Object r2 = r6.L$1
                kotlinx.coroutines.channels.ProducerScope r2 = (kotlinx.coroutines.channels.ProducerScope) r2
                kotlin.ResultKt.throwOnFailure(r7)
                goto L3f
            L26:
                kotlin.ResultKt.throwOnFailure(r7)
                com.pspdfkit.annotations.AnnotationProvider r7 = r6.$this_getAnnotationsObservable
                int r2 = r6.$pageIndex
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r6.L$0 = r5
                r6.L$1 = r0
                r6.label = r4
                java.lang.Object r7 = r7.getAnnotations(r2, r6)
                if (r7 != r1) goto L3e
                goto L50
            L3e:
                r2 = r0
            L3f:
                java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r6.L$0 = r0
                r0 = 0
                r6.L$1 = r0
                r6.label = r3
                java.lang.Object r6 = r2.send(r7, r6)
                if (r6 != r1) goto L51
            L50:
                return r1
            L51:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.annotations.AnnotationProviderRxJava.C18471.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super List<? extends Annotation>> producerScope, Continuation<? super Unit> continuation) {
            return ((C18471) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Deprecated(message = ANNOTATION_PROVIDER_RX_DEPRECATION_MESSAGE)
    public static final Completable addAnnotationToPageCompletable(AnnotationProvider annotationProvider, Annotation annotation) {
        annotationProvider.getClass();
        annotation.getClass();
        return RxCompletableKt.rxCompletable(Dispatchers.getIO(), new AnonymousClass1(annotationProvider, annotation, null));
    }

    @Deprecated(message = ANNOTATION_PROVIDER_RX_DEPRECATION_MESSAGE)
    public static final Single<Annotation> createAnnotationFromInstantJsonSingle(AnnotationProvider annotationProvider, String str) {
        annotationProvider.getClass();
        str.getClass();
        return RxSingleKt.rxSingle(Dispatchers.getIO(), new C18451(annotationProvider, str, null));
    }

    @Deprecated(message = ANNOTATION_PROVIDER_RX_DEPRECATION_MESSAGE)
    public static final Observable<Annotation> getAllAnnotationsOfTypeObservable(AnnotationProvider annotationProvider, EnumSet<AnnotationType> enumSet) {
        annotationProvider.getClass();
        enumSet.getClass();
        return RxObservableKt.rxObservable(Dispatchers.getIO(), new C18461(annotationProvider, enumSet, null));
    }

    @Deprecated(message = ANNOTATION_PROVIDER_RX_DEPRECATION_MESSAGE)
    public static final Observable<List<Annotation>> getAnnotationsObservable(AnnotationProvider annotationProvider, int i) {
        annotationProvider.getClass();
        return RxObservableKt.rxObservable(Dispatchers.getIO(), new C18471(annotationProvider, i, null));
    }

    @Deprecated(message = ANNOTATION_PROVIDER_RX_DEPRECATION_MESSAGE)
    public static final Observable<Annotation> getAllAnnotationsOfTypeObservable(AnnotationProvider annotationProvider, EnumSet<AnnotationType> enumSet, int i, int i2) {
        annotationProvider.getClass();
        enumSet.getClass();
        return RxObservableKt.rxObservable(Dispatchers.getIO(), new AnonymousClass2(annotationProvider, enumSet, i, i2, null));
    }
}
