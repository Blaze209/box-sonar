package androidx.constraintlayout.compose;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: MotionLayout.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/constraintlayout/compose/Api30Impl;", "", "()V", "isShowingLayoutBounds", "", "view", "Landroid/view/View;", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class Api30Impl {
    public static final Api30Impl INSTANCE = new Api30Impl();

    private Api30Impl() {
    }

    @JvmStatic
    public static final boolean isShowingLayoutBounds(View view) {
        return view.isShowingLayoutBounds();
    }
}
