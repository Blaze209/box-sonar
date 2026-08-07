package expo.modules.ui.menu;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContextMenuRecords.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J(\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lexpo/modules/ui/menu/Submenu;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "elements", "", "Lexpo/modules/ui/menu/ContextMenuElement;", "button", "Lexpo/modules/ui/menu/ContextMenuButtonProps;", "<init>", "([Lexpo/modules/ui/menu/ContextMenuElement;Lexpo/modules/ui/menu/ContextMenuButtonProps;)V", "getElements$annotations", "()V", "getElements", "()[Lexpo/modules/ui/menu/ContextMenuElement;", "[Lexpo/modules/ui/menu/ContextMenuElement;", "getButton$annotations", "getButton", "()Lexpo/modules/ui/menu/ContextMenuButtonProps;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "([Lexpo/modules/ui/menu/ContextMenuElement;Lexpo/modules/ui/menu/ContextMenuButtonProps;)Lexpo/modules/ui/menu/Submenu;", "equals", "", "other", "", "hashCode", "", "toString", "", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Submenu implements Record, Serializable {
    public static final int $stable = 8;
    private final ContextMenuButtonProps button;
    private final ContextMenuElement[] elements;

    public static /* synthetic */ Submenu copy$default(Submenu submenu, ContextMenuElement[] contextMenuElementArr, ContextMenuButtonProps contextMenuButtonProps, int i, Object obj) {
        if ((i & 1) != 0) {
            contextMenuElementArr = submenu.elements;
        }
        if ((i & 2) != 0) {
            contextMenuButtonProps = submenu.button;
        }
        return submenu.copy(contextMenuElementArr, contextMenuButtonProps);
    }

    @Field
    public static /* synthetic */ void getButton$annotations() {
    }

    @Field
    public static /* synthetic */ void getElements$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ContextMenuElement[] getElements() {
        return this.elements;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ContextMenuButtonProps getButton() {
        return this.button;
    }

    public final Submenu copy(ContextMenuElement[] elements, ContextMenuButtonProps button) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Intrinsics.checkNotNullParameter(button, "button");
        return new Submenu(elements, button);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Submenu)) {
            return false;
        }
        Submenu submenu = (Submenu) other;
        return Intrinsics.areEqual(this.elements, submenu.elements) && Intrinsics.areEqual(this.button, submenu.button);
    }

    public int hashCode() {
        return (Arrays.hashCode(this.elements) * 31) + this.button.hashCode();
    }

    public String toString() {
        return "Submenu(elements=" + Arrays.toString(this.elements) + ", button=" + this.button + ")";
    }

    public Submenu(ContextMenuElement[] elements, ContextMenuButtonProps button) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Intrinsics.checkNotNullParameter(button, "button");
        this.elements = elements;
        this.button = button;
    }

    public /* synthetic */ Submenu(ContextMenuElement[] contextMenuElementArr, ContextMenuButtonProps contextMenuButtonProps, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ContextMenuElement[0] : contextMenuElementArr, contextMenuButtonProps);
    }

    public final ContextMenuElement[] getElements() {
        return this.elements;
    }

    public final ContextMenuButtonProps getButton() {
        return this.button;
    }
}
