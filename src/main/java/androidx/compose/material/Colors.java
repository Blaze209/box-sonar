package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.graphics.Color;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.modules.appstate.AppStateModule;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Colors.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b2\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u008f\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b@\u0010AJ\b\u0010B\u001a\u00020CH\u0016R+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R+\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R+\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R+\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0019\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R+\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0019\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R+\u0010\b\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010\u0019\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R+\u0010\t\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0019\u001a\u0004\b)\u0010\u0015\"\u0004\b*\u0010\u0017R+\u0010\n\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010\u0019\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b1\u0010\u0019\u001a\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0017R+\u0010\f\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010\u0019\u001a\u0004\b2\u0010\u0015\"\u0004\b3\u0010\u0017R+\u0010\r\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b7\u0010\u0019\u001a\u0004\b5\u0010\u0015\"\u0004\b6\u0010\u0017R+\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b:\u0010\u0019\u001a\u0004\b8\u0010\u0015\"\u0004\b9\u0010\u0017R+\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00108F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b>\u0010\u0019\u001a\u0004\b\u000f\u0010;\"\u0004\b<\u0010=¨\u0006D"}, d2 = {"Landroidx/compose/material/Colors;", "", "primary", "Landroidx/compose/ui/graphics/Color;", "primaryVariant", "secondary", "secondaryVariant", AppStateModule.APP_STATE_BACKGROUND, "surface", "error", "onPrimary", "onSecondary", "onBackground", "onSurface", "onError", "isLight", "", "<init>", "(JJJJJJJJJJJJZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "getPrimary-0d7_KjU", "()J", "setPrimary-8_81llA$material", "(J)V", "primary$delegate", "Landroidx/compose/runtime/MutableState;", "getPrimaryVariant-0d7_KjU", "setPrimaryVariant-8_81llA$material", "primaryVariant$delegate", "getSecondary-0d7_KjU", "setSecondary-8_81llA$material", "secondary$delegate", "getSecondaryVariant-0d7_KjU", "setSecondaryVariant-8_81llA$material", "secondaryVariant$delegate", "getBackground-0d7_KjU", "setBackground-8_81llA$material", "background$delegate", "getSurface-0d7_KjU", "setSurface-8_81llA$material", "surface$delegate", "getError-0d7_KjU", "setError-8_81llA$material", "error$delegate", "getOnPrimary-0d7_KjU", "setOnPrimary-8_81llA$material", "onPrimary$delegate", "getOnSecondary-0d7_KjU", "setOnSecondary-8_81llA$material", "onSecondary$delegate", "getOnBackground-0d7_KjU", "setOnBackground-8_81llA$material", "onBackground$delegate", "getOnSurface-0d7_KjU", "setOnSurface-8_81llA$material", "onSurface$delegate", "getOnError-0d7_KjU", "setOnError-8_81llA$material", "onError$delegate", "()Z", "setLight$material", "(Z)V", "isLight$delegate", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-pvPzIIM", "(JJJJJJJJJJJJZ)Landroidx/compose/material/Colors;", "toString", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Colors {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: background$delegate, reason: from kotlin metadata */
    private final MutableState background;

    /* JADX INFO: renamed from: error$delegate, reason: from kotlin metadata */
    private final MutableState error;

    /* JADX INFO: renamed from: isLight$delegate, reason: from kotlin metadata */
    private final MutableState isLight;

    /* JADX INFO: renamed from: onBackground$delegate, reason: from kotlin metadata */
    private final MutableState onBackground;

    /* JADX INFO: renamed from: onError$delegate, reason: from kotlin metadata */
    private final MutableState onError;

    /* JADX INFO: renamed from: onPrimary$delegate, reason: from kotlin metadata */
    private final MutableState onPrimary;

    /* JADX INFO: renamed from: onSecondary$delegate, reason: from kotlin metadata */
    private final MutableState onSecondary;

    /* JADX INFO: renamed from: onSurface$delegate, reason: from kotlin metadata */
    private final MutableState onSurface;

    /* JADX INFO: renamed from: primary$delegate, reason: from kotlin metadata */
    private final MutableState primary;

    /* JADX INFO: renamed from: primaryVariant$delegate, reason: from kotlin metadata */
    private final MutableState primaryVariant;

    /* JADX INFO: renamed from: secondary$delegate, reason: from kotlin metadata */
    private final MutableState secondary;

    /* JADX INFO: renamed from: secondaryVariant$delegate, reason: from kotlin metadata */
    private final MutableState secondaryVariant;

    /* JADX INFO: renamed from: surface$delegate, reason: from kotlin metadata */
    private final MutableState surface;

    public /* synthetic */ Colors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, z);
    }

    private Colors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, boolean z) {
        this.primary = SnapshotStateKt.mutableStateOf(Color.m6804boximpl(j), SnapshotStateKt.structuralEqualityPolicy());
        this.primaryVariant = SnapshotStateKt.mutableStateOf(Color.m6804boximpl(j2), SnapshotStateKt.structuralEqualityPolicy());
        this.secondary = SnapshotStateKt.mutableStateOf(Color.m6804boximpl(j3), SnapshotStateKt.structuralEqualityPolicy());
        this.secondaryVariant = SnapshotStateKt.mutableStateOf(Color.m6804boximpl(j4), SnapshotStateKt.structuralEqualityPolicy());
        this.background = SnapshotStateKt.mutableStateOf(Color.m6804boximpl(j5), SnapshotStateKt.structuralEqualityPolicy());
        this.surface = SnapshotStateKt.mutableStateOf(Color.m6804boximpl(j6), SnapshotStateKt.structuralEqualityPolicy());
        this.error = SnapshotStateKt.mutableStateOf(Color.m6804boximpl(j7), SnapshotStateKt.structuralEqualityPolicy());
        this.onPrimary = SnapshotStateKt.mutableStateOf(Color.m6804boximpl(j8), SnapshotStateKt.structuralEqualityPolicy());
        this.onSecondary = SnapshotStateKt.mutableStateOf(Color.m6804boximpl(j9), SnapshotStateKt.structuralEqualityPolicy());
        this.onBackground = SnapshotStateKt.mutableStateOf(Color.m6804boximpl(j10), SnapshotStateKt.structuralEqualityPolicy());
        this.onSurface = SnapshotStateKt.mutableStateOf(Color.m6804boximpl(j11), SnapshotStateKt.structuralEqualityPolicy());
        this.onError = SnapshotStateKt.mutableStateOf(Color.m6804boximpl(j12), SnapshotStateKt.structuralEqualityPolicy());
        this.isLight = SnapshotStateKt.mutableStateOf(Boolean.valueOf(z), SnapshotStateKt.structuralEqualityPolicy());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getPrimary-0d7_KjU, reason: not valid java name */
    public final long m2342getPrimary0d7_KjU() {
        return ((Color) this.primary.getValue()).m6824unboximpl();
    }

    /* JADX INFO: renamed from: setPrimary-8_81llA$material, reason: not valid java name */
    public final void m2354setPrimary8_81llA$material(long j) {
        this.primary.setValue(Color.m6804boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getPrimaryVariant-0d7_KjU, reason: not valid java name */
    public final long m2343getPrimaryVariant0d7_KjU() {
        return ((Color) this.primaryVariant.getValue()).m6824unboximpl();
    }

    /* JADX INFO: renamed from: setPrimaryVariant-8_81llA$material, reason: not valid java name */
    public final void m2355setPrimaryVariant8_81llA$material(long j) {
        this.primaryVariant.setValue(Color.m6804boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getSecondary-0d7_KjU, reason: not valid java name */
    public final long m2344getSecondary0d7_KjU() {
        return ((Color) this.secondary.getValue()).m6824unboximpl();
    }

    /* JADX INFO: renamed from: setSecondary-8_81llA$material, reason: not valid java name */
    public final void m2356setSecondary8_81llA$material(long j) {
        this.secondary.setValue(Color.m6804boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getSecondaryVariant-0d7_KjU, reason: not valid java name */
    public final long m2345getSecondaryVariant0d7_KjU() {
        return ((Color) this.secondaryVariant.getValue()).m6824unboximpl();
    }

    /* JADX INFO: renamed from: setSecondaryVariant-8_81llA$material, reason: not valid java name */
    public final void m2357setSecondaryVariant8_81llA$material(long j) {
        this.secondaryVariant.setValue(Color.m6804boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m2335getBackground0d7_KjU() {
        return ((Color) this.background.getValue()).m6824unboximpl();
    }

    /* JADX INFO: renamed from: setBackground-8_81llA$material, reason: not valid java name */
    public final void m2347setBackground8_81llA$material(long j) {
        this.background.setValue(Color.m6804boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getSurface-0d7_KjU, reason: not valid java name */
    public final long m2346getSurface0d7_KjU() {
        return ((Color) this.surface.getValue()).m6824unboximpl();
    }

    /* JADX INFO: renamed from: setSurface-8_81llA$material, reason: not valid java name */
    public final void m2358setSurface8_81llA$material(long j) {
        this.surface.setValue(Color.m6804boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getError-0d7_KjU, reason: not valid java name */
    public final long m2336getError0d7_KjU() {
        return ((Color) this.error.getValue()).m6824unboximpl();
    }

    /* JADX INFO: renamed from: setError-8_81llA$material, reason: not valid java name */
    public final void m2348setError8_81llA$material(long j) {
        this.error.setValue(Color.m6804boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnPrimary-0d7_KjU, reason: not valid java name */
    public final long m2339getOnPrimary0d7_KjU() {
        return ((Color) this.onPrimary.getValue()).m6824unboximpl();
    }

    /* JADX INFO: renamed from: setOnPrimary-8_81llA$material, reason: not valid java name */
    public final void m2351setOnPrimary8_81llA$material(long j) {
        this.onPrimary.setValue(Color.m6804boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnSecondary-0d7_KjU, reason: not valid java name */
    public final long m2340getOnSecondary0d7_KjU() {
        return ((Color) this.onSecondary.getValue()).m6824unboximpl();
    }

    /* JADX INFO: renamed from: setOnSecondary-8_81llA$material, reason: not valid java name */
    public final void m2352setOnSecondary8_81llA$material(long j) {
        this.onSecondary.setValue(Color.m6804boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnBackground-0d7_KjU, reason: not valid java name */
    public final long m2337getOnBackground0d7_KjU() {
        return ((Color) this.onBackground.getValue()).m6824unboximpl();
    }

    /* JADX INFO: renamed from: setOnBackground-8_81llA$material, reason: not valid java name */
    public final void m2349setOnBackground8_81llA$material(long j) {
        this.onBackground.setValue(Color.m6804boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnSurface-0d7_KjU, reason: not valid java name */
    public final long m2341getOnSurface0d7_KjU() {
        return ((Color) this.onSurface.getValue()).m6824unboximpl();
    }

    /* JADX INFO: renamed from: setOnSurface-8_81llA$material, reason: not valid java name */
    public final void m2353setOnSurface8_81llA$material(long j) {
        this.onSurface.setValue(Color.m6804boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOnError-0d7_KjU, reason: not valid java name */
    public final long m2338getOnError0d7_KjU() {
        return ((Color) this.onError.getValue()).m6824unboximpl();
    }

    /* JADX INFO: renamed from: setOnError-8_81llA$material, reason: not valid java name */
    public final void m2350setOnError8_81llA$material(long j) {
        this.onError.setValue(Color.m6804boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isLight() {
        return ((Boolean) this.isLight.getValue()).booleanValue();
    }

    public final void setLight$material(boolean z) {
        this.isLight.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: copy-pvPzIIM, reason: not valid java name */
    public final Colors m2334copypvPzIIM(long primary, long primaryVariant, long secondary, long secondaryVariant, long background, long surface, long error, long onPrimary, long onSecondary, long onBackground, long onSurface, long onError, boolean isLight) {
        return new Colors(primary, primaryVariant, secondary, secondaryVariant, background, surface, error, onPrimary, onSecondary, onBackground, onSurface, onError, isLight, null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Colors(primary=");
        sb.append((Object) Color.m6822toStringimpl(m2342getPrimary0d7_KjU())).append(", primaryVariant=").append((Object) Color.m6822toStringimpl(m2343getPrimaryVariant0d7_KjU())).append(", secondary=").append((Object) Color.m6822toStringimpl(m2344getSecondary0d7_KjU())).append(", secondaryVariant=").append((Object) Color.m6822toStringimpl(m2345getSecondaryVariant0d7_KjU())).append(", background=").append((Object) Color.m6822toStringimpl(m2335getBackground0d7_KjU())).append(", surface=").append((Object) Color.m6822toStringimpl(m2346getSurface0d7_KjU())).append(", error=").append((Object) Color.m6822toStringimpl(m2336getError0d7_KjU())).append(", onPrimary=").append((Object) Color.m6822toStringimpl(m2339getOnPrimary0d7_KjU())).append(", onSecondary=").append((Object) Color.m6822toStringimpl(m2340getOnSecondary0d7_KjU())).append(", onBackground=").append((Object) Color.m6822toStringimpl(m2337getOnBackground0d7_KjU())).append(", onSurface=").append((Object) Color.m6822toStringimpl(m2341getOnSurface0d7_KjU())).append(", onError=");
        sb.append((Object) Color.m6822toStringimpl(m2338getOnError0d7_KjU())).append(", isLight=").append(isLight()).append(')');
        return sb.toString();
    }
}
