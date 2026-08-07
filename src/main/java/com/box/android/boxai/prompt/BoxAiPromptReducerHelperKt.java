package com.box.android.boxai.prompt;

import com.box.android.base.presentation.components.inputbar.BasicInputBarReducer;
import com.box.android.base.presentation.components.inputbar.TextFieldValueUIModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiPromptReducerHelper.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0007"}, d2 = {"updatePrompt", "Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action;", "Lcom/box/android/boxai/prompt/BoxAiPromptReducer$Action$Companion;", "value", "Lcom/box/android/base/presentation/components/inputbar/TextFieldValueUIModel;", "keyboardActionHandled", "submitPrompt", "boxai_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxAiPromptReducerHelperKt {
    public static final BoxAiPromptReducer.Action updatePrompt(BoxAiPromptReducer.Action.Companion companion, TextFieldValueUIModel value) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        return new BoxAiPromptReducer.Action.TextInputAction(new BasicInputBarReducer.Action.UpdateText(value));
    }

    public static final BoxAiPromptReducer.Action keyboardActionHandled(BoxAiPromptReducer.Action.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return new BoxAiPromptReducer.Action.TextInputAction(BasicInputBarReducer.Action.KeyboardActionHandled.INSTANCE);
    }

    public static final BoxAiPromptReducer.Action submitPrompt(BoxAiPromptReducer.Action.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return new BoxAiPromptReducer.Action.TextInputAction(BasicInputBarReducer.Action.SubmitClicked.INSTANCE);
    }
}
