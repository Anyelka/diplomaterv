$(document).ready(
    function () {

        $("#saveFTResultButton").click({

        });

        function saveResult() {
            $.ajax({
                url: "generateResults",
                data: {},
                success: function (response) {
                    successful();
                }
            });
        }

    }
);