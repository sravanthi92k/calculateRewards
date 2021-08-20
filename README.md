# calculateRewards

You have to run the RewardcalculatorApplication as Java Application.

Go to Postman/RestClient and Raise a post request the following url : http://localhost:8080/processRewardPoints/1/transactions

Content-Type : Application/json

Request Body:
=============

[
    {
        "transactionAmount":120,
        "transactionDate":"2021-06-03"
    },
     {
        "transactionAmount":80,
        "transactionDate":"2021-06-25"
    },
    {
        "transactionAmount":150,
        "transactionDate":"2021-07-03"
    },
    {
        "transactionAmount":200,
        "transactionDate":"2021-08-03"
    }
]

you will be seeing the output.
