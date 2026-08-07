package expo.modules.ui.button;

import android.graphics.Color;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

/* JADX INFO: compiled from: Button.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lexpo/modules/ui/button/ButtonColors;", "Lexpo/modules/kotlin/records/Record;", "<init>", "()V", "containerColor", "Landroid/graphics/Color;", "getContainerColor$annotations", "getContainerColor", "()Landroid/graphics/Color;", "contentColor", "getContentColor$annotations", "getContentColor", "disabledContainerColor", "getDisabledContainerColor$annotations", "getDisabledContainerColor", "disabledContentColor", "getDisabledContentColor$annotations", "getDisabledContentColor", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ButtonColors implements Record {
    public static final int $stable = 8;
    private final Color containerColor;
    private final Color contentColor;
    private final Color disabledContainerColor;
    private final Color disabledContentColor;

    @Field
    public static /* synthetic */ void getContainerColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledContainerColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledContentColor$annotations() {
    }

    public final Color getContainerColor() {
        return this.containerColor;
    }

    public final Color getContentColor() {
        return this.contentColor;
    }

    public final Color getDisabledContainerColor() {
        return this.disabledContainerColor;
    }

    public final Color getDisabledContentColor() {
        return this.disabledContentColor;
    }
}
