package com.biscuit.models;

import java.util.List;

/**
 * @author ksharm53
 *
 */
public class TaigaProject {
	private String name;
	private String slug;
	private String description;
	private List<TaigaUser> users;
	private boolean isBacklogActivated;
	private boolean isKanbanActivated;
	private boolean isWikiActivated;
	private boolean isIssuesActivated;

	@Override
	public String toString() {
		return "ProjectDTO{" +
				"name='" + name + '\'' +
				", slug='" + slug + '\'' +
				", description='" + description + '\'' +
				'}';
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isBacklogActivated() {
		return isBacklogActivated;
	}

	public void setIsBacklogActivated(boolean isBacklogActivated) {
		this.isBacklogActivated = isBacklogActivated;
	}

	public boolean isIssuesActivated() {
		return isIssuesActivated;
	}

	public void setIsIssuesActivated(boolean isIssuesActivated) {
		this.isIssuesActivated = isIssuesActivated;
	}

	public boolean isKanbanActivated() {
		return isKanbanActivated;
	}

	public void setIsKanbanActivated(boolean isKanbanActivated) {
		this.isKanbanActivated = isKanbanActivated;
	}

	public boolean isWikiActivated() {
		return isWikiActivated;
	}

	public void setIsWikiActivated(boolean isWikiActivated) {
		this.isWikiActivated = isWikiActivated;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public List<TaigaUser> getUsers() {
		return users;
	}

	public void setUsers(List<TaigaUser> users) {
		this.users = users;
	}

}
