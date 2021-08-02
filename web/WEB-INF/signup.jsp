<%-- 
    Document   : signup
    Created on : Jun 9, 2021, 10:28:55 PM
    Author     : 631503
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="styles/signup.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SingleParentLife</title>
        <link rel="stylesheet" href="styles/common.css">
        <style>
            .container{
                background: #ffffff;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <img src="images/LOGO.png" alt="" id="logo">
            <a href="index" style="font-size: 30px; text-decoration: none; color:#4f66da;">🠔</a>
            <h1>SingleParentLife</h1>
            <form action="signup" method="post">
                <div class="input-control">
                    <h2>Email</h2>
                    <input name="email" type="text">
                    <div>
                        <button type="button">Next</button>
                    </div>
                </div>

                <!--div class="input-control hidden">
                    <h2>Email Verification Code</h2>
                    <input name="email code" type="text">
                    <div>
                        <button type="button">Next</button>
                    </div>
                </div-->

                <div class="input-control hidden">
                    <h2>Password</h2>
                    <input name="password" type="password">
                    <!--h2>Confirm Password</h2>
                    <input name="confirmpassword" type="password"-->
                    <div>
                        <button type="button">Next</button>
                    </div> 
                </div>

                <div class="input-control hidden">
                    <h2>First Name</h2>
                    <input name="firstName" type="text">
                    <h2>Last Name</h2>
                    <input name="lastName" type="text">
                    <div>
                        <button type="button">Next</button>
                    </div>
                </div>

                <div class="input-control hidden">
                    <h2>City</h2>
                    <input name="city" type="text">
                    <h2>Postal Code/Zip Code</h2>
                    <input name="postalcodeorzipcode" type="text">
                    <h2>Province/State</h2>
                    <input name="provinceorstate" type="text">
                    <h2>Country</h2>
                    <input name="country" type="text">
                    <div>
                        <button type="button">Next</button>
                    </div>
                </div>

                <div class="input-control hidden">
                    <h2>Phone Number</h2>
                    <input name="phoneNumber" type="text">
                    <h2>Date of Birth</h2>
                    <input type="date">
                    <h2>Gender</h2>
                    <select name="gender">
                        <option value="M">Male</option>
                        <option value="F">Female</option>
                        <option value="O">Other</option>
                    </select>
                    <div>
                        <button type="button">Next</button>
                    </div>
                </div>

                <!--https://www.w3schools.com/howto/tryit.asp?filename=tryhow_css_switch-->
                <!--div class="input-control hidden">
                    <h2>Preferences</h2>
                    <p>Enable Notifications
                        <label class="switch">
                            <input type="checkbox">
                            <span class="slider round"></span>
                        </label></p>
                    <p>Enable Location Access*
                        <label class="switch">
                            <input type="checkbox">
                            <span class="slider round"></span>
                        </label></p>
                    <p><small>*Required for Full App Functionality</small></p>
                    <div>
                        <button type="button">Next</button>
                    </div>
                </div-->

                <div class="input-control hidden">
                    <h2>Add a Photo</h2>
                    <input type="file">
                    <div>
                        <button type="button">Next</button>
                    </div>
                </div>

                <!--https://www.w3schools.com/tags/att_input_type_checkbox.asp-->
                <!--div class="input-control hidden">
                    <div>
                        <button type="button" href="https://google.com">Terms and Conditions</button>
                <button type="button" href="https://google.com">Privacy Policy</button>
                <p></p>
                <input type="checkbox" name="crimeclearancecheck" value="Y">
                <label for="crimeclearancecheck">Police Clearance Check*</label>
                <p><small>*Required for Full App Functionality</small></p>
                <button type="button" href="match">Agree</button>
            </div-->

        </div>
    </form>
</div>

<script type="text/javascript" >
    let btns = document.querySelectorAll('button')
    btns.forEach((item, index) => {
        item.addEventListener('click', function () {
            if (index === btns.length - 1) {
                document.querySelector('form').submit()
                alert('login was successful')
            } else {
                item.parentNode.parentNode.classList.add('hidden')
                btns[index + 1].parentNode.parentNode.classList.remove('hidden')
            }
        })
    })
</script>
</body>
</html>
