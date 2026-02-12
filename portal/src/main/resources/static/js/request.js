$(document).ready(function () {
    $("#customerForm").submit(function (event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();

        // PREPARE FORM DATA
        let formData = {
            name: $("#name").val(),
            email: $("#email").val(),
            address: $("#address").val()
        }

        ajaxPost(formData);
    });

    $("#proceed").click(function(){
        let serviceId = $("#plan").val();
        let plan = $("#plan11").val();
        let hostname = $('input[name="hostname"]:checked').val();
        let location = $('input[name="location"]:checked').val();
        let os = $('input[name="os"]:checked').val();
        let promo = $("#promo").val();

        let paymentMethod = $('input[name="paymentMethod"]:checked').val();
        let billingCycle = $('input[name="billingCycle"]:checked').val();

        // PREPARE FORM DATA
        let formData = {
            serviceId: serviceId,
            hostname: hostname,
            location: location,
            os: os,
            promo: promo,
            paymentMethod: paymentMethod,
            billingCycle: billingCycle
        }
        ajaxPost(formData);
    });

    function ajaxPost(formData) {
        // DO POST
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: baseUrl + "/order/vm",
            headers:  {
                'X-CSRF-TOKEN': token
            },
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function (result) {
                $(".alert").addClass("show");
                console.log(JSON.stringify(result));
            },
            error: function (e) {
                console.log("ERROR: ", e);
            }
        });
    }
})
