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

