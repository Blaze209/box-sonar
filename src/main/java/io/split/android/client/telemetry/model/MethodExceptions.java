package io.split.android.client.telemetry.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class MethodExceptions {

    @SerializedName("tr")
    private long track;

    @SerializedName("t")
    private long treatment;

    @SerializedName("tc")
    private long treatmentWithConfig;

    @SerializedName("ts")
    private long treatments;

    @SerializedName("tf")
    private long treatmentsByFlagSet;

    @SerializedName("tfs")
    private long treatmentsByFlagSets;

    @SerializedName("tcs")
    private long treatmentsWithConfig;

    @SerializedName("tcf")
    private long treatmentsWithConfigByFlagSet;

    @SerializedName("tcfs")
    private long treatmentsWithConfigByFlagSets;

    public long getTreatment() {
        return this.treatment;
    }

    public void setTreatment(long treatment) {
        this.treatment = treatment;
    }

    public long getTreatments() {
        return this.treatments;
    }

    public void setTreatments(long treatments) {
        this.treatments = treatments;
    }

    public long getTreatmentWithConfig() {
        return this.treatmentWithConfig;
    }

    public void setTreatmentWithConfig(long treatmentWithConfig) {
        this.treatmentWithConfig = treatmentWithConfig;
    }

    public long getTreatmentsWithConfig() {
        return this.treatmentsWithConfig;
    }

    public void setTreatmentsWithConfig(long treatmentsWithConfig) {
        this.treatmentsWithConfig = treatmentsWithConfig;
    }

    public void setTreatmentsByFlagSet(long treatmentsByFlagSet) {
        this.treatmentsByFlagSet = treatmentsByFlagSet;
    }

    public long getTreatmentsByFlagSet() {
        return this.treatmentsByFlagSet;
    }

    public void setTreatmentsByFlagSets(long treatmentsByFlagSets) {
        this.treatmentsByFlagSets = treatmentsByFlagSets;
    }

    public long getTreatmentsByFlagSets() {
        return this.treatmentsByFlagSets;
    }

    public void setTreatmentsWithConfigByFlagSet(long treatmentsWithConfigByFlagSet) {
        this.treatmentsWithConfigByFlagSet = treatmentsWithConfigByFlagSet;
    }

    public long getTreatmentsWithConfigByFlagSet() {
        return this.treatmentsWithConfigByFlagSet;
    }

    public void setTreatmentsWithConfigByFlagSets(long treatmentsWithConfigByFlagSets) {
        this.treatmentsWithConfigByFlagSets = treatmentsWithConfigByFlagSets;
    }

    public long getTreatmentsWithConfigByFlagSets() {
        return this.treatmentsWithConfigByFlagSets;
    }

    public long getTrack() {
        return this.track;
    }

    public void setTrack(long track) {
        this.track = track;
    }
}
