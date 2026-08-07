package sdk.pendo.io.x6;

import android.view.View;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0010\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000f\u0010\u0010B\t\b\u0010¢\u0006\u0004\b\u000f\u0010\u0011J\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\bR'\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00000\nj\b\u0012\u0004\u0012\u00020\u0000`\u000b8\u0006¢\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\u0004\u0010\r¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/x6/f;", "", "child", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/view/View;", "b", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "view", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "children", "<init>", "(Landroid/view/View;)V", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class f {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final WeakReference<Object> view;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final ArrayList<f> children;

    public f() {
        this.children = new ArrayList<>();
        this.view = new WeakReference<>(null);
    }

    public final void a(f child) {
        Intrinsics.checkNotNullParameter(child, "child");
        this.children.add(child);
    }

    public final View b() {
        Object obj = this.view.get();
        if (obj instanceof View) {
            return (View) obj;
        }
        return null;
    }

    public f(View view) {
        this.children = new ArrayList<>();
        this.view = new WeakReference<>(view);
    }

    public final ArrayList<f> a() {
        return this.children;
    }
}
