package com.box.android.fileactivity.presentation;

import com.box.android.base.presentation.components.commentbar.CommentWithMentionsReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivitiesScreen.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class FileActivitiesScreenKt$FileActivitiesScreen$1$1$commentWithMentionsStore$2$1 extends FunctionReferenceImpl implements Function1<CommentWithMentionsReducer.Action, FileActivitiesReducer.Action.CommentWithMentionsAction> {
    public static final FileActivitiesScreenKt$FileActivitiesScreen$1$1$commentWithMentionsStore$2$1 INSTANCE = new FileActivitiesScreenKt$FileActivitiesScreen$1$1$commentWithMentionsStore$2$1();

    FileActivitiesScreenKt$FileActivitiesScreen$1$1$commentWithMentionsStore$2$1() {
        super(1, FileActivitiesReducer.Action.CommentWithMentionsAction.class, "<init>", "<init>(Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final FileActivitiesReducer.Action.CommentWithMentionsAction invoke(CommentWithMentionsReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new FileActivitiesReducer.Action.CommentWithMentionsAction(p0);
    }
}
