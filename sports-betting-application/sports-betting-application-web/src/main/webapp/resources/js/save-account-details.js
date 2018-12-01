$(document).ready(function () {
    $("#saveAccountDetailsButton").click(function () {
        $.ajax({
            url: "saveAccountDetails",
            data: {
                playerName: $("#playerName").val(),
                playerDateOfBirth: $("#playerDateOfBirth").val(),
                playerAccountNumber: $("#playerAccountNumber").val()
            },
            success: function (response) {
                var messageDiv = $("#saveAccountDetailsResponseDiv");
                var messageText = $("#saveAccountDetailsResponseText")
                if(response.successful) {
                    messageDiv.addClass("alert alert-success");
                    messageDiv.removeClass("alert-danger");
                    messageText.text(response.status)
                } else {
                    messageDiv.addClass("alert alert-danger");
                    messageDiv.removeClass("alert-success");
                    messageText.text(response.status);
                }

            }
        })
    });
});