package io.split.android.client.telemetry.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class MethodLatencies {

    @SerializedName("tr")
    private List<Long> track;

    @SerializedName("t")
    private List<Long> treatment;

    @SerializedName("tc")
    private List<Long> treatmentWithConfig;

    @SerializedName("ts")
    private List<Long> treatments;

    @SerializedName("tf")
    private List<Long> treatmentsByFlagSet;

    @SerializedName("tfs")
    private List<Long> treatmentsByFlagSets;

    @SerializedName("tcs")
    private List<Long> treatmentsWithConfig;

    @SerializedName("tcf")
    private List<Long> treatmentsWithConfigByFlagSet;

    @SerializedName("tcfs")
    private List<Long> treatmentsWithConfigByFlagSets;

    public List<Long> getTreatment() {
        return this.treatment;
    }

    public void setTreatment(List<Long> treatment) {
        this.treatment = treatment;
    }

    public List<Long> getTreatments() {
        return this.treatments;
    }

    public void setTreatments(List<Long> treatments) {
        this.treatments = treatments;
    }

    public List<Long> getTreatmentWithConfig() {
        return this.treatmentWithConfig;
    }

    public void setTreatmentWithConfig(List<Long> treatmentWithConfig) {
        this.treatmentWithConfig = treatmentWithConfig;
    }

    public List<Long> getTreatmentsWithConfig() {
        return this.treatmentsWithConfig;
    }

    public void setTreatmentsWithConfig(List<Long> treatmentsWithConfig) {
        this.treatmentsWithConfig = treatmentsWithConfig;
    }

    public void setTreatmentsByFlagSet(List<Long> treatmentsByFlagSet) {
        this.treatmentsByFlagSet = treatmentsByFlagSet;
    }

    public List<Long> getTreatmentsByFlagSet() {
        return this.treatmentsByFlagSet;
    }

    public void setTreatmentsByFlagSets(List<Long> treatmentsByFlagSets) {
        this.treatmentsByFlagSets = treatmentsByFlagSets;
    }

    public List<Long> getTreatmentsByFlagSets() {
        return this.treatmentsByFlagSets;
    }

    public void setTreatmentsWithConfigByFlagSet(List<Long> treatmentsWithConfigByFlagSet) {
        this.treatmentsWithConfigByFlagSet = treatmentsWithConfigByFlagSet;
    }

    public List<Long> getTreatmentsWithConfigByFlagSet() {
        return this.treatmentsWithConfigByFlagSet;
    }

    public void setTreatmentsWithConfigByFlagSets(List<Long> treatmentsWithConfigByFlagSets) {
        this.treatmentsWithConfigByFlagSets = treatmentsWithConfigByFlagSets;
    }

    public List<Long> getTreatmentsWithConfigByFlagSets() {
        return this.treatmentsWithConfigByFlagSets;
    }

    public List<Long> getTrack() {
        return this.track;
    }

    public void setTrack(List<Long> track) {
        this.track = track;
    }
}
