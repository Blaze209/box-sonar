package androidx.constraintlayout.compose;

import androidx.compose.foundation.layout.LayoutScopeMarker;
import androidx.constraintlayout.core.parser.CLNumber;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TransitionScope.kt */
/* JADX INFO: loaded from: classes8.dex */
@LayoutScopeMarker
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0000\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005J)\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\u0006\u001a\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0002\b\f¨\u0006\r"}, d2 = {"Landroidx/constraintlayout/compose/KeyAttributesScope;", "Landroidx/constraintlayout/compose/BaseKeyFramesScope;", "targets", "", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "([Landroidx/constraintlayout/compose/ConstrainedLayoutReference;)V", "frame", "", "", "keyFrameContent", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/KeyAttributeScope;", "Lkotlin/ExtensionFunctionType;", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class KeyAttributesScope extends BaseKeyFramesScope {
    public static final int $stable = 0;

    public KeyAttributesScope(ConstrainedLayoutReference... constrainedLayoutReferenceArr) {
        super((ConstrainedLayoutReference[]) Arrays.copyOf(constrainedLayoutReferenceArr, constrainedLayoutReferenceArr.length), null);
    }

    public final void frame(int frame, Function1<? super KeyAttributeScope, Unit> keyFrameContent) {
        KeyAttributeScope keyAttributeScope = new KeyAttributeScope();
        keyFrameContent.invoke(keyAttributeScope);
        getFramesContainer().add(new CLNumber(frame));
        keyAttributeScope.addToContainer$constraintlayout_compose_release(getKeyFramePropsObject());
    }
}
