<!DOCTYPE html>
<html>
<head>
	<#include "base.ftl">
	<title>Edit Profile</title>
	<link rel="stylesheet" type="text/css" href="styleForEditProfile.css">
</head>
<body>

<#macro content>
	<div class="wrapper">
		<form method="post" action="profile.ftl">
			<div class="wrapper-left">
				<details class="personalData">
					<summary>Edit Personal Data</summary>
					<div class="box">
						<div class="labelData">
							<label for="firstName" class="fl">First Name: </label>
						</div>
						<div class="inputData">
							<input class="data" type="text" name="firstname" placeholder="Edit First Name" autofocus="on"
							required minlength="4"
                       		pattern="^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$">
						</div>
					</div>

					<div class="box">
						<div class="labelData">
							<label for="secondName" class="fl"> Last Name: </label>
						</div>
						<div class="inputData">
							<input class="data" type="text" required name="lastname"
                       	placeholder="Edit Last name" class="textBox" minlength="6"
                       	pattern="^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$">
						</div>
					</div>

					<div class="box">
						<div class="labelData">
							<label for="login" class="fl"> Login: </label>
						</div>
						<div class="inputData">
							<input class="data" type="text" required name="login" placeholder="Edit Login" class="textBox"
                    		minlength="4">
						</div>
					</div>

					<div class="box">
						<div class="labelData">
							<label for="password" class="fl"> Password </label>
						</div>
						<div class="inputData">
							<input type="Password" required name="password" placeholder="Enter Password" class="data"
								   minlength="6"
								   pattern="(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}">
						</div>
					</div>

					<div class="box">
						<div class="labelData">
							<label for="email" class="fl"> Email ID: </label>
						</div>
						<div class="inputData">
							<input type="email" required name="email" placeholder="Enter Email" class="data"
                    		pattern="/\A[^@]+@([^@\.]+\.)+[^@\.]+\z/">
						</div>	
					</div>

					<div class="box">
						<div class="labelData">
							<label for="gender" class="fl"> Gender: </label>
						</div>
						<div class="inputData">
						 	<input type="radio" name="gender" class="genderData" value="Male" required> Male &nbsp; &nbsp; &nbsp; &nbsp;
            				<input type="radio" name="gender" class="genderData" value="Female" required> Female 
						</div>
					</div>


            		<div class="editButton">
            			<input type="submit" name="submit" value="Edit">
            		</div> 	
				</details>
			</div>

			<div class="wrapper-right">
				<details class="profileData">
					<summary>Edit Profile data</summary>
					<div class="box">
						<div class="labelProfileData">
							<label for="file">Upload photo</label>
						</div>
						<div class="inputProfileData">
							<input class="data" type="file" name="file" value="select photo" required>
						</div>
					</div>
					<div class="box">
						<div class="labelProfileData">
							<label for="profileRole">Role:</label>
						</div>
						<div class="inputProfileData">
							<input class="data" type="text" name="profileRole" required>
						</div>
					</div>
					<div class="box">
						<div class="labelProfileData">
							<label for="profileHobby">Hobby:</label>
						</div>
						<div class="inputProfileData">
							<input class="data" type="text" name="profileHobby" required>
						</div>
					</div>
       				<div class="editButton">
            			<input type="submit" name="submit" value="Edit">
            		</div> 		
				</details>
       		</div>
		</form>
	</div>
</#macro>
</body>
</html>