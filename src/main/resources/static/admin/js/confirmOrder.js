$(document).on('click', '.btn-confirm' ,function(){
    var orderDetailId = $(this).closest("tr").data("id");
    var orderDetailIds = [];
    orderDetailIds.push(orderDetailId);
    confirmOrderDetail(orderDetailIds)
});

$(document).on('click', '.btn-confirm-all' ,function(){
    Swal.fire({
        title: 'Are you sure?',
        text: 'Confirm all orders?',
        icon: 'question',
        confirmButtonText: 'Yes',
        showCancelButton: true
    }).then(function (result) {
        if (result.value) {
            var orderDetailIds = [];
            $(".orderDetail-item").each(function () {
                var orderDetailId = $(this).data("id");
                orderDetailIds.push(orderDetailId);
            });
            confirmOrderDetail(orderDetailIds)
        } else return false;
    });
});

$(document).on('click', '.btn-confirm-order' ,function(){
    var orderId = $(this).closest("tr").data("id");
    var orderIds = [];
    orderIds.push(orderId);
    confirmOrder(orderIds)
});

$(document).on('click', '.btn-confirm-all-order' ,function(){
    Swal.fire({
        title: 'Are you sure?',
        text: 'Confirm all orders?',
        icon: 'question',
        confirmButtonText: 'Yes',
        showCancelButton: true
    }).then(function (result) {
        if (result.value) {
            var orderIds = [];
            $(".order-item").each(function () {
                var orderId = $(this).data("id");
                orderIds.push(orderId);
            });
            confirmOrder(orderIds)
        } else return false;
    });
});

$(document).on('click', '.btn-cancel' ,function(){
    var orderDetailId = $(this).closest("tr").data("id");
    var orderDetailIds = [];
    orderDetailIds.push(orderDetailId);
    cancelOrderDetail(orderDetailIds)
});

$(document).on('click', '.btn-cancel-all' ,function(){
    Swal.fire({
        title: 'Are you sure?',
        text: 'Cancel all orders?',
        icon: 'question',
        confirmButtonText: 'Yes',
        showCancelButton: true
    }).then(function (result) {
        if (result.value) {
            var orderDetailIds = [];
            $(".orderDetail-item").each(function () {
                var orderDetailId = $(this).data("id");
                orderDetailIds.push(orderDetailId);
            });
            cancelOrderDetail(orderDetailIds)
        } else return false;
    });
});

$(document).on('click', '.btn-cancel-order' ,function(){
    var orderId = $(this).closest("tr").data("id");
    var orderIds = [];
    orderIds.push(orderId);
    cancelOrder(orderIds)
});

$(document).on('click', '.btn-cancel-all-order' ,function(){
    status = 1;
    Swal.fire({
        title: 'Are you sure?',
        text: 'Cancel all orders?',
        icon: 'question',
        confirmButtonText: 'Yes',
        showCancelButton: true
    }).then(function (result) {
        if (result.value) {
            var orderIds = [];
            $(".order-item").each(function () {
                var orderId = $(this).data("id");
                orderIds.push(orderId);
            });
            cancelOrder(orderIds)
        } else return false;
    });
});

function confirmOrderDetail(orderDetailIds) {
    $.ajax({
        url: '/manager/order/confirmOrderDetail',
        method: 'POST',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify(orderDetailIds),
        success: function (resp) {
            for(var i = 0; i < resp.data.length; i++){
                $("tbody").find("tr[data-id='" + resp.data[i] + "']").find(".btn-confirm").html("<i class=\"dripicons-checkmark\"></i>");
                $("tbody").find("tr[data-id='" + resp.data[i] + "']").find(".btn-cancel").html("Cancel");
            }
        },
        error: function (error) {
            Swal.fire({
                title: 'Can`t confirm order!',
                text: 'Try again later?',
                icon: 'error'
            });
        }
    });
}

function confirmOrder(orderIds) {
    $.ajax({
        url: '/manager/order/confirmOrder',
        method: 'POST',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify(orderIds),
        success: function (resp) {
            for(var i = 0; i < resp.data.length; i++){
                $("tbody").find("tr[data-id='" + resp.data[i] + "']").find(".btn-confirm-order").html("<i class=\"dripicons-checkmark\"></i>");
                $("tbody").find("tr[data-id='" + resp.data[i] + "']").find(".btn-cancel-order").html("Cancel");
            }
        },
        error: function (error) {
            Swal.fire({
                title: 'Can`t confirm order!',
                text: 'Try again later?',
                icon: 'error'
            });
        }
    });
}

function cancelOrderDetail(orderDetailIds) {
    $.ajax({
        url: '/manager/order/cancelOrderDetail',
        method: 'POST',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify(orderDetailIds),
        success: function (resp) {
            for(var i = 0; i < resp.data.length; i++){
                $("tbody").find("tr[data-id='" + resp.data[i] + "']").find(".btn-cancel").html("<i class=\"dripicons-trash\"></i>");
                $("tbody").find("tr[data-id='" + resp.data[i] + "']").find(".btn-confirm").html("Confirm");
            }
        },
        error: function (error) {
            Swal.fire({
                title: 'Can`t cancel order!',
                text: 'Try again later?',
                icon: 'error'
            });
        }
    });
}

function cancelOrder(orderIds) {
    $.ajax({
        url: '/manager/order/cancelOrder',
        method: 'POST',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify(orderIds),
        success: function (resp) {
            for(var i = 0; i < resp.data.length; i++){
                $("tbody").find("tr[data-id='" + resp.data[i] + "']").find(".btn-cancel-order").html("<i class=\"dripicons-trash\"></i>");
                $("tbody").find("tr[data-id='" + resp.data[i] + "']").find(".btn-confirm-order").html("Confirm");
            }
        },
        error: function (error) {
            Swal.fire({
                title: 'Can`t cancel order!',
                text: 'Try again later?',
                icon: 'error'
            });
        }
    });
}