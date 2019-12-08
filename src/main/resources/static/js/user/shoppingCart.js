function loadCart() {
    $.ajax({
        url: '/cart/get/',
        method: 'GET',
        success: function (resp) {
            var content = '';
            if (!Array.isArray(resp.data) || !resp.data.length || resp.data.length == 0) {
                $('.badge.badge-info.badge-pill.noti-icon-badge').text("0");
                $('.dropdown-item.noti-title').find('span').text("0");
            } else {
                $('.badge.badge-info.badge-pill.noti-icon-badge').text(resp.data.length);
                $('.dropdown-item.noti-title').find('span').text(resp.data.length);
                for (i = 0; i < resp.data.length; i++) {
                    content += '<a href="/product/' + resp.data[i].product.id + '" class="dropdown-item notify-item">';
                    content += '<div class="notify-icon" style="width: 40%;">';
                    content += '<img src="' + resp.data[i].product.thumbnail + '" alt="" style="width: 75px;">';
                    content += '<b style="color: black;" style="max-width: 40%;">' + resp.data[i].product.name + '</b>';
                    content += '</div>';
                    content += '<p class="notify-details" style="color: black;">';
                    content += '<small class="text-muted">' + resp.data[i].currentPrice + '</small>';
                    content += '</p>';
                    content += '</a>';
                }
            }
            $('#cart-items-wrapper').html(content);
        },
        error: function (error) {
            console.log(error);
        }
    });
}
function addToCart(product_id, btn) {
    if($("#currentUser").text() != ""){
        $.ajax({
            url: '/cart/buy/' + product_id,
            method: 'GET',
            success: function (resp) {
                if (btn == 'btn-add-cart') {
                    event.preventDefault();
                    Swal.fire({
                        title: 'Product Added!',
                        text: 'Do you want to check out now?',
                        icon: 'success',
                        showCancelButton: true,
                        confirmButtonColor: '#3085d6',
                        cancelButtonColor: '#d33',
                        cancelButtonText: 'No, continue shopping!',
                        confirmButtonText: 'Yes, view my cart!'
                    }).then(function(result){
                        if (result.value){
                            location.href = "/cart";
                        }
                    });
                } else if (btn == 'btn-to-cart') {
                    location.href = "/cart";
                }
            },
            error: function (error) {
                event.preventDefault();
                Swal.fire({
                    title: 'Can`t add product!',
                    text: 'Try again later?',
                    icon: 'error'
                });
            }
        });
    }
    else{
        var el = document.createElement('div')
        el.innerHTML = "Please click <a href='/account/login'>here</a> to login"
        Swal.fire({
            title: 'You must login to buy a product',
            html: el,
            icon: 'error'
        });
    }
}

$(document).on('click', '.btn-add-cart' ,function(){
    var product_id = $(this).attr('id').replace('add-cart-', '');
    addToCart(product_id, 'btn-add-cart');
    // loadCart();
});

$(document).on('click', '.btn-to-cart' ,function(){
    var product_id = $(this).attr('id').replace('add-cart-', '');
    addToCart(product_id, 'btn-to-cart');
    // loadCart();
});

//cái này khác gì cái trên?
// $('.btn-add-cart-product-detail').click(function(){
//     var product_id = $(this).attr('id').replace('add-cart-', '');
//     addCart(product_id);
// });