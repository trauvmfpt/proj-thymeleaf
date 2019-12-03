$(document).ready(function () {
    $("#customerRegisterForm").validate({
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
            cfmPassword: {
                equalTo: "#txtNewPassword",
                minlength: 7
            },
            email: {
                required: true,
                email: true
            },
            fullname:{
                required: true
            },
            address: {
                required: true
            },
            phone: {
                required: true
            },
            birthday: {
                required: true
            },
            gender: {
                required: true
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
            cfmPassword: {
                equalTo: "Password does not match"
            },
            email: {
                required: "Must enter email",
                email: "Invalid Email"
            },
            fullname: {
                required: "Must enter fullname"
            },
            address: {
                required: "Must enter address"
            },
            phone: {
                required: "Must enter phone"
            },
            birthday: {
                required: "Must enter birthday"
            },
            gender: {
                required: "Must choose gender"
            }
        }
    });
});