package expo.modules.ui;

import android.graphics.Color;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

/* JADX INFO: compiled from: PickerView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b%\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010\bR\u001e\u0010!\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010\bR\u001e\u0010$\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0003\u001a\u0004\b&\u0010\bR\u001e\u0010'\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0003\u001a\u0004\b)\u0010\b¨\u0006*"}, d2 = {"Lexpo/modules/ui/PickerColors;", "Lexpo/modules/kotlin/records/Record;", "<init>", "()V", "activeBorderColor", "Landroid/graphics/Color;", "getActiveBorderColor$annotations", "getActiveBorderColor", "()Landroid/graphics/Color;", "activeContentColor", "getActiveContentColor$annotations", "getActiveContentColor", "inactiveBorderColor", "getInactiveBorderColor$annotations", "getInactiveBorderColor", "inactiveContentColor", "getInactiveContentColor$annotations", "getInactiveContentColor", "disabledActiveBorderColor", "getDisabledActiveBorderColor$annotations", "getDisabledActiveBorderColor", "disabledActiveContentColor", "getDisabledActiveContentColor$annotations", "getDisabledActiveContentColor", "disabledInactiveBorderColor", "getDisabledInactiveBorderColor$annotations", "getDisabledInactiveBorderColor", "disabledInactiveContentColor", "getDisabledInactiveContentColor$annotations", "getDisabledInactiveContentColor", "activeContainerColor", "getActiveContainerColor$annotations", "getActiveContainerColor", "inactiveContainerColor", "getInactiveContainerColor$annotations", "getInactiveContainerColor", "disabledActiveContainerColor", "getDisabledActiveContainerColor$annotations", "getDisabledActiveContainerColor", "disabledInactiveContainerColor", "getDisabledInactiveContainerColor$annotations", "getDisabledInactiveContainerColor", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PickerColors implements Record {
    public static final int $stable = 8;
    private final Color activeBorderColor;
    private final Color activeContainerColor;
    private final Color activeContentColor;
    private final Color disabledActiveBorderColor;
    private final Color disabledActiveContainerColor;
    private final Color disabledActiveContentColor;
    private final Color disabledInactiveBorderColor;
    private final Color disabledInactiveContainerColor;
    private final Color disabledInactiveContentColor;
    private final Color inactiveBorderColor;
    private final Color inactiveContainerColor;
    private final Color inactiveContentColor;

    @Field
    public static /* synthetic */ void getActiveBorderColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getActiveContainerColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getActiveContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledActiveBorderColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledActiveContainerColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledActiveContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledInactiveBorderColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledInactiveContainerColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledInactiveContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getInactiveBorderColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getInactiveContainerColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getInactiveContentColor$annotations() {
    }

    public final Color getActiveBorderColor() {
        return this.activeBorderColor;
    }

    public final Color getActiveContentColor() {
        return this.activeContentColor;
    }

    public final Color getInactiveBorderColor() {
        return this.inactiveBorderColor;
    }

    public final Color getInactiveContentColor() {
        return this.inactiveContentColor;
    }

    public final Color getDisabledActiveBorderColor() {
        return this.disabledActiveBorderColor;
    }

    public final Color getDisabledActiveContentColor() {
        return this.disabledActiveContentColor;
    }

    public final Color getDisabledInactiveBorderColor() {
        return this.disabledInactiveBorderColor;
    }

    public final Color getDisabledInactiveContentColor() {
        return this.disabledInactiveContentColor;
    }

    public final Color getActiveContainerColor() {
        return this.activeContainerColor;
    }

    public final Color getInactiveContainerColor() {
        return this.inactiveContainerColor;
    }

    public final Color getDisabledActiveContainerColor() {
        return this.disabledActiveContainerColor;
    }

    public final Color getDisabledInactiveContainerColor() {
        return this.disabledInactiveContainerColor;
    }
}
