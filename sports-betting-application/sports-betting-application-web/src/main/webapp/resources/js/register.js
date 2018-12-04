$(document).ready(
    function () {
        var emailInput = $("#email");
        var usernameInput = $("#username");
        var passwordInput = $("#password");
        var fullNameInput = $("#fullName");
        var accountNumberInput = $("#accountNumber");
        var currencyInput = $("#currency");
        var dateOfBirthInput = $("#dateOfBirth");

        $("#registerButton").click(
            function () {
                $.ajax({
                    url: "sendRegistrationRequest",
                    data: {
                        email: emailInput.val(),
                        username: usernameInput.val(),
                        password: passwordInput.val(),
                        fullName: fullNameInput.val(),
                        accountNumber: accountNumberInput.val(),
                        currency: currencyInput.val(),
                        dateOfBirth: dateOfBirthInput.val()
                    },
                    success: function (response) {
                        reloadForm();
                        if (response.valid) {
                            showSuccessfulRegistration();
                        } else {
                            showErrors(response);
                        }
                    }
                })
            }
        );

        function reloadForm() {
            deleteAllAlertBoxes();
            deleteAllInputOutlines();
        }

        function deleteAllAlertBoxes() {
            $(".alert").remove();
        }

        function deleteAllInputOutlines() {
            $(".error-input").removeClass("error-input");
        }

        function showSuccessfulRegistration() {
            $("#registrationErrorDiv").addClass("alert alert-success");
            $("#registrationErrorText").text("Successful registration!");
        }

        function showErrors(response) {
            var emailError = response.emailError;
            var usernameError = response.usernameError;
            var passwordError = response.passwordError;
            var fullNameError = response.fullNameError;
            var accountNumberError = response.accountNumberError;
            var dateOfBirthError = response.dateOfBirthError;

            if (!(emailError === "")) {
                errorOutline(emailInput);
                createRedAlertBox(emailInput, emailError);
            }
            if (!(usernameError === "")) {
                errorOutline(usernameInput);
                createRedAlertBox(usernameInput, usernameError);
            }
            if (!(passwordError === "")) {
                errorOutline(passwordInput);
                createRedAlertBox(passwordInput, passwordError);
            }
            if (!(fullNameError === "")) {
                errorOutline(fullNameInput);
                createRedAlertBox(fullNameInput, fullNameError);
            }
            if (!(accountNumberError === "")) {
                errorOutline(accountNumberInput);
                createRedAlertBox(accountNumberInput, accountNumberError);
            }
            if (!(dateOfBirthError === "")) {
                errorOutline(dateOfBirthInput);
                createRedAlertBox(dateOfBirthInput, dateOfBirthError);
            }
        }

        function createRedAlertBox(inputField, alertText) {
            inputField.after("<div class=\"alert alert-danger form-group col-xs-12\"><p>" + alertText + "</p></div>");
        }

        function errorOutline(inputField) {
            inputField.addClass("error-input");
        }

    }
);