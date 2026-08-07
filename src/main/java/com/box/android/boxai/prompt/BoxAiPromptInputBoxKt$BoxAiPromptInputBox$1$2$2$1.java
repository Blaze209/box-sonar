package com.box.android.boxai.prompt;

import com.box.android.boxai.voice.VoiceInputReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiPromptInputBox.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class BoxAiPromptInputBoxKt$BoxAiPromptInputBox$1$2$2$1 extends FunctionReferenceImpl implements Function1<VoiceInputReducer.Action, BoxAiPromptReducer.Action.VoiceInputAction> {
    public static final BoxAiPromptInputBoxKt$BoxAiPromptInputBox$1$2$2$1 INSTANCE = new BoxAiPromptInputBoxKt$BoxAiPromptInputBox$1$2$2$1();

    BoxAiPromptInputBoxKt$BoxAiPromptInputBox$1$2$2$1() {
        super(1, BoxAiPromptReducer.Action.VoiceInputAction.class, "<init>", "<init>(Lcom/box/android/boxai/voice/VoiceInputReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final BoxAiPromptReducer.Action.VoiceInputAction invoke(VoiceInputReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new BoxAiPromptReducer.Action.VoiceInputAction(p0);
    }
}
