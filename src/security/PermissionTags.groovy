package security

// There is a tag for every permission currently on Jenkins
// When modifying permissions on a job it's necessary to provide a list containing the desired tags to modify
public enum PermissionTags {
    CREDENTIALS_CREATE,
    CREDENTIALS_DELETE,
    CREDENTIALS_UPDATE,
    CREDENTIALS_VIEW,
    CREDENTIALS_MANAGEDOMAIN,
    JOB_BUILD,
    JOB_CANCEL,
    JOB_CONFIGURE,
    JOB_DELETE,
    JOB_CREATE,
    JOB_READ,
    JOB_DISCOVER,
    JOB_MOVE,
    JOB_WORKSPACE,
    RUN_DELETE,
    RUN_REPLAY,
    RUN_UPDATE,
    VIEW_READ,
    VIEW_DELETE,
    VIEW_CREATE,
    VIEW_CONFIGURE,
    SCM_TAG
}
