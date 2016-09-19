# Car-Parking-Management

linux command to run the server:-


javac CarServer.java


java CarServer [port number] [number of clients]

linux command to run the client:-

javac CarClient.java

java CarClient [IP address of server] [por number] [number of cars handled by the client]


Note: All the interactions are to be done with the server


Description Of the Project:-

The project aims to manage vehicles in a huge multi zone / level parking
lot where each zone is managed by a client who computes the empty spaces in
the respective zone/level for new vehicles to enter and park. A central server
manages all the parking spaces in the parking lot by distributing the tasks to the
clients in each zone / level. The communication among the master server and the
clients is realised through networking techniques which have been implemented
through sockets in Java.

The user is required to input port and backlog to initiate the process. The
port number is the port on which the master server listens and the backlog is the
maximum number of clients it can hold in a queue. This number shall indicate
the total number of zones in the parking lot. Folowing this process, clients are
created for the respective zones and the servers waits for the acknowledgement
from the newly connected clients and jumps into a passive listen state. After
the connection is complete, i.e. the backlog is full, the menu driven program
jumps into action and the optoins are displayed for parking a new car or taking
a parked car form the lot.

1. Incase of a new parking request, the server polls every client in a prede-
termined sequence (according to the distace of the zone from the entry
of the parking) for the available slot number in the repective zone. The
client communicates this slot number to the main server which in turn
provides the user with the complete address of the availble slot alongwith
the unique ID number for the respective slot. Assuming that the the user
always accepts the given slot , the car will be considered parked in the
alotted slot and the client side list will be updated. The proces is repeated
for a new request.

2. Incase of a car retrival request, the main server asks for the unique ID
number from the user and accordingly fethes the complete address from
its own database and reports it to the user. Assuming that the user always
takes the car from the slot, the respective client is informed of the same
and the respective client side database is also refreshed. Incase the unique
ID number given to the customer is for an empty slot, an error message
is returned.The proces is repeated for a new request.

The client side code works accordngly. Input is taken from the command
line as the port numbr, the IP address, and the number of parking plots in the
current zone handled by the client. The client then tries o connct with the server
of the respective port and IP address.The client then creates a database of the
parked/unparked parking plots. the client then waits for the server to get the
respective instruction. When the server asks for a new parking place, The client
checks in the database if a vacant parking place is available.if it is available, the
parking id corresponding to the region is povided and stored accordingly to the
database. If no parking is availble corresponding message is submitted. If the
server asks the client to free a paicular place, the client attemts to free the car
if it there else a corresponding error message is generated.

