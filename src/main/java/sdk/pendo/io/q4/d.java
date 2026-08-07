package sdk.pendo.io.q4;

import android.view.View;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.k3.j;
import sdk.pendo.io.k3.o;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0005\u001a\u00020\u00022\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0014R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000b¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/q4/d;", "Lsdk/pendo/io/k3/j;", "", "Lsdk/pendo/io/k3/o;", "observer", "b", "Landroid/view/View;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/view/View;", "view", "", "Z", "callOnAttach", "<init>", "(Landroid/view/View;Z)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
final class d extends j<Unit> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final View view;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final boolean callOnAttach;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00050\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0014R\u0014\u0010\u000b\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0013\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00050\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lsdk/pendo/io/q4/d$a;", "Lsdk/pendo/io/l3/a;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "Landroid/view/View;", "view", "", "c", "Z", "callOnAttach", "Lsdk/pendo/io/k3/o;", "d", "Lsdk/pendo/io/k3/o;", "observer", "<init>", "(Landroid/view/View;ZLsdk/pendo/io/k3/o;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    private static final class a extends sdk.pendo.io.l3.a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final View view;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final boolean callOnAttach;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        private final o<? super Unit> observer;

        public a(View view, boolean z, o<? super Unit> observer) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(observer, "observer");
            this.view = view;
            this.callOnAttach = z;
            this.observer = observer;
        }

        @Override // sdk.pendo.io.l3.a
        protected void a() {
            this.view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (!this.callOnAttach || isDisposed()) {
                return;
            }
            this.observer.onNext(Unit.INSTANCE);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (this.callOnAttach || isDisposed()) {
                return;
            }
            this.observer.onNext(Unit.INSTANCE);
        }
    }

    public d(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.callOnAttach = z;
    }

    @Override // sdk.pendo.io.k3.j
    protected void b(o<? super Unit> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (sdk.pendo.io.p4.a.a(observer)) {
            a aVar = new a(this.view, this.callOnAttach, observer);
            observer.onSubscribe(aVar);
            this.view.addOnAttachStateChangeListener(aVar);
        }
    }
}
