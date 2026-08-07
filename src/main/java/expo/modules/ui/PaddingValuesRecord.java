package expo.modules.ui;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Dp;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

/* JADX INFO: compiled from: CarouselView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0013\u001a\u00020\u0014R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\bR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\bR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\b¨\u0006\u0015"}, d2 = {"Lexpo/modules/ui/PaddingValuesRecord;", "Lexpo/modules/kotlin/records/Record;", "<init>", "()V", "start", "", "getStart$annotations", "getStart", "()Ljava/lang/Float;", "Ljava/lang/Float;", ViewProps.TOP, "getTop$annotations", "getTop", "end", "getEnd$annotations", "getEnd", ViewProps.BOTTOM, "getBottom$annotations", "getBottom", "toPaddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PaddingValuesRecord implements Record {
    public static final int $stable = 0;
    private final Float bottom;
    private final Float end;
    private final Float start;
    private final Float top;

    @Field
    public static /* synthetic */ void getBottom$annotations() {
    }

    @Field
    public static /* synthetic */ void getEnd$annotations() {
    }

    @Field
    public static /* synthetic */ void getStart$annotations() {
    }

    @Field
    public static /* synthetic */ void getTop$annotations() {
    }

    public final Float getStart() {
        return this.start;
    }

    public final Float getTop() {
        return this.top;
    }

    public final Float getEnd() {
        return this.end;
    }

    public final Float getBottom() {
        return this.bottom;
    }

    public final PaddingValues toPaddingValues() {
        float fM9687constructorimpl;
        float fM9687constructorimpl2;
        float fM9687constructorimpl3;
        float fM9687constructorimpl4;
        Float f = this.start;
        if (f != null) {
            fM9687constructorimpl = Dp.m9687constructorimpl(f.floatValue());
        } else {
            fM9687constructorimpl = Dp.m9687constructorimpl(0);
        }
        Float f2 = this.top;
        if (f2 != null) {
            fM9687constructorimpl2 = Dp.m9687constructorimpl(f2.floatValue());
        } else {
            fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
        }
        Float f3 = this.end;
        if (f3 != null) {
            fM9687constructorimpl3 = Dp.m9687constructorimpl(f3.floatValue());
        } else {
            fM9687constructorimpl3 = Dp.m9687constructorimpl(0);
        }
        Float f4 = this.bottom;
        if (f4 != null) {
            fM9687constructorimpl4 = Dp.m9687constructorimpl(f4.floatValue());
        } else {
            fM9687constructorimpl4 = Dp.m9687constructorimpl(0);
        }
        return PaddingKt.m1214PaddingValuesa9UjIt4(fM9687constructorimpl, fM9687constructorimpl2, fM9687constructorimpl3, fM9687constructorimpl4);
    }
}
