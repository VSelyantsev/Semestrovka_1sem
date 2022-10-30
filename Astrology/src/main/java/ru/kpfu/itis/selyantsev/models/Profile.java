package ru.kpfu.itis.selyantsev.models;

public class Profile {

    private Long profileId;
    private String profilePhotoUrl;
    private String profileRole;
    private String profileHobby;

    private String accountLoginName;

    public Profile(
            Long profileId,
            String profilePhotoUrl,
            String profileRole,
            String profileHobby,
            String accountLoginName) {
        this.profileId = profileId;
        this.profilePhotoUrl = profilePhotoUrl;
        this.profileRole = profileRole;
        this.profileHobby = profileHobby;
        this.accountLoginName = accountLoginName;
    }

    public Profile(String profilePhotoUrl, String profileRole, String profileHobby) {
        this.profilePhotoUrl = profilePhotoUrl;
        this.profileRole = profileRole;
        this.profileHobby = profileHobby;
    }

    public Profile(
            String profilePhotoUrl,
            String profileRole,
            String profileHobby,
            String accountLoginName) {
        this.profilePhotoUrl = profilePhotoUrl;
        this.profileRole = profileRole;
        this.profileHobby = profileHobby;
        this.accountLoginName = accountLoginName;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }

    public String getProfileRole() {
        return profileRole;
    }

    public void setProfileRole(String profileRole) {
        this.profileRole = profileRole;
    }

    public String getProfileHobby() {
        return profileHobby;
    }

    public void setProfileHobby(String profileHobby) {
        this.profileHobby = profileHobby;
    }

    public String getAccountLoginName() {
        return accountLoginName;
    }

    public void setAccountLoginName(String accountLoginName) {
        this.accountLoginName = accountLoginName;
    }
}
