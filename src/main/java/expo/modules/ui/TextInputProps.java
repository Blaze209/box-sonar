package expo.modules.ui;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import expo.modules.kotlin.views.ComposeProps;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextInputView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0087\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012*\b\u0002\u0010\r\u001a$\u0012 \u0012\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fj\u0002`\u00110\u000ej\u0002`\u00120\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u0003HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J+\u0010%\u001a$\u0012 \u0012\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fj\u0002`\u00110\u000ej\u0002`\u00120\u0003HÆ\u0003J§\u0001\u0010&\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032*\b\u0002\u0010\r\u001a$\u0012 \u0012\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fj\u0002`\u00110\u000ej\u0002`\u00120\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020\u00072\b\u0010(\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010)\u001a\u00020\tHÖ\u0001J\t\u0010*\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R3\u0010\r\u001a$\u0012 \u0012\u001e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fj\u0002`\u00110\u000ej\u0002`\u00120\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016¨\u0006+"}, d2 = {"Lexpo/modules/ui/TextInputProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "defaultValue", "Landroidx/compose/runtime/MutableState;", "", ReactTextInputShadowNode.PROP_PLACEHOLDER, "multiline", "", ViewProps.NUMBER_OF_LINES, "", "keyboardType", "autocorrection", "autoCapitalize", "modifiers", "", "", "", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;)V", "getDefaultValue", "()Landroidx/compose/runtime/MutableState;", "getPlaceholder", "getMultiline", "getNumberOfLines", "getKeyboardType", "getAutocorrection", "getAutoCapitalize", "getModifiers", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "toString", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class TextInputProps implements ComposeProps {
    public static final int $stable = 0;
    private final MutableState<String> autoCapitalize;
    private final MutableState<Boolean> autocorrection;
    private final MutableState<String> defaultValue;
    private final MutableState<String> keyboardType;
    private final MutableState<List<Map<String, Object>>> modifiers;
    private final MutableState<Boolean> multiline;
    private final MutableState<Integer> numberOfLines;
    private final MutableState<String> placeholder;

    public TextInputProps() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextInputProps copy$default(TextInputProps textInputProps, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, MutableState mutableState7, MutableState mutableState8, int i, Object obj) {
        if ((i & 1) != 0) {
            mutableState = textInputProps.defaultValue;
        }
        if ((i & 2) != 0) {
            mutableState2 = textInputProps.placeholder;
        }
        if ((i & 4) != 0) {
            mutableState3 = textInputProps.multiline;
        }
        if ((i & 8) != 0) {
            mutableState4 = textInputProps.numberOfLines;
        }
        if ((i & 16) != 0) {
            mutableState5 = textInputProps.keyboardType;
        }
        if ((i & 32) != 0) {
            mutableState6 = textInputProps.autocorrection;
        }
        if ((i & 64) != 0) {
            mutableState7 = textInputProps.autoCapitalize;
        }
        if ((i & 128) != 0) {
            mutableState8 = textInputProps.modifiers;
        }
        MutableState mutableState9 = mutableState7;
        MutableState mutableState10 = mutableState8;
        MutableState mutableState11 = mutableState5;
        MutableState mutableState12 = mutableState6;
        return textInputProps.copy(mutableState, mutableState2, mutableState3, mutableState4, mutableState11, mutableState12, mutableState9, mutableState10);
    }

    public final MutableState<String> component1() {
        return this.defaultValue;
    }

    public final MutableState<String> component2() {
        return this.placeholder;
    }

    public final MutableState<Boolean> component3() {
        return this.multiline;
    }

    public final MutableState<Integer> component4() {
        return this.numberOfLines;
    }

    public final MutableState<String> component5() {
        return this.keyboardType;
    }

    public final MutableState<Boolean> component6() {
        return this.autocorrection;
    }

    public final MutableState<String> component7() {
        return this.autoCapitalize;
    }

    public final MutableState<List<Map<String, Object>>> component8() {
        return this.modifiers;
    }

    public final TextInputProps copy(MutableState<String> defaultValue, MutableState<String> placeholder, MutableState<Boolean> multiline, MutableState<Integer> numberOfLines, MutableState<String> keyboardType, MutableState<Boolean> autocorrection, MutableState<String> autoCapitalize, MutableState<List<Map<String, Object>>> modifiers) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        Intrinsics.checkNotNullParameter(multiline, "multiline");
        Intrinsics.checkNotNullParameter(numberOfLines, "numberOfLines");
        Intrinsics.checkNotNullParameter(keyboardType, "keyboardType");
        Intrinsics.checkNotNullParameter(autocorrection, "autocorrection");
        Intrinsics.checkNotNullParameter(autoCapitalize, "autoCapitalize");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new TextInputProps(defaultValue, placeholder, multiline, numberOfLines, keyboardType, autocorrection, autoCapitalize, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextInputProps)) {
            return false;
        }
        TextInputProps textInputProps = (TextInputProps) other;
        return Intrinsics.areEqual(this.defaultValue, textInputProps.defaultValue) && Intrinsics.areEqual(this.placeholder, textInputProps.placeholder) && Intrinsics.areEqual(this.multiline, textInputProps.multiline) && Intrinsics.areEqual(this.numberOfLines, textInputProps.numberOfLines) && Intrinsics.areEqual(this.keyboardType, textInputProps.keyboardType) && Intrinsics.areEqual(this.autocorrection, textInputProps.autocorrection) && Intrinsics.areEqual(this.autoCapitalize, textInputProps.autoCapitalize) && Intrinsics.areEqual(this.modifiers, textInputProps.modifiers);
    }

    public int hashCode() {
        return (((((((((((((this.defaultValue.hashCode() * 31) + this.placeholder.hashCode()) * 31) + this.multiline.hashCode()) * 31) + this.numberOfLines.hashCode()) * 31) + this.keyboardType.hashCode()) * 31) + this.autocorrection.hashCode()) * 31) + this.autoCapitalize.hashCode()) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "TextInputProps(defaultValue=" + this.defaultValue + ", placeholder=" + this.placeholder + ", multiline=" + this.multiline + ", numberOfLines=" + this.numberOfLines + ", keyboardType=" + this.keyboardType + ", autocorrection=" + this.autocorrection + ", autoCapitalize=" + this.autoCapitalize + ", modifiers=" + this.modifiers + ")";
    }

    public TextInputProps(MutableState<String> defaultValue, MutableState<String> placeholder, MutableState<Boolean> multiline, MutableState<Integer> numberOfLines, MutableState<String> keyboardType, MutableState<Boolean> autocorrection, MutableState<String> autoCapitalize, MutableState<List<Map<String, Object>>> modifiers) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        Intrinsics.checkNotNullParameter(multiline, "multiline");
        Intrinsics.checkNotNullParameter(numberOfLines, "numberOfLines");
        Intrinsics.checkNotNullParameter(keyboardType, "keyboardType");
        Intrinsics.checkNotNullParameter(autocorrection, "autocorrection");
        Intrinsics.checkNotNullParameter(autoCapitalize, "autoCapitalize");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.defaultValue = defaultValue;
        this.placeholder = placeholder;
        this.multiline = multiline;
        this.numberOfLines = numberOfLines;
        this.keyboardType = keyboardType;
        this.autocorrection = autocorrection;
        this.autoCapitalize = autoCapitalize;
        this.modifiers = modifiers;
    }

    public /* synthetic */ TextInputProps(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, MutableState mutableState7, MutableState mutableState8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null) : mutableState, (i & 2) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null) : mutableState2, (i & 4) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null) : mutableState3, (i & 8) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState4, (i & 16) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("default", null, 2, null) : mutableState5, (i & 32) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null) : mutableState6, (i & 64) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("none", null, 2, null) : mutableState7, (i & 128) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null) : mutableState8);
    }

    public final MutableState<String> getDefaultValue() {
        return this.defaultValue;
    }

    public final MutableState<String> getPlaceholder() {
        return this.placeholder;
    }

    public final MutableState<Boolean> getMultiline() {
        return this.multiline;
    }

    public final MutableState<Integer> getNumberOfLines() {
        return this.numberOfLines;
    }

    public final MutableState<String> getKeyboardType() {
        return this.keyboardType;
    }

    public final MutableState<Boolean> getAutocorrection() {
        return this.autocorrection;
    }

    public final MutableState<String> getAutoCapitalize() {
        return this.autoCapitalize;
    }

    public final MutableState<List<Map<String, Object>>> getModifiers() {
        return this.modifiers;
    }
}
