package com.box.android.coreservices.jobmanager.jobcollections;

import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.R;
import com.box.android.coreservices.jobmanager.JobCollectionList;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.jobs.BoxJob;
import com.box.android.coreservices.jobmanager.jobs.ExportBoxJob;
import com.box.android.coreservices.jobmanager.tasks.BoxTask;
import com.box.android.coreservices.jobmanager.tasks.PrepareExportTask;
import com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.coreservices.services.NotificationServices;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxItem;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes9.dex */
public final class ExportBoxJobCollection extends TransferBoxJobCollection {
    public static final String DESTINATION_FOLDER_PATH = "mDestinationFolderPath";
    public static final String TYPE = "exportBoxJobCollection";
    private transient boolean mHasShownErrorDialog;
    private IntentServices mIntentServices;
    private NotificationServices mNotificationServices;

    @Override // com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection
    public boolean shouldAppearInNotifCenter() {
        return false;
    }

    @Override // com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection
    public boolean shouldAutoClear() {
        return false;
    }

    @Override // com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection
    public boolean shouldDisplayCompleteTransferToast() {
        return false;
    }

    @Override // com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection
    public boolean shouldDisplayStartTransferToast() {
        return false;
    }

    public ExportBoxJobCollection(MoCoContainerBuilder.MoCoContainer moCoContainer, JobCollectionList jobCollectionList, BoxFile boxFile, IntentServices intentServices, NotificationServices notificationServices, BoxExtendedApiFolder boxExtendedApiFolder, IMoCoBoxTransfers iMoCoBoxTransfers, String str, String str2, boolean z) {
        super(TYPE, moCoContainer, jobCollectionList);
        this.mHasShownErrorDialog = false;
        this.mIntentServices = intentServices;
        this.mNotificationServices = notificationServices;
        setDestinationFolderPath(str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ExportBoxJob(moCoContainer, this, boxFile, notificationServices, boxExtendedApiFolder, iMoCoBoxTransfers, str, str2, z));
        addJobs(arrayList);
    }

    public ExportBoxJobCollection(MoCoContainerBuilder.MoCoContainer moCoContainer, IntentServices intentServices, NotificationServices notificationServices, BoxExtendedApiFolder boxExtendedApiFolder, IMoCoBoxTransfers iMoCoBoxTransfers, JobCollectionList jobCollectionList, Collection<BoxItem> collection, String str) {
        super(TYPE, moCoContainer, jobCollectionList);
        this.mIntentServices = intentServices;
        this.mNotificationServices = notificationServices;
        String str2 = str;
        setDestinationFolderPath(str2);
        ArrayList arrayList = new ArrayList();
        for (BoxItem boxItem : collection) {
            ExportBoxJob exportBoxJob = new ExportBoxJob(moCoContainer, this, boxItem, notificationServices, boxExtendedApiFolder, iMoCoBoxTransfers, boxItem.getName(), str2, false);
            if (exportBoxJob.getTasks() != null && exportBoxJob.getTasks().size() >= 1) {
                arrayList.add(exportBoxJob);
            }
            str2 = str;
        }
        if (arrayList.size() < 1) {
            reportCompleted(this);
        }
        if (arrayList.size() == 1) {
            Iterator<BoxTask> it = arrayList.get(0).getTasks().iterator();
            while (it.hasNext()) {
                if (!(it.next() instanceof PrepareExportTask)) {
                    this.mHasShownErrorDialog = true;
                }
            }
        }
        addJobs(arrayList);
    }

    public ExportBoxJobCollection() {
    }

    private void showErrorDialog() {
        if (this.mHasShownErrorDialog) {
            return;
        }
        Iterator<BoxJob> it = getJobs().iterator();
        while (it.hasNext()) {
            if (((ExportBoxJob) it.next()).shouldShowErrorDialog()) {
                this.mNotificationServices.displayDialog(CommonBoxUtil.LS(R.string.unable_to_download_files_title), CommonBoxUtil.LS(R.string.unable_to_download_files_message), CommonBoxUtil.LS(R.string.LO_Continue));
                this.mHasShownErrorDialog = true;
                return;
            }
        }
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    protected void reportStarted(ProgressReporter progressReporter) {
        showErrorDialog();
        super.reportStarted(progressReporter);
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    protected void reportCompleted(ProgressReporter progressReporter) {
        showErrorDialog();
        super.reportCompleted(progressReporter);
    }

    @Override // com.box.android.coreservices.jobmanager.jobcollections.TransferBoxJobCollection, com.box.android.coreservices.jobmanager.ParentJobItem
    public String getDescription() {
        if (isSuccessfullyCompleted()) {
            return String.format(CommonBoxUtil.plural(R.array.export_completed_description, getJobs().size()), Integer.valueOf(getJobs().size()), new File(getDestinationFolderPath()).getName());
        }
        return super.getDescription();
    }

    @Override // com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection
    protected int getInProgressTitleResId() {
        return R.array.Downloading_item_and_n_other_items;
    }

    @Override // com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection
    protected int getCompletedTitleResId() {
        return R.array.Downloaded_item_and_n_other_items;
    }

    @Override // com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection
    protected int getErrorTextResId() {
        return R.array.N_items_failed_to_download;
    }

    public String getDestinationFolderPath() {
        return (String) this.mProperties.get("mDestinationFolderPath");
    }

    public void setDestinationFolderPath(String str) {
        this.mProperties.put("mDestinationFolderPath", str);
    }

    @Override // com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection, com.box.android.coreservices.jobmanager.ParentJobItem, com.box.android.coreservices.jobmanager.JobItem, com.box.android.coreservices.jobmanager.JobItemJsonEntity, com.box.android.coreservices.models.BoxPersistableObject
    protected void parseJSONMember(JsonObject.Member member) {
        String name = member.getName();
        JsonValue value = member.getValue();
        if (name.equals("mDestinationFolderPath")) {
            setDestinationFolderPath(value.asString());
        } else {
            super.parseJSONMember(member);
        }
    }
}
