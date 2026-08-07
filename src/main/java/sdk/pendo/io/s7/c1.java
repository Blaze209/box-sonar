package sdk.pendo.io.s7;

import android.view.View;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.viewpager.widget.ViewPager;
import java.util.HashMap;
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
import kotlinx.coroutines.GlobalScope;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.PendoTouchDelegate;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.sdk.react.PlatformStateManager;
import sdk.pendo.io.sdk.react.ReactNativeScreenManager;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000¨\u0006\u0004"}, d2 = {"Landroid/view/View;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "pendoIO_release"}, k = 2, mv = {1, 9, 0})
public final class c1 {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.utilities.ViewHierarchyUtilityKt$isPendoClickable$1", f = "ViewHierarchyUtility.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ View b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = view;
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
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.b.setClickable(true);
            return Unit.INSTANCE;
        }
    }

    public static final boolean a(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return (view instanceof DrawerLayout) || Intrinsics.areEqual(view.getClass().getCanonicalName(), "androidx.drawerlayout.widget.DrawerLayout");
    }

    public static final boolean b(View view) {
        HashMap<Integer, String> clickableElements$pendoIO_release;
        Intrinsics.checkNotNullParameter(view, "<this>");
        if ((view instanceof ScrollView) || (view instanceof AbsListView) || (view instanceof ViewPager) || a(view)) {
            return false;
        }
        if ((view instanceof Spinner) && ((Spinner) view).getOnItemSelectedListener() != null) {
            return true;
        }
        if (view.getParent() != null && (view.getParent() instanceof AbsListView)) {
            ViewParent parent = view.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.widget.AbsListView");
            if (((AbsListView) parent).getOnItemClickListener() != null) {
                return true;
            }
        }
        if (view.isClickable() || view.hasOnClickListeners() || (PlatformStateManager.INSTANCE.isXamarinFormsOrMaui() && (view.getTouchDelegate() instanceof PendoTouchDelegate))) {
            return true;
        }
        sdk.pendo.io.x6.d dVarZ = PendoInternal.z();
        ReactNativeScreenManager reactNativeScreenManager = dVarZ instanceof ReactNativeScreenManager ? (ReactNativeScreenManager) dVarZ : null;
        if (reactNativeScreenManager == null || (clickableElements$pendoIO_release = reactNativeScreenManager.getClickableElements$pendoIO_release()) == null || !clickableElements$pendoIO_release.containsKey(Integer.valueOf(view.getId()))) {
            return false;
        }
        if (!view.isClickable()) {
            try {
                BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, b1.a.b(), null, new a(view, null), 2, null);
            } catch (Exception e) {
                PendoLogger.d(e, "isPendoClickable try to set RN element as clickable failed", new Object[0]);
            }
        }
        return true;
    }
}
