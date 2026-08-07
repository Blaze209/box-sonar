package sdk.pendo.io.models;

import sdk.pendo.io.b0.c;
import sdk.pendo.io.s7.e0;

/* JADX INFO: loaded from: classes4.dex */
public class StepLocationModel {

    @c("featureLocationId")
    private String mFeatureLocationId;

    @c("featureSelector")
    private String mFeatureSelector;

    @c("gravity")
    private String mGravity;

    @c("pageLocationId")
    private String mPageLocationId;

    @c("pageSelector")
    private String mPageSelector;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            StepLocationModel stepLocationModel = (StepLocationModel) obj;
            if (e0.a(this.mPageSelector, stepLocationModel.mPageSelector) && e0.a(this.mFeatureSelector, stepLocationModel.mFeatureSelector) && e0.a(this.mFeatureLocationId, stepLocationModel.mFeatureLocationId) && e0.a(this.mPageLocationId, stepLocationModel.mPageLocationId) && e0.a(this.mGravity, stepLocationModel.mGravity)) {
                return true;
            }
        }
        return false;
    }

    public String getFeatureSelector() {
        return this.mFeatureSelector;
    }

    public String getGravity() {
        return this.mGravity;
    }

    public int hashCode() {
        return e0.a(this.mPageSelector, this.mFeatureSelector, this.mFeatureLocationId, this.mPageLocationId, this.mGravity);
    }

    public void setFeatureSelector(String str) {
        this.mFeatureSelector = str;
    }
}
