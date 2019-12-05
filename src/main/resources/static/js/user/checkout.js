var products_checkout = [];
$(".cart-item").each(function () {
    var cartItem = {
        name: $(this).find(".cart-item-name").text(),
        quantity: 1,
        price: currency($(this).find(".cart-item-price").text().replace(/,/g, "") / 23600),
        sku: $(this).find(".cart-item-id").val(),
        currency: "USD"
    };
    products_checkout.push(cartItem);
});


function currency(x) {
    return Number.parseFloat(x).toFixed(2);
}

var total = 0;
for (var i = 0; i < products_checkout.length; i++) {
    total += parseFloat(products_checkout[i].price);
}

if($("#paypal-button").length > 0){
    var paypalActions;
    paypal.Button.render({
        // Configure environment
        env: 'sandbox',
        client: {
            sandbox: 'AYpIzlebp5E_20oD8ZnKDW00rQqc9SK9w7_rvBNninBVLtU21rlWfHj5SL6ir6Id_OUwwptQoxlKDq75',
            production: 'demo_production_client_id'
        },
        // Customize button (optional)
        locale: 'en_US',
        style: {
            size: 'large',
            color: 'black',
            shape: 'pill',
        },
        validate: function (actions) {
            actions.disable();
            paypalActions = actions;
        },
        onClick: function (e) {
            if ($("div.unconfirmed-item").length > 0 || $("div.declined-item").length > 0) {
                paypalActions.disable();
                Swal.fire({
                    title: 'Cannot checkout this order!',
                    text: 'There are still unconfirmed or declined products. Please wait or remove those products from your cart to continue',
                    icon: 'error'
                });
            } else {
                paypalActions.enable();
            }
        },
        // Set up a payment
        payment: function (data, actions) {
            return actions.payment.create({
                transactions: [{
                    amount: {
                        total: currency(total),
                        currency: 'USD',
                    },
                    payment_options: {
                        allowed_payment_method: 'INSTANT_FUNDING_SOURCE'
                    },
                    soft_descriptor: 'ECHI5786786',
                    item_list: {
                        items: products_checkout,
                        shipping_address: {
                            recipient_name: "Vu Tien Phuc",
                            line1: "36 bach mai",
                            city: 'San Jose',
                            country_code: 'US',
                            postal_code: '95131',
                            phone: "0962906297",
                            state: 'CA',
                        }
                    }
                }]
            });
        },
        payment_options: {
            allowed_payment_method: 'INSTANT_FUNDING_SOURCE'
        },
        onAuthorize: function (data, actions) {
            return actions.payment.execute().then(function () {
                $("#formform").attr("action", "/cart/checkout");
                $("#formform").attr("method", "post");
                $("#formform").submit();
            });
        },
        onError: function (err) {
            Swal.fire({
                title: 'Error!',
                text: 'Payment failed!',
                icon: 'error'
            });
        }
    }, '#paypal-button');
}

$("input[name='payment_type']").click(function () {
    var radioValue = $("input[name='payment_type']:checked").val();
    if (radioValue == 1) {
        $("#paypal-button").removeClass("hidden");
    } else {
        $("#paypal-button").addClass("hidden");
    }
});
// Give the parameter a variable name
var orderProductId = getParameterByName('orderProductId');

$(document).ready(function () {
    if (orderProductId == null || orderProductId == '') {
        $('.confirm-content').show();
    } else {
        $('.confirm-content').hide();
        $('.checkout-content').show();
    }
});

function confirmSubmit(e) {
    e.preventDefault();
    Swal.fire({
        title: 'Are you sure!',
        text: 'Do you want to confirm this order?',
        icon: 'question',
        confirmButtonText: 'Yes',
        showCancelButton: true
    }).then(function (result) {
        if (result.value) {
            $("#formform").attr("action", "/cart/confirm");
            $("#formform").attr("method", "post");
            $("#formform").submit();
        } else {
            return false;
        }
    });
}

function cancelSubmit(e) {
    e.preventDefault();
    Swal.fire({
        title: 'Are you sure!',
        text: 'Do you want to cancel this order?',
        icon: 'question',
        confirmButtonText: 'Yes',
        showCancelButton: true
    }).then(function (result) {
        if (result.value) {
            $("#formform").attr("action", "/cart/cancel");
            $("#formform").attr("method", "post");
            $("#formform").submit();
        } else return false;
    });
}

function checkoutSubmit(e) {
    e.preventDefault();
    if ($("div.unconfirmed-item").length > 0 || $("div.declined-item").length > 0) {
        Swal.fire({
            title: 'Cannot checkout this order!',
            text: 'There are still unconfirmed or declined products. Please wait or remove those products from your cart to continue',
            icon: 'error'
        });
    } else {
        Swal.fire({
            title: 'Are you sure!',
            text: 'Choose the payment method?',
            icon: 'question',
            confirmButtonText: 'Yes',
            showCancelButton: true
        }).then(function (result) {
            if (result.value) {
                $("#formform").attr("action", "/cart/checkout");
                $("#formform").attr("method", "post");
                $("#formform").submit();
            } else return false;
        });
    }
}

// Parse the URL parameter
function getParameterByName(name, url) {
    if (!url) url = window.location.href;
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}

$("#formform").validate({
    rules: {
        customerName: {
            required: true,
            maxlength: 50
        },
        customerEmail: {
            required: true,
            email: true
        },
        customerPhone: {
            required: true,
        },
        payment_type: {
            required: true
        }
    },
    messages: {
        customerName: {
            required: "Must enter name",
            maxlength: "Username must be less than 50 characters"
        },
        customerEmail: {
            required: "Must enter email",
            email: "Invalid email"
        },
        customerPhone: {
            required: "Must enter phone"
        },
        payment_type: {
            required: "Must choose payment method"
        }
    }
});

$(document).on('click', '.remove' ,function(){
    var currentItem = $(this);
    var product_id = $(this).data('product-id');
    var order_id = $(this).data('order-id');
    $.ajax({
        url: '/cart/removeFromCart',
        method: 'POST',
        data:{
            productId: product_id, orderId: order_id
        },
        success: function (resp) {
            location.reload();
        },
        error: function (error) {
            event.preventDefault();
            Swal.fire({
                title: 'Can`t remove product!',
                text: 'Try again later?',
                icon: 'error'
            });
        }
    });
});