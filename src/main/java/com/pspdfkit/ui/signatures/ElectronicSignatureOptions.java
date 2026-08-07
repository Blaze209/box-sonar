package com.pspdfkit.ui.signatures;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.content.res.ResourcesCompat;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.R;
import com.pspdfkit.configuration.signatures.SignatureColorOptions;
import com.pspdfkit.configuration.signatures.SignatureCreationMode;
import com.pspdfkit.configuration.signatures.SignatureSavingStrategy;
import com.pspdfkit.ui.fonts.Font;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0001#B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0006\u0010\u0015\u001a\u00020\u0016J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Lcom/pspdfkit/ui/signatures/ElectronicSignatureOptions;", "Landroid/os/Parcelable;", "signatureSavingStrategy", "Lcom/pspdfkit/configuration/signatures/SignatureSavingStrategy;", "signatureColorOptions", "Lcom/pspdfkit/configuration/signatures/SignatureColorOptions;", "signatureCreationModes", "", "Lcom/pspdfkit/configuration/signatures/SignatureCreationMode;", "<init>", "(Lcom/pspdfkit/configuration/signatures/SignatureSavingStrategy;Lcom/pspdfkit/configuration/signatures/SignatureColorOptions;Ljava/util/List;)V", "getSignatureSavingStrategy", "()Lcom/pspdfkit/configuration/signatures/SignatureSavingStrategy;", "getSignatureColorOptions", "()Lcom/pspdfkit/configuration/signatures/SignatureColorOptions;", "getSignatureCreationModes", "()Ljava/util/List;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class ElectronicSignatureOptions implements Parcelable {
    private final SignatureColorOptions signatureColorOptions;
    private final List<SignatureCreationMode> signatureCreationModes;
    private final SignatureSavingStrategy signatureSavingStrategy;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<ElectronicSignatureOptions> CREATOR = new Creator();
    public static final int $stable = 8;
    private static final int CAVEAT_FONT_RES = R.font.pspdf__caveat_bold;
    private static final int PACIFICO_FONT_RES = R.font.pspdf__pacifico_regular;
    private static final int MARCK_SCRIPT_FONT_RES = R.font.pspdf__marck_script_regular;
    private static final int MEDDON_FONT_RES = R.font.pspdf__meddon_regular;
    private static final Set<Font> customFonts = new LinkedHashSet();

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\"\u0010\u0010\u001a\u00020\u00112\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u0014R\u0010\u0010\u0004\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/pspdfkit/ui/signatures/ElectronicSignatureOptions$Companion;", "", "<init>", "()V", "CAVEAT_FONT_RES", "", "PACIFICO_FONT_RES", "MARCK_SCRIPT_FONT_RES", "MEDDON_FONT_RES", "customFonts", "", "Lcom/pspdfkit/ui/fonts/Font;", "getAvailableFonts", "", "context", "Landroid/content/Context;", "setAvailableFonts", "", "fonts", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Set<Font> getAvailableFonts(Context context) {
            context.getClass();
            if (!ElectronicSignatureOptions.customFonts.isEmpty()) {
                return ElectronicSignatureOptions.customFonts;
            }
            Typeface font = ResourcesCompat.getFont(context, ElectronicSignatureOptions.CAVEAT_FONT_RES);
            font.getClass();
            Font font2 = new Font("Caveat", font);
            Typeface font3 = ResourcesCompat.getFont(context, ElectronicSignatureOptions.PACIFICO_FONT_RES);
            font3.getClass();
            Font font4 = new Font("Pacifico", font3);
            Typeface font5 = ResourcesCompat.getFont(context, ElectronicSignatureOptions.MARCK_SCRIPT_FONT_RES);
            font5.getClass();
            Font font6 = new Font("Marck Script", font5);
            Typeface font7 = ResourcesCompat.getFont(context, ElectronicSignatureOptions.MEDDON_FONT_RES);
            font7.getClass();
            return new LinkedHashSet(CollectionsKt.listOf((Object[]) new Font[]{font2, font4, font6, new Font("Meddon", font7)}));
        }

        public final void setAvailableFonts(LinkedHashSet<Font> fonts) {
            ElectronicSignatureOptions.customFonts.clear();
            if (fonts == null || fonts.isEmpty()) {
                return;
            }
            ElectronicSignatureOptions.customFonts.addAll(fonts);
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ElectronicSignatureOptions> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ElectronicSignatureOptions createFromParcel(Parcel parcel) {
            parcel.getClass();
            SignatureSavingStrategy signatureSavingStrategyValueOf = SignatureSavingStrategy.valueOf(parcel.readString());
            SignatureColorOptions signatureColorOptions = (SignatureColorOptions) parcel.readParcelable(ElectronicSignatureOptions.class.getClassLoader());
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(SignatureCreationMode.valueOf(parcel.readString()));
            }
            return new ElectronicSignatureOptions(signatureSavingStrategyValueOf, signatureColorOptions, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ElectronicSignatureOptions[] newArray(int i) {
            return new ElectronicSignatureOptions[i];
        }
    }

    public ElectronicSignatureOptions() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ElectronicSignatureOptions copy$default(ElectronicSignatureOptions electronicSignatureOptions, SignatureSavingStrategy signatureSavingStrategy, SignatureColorOptions signatureColorOptions, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            signatureSavingStrategy = electronicSignatureOptions.signatureSavingStrategy;
        }
        if ((i & 2) != 0) {
            signatureColorOptions = electronicSignatureOptions.signatureColorOptions;
        }
        if ((i & 4) != 0) {
            list = electronicSignatureOptions.signatureCreationModes;
        }
        return electronicSignatureOptions.copy(signatureSavingStrategy, signatureColorOptions, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SignatureSavingStrategy getSignatureSavingStrategy() {
        return this.signatureSavingStrategy;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SignatureColorOptions getSignatureColorOptions() {
        return this.signatureColorOptions;
    }

    public final List<SignatureCreationMode> component3() {
        return this.signatureCreationModes;
    }

    public final ElectronicSignatureOptions copy(SignatureSavingStrategy signatureSavingStrategy, SignatureColorOptions signatureColorOptions, List<? extends SignatureCreationMode> signatureCreationModes) {
        signatureSavingStrategy.getClass();
        signatureColorOptions.getClass();
        signatureCreationModes.getClass();
        return new ElectronicSignatureOptions(signatureSavingStrategy, signatureColorOptions, signatureCreationModes);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ElectronicSignatureOptions)) {
            return false;
        }
        ElectronicSignatureOptions electronicSignatureOptions = (ElectronicSignatureOptions) other;
        return this.signatureSavingStrategy == electronicSignatureOptions.signatureSavingStrategy && Intrinsics.areEqual(this.signatureColorOptions, electronicSignatureOptions.signatureColorOptions) && Intrinsics.areEqual(this.signatureCreationModes, electronicSignatureOptions.signatureCreationModes);
    }

    public final SignatureColorOptions getSignatureColorOptions() {
        return this.signatureColorOptions;
    }

    public final List<SignatureCreationMode> getSignatureCreationModes() {
        return this.signatureCreationModes;
    }

    public final SignatureSavingStrategy getSignatureSavingStrategy() {
        return this.signatureSavingStrategy;
    }

    public int hashCode() {
        return this.signatureCreationModes.hashCode() + ((this.signatureColorOptions.hashCode() + (this.signatureSavingStrategy.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "ElectronicSignatureOptions(signatureSavingStrategy=" + this.signatureSavingStrategy + ", signatureColorOptions=" + this.signatureColorOptions + ", signatureCreationModes=" + this.signatureCreationModes + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        dest.getClass();
        dest.writeString(this.signatureSavingStrategy.name());
        dest.writeParcelable(this.signatureColorOptions, flags);
        List<SignatureCreationMode> list = this.signatureCreationModes;
        dest.writeInt(list.size());
        Iterator<SignatureCreationMode> it = list.iterator();
        while (it.hasNext()) {
            dest.writeString(it.next().name());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ElectronicSignatureOptions(SignatureSavingStrategy signatureSavingStrategy, SignatureColorOptions signatureColorOptions, List<? extends SignatureCreationMode> list) {
        signatureSavingStrategy.getClass();
        signatureColorOptions.getClass();
        list.getClass();
        this.signatureSavingStrategy = signatureSavingStrategy;
        this.signatureColorOptions = signatureColorOptions;
        this.signatureCreationModes = list;
        if (new HashSet(list).size() < list.size()) {
            throw new IllegalArgumentException("`signatureCreationModes` must not have duplicates.");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ElectronicSignatureOptions(SignatureSavingStrategy signatureSavingStrategy, SignatureColorOptions signatureColorOptions, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        signatureSavingStrategy = (i & 1) != 0 ? SignatureSavingStrategy.SAVE_IF_SELECTED : signatureSavingStrategy;
        if ((i & 2) != 0) {
            signatureColorOptions = SignatureColorOptions.fromDefaults();
            signatureColorOptions.getClass();
        }
        this(signatureSavingStrategy, signatureColorOptions, (i & 4) != 0 ? CollectionsKt.listOf((Object[]) new SignatureCreationMode[]{SignatureCreationMode.DRAW, SignatureCreationMode.IMAGE, SignatureCreationMode.TYPE}) : list);
    }
}
