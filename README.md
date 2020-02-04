# OS-Project-2019
A Multi-threaded TCP Server Application, which allows multiple users to be registered, login and trade football players. 
The Application should provide the following functions for the client applications.
1.	Register with the system (Note There is two types of users: Player Agents and Clubs)
*	Clubs have the following details (Note: The same club name and id can only be registered once)
i.	Name.
ii.	Club ID.
iii.	Email.
iv.	Funds Available for transfer.
*	Agents have the following details (Note: The same agent name and id can only be registered once)
i.	Agent Name
ii.	Agent ID
iii.	Email
2.	Log-in to the player transfer system from the client application to the server application.
*	Note: The log in is based on the club’s or the agent’s name and id
3.	Once logged in the agent would be able to:
*	Add a player with the following details (Note when adding a player profile the server should assign a unique player ID).
i.	Name
ii.	Age
iii.	Player ID
iv.	Club ID
v.	Agent ID
vi.	Valuation
vii.	Status
1.	For Sale
2.	Sold
3.	Sale Suspended
viii.	Position
1.	Goalkeeper
2.	Defender
3.	Midfield
4.	Attacker
*	Update the player’s valuation.
*	Update the player’s status. 
4.	Once logged in the club would be able to:
*	Search for all players in a given position.
*	Search for all players for sale in their club
*	Suspend/Resume the sale of a player in their club. 
*	Purchase a player. When a club tries to purchase a player the following must be checked:
1.	That the player must be valid.
2.	The club has the funds required and the player is for sales.
3.	 If points 1 and 2 are true then:
*	The player’s status changes to sold.
*	The player’s club ID should change to the new Club ID
*	The purchasing club’s balance should reduce by the valuation.
*	The selling club’s balance should increase by the valuation.

