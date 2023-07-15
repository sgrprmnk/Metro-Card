# Metro-Card
## Context
 A new metro train has been launched from the Central station to the Airport. It is a non-stop train, which means the train will stop only at the Airport with no intermediate stops. 
It is also possible to return from the Airport back to the Central station. This is also a non-stop journey.

## MetroCard
 Metro authority prefers money to be collected via MetroCard. MetroCard is an electronic payment utility that can be used to pay for the metro travel charges. The MetroCard is like a wallet loaded with money. Each person traveling in this metro must carry a MetroCard and each card will have a unique number. 
 
 To travel by this train, one needs a MetroCard. If the MetroCard doesn’t have sufficient balance, then the remaining cost for the travel needs to be paid by recharging the MetroCard. This auto recharge loads only the required amount of money for the journey and the station collects a 2% service fee for the transaction. 
Travel charges
 Costs for the journey are based on the passenger's age. It is categorized as below
 
![image](https://github.com/sgrprmnk/Metro-Card/assets/22534120/855598ee-5e7c-4bc4-b296-e3854504a7f2)

## Journey Types
 Travel charges are different for a single trip and for a return journey. When a passenger takes a return journey, there is a discount of 50% for the travel charges of the return journey. 
 
 For eg: If a senior citizen travels from Central to Airport, the travel charge collected is 100. If the same citizen travels back to Central station,  the amount collected for the return journey is 50. If the same citizen passes a third time on the same day, it will be treated as a new single journey and the travel charge collected is 100.

## Goal
 Your task is to build a solution that calculates various travel charges collected at each station and print the collection summary and passenger summary. 
 
- The collection summary should give a breakup of the total amount collected and the total discount given. 
- The passenger summary should display the total number of passengers traveled per type in descending order of the passenger count. 
- If any of the passenger type have same value for passenger count then display in the ascending order of the passenger type for that case. 
	Ex:If ADULT and KID has same value then display it as 
	ADULT <no_of_passengers>
	KID <no_of_passengers>

## Assumptions
- All passengers should have a MetroCard. 
- If a passenger does not have sufficient balance in the MetroCard, then the MetroCard needs to be recharged before taking up the journey. 
- The service fee for doing the recharge is collected by the origin station of the journey. 
- The passenger count is calculated based on journeys eg: if the same passenger travels twice, the count is 2.
# Sample I/O
## Input Commands & Format
#### BALANCE <METROCARD_NUMBER> <BALANCE_IN_THE_METROCARD>
 
 <METROCARD_NUMBER> is the identifier for a given MetroCard. 
 <BALANCE_IN_THE_METROCARD> is the amount of money available in the MetroCard for journeys. 
 
#### CHECK_IN <METROCARD_NUMBER>  <PASSENGER_TYPE> <FROM_STATION>
 
 The CHECK_IN command should deduct the appropriate amount of travel charge from the MetroCard of the passenger, depending on the passenger type. If the passenger has already made a single journey, then only 50% of the travel charge should be deducted from the MetroCard for their return journey.
 
## PRINT_SUMMARY 
 Returns calculated travel charges collected, and passenger summary per station in the following format:
 
- TOTAL_COLLECTION AIRPORT <amount of travel charges collected> <total discount given> 
- <PASSENGER_TYPE with highest count from AIRPORT> <passenger type count> 
- <PASSENGER_TYPE with second highest count from AIRPORT> <passenger type count> 
- <PASSENGER_TYPE with least count from AIRPORT> <passenger type count> 
- TOTAL_COLLECTION CENTRAL <amount of travel charges collected> <total discount given> 
- <PASSENGER_TYPE with highest count from CENTRAL> <passenger type count> 
- <PASSENGER_TYPE with second highest count from CENTRAL> <passenger type count> 
- <PASSENGER_TYPE with least count from CENTRAL> <passenger type count>
## Sample Input/Output 1
### INPUT	
BALANCEMC1 600
BALANCEMC2 500 
BALANCEMC3 50 
BALANCEMC4 50 
BALANCEMC5 200 
CHECK_INMC1 ADULT CENTRAL 
CHECK_INMC2 SENIOR_CITIZEN CENTRAL 
CHECK_INMC1 ADULT AIRPORT 
CHECK_INMC3 KID AIRPORT 
CHECK_INMC4 ADULT AIRPORT 
CHECK_INMC5 KID AIRPORT 
PRINT_SUMMARY
### OUTPUT
TOTAL_COLLECTION CENTRAL 300 0 
PASSENGER_TYPE_SUMMARY
ADULT 1
SENIOR_CITIZEN 1
TOTAL_COLLECTION AIRPORT  403 100 
PASSENGER_TYPE_SUMMARY
ADULT 2
KID 2
 Each person’s total charges are sorted in  ascending order of their metro card number. 
### Explanation

![image](https://github.com/sgrprmnk/Metro-Card/assets/22534120/9e385415-86f8-44f3-a84b-02cd68040113)

 
