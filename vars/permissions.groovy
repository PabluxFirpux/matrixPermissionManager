import security.PermisionsModifier
import security.PermissionTags

def add(String jobName, String user_to_modify, PermissionTags[] tags) {
    def fileContent = util.getJobConfig(jobName)
    def result = PermisionsModifier.addPermissions(fileContent, user_to_modify, tags);

    util.updateJobConfig(jobName, result)
}


def remove(String jobName, String user_to_modify, PermissionTags[] tags) {
    def fileContent = util.getJobConfig(jobName)
    def result = PermisionsModifier.removePermissions(fileContent, user_to_modify, tags);

    util.updateJobConfig(jobName, result)
}


def addAll(String jobName, String user) {
    PermissionTags[] allTags = PermissionTags.values()
    add(jobName, user, allTags)
}

def removeAll(String jobName, String user) {
    PermissionTags[] allTags = PermissionTags.values()
    remove(jobName, user, allTags)
}
