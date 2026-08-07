package expo.modules.ui;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.views.ComposeProps;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AlertDialogView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012$\b\u0002\u0010\t\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bj\u0002`\r0\nj\u0002`\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J%\u0010\u001f\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bj\u0002`\r0\nj\u0002`\u000eHÆ\u0003Ji\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2$\b\u0002\u0010\t\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bj\u0002`\r0\nj\u0002`\u000eHÆ\u0001J\u0013\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R-\u0010\t\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bj\u0002`\r0\nj\u0002`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lexpo/modules/ui/AlertDialogProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "title", "", "text", "confirmButtonText", "dismissButtonText", ViewProps.VISIBLE, "", "modifiers", "", "", "", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "getTitle", "()Ljava/lang/String;", "getText", "getConfirmButtonText", "getDismissButtonText", "getVisible", "()Z", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class AlertDialogProps implements ComposeProps {
    public static final int $stable = 8;
    private final String confirmButtonText;
    private final String dismissButtonText;
    private final List<Map<String, Object>> modifiers;
    private final String text;
    private final String title;
    private final boolean visible;

    public AlertDialogProps() {
        this(null, null, null, null, false, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AlertDialogProps copy$default(AlertDialogProps alertDialogProps, String str, String str2, String str3, String str4, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = alertDialogProps.title;
        }
        if ((i & 2) != 0) {
            str2 = alertDialogProps.text;
        }
        if ((i & 4) != 0) {
            str3 = alertDialogProps.confirmButtonText;
        }
        if ((i & 8) != 0) {
            str4 = alertDialogProps.dismissButtonText;
        }
        if ((i & 16) != 0) {
            z = alertDialogProps.visible;
        }
        if ((i & 32) != 0) {
            list = alertDialogProps.modifiers;
        }
        boolean z2 = z;
        List list2 = list;
        return alertDialogProps.copy(str, str2, str3, str4, z2, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getConfirmButtonText() {
        return this.confirmButtonText;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDismissButtonText() {
        return this.dismissButtonText;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getVisible() {
        return this.visible;
    }

    public final List<Map<String, Object>> component6() {
        return this.modifiers;
    }

    public final AlertDialogProps copy(String title, String text, String confirmButtonText, String dismissButtonText, boolean visible, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new AlertDialogProps(title, text, confirmButtonText, dismissButtonText, visible, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlertDialogProps)) {
            return false;
        }
        AlertDialogProps alertDialogProps = (AlertDialogProps) other;
        return Intrinsics.areEqual(this.title, alertDialogProps.title) && Intrinsics.areEqual(this.text, alertDialogProps.text) && Intrinsics.areEqual(this.confirmButtonText, alertDialogProps.confirmButtonText) && Intrinsics.areEqual(this.dismissButtonText, alertDialogProps.dismissButtonText) && this.visible == alertDialogProps.visible && Intrinsics.areEqual(this.modifiers, alertDialogProps.modifiers);
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.text;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.confirmButtonText;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.dismissButtonText;
        return ((((iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + Boolean.hashCode(this.visible)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "AlertDialogProps(title=" + this.title + ", text=" + this.text + ", confirmButtonText=" + this.confirmButtonText + ", dismissButtonText=" + this.dismissButtonText + ", visible=" + this.visible + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AlertDialogProps(String str, String str2, String str3, String str4, boolean z, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.title = str;
        this.text = str2;
        this.confirmButtonText = str3;
        this.dismissButtonText = str4;
        this.visible = z;
        this.modifiers = modifiers;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getText() {
        return this.text;
    }

    public final String getConfirmButtonText() {
        return this.confirmButtonText;
    }

    public final String getDismissButtonText() {
        return this.dismissButtonText;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public /* synthetic */ AlertDialogProps(String str, String str2, String str3, String str4, boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? false : z, (i & 32) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<Map<String, Object>> getModifiers() {
        return this.modifiers;
    }
}
