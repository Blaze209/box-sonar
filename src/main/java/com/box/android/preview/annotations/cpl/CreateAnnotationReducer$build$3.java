package com.box.android.preview.annotations.cpl;

import com.box.android.base.presentation.components.commentbar.CommentWithMentionsReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateAnnotationReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class CreateAnnotationReducer$build$3 extends FunctionReferenceImpl implements Function1<CommentWithMentionsReducer.Action, CreateAnnotationReducer.Action.CommentWithMentionsAction> {
    public static final CreateAnnotationReducer$build$3 INSTANCE = new CreateAnnotationReducer$build$3();

    CreateAnnotationReducer$build$3() {
        super(1, CreateAnnotationReducer.Action.CommentWithMentionsAction.class, "<init>", "<init>(Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CreateAnnotationReducer.Action.CommentWithMentionsAction invoke(CommentWithMentionsReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new CreateAnnotationReducer.Action.CommentWithMentionsAction(p0);
    }
}
