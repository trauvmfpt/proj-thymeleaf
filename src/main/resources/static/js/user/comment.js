var x = 3;
var y = 2;

function prepareDate(d) {
    [d, m, y] = d.split("-"); //Split the string
    return [y, m - 1, d]; //Return as an array with y,m,d sequence
}

var periods = {
    month: 30 * 24 * 60 * 60 * 1000,
    week: 7 * 24 * 60 * 60 * 1000,
    day: 24 * 60 * 60 * 1000,
    hour: 60 * 60 * 1000,
    minute: 60 * 1000
};

function formatTime(timeCreated) {
    var diff = Date.now() - timeCreated;

    if (diff > periods.month) {
        // it was at least a month ago
        return Math.floor(diff / periods.month) + "m ago";
    } else if (diff > periods.week) {
        return Math.floor(diff / periods.week) + "w ago";
    } else if (diff > periods.day) {
        return Math.floor(diff / periods.day) + "d ago";
    } else if (diff > periods.hour) {
        return Math.floor(diff / periods.hour) + "h ago";
    } else if (diff > periods.minute) {
        return Math.floor(diff / periods.minute) + "m ago";
    }
    return "Just now";
}

$(document).ready(function () {
    getComment(x);
});

$(document).click(function (e) {
    var target = e.target;
    if (!$(target).is('.toolbox') && !$(target).parents().is('.toolbox') && !$(target).is('.btn-tool') && !$(target).parents().is('.btn-tool')) {
        $('.toolbox').addClass("hidden");
        $('.arrow-up').addClass("hidden");
    }
});

// $(document).on("click", ".btn-reply", function () {
//     $(".reply-box").removeClass("hidden");
//     $(".reply-box").addClass("hidden");
//     $(this).closest("article").find(".reply-box").removeClass("hidden");
//     $(this).closest("article").find(".reply-box").focus();
// });

$(document).on("click", "#btn_submit_comment", function () {
    postComment();
});

$(document).on("keypress", "#comment_body", function (e) {
    var key = e.which;
    if (key == 13) {
        postComment();
    }
});

function postComment() {
    x = $(".comment-father").not('.hidden').length + 1;
    var commentBody = $("#comment_body").val();
    var albumId;
    var photographerId;
    var productId;
    var studioId;
    if(postType == "album"){
        albumId = newsId;
    }
    else if(postType == "photographer"){
        photographerId = newsId;
    }
    else if(postType == "product"){
        productId = newsId;
    }
    else if(postType == "studio"){
        studioId = newsId;
    }
    var commentDTO = {
        studioId: studioId,
        albumId: albumId,
        productId: productId,
        photographerId: photographerId,
        content: commentBody
    };
    $.ajax({
        url: '/api/comment/save/',
        data: JSON.stringify(commentDTO),
        type: 'POST',
        contentType: 'application/json',
        dataType: 'json',
        success: function (result) {
            getComment(x);
            $("#comment_body").val('');
        },
        error: function (xhr, status, error) {
            if (xhr.responseJSON.status == 401) {
                var el = document.createElement('div')
                el.innerHTML = "Please click <a href='/account/login'>here</a> to login"
                Swal.fire({
                    title: 'You must login as a customer to comment',
                    html: el,
                    icon: 'error'
                });
            } else if (xhr.responseJSON.status == 500) {
                Swal.fire({
                    title: 'Error! Something has happened!',
                    content: 'Please try again latter!',
                    icon: 'error'
                });
            }
        },
    });
}

// $(document).on("keypress", ".reply-box", function (e) {
//     x = $(".comment-father").not('.hidden').length + 1;
//     var key = e.which;
//     if (key == 13) {
//         $.ajax({
//             url: '/News/default.aspx/CreateReply',
//             data: JSON.stringify({ commentBody: $(this).val(), commentId: $(this).closest("article").data("id") }),
//             type: 'POST',
//             contentType: 'application/json',
//             dataType: 'json',
//             success: function (result) {
//                 if (result.d == false) {
//                     alert("Bạn phải đăng nhập để có thể bình luận")
//                     return false;
//                 }
//                 getComment(x, y);
//             },
//             error: function () {
//             }
//         });
//     }
// });

$(document).on("click", ".btn-tool", function () {
    $(this).closest("li").find(".toolbox").removeClass("hidden")
    $(this).closest("li").find(".arrow-up").removeClass("hidden")
});

$(document).on("click", ".btn-delete-comment", function () {
    if (confirm("Xóa bình luận này?")) {
        $.ajax({
            url: '/comment/delete/' + $(this).data("id"),
            type: 'GET',
            contentType: 'application/json',
            dataType: 'json',
            success: function (result) {
                getComment(x);
            },
            error: function () {
            }
        });
    }
});

// $(document).on("click", ".btn-delete-reply", function () {
//     if (confirm("Xóa bình luận này?")) {
//         $.ajax({
//             url: '/News/default.aspx/DeleteReply',
//             data: JSON.stringify({ replyId: $(this).data("id") }),
//             type: 'POST',
//             contentType: 'application/json',
//             dataType: 'json',
//             success: function (result) {
//                 getComment(x);
//             },
//             error: function () {
//             }
//         });
//     }
// });


function getComment(x) {
    $(document).ready(function () {
        $.ajax({
            url: '/api/comment/getAllByPostId/' + newsId,
            type: 'GET',
            contentType: 'application/json',
            dataType: 'json',
            success: function (result) {
                var html = "";
                for (var i = 0; i < result.data.length; i++) {
                    if(result.data[i].studioId != 0){
                        html += '<article data-id = "' + result.data[i].studioId + '"><li class="comment user-comment comment-father hidden">';
                    }
                    else if(result.data[i].productId != 0){
                        html += '<article data-id = "' + result.data[i].productId + '"><li class="comment user-comment comment-father hidden">';
                    }
                    else if(result.data[i].photographerId != 0){
                        html += '<article data-id = "' + result.data[i].photographerId + '"><li class="comment user-comment comment-father hidden">';
                    }
                    else if(result.data[i].albumId != 0){
                        html += '<article data-id = "' + result.data[i].albumId + '"><li class="comment user-comment comment-father hidden">';
                    }
                    html += '<a class="avatar"><img src="https://banner2.cleanpng.com/20180828/sxw/kisspng-clip-art-computer-icons-user-download-chamber-of-d-talonpaw-svg-png-icon-free-download-175238-on-5b84c95a116717.2809616615354289540713.jpg" width="35" alt="Profile Avatar" /></a><div class="comment-text">'
                    html += '<div class="info"><a>' + result.data[i].userName + '</a></div>';
                    html += '<p>' + result.data[i].content + '</p>';
                    if (currentRole == "ROLE_5" || currentUser == result.data[i].userName) {
                        html += '<i class="fa fa-ellipsis-h btn-tool"></i>';
                        html += '<div class="arrow-up hidden"></div>';
                        html += '<div class="toolbox hidden">';
                        html += '<div class="delete-comment btn-delete-comment btn-delete-comment" data-id = "' + result.data[i].id + '"> Delete </div>';
                        html += '</div>';
                    }
                    html += '</div>'
                    html += '<div class="comment-time">'
                    html += '<p>' + formatTime(result.data[i].createdAt) + '</p>'
                    html += '</div></li></article>'

                    // for (var j = 0; j < result.d[i].CommentReplies.length; j++) {
                    //     html += '<li class="comment user-comment reply hidden">';
                    //     html += '<a class="avatar"><img src="../assets/images/user.jpg" width="35" alt="Profile Avatar" /></a><div class="comment-text">'
                    //     html += '<div class="info"><a>' + result.d[i].CommentReplies[j].UserName + '</a></div>';
                    //     html += '<p>' + result.d[i].CommentReplies[j].Body + '</p>';
                    //     if (currentRole == "Administrator" || currentUser == result.d[i].CommentReplies[j].UserName) {
                    //         html += '<i class="fa fa-ellipsis-h btn-tool"></i>';
                    //         html += '<div class="arrow-up hidden"></div>';
                    //         html += '<div class="toolbox hidden">';
                    //         html += '<div class="delete-comment btn-delete-reply" data-id = "' + result.d[i].CommentReplies[j].Id + '"> Xóa bình luận </div>';
                    //         html += '<div class="edit-comment"> Sửa bình luận </div >';
                    //         html += '</div>';
                    //     }
                    //     html += '</div>';
                    //     html += '<div class="comment-time">'
                    //     html += '<p class="btn-reply"><i class="fa fa-reply" data-toggle="tooltip" data-placement="bottom" title="Reply!"></i>Trả lời</p>'
                    //     html += '<p>' + formatTime(parseInt(result.d[i].CommentReplies[j].CreateTime.split('(').pop().split(')')[0])) + '</p>'
                    //     html += '</div></li>'
                    // }
                    // if (result.d[i].CommentReplies.length > 2) {
                    //     html += '<h5 style="text-align: center; margin-bottom: 20px;" class = "loadMoreReply hidden">Hiển thị thêm trả lời</h4>'
                    // }
                    // html += '<textarea rows="1" class="form-control reply-box hidden" placeholder="Add a reply"></textarea></article>'
                }
                if (result.data.length > 3) {
                    html += '<h3 style="text-align: center" id = "loadMore">Load more</h3>'
                }
                $(".comment-section").html("");
                $(".comment-section").html(html);

                size_li = $(".comment-father").length;

                $('.comment-father:lt(' + x + ')').removeClass('hidden');
                $('.comment-father:lt(' + x + ')').closest('article').find('.reply:lt(' + y + ')').removeClass('hidden');
                $('.comment-father:lt(' + x + ')').closest('article').find('.loadMoreReply:lt(' + y + ')').removeClass('hidden');
                if (x == size_li) {
                    $('#loadMore').hide();
                }

                $('#loadMore').click(function () {
                    x = (x + 3 <= size_li) ? x + 3 : size_li;
                    $('.comment-father:lt(' + x + ')').removeClass('hidden');
                    $('.comment-father:lt(' + x + ')').closest('article').find('.reply:lt(' + y + ')').removeClass('hidden');
                    // $('.comment-father:lt(' + x + ')').closest('article').find('.loadMoreReply:lt(' + y + ')').removeClass('hidden');
                    if (x == size_li) {
                        $('#loadMore').hide();
                    }
                });

                // $('.loadMoreReply').click(function () {
                //     size_li_reply = $(this).closest('article').find('.reply').length;
                //     y = (x + 2 <= size_li_reply) ? y + 2 : size_li_reply;
                //     $(this).closest('article').find('.reply:lt(' + y + ')').removeClass('hidden');
                //     if (y == size_li_reply) {
                //         $(this).hide();
                //     }
                // });
            },
            error: function () {
            }
        });
    });
}