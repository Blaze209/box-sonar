package androidx.fragment.compose;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentContainerView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AndroidFragment.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0002R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/fragment/compose/FragmentContainerViewFactory;", "Lkotlin/Function1;", "Landroid/content/Context;", "Landroid/view/View;", "containerId", "", "(I)V", TtmlNode.RUBY_CONTAINER, "Landroidx/fragment/app/FragmentContainerView;", "getContainer", "()Landroidx/fragment/app/FragmentContainerView;", "lastCreatedContainer", "invoke", "context", "fragment-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
        FragmentContainerView fragmentContainerView = new FragmentContainerView(context);
        fragmentContainerView.setId(this.containerId);
        this.lastCreatedContainer = fragmentContainerView;
        return fragmentContainerView;
    }
}
