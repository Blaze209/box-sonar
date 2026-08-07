package expo.modules.ui.menu;

import android.graphics.Color;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.views.ComposeProps;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContextMenuRecords.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012$\b\u0002\u0010\u000b\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rj\u0002`\u000f0\fj\u0002`\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u0010 \u001a\u00020\bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003J%\u0010\"\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rj\u0002`\u000f0\fj\u0002`\u0010HÆ\u0003Jd\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2$\b\u0002\u0010\u000b\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rj\u0002`\u000f0\fj\u0002`\u0010HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR-\u0010\u000b\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rj\u0002`\u000f0\fj\u0002`\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006+"}, d2 = {"Lexpo/modules/ui/menu/ContextMenuProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "text", "", "elements", "", "Lexpo/modules/ui/menu/ContextMenuElement;", "activationMethod", "Lexpo/modules/ui/menu/ActivationMethod;", "color", "Landroid/graphics/Color;", "modifiers", "", "", "", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Ljava/lang/String;[Lexpo/modules/ui/menu/ContextMenuElement;Lexpo/modules/ui/menu/ActivationMethod;Landroid/graphics/Color;Ljava/util/List;)V", "getText", "()Ljava/lang/String;", "getElements", "()[Lexpo/modules/ui/menu/ContextMenuElement;", "[Lexpo/modules/ui/menu/ContextMenuElement;", "getActivationMethod", "()Lexpo/modules/ui/menu/ActivationMethod;", "getColor", "()Landroid/graphics/Color;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;[Lexpo/modules/ui/menu/ContextMenuElement;Lexpo/modules/ui/menu/ActivationMethod;Landroid/graphics/Color;Ljava/util/List;)Lexpo/modules/ui/menu/ContextMenuProps;", "equals", "", "other", "hashCode", "", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ContextMenuProps implements ComposeProps {
    public static final int $stable = 8;
    private final ActivationMethod activationMethod;
    private final Color color;
    private final ContextMenuElement[] elements;
    private final List<Map<String, Object>> modifiers;
    private final String text;

    public ContextMenuProps() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ContextMenuProps copy$default(ContextMenuProps contextMenuProps, String str, ContextMenuElement[] contextMenuElementArr, ActivationMethod activationMethod, Color color, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = contextMenuProps.text;
        }
        if ((i & 2) != 0) {
            contextMenuElementArr = contextMenuProps.elements;
        }
        if ((i & 4) != 0) {
            activationMethod = contextMenuProps.activationMethod;
        }
        if ((i & 8) != 0) {
            color = contextMenuProps.color;
        }
        if ((i & 16) != 0) {
            list = contextMenuProps.modifiers;
        }
        List list2 = list;
        ActivationMethod activationMethod2 = activationMethod;
        return contextMenuProps.copy(str, contextMenuElementArr, activationMethod2, color, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ContextMenuElement[] getElements() {
        return this.elements;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ActivationMethod getActivationMethod() {
        return this.activationMethod;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Color getColor() {
        return this.color;
    }

    public final List<Map<String, Object>> component5() {
        return this.modifiers;
    }

    public final ContextMenuProps copy(String text, ContextMenuElement[] elements, ActivationMethod activationMethod, Color color, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(elements, "elements");
        Intrinsics.checkNotNullParameter(activationMethod, "activationMethod");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new ContextMenuProps(text, elements, activationMethod, color, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContextMenuProps)) {
            return false;
        }
        ContextMenuProps contextMenuProps = (ContextMenuProps) other;
        return Intrinsics.areEqual(this.text, contextMenuProps.text) && Intrinsics.areEqual(this.elements, contextMenuProps.elements) && this.activationMethod == contextMenuProps.activationMethod && Intrinsics.areEqual(this.color, contextMenuProps.color) && Intrinsics.areEqual(this.modifiers, contextMenuProps.modifiers);
    }

    public int hashCode() {
        int iHashCode = ((((this.text.hashCode() * 31) + Arrays.hashCode(this.elements)) * 31) + this.activationMethod.hashCode()) * 31;
        Color color = this.color;
        return ((iHashCode + (color == null ? 0 : color.hashCode())) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "ContextMenuProps(text=" + this.text + ", elements=" + Arrays.toString(this.elements) + ", activationMethod=" + this.activationMethod + ", color=" + this.color + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContextMenuProps(String text, ContextMenuElement[] elements, ActivationMethod activationMethod, Color color, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(elements, "elements");
        Intrinsics.checkNotNullParameter(activationMethod, "activationMethod");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.text = text;
        this.elements = elements;
        this.activationMethod = activationMethod;
        this.color = color;
        this.modifiers = modifiers;
    }

    public /* synthetic */ ContextMenuProps(String str, ContextMenuElement[] contextMenuElementArr, ActivationMethod activationMethod, Color color, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? new ContextMenuElement[0] : contextMenuElementArr, (i & 4) != 0 ? ActivationMethod.SINGLE_PRESS : activationMethod, (i & 8) != 0 ? null : color, (i & 16) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getText() {
        return this.text;
    }

    public final ContextMenuElement[] getElements() {
        return this.elements;
    }

    public final ActivationMethod getActivationMethod() {
        return this.activationMethod;
    }

    public final Color getColor() {
        return this.color;
    }

    public final List<Map<String, Object>> getModifiers() {
        return this.modifiers;
    }
}
