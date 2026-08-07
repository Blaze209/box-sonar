package androidx.compose.material3;

import androidx.compose.ui.window.SecureFlagPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModalBottomSheet.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u001d\b\u0016\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0007B'\b\u0016\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\nB7\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\rJ\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0011R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u001a"}, d2 = {"Landroidx/compose/material3/ModalBottomSheetProperties;", "", "<init>", "()V", "shouldDismissOnBackPress", "", "shouldDismissOnClickOutside", "(ZZ)V", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "(Landroidx/compose/ui/window/SecureFlagPolicy;ZZ)V", "isAppearanceLightStatusBars", "isAppearanceLightNavigationBars", "(ZZLandroidx/compose/ui/window/SecureFlagPolicy;ZZ)V", "getSecurePolicy", "()Landroidx/compose/ui/window/SecureFlagPolicy;", "getShouldDismissOnBackPress", "()Z", "isAppearanceLightStatusBars$material3", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "isAppearanceLightNavigationBars$material3", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ModalBottomSheetProperties {
    public static final int $stable = 0;
    private final Boolean isAppearanceLightNavigationBars;
    private final Boolean isAppearanceLightStatusBars;
    private final SecureFlagPolicy securePolicy;
    private final boolean shouldDismissOnBackPress;
    private final boolean shouldDismissOnClickOutside;

    public final SecureFlagPolicy getSecurePolicy() {
        return this.securePolicy;
    }

    public final boolean getShouldDismissOnBackPress() {
        return this.shouldDismissOnBackPress;
    }

    /* JADX INFO: renamed from: shouldDismissOnClickOutside, reason: from getter */
    public final boolean getShouldDismissOnClickOutside() {
        return this.shouldDismissOnClickOutside;
    }

    /* JADX INFO: renamed from: isAppearanceLightStatusBars$material3, reason: from getter */
    public final Boolean getIsAppearanceLightStatusBars() {
        return this.isAppearanceLightStatusBars;
    }

    /* JADX INFO: renamed from: isAppearanceLightNavigationBars$material3, reason: from getter */
    public final Boolean getIsAppearanceLightNavigationBars() {
        return this.isAppearanceLightNavigationBars;
    }

    public ModalBottomSheetProperties() {
        this.securePolicy = SecureFlagPolicy.Inherit;
        this.shouldDismissOnBackPress = true;
        this.shouldDismissOnClickOutside = true;
        this.isAppearanceLightStatusBars = null;
        this.isAppearanceLightNavigationBars = null;
    }

    public ModalBottomSheetProperties(boolean z, boolean z2) {
        this.securePolicy = SecureFlagPolicy.Inherit;
        this.shouldDismissOnBackPress = z;
        this.shouldDismissOnClickOutside = z2;
        this.isAppearanceLightNavigationBars = null;
        this.isAppearanceLightStatusBars = null;
    }

    public /* synthetic */ ModalBottomSheetProperties(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2);
    }

    public /* synthetic */ ModalBottomSheetProperties(SecureFlagPolicy secureFlagPolicy, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SecureFlagPolicy.Inherit : secureFlagPolicy, (i & 2) != 0 ? true : z, (i & 4) != 0 ? true : z2);
    }

    public ModalBottomSheetProperties(SecureFlagPolicy secureFlagPolicy, boolean z, boolean z2) {
        this.securePolicy = secureFlagPolicy;
        this.shouldDismissOnBackPress = z;
        this.shouldDismissOnClickOutside = z2;
        this.isAppearanceLightNavigationBars = null;
        this.isAppearanceLightStatusBars = null;
    }

    public /* synthetic */ ModalBottomSheetProperties(boolean z, boolean z2, SecureFlagPolicy secureFlagPolicy, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2, (i & 4) != 0 ? SecureFlagPolicy.Inherit : secureFlagPolicy, (i & 8) != 0 ? true : z3, (i & 16) != 0 ? true : z4);
    }

    public ModalBottomSheetProperties(boolean z, boolean z2, SecureFlagPolicy secureFlagPolicy, boolean z3, boolean z4) {
        this.shouldDismissOnBackPress = z3;
        this.shouldDismissOnClickOutside = z4;
        this.securePolicy = secureFlagPolicy;
        this.isAppearanceLightStatusBars = Boolean.valueOf(z);
        this.isAppearanceLightNavigationBars = Boolean.valueOf(z2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModalBottomSheetProperties)) {
            return false;
        }
        ModalBottomSheetProperties modalBottomSheetProperties = (ModalBottomSheetProperties) other;
        return this.securePolicy == modalBottomSheetProperties.securePolicy && Intrinsics.areEqual(this.isAppearanceLightStatusBars, modalBottomSheetProperties.isAppearanceLightStatusBars) && Intrinsics.areEqual(this.isAppearanceLightNavigationBars, modalBottomSheetProperties.isAppearanceLightNavigationBars) && this.shouldDismissOnClickOutside == modalBottomSheetProperties.shouldDismissOnClickOutside && this.shouldDismissOnBackPress == modalBottomSheetProperties.shouldDismissOnBackPress;
    }

    public int hashCode() {
        int iHashCode = ((this.securePolicy.hashCode() * 31) + Boolean.hashCode(this.shouldDismissOnBackPress)) * 31;
        Boolean bool = this.isAppearanceLightStatusBars;
        int iHashCode2 = (iHashCode + (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0)) * 31;
        Boolean bool2 = this.isAppearanceLightNavigationBars;
        return ((iHashCode2 + (bool2 != null ? Boolean.hashCode(bool2.booleanValue()) : 0)) * 31) + Boolean.hashCode(this.shouldDismissOnClickOutside);
    }
}
