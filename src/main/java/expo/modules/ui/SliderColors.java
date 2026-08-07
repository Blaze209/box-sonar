package expo.modules.ui;

import android.graphics.Color;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

/* JADX INFO: compiled from: SliderView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lexpo/modules/ui/SliderColors;", "Lexpo/modules/kotlin/records/Record;", "<init>", "()V", "thumbColor", "Landroid/graphics/Color;", "getThumbColor$annotations", "getThumbColor", "()Landroid/graphics/Color;", "activeTrackColor", "getActiveTrackColor$annotations", "getActiveTrackColor", "inactiveTrackColor", "getInactiveTrackColor$annotations", "getInactiveTrackColor", "activeTickColor", "getActiveTickColor$annotations", "getActiveTickColor", "inactiveTickColor", "getInactiveTickColor$annotations", "getInactiveTickColor", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SliderColors implements Record {
    public static final int $stable = 8;
    private final Color activeTickColor;
    private final Color activeTrackColor;
    private final Color inactiveTickColor;
    private final Color inactiveTrackColor;
    private final Color thumbColor;

    @Field
    public static /* synthetic */ void getActiveTickColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getActiveTrackColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getInactiveTickColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getInactiveTrackColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getThumbColor$annotations() {
    }

    public final Color getThumbColor() {
        return this.thumbColor;
    }

    public final Color getActiveTrackColor() {
        return this.activeTrackColor;
    }

    public final Color getInactiveTrackColor() {
        return this.inactiveTrackColor;
    }

    public final Color getActiveTickColor() {
        return this.activeTickColor;
    }

    public final Color getInactiveTickColor() {
        return this.inactiveTickColor;
    }
}
