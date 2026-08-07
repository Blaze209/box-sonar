package sdk.pendo.io.v6;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
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
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.s7.b0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\u0006\u0010\u001d\u001a\u00020\u0018¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J*\u0010\u0012\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016R\u0017\u0010\u0017\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lsdk/pendo/io/v6/i;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onSingleTapUp", "onDown", "", "onShowPress", "e1", "e2", "", "distanceX", "distanceY", "onScroll", "onLongPress", "velocityX", "velocityY", "onFling", "Lsdk/pendo/io/s7/b0;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/s7/b0;", "()Lsdk/pendo/io/s7/b0;", "motionEventHandler", "Lkotlinx/coroutines/CoroutineScope;", "b", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "", "c", "Ljava/lang/String;", "TAG", "<init>", "(Lsdk/pendo/io/s7/b0;Lkotlinx/coroutines/CoroutineScope;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class i implements GestureDetector.OnGestureListener {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final b0 motionEventHandler;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final CoroutineScope coroutineScope;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final String TAG;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.compose.PendoGestureListener$onSingleTapUp$1", f = "PendoGestureListener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ MotionEvent c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(MotionEvent motionEvent, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = motionEvent;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return i.this.new a(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            i.this.getMotionEventHandler().a(this.c);
            return Unit.INSTANCE;
        }
    }

    public i(b0 motionEventHandler, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(motionEventHandler, "motionEventHandler");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.motionEventHandler = motionEventHandler;
        this.coroutineScope = coroutineScope;
        this.TAG = "PendoGestureListener";
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final b0 getMotionEventHandler() {
        return this.motionEventHandler;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        PendoLogger.d(this.TAG, "onDown " + e);
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Intrinsics.checkNotNullParameter(e2, "e2");
        PendoLogger.d(this.TAG, "onFling");
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        PendoLogger.d(this.TAG, "onLongPress");
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Intrinsics.checkNotNullParameter(e2, "e2");
        PendoLogger.d(this.TAG, "EVENT -> Window callback onScroll");
        this.motionEventHandler.a();
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        PendoLogger.d(this.TAG, "onShowPress " + e);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        PendoLogger.d(this.TAG, "onSingleTapUp " + e);
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new a(e, null), 3, null);
        return false;
    }
}
