package com.pspdfkit.internal;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.pspdfkit.annotations.stamps.StampPickerItem;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.ui.dialog.stamps.StampPickerDialog$observeViewModel$1", f = "StampPickerDialog.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, nl = {88}, s = {}, v = 2)
public final class e40 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ f40 b;

    @DebugMetadata(c = "com.pspdfkit.internal.ui.dialog.stamps.StampPickerDialog$observeViewModel$1$1", f = "StampPickerDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public /* synthetic */ Object a;
        public final /* synthetic */ f40 b;

        /* JADX INFO: renamed from: com.pspdfkit.internal.e40$a$a, reason: collision with other inner class name */
        @DebugMetadata(c = "com.pspdfkit.internal.ui.dialog.stamps.StampPickerDialog$observeViewModel$1$1$1", f = "StampPickerDialog.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
        public static final class C0268a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int a;
            public final /* synthetic */ f40 b;

            /* JADX INFO: renamed from: com.pspdfkit.internal.e40$a$a$a, reason: collision with other inner class name */
            public static final class C0269a<T> implements FlowCollector {
                public final /* synthetic */ f40 a;

                public C0269a(f40 f40Var) {
                    this.a = f40Var;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    f40 f40Var = this.a;
                    List<StampPickerItem> list = ((x30) obj).a;
                    int i = f40.d;
                    h40 h40Var = f40Var.c;
                    if (h40Var != null) {
                        h40Var.setItems(list);
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0268a(f40 f40Var, Continuation<? super C0268a> continuation) {
                super(2, continuation);
                this.b = f40Var;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0268a(this.b, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return new C0268a(this.b, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    l40 l40Var = this.b.a;
                    if (l40Var == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewmodel");
                        l40Var = null;
                    }
                    StateFlow<x30> stateFlow = l40Var.b;
                    C0269a c0269a = new C0269a(this.b);
                    this.a = 1;
                    if (stateFlow.collect(c0269a, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }

        @DebugMetadata(c = "com.pspdfkit.internal.ui.dialog.stamps.StampPickerDialog$observeViewModel$1$1$2", f = "StampPickerDialog.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
        public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int a;
            public final /* synthetic */ f40 b;

            /* JADX INFO: renamed from: com.pspdfkit.internal.e40$a$b$a, reason: collision with other inner class name */
            public static final class C0270a<T> implements FlowCollector {
                public final /* synthetic */ f40 a;

                public C0270a(f40 f40Var) {
                    this.a = f40Var;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    h40 h40Var;
                    StampPickerItem stampPickerItem = (StampPickerItem) obj;
                    if (stampPickerItem != null && (h40Var = this.a.c) != null) {
                        h40Var.setCustomStampAnnotation(stampPickerItem);
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(f40 f40Var, Continuation<? super b> continuation) {
                super(2, continuation);
                this.b = f40Var;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new b(this.b, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return new b(this.b, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    l40 l40Var = this.b.a;
                    if (l40Var == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewmodel");
                        l40Var = null;
                    }
                    StateFlow<StampPickerItem> stateFlow = l40Var.d;
                    C0270a c0270a = new C0270a(this.b);
                    this.a = 1;
                    if (stateFlow.collect(c0270a, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f40 f40Var, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = f40Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(this.b, continuation);
            aVar.a = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            a aVar = new a(this.b, continuation);
            aVar.a = coroutineScope;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.a;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C0268a(this.b, null), 3, null);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new b(this.b, null), 3, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e40(f40 f40Var, Continuation<? super e40> continuation) {
        super(2, continuation);
        this.b = f40Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new e40(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new e40(this.b, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            f40 f40Var = this.b;
            Lifecycle.State state = Lifecycle.State.STARTED;
            a aVar = new a(f40Var, null);
            this.a = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(f40Var, state, aVar, this) == coroutine_suspended) {
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
