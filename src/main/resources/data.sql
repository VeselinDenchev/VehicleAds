INSERT INTO brands (name) VALUES
    ('Acura'),
    ('Airstream'),
    ('Alfa Romeo'),
    ('Aston Martin'),
    ('Audi'),
    ('Bayliner'),
    ('Bentley'),
    ('BMW'),
    ('Buick'),
    ('Cadillac'),
    ('Chaparral'),
    ('Chevrolet'),
    ('Chrysler'),
    ('Citroën'),
    ('Daimler'),
    ('Dodge'),
    ('Ducati'),
    ('Ferrari'),
    ('Fiat'),
    ('Ford'),
    ('Forest River'),
    ('General Motors'),
    ('Harley-Davidson'),
    ('Honda'),
    ('Hyundai'),
    ('Infiniti'),
    ('Iveco'),
    ('Jaguar'),
    ('Jayco'),
    ('Jeep'),
    ('Kia'),
    ('Land Rover'),
    ('Lexus'),
    ('Lincoln'),
    ('MAN'),
    ('MasterCraft'),
    ('Mazda'),
    ('Mercedes-Benz'),
    ('Mitsubishi'),
    ('Nissan'),
    ('Peugeot'),
    ('Porsche'),
    ('Renault'),
    ('Scania'),
    ('Sea Ray'),
    ('Skoda'),
    ('Subaru'),
    ('Suzuki'),
    ('Tesla'),
    ('Thor'),
    ('Toyota'),
    ('Volkswagen'),
    ('Volvo'),
    ('Winnebago'),
    ('Yamaha');


INSERT INTO vehicles (brand_id, model_name, vehicle_type) VALUES
-- Boats

-- Bayliner
(6, 'VR5', 0),
(6, 'Element E18', 0),
-- Yamaha (for Boats)
(55, '212X', 0),
(55, '242X E-Series', 0),

-- Buses

-- Daimler
(15, 'Setra S415 UL', 1),
(15, 'Setra S417', 1),
-- Volvo (for Buses)
(53, '7900 Electric', 1),
(53, '9700', 1),

-- Cars

-- Acura
    (1, 'MDX', 2),
    (1, 'RDX', 2),
    (1, 'TLX', 2),
    (1, 'ILX', 2),
    (1, 'NSX', 2),

-- Alfa Romeo
    (3, 'Giulia', 2),
    (3, 'Stelvio', 2),
    (3, '4C Spider', 2),
    (3, 'Giulietta', 2),
    (3, 'Tonale', 2),

-- Aston Martin
    (4, 'DB11', 2),
    (4, 'Vantage', 2),
    (4, 'DBS Superleggera', 2),
    (4, 'DBX', 2),
    (4, 'Rapide', 2),

-- Audi
    (5, 'A4', 2),
    (5, 'Q5', 2),
    (5, 'R8', 2),
    (5, 'A6', 2),
    (5, 'A3', 2),

-- Bentley
    (7, 'Continental GT', 2),
    (7, 'Bentayga', 2),
    (7, 'Flying Spur', 2),
    (7, 'Mulsanne', 2),
    (7, 'Bacalar', 2),

-- BMW
    (8, '3 Series', 2),
    (8, 'X5', 2),
    (8, 'i8', 2),
    (8, '5 Series', 2),
    (8, 'M4', 2),

-- Buick
    (9, 'Enclave', 2),
    (9, 'Regal', 2),
    (9, 'Encore', 2),
    (9, 'Envision', 2),
    (9, 'LaCrosse', 2),

-- Cadillac
    (10, 'Escalade', 2),
    (10, 'CTS', 2),
    (10, 'XT5', 2),
    (10, 'CT6', 2),
    (10, 'XT4', 2),

-- Chevrolet
    (12, 'Silverado', 2),
    (12, 'Camaro', 2),
    (12, 'Equinox', 2),
    (12, 'Malibu', 2),
    (12, 'Tahoe', 2),

-- Chrysler
    (13, 'Pacifica', 2),
    (13, '300', 2),
    (13, 'Voyager', 2),
    (13, 'Crossfire', 2),
    (13, 'Aspen', 2),

-- Citroën
    (14, 'C3', 2),
    (14, 'C5 Aircross', 2),
    (14, 'Berlingo', 2),
    (14, 'C4', 2),
    (14, 'DS3', 2),

-- Dodge
    (16, 'Charger', 2),
    (16, 'Challenger', 2),
    (16, 'Durango', 2),
    (16, 'Viper', 2),
    (16, 'Journey', 2),

-- Ferrari
    (18, 'Portofino', 2),
    (18, '488 Pista', 2),
    (18, 'F8 Tributo', 2),
    (18, 'Roma', 2),
    (18, '812 Superfast', 2),

-- Fiat
    (19, '500', 2),
    (19, 'Panda', 2),
    (19, 'Tipo', 2),
    (19, '500X', 2),
    (19, '124 Spider', 2),

-- Ford
    (20, 'F-150', 2),
    (20, 'Mustang', 2),
    (20, 'Explorer', 2),
    (20, 'Focus', 2),
    (20, 'Fiesta', 2),

-- Honda
    (24, 'Civic', 2),
    (24, 'Accord', 2),
    (24, 'CR-V', 2),
    (24, 'Pilot', 2),
    (24, 'Fit', 2),

-- Hyundai
    (25, 'Elantra', 2),
    (25, 'Santa Fe', 2),
    (25, 'Tucson', 2),
    (25, 'Sonata', 2),
    (25, 'Kona', 2),

-- Infiniti
    (26, 'Q50', 2),
    (26, 'QX60', 2),
    (26, 'QX80', 2),
    (26, 'Q60', 2),
    (26, 'QX50', 2),

-- Jaguar
    (27, 'F-PACE', 2),
    (27, 'XE', 2),
    (27, 'F-TYPE', 2),
    (27, 'XF', 2),
    (27, 'E-PACE', 2),

-- Jeep
    (30, 'Wrangler', 2),
    (30, 'Grand Cherokee', 2),
    (30, 'Compass', 2),
    (30, 'Renegade', 2),
    (30, 'Cherokee', 2),

-- Kia
    (31, 'Sorento', 2),
    (31, 'Sportage', 2),
    (31, 'Optima', 2),
    (31, 'Rio', 2),
    (31, 'Telluride', 2),

-- Land Rover
    (32, 'Range Rover', 2),
    (32, 'Discovery', 2),
    (32, 'Defender', 2),
    (32, 'Range Rover Sport', 2),
    (32, 'Range Rover Evoque', 2),

-- Lexus
    (33, 'RX', 2),
    (33, 'ES', 2),
    (33, 'NX', 2),
    (33, 'IS', 2),
    (33, 'UX', 2),

-- Lincoln
    (34, 'Navigator', 2),
    (34, 'Continental', 2),
    (34, 'MKZ', 2),
    (34, 'Aviator', 2),
    (34, 'Corsair', 2),

    -- Mazda
    (37, 'CX-5', 2),
    (37, 'Mazda3', 2),
    (37, 'MX-5 Miata', 2),
    (37, 'Mazda6', 2),
    (37, 'CX-30', 2),

    -- Mercedes-Benz
    (38, 'C-Class', 2),
    (38, 'E-Class', 2),
    (38, 'GLE', 2),
    (38, 'S-Class', 2),
    (38, 'GLC', 2),

    -- Mitsubishi
    (39, 'Outlander', 2),
    (39, 'Lancer', 2),
    (39, 'Eclipse Cross', 2),
    (39, 'Mirage', 2),
    (39, 'Pajero', 2),

    -- Nissan
    (40, 'Altima', 2),
    (40, 'Rogue', 2),
    (40, 'Leaf', 2),
    (40, 'Sentra', 2),
    (40, 'Pathfinder', 2),

    -- Peugeot
    (41, '208', 2),
    (41, '3008', 2),
    (41, '508', 2),
    (41, '2008', 2),
    (41, '308', 2),

    -- Porsche
    (42, '911', 2),
    (42, 'Cayenne', 2),
    (42, 'Panamera', 2),
    (42, 'Macan', 2),
    (42, '718 Boxster', 2),

    -- Renault
    (43, 'Clio', 2),
    (43, 'Megane', 2),
    (43, 'Kadjar', 2),
    (43, 'Captur', 2),
    (43, 'Zoe', 2),

    -- Skoda
    (46, 'Octavia', 2),
    (46, 'Kodiaq', 2),
    (46, 'Superb', 2),
    (46, 'Karoq', 2),
    (46, 'Fabia', 2),

    -- Subaru
    (47, 'Outback', 2),
    (47, 'Forester', 2),
    (47, 'Impreza', 2),
    (47, 'WRX', 2),
    (47, 'Legacy', 2),

    -- Suzuki
    (48, 'Swift', 2),
    (48, 'Vitara', 2),
    (48, 'Baleno', 2),
    (48, 'S-Cross', 2),
    (48, 'Jimny', 2),

    -- Tesla
    (49, 'Model S', 2),
    (49, 'Model X', 2),
    (49, 'Model 3', 2),
    (49, 'Model Y', 2),
    (49, 'Roadster', 2),

    -- Toyota
    (51, 'Camry', 2),
    (51, 'RAV4', 2),
    (51, 'Corolla', 2),
    (51, 'Prius', 2),
    (51, 'Highlander', 2),

    -- Volkswagen
    (52, 'Golf', 2),
    (52, 'Tiguan', 2),
    (52, 'Passat', 2),
    (52, 'Jetta', 2),
    (52, 'Atlas', 2),

    -- Volvo
    (53, 'XC90', 2),
    (53, 'S60', 2),
    (53, 'V60', 2),
    (53, 'XC60', 2),
    (53, 'S90', 2),

-- Caravans

-- Airstream
(2, 'Classic', 3),
(2, 'Flying Cloud', 3),
-- Winnebago
(54, 'Minnie Winnie', 3),
(54, 'Forza', 3),

-- Motorcycles

-- BMW (Motorcycles)
(8, 'R 1250 GS', 4),
(8, 'S 1000 RR', 4),
(8, 'F 850 GS', 4),
(8, 'R NineT', 4),
(8, 'G 310 R', 4),

-- Ducati
(17, 'Panigale V4', 4),
(17, 'Monster', 4),
(17, 'Multistrada', 4),
(17, 'Scrambler', 4),
(17, 'Diavel', 4),

-- Harley-Davidson
(23, 'Street Glide', 4),
(23, 'Fat Boy', 4),
(23, 'Sportster Iron 883', 4),
(23, 'Road King', 4),
(23, 'Softail Slim', 4),

-- Honda (Motorcycles)
(24, 'Gold Wing', 4),
(24, 'CBR1000RR', 4),
(24, 'Africa Twin', 4),
(24, 'CB500X', 4),
(24, 'Rebel 500', 4),

-- Yamaha (Motorcycles)
(55, 'YZF-R1', 4),
(55, 'MT-07', 4),
(55, 'Tenere 700', 4),
(55, 'YZF-R6', 4),
(55, 'V Star 250', 4),

-- Trucks

-- Daimler (Freightliner and Western Star)
(15, 'Freightliner Cascadia', 5),
(15, 'Freightliner M2 106', 5),
(15, 'Western Star 4900', 5),
(15, 'Freightliner 114SD', 5),
(15, 'Western Star 5700XE', 5),

-- Volvo
(53, 'Volvo FH', 5),
(53, 'Volvo FMX', 5),
(53, 'Volvo VNL', 5),
(53, 'Volvo VNR', 5),
(53, 'Volvo VHD', 5),

-- Scania
(44, 'Scania R Series', 5),
(44, 'Scania G Series', 5),
(44, 'Scania P Series', 5),
(44, 'Scania S Series', 5),
(44, 'Scania XT Series', 5);
