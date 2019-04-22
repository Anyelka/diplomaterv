$(document).ready(
    function () {

        $('[id^=editUserButton]').click(
            function () {
                var userId = this.id.replace('editUserButton', '');

                $(this).toggleClass("hide");
                var saveEditUserButtonId = this.id.replace('editUserButton', 'saveEditUserButton');
                $("#" + saveEditUserButtonId).toggleClass("hide");
                $("#quitEditUserButton" + userId).toggleClass("hide");

                $("p[id$=" + userId + "]").toggleClass("hide");
                $("input[id$=" + userId + "]").toggleClass("hide");

            }
        );

        $("[id^=quitEditUserButton]").click(function () {
            var userId= this.id.replace("quitEditUserButton","");
            $("#editUserButton" + userId).toggleClass("hide");
            $("#saveEditUserButton" + userId).toggleClass("hide");
            $("#quitEditUserButton" + userId).toggleClass("hide");

            $("p[id$=" + userId + "]").toggleClass("hide");
            $("input[id$=" + userId + "]").toggleClass("hide");
        });

        $('[id^=saveEditUserButton]').click(
            function () {
                var userId = this.id.replace('saveEditUserButton', '');

                $(this).toggleClass("hide");
                var editUserButtonId = this.id.replace('saveEditUserButton', 'editUserButton');
                $("#" + editUserButtonId).toggleClass("hide");
                $("#quitEditUserButton" + userId).toggleClass("hide");

                $("p[id$=" + userId + "]").toggleClass("hide");
                $("input[id$=" + userId + "]").toggleClass("hide");

                sendSaveAjaxRequest(userId);
            }
        );

        function sendSaveAjaxRequest(userId) {
            $(".alert").remove();
            $.ajax({
                type: "POST",
                url: "/user/edit",
                dataType: 'json',
                contentType: 'application/json',
                data: JSON.stringify({
                    userId: $("#" + userId + "userId").text(),
                    userEmail: $("#inputUserEmail" + userId).val(),
                    username: $("#inputUserName" + userId).val(),
                    userFullName: $("#inputUserFullName" + userId).val(),
                    userAccountNumber: $("#inputUserAccountNumber" + userId).val(),
                    userDateOfBirth: $("#inputUserDateOfBirth" + userId).val(),
                    userBalance: $("#inputUserBalance" + userId).val(),
                    userCurrency: $("#inputUserCurrency" + userId).val(),
                }),
                success: function (response) {
                    if (response.valid) {
                        showSuccessfulUserEditAlertBox();
                        $("p[id=userEmail" + userId + "]").text($("#inputUserEmail" + userId).val());
                        $("p[id=userName" + userId + "]").text($("#inputUserName" + userId).val());
                        $("p[id=userFullName" + userId + "]").text($("#inputUserFullName" + userId).val());
                        $("p[id=userAccountNumber" + userId + "]").text($("#inputUserAccountNumber" + userId).val());
                        $("p[id=userDateOfBirth" + userId + "]").text($("#inputUserDateOfBirth" + userId).val());
                        $("p[id=userBalance" + userId + "]").text($("#inputUserBalance" + userId).val());
                        $("p[id=userCurrency" + userId + "]").text($("#inputUserCurrency" + userId).val());

                    } else {
                        if(response.emailError != "") {
                            $("nav").after("<div class='alert alert-danger'><p>" + response.emailError + "</p></div>")
                        }
                        if(response.usernameError != "") {
                            $("nav").after("<div class='alert alert-danger'><p>" + response.usernameError + "</p></div>")
                        }
                        if(response.fullNameError != "") {
                            $("nav").after("<div class='alert alert-danger'><p>" + response.fullNameError + "</p></div>")
                        }
                        if(response.accountNumberError != "") {
                            $("nav").after("<div class='alert alert-danger'><p>" + response.accountNumberError + "</p></div>")
                        }
                        if(response.balanceError != "") {
                            $("nav").after("<div class='alert alert-danger'><p>" + response.balanceError + "</p></div>")
                        }
                        if(response.currencyError != "") {
                            $("nav").after("<div class='alert alert-danger'><p>" + response.currencyError + "</p></div>")
                        }
                        if(response.dateOfBirthError != "") {
                            $("nav").after("<div class='alert alert-danger'><p>" + response.dateOfBirthError + "</p></div>")
                        }
                    }
                }

            });
        }

        function showSuccessfulUserEditAlertBox() {
            $("nav").after("<div class='alert alert-success'><p>The user was edited successfully!</p></div>");
        }

        $('[id^=deleteUserButton]').click(function () {
            console.log("delete user button clicked");
            var userId = this.id.replace('deleteUserButton', '');
            console.log("user id to be deleted: " + userId)
            var username = $("#deleteUserUsername" + userId).val();
            console.log("username of the user: " + username);
            $("#deleteUserModalText").text("Are you sure you want to delete the user: " + username + "?");
        });
        
        $("#confirmDeleteUserButton").click(function () {
            var username = $("#deleteUserModalText").text().replace("Are you sure you want to delete the user: ","").replace("?","");
            console.log(username);
            $.ajax({
                type: "POST",
                url: "/user/delete",
                dataType: 'json',
                contentType: 'application/json',
                data: JSON.stringify({
                    username: username
                }),
                success: function(response) {
                    if(response.valid) {
                        closeDeleteUserModal();
                        showSuccessfulUserDeletionAlertBox();
                    }else {
                        var alertText = response.usernameError;
                        $("#deleteUserModalBody").append('<div class="alert alert-danger"><p>' + alertText + '</p></div>');
                    }
                }
            });
        });

        function closeDeleteUserModal() {
            $("#deleteUserModal").modal('hide');
        }

        function showSuccessfulUserDeletionAlertBox() {
            $("nav").after("<div class='alert alert-success'><p>The user was deleted successfully!</p></div>");
        }
    }
);