$(document).ready(
    function () {
        var eventId;
        $('[id^=addFTResult]').click(function () {
            eventId = this.id.replace('addFTResult', '');
            var eventTitle = $("#sportEventTitle" + eventId).val();
            loadModalData(eventTitle);
        });

        function loadModalData(eventTitle) {
            $("#FTResultModalText").text("Add Full Time result of event: " + eventTitle);
            $("#homeTeamModalLabel").text(eventTitle.substring(0, eventTitle.indexOf("-")));
            $("#awayTeamModalLabel").text(eventTitle.substring(eventTitle.indexOf("-") + 2));
        }

        $("#saveFTResultButton").click(function () {
            var homeScore = $("#homeScoreSelect").val();
            var awayScore = $("#awayScoreSelect").val();

            $.ajax({
                type: "POST",
                url: "/addResult/fullTimeResult",
                dataType: 'json',
                contentType: 'application/json',
                data: JSON.stringify({
                    eventId: eventId,
                    fullTimeResult: homeScore.concat(" - ").concat(awayScore)
                }),
                success: function (response) {
                    if(response.valid) {
                        closeFTResultModal();
                        successfulResultSave();
                    } else {
                        var alertText;
                        if(response.eventIdError != "") {
                            alertText = response.eventIdError;
                        }
                        if(response.fullTimeResultError != "") {
                            alertText = response.fullTimeResultError;
                        }
                        if(response.existingResultError != "") {
                            alertText = response.existingResultError;
                        }
                        $("#FTResultModalFooter").append('<div class="alert alert-danger"><p>' + alertText + '</p></div>');
                    }
                }
            });
        });

        $('[id^=addBetResultButton]').click(function () {
            var betId = this.id.replace('addBetResultButton', '');
            var betDescription = $("#betTitle" + betId).val();

            console.log("Add bet result button clicked");
            console.log("The bet of the button that was clicked: " + betDescription);

            $("#betResultModalText").text("Add result for bet: " + betDescription);

            var outcomeDescriptions = [];
            var i = 0;
            $('[id^=addBetResultOutcomeDescription' + betId + ']').each(function () {
                outcomeDescriptions[i] = $(this).val();
                console.log(outcomeDescriptions[i]);
                i++;
            });

            var outcomeValues = [];
            var j = 0;
            $('[id^=addBetResultOutcomeValue' + betId + ']').each(function () {
                outcomeValues[j] = $(this).val();
                console.log(outcomeValues[j]);
                j++;
            });

            var outcomeOdds = [];
            var k = 0;
            $('[id^=addBetResultOutcomeOdd' + betId + ']').each(function () {
                outcomeOdds[k] = $(this).val();
                console.log(outcomeOdds[k]);
                k++;
            });

            for (var l = 0; l < outcomeOdds.length; l++) {
                $("#modalOutcomesButtonGroup").append("<div id=\"accordion\" class=\"btn-group\">\n" +
                    "                                    <div class=\"card\">\n" +
                    "                                        <button type=\"button\"\n" +
                    "                                                id=\"saveBetResultButton" + outcomeValues[l] + "\"\n" +
                    "                                                class=\"btn btn-primary\">\n" +
                    "                                                " + outcomeValues[l] + " <br> \n" +
                    "                                        </button>\n" +
                    "                                    </div>\n" +
                    "                                </div>");
            }

        });

        $("#closeBetResultModalButton").click(function () {
            $("#modalOutcomesButtonGroup").empty();
        });

        $("body").on("click",'[id^=saveBetResultButton]',function () {
            console.log("Save bet result button clicked");
            var outcomeValue = this.id.replace('saveBetResultButton', '');
            var betDescription = $("#betResultModalText").text().replace("Add result for bet: ", "");
            console.log("The bet to be saved: " + betDescription + " with the result: " + outcomeValue);

            $.ajax({
                type: "POST",
                url: "/addResult/betResult",
                dataType: 'json',
                contentType: 'application/json',
                data: JSON.stringify({
                    betDescription: betDescription,
                    outcomeValue: outcomeValue
                }),
                success: function (response) {
                    if(response.valid) {
                        closeBetResultModal();
                        successfulResultSave();
                    } else {
                        var alertText;
                        if(response.betDescriptionError != "") {
                            alertText = response.betDescriptionError;
                        }
                        if(response.outcomeValueError != "") {
                            alertText = response.outcomeValueError;
                        }
                        $("#betResultModalBody").append('<div class="alert alert-danger"><p>' + alertText + '</p></div>');
                    }
                }
            });

            $("#modalOutcomesButtonGroup").empty();
        });

        function closeFTResultModal() {
            $("#FTResultModal").modal('hide');
        }

        function closeBetResultModal() {
            $("#betResultModal").modal('hide');
        }

        function successfulResultSave() {
            $("nav").after("<div class='alert alert-success'><p>The result was saved successfully!</p></div>");
        }

    }
);