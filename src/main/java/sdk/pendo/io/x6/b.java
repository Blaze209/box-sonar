package sdk.pendo.io.x6;

import android.app.Activity;
import android.view.View;
import android.view.ViewParent;
import android.widget.ScrollView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.s7.o0;
import sdk.pendo.io.s7.y;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ:\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002JE\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\rJ\u0019\u0010\n\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0004\b\n\u0010\u0010J4\u0010\u0014\u001a\u00020\u00132\"\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\t2\b\b\u0002\u0010\u0012\u001a\u00020\u0004J%\u0010\n\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00152\u0006\u0010\u0012\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\n\u0010\u0017JA\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\u00152\"\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u0012\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\n\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lsdk/pendo/io/x6/b;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "isIgnoreDynamicFragmentsInScrollView", "Ljava/util/HashMap;", "", "Lsdk/pendo/io/x6/c;", "Lkotlin/collections/HashMap;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/app/Activity;", "activity", "(Landroid/app/Activity;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/view/ViewParent;", "viewParent", "(Landroid/view/ViewParent;)Z", "fragmentsInfoHashMap", "isOldScreenIdFormat", "", "b", "Ljava/util/TreeSet;", "fragmentsNames", "(Ljava/util/TreeSet;Z)Ljava/lang/String;", "(Ljava/util/HashMap;Z)Ljava/util/TreeSet;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class b {

    /* JADX INFO: renamed from: sdk.pendo.io.x6.b$b, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.FragmentHelper", f = "FragmentHelper.kt", i = {0}, l = {46}, m = "populateFragmentsInfoList", n = {"newFragmentsInfoHashMap"}, s = {"L$0"})
    static final class C0520b extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        int d;

        C0520b(Continuation<? super C0520b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return b.this.a((Activity) null, false, (Continuation<? super HashMap<Integer, sdk.pendo.io.x6.c>>) this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.FragmentHelper$populateFragmentsInfoList$2$1", f = "FragmentHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ Ref.ObjectRef<HashMap<Integer, sdk.pendo.io.x6.c>> b;
        final /* synthetic */ b c;
        final /* synthetic */ Activity d;
        final /* synthetic */ boolean e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Ref.ObjectRef<HashMap<Integer, sdk.pendo.io.x6.c>> objectRef, b bVar, Activity activity, boolean z, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = objectRef;
            this.c = bVar;
            this.d = activity;
            this.e = z;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.b, this.c, this.d, this.e, continuation);
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [T, java.util.HashMap] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.b.element = this.c.a(((FragmentActivity) this.d).getSupportFragmentManager(), this.e);
            return Unit.INSTANCE;
        }
    }

    public final String b(HashMap<Integer, sdk.pendo.io.x6.c> fragmentsInfoHashMap, boolean isOldScreenIdFormat) {
        Intrinsics.checkNotNullParameter(fragmentsInfoHashMap, "fragmentsInfoHashMap");
        return a(a(fragmentsInfoHashMap, isOldScreenIdFormat), isOldScreenIdFormat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<Integer, sdk.pendo.io.x6.c> a(FragmentManager fragmentManager, boolean isIgnoreDynamicFragmentsInScrollView) {
        if (fragmentManager == null) {
            PendoLogger.w("FragmentHelper allActivityFragmentsInfo -> fragment manager is null", new Object[0]);
            return null;
        }
        HashMap<Integer, sdk.pendo.io.x6.c> map = new HashMap<>();
        ArrayDeque arrayDeque = new ArrayDeque();
        for (Fragment fragment : fragmentManager.getFragments()) {
            if (fragment != null) {
                arrayDeque.add(new Pair(fragment, 0));
            }
        }
        while (!arrayDeque.isEmpty()) {
            try {
                Pair pair = (Pair) arrayDeque.removeLast();
                Fragment fragment2 = (Fragment) pair.getFirst();
                int iIntValue = ((Number) pair.getSecond()).intValue();
                if (o0.a(fragment2)) {
                    if (isIgnoreDynamicFragmentsInScrollView) {
                        View view = fragment2.getView();
                        if (a(view != null ? view.getParent() : null)) {
                        }
                    }
                    View view2 = fragment2.getView();
                    if (view2 != null) {
                        int iHashCode = view2.hashCode();
                        Integer numValueOf = Integer.valueOf(iHashCode);
                        String simpleName = fragment2.getClass().getSimpleName();
                        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
                        map.put(numValueOf, new sdk.pendo.io.x6.c(simpleName, iIntValue, iHashCode));
                    }
                    for (Fragment fragment3 : fragment2.getChildFragmentManager().getFragments()) {
                        if (fragment3 != null) {
                            Intrinsics.checkNotNull(fragment3);
                            arrayDeque.add(new Pair(fragment3, Integer.valueOf(iIntValue + 1)));
                        }
                    }
                }
            } catch (Throwable th) {
                PendoLogger.w(th, "FragmentHelper allActivityFragmentsInfo -> " + th, new Object[0]);
                return map;
            }
        }
        return map;
    }

    public final TreeSet<String> a(HashMap<Integer, sdk.pendo.io.x6.c> fragmentsInfoHashMap, boolean isOldScreenIdFormat) {
        Intrinsics.checkNotNullParameter(fragmentsInfoHashMap, "fragmentsInfoHashMap");
        TreeSet<String> treeSet = new TreeSet<>();
        for (Map.Entry<Integer, sdk.pendo.io.x6.c> entry : fragmentsInfoHashMap.entrySet()) {
            if (!isOldScreenIdFormat || entry.getValue().getFragmentLevel() == 0) {
                treeSet.add(entry.getValue().getFragmentName());
            }
        }
        return treeSet;
    }

    public static /* synthetic */ String a(b bVar, HashMap map, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return bVar.b(map, z);
    }

    public final String a(TreeSet<String> fragmentsNames, boolean isOldScreenIdFormat) {
        y yVar;
        Intrinsics.checkNotNullParameter(fragmentsNames, "fragmentsNames");
        String str = "";
        StringBuilder sb = new StringBuilder("");
        if (!fragmentsNames.isEmpty()) {
            sb.append(i.FRAGMENTS_SEPARATOR);
            if (isOldScreenIdFormat) {
                yVar = y.a;
            } else {
                yVar = y.a;
                str = "|";
            }
            sb.append(yVar.a(str, fragmentsNames));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final boolean a(ViewParent viewParent) {
        if (viewParent != null) {
            return (viewParent instanceof NestedScrollView) || (viewParent instanceof ScrollView) || a(viewParent.getParent());
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(Activity activity, boolean z, Continuation<? super HashMap<Integer, sdk.pendo.io.x6.c>> continuation) {
        C0520b c0520b;
        Ref.ObjectRef objectRef;
        if (continuation instanceof C0520b) {
            c0520b = (C0520b) continuation;
            int i = c0520b.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                c0520b.d = i - Integer.MIN_VALUE;
            } else {
                c0520b = new C0520b(continuation);
            }
        } else {
            c0520b = new C0520b(continuation);
        }
        Object obj = c0520b.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c0520b.d;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            if (activity != null) {
                if (activity instanceof FragmentActivity) {
                    CoroutineContext coroutineContextPlus = Dispatchers.getMain().getImmediate().plus(new CoroutineName("populateFragmentsInfoList"));
                    c cVar = new c(objectRef2, this, activity, z, null);
                    c0520b.a = objectRef2;
                    c0520b.d = 1;
                    if (BuildersKt.withContext(coroutineContextPlus, cVar, c0520b) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    PendoLogger.d("FragmentHelper populateFragmentsInfoList -> activity is not a FragmentActivity", new Object[0]);
                }
            }
            objectRef = objectRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) c0520b.a;
            ResultKt.throwOnFailure(obj);
        }
        return objectRef.element;
    }
}
