package sdk.pendo.io.o7;

import android.app.Activity;
import android.app.Application;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import external.sdk.pendo.io.mozilla.javascript.Token;
import io.split.android.client.service.ServiceConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.sync.Mutex;
import org.json.JSONArray;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.activities.PendoGuideVisualActivity;
import sdk.pendo.io.h7.r;
import sdk.pendo.io.h7.s;
import sdk.pendo.io.j7.v;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.SessionData;
import sdk.pendo.io.s7.e1;
import sdk.pendo.io.s7.x;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u0000 ^2\u00020\u0001:\u0001\tBQ\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010X\u001a\u00020W\u0012\u0006\u0010Y\u001a\u00020W\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u0012\b\b\u0002\u0010\"\u001a\u00020 \u0012\b\b\u0002\u0010$\u001a\u00020 \u0012\b\b\u0002\u0010[\u001a\u00020Z¢\u0006\u0004\b\\\u0010]J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0014J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\t\u001a\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\fJ\u0013\u0010\r\u001a\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\fJ\u001b\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\fJ\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0013\u0010\u000b\u001a\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001b\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u000eJ\b\u0010\u0012\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\u0012\u0010\u000f\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010!R\u0014\u0010$\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010!R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b\u001a\u0010(R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\b0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\b0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010,R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u001e\u00107\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R$\u0010=\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020:\u0018\u000109088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R$\u0010C\u001a\u0010\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020@\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020E0D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u001b\u0010L\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010'\u001a\u0004\b\u0016\u0010KR\u001b\u0010Q\u001a\u00020M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010'\u001a\u0004\bO\u0010PR\u001b\u0010V\u001a\u00020R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010'\u001a\u0004\bT\u0010U\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006_"}, d2 = {"Lsdk/pendo/io/o7/e;", "Lsdk/pendo/io/o7/a;", "Landroid/app/Activity;", "activity", "Lsdk/pendo/io/models/SessionData;", "data", "Lsdk/pendo/io/h7/m;", "config", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Landroid/app/Activity;Lsdk/pendo/io/models/SessionData;Lsdk/pendo/io/h7/m;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "Landroid/view/MotionEvent;", "motionEvent", "r", "s", "", "Landroid/app/Application;", "p", "Landroid/app/Application;", "applicationContext", "Lsdk/pendo/io/Pendo$PendoOptions$Framework;", "q", "Lsdk/pendo/io/Pendo$PendoOptions$Framework;", "framework", "Lsdk/pendo/io/p5/a;", "Lsdk/pendo/io/p5/a;", "pendoComponents", "", "J", "scanDebounceMs", "t", "scanTimeoutMs", "Lsdk/pendo/io/r7/h;", "u", "Lkotlin/Lazy;", "()Lsdk/pendo/io/r7/h;", "scanner", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "v", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "onDrawEventFlow", "w", "onFocusChangedEventFlow", "Lkotlinx/coroutines/Job;", "x", "Lkotlinx/coroutines/Job;", "onFocusEventCollectionJob", "Ljava/lang/ref/WeakReference;", "y", "Ljava/lang/ref/WeakReference;", "currentActivityRef", "Ljava/util/concurrent/atomic/AtomicReference;", "", "Lsdk/pendo/io/s7/e1$a;", "z", "Ljava/util/concurrent/atomic/AtomicReference;", "currentVisibleRoots", "Lkotlin/Pair;", "Landroid/view/ViewGroup;", "Lsdk/pendo/io/s5/c;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lkotlin/Pair;", "attachedTouchObserver", "", "Landroid/view/ViewTreeObserver;", "B", "Ljava/util/List;", "attachedTreeObservers", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "C", "()Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "onWindowFocusChangeListener", "Landroid/view/ViewTreeObserver$OnDrawListener;", "D", "o", "()Landroid/view/ViewTreeObserver$OnDrawListener;", "onDrawListener", "Lsdk/pendo/io/z6/c;", ExifInterface.LONGITUDE_EAST, "n", "()Lsdk/pendo/io/z6/c;", "lifeCycleCallbacksListener", "", ServiceConstants.WORKER_PARAM_API_KEY, "baseUrl", "Lsdk/pendo/io/z6/b;", "dispatcherProvider", "<init>", "(Landroid/app/Application;Ljava/lang/String;Ljava/lang/String;Lsdk/pendo/io/Pendo$PendoOptions$Framework;Lsdk/pendo/io/p5/a;JJLsdk/pendo/io/z6/b;)V", "F", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public class e extends a {

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private Pair<? extends ViewGroup, ? extends sdk.pendo.io.s5.c> attachedTouchObserver;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    private final List<ViewTreeObserver> attachedTreeObservers;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    private final Lazy onWindowFocusChangeListener;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    private final Lazy onDrawListener;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    private final Lazy lifeCycleCallbacksListener;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private final Application applicationContext;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private final Pendo.PendoOptions.Framework framework;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    private final sdk.pendo.io.p5.a pendoComponents;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    private final long scanDebounceMs;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    private final long scanTimeoutMs;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    private final Lazy scanner;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    private final MutableSharedFlow<Unit> onDrawEventFlow;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    private final MutableSharedFlow<Unit> onFocusChangedEventFlow;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    private Job onFocusEventCollectionJob;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    private WeakReference<Activity> currentActivityRef;

    /* JADX INFO: renamed from: z, reason: from kotlin metadata */
    private AtomicReference<List<e1.a>> currentVisibleRoots;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.managers.SRNativeManager$addWindowsStatesListeners$2", f = "SRNativeManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        private /* synthetic */ Object b;

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* synthetic */ class a extends FunctionReferenceImpl implements Function1<MotionEvent, Unit> {
            a(Object obj) {
                super(1, obj, e.class, "handleTouchEvent", "handleTouchEvent(Landroid/view/MotionEvent;)V", 0);
            }

            public final void a(MotionEvent motionEvent) {
                ((e) this.receiver).a(motionEvent);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MotionEvent motionEvent) {
                a(motionEvent);
                return Unit.INSTANCE;
            }
        }

        b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = e.this.new b(continuation);
            bVar.b = obj;
            return bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ArrayList<View> arrayList;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List list = (List) e.this.currentVisibleRoots.get();
            if (list != null) {
                arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    WeakReference<View> weakReference = ((e1.a) it.next()).a;
                    View view = weakReference != null ? weakReference.get() : null;
                    if (view != null) {
                        arrayList.add(view);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList == null || arrayList.isEmpty()) {
                PendoLogger.d("SRManager", "addWindowsStatesListeners -> no visible roots found");
            } else {
                e eVar = e.this;
                for (View view2 : arrayList) {
                    ViewGroup viewGroup = view2 instanceof ViewGroup ? (ViewGroup) view2 : null;
                    if (viewGroup == null) {
                        PendoLogger.d("SRManager", "addWindowsStatesListeners -> window decorView is null");
                    } else {
                        ViewTreeObserver viewTreeObserver = viewGroup.getViewTreeObserver();
                        if (viewTreeObserver.isAlive()) {
                            viewTreeObserver.addOnDrawListener(eVar.o());
                            viewTreeObserver.addOnWindowFocusChangeListener(eVar.p());
                            List list2 = eVar.attachedTreeObservers;
                            Intrinsics.checkNotNull(viewTreeObserver);
                            list2.add(viewTreeObserver);
                        }
                    }
                }
                Object objLast = CollectionsKt.last((List<? extends Object>) arrayList);
                Intrinsics.checkNotNullExpressionValue(objLast, "last(...)");
                View view3 = (View) objLast;
                ViewGroup viewGroup2 = view3 instanceof ViewGroup ? (ViewGroup) view3 : null;
                if (viewGroup2 == null) {
                    return Unit.INSTANCE;
                }
                try {
                    PendoLogger.d("SRManager", "addWindowsStatesListeners add touch observer to top-most decorView: " + viewGroup2 + " with hash: " + viewGroup2.hashCode());
                    sdk.pendo.io.r7.d dVar = new sdk.pendo.io.r7.d(new a(e.this));
                    e.this.attachedTouchObserver = TuplesKt.to(viewGroup2, dVar);
                    sdk.pendo.io.s5.a.a.a(viewGroup2, dVar);
                } catch (Exception e) {
                    PendoLogger.d("SRManager", "addWindowsStatesListeners error: " + e);
                }
                e.this.r();
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.managers.SRNativeManager", f = "SRNativeManager.kt", i = {0, 0, 1, 1}, l = {218, 226}, m = "createLayoutChangesListeners", n = {"this", "activity", "this", "activity"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class c extends ContinuationImpl {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return e.this.a((Activity) null, this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.managers.SRNativeManager$createLayoutChangesListeners$2", f = "SRNativeManager.kt", i = {}, l = {231}, m = "invokeSuspend", n = {}, s = {})
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
        @DebugMetadata(c = "sdk.pendo.io.sessionreplay.managers.SRNativeManager$createLayoutChangesListeners$2$1", f = "SRNativeManager.kt", i = {}, l = {234}, m = "invokeSuspend", n = {}, s = {})
        static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int a;
            final /* synthetic */ e b;

            /* JADX INFO: renamed from: sdk.pendo.io.o7.e$d$a$a, reason: collision with other inner class name */
            @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "it", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lkotlin/Unit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0})
            static final class C0452a<T> implements FlowCollector {
                final /* synthetic */ e a;

                /* JADX INFO: renamed from: sdk.pendo.io.o7.e$d$a$a$a, reason: collision with other inner class name */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "sdk.pendo.io.sessionreplay.managers.SRNativeManager$createLayoutChangesListeners$2$1$1", f = "SRNativeManager.kt", i = {}, l = {236}, m = "emit", n = {}, s = {})
                static final class C0453a extends ContinuationImpl {
                    /* synthetic */ Object a;
                    final /* synthetic */ C0452a<T> b;
                    int c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C0453a(C0452a<? super T> c0452a, Continuation<? super C0453a> continuation) {
                        super(continuation);
                        this.b = c0452a;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.c |= Integer.MIN_VALUE;
                        return this.b.emit(null, this);
                    }
                }

                C0452a(e eVar) {
                    this.a = eVar;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(Unit unit, Continuation<? super Unit> continuation) {
                    C0453a c0453a;
                    if (continuation instanceof C0453a) {
                        c0453a = (C0453a) continuation;
                        int i = c0453a.c;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            c0453a.c = i - Integer.MIN_VALUE;
                        } else {
                            c0453a = new C0453a(this, continuation);
                        }
                    } else {
                        c0453a = new C0453a(this, continuation);
                    }
                    Object obj = c0453a.a;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = c0453a.c;
                    try {
                        if (i2 == 0) {
                            ResultKt.throwOnFailure(obj);
                            e eVar = this.a;
                            c0453a.c = 1;
                            if (eVar.b(c0453a) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i2 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                    } catch (CancellationException e) {
                        throw e;
                    } catch (Exception e2) {
                        PendoLogger.e("SRManager", "handleOnDrawEvent: " + e2, e2);
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(e eVar, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = eVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Flow flowA = x.a(this.b.onDrawEventFlow, this.b.scanDebounceMs, this.b.scanTimeoutMs);
                    C0452a c0452a = new C0452a(this.b);
                    this.a = 1;
                    if (flowA.collect(c0452a, this) == coroutine_suspended) {
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

        d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e.this.new d(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher coroutineDispatcherC = e.this.getDispatcherProvider().c();
                a aVar = new a(e.this, null);
                this.a = 1;
                if (BuildersKt.withContext(coroutineDispatcherC, aVar, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: sdk.pendo.io.o7.e$e, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.managers.SRNativeManager$createLayoutChangesListeners$3", f = "SRNativeManager.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
    static final class C0454e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;

        /* JADX INFO: renamed from: sdk.pendo.io.o7.e$e$a */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
        @DebugMetadata(c = "sdk.pendo.io.sessionreplay.managers.SRNativeManager$createLayoutChangesListeners$3$1", f = "SRNativeManager.kt", i = {}, l = {252}, m = "invokeSuspend", n = {}, s = {})
        static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int a;
            final /* synthetic */ e b;

            /* JADX INFO: renamed from: sdk.pendo.io.o7.e$e$a$a, reason: collision with other inner class name */
            @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "it", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lkotlin/Unit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0})
            static final class C0455a<T> implements FlowCollector {
                final /* synthetic */ e a;

                /* JADX INFO: renamed from: sdk.pendo.io.o7.e$e$a$a$a, reason: collision with other inner class name */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "sdk.pendo.io.sessionreplay.managers.SRNativeManager$createLayoutChangesListeners$3$1$1", f = "SRNativeManager.kt", i = {}, l = {254}, m = "emit", n = {}, s = {})
                static final class C0456a extends ContinuationImpl {
                    /* synthetic */ Object a;
                    final /* synthetic */ C0455a<T> b;
                    int c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C0456a(C0455a<? super T> c0455a, Continuation<? super C0456a> continuation) {
                        super(continuation);
                        this.b = c0455a;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.c |= Integer.MIN_VALUE;
                        return this.b.emit(null, this);
                    }
                }

                C0455a(e eVar) {
                    this.a = eVar;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(Unit unit, Continuation<? super Unit> continuation) {
                    C0456a c0456a;
                    if (continuation instanceof C0456a) {
                        c0456a = (C0456a) continuation;
                        int i = c0456a.c;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            c0456a.c = i - Integer.MIN_VALUE;
                        } else {
                            c0456a = new C0456a(this, continuation);
                        }
                    } else {
                        c0456a = new C0456a(this, continuation);
                    }
                    Object obj = c0456a.a;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = c0456a.c;
                    try {
                        if (i2 == 0) {
                            ResultKt.throwOnFailure(obj);
                            e eVar = this.a;
                            c0456a.c = 1;
                            if (eVar.c(c0456a) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i2 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                    } catch (CancellationException e) {
                        throw e;
                    } catch (Exception e2) {
                        PendoLogger.e("SRManager", "handleOnFocusChangedEvent: " + e2, e2);
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(e eVar, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = eVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Flow flowA = x.a(this.b.onFocusChangedEventFlow, 50L, 150L);
                    C0455a c0455a = new C0455a(this.b);
                    this.a = 1;
                    if (flowA.collect(c0455a, this) == coroutine_suspended) {
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

        C0454e(Continuation<? super C0454e> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0454e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e.this.new C0454e(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher coroutineDispatcherC = e.this.getDispatcherProvider().c();
                a aVar = new a(e.this, null);
                this.a = 1;
                if (BuildersKt.withContext(coroutineDispatcherC, aVar, this) == coroutine_suspended) {
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

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.managers.SRNativeManager", f = "SRNativeManager.kt", i = {0, 0, 1, 1}, l = {424, 275}, m = "handleOnDrawEvent", n = {"this", "$this$withLock_u24default$iv", "this", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class f extends ContinuationImpl {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        f(Continuation<? super f> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return e.this.b(this);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lsdk/pendo/io/j7/v;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.managers.SRNativeManager$handleOnDrawEvent$2$1$childNodes$1", f = "SRNativeManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends v>>, Object> {
        int a;
        final /* synthetic */ List<e1.a> c;
        final /* synthetic */ s d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        g(List<? extends e1.a> list, s sVar, Continuation<? super g> continuation) {
            super(2, continuation);
            this.c = list;
            this.d = sVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends v>> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e.this.new g(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return e.this.q().a(this.c, this.d, e.this.getDisplayData());
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.managers.SRNativeManager", f = "SRNativeManager.kt", i = {0, 0, 1, 1, 2}, l = {424, 343, 349}, m = "handleOnFocusChangedEvent", n = {"this", "$this$withLock_u24default$iv", "this", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0"})
    static final class h extends ContinuationImpl {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        h(Continuation<? super h> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return e.this.c(this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.managers.SRNativeManager$handleTouchEvent$1", f = "SRNativeManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class i extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ MotionEvent b;
        final /* synthetic */ e c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(MotionEvent motionEvent, e eVar, Continuation<? super i> continuation) {
            super(2, continuation);
            this.b = motionEvent;
            this.c = eVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((i) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new i(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            sdk.pendo.io.h7.x xVar;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            MotionEvent motionEvent = this.b;
            Intrinsics.checkNotNull(motionEvent);
            int action = motionEvent.getAction();
            if (action == 0) {
                xVar = sdk.pendo.io.h7.x.TOUCH_START;
            } else {
                if (action != 1 && action != 3) {
                    return Unit.INSTANCE;
                }
                xVar = sdk.pendo.io.h7.x.TOUCH_END;
            }
            sdk.pendo.io.h7.h hVar = new sdk.pendo.io.h7.h(System.currentTimeMillis(), this.c.pendoComponents.b().getCurrentScreenId(), xVar.getValue(), this.b.getRawX() - this.c.getDisplayData().getLeftInset(), this.b.getRawY() - this.c.getDisplayData().getTopInset());
            sdk.pendo.io.p7.c recordingsManager = this.c.getRecordingsManager();
            if (recordingsManager != null) {
                recordingsManager.a(hVar);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0007\n\u0002\b\u0003*\u0001\u0000\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"sdk/pendo/io/o7/e$j$a", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Lsdk/pendo/io/o7/e$j$a;"}, k = 3, mv = {1, 9, 0})
    static final class j extends Lambda implements Function0<a> {

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"sdk/pendo/io/o7/e$j$a", "Lsdk/pendo/io/z6/c;", "Landroid/app/Activity;", "activity", "", "onActivityResumed", "onActivityPaused", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
        public static final class a extends sdk.pendo.io.z6.c {
            final /* synthetic */ e a;

            /* JADX INFO: renamed from: sdk.pendo.io.o7.e$j$a$a, reason: collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
            @DebugMetadata(c = "sdk.pendo.io.sessionreplay.managers.SRNativeManager$lifeCycleCallbacksListener$2$1$onActivityPaused$1", f = "SRNativeManager.kt", i = {}, l = {171}, m = "invokeSuspend", n = {}, s = {})
            static final class C0457a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int a;
                final /* synthetic */ e b;
                final /* synthetic */ Activity c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0457a(e eVar, Activity activity, Continuation<? super C0457a> continuation) {
                    super(2, continuation);
                    this.b = eVar;
                    this.c = activity;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C0457a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C0457a(this.b, this.c, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.a;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        e eVar = this.b;
                        Activity activity = this.c;
                        this.a = 1;
                        if (eVar.b(activity, this) == coroutine_suspended) {
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

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"sdk/pendo/io/o7/e$j$a$b", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "", "hasFocus", "", "onWindowFocusChanged", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
            public static final class b implements ViewTreeObserver.OnWindowFocusChangeListener {
                final /* synthetic */ Activity a;
                final /* synthetic */ e b;

                /* JADX INFO: renamed from: sdk.pendo.io.o7.e$j$a$b$a, reason: collision with other inner class name */
                @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
                @DebugMetadata(c = "sdk.pendo.io.sessionreplay.managers.SRNativeManager$lifeCycleCallbacksListener$2$1$onActivityResumed$1$onWindowFocusChanged$2", f = "SRNativeManager.kt", i = {}, l = {Token.LETEXPR}, m = "invokeSuspend", n = {}, s = {})
                static final class C0458a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    int a;
                    final /* synthetic */ e b;
                    final /* synthetic */ Activity c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0458a(e eVar, Activity activity, Continuation<? super C0458a> continuation) {
                        super(2, continuation);
                        this.b = eVar;
                        this.c = activity;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C0458a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C0458a(this.b, this.c, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.a;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            e eVar = this.b;
                            Activity activity = this.c;
                            this.a = 1;
                            if (eVar.a(activity, this) == coroutine_suspended) {
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

                b(Activity activity, e eVar) {
                    this.a = activity;
                    this.b = eVar;
                }

                @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
                public void onWindowFocusChanged(boolean hasFocus) {
                    if (hasFocus) {
                        ViewTreeObserver viewTreeObserver = this.a.getWindow().getDecorView().getViewTreeObserver();
                        if (viewTreeObserver != null) {
                            if (!viewTreeObserver.isAlive()) {
                                viewTreeObserver = null;
                            }
                            if (viewTreeObserver != null) {
                                viewTreeObserver.removeOnWindowFocusChangeListener(this);
                            }
                        }
                        BuildersKt__Builders_commonKt.launch$default(this.b.getCoroutineScope(), null, null, new C0458a(this.b, this.a, null), 3, null);
                    }
                }
            }

            a(e eVar) {
                this.a = eVar;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                PendoLogger.i("SRManager", "onActivityPaused: " + activity);
                this.a.c();
                BuildersKt__Builders_commonKt.launch$default(this.a.getCoroutineScope(), null, null, new C0457a(this.a, activity, null), 3, null);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                PendoLogger.i("SRManager", "onActivityResumed: " + activity);
                ViewTreeObserver viewTreeObserver = activity.getWindow().getDecorView().getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnWindowFocusChangeListener(new b(activity, this.a));
                }
            }
        }

        j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a invoke() {
            return new a(e.this);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/view/ViewTreeObserver$OnDrawListener;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Landroid/view/ViewTreeObserver$OnDrawListener;"}, k = 3, mv = {1, 9, 0})
    static final class k extends Lambda implements Function0<ViewTreeObserver.OnDrawListener> {
        k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ViewTreeObserver.OnDrawListener invoke() {
            final e eVar = e.this;
            return new ViewTreeObserver.OnDrawListener() { // from class: sdk.pendo.io.o7.e$k$$ExternalSyntheticLambda0
                @Override // android.view.ViewTreeObserver.OnDrawListener
                public final void onDraw() {
                    e.k.a(eVar);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(e this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.r();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.managers.SRNativeManager$onStopSession$1", f = "SRNativeManager.kt", i = {}, l = {202}, m = "invokeSuspend", n = {}, s = {})
    static final class l extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;

        l(Continuation<? super l> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((l) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e.this.new l(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Activity activity;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (e.this.getRecordingsManager() == null) {
                    return Unit.INSTANCE;
                }
                WeakReference weakReference = e.this.currentActivityRef;
                Activity activity2 = weakReference != null ? (Activity) weakReference.get() : null;
                sdk.pendo.io.p7.c recordingsManager = e.this.getRecordingsManager();
                PendoLogger.i("SRManager", "onStopSession -> " + activity2 + " visitor:" + (recordingsManager != null ? recordingsManager.getSessionVisitorId() : null));
                e.this.applicationContext.unregisterActivityLifecycleCallbacks(e.this.n());
                WeakReference weakReference2 = e.this.currentActivityRef;
                if (weakReference2 != null && (activity = (Activity) weakReference2.get()) != null) {
                    e eVar = e.this;
                    this.a = 1;
                    if (eVar.b(activity, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            e.this.a((sdk.pendo.io.h7.m) null);
            e.this.a((s) null);
            sdk.pendo.io.p7.c recordingsManager2 = e.this.getRecordingsManager();
            if (recordingsManager2 != null) {
                recordingsManager2.a();
            }
            e.this.a((sdk.pendo.io.p7.c) null);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;"}, k = 3, mv = {1, 9, 0})
    static final class m extends Lambda implements Function0<ViewTreeObserver.OnWindowFocusChangeListener> {
        m() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ViewTreeObserver.OnWindowFocusChangeListener invoke() {
            final e eVar = e.this;
            return new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: sdk.pendo.io.o7.e$m$$ExternalSyntheticLambda0
                @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
                public final void onWindowFocusChanged(boolean z) {
                    e.m.a(eVar, z);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(e this$0, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.s();
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.managers.SRNativeManager", f = "SRNativeManager.kt", i = {0}, l = {368}, m = "removeLayoutChangesListeners", n = {"this"}, s = {"L$0"})
    static final class n extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        int d;

        n(Continuation<? super n> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return e.this.b((Activity) null, this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sessionreplay.managers.SRNativeManager$removeWindowsStatesListeners$2", f = "SRNativeManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class o extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;

        o(Continuation<? super o> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((o) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e.this.new o(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PendoLogger.d("SRManager", "removeWindowsStatesListeners tree observers: " + e.this.attachedTreeObservers.size() + ", touch observer: " + e.this.attachedTouchObserver);
            List<ViewTreeObserver> list = e.this.attachedTreeObservers;
            e eVar = e.this;
            for (ViewTreeObserver viewTreeObserver : list) {
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnDrawListener(eVar.o());
                    viewTreeObserver.removeOnWindowFocusChangeListener(eVar.p());
                }
            }
            Pair pair = e.this.attachedTouchObserver;
            if (pair != null) {
                sdk.pendo.io.s5.a.a.b((ViewGroup) pair.component1(), (sdk.pendo.io.s5.c) pair.component2());
            }
            e.this.attachedTouchObserver = null;
            e.this.attachedTreeObservers.clear();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lsdk/pendo/io/c3/a;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Lsdk/pendo/io/c3/a;"}, k = 3, mv = {1, 9, 0})
    static final class p extends Lambda implements Function0<sdk.pendo.io.c3.a> {
        p() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final sdk.pendo.io.c3.a invoke() {
            return sdk.pendo.io.c3.b.a(e.this.framework);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0004\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "invoke", "()Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class q extends Lambda implements Function0<sdk.pendo.io.r7.h> {
        final /* synthetic */ sdk.pendo.io.v2.a a;
        final /* synthetic */ sdk.pendo.io.d3.a b;
        final /* synthetic */ Function0 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(sdk.pendo.io.v2.a aVar, sdk.pendo.io.d3.a aVar2, Function0 function0) {
            super(0);
            this.a = aVar;
            this.b = aVar2;
            this.c = function0;
        }

        /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, sdk.pendo.io.r7.h] */
        @Override // kotlin.jvm.functions.Function0
        public final sdk.pendo.io.r7.h invoke() {
            sdk.pendo.io.v2.a aVar = this.a;
            return (aVar instanceof sdk.pendo.io.v2.b ? ((sdk.pendo.io.v2.b) aVar).getScope() : aVar.getKoin().getScopeRegistry().getRootScope()).b(Reflection.getOrCreateKotlinClass(sdk.pendo.io.r7.h.class), this.b, this.c);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Application applicationContext, String apiKey, String baseUrl, Pendo.PendoOptions.Framework framework, sdk.pendo.io.p5.a pendoComponents, long j2, long j3, sdk.pendo.io.z6.b dispatcherProvider) {
        super(apiKey, baseUrl, dispatcherProvider);
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(framework, "framework");
        Intrinsics.checkNotNullParameter(pendoComponents, "pendoComponents");
        Intrinsics.checkNotNullParameter(dispatcherProvider, "dispatcherProvider");
        this.applicationContext = applicationContext;
        this.framework = framework;
        this.pendoComponents = pendoComponents;
        this.scanDebounceMs = j2;
        this.scanTimeoutMs = j3;
        this.scanner = LazyKt.lazy(sdk.pendo.io.i3.b.a.a(), (Function0) new q(this, null, new p()));
        this.onDrawEventFlow = SharedFlowKt.MutableSharedFlow$default(0, 1, null, 5, null);
        this.onFocusChangedEventFlow = SharedFlowKt.MutableSharedFlow$default(0, 1, null, 5, null);
        this.currentVisibleRoots = new AtomicReference<>(null);
        this.attachedTreeObservers = new ArrayList();
        this.onWindowFocusChangeListener = LazyKt.lazy(new m());
        this.onDrawListener = LazyKt.lazy(new k());
        this.lifeCycleCallbacksListener = LazyKt.lazy(new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        this.onDrawEventFlow.tryEmit(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        this.onFocusChangedEventFlow.tryEmit(Unit.INSTANCE);
    }

    public /* synthetic */ e(Application application, String str, String str2, Pendo.PendoOptions.Framework framework, sdk.pendo.io.p5.a aVar, long j2, long j3, sdk.pendo.io.z6.b bVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, str, str2, (i2 & 8) != 0 ? Pendo.PendoOptions.Framework.NATIVE : framework, aVar, (i2 & 32) != 0 ? r.a.g() : j2, (i2 & 64) != 0 ? r.a.h() : j3, (i2 & 128) != 0 ? sdk.pendo.io.z6.a.a : bVar);
    }

    private final Object d(Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(getDispatcherProvider().b(), new o(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final sdk.pendo.io.z6.c n() {
        return (sdk.pendo.io.z6.c) this.lifeCycleCallbacksListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewTreeObserver.OnDrawListener o() {
        return (ViewTreeObserver.OnDrawListener) this.onDrawListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewTreeObserver.OnWindowFocusChangeListener p() {
        return (ViewTreeObserver.OnWindowFocusChangeListener) this.onWindowFocusChangeListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final sdk.pendo.io.r7.h q() {
        return (sdk.pendo.io.r7.h) this.scanner.getValue();
    }

    @Override // sdk.pendo.io.o7.a
    protected void c() {
        super.c();
        this.onFocusEventCollectionJob = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:33:0x0083 A[Catch: all -> 0x004b, TryCatch #0 {all -> 0x004b, blocks: (B:14:0x0032, B:42:0x00c5, B:19:0x0047, B:31:0x007f, B:33:0x0083, B:35:0x008b, B:37:0x009a, B:39:0x00a4), top: B:49:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x008a  */
    /* JADX WARN: Code duplicated, block: B:37:0x009a A[Catch: all -> 0x004b, TryCatch #0 {all -> 0x004b, blocks: (B:14:0x0032, B:42:0x00c5, B:19:0x0047, B:31:0x007f, B:33:0x0083, B:35:0x008b, B:37:0x009a, B:39:0x00a4), top: B:49:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c2, code lost:
    
        if (r3.a(r1) == r2) goto L41;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [sdk.pendo.io.o7.e] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Object, sdk.pendo.io.o7.a, sdk.pendo.io.o7.e] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.lang.Object, sdk.pendo.io.o7.e] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v8, types: [kotlinx.coroutines.sync.Mutex] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.o7.e.c(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:38:0x00a6 A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #1 {all -> 0x0036, blocks: (B:13:0x0031, B:36:0x009e, B:38:0x00a6, B:41:0x00b7, B:42:0x00c0, B:44:0x00c6, B:45:0x00d4, B:47:0x00f1), top: B:58:0x0031 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00b7 A[Catch: all -> 0x0036, TRY_ENTER, TryCatch #1 {all -> 0x0036, blocks: (B:13:0x0031, B:36:0x009e, B:38:0x00a6, B:41:0x00b7, B:42:0x00c0, B:44:0x00c6, B:45:0x00d4, B:47:0x00f1), top: B:58:0x0031 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00c6 A[Catch: all -> 0x0036, LOOP:0: B:42:0x00c0->B:44:0x00c6, LOOP_END, TryCatch #1 {all -> 0x0036, blocks: (B:13:0x0031, B:36:0x009e, B:38:0x00a6, B:41:0x00b7, B:42:0x00c0, B:44:0x00c6, B:45:0x00d4, B:47:0x00f1), top: B:58:0x0031 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00f1 A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #1 {all -> 0x0036, blocks: (B:13:0x0031, B:36:0x009e, B:38:0x00a6, B:41:0x00b7, B:42:0x00c0, B:44:0x00c6, B:45:0x00d4, B:47:0x00f1), top: B:58:0x0031 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object b(Continuation<? super Unit> continuation) throws Throwable {
        f fVar;
        Mutex srMutex;
        Throwable th;
        Mutex mutex;
        e eVar;
        List list;
        JSONArray jSONArray;
        Iterator it;
        sdk.pendo.io.h7.f fVar2;
        sdk.pendo.io.p7.c recordingsManager;
        if (continuation instanceof f) {
            fVar = (f) continuation;
            int i2 = fVar.e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                fVar.e = i2 - Integer.MIN_VALUE;
            } else {
                fVar = new f(continuation);
            }
        } else {
            fVar = new f(continuation);
        }
        Object obj = fVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = fVar.e;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                srMutex = getSrMutex();
                fVar.a = this;
                fVar.b = srMutex;
                fVar.e = 1;
                if (srMutex.lock(null, fVar) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutex = (Mutex) fVar.b;
                eVar = (e) fVar.a;
                try {
                    ResultKt.throwOnFailure(obj);
                    list = (List) obj;
                    if (list.isEmpty()) {
                        PendoLogger.d("SRManager", "handleOnDrawEvent -> childNodes list is empty");
                        Unit unit = Unit.INSTANCE;
                        mutex.unlock(null);
                        return unit;
                    }
                    jSONArray = new JSONArray();
                    it = list.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(((v) it.next()).a());
                    }
                    fVar2 = new sdk.pendo.io.h7.f(System.currentTimeMillis(), eVar.pendoComponents.b().getCurrentScreenId(), jSONArray, eVar.getDisplayData());
                    recordingsManager = eVar.getRecordingsManager();
                    if (recordingsManager != null) {
                        recordingsManager.a(fVar2);
                        Unit unit2 = Unit.INSTANCE;
                    }
                    srMutex = mutex;
                    srMutex.unlock(null);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    mutex.unlock(null);
                    throw th;
                }
            }
            Mutex mutex2 = (Mutex) fVar.b;
            e eVar2 = (e) fVar.a;
            ResultKt.throwOnFailure(obj);
            srMutex = mutex2;
            this = eVar2;
            s privacyConfig = this.getPrivacyConfig();
            if (privacyConfig == null) {
                Unit unit3 = Unit.INSTANCE;
                srMutex.unlock(null);
                return unit3;
            }
            List<e1.a> list2 = this.currentVisibleRoots.get();
            if (list2 != null) {
                if (list2.isEmpty()) {
                    throw new Exception("No Roots Found");
                }
                CoroutineDispatcher coroutineDispatcherB = this.getDispatcherProvider().b();
                g gVar = this.new g(list2, privacyConfig, null);
                fVar.a = this;
                fVar.b = srMutex;
                fVar.e = 2;
                Object objWithContext = BuildersKt.withContext(coroutineDispatcherB, gVar, fVar);
                if (objWithContext != coroutine_suspended) {
                    eVar = this;
                    mutex = srMutex;
                    obj = objWithContext;
                    list = (List) obj;
                    if (list.isEmpty()) {
                        PendoLogger.d("SRManager", "handleOnDrawEvent -> childNodes list is empty");
                        Unit unit4 = Unit.INSTANCE;
                        mutex.unlock(null);
                        return unit4;
                    }
                    jSONArray = new JSONArray();
                    it = list.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(((v) it.next()).a());
                    }
                    fVar2 = new sdk.pendo.io.h7.f(System.currentTimeMillis(), eVar.pendoComponents.b().getCurrentScreenId(), jSONArray, eVar.getDisplayData());
                    recordingsManager = eVar.getRecordingsManager();
                    if (recordingsManager != null) {
                        recordingsManager.a(fVar2);
                        Unit unit5 = Unit.INSTANCE;
                    }
                    srMutex = mutex;
                }
                return coroutine_suspended;
            }
            srMutex.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th3) {
            Mutex mutex3 = srMutex;
            th = th3;
            mutex = mutex3;
            mutex.unlock(null);
            throw th;
        }
    }

    public void c(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        sdk.pendo.io.h7.p pVarA = a(activity);
        int width = (pVarA.getWidth() - pVarA.getLeftInset()) - pVarA.getRightInset();
        int height = (pVarA.getHeight() - pVarA.getTopInset()) - pVarA.getBottomInset();
        if (r.a.i()) {
            width += 6;
        }
        a(sdk.pendo.io.h7.p.a(pVarA, width, height, 0, 0, 0, 0, 60, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object b(Activity activity, Continuation<? super Unit> continuation) {
        n nVar;
        if (continuation instanceof n) {
            nVar = (n) continuation;
            int i2 = nVar.d;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                nVar.d = i2 - Integer.MIN_VALUE;
            } else {
                nVar = new n(continuation);
            }
        } else {
            nVar = new n(continuation);
        }
        Object obj = nVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = nVar.d;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            if (activity instanceof PendoGuideVisualActivity) {
                PendoLogger.d("SRManager", "removeLayoutChangesListeners skipping " + activity);
            } else {
                PendoLogger.d("SRManager", "removeLayoutChangesListeners " + activity);
                nVar.a = this;
                nVar.d = 1;
                if (d(nVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this = (e) nVar.a;
        ResultKt.throwOnFailure(obj);
        this.currentActivityRef = null;
        return Unit.INSTANCE;
    }

    private final Object a(Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(getDispatcherProvider().b(), new b(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    private final void b(Activity activity) {
        AtomicReference<List<e1.a>> atomicReference = this.currentVisibleRoots;
        List<e1.a> listA = e1.a(activity);
        ArrayList arrayList = null;
        if (listA != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : listA) {
                e1.a aVar = (e1.a) obj;
                if (aVar.e()) {
                    if (Intrinsics.areEqual(aVar.c(), activity != null ? activity.getWindow() : null)) {
                    }
                }
                arrayList2.add(obj);
            }
            arrayList = arrayList2;
        }
        atomicReference.set(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:30:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:33:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(Activity activity, Continuation<? super Unit> continuation) {
        c cVar;
        e eVar;
        Activity activity2;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i2 = cVar.e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                cVar.e = i2 - Integer.MIN_VALUE;
            } else {
                cVar = new c(continuation);
            }
        } else {
            cVar = new c(continuation);
        }
        Object obj = cVar.c;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = cVar.e;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            if (!(activity instanceof PendoGuideVisualActivity)) {
                PendoLogger.d("SRManager", "createLayoutChangesListeners " + activity);
                cVar.a = this;
                cVar.b = activity;
                cVar.e = 1;
                if (d(cVar) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            PendoLogger.d("SRManager", "createLayoutChangesListeners skipping " + activity);
            return Unit.INSTANCE;
        }
        if (i3 == 1) {
            activity = (Activity) cVar.b;
            this = (e) cVar.a;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            activity2 = (Activity) cVar.b;
            eVar = (e) cVar.a;
            ResultKt.throwOnFailure(obj);
        }
        if (eVar.getOnEventCollectionJob() == null) {
            eVar.a(BuildersKt__Builders_commonKt.launch$default(eVar.getCoroutineScope(), new CoroutineName("DrawEventCollectionCoroutine"), null, eVar.new d(null), 2, null));
        }
        if (eVar.onFocusEventCollectionJob == null) {
            eVar.onFocusEventCollectionJob = BuildersKt__Builders_commonKt.launch$default(eVar.getCoroutineScope(), new CoroutineName("FocusEventCollectionCoroutine"), null, eVar.new C0454e(null), 2, null);
        }
        eVar.c(activity2);
        return Unit.INSTANCE;
        this.currentActivityRef = new WeakReference<>(activity);
        this.b(activity);
        PendoLogger.d("SRManager", "createLayoutChangesListeners current visible roots $" + this.currentVisibleRoots.get());
        cVar.a = this;
        cVar.b = activity;
        cVar.e = 2;
        if (this.a(cVar) != coroutine_suspended) {
            Activity activity3 = activity;
            eVar = this;
            activity2 = activity3;
            if (eVar.getOnEventCollectionJob() == null) {
                eVar.a(BuildersKt__Builders_commonKt.launch$default(eVar.getCoroutineScope(), new CoroutineName("DrawEventCollectionCoroutine"), null, eVar.new d(null), 2, null));
            }
            if (eVar.onFocusEventCollectionJob == null) {
                eVar.onFocusEventCollectionJob = BuildersKt__Builders_commonKt.launch$default(eVar.getCoroutineScope(), new CoroutineName("FocusEventCollectionCoroutine"), null, eVar.new C0454e(null), 2, null);
            }
            eVar.c(activity2);
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }

    private final boolean b(MotionEvent motionEvent) {
        return !e1.a(motionEvent).booleanValue() || this.pendoComponents.a().isAnyGuideDisplayed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(MotionEvent motionEvent) {
        if (b(motionEvent)) {
            return;
        }
        x.a(getCoroutineScope(), getSrMutex(), null, null, new i(motionEvent, this, null), 6, null);
    }

    @Override // sdk.pendo.io.o7.a
    public Object a(Activity activity, SessionData sessionData, sdk.pendo.io.h7.m mVar, Continuation<? super Unit> continuation) {
        return a(this, activity, sessionData, mVar, continuation);
    }

    static /* synthetic */ Object a(e eVar, Activity activity, SessionData sessionData, sdk.pendo.io.h7.m mVar, Continuation<? super Unit> continuation) {
        eVar.a(new sdk.pendo.io.p7.c(sessionData.getVisitorId(), sessionData.getAccountId(), eVar.m(), mVar, eVar.k(), null, 32, null));
        eVar.applicationContext.registerActivityLifecycleCallbacks(eVar.n());
        Object objA = eVar.a(activity, continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }

    @Override // sdk.pendo.io.o7.g
    public void a() {
        c();
        x.a(getCoroutineScope(), getSrMutex(), getDispatcherProvider().b(), null, new l(null), 4, null);
    }
}
