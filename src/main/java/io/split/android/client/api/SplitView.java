package io.split.android.client.api;

import io.split.android.client.dtos.Prerequisite;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class SplitView {
    public long changeNumber;
    public Map<String, String> configs;
    public String defaultTreatment;
    public boolean impressionsDisabled;
    public boolean killed;
    public String name;
    public String trafficType;
    public List<String> treatments;
    public List<String> sets = new ArrayList();
    public List<Prerequisite> prerequisites = new ArrayList();
}
