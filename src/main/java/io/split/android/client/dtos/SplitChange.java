package io.split.android.client.dtos;

import com.google.gson.annotations.SerializedName;
import io.split.android.client.service.ServiceConstants;
import io.split.android.client.service.http.HttpFetcherImpl;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SplitChange {

    @SerializedName(alternate = {"since"}, value = "s")
    public long since;

    @SerializedName(alternate = {ServiceConstants.DEFAULT_SPLITS_FILENAME}, value = "d")
    public List<Split> splits;

    @SerializedName(alternate = {HttpFetcherImpl.TILL_PARAM}, value = "t")
    public long till;

    public static SplitChange create(long since, long till, List<Split> splits) {
        SplitChange splitChange = new SplitChange();
        splitChange.since = since;
        splitChange.till = till;
        splitChange.splits = splits;
        return splitChange;
    }
}
