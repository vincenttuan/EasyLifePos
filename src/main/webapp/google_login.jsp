<%-- 
    889955278565-hh2p89ri0bek2eo0r8dkcjamaok12avp.apps.googleusercontent.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <meta name="google-signin-client_id" content="889955278565-hh2p89ri0bek2eo0r8dkcjamaok12avp.apps.googleusercontent.com">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Google login</title>
        <script>
            function onSignIn(googleUser) {
                var profile = googleUser.getBasicProfile();
                console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
                console.log('Name: ' + profile.getName());
                console.log('Image URL: ' + profile.getImageUrl());
                console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
            }
            function signOut() {
                var auth2 = gapi.auth2.getAuthInstance();
                auth2.signOut().then(function () {
                    console.log('User signed out.');
                });
            }
        </script>
    </head>
    <body>
        <h1>Google login test</h1>
        <div class="g-signin2" data-onsuccess="onSignIn"></div>
        <a href="#" onclick="signOut();">Sign out</a>
        
    </body>
</html>
