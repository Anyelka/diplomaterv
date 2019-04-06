$(document).ready(
    function () {

        var alertBox = $("#responseDiv");
        var alertText = $("#responseText");

        $('[id^=editUserButton]').click(
            function () {
                var userId = this.id.replace('editUserButton', '');

                $(this).toggleClass("hide");
                var saveEditUserButtonId = this.id.replace('editUserButton', 'saveEditUserButton');
                $("#" + saveEditUserButtonId).toggleClass("hide");

                $("p[id$=" + userId + "]").toggleClass("hide");
                $("input[id$=" + userId + "]").toggleClass("hide");
            }
        );

        $('[id^=saveEditUserButton]').click(
            function () {
                var userId = this.id.replace('saveEditUserButton', '');
                $(this).toggleClass("hide");

                var editUserButtonId = this.id.replace('saveEditUserButton', 'editUserButton');
                $("#" + editUserButtonId).toggleClass("hide");
                $("p[id$=" + userId + "]").toggleClass("hide");

                $("input[id$=" + userId + "]").toggleClass("hide");

                sendSaveAjaxRequest(userId);
            }
        );

        function sendSaveAjaxRequest(userId) {
            $.ajax({
                url: "editUser",
                data: {
                    userId: $("#" + userId + "userId").val(),
                    userName: $("#userEmail" + userId).val(),
                    userName: $("#userName" + userId).val(),
                    userName: $("#userFullName" + userId).val(),
                    userName: $("#userAccountNumber" + userId).val(),
                    userName: $("#userDateOfBirth" + userId).val(),
                    userName: $("#userBalance" + userId).val(),
                    userName: $("#userCurrency" + userId).val(),
                },
                succes: function (response) {
                    if (response.valid) {
                        showSuccessAlertBox();
                    }
                }

            });
        }

        function showSuccessAlertBox() {
            alertBox.addClass("alert alert-success");
            alertText.text("Account details updated successfully!");
        }
    }
);