package androidx.constraintlayout.compose;

import androidx.compose.foundation.layout.LayoutScopeMarker;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: TransitionScope.kt */
/* JADX INFO: loaded from: classes8.dex */
@LayoutScopeMarker
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR+\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\tR+\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR+\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR+\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\tR+\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR1\u0010!\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020 8F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\tR1\u0010%\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020 8F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b(\u0010\u000b\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR1\u0010)\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020 8F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b,\u0010\u000b\u001a\u0004\b*\u0010\u0007\"\u0004\b+\u0010\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006-"}, d2 = {"Landroidx/constraintlayout/compose/KeyAttributeScope;", "Landroidx/constraintlayout/compose/BaseKeyFrameScope;", "()V", "<set-?>", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "alpha$delegate", "Lkotlin/properties/ObservableProperty;", "rotationX", "getRotationX", "setRotationX", "rotationX$delegate", "rotationY", "getRotationY", "setRotationY", "rotationY$delegate", "rotationZ", "getRotationZ", "setRotationZ", "rotationZ$delegate", "scaleX", "getScaleX", "setScaleX", "scaleX$delegate", "scaleY", "getScaleY", "setScaleY", "scaleY$delegate", "Landroidx/compose/ui/unit/Dp;", "translationX", "getTranslationX-D9Ej5fM", "setTranslationX-0680j_4", "translationX$delegate", "translationY", "getTranslationY-D9Ej5fM", "setTranslationY-0680j_4", "translationY$delegate", "translationZ", "getTranslationZ-D9Ej5fM", "setTranslationZ-0680j_4", "translationZ$delegate", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class KeyAttributeScope extends BaseKeyFrameScope {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(KeyAttributeScope.class, "alpha", "getAlpha()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(KeyAttributeScope.class, "scaleX", "getScaleX()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(KeyAttributeScope.class, "scaleY", "getScaleY()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(KeyAttributeScope.class, "rotationX", "getRotationX()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(KeyAttributeScope.class, "rotationY", "getRotationY()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(KeyAttributeScope.class, "rotationZ", "getRotationZ()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(KeyAttributeScope.class, "translationX", "getTranslationX-D9Ej5fM()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(KeyAttributeScope.class, "translationY", "getTranslationY-D9Ej5fM()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(KeyAttributeScope.class, "translationZ", "getTranslationZ-D9Ej5fM()F", 0))};
    public static final int $stable = 8;

    /* JADX INFO: renamed from: alpha$delegate, reason: from kotlin metadata */
    private final ObservableProperty alpha;

    /* JADX INFO: renamed from: rotationX$delegate, reason: from kotlin metadata */
    private final ObservableProperty rotationX;

    /* JADX INFO: renamed from: rotationY$delegate, reason: from kotlin metadata */
    private final ObservableProperty rotationY;

    /* JADX INFO: renamed from: rotationZ$delegate, reason: from kotlin metadata */
    private final ObservableProperty rotationZ;

    /* JADX INFO: renamed from: scaleX$delegate, reason: from kotlin metadata */
    private final ObservableProperty scaleX;

    /* JADX INFO: renamed from: scaleY$delegate, reason: from kotlin metadata */
    private final ObservableProperty scaleY;

    /* JADX INFO: renamed from: translationX$delegate, reason: from kotlin metadata */
    private final ObservableProperty translationX;

    /* JADX INFO: renamed from: translationY$delegate, reason: from kotlin metadata */
    private final ObservableProperty translationY;

    /* JADX INFO: renamed from: translationZ$delegate, reason: from kotlin metadata */
    private final ObservableProperty translationZ;

    public KeyAttributeScope() {
        super(null);
        Float fValueOf = Float.valueOf(1.0f);
        this.alpha = addOnPropertyChange(fValueOf, "alpha");
        this.scaleX = addOnPropertyChange(fValueOf, "scaleX");
        this.scaleY = addOnPropertyChange(fValueOf, "scaleY");
        Float fValueOf2 = Float.valueOf(0.0f);
        this.rotationX = addOnPropertyChange(fValueOf2, "rotationX");
        this.rotationY = addOnPropertyChange(fValueOf2, "rotationY");
        this.rotationZ = addOnPropertyChange(fValueOf2, "rotationZ");
        float f = 0;
        this.translationX = addOnPropertyChange(Dp.m9685boximpl(Dp.m9687constructorimpl(f)), "translationX");
        this.translationY = addOnPropertyChange(Dp.m9685boximpl(Dp.m9687constructorimpl(f)), "translationY");
        this.translationZ = addOnPropertyChange(Dp.m9685boximpl(Dp.m9687constructorimpl(f)), "translationZ");
    }

    public final float getAlpha() {
        return ((Number) this.alpha.getValue(this, $$delegatedProperties[0])).floatValue();
    }

    public final void setAlpha(float f) {
        this.alpha.setValue(this, $$delegatedProperties[0], Float.valueOf(f));
    }

    public final float getScaleX() {
        return ((Number) this.scaleX.getValue(this, $$delegatedProperties[1])).floatValue();
    }

    public final void setScaleX(float f) {
        this.scaleX.setValue(this, $$delegatedProperties[1], Float.valueOf(f));
    }

    public final float getScaleY() {
        return ((Number) this.scaleY.getValue(this, $$delegatedProperties[2])).floatValue();
    }

    public final void setScaleY(float f) {
        this.scaleY.setValue(this, $$delegatedProperties[2], Float.valueOf(f));
    }

    public final float getRotationX() {
        return ((Number) this.rotationX.getValue(this, $$delegatedProperties[3])).floatValue();
    }

    public final void setRotationX(float f) {
        this.rotationX.setValue(this, $$delegatedProperties[3], Float.valueOf(f));
    }

    public final float getRotationY() {
        return ((Number) this.rotationY.getValue(this, $$delegatedProperties[4])).floatValue();
    }

    public final void setRotationY(float f) {
        this.rotationY.setValue(this, $$delegatedProperties[4], Float.valueOf(f));
    }

    public final float getRotationZ() {
        return ((Number) this.rotationZ.getValue(this, $$delegatedProperties[5])).floatValue();
    }

    public final void setRotationZ(float f) {
        this.rotationZ.setValue(this, $$delegatedProperties[5], Float.valueOf(f));
    }

    /* JADX INFO: renamed from: getTranslationX-D9Ej5fM, reason: not valid java name */
    public final float m10071getTranslationXD9Ej5fM() {
        return ((Dp) this.translationX.getValue(this, $$delegatedProperties[6])).m9701unboximpl();
    }

    /* JADX INFO: renamed from: setTranslationX-0680j_4, reason: not valid java name */
    public final void m10074setTranslationX0680j_4(float f) {
        this.translationX.setValue(this, $$delegatedProperties[6], Dp.m9685boximpl(f));
    }

    /* JADX INFO: renamed from: getTranslationY-D9Ej5fM, reason: not valid java name */
    public final float m10072getTranslationYD9Ej5fM() {
        return ((Dp) this.translationY.getValue(this, $$delegatedProperties[7])).m9701unboximpl();
    }

    /* JADX INFO: renamed from: setTranslationY-0680j_4, reason: not valid java name */
    public final void m10075setTranslationY0680j_4(float f) {
        this.translationY.setValue(this, $$delegatedProperties[7], Dp.m9685boximpl(f));
    }

    /* JADX INFO: renamed from: getTranslationZ-D9Ej5fM, reason: not valid java name */
    public final float m10073getTranslationZD9Ej5fM() {
        return ((Dp) this.translationZ.getValue(this, $$delegatedProperties[8])).m9701unboximpl();
    }

    /* JADX INFO: renamed from: setTranslationZ-0680j_4, reason: not valid java name */
    public final void m10076setTranslationZ0680j_4(float f) {
        this.translationZ.setValue(this, $$delegatedProperties[8], Dp.m9685boximpl(f));
    }
}
