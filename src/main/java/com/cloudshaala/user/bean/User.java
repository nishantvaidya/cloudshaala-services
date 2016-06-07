package com.cloudshaala.user.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	private String password,firstname,lastname,gender,countryCode,stateCode,
    districtCode,cityVillage,streetAddress,email,mobile,landline,
    locLatitude,locLongitude,registeredByUser,registrationPlatform,
    communityLoginBy, communityLoginId, profilePic,secondaryLangCode,
    androidToken,primaryInstitutionType;
;
public User()
{

}

public User(String firstname, String lastname, String mobile, String email,String primaryInstitutionType) {
this.firstname = firstname;
this.lastname = lastname;
this.mobile = mobile;
this.email = email;
this.primaryInstitutionType=primaryInstitutionType;
}

public User(String registrationPlatform, long id, String password,
        String firstname, String lastname, String gender, String countryCode,
        String stateCode, String districtCode, String cityVillage,
        String streetAddress, String email, String mobile, String landline,
        String locLatitude, String locLongitude, String registeredByUser,
        String communityLoginBy, String communityLoginId, String profilePic,
        String secondaryLangCode)
{
this.registrationPlatform = registrationPlatform;
this.id = id;
this.password = password;
this.firstname = firstname;
this.lastname = lastname;
this.gender = gender;
this.countryCode = countryCode;
this.stateCode = stateCode;
this.districtCode = districtCode;
this.cityVillage = cityVillage;
this.streetAddress = streetAddress;
this.email = email;
this.mobile = mobile;
this.landline = landline;
this.locLatitude = locLatitude;
this.locLongitude = locLongitude;
this.registeredByUser = registeredByUser;
this.communityLoginBy = communityLoginBy;
this.communityLoginId = communityLoginId;
this.profilePic = profilePic;
this.secondaryLangCode = secondaryLangCode;
}

public String getPrimaryInstitutionType() {
return primaryInstitutionType;
}

public void setPrimaryInstitutionType(String primaryInstitutionType) {
this.primaryInstitutionType = primaryInstitutionType;
}



public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password;
}

public String getFirstname() {
return firstname;
}

public void setFirstname(String firstname) {
this.firstname = firstname;
}

public String getLastname() {
return lastname;
}

public void setLastname(String lastname) {
this.lastname = lastname;
}

public String getGender() {
return gender;
}

public void setGender(String gender) {
this.gender = gender;
}

public String getCountryCode() {
return countryCode;
}

public void setCountryCode(String countryCode) {
this.countryCode = countryCode;
}

public String getStateCode() {
return stateCode;
}

public void setStateCode(String stateCode) {
this.stateCode = stateCode;
}

public String getDistrictCode() {
return districtCode;
}

public void setDistrictCode(String districtCode) {
this.districtCode = districtCode;
}

public String getCityVillage() {
return cityVillage;
}

public void setCityVillage(String cityVillage) {
this.cityVillage = cityVillage;
}

public String getStreetAddress() {
return streetAddress;
}

public void setStreetAddress(String streetAddress) {
this.streetAddress = streetAddress;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getMobile() {
return mobile;
}

public void setMobile(String mobile) {
this.mobile = mobile;
}

public String getLandline() {
return landline;
}

public void setLandline(String landline) {
this.landline = landline;
}

public String getLocLatitude() {
return locLatitude;
}

public void setLocLatitude(String locLatitude) {
this.locLatitude = locLatitude;
}

public String getLocLongitude() {
return locLongitude;
}

public void setLocLongitude(String locLongitude) {
this.locLongitude = locLongitude;
}

public String getRegisteredByUser() {
return registeredByUser;
}

public void setRegisteredByUser(String registeredByUser) {
this.registeredByUser = registeredByUser;
}

public String getRegistrationPlatform() {
return registrationPlatform;
}

public void setRegistrationPlatform(String registrationPlatform) {
this.registrationPlatform = registrationPlatform;
}

public String getCommunityLoginBy() {
return communityLoginBy;
}

public void setCommunityLoginBy(String communityLoginBy) {
this.communityLoginBy = communityLoginBy;
}

public String getCommunityLoginId() {
return communityLoginId;
}

public void setCommunityLoginId(String communityLoginId) {
this.communityLoginId = communityLoginId;
}

public String getProfilePic() {
return profilePic;
}

public void setProfilePic(String profilePic) {
this.profilePic = profilePic;
}

public String getSecondaryLangCode() {
return secondaryLangCode;
}

public void setSecondaryLangCode(String secondaryLangCode) {
this.secondaryLangCode = secondaryLangCode;
}

public String getAndroidToken() {
return androidToken;
}

public void setAndroidToken(String androidToken) {
this.androidToken = androidToken;
}

public  String getFullname()
{
if (firstname!=null)
{
    if (lastname!=null)
        return firstname+" "+lastname;
    else
        return firstname;
}
return "";
}
@Override
public String toString() {
return  "id:"+id+"  name:"+firstname+" "+lastname;
}

}
