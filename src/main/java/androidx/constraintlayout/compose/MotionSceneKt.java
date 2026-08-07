package androidx.constraintlayout.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

/* JADX INFO: compiled from: MotionScene.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {TypedValues.MotionScene.NAME, "Landroidx/constraintlayout/compose/MotionScene;", "content", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/constraintlayout/compose/MotionScene;", "constraintlayout-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MotionSceneKt {
    public static final MotionScene MotionScene(String str, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1620042625, "C(MotionScene)51@1904L46:MotionScene.kt#fysre8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1620042625, i, -1, "androidx.constraintlayout.compose.MotionScene (MotionScene.kt:48)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 625482214, "CC(remember):MotionScene.kt#9igjgp");
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed(str)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new JSONMotionScene(str);
            composer.updateRememberedValue(objRememberedValue);
        }
        JSONMotionScene jSONMotionScene = (JSONMotionScene) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jSONMotionScene;
    }
}
