$(document).ready(
    function () {
        var outcomeId;
        $('[id^=openModalButton]').click(function() {
            outcomeId = this.id.replace('openModalButton', '');
            var betDescription = $("#betDescription" + outcomeId).val();
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
                        playerUsername: $("#playerUsername").val(),
                        outcomeId: outcomeId,
                        stake: $("#wagerStake").val()
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
            errorOutline($("#wagerStake"));
            createRedAlertBox($("#wagerStake"), errorMessage);
        }

        function createRedAlertBox(inputField, alertText) {
            inputField.after("<div class=\"alert alert-danger\"><p>" + alertText + "</p></div>");
        }

        function errorOutline(inputField) {
            inputField.addClass("error-input");
        }

    }
);