let alertPlaceholder = document.getElementById("liveAlertPlaceholder");
let alertTrigger = document.getElementById("proceed-order-vps");

function alert(e, t) {
    let l = document.createElement("div");
    l.innerHTML = '<div class="alert alert-' + t + ' alert-dismissible" role="alert"><i class="mdi mdi-check-all me-2"></i>' + e + '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div>', alertPlaceholder.append(l)
}

alertTrigger && alertTrigger.addEventListener("click", function () {
    alert("Nice, you triggered this alert message!", "info")
});
