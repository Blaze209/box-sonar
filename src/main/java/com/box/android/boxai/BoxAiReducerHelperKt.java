package com.box.android.boxai;

import com.box.android.base.presentation.components.inputbar.BasicInputBarReducer;
import com.box.android.boxai.prompt.BoxAiPromptReducer;
import com.box.android.boxai.qa.BoxAiQaReducer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiReducerHelper.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"showKeyboard", "Lcom/box/android/boxai/BoxAiReducer$Action;", "Lcom/box/android/boxai/BoxAiReducer$Action$Companion;", "boxai_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxAiReducerHelperKt {
    public static final BoxAiReducer.Action showKeyboard(BoxAiReducer.Action.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return new BoxAiReducer.Action.QaAiAction(new BoxAiQaReducer.Action.PromptInputAction(new BoxAiPromptReducer.Action.TextInputAction(BasicInputBarReducer.Action.ShowKeyboard.INSTANCE)));
    }
}
