package com.box.android.coreservices.modelcontroller;

import android.os.SystemClock;
import java.util.Comparator;
import java.util.concurrent.FutureTask;
import org.apache.commons.lang3.builder.CompareToBuilder;

/* JADX INFO: loaded from: classes9.dex */
public class PriorityFutureTask<T> extends FutureTask<T> {
    private static final BoxFutureTask.TaskPriority GENERIC_FUTURETASK_PRIORITY = BoxFutureTask.TaskPriority.PRIORITY_MEDIUM;
    private final long mConstructionTimestamp;
    private final BoxFutureTask.TaskPriority mPriority;

    public static class PriorityFutureTaskComparator implements Comparator<Runnable> {
        @Override // java.util.Comparator
        public int compare(Runnable runnable, Runnable runnable2) {
            long j;
            BoxFutureTask.TaskPriority taskPriority = PriorityFutureTask.GENERIC_FUTURETASK_PRIORITY;
            long j2 = Long.MAX_VALUE;
            if (runnable instanceof PriorityFutureTask) {
                PriorityFutureTask priorityFutureTask = (PriorityFutureTask) runnable;
                taskPriority = priorityFutureTask.mPriority;
                j = priorityFutureTask.mConstructionTimestamp;
            } else {
                j = Long.MAX_VALUE;
            }
            BoxFutureTask.TaskPriority taskPriority2 = PriorityFutureTask.GENERIC_FUTURETASK_PRIORITY;
            if (runnable2 instanceof PriorityFutureTask) {
                PriorityFutureTask priorityFutureTask2 = (PriorityFutureTask) runnable2;
                taskPriority2 = priorityFutureTask2.mPriority;
                j2 = priorityFutureTask2.mConstructionTimestamp;
            }
            return new CompareToBuilder().append(taskPriority.ordinal(), taskPriority2.ordinal()).append(j, j2).toComparison();
        }
    }

    public PriorityFutureTask(Runnable runnable, T t) {
        super(runnable, t);
        if (runnable instanceof BoxFutureTask) {
            this.mPriority = ((BoxFutureTask) runnable).getPriority();
        } else {
            this.mPriority = GENERIC_FUTURETASK_PRIORITY;
        }
        this.mConstructionTimestamp = SystemClock.uptimeMillis();
    }
}
