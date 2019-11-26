function addCart(product_id) {
    $.ajax({
        url: 'http://localhost:8080/cart/buy/' + product_id,
        method: 'GET',
        success: function (resp) {
            console.log(resp);
            alert("success");
        },
        error: function (error) {
            alert("error");
        }
    });
}

$(document).on('click', '.btn-add-cart' ,function(){
    var product_id = $(this).attr('id').replace('add-cart-', '');
    addCart(product_id);
});

$('.btn-add-cart-product-detail').click(function(){
    var product_id = $(this).attr('id').replace('add-cart-', '');
    addCart(product_id);
});