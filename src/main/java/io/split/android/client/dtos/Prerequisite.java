package io.split.android.client.dtos;

import com.google.gson.annotations.SerializedName;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class Prerequisite {

    @SerializedName("n")
    private String name;

    @SerializedName("ts")
    private Set<String> treatments;

    public Prerequisite() {
    }

    public Prerequisite(String name, Set<String> treatments) {
        this.name = name;
        this.treatments = treatments;
    }

    public String getFlagName() {
        String str = this.name;
        return str == null ? "" : str;
    }

    public Set<String> getTreatments() {
        Set<String> set = this.treatments;
        return set == null ? new HashSet() : set;
    }
}
