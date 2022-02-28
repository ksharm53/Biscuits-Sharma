
package com.biscuit.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "slug",
    "description",
    "created_date",
    "modified_date",
    "owner",
    "members",
    "total_milestones",
    "total_story_points",
    "is_contact_activated",
    "is_epics_activated",
    "is_backlog_activated",
    "is_kanban_activated",
    "is_wiki_activated",
    "is_issues_activated",
    "videoconferences",
    "videoconferences_extra_data",
    "creation_template",
    "is_private",
    "anon_permissions",
    "public_permissions",
    "is_featured",
    "is_looking_for_people",
    "looking_for_people_note",
    "blocked_code",
    "totals_updated_datetime",
    "total_fans",
    "total_fans_last_week",
    "total_fans_last_month",
    "total_fans_last_year",
    "total_activity",
    "total_activity_last_week",
    "total_activity_last_month",
    "total_activity_last_year",
    "tags",
    "tags_colors",
    "default_epic_status",
    "default_points",
    "default_us_status",
    "default_task_status",
    "default_priority",
    "default_severity",
    "default_issue_status",
    "default_issue_type",
    "default_swimlane",
    "my_permissions",
    "i_am_owner",
    "i_am_admin",
    "i_am_member",
    "notify_level",
    "total_closed_milestones",
    "is_watcher",
    "total_watchers",
    "logo_small_url",
    "logo_big_url",
    "is_fan",
    "my_homepage",
    "epic_statuses",
    "swimlanes",
    "us_statuses",
    "us_duedates",
    "points",
    "task_statuses",
    "task_duedates",
    "issue_statuses",
    "issue_types",
    "issue_duedates",
    "priorities",
    "severities",
    "epic_custom_attributes",
    "userstory_custom_attributes",
    "task_custom_attributes",
    "issue_custom_attributes",
    "roles",
    "total_memberships",
    "is_out_of_owner_limits",
    "is_private_extra_info",
    "max_memberships",
    "epics_csv_uuid",
    "userstories_csv_uuid",
    "tasks_csv_uuid",
    "issues_csv_uuid",
    "transfer_token",
    "milestones"
})
@Generated("jsonschema2pojo")
public class ProjectResponse {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("description")
    private String description;
    @JsonProperty("created_date")
    private String createdDate;
    @JsonProperty("modified_date")
    private String modifiedDate;
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("members")
    private List<Member> members = null;
    @JsonProperty("total_milestones")
    private Object totalMilestones;
    @JsonProperty("total_story_points")
    private Object totalStoryPoints;
    @JsonProperty("is_contact_activated")
    private Boolean isContactActivated;
    @JsonProperty("is_epics_activated")
    private Boolean isEpicsActivated;
    @JsonProperty("is_backlog_activated")
    private Boolean isBacklogActivated;
    @JsonProperty("is_kanban_activated")
    private Boolean isKanbanActivated;
    @JsonProperty("is_wiki_activated")
    private Boolean isWikiActivated;
    @JsonProperty("is_issues_activated")
    private Boolean isIssuesActivated;
    @JsonProperty("videoconferences")
    private Object videoconferences;
    @JsonProperty("videoconferences_extra_data")
    private Object videoconferencesExtraData;
    @JsonProperty("creation_template")
    private Integer creationTemplate;
    @JsonProperty("is_private")
    private Boolean isPrivate;
    @JsonProperty("anon_permissions")
    private List<Object> anonPermissions = null;
    @JsonProperty("public_permissions")
    private List<Object> publicPermissions = null;
    @JsonProperty("is_featured")
    private Boolean isFeatured;
    @JsonProperty("is_looking_for_people")
    private Boolean isLookingForPeople;
    @JsonProperty("looking_for_people_note")
    private String lookingForPeopleNote;
    @JsonProperty("blocked_code")
    private Object blockedCode;
    @JsonProperty("totals_updated_datetime")
    private String totalsUpdatedDatetime;
    @JsonProperty("total_fans")
    private Integer totalFans;
    @JsonProperty("total_fans_last_week")
    private Integer totalFansLastWeek;
    @JsonProperty("total_fans_last_month")
    private Integer totalFansLastMonth;
    @JsonProperty("total_fans_last_year")
    private Integer totalFansLastYear;
    @JsonProperty("total_activity")
    private Integer totalActivity;
    @JsonProperty("total_activity_last_week")
    private Integer totalActivityLastWeek;
    @JsonProperty("total_activity_last_month")
    private Integer totalActivityLastMonth;
    @JsonProperty("total_activity_last_year")
    private Integer totalActivityLastYear;
    @JsonProperty("tags")
    private List<Object> tags = null;
    @JsonProperty("tags_colors")
    private TagsColors tagsColors;
    @JsonProperty("default_epic_status")
    private Integer defaultEpicStatus;
    @JsonProperty("default_points")
    private Integer defaultPoints;
    @JsonProperty("default_us_status")
    private Integer defaultUsStatus;
    @JsonProperty("default_task_status")
    private Integer defaultTaskStatus;
    @JsonProperty("default_priority")
    private Integer defaultPriority;
    @JsonProperty("default_severity")
    private Integer defaultSeverity;
    @JsonProperty("default_issue_status")
    private Integer defaultIssueStatus;
    @JsonProperty("default_issue_type")
    private Integer defaultIssueType;
    @JsonProperty("default_swimlane")
    private Object defaultSwimlane;
    @JsonProperty("my_permissions")
    private List<String> myPermissions = null;
    @JsonProperty("i_am_owner")
    private Boolean iAmOwner;
    @JsonProperty("i_am_admin")
    private Boolean iAmAdmin;
    @JsonProperty("i_am_member")
    private Boolean iAmMember;
    @JsonProperty("notify_level")
    private Integer notifyLevel;
    @JsonProperty("total_closed_milestones")
    private Integer totalClosedMilestones;
    @JsonProperty("is_watcher")
    private Boolean isWatcher;
    @JsonProperty("total_watchers")
    private Integer totalWatchers;
    @JsonProperty("logo_small_url")
    private Object logoSmallUrl;
    @JsonProperty("logo_big_url")
    private Object logoBigUrl;
    @JsonProperty("is_fan")
    private Boolean isFan;
    @JsonProperty("my_homepage")
    private Boolean myHomepage;
    @JsonProperty("epic_statuses")
    private List<EpicStatus> epicStatuses = null;
    @JsonProperty("swimlanes")
    private Object swimlanes;
    @JsonProperty("us_statuses")
    private List<UsStatus> usStatuses = null;
    @JsonProperty("us_duedates")
    private List<UsDuedate> usDuedates = null;
    @JsonProperty("points")
    private List<Point> points = null;
    @JsonProperty("task_statuses")
    private List<TaskStatus> taskStatuses = null;
    @JsonProperty("task_duedates")
    private List<TaskDuedate> taskDuedates = null;
    @JsonProperty("issue_statuses")
    private List<IssueStatus> issueStatuses = null;
    @JsonProperty("issue_types")
    private List<IssueType> issueTypes = null;
    @JsonProperty("issue_duedates")
    private List<IssueDuedate> issueDuedates = null;
    @JsonProperty("priorities")
    private List<Priority> priorities = null;
    @JsonProperty("severities")
    private List<Severity> severities = null;
    @JsonProperty("epic_custom_attributes")
    private Object epicCustomAttributes;
    @JsonProperty("userstory_custom_attributes")
    private Object userstoryCustomAttributes;
    @JsonProperty("task_custom_attributes")
    private Object taskCustomAttributes;
    @JsonProperty("issue_custom_attributes")
    private Object issueCustomAttributes;
    @JsonProperty("roles")
    private List<Role> roles = null;
    @JsonProperty("total_memberships")
    private Integer totalMemberships;
    @JsonProperty("is_out_of_owner_limits")
    private Boolean isOutOfOwnerLimits;
    @JsonProperty("is_private_extra_info")
    private IsPrivateExtraInfo isPrivateExtraInfo;
    @JsonProperty("max_memberships")
    private Integer maxMemberships;
    @JsonProperty("epics_csv_uuid")
    private Object epicsCsvUuid;
    @JsonProperty("userstories_csv_uuid")
    private Object userstoriesCsvUuid;
    @JsonProperty("tasks_csv_uuid")
    private Object tasksCsvUuid;
    @JsonProperty("issues_csv_uuid")
    private Object issuesCsvUuid;
    @JsonProperty("transfer_token")
    private Object transferToken;
    @JsonProperty("milestones")
    private List<Object> milestones = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("created_date")
    public String getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("created_date")
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @JsonProperty("modified_date")
    public String getModifiedDate() {
        return modifiedDate;
    }

    @JsonProperty("modified_date")
    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @JsonProperty("owner")
    public Owner getOwner() {
        return owner;
    }

    @JsonProperty("owner")
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @JsonProperty("members")
    public List<Member> getMembers() {
        return members;
    }

    @JsonProperty("members")
    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @JsonProperty("total_milestones")
    public Object getTotalMilestones() {
        return totalMilestones;
    }

    @JsonProperty("total_milestones")
    public void setTotalMilestones(Object totalMilestones) {
        this.totalMilestones = totalMilestones;
    }

    @JsonProperty("total_story_points")
    public Object getTotalStoryPoints() {
        return totalStoryPoints;
    }

    @JsonProperty("total_story_points")
    public void setTotalStoryPoints(Object totalStoryPoints) {
        this.totalStoryPoints = totalStoryPoints;
    }

    @JsonProperty("is_contact_activated")
    public Boolean getIsContactActivated() {
        return isContactActivated;
    }

    @JsonProperty("is_contact_activated")
    public void setIsContactActivated(Boolean isContactActivated) {
        this.isContactActivated = isContactActivated;
    }

    @JsonProperty("is_epics_activated")
    public Boolean getIsEpicsActivated() {
        return isEpicsActivated;
    }

    @JsonProperty("is_epics_activated")
    public void setIsEpicsActivated(Boolean isEpicsActivated) {
        this.isEpicsActivated = isEpicsActivated;
    }

    @JsonProperty("is_backlog_activated")
    public Boolean getIsBacklogActivated() {
        return isBacklogActivated;
    }

    @JsonProperty("is_backlog_activated")
    public void setIsBacklogActivated(Boolean isBacklogActivated) {
        this.isBacklogActivated = isBacklogActivated;
    }

    @JsonProperty("is_kanban_activated")
    public Boolean getIsKanbanActivated() {
        return isKanbanActivated;
    }

    @JsonProperty("is_kanban_activated")
    public void setIsKanbanActivated(Boolean isKanbanActivated) {
        this.isKanbanActivated = isKanbanActivated;
    }

    @JsonProperty("is_wiki_activated")
    public Boolean getIsWikiActivated() {
        return isWikiActivated;
    }

    @JsonProperty("is_wiki_activated")
    public void setIsWikiActivated(Boolean isWikiActivated) {
        this.isWikiActivated = isWikiActivated;
    }

    @JsonProperty("is_issues_activated")
    public Boolean getIsIssuesActivated() {
        return isIssuesActivated;
    }

    @JsonProperty("is_issues_activated")
    public void setIsIssuesActivated(Boolean isIssuesActivated) {
        this.isIssuesActivated = isIssuesActivated;
    }

    @JsonProperty("videoconferences")
    public Object getVideoconferences() {
        return videoconferences;
    }

    @JsonProperty("videoconferences")
    public void setVideoconferences(Object videoconferences) {
        this.videoconferences = videoconferences;
    }

    @JsonProperty("videoconferences_extra_data")
    public Object getVideoconferencesExtraData() {
        return videoconferencesExtraData;
    }

    @JsonProperty("videoconferences_extra_data")
    public void setVideoconferencesExtraData(Object videoconferencesExtraData) {
        this.videoconferencesExtraData = videoconferencesExtraData;
    }

    @JsonProperty("creation_template")
    public Integer getCreationTemplate() {
        return creationTemplate;
    }

    @JsonProperty("creation_template")
    public void setCreationTemplate(Integer creationTemplate) {
        this.creationTemplate = creationTemplate;
    }

    @JsonProperty("is_private")
    public Boolean getIsPrivate() {
        return isPrivate;
    }

    @JsonProperty("is_private")
    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    @JsonProperty("anon_permissions")
    public List<Object> getAnonPermissions() {
        return anonPermissions;
    }

    @JsonProperty("anon_permissions")
    public void setAnonPermissions(List<Object> anonPermissions) {
        this.anonPermissions = anonPermissions;
    }

    @JsonProperty("public_permissions")
    public List<Object> getPublicPermissions() {
        return publicPermissions;
    }

    @JsonProperty("public_permissions")
    public void setPublicPermissions(List<Object> publicPermissions) {
        this.publicPermissions = publicPermissions;
    }

    @JsonProperty("is_featured")
    public Boolean getIsFeatured() {
        return isFeatured;
    }

    @JsonProperty("is_featured")
    public void setIsFeatured(Boolean isFeatured) {
        this.isFeatured = isFeatured;
    }

    @JsonProperty("is_looking_for_people")
    public Boolean getIsLookingForPeople() {
        return isLookingForPeople;
    }

    @JsonProperty("is_looking_for_people")
    public void setIsLookingForPeople(Boolean isLookingForPeople) {
        this.isLookingForPeople = isLookingForPeople;
    }

    @JsonProperty("looking_for_people_note")
    public String getLookingForPeopleNote() {
        return lookingForPeopleNote;
    }

    @JsonProperty("looking_for_people_note")
    public void setLookingForPeopleNote(String lookingForPeopleNote) {
        this.lookingForPeopleNote = lookingForPeopleNote;
    }

    @JsonProperty("blocked_code")
    public Object getBlockedCode() {
        return blockedCode;
    }

    @JsonProperty("blocked_code")
    public void setBlockedCode(Object blockedCode) {
        this.blockedCode = blockedCode;
    }

    @JsonProperty("totals_updated_datetime")
    public String getTotalsUpdatedDatetime() {
        return totalsUpdatedDatetime;
    }

    @JsonProperty("totals_updated_datetime")
    public void setTotalsUpdatedDatetime(String totalsUpdatedDatetime) {
        this.totalsUpdatedDatetime = totalsUpdatedDatetime;
    }

    @JsonProperty("total_fans")
    public Integer getTotalFans() {
        return totalFans;
    }

    @JsonProperty("total_fans")
    public void setTotalFans(Integer totalFans) {
        this.totalFans = totalFans;
    }

    @JsonProperty("total_fans_last_week")
    public Integer getTotalFansLastWeek() {
        return totalFansLastWeek;
    }

    @JsonProperty("total_fans_last_week")
    public void setTotalFansLastWeek(Integer totalFansLastWeek) {
        this.totalFansLastWeek = totalFansLastWeek;
    }

    @JsonProperty("total_fans_last_month")
    public Integer getTotalFansLastMonth() {
        return totalFansLastMonth;
    }

    @JsonProperty("total_fans_last_month")
    public void setTotalFansLastMonth(Integer totalFansLastMonth) {
        this.totalFansLastMonth = totalFansLastMonth;
    }

    @JsonProperty("total_fans_last_year")
    public Integer getTotalFansLastYear() {
        return totalFansLastYear;
    }

    @JsonProperty("total_fans_last_year")
    public void setTotalFansLastYear(Integer totalFansLastYear) {
        this.totalFansLastYear = totalFansLastYear;
    }

    @JsonProperty("total_activity")
    public Integer getTotalActivity() {
        return totalActivity;
    }

    @JsonProperty("total_activity")
    public void setTotalActivity(Integer totalActivity) {
        this.totalActivity = totalActivity;
    }

    @JsonProperty("total_activity_last_week")
    public Integer getTotalActivityLastWeek() {
        return totalActivityLastWeek;
    }

    @JsonProperty("total_activity_last_week")
    public void setTotalActivityLastWeek(Integer totalActivityLastWeek) {
        this.totalActivityLastWeek = totalActivityLastWeek;
    }

    @JsonProperty("total_activity_last_month")
    public Integer getTotalActivityLastMonth() {
        return totalActivityLastMonth;
    }

    @JsonProperty("total_activity_last_month")
    public void setTotalActivityLastMonth(Integer totalActivityLastMonth) {
        this.totalActivityLastMonth = totalActivityLastMonth;
    }

    @JsonProperty("total_activity_last_year")
    public Integer getTotalActivityLastYear() {
        return totalActivityLastYear;
    }

    @JsonProperty("total_activity_last_year")
    public void setTotalActivityLastYear(Integer totalActivityLastYear) {
        this.totalActivityLastYear = totalActivityLastYear;
    }

    @JsonProperty("tags")
    public List<Object> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    @JsonProperty("tags_colors")
    public TagsColors getTagsColors() {
        return tagsColors;
    }

    @JsonProperty("tags_colors")
    public void setTagsColors(TagsColors tagsColors) {
        this.tagsColors = tagsColors;
    }

    @JsonProperty("default_epic_status")
    public Integer getDefaultEpicStatus() {
        return defaultEpicStatus;
    }

    @JsonProperty("default_epic_status")
    public void setDefaultEpicStatus(Integer defaultEpicStatus) {
        this.defaultEpicStatus = defaultEpicStatus;
    }

    @JsonProperty("default_points")
    public Integer getDefaultPoints() {
        return defaultPoints;
    }

    @JsonProperty("default_points")
    public void setDefaultPoints(Integer defaultPoints) {
        this.defaultPoints = defaultPoints;
    }

    @JsonProperty("default_us_status")
    public Integer getDefaultUsStatus() {
        return defaultUsStatus;
    }

    @JsonProperty("default_us_status")
    public void setDefaultUsStatus(Integer defaultUsStatus) {
        this.defaultUsStatus = defaultUsStatus;
    }

    @JsonProperty("default_task_status")
    public Integer getDefaultTaskStatus() {
        return defaultTaskStatus;
    }

    @JsonProperty("default_task_status")
    public void setDefaultTaskStatus(Integer defaultTaskStatus) {
        this.defaultTaskStatus = defaultTaskStatus;
    }

    @JsonProperty("default_priority")
    public Integer getDefaultPriority() {
        return defaultPriority;
    }

    @JsonProperty("default_priority")
    public void setDefaultPriority(Integer defaultPriority) {
        this.defaultPriority = defaultPriority;
    }

    @JsonProperty("default_severity")
    public Integer getDefaultSeverity() {
        return defaultSeverity;
    }

    @JsonProperty("default_severity")
    public void setDefaultSeverity(Integer defaultSeverity) {
        this.defaultSeverity = defaultSeverity;
    }

    @JsonProperty("default_issue_status")
    public Integer getDefaultIssueStatus() {
        return defaultIssueStatus;
    }

    @JsonProperty("default_issue_status")
    public void setDefaultIssueStatus(Integer defaultIssueStatus) {
        this.defaultIssueStatus = defaultIssueStatus;
    }

    @JsonProperty("default_issue_type")
    public Integer getDefaultIssueType() {
        return defaultIssueType;
    }

    @JsonProperty("default_issue_type")
    public void setDefaultIssueType(Integer defaultIssueType) {
        this.defaultIssueType = defaultIssueType;
    }

    @JsonProperty("default_swimlane")
    public Object getDefaultSwimlane() {
        return defaultSwimlane;
    }

    @JsonProperty("default_swimlane")
    public void setDefaultSwimlane(Object defaultSwimlane) {
        this.defaultSwimlane = defaultSwimlane;
    }

    @JsonProperty("my_permissions")
    public List<String> getMyPermissions() {
        return myPermissions;
    }

    @JsonProperty("my_permissions")
    public void setMyPermissions(List<String> myPermissions) {
        this.myPermissions = myPermissions;
    }

    @JsonProperty("i_am_owner")
    public Boolean getiAmOwner() {
        return iAmOwner;
    }

    @JsonProperty("i_am_owner")
    public void setiAmOwner(Boolean iAmOwner) {
        this.iAmOwner = iAmOwner;
    }

    @JsonProperty("i_am_admin")
    public Boolean getiAmAdmin() {
        return iAmAdmin;
    }

    @JsonProperty("i_am_admin")
    public void setiAmAdmin(Boolean iAmAdmin) {
        this.iAmAdmin = iAmAdmin;
    }

    @JsonProperty("i_am_member")
    public Boolean getiAmMember() {
        return iAmMember;
    }

    @JsonProperty("i_am_member")
    public void setiAmMember(Boolean iAmMember) {
        this.iAmMember = iAmMember;
    }

    @JsonProperty("notify_level")
    public Integer getNotifyLevel() {
        return notifyLevel;
    }

    @JsonProperty("notify_level")
    public void setNotifyLevel(Integer notifyLevel) {
        this.notifyLevel = notifyLevel;
    }

    @JsonProperty("total_closed_milestones")
    public Integer getTotalClosedMilestones() {
        return totalClosedMilestones;
    }

    @JsonProperty("total_closed_milestones")
    public void setTotalClosedMilestones(Integer totalClosedMilestones) {
        this.totalClosedMilestones = totalClosedMilestones;
    }

    @JsonProperty("is_watcher")
    public Boolean getIsWatcher() {
        return isWatcher;
    }

    @JsonProperty("is_watcher")
    public void setIsWatcher(Boolean isWatcher) {
        this.isWatcher = isWatcher;
    }

    @JsonProperty("total_watchers")
    public Integer getTotalWatchers() {
        return totalWatchers;
    }

    @JsonProperty("total_watchers")
    public void setTotalWatchers(Integer totalWatchers) {
        this.totalWatchers = totalWatchers;
    }

    @JsonProperty("logo_small_url")
    public Object getLogoSmallUrl() {
        return logoSmallUrl;
    }

    @JsonProperty("logo_small_url")
    public void setLogoSmallUrl(Object logoSmallUrl) {
        this.logoSmallUrl = logoSmallUrl;
    }

    @JsonProperty("logo_big_url")
    public Object getLogoBigUrl() {
        return logoBigUrl;
    }

    @JsonProperty("logo_big_url")
    public void setLogoBigUrl(Object logoBigUrl) {
        this.logoBigUrl = logoBigUrl;
    }

    @JsonProperty("is_fan")
    public Boolean getIsFan() {
        return isFan;
    }

    @JsonProperty("is_fan")
    public void setIsFan(Boolean isFan) {
        this.isFan = isFan;
    }

    @JsonProperty("my_homepage")
    public Boolean getMyHomepage() {
        return myHomepage;
    }

    @JsonProperty("my_homepage")
    public void setMyHomepage(Boolean myHomepage) {
        this.myHomepage = myHomepage;
    }

    @JsonProperty("epic_statuses")
    public List<EpicStatus> getEpicStatuses() {
        return epicStatuses;
    }

    @JsonProperty("epic_statuses")
    public void setEpicStatuses(List<EpicStatus> epicStatuses) {
        this.epicStatuses = epicStatuses;
    }

    @JsonProperty("swimlanes")
    public Object getSwimlanes() {
        return swimlanes;
    }

    @JsonProperty("swimlanes")
    public void setSwimlanes(Object swimlanes) {
        this.swimlanes = swimlanes;
    }

    @JsonProperty("us_statuses")
    public List<UsStatus> getUsStatuses() {
        return usStatuses;
    }

    @JsonProperty("us_statuses")
    public void setUsStatuses(List<UsStatus> usStatuses) {
        this.usStatuses = usStatuses;
    }

    @JsonProperty("us_duedates")
    public List<UsDuedate> getUsDuedates() {
        return usDuedates;
    }

    @JsonProperty("us_duedates")
    public void setUsDuedates(List<UsDuedate> usDuedates) {
        this.usDuedates = usDuedates;
    }

    @JsonProperty("points")
    public List<Point> getPoints() {
        return points;
    }

    @JsonProperty("points")
    public void setPoints(List<Point> points) {
        this.points = points;
    }

    @JsonProperty("task_statuses")
    public List<TaskStatus> getTaskStatuses() {
        return taskStatuses;
    }

    @JsonProperty("task_statuses")
    public void setTaskStatuses(List<TaskStatus> taskStatuses) {
        this.taskStatuses = taskStatuses;
    }

    @JsonProperty("task_duedates")
    public List<TaskDuedate> getTaskDuedates() {
        return taskDuedates;
    }

    @JsonProperty("task_duedates")
    public void setTaskDuedates(List<TaskDuedate> taskDuedates) {
        this.taskDuedates = taskDuedates;
    }

    @JsonProperty("issue_statuses")
    public List<IssueStatus> getIssueStatuses() {
        return issueStatuses;
    }

    @JsonProperty("issue_statuses")
    public void setIssueStatuses(List<IssueStatus> issueStatuses) {
        this.issueStatuses = issueStatuses;
    }

    @JsonProperty("issue_types")
    public List<IssueType> getIssueTypes() {
        return issueTypes;
    }

    @JsonProperty("issue_types")
    public void setIssueTypes(List<IssueType> issueTypes) {
        this.issueTypes = issueTypes;
    }

    @JsonProperty("issue_duedates")
    public List<IssueDuedate> getIssueDuedates() {
        return issueDuedates;
    }

    @JsonProperty("issue_duedates")
    public void setIssueDuedates(List<IssueDuedate> issueDuedates) {
        this.issueDuedates = issueDuedates;
    }

    @JsonProperty("priorities")
    public List<Priority> getPriorities() {
        return priorities;
    }

    @JsonProperty("priorities")
    public void setPriorities(List<Priority> priorities) {
        this.priorities = priorities;
    }

    @JsonProperty("severities")
    public List<Severity> getSeverities() {
        return severities;
    }

    @JsonProperty("severities")
    public void setSeverities(List<Severity> severities) {
        this.severities = severities;
    }

    @JsonProperty("epic_custom_attributes")
    public Object getEpicCustomAttributes() {
        return epicCustomAttributes;
    }

    @JsonProperty("epic_custom_attributes")
    public void setEpicCustomAttributes(Object epicCustomAttributes) {
        this.epicCustomAttributes = epicCustomAttributes;
    }

    @JsonProperty("userstory_custom_attributes")
    public Object getUserstoryCustomAttributes() {
        return userstoryCustomAttributes;
    }

    @JsonProperty("userstory_custom_attributes")
    public void setUserstoryCustomAttributes(Object userstoryCustomAttributes) {
        this.userstoryCustomAttributes = userstoryCustomAttributes;
    }

    @JsonProperty("task_custom_attributes")
    public Object getTaskCustomAttributes() {
        return taskCustomAttributes;
    }

    @JsonProperty("task_custom_attributes")
    public void setTaskCustomAttributes(Object taskCustomAttributes) {
        this.taskCustomAttributes = taskCustomAttributes;
    }

    @JsonProperty("issue_custom_attributes")
    public Object getIssueCustomAttributes() {
        return issueCustomAttributes;
    }

    @JsonProperty("issue_custom_attributes")
    public void setIssueCustomAttributes(Object issueCustomAttributes) {
        this.issueCustomAttributes = issueCustomAttributes;
    }

    @JsonProperty("roles")
    public List<Role> getRoles() {
        return roles;
    }

    @JsonProperty("roles")
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @JsonProperty("total_memberships")
    public Integer getTotalMemberships() {
        return totalMemberships;
    }

    @JsonProperty("total_memberships")
    public void setTotalMemberships(Integer totalMemberships) {
        this.totalMemberships = totalMemberships;
    }

    @JsonProperty("is_out_of_owner_limits")
    public Boolean getIsOutOfOwnerLimits() {
        return isOutOfOwnerLimits;
    }

    @JsonProperty("is_out_of_owner_limits")
    public void setIsOutOfOwnerLimits(Boolean isOutOfOwnerLimits) {
        this.isOutOfOwnerLimits = isOutOfOwnerLimits;
    }

    @JsonProperty("is_private_extra_info")
    public IsPrivateExtraInfo getIsPrivateExtraInfo() {
        return isPrivateExtraInfo;
    }

    @JsonProperty("is_private_extra_info")
    public void setIsPrivateExtraInfo(IsPrivateExtraInfo isPrivateExtraInfo) {
        this.isPrivateExtraInfo = isPrivateExtraInfo;
    }

    @JsonProperty("max_memberships")
    public Integer getMaxMemberships() {
        return maxMemberships;
    }

    @JsonProperty("max_memberships")
    public void setMaxMemberships(Integer maxMemberships) {
        this.maxMemberships = maxMemberships;
    }

    @JsonProperty("epics_csv_uuid")
    public Object getEpicsCsvUuid() {
        return epicsCsvUuid;
    }

    @JsonProperty("epics_csv_uuid")
    public void setEpicsCsvUuid(Object epicsCsvUuid) {
        this.epicsCsvUuid = epicsCsvUuid;
    }

    @JsonProperty("userstories_csv_uuid")
    public Object getUserstoriesCsvUuid() {
        return userstoriesCsvUuid;
    }

    @JsonProperty("userstories_csv_uuid")
    public void setUserstoriesCsvUuid(Object userstoriesCsvUuid) {
        this.userstoriesCsvUuid = userstoriesCsvUuid;
    }

    @JsonProperty("tasks_csv_uuid")
    public Object getTasksCsvUuid() {
        return tasksCsvUuid;
    }

    @JsonProperty("tasks_csv_uuid")
    public void setTasksCsvUuid(Object tasksCsvUuid) {
        this.tasksCsvUuid = tasksCsvUuid;
    }

    @JsonProperty("issues_csv_uuid")
    public Object getIssuesCsvUuid() {
        return issuesCsvUuid;
    }

    @JsonProperty("issues_csv_uuid")
    public void setIssuesCsvUuid(Object issuesCsvUuid) {
        this.issuesCsvUuid = issuesCsvUuid;
    }

    @JsonProperty("transfer_token")
    public Object getTransferToken() {
        return transferToken;
    }

    @JsonProperty("transfer_token")
    public void setTransferToken(Object transferToken) {
        this.transferToken = transferToken;
    }

    @JsonProperty("milestones")
    public List<Object> getMilestones() {
        return milestones;
    }

    @JsonProperty("milestones")
    public void setMilestones(List<Object> milestones) {
        this.milestones = milestones;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
