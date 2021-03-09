INSERT INTO foods (name,image,gram,quantity,price,description,food_type_id)
VALUES ('АЛЯСКА',
        'http://dvepalochki.kg/wp-content/uploads/2019/06/d19-300x300.jpg',
        210,
        8,
        280,
        'Лосось, огурец, тобико',
        (select id from food_types
        where name = "cold_roll"));

        INSERT INTO foods (name,image,gram,quantity,price,description,food_type_id)
VALUES
        ('АМЕРИКА МАКИ',
        'http://dvepalochki.kg/wp-content/uploads/2019/06/55555-300x300.jpg',
        230,
        8,
        300,
        'Копченый лосось, угорь, сливочный сыр, огурец',
        (select id from food_types
        where name = "cold_roll"));

        INSERT INTO foods (name,image,gram,quantity,price,description,food_type_id)
VALUES
        ('БОНИТО',
        'http://dvepalochki.kg/wp-content/uploads/2019/06/D110-300x300.jpg',
        210,
        8,
        240,
        'Копченый лосось, угорь, сливочный сыр, огурец',
        (select id from food_types
        where name = "cold_roll"));

        INSERT INTO foods (name,image,gram,quantity,price,description,food_type_id)
VALUES
        ('АРАМАКИ',
        'http://dvepalochki.kg/wp-content/uploads/2019/06/D85-min-300x300.jpg',
        250,
        8,
        290,
        'Лосось, омлет, сливочный сыр, тобико',
        (select id from food_types
        where name = "baked_roll"));
        INSERT INTO foods (name,image,gram,quantity,price,description,food_type_id)
VALUES
        ('АЯШИ',
        'http://dvepalochki.kg/wp-content/uploads/2019/06/D91-min-300x300.jpg',
        180,
        5,
        180,
        'Сырный соус, омлет, крабовый крем, тобико',
        (select id from food_types
        where name = "baked_roll"));
        INSERT INTO foods (name,image,gram,quantity,price,description,food_type_id)
VALUES
         ('ЛЕГЕНДА',
        'http://dvepalochki.kg/wp-content/uploads/2019/06/D85-min-300x300.jpg',
        250,
        8,
        320,
        'Лосось, угорь, креветка, сливочный сыр, тобико',
        (select id from food_types
        where name = "baked_roll"));

        INSERT INTO foods (name,image,gram,quantity,price,description,food_type_id)
VALUES
         ('СЯКЕ ФРАЙ',
        'http://dvepalochki.kg/wp-content/uploads/2019/06/D71-min-300x300.jpg',
        240,
        8,
        260,
        'Лосось, авокадо, сливочный сыр, тобико',
        (select id from food_types
        where name = "fried_roll"));

        INSERT INTO foods (name,image,gram,quantity,price,description,food_type_id)
VALUES
         ('ЗАПЕЧЕННЫЕ МИДИИ',
        'http://dvepalochki.kg/wp-content/uploads/2019/06/D54-min-300x300.jpg',
        150,
        8,
        250,
        'Мидии, яки соус',
        (select id from food_types
        where name = "snacks"));

        INSERT INTO foods (name,image,gram,quantity,price,description,food_type_id)
VALUES
         ('СУШИ ЛОСОСЬ',
        'http://dvepalochki.kg/wp-content/uploads/2019/06/parallax-item-3.png',
        30,
        1,
        55,
        'ЛОСОСЬ',
        (select id from food_types
        where name = "sushi"));

        INSERT INTO foods (name,image,gram,quantity,price,description,food_type_id)
VALUES
         ('ВСЕ ВКЛЮЧЕНО',
        'http://dvepalochki.kg/wp-content/uploads/2019/06/D140-min-300x300.jpg',
        1790,
        64,
        1800,
        'Филадельфия, Калифорния, Чикен ролл, Ролл с угрем, Темпура с лососем, Унаги фрай, Аяши, Легенда, суши Лосось, суши Креветка, суши Угорь, суши Томаго, суши Копченый Лосось',
        (select id from food_types
        where name = "set"));

        INSERT INTO foods (name,image,gram,quantity,price,description,food_type_id)
VALUES
         ('ЛАНЧ №1 (ДО 15:00)',
        'http://dvepalochki.kg/wp-content/uploads/2019/06/sushi-png-pic_7-1-300x300.jpg',
        1,
        1,
        300,
        'Супы: Мисо/Кимчи/Сливочный + Любой ролл до 250 с',
        (select id from food_types
        where name = "lunch"));

        INSERT INTO foods (name,image,gram,quantity,price,description,food_type_id)
VALUES
         ('КИМЧИ СУП',
        'http://dvepalochki.kg/wp-content/uploads/2019/06/D49-min-300x300.jpg',
        310,
        1,
        130,
        'Мисо паста, яйцо, сыр тофу, водоросли вакамэ, кимчи соус',
        (select id from food_types
        where name = "soup"));

        INSERT INTO foods (name,image,gram,quantity,price,description,food_type_id)
VALUES
         ('МИНАРИ',
        'http://dvepalochki.kg/wp-content/uploads/2019/06/D45-min-300x300.jpg',
        130,
        6,
        50,
        'Рисовое тесто, банан, киви, сливочный сыр',
        (select id from food_types
        where name = "dessert"));

        INSERT INTO foods (name,image,gram,quantity,price,description,food_type_id)
VALUES
         ('КЛЮКВЕННЫЙ МОРС',
        'http://dvepalochki.kg/wp-content/uploads/2019/06/b7860bc0-300x300.jpg',
        1,
        1,
        100,
        'морс из клюквы',
        (select id from food_types
        where name = "cold_drink"));



         INSERT INTO foods (name,image,gram,quantity,price,description,food_type_id)
VALUES
         ('ВОСХОДЯЩЕЕ СОЛНЦЕ',
        'http://dvepalochki.kg/wp-content/uploads/2019/06/koktail-300x300.jpg',
        300,
        1,
        120,
        'Соки: апельсиновый, гранатовый, ананасовый, сироп манго, банан свежий',
        (select id from food_types
        where name = "milk_drink"));
         INSERT INTO foods (name,image,gram,quantity,price,description,food_type_id)
VALUES
         ('АЙС ЛАТТЕ',
        'http://dvepalochki.kg/wp-content/uploads/2019/06/cofe-1-300x300.jpg',
        300,
        1,
        150,
        'Молоко, эспрессо, лед, сироп',
        (select id from food_types
        where name = "coffee"));

         INSERT INTO foods (name,image,gram,quantity,price,description,food_type_id)
VALUES
         ('АЛТАЙСКИЙ ЧАЙ',
        'http://dvepalochki.kg/wp-content/uploads/2019/06/chai-1.jpg',
        600,
        1,
        150,
        'Сироп черносмородиновый, сок вишня, сок имбирный, мед, апельсин, корица',
        (select id from food_types
        where name = "tea"));

         INSERT INTO foods (name,image,gram,quantity,price,description,food_type_id)
VALUES
         ('ВАСАБИ',
        'http://dvepalochki.kg/wp-content/uploads/2019/06/addition1-300x300.jpg',
        7,
        1,
        30,
        'ВАСАБИ',
        (select id from food_types
        where name = "extra"))
        ;