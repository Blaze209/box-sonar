package com.box.android.base.compose;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentContainerView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SafeAndroidFragment.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0002H\u0096\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/box/android/base/compose/FragmentContainerViewFactory;", "Lkotlin/Function1;", "Landroid/content/Context;", "Landroid/view/View;", "containerId", "", "<init>", "(I)V", "lastCreatedContainer", "Landroidx/fragment/app/FragmentContainerView;", TtmlNode.RUBY_CONTAINER, "getContainer", "()Landroidx/fragment/app/FragmentContainerView;", "invoke", "context", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class FragmentContainerViewFactory implements Function1<Context, View> {
    private final int containerId;
    private FragmentContainerView lastCreatedContainer;

    public FragmentContainerViewFactory(int i) {
        this.containerId = i;
    }

    public final FragmentContainerView getContainer() {
        FragmentContainerView fragmentContainerView = this.lastCreatedContainer;
        if (fragmentContainerView != null) {
            return fragmentContainerView;
        }
        throw new IllegalStateException(("AndroidView has not created a container for " + this.containerId + " yet").toString());
    }

    @Override // kotlin.jvm.functions.Function1
    public FragmentContainerView invoke(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FragmentContainerView fragmentContainerView = new FragmentContainerView(context);
        fragmentContainerView.setId(this.containerId);
        this.lastCreatedContainer = fragmentContainerView;
        return fragmentContainerView;
    }
}
