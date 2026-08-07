package androidx.constraintlayout.compose;

import android.util.Log;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.ConstraintSetParser;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: MotionScene.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0004H\u0014J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0016R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/constraintlayout/compose/JSONMotionScene;", "Landroidx/constraintlayout/compose/EditableJSONLayout;", "Landroidx/constraintlayout/compose/MotionScene;", "content", "", "(Ljava/lang/String;)V", "constraintSetsContent", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "forcedProgress", "", "transitionsContent", "getConstraintSet", FirebaseAnalytics.Param.INDEX, "", "name", "getConstraintSetInstance", "Landroidx/constraintlayout/compose/ConstraintSet;", "getForcedProgress", "getTransition", "getTransitionInstance", "Landroidx/constraintlayout/compose/Transition;", "onNewContent", "", "onNewProgress", "progress", "resetForcedProgress", "setConstraintSetContent", "setTransitionContent", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class JSONMotionScene extends EditableJSONLayout implements MotionScene {
    public static final int $stable = 0;
    private final HashMap<String, String> constraintSetsContent;
    private float forcedProgress;
    private final HashMap<String, String> transitionsContent;

    public JSONMotionScene(String str) {
        super(str);
        this.constraintSetsContent = new HashMap<>();
        this.transitionsContent = new HashMap<>();
        this.forcedProgress = Float.NaN;
        initialization();
    }

    @Override // androidx.constraintlayout.core.state.CoreMotionScene
    public void setConstraintSetContent(String name, String content) {
        this.constraintSetsContent.put(name, content);
    }

    @Override // androidx.constraintlayout.core.state.CoreMotionScene
    public void setTransitionContent(String name, String content) {
        this.transitionsContent.put(name, content);
    }

    @Override // androidx.constraintlayout.core.state.CoreMotionScene
    public String getConstraintSet(String name) {
        return this.constraintSetsContent.get(name);
    }

    @Override // androidx.constraintlayout.core.state.CoreMotionScene
    public String getConstraintSet(int index) {
        return (String) CollectionsKt.elementAtOrNull(this.constraintSetsContent.values(), index);
    }

    @Override // androidx.constraintlayout.core.state.CoreMotionScene
    public String getTransition(String name) {
        return this.transitionsContent.get(name);
    }

    @Override // androidx.constraintlayout.compose.LayoutInformationReceiver
    public float getForcedProgress() {
        return this.forcedProgress;
    }

    @Override // androidx.constraintlayout.compose.LayoutInformationReceiver
    public void resetForcedProgress() {
        this.forcedProgress = Float.NaN;
    }

    @Override // androidx.constraintlayout.compose.MotionScene
    public ConstraintSet getConstraintSetInstance(String name) {
        String constraintSet = getConstraintSet(name);
        if (constraintSet != null) {
            return ConstraintLayoutKt.ConstraintSet(constraintSet);
        }
        return null;
    }

    @Override // androidx.constraintlayout.compose.MotionScene
    public Transition getTransitionInstance(String name) {
        CLObject cLObject;
        String transition = getTransition(name);
        if (transition == null) {
            return null;
        }
        try {
            cLObject = CLParser.parse(transition);
        } catch (CLParsingException e) {
            Log.e("CML", "Error parsing JSON " + e);
            cLObject = null;
        }
        if (cLObject == null) {
            return null;
        }
        return new TransitionImpl(cLObject);
    }

    @Override // androidx.constraintlayout.compose.EditableJSONLayout
    protected void onNewContent(String content) {
        super.onNewContent(content);
        try {
            ConstraintSetParser.parseMotionSceneJSON(this, content);
        } catch (Exception unused) {
        }
    }

    @Override // androidx.constraintlayout.compose.LayoutInformationReceiver
    public void onNewProgress(float progress) {
        this.forcedProgress = progress;
        signalUpdate();
    }
}
