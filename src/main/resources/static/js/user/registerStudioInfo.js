$(document).ready(function () {
    $("#studioRegisterForm").validate({
        rules: {
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
        },
        messages: {
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
        }
    });
});