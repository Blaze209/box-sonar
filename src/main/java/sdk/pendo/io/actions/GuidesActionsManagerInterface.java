package sdk.pendo.io.actions;

/* JADX INFO: loaded from: classes4.dex */
public interface GuidesActionsManagerInterface {
    void dismissVisibleGuides();

    void removeGuideFullyDisplayedAfterAnimation(String str);

    void setGuideFullyDisplayedAfterAnimation(String str);

    boolean wasGuideFullyDisplayedAfterAnimation(String str);
}
