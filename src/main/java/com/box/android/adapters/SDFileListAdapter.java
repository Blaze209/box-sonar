package com.box.android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.box.android.R;
import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.base.presentation.utilities.SupportedFileExtensionIcons;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.dao.FileInfo;
import com.box.android.data.service.impl.thumbnail.ThumbnailService;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.controller.IBrowseController;
import com.box.android.domain.identity.IUserContextManager;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class SDFileListAdapter extends ArrayAdapter<FileInfo> {
    protected final IBrowseController mBrowseController;
    private final boolean mDisableFiles;
    private final FeatureFlips mFeatureFlips;
    private final FileCheckedDelegate mFileCheckedDelegate;
    private final FolderSelectListener mFolderSelectListener;
    private final LayoutInflater mInflater;
    LocalThumbnailManager mThumbnailController;
    protected final ThumbnailService mThumbnailService;
    protected final IUserContextManager mUserContextManager;

    public interface FileCheckedDelegate {
        boolean isFileChecked(FileInfo fileInfo);
    }

    public interface FolderSelectListener {
        void onFolderCheckToggle(FileInfo fileInfo);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return true;
    }

    public SDFileListAdapter(Context context, List<FileInfo> list, boolean z, IBrowseController iBrowseController, IUserContextManager iUserContextManager, ThumbnailService thumbnailService, FeatureFlips featureFlips) {
        this(context, list, z, null, null, iBrowseController, iUserContextManager, thumbnailService, featureFlips);
    }

    public SDFileListAdapter(Context context, List<FileInfo> list, boolean z, FileCheckedDelegate fileCheckedDelegate, FolderSelectListener folderSelectListener, IBrowseController iBrowseController, IUserContextManager iUserContextManager, ThumbnailService thumbnailService, FeatureFlips featureFlips) {
        super(context, 0, list);
        this.mInflater = LayoutInflater.from(context);
        this.mDisableFiles = z;
        this.mFileCheckedDelegate = fileCheckedDelegate;
        this.mFolderSelectListener = folderSelectListener;
        this.mBrowseController = iBrowseController;
        this.mUserContextManager = iUserContextManager;
        this.mThumbnailService = thumbnailService;
        this.mThumbnailController = new LocalThumbnailManager(iBrowseController, iUserContextManager, thumbnailService);
        this.mFeatureFlips = featureFlips;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        FileCheckedDelegate fileCheckedDelegate;
        if (view == null) {
            view = this.mInflater.inflate(this.mFeatureFlips.getMainScreenRedesign().getEnabled() ? R.layout.browse_list_item : R.layout.browse_list_item_legacy, viewGroup, false);
            view.setTag(new ViewHolderMap(view));
        }
        ViewHolderMap viewHolderMap = (ViewHolderMap) view.getTag();
        FileInfo item = getItem(i);
        ImageView imageView = (ImageView) viewHolderMap.getView(R.id.box_browsesdk_thumb_image, ImageView.class);
        if (item.isFolder()) {
            imageView.setImageResource(this.mThumbnailController.getDefaultIconForFolders());
        } else {
            imageView.setImageResource(this.mThumbnailController.getDefaultIconResourceForFile(item.getFilename()));
        }
        ((TextView) viewHolderMap.getView(R.id.box_browsesdk_name_text, TextView.class)).setText(item.getFilename());
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) viewHolderMap.getView(R.id.boxItemCheckBox, AppCompatCheckBox.class);
        if (item.isFolder()) {
            ((TextView) viewHolderMap.getView(R.id.metaline_description, TextView.class)).setText(CommonBoxUtil.LS(R.string.updated) + " " + item.getLastUpdated());
            appCompatCheckBox.setVisibility(this.mFolderSelectListener != null ? 0 : 8);
            if (this.mFolderSelectListener != null && (fileCheckedDelegate = this.mFileCheckedDelegate) != null) {
                appCompatCheckBox.setChecked(fileCheckedDelegate.isFileChecked(item));
                appCompatCheckBox.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.adapters.SDFileListAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        SDFileListAdapter.this.mFolderSelectListener.onFolderCheckToggle(SDFileListAdapter.this.getItem(((Integer) view2.getTag()).intValue()));
                    }
                });
                appCompatCheckBox.setTag(Integer.valueOf(i));
            } else {
                appCompatCheckBox.setVisibility(8);
            }
        } else {
            ((TextView) viewHolderMap.getView(R.id.metaline_description, TextView.class)).setText(CommonBoxUtil.LS(R.string.updated) + " " + item.getLastUpdated() + " " + item.getSize());
            FileCheckedDelegate fileCheckedDelegate2 = this.mFileCheckedDelegate;
            if (fileCheckedDelegate2 != null) {
                appCompatCheckBox.setChecked(fileCheckedDelegate2.isFileChecked(item));
                appCompatCheckBox.setVisibility(0);
            } else {
                appCompatCheckBox.setVisibility(8);
            }
            appCompatCheckBox.setOnClickListener(null);
            appCompatCheckBox.setClickable(false);
        }
        if (this.mDisableFiles) {
            if (!item.isFolder()) {
                view.setAlpha(0.5f);
                view.setEnabled(false);
                return view;
            }
            view.setAlpha(1.0f);
            view.setEnabled(true);
        }
        return view;
    }

    public boolean isItemEnabled(int i) {
        return getItem(i).isFolder() || !this.mDisableFiles;
    }

    public void setList(List<FileInfo> list) {
        clear();
        Iterator<FileInfo> it = list.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public static class LocalThumbnailManager extends ThumbnailManager {
        public int getDefaultIconForFolders() {
            return R.drawable.ic_folder_personal;
        }

        public LocalThumbnailManager(IBrowseController iBrowseController, IUserContextManager iUserContextManager, ThumbnailService thumbnailService) {
            super(iBrowseController, iUserContextManager, thumbnailService);
        }

        public int getDefaultIconResourceForFile(String str) {
            return SupportedFileExtensionIcons.INSTANCE.findFileIcon(CommonBoxUtil.getFileExtension(str, "")).getDrawable();
        }
    }
}
