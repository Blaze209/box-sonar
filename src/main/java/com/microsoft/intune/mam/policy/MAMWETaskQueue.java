package com.microsoft.intune.mam.policy;

import android.os.ConditionVariable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes3.dex */
public class MAMWETaskQueue {
    private static final int INITIAL_QUEUE_CAPACITY = 11;
    private final ConditionVariable mConditionVariable = new ConditionVariable(false);
    private final PriorityQueue<Task> mTaskQueue = new PriorityQueue<>(11, new TaskComparator());

    public interface Task extends Runnable {
        long dueAt();
    }

    private static class TaskComparator implements Comparator<Task> {
        private TaskComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Task task, Task task2) {
            return Long.signum(task.dueAt() - task2.dueAt());
        }
    }

    public synchronized void add(Task task) {
        this.mTaskQueue.add(task);
        this.mConditionVariable.open();
    }

    public synchronized void remove(Task task) {
        this.mTaskQueue.remove(task);
    }

    public List<Task> getDueTasks(long j) {
        long delayUntilNextTask = getDelayUntilNextTask(j);
        if (delayUntilNextTask > 0) {
            this.mConditionVariable.block(delayUntilNextTask);
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            this.mConditionVariable.close();
            while (getDelayUntilNextTask(1L) <= 0) {
                arrayList.add(this.mTaskQueue.poll());
            }
        }
        return arrayList;
    }

    private synchronized long getDelayUntilNextTask(long j) {
        Task taskPeek = this.mTaskQueue.peek();
        if (taskPeek == null) {
            return j;
        }
        return taskPeek.dueAt() - System.currentTimeMillis();
    }
}
