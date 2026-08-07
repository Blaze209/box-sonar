package com.box.android.coreservices.jobmanager.tasks;

import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.coreservices.jobmanager.JobItem;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.jobs.BoxJob;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;
import com.box.androidsdk.content.models.BoxBookmark;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxSharedLinkSession;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.util.concurrent.ExecutionException;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BoxItemTask extends BoxTask implements JobItem.BoxItemJobItem {
    public static final String ITEM_ID = "mItemId";
    public static final String ITEM_TYPE = "mItemType";
    public static final String SHARED_LINK = "mSharedLink";
    public static final String SHARED_LINK_PASSWORD = "mSharedLinkPassword";
    protected transient BoxItem mBoxItem;
    protected long mProgress;
    protected long mProgressMax;

    protected BoxItemTask() {
        this.mProgress = -1L;
        this.mProgressMax = -1L;
    }

    protected BoxItemTask(String str, String str2, BoxItem boxItem, MoCoContainerBuilder.MoCoContainer moCoContainer, BoxJob boxJob) {
        super(str, str2, moCoContainer, boxJob);
        this.mProgress = -1L;
        this.mProgressMax = -1L;
        if (boxItem != null) {
            setItemId(boxItem.getUserId());
            setItemType(boxItem.getType());
        }
        init(moCoContainer, boxJob);
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem.BoxItemJobItem
    public String getItemId() {
        return (String) this.mProperties.get(ITEM_ID);
    }

    public void setItemId(String str) {
        this.mProperties.put(ITEM_ID, str);
    }

    public String getItemType() {
        return (String) this.mProperties.get(ITEM_TYPE);
    }

    public void setItemType(String str) {
        this.mProperties.put(ITEM_TYPE, str);
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxTask, com.box.android.coreservices.jobmanager.JobItem, com.box.android.coreservices.jobmanager.JobItemJsonEntity, com.box.android.coreservices.models.BoxPersistableObject
    protected void parseJSONMember(JsonObject.Member member) {
        String name = member.getName();
        JsonValue value = member.getValue();
        if (name.equals(ITEM_ID)) {
            setItemId(value.asString());
        } else if (name.equals(ITEM_TYPE)) {
            setItemType(value.asString());
        } else {
            super.parseJSONMember(member);
        }
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxTask
    public void init(MoCoContainerBuilder.MoCoContainer moCoContainer, BoxJob boxJob) {
        super.init(moCoContainer, boxJob);
        if (this.mBoxItem == null && StringUtils.isNotBlank(getItemId())) {
            try {
                if (getItemType().equalsIgnoreCase("file")) {
                    this.mBoxItem = (BoxItem) moCoContainer.getBaseModelController().performLocal(moCoContainer.getFileApi().getInfoRequest(getItemId()), null).get().getResult();
                } else if (getItemType().equalsIgnoreCase("folder")) {
                    this.mBoxItem = (BoxItem) moCoContainer.getBaseModelController().performLocal(moCoContainer.getFolderApi().getInfoRequest(getItemId()), null).get().getResult();
                } else if (getItemType().equalsIgnoreCase(BoxBookmark.TYPE)) {
                    this.mBoxItem = (BoxItem) moCoContainer.getBaseModelController().performLocal(moCoContainer.getWeblinkApi().getInfoRequest(getItemId()), null).get().getResult();
                }
            } catch (InterruptedException e) {
                BoxLogUtils.logException(e);
                Thread.currentThread().interrupt();
            } catch (ExecutionException e2) {
                BoxLogUtils.logException(e2);
            }
        }
    }

    public BoxItem getItem() {
        return this.mBoxItem;
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    public String getTitle() {
        BoxItem boxItem = this.mBoxItem;
        if (boxItem != null) {
            return boxItem.getName();
        }
        return "";
    }

    public ProgressReporter.ProgressType[] getSupportedProgressTypes() {
        return new ProgressReporter.ProgressType[]{ProgressReporter.ProgressType.NUM_TASKS};
    }

    public long getProgress(ProgressReporter.ProgressType progressType) {
        if (!isSupportedProgressType(progressType)) {
            return -3L;
        }
        if (this.mTask == null) {
            return -1L;
        }
        if (this.mTask.isDone() || this.mTask.isCancelled()) {
            return this.mProgress;
        }
        return -1L;
    }

    public long getMax(ProgressReporter.ProgressType progressType) {
        if (!isSupportedProgressType(progressType)) {
            return -3L;
        }
        if (this.mTask == null) {
            return -1L;
        }
        if (this.mTask.isDone() || this.mTask.isCancelled()) {
            return this.mProgressMax;
        }
        return -1L;
    }

    protected boolean isSupportedProgressType(ProgressReporter.ProgressType progressType) {
        boolean z = false;
        for (ProgressReporter.ProgressType progressType2 : getSupportedProgressTypes()) {
            if (progressType == progressType2) {
                z = true;
            }
        }
        return z;
    }

    public void setSharedLinkPassword(String str) {
        this.mProperties.put(SHARED_LINK_PASSWORD, str);
    }

    public void setSharedLink(String str) {
        this.mProperties.put(SHARED_LINK, str);
    }

    public String getSharedLink() {
        return (String) this.mProperties.get(SHARED_LINK);
    }

    public String getSharedLinkPassword() {
        return (String) this.mProperties.get(SHARED_LINK_PASSWORD);
    }

    protected BoxSession createSharedLinkSession() {
        BoxSharedLinkSession boxSharedLinkSession = new BoxSharedLinkSession(this.mMoCoContainer.getUserContextManager().getBoxSession(ApplicationProvider.getApplication()));
        boxSharedLinkSession.setSharedLink(getSharedLink());
        boxSharedLinkSession.setPassword(getSharedLinkPassword());
        return boxSharedLinkSession;
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxTask
    protected void handleCancelProgress() {
        reportProgressUpdated(this, ProgressReporter.ProgressType.NUM_TASKS, 0L, 0L);
    }
}
