package expo.modules.ui.menu;

import com.facebook.hermes.intl.Constants;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.ui.button.ButtonColors;
import expo.modules.ui.button.ButtonVariant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContextMenuRecords.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002BI\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012R\u001c\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lexpo/modules/ui/menu/ContextMenuButtonProps;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "text", "", Constants.SENSITIVITY_VARIANT, "Lexpo/modules/ui/button/ButtonVariant;", "elementColors", "Lexpo/modules/ui/button/ButtonColors;", "leadingIcon", "trailingIcon", "disabled", "", "<init>", "(Ljava/lang/String;Lexpo/modules/ui/button/ButtonVariant;Lexpo/modules/ui/button/ButtonColors;Ljava/lang/String;Ljava/lang/String;Z)V", "getText$annotations", "()V", "getText", "()Ljava/lang/String;", "getVariant$annotations", "getVariant", "()Lexpo/modules/ui/button/ButtonVariant;", "getElementColors$annotations", "getElementColors", "()Lexpo/modules/ui/button/ButtonColors;", "getLeadingIcon$annotations", "getLeadingIcon", "getTrailingIcon$annotations", "getTrailingIcon", "getDisabled$annotations", "getDisabled", "()Z", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContextMenuButtonProps implements Record, Serializable {
    public static final int $stable = 8;
    private final boolean disabled;
    private final ButtonColors elementColors;
    private final String leadingIcon;
    private final String text;
    private final String trailingIcon;
    private final ButtonVariant variant;

    public ContextMenuButtonProps() {
        this(null, null, null, null, null, false, 63, null);
    }

    @Field
    public static /* synthetic */ void getDisabled$annotations() {
    }

    @Field
    public static /* synthetic */ void getElementColors$annotations() {
    }

    @Field
    public static /* synthetic */ void getLeadingIcon$annotations() {
    }

    @Field
    public static /* synthetic */ void getText$annotations() {
    }

    @Field
    public static /* synthetic */ void getTrailingIcon$annotations() {
    }

    @Field
    public static /* synthetic */ void getVariant$annotations() {
    }

    public ContextMenuButtonProps(String text, ButtonVariant buttonVariant, ButtonColors elementColors, String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(elementColors, "elementColors");
        this.text = text;
        this.variant = buttonVariant;
        this.elementColors = elementColors;
        this.leadingIcon = str;
        this.trailingIcon = str2;
        this.disabled = z;
    }

    public /* synthetic */ ContextMenuButtonProps(String str, ButtonVariant buttonVariant, ButtonColors buttonColors, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? ButtonVariant.DEFAULT : buttonVariant, (i & 4) != 0 ? new ButtonColors() : buttonColors, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? false : z);
    }

    public final String getText() {
        return this.text;
    }

    public final ButtonVariant getVariant() {
        return this.variant;
    }

    public final ButtonColors getElementColors() {
        return this.elementColors;
    }

    public final String getLeadingIcon() {
        return this.leadingIcon;
    }

    public final String getTrailingIcon() {
        return this.trailingIcon;
    }

    public final boolean getDisabled() {
        return this.disabled;
    }
}
