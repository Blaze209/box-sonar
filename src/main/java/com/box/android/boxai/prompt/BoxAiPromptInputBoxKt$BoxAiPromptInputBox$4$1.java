package com.box.android.boxai.prompt;

import com.box.android.base.presentation.components.permission.PermissionReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiPromptInputBox.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class BoxAiPromptInputBoxKt$BoxAiPromptInputBox$4$1 extends FunctionReferenceImpl implements Function1<PermissionReducer.Action, BoxAiPromptReducer.Action.AudioPermissionsAction> {
    public static final BoxAiPromptInputBoxKt$BoxAiPromptInputBox$4$1 INSTANCE = new BoxAiPromptInputBoxKt$BoxAiPromptInputBox$4$1();

    BoxAiPromptInputBoxKt$BoxAiPromptInputBox$4$1() {
        super(1, BoxAiPromptReducer.Action.AudioPermissionsAction.class, "<init>", "<init>(Lcom/box/android/base/presentation/components/permission/PermissionReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final BoxAiPromptReducer.Action.AudioPermissionsAction invoke(PermissionReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new BoxAiPromptReducer.Action.AudioPermissionsAction(p0);
    }
}
