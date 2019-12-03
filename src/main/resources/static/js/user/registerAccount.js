$(document).ready(function () {
    $("#accountRegisterForm").validate({
        rules: {
            username: {
                required: true,
                minlength: 7,
                maxlength: 50
            },
            password:{
                required: true,
                minlength: 7,
            },
            role: {
                required: true
            },
            cfmPassword: {
                equalTo: "#txtNewPassword",
                minlength: 7
            }
        },
        messages: {
            username: {
                required: "Must enter username",
                minlength: "Username must be more than 7 characters",
                maxlength: "Username must be less than 50 characters"
            },
            password: {
                required: "Must enter password",
                minlength: "Password must be more than 7 characters"
            },
            role: {
                required: "Must choose a role"
            },
            cfmPassword: {
                equalTo: "Password does not match"
            }
        }
    });
});