-- Create table if it doesn't exist
CREATE TABLE IF NOT EXISTS clothes (
    id SERIAL PRIMARY KEY,
    item_name VARCHAR(255),
    color VARCHAR(255),
    brand VARCHAR(255),
    item_size INT,
    price DECIMAL,
    quantity INT
    );

-- Insert sample data
INSERT INTO clothes (item_name, color, brand, item_size, price, quantity)
VALUES
    ('Dress', 'black', 'Zara', 42, 5500),
    ('Skirt', 'white', 'Mango', 46, 3800),
    ('T-shirt', 'yellow', 'The north face', 50, 1300),
    ('Sweater', 'green', 'H&M', 48, 6400),
    ('Socks', 'red', 'Nike', 36, 550),
    ('Jeans', 'blue', 'Gloria Jeans', 44, 9999),
    ('Trousers', 'purple', 'Target', 38, 8500),
    ('Jumper', 'orange', 'Puma', 52, 3899);