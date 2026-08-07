package com.pspdfkit.internal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import com.facebook.imageutils.JfifUtil;
import com.facebook.imageutils.TiffUtil;
import com.microsoft.intune.mam.client.app.MAMAlertDialogBuilder;
import com.pspdfkit.R;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import com.pspdfkit.annotations.measurements.MeasurementValueConfigurationEditor;
import com.pspdfkit.configuration.rendering.PageRenderConfiguration;
import com.pspdfkit.internal.jni.NativeAnnotation;
import com.pspdfkit.internal.jni.NativeAnnotationManager;
import com.pspdfkit.internal.jni.NativeMeasurementContentFormat;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.inspector.views.MeasurementValueConfigurationPickerListener;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.undo.edit.CompoundEdit;
import com.pspdfkit.undo.edit.Edit;
import com.pspdfkit.undo.edit.annotations.MeasurementValueConfigurationEdit;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes3.dex */
public final class dq implements MeasurementValueConfigurationEditor, at {
    public final lm a;
    public final PdfFragment b;
    public final at c;
    public final ArrayList<Edit> d;
    public final go<MeasurementValueConfigurationEditor.ChangeListener> e;

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.measurements.MeasurementValueConfigurationEditorImpl$add$2", f = "MeasurementValueConfigurationEditorImpl.kt", i = {}, l = {266}, m = "invokeSuspend", n = {}, nl = {TiffUtil.TIFF_TAG_ORIENTATION}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ MeasurementValueConfiguration c;
        public final /* synthetic */ boolean d;

        /* JADX INFO: renamed from: com.pspdfkit.internal.dq$a$a, reason: collision with other inner class name */
        @DebugMetadata(c = "com.pspdfkit.internal.annotations.measurements.MeasurementValueConfigurationEditorImpl$add$2$1", f = "MeasurementValueConfigurationEditorImpl.kt", i = {}, l = {267}, m = "invokeSuspend", n = {}, nl = {273}, s = {}, v = 2)
        public static final class C0265a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int a;
            public final /* synthetic */ dq b;
            public final /* synthetic */ MeasurementValueConfiguration c;
            public final /* synthetic */ boolean d;

            /* JADX INFO: renamed from: com.pspdfkit.internal.dq$a$a$a, reason: collision with other inner class name */
            @DebugMetadata(c = "com.pspdfkit.internal.annotations.measurements.MeasurementValueConfigurationEditorImpl$add$2$1$1", f = "MeasurementValueConfigurationEditorImpl.kt", i = {}, l = {268}, m = "invokeSuspend", n = {}, nl = {269}, s = {}, v = 2)
            public static final class C0266a extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                public int a;
                public final /* synthetic */ dq b;
                public final /* synthetic */ MeasurementValueConfiguration c;
                public final /* synthetic */ boolean d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0266a(dq dqVar, MeasurementValueConfiguration measurementValueConfiguration, boolean z, Continuation<? super C0266a> continuation) {
                    super(1, continuation);
                    this.b = dqVar;
                    this.c = measurementValueConfiguration;
                    this.d = z;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new C0266a(this.b, this.c, this.d, continuation);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super Unit> continuation) {
                    return ((C0266a) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.a;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        dq dqVar = this.b;
                        MeasurementValueConfiguration measurementValueConfiguration = this.c;
                        this.a = 1;
                        lm lmVar = dqVar.a;
                        PageRenderConfiguration pageRenderConfiguration = lm.Q;
                        Object objA = lmVar.a(measurementValueConfiguration, this);
                        if (objA != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            objA = Unit.INSTANCE;
                        }
                        if (objA == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    if (this.d) {
                        dq dqVar2 = this.b;
                        dqVar2.d.add(new MeasurementValueConfigurationEdit.Add(this.c));
                    }
                    go<MeasurementValueConfigurationEditor.ChangeListener> goVar = this.b.e;
                    MeasurementValueConfiguration measurementValueConfiguration2 = this.c;
                    Iterator<MeasurementValueConfigurationEditor.ChangeListener> it = goVar.iterator();
                    while (it.hasNext()) {
                        it.next().onMeasurementValueConfigurationAdded(measurementValueConfiguration2);
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0265a(dq dqVar, MeasurementValueConfiguration measurementValueConfiguration, boolean z, Continuation<? super C0265a> continuation) {
                super(2, continuation);
                this.b = dqVar;
                this.c = measurementValueConfiguration;
                this.d = z;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0265a(this.b, this.c, this.d, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C0265a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    dq dqVar = this.b;
                    C0266a c0266a = new C0266a(dqVar, this.c, this.d, null);
                    this.a = 1;
                    if (dq.a(dqVar, c0266a, this) == coroutine_suspended) {
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
        public a(MeasurementValueConfiguration measurementValueConfiguration, boolean z, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = measurementValueConfiguration;
            this.d = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return dq.this.new a(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MainCoroutineDispatcher main = Dispatchers.getMain();
                C0265a c0265a = new C0265a(dq.this, this.c, this.d, null);
                this.a = 1;
                if (BuildersKt.withContext(main, c0265a, this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.measurements.MeasurementValueConfigurationEditorImpl", f = "MeasurementValueConfigurationEditorImpl.kt", i = {0}, l = {333}, m = "getAnnotationsForConfiguration", n = {"configuration"}, nl = {327}, s = {"L$0"}, v = 2)
    public static final class b extends ContinuationImpl {
        public Object a;
        public /* synthetic */ Object b;
        public int d;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return dq.this.getAnnotationsForConfiguration(null, this);
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.measurements.MeasurementValueConfigurationEditorImpl$getAnnotationsForConfiguration$result$1", f = "MeasurementValueConfigurationEditorImpl.kt", i = {0}, l = {332}, m = "invokeSuspend", n = {"annotationIds"}, nl = {-1}, s = {"L$0"}, v = 2)
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Annotation>>, Object> {
        public Object a;
        public int b;
        public final /* synthetic */ MeasurementValueConfiguration d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(MeasurementValueConfiguration measurementValueConfiguration, Continuation<? super c> continuation) {
            super(2, continuation);
            this.d = measurementValueConfiguration;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return dq.this.new c(this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Annotation>> continuation) {
            return dq.this.new c(this.d, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            NativeAnnotationManager nativeAnnotationManager = dq.this.a.getAnnotationProvider().d;
            MeasurementValueConfiguration measurementValueConfiguration = this.d;
            ArrayList<NativeAnnotation> annotationsForMeasurementContentFormat = nativeAnnotationManager.getAnnotationsForMeasurementContentFormat(new NativeMeasurementContentFormat(measurementValueConfiguration.getName(), mr.a(measurementValueConfiguration.getScale()), mr.a(measurementValueConfiguration.getPrecision())));
            annotationsForMeasurementContentFormat.getClass();
            ArrayList arrayList = new ArrayList();
            int size = annotationsForMeasurementContentFormat.size();
            int i2 = 0;
            while (i2 < size) {
                NativeAnnotation nativeAnnotation = annotationsForMeasurementContentFormat.get(i2);
                i2++;
                Long annotationId = nativeAnnotation.getAnnotationId();
                Integer numBoxInt = annotationId != null ? Boxing.boxInt((int) annotationId.longValue()) : null;
                if (numBoxInt != null) {
                    arrayList.add(numBoxInt);
                }
            }
            o3 annotationProvider = dq.this.a.getAnnotationProvider();
            this.a = SpillingKt.nullOutSpilledVariable(arrayList);
            this.b = 1;
            annotationProvider.getClass();
            Object objA = o3.a(annotationProvider, arrayList, this);
            return objA == coroutine_suspended ? coroutine_suspended : objA;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.measurements.MeasurementValueConfigurationEditorImpl$getUsageCount$2", f = "MeasurementValueConfigurationEditorImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        public final /* synthetic */ MeasurementValueConfiguration b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(MeasurementValueConfiguration measurementValueConfiguration, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = measurementValueConfiguration;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return dq.this.new d(this.b, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return dq.this.new d(this.b, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            NativeAnnotationManager nativeAnnotationManager = dq.this.a.getAnnotationProvider().d;
            MeasurementValueConfiguration measurementValueConfiguration = this.b;
            measurementValueConfiguration.getClass();
            return Boxing.boxInt(nativeAnnotationManager.getAnnotationsForMeasurementContentFormat(new NativeMeasurementContentFormat(measurementValueConfiguration.getName(), mr.a(measurementValueConfiguration.getScale()), mr.a(measurementValueConfiguration.getPrecision()))).size());
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.measurements.MeasurementValueConfigurationEditorImpl$modify$2", f = "MeasurementValueConfigurationEditorImpl.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, nl = {Token.GENEXPR}, s = {}, v = 2)
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ MeasurementValueConfiguration c;
        public final /* synthetic */ MeasurementValueConfiguration d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ boolean f;

        @DebugMetadata(c = "com.pspdfkit.internal.annotations.measurements.MeasurementValueConfigurationEditorImpl$modify$2$1", f = "MeasurementValueConfigurationEditorImpl.kt", i = {0, 0, 1, 1, 2, 2}, l = {Token.LOOP, Token.DOTQUERY, Token.XMLEND}, m = "invokeSuspend", n = {"isJustARename", "isActuallyADeleteOperation", "isJustARename", "isActuallyADeleteOperation", "isJustARename", "isActuallyADeleteOperation"}, nl = {134, Token.XMLEND, Token.TO_DOUBLE}, s = {"Z$0", "I$0", "Z$0", "I$0", "Z$0", "I$0"}, v = 2)
        public static final class a extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            public boolean a;
            public int b;
            public int c;
            public final /* synthetic */ MeasurementValueConfiguration d;
            public final /* synthetic */ MeasurementValueConfiguration e;
            public final /* synthetic */ dq f;
            public final /* synthetic */ boolean g;
            public final /* synthetic */ boolean h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(MeasurementValueConfiguration measurementValueConfiguration, MeasurementValueConfiguration measurementValueConfiguration2, dq dqVar, boolean z, boolean z2, Continuation<? super a> continuation) {
                super(1, continuation);
                this.d = measurementValueConfiguration;
                this.e = measurementValueConfiguration2;
                this.f = dqVar;
                this.g = z;
                this.h = z2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new a(this.d, this.e, this.f, this.g, this.h, continuation);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Unit> continuation) {
                return ((a) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code duplicated, block: B:40:0x00c2  */
            /* JADX WARN: Code duplicated, block: B:42:0x00c5  */
            /* JADX WARN: Code duplicated, block: B:45:0x00de  */
            /* JADX WARN: Code duplicated, block: B:51:0x00e8  */
            /* JADX WARN: Code duplicated, block: B:54:0x0102  */
            /* JADX WARN: Code duplicated, block: B:56:0x0106  */
            /* JADX WARN: Code duplicated, block: B:57:0x010b  */
            /* JADX WARN: Code duplicated, block: B:59:0x010e  */
            /* JADX WARN: Code duplicated, block: B:63:0x0119  */
            /* JADX WARN: Code duplicated, block: B:65:0x011f  */
            /* JADX WARN: Code duplicated, block: B:68:0x0128  */
            /* JADX WARN: Code duplicated, block: B:71:0x0134 A[LOOP:0: B:69:0x012e->B:71:0x0134, LOOP_END] */
            /* JADX WARN: Code duplicated, block: B:72:0x013e  */
            /* JADX WARN: Code duplicated, block: B:75:0x014c A[LOOP:1: B:73:0x0146->B:75:0x014c, LOOP_END] */
            /* JADX WARN: Code restructure failed: missing block: B:46:0x00e0, code lost:
            
                if (r13 == r0) goto L47;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r13) {
                /*
                    Method dump skipped, instruction units count: 345
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.dq.e.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(MeasurementValueConfiguration measurementValueConfiguration, MeasurementValueConfiguration measurementValueConfiguration2, boolean z, boolean z2, Continuation<? super e> continuation) {
            super(2, continuation);
            this.c = measurementValueConfiguration;
            this.d = measurementValueConfiguration2;
            this.e = z;
            this.f = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return dq.this.new e(this.c, this.d, this.e, this.f, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                dq dqVar = dq.this;
                a aVar = new a(this.c, this.d, dqVar, this.e, this.f, null);
                this.a = 1;
                if (dq.a(dqVar, aVar, this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.measurements.MeasurementValueConfigurationEditorImpl$remove$1", f = "MeasurementValueConfigurationEditorImpl.kt", i = {1}, l = {168, Context.VERSION_1_7}, m = "invokeSuspend", n = {"references"}, nl = {169, 192}, s = {"I$0"}, v = 2)
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ MeasurementValueConfiguration c;
        public final /* synthetic */ android.content.Context d;

        @DebugMetadata(c = "com.pspdfkit.internal.annotations.measurements.MeasurementValueConfigurationEditorImpl$remove$1$1", f = "MeasurementValueConfigurationEditorImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ android.content.Context a;
            public final /* synthetic */ int b;
            public final /* synthetic */ dq c;
            public final /* synthetic */ MeasurementValueConfiguration d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(android.content.Context context, int i, dq dqVar, MeasurementValueConfiguration measurementValueConfiguration, Continuation<? super a> continuation) {
                super(2, continuation);
                this.a = context;
                this.b = i;
                this.c = dqVar;
                this.d = measurementValueConfiguration;
            }

            public static final void a(dq dqVar, MeasurementValueConfiguration measurementValueConfiguration, DialogInterface dialogInterface, int i) {
                dqVar.remove(measurementValueConfiguration, true, true);
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
                MAMAlertDialogBuilder mAMAlertDialogBuilder = new MAMAlertDialogBuilder(this.a);
                android.content.Context context = this.a;
                int i = R.plurals.pspdf__measurements_used_elsewhere;
                int i2 = this.b;
                AlertDialog.Builder negativeButton = mAMAlertDialogBuilder.setTitle(no.a(context, i, i2, Boxing.boxInt(i2))).setMessage(this.a.getString(R.string.pspdf__delete_scale_warning)).setCancelable(true).setNegativeButton(R.string.pspdf__cancel, (DialogInterface.OnClickListener) null);
                int i3 = R.string.pspdf__delete;
                final dq dqVar = this.c;
                final MeasurementValueConfiguration measurementValueConfiguration = this.d;
                negativeButton.setPositiveButton(i3, new DialogInterface.OnClickListener() { // from class: com.pspdfkit.internal.dq$f$a$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        dq.f.a.a(dqVar, measurementValueConfiguration, dialogInterface, i4);
                    }
                }).show();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(MeasurementValueConfiguration measurementValueConfiguration, android.content.Context context, Continuation<? super f> continuation) {
            super(2, continuation);
            this.c = measurementValueConfiguration;
            this.d = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return dq.this.new f(this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r11, r4, r10) == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r10.a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r11)
                goto L57
            L12:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L1a:
                kotlin.ResultKt.throwOnFailure(r11)
                goto L2e
            L1e:
                kotlin.ResultKt.throwOnFailure(r11)
                com.pspdfkit.internal.dq r11 = com.pspdfkit.internal.dq.this
                com.pspdfkit.annotations.measurements.MeasurementValueConfiguration r1 = r10.c
                r10.a = r3
                java.lang.Object r11 = r11.getUsageCount(r1, r10)
                if (r11 != r0) goto L2e
                goto L4e
            L2e:
                java.lang.Number r11 = (java.lang.Number) r11
                int r6 = r11.intValue()
                if (r6 <= 0) goto L4f
                kotlinx.coroutines.MainCoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getMain()
                com.pspdfkit.internal.dq$f$a r4 = new com.pspdfkit.internal.dq$f$a
                android.content.Context r5 = r10.d
                com.pspdfkit.internal.dq r7 = com.pspdfkit.internal.dq.this
                com.pspdfkit.annotations.measurements.MeasurementValueConfiguration r8 = r10.c
                r9 = 0
                r4.<init>(r5, r6, r7, r8, r9)
                r10.a = r2
                java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r11, r4, r10)
                if (r10 != r0) goto L57
            L4e:
                return r0
            L4f:
                com.pspdfkit.internal.dq r11 = com.pspdfkit.internal.dq.this
                com.pspdfkit.annotations.measurements.MeasurementValueConfiguration r10 = r10.c
                r0 = 0
                r11.remove(r10, r0, r3)
            L57:
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.dq.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.annotations.measurements.MeasurementValueConfigurationEditorImpl$remove$2", f = "MeasurementValueConfigurationEditorImpl.kt", i = {}, l = {203}, m = "invokeSuspend", n = {}, nl = {JfifUtil.MARKER_RST7}, s = {}, v = 2)
    public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ MeasurementValueConfiguration c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;

        @DebugMetadata(c = "com.pspdfkit.internal.annotations.measurements.MeasurementValueConfigurationEditorImpl$remove$2$1", f = "MeasurementValueConfigurationEditorImpl.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, nl = {214}, s = {}, v = 2)
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int a;
            public final /* synthetic */ dq b;
            public final /* synthetic */ MeasurementValueConfiguration c;
            public final /* synthetic */ boolean d;
            public final /* synthetic */ boolean e;

            /* JADX INFO: renamed from: com.pspdfkit.internal.dq$g$a$a, reason: collision with other inner class name */
            @DebugMetadata(c = "com.pspdfkit.internal.annotations.measurements.MeasurementValueConfigurationEditorImpl$remove$2$1$1", f = "MeasurementValueConfigurationEditorImpl.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, nl = {206}, s = {}, v = 2)
            public static final class C0267a extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                public int a;
                public final /* synthetic */ dq b;
                public final /* synthetic */ MeasurementValueConfiguration c;
                public final /* synthetic */ boolean d;
                public final /* synthetic */ boolean e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0267a(dq dqVar, MeasurementValueConfiguration measurementValueConfiguration, boolean z, boolean z2, Continuation<? super C0267a> continuation) {
                    super(1, continuation);
                    this.b = dqVar;
                    this.c = measurementValueConfiguration;
                    this.d = z;
                    this.e = z2;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new C0267a(this.b, this.c, this.d, this.e, continuation);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super Unit> continuation) {
                    return ((C0267a) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code duplicated, block: B:25:0x0061  */
                /* JADX WARN: Code duplicated, block: B:27:0x0067  */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    o00 o00Var;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.a;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        dq dqVar = this.b;
                        MeasurementValueConfiguration measurementValueConfiguration = this.c;
                        boolean z = this.d;
                        boolean z2 = this.e;
                        this.a = 1;
                        if (dqVar.a(measurementValueConfiguration, z, z2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    if (this.e) {
                        this.b.d.add(new MeasurementValueConfigurationEdit.Delete(this.c));
                    }
                    if (Intrinsics.areEqual(e60.a, this.c)) {
                        if (Intrinsics.areEqual(e60.a, (Object) null)) {
                            MeasurementValueConfiguration measurementValueConfiguration2 = e60.a;
                            if (!Intrinsics.areEqual(measurementValueConfiguration2 != null ? measurementValueConfiguration2.getName() : null, (Object) null)) {
                                e60.a = null;
                                o00Var = e60.b;
                                if (o00Var != null) {
                                    o00Var.a(null);
                                }
                            }
                        } else {
                            e60.a = null;
                            o00Var = e60.b;
                            if (o00Var != null) {
                                o00Var.a(null);
                            }
                        }
                    }
                    go<MeasurementValueConfigurationEditor.ChangeListener> goVar = this.b.e;
                    MeasurementValueConfiguration measurementValueConfiguration3 = this.c;
                    Iterator<MeasurementValueConfigurationEditor.ChangeListener> it = goVar.iterator();
                    while (it.hasNext()) {
                        it.next().onMeasurementValueConfigurationDeleted(measurementValueConfiguration3);
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(dq dqVar, MeasurementValueConfiguration measurementValueConfiguration, boolean z, boolean z2, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = dqVar;
                this.c = measurementValueConfiguration;
                this.d = z;
                this.e = z2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, this.d, this.e, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    dq dqVar = this.b;
                    C0267a c0267a = new C0267a(dqVar, this.c, this.d, this.e, null);
                    this.a = 1;
                    if (dq.a(dqVar, c0267a, this) == coroutine_suspended) {
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
        public g(MeasurementValueConfiguration measurementValueConfiguration, boolean z, boolean z2, Continuation<? super g> continuation) {
            super(2, continuation);
            this.c = measurementValueConfiguration;
            this.d = z;
            this.e = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return dq.this.new g(this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MainCoroutineDispatcher main = Dispatchers.getMain();
                a aVar = new a(dq.this, this.c, this.d, this.e, null);
                this.a = 1;
                if (BuildersKt.withContext(main, aVar, this) == coroutine_suspended) {
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

    public dq(lm lmVar, PdfFragment pdfFragment, at atVar) {
        lmVar.getClass();
        this.a = lmVar;
        this.b = pdfFragment;
        this.c = atVar;
        this.d = new ArrayList<>();
        this.e = new go<>();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(dq dqVar, Function1 function1, ContinuationImpl continuationImpl) {
        gq gqVar;
        at atVar;
        int size;
        if (continuationImpl instanceof gq) {
            gqVar = (gq) continuationImpl;
            int i = gqVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                gqVar.d = i - Integer.MIN_VALUE;
            } else {
                gqVar = new gq(dqVar, continuationImpl);
            }
        } else {
            gqVar = new gq(dqVar, continuationImpl);
        }
        Object obj = gqVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = gqVar.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            dqVar.d.clear();
            gqVar.a = SpillingKt.nullOutSpilledVariable(function1);
            gqVar.d = 1;
            if (function1.invoke(gqVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (!dqVar.d.isEmpty() && (atVar = dqVar.c) != null && (size = dqVar.d.size()) != 0) {
            ArrayList<Edit> arrayList = dqVar.d;
            atVar.a(size != 1 ? new CompoundEdit(CollectionsKt.toList(arrayList)) : (Edit) CollectionsKt.first((List) arrayList));
        }
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.annotations.measurements.MeasurementValueConfigurationEditor
    public final boolean add(android.content.Context context, MeasurementValueConfiguration measurementValueConfiguration, final MeasurementValueConfigurationPickerListener measurementValueConfigurationPickerListener) {
        context.getClass();
        measurementValueConfiguration.getClass();
        measurementValueConfigurationPickerListener.getClass();
        List<MeasurementValueConfiguration> list = this.a.P;
        int iIndexOf = list.indexOf(measurementValueConfiguration);
        if (iIndexOf < 0) {
            add(measurementValueConfiguration, true);
            return true;
        }
        final MeasurementValueConfiguration measurementValueConfiguration2 = list.get(iIndexOf);
        if (Objects.equals(measurementValueConfiguration2.getName(), measurementValueConfiguration.getName())) {
            measurementValueConfigurationPickerListener.onConfigurationPicked(measurementValueConfiguration2);
            return true;
        }
        if (measurementValueConfiguration2.getName() == null) {
            modify(measurementValueConfiguration2, measurementValueConfiguration, false, true);
            return true;
        }
        new MAMAlertDialogBuilder(context).setTitle(context.getString(R.string.pspdf__scale_in_use)).setMessage(context.getString(R.string.pspdf__edit_use_existing_scale)).setCancelable(true).setNegativeButton(context.getString(R.string.pspdf__edit), (DialogInterface.OnClickListener) null).setPositiveButton(context.getString(R.string.pspdf__use_existing), new DialogInterface.OnClickListener() { // from class: com.pspdfkit.internal.dq$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dq.a(measurementValueConfigurationPickerListener, measurementValueConfiguration2, dialogInterface, i);
            }
        }).show();
        return false;
    }

    @Override // com.pspdfkit.annotations.measurements.MeasurementValueConfigurationEditor
    public final void addChangeListener(MeasurementValueConfigurationEditor.ChangeListener changeListener) {
        changeListener.getClass();
        this.e.a(changeListener);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.pspdfkit.annotations.measurements.MeasurementValueConfigurationEditor
    public final Object getAnnotationsForConfiguration(MeasurementValueConfiguration measurementValueConfiguration, Continuation<? super List<? extends Annotation>> continuation) {
        b bVar;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i = bVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                bVar.d = i - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuation);
            }
        } else {
            bVar = new b(continuation);
        }
        Object objAwait = bVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bVar.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objAwait);
            if (measurementValueConfiguration == null) {
                return CollectionsKt.emptyList();
            }
            lm lmVar = this.a;
            CoroutineDispatcher io2 = Dispatchers.getIO();
            c cVar = new c(measurementValueConfiguration, null);
            lmVar.getClass();
            io2.getClass();
            Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(lmVar.b, io2, null, cVar, 2, null);
            bVar.a = SpillingKt.nullOutSpilledVariable(measurementValueConfiguration);
            bVar.d = 1;
            objAwait = deferredAsync$default.await(bVar);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objAwait);
        }
        return (List) objAwait;
    }

    @Override // com.pspdfkit.annotations.measurements.MeasurementValueConfigurationEditor
    public final List<MeasurementValueConfiguration> getConfigurations() {
        return this.a.P;
    }

    @Override // com.pspdfkit.annotations.measurements.MeasurementValueConfigurationEditor
    public final Object getUsageCount(MeasurementValueConfiguration measurementValueConfiguration, Continuation<? super Integer> continuation) {
        lm lmVar = this.a;
        CoroutineDispatcher io2 = Dispatchers.getIO();
        d dVar = new d(measurementValueConfiguration, null);
        lmVar.getClass();
        io2.getClass();
        return BuildersKt__Builders_commonKt.async$default(lmVar.b, io2, null, dVar, 2, null).await(continuation);
    }

    @Override // com.pspdfkit.annotations.measurements.MeasurementValueConfigurationEditor
    public final boolean modify(android.content.Context context, final MeasurementValueConfiguration measurementValueConfiguration, MeasurementValueConfiguration measurementValueConfiguration2, final MeasurementValueConfigurationPickerListener measurementValueConfigurationPickerListener) {
        context.getClass();
        measurementValueConfiguration.getClass();
        measurementValueConfiguration2.getClass();
        measurementValueConfigurationPickerListener.getClass();
        List<MeasurementValueConfiguration> list = this.a.P;
        if (Intrinsics.areEqual(measurementValueConfiguration, measurementValueConfiguration2)) {
            if (Intrinsics.areEqual(measurementValueConfiguration.getName(), measurementValueConfiguration2.getName())) {
                return true;
            }
            modify(measurementValueConfiguration, measurementValueConfiguration2, false, true);
            return true;
        }
        int iIndexOf = list.indexOf(measurementValueConfiguration2);
        if (iIndexOf < 0) {
            modify(measurementValueConfiguration, measurementValueConfiguration2, true, true);
            return true;
        }
        final MeasurementValueConfiguration measurementValueConfiguration3 = list.get(iIndexOf);
        new MAMAlertDialogBuilder(context).setTitle(context.getString(R.string.pspdf__scale_in_use)).setMessage(context.getString(R.string.pspdf__edit_use_existing_scale)).setCancelable(true).setNegativeButton(context.getString(R.string.pspdf__edit), (DialogInterface.OnClickListener) null).setPositiveButton(context.getString(R.string.pspdf__use_existing), new DialogInterface.OnClickListener() { // from class: com.pspdfkit.internal.dq$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dq.a(this.f$0, measurementValueConfiguration, measurementValueConfiguration3, measurementValueConfigurationPickerListener, dialogInterface, i);
            }
        }).show();
        return false;
    }

    @Override // com.pspdfkit.annotations.measurements.MeasurementValueConfigurationEditor
    public final void remove(android.content.Context context, MeasurementValueConfiguration measurementValueConfiguration) {
        context.getClass();
        measurementValueConfiguration.getClass();
        lm lmVar = this.a;
        f fVar = new f(measurementValueConfiguration, context, null);
        PageRenderConfiguration pageRenderConfiguration = lm.Q;
        lmVar.a(EmptyCoroutineContext.INSTANCE, fVar);
    }

    @Override // com.pspdfkit.annotations.measurements.MeasurementValueConfigurationEditor
    public final void removeChangeListener(MeasurementValueConfigurationEditor.ChangeListener changeListener) {
        changeListener.getClass();
        this.e.b(changeListener);
    }

    @Override // com.pspdfkit.annotations.measurements.MeasurementValueConfigurationEditor
    public final void startCalibrationTool() {
        PdfFragment pdfFragment = this.b;
        pdfFragment.exitCurrentlyActiveMode();
        pdfFragment.enterAnnotatingMode(AnnotationTool.MEASUREMENT_SCALE_CALIBRATION);
    }

    @Override // com.pspdfkit.annotations.measurements.MeasurementValueConfigurationEditor
    public final void remove(MeasurementValueConfiguration measurementValueConfiguration, boolean z, boolean z2) {
        measurementValueConfiguration.getClass();
        lm lmVar = this.a;
        g gVar = new g(measurementValueConfiguration, z, z2, null);
        PageRenderConfiguration pageRenderConfiguration = lm.Q;
        lmVar.a(EmptyCoroutineContext.INSTANCE, gVar);
    }

    @Override // com.pspdfkit.annotations.measurements.MeasurementValueConfigurationEditor
    public final void modify(MeasurementValueConfiguration measurementValueConfiguration, MeasurementValueConfiguration measurementValueConfiguration2, boolean z, boolean z2) {
        measurementValueConfiguration.getClass();
        measurementValueConfiguration2.getClass();
        if (measurementValueConfiguration.equalsAll(measurementValueConfiguration2)) {
            return;
        }
        this.a.a(Dispatchers.getMain(), new e(measurementValueConfiguration, measurementValueConfiguration2, z, z2, null));
    }

    @Override // com.pspdfkit.annotations.measurements.MeasurementValueConfigurationEditor
    public final void add(MeasurementValueConfiguration measurementValueConfiguration, boolean z) {
        measurementValueConfiguration.getClass();
        lm lmVar = this.a;
        a aVar = new a(measurementValueConfiguration, z, null);
        PageRenderConfiguration pageRenderConfiguration = lm.Q;
        lmVar.a(EmptyCoroutineContext.INSTANCE, aVar);
    }

    public static final void a(dq dqVar, MeasurementValueConfiguration measurementValueConfiguration, MeasurementValueConfiguration measurementValueConfiguration2, MeasurementValueConfigurationPickerListener measurementValueConfigurationPickerListener, DialogInterface dialogInterface, int i) {
        dqVar.modify(measurementValueConfiguration, measurementValueConfiguration2, true, true);
        measurementValueConfigurationPickerListener.onConfigurationPicked(measurementValueConfiguration2);
    }

    public static final void a(MeasurementValueConfigurationPickerListener measurementValueConfigurationPickerListener, MeasurementValueConfiguration measurementValueConfiguration, DialogInterface dialogInterface, int i) {
        measurementValueConfigurationPickerListener.onConfigurationPicked(measurementValueConfiguration);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
    
        if (r9 == r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0086, code lost:
    
        if (r5.a(r6, r0) == r1) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(com.pspdfkit.annotations.measurements.MeasurementValueConfiguration r6, boolean r7, final boolean r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.pspdfkit.internal.eq
            if (r0 == 0) goto L13
            r0 = r9
            com.pspdfkit.internal.eq r0 = (com.pspdfkit.internal.eq) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            com.pspdfkit.internal.eq r0 = new com.pspdfkit.internal.eq
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r5 = r0.a
            com.pspdfkit.annotations.measurements.MeasurementValueConfiguration r5 = (com.pspdfkit.annotations.measurements.MeasurementValueConfiguration) r5
            kotlin.ResultKt.throwOnFailure(r9)
            goto L89
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            boolean r8 = r0.c
            boolean r7 = r0.b
            java.lang.Object r6 = r0.a
            com.pspdfkit.annotations.measurements.MeasurementValueConfiguration r6 = (com.pspdfkit.annotations.measurements.MeasurementValueConfiguration) r6
            kotlin.ResultKt.throwOnFailure(r9)
            goto L58
        L44:
            kotlin.ResultKt.throwOnFailure(r9)
            if (r7 == 0) goto L72
            r0.a = r6
            r0.b = r7
            r0.c = r8
            r0.f = r4
            java.lang.Object r9 = r5.getAnnotationsForConfiguration(r6, r0)
            if (r9 != r1) goto L58
            goto L88
        L58:
            java.util.List r9 = (java.util.List) r9
            boolean r2 = r9.isEmpty()
            if (r2 != 0) goto L72
            com.pspdfkit.internal.lm r2 = r5.a
            com.pspdfkit.internal.o3 r2 = r2.getAnnotationProvider()
            com.pspdfkit.internal.dq$$ExternalSyntheticLambda1 r4 = new com.pspdfkit.internal.dq$$ExternalSyntheticLambda1
            r4.<init>()
            r2.getClass()
            r9 = 0
            r2.a(r9, r4)
        L72:
            com.pspdfkit.internal.lm r5 = r5.a
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.a = r9
            r0.b = r7
            r0.c = r8
            r0.f = r3
            com.pspdfkit.configuration.rendering.PageRenderConfiguration r7 = com.pspdfkit.internal.lm.Q
            java.lang.Object r5 = r5.a(r6, r0)
            if (r5 != r1) goto L89
        L88:
            return r1
        L89:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.dq.a(com.pspdfkit.annotations.measurements.MeasurementValueConfiguration, boolean, boolean, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // com.pspdfkit.internal.at
    public final void a(Edit edit) {
        edit.getClass();
        this.d.add(edit);
    }

    public static final void a(List list, o3 o3Var, boolean z) throws InterruptedException {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Annotation annotation = (Annotation) it.next();
            BuildersKt__BuildersKt.runBlocking$default(null, new fq(o3Var, annotation, z, null), 1, null);
            i0 i0VarA = ar.a();
            i0VarA.getClass();
            Bundle bundle = new Bundle();
            bundle.putString(Analytics.Data.ANNOTATION_TYPE, annotation.getType().name());
            bundle.putInt(Analytics.Data.PAGE_INDEX, annotation.getPageIndex());
            i0VarA.a(Analytics.Event.DELETE_ANNOTATION, bundle);
        }
    }
}
