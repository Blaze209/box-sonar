package com.box.android.base.presentation.components.commentbar;

import com.box.android.base.presentation.components.commentbar.mentions.CollaboratorsMentionsReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommentBar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class CommentBarKt$CommentBar$3$collaboratorsStore$2$1 extends FunctionReferenceImpl implements Function1<CollaboratorsMentionsReducer.Action, CommentWithMentionsReducer.Action.Collaborators> {
    public static final CommentBarKt$CommentBar$3$collaboratorsStore$2$1 INSTANCE = new CommentBarKt$CommentBar$3$collaboratorsStore$2$1();

    CommentBarKt$CommentBar$3$collaboratorsStore$2$1() {
        super(1, CommentWithMentionsReducer.Action.Collaborators.class, "<init>", "<init>(Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CommentWithMentionsReducer.Action.Collaborators invoke(CollaboratorsMentionsReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new CommentWithMentionsReducer.Action.Collaborators(p0);
    }
}
