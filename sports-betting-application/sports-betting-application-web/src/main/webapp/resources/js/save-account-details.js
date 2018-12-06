$(document).ready(function () {
    var alertBox = $("#saveAccountDetailsResponseDiv");
    var alertText = $("#saveAccountDetailsResponseText");

    var playerNameInput = $("#playerName");
    var dateOfBirthInput = $("#playerDateOfBirth");
    var accountNumberInput = $("#playerAccountNumber");

    $("#saveAccountDetailsButton").click(function () {
        console.log("save account details button clicked");
        $.ajax({
            url: "saveAccountDetails",
            data: {
                playerName: $("#playerName").val(),
                playerDateOfBirth: $("#playerDateOfBirth").val(),
                playerAccountNumber: $("#playerAccountNumber").val()
            },
            success: function (response) {
                reloadForm();
                if (response.valid) {
                    showSuccessAlertBox();
                } else {
                    showErrors(response);
                }
            }
        })
    });

    function reloadForm() {
        deleteAlertBoxes();
        deleteInputOutlines();
    }

    function deleteAlertBoxes() {
        $(".alert").remove();
    }

    function deleteInputOutlines() {
        $(".error-input").removeClass("error-input");
    }

    function showErrors(response) {
        var fullNameError = response.fullNameError;
        var accountNumberError = response.accountNumberError;
        var dateOfBirthError = response.dateOfBirthError;

        if(!(response.fullNameError === "")) {
            errorOutline(playerNameInput);
            createRedAlertBox(playerNameInput, fullNameError);
        }
        if(!(response.dateOfBirthError === "")) {
            errorOutline(dateOfBirthInput);
            createRedAlertBox(dateOfBirthInput, dateOfBirthError);
        }
        if(!(response.accountNumberError === "")) {
            errorOutline(accountNumberInput);
            createRedAlertBox(accountNumberInput, accountNumberError);
        }
    }

    function showSuccessAlertBox() {
        alertBox.addClass("alert alert-success");
        alertText.text("Account details updated successfully!");
    }

    function createRedAlertBox(inputField, alertText) {
        inputField.after("<div class=\"alert alert-danger\"><p>" + alertText + "</p></div>");
    }

    function errorOutline(inputField) {
        inputField.addClass("error-input");
    }
});