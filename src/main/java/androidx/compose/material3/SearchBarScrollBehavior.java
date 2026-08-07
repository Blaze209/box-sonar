package androidx.compose.material3;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBar.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0013H&R\u001a\u0010\u0002\u001a\u00020\u00038'X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00038'X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Landroidx/compose/material3/SearchBarScrollBehavior;", "", "scrollOffset", "", "getScrollOffset", "()F", "setScrollOffset", "(F)V", "scrollOffsetLimit", "getScrollOffsetLimit", "setScrollOffsetLimit", "contentOffset", "getContentOffset", "setContentOffset", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getNestedScrollConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "searchBarScrollBehavior", "Landroidx/compose/ui/Modifier;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface SearchBarScrollBehavior {
    float getContentOffset();

    NestedScrollConnection getNestedScrollConnection();

    float getScrollOffset();

    float getScrollOffsetLimit();

    Modifier searchBarScrollBehavior(Modifier modifier);

    void setContentOffset(float f);

    void setScrollOffset(float f);

    void setScrollOffsetLimit(float f);
}
