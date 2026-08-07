package androidx.constraintlayout.compose;

import androidx.compose.foundation.layout.LayoutScopeMarker;
import androidx.constraintlayout.core.parser.CLNumber;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: TransitionScope.kt */
/* JADX INFO: loaded from: classes8.dex */
@LayoutScopeMarker
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0000\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005J)\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u000f\u001a\u00020\u00112\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100\u0013¢\u0006\u0002\b\u0015R+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Landroidx/constraintlayout/compose/KeyPositionsScope;", "Landroidx/constraintlayout/compose/BaseKeyFramesScope;", "targets", "", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "([Landroidx/constraintlayout/compose/ConstrainedLayoutReference;)V", "<set-?>", "Landroidx/constraintlayout/compose/RelativePosition;", "type", "getType", "()Landroidx/constraintlayout/compose/RelativePosition;", "setType", "(Landroidx/constraintlayout/compose/RelativePosition;)V", "type$delegate", "Lkotlin/properties/ObservableProperty;", "frame", "", "", "keyFrameContent", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/KeyPositionScope;", "Lkotlin/ExtensionFunctionType;", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class KeyPositionsScope extends BaseKeyFramesScope {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(KeyPositionsScope.class, "type", "getType()Landroidx/constraintlayout/compose/RelativePosition;", 0))};
    public static final int $stable = 8;

    /* JADX INFO: renamed from: type$delegate, reason: from kotlin metadata */
    private final ObservableProperty type;

    public KeyPositionsScope(ConstrainedLayoutReference... constrainedLayoutReferenceArr) {
        super((ConstrainedLayoutReference[]) Arrays.copyOf(constrainedLayoutReferenceArr, constrainedLayoutReferenceArr.length), null);
        this.type = BaseKeyFramesScope.addNameOnPropertyChange$constraintlayout_compose_release$default(this, RelativePosition.INSTANCE.getDelta(), null, 2, null);
    }

    public final RelativePosition getType() {
        return (RelativePosition) this.type.getValue(this, $$delegatedProperties[0]);
    }

    public final void setType(RelativePosition relativePosition) {
        this.type.setValue(this, $$delegatedProperties[0], relativePosition);
    }

    public final void frame(int frame, Function1<? super KeyPositionScope, Unit> keyFrameContent) {
        KeyPositionScope keyPositionScope = new KeyPositionScope();
        keyFrameContent.invoke(keyPositionScope);
        getFramesContainer().add(new CLNumber(frame));
        keyPositionScope.addToContainer$constraintlayout_compose_release(getKeyFramePropsObject());
    }
}
