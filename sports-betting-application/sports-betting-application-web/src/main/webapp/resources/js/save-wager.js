$(document).ready(
    function () {

        var playerUsername = $("#playerUsername").val();
        var outcomeId = $("#outcomeId").val();
        var stakeInput = $("#wagerStake");

        $(".openModalButton").click(function() {
            var betDescription = $(this).prev().val();
            var outcome = $(this).text();
            loadModalData(betDescription, outcome);
        });

        function loadModalData(betDescription, outcome) {
            $("#saveWagerModalHeaderText").text(betDescription + " " + outcome);
        }

        $("#confirmWager").click(
            function () {
                $.ajax({
                    url: "saveWager",
                    data: {
                        playerUsername: playerUsername,
                        outcomeId: outcomeId,
                        stake: stakeInput.val()
                    },
                    success: function (response) {
                        reload();
                        if (response.valid) {
                            closeModal();
                            successfulWagerSave();
                        } else {
                            showStakeError(response.stakeError);
                        }
                    }
                })
            }
        );

        function reload() {
            deleteAlertBoxes();
            deleteInputOutlines();
        }

        function deleteAlertBoxes() {
            $(".alert").remove();
        }

        function deleteInputOutlines() {
            $(".error-input").removeClass("error-input");
        }

        function successfulWagerSave() {
            $("nav").after("<div class='alert alert-success'><p>Wager saved successfully!</p></div>");
        }

        function closeModal() {
            $("#saveWagerModal").modal('hide');
        }

        function showStakeError(errorMessage) {
            errorOutline(stakeInput);
            createRedAlertBox(stakeInput, errorMessage);
        }

        function createRedAlertBox(inputField, alertText) {
            inputField.after("<div class=\"alert alert-danger\"><p>" + alertText + "</p></div>");
        }

        function errorOutline(inputField) {
            inputField.addClass("error-input");
        }

    }
);