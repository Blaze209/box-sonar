package sdk.pendo.io.s7;

import android.view.View;
import android.view.ViewGroup;
import androidx.media3.exoplayer.upstream.CmcdData;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayDeque;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import sdk.pendo.io.R;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.sdk.react.PlatformStateManager;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\n2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rH\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0005J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0005J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lsdk/pendo/io/s7/d1;", "", "Landroid/view/ViewGroup;", "viewGroup", "Ljava/util/ArrayDeque;", "Landroid/view/View;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "view", "", "b", "e", "Lkotlin/Function0;", "extractor", "value", "f", "c", "g", "d", "(Landroid/view/View;)Ljava/lang/String;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class d1 {
    public static final d1 a = new d1();

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class a extends Lambda implements Function0<Object> {
        final /* synthetic */ View a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view) {
            super(0);
            this.a = view;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return this.a.getTag();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class b extends Lambda implements Function0<Object> {
        final /* synthetic */ View a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(View view) {
            super(0);
            this.a = view;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return this.a.getTag(R.id.pnd_maui_view_tag);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class c extends Lambda implements Function0<Object> {
        final /* synthetic */ View a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(View view) {
            super(0);
            this.a = view;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return this.a.getTag();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class d extends Lambda implements Function0<Object> {
        final /* synthetic */ View a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(View view) {
            super(0);
            this.a = view;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return this.a.getTag(R.id.pnd_view_tag);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class e extends Lambda implements Function0<Object> {
        final /* synthetic */ View a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(View view) {
            super(0);
            this.a = view;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return this.a.getTag();
        }
    }

    private d1() {
    }

    private final void a(ViewGroup viewGroup, ArrayDeque<View> queue) {
        try {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != null) {
                    queue.add(childAt);
                }
            }
        } catch (Exception e2) {
            PendoLogger.d("ViewTagExtractor", "View hierarchy mutated during read: " + e2.getMessage());
        }
    }

    private final String b(View view) {
        return a(new c(view));
    }

    private final String e(View view) {
        return a(new e(view));
    }

    public final String c(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        String strA = a(new d(view));
        if (strA != null) {
            return a.a(strA);
        }
        return null;
    }

    public final String d(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        PlatformStateManager platformStateManager = PlatformStateManager.INSTANCE;
        if (platformStateManager.isXamarinFormsOrMaui()) {
            return a(view);
        }
        return platformStateManager.isReactNativeApp() ? e(view) : b(view);
    }

    public final String f(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        String strD = d(view);
        if (strD == null) {
            return null;
        }
        return a(strD);
    }

    public final String g(View view) {
        if (view == null) {
            return null;
        }
        try {
            String strF = f(view);
            if (strF != null) {
                return strF;
            }
            if (!(view instanceof ViewGroup)) {
                return null;
            }
            ArrayDeque<View> arrayDeque = new ArrayDeque<>();
            while (true) {
                a((ViewGroup) view, arrayDeque);
                while (!arrayDeque.isEmpty()) {
                    view = arrayDeque.removeFirst();
                    Intrinsics.checkNotNull(view);
                    String strF2 = f(view);
                    if (strF2 != null) {
                        return strF2;
                    }
                    if (view instanceof ViewGroup) {
                    }
                }
            }
        } catch (Exception e2) {
            PendoLogger.d("ViewTagExtractor", "Unexpected error during BFS traversal", e2);
        }
        return null;
    }

    private final String a(String value) {
        return y0.a(value);
    }

    private final String a(View view) {
        String strA = a(new b(view));
        return (strA == null || StringsKt.isBlank(strA)) ? a(new a(view)) : strA;
    }

    private final String a(Function0<? extends Object> extractor) {
        try {
            Object objInvoke = extractor.invoke();
            if (!(objInvoke instanceof CharSequence)) {
                if (objInvoke instanceof Number) {
                    return ((Number) objInvoke).toString();
                }
                return null;
            }
            String string = objInvoke.toString();
            if (StringsKt.isBlank(string)) {
                return null;
            }
            return string;
        } catch (Exception e2) {
            PendoLogger.d("ViewTagExtractor", "Failed to extract tag: " + e2.getMessage());
            return null;
        }
    }
}
