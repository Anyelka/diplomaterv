$(document).ready(
    function () {
        var eventId;

        $('[id^=addFTResult]').click(function () {
            eventId = this.id.replace('addFTResult', '');
            var eventTitle = $("#sportEventTitle" + eventId).val();
            loadModalData(eventTitle);
        });

        function loadModalData(eventTitle) {
            $("#addFTResultModalText").text("Add Full Time result of event - " + eventTitle);
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
                    eventId : eventId,
                    fullTimeResult : homeScore.concat(" - ").concat(awayScore)
                }),
                success: function (response) {
                }
            });
        });


    }
);