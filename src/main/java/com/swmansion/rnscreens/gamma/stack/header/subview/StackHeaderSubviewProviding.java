package com.swmansion.rnscreens.gamma.stack.header.subview;

import android.view.View;
import kotlin.Metadata;

/* JADX INFO: compiled from: StackHeaderSubviewProviding.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubviewProviding;", "", "type", "Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubviewType;", "getType", "()Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubviewType;", "collapseMode", "Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubviewCollapseMode;", "getCollapseMode", "()Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubviewCollapseMode;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "updateContentOriginOffset", "", "x", "", "y", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface StackHeaderSubviewProviding {
    StackHeaderSubviewCollapseMode getCollapseMode();

    StackHeaderSubviewType getType();

    View getView();

    void updateContentOriginOffset(int x, int y);
}
