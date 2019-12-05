function addToCart(product_id, btn) {
    if($("#currentUser").text() != ""){
        $.ajax({
            url: 'http://localhost:8080/cart/buy/' + product_id,
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
                            location.href = "http://localhost:8080/cart";
                        }
                    });
                } else if (btn == 'btn-to-cart') {
                    location.href = "http://localhost:8080/cart";
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
});

$(document).on('click', '.btn-to-cart' ,function(){
    var product_id = $(this).attr('id').replace('add-cart-', '');
    addToCart(product_id, 'btn-to-cart');
});

//cái này khác gì cái trên?
// $('.btn-add-cart-product-detail').click(function(){
//     var product_id = $(this).attr('id').replace('add-cart-', '');
//     addCart(product_id);
// });