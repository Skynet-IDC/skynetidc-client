!function (t) {
    "use strict";
    function e() {}
    e.prototype.init = function () {
        t(".btn-delete").click(function () {
            const idVps = this.id;
            Swal.fire({
                title: "Delete VPS",
                icon: "warning",
                html: 'Do you want to remove this VPS ?',
                showCancelButton: !0,
                confirmButtonText: "Delete",
                showLoaderOnConfirm: !0,
                confirmButtonColor: "#556ee6",
                cancelButtonColor: "#f46a6a",
                preConfirm: function (n) {
                    return new Promise(function (t, e) {
                        setTimeout(function () {
                            "taken@example.com" === n ? e("This email is already taken.") : t()
                        }, 500)
                    })
                },
                allowOutsideClick: !1
            }).then(function (t) {
                console.log("ERROR: " + JSON.stringify(t));
                if (t.isConfirmed) {
                    $.ajax({
                        type: "DELETE",
                        contentType: "application/json",
                        url: baseUrl + '/vm'  + '?' + $.param({"id": idVps}),
                        headers:  {
                            'X-CSRF-TOKEN': $("meta[name='_csrf']").attr("content")
                        },
                        dataType: 'json',
                        success: function (result) {
                            Swal.fire({
                                icon: "success",
                                title: "Delete successfully!",
                                confirmButtonColor: "#556ee6"
                            });
                            $('#tr' + idVps).remove();
                        },
                        error: function (e) {
                            console.log("ERROR: ", e);
                        }
                    });

                }
            })
        })
    }, t.SweetAlert = new e, t.SweetAlert.Constructor = e
}(window.jQuery), function () {
    "use strict";
    window.jQuery.SweetAlert.init()
}();
