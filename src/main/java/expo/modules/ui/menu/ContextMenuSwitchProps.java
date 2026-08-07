package expo.modules.ui.menu;

import com.facebook.hermes.intl.Constants;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.ui.SwitchColors;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContextMenuRecords.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u0012\"\u0004\b\u0015\u0010\u0016R$\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lexpo/modules/ui/menu/ContextMenuSwitchProps;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "value", "", "label", "", Constants.SENSITIVITY_VARIANT, "elementColors", "Lexpo/modules/ui/SwitchColors;", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Lexpo/modules/ui/SwitchColors;)V", "getValue$annotations", "()V", "getValue", "()Z", "getLabel$annotations", "getLabel", "()Ljava/lang/String;", "getVariant$annotations", "getVariant", "setVariant", "(Ljava/lang/String;)V", "getElementColors$annotations", "getElementColors", "()Lexpo/modules/ui/SwitchColors;", "setElementColors", "(Lexpo/modules/ui/SwitchColors;)V", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContextMenuSwitchProps implements Record, Serializable {
    public static final int $stable = 8;
    private SwitchColors elementColors;
    private final String label;
    private final boolean value;
    private String variant;

    public ContextMenuSwitchProps() {
        this(false, null, null, null, 15, null);
    }

    @Field
    public static /* synthetic */ void getElementColors$annotations() {
    }

    @Field
    public static /* synthetic */ void getLabel$annotations() {
    }

    @Field
    public static /* synthetic */ void getValue$annotations() {
    }

    @Field
    public static /* synthetic */ void getVariant$annotations() {
    }

    public ContextMenuSwitchProps(boolean z, String label, String variant, SwitchColors elementColors) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(elementColors, "elementColors");
        this.value = z;
        this.label = label;
        this.variant = variant;
        this.elementColors = elementColors;
    }

    public /* synthetic */ ContextMenuSwitchProps(boolean z, String str, String str2, SwitchColors switchColors, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? new SwitchColors() : switchColors);
    }

    public final boolean getValue() {
        return this.value;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getVariant() {
        return this.variant;
    }

    public final void setVariant(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.variant = str;
    }

    public final SwitchColors getElementColors() {
        return this.elementColors;
    }

    public final void setElementColors(SwitchColors switchColors) {
        Intrinsics.checkNotNullParameter(switchColors, "<set-?>");
        this.elementColors = switchColors;
    }
}
