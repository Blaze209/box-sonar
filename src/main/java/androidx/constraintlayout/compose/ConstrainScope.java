package androidx.constraintlayout.compose;

import androidx.compose.foundation.layout.LayoutScopeMarker;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLString;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: ConstrainScope.kt */
/* JADX INFO: loaded from: classes8.dex */
@LayoutScopeMarker
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b$\b\u0007\u0018\u00002\u00020\u0001:\u0006\u009c\u0001\u009d\u0001\u009e\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020zJ\u000e\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020{J\u0018\u0010|\u001a\u00020x2\u0006\u0010}\u001a\u0002032\b\b\u0003\u0010~\u001a\u00020\rJ\u000e\u0010\u007f\u001a\u00020x2\u0006\u0010}\u001a\u000203J\u0019\u0010\u0080\u0001\u001a\u00020x2\u0006\u0010}\u001a\u0002032\b\b\u0003\u0010~\u001a\u00020\rJ-\u0010\u0081\u0001\u001a\u00020x2\u0006\u0010}\u001a\u0002032\u0007\u0010\u0082\u0001\u001a\u00020\r2\u0007\u0010\u0083\u0001\u001a\u00020Vø\u0001\u0000¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0007\u0010\u0086\u0001\u001a\u00020xJ\u0007\u0010\u0087\u0001\u001a\u00020xJ\u0007\u0010\u0088\u0001\u001a\u00020xJY\u0010\u0089\u0001\u001a\u00020x2\u0006\u0010T\u001a\u00020z2\u0006\u0010\u0017\u001a\u00020z2\t\b\u0002\u0010\u008a\u0001\u001a\u00020V2\t\b\u0002\u0010\u008b\u0001\u001a\u00020V2\t\b\u0002\u0010\u008c\u0001\u001a\u00020V2\t\b\u0002\u0010\u008d\u0001\u001a\u00020V2\b\b\u0003\u0010~\u001a\u00020\rø\u0001\u0000¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u009f\u0001\u0010\u0089\u0001\u001a\u00020x2\u0006\u0010R\u001a\u00020{2\u0006\u0010T\u001a\u00020z2\u0006\u0010\u001d\u001a\u00020{2\u0006\u0010\u0017\u001a\u00020z2\t\b\u0002\u0010\u0090\u0001\u001a\u00020V2\t\b\u0002\u0010\u008a\u0001\u001a\u00020V2\t\b\u0002\u0010\u0091\u0001\u001a\u00020V2\t\b\u0002\u0010\u008b\u0001\u001a\u00020V2\t\b\u0002\u0010\u0092\u0001\u001a\u00020V2\t\b\u0002\u0010\u008c\u0001\u001a\u00020V2\t\b\u0002\u0010\u0093\u0001\u001a\u00020V2\t\b\u0002\u0010\u008d\u0001\u001a\u00020V2\b\b\u0003\u0010(\u001a\u00020\r2\b\b\u0003\u0010d\u001a\u00020\rø\u0001\u0000¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001JY\u0010\u0089\u0001\u001a\u00020x2\u0006\u0010R\u001a\u00020{2\u0006\u0010\u001d\u001a\u00020{2\t\b\u0002\u0010\u0090\u0001\u001a\u00020V2\t\b\u0002\u0010\u0091\u0001\u001a\u00020V2\t\b\u0002\u0010\u0092\u0001\u001a\u00020V2\t\b\u0002\u0010\u0093\u0001\u001a\u00020V2\b\b\u0003\u0010~\u001a\u00020\rø\u0001\u0000¢\u0006\u0006\b\u008e\u0001\u0010\u0096\u0001J\u0007\u0010\u0097\u0001\u001a\u00020xJ\u0007\u0010\u0098\u0001\u001a\u00020xJ\u0017\u0010\u0099\u0001\u001a\u00020 *\u00020Vø\u0001\u0000¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR&\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\tR+\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R&\u0010(\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0010\"\u0004\b*\u0010\u0012R+\u0010+\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b,\u0010\u0010\"\u0004\b-\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u00102\u001a\u000203¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R+\u00106\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b9\u0010/\u001a\u0004\b7\u0010\u0010\"\u0004\b8\u0010\u0012R+\u0010:\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b=\u0010/\u001a\u0004\b;\u0010\u0010\"\u0004\b<\u0010\u0012R+\u0010>\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bA\u0010/\u001a\u0004\b?\u0010\u0010\"\u0004\b@\u0010\u0012R+\u0010B\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bE\u0010/\u001a\u0004\bC\u0010\u0010\"\u0004\bD\u0010\u0012R+\u0010F\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bI\u0010/\u001a\u0004\bG\u0010\u0010\"\u0004\bH\u0010\u0012R+\u0010J\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bM\u0010/\u001a\u0004\bK\u0010\u0010\"\u0004\bL\u0010\u0012R+\u0010N\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bQ\u0010/\u001a\u0004\bO\u0010\u0010\"\u0004\bP\u0010\u0012R\u0011\u0010R\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\tR\u0011\u0010T\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u001aR1\u0010W\u001a\u00020V2\u0006\u0010\u001f\u001a\u00020V8F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\bX\u0010\u0010\"\u0004\bY\u0010\u0012R1\u0010\\\u001a\u00020V2\u0006\u0010\u001f\u001a\u00020V8F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b_\u0010[\u001a\u0004\b]\u0010\u0010\"\u0004\b^\u0010\u0012R1\u0010`\u001a\u00020V2\u0006\u0010\u001f\u001a\u00020V8F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bc\u0010[\u001a\u0004\ba\u0010\u0010\"\u0004\bb\u0010\u0012R&\u0010d\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u0010\"\u0004\bf\u0010\u0012R+\u0010g\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bj\u0010/\u001a\u0004\bh\u0010\u0010\"\u0004\bi\u0010\u0012R+\u0010l\u001a\u00020k2\u0006\u0010\u001f\u001a\u00020k8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR+\u0010s\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bv\u0010'\u001a\u0004\bt\u0010#\"\u0004\bu\u0010%\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u009f\u0001"}, d2 = {"Landroidx/constraintlayout/compose/ConstrainScope;", "", "id", "containerObject", "Landroidx/constraintlayout/core/parser/CLObject;", "(Ljava/lang/Object;Landroidx/constraintlayout/core/parser/CLObject;)V", "absoluteLeft", "Landroidx/constraintlayout/compose/VerticalAnchorable;", "getAbsoluteLeft", "()Landroidx/constraintlayout/compose/VerticalAnchorable;", "absoluteRight", "getAbsoluteRight", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "baseline", "Landroidx/constraintlayout/compose/BaselineAnchorable;", "getBaseline", "()Landroidx/constraintlayout/compose/BaselineAnchorable;", ViewProps.BOTTOM, "Landroidx/constraintlayout/compose/HorizontalAnchorable;", "getBottom", "()Landroidx/constraintlayout/compose/HorizontalAnchorable;", "getContainerObject$constraintlayout_compose_release", "()Landroidx/constraintlayout/core/parser/CLObject;", "end", "getEnd", "<set-?>", "Landroidx/constraintlayout/compose/Dimension;", "height", "getHeight", "()Landroidx/constraintlayout/compose/Dimension;", "setHeight", "(Landroidx/constraintlayout/compose/Dimension;)V", "height$delegate", "Landroidx/constraintlayout/compose/ConstrainScope$DimensionProperty;", "horizontalBias", "getHorizontalBias", "setHorizontalBias", "horizontalChainWeight", "getHorizontalChainWeight", "setHorizontalChainWeight", "horizontalChainWeight$delegate", "Landroidx/constraintlayout/compose/ConstrainScope$FloatProperty;", "getId$constraintlayout_compose_release", "()Ljava/lang/Object;", "parent", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "getParent", "()Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "pivotX", "getPivotX", "setPivotX", "pivotX$delegate", "pivotY", "getPivotY", "setPivotY", "pivotY$delegate", "rotationX", "getRotationX", "setRotationX", "rotationX$delegate", "rotationY", "getRotationY", "setRotationY", "rotationY$delegate", "rotationZ", "getRotationZ", "setRotationZ", "rotationZ$delegate", "scaleX", "getScaleX", "setScaleX", "scaleX$delegate", "scaleY", "getScaleY", "setScaleY", "scaleY$delegate", "start", "getStart", ViewProps.TOP, "getTop", "Landroidx/compose/ui/unit/Dp;", "translationX", "getTranslationX-D9Ej5fM", "setTranslationX-0680j_4", "translationX$delegate", "Landroidx/constraintlayout/compose/ConstrainScope$DpProperty;", "translationY", "getTranslationY-D9Ej5fM", "setTranslationY-0680j_4", "translationY$delegate", "translationZ", "getTranslationZ-D9Ej5fM", "setTranslationZ-0680j_4", "translationZ$delegate", "verticalBias", "getVerticalBias", "setVerticalBias", "verticalChainWeight", "getVerticalChainWeight", "setVerticalChainWeight", "verticalChainWeight$delegate", "Landroidx/constraintlayout/compose/Visibility;", "visibility", "getVisibility", "()Landroidx/constraintlayout/compose/Visibility;", "setVisibility", "(Landroidx/constraintlayout/compose/Visibility;)V", "visibility$delegate", "Landroidx/constraintlayout/compose/ConstrainScope$visibility$2;", "width", "getWidth", "setWidth", "width$delegate", "centerAround", "", "anchor", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "centerHorizontallyTo", "other", "bias", "centerTo", "centerVerticallyTo", "circular", "angle", "distance", "circular-wH6b6FI", "(Landroidx/constraintlayout/compose/ConstrainedLayoutReference;FF)V", "clearConstraints", "clearHorizontal", "clearVertical", "linkTo", "topMargin", "bottomMargin", "topGoneMargin", "bottomGoneMargin", "linkTo-8ZKsbrE", "(Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;FFFFF)V", "startMargin", "endMargin", "startGoneMargin", "endGoneMargin", "linkTo-R7zmacU", "(Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;FFFFFFFFFF)V", "(Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;FFFFF)V", "resetDimensions", "resetTransforms", "asDimension", "asDimension-0680j_4", "(F)Landroidx/constraintlayout/compose/Dimension;", "DimensionProperty", "DpProperty", "FloatProperty", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConstrainScope {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "width", "getWidth()Landroidx/constraintlayout/compose/Dimension;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "height", "getHeight()Landroidx/constraintlayout/compose/Dimension;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "visibility", "getVisibility()Landroidx/constraintlayout/compose/Visibility;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "scaleX", "getScaleX()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "scaleY", "getScaleY()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "rotationX", "getRotationX()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "rotationY", "getRotationY()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "rotationZ", "getRotationZ()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "translationX", "getTranslationX-D9Ej5fM()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "translationY", "getTranslationY-D9Ej5fM()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "translationZ", "getTranslationZ-D9Ej5fM()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "pivotX", "getPivotX()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "pivotY", "getPivotY()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "horizontalChainWeight", "getHorizontalChainWeight()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ConstrainScope.class, "verticalChainWeight", "getVerticalChainWeight()F", 0))};
    public static final int $stable = 0;
    private final VerticalAnchorable absoluteLeft;
    private final VerticalAnchorable absoluteRight;
    private float alpha;
    private final BaselineAnchorable baseline;
    private final HorizontalAnchorable bottom;
    private final CLObject containerObject;
    private final VerticalAnchorable end;
    private float horizontalBias;

    /* JADX INFO: renamed from: horizontalChainWeight$delegate, reason: from kotlin metadata */
    private final FloatProperty horizontalChainWeight;
    private final Object id;

    /* JADX INFO: renamed from: pivotX$delegate, reason: from kotlin metadata */
    private final FloatProperty pivotX;

    /* JADX INFO: renamed from: pivotY$delegate, reason: from kotlin metadata */
    private final FloatProperty pivotY;

    /* JADX INFO: renamed from: rotationX$delegate, reason: from kotlin metadata */
    private final FloatProperty rotationX;

    /* JADX INFO: renamed from: rotationY$delegate, reason: from kotlin metadata */
    private final FloatProperty rotationY;

    /* JADX INFO: renamed from: rotationZ$delegate, reason: from kotlin metadata */
    private final FloatProperty rotationZ;

    /* JADX INFO: renamed from: scaleX$delegate, reason: from kotlin metadata */
    private final FloatProperty scaleX;

    /* JADX INFO: renamed from: scaleY$delegate, reason: from kotlin metadata */
    private final FloatProperty scaleY;
    private final VerticalAnchorable start;
    private final HorizontalAnchorable top;

    /* JADX INFO: renamed from: translationX$delegate, reason: from kotlin metadata */
    private final DpProperty translationX;

    /* JADX INFO: renamed from: translationY$delegate, reason: from kotlin metadata */
    private final DpProperty translationY;

    /* JADX INFO: renamed from: translationZ$delegate, reason: from kotlin metadata */
    private final DpProperty translationZ;
    private float verticalBias;

    /* JADX INFO: renamed from: verticalChainWeight$delegate, reason: from kotlin metadata */
    private final FloatProperty verticalChainWeight;

    /* JADX INFO: renamed from: visibility$delegate, reason: from kotlin metadata */
    private final ConstrainScope$visibility$2 visibility;
    private final ConstrainedLayoutReference parent = new ConstrainedLayoutReference("parent");

    /* JADX INFO: renamed from: width$delegate, reason: from kotlin metadata */
    private final DimensionProperty width = new DimensionProperty(Dimension.INSTANCE.getWrapContent());

    /* JADX INFO: renamed from: height$delegate, reason: from kotlin metadata */
    private final DimensionProperty height = new DimensionProperty(Dimension.INSTANCE.getWrapContent());

    /* JADX WARN: Type inference failed for: r15v5, types: [androidx.constraintlayout.compose.ConstrainScope$visibility$2] */
    public ConstrainScope(Object obj, CLObject cLObject) {
        this.id = obj;
        this.containerObject = cLObject;
        this.start = new ConstraintVerticalAnchorable(-2, cLObject);
        this.absoluteLeft = new ConstraintVerticalAnchorable(0, cLObject);
        this.top = new ConstraintHorizontalAnchorable(0, cLObject);
        this.end = new ConstraintVerticalAnchorable(-1, cLObject);
        this.absoluteRight = new ConstraintVerticalAnchorable(1, cLObject);
        this.bottom = new ConstraintHorizontalAnchorable(1, cLObject);
        this.baseline = new ConstraintBaselineAnchorable(cLObject);
        final Visibility visible = Visibility.INSTANCE.getVisible();
        this.visibility = new ObservableProperty<Visibility>(visible) { // from class: androidx.constraintlayout.compose.ConstrainScope$visibility$2
            @Override // kotlin.properties.ObservableProperty
            public /* bridge */ /* synthetic */ void afterChange(KProperty kProperty, Visibility visibility, Visibility visibility2) {
                afterChange2((KProperty<?>) kProperty, visibility, visibility2);
            }

            /* JADX INFO: renamed from: afterChange, reason: avoid collision after fix types in other method */
            protected void afterChange2(KProperty<?> property, Visibility oldValue, Visibility newValue) {
                this.this$0.getContainerObject().putString(property.getName(), newValue.getName());
            }
        };
        this.alpha = 1.0f;
        this.scaleX = new FloatProperty(this, 1.0f, null, 2, null);
        int i = 2;
        DefaultConstructorMarker defaultConstructorMarker = null;
        String str = null;
        this.scaleY = new FloatProperty(this, 1.0f, str, i, defaultConstructorMarker);
        float f = 0.0f;
        this.rotationX = new FloatProperty(this, f, str, i, defaultConstructorMarker);
        this.rotationY = new FloatProperty(this, f, str, i, defaultConstructorMarker);
        this.rotationZ = new FloatProperty(this, f, str, i, defaultConstructorMarker);
        float f2 = 0;
        this.translationX = new DpProperty(this, Dp.m9687constructorimpl(f2), str, i, defaultConstructorMarker);
        this.translationY = new DpProperty(this, Dp.m9687constructorimpl(f2), str, i, defaultConstructorMarker);
        this.translationZ = new DpProperty(this, Dp.m9687constructorimpl(f2), str, i, defaultConstructorMarker);
        float f3 = 0.5f;
        this.pivotX = new FloatProperty(this, f3, str, i, defaultConstructorMarker);
        this.pivotY = new FloatProperty(this, f3, str, i, defaultConstructorMarker);
        this.horizontalChainWeight = new FloatProperty(Float.NaN, "hWeight");
        this.verticalChainWeight = new FloatProperty(Float.NaN, "vWeight");
        this.horizontalBias = 0.5f;
        this.verticalBias = 0.5f;
    }

    /* JADX INFO: renamed from: getContainerObject$constraintlayout_compose_release, reason: from getter */
    public final CLObject getContainerObject() {
        return this.containerObject;
    }

    /* JADX INFO: renamed from: getId$constraintlayout_compose_release, reason: from getter */
    public final Object getId() {
        return this.id;
    }

    public final ConstrainedLayoutReference getParent() {
        return this.parent;
    }

    public final VerticalAnchorable getStart() {
        return this.start;
    }

    public final VerticalAnchorable getAbsoluteLeft() {
        return this.absoluteLeft;
    }

    public final HorizontalAnchorable getTop() {
        return this.top;
    }

    public final VerticalAnchorable getEnd() {
        return this.end;
    }

    public final VerticalAnchorable getAbsoluteRight() {
        return this.absoluteRight;
    }

    public final HorizontalAnchorable getBottom() {
        return this.bottom;
    }

    public final BaselineAnchorable getBaseline() {
        return this.baseline;
    }

    public final Dimension getWidth() {
        return this.width.getValue(this, $$delegatedProperties[0]);
    }

    public final void setWidth(Dimension dimension) {
        this.width.setValue(this, $$delegatedProperties[0], dimension);
    }

    public final Dimension getHeight() {
        return this.height.getValue(this, $$delegatedProperties[1]);
    }

    public final void setHeight(Dimension dimension) {
        this.height.setValue(this, $$delegatedProperties[1], dimension);
    }

    public final Visibility getVisibility() {
        return getValue(this, $$delegatedProperties[2]);
    }

    public final void setVisibility(Visibility visibility) {
        setValue(this, $$delegatedProperties[2], visibility);
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
        if (Float.isNaN(f)) {
            return;
        }
        this.containerObject.putNumber("alpha", f);
    }

    public final float getScaleX() {
        return this.scaleX.getValue(this, $$delegatedProperties[3]).floatValue();
    }

    public final void setScaleX(float f) {
        this.scaleX.setValue(this, $$delegatedProperties[3], Float.valueOf(f));
    }

    public final float getScaleY() {
        return this.scaleY.getValue(this, $$delegatedProperties[4]).floatValue();
    }

    public final void setScaleY(float f) {
        this.scaleY.setValue(this, $$delegatedProperties[4], Float.valueOf(f));
    }

    public final float getRotationX() {
        return this.rotationX.getValue(this, $$delegatedProperties[5]).floatValue();
    }

    public final void setRotationX(float f) {
        this.rotationX.setValue(this, $$delegatedProperties[5], Float.valueOf(f));
    }

    public final float getRotationY() {
        return this.rotationY.getValue(this, $$delegatedProperties[6]).floatValue();
    }

    public final void setRotationY(float f) {
        this.rotationY.setValue(this, $$delegatedProperties[6], Float.valueOf(f));
    }

    public final float getRotationZ() {
        return this.rotationZ.getValue(this, $$delegatedProperties[7]).floatValue();
    }

    public final void setRotationZ(float f) {
        this.rotationZ.setValue(this, $$delegatedProperties[7], Float.valueOf(f));
    }

    /* JADX INFO: renamed from: getTranslationX-D9Ej5fM, reason: not valid java name */
    public final float m9969getTranslationXD9Ej5fM() {
        return this.translationX.getValue(this, $$delegatedProperties[8]).m9701unboximpl();
    }

    /* JADX INFO: renamed from: setTranslationX-0680j_4, reason: not valid java name */
    public final void m9975setTranslationX0680j_4(float f) {
        this.translationX.setValue(this, $$delegatedProperties[8], Dp.m9685boximpl(f));
    }

    /* JADX INFO: renamed from: getTranslationY-D9Ej5fM, reason: not valid java name */
    public final float m9970getTranslationYD9Ej5fM() {
        return this.translationY.getValue(this, $$delegatedProperties[9]).m9701unboximpl();
    }

    /* JADX INFO: renamed from: setTranslationY-0680j_4, reason: not valid java name */
    public final void m9976setTranslationY0680j_4(float f) {
        this.translationY.setValue(this, $$delegatedProperties[9], Dp.m9685boximpl(f));
    }

    /* JADX INFO: renamed from: getTranslationZ-D9Ej5fM, reason: not valid java name */
    public final float m9971getTranslationZD9Ej5fM() {
        return this.translationZ.getValue(this, $$delegatedProperties[10]).m9701unboximpl();
    }

    /* JADX INFO: renamed from: setTranslationZ-0680j_4, reason: not valid java name */
    public final void m9977setTranslationZ0680j_4(float f) {
        this.translationZ.setValue(this, $$delegatedProperties[10], Dp.m9685boximpl(f));
    }

    public final float getPivotX() {
        return this.pivotX.getValue(this, $$delegatedProperties[11]).floatValue();
    }

    public final void setPivotX(float f) {
        this.pivotX.setValue(this, $$delegatedProperties[11], Float.valueOf(f));
    }

    public final float getPivotY() {
        return this.pivotY.getValue(this, $$delegatedProperties[12]).floatValue();
    }

    public final void setPivotY(float f) {
        this.pivotY.setValue(this, $$delegatedProperties[12], Float.valueOf(f));
    }

    public final float getHorizontalChainWeight() {
        return this.horizontalChainWeight.getValue(this, $$delegatedProperties[13]).floatValue();
    }

    public final void setHorizontalChainWeight(float f) {
        this.horizontalChainWeight.setValue(this, $$delegatedProperties[13], Float.valueOf(f));
    }

    public final float getVerticalChainWeight() {
        return this.verticalChainWeight.getValue(this, $$delegatedProperties[14]).floatValue();
    }

    public final void setVerticalChainWeight(float f) {
        this.verticalChainWeight.setValue(this, $$delegatedProperties[14], Float.valueOf(f));
    }

    public final float getHorizontalBias() {
        return this.horizontalBias;
    }

    public final void setHorizontalBias(float f) {
        this.horizontalBias = f;
        if (Float.isNaN(f)) {
            return;
        }
        this.containerObject.putNumber("hBias", f);
    }

    public final float getVerticalBias() {
        return this.verticalBias;
    }

    public final void setVerticalBias(float f) {
        this.verticalBias = f;
        if (Float.isNaN(f)) {
            return;
        }
        this.containerObject.putNumber("vBias", f);
    }

    /* JADX INFO: renamed from: linkTo-8ZKsbrE, reason: not valid java name */
    public final void m9973linkTo8ZKsbrE(ConstraintLayoutBaseScope.VerticalAnchor start, ConstraintLayoutBaseScope.VerticalAnchor end, float startMargin, float endMargin, float startGoneMargin, float endGoneMargin, float bias) {
        this.start.mo9949linkToVpY3zN4(start, startMargin, startGoneMargin);
        this.end.mo9949linkToVpY3zN4(end, endMargin, endGoneMargin);
        this.containerObject.putNumber("hRtlBias", bias);
    }

    /* JADX INFO: renamed from: linkTo-8ZKsbrE, reason: not valid java name */
    public final void m9972linkTo8ZKsbrE(ConstraintLayoutBaseScope.HorizontalAnchor top, ConstraintLayoutBaseScope.HorizontalAnchor bottom, float topMargin, float bottomMargin, float topGoneMargin, float bottomGoneMargin, float bias) {
        this.top.mo9948linkToVpY3zN4(top, topMargin, topGoneMargin);
        this.bottom.mo9948linkToVpY3zN4(bottom, bottomMargin, bottomGoneMargin);
        this.containerObject.putNumber("vBias", bias);
    }

    /* JADX INFO: renamed from: linkTo-R7zmacU, reason: not valid java name */
    public final void m9974linkToR7zmacU(ConstraintLayoutBaseScope.VerticalAnchor start, ConstraintLayoutBaseScope.HorizontalAnchor top, ConstraintLayoutBaseScope.VerticalAnchor end, ConstraintLayoutBaseScope.HorizontalAnchor bottom, float startMargin, float topMargin, float endMargin, float bottomMargin, float startGoneMargin, float topGoneMargin, float endGoneMargin, float bottomGoneMargin, float horizontalBias, float verticalBias) {
        m9973linkTo8ZKsbrE(start, end, startMargin, endMargin, startGoneMargin, endGoneMargin, horizontalBias);
        m9972linkTo8ZKsbrE(top, bottom, topMargin, bottomMargin, topGoneMargin, bottomGoneMargin, verticalBias);
    }

    public final void centerTo(ConstrainedLayoutReference other) {
        m9966linkToR7zmacU$default(this, other.getStart(), other.getTop(), other.getEnd(), other.getBottom(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 16368, null);
    }

    public static /* synthetic */ void centerHorizontallyTo$default(ConstrainScope constrainScope, ConstrainedLayoutReference constrainedLayoutReference, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.5f;
        }
        constrainScope.centerHorizontallyTo(constrainedLayoutReference, f);
    }

    public final void centerHorizontallyTo(ConstrainedLayoutReference other, float bias) {
        m9965linkTo8ZKsbrE$default(this, other.getStart(), other.getEnd(), 0.0f, 0.0f, 0.0f, 0.0f, bias, 60, (Object) null);
    }

    public static /* synthetic */ void centerVerticallyTo$default(ConstrainScope constrainScope, ConstrainedLayoutReference constrainedLayoutReference, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.5f;
        }
        constrainScope.centerVerticallyTo(constrainedLayoutReference, f);
    }

    public final void centerVerticallyTo(ConstrainedLayoutReference other, float bias) {
        m9964linkTo8ZKsbrE$default(this, other.getTop(), other.getBottom(), 0.0f, 0.0f, 0.0f, 0.0f, bias, 60, (Object) null);
    }

    public final void centerAround(ConstraintLayoutBaseScope.VerticalAnchor anchor) {
        m9965linkTo8ZKsbrE$default(this, anchor, anchor, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 124, (Object) null);
    }

    public final void centerAround(ConstraintLayoutBaseScope.HorizontalAnchor anchor) {
        m9964linkTo8ZKsbrE$default(this, anchor, anchor, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 124, (Object) null);
    }

    /* JADX INFO: renamed from: circular-wH6b6FI, reason: not valid java name */
    public final void m9968circularwH6b6FI(ConstrainedLayoutReference other, float angle, float distance) {
        CLArray cLArray = new CLArray(new char[0]);
        cLArray.add(CLString.from(other.getId().toString()));
        cLArray.add(new CLNumber(angle));
        cLArray.add(new CLNumber(distance));
        this.containerObject.put("circular", cLArray);
    }

    public final void clearHorizontal() {
        this.containerObject.remove("left");
        this.containerObject.remove("right");
        this.containerObject.remove("start");
        this.containerObject.remove("end");
    }

    public final void clearVertical() {
        this.containerObject.remove(ViewProps.TOP);
        this.containerObject.remove(ViewProps.BOTTOM);
        this.containerObject.remove("baseline");
    }

    public final void clearConstraints() {
        clearHorizontal();
        clearVertical();
        this.containerObject.remove("circular");
    }

    public final void resetDimensions() {
        setWidth(Dimension.INSTANCE.getWrapContent());
        setHeight(Dimension.INSTANCE.getWrapContent());
    }

    public final void resetTransforms() {
        this.containerObject.remove("alpha");
        this.containerObject.remove("scaleX");
        this.containerObject.remove("scaleY");
        this.containerObject.remove("rotationX");
        this.containerObject.remove("rotationY");
        this.containerObject.remove("rotationZ");
        this.containerObject.remove("translationX");
        this.containerObject.remove("translationY");
        this.containerObject.remove("translationZ");
        this.containerObject.remove("pivotX");
        this.containerObject.remove("pivotY");
    }

    /* JADX INFO: renamed from: asDimension-0680j_4, reason: not valid java name */
    public final Dimension m9967asDimension0680j_4(float f) {
        return Dimension.INSTANCE.m10047value0680j_4(f);
    }

    /* JADX INFO: compiled from: ConstrainScope.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Landroidx/constraintlayout/compose/ConstrainScope$DimensionProperty;", "Lkotlin/properties/ObservableProperty;", "Landroidx/constraintlayout/compose/Dimension;", "initialValue", "(Landroidx/constraintlayout/compose/ConstrainScope;Landroidx/constraintlayout/compose/Dimension;)V", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class DimensionProperty extends ObservableProperty<Dimension> {
        public DimensionProperty(Dimension dimension) {
            super(dimension);
        }

        @Override // kotlin.properties.ObservableProperty
        public /* bridge */ /* synthetic */ void afterChange(KProperty kProperty, Dimension dimension, Dimension dimension2) {
            afterChange2((KProperty<?>) kProperty, dimension, dimension2);
        }

        /* JADX INFO: renamed from: afterChange, reason: avoid collision after fix types in other method */
        protected void afterChange2(KProperty<?> property, Dimension oldValue, Dimension newValue) {
            CLObject containerObject = ConstrainScope.this.getContainerObject();
            String name = property.getName();
            Intrinsics.checkNotNull(newValue, "null cannot be cast to non-null type androidx.constraintlayout.compose.DimensionDescription");
            containerObject.put(name, ((DimensionDescription) newValue).asCLElement$constraintlayout_compose_release());
        }
    }

    /* JADX INFO: compiled from: ConstrainScope.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/constraintlayout/compose/ConstrainScope$FloatProperty;", "Lkotlin/properties/ObservableProperty;", "", "initialValue", "nameOverride", "", "(Landroidx/constraintlayout/compose/ConstrainScope;FLjava/lang/String;)V", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class FloatProperty extends ObservableProperty<Float> {
        private final String nameOverride;

        public FloatProperty(float f, String str) {
            super(Float.valueOf(f));
            this.nameOverride = str;
        }

        public /* synthetic */ FloatProperty(ConstrainScope constrainScope, float f, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, (i & 2) != 0 ? null : str);
        }

        @Override // kotlin.properties.ObservableProperty
        public /* bridge */ /* synthetic */ void afterChange(KProperty kProperty, Float f, Float f2) {
            afterChange((KProperty<?>) kProperty, f.floatValue(), f2.floatValue());
        }

        protected void afterChange(KProperty<?> property, float oldValue, float newValue) {
            if (Float.isNaN(newValue)) {
                return;
            }
            CLObject containerObject = ConstrainScope.this.getContainerObject();
            String name = this.nameOverride;
            if (name == null) {
                name = property.getName();
            }
            containerObject.putNumber(name, newValue);
        }
    }

    /* JADX INFO: compiled from: ConstrainScope.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J.\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0014ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000f"}, d2 = {"Landroidx/constraintlayout/compose/ConstrainScope$DpProperty;", "Lkotlin/properties/ObservableProperty;", "Landroidx/compose/ui/unit/Dp;", "initialValue", "nameOverride", "", "(Landroidx/constraintlayout/compose/ConstrainScope;FLjava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "afterChange-VpY3zN4", "(Lkotlin/reflect/KProperty;FF)V", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class DpProperty extends ObservableProperty<Dp> {
        private final String nameOverride;

        public /* synthetic */ DpProperty(ConstrainScope constrainScope, float f, String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, str);
        }

        private DpProperty(float f, String str) {
            super(Dp.m9685boximpl(f));
            this.nameOverride = str;
        }

        public /* synthetic */ DpProperty(ConstrainScope constrainScope, float f, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(constrainScope, f, (i & 2) != 0 ? null : str, null);
        }

        @Override // kotlin.properties.ObservableProperty
        public /* bridge */ /* synthetic */ void afterChange(KProperty kProperty, Dp dp, Dp dp2) {
            m9978afterChangeVpY3zN4(kProperty, dp.m9701unboximpl(), dp2.m9701unboximpl());
        }

        /* JADX INFO: renamed from: afterChange-VpY3zN4, reason: not valid java name */
        protected void m9978afterChangeVpY3zN4(KProperty<?> property, float oldValue, float newValue) {
            if (Float.isNaN(newValue)) {
                return;
            }
            CLObject containerObject = ConstrainScope.this.getContainerObject();
            String name = this.nameOverride;
            if (name == null) {
                name = property.getName();
            }
            containerObject.putNumber(name, newValue);
        }
    }

    /* JADX INFO: renamed from: linkTo-8ZKsbrE$default, reason: not valid java name */
    public static /* synthetic */ void m9965linkTo8ZKsbrE$default(ConstrainScope constrainScope, ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor, ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor2, float f, float f2, float f3, float f4, float f5, int i, Object obj) {
        if ((i & 4) != 0) {
            f = Dp.m9687constructorimpl(0);
        }
        float f6 = f;
        if ((i & 8) != 0) {
            f2 = Dp.m9687constructorimpl(0);
        }
        float f7 = f2;
        if ((i & 16) != 0) {
            f3 = Dp.m9687constructorimpl(0);
        }
        constrainScope.m9973linkTo8ZKsbrE(verticalAnchor, verticalAnchor2, f6, f7, f3, (i & 32) != 0 ? Dp.m9687constructorimpl(0) : f4, (i & 64) != 0 ? 0.5f : f5);
    }

    /* JADX INFO: renamed from: linkTo-8ZKsbrE$default, reason: not valid java name */
    public static /* synthetic */ void m9964linkTo8ZKsbrE$default(ConstrainScope constrainScope, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor2, float f, float f2, float f3, float f4, float f5, int i, Object obj) {
        if ((i & 4) != 0) {
            f = Dp.m9687constructorimpl(0);
        }
        float f6 = f;
        if ((i & 8) != 0) {
            f2 = Dp.m9687constructorimpl(0);
        }
        float f7 = f2;
        if ((i & 16) != 0) {
            f3 = Dp.m9687constructorimpl(0);
        }
        constrainScope.m9972linkTo8ZKsbrE(horizontalAnchor, horizontalAnchor2, f6, f7, f3, (i & 32) != 0 ? Dp.m9687constructorimpl(0) : f4, (i & 64) != 0 ? 0.5f : f5);
    }

    /* JADX INFO: renamed from: linkTo-R7zmacU$default, reason: not valid java name */
    public static /* synthetic */ void m9966linkToR7zmacU$default(ConstrainScope constrainScope, ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor, ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor2, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, int i, Object obj) {
        constrainScope.m9974linkToR7zmacU(verticalAnchor, horizontalAnchor, verticalAnchor2, horizontalAnchor2, (i & 16) != 0 ? Dp.m9687constructorimpl(0) : f, (i & 32) != 0 ? Dp.m9687constructorimpl(0) : f2, (i & 64) != 0 ? Dp.m9687constructorimpl(0) : f3, (i & 128) != 0 ? Dp.m9687constructorimpl(0) : f4, (i & 256) != 0 ? Dp.m9687constructorimpl(0) : f5, (i & 512) != 0 ? Dp.m9687constructorimpl(0) : f6, (i & 1024) != 0 ? Dp.m9687constructorimpl(0) : f7, (i & 2048) != 0 ? Dp.m9687constructorimpl(0) : f8, (i & 4096) != 0 ? 0.5f : f9, (i & 8192) != 0 ? 0.5f : f10);
    }
}
