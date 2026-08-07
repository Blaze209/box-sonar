package expo.modules.ui.menu;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContextMenuRecords.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J7\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\nHÖ\u0001R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R&\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006."}, d2 = {"Lexpo/modules/ui/menu/ContextMenuElement;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "button", "Lexpo/modules/ui/menu/ContextMenuButtonProps;", "switch", "Lexpo/modules/ui/menu/ContextMenuSwitchProps;", "submenu", "Lexpo/modules/ui/menu/Submenu;", "contextMenuElementID", "", "<init>", "(Lexpo/modules/ui/menu/ContextMenuButtonProps;Lexpo/modules/ui/menu/ContextMenuSwitchProps;Lexpo/modules/ui/menu/Submenu;Ljava/lang/String;)V", "getButton$annotations", "()V", "getButton", "()Lexpo/modules/ui/menu/ContextMenuButtonProps;", "setButton", "(Lexpo/modules/ui/menu/ContextMenuButtonProps;)V", "getSwitch$annotations", "getSwitch", "()Lexpo/modules/ui/menu/ContextMenuSwitchProps;", "setSwitch", "(Lexpo/modules/ui/menu/ContextMenuSwitchProps;)V", "getSubmenu$annotations", "getSubmenu", "()Lexpo/modules/ui/menu/Submenu;", "setSubmenu", "(Lexpo/modules/ui/menu/Submenu;)V", "getContextMenuElementID$annotations", "getContextMenuElementID", "()Ljava/lang/String;", "setContextMenuElementID", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ContextMenuElement implements Record, Serializable {
    public static final int $stable = 8;
    private ContextMenuButtonProps button;
    private String contextMenuElementID;
    private Submenu submenu;
    private ContextMenuSwitchProps switch;

    public static /* synthetic */ ContextMenuElement copy$default(ContextMenuElement contextMenuElement, ContextMenuButtonProps contextMenuButtonProps, ContextMenuSwitchProps contextMenuSwitchProps, Submenu submenu, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            contextMenuButtonProps = contextMenuElement.button;
        }
        if ((i & 2) != 0) {
            contextMenuSwitchProps = contextMenuElement.switch;
        }
        if ((i & 4) != 0) {
            submenu = contextMenuElement.submenu;
        }
        if ((i & 8) != 0) {
            str = contextMenuElement.contextMenuElementID;
        }
        return contextMenuElement.copy(contextMenuButtonProps, contextMenuSwitchProps, submenu, str);
    }

    @Field
    public static /* synthetic */ void getButton$annotations() {
    }

    @Field
    public static /* synthetic */ void getContextMenuElementID$annotations() {
    }

    @Field
    public static /* synthetic */ void getSubmenu$annotations() {
    }

    @Field
    public static /* synthetic */ void getSwitch$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ContextMenuButtonProps getButton() {
        return this.button;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ContextMenuSwitchProps getSwitch() {
        return this.switch;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Submenu getSubmenu() {
        return this.submenu;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getContextMenuElementID() {
        return this.contextMenuElementID;
    }

    public final ContextMenuElement copy(ContextMenuButtonProps button, ContextMenuSwitchProps contextMenuSwitchProps, Submenu submenu, String contextMenuElementID) {
        Intrinsics.checkNotNullParameter(contextMenuElementID, "contextMenuElementID");
        return new ContextMenuElement(button, contextMenuSwitchProps, submenu, contextMenuElementID);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContextMenuElement)) {
            return false;
        }
        ContextMenuElement contextMenuElement = (ContextMenuElement) other;
        return Intrinsics.areEqual(this.button, contextMenuElement.button) && Intrinsics.areEqual(this.switch, contextMenuElement.switch) && Intrinsics.areEqual(this.submenu, contextMenuElement.submenu) && Intrinsics.areEqual(this.contextMenuElementID, contextMenuElement.contextMenuElementID);
    }

    public int hashCode() {
        ContextMenuButtonProps contextMenuButtonProps = this.button;
        int iHashCode = (contextMenuButtonProps == null ? 0 : contextMenuButtonProps.hashCode()) * 31;
        ContextMenuSwitchProps contextMenuSwitchProps = this.switch;
        int iHashCode2 = (iHashCode + (contextMenuSwitchProps == null ? 0 : contextMenuSwitchProps.hashCode())) * 31;
        Submenu submenu = this.submenu;
        return ((iHashCode2 + (submenu != null ? submenu.hashCode() : 0)) * 31) + this.contextMenuElementID.hashCode();
    }

    public String toString() {
        return "ContextMenuElement(button=" + this.button + ", switch=" + this.switch + ", submenu=" + this.submenu + ", contextMenuElementID=" + this.contextMenuElementID + ")";
    }

    public ContextMenuElement(ContextMenuButtonProps contextMenuButtonProps, ContextMenuSwitchProps contextMenuSwitchProps, Submenu submenu, String contextMenuElementID) {
        Intrinsics.checkNotNullParameter(contextMenuElementID, "contextMenuElementID");
        this.button = contextMenuButtonProps;
        this.switch = contextMenuSwitchProps;
        this.submenu = submenu;
        this.contextMenuElementID = contextMenuElementID;
    }

    public /* synthetic */ ContextMenuElement(ContextMenuButtonProps contextMenuButtonProps, ContextMenuSwitchProps contextMenuSwitchProps, Submenu submenu, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : contextMenuButtonProps, (i & 2) != 0 ? null : contextMenuSwitchProps, (i & 4) != 0 ? null : submenu, str);
    }

    public final ContextMenuButtonProps getButton() {
        return this.button;
    }

    public final void setButton(ContextMenuButtonProps contextMenuButtonProps) {
        this.button = contextMenuButtonProps;
    }

    public final ContextMenuSwitchProps getSwitch() {
        return this.switch;
    }

    public final void setSwitch(ContextMenuSwitchProps contextMenuSwitchProps) {
        this.switch = contextMenuSwitchProps;
    }

    public final Submenu getSubmenu() {
        return this.submenu;
    }

    public final void setSubmenu(Submenu submenu) {
        this.submenu = submenu;
    }

    public final String getContextMenuElementID() {
        return this.contextMenuElementID;
    }

    public final void setContextMenuElementID(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.contextMenuElementID = str;
    }
}
