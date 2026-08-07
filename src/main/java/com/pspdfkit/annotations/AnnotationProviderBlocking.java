package com.pspdfkit.annotations;

import java.util.EnumSet;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
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
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007\u001a \u0010\b\u001a\u0004\u0018\u00010\u0004*\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0007\u001a \u0010\b\u001a\u0004\u0018\u00010\u0004*\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0001H\u0007\u001a \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0007\u001a4\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0001\u0010\u000f\u001a\u00020\u00072\b\b\u0001\u0010\u0010\u001a\u00020\u0007H\u0007\u001a\u0014\u0010\u0011\u001a\u00020\u0012*\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\u0014\u001a\u00020\u0012*\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0004H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"ANNOTATION_PROVIDER_BLOCKING_DEPRECATION_MESSAGE", "", "getAnnotationsBlocking", "", "Lcom/pspdfkit/annotations/Annotation;", "Lcom/pspdfkit/annotations/AnnotationProvider;", "pageIndex", "", "getAnnotationBlocking", "objectNumber", "uuid", "getAllAnnotationsOfTypeBlocking", "types", "Ljava/util/EnumSet;", "Lcom/pspdfkit/annotations/AnnotationType;", "startPageIndex", "pageCount", "addAnnotationToPageBlocking", "", "annotation", "removeAnnotationFromPageBlocking", "sdk-nutrient"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class AnnotationProviderBlocking {
    private static final String ANNOTATION_PROVIDER_BLOCKING_DEPRECATION_MESSAGE = "AnnotationProviderBlocking is temporary and will be removed in a future release. Migrate to the suspend APIs on AnnotationProvider.";

    /* JADX INFO: renamed from: com.pspdfkit.annotations.AnnotationProviderBlocking$addAnnotationToPageBlocking$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.annotations.AnnotationProviderBlocking$addAnnotationToPageBlocking$1", f = "AnnotationProviderBlocking.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Annotation $annotation;
        final /* synthetic */ AnnotationProvider $this_addAnnotationToPageBlocking;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AnnotationProvider annotationProvider, Annotation annotation, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_addAnnotationToPageBlocking = annotationProvider;
            this.$annotation = annotation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$this_addAnnotationToPageBlocking, this.$annotation, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnnotationProvider annotationProvider = this.$this_addAnnotationToPageBlocking;
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

    /* JADX INFO: renamed from: com.pspdfkit.annotations.AnnotationProviderBlocking$getAllAnnotationsOfTypeBlocking$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/pspdfkit/annotations/Annotation;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.annotations.AnnotationProviderBlocking$getAllAnnotationsOfTypeBlocking$1", f = "AnnotationProviderBlocking.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class C18401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Annotation>>, Object> {
        final /* synthetic */ AnnotationProvider $this_getAllAnnotationsOfTypeBlocking;
        final /* synthetic */ EnumSet<AnnotationType> $types;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C18401(AnnotationProvider annotationProvider, EnumSet<AnnotationType> enumSet, Continuation<? super C18401> continuation) {
            super(2, continuation);
            this.$this_getAllAnnotationsOfTypeBlocking = annotationProvider;
            this.$types = enumSet;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C18401(this.$this_getAllAnnotationsOfTypeBlocking, this.$types, continuation);
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
            AnnotationProvider annotationProvider = this.$this_getAllAnnotationsOfTypeBlocking;
            EnumSet<AnnotationType> enumSet = this.$types;
            this.label = 1;
            Object allAnnotationsOfType = annotationProvider.getAllAnnotationsOfType(enumSet, this);
            return allAnnotationsOfType == coroutine_suspended ? coroutine_suspended : allAnnotationsOfType;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Annotation>> continuation) {
            return ((C18401) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.annotations.AnnotationProviderBlocking$getAllAnnotationsOfTypeBlocking$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/pspdfkit/annotations/Annotation;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.annotations.AnnotationProviderBlocking$getAllAnnotationsOfTypeBlocking$2", f = "AnnotationProviderBlocking.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Annotation>>, Object> {
        final /* synthetic */ int $pageCount;
        final /* synthetic */ int $startPageIndex;
        final /* synthetic */ AnnotationProvider $this_getAllAnnotationsOfTypeBlocking;
        final /* synthetic */ EnumSet<AnnotationType> $types;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(AnnotationProvider annotationProvider, EnumSet<AnnotationType> enumSet, int i, int i2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$this_getAllAnnotationsOfTypeBlocking = annotationProvider;
            this.$types = enumSet;
            this.$startPageIndex = i;
            this.$pageCount = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$this_getAllAnnotationsOfTypeBlocking, this.$types, this.$startPageIndex, this.$pageCount, continuation);
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
            AnnotationProvider annotationProvider = this.$this_getAllAnnotationsOfTypeBlocking;
            EnumSet<AnnotationType> enumSet = this.$types;
            int i2 = this.$startPageIndex;
            int i3 = this.$pageCount;
            this.label = 1;
            Object allAnnotationsOfType = annotationProvider.getAllAnnotationsOfType(enumSet, i2, i3, this);
            return allAnnotationsOfType == coroutine_suspended ? coroutine_suspended : allAnnotationsOfType;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Annotation>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.annotations.AnnotationProviderBlocking$getAnnotationBlocking$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/pspdfkit/annotations/Annotation;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.annotations.AnnotationProviderBlocking$getAnnotationBlocking$1", f = "AnnotationProviderBlocking.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class C18411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Annotation>, Object> {
        final /* synthetic */ int $objectNumber;
        final /* synthetic */ int $pageIndex;
        final /* synthetic */ AnnotationProvider $this_getAnnotationBlocking;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C18411(AnnotationProvider annotationProvider, int i, int i2, Continuation<? super C18411> continuation) {
            super(2, continuation);
            this.$this_getAnnotationBlocking = annotationProvider;
            this.$pageIndex = i;
            this.$objectNumber = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C18411(this.$this_getAnnotationBlocking, this.$pageIndex, this.$objectNumber, continuation);
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
            AnnotationProvider annotationProvider = this.$this_getAnnotationBlocking;
            int i2 = this.$pageIndex;
            int i3 = this.$objectNumber;
            this.label = 1;
            Object annotation = annotationProvider.getAnnotation(i2, i3, this);
            return annotation == coroutine_suspended ? coroutine_suspended : annotation;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Annotation> continuation) {
            return ((C18411) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.annotations.AnnotationProviderBlocking$getAnnotationBlocking$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/pspdfkit/annotations/Annotation;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.annotations.AnnotationProviderBlocking$getAnnotationBlocking$2", f = "AnnotationProviderBlocking.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class C18422 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Annotation>, Object> {
        final /* synthetic */ int $pageIndex;
        final /* synthetic */ AnnotationProvider $this_getAnnotationBlocking;
        final /* synthetic */ String $uuid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C18422(AnnotationProvider annotationProvider, int i, String str, Continuation<? super C18422> continuation) {
            super(2, continuation);
            this.$this_getAnnotationBlocking = annotationProvider;
            this.$pageIndex = i;
            this.$uuid = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C18422(this.$this_getAnnotationBlocking, this.$pageIndex, this.$uuid, continuation);
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
            AnnotationProvider annotationProvider = this.$this_getAnnotationBlocking;
            int i2 = this.$pageIndex;
            String str = this.$uuid;
            this.label = 1;
            Object annotation = annotationProvider.getAnnotation(i2, str, this);
            return annotation == coroutine_suspended ? coroutine_suspended : annotation;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Annotation> continuation) {
            return ((C18422) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.annotations.AnnotationProviderBlocking$getAnnotationsBlocking$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/pspdfkit/annotations/Annotation;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.annotations.AnnotationProviderBlocking$getAnnotationsBlocking$1", f = "AnnotationProviderBlocking.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class C18431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Annotation>>, Object> {
        final /* synthetic */ int $pageIndex;
        final /* synthetic */ AnnotationProvider $this_getAnnotationsBlocking;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C18431(AnnotationProvider annotationProvider, int i, Continuation<? super C18431> continuation) {
            super(2, continuation);
            this.$this_getAnnotationsBlocking = annotationProvider;
            this.$pageIndex = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C18431(this.$this_getAnnotationsBlocking, this.$pageIndex, continuation);
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
            AnnotationProvider annotationProvider = this.$this_getAnnotationsBlocking;
            int i2 = this.$pageIndex;
            this.label = 1;
            Object annotations = annotationProvider.getAnnotations(i2, this);
            return annotations == coroutine_suspended ? coroutine_suspended : annotations;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Annotation>> continuation) {
            return ((C18431) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.annotations.AnnotationProviderBlocking$removeAnnotationFromPageBlocking$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.annotations.AnnotationProviderBlocking$removeAnnotationFromPageBlocking$1", f = "AnnotationProviderBlocking.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class C18441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Annotation $annotation;
        final /* synthetic */ AnnotationProvider $this_removeAnnotationFromPageBlocking;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C18441(AnnotationProvider annotationProvider, Annotation annotation, Continuation<? super C18441> continuation) {
            super(2, continuation);
            this.$this_removeAnnotationFromPageBlocking = annotationProvider;
            this.$annotation = annotation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C18441(this.$this_removeAnnotationFromPageBlocking, this.$annotation, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnnotationProvider annotationProvider = this.$this_removeAnnotationFromPageBlocking;
                Annotation annotation = this.$annotation;
                this.label = 1;
                if (annotationProvider.removeAnnotationFromPage(annotation, this) == coroutine_suspended) {
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
            return ((C18441) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Deprecated(message = ANNOTATION_PROVIDER_BLOCKING_DEPRECATION_MESSAGE)
    public static final void addAnnotationToPageBlocking(AnnotationProvider annotationProvider, Annotation annotation) {
        annotationProvider.getClass();
        annotation.getClass();
        try {
            BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(annotationProvider, annotation, null), 1, null);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    @Deprecated(message = ANNOTATION_PROVIDER_BLOCKING_DEPRECATION_MESSAGE)
    public static final List<Annotation> getAllAnnotationsOfTypeBlocking(AnnotationProvider annotationProvider, EnumSet<AnnotationType> enumSet) {
        annotationProvider.getClass();
        enumSet.getClass();
        try {
            return (List) BuildersKt__BuildersKt.runBlocking$default(null, new C18401(annotationProvider, enumSet, null), 1, null);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return CollectionsKt.emptyList();
        }
    }

    @Deprecated(message = ANNOTATION_PROVIDER_BLOCKING_DEPRECATION_MESSAGE)
    public static final Annotation getAnnotationBlocking(AnnotationProvider annotationProvider, int i, int i2) {
        annotationProvider.getClass();
        try {
            return (Annotation) BuildersKt__BuildersKt.runBlocking$default(null, new C18411(annotationProvider, i, i2, null), 1, null);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Deprecated(message = ANNOTATION_PROVIDER_BLOCKING_DEPRECATION_MESSAGE)
    public static final List<Annotation> getAnnotationsBlocking(AnnotationProvider annotationProvider, int i) {
        annotationProvider.getClass();
        try {
            return (List) BuildersKt__BuildersKt.runBlocking$default(null, new C18431(annotationProvider, i, null), 1, null);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return CollectionsKt.emptyList();
        }
    }

    @Deprecated(message = ANNOTATION_PROVIDER_BLOCKING_DEPRECATION_MESSAGE)
    public static final void removeAnnotationFromPageBlocking(AnnotationProvider annotationProvider, Annotation annotation) {
        annotationProvider.getClass();
        annotation.getClass();
        try {
            BuildersKt__BuildersKt.runBlocking$default(null, new C18441(annotationProvider, annotation, null), 1, null);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    @Deprecated(message = ANNOTATION_PROVIDER_BLOCKING_DEPRECATION_MESSAGE)
    public static final Annotation getAnnotationBlocking(AnnotationProvider annotationProvider, int i, String str) {
        annotationProvider.getClass();
        str.getClass();
        try {
            return (Annotation) BuildersKt__BuildersKt.runBlocking$default(null, new C18422(annotationProvider, i, str, null), 1, null);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Deprecated(message = ANNOTATION_PROVIDER_BLOCKING_DEPRECATION_MESSAGE)
    public static final List<Annotation> getAllAnnotationsOfTypeBlocking(AnnotationProvider annotationProvider, EnumSet<AnnotationType> enumSet, int i, int i2) {
        annotationProvider.getClass();
        enumSet.getClass();
        try {
            return (List) BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass2(annotationProvider, enumSet, i, i2, null), 1, null);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return CollectionsKt.emptyList();
        }
    }
}
