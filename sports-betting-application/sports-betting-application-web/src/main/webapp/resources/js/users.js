$(document).ready(
    function() {
        $('[id^=editUserButton]').click(
            function () {
                var userId = this.id.replace('editUserButton','');

                $(this).toggleClass("hide");
                var saveEditUserButtonId = this.id.replace('editUserButton','saveEditUserButton');
                $("#"+saveEditUserButtonId).toggleClass("hide");

                $("p[id$="+userId+"]").toggleClass("hide");
                $("input[id$="+userId+"]").toggleClass("hide");
            }
        );

        $('[id^=saveEditUserButton]').click(
            function () {
                var userId = this.id.replace('saveEditUserButton','');

                $(this).toggleClass("hide");
                var editUserButtonId = this.id.replace('saveEditUserButton','editUserButton');
                $("#"+editUserButtonId).toggleClass("hide");

                $("p[id$="+userId+"]").toggleClass("hide");
                $("input[id$="+userId+"]").toggleClass("hide");

                sendSaveAjaxRequest();
            }

        );

        function sendSaveAjaxRequest() {
            $.ajax({
                url: "user/edit",
                data: {
                    
                },
                succes: function () {
                    
                }

            });
        }
    }
);