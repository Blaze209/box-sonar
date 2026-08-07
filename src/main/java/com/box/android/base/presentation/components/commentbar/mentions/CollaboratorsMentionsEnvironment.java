package com.box.android.base.presentation.components.commentbar.mentions;

import com.box.android.domain.controller.ICommentControllerBridge;
import com.box.android.domain.metrics.Gen204FileActivityEventLogger;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollaboratorsMentionsReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsEnvironment;", "", "fileActivityEventLogger", "Lcom/box/android/domain/metrics/Gen204FileActivityEventLogger;", "commentControllerBridge", "Lcom/box/android/domain/controller/ICommentControllerBridge;", "<init>", "(Lcom/box/android/domain/metrics/Gen204FileActivityEventLogger;Lcom/box/android/domain/controller/ICommentControllerBridge;)V", "getFileActivityEventLogger", "()Lcom/box/android/domain/metrics/Gen204FileActivityEventLogger;", "getCommentControllerBridge", "()Lcom/box/android/domain/controller/ICommentControllerBridge;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollaboratorsMentionsEnvironment {
    public static final int $stable = 8;
    private final ICommentControllerBridge commentControllerBridge;
    private final Gen204FileActivityEventLogger fileActivityEventLogger;

    @Inject
    public CollaboratorsMentionsEnvironment(Gen204FileActivityEventLogger fileActivityEventLogger, ICommentControllerBridge commentControllerBridge) {
        Intrinsics.checkNotNullParameter(fileActivityEventLogger, "fileActivityEventLogger");
        Intrinsics.checkNotNullParameter(commentControllerBridge, "commentControllerBridge");
        this.fileActivityEventLogger = fileActivityEventLogger;
        this.commentControllerBridge = commentControllerBridge;
    }

    public final Gen204FileActivityEventLogger getFileActivityEventLogger() {
        return this.fileActivityEventLogger;
    }

    public final ICommentControllerBridge getCommentControllerBridge() {
        return this.commentControllerBridge;
    }
}
