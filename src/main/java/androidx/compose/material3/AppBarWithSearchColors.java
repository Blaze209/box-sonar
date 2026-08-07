package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBar.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\fJ\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0007\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0015\u0010\u0010¨\u0006\u001b"}, d2 = {"Landroidx/compose/material3/AppBarWithSearchColors;", "", "searchBarColors", "Landroidx/compose/material3/SearchBarColors;", "scrolledSearchBarContainerColor", "Landroidx/compose/ui/graphics/Color;", "appBarContainerColor", "scrolledAppBarContainerColor", "appBarNavigationIconColor", "appBarActionIconColor", "<init>", "(Landroidx/compose/material3/SearchBarColors;JJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/material3/SearchBarColors;JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSearchBarColors", "()Landroidx/compose/material3/SearchBarColors;", "getScrolledSearchBarContainerColor-0d7_KjU", "()J", "J", "getAppBarContainerColor-0d7_KjU", "getScrolledAppBarContainerColor-0d7_KjU", "getAppBarNavigationIconColor-0d7_KjU", "getAppBarActionIconColor-0d7_KjU", "equals", "", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppBarWithSearchColors {
    public static final int $stable = 0;
    private final long appBarActionIconColor;
    private final long appBarContainerColor;
    private final long appBarNavigationIconColor;
    private final long scrolledAppBarContainerColor;
    private final long scrolledSearchBarContainerColor;
    private final SearchBarColors searchBarColors;

    public /* synthetic */ AppBarWithSearchColors(SearchBarColors searchBarColors, long j, long j2, long j3, long j4, long j5, DefaultConstructorMarker defaultConstructorMarker) {
        this(searchBarColors, j, j2, j3, j4, j5);
    }

    public /* synthetic */ AppBarWithSearchColors(SearchBarColors searchBarColors, long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(searchBarColors, j, j2, j3);
    }

    private AppBarWithSearchColors(SearchBarColors searchBarColors, long j, long j2, long j3, long j4, long j5) {
        this.searchBarColors = searchBarColors;
        this.scrolledSearchBarContainerColor = j;
        this.appBarContainerColor = j2;
        this.scrolledAppBarContainerColor = j3;
        this.appBarNavigationIconColor = j4;
        this.appBarActionIconColor = j5;
    }

    public final SearchBarColors getSearchBarColors() {
        return this.searchBarColors;
    }

    /* JADX INFO: renamed from: getScrolledSearchBarContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getScrolledSearchBarContainerColor() {
        return this.scrolledSearchBarContainerColor;
    }

    /* JADX INFO: renamed from: getAppBarContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getAppBarContainerColor() {
        return this.appBarContainerColor;
    }

    /* JADX INFO: renamed from: getScrolledAppBarContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getScrolledAppBarContainerColor() {
        return this.scrolledAppBarContainerColor;
    }

    /* JADX INFO: renamed from: getAppBarNavigationIconColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getAppBarNavigationIconColor() {
        return this.appBarNavigationIconColor;
    }

    /* JADX INFO: renamed from: getAppBarActionIconColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getAppBarActionIconColor() {
        return this.appBarActionIconColor;
    }

    private AppBarWithSearchColors(SearchBarColors searchBarColors, long j, long j2, long j3) {
        this(searchBarColors, Color.INSTANCE.m6850getUnspecified0d7_KjU(), j, Color.INSTANCE.m6850getUnspecified0d7_KjU(), j2, j3, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppBarWithSearchColors)) {
            return false;
        }
        AppBarWithSearchColors appBarWithSearchColors = (AppBarWithSearchColors) other;
        return Intrinsics.areEqual(this.searchBarColors, appBarWithSearchColors.searchBarColors) && Color.m6815equalsimpl0(this.scrolledSearchBarContainerColor, appBarWithSearchColors.scrolledSearchBarContainerColor) && Color.m6815equalsimpl0(this.appBarContainerColor, appBarWithSearchColors.appBarContainerColor) && Color.m6815equalsimpl0(this.scrolledAppBarContainerColor, appBarWithSearchColors.scrolledAppBarContainerColor) && Color.m6815equalsimpl0(this.appBarNavigationIconColor, appBarWithSearchColors.appBarNavigationIconColor) && Color.m6815equalsimpl0(this.appBarActionIconColor, appBarWithSearchColors.appBarActionIconColor);
    }

    public int hashCode() {
        return (((((((((this.searchBarColors.hashCode() * 31) + Color.m6821hashCodeimpl(this.scrolledSearchBarContainerColor)) * 31) + Color.m6821hashCodeimpl(this.appBarContainerColor)) * 31) + Color.m6821hashCodeimpl(this.scrolledAppBarContainerColor)) * 31) + Color.m6821hashCodeimpl(this.appBarNavigationIconColor)) * 31) + Color.m6821hashCodeimpl(this.appBarActionIconColor);
    }
}
