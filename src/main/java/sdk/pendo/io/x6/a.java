package sdk.pendo.io.x6;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.media3.exoplayer.upstream.CmcdData;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.views.custom.PendoBackCapture;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b7\u00108J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0080@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\fJ\u0015\u0010\b\u001a\u0004\u0018\u00010\nH\u0080@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\rJ#\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0080@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0011RB\u0010\u001a\u001a*\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u0013j\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0004`\u00158\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0016\u0010\u001d\"\u0004\b\b\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R*\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b\b\u0010&\"\u0004\b\b\u0010'R\"\u0010.\u001a\u00020\u00148\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b\b\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082D¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105\u0082\u0002\u0004\n\u0002\b\u0019¨\u00069"}, d2 = {"Lsdk/pendo/io/x6/a;", "", "Landroid/view/ViewTreeObserver;", "viewTree", "Ljava/lang/ref/WeakReference;", "Landroid/view/ViewGroup;", "currentViewRef", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Landroid/view/ViewTreeObserver;Ljava/lang/ref/WeakReference;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lsdk/pendo/io/views/custom/PendoBackCapture;", "pendoBackCapture", "(Lsdk/pendo/io/views/custom/PendoBackCapture;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currentViewRoot", "(Landroid/view/ViewGroup;Lsdk/pendo/io/views/custom/PendoBackCapture;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "getBackCaptureMap$pendoIO_release", "()Ljava/util/HashMap;", "backCaptureMap", "c", "Landroid/view/ViewTreeObserver;", "()Landroid/view/ViewTreeObserver;", "(Landroid/view/ViewTreeObserver;)V", "currentViewTree", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "d", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "currentFocusListener", "e", "Ljava/lang/ref/WeakReference;", "()Ljava/lang/ref/WeakReference;", "(Ljava/lang/ref/WeakReference;)V", "currentRootViewRef", "f", "I", "getCurrentViewHash$pendoIO_release", "()I", "(I)V", "currentViewHash", "", "g", "Ljava/lang/String;", "TAG", "Lkotlinx/coroutines/sync/Mutex;", CmcdData.STREAMING_FORMAT_HLS, "Lkotlinx/coroutines/sync/Mutex;", "backCaptureMutex", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final CoroutineDispatcher dispatcher;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final HashMap<Integer, WeakReference<PendoBackCapture>> backCaptureMap;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private ViewTreeObserver currentViewTree;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private ViewTreeObserver.OnGlobalFocusChangeListener currentFocusListener;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private WeakReference<ViewGroup> currentRootViewRef;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private int currentViewHash;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final String TAG;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final Mutex backCaptureMutex;

    /* JADX INFO: renamed from: sdk.pendo.io.x6.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.FocusHandler$addKeyListenerToCurrentFocusedViewOrToPendoBackCapture$2", f = "FocusHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C0519a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
        int a;
        final /* synthetic */ PendoBackCapture c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0519a(PendoBackCapture pendoBackCapture, Continuation<? super C0519a> continuation) {
            super(2, continuation);
            this.c = pendoBackCapture;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<Object> continuation) {
            return ((C0519a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return a.this.new C0519a(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                WeakReference<ViewGroup> weakReferenceA = a.this.a();
                ViewGroup viewGroup = weakReferenceA != null ? weakReferenceA.get() : null;
                View viewFindFocus = viewGroup != null ? viewGroup.findFocus() : null;
                if (viewFindFocus != null) {
                    a aVar = a.this;
                    PendoBackCapture pendoBackCapture = this.c;
                    PendoLogger.d(aVar.TAG + " addKeyListenerToCurrentFocusedViewOrToPendoBackCapture - in focus element is: " + viewFindFocus, new Object[0]);
                    return Boxing.boxBoolean(sdk.pendo.io.d8.b.a(viewFindFocus, pendoBackCapture));
                }
                a aVar2 = a.this;
                PendoBackCapture pendoBackCapture2 = this.c;
                PendoLogger.d(aVar2.TAG + " addKeyListenerToCurrentFocusedViewOrToPendoBackCapture - No view currently has focus. Attempting to set focus to PendoBackCapture.", new Object[0]);
                pendoBackCapture2.requestFocus();
                PendoLogger.d(aVar2.TAG + " addKeyListenerToCurrentFocusedViewOrToPendoBackCapture - pendoBackCapture requested focus", new Object[0]);
                return Unit.INSTANCE;
            } catch (Exception e) {
                PendoLogger.e(a.this.TAG, Intrinsics.areEqual(e.getClass().getName(), "android.view.ViewRootImpl$CalledFromWrongThreadException") ? "addKeyListenerToCurrentFocusedViewOrToPendoBackCapture failed due to thread ownership. Host app or another SDK might have misconfigured the view hierarchy." : "addKeyListenerToCurrentFocusedViewOrToPendoBackCapture unexpected error.", e);
                return Unit.INSTANCE;
            }
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.FocusHandler$addPendoBackCaptureToViewGroup$2", f = "FocusHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ PendoBackCapture b;
        final /* synthetic */ ViewGroup c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(PendoBackCapture pendoBackCapture, ViewGroup viewGroup, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = pendoBackCapture;
            this.c = viewGroup;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                if (Intrinsics.areEqual(this.b.getParent(), this.c)) {
                    return Unit.INSTANCE;
                }
                ViewParent parent = this.b.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(this.b);
                }
                ViewGroup viewGroup2 = this.c;
                if (viewGroup2 != null) {
                    viewGroup2.addView(this.b);
                }
                return Unit.INSTANCE;
            } catch (Exception e) {
                PendoLogger.w(e, "Error adding pendoBackCapture", new Object[0]);
            }
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.FocusHandler", f = "FocusHandler.kt", i = {0, 0, 1, 1, 2, 2}, l = {Token.SETELEM_OP, 103, 111}, m = "getPendoBackCapture$pendoIO_release", n = {"this", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "pendoBackCapture", "$this$withLock_u24default$iv", "pendoBackCapture"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
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
            return a.this.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.FocusHandler$setFocusListener$2", f = "FocusHandler.kt", i = {}, l = {48, 56, 61}, m = "invokeSuspend", n = {}, s = {})
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ ViewTreeObserver b;
        final /* synthetic */ a c;
        final /* synthetic */ WeakReference<ViewGroup> d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ViewTreeObserver viewTreeObserver, a aVar, WeakReference<ViewGroup> weakReference, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = viewTreeObserver;
            this.c = aVar;
            this.d = weakReference;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, this.c, this.d, continuation);
        }

        /* JADX WARN: Code duplicated, block: B:39:0x00cb A[Catch: Exception -> 0x0029, CancellationException -> 0x012b, TryCatch #2 {CancellationException -> 0x012b, Exception -> 0x0029, blocks: (B:7:0x0012, B:11:0x001f, B:43:0x0112, B:45:0x0116, B:12:0x0024, B:37:0x00c7, B:39:0x00cb, B:17:0x002f, B:19:0x0037, B:21:0x003a, B:23:0x0048, B:25:0x0084, B:27:0x008a, B:29:0x0092, B:30:0x009b, B:32:0x00ac, B:34:0x00b2, B:40:0x00df), top: B:53:0x000a }] */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x011e, code lost:
        
            if (r1.a(r8, r7) == r0) goto L47;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 301
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.x6.a.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public a(CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        this.backCaptureMap = new HashMap<>();
        this.currentViewHash = -1;
        this.TAG = "FocusHandler";
        this.backCaptureMutex = MutexKt.Mutex$default(false, 1, null);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final ViewTreeObserver getCurrentViewTree() {
        return this.currentViewTree;
    }

    public /* synthetic */ a(CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dispatchers.getMain().getImmediate() : coroutineDispatcher);
    }

    public final Object a(PendoBackCapture pendoBackCapture, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new C0519a(pendoBackCapture, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public final Object a(ViewGroup viewGroup, PendoBackCapture pendoBackCapture, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new b(pendoBackCapture, viewGroup, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public final WeakReference<ViewGroup> a() {
        return this.currentRootViewRef;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0106, code lost:
    
        if (r11.a(r2, r7, r0) == r1) goto L52;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.coroutines.Continuation, sdk.pendo.io.x6.a$c] */
    /* JADX WARN: Type inference failed for: r0v3, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r0v8, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v3, types: [sdk.pendo.io.x6.a] */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Object, kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.Object, kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, sdk.pendo.io.views.custom.PendoBackCapture] */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [T, android.view.View, sdk.pendo.io.views.custom.PendoBackCapture] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(kotlin.coroutines.Continuation<? super sdk.pendo.io.views.custom.PendoBackCapture> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.x6.a.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void a(WeakReference<ViewGroup> weakReference) {
        this.currentRootViewRef = weakReference;
    }

    public final void a(int i) {
        this.currentViewHash = i;
    }

    public final void a(ViewTreeObserver viewTreeObserver) {
        this.currentViewTree = viewTreeObserver;
    }

    public final Object a(ViewTreeObserver viewTreeObserver, WeakReference<ViewGroup> weakReference, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new d(viewTreeObserver, this, weakReference, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
