package sdk.pendo.io.r4;

import android.widget.CompoundButton;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.k3.o;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0014R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u00028TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/r4/a;", "Lsdk/pendo/io/o4/a;", "", "Lsdk/pendo/io/k3/o;", "observer", "", "d", "Landroid/widget/CompoundButton;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/widget/CompoundButton;", "view", CmcdData.OBJECT_TYPE_MANIFEST, "()Ljava/lang/Boolean;", "initialValue", "<init>", "(Landroid/widget/CompoundButton;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
final class a extends sdk.pendo.io.o4.a<Boolean> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final CompoundButton view;

    /* JADX INFO: renamed from: sdk.pendo.io.r4.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00050\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0014R\u0014\u0010\f\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00050\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/r4/a$a;", "Lsdk/pendo/io/l3/a;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "Landroid/widget/CompoundButton;", "compoundButton", "", "isChecked", "", "onCheckedChanged", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "Landroid/widget/CompoundButton;", "view", "Lsdk/pendo/io/k3/o;", "c", "Lsdk/pendo/io/k3/o;", "observer", "<init>", "(Landroid/widget/CompoundButton;Lsdk/pendo/io/k3/o;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    private static final class C0472a extends sdk.pendo.io.l3.a implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final CompoundButton view;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final o<? super Boolean> observer;

        public C0472a(CompoundButton view, o<? super Boolean> observer) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(observer, "observer");
            this.view = view;
            this.observer = observer;
        }

        @Override // sdk.pendo.io.l3.a
        protected void a() {
            this.view.setOnCheckedChangeListener(null);
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            Intrinsics.checkNotNullParameter(compoundButton, "compoundButton");
            if (isDisposed()) {
                return;
            }
            this.observer.onNext(Boolean.valueOf(isChecked));
        }
    }

    public a(CompoundButton view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    @Override // sdk.pendo.io.o4.a
    protected void d(o<? super Boolean> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (sdk.pendo.io.p4.a.a(observer)) {
            C0472a c0472a = new C0472a(this.view, observer);
            observer.onSubscribe(c0472a);
            this.view.setOnCheckedChangeListener(c0472a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.o4.a
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public Boolean l() {
        return Boolean.valueOf(this.view.isChecked());
    }
}
