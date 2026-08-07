package com.pspdfkit.internal;

import android.graphics.Matrix;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.pspdfkit.internal.jni.NativeContentEditor;
import com.pspdfkit.utils.PdfLog;
import java.util.Collection;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/pspdfkit/internal/kb;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class kb extends ViewModel {
    public NativeContentEditor a;
    public final HashMap b = new HashMap();
    public final HashMap<Integer, d00> c = new HashMap<>();
    public final MutableSharedFlow<a> d;
    public final SharedFlow<a> e;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.pspdfkit.internal.kb$a[], still in use, count: 1, list:
      (r0v1 com.pspdfkit.internal.kb$a[]) from 0x001a: INVOKE (r0v1 com.pspdfkit.internal.kb$a[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class a {
        SAVE,
        DISCARD;

        static {
            EnumEntriesKt.enumEntries(aVarArr);
        }

        public a() {
            super(str, i);
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) c.clone();
        }
    }

    public kb() {
        Matrix matrix = ta.R;
        int i = gb.b0;
        MutableSharedFlow<a> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.d = mutableSharedFlowMutableSharedFlow$default;
        this.e = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
    }

    public final void a() {
        this.a = null;
        this.b.clear();
        Collection<d00> collectionValues = this.c.values();
        collectionValues.getClass();
        for (d00 d00Var : collectionValues) {
            try {
                FragmentManager fragmentManager = d00Var.a;
                String str = d00Var.b;
                int i = sk.c;
                fragmentManager.getClass();
                str.getClass();
                if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                    throw new IllegalStateException("removeFragment() may only be called from the main thread.");
                }
                Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag(str);
                if (fragmentFindFragmentByTag != null) {
                    fi.a(fragmentManager, fragmentFindFragmentByTag);
                }
            } catch (Exception e) {
                PdfLog.e("Nutri.CEditingSMHandler", e, "Error while cleaning up page content editing pagehandler savestate fragments.", new Object[0]);
            }
        }
        this.c.clear();
    }

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        a();
    }
}
