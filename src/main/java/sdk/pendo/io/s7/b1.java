package sdk.pendo.io.s7;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.TextView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.recyclerview.widget.RecyclerView;
import com.box.android.domain.localrepo.sqlitetables.BoxTaskCollaboratorsSQLData;
import com.facebook.react.uimanager.ViewProps;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.PendoTouchDelegate;
import sdk.pendo.io.events.ComposeIdentificationData;
import sdk.pendo.io.events.IdentificationData;
import sdk.pendo.io.events.TagsIdentifier;
import sdk.pendo.io.listeners.views.OnElementInScreenFoundListener;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.sdk.react.PlatformStateManager;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0015B\t\b\u0002¢\u0006\u0004\bH\u0010IJ\b\u0010\u0004\u001a\u00020\u0003H\u0002Jd\u0010\u0015\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\tj\b\u0012\u0004\u0012\u00020\u0005`\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J*\u0010\u0015\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J \u0010\u0015\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0018\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0018\u0010\u0015\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0003H\u0002J(\u0010\u0015\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002J \u0010\u0015\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002J\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00182\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0018H\u0002J\u0018\u0010\u0004\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0018H\u0002J\u0018\u0010\u0015\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0018H\u0002Ja\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\tj\b\u0012\u0004\u0012\u00020\u0005`\n2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\"\u0010$\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050#0\"\"\n\u0012\u0006\b\u0001\u0012\u00020\u00050#H\u0003¢\u0006\u0004\b\u0015\u0010%JI\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\"\u0010$\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050#0\"\"\n\u0012\u0006\b\u0001\u0012\u00020\u00050#H\u0003¢\u0006\u0004\b\u0015\u0010&J\u001a\u0010\u0015\u001a\u0004\u0018\u00010*2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u0018H\u0016J \u0010\u0015\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J4\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010.2\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016JB\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0017J*\u0010\u0015\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u00103\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0017J\u0010\u0010\u0015\u001a\u0002052\u0006\u0010\u0006\u001a\u000204H\u0016J(\u0010\u0015\u001a\u00020\u00032\b\u00106\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\tj\b\u0012\u0004\u0012\u00020\u0005`\nJ\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u001b\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0015\u00107JC\u0010\u0015\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u00108\u001a\u00020 2\"\u0010$\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050#0\"\"\n\u0012\u0006\b\u0001\u0012\u00020\u00050#H\u0017¢\u0006\u0004\b\u0015\u00109JI\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\"\u0010$\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050#0\"\"\n\u0012\u0006\b\u0001\u0012\u00020\u00050#H\u0017¢\u0006\u0004\b\u001d\u0010:R\u001a\u0010>\u001a\u00020;8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001d\u0010<\u001a\u0004\b\u001d\u0010=R$\u0010C\u001a\u0004\u0018\u00010?8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010@\u001a\u0004\b\u0015\u0010A\"\u0004\b\u0015\u0010BR\u001c\u0010G\u001a\n E*\u0004\u0018\u00010D0D8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010F\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006J"}, d2 = {"Lsdk/pendo/io/s7/b1;", "Lsdk/pendo/io/w5/a;", "Lsdk/pendo/io/s7/s;", "", "d", "Landroid/view/View;", "view", "Lorg/json/JSONArray;", "tree", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "discoverySet", "", ComposeIdentificationData.FIELD_DEPTH, "fakeZ", "isParentAList", "isForCapture", "Lsdk/pendo/io/listeners/views/OnElementInScreenFoundListener;", "onViewFoundListener", "", "currentScreenId", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "rootView", "", "Lorg/json/JSONObject;", "viewAsJSON", "Lsdk/pendo/io/events/IdentificationData;", "viewIdentificationData", "c", "b", "jsonObject", "", "Lsdk/pendo/io/s7/b1$a;", "callbacks", "", "Ljava/lang/Class;", "classes", "(Landroid/view/View;Ljava/util/HashSet;Ljava/util/List;[Ljava/lang/Class;)Z", "(Landroid/view/View;Ljava/util/List;[Ljava/lang/Class;)Z", "Landroid/app/Activity;", "activity", "ignoreDialogs", "Lsdk/pendo/io/s7/e1$a;", "identificationDataJson", "includeText", "includeNestedText", "", "rootViews", "recMaxDepth", "parentAList", "forCapture", "viewZIndex", "Landroid/view/ViewGroup;", "Lkotlin/ranges/IntProgression;", "viewChild", "(Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callback", "(Landroid/view/View;Lsdk/pendo/io/s7/b1$a;[Ljava/lang/Class;)V", "(Landroid/view/View;Ljava/util/List;[Ljava/lang/Class;)V", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "mainCoroutineDispatcher", "Lsdk/pendo/io/s7/i;", "Lsdk/pendo/io/s7/i;", "()Lsdk/pendo/io/s7/i;", "(Lsdk/pendo/io/s7/i;)V", "composeUtilityHelper", "Lsdk/pendo/io/x6/k;", "kotlin.jvm.PlatformType", "()Lsdk/pendo/io/x6/k;", "policyManager", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class b1 implements sdk.pendo.io.w5.a, s {
    public static final b1 a = new b1();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static final MainCoroutineDispatcher mainCoroutineDispatcher = Dispatchers.getMain();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static i composeUtilityHelper;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0006\u0010\t\u001a\u00020\bR(\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/s7/b1$a;", "", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "oBundle", "", "performActionOnView", "", "reset", "<set-?>", "data", "Landroid/os/Bundle;", "getData", "()Landroid/os/Bundle;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static abstract class a {
        private Bundle data;

        public final Bundle getData() {
            return this.data;
        }

        public abstract boolean performActionOnView(View view, Bundle oBundle);

        public final void reset() {
            this.data = new Bundle();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.utilities.ViewHierarchyUtility$addListenersToView$2", f = "ViewHierarchyUtility.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int a;
        final /* synthetic */ View b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(View view, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = view;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (this.b.getTouchDelegate() instanceof PendoTouchDelegate) {
                return Boxing.boxBoolean(true);
            }
            if (c1.b(this.b)) {
                e1.a(this.b, (WeakReference<View>) new WeakReference(this.b));
                return Boxing.boxBoolean(true);
            }
            View view = this.b;
            if (view instanceof AbsListView) {
                e1.a((AbsListView) view);
                return Boxing.boxBoolean(false);
            }
            if (c1.a(view)) {
                View view2 = this.b;
                Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type androidx.drawerlayout.widget.DrawerLayout");
                e1.a((DrawerLayout) view2);
                return Boxing.boxBoolean(false);
            }
            if (PlatformStateManager.INSTANCE.isReactNativeAnalyticsEnabled() && Intrinsics.areEqual(this.b.getClass().getSimpleName(), "ReactViewGroup")) {
                Object parent = this.b.getParent();
                if (parent instanceof View) {
                    View view3 = (View) parent;
                    if ((view3.getTouchDelegate() instanceof PendoTouchDelegate) && Intrinsics.areEqual(parent.getClass().getSimpleName(), "ReactViewGroup")) {
                        TouchDelegate touchDelegate = view3.getTouchDelegate();
                        Intrinsics.checkNotNull(touchDelegate, "null cannot be cast to non-null type sdk.pendo.io.PendoTouchDelegate");
                        e1.a(this.b, ((PendoTouchDelegate) touchDelegate).a());
                    }
                }
            }
            return Boxing.boxBoolean(false);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"sdk/pendo/io/s7/b1$c", "Lsdk/pendo/io/z7/a$c;", "Landroid/view/View;", "view", "", "isParentAList", "", ViewProps.Z_INDEX, "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class c implements sdk.pendo.io.z7.a.c {
        final /* synthetic */ JSONArray a;
        final /* synthetic */ OnElementInScreenFoundListener b;
        final /* synthetic */ String c;

        c(JSONArray jSONArray, OnElementInScreenFoundListener onElementInScreenFoundListener, String str) {
            this.a = jSONArray;
            this.b = onElementInScreenFoundListener;
            this.c = str;
        }

        @Override // sdk.pendo.io.z7.a.c
        public void a(View view, boolean isParentAList, int zIndex) {
            View view2;
            boolean z;
            Intrinsics.checkNotNullParameter(view, "view");
            try {
                b1 b1Var = b1.a;
                if (b1Var.b(view)) {
                    return;
                }
                view2 = view;
                z = isParentAList;
                try {
                    b1Var.a(view2, this.a, zIndex, z, true, this.b, this.c);
                    return;
                } catch (Exception e) {
                    e = e;
                }
            } catch (Exception e2) {
                e = e2;
                view2 = view;
                z = isParentAList;
            }
            Exception exc = e;
            PendoLogger.e(exc, exc.getMessage(), "get ViewTreeAndScreenState input: view:" + view2.getClass().getCanonicalName() + " isParentList:" + z + " ");
        }
    }

    private b1() {
    }

    private final sdk.pendo.io.x6.k c() {
        return PendoInternal.y();
    }

    private final void d(View view, JSONObject jsonObject) {
        try {
            JSONObject jSONObject = new JSONObject();
            Rect rectG = e1.g(view);
            jSONObject.put("left", rectG.left);
            jSONObject.put(ViewProps.TOP, rectG.top);
            jSONObject.put("width", rectG.width());
            jSONObject.put("height", rectG.height());
            jsonObject.put(ViewProps.POSITION, jSONObject);
        } catch (JSONException e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
        }
    }

    public Object a(View view, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new b(view, null), continuation);
    }

    public final MainCoroutineDispatcher b() {
        return mainCoroutineDispatcher;
    }

    @Override // sdk.pendo.io.v2.a
    public sdk.pendo.io.u2.a getKoin() {
        return sdk.pendo.io.w5.a.C0510a.a(this);
    }

    private final void a(View view, JSONObject viewAsJSON, IdentificationData viewIdentificationData, boolean isForCapture) throws JSONException {
        if (isForCapture) {
            JSONObject jSONObjectCreateRetroElementTexts = viewIdentificationData.createRetroElementTexts();
            if (jSONObjectCreateRetroElementTexts != null) {
                viewAsJSON.put("retroElementTexts", jSONObjectCreateRetroElementTexts);
            }
            if (c().getIncludeRetroElementCompatibilityHashes()) {
                viewAsJSON.put("retroElementCompatibilityHashes", a(view, viewIdentificationData));
            }
        }
    }

    private final void b(View view, JSONObject jsonObject) {
        try {
            boolean zB = c1.b(view);
            jsonObject.put("clickable", zB);
            if (zB) {
                TextView textViewD = e1.d(view);
                CharSequence text = textViewD != null ? textViewD.getText() : null;
                if (text != null) {
                    jsonObject.put(IdentificationData.FIELD_TEXT_BASE64, y0.a(y0.a(text).toString()));
                }
            }
            jsonObject.put("has_on_click_listeners", view.hasOnClickListeners());
        } catch (JSONException e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
        }
    }

    private final void c(View view, JSONObject viewAsJSON) throws JSONException {
        String strF = e1.f(view);
        if (strF != null) {
            viewAsJSON.put("id", strF);
        }
        if (!PlatformStateManager.INSTANCE.isReactNativeAnalyticsEnabled() || view.getId() <= 0) {
            return;
        }
        viewAsJSON.put("reactTag", view.getId());
    }

    private final boolean d() {
        return PendoInternal.y().getShouldExcludeGhostElementsForCapture();
    }

    private final void a(JSONObject viewAsJSON, IdentificationData viewIdentificationData, boolean isForCapture) throws JSONException {
        if (isForCapture) {
            JSONArray jSONArrayCreateTagIdentifiers = viewIdentificationData.createTagIdentifiers();
            Intrinsics.checkNotNullExpressionValue(jSONArrayCreateTagIdentifiers, "createTagIdentifiers(...)");
            if (jSONArrayCreateTagIdentifiers.length() > 0) {
                viewAsJSON.put(TagsIdentifier.FIELD_IDS_ARRAY, jSONArrayCreateTagIdentifiers);
            }
        }
    }

    public boolean b(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return PendoInternal.y().b().contains(Reflection.getOrCreateKotlinClass(view.getClass()));
    }

    public boolean a(View view, JSONArray tree, int recMaxDepth, boolean parentAList, boolean forCapture, OnElementInScreenFoundListener onViewFoundListener, String currentScreenId) throws JSONException, InterruptedException {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(tree, "tree");
        Intrinsics.checkNotNullParameter(currentScreenId, "currentScreenId");
        i iVar = composeUtilityHelper;
        if (iVar == null || !iVar.d(view)) {
            Object objA = a(view, recMaxDepth, parentAList, forCapture);
            if (objA == null) {
                objA = Boolean.FALSE;
            }
            tree.put(objA);
            if (onViewFoundListener != null) {
                onViewFoundListener.onViewFound((JSONObject) objA, new WeakReference<>(view));
            }
        } else {
            i iVar2 = composeUtilityHelper;
            if (iVar2 != null) {
                iVar2.a(view, tree, onViewFoundListener, forCapture, currentScreenId);
            }
        }
        return true;
    }

    @SafeVarargs
    public void b(View view, List<? extends a> callbacks, Class<? extends View>... classes) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        Intrinsics.checkNotNullParameter(classes, "classes");
        a(view, new HashSet<>(), callbacks, (Class<? extends View>[]) Arrays.copyOf(classes, classes.length));
    }

    private final JSONObject b(View view, boolean isParentAList) {
        if (view == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        b(view, jSONObject);
        d(view, jSONObject);
        if (isParentAList) {
            a(view, jSONObject);
        }
        if ((view instanceof TextView) && !jSONObject.has(IdentificationData.FIELD_TEXT_BASE64)) {
            try {
                jSONObject.put(IdentificationData.FIELD_TEXT_BASE64, y0.a(y0.a(((TextView) view).getText()).toString()));
                return jSONObject;
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), new Object[0]);
            }
        }
        return jSONObject;
    }

    public JSONArray a(View view, IdentificationData viewIdentificationData) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(viewIdentificationData, "viewIdentificationData");
        return sdk.pendo.io.c6.b.a(view, viewIdentificationData).createRetroElementCompatibilityHashes();
    }

    private final IdentificationData a(View view, boolean isForCapture) {
        IdentificationData identificationDataA;
        if (isForCapture) {
            Boolean bool = Boolean.TRUE;
            identificationDataA = sdk.pendo.io.c6.b.a(view, bool, bool);
        } else {
            identificationDataA = sdk.pendo.io.c6.b.a(view, Boolean.valueOf(c().getIncludeFeatureClickTexts()), Boolean.valueOf(c().getIncludeFeatureClickNestedTexts()));
        }
        Intrinsics.checkNotNull(identificationDataA);
        return identificationDataA;
    }

    public JSONObject a(View view, int viewZIndex, boolean isParentAList, boolean isForCapture) throws JSONException {
        Intrinsics.checkNotNullParameter(view, "view");
        JSONObject jSONObjectB = b(view, isParentAList);
        if (jSONObjectB == null) {
            PendoLogger.e("View as JSON is null!", new Object[0]);
            return null;
        }
        jSONObjectB.put("classHierarchy", y0.a((List<? extends Object>) y0.a(view)));
        c(view, jSONObjectB);
        IdentificationData identificationDataA = a(view, isForCapture);
        a(view, jSONObjectB, identificationDataA);
        a(view, jSONObjectB, identificationDataA, isForCapture);
        a(jSONObjectB, identificationDataA, isForCapture);
        JSONObject json = identificationDataA.toJSON();
        Intrinsics.checkNotNullExpressionValue(json, "toJSON(...)");
        jSONObjectB.put("retroElementInfo", a(json));
        jSONObjectB.put(ViewProps.Z_INDEX, viewZIndex);
        return jSONObjectB;
    }

    @Override // sdk.pendo.io.s7.s
    public synchronized e1.a a(Activity activity, boolean ignoreDialogs) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        if (decorView.getLayoutParams() == null) {
            return null;
        }
        WeakReference weakReference = new WeakReference(decorView);
        ViewGroup.LayoutParams layoutParams = decorView.getLayoutParams();
        e1.a aVar = new e1.a(weakReference, layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null);
        if (activity.hasWindowFocus() || ignoreDialogs) {
            PendoLogger.d("ViewHierarchyUtility", "getActivityMostTopRootViewData -> activity.hasWindowFocus: " + activity.hasWindowFocus() + ", ignoreDialogs: " + ignoreDialogs);
        } else {
            List<e1.a> listA = e1.a(activity);
            PendoLogger.d("ViewHierarchyUtility", "getActivityMostTopRootViewData -> activity has no focus, viewRoots.size: " + listA.size());
            if (listA.size() > 1) {
                e1.a aVar2 = listA.get(listA.size() - 1);
                WindowManager.LayoutParams layoutParamsA = aVar2.a();
                Integer numValueOf = layoutParamsA != null ? Integer.valueOf(layoutParamsA.type) : null;
                PendoLogger.d("ViewHierarchyUtility", "getActivityMostTopRootViewData -> lastRoot type: " + numValueOf + ", isDialogType: " + aVar2.g() + ", isPopupWindowType: " + aVar2.i() + ", isBottomSheetType: " + aVar2.f());
                if (aVar2.g() || aVar2.i() || aVar2.f()) {
                    return aVar2;
                }
            }
        }
        return aVar;
    }

    public final i a() {
        return composeUtilityHelper;
    }

    public IntProgression a(ViewGroup view) {
        Intrinsics.checkNotNullParameter(view, "view");
        a1 a1Var = a1.a;
        boolean zA = a1Var.a(view);
        boolean zB = a1Var.b(view);
        int childCount = view.getChildCount();
        if (zB) {
            int i = childCount - 1;
            return RangesKt.downTo(i, i);
        }
        if (zA && childCount > 1) {
            childCount--;
        }
        return RangesKt.until(0, childCount);
    }

    @Override // sdk.pendo.io.s7.s
    public JSONArray a(Set<? extends View> rootViews, boolean isForCapture, OnElementInScreenFoundListener onViewFoundListener, String currentScreenId) {
        Intrinsics.checkNotNullParameter(currentScreenId, "currentScreenId");
        if (rootViews == null || rootViews.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (View view : rootViews) {
            if (e1.a(view, 0)) {
                if (isForCapture && d() && PlatformStateManager.INSTANCE.isNotReactNativeApp()) {
                    a(view, jSONArray, onViewFoundListener, currentScreenId);
                    w.a(jSONArray);
                } else {
                    a(view, jSONArray, new HashSet<>(), 0, 0, false, isForCapture, onViewFoundListener, currentScreenId);
                }
            }
        }
        return jSONArray;
    }

    @Override // sdk.pendo.io.s7.s
    public JSONObject a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return a(view, c().getIncludeFeatureClickTexts(), c().getIncludeFeatureClickNestedTexts());
    }

    public JSONObject a(View view, boolean includeText, boolean includeNestedText) throws JSONException {
        Intrinsics.checkNotNullParameter(view, "view");
        JSONObject json = sdk.pendo.io.c6.b.a(view, Boolean.valueOf(includeText), Boolean.valueOf(includeNestedText)).toJSON();
        Intrinsics.checkNotNullExpressionValue(json, "toJSON(...)");
        return a(json);
    }

    public JSONObject a(JSONObject identificationDataJson) {
        String string;
        Intrinsics.checkNotNullParameter(identificationDataJson, "identificationDataJson");
        if (identificationDataJson.has(IdentificationData.RA_PREDICATE)) {
            string = identificationDataJson.getString(IdentificationData.RA_PREDICATE);
            identificationDataJson.remove(IdentificationData.RA_PREDICATE);
        } else {
            string = null;
        }
        if (identificationDataJson.has(IdentificationData.PREDICATE)) {
            identificationDataJson.remove(IdentificationData.PREDICATE);
        }
        if (string != null) {
            identificationDataJson.put(IdentificationData.PREDICATE, string);
        }
        return identificationDataJson;
    }

    private final int a(View view, JSONArray tree, HashSet<View> discoverySet, int depth, int fakeZ, boolean isParentAList, boolean isForCapture, OnElementInScreenFoundListener onViewFoundListener, String currentScreenId) {
        boolean z;
        HashSet<View> hashSet = discoverySet;
        int i = depth + fakeZ;
        if (view != null && e1.a(view, 0) && !b(view)) {
            boolean zJ = e1.j(view);
            try {
                if (a(view, tree, i, isParentAList, isForCapture, onViewFoundListener, currentScreenId)) {
                    hashSet.add(view);
                    if ((view instanceof ViewGroup) && ((ViewGroup) view).getChildCount() > 0) {
                        IntProgression intProgressionA = a((ViewGroup) view);
                        int first = intProgressionA.getFirst();
                        int last = intProgressionA.getLast();
                        int step = intProgressionA.getStep();
                        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                            int i2 = first;
                            int iMax = i;
                            while (true) {
                                View childAt = ((ViewGroup) view).getChildAt(i2);
                                if (a(childAt, hashSet)) {
                                    z = zJ;
                                    iMax = Math.max(iMax, a(childAt, tree, hashSet, iMax + 1, i2, z, isForCapture, onViewFoundListener, currentScreenId));
                                } else {
                                    z = zJ;
                                }
                                if (i2 == last) {
                                    break;
                                }
                                i2 += step;
                                hashSet = discoverySet;
                                zJ = z;
                            }
                            i = iMax;
                        }
                    }
                    return i + 1;
                }
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), "get ViewTreeAndScreenState input: view:" + view.getClass().getCanonicalName() + " isParentList:" + isParentAList + " ");
                return -1;
            }
        }
        return i;
    }

    private final void a(View rootView, JSONArray tree, OnElementInScreenFoundListener onViewFoundListener, String currentScreenId) {
        PendoLogger.i("ViewHierarchyUtility -> entering populateViewTreeSmartScan", new Object[0]);
        new sdk.pendo.io.z7.a().a(rootView, false, new sdk.pendo.io.z7.a.d(0), new ArrayList<>(), new c(tree, onViewFoundListener, currentScreenId));
    }

    @SafeVarargs
    private final boolean a(View view, List<? extends a> callbacks, Class<? extends View>... classes) {
        boolean z = true;
        boolean zPerformActionOnView = false;
        boolean z2 = classes.length == 0;
        if (classes.length == 0) {
            z = z2;
            break;
        }
        int length = classes.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = z2;
                break;
            }
            if (classes[i].isInstance(view)) {
                break;
            }
            i++;
        }
        if (z) {
            for (a aVar : callbacks) {
                zPerformActionOnView |= aVar.performActionOnView(view, aVar.getData());
            }
        }
        return zPerformActionOnView;
    }

    public final void a(i iVar) {
        composeUtilityHelper = iVar;
    }

    private final void a(View view, JSONObject jsonObject) {
        int childAdapterPosition;
        ViewParent parent = view.getParent();
        if (parent instanceof AbsListView) {
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.widget.AdapterView<*>");
            childAdapterPosition = ((AdapterView) parent).getPositionForView(view);
        } else {
            childAdapterPosition = parent instanceof RecyclerView ? ((RecyclerView) parent).getChildAdapterPosition(view) : -1;
        }
        if (childAdapterPosition >= 0) {
            try {
                jsonObject.put(BoxTaskCollaboratorsSQLData.LIST_POSITION, childAdapterPosition);
            } catch (JSONException unused) {
            }
        }
    }

    private final void a(View view, JSONObject viewAsJSON, IdentificationData viewIdentificationData) throws JSONException {
        if (viewAsJSON.has("descriptiveTextBase64")) {
            return;
        }
        try {
            CharSequence contentDescription = view.getContentDescription();
            String textBase64 = viewIdentificationData.getTextBase64();
            if (!(view instanceof ViewGroup) && textBase64 != null && textBase64.length() != 0) {
                viewAsJSON.put("descriptiveTextBase64", textBase64);
                return;
            }
            viewAsJSON.put("descriptiveTextBase64", y0.a((!TextUtils.isEmpty(contentDescription) ? y0.a((CharSequence) contentDescription.toString()) : y0.a((CharSequence) view.getClass().getSimpleName())).toString()));
        } catch (NullPointerException e) {
            PendoLogger.d(e, "Inside ViewHierarchyUtility.getViewTreeAndScreenState() while trying to populate DESCRIPTIVE_TEXT_BASE64", new Object[0]);
        }
    }

    public final boolean a(View viewChild, HashSet<View> discoverySet) {
        Intrinsics.checkNotNullParameter(discoverySet, "discoverySet");
        if (viewChild == null || discoverySet.contains(viewChild)) {
            return false;
        }
        PlatformStateManager platformStateManager = PlatformStateManager.INSTANCE;
        return platformStateManager.isNotReactNativeApp() || (platformStateManager.isReactNativeAnalyticsEnabled() && viewChild.getVisibility() == 0);
    }

    @SafeVarargs
    public void a(View view, a callback, Class<? extends View>... classes) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(classes, "classes");
        ArrayList arrayList = new ArrayList();
        arrayList.add(callback);
        b(view, arrayList, (Class[]) Arrays.copyOf(classes, classes.length));
    }

    @SafeVarargs
    private final boolean a(View view, HashSet<View> discoverySet, List<? extends a> callbacks, Class<? extends View>... classes) {
        ViewGroup viewGroup;
        int childCount;
        if (a(view, callbacks, (Class<? extends View>[]) Arrays.copyOf(classes, classes.length))) {
            return true;
        }
        discoverySet.add(view);
        if ((view instanceof ViewGroup) && (childCount = (viewGroup = (ViewGroup) view).getChildCount()) > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (!discoverySet.contains(childAt)) {
                    Intrinsics.checkNotNull(childAt);
                    if (a(childAt, discoverySet, callbacks, (Class<? extends View>[]) Arrays.copyOf(classes, classes.length))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
