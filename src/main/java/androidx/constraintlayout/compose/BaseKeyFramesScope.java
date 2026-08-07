package androidx.constraintlayout.compose;

import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLString;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: TransitionScope.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\u001b\b\u0004\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005J5\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u0019\"\n\b\u0000\u0010\u001a*\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u0002H\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0000¢\u0006\u0004\b\u001f\u0010 R+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0001\u0004!\"#$¨\u0006%"}, d2 = {"Landroidx/constraintlayout/compose/BaseKeyFramesScope;", "", "targets", "", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "([Landroidx/constraintlayout/compose/ConstrainedLayoutReference;)V", "<set-?>", "Landroidx/constraintlayout/compose/Easing;", "easing", "getEasing", "()Landroidx/constraintlayout/compose/Easing;", "setEasing", "(Landroidx/constraintlayout/compose/Easing;)V", "easing$delegate", "Lkotlin/properties/ObservableProperty;", "framesContainer", "Landroidx/constraintlayout/core/parser/CLArray;", "getFramesContainer$constraintlayout_compose_release", "()Landroidx/constraintlayout/core/parser/CLArray;", "keyFramePropsObject", "Landroidx/constraintlayout/core/parser/CLObject;", "getKeyFramePropsObject$constraintlayout_compose_release", "()Landroidx/constraintlayout/core/parser/CLObject;", "targetsContainer", "addNameOnPropertyChange", "Lkotlin/properties/ObservableProperty;", ExifInterface.LONGITUDE_EAST, "Landroidx/constraintlayout/compose/NamedPropertyOrValue;", "initialValue", "nameOverride", "", "addNameOnPropertyChange$constraintlayout_compose_release", "(Landroidx/constraintlayout/compose/NamedPropertyOrValue;Ljava/lang/String;)Lkotlin/properties/ObservableProperty;", "Landroidx/constraintlayout/compose/FakeKeyFramesScope;", "Landroidx/constraintlayout/compose/KeyAttributesScope;", "Landroidx/constraintlayout/compose/KeyCyclesScope;", "Landroidx/constraintlayout/compose/KeyPositionsScope;", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BaseKeyFramesScope {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(BaseKeyFramesScope.class, "easing", "getEasing()Landroidx/constraintlayout/compose/Easing;", 0))};
    public static final int $stable = 8;

    /* JADX INFO: renamed from: easing$delegate, reason: from kotlin metadata */
    private final ObservableProperty easing;
    private final CLArray framesContainer;
    private final CLObject keyFramePropsObject;
    private final CLArray targetsContainer;

    public /* synthetic */ BaseKeyFramesScope(ConstrainedLayoutReference[] constrainedLayoutReferenceArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(constrainedLayoutReferenceArr);
    }

    private BaseKeyFramesScope(ConstrainedLayoutReference... constrainedLayoutReferenceArr) {
        CLObject cLObject = new CLObject(new char[0]);
        cLObject.clear();
        this.keyFramePropsObject = cLObject;
        CLArray cLArray = new CLArray(new char[0]);
        this.targetsContainer = cLArray;
        CLArray cLArray2 = new CLArray(new char[0]);
        this.framesContainer = cLArray2;
        this.easing = addNameOnPropertyChange$constraintlayout_compose_release(Easing.INSTANCE.getStandard(), "transitionEasing");
        cLObject.put("target", cLArray);
        cLObject.put("frames", cLArray2);
        for (ConstrainedLayoutReference constrainedLayoutReference : constrainedLayoutReferenceArr) {
            char[] charArray = constrainedLayoutReference.getId().toString().toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
            CLArray cLArray3 = this.targetsContainer;
            CLString cLString = new CLString(charArray);
            cLString.setStart(0L);
            cLString.setEnd(((long) charArray.length) - 1);
            cLArray3.add(cLString);
        }
    }

    /* JADX INFO: renamed from: getKeyFramePropsObject$constraintlayout_compose_release, reason: from getter */
    public final CLObject getKeyFramePropsObject() {
        return this.keyFramePropsObject;
    }

    /* JADX INFO: renamed from: getFramesContainer$constraintlayout_compose_release, reason: from getter */
    public final CLArray getFramesContainer() {
        return this.framesContainer;
    }

    public final Easing getEasing() {
        return (Easing) this.easing.getValue(this, $$delegatedProperties[0]);
    }

    public final void setEasing(Easing easing) {
        this.easing.setValue(this, $$delegatedProperties[0], easing);
    }

    public static /* synthetic */ ObservableProperty addNameOnPropertyChange$constraintlayout_compose_release$default(BaseKeyFramesScope baseKeyFramesScope, NamedPropertyOrValue namedPropertyOrValue, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addNameOnPropertyChange");
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return baseKeyFramesScope.addNameOnPropertyChange$constraintlayout_compose_release(namedPropertyOrValue, str);
    }

    public final <E extends NamedPropertyOrValue> ObservableProperty<E> addNameOnPropertyChange$constraintlayout_compose_release(final E initialValue, final String nameOverride) {
        return (ObservableProperty) new ObservableProperty<E>(initialValue) { // from class: androidx.constraintlayout.compose.BaseKeyFramesScope$addNameOnPropertyChange$1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Incorrect types in method signature: (Lkotlin/reflect/KProperty<*>;TE;TE;)V */
            @Override // kotlin.properties.ObservableProperty
            public void afterChange(KProperty property, NamedPropertyOrValue oldValue, NamedPropertyOrValue newValue) {
                String name = nameOverride;
                if (name == null) {
                    name = property.getName();
                }
                if (newValue != null) {
                    this.getKeyFramePropsObject().putString(name, newValue.getName());
                }
            }
        };
    }
}
