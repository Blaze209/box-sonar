package com.box.android.activities.tasks;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.application.BoxBaseApplication;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxResponseMessage;
import com.box.android.coreservices.modelcontroller.messages.Controller;
import com.box.android.domain.mappers.FileModelMapper;
import com.box.android.domain.mappers.FolderModelMapper;
import com.box.android.domain.mappers.WebLinkModelMapper;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.FileUploadDomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.services.IUpdateItemInfoService;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxBookmark;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.requests.BoxRequestItemUpdate;
import com.box.androidsdk.content.requests.BoxRequestsBookmark;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.requests.BoxRequestsFolder;
import com.box.androidsdk.content.utils.BoxItemUtility;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiWeblink;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* JADX INFO: loaded from: classes9.dex */
public class RenameTaskActivity extends Hilt_RenameTaskActivity implements View.OnClickListener {
    private TextView mErrorText;
    private RenameTask mRenameTask;

    @Inject
    public IUpdateItemInfoService updateItemInfoService;

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }

    public static abstract class RenameTask {
        private final TextWatcher anyTextWatcher;
        private long conflictFetchRequestId;
        private final HashMap<String, Boolean> existingConflictNames = new HashMap<>();
        private String fileNameExtension;
        protected BoxExtendedApiWeblink mBoxApiBookmark;
        protected BoxExtendedApiFile mBoxExtendedApiFile;
        protected BoxExtendedApiFolder mBoxExtendedApiFolder;
        protected IBaseModelController mController;
        private boolean mErrorCausedByChar;
        private char mErrorChar;
        private final BoxItem mItemToRename;
        private final EditText mRenameEditText;
        public IUpdateItemInfoService updateItemInfoService;

        protected abstract void broadcastDismissSpinner();

        protected abstract void handleResultError(Result.Error<DomainError> error, ItemType itemType, String str);

        protected abstract void onCheckTextError(String str);

        protected abstract void onCheckTextSuccess();

        protected abstract void onRenameFail(String str);

        protected abstract void onRenameSuccess();

        protected abstract void setOKEnabled(boolean z);

        protected abstract void showRenamingSpinner();

        protected RenameTask(BoxItem boxItem, EditText editText, IBaseModelController iBaseModelController, BoxExtendedApiFolder boxExtendedApiFolder, IUpdateItemInfoService iUpdateItemInfoService, BoxExtendedApiFile boxExtendedApiFile, BoxExtendedApiWeblink boxExtendedApiWeblink) {
            int iLastIndexOf;
            this.fileNameExtension = "";
            TextWatcher textWatcher = new TextWatcher() { // from class: com.box.android.activities.tasks.RenameTaskActivity.RenameTask.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    RenameTask.this.checkText();
                }
            };
            this.anyTextWatcher = textWatcher;
            this.mErrorChar = ' ';
            this.mErrorCausedByChar = false;
            this.mController = iBaseModelController;
            this.mBoxExtendedApiFile = boxExtendedApiFile;
            this.mBoxExtendedApiFolder = boxExtendedApiFolder;
            this.mBoxApiBookmark = boxExtendedApiWeblink;
            this.mItemToRename = boxItem;
            this.updateItemInfoService = iUpdateItemInfoService;
            this.mRenameEditText = editText;
            String name = boxItem.getName();
            String id = boxItem.getParent() == null ? null : boxItem.getParent().getUserId();
            if (id != null) {
                this.conflictFetchRequestId = iBaseModelController.performRemote(boxExtendedApiFolder.getFolderWithAllItems(id)).getRequestId();
            }
            if ((boxItem instanceof BoxFile) && (iLastIndexOf = name.lastIndexOf(".")) > 0) {
                this.fileNameExtension = name.substring(iLastIndexOf).trim();
            }
            editText.addTextChangedListener(textWatcher);
        }

        public void processBoxMessage(BoxMessage<?> boxMessage) {
            if (boxMessage instanceof BoxResponseMessage) {
                BoxResponseMessage boxResponseMessage = (BoxResponseMessage) boxMessage;
                if (boxMessage.getRequestId() == this.conflictFetchRequestId && boxMessage.getAction().equals(BoxRequestsFolder.GetFolderWithAllItems.class.getName())) {
                    if (boxResponseMessage.wasSuccessful()) {
                        onFetchedConflictList((BoxFolder) boxResponseMessage.getResponse().getResult());
                    }
                } else if ((boxResponseMessage.getRequest() instanceof BoxRequestItemUpdate) && ((BoxRequestItemUpdate) boxResponseMessage.getRequest()).getId().equals(this.mItemToRename.getUserId())) {
                    broadcastDismissSpinner();
                    if (boxResponseMessage.getResponse().isSuccess()) {
                        onRenameSuccess();
                    } else {
                        onRenameFail(String.format(CommonBoxUtil.LS(boxResponseMessage.getErrorStringRId(boxResponseMessage.getRequest() instanceof BoxRequestsFolder.UpdateFolder ? BoxMessage.Scenario.RENAME_FOLDER : BoxMessage.Scenario.RENAME_FILE, R.string.check_connection_try_again, R.string.rename_error_genericerror)), this.mRenameEditText.getText().toString().trim()));
                    }
                }
            }
        }

        public void onFetchedConflictList(BoxFolder boxFolder) {
            if (boxFolder.getUserId().equals(this.mItemToRename.getParent() == null ? null : this.mItemToRename.getParent().getUserId())) {
                for (BoxItem boxItem : boxFolder.getItemCollection()) {
                    if (!boxItem.getUserId().equals(this.mItemToRename.getUserId())) {
                        this.existingConflictNames.put(boxItem.getName().toLowerCase(Locale.US), true);
                    }
                }
                checkText();
            }
        }

        public void doRename(String str) {
            final ItemId itemId;
            final String str2 = str + this.fileNameExtension;
            showRenamingSpinner();
            BoxItem boxItem = this.mItemToRename;
            if (boxItem instanceof BoxFolder) {
                itemId = FolderModelMapper.INSTANCE.toFolderModel((BoxFolder) this.mItemToRename, false).getItemId();
            } else if (boxItem instanceof BoxBookmark) {
                itemId = WebLinkModelMapper.INSTANCE.toWebLinkModel((BoxBookmark) this.mItemToRename, false).getItemId();
            } else {
                itemId = FileModelMapper.INSTANCE.toFileModel((BoxFile) this.mItemToRename, false).getItemId();
            }
            this.updateItemInfoService.updateItemInfo(itemId, str2, null, new Continuation<Result<? extends ItemModel, ? extends DomainError>>() { // from class: com.box.android.activities.tasks.RenameTaskActivity.RenameTask.2
                @Override // kotlin.coroutines.Continuation
                /* JADX INFO: renamed from: getContext */
                public CoroutineContext get$context() {
                    return EmptyCoroutineContext.INSTANCE;
                }

                @Override // kotlin.coroutines.Continuation
                public void resumeWith(Object obj) {
                    if (obj instanceof Result.Success) {
                        RenameTask.this.onRenameSuccess();
                    } else if (obj instanceof Result.Error) {
                        RenameTask.this.handleResultError((Result.Error) obj, itemId.getType(), str2);
                    }
                    RenameTask.this.broadcastDismissSpinner();
                }
            });
        }

        public String getFileExtension() {
            return this.fileNameExtension;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void checkText() {
            String strLS;
            String strTrim = this.mRenameEditText.getText().toString().trim();
            if (this.existingConflictNames.get((strTrim + this.fileNameExtension).toLowerCase(Locale.US)) != null) {
                if (this.mItemToRename instanceof BoxFolder) {
                    strLS = CommonBoxUtil.LS(R.string.A_folder_is_already_named_this);
                } else {
                    strLS = CommonBoxUtil.LS(R.string.LS_A_file_is_alrea);
                }
                this.mErrorCausedByChar = false;
            } else if (!CommonBoxUtil.isFilenameValidForSD(strTrim) && !strTrim.equalsIgnoreCase("")) {
                if (strTrim.contains("/")) {
                    this.mErrorChar = '/';
                } else if (strTrim.contains("\\")) {
                    this.mErrorChar = '\\';
                } else if (!this.mErrorCausedByChar) {
                    this.mErrorChar = strTrim.charAt(strTrim.length() - 1);
                }
                strLS = String.format(Locale.US, "%s '%s'", CommonBoxUtil.LS(R.string.LS_Unsupported_character), Character.valueOf(this.mErrorChar));
                this.mErrorCausedByChar = true;
            } else if (TextUtils.isEmpty(strTrim)) {
                this.mErrorCausedByChar = false;
                strLS = "";
            } else {
                strLS = null;
            }
            if (strLS == null) {
                onCheckTextSuccess();
                setOKEnabled(true);
                this.mErrorCausedByChar = false;
            } else {
                onCheckTextError(strLS);
                setOKEnabled(false);
            }
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void processBoxMessage(BoxMessage<?> boxMessage) {
        super.processBoxMessage(boxMessage);
        this.mRenameTask.processBoxMessage(boxMessage);
    }

    private RenameTask buildRenameTask(final BoxItem boxItem, EditText editText) {
        return new RenameTask(boxItem, editText, this.mBaseMoco, this.mBoxExtendedApiFolder, this.updateItemInfoService, this.mBoxExtendedApiFile, this.mBoxApiBookmark) { // from class: com.box.android.activities.tasks.RenameTaskActivity.1
            @Override // com.box.android.activities.tasks.RenameTaskActivity.RenameTask
            protected void onRenameSuccess() {
                RenameTaskActivity.this.setResult(-1);
                RenameTaskActivity.this.finish();
                BoxPresentationUtils.displayToast(String.format(CommonBoxUtil.LS(Objects.equals(boxItem.getType(), ItemType.FOLDER.getValue()) ? R.string.folder_rename_successful : R.string.file_rename_successful), boxItem.getName()), RenameTaskActivity.this);
            }

            @Override // com.box.android.activities.tasks.RenameTaskActivity.RenameTask
            protected void handleResultError(Result.Error<DomainError> error, ItemType itemType, String str) {
                DomainError value = error.getValue();
                int i = itemType == ItemType.FOLDER ? R.string.folder_rename_error_duplicate_name : R.string.file_rename_error_duplicate_name;
                if (!(value instanceof FileUploadDomainError.NameExistsErr)) {
                    if (value instanceof FileUploadDomainError.AccessDeniedError) {
                        i = R.string.rename_error_forbidden;
                    } else {
                        i = value instanceof DomainError.NoConnectivityError ? R.string.check_connection_try_again : R.string.rename_error_genericerror;
                    }
                }
                onRenameFail(String.format(CommonBoxUtil.LS(i), str));
            }

            @Override // com.box.android.activities.tasks.RenameTaskActivity.RenameTask
            protected void onRenameFail(String str) {
                BoxPresentationUtils.displayToast(str, BoxBaseApplication.getInstance().getApplicationContext());
            }

            @Override // com.box.android.activities.tasks.RenameTaskActivity.RenameTask
            protected void setOKEnabled(boolean z) {
                ((Button) RenameTaskActivity.this.findViewById(R.id.btnOK)).setEnabled(z);
            }

            @Override // com.box.android.activities.tasks.RenameTaskActivity.RenameTask
            protected void onCheckTextError(String str) {
                RenameTaskActivity.this.mErrorText.setText(str);
            }

            @Override // com.box.android.activities.tasks.RenameTaskActivity.RenameTask
            protected void onCheckTextSuccess() {
                RenameTaskActivity.this.mErrorText.setText("");
            }

            @Override // com.box.android.activities.tasks.RenameTaskActivity.RenameTask
            protected void showRenamingSpinner() {
                RenameTaskActivity.this.showSpinner(CommonBoxUtil.LS(R.string.LS_Renaming___), false);
            }

            @Override // com.box.android.activities.tasks.RenameTaskActivity.RenameTask
            protected void broadcastDismissSpinner() {
                RenameTaskActivity.this.broadcastDismissSpinner();
            }
        };
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return Integer.valueOf(R.layout.layout_edittext_dialog);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxCreate(Bundle bundle) {
        String strLS;
        super.onBoxCreate(bundle);
        getIntent().setExtrasClassLoader(getClassLoader());
        BoxItem boxItem = (BoxItem) getIntent().getSerializableExtra(Controller.ARG_BOXITEM);
        if (boxItem == null) {
            finish();
            return;
        }
        String name = boxItem.getName();
        EditText editText = (EditText) findViewById(R.id.dialog_edit_text);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.box.android.activities.tasks.RenameTaskActivity.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                View viewFindViewById = RenameTaskActivity.this.findViewById(R.id.btnOK);
                if (i != 6 || viewFindViewById == null || !viewFindViewById.isEnabled()) {
                    return false;
                }
                RenameTaskActivity.this.doTask();
                return true;
            }
        });
        this.mRenameTask = buildRenameTask(boxItem, editText);
        if (boxItem instanceof BoxFolder) {
            strLS = CommonBoxUtil.LS(R.string.Rename_Folder);
        } else if (boxItem instanceof BoxFile) {
            strLS = CommonBoxUtil.LS(R.string.Rename_File);
            int iLastIndexOf = name.lastIndexOf(".");
            if (iLastIndexOf > 0) {
                name = name.substring(0, iLastIndexOf);
                ((TextView) findViewById(R.id.dialog_extension_text)).setText(this.mRenameTask.getFileExtension());
                findViewById(R.id.dialog_extension_text).setVisibility(0);
            }
        } else {
            strLS = CommonBoxUtil.LS(R.string.Rename_Bookmark);
        }
        setMainText(strLS, "", name, true);
        initializeButtons();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter = super.getIntentFilter();
        intentFilter.addAction(BoxRequestsFolder.GetFolderWithAllItems.class.getName());
        intentFilter.addAction(BoxRequestsFile.UpdateFile.class.getName());
        intentFilter.addAction(BoxRequestsFolder.UpdateFolder.class.getName());
        intentFilter.addAction(BoxRequestsBookmark.UpdateBookmark.class.getName());
        return intentFilter;
    }

    public static Intent getLaunchIntent(Context context, BoxItem boxItem) {
        Intent intent = new Intent(context, (Class<?>) RenameTaskActivity.class);
        if (boxItem instanceof BoxFolder) {
            boxItem = BoxItemUtility.copyFolderWithNoItems((BoxFolder) boxItem);
        }
        intent.putExtra(Controller.ARG_BOXITEM, boxItem);
        return intent;
    }

    private void setMainText(String str, String str2, String str3, boolean z) {
        TextView textView = (TextView) findViewById(R.id.dialog_title);
        this.mErrorText = (TextView) findViewById(R.id.error_text);
        EditText editText = (EditText) findViewById(R.id.dialog_edit_text);
        textView.setText(str);
        if (!z) {
            editText.setVisibility(8);
        } else {
            editText.setText(str3);
            editText.setSelection(str3.length());
        }
    }

    private void initializeButtons() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void doTask() {
        this.mRenameTask.doRename(((EditText) findViewById(R.id.dialog_edit_text)).getText().toString().trim());
    }
}
