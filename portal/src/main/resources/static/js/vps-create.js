$(document).ready(function () {
    $(".location").click(function(){
        let location = this.value;
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: baseUrl + "/plan?location=" + location,
            headers:  {
                'X-CSRF-TOKEN': token
            },
            dataType: 'json',
            success: function (result) {
                console.log(JSON.stringify(result));
                $("#product-id").html('');
                $.each(result.items, function(){
                    $("#product-id").append('<option value="'+ this.id +'">'+ this.name +'</option>');
                })
            },
            error: function (e) {
                console.log("ERROR: ", e);
            }
        });
    });

    $(".operating-system").click(function(){
        let code = this.value;
        console.log("os: " + code);
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: baseUrl + "/os?code=" + code,
            headers:  {
                'X-CSRF-TOKEN': token
            },
            dataType: 'json',
            success: function (result) {
                console.log(JSON.stringify(result));
                // $("#os").html('');
                // $.each(result.items, function(){
                //     $("#os").append('<option value="'+ this.id +'">'+ this.name +'</option>');
                // })
            },
            error: function (e) {
                console.log("ERROR: ", e);
            }
        });
    });

    $("#proceed-order-vps").click(function(){
        let hostname = $("#server-name").val();
        let billingCycle = $('input[name="billing-cycle"]:checked').val();
        let productId = $("#product-id").val();
        let location = $('input[name="location"]:checked').val();
        let os = $('input[name="os"]:checked').val();
        let promo = $("#promo").val();
        let paymentMethod = $('input[name="payment-method"]:checked').val();
        let firewallGroup =  $("#firewall-group").val();
        let sshKey =  $("#ssh-key").val();
        let startupScript =  $("#startup-script").val();

        let formData = {
            hostname: hostname,
            location: location,
            productId: productId,
            os: os,
            promo: promo,
            paymentMethod: paymentMethod,
            billingCycle: billingCycle,
            firewallGroup: firewallGroup,
            sshKey: sshKey,
            startupScript: startupScript

        }
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
                console.log(JSON.stringify(result));
                Swal.fire({
                    position: "top-end",
                    icon: "success",
                    title: "Tạo VPS thành công.",
                    showConfirmButton: !1,
                    timer: 5000
                })
            },
            error: function (e) {
                console.log("ERROR: ", e);
                Swal.fire({
                    position: "top-end",
                    icon: "warning",
                    title: "Tạo VPS thất bại!",
                    showConfirmButton: !1,
                    timer: 5000
                })
            }
        });
    });

    $('#generateBtn').click(function() {
        const passwordLength = 12;
        const newPassword = generatePassword(passwordLength);
        $('#password').val(newPassword);
    });
})

function generatePassword(length) {
    const charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+~`|}{[]\:;?><,./-=";
    let password = "";
    for (let i = 0; i < length; i++) {
        const randomIndex = Math.floor(Math.random() * charset.length);
        password += charset.charAt(randomIndex);
    }
    return password;
}
