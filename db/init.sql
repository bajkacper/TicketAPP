/*
CREATE TABLE Users (
    userId SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    userType INTEGER REFERENCES UserTypes(userTypeId)
);
CREATE TABLE UserTypes (
  userTypeId SERIAL PRIMARY KEY,
  typeName VARCHAR(20) NOT NULL UNIQUE
);
CREATE TABLE Movies (
    movieId SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    genre VARCHAR(50),
    duration INTEGER,
    ageLimit INTEGER
);

CREATE TABLE Screenings (
    screeningId SERIAL PRIMARY KEY,
    movieId INTEGER REFERENCES Movies(movieId),
    screeningDate DATE,
    screeningTime TIME,
    cinemaHall VARCHAR(50),
    availableSeats INTEGER
);

CREATE TABLE Tickets (
    ticketId SERIAL PRIMARY KEY,
    screeningId INTEGER REFERENCES Screenings(screeningId),
    userId INTEGER REFERENCES Users(userId),
    ticketType VARCHAR(20),
    ticketPrice NUMERIC(10, 2)
);

CREATE TABLE Reservations (
    reservationId SERIAL PRIMARY KEY,
    screeningId INTEGER REFERENCES Screenings(screeningId),
    userId INTEGER REFERENCES Users(userId),
    reservationDate DATE,
    reservedSeats INTEGER
);

CREATE TABLE Transactions (
    transactionId SERIAL PRIMARY KEY,
    userId INTEGER REFERENCES Users(userId),
    transactionDate TIMESTAMP,
    transactionAmount NUMERIC(10, 2),
    paymentMethod VARCHAR(50)
);
INSERT INTO UserTypes (typeName) VALUES ('ADMIN'), ('CUSTOMER'), ('CASHIER');
*/
CREATE TABLE "USERS" (
  "id" SERIAL PRIMARY KEY,
  "userName" VARCHAR(45) NOT NULL,
  "email" VARCHAR(45) UNIQUE NOT NULL,
  "lastName" VARCHAR(45) NOT NULL,
  "password" VARCHAR(45) NOT NULL,
  "userType" VARCHAR(10) NOT NULL,
  "activated" BOOLEAN NOT NULL,
  "verification" VARCHAR(45) NOT NULL
);

CREATE TABLE "CONFIRMATION_TOKEN" (
  "id" SERIAL PRIMARY KEY,
  "token" VARCHAR(45) NOT NULL,
  "createdAt" TIMESTAMP NOT NULL,
  "expiresAt" TIMESTAMP NOT NULL,
  "confirmedAt" TIMESTAMP,
  "userId" INT NOT NULL
);

CREATE TABLE "PAYMENT" (
  "id" SERIAL PRIMARY KEY,
  "isCompleted" BOOLEAN NOT NULL
);

CREATE TABLE "MOVIE" (
  "id" SERIAL PRIMARY KEY,
  "name" VARCHAR(45) NOT NULL,
  "length" INT NOT NULL,
  "description" VARCHAR(255) NOT NULL,
  "ageAllowed" INT NOT NULL,
  "year" INT NOT NULL,
  "subtitles" BOOLEAN NOT NULL
);

CREATE TABLE "BRANCH" (
  "id" SERIAL PRIMARY KEY,
  "number" INT NOT NULL,
  "street" VARCHAR(45) NOT NULL,
  "city" VARCHAR(45) NOT NULL
);

CREATE TABLE "SCREENING_ROOM" (
  "id" SERIAL PRIMARY KEY,
  "name" VARCHAR(45) NOT NULL,
  "no_seats" INT NOT NULL,
  "branchId" INT NOT NULL
);

CREATE TABLE "SCREENING" (
  "id" SERIAL PRIMARY KEY,
  "date" TIMESTAMP NOT NULL,
  "movieId" INT NOT NULL,
  "screeningRoomId" INT NOT NULL
);

CREATE TABLE "SEATS" (
  "id" SERIAL PRIMARY KEY,
  "row" VARCHAR(45) NOT NULL,
  "number" INT NOT NULL,
  "screeningRoomId" INT NOT NULL
);

CREATE TABLE "BOOKING" (
  "id" SERIAL PRIMARY KEY,
  "price" DECIMAL(5,2) NOT NULL,
  "userId" INT NOT NULL,
  "paymentId" INT NOT NULL
);

CREATE TABLE "RESERVED_SEATS" (
  "id" SERIAL PRIMARY KEY,
  "bookingId" INT NOT NULL,
  "seatId" INT NOT NULL
);

ALTER TABLE "CONFIRMATION_TOKEN" ADD CONSTRAINT "fk_CONFIRMATION_TOKEN_USER" FOREIGN KEY ("userId") REFERENCES "USERS" ("id");

ALTER TABLE "SCREENING_ROOM" ADD CONSTRAINT "fk_SCREENING_ROOM_BRANCH" FOREIGN KEY ("branchId") REFERENCES "BRANCH" ("id");

ALTER TABLE "SCREENING" ADD CONSTRAINT "fk_SCREENING_MOVIE" FOREIGN KEY ("movieId") REFERENCES "MOVIE" ("id");

ALTER TABLE "SCREENING" ADD CONSTRAINT "fk_SCREENING_SCREENING_ROOM" FOREIGN KEY ("screeningRoomId") REFERENCES "SCREENING_ROOM" ("id");

ALTER TABLE "SEATS" ADD CONSTRAINT "fk_SEATS_SCREENING_ROOM" FOREIGN KEY ("screeningRoomId") REFERENCES "SCREENING_ROOM" ("id");

ALTER TABLE "BOOKING" ADD CONSTRAINT "fk_BOOKING_USER" FOREIGN KEY ("userId") REFERENCES "USERS" ("id");

ALTER TABLE "BOOKING" ADD CONSTRAINT "fk_BOOKING_PAYMENT" FOREIGN KEY ("paymentId") REFERENCES "PAYMENT" ("id");

ALTER TABLE "RESERVED_SEATS" ADD CONSTRAINT "fk_RESERVED_SEATS_BOOKING" FOREIGN KEY ("bookingId") REFERENCES "BOOKING" ("id");

ALTER TABLE "RESERVED_SEATS" ADD CONSTRAINT "fk_RESERVED_SEATS_SEATS" FOREIGN KEY ("seatId") REFERENCES "SEATS" ("id");


