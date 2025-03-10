import security.PermisionsModifier
import security.PermissionTags
// The main methods and functionality of the shared library.

//IMPORTANT: When giving a job name that is within a folder or several, the path to the job should be expressed as follows
// "main_folder/sub_folder_1/sub_folder_2/jobName" with each parent folder separated by a forward slash in a Hierarchical order.

// This method is called via the wrapper methods "addUser" and "addGroup" that perform extremelly similar purposes
def add(String jobName, String user_to_modify, PermissionTags[] tags, boolean isGroup) {
    def fileContent = util.getJobConfig(jobName)
    def result = PermisionsModifier.addPermissions(fileContent, user_to_modify, tags, isGroup);

    util.updateJobConfig(jobName, result)
}

// Given an item name from the Jenkins Server, either folder or job, a user to which assign the permissions and a list of the permissions desired,
// will allow the given user the clearence needed to perform said actions in the job or folder
def addUser(String jobName, String user_to_modify, PermissionTags[] tags) {
    add(jobName, user_to_modify, tags, false)
}

// The same functionality of "addUser" but applied to groups, as the difference needs to be specified to the API.
// Will allow a group to performs the given actions on the selected job or folder
def addGroup(String jobName, String user_to_modify, PermissionTags[] tags) {
    add(jobName, user_to_modify, tags, true)
}

// Removes the clearence for a user or group (no specification needed besides user or group name) to perform the actions given on a job or folder
def remove(String jobName, String user_to_modify, PermissionTags[] tags) {
    def fileContent = util.getJobConfig(jobName)
    def result = PermisionsModifier.removePermissions(fileContent, user_to_modify, tags);

    util.updateJobConfig(jobName, result)
}

// Adds all existing permissions to a user on the given job
// This means full control over the resource
def addAllUser(String jobName, String user) {
    PermissionTags[] allTags = PermissionTags.values()
    addUser(jobName, user, allTags)
}

// Adds all existing permissions to a group on the given job
// This means full control over the resource
def addAllGroup(String jobName, String user) {
    PermissionTags[] allTags = PermissionTags.values()
    addGroup(jobName, user, allTags)
}

// Removes all current permissions a user or group have on the given job
def removeAll(String jobName, String user) {
    PermissionTags[] allTags = PermissionTags.values()
    remove(jobName, user, allTags)
}
