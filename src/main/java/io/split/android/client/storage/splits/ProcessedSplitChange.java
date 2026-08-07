package io.split.android.client.storage.splits;

import io.split.android.client.dtos.Split;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ProcessedSplitChange {
    private final List<Split> activeSplits;
    private final List<Split> archivedSplits;
    private final long changeNumber;
    private final long updateTimestamp;

    public ProcessedSplitChange(List<Split> activeSplits, List<Split> archivedSplits, long changeNumber, long updateTimestamp) {
        this.activeSplits = activeSplits;
        this.archivedSplits = archivedSplits;
        this.changeNumber = changeNumber;
        this.updateTimestamp = updateTimestamp;
    }

    public List<Split> getActiveSplits() {
        return this.activeSplits;
    }

    public List<Split> getArchivedSplits() {
        return this.archivedSplits;
    }

    public long getChangeNumber() {
        return this.changeNumber;
    }

    public long getUpdateTimestamp() {
        return this.updateTimestamp;
    }
}
