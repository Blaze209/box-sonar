package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: SavedStateEncoder.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J)\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0002¢\u0006\u0002\u0010\u001fJ\u0018\u0010 \u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u0016H\u0016J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u001aH\u0016J\u0010\u0010'\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u00102\u001a\u00020\u001eH\u0016J)\u00103\u001a\u00020\u001e\"\u0004\b\u0000\u001042\f\u00105\u001a\b\u0012\u0004\u0012\u0002H4062\u0006\u0010\f\u001a\u0002H4H\u0016¢\u0006\u0002\u00107R\u001a\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u00068"}, d2 = {"Landroidx/savedstate/serialization/SavedStateEncoder;", "Lkotlinx/serialization/encoding/AbstractEncoder;", "savedState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "configuration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "<init>", "(Landroid/os/Bundle;Landroidx/savedstate/serialization/SavedStateConfiguration;)V", "getSavedState$savedstate", "()Landroid/os/Bundle;", "Landroid/os/Bundle;", "value", "", "key", "getKey$savedstate", "()Ljava/lang/String;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "shouldEncodeElementDefault", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", FirebaseAnalytics.Param.INDEX, "", "beginStructure", "Lkotlinx/serialization/encoding/CompositeEncoder;", "putClassDiscriminatorIfRequired", "", "(Landroidx/savedstate/serialization/SavedStateConfiguration;Lkotlinx/serialization/descriptors/SerialDescriptor;Landroid/os/Bundle;)V", "encodeElement", "encodeBoolean", "encodeByte", "", "encodeShort", "", "encodeInt", "encodeLong", "", "encodeFloat", "", "encodeDouble", "", "encodeChar", "", "encodeString", "encodeEnum", "enumDescriptor", "encodeNull", "encodeSerializableValue", ExifInterface.GPS_DIRECTION_TRUE, "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "savedstate"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SavedStateEncoder extends AbstractEncoder {
    private final SavedStateConfiguration configuration;
    private String key;
    private final Bundle savedState;

    /* JADX INFO: renamed from: getSavedState$savedstate, reason: from getter */
    public final Bundle getSavedState() {
        return this.savedState;
    }

    public SavedStateEncoder(Bundle savedState, SavedStateConfiguration configuration) {
        Intrinsics.checkNotNullParameter(savedState, "savedState");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.savedState = savedState;
        this.configuration = configuration;
        this.key = "";
    }

    /* JADX INFO: renamed from: getKey$savedstate, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    @Override // kotlinx.serialization.encoding.Encoder, kotlinx.serialization.encoding.CompositeEncoder
    public SerializersModule getSerializersModule() {
        return this.configuration.getSerializersModule();
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public boolean shouldEncodeElementDefault(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this.configuration.getEncodeDefaults();
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public CompositeEncoder beginStructure(SerialDescriptor descriptor) {
        Pair[] pairArr;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (Intrinsics.areEqual(this.key, "")) {
            putClassDiscriminatorIfRequired(this.configuration, descriptor, this.savedState);
            return this;
        }
        Map mapEmptyMap = MapsKt.emptyMap();
        if (mapEmptyMap.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList = new ArrayList(mapEmptyMap.size());
            for (Map.Entry entry : mapEmptyMap.entrySet()) {
                arrayList.add(TuplesKt.to((String) entry.getKey(), entry.getValue()));
            }
            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        }
        Bundle bundleBundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        SavedStateWriter.m11040constructorimpl(bundleBundleOf);
        SavedStateWriter.m11067putSavedStateimpl(SavedStateWriter.m11040constructorimpl(this.savedState), this.key, bundleBundleOf);
        putClassDiscriminatorIfRequired(this.configuration, descriptor, bundleBundleOf);
        return new SavedStateEncoder(bundleBundleOf, this.configuration);
    }

    private final void putClassDiscriminatorIfRequired(SavedStateConfiguration configuration, SerialDescriptor descriptor, Bundle savedState) {
        if (configuration.getClassDiscriminatorMode() == 1 && !SavedStateReader.m10955containsimpl(SavedStateReader.m10954constructorimpl(savedState), "type")) {
            if (Intrinsics.areEqual(descriptor.getKind(), StructureKind.CLASS.INSTANCE) || Intrinsics.areEqual(descriptor.getKind(), StructureKind.OBJECT.INSTANCE)) {
                SavedStateWriter.m11073putStringimpl(SavedStateWriter.m11040constructorimpl(savedState), "type", descriptor.getSerialName());
            }
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public boolean encodeElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.key = descriptor.getElementName(index);
        if (this.configuration.getClassDiscriminatorMode() == 1) {
            boolean zM10955containsimpl = SavedStateReader.m10955containsimpl(SavedStateReader.m10954constructorimpl(this.savedState), "type");
            boolean zAreEqual = Intrinsics.areEqual(this.key, "type");
            if (zM10955containsimpl && zAreEqual) {
                throw new IllegalArgumentException("SavedStateEncoder for " + SavedStateReader.m11025getStringimpl(SavedStateReader.m10954constructorimpl(this.savedState), "type") + " has property '" + this.key + "' that conflicts with the class discriminator. You can rename a property with @SerialName annotation.");
            }
        }
        return true;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeBoolean(boolean value) {
        SavedStateWriter.m11046putBooleanimpl(SavedStateWriter.m11040constructorimpl(this.savedState), this.key, value);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeByte(byte value) {
        SavedStateWriter.m11057putIntimpl(SavedStateWriter.m11040constructorimpl(this.savedState), this.key, value);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeShort(short value) {
        SavedStateWriter.m11057putIntimpl(SavedStateWriter.m11040constructorimpl(this.savedState), this.key, value);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeInt(int value) {
        SavedStateWriter.m11057putIntimpl(SavedStateWriter.m11040constructorimpl(this.savedState), this.key, value);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeLong(long value) {
        SavedStateWriter.m11061putLongimpl(SavedStateWriter.m11040constructorimpl(this.savedState), this.key, value);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeFloat(float value) {
        SavedStateWriter.m11055putFloatimpl(SavedStateWriter.m11040constructorimpl(this.savedState), this.key, value);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeDouble(double value) {
        SavedStateWriter.m11053putDoubleimpl(SavedStateWriter.m11040constructorimpl(this.savedState), this.key, value);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeChar(char value) {
        SavedStateWriter.m11048putCharimpl(SavedStateWriter.m11040constructorimpl(this.savedState), this.key, value);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        SavedStateWriter.m11073putStringimpl(SavedStateWriter.m11040constructorimpl(this.savedState), this.key, value);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeEnum(SerialDescriptor enumDescriptor, int index) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        SavedStateWriter.m11057putIntimpl(SavedStateWriter.m11040constructorimpl(this.savedState), this.key, index);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void encodeNull() {
        SavedStateWriter.m11063putNullimpl(SavedStateWriter.m11040constructorimpl(this.savedState), this.key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public <T> void encodeSerializableValue(SerializationStrategy<? super T> serializer, T value) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (SavedStateEncoder_androidKt.encodeFormatSpecificTypesOnPlatform(this, serializer, value)) {
            return;
        }
        SerialDescriptor descriptor = serializer.getDescriptor();
        if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getIntListDescriptor())) {
            if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getStringListDescriptor())) {
                if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getBooleanArrayDescriptor())) {
                    if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getCharArrayDescriptor())) {
                        if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getDoubleArrayDescriptor())) {
                            if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getFloatArrayDescriptor())) {
                                if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getIntArrayDescriptor())) {
                                    if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getLongArrayDescriptor())) {
                                        if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getStringArrayDescriptor())) {
                                            super.encodeSerializableValue(serializer, value);
                                            return;
                                        }
                                        Bundle bundleM11040constructorimpl = SavedStateWriter.m11040constructorimpl(this.savedState);
                                        String str = this.key;
                                        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                                        SavedStateWriter.m11074putStringArrayimpl(bundleM11040constructorimpl, str, (String[]) value);
                                        return;
                                    }
                                    Bundle bundleM11040constructorimpl2 = SavedStateWriter.m11040constructorimpl(this.savedState);
                                    String str2 = this.key;
                                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.LongArray");
                                    SavedStateWriter.m11062putLongArrayimpl(bundleM11040constructorimpl2, str2, (long[]) value);
                                    return;
                                }
                                Bundle bundleM11040constructorimpl3 = SavedStateWriter.m11040constructorimpl(this.savedState);
                                String str3 = this.key;
                                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.IntArray");
                                SavedStateWriter.m11058putIntArrayimpl(bundleM11040constructorimpl3, str3, (int[]) value);
                                return;
                            }
                            Bundle bundleM11040constructorimpl4 = SavedStateWriter.m11040constructorimpl(this.savedState);
                            String str4 = this.key;
                            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.FloatArray");
                            SavedStateWriter.m11056putFloatArrayimpl(bundleM11040constructorimpl4, str4, (float[]) value);
                            return;
                        }
                        Bundle bundleM11040constructorimpl5 = SavedStateWriter.m11040constructorimpl(this.savedState);
                        String str5 = this.key;
                        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.DoubleArray");
                        SavedStateWriter.m11054putDoubleArrayimpl(bundleM11040constructorimpl5, str5, (double[]) value);
                        return;
                    }
                    Bundle bundleM11040constructorimpl6 = SavedStateWriter.m11040constructorimpl(this.savedState);
                    String str6 = this.key;
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.CharArray");
                    SavedStateWriter.m11049putCharArrayimpl(bundleM11040constructorimpl6, str6, (char[]) value);
                    return;
                }
                Bundle bundleM11040constructorimpl7 = SavedStateWriter.m11040constructorimpl(this.savedState);
                String str7 = this.key;
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.BooleanArray");
                SavedStateWriter.m11047putBooleanArrayimpl(bundleM11040constructorimpl7, str7, (boolean[]) value);
                return;
            }
            Bundle bundleM11040constructorimpl8 = SavedStateWriter.m11040constructorimpl(this.savedState);
            String str8 = this.key;
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            SavedStateWriter.m11075putStringListimpl(bundleM11040constructorimpl8, str8, (List) value);
            return;
        }
        Bundle bundleM11040constructorimpl9 = SavedStateWriter.m11040constructorimpl(this.savedState);
        String str9 = this.key;
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Int>");
        SavedStateWriter.m11059putIntListimpl(bundleM11040constructorimpl9, str9, (List) value);
    }
}
