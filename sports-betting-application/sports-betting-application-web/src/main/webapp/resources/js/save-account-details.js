$(document).ready(function () {
    var alertBox = $("#saveAccountDetailsResponseDiv");
    var alertText = $("#saveAccountDetailsResponseText");

    $("#saveAccountDetailsButton").click(function() {
        console.log("save account details button clicked");
        $.ajax({
            url: "saveAccountDetails",
            data: {
                playerName: $("#playerName").val(),
                playerDateOfBirth: $("#playerDateOfBirth").val(),
                playerAccountNumber: $("#playerAccountNumber").val()
            },
        success: function (response) {

            if (response.successful) {
                    greenAlertBox();
                    alertText.text(response.status)
                } else {
                    redAlertBox();
                    alertText.text(response.status);
                    $("#playerDateOfBirth").addClass("error-input");
                }
            }
        })
    });


    function redAlertBox() {
        alertBox.addClass("alert alert-danger");
        alertBox.removeClass("alert-success");
    }

    function greenAlertBox() {
        alertBox.addClass("alert alert-success");
        alertBox.removeClass("alert-danger");
    }
});