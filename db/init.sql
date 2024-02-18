CREATE TABLE IF NOT EXISTS movies (
    movie_id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    release_date DATE NOT NULL,
    genre VARCHAR(100),
    duration_minutes INTEGER
    );

CREATE TABLE IF NOT EXISTS theaters (
    theater_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    capacity INTEGER NOT NULL
    );

CREATE TABLE IF NOT EXISTS screenings (
    screening_id SERIAL PRIMARY KEY,
    movie_id INTEGER REFERENCES movies(movie_id),
    theater_id INTEGER REFERENCES theaters(theater_id),
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    price DECIMAL(8, 2) NOT NULL
    );

CREATE TABLE IF NOT EXISTS seats (
    seat_id SERIAL PRIMARY KEY,
    theater_id INTEGER REFERENCES theaters(theater_id),
    row_number INTEGER NOT NULL,
    seat_number INTEGER NOT NULL
    );

CREATE TABLE IF NOT EXISTS reservations (
         reservation_id SERIAL PRIMARY KEY,
         screening_id INTEGER REFERENCES screenings(screening_id),
         seat_id INTEGER REFERENCES seats(seat_id),
         customer_name VARCHAR(255) NOT NULL,
         reservation_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
     );
FOREIGN KEY (screening_id, seat_id) REFERENCES screenings(screening_id, seat_id);
