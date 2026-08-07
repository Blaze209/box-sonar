package expo.modules.ui;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsProperties_androidKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Modifiers.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"applyTestTag", "Landroidx/compose/ui/Modifier;", ViewProps.TEST_ID, "", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ModifiersKt {
    public static final Modifier applyTestTag(Modifier modifier, String str) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        String str2 = str;
        return (str2 == null || str2.length() == 0) ? modifier : TestTagKt.testTag(SemanticsModifierKt.semantics$default(modifier, false, new Function1() { // from class: expo.modules.ui.ModifiersKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ModifiersKt.applyTestTag$lambda$0((SemanticsPropertyReceiver) obj);
            }
        }, 1, null), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyTestTag$lambda$0(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsProperties_androidKt.setTestTagsAsResourceId(semantics, true);
        return Unit.INSTANCE;
    }
}
