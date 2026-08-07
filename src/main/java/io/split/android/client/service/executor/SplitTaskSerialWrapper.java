package io.split.android.client.service.executor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class SplitTaskSerialWrapper implements SplitTask {
    public static final String SPLIT_EXTRA_EXECUTION_RESULTS = "serial_task_results";
    private final SplitTaskType mSplitTaskType;
    private final List<SplitTask> mTaskList;

    public SplitTaskSerialWrapper(SplitTaskType splitTaskType, SplitTask... tasks) {
        this.mSplitTaskType = splitTaskType;
        this.mTaskList = Arrays.asList(tasks);
    }

    public SplitTaskSerialWrapper(SplitTask... tasks) {
        this(SplitTaskType.GENERIC_TASK, tasks);
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        boolean z;
        ArrayList arrayList = new ArrayList();
        Iterator<SplitTask> it = this.mTaskList.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            SplitTaskExecutionInfo splitTaskExecutionInfoExecute = it.next().execute();
            if (splitTaskExecutionInfoExecute != null) {
                arrayList.add(splitTaskExecutionInfoExecute);
                if (!SplitTaskExecutionStatus.SUCCESS.equals(splitTaskExecutionInfoExecute.getStatus())) {
                    z = false;
                    break;
                }
            }
        }
        Map mapSingletonMap = Collections.singletonMap(SPLIT_EXTRA_EXECUTION_RESULTS, arrayList);
        if (z) {
            return SplitTaskExecutionInfo.success(this.mSplitTaskType, mapSingletonMap);
        }
        return SplitTaskExecutionInfo.error(this.mSplitTaskType, mapSingletonMap);
    }

    public List<SplitTask> getTaskList() {
        return this.mTaskList;
    }
}
