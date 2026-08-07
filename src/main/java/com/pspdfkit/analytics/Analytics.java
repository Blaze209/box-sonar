package com.pspdfkit.analytics;

/* JADX INFO: loaded from: classes3.dex */
public final class Analytics {

    public static final class Data {
        public static final String ACTION = "action";
        public static final String ACTION_TYPE = "action_type";
        public static final String ANNOTATION_PROCESSING_MODE = "processing_mode";
        public static final String ANNOTATION_TOOL = "annotation_tool";
        public static final String ANNOTATION_TYPE = "annotation_type";
        public static final String COUNT = "count";
        public static final String LENGTH = "length";
        public static final String PACKAGE_NAME = "package_name";
        public static final String PAGE_INDEX = "page_index";
        public static final String SEARCH_TYPE = "search_type";
        public static final String SORT = "sort";
        public static final String TARGET_PAGE_INDEX = "target_page_index";
        public static final String VALUE = "value";

        private Data() {
        }
    }

    public static final class Event {
        public static final String ADD_BOOKMARK = "add_bookmark";
        public static final String CANCEL_ANNOTATION_CREATOR_DIALOG = "cancel_annotation_creator_dialog";
        public static final String CHANGE_PAGE = "change_page";
        public static final String CHANGE_PROPERTY_IN_INSPECTOR = "change_property_in_inspector";
        public static final String CREATE_ANNOTATION = "create_annotation";
        public static final String DELETE_ANNOTATION = "delete_annotation";
        public static final String EDIT_BOOKMARKS = "edit_bookmarks";
        public static final String ENTER_ANNOTATION_CREATION_MODE = "enter_annotation_creation_mode";
        public static final String EXIT_ANNOTATION_CREATION_MODE = "exit_annotation_creation_mode";
        public static final String EXIT_SEARCH = "exit_search";
        public static final String FAILED_DOCUMENT_LOAD = "failed_document_load";
        public static final String LOAD_DOCUMENT = "load_document";
        public static final String MOVE_TOOLBAR = "move_toolbar";
        public static final String NAVIGATE_THUMBNAIL_BAR = "navigate_thumbnail_bar";
        public static final String OPEN_DOCUMENT_EDITOR = "open_document_editor";
        public static final String OPEN_OUTLINE_VIEW = "open_outline_view";
        public static final String OPEN_READER_VIEW = "open_reader_view";
        public static final String OPEN_THUMBNAIL_GRID = "open_thumbnail_grid";
        public static final String PERFORM_DOCUMENT_EDITOR_ACTION = "perform_document_editor_action";
        public static final String PERFORM_SEARCH = "perform_search";
        public static final String PERFORM_TEXT_SELECTION_ACTION = "perform_text_selection_action";
        public static final String PRINT = "print";
        public static final String REMOVE_BOOKMARK = "remove_bookmark";
        public static final String RENAME_BOOKMARK = "rename_bookmark";
        public static final String SELECT_ANNOTATION = "select_annotation";
        public static final String SELECT_SEARCH_RESULT = "select_search_result";
        public static final String SELECT_TEXT = "select_text";
        public static final String SET_ANNOTATION_CREATOR = "set_annotation_creator";
        public static final String SHARE = "share";
        public static final String SHOW_ANNOTATION_CREATOR_DIALOG = "show_annotation_creator_dialog";
        public static final String SHOW_ANNOTATION_INSPECTOR = "show_annotation_inspector";
        public static final String SORT_BOOKMARK = "sort_bookmark";
        public static final String START_SEARCH = "start_search";
        public static final String TAP_ANNOTATION_IN_OUTLINE_LIST = "tap_annotation_in_outline_list";
        public static final String TAP_BOOKMARK_IN_BOOKMARK_LIST = "tap_bookmark_in_bookmark_list";
        public static final String TAP_OUTLINE_ELEMENT_IN_OUTLINE_LIST = "tap_outline_element_in_outline_list";

        private Event() {
        }
    }

    private Analytics() {
    }
}
