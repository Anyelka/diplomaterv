$(document).ready(
    function () {
        $("#generateResultsButton").click(
            function () {


                $.ajax({
                    url: "generateResults",
                    data: {},
                    success: function (response) {
                        successful();
                    }
                });

                function successful(response) {
                    $("nav").after("<div class='alert alert-success'><p>" + response + "</p></div>");
                }
            }
        );
    }
);