package sdk.pendo.io.s7;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.ui.geometry.Rect;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.text.TextUtilsCompat;
import androidx.core.view.GravityCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001e2\u00020\u0001:\u0001\u0005B\u0013\b\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u001f¢\u0006\u0004\b-\u0010.J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006Jc\u0010\u0005\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0005\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0004J\u000f\u0010\u001c\u001a\u00020\u001bH\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u001bH\u0000¢\u0006\u0004\b\u001e\u0010\u001dR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010 R8\u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\"2\u0010\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\"8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0019\u0010$\u001a\u0004\b%\u0010&R\"\u0010,\u001a\u00020\u001b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b%\u0010(\u001a\u0004\b)\u0010\u001d\"\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lsdk/pendo/io/s7/e;", "", "Lsdk/pendo/io/s7/i0;", "view", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lorg/json/JSONObject;", "viewAsJson", "Landroid/view/View;", "Landroid/app/Activity;", "activity", "", "left", ViewProps.TOP, "width", "height", "", "featureSelector", TypedValues.Custom.S_REFERENCE, "Landroid/view/ViewGroup;", "rootView", "", "gravity", "(Landroid/app/Activity;DDDDLjava/lang/String;Ljava/lang/Object;Landroid/view/ViewGroup;Ljava/lang/Integer;)Landroid/view/View;", "anchorView", "b", "f", "", "e", "()Z", "d", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "coroutineMainDispatcher", "Ljava/lang/ref/WeakReference;", "<set-?>", "Ljava/lang/ref/WeakReference;", "c", "()Ljava/lang/ref/WeakReference;", "activeAnchorView", "Z", "isRTLFlagEnabledInManifest$pendoIO_release", "setRTLFlagEnabledInManifest$pendoIO_release", "(Z)V", "isRTLFlagEnabledInManifest", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class e {

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ArrayList<WeakReference<i0>> e = new ArrayList<>();
    private static e f;

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private CoroutineDispatcher coroutineMainDispatcher;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private WeakReference<i0> activeAnchorView;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private boolean isRTLFlagEnabledInManifest;

    /* JADX INFO: renamed from: sdk.pendo.io.s7.e$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R0\u0010\u000b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b`\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/s7/e$a;", "", "Lsdk/pendo/io/s7/e;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "TAG", "Ljava/lang/String;", "Ljava/util/ArrayList;", "Ljava/lang/ref/WeakReference;", "Lsdk/pendo/io/s7/i0;", "Lkotlin/collections/ArrayList;", "anchorViewsList", "Ljava/util/ArrayList;", "instance", "Lsdk/pendo/io/s7/e;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final e a() {
            e eVar = e.f;
            if (eVar != null) {
                return eVar;
            }
            e eVar2 = e.f;
            if (eVar2 != null) {
                return eVar2;
            }
            e eVar3 = new e(null, 1, 0 == true ? 1 : 0);
            e.f = eVar3;
            return eVar3;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.utilities.AnchorViewUtils$createAnchorView$1", f = "AnchorViewUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ ViewGroup b;
        final /* synthetic */ i0 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ViewGroup viewGroup, i0 i0Var, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = viewGroup;
            this.c = i0Var;
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
            this.b.addView(this.c);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.utilities.AnchorViewUtils$removeViewFromItsParent$1$1", f = "AnchorViewUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ i0 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(i0 i0Var, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = i0Var;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ViewGroup viewGroup = (ViewGroup) this.b.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.b);
            }
            return Unit.INSTANCE;
        }
    }

    private e(CoroutineDispatcher coroutineDispatcher) {
        this.coroutineMainDispatcher = coroutineDispatcher;
        this.isRTLFlagEnabledInManifest = e();
    }

    public final synchronized void b() {
        i0 i0Var;
        WeakReference<i0> weakReference = this.activeAnchorView;
        PendoLogger.d("AnchorViewUtils", "disableActiveAnchorView  - " + (weakReference != null ? weakReference.get() : null));
        WeakReference<i0> weakReference2 = this.activeAnchorView;
        if (weakReference2 != null && (i0Var = weakReference2.get()) != null) {
            i0Var.setStatus(i0.b.DISABLED);
        }
    }

    public final WeakReference<i0> c() {
        return this.activeAnchorView;
    }

    public final boolean d() {
        try {
            return TextUtilsCompat.getLayoutDirectionFromLocale(s0.a()) == 1;
        } catch (Exception e2) {
            PendoLogger.d("AnchorViewUtils", "isCurrentLocaleRTL exception -  " + e2.getMessage());
            return false;
        }
    }

    public final boolean e() {
        try {
            Context applicationContext = sdk.pendo.io.d6.c.h().a().getApplicationContext();
            ApplicationInfo applicationInfo = MAMPackageManagement.getApplicationInfo(applicationContext.getPackageManager(), applicationContext.getPackageName(), 0);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            return (applicationInfo.flags & 4194304) != 0;
        } catch (Exception e2) {
            PendoLogger.d("AnchorViewUtils", "isRTLFlagEnabled exception -  " + e2.getMessage());
            return false;
        }
    }

    public final synchronized void f() {
        WeakReference<i0> weakReference = this.activeAnchorView;
        a(weakReference != null ? weakReference.get() : null);
        this.activeAnchorView = null;
    }

    /* synthetic */ e(CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dispatchers.getMain() : coroutineDispatcher);
    }

    public final synchronized View a(Activity activity, double left, double top, double width, double height, String featureSelector, Object reference, ViewGroup rootView, Integer gravity) {
        i0 i0Var;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        PendoLogger.d("AnchorViewUtils", "createAnchorView creating anchorView");
        i0Var = new i0(activity, new WeakReference(reference), featureSelector);
        i0Var.setLayoutParams(gravity == null ? new FrameLayout.LayoutParams((int) width, (int) height) : new FrameLayout.LayoutParams((int) width, (int) height, gravity.intValue()));
        i0Var.setX((float) left);
        i0Var.setY((float) top);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), this.coroutineMainDispatcher, null, new b(rootView, i0Var, null), 2, null);
        e.add(new WeakReference<>(i0Var));
        return i0Var;
    }

    public static /* synthetic */ View a(e eVar, Activity activity, double d, double d2, double d3, double d4, String str, Object obj, ViewGroup viewGroup, Integer num, int i, Object obj2) {
        Activity activity2;
        ViewGroup viewGroup2;
        String str2 = (i & 32) != 0 ? null : str;
        Object obj3 = (i & 64) != 0 ? null : obj;
        if ((i & 128) != 0) {
            activity2 = activity;
            View viewFindViewById = activity2.findViewById(R.id.content);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            viewGroup2 = (ViewGroup) viewFindViewById;
        } else {
            activity2 = activity;
            viewGroup2 = viewGroup;
        }
        return eVar.a(activity2, d, d2, d3, d4, str2, obj3, viewGroup2, (i & 256) != 0 ? null : num);
    }

    public final View a(JSONObject viewAsJson) {
        WeakReference<View> weakReference;
        Intrinsics.checkNotNullParameter(viewAsJson, "viewAsJson");
        try {
            Object obj = viewAsJson.get("boundsInWindow");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.geometry.Rect");
            Rect rect = (Rect) obj;
            double left = rect.getLeft();
            double top = rect.getTop();
            double right = rect.getRight() - rect.getLeft();
            double bottom = rect.getBottom() - rect.getTop();
            Activity activityA = sdk.pendo.io.d6.c.h().a();
            b1 b1Var = b1.a;
            Intrinsics.checkNotNull(activityA);
            e1.a aVarA = s.a.a(b1Var, activityA, false, 2, null);
            View view = (aVarA == null || (weakReference = aVarA.a) == null) ? null : weakReference.get();
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
            return a(this, activityA, left, top, right, bottom, null, viewAsJson.get("semanticsNode"), (ViewGroup) view, Integer.valueOf((this.isRTLFlagEnabledInManifest && d()) ? GravityCompat.END : GravityCompat.START), 32, null);
        } catch (Exception e2) {
            PendoLogger.w("AnchorViewUtils", "createAnchorViewForCompose failed to create viewRef - " + e2.getMessage());
            return null;
        }
    }

    private final void a(i0 view) {
        if (view != null) {
            PendoLogger.d("AnchorViewUtils", "removeViewFromItsParent removing view - " + view);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), this.coroutineMainDispatcher, null, new c(view, null), 2, null);
        }
    }

    public final synchronized void a(View anchorView) {
        if (anchorView instanceof i0) {
            WeakReference<i0> weakReference = new WeakReference<>(anchorView);
            this.activeAnchorView = weakReference;
            PendoLogger.d("AnchorViewUtils", "setActiveAnchorView setting activeAnchorView - " + weakReference.get());
            Iterator<T> it = e.iterator();
            while (it.hasNext()) {
                i0 i0Var = (i0) ((WeakReference) it.next()).get();
                if (!Intrinsics.areEqual(i0Var, anchorView)) {
                    a(i0Var);
                }
            }
            e.clear();
        }
    }
}
