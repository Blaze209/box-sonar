package com.box.android.preview.fileactions;

import com.box.android.preview.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: FileActionUIItem.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b$\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&¨\u0006'"}, d2 = {"Lcom/box/android/preview/fileactions/FileActionUIItem;", "", "iconRes", "", "titleRes", "<init>", "(Ljava/lang/String;III)V", "getIconRes", "()I", "getTitleRes", "RenameFile", "ThumbnailsView", "OutlineView", "PageView", "MoveOrCopy", "MakeAvailableOffline", "RemoveFromOffline", "FileInformation", "ViewContainingFolder", "Download", "Print", "ViewSettings", "Watermarking", "Delete", "EndCollaboration", "Search", "Share", "OpenIn", "AddAnnotation", "FileActivity", "Collections", "CopySharedLink", "FolderGallery", "CaptureHistoryGallery", "RecentGallery", "OfflineGallery", "Playlist", "BoxAi", "AddTask", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum FileActionUIItem {
    RenameFile(R.drawable.ic_edit_fill, R.string.rename_this_file),
    ThumbnailsView(R.drawable.ic_gridview24_blue, R.string.preview_thumbnails_view_label),
    OutlineView(R.drawable.pspdf__ic_outline_view_outline, R.string.preview_outline_view_label),
    PageView(R.drawable.ic_draft_24, R.string.preview_page_view_label),
    MoveOrCopy(R.drawable.ic_file_copy, R.string.preview_move_or_copy_label),
    MakeAvailableOffline(R.drawable.ic_checkmark_badge_underline, R.string.preview_make_available_offline_label),
    RemoveFromOffline(R.drawable.ic_checkmark_badge_underline, R.string.preview_remove_from_offline_label),
    FileInformation(R.drawable.ic_info_24, R.string.preview_file_information_label),
    ViewContainingFolder(R.drawable.ic_folderpersonal20, R.string.view_containing_folder),
    Download(R.drawable.ic_file_download_grey_24dp, R.string.Download),
    Print(R.drawable.pspdf__ic_print, R.string.print_file_label),
    ViewSettings(R.drawable.ic_settings_outline, R.string.view_settings_label),
    Watermarking(R.drawable.ic_watermark, R.string.watermarking),
    Delete(R.drawable.ic_delete, R.string.LS_Delete),
    EndCollaboration(R.drawable.ic_end_collaboration, R.string.LS_End_Collaboration),
    Search(R.drawable.ic_search_24, R.string.preview_search_document_label),
    Share(R.drawable.ic_android_share, R.string.share),
    OpenIn(R.drawable.ic_arrow_up_right_square_alt, R.string.preview_open_with_label),
    AddAnnotation(R.drawable.ic_scribble_v2, R.string.create_annotation),
    FileActivity(R.drawable.ic_ellipsis_bubble_line, R.string.file_activity_talkback_label),
    Collections(R.drawable.ic_collections_star, R.string.Collections),
    CopySharedLink(R.drawable.ic_shared_link_diagonal, R.string.copy_shared_link),
    FolderGallery(R.drawable.ic_gridview24_blue, R.string.preview_folder_gallery_view_label),
    CaptureHistoryGallery(R.drawable.ic_gridview24_blue, R.string.preview_capture_history_gallery_view_label),
    RecentGallery(R.drawable.ic_gridview24_blue, R.string.preview_recents_gallery_view_label),
    OfflineGallery(R.drawable.ic_gridview24_blue, R.string.preview_offline_gallery_view_label),
    Playlist(R.drawable.ic_playlist24_blue, R.string.preview_playlist_label),
    BoxAi(R.drawable.ic_box_ai, R.string.box_ai),
    AddTask(R.drawable.add_task_24, R.string.add_task);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final int iconRes;
    private final int titleRes;

    public static EnumEntries<FileActionUIItem> getEntries() {
        return $ENTRIES;
    }

    FileActionUIItem(int i, int i2) {
        this.iconRes = i;
        this.titleRes = i2;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }
}
