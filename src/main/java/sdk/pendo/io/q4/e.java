package sdk.pendo.io.q4;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.k3.j;
import sdk.pendo.io.k3.o;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0005\u001a\u00020\u00022\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0014R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lsdk/pendo/io/q4/e;", "Lsdk/pendo/io/k3/j;", "", "Lsdk/pendo/io/k3/o;", "observer", "b", "Landroid/view/View;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
final class e extends j<Unit> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final View view;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u000e\u0010\r\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00030\n¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0014R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00030\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/q4/e$a;", "Lsdk/pendo/io/l3/a;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/view/View;", "b", "Landroid/view/View;", "view", "Lsdk/pendo/io/k3/o;", "c", "Lsdk/pendo/io/k3/o;", "observer", "<init>", "(Landroid/view/View;Lsdk/pendo/io/k3/o;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    private static final class a extends sdk.pendo.io.l3.a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final View view;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final o<? super Unit> observer;

        public a(View view, o<? super Unit> observer) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(observer, "observer");
            this.view = view;
            this.observer = observer;
        }

        @Override // sdk.pendo.io.l3.a
        protected void a() {
            this.view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (isDisposed()) {
                return;
            }
            this.observer.onNext(Unit.INSTANCE);
        }
    }

    public e(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    @Override // sdk.pendo.io.k3.j
    protected void b(o<? super Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (sdk.pendo.io.p4.a.a(observer)) {
            a aVar = new a(this.view, observer);
            observer.onSubscribe(aVar);
            this.view.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
        }
    }
}
