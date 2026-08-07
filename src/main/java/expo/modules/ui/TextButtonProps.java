package expo.modules.ui;

import android.graphics.Color;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import expo.modules.kotlin.views.ComposeProps;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextButtonView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012$\b\u0002\u0010\b\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nj\u0002`\f0\tj\u0002`\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J%\u0010\u001b\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nj\u0002`\f0\tj\u0002`\rHÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072$\b\u0002\u0010\b\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nj\u0002`\f0\tj\u0002`\rHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R-\u0010\b\u001a\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nj\u0002`\f0\tj\u0002`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lexpo/modules/ui/TextButtonProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "text", "", "color", "Landroid/graphics/Color;", "disabled", "", "modifiers", "", "", "", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Ljava/lang/String;Landroid/graphics/Color;ZLjava/util/List;)V", "getText", "()Ljava/lang/String;", "getColor", "()Landroid/graphics/Color;", "getDisabled", "()Z", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class TextButtonProps implements ComposeProps {
    public static final int $stable = 8;
    private final Color color;
    private final boolean disabled;
    private final List<Map<String, Object>> modifiers;
    private final String text;

    public TextButtonProps() {
        this(null, null, false, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextButtonProps copy$default(TextButtonProps textButtonProps, String str, Color color, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = textButtonProps.text;
        }
        if ((i & 2) != 0) {
            color = textButtonProps.color;
        }
        if ((i & 4) != 0) {
            z = textButtonProps.disabled;
        }
        if ((i & 8) != 0) {
            list = textButtonProps.modifiers;
        }
        return textButtonProps.copy(str, color, z, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Color getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getDisabled() {
        return this.disabled;
    }

    public final List<Map<String, Object>> component4() {
        return this.modifiers;
    }

    public final TextButtonProps copy(String text, Color color, boolean disabled, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new TextButtonProps(text, color, disabled, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextButtonProps)) {
            return false;
        }
        TextButtonProps textButtonProps = (TextButtonProps) other;
        return Intrinsics.areEqual(this.text, textButtonProps.text) && Intrinsics.areEqual(this.color, textButtonProps.color) && this.disabled == textButtonProps.disabled && Intrinsics.areEqual(this.modifiers, textButtonProps.modifiers);
    }

    public int hashCode() {
        int iHashCode = this.text.hashCode() * 31;
        Color color = this.color;
        return ((((iHashCode + (color == null ? 0 : color.hashCode())) * 31) + Boolean.hashCode(this.disabled)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "TextButtonProps(text=" + this.text + ", color=" + this.color + ", disabled=" + this.disabled + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TextButtonProps(String text, Color color, boolean z, List<? extends Map<String, ? extends Object>> modifiers) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.text = text;
        this.color = color;
        this.disabled = z;
        this.modifiers = modifiers;
    }

    public /* synthetic */ TextButtonProps(String str, Color color, boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : color, (i & 4) != 0 ? false : z, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getText() {
        return this.text;
    }

    public final Color getColor() {
        return this.color;
    }

    public final boolean getDisabled() {
        return this.disabled;
    }

    public final List<Map<String, Object>> getModifiers() {
        return this.modifiers;
    }
}
