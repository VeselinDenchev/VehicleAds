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

-- Boats
INSERT INTO boats (brand_id, model_name) VALUES
-- Bayliner
(6, 'VR5'),
(6, 'Element E18'),
-- Yamaha (for Boats)
(55, '212X'),
(55, '242X E-Series');

-- Buses
INSERT INTO buses (brand_id, model_name) VALUES
-- Daimler
(15, 'Setra S415 UL'),
(15, 'Setra S417'),
-- Volvo (for Buses)
(53, '7900 Electric'),
(53, '9700');

-- Cars
INSERT INTO cars (brand_id, model_name) VALUES
-- Acura
    (1, 'MDX'),
    (1, 'RDX'),
    (1, 'TLX'),
    (1, 'ILX'),
    (1, 'NSX'),

-- Alfa Romeo
    (3, 'Giulia'),
    (3, 'Stelvio'),
    (3, '4C Spider'),
    (3, 'Giulietta'),
    (3, 'Tonale'),

-- Aston Martin
    (4, 'DB11'),
    (4, 'Vantage'),
    (4, 'DBS Superleggera'),
    (4, 'DBX'),
    (4, 'Rapide'),

-- Audi
    (5, 'A4'),
    (5, 'Q5'),
    (5, 'R8'),
    (5, 'A6'),
    (5, 'A3'),

-- Bentley
    (7, 'Continental GT'),
    (7, 'Bentayga'),
    (7, 'Flying Spur'),
    (7, 'Mulsanne'),
    (7, 'Bacalar'),

-- BMW
    (8, '3 Series'),
    (8, 'X5'),
    (8, 'i8'),
    (8, '5 Series'),
    (8, 'M4'),

-- Buick
    (9, 'Enclave'),
    (9, 'Regal'),
    (9, 'Encore'),
    (9, 'Envision'),
    (9, 'LaCrosse'),

-- Cadillac
    (10, 'Escalade'),
    (10, 'CTS'),
    (10, 'XT5'),
    (10, 'CT6'),
    (10, 'XT4'),

-- Chevrolet
    (12, 'Silverado'),
    (12, 'Camaro'),
    (12, 'Equinox'),
    (12, 'Malibu'),
    (12, 'Tahoe'),

-- Chrysler
    (13, 'Pacifica'),
    (13, '300'),
    (13, 'Voyager'),
    (13, 'Crossfire'),
    (13, 'Aspen'),

-- Citroën
    (14, 'C3'),
    (14, 'C5 Aircross'),
    (14, 'Berlingo'),
    (14, 'C4'),
    (14, 'DS3'),

-- Dodge
    (16, 'Charger'),
    (16, 'Challenger'),
    (16, 'Durango'),
    (16, 'Viper'),
    (16, 'Journey'),

-- Ferrari
    (18, 'Portofino'),
    (18, '488 Pista'),
    (18, 'F8 Tributo'),
    (18, 'Roma'),
    (18, '812 Superfast'),

-- Fiat
    (19, '500'),
    (19, 'Panda'),
    (19, 'Tipo'),
    (19, '500X'),
    (19, '124 Spider'),

-- Ford
    (20, 'F-150'),
    (20, 'Mustang'),
    (20, 'Explorer'),
    (20, 'Focus'),
    (20, 'Fiesta'),

-- Honda
    (24, 'Civic'),
    (24, 'Accord'),
    (24, 'CR-V'),
    (24, 'Pilot'),
    (24, 'Fit'),

-- Hyundai
    (25, 'Elantra'),
    (25, 'Santa Fe'),
    (25, 'Tucson'),
    (25, 'Sonata'),
    (25, 'Kona'),

-- Infiniti
    (26, 'Q50'),
    (26, 'QX60'),
    (26, 'QX80'),
    (26, 'Q60'),
    (26, 'QX50'),

-- Jaguar
    (27, 'F-PACE'),
    (27, 'XE'),
    (27, 'F-TYPE'),
    (27, 'XF'),
    (27, 'E-PACE'),

-- Jeep
    (30, 'Wrangler'),
    (30, 'Grand Cherokee'),
    (30, 'Compass'),
    (30, 'Renegade'),
    (30, 'Cherokee'),

-- Kia
    (31, 'Sorento'),
    (31, 'Sportage'),
    (31, 'Optima'),
    (31, 'Rio'),
    (31, 'Telluride'),

-- Land Rover
    (32, 'Range Rover'),
    (32, 'Discovery'),
    (32, 'Defender'),
    (32, 'Range Rover Sport'),
    (32, 'Range Rover Evoque'),

-- Lexus
    (33, 'RX'),
    (33, 'ES'),
    (33, 'NX'),
    (33, 'IS'),
    (33, 'UX'),

-- Lincoln
    (34, 'Navigator'),
    (34, 'Continental'),
    (34, 'MKZ'),
    (34, 'Aviator'),
    (34, 'Corsair'),

    -- Mazda
    (37, 'CX-5'),
    (37, 'Mazda3'),
    (37, 'MX-5 Miata'),
    (37, 'Mazda6'),
    (37, 'CX-30'),

    -- Mercedes-Benz
    (38, 'C-Class'),
    (38, 'E-Class'),
    (38, 'GLE'),
    (38, 'S-Class'),
    (38, 'GLC'),

    -- Mitsubishi
    (39, 'Outlander'),
    (39, 'Lancer'),
    (39, 'Eclipse Cross'),
    (39, 'Mirage'),
    (39, 'Pajero'),

    -- Nissan
    (40, 'Altima'),
    (40, 'Rogue'),
    (40, 'Leaf'),
    (40, 'Sentra'),
    (40, 'Pathfinder'),

    -- Peugeot
    (41, '208'),
    (41, '3008'),
    (41, '508'),
    (41, '2008'),
    (41, '308'),

    -- Porsche
    (42, '911'),
    (42, 'Cayenne'),
    (42, 'Panamera'),
    (42, 'Macan'),
    (42, '718 Boxster'),

    -- Renault
    (43, 'Clio'),
    (43, 'Megane'),
    (43, 'Kadjar'),
    (43, 'Captur'),
    (43, 'Zoe'),

    -- Skoda
    (46, 'Octavia'),
    (46, 'Kodiaq'),
    (46, 'Superb'),
    (46, 'Karoq'),
    (46, 'Fabia'),

    -- Subaru
    (47, 'Outback'),
    (47, 'Forester'),
    (47, 'Impreza'),
    (47, 'WRX'),
    (47, 'Legacy'),

    -- Suzuki
    (48, 'Swift'),
    (48, 'Vitara'),
    (48, 'Baleno'),
    (48, 'S-Cross'),
    (48, 'Jimny'),

    -- Tesla
    (49, 'Model S'),
    (49, 'Model X'),
    (49, 'Model 3'),
    (49, 'Model Y'),
    (49, 'Roadster'),

    -- Toyota
    (51, 'Camry'),
    (51, 'RAV4'),
    (51, 'Corolla'),
    (51, 'Prius'),
    (51, 'Highlander'),

    -- Volkswagen
    (52, 'Golf'),
    (52, 'Tiguan'),
    (52, 'Passat'),
    (52, 'Jetta'),
    (52, 'Atlas'),

    -- Volvo
    (53, 'XC90'),
    (53, 'S60'),
    (53, 'V60'),
    (53, 'XC60'),
    (53, 'S90');

-- Caravans
INSERT INTO caravans (brand_id, model_name) VALUES
-- Airstream
(2, 'Classic'),
(2, 'Flying Cloud'),
-- Winnebago
(54, 'Minnie Winnie'),
(54, 'Forza');

-- Motorcycles
INSERT INTO motorcycles (brand_id, model_name) VALUES
-- BMW (Motorcycles)
(8, 'R 1250 GS'),
(8, 'S 1000 RR'),
(8, 'F 850 GS'),
(8, 'R NineT'),
(8, 'G 310 R'),

-- Ducati
(17, 'Panigale V4'),
(17, 'Monster'),
(17, 'Multistrada'),
(17, 'Scrambler'),
(17, 'Diavel'),

-- Harley-Davidson
(23, 'Street Glide'),
(23, 'Fat Boy'),
(23, 'Sportster Iron 883'),
(23, 'Road King'),
(23, 'Softail Slim'),

-- Honda (Motorcycles)
(24, 'Gold Wing'),
(24, 'CBR1000RR'),
(24, 'Africa Twin'),
(24, 'CB500X'),
(24, 'Rebel 500'),

-- Yamaha (Motorcycles)
(55, 'YZF-R1'),
(55, 'MT-07'),
(55, 'Tenere 700'),
(55, 'YZF-R6'),
(55, 'V Star 250');

-- Trucks
INSERT INTO trucks (brand_id, model_name) VALUES
-- Daimler (Freightliner and Western Star)
(15, 'Freightliner Cascadia'),
(15, 'Freightliner M2 106'),
(15, 'Western Star 4900'),
(15, 'Freightliner 114SD'),
(15, 'Western Star 5700XE'),

-- Volvo
(53, 'Volvo FH'),
(53, 'Volvo FMX'),
(53, 'Volvo VNL'),
(53, 'Volvo VNR'),
(53, 'Volvo VHD'),

-- Scania
(44, 'Scania R Series'),
(44, 'Scania G Series'),
(44, 'Scania P Series'),
(44, 'Scania S Series'),
(44, 'Scania XT Series');
