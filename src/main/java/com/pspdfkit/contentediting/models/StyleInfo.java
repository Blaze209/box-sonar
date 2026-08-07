package com.pspdfkit.contentediting.models;

import android.content.Context;
import com.pspdfkit.R;
import com.pspdfkit.contentediting.models.serializer.ColorSerializer;
import com.pspdfkit.internal.u40;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 L2\u00020\u0001:\u0002KLB\u008e\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b\u0012\u001f\b\u0002\u0010\f\u001a\u0019\u0018\u00010\rj\u0004\u0018\u0001`\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\t0\u0010\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b¢\u0006\u0004\b\u0014\u0010\u0015Bk\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0014\u0010\u0019J\u000e\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u000204J\n\u0010?\u001a\u00020\u0003H\u0096\u0080\u0004J\u0014\u0010@\u001a\u00020\u00072\b\u0010A\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010B\u001a\u00020\rH\u0096\u0080\u0004J%\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IH\u0001¢\u0006\u0002\bJR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010 \u001a\u0004\b!\u0010\u001fR\u001b\u0010\t\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R*\u0010\f\u001a\u0019\u0018\u00010\rj\u0004\u0018\u0001`\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\t0\u0010¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u001b\u0010\u0012\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b¢\u0006\n\n\u0002\u0010$\u001a\u0004\b(\u0010#R\u001b\u0010\u0013\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b¢\u0006\n\n\u0002\u0010$\u001a\u0004\b)\u0010#R\u0011\u0010*\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0011\u0010-\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b.\u0010,R\u0011\u0010/\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b/\u0010,R\u0013\u00100\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b1\u0010&R\u001c\u00105\u001a\u0002068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0013\u0010;\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b<\u0010\u001bR\u0011\u0010=\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b>\u0010\u001b¨\u0006M"}, d2 = {"Lcom/pspdfkit/contentediting/models/StyleInfo;", "", "family", "", "faceMismatch", "Lcom/pspdfkit/contentediting/models/FaceMismatch;", "bold", "", "italic", "size", "", "Lcom/pspdfkit/contentediting/models/Numeric;", "color", "", "Lkotlinx/serialization/Serializable;", "with", "Lcom/pspdfkit/contentediting/models/serializer/ColorSerializer;", "Lcom/pspdfkit/contentediting/models/ContentColor;", "xScale", "skew", "<init>", "(Ljava/lang/String;Lcom/pspdfkit/contentediting/models/FaceMismatch;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lcom/pspdfkit/contentediting/models/FaceMismatch;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Float;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFamily", "()Ljava/lang/String;", "getFaceMismatch", "()Lcom/pspdfkit/contentediting/models/FaceMismatch;", "getBold", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getItalic", "getSize", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getXScale", "getSkew", "hasMixedFonts", "getHasMixedFonts", "()Z", "hasUnknownFont", "getHasUnknownFont", "isFontResolved", "colorInt", "getColorInt", "getFontNameForDisplay", "context", "Landroid/content/Context;", "pointFormat", "Ljava/text/DecimalFormat;", "getPointFormat$annotations", "()V", "getPointFormat", "()Ljava/text/DecimalFormat;", "formattedPointSize", "getFormattedPointSize", "pointSizeForDisplay", "getPointSizeForDisplay", "toString", "equals", "other", "hashCode", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$sdk_nutrient", "$serializer", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public final class StyleInfo {
    private final Boolean bold;
    private final Integer color;
    private final FaceMismatch faceMismatch;
    private final String family;
    private final Boolean italic;
    private final DecimalFormat pointFormat;
    private final Float size;
    private final Float skew;
    private final Float xScale;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/pspdfkit/contentediting/models/StyleInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/pspdfkit/contentediting/models/StyleInfo;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<StyleInfo> serializer() {
            return StyleInfo$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public StyleInfo() {
        this((String) null, (FaceMismatch) null, (Boolean) null, (Boolean) null, (Float) null, (Integer) null, (Float) null, (Float) null, 255, (DefaultConstructorMarker) null);
    }

    @Transient
    public static /* synthetic */ void getPointFormat$annotations() {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$sdk_nutrient(StyleInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.family != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.family);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.faceMismatch != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, FaceMismatch$$serializer.INSTANCE, self.faceMismatch);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.bold != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.bold);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.italic != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.italic);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.size != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, FloatSerializer.INSTANCE, self.size);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.color != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, ColorSerializer.INSTANCE, self.color);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.xScale != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, FloatSerializer.INSTANCE, self.xScale);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 7) && self.skew == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 7, FloatSerializer.INSTANCE, self.skew);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StyleInfo)) {
            return false;
        }
        StyleInfo styleInfo = (StyleInfo) other;
        return Intrinsics.areEqual(this.family, styleInfo.family) && Intrinsics.areEqual(this.faceMismatch, styleInfo.faceMismatch) && Intrinsics.areEqual(this.bold, styleInfo.bold) && Intrinsics.areEqual(this.italic, styleInfo.italic) && Intrinsics.areEqual(this.size, styleInfo.size) && Intrinsics.areEqual(this.color, styleInfo.color) && Intrinsics.areEqual(this.xScale, styleInfo.xScale) && Intrinsics.areEqual(this.skew, styleInfo.skew);
    }

    public final Boolean getBold() {
        return this.bold;
    }

    public final Integer getColor() {
        return this.color;
    }

    public final Integer getColorInt() {
        return this.color;
    }

    public final FaceMismatch getFaceMismatch() {
        return this.faceMismatch;
    }

    public final String getFamily() {
        return this.family;
    }

    public final String getFontNameForDisplay(Context context) {
        String str;
        context.getClass();
        if (getHasMixedFonts()) {
            String string = context.getString(R.string.pspdf__contentediting_mixed_fonts);
            string.getClass();
            return string;
        }
        if (!getHasUnknownFont() && (str = this.family) != null) {
            return str;
        }
        String string2 = context.getString(R.string.pspdf__contentediting_unknown_font);
        string2.getClass();
        return string2;
    }

    public final String getFormattedPointSize() {
        Float f = this.size;
        if (f == null) {
            return null;
        }
        return this.pointFormat.format(Float.valueOf(f.floatValue()));
    }

    public final boolean getHasMixedFonts() {
        return this.family == null && this.faceMismatch == null;
    }

    public final boolean getHasUnknownFont() {
        return this.faceMismatch != null;
    }

    public final Boolean getItalic() {
        return this.italic;
    }

    public final DecimalFormat getPointFormat() {
        return this.pointFormat;
    }

    public final String getPointSizeForDisplay() {
        String formattedPointSize = getFormattedPointSize();
        return formattedPointSize == null ? " ? " : formattedPointSize;
    }

    public final Float getSize() {
        return this.size;
    }

    public final Float getSkew() {
        return this.skew;
    }

    public final Float getXScale() {
        return this.xScale;
    }

    public int hashCode() {
        String str = this.family;
        Integer numValueOf = str != null ? Integer.valueOf(str.hashCode()) : null;
        FaceMismatch faceMismatch = this.faceMismatch;
        Integer numValueOf2 = faceMismatch != null ? Integer.valueOf(faceMismatch.hashCode()) : null;
        Boolean bool = this.bold;
        Integer numValueOf3 = bool != null ? Integer.valueOf(Boolean.hashCode(bool.booleanValue())) : null;
        Boolean bool2 = this.italic;
        Integer numValueOf4 = bool2 != null ? Integer.valueOf(Boolean.hashCode(bool2.booleanValue())) : null;
        Float f = this.size;
        Integer numValueOf5 = f != null ? Integer.valueOf(Float.hashCode(f.floatValue())) : null;
        Integer num = this.color;
        Integer numValueOf6 = num != null ? Integer.valueOf(Integer.hashCode(num.intValue())) : null;
        Float f2 = this.xScale;
        Integer numValueOf7 = f2 != null ? Integer.valueOf(Float.hashCode(f2.floatValue())) : null;
        Float f3 = this.skew;
        int iIntValue = 0;
        for (Integer num2 : CollectionsKt.listOf((Object[]) new Integer[]{numValueOf, numValueOf2, numValueOf3, numValueOf4, numValueOf5, numValueOf6, numValueOf7, f3 != null ? Integer.valueOf(Float.hashCode(f3.floatValue())) : null})) {
            iIntValue = (iIntValue * 31) + (num2 != null ? num2.intValue() : 0);
        }
        return iIntValue;
    }

    public final boolean isFontResolved() {
        return (getHasUnknownFont() || getHasMixedFonts()) ? false : true;
    }

    public String toString() {
        String str;
        String str2 = null;
        if (getHasMixedFonts()) {
            str = "### Mixed Fonts ###";
        } else if (getHasUnknownFont()) {
            FaceMismatch faceMismatch = this.faceMismatch;
            str = "### Unknown Font (" + (faceMismatch != null ? faceMismatch.getUnavailableFaceName() : null) + ") ###";
        } else {
            str = this.family;
        }
        String str3 = this.size + " pt";
        Integer num = this.color;
        String strA = num != null ? u40.a(num.intValue(), true, true) : null;
        Boolean bool = this.bold;
        Boolean bool2 = Boolean.TRUE;
        String str4 = Intrinsics.areEqual(bool, bool2) ? "bold" : null;
        String str5 = Intrinsics.areEqual(this.italic, bool2) ? "italic" : null;
        String str6 = "xScale " + this.xScale;
        Float f = this.xScale;
        if (f == null || Intrinsics.areEqual(f, 1.0f)) {
            str6 = null;
        }
        String str7 = "skew " + this.skew;
        Float f2 = this.skew;
        if (f2 != null && !Intrinsics.areEqual(f2, 1.0f)) {
            str2 = str7;
        }
        return CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{str, str3, strA, str4, str5, str6, str2}), ",", "StyleInfo{", "}", 0, null, null, 56, null);
    }

    public /* synthetic */ StyleInfo(int i, String str, FaceMismatch faceMismatch, Boolean bool, Boolean bool2, Float f, Integer num, Float f2, Float f3, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.family = null;
        } else {
            this.family = str;
        }
        if ((i & 2) == 0) {
            this.faceMismatch = null;
        } else {
            this.faceMismatch = faceMismatch;
        }
        if ((i & 4) == 0) {
            this.bold = null;
        } else {
            this.bold = bool;
        }
        if ((i & 8) == 0) {
            this.italic = null;
        } else {
            this.italic = bool2;
        }
        if ((i & 16) == 0) {
            this.size = null;
        } else {
            this.size = f;
        }
        if ((i & 32) == 0) {
            this.color = null;
        } else {
            this.color = num;
        }
        if ((i & 64) == 0) {
            this.xScale = null;
        } else {
            this.xScale = f2;
        }
        if ((i & 128) == 0) {
            this.skew = null;
        } else {
            this.skew = f3;
        }
        this.pointFormat = new DecimalFormat("0.##");
    }

    public StyleInfo(String str, FaceMismatch faceMismatch, Boolean bool, Boolean bool2, Float f, Integer num, Float f2, Float f3) {
        this.family = str;
        this.faceMismatch = faceMismatch;
        this.bold = bool;
        this.italic = bool2;
        this.size = f;
        this.color = num;
        this.xScale = f2;
        this.skew = f3;
        this.pointFormat = new DecimalFormat("0.##");
    }

    public /* synthetic */ StyleInfo(String str, FaceMismatch faceMismatch, Boolean bool, Boolean bool2, Float f, Integer num, Float f2, Float f3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : faceMismatch, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : bool2, (i & 16) != 0 ? null : f, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : f2, (i & 128) != 0 ? null : f3);
    }
}
