package expo.modules.ui;

import android.graphics.Color;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

/* JADX INFO: compiled from: SwitchView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010\bR\u001e\u0010!\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010\b¨\u0006$"}, d2 = {"Lexpo/modules/ui/SwitchColors;", "Lexpo/modules/kotlin/records/Record;", "<init>", "()V", "checkedThumbColor", "Landroid/graphics/Color;", "getCheckedThumbColor$annotations", "getCheckedThumbColor", "()Landroid/graphics/Color;", "checkedTrackColor", "getCheckedTrackColor$annotations", "getCheckedTrackColor", "uncheckedThumbColor", "getUncheckedThumbColor$annotations", "getUncheckedThumbColor", "uncheckedTrackColor", "getUncheckedTrackColor$annotations", "getUncheckedTrackColor", "checkedColor", "getCheckedColor$annotations", "getCheckedColor", "disabledCheckedColor", "getDisabledCheckedColor$annotations", "getDisabledCheckedColor", "uncheckedColor", "getUncheckedColor$annotations", "getUncheckedColor", "disabledUncheckedColor", "getDisabledUncheckedColor$annotations", "getDisabledUncheckedColor", "checkmarkColor", "getCheckmarkColor$annotations", "getCheckmarkColor", "disabledIndeterminateColor", "getDisabledIndeterminateColor$annotations", "getDisabledIndeterminateColor", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SwitchColors implements Record {
    public static final int $stable = 8;
    private final Color checkedColor;
    private final Color checkedThumbColor;
    private final Color checkedTrackColor;
    private final Color checkmarkColor;
    private final Color disabledCheckedColor;
    private final Color disabledIndeterminateColor;
    private final Color disabledUncheckedColor;
    private final Color uncheckedColor;
    private final Color uncheckedThumbColor;
    private final Color uncheckedTrackColor;

    @Field
    public static /* synthetic */ void getCheckedColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getCheckedThumbColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getCheckedTrackColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getCheckmarkColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledCheckedColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledIndeterminateColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledUncheckedColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getUncheckedColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getUncheckedThumbColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getUncheckedTrackColor$annotations() {
    }

    public final Color getCheckedThumbColor() {
        return this.checkedThumbColor;
    }

    public final Color getCheckedTrackColor() {
        return this.checkedTrackColor;
    }

    public final Color getUncheckedThumbColor() {
        return this.uncheckedThumbColor;
    }

    public final Color getUncheckedTrackColor() {
        return this.uncheckedTrackColor;
    }

    public final Color getCheckedColor() {
        return this.checkedColor;
    }

    public final Color getDisabledCheckedColor() {
        return this.disabledCheckedColor;
    }

    public final Color getUncheckedColor() {
        return this.uncheckedColor;
    }

    public final Color getDisabledUncheckedColor() {
        return this.disabledUncheckedColor;
    }

    public final Color getCheckmarkColor() {
        return this.checkmarkColor;
    }

    public final Color getDisabledIndeterminateColor() {
        return this.disabledIndeterminateColor;
    }
}
