<!DOCTYPE html>
<html lang="en">
<head>
    <#include "base.ftl">
	<meta charset="UTF-8">
	<title>Profile</title>
	<script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
    <link rel="stylesheet" href="styleForProfile.css">
</head>
<body>

<#macro content>
    <div class="wrapper">
        <div class="left">
            <img src="images/profile/photoProfile.jpg"
            alt="user" width="100">
            <h4>${user.firstName} ${user.lastName}</h4>
            <!-- Role input(по умолчанию none), берем из формы в сервлете(edit profile)-->
             <p>
                 ${profile.profileRole}
                <div class="inputForRole">
                    <input type="text" name="role-name">
                </div>
             </p>
        </div>
        <div class="right">
            <div class="info">
                <h3>Information</h3>
                <div class="info_data">
                     <div class="data">
                        <h4>Email</h4>
                        <p>${user.email}</p>
                     </div>
                     <div class="data">
                       <h4>Hobby</h4>
                       <!-- select -->
                        <p>
                            ${profile.profileHobby}
                        </p>
                  </div>
                </div>
            </div>
          
          <div class="projects">
                <h3>Articles</h3>
                <div class="projects_data">
                     <div class="data">
                        <h4>Recent</h4>
                        <p>Lorem ipsum dolor sit amet.</p>
                     </div>
                </div>
              <div class="profile">
                  <button>
                      <a class="redirect" href="/editProfile">Edit Profile</a>
                  </button>
              </div>
            </div>
        </div>
    </div>
</#macro>
</body>
</html>