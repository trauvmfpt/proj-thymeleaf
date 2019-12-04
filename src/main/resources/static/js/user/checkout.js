var products_checkout = [];
$(".cart-item").each(function () {
   var cartItem = {
       name: $(this).find(".cart-item-name").text(),
       quantity: 1,
       price: currency($(this).find(".cart-item-price").text().replace(/,/g, "")/23600),
       sku: $(this).find(".cart-item-id").val(),
       currency: "USD"
   }
   products_checkout.push(cartItem);
});


function currency(x) {
    return Number.parseFloat(x).toFixed(2);
}

var total = 0;
for(var i = 0; i < products_checkout.length; i++){
    total += parseFloat(products_checkout[i].price);
}

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
    // Set up a payment
    payment: function(data, actions) {
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
    onAuthorize: function(data, actions) {
        return actions.payment.execute().then(function(){
            $("#formform").attr("action", "/cart/checkout");
            $("#formform").attr("method", "post");
            $("#formform").submit();
        });
    }
}, '#paypal-button');