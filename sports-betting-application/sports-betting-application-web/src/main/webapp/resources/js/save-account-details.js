$(document).ready(
    function(){
        $('#saveAccountDetailsButton').onclick(
            function (event) {
                var name = $('#playerName');
                var dateOfBirth = $('#playerDateOfBirth');
                var accountNumber = $('#playerAccountNumber');
                var balance = $('#playerBalance');
                var currency = $('#playerCurrency');

                $.get('saveAccountDetails', {
                    accountDetailsRequest : {
                        name : name,
                        dateOfBirth : dateOfBirth,
                        accountNumber : accountNumber,
                        balance : balance,
                        currency : currency
                    }, function() {

                    }
                })
                
            }
        );
    }
    
);