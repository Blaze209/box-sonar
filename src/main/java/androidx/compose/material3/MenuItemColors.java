package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Menu.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bi\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010B9\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0011J\u0087\u0001\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u0007¢\u0006\u0004\b(\u0010)JI\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b*\u0010+J!\u0010\u0002\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020-H\u0001¢\u0006\u0004\b/\u00100J!\u0010\u0004\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020-H\u0001¢\u0006\u0004\b1\u00100J!\u0010\u0005\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020-H\u0001¢\u0006\u0004\b2\u00100J!\u0010\t\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020-H\u0001¢\u0006\u0004\b3\u00100J\u0013\u00104\u001a\u00020-2\b\u00105\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00106\u001a\u000207H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0019\u0010\u0013R\u001e\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0013R\u001e\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001e\u0010\u0013R\u001e\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u0013R\u001e\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u0013R\u001e\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010\u0013R\u001e\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010\u0013¨\u00068"}, d2 = {"Landroidx/compose/material3/MenuItemColors;", "", "textColor", "Landroidx/compose/ui/graphics/Color;", "leadingIconColor", "trailingIconColor", "disabledTextColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "containerColor", "disabledContainerColor", "selectedTextColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "selectedContainerColor", "<init>", "(JJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getTextColor-0d7_KjU", "()J", "J", "getLeadingIconColor-0d7_KjU", "getTrailingIconColor-0d7_KjU", "getDisabledTextColor-0d7_KjU", "getDisabledLeadingIconColor-0d7_KjU", "getDisabledTrailingIconColor-0d7_KjU", "getContainerColor-0d7_KjU$annotations", "()V", "getContainerColor-0d7_KjU", "getDisabledContainerColor-0d7_KjU$annotations", "getDisabledContainerColor-0d7_KjU", "getSelectedContainerColor-0d7_KjU$annotations", "getSelectedContainerColor-0d7_KjU", "getSelectedTextColor-0d7_KjU$annotations", "getSelectedTextColor-0d7_KjU", "getSelectedLeadingIconColor-0d7_KjU$annotations", "getSelectedLeadingIconColor-0d7_KjU", "getSelectedTrailingIconColor-0d7_KjU$annotations", "getSelectedTrailingIconColor-0d7_KjU", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-2qZNXz8", "(JJJJJJJJJJJJ)Landroidx/compose/material3/MenuItemColors;", "copy-tNS2XkQ", "(JJJJJJ)Landroidx/compose/material3/MenuItemColors;", "enabled", "", "selected", "textColor-WaAFU9c$material3", "(ZZ)J", "leadingIconColor-WaAFU9c$material3", "trailingIconColor-WaAFU9c$material3", "containerColor-WaAFU9c$material3", "equals", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MenuItemColors {
    public static final int $stable = 0;
    private final long containerColor;
    private final long disabledContainerColor;
    private final long disabledLeadingIconColor;
    private final long disabledTextColor;
    private final long disabledTrailingIconColor;
    private final long leadingIconColor;
    private final long selectedContainerColor;
    private final long selectedLeadingIconColor;
    private final long selectedTextColor;
    private final long selectedTrailingIconColor;
    private final long textColor;
    private final long trailingIconColor;

    public /* synthetic */ MenuItemColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12);
    }

    public /* synthetic */ MenuItemColors(long j, long j2, long j3, long j4, long j5, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6);
    }

    /* JADX INFO: renamed from: getContainerColor-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m3761getContainerColor0d7_KjU$annotations() {
    }

    /* JADX INFO: renamed from: getDisabledContainerColor-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m3762getDisabledContainerColor0d7_KjU$annotations() {
    }

    /* JADX INFO: renamed from: getSelectedContainerColor-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m3763getSelectedContainerColor0d7_KjU$annotations() {
    }

    /* JADX INFO: renamed from: getSelectedLeadingIconColor-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m3764getSelectedLeadingIconColor0d7_KjU$annotations() {
    }

    /* JADX INFO: renamed from: getSelectedTextColor-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m3765getSelectedTextColor0d7_KjU$annotations() {
    }

    /* JADX INFO: renamed from: getSelectedTrailingIconColor-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m3766getSelectedTrailingIconColor0d7_KjU$annotations() {
    }

    private MenuItemColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
        this.textColor = j;
        this.leadingIconColor = j2;
        this.trailingIconColor = j3;
        this.disabledTextColor = j4;
        this.disabledLeadingIconColor = j5;
        this.disabledTrailingIconColor = j6;
        this.containerColor = j7;
        this.disabledContainerColor = j8;
        this.selectedContainerColor = j12;
        this.selectedTextColor = j9;
        this.selectedLeadingIconColor = j10;
        this.selectedTrailingIconColor = j11;
    }

    /* JADX INFO: renamed from: getTextColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getTextColor() {
        return this.textColor;
    }

    /* JADX INFO: renamed from: getLeadingIconColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getLeadingIconColor() {
        return this.leadingIconColor;
    }

    /* JADX INFO: renamed from: getTrailingIconColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getTrailingIconColor() {
        return this.trailingIconColor;
    }

    /* JADX INFO: renamed from: getDisabledTextColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledTextColor() {
        return this.disabledTextColor;
    }

    /* JADX INFO: renamed from: getDisabledLeadingIconColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledLeadingIconColor() {
        return this.disabledLeadingIconColor;
    }

    /* JADX INFO: renamed from: getDisabledTrailingIconColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledTrailingIconColor() {
        return this.disabledTrailingIconColor;
    }

    /* JADX INFO: renamed from: getContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getContainerColor() {
        return this.containerColor;
    }

    /* JADX INFO: renamed from: getDisabledContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledContainerColor() {
        return this.disabledContainerColor;
    }

    /* JADX INFO: renamed from: getSelectedContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectedContainerColor() {
        return this.selectedContainerColor;
    }

    /* JADX INFO: renamed from: getSelectedTextColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectedTextColor() {
        return this.selectedTextColor;
    }

    /* JADX INFO: renamed from: getSelectedLeadingIconColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectedLeadingIconColor() {
        return this.selectedLeadingIconColor;
    }

    /* JADX INFO: renamed from: getSelectedTrailingIconColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectedTrailingIconColor() {
        return this.selectedTrailingIconColor;
    }

    private MenuItemColors(long j, long j2, long j3, long j4, long j5, long j6) {
        this(j, j2, j3, j4, j5, j6, Color.INSTANCE.m6850getUnspecified0d7_KjU(), Color.INSTANCE.m6850getUnspecified0d7_KjU(), Color.INSTANCE.m6850getUnspecified0d7_KjU(), Color.INSTANCE.m6850getUnspecified0d7_KjU(), Color.INSTANCE.m6850getUnspecified0d7_KjU(), Color.INSTANCE.m6850getUnspecified0d7_KjU(), null);
    }

    /* JADX INFO: renamed from: copy-2qZNXz8$default, reason: not valid java name */
    public static /* synthetic */ MenuItemColors m3759copy2qZNXz8$default(MenuItemColors menuItemColors, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, int i, Object obj) {
        long j13;
        long j14;
        long j15 = (i & 1) != 0 ? menuItemColors.textColor : j;
        long j16 = (i & 2) != 0 ? menuItemColors.containerColor : j2;
        long j17 = (i & 4) != 0 ? menuItemColors.leadingIconColor : j3;
        long j18 = (i & 8) != 0 ? menuItemColors.trailingIconColor : j4;
        long j19 = (i & 16) != 0 ? menuItemColors.disabledTextColor : j5;
        long j20 = (i & 32) != 0 ? menuItemColors.disabledContainerColor : j6;
        long j21 = (i & 64) != 0 ? menuItemColors.disabledLeadingIconColor : j7;
        long j22 = j15;
        long j23 = (i & 128) != 0 ? menuItemColors.disabledTrailingIconColor : j8;
        long j24 = (i & 256) != 0 ? menuItemColors.selectedTextColor : j9;
        long j25 = (i & 512) != 0 ? menuItemColors.selectedContainerColor : j10;
        long j26 = (i & 1024) != 0 ? menuItemColors.selectedLeadingIconColor : j11;
        if ((i & 2048) != 0) {
            j14 = j26;
            j13 = menuItemColors.selectedTrailingIconColor;
        } else {
            j13 = j12;
            j14 = j26;
        }
        return menuItemColors.m3771copy2qZNXz8(j22, j16, j17, j18, j19, j20, j21, j23, j24, j25, j14, j13);
    }

    /* JADX INFO: renamed from: copy-2qZNXz8, reason: not valid java name */
    public final MenuItemColors m3771copy2qZNXz8(long textColor, long containerColor, long leadingIconColor, long trailingIconColor, long disabledTextColor, long disabledContainerColor, long disabledLeadingIconColor, long disabledTrailingIconColor, long selectedTextColor, long selectedContainerColor, long selectedLeadingIconColor, long selectedTrailingIconColor) {
        return new MenuItemColors(textColor != 16 ? textColor : this.textColor, leadingIconColor != 16 ? leadingIconColor : this.leadingIconColor, trailingIconColor != 16 ? trailingIconColor : this.trailingIconColor, disabledTextColor != 16 ? disabledTextColor : this.disabledTextColor, disabledLeadingIconColor != 16 ? disabledLeadingIconColor : this.disabledLeadingIconColor, disabledTrailingIconColor != 16 ? disabledTrailingIconColor : this.disabledTrailingIconColor, containerColor != 16 ? containerColor : this.containerColor, disabledContainerColor != 16 ? disabledContainerColor : this.disabledContainerColor, selectedTextColor != 16 ? selectedTextColor : this.selectedTextColor, selectedLeadingIconColor != 16 ? selectedLeadingIconColor : this.selectedLeadingIconColor, selectedTrailingIconColor != 16 ? selectedTrailingIconColor : this.selectedTrailingIconColor, selectedContainerColor != 16 ? selectedContainerColor : this.selectedContainerColor, null);
    }

    /* JADX INFO: renamed from: copy-tNS2XkQ$default, reason: not valid java name */
    public static /* synthetic */ MenuItemColors m3760copytNS2XkQ$default(MenuItemColors menuItemColors, long j, long j2, long j3, long j4, long j5, long j6, int i, Object obj) {
        if ((i & 1) != 0) {
            j = menuItemColors.textColor;
        }
        return menuItemColors.m3772copytNS2XkQ(j, (i & 2) != 0 ? menuItemColors.leadingIconColor : j2, (i & 4) != 0 ? menuItemColors.trailingIconColor : j3, (i & 8) != 0 ? menuItemColors.disabledTextColor : j4, (i & 16) != 0 ? menuItemColors.disabledLeadingIconColor : j5, (i & 32) != 0 ? menuItemColors.disabledTrailingIconColor : j6);
    }

    /* JADX INFO: renamed from: copy-tNS2XkQ, reason: not valid java name */
    public final MenuItemColors m3772copytNS2XkQ(long textColor, long leadingIconColor, long trailingIconColor, long disabledTextColor, long disabledLeadingIconColor, long disabledTrailingIconColor) {
        return new MenuItemColors(textColor != 16 ? textColor : this.textColor, leadingIconColor != 16 ? leadingIconColor : this.leadingIconColor, trailingIconColor != 16 ? trailingIconColor : this.trailingIconColor, disabledTextColor != 16 ? disabledTextColor : this.disabledTextColor, disabledLeadingIconColor != 16 ? disabledLeadingIconColor : this.disabledLeadingIconColor, disabledTrailingIconColor != 16 ? disabledTrailingIconColor : this.disabledTrailingIconColor, null);
    }

    /* JADX INFO: renamed from: textColor-WaAFU9c$material3$default, reason: not valid java name */
    public static /* synthetic */ long m3768textColorWaAFU9c$material3$default(MenuItemColors menuItemColors, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return menuItemColors.m3786textColorWaAFU9c$material3(z, z2);
    }

    /* JADX INFO: renamed from: textColor-WaAFU9c$material3, reason: not valid java name */
    public final long m3786textColorWaAFU9c$material3(boolean enabled, boolean selected) {
        if (!enabled) {
            return this.disabledTextColor;
        }
        if (selected) {
            return this.selectedTextColor;
        }
        return this.textColor;
    }

    /* JADX INFO: renamed from: leadingIconColor-WaAFU9c$material3$default, reason: not valid java name */
    public static /* synthetic */ long m3767leadingIconColorWaAFU9c$material3$default(MenuItemColors menuItemColors, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return menuItemColors.m3785leadingIconColorWaAFU9c$material3(z, z2);
    }

    /* JADX INFO: renamed from: leadingIconColor-WaAFU9c$material3, reason: not valid java name */
    public final long m3785leadingIconColorWaAFU9c$material3(boolean enabled, boolean selected) {
        if (!enabled) {
            return this.disabledLeadingIconColor;
        }
        if (selected) {
            return this.selectedLeadingIconColor;
        }
        return this.leadingIconColor;
    }

    /* JADX INFO: renamed from: trailingIconColor-WaAFU9c$material3$default, reason: not valid java name */
    public static /* synthetic */ long m3769trailingIconColorWaAFU9c$material3$default(MenuItemColors menuItemColors, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return menuItemColors.m3787trailingIconColorWaAFU9c$material3(z, z2);
    }

    /* JADX INFO: renamed from: trailingIconColor-WaAFU9c$material3, reason: not valid java name */
    public final long m3787trailingIconColorWaAFU9c$material3(boolean enabled, boolean selected) {
        if (!enabled) {
            return this.disabledTrailingIconColor;
        }
        if (selected) {
            return this.selectedTrailingIconColor;
        }
        return this.trailingIconColor;
    }

    /* JADX INFO: renamed from: containerColor-WaAFU9c$material3$default, reason: not valid java name */
    public static /* synthetic */ long m3758containerColorWaAFU9c$material3$default(MenuItemColors menuItemColors, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return menuItemColors.m3770containerColorWaAFU9c$material3(z, z2);
    }

    /* JADX INFO: renamed from: containerColor-WaAFU9c$material3, reason: not valid java name */
    public final long m3770containerColorWaAFU9c$material3(boolean enabled, boolean selected) {
        if (!enabled) {
            return this.disabledContainerColor;
        }
        if (selected) {
            return this.selectedContainerColor;
        }
        return this.containerColor;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof MenuItemColors)) {
            return false;
        }
        MenuItemColors menuItemColors = (MenuItemColors) other;
        return Color.m6815equalsimpl0(this.textColor, menuItemColors.textColor) && Color.m6815equalsimpl0(this.containerColor, menuItemColors.containerColor) && Color.m6815equalsimpl0(this.leadingIconColor, menuItemColors.leadingIconColor) && Color.m6815equalsimpl0(this.trailingIconColor, menuItemColors.trailingIconColor) && Color.m6815equalsimpl0(this.disabledTextColor, menuItemColors.disabledTextColor) && Color.m6815equalsimpl0(this.disabledLeadingIconColor, menuItemColors.disabledLeadingIconColor) && Color.m6815equalsimpl0(this.disabledTrailingIconColor, menuItemColors.disabledTrailingIconColor) && Color.m6815equalsimpl0(this.disabledContainerColor, menuItemColors.disabledContainerColor) && Color.m6815equalsimpl0(this.selectedContainerColor, menuItemColors.selectedContainerColor) && Color.m6815equalsimpl0(this.selectedTextColor, menuItemColors.selectedTextColor) && Color.m6815equalsimpl0(this.selectedLeadingIconColor, menuItemColors.selectedLeadingIconColor) && Color.m6815equalsimpl0(this.selectedTrailingIconColor, menuItemColors.selectedTrailingIconColor);
    }

    public int hashCode() {
        return (((((((((((((((((((((Color.m6821hashCodeimpl(this.textColor) * 31) + Color.m6821hashCodeimpl(this.containerColor)) * 31) + Color.m6821hashCodeimpl(this.leadingIconColor)) * 31) + Color.m6821hashCodeimpl(this.trailingIconColor)) * 31) + Color.m6821hashCodeimpl(this.disabledTextColor)) * 31) + Color.m6821hashCodeimpl(this.disabledLeadingIconColor)) * 31) + Color.m6821hashCodeimpl(this.disabledTrailingIconColor)) * 31) + Color.m6821hashCodeimpl(this.disabledContainerColor)) * 31) + Color.m6821hashCodeimpl(this.selectedContainerColor)) * 31) + Color.m6821hashCodeimpl(this.selectedTextColor)) * 31) + Color.m6821hashCodeimpl(this.selectedLeadingIconColor)) * 31) + Color.m6821hashCodeimpl(this.selectedTrailingIconColor);
    }
}
