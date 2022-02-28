
package com.biscuit.models;

import java.util.HashMap;
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
    "username",
    "full_name_display",
    "photo",
    "big_photo",
    "gravatar_id",
    "is_active",
    "id"
})
@Generated("jsonschema2pojo")
public class Owner {

    @JsonProperty("username")
    private String username;
    @JsonProperty("full_name_display")
    private String fullNameDisplay;
    @JsonProperty("photo")
    private Object photo;
    @JsonProperty("big_photo")
    private Object bigPhoto;
    @JsonProperty("gravatar_id")
    private String gravatarId;
    @JsonProperty("is_active")
    private Boolean isActive;
    @JsonProperty("id")
    private Integer id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("full_name_display")
    public String getFullNameDisplay() {
        return fullNameDisplay;
    }

    @JsonProperty("full_name_display")
    public void setFullNameDisplay(String fullNameDisplay) {
        this.fullNameDisplay = fullNameDisplay;
    }

    @JsonProperty("photo")
    public Object getPhoto() {
        return photo;
    }

    @JsonProperty("photo")
    public void setPhoto(Object photo) {
        this.photo = photo;
    }

    @JsonProperty("big_photo")
    public Object getBigPhoto() {
        return bigPhoto;
    }

    @JsonProperty("big_photo")
    public void setBigPhoto(Object bigPhoto) {
        this.bigPhoto = bigPhoto;
    }

    @JsonProperty("gravatar_id")
    public String getGravatarId() {
        return gravatarId;
    }

    @JsonProperty("gravatar_id")
    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    @JsonProperty("is_active")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("is_active")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
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
