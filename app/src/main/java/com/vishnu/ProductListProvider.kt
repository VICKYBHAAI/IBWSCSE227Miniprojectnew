package com.vishnu

import com.vishnu.ibwscse227miniproject.R

object ProductListProvider {

    fun getAllProducts(): List<ProductItem> {
        return listOf(
            ProductItem(
                id = 1,
                name = "Basmati Rice (1kg)",
                imageRes = R.drawable.rice,
                price = 120
            ),
            ProductItem(
                id = 2,
                name = "Wheat Flour (1kg)",
                imageRes = R.drawable.flour,
                price = 45
            ),
            ProductItem(id = 3, name = "Sugar (1kg)", imageRes = R.drawable.sugar, price = 42),
            ProductItem(id = 4, name = "Salt (1kg)", imageRes = R.drawable.salt, price = 20),
            ProductItem(id = 5, name = "Tur Dal (1kg)", imageRes = R.drawable.turdal, price = 110),
            ProductItem(id = 6, name = "Moong Dal (1kg)", imageRes = R.drawable.moongdal, price = 100),
            ProductItem(id = 7, name = "Chana Dal (1kg)", imageRes = R.drawable.chanadal, price = 80),
            ProductItem(id = 8, name = "Urad Dal (1kg)", imageRes = R.drawable.uraddal, price = 120),
            ProductItem(id = 9, name = "Toor Dal (1kg)", imageRes = R.drawable.toordal, price = 90),
            ProductItem(id = 10, name = "Masoor Dal (1kg)", imageRes = R.drawable.masoordal, price = 85),
            ProductItem(id = 11, name = "Rajma (500g)", imageRes = R.drawable.rajma, price = 70),
            ProductItem(id = 12, name = "Chana (500g)", imageRes = R.drawable.chana, price = 50),
            ProductItem(id = 13, name = "Moong (500g)", imageRes = R.drawable.moong, price = 60),
            ProductItem(
                id = 14,
                name = "Soya Chunks (500g)",
                imageRes = R.drawable.soyachunks,
                price = 90
            ),
            ProductItem(id = 15, name = "Besan (500g)", imageRes = R.drawable.besan, price = 55),
            ProductItem(id = 16, name = "Poha (500g)", imageRes = R.drawable.poha, price = 35),
            ProductItem(
                id = 17,
                name = "Sabudana (500g)",
                imageRes = R.drawable.sabudana,
                price = 65
            ),
            ProductItem(
                id = 18,
                name = "Vermicelli (500g)",
                imageRes = R.drawable.vermicelli,
                price = 40
            ),
            ProductItem(id = 19, name = "Maida (1kg)", imageRes = R.drawable.maida, price = 50),
            ProductItem(id = 20, name = "Rava (1kg)", imageRes = R.drawable.rava, price = 45),
            ProductItem(
                id = 21,
                name = "Jaggery (500g)",
                imageRes = R.drawable.jaggery,
                price = 60
            ),
            ProductItem(id = 22, name = "Honey (500g)", imageRes = R.drawable.honey, price = 180),
            ProductItem(
                id = 23,
                name = "Peanut Butter (500g)",
                imageRes = R.drawable.peanutbutter,
                price = 220
            ),
            ProductItem(id = 24, name = "Jam (500g)", imageRes = R.drawable.jam, price = 90),
            ProductItem(
                id = 25,
                name = "Maggi (Pack of 12)",
                imageRes = R.drawable.maggie,
                price = 120
            ),
            ProductItem(
                id = 26,
                name = "Biscuits (Parle-G)",
                imageRes = R.drawable.biscuitsparleg,
                price = 30
            ),
            ProductItem(
                id = 27,
                name = "Marie Gold (200g)",
                imageRes = R.drawable.marriegold,
                price = 25
            ),
            ProductItem(
                id = 28,
                name = "Good Day (200g)",
                imageRes = R.drawable.goodday,
                price = 35
            ),
            ProductItem(
                id = 29,
                name = "Bournvita (500g)",
                imageRes = R.drawable.bournvita,
                price = 200
            ),
            ProductItem(
                id = 30,
                name = "Horlicks (500g)",
                imageRes = R.drawable.horlicks,
                price = 220
            )
//            ProductItem(id = 31, name = "Boost (500g)", imageRes = R.drawable.boost, price = 210),
//            ProductItem(
//                id = 32,
//                name = "Complan (500g)",
//                imageRes = R.drawable.complan,
//                price = 230
//            ),
//            ProductItem(id = 33, name = "Milk (1L)", imageRes = R.drawable.milk, price = 55),
//            ProductItem(id = 34, name = "Curd (500g)", imageRes = R.drawable.curd, price = 40),
//            ProductItem(id = 35, name = "Paneer (200g)", imageRes = R.drawable.paneer, price = 80),
//            ProductItem(id = 36, name = "Butter (100g)", imageRes = R.drawable.butter, price = 50),
//            ProductItem(id = 37, name = "Ghee (500g)", imageRes = R.drawable.ghee, price = 300),
//            ProductItem(id = 38, name = "Cheese (200g)", imageRes = R.drawable.cheese, price = 120),
//            ProductItem(id = 39, name = "Eggs (Dozen)", imageRes = R.drawable.eggs, price = 60),
//            ProductItem(
//                id = 40,
//                name = "Chicken (1kg)",
//                imageRes = R.drawable.chicken,
//                price = 180
//            ),
//            ProductItem(id = 41, name = "Mutton (1kg)", imageRes = R.drawable.mutton, price = 600),
//            ProductItem(id = 42, name = "Fish (1kg)", imageRes = R.drawable.fish, price = 250),
//            ProductItem(id = 43, name = "Prawns (500g)", imageRes = R.drawable.prawns, price = 350),
//            ProductItem(id = 44, name = "Potato (1kg)", imageRes = R.drawable.potato, price = 20),
//            ProductItem(id = 45, name = "Onion (1kg)", imageRes = R.drawable.onion, price = 30),
//            ProductItem(id = 46, name = "Tomato (1kg)", imageRes = R.drawable.tomato, price = 25),
//            ProductItem(id = 47, name = "Carrot (1kg)", imageRes = R.drawable.carrot, price = 40),
//            ProductItem(id = 48, name = "Beans (500g)", imageRes = R.drawable.beans, price = 50),
//            ProductItem(id = 49, name = "Cabbage (1kg)", imageRes = R.drawable.cabbage, price = 30),
//            ProductItem(
//                id = 50,
//                name = "Cauliflower (1kg)",
//                imageRes = R.drawable.cauliflower,
//                price = 35
//            ),
//            ProductItem(id = 51, name = "Brinjal (1kg)", imageRes = R.drawable.brinjal, price = 40),
//            ProductItem(
//                id = 52,
//                name = "Ladyfinger (500g)",
//                imageRes = R.drawable.ladyfinger,
//                price = 45
//            ),
//            ProductItem(
//                id = 53,
//                name = "Cucumber (1kg)",
//                imageRes = R.drawable.cucumber,
//                price = 25
//            ),
//            ProductItem(id = 54, name = "Pumpkin (1kg)", imageRes = R.drawable.pumpkin, price = 30),
//            ProductItem(id = 55, name = "Radish (1kg)", imageRes = R.drawable.radish, price = 20),
//            ProductItem(
//                id = 56,
//                name = "Spinach (500g)",
//                imageRes = R.drawable.spinach,
//                price = 25
//            ),
//            ProductItem(
//                id = 57,
//                name = "Coriander Leaves (100g)",
//                imageRes = R.drawable.coriander,
//                price = 10
//            ),
//            ProductItem(
//                id = 58,
//                name = "Mint Leaves (100g)",
//                imageRes = R.drawable.mint,
//                price = 15
//            ),
//            ProductItem(
//                id = 59,
//                name = "Curry Leaves (100g)",
//                imageRes = R.drawable.curry_leaves,
//                price = 5
//            ),
//            ProductItem(id = 60, name = "Lemon (4pcs)", imageRes = R.drawable.lemon, price = 20),
//            ProductItem(id = 61, name = "Banana (Dozen)", imageRes = R.drawable.banana, price = 40),
//            ProductItem(id = 62, name = "Apple (1kg)", imageRes = R.drawable.apple, price = 150),
//            ProductItem(id = 63, name = "Orange (1kg)", imageRes = R.drawable.orange, price = 80),
//            ProductItem(id = 64, name = "Grapes (500g)", imageRes = R.drawable.grapes, price = 60),
//            ProductItem(
//                id = 65,
//                name = "Pomegranate (1kg)",
//                imageRes = R.drawable.pomegranate,
//                price = 120
//            ),
//            ProductItem(id = 66, name = "Mango (1kg)", imageRes = R.drawable.mango, price = 100),
//            ProductItem(
//                id = 67,
//                name = "Pineapple (1pc)",
//                imageRes = R.drawable.pineapple,
//                price = 50
//            ),
//            ProductItem(
//                id = 68,
//                name = "Watermelon (1kg)",
//                imageRes = R.drawable.watermelon,
//                price = 30
//            ),
//            ProductItem(
//                id = 69,
//                name = "Muskmelon (1kg)",
//                imageRes = R.drawable.muskmelon,
//                price = 40
//            ),
//            ProductItem(id = 70, name = "Papaya (1kg)", imageRes = R.drawable.papaya, price = 35),
//            ProductItem(id = 71, name = "Guava (1kg)", imageRes = R.drawable.guava, price = 60),
//            ProductItem(id = 72, name = "Pear (1kg)", imageRes = R.drawable.pear, price = 90),
//            ProductItem(id = 73, name = "Kiwi (4pcs)", imageRes = R.drawable.kiwi, price = 120),
//            ProductItem(
//                id = 74,
//                name = "Strawberry (250g)",
//                imageRes = R.drawable.strawberry,
//                price = 100
//            ),
//            ProductItem(id = 75, name = "Cherry (250g)", imageRes = R.drawable.cherry, price = 200),
//            ProductItem(id = 76, name = "Peach (1kg)", imageRes = R.drawable.peach, price = 110),
//            ProductItem(id = 77, name = "Plum (1kg)", imageRes = R.drawable.plum, price = 80),
//            ProductItem(id = 78, name = "Litchi (500g)", imageRes = R.drawable.litchi, price = 90),
//            ProductItem(id = 79, name = "Coconut (1pc)", imageRes = R.drawable.coconut, price = 30),
//            ProductItem(
//                id = 80,
//                name = "Almonds (250g)",
//                imageRes = R.drawable.almonds,
//                price = 250
//            ),
//            ProductItem(id = 81, name = "Cashew (250g)", imageRes = R.drawable.cashew, price = 300),
//            ProductItem(id = 82, name = "Walnut (250g)", imageRes = R.drawable.walnut, price = 280),
//            ProductItem(
//                id = 83,
//                name = "Raisins (250g)",
//                imageRes = R.drawable.raisins,
//                price = 120
//            ),
//            ProductItem(id = 84, name = "Dates (250g)", imageRes = R.drawable.dates, price = 150),
//            ProductItem(
//                id = 85,
//                name = "Pistachio (250g)",
//                imageRes = R.drawable.pistachio,
//                price = 350
//            ),
//            ProductItem(
//                id = 86,
//                name = "Peanuts (500g)",
//                imageRes = R.drawable.peanuts,
//                price = 80
//            ),
//            ProductItem(
//                id = 87,
//                name = "Sunflower Seeds (250g)",
//                imageRes = R.drawable.sunflower_seeds,
//                price = 100
//            ),
//            ProductItem(
//                id = 88,
//                name = "Pumpkin Seeds (250g)",
//                imageRes = R.drawable.pumpkin_seeds,
//                price = 120
//            ),
//            ProductItem(
//                id = 89,
//                name = "Chia Seeds (100g)",
//                imageRes = R.drawable.chia_seeds,
//                price = 150
//            ),
//            ProductItem(
//                id = 90,
//                name = "Flax Seeds (250g)",
//                imageRes = R.drawable.flax_seeds,
//                price = 90
//            ),
//            ProductItem(
//                id = 91,
//                name = "Sesame Seeds (250g)",
//                imageRes = R.drawable.sesame_seeds,
//                price = 70
//            ),
//            ProductItem(
//                id = 92,
//                name = "Mustard Seeds (250g)",
//                imageRes = R.drawable.mustard_seeds,
//                price = 50
//            ),
//            ProductItem(
//                id = 93,
//                name = "Cumin Seeds (250g)",
//                imageRes = R.drawable.cumin_seeds,
//                price = 60
//            ),
//            ProductItem(
//                id = 94,
//                name = "Fennel Seeds (250g)",
//                imageRes = R.drawable.fennel_seeds,
//                price = 55
//            ),
//            ProductItem(
//                id = 95,
//                name = "Coriander Seeds (250g)",
//                imageRes = R.drawable.coriander_seeds,
//                price = 45
//            ),
//            ProductItem(
//                id = 96,
//                name = "Fenugreek Seeds (250g)",
//                imageRes = R.drawable.fenugreek_seeds,
//                price = 40
//            ),
//            ProductItem(
//                id = 97,
//                name = "Cardamom (100g)",
//                imageRes = R.drawable.cardamom,
//                price = 200
//            ),
//            ProductItem(id = 98, name = "Cloves (100g)", imageRes = R.drawable.cloves, price = 150),
//            ProductItem(
//                id = 99,
//                name = "Cinnamon (100g)",
//                imageRes = R.drawable.cinnamon,
//                price = 120
//            ),
//            ProductItem(
//                id = 100,
//                name = "Black Pepper (100g)",
//                imageRes = R.drawable.black_pepper,
//                price = 100
//            ),
//            // Continue adding more items up to 500...
//            ProductItem(
//                id = 101,
//                name = "Turmeric Powder (100g)",
//                imageRes = R.drawable.turmeric,
//                price = 30
//            ),
//            ProductItem(
//                id = 102,
//                name = "Red Chilli Powder (100g)",
//                imageRes = R.drawable.chilli_powder,
//                price = 40
//            ),
//            ProductItem(
//                id = 103,
//                name = "Coriander Powder (100g)",
//                imageRes = R.drawable.coriander_powder,
//                price = 35
//            ),
//            ProductItem(
//                id = 104,
//                name = "Garam Masala (100g)",
//                imageRes = R.drawable.garam_masala,
//                price = 50
//            ),
//            ProductItem(
//                id = 105,
//                name = "Tea Powder (250g)",
//                imageRes = R.drawable.tea_powder,
//                price = 80
//            ),
//            ProductItem(
//                id = 106,
//                name = "Coffee Powder (250g)",
//                imageRes = R.drawable.coffee_powder,
//                price = 120
//            ),
//            ProductItem(
//                id = 107,
//                name = "Green Tea (50g)",
//                imageRes = R.drawable.green_tea,
//                price = 100
//            ),
//            ProductItem(
//                id = 108,
//                name = "Black Tea (50g)",
//                imageRes = R.drawable.black_tea,
//                price = 90
//            ),
//            ProductItem(
//                id = 109,
//                name = "Herbal Tea (50g)",
//                imageRes = R.drawable.herbal_tea,
//                price = 110
//            ),
//            ProductItem(
//                id = 110,
//                name = "Lemon Tea (50g)",
//                imageRes = R.drawable.lemon_tea,
//                price = 95
//            ),
//            ProductItem(
//                id = 111,
//                name = "Coconut Oil (500ml)",
//                imageRes = R.drawable.coconut_oil,
//                price = 200
//            ),
//            ProductItem(
//                id = 112,
//                name = "Olive Oil (500ml)",
//                imageRes = R.drawable.olive_oil,
//                price = 300
//            ),
//            ProductItem(
//                id = 113,
//                name = "Sunflower Oil (1L)",
//                imageRes = R.drawable.sunflower_oil,
//                price = 150
//            ),
//            ProductItem(
//                id = 114,
//                name = "Mustard Oil (1L)",
//                imageRes = R.drawable.mustard_oil,
//                price = 120
//            ),
//            ProductItem(
//                id = 115,
//                name = "Soybean Oil (1L)",
//                imageRes = R.drawable.soybean_oil,
//                price = 130
//            ),
//            ProductItem(
//                id = 116,
//                name = "Groundnut Oil (1L)",
//                imageRes = R.drawable.groundnut_oil,
//                price = 180
//            ),
//            ProductItem(
//                id = 117,
//                name = "Gingelly Oil (500ml)",
//                imageRes = R.drawable.gingelly_oil,
//                price = 220
//            ),
//            ProductItem(
//                id = 118,
//                name = "Rice Bran Oil (1L)",
//                imageRes = R.drawable.rice_bran_oil,
//                price = 140
//            ),
//            ProductItem(
//                id = 119,
//                name = "Corn Oil (1L)",
//                imageRes = R.drawable.corn_oil,
//                price = 160
//            ),
//            ProductItem(
//                id = 120,
//                name = "Vinegar (500ml)",
//                imageRes = R.drawable.vinegar,
//                price = 50
//            ),
//            ProductItem(
//                id = 121,
//                name = "Soya Sauce (500ml)",
//                imageRes = R.drawable.soya_sauce,
//                price = 80
//            ),
//            ProductItem(
//                id = 122,
//                name = "Tomato Ketchup (500g)",
//                imageRes = R.drawable.tomato_ketchup,
//                price = 70
//            ),
//            ProductItem(
//                id = 123,
//                name = "Green Chilli Sauce (200g)",
//                imageRes = R.drawable.chilli_sauce,
//                price = 60
//            ),
//            ProductItem(
//                id = 124,
//                name = "Mayonnaise (200g)",
//                imageRes = R.drawable.mayonnaise,
//                price = 90
//            ),
//            ProductItem(
//                id = 125,
//                name = "Mustard Sauce (200g)",
//                imageRes = R.drawable.mustard_sauce,
//                price = 75
//            ),
//            ProductItem(
//                id = 126,
//                name = "Pepper Powder (100g)",
//                imageRes = R.drawable.pepper_powder,
//                price = 60
//            ),
//            ProductItem(
//                id = 127,
//                name = "Oregano (50g)",
//                imageRes = R.drawable.oregano,
//                price = 80
//            ),
//            ProductItem(
//                id = 128,
//                name = "Chilli Flakes (50g)",
//                imageRes = R.drawable.chilli_flakes,
//                price = 50
//            ),
//            ProductItem(
//                id = 129,
//                name = "Mixed Herbs (50g)",
//                imageRes = R.drawable.mixed_herbs,
//                price = 90
//            ),
//            ProductItem(
//                id = 130,
//                name = "Basil Leaves (50g)",
//                imageRes = R.drawable.basil_leaves,
//                price = 70
//            ),
//            ProductItem(id = 131, name = "Thyme (50g)", imageRes = R.drawable.thyme, price = 85),
//            ProductItem(
//                id = 132,
//                name = "Rosemary (50g)",
//                imageRes = R.drawable.rosemary,
//                price = 95
//            ),
//            ProductItem(
//                id = 133,
//                name = "Parsley (50g)",
//                imageRes = R.drawable.parsley,
//                price = 75
//            ),
//            ProductItem(
//                id = 134,
//                name = "Mint Leaves (50g)",
//                imageRes = R.drawable.mint_leaves,
//                price = 65
//            ),
//            ProductItem(
//                id = 135,
//                name = "Curry Powder (100g)",
//                imageRes = R.drawable.curry_powder,
//                price = 55
//            ),
//            ProductItem(
//                id = 136,
//                name = "Biryani Masala (100g)",
//                imageRes = R.drawable.biryani_masala,
//                price = 65
//            ),
//            ProductItem(
//                id = 137,
//                name = "Pav Bhaji Masala (100g)",
//                imageRes = R.drawable.pav_bhaji_masala,
//                price = 60
//            ),
//            ProductItem(
//                id = 138,
//                name = "Chaat Masala (100g)",
//                imageRes = R.drawable.chaat_masala,
//                price = 50
//            ),
//            ProductItem(
//                id = 139,
//                name = "Sambar Powder (100g)",
//                imageRes = R.drawable.sambar_powder,
//                price = 55
//            ),
//            ProductItem(
//                id = 140,
//                name = "Rasam Powder (100g)",
//                imageRes = R.drawable.rasam_powder,
//                price = 50
//            ),
//            ProductItem(
//                id = 141,
//                name = "Pickle (Mango) (500g)",
//                imageRes = R.drawable.mango_pickle,
//                price = 120
//            ),
//            ProductItem(
//                id = 142,
//                name = "Pickle (Lemon) (500g)",
//                imageRes = R.drawable.lemon_pickle,
//                price = 110
//            ),
//            ProductItem(
//                id = 143,
//                name = "Pickle (Mixed) (500g)",
//                imageRes = R.drawable.mixed_pickle,
//                price = 130
//            ),
//            ProductItem(
//                id = 144,
//                name = "Pickle (Chilli) (500g)",
//                imageRes = R.drawable.chilli_pickle,
//                price = 100
//            ),
//            ProductItem(
//                id = 145,
//                name = "Pickle (Garlic) (500g)",
//                imageRes = R.drawable.garlic_pickle,
//                price = 140
//            ),
//            ProductItem(id = 146, name = "Papad (100g)", imageRes = R.drawable.papad, price = 40),
//            ProductItem(id = 147, name = "Fryums (200g)", imageRes = R.drawable.fryums, price = 60),
//            ProductItem(id = 148, name = "Pasta (500g)", imageRes = R.drawable.pasta, price = 70),
//            ProductItem(
//                id = 149,
//                name = "Noodles (500g)",
//                imageRes = R.drawable.noodles,
//                price = 65
//            ),
//            ProductItem(
//                id = 150,
//                name = "Macaroni (500g)",
//                imageRes = R.drawable.macaroni,
//                price = 75
//            ),
//            ProductItem(
//                id = 151,
//                name = "Spaghetti (500g)",
//                imageRes = R.drawable.spaghetti,
//                price = 80
//            ),
//            ProductItem(id = 152, name = "Penne (500g)", imageRes = R.drawable.penne, price = 85),
//            ProductItem(
//                id = 153,
//                name = "Fusilli (500g)",
//                imageRes = R.drawable.fusilli,
//                price = 90
//            ),
//            ProductItem(
//                id = 154,
//                name = "Lasagne Sheets (250g)",
//                imageRes = R.drawable.lasagne,
//                price = 100
//            ),
//            ProductItem(
//                id = 155,
//                name = "Vermicelli (500g)",
//                imageRes = R.drawable.vermicelli,
//                price = 60
//            ),
//            ProductItem(
//                id = 156,
//                name = "Cornflakes (500g)",
//                imageRes = R.drawable.cornflakes,
//                price = 90
//            ),
//            ProductItem(id = 157, name = "Oats (500g)", imageRes = R.drawable.oats, price = 80),
//            ProductItem(
//                id = 158,
//                name = "Muesli (500g)",
//                imageRes = R.drawable.muesli,
//                price = 120
//            ),
//            ProductItem(
//                id = 159,
//                name = "Chocos (500g)",
//                imageRes = R.drawable.chocos,
//                price = 110
//            ),
//            ProductItem(
//                id = 160,
//                name = "Kellogg's (500g)",
//                imageRes = R.drawable.kelloggs,
//                price = 130
//            ),
//            ProductItem(id = 161, name = "Bread (400g)", imageRes = R.drawable.bread, price = 35),
//            ProductItem(
//                id = 162,
//                name = "Brown Bread (400g)",
//                imageRes = R.drawable.brown_bread,
//                price = 45
//            ),
//            ProductItem(
//                id = 163,
//                name = "Multigrain Bread (400g)",
//                imageRes = R.drawable.multigrain_bread,
//                price = 50
//            ),
//            ProductItem(
//                id = 164,
//                name = "Milk Bread (400g)",
//                imageRes = R.drawable.milk_bread,
//                price = 40
//            ),
//            ProductItem(id = 165, name = "Bun (6pcs)", imageRes = R.drawable.bun, price = 30),
//            ProductItem(id = 166, name = "Pav (6pcs)", imageRes = R.drawable.pav, price = 25),
//            ProductItem(
//                id = 167,
//                name = "Croissant (2pcs)",
//                imageRes = R.drawable.croissant,
//                price = 60
//            ),
//            ProductItem(id = 168, name = "Donut (2pcs)", imageRes = R.drawable.donut, price = 70),
//            ProductItem(id = 169, name = "Cake (500g)", imageRes = R.drawable.cake, price = 200),
//            ProductItem(id = 170, name = "Pastry (2pcs)", imageRes = R.drawable.pastry, price = 80),
//            ProductItem(id = 171, name = "Muffin (2pcs)", imageRes = R.drawable.muffin, price = 90),
//            ProductItem(
//                id = 172,
//                name = "Cookies (200g)",
//                imageRes = R.drawable.cookies,
//                price = 60
//            ),
//            ProductItem(
//                id = 173,
//                name = "Cream Biscuits (200g)",
//                imageRes = R.drawable.cream_biscuits,
//                price = 50
//            ),
//            ProductItem(
//                id = 174,
//                name = "Digestive Biscuits (200g)",
//                imageRes = R.drawable.digestive_biscuits,
//                price = 55
//            ),
//            ProductItem(
//                id = 175,
//                name = "Marie Biscuits (200g)",
//                imageRes = R.drawable.marie_biscuits,
//                price = 40
//            ),
//            ProductItem(
//                id = 176,
//                name = "Khakhra (200g)",
//                imageRes = R.drawable.khakhra,
//                price = 70
//            ),
//            ProductItem(id = 177, name = "Thepla (200g)", imageRes = R.drawable.thepla, price = 80),
//            ProductItem(id = 178, name = "Mathri (200g)", imageRes = R.drawable.mathri, price = 60),
//            ProductItem(
//                id = 179,
//                name = "Namkeen (200g)",
//                imageRes = R.drawable.namkeen,
//                price = 50
//            ),
//            ProductItem(id = 180, name = "Bhujia (200g)", imageRes = R.drawable.bhujia, price = 45),
//            ProductItem(
//                id = 181,
//                name = "Chips (Lays) (50g)",
//                imageRes = R.drawable.chips,
//                price = 20
//            ),
//            ProductItem(
//                id = 182,
//                name = "Kurkure (50g)",
//                imageRes = R.drawable.kurkure,
//                price = 20
//            ),
//            ProductItem(id = 183, name = "Bingo (50g)", imageRes = R.drawable.bingo, price = 20),
//            ProductItem(
//                id = 184,
//                name = "Cheese Balls (50g)",
//                imageRes = R.drawable.cheese_balls,
//                price = 25
//            ),
//            ProductItem(
//                id = 185,
//                name = "Popcorn (100g)",
//                imageRes = R.drawable.popcorn,
//                price = 30
//            ),
//            ProductItem(
//                id = 186,
//                name = "Chocolate (Dairy Milk) (50g)",
//                imageRes = R.drawable.chocolate,
//                price = 50
//            ),
//            ProductItem(
//                id = 187,
//                name = "5 Star (50g)",
//                imageRes = R.drawable.five_star,
//                price = 45
//            ),
//            ProductItem(id = 188, name = "Perk (50g)", imageRes = R.drawable.perk, price = 40),
//            ProductItem(id = 189, name = "KitKat (50g)", imageRes = R.drawable.kitkat, price = 50),
//            ProductItem(
//                id = 190,
//                name = "Snickers (50g)",
//                imageRes = R.drawable.snickers,
//                price = 55
//            ),
//            ProductItem(id = 191, name = "Munch (50g)", imageRes = R.drawable.munch, price = 40),
//            ProductItem(
//                id = 192,
//                name = "Milky Bar (50g)",
//                imageRes = R.drawable.milky_bar,
//                price = 45
//            ),
//            ProductItem(id = 193, name = "Gems (50g)", imageRes = R.drawable.gems, price = 30),
//            ProductItem(
//                id = 194,
//                name = "Nutties (50g)",
//                imageRes = R.drawable.nutties,
//                price = 35
//            ),
//            ProductItem(
//                id = 195,
//                name = "Eclairs (50g)",
//                imageRes = R.drawable.eclairs,
//                price = 25
//            ),
//            ProductItem(id = 196, name = "Pulse (50g)", imageRes = R.drawable.pulse, price = 20),
//            ProductItem(id = 197, name = "Melody (50g)", imageRes = R.drawable.melody, price = 30),
//            ProductItem(
//                id = 198,
//                name = "Coffee Bite (50g)",
//                imageRes = R.drawable.coffee_bite,
//                price = 35
//            ),
//            ProductItem(
//                id = 199,
//                name = "Candyman (50g)",
//                imageRes = R.drawable.candyman,
//                price = 25
//            ),
//            ProductItem(
//                id = 200,
//                name = "Lollipop (5pcs)",
//                imageRes = R.drawable.lollipop,
//                price = 30
//            )
        )
    }
    fun fromFirebaseMap(map: Map<String, Any>): ProductItem {
        return ProductItem(
            id = map["id"] as? String ?: "",
            name = map["name"] as? String ?: "",
            imageUrl = map["imageUrl"] as? String ?: "",
            price = (map["price"] as? Double) ?: 0.0,
            quantity = (map["quantity"] as? Int) ?: 1
        )
    }
}