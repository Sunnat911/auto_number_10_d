function order(e){
    console.log(e.target.value)

    $.ajax({
        url: "/admin/orders/state/?state="+state+"",
        type: "GET",
        success: function (response) {

        },
        error: function (request, status, error) {

        }
    });
}