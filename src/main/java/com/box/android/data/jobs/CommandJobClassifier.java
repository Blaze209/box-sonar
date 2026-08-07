package com.box.android.data.jobs;

import com.box.android.domain.jobs.JobType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommandJobClassifier.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/android/data/jobs/CommandJobClassifier;", "", "<init>", "()V", "knownCommandJobs", "", "", "isCommandJob", "", "jobType", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CommandJobClassifier {
    public static final CommandJobClassifier INSTANCE = new CommandJobClassifier();
    private static final Set<String> knownCommandJobs = SetsKt.setOf((Object[]) new String[]{JobType.DELETE_FILE, JobType.COPY_FILE, "CopyItem", JobType.MOVE_FILE, "MoveItem", "create_folder"});

    private CommandJobClassifier() {
    }

    public final boolean isCommandJob(String jobType) {
        Intrinsics.checkNotNullParameter(jobType, "jobType");
        return knownCommandJobs.contains(jobType);
    }
}
