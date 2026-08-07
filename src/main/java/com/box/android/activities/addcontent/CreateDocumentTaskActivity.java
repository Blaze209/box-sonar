package com.box.android.activities.addcontent;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.base.presentation.utilities.IItemClickHandler;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxResponseMessage;
import com.box.android.coreservices.utilities.APIErrorStringProvider;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.domain.services.IBVEManager;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.android.localrepo.LocalFiles;
import com.box.android.utilities.ItemClickHandler;
import com.box.android.utilities.notificationmanager.BoxNotificationHelper;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIteratorItems;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.dao.BoxNoteCreation;
import com.box.boxandroidlibv2private.requests.BoxRequestCreateBoxNote;
import com.box.boxandroidlibv2private.requests.BoxRequestUploadFile;
import com.box.boxandroidlibv2private.requests.requestobjects.IBoxRequestUploadFileHelper;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import javax.inject.Inject;
import org.apache.commons.io.FileUtils;

/* JADX INFO: loaded from: classes9.dex */
public class CreateDocumentTaskActivity extends Hilt_CreateDocumentTaskActivity implements View.OnClickListener {
    public static final String EXTRA_ASSET_NAME = "assetName";
    public static final String EXTRA_FOLDER_ID = "folderId";
    private static final String TAG = "com.box.android.activities.addcontent.CreateDocumentTaskActivity";
    private BoxFolder boxFolder;

    @Inject
    protected IBVEManager bveManager;
    private EditText dialogEditText;
    private TextView errorText;
    private Handler handler;
    private ItemClickHandler itemClickHandler;

    @Inject
    protected ItemClickHandler.Factory itemClickHandlerFactory;
    private String mAssetName;
    private String mFolderId;
    private String mAssetExtension = "";
    private final TextWatcher anyTextWatcher = new TextWatcher() { // from class: com.box.android.activities.addcontent.CreateDocumentTaskActivity.4
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            CreateDocumentTaskActivity.this.checkText();
        }
    };

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return Integer.valueOf(R.layout.layout_edittext_dialog);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        this.handler = new Handler(Looper.getMainLooper());
        this.itemClickHandler = this.itemClickHandlerFactory.create((AppCompatActivity) this);
        this.mFolderId = getIntent().getStringExtra("folderId");
        this.mAssetName = getIntent().getStringExtra(EXTRA_ASSET_NAME);
        ((Button) findViewById(R.id.btnOK)).setText(CommonBoxUtil.LS(R.string.create));
        String str = this.mAssetName;
        if (str != null) {
            this.mAssetExtension = str.substring(str.lastIndexOf(".") + 1).toLowerCase(Locale.US);
            ((TextView) findViewById(R.id.dialog_extension_text)).setText("." + this.mAssetExtension);
            ((TextView) findViewById(R.id.dialog_extension_text)).setVisibility(0);
        }
        final String strLS = CommonBoxUtil.LS(R.string.create_document_named);
        try {
            this.boxFolder = (BoxFolder) this.mBaseMoco.performLocal(this.mBoxExtendedApiFolder.getFolderWithAllItems(this.mFolderId)).get().getResult();
        } catch (InterruptedException e) {
            BoxLogUtils.e(TAG, "Thread was interrupted", e);
            Thread.currentThread().interrupt();
            this.boxFolder = null;
        } catch (Exception unused) {
            this.boxFolder = null;
        }
        if (this.boxFolder == null) {
            showSpinner(CommonBoxUtil.LS(R.string.creating_dot_dot_dot));
            new Thread() { // from class: com.box.android.activities.addcontent.CreateDocumentTaskActivity.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        CreateDocumentTaskActivity createDocumentTaskActivity = CreateDocumentTaskActivity.this;
                        createDocumentTaskActivity.boxFolder = (BoxFolder) createDocumentTaskActivity.mBaseMoco.performRemote(CreateDocumentTaskActivity.this.mBoxExtendedApiFolder.getFolderWithAllItems(CreateDocumentTaskActivity.this.mFolderId)).get().getResult();
                    } catch (InterruptedException e2) {
                        BoxLogUtils.e(CreateDocumentTaskActivity.TAG, "Thread was interrupted", e2);
                        Thread.currentThread().interrupt();
                        CreateDocumentTaskActivity.this.boxFolder = null;
                    } catch (Exception unused2) {
                        CreateDocumentTaskActivity.this.boxFolder = null;
                    }
                    if (CreateDocumentTaskActivity.this.boxFolder == null) {
                        BoxNotificationHelper.displayDialog(CommonBoxUtil.LS(R.string.create_error_offline));
                        CreateDocumentTaskActivity.this.finish();
                    } else {
                        CreateDocumentTaskActivity.this.broadcastDismissSpinner();
                        CreateDocumentTaskActivity.this.handler.post(new Runnable() { // from class: com.box.android.activities.addcontent.CreateDocumentTaskActivity.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                CreateDocumentTaskActivity.this.setMainText(strLS, "", "");
                                CreateDocumentTaskActivity.this.initializeButtons();
                                CreateDocumentTaskActivity.this.checkText();
                                ((EditText) CreateDocumentTaskActivity.this.findViewById(R.id.dialog_edit_text)).requestFocus();
                            }
                        });
                    }
                }
            }.start();
        } else {
            setMainText(strLS, "", "");
            initializeButtons();
            checkText();
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxResume() {
        super.onBoxResume();
        if (this.boxFolder != null) {
            ((EditText) findViewById(R.id.dialog_edit_text)).requestFocus();
        }
    }

    public static Intent newCreateDocumentTask(Context context, String str, String str2) {
        Intent intent = new Intent(context, (Class<?>) CreateDocumentTaskActivity.class);
        intent.putExtra("folderId", str);
        intent.putExtra(EXTRA_ASSET_NAME, str2);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMainText(String str, String str2, String str3) {
        TextView textView = (TextView) findViewById(R.id.dialog_title);
        this.errorText = (TextView) findViewById(R.id.error_text);
        this.dialogEditText = (EditText) findViewById(R.id.dialog_edit_text);
        textView.setText(str);
        this.dialogEditText.setText(str3);
        this.dialogEditText.setSelection(str3.length());
        this.dialogEditText.setHint(CommonBoxUtil.LS(R.string.Enter_document_name));
        this.dialogEditText.addTextChangedListener(this.anyTextWatcher);
        this.dialogEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.box.android.activities.addcontent.CreateDocumentTaskActivity.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView2, int i, KeyEvent keyEvent) {
                View viewFindViewById = CreateDocumentTaskActivity.this.findViewById(R.id.btnOK);
                if (i != 6 || viewFindViewById == null || !viewFindViewById.isEnabled()) {
                    return false;
                }
                CreateDocumentTaskActivity.this.doTask();
                return true;
            }
        });
        if (getResources().getConfiguration().orientation == 1) {
            getWindow().setSoftInputMode(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initializeButtons() {
        findViewById(R.id.btnOK).setOnClickListener(this);
        findViewById(R.id.btnCancel).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnOK) {
            doTask();
        } else if (id == R.id.btnCancel) {
            finish();
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter = super.getIntentFilter();
        intentFilter.addAction(BoxRequestCreateBoxNote.class.getName());
        return intentFilter;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void processBoxMessage(BoxMessage<?> boxMessage) {
        if (boxMessage instanceof BoxResponseMessage) {
            BoxResponseMessage boxResponseMessage = (BoxResponseMessage) boxMessage;
            if (!(boxResponseMessage.getRequest() instanceof BoxRequestCreateBoxNote) || isFinishing()) {
                return;
            }
            BoxResponse response = boxResponseMessage.getResponse();
            BoxNoteCreation boxNoteCreation = (BoxNoteCreation) response.getResult();
            if (response.isSuccess() && boxNoteCreation.getSuccess() == Boolean.TRUE) {
                logCreationSuccess(response);
                this.itemClickHandler.onFileClick(boxNoteCreation.getNewNote(), new IItemClickHandler.FileClickConfig(PreviewSource.Browse.INSTANCE, null, null, null, null, null, null, true, true));
                setResult(-1);
                finish();
                return;
            }
            if (response.getException() instanceof BoxException) {
                BoxException boxException = (BoxException) response.getException();
                if (BoxNoteCreation.ERROR_NAME_CONFLICT.equals(boxException.getMessage())) {
                    BoxPresentationUtils.displayToast(R.string.file_create_error_duplicate_name, this, new String[0]);
                } else if (boxException.getResponseCode() == 403) {
                    BoxPresentationUtils.displayToast(R.string.permission_denied_general, this, new String[0]);
                } else {
                    BoxPresentationUtils.displayToast(R.string.check_connection_try_again, this, new String[0]);
                }
            }
            broadcastDismissSpinner();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doTask() {
        final String strTrim = (this.dialogEditText.getText().toString().trim() + "." + this.mAssetExtension).trim();
        BoxIteratorItems<BoxItem> itemCollection = this.boxFolder.getItemCollection();
        if (itemCollection != null) {
            for (BoxItem boxItem : itemCollection) {
                if ((boxItem instanceof BoxFile) && boxItem.getName().toLowerCase(Locale.US).equals(strTrim)) {
                    BoxPresentationUtils.displayToast(R.string.file_create_error_duplicate_name, this, new String[0]);
                    return;
                }
            }
        }
        showSpinner(CommonBoxUtil.LS(R.string.creating_dot_dot_dot));
        if (SupportedFileExtensions.INSTANCE.isBoxNoteExtension(this.mAssetExtension)) {
            BoxAnalytics.INSTANCE.trackEvent("boxnote", PasskeyWebListener.CREATE_UNIQUE_KEY, "bytes", (Integer) 0);
            this.mBaseMoco.performRemote(this.mBoxApiPrivate.getBoxNoteCreation(this.mFolderId, strTrim, this.bveManager.getBaseUri()));
        } else {
            new Thread() { // from class: com.box.android.activities.addcontent.CreateDocumentTaskActivity.3
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        InputStream inputStreamOpen = CreateDocumentTaskActivity.this.getAssets().open(CreateDocumentTaskActivity.this.mAssetName);
                        try {
                            File fileCreateTempFile = File.createTempFile("create_doc_", null, ((LocalFiles) CreateDocumentTaskActivity.this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_FILES)).getDownloads().getTempDownloadDir());
                            fileCreateTempFile.deleteOnExit();
                            FileUtils.copyInputStreamToFile(inputStreamOpen, fileCreateTempFile);
                            BoxRequestUploadFile uploadFileRequest = CreateDocumentTaskActivity.this.mBoxExtendedApiFile.getUploadFileRequest(fileCreateTempFile, CreateDocumentTaskActivity.this.mFolderId, new IBoxRequestUploadFileHelper() { // from class: com.box.android.activities.addcontent.CreateDocumentTaskActivity.3.1
                                @Override // com.box.boxandroidlibv2private.requests.requestobjects.IBoxRequestUploadFileHelper
                                public void checkBasicError() throws BoxException {
                                }

                                @Override // com.box.boxandroidlibv2private.requests.requestobjects.IBoxRequestUploadFileHelper
                                public void addCustomProperties(HashMap<String, String> map) {
                                    map.put(BoxExtendedApiFile.ANALYTICS_PARAM_SOURCE_TYPE, IMoCoBoxTransfers.TransferSourceType.FILE_CREATE.name());
                                }
                            });
                            uploadFileRequest.setFileName(strTrim);
                            BoxResponse boxResponse = CreateDocumentTaskActivity.this.mBaseMoco.performRemote(uploadFileRequest).get();
                            CreateDocumentTaskActivity.this.broadcastDismissSpinner();
                            CreateDocumentTaskActivity.this.previewNewFile(boxResponse, strTrim);
                            CreateDocumentTaskActivity.this.finish();
                            if (inputStreamOpen != null) {
                                inputStreamOpen.close();
                            }
                        } catch (Throwable th) {
                            if (inputStreamOpen != null) {
                                try {
                                    inputStreamOpen.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    } catch (InterruptedException e) {
                        BoxLogUtils.e(CreateDocumentTaskActivity.TAG, "Thread was interrupted", e);
                        Thread.currentThread().interrupt();
                        CreateDocumentTaskActivity.this.boxFolder = null;
                    } catch (Exception e2) {
                        BoxLogUtils.logException(e2);
                        CreateDocumentTaskActivity.this.broadcastDismissSpinner();
                    }
                }
            }.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void previewNewFile(BoxResponse<BoxFile> boxResponse, String str) {
        if (boxResponse.isSuccess()) {
            logCreationSuccess(boxResponse);
            this.itemClickHandler.onFileClick((BoxFile) boxResponse.getResult(), new IItemClickHandler.FileClickConfig(PreviewSource.Browse.INSTANCE, null, null, null, null, null, str, true, true));
        } else {
            Exception exception = boxResponse.getException();
            if (exception instanceof BoxException) {
                BoxPresentationUtils.displayToast(APIErrorStringProvider.getInstance().getErrorStringRId(BoxMessage.Scenario.UPLOAD_FILE, (BoxException) exception), this, new String[0]);
            }
        }
    }

    private void logCreationSuccess(BoxResponse boxResponse) {
        BoxObject result = boxResponse.getResult();
        if (result instanceof BoxNoteCreation) {
            BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_CREATE_NEW_BOX_NOTE_SUCCEEDED);
        }
        if (result instanceof BoxFile) {
            String fileExtension = CommonBoxUtil.getFileExtension(((BoxFile) result).getName(), "");
            fileExtension.hashCode();
            switch (fileExtension) {
                case "txt":
                    BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_CREATE_NEW_TEXT_FILE_SUCCEEDED);
                    break;
                case "docx":
                    BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_CREATE_NEW_WORD_DOC_SUCCEEDED);
                    break;
                case "pptx":
                    BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_CREATE_NEW_POWERPOINT_SUCCEEDED);
                    break;
                case "xlsx":
                    BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_CREATE_NEW_EXCEL_SUCCEEDED);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkText() {
        String strTrim = this.dialogEditText.getText().toString().trim();
        String lowerCase = (strTrim + "." + this.mAssetExtension).trim().toLowerCase(Locale.US);
        Button button = (Button) findViewById(R.id.btnOK);
        if (TextUtils.isEmpty(strTrim)) {
            this.errorText.setVisibility(8);
            button.setEnabled(false);
            return;
        }
        String unsupportedCharacters = CommonBoxUtil.getUnsupportedCharacters(lowerCase);
        if (!TextUtils.isEmpty(unsupportedCharacters)) {
            this.errorText.setVisibility(0);
            this.errorText.setText(String.format(Locale.US, "%s '%s'", CommonBoxUtil.LS(R.string.LS_Unsupported_character), unsupportedCharacters));
            button.setEnabled(false);
        } else {
            this.errorText.setVisibility(8);
            button.setEnabled(true);
        }
    }
}
