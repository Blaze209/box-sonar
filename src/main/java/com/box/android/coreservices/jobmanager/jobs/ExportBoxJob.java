package com.box.android.coreservices.jobmanager.jobs;

import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.R;
import com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection;
import com.box.android.coreservices.jobmanager.tasks.BoxTask;
import com.box.android.coreservices.jobmanager.tasks.ExportTask;
import com.box.android.coreservices.jobmanager.tasks.PrepareExportTask;
import com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;
import com.box.android.coreservices.models.CustomBoxSession;
import com.box.android.coreservices.services.NotificationServices;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class ExportBoxJob extends BoxItemTransferJob {
    public static final String TYPE = "exportJob";
    protected transient boolean mShouldShowErrorDialog;

    public ExportBoxJob() {
    }

    public ExportBoxJob(MoCoContainerBuilder.MoCoContainer moCoContainer, BoxJobCollection boxJobCollection, BoxItem boxItem, NotificationServices notificationServices, BoxExtendedApiFolder boxExtendedApiFolder, IMoCoBoxTransfers iMoCoBoxTransfers, String str, String str2, boolean z) {
        ArrayList arrayList;
        super(TYPE, moCoContainer, boxJobCollection, boxItem);
        this.mShouldShowErrorDialog = false;
        ArrayList arrayList2 = new ArrayList(1);
        CustomBoxSession customBoxSession = (CustomBoxSession) this.mMoCoContainer.getUserContextManager().getBoxSession(ApplicationProvider.getApplication());
        String sharedLink = customBoxSession.getSharedLink();
        String password = customBoxSession.getPassword();
        if (boxItem instanceof BoxFile) {
            if (!SupportedFileExtensions.INSTANCE.isBoxNoteExtension(CommonBoxUtil.getFileExtension(boxItem.getName(), ""))) {
                addApplicableTasks((BoxFile) boxItem, arrayList2, new File(str2 + File.separator + str), z, sharedLink, password);
                arrayList = arrayList2;
            } else {
                arrayList = arrayList2;
                notificationServices.displayToast(R.string.box_notes_cannot_be_downloaded, ApplicationProvider.getApplication().getApplicationContext());
            }
        } else {
            arrayList = arrayList2;
            if (boxItem instanceof BoxFolder) {
                arrayList.add(new PrepareExportTask(moCoContainer, this, (BoxFolder) boxItem, boxExtendedApiFolder, iMoCoBoxTransfers, str2, z));
            }
        }
        addTasks(arrayList);
    }

    public void addApplicableTasks(BoxFile boxFile, List<BoxTask> list, File file, boolean z, String str, String str2) {
        if (SupportedFileExtensions.INSTANCE.isBoxNoteExtension(CommonBoxUtil.getFileExtension(boxFile.getName(), ""))) {
            this.mShouldShowErrorDialog = true;
            return;
        }
        if (!boxFile.getPermissions().contains(BoxItem.Permission.CAN_DOWNLOAD)) {
            this.mShouldShowErrorDialog = true;
        }
        ExportTask exportTask = new ExportTask(this.mMoCoContainer, this, boxFile, file, z);
        exportTask.setSharedLinkPassword(str2);
        exportTask.setSharedLink(str);
        exportTask.saveToLevelDB();
        list.add(exportTask);
    }

    public boolean shouldShowErrorDialog() {
        return this.mShouldShowErrorDialog;
    }
}
