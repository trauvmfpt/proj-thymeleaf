$(document).ready(function () {

    /* 1. Visualizing things on Hover - See next part for action on click */
    $('#stars li').on('mouseover', function () {
        var onStar = parseInt($(this).data('value'), 10); // The star currently mouse on

        // Now highlight all the stars that's not after the current hovered star
        $(this).parent().children('li.star').each(function (e) {
            if (e < onStar) {
                $(this).addClass('hover');
            } else {
                $(this).removeClass('hover');
            }
        });

    }).on('mouseout', function () {
        $(this).parent().children('li.star').each(function (e) {
            $(this).removeClass('hover');
        });
    });


    /* 2. Action to perform on click */
    $('#stars li').on('click', function () {
        var onStar = parseInt($(this).data('value'), 10); // The star currently selected
        var stars = $(this).parent().children('li.star');

        var albumId;
        var photographerId;
        var productId;
        var studioId;

        if (postType == "album") {
            albumId = newsId;
        } else if (postType == "photographer") {
            photographerId = newsId;
        } else if (postType == "product") {
            productId = newsId;
        } else if (postType == "studio") {
            studioId = newsId;
        }
        var ratingDTO = {
            studioId: studioId,
            albumId: albumId,
            productId: productId,
            photographerId: photographerId,
            value: onStar
        };

        $.ajax({
            url: '/api/rating/save/',
            data: JSON.stringify(ratingDTO),
            type: 'POST',
            contentType: 'application/json',
            dataType: 'json',
            success: function (result) {
                getRating();

                for (var i = 0; i < stars.length; i++) {
                    $(stars[i]).removeClass('selected');
                }

                for (var i = 0; i < onStar; i++) {
                    $(stars[i]).addClass('selected');
                }

                // JUST RESPONSE (Not needed)
                var ratingValue = parseInt($('#stars li.selected').last().data('value'), 10);
                var msg = "";
                if (ratingValue > 1) {
                    msg = "Thanks! You rated this " + ratingValue + " stars.";
                } else {
                    msg = "We will improve ourselves. You rated this " + ratingValue + " stars.";
                }
                responseMessage(msg);
            },
            error: function (xhr, status, error) {
                if(xhr.responseJSON.status == 401){
                    var el = document.createElement('div')
                    el.innerHTML = "Please click <a href='/account/login'>here</a> to login"
                    Swal.fire({
                        title: 'You must login as a customer to rate',
                        html: el,
                        icon: 'error'
                    });
                }
                else if(xhr.responseJSON.status == 500){
                    Swal.fire({
                        title: 'Error! Something has happened!',
                        content: 'Please try again latter!',
                        icon: 'error'
                    });
                }
            }
        });
    });
});

function getRating(){
    $.ajax({
        url: '/api/rating/getRatingByPostId?postId=' + newsId + "&postType=" + postType,
        type: 'GET',
        contentType: 'application/json',
        dataType: 'json',
        success: function (result) {
            $(".rating-number").text(result.data);
            var stars = $('#stars li').parent().children('li.star');
            var onStar = Math.floor(result.data);
            for (var i = 0; i < stars.length; i++) {
                $(stars[i]).removeClass('selected');
            }

            for (var i = 0; i < onStar; i++) {
                $(stars[i]).addClass('selected');
            }
        },
        error: function () {
        }
    });
}
$(document).ready(function () {
    getRating();
});


function responseMessage(msg) {
    $('.success-box').fadeIn(200);
    $('.success-box').removeClass("hidden");
    $('.success-box div.text-message').html("<span>" + msg + "</span>");
}