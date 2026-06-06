package com.yigittepe.nearcampus1.data

import androidx.compose.ui.graphics.Color
import com.yigittepe.nearcampus1.model.Discount
import com.yigittepe.nearcampus1.model.MenuCategory
import com.yigittepe.nearcampus1.model.MenuItem
import com.yigittepe.nearcampus1.model.Review
import com.yigittepe.nearcampus1.model.Venue

internal object MockNearCampusRepository {
    val venues = listOf(
        Venue(
            id = "babs-hisarustu",
            name = "Bab's Hisarüstü",
            category = "Pub / Bar",
            distanceKm = 0.2,
            rating = 4.6,
            price = "₺₺",
            openNow = true,
            discount = null,
            address = "Rumeli Hisarı, Hisar Üstü Nispetiye Cd No:89, 34470 Sarıyer/İstanbul",
            phone = "",
            palette = listOf(Color(0xFF1A1A1A), Color(0xFFC5A880), Color(0xFFFFFFFF)),
            favorite = false,
            latitude = 41.087278,
            longitude = 29.050148,
            imageUrl = "https://static.parastorage.com/services/restaurant-menus-showcase-ooi/9fcd779d28a5e12fd1a103bc3353803383dbc4b835f6b6502ef7f9bf/media/menus_side_image.7077f229.jpeg"
        ),
        Venue(
            id = "dynamite-kitchen",
            name = "Dynamite Kitchen",
            category = "Restaurant / Dinner",
            distanceKm = 0.4,
            rating = 3.3,
            price = "₺₺",
            openNow = true,
            discount = null,
            address = "Hisarüstü Nispetiye Cad., No:71A, Rumelihisarı Mah., Sarıyer, İstanbul",
            phone = "+90 212 000 1010",
            palette = listOf(Color(0xFF101820), Color(0xFF775A19), Color(0xFF1A365D)),
            favorite = false,
            latitude = 41.086482,
            longitude = 29.04922,
            imageUrl = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqmZjWfYWjcTKxlkgH7.jpg?alt=media&token=2bb217bb-7ddb-458d-b9c5-54af20a9b7da"
        ),
        Venue(
            id = "hamburg-burger-hisarustu",
            name = "Hamburg Burger",
            category = "Restaurant / Burger",
            distanceKm = 0.1,
            rating = 4.5,
            price = "₺₺",
            openNow = true,
            discount = null,
            address = "Rumeli Hisarı,  Cami Sk. No:19/A, Rumelihisarı Mah, Sarıyer",
            phone = "05323238935",
            palette = listOf(Color(0xFF0B131F), Color(0xFFF5A623), Color(0xFFFFFFFF)),
            favorite = false,
            latitude = 41.085948,
            longitude = 29.046054,
            imageUrl = "https://res.disoo.com/GCP/business/gcp_merchant_2be3f080f56a8ade4eeddbe0017bb9a3.jpeg"
        ),
        Venue(
            id = "miligram-coffee-hisarustu",
            name = "Miligram Coffee",
            category = "Cafe / Coffee",
            distanceKm = 0.3,
            rating = 4.5,
            price = "₺₺",
            openNow = true,
            discount = null,
            address = "Nispetiye Cad., No:154, Beşiktaş, İstanbul",
            phone = "",
            palette = listOf(Color(0xFF1A1A1A), Color(0xFFFFFFFF), Color(0xFFC5A880)),
            favorite = false,
            latitude = 41.085173,
            longitude = 29.045326,
            imageUrl = "https://d1menc1ksg2bot.cloudfront.net/images/restaurant/odlkB93QNWOVmTzY1ZurLyht1Ve21672863703849.jpg"
        ),
    )

    fun menuCategories(id: String): List<MenuCategory> =
        when (id) {
            "babs-hisarustu" -> listOf(
                MenuCategory(
                    name = "Kampanyalar - Kokteyl Kampanyaları",
                    no = 0,
                    details = "Her ay seçili kokteyllerde %20'ye varan indirim",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Lemon Drop Martini (Kampanya)",
                            category = "",
                            price = 350,
                            details = "Votka, Portakal Likörü ve Limon Suyu",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Aperol Spritz (Kampanya)",
                            category = "",
                            price = 350,
                            details = "Aperol, Köpüklü Şarap, Soda",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Limoncello Spritz (Kampanya)",
                            category = "",
                            price = 350,
                            details = "Limoncello, köpüklü şarap ve soda",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Sex On The Beach (Kampanya)",
                            category = "",
                            price = 350,
                            details = "Votka, şeftali likörü, cranberry juice ve portakal suyu",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Kampanyalar - Bira Kampanyaları",
                    no = 1,
                    details = "Her hafta seçili biralarda süper indirimler",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "à santé - Double IPA",
                            category = "",
                            price = 250,
                            details = "Tropik ve çam aromalı %8 alkol oranıyla öne çıkan kraft bira",
                            image = "https://static.wixstatic.com/media/ced9d3_065d83b7acfb496da6a4db3e00cc1f01~mv2.avif/v1/fill/w_147,h_214,al_c,q_80,usm_0.66_1.00_0.01,blur_2,enc_auto/ced9d3_065d83b7acfb496da6a4db3e00cc1f01~mv2.avif",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "à santé - Belgian Strong",
                            category = "",
                            price = 250,
                            details = "Muz, karanfil ve karabiber aromalı %8 alkol oranıyla Ale tipi kraft bira",
                            image = "https://static.wixstatic.com/media/ced9d3_0034aa4c9aa545c2b069d9625110eebb~mv2.avif/v1/fill/w_147,h_221,al_c,q_80,usm_0.66_1.00_0.01,blur_2,enc_auto/ced9d3_0034aa4c9aa545c2b069d9625110eebb~mv2.avif",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "à santé - West Coast IPA",
                            category = "",
                            price = 250,
                            details = "Floral, greyfurt ve çam aromalı %6 alkol oranıyla IPA tipi kraft bira",
                            image = "https://static.wixstatic.com/media/ced9d3_7d4c6e2e5e924778be14a04ad6586e29~mv2.avif/v1/fill/w_147,h_221,al_c,q_80,usm_0.66_1.00_0.01,blur_2,enc_auto/ced9d3_7d4c6e2e5e924778be14a04ad6586e29~mv2.avif",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "à santé - Vienna Lager",
                            category = "",
                            price = 250,
                            details = "Kızarmış ekmek ve malt aromalı %5 alkol oranıyla Lager tipi kraft bira",
                            image = "https://static.wixstatic.com/media/ced9d3_88294e8db0c048c5ab3e07b1c57692dd~mv2.avif/v1/fill/w_147,h_221,al_c,q_80,usm_0.66_1.00_0.01,blur_2,enc_auto/ced9d3_88294e8db0c048c5ab3e07b1c57692dd~mv2.avif",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "à santé - New Zealand Pilsner",
                            category = "",
                            price = 250,
                            details = "Floral ve tropik meyve aromalı %5 alkol oranıyla Pilsner tipi kraft bira",
                            image = "https://static.wixstatic.com/media/ced9d3_046ed3fb8d98403b95878db13010f7e0~mv2.avif/v1/fill/w_147,h_221,al_c,q_80,usm_0.66_1.00_0.01,blur_2,enc_auto/ced9d3_046ed3fb8d98403b95878db13010f7e0~mv2.avif",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "à santé - Saison",
                            category = "",
                            price = 250,
                            details = "Muz ve turunçgil aromalı %5 alkol oranıyla çiftlik birası olarak da bilinen kraft bira",
                            image = "https://static.wixstatic.com/media/ced9d3_e91707c98d7d4adcaed0d3028f929a3f~mv2.avif/v1/fill/w_147,h_221,al_c,q_80,usm_0.66_1.00_0.01,blur_2,enc_auto/ced9d3_e91707c98d7d4adcaed0d3028f929a3f~mv2.avif",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "à santé - Summer Lager",
                            category = "",
                            price = 250,
                            details = "Mevsimsel aromaları ve %4.2 alkol oranıyla öne çıkan kraft bira",
                            image = "https://static.wixstatic.com/media/ced9d3_6f16abc6830c4ce5aa6a3ae1642e6a44~mv2.avif/v1/fill/w_147,h_195,al_c,q_80,usm_0.66_1.00_0.01,blur_2,enc_auto/ced9d3_6f16abc6830c4ce5aa6a3ae1642e6a44~mv2.avif",
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Kampanyalar - Şarap Kampanyaları",
                    no = 2,
                    details = "Her hafta seçili şaraplarda süper indirimler",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Doluca,Beyaz Şişe",
                            category = "",
                            price = 800,
                            details = "75cl, Sultaniye, Emir",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Doluca,Rose Şişe",
                            category = "",
                            price = 800,
                            details = "75cl, Çal Karası, Grenache",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Kampanyalar - Shot Kampanyaları",
                    no = 3,
                    details = "Sınırlı süre için seçili shotlarda indirim",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "The Jack Daniel's (6'lı)",
                            category = "",
                            price = 900,
                            details = "Jack Daniel's Apple, Honey ve Fire'den ikişer shot. Tüm lezzetler, ikişer doz!",
                            image = "https://static.wixstatic.com/media/ced9d3_f501c3a685d84ecca78e59d0367b607f~mv2.jpg/v1/fill/w_147,h_196,al_c,q_80,usm_0.66_1.00_0.01,blur_2,enc_auto/ced9d3_f501c3a685d84ecca78e59d0367b607f~mv2.jpg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "The Jäger Double Trio (6'lı)",
                            category = "",
                            price = 900,
                            details = "Jägermeister Classic, Orange ve Cold Brew'den ikişer shot. Tüm lezzetler, ikişer doz!",
                            image = "https://static.wixstatic.com/media/ced9d3_5493074646384d12b0b3d78ad75f1656~mv2.jpg/v1/fill/w_147,h_96,al_c,q_80,usm_0.66_1.00_0.01,blur_2,enc_auto/ced9d3_5493074646384d12b0b3d78ad75f1656~mv2.jpg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "7'li Rainbow Likör Shot",
                            category = "",
                            price = 450,
                            details = "Yeşil Elma, Karpuz-Çilek, Lime-Limon, Kırmızı Orman Meyveleri, Tropik Meyveler, Vişne ve Çilek-Agave Aromalı Likör Shotlar.",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Tekli Rainbow Shot",
                            category = "",
                            price = 90,
                            details = "Dilediğiniz Aroması ile",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Jack Shot + Efes Fıçı",
                            category = "",
                            price = 550,
                            details = "1'er shot jack apple, honey, ve fire. Yanında 50cl Fıçı Efes",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Kampanyalar - Happy Hours (7'ye kadar)",
                    no = 4,
                    details = "7'ye kadar, mutlu eden fiyatlar.",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Bud Fıçı (50cl.)",
                            category = "",
                            price = 130,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Becks Fıçı (50cl.)",
                            category = "",
                            price = 130,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Efes Pilsen Fıçı (50cl.)",
                            category = "",
                            price = 130,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Sangria (Cuma-Cumartesi Hariç)",
                            category = "",
                            price = 200,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Kampanyalar - Atıştıran Kampanyalar (Cuma - Cumartesi Hariç)",
                    no = 5,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "2 Fıçı Bira + Patates",
                            category = "",
                            price = 460,
                            details = "Soft içecekler ya da Efes Pilsen Fıçı ve Baharatlı Patates Kızartması",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Yemekler - Burgerler",
                    no = 6,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Hamburger",
                            category = "",
                            price = 430,
                            details = "120 gr. burger köftesi, yeşillik, karamelize soğan yanında patates ve coleslaw ile",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Cheeseburger",
                            category = "",
                            price = 450,
                            details = "120 gr. burger köftesi, double cheddar, yeşillik, karamelize soğan yanında patates ve coleslaw ile",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "BBQ Burger",
                            category = "",
                            price = 450,
                            details = "120 gr. burger köftesi, cheddar, BBQ sos, karamelize soğan yanında patates ve coleslaw ile",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Tnt Burger",
                            category = "",
                            price = 460,
                            details = "120 gr. burger köftesi, cheddar, tnt sos, karamelize soğan yanında patates ve coleslaw ile",
                            image = "https://static.wixstatic.com/shapes/ec845c_4f5504ceb3f84cd18f72f779dcad9078.svg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Köz Burger",
                            category = "",
                            price = 460,
                            details = "120 gr. burger köftesi, cheddar, köz patlıcan sos, karamelize soğan yanında patates ve coleslaw ile",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Rokfor Burger",
                            category = "",
                            price = 480,
                            details = "120 gr. burger köftesi, cheddar, kapya biberli rokfor sos, karamelize soğan yanında patates ve coleslaw ile",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Mushroom Burger",
                            category = "",
                            price = 480,
                            details = "120 gr. burger köftesi, cheddar, worcestershire mushroom sos, karamelize soğan yanında patates ve coleslaw ile",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Bab's Burger",
                            category = "",
                            price = 850,
                            details = "240 gr. burger köftesi, double cheddar, dilediğiniz burger sosu, karamelize soğan yanında patates ve coleslaw ile",
                            image = "https://static.wixstatic.com/shapes/ced9d3_79d11b3af68f46be8bcb05e73bc65c0d.svg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Çıtır Balık Burger",
                            category = "",
                            price = 420,
                            details = "90 gr. çıtır balık parçaları, yeşillik, karamelize soğan yanında patates ve coleslaw ile",
                            image = "https://static.wixstatic.com/shapes/ec845c_aec44ab07aaf49a6b76a2d53c6dea7f4.svg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Hellim Burger",
                            category = "",
                            price = 450,
                            details = "Çıtır hellim parçaları, yeşillik, karamelize soğan yanında patates ve coleslaw ile",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Chicken Schnitzel Burger",
                            category = "",
                            price = 450,
                            details = "Tavuk schnitzel, marul, karamelize soğan yanında patates ve coleslaw ile",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Vegan Schnitzel Burger",
                            category = "",
                            price = 450,
                            details = "90 gr. veggy schnitzel, yeşillik, karamelize soğan yanında patates ve coleslaw ile",
                            image = "https://static.wixstatic.com/shapes/ec845c_2306a227a54044a9999b9f5e5fdf2185.svg",
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Yemekler - Bar Sepetleri",
                    no = 7,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Box No: 0",
                            category = "",
                            price = 480,
                            details = "2 adet sigara böreği, 2 adet veggy sticks, 2 adet soğan halkası, patates ve sweet carrot sos",
                            image = "https://static.wixstatic.com/shapes/ec845c_1e2d7b43595d4211a518c7876faa837c.svg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Box No: 1",
                            category = "",
                            price = 490,
                            details = "2 adet tavuklu mısır topu, 2 adet crispy fish, 2 adet sigara böreği, patates ve chili mayonez sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Box No: 2",
                            category = "",
                            price = 550,
                            details = "2 adet chicken finger, 2 adet hellim stick, 2 adet çin böreği, patates ve köz kapya sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Box No: 3",
                            category = "",
                            price = 500,
                            details = "2 adet mozarella stick, 2 adet jalapeno poppers, 2 adet mısırlı tavuk topları, patates ve köz kapya sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Box No: 4",
                            category = "",
                            price = 520,
                            details = "2 adet körili samosa, 2 adet kinoalı mücver, 2 adet zeytin kroket, patates ve sweet chili sos",
                            image = "https://static.wixstatic.com/shapes/ec845c_2306a227a54044a9999b9f5e5fdf2185.svg",
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Yemekler - Atıştırmalıklar",
                    no = 8,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Sigara Böreği",
                            category = "",
                            price = 280,
                            details = "8 adet sigara böreği ve sweet carrot sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Veggy Sticks",
                            category = "",
                            price = 280,
                            details = "8 adet veggy sticks ve sweet carrot sos",
                            image = "https://static.wixstatic.com/shapes/ec845c_2306a227a54044a9999b9f5e5fdf2185.svg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Soğan Halkası",
                            category = "",
                            price = 290,
                            details = "10 adet soğan halkası ve chili mayonez sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Tnt Chicken",
                            category = "",
                            price = 320,
                            details = "170 gr tnt soslu tavuk parçaları",
                            image = "https://static.wixstatic.com/shapes/ec845c_4f5504ceb3f84cd18f72f779dcad9078.svg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Fish & Chips",
                            category = "",
                            price = 360,
                            details = "6 adet çıtır balık, patates vee chili mayonez sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Hellim Sticks",
                            category = "",
                            price = 360,
                            details = "6 adet hellim sticks ve köz kapya sosu",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Chicken Fingers",
                            category = "",
                            price = 370,
                            details = "5 adet chicken finger, patates ve ballı hardal sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Çıtır Kalamar",
                            category = "",
                            price = 410,
                            details = "8 adet paneli kalamar, patates ve chili mayonez sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Tnt Karides",
                            category = "",
                            price = 570,
                            details = "10 adet tnt soslu büyük boy karides ve patates",
                            image = "https://static.wixstatic.com/shapes/ec845c_4f5504ceb3f84cd18f72f779dcad9078.svg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Cheddar Soslu Patates",
                            category = "",
                            price = 250,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Kajun Baharatlı Patates",
                            category = "",
                            price = 200,
                            details = "",
                            image = "https://static.wixstatic.com/shapes/ec845c_2306a227a54044a9999b9f5e5fdf2185.svg",
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Yemekler - Salatalar",
                    no = 9,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Izgara Tavuk Salata",
                            category = "",
                            price = 450,
                            details = "180-200 gr. ızgara tavuk ile",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Çıtır Hellim Salata",
                            category = "",
                            price = 450,
                            details = "4 adet çıtır hellim ile",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Kinoalı Mücver Salata",
                            category = "",
                            price = 440,
                            details = "180 gr. mücver ile",
                            image = "https://static.wixstatic.com/shapes/ec845c_2306a227a54044a9999b9f5e5fdf2185.svg",
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Yemekler - Alternatifler",
                    no = 10,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Piliç Izgara",
                            category = "",
                            price = 480,
                            details = "180-200 gr. tavuk yanında kajun baharatlı patates ve mevsim yeşillikleri",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Vegan Schnitzel",
                            category = "",
                            price = 480,
                            details = "180 gr. veggy schnitzel yanında kajun baharatlı patates ve mevsim yeşillikleri",
                            image = "https://static.wixstatic.com/shapes/ec845c_2306a227a54044a9999b9f5e5fdf2185.svg",
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Yemekler - Dip Soslar ve Ekstralar",
                    no = 11,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Tnt Sos",
                            category = "",
                            price = 50,
                            details = "",
                            image = "https://static.wixstatic.com/shapes/ec845c_4f5504ceb3f84cd18f72f779dcad9078.svg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Köz Kapya Sos",
                            category = "",
                            price = 50,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Ballı Hardal Sos",
                            category = "",
                            price = 50,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Sweet Carrot Sos",
                            category = "",
                            price = 50,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Chili Mayonez Sos",
                            category = "",
                            price = 50,
                            details = "",
                            image = "https://static.wixstatic.com/shapes/ec845c_4f5504ceb3f84cd18f72f779dcad9078.svg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Dilim Cheddar",
                            category = "",
                            price = 50,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Coleslaw",
                            category = "",
                            price = 50,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Yemekler - Çerezler",
                    no = 12,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Tuzlu Fıstık",
                            category = "",
                            price = 110,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Turşu Tabağı",
                            category = "",
                            price = 120,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Patlamış Mısır",
                            category = "",
                            price = 110,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Kokteyller - Ayın Kokteylleri 🔥",
                    no = 13,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Grinch Spiritz",
                            category = "",
                            price = 430,
                            details = "Köpüklü şarap, kavun likörü, lime suyu ve soda",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Jack Frost",
                            category = "",
                            price = 480,
                            details = "Votka, hindistan cevizi likörü, ananas suyu ve blue curacao",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Gin-Gle Bell Fizz",
                            category = "",
                            price = 450,
                            details = "Gin, cranberry juice, köpüklü şarap",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Clausmopolitan",
                            category = "",
                            price = 480,
                            details = "Votka, portakal likörü, cranberry juice, lime suyu ve grenadine",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Kokteyller - Powepuff Cocktails",
                    no = 14,
                    details = "Yeni İmza Kokteyllerimiz",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Blossom",
                            category = "",
                            price = 420,
                            details = "Gin, Portakal Likörü, Limon Suyu, Sweet&Sour, Orman Meyveleri Püresi",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Buttercup",
                            category = "",
                            price = 420,
                            details = "Tekila, Kavun Likörü, Nane Likörü",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Bubbles",
                            category = "",
                            price = 420,
                            details = "Votka, Şeftali Likörü, Elma Suyu, Lime Suyu, Blue Curacao",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Kokteyller - İmza Kokteyller",
                    no = 15,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Superior",
                            category = "",
                            price = 530,
                            details = "Cin, Kuzukulağı, Mürver Çiçeği Likörü, Sweet & Sour, Soda",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Royal Martini",
                            category = "",
                            price = 510,
                            details = "Cin, Yaban Mersinli Vodka, Parfair Amor, Limon Suyu",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Purple Sky Gin Tonic",
                            category = "",
                            price = 510,
                            details = "Cin, Lime, Purple Sky Tea, Tonik",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Cucumber Cooler",
                            category = "",
                            price = 510,
                            details = "Cin, Salatalık Suyu, Limon Suyu, Portakal Suyu, Simple Syrup, Soda",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Aromatic Fire",
                            category = "",
                            price = 500,
                            details = "Tütsülenmiş Viski, Orman Meyveleri Püresi, Sweet & Sour",
                            image = "https://static.wixstatic.com/shapes/ec845c_4f5504ceb3f84cd18f72f779dcad9078.svg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Surfer on Acid",
                            category = "",
                            price = 490,
                            details = "Jagermeister, Malibu, Ananas Suyu",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Blue Mountain",
                            category = "",
                            price = 490,
                            details = "Tekila, Blue Curaçao, Limon Suyu, Ananas Suyu",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Salted Caramel Dream",
                            category = "",
                            price = 480,
                            details = "Kahve Tütsülü Vodka, Baileys, Süt, Tuzlu Karamel",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Jack Blackberry&Lemonade",
                            category = "",
                            price = 470,
                            details = "Jack Daniels Blackberry, Ananas Püresi, S&S, Limon Suyu,Soda",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Bab's Kokteyl",
                            category = "",
                            price = 530,
                            details = "Menü dışı istekleriniz, Kişiye özel tarifler",
                            image = "https://static.wixstatic.com/shapes/ced9d3_47d0c41a1d16489dbd15409add2b1378.svg",
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Kokteyller - Klasikler",
                    no = 16,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Long Island Ice Tea",
                            category = "",
                            price = 550,
                            details = "Vodka, Gin, Tekila, Rom, Triple Sec, Sweet & Sour, Kola",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Mojito",
                            category = "",
                            price = 530,
                            details = "Rom, Esmer Şeker, Lime, Soda, Taze Nane",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Pina Colada",
                            category = "",
                            price = 510,
                            details = "Rom, Portakal Likörü, Hindistan Cevizi Likörü, Süt, Ananas Suyu, Ananas Püresi",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Gin Fizz",
                            category = "",
                            price = 510,
                            details = "Gin, Soda, Pudra Şekeri",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Espresso Martini",
                            category = "",
                            price = 510,
                            details = "Vodka, Kahlua, Espresso",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Whiskey Sour",
                            category = "",
                            price = 510,
                            details = "Bourbon Viski, Angustra Bitter, Sweet & Sour",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Tequila Sunrise",
                            category = "",
                            price = 500,
                            details = "Tekila, Portakal Suyu, Nar Şurubu",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Lynchburg Lemonade",
                            category = "",
                            price = 490,
                            details = "Viski, Triple Sec, Sweet & Sour, Sprite",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Cuba Libre",
                            category = "",
                            price = 490,
                            details = "Rom, Coca-Cola, Lime Suyu",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Negroni",
                            category = "",
                            price = 490,
                            details = "Gin, Campari, Sweet Vermouth",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Margarita",
                            category = "",
                            price = 490,
                            details = "Tekila, Triple Sec, Lime",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Cosmopolitan",
                            category = "",
                            price = 460,
                            details = "Vodka, Triple Sec, Lime, Kızılcık Suyu",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Black Russian",
                            category = "",
                            price = 450,
                            details = "Vodka, Kahlua",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "White Russian",
                            category = "",
                            price = 450,
                            details = "Vodka, Kahlua, Süt Kreması",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Sex on the Beach (Kampanya)",
                            category = "",
                            price = 350,
                            details = "Votka, Şeftali likörü, Cranberry Juice ve Portakal Suyu",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Kokteyller",
                    no = 17,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Chilli Passion Martini",
                            category = "",
                            price = 510,
                            details = "Rom, Passion Fruit, Üzüm Suyu, Portakal Suyu, Taze Zencefil, Şili Biberi",
                            image = "https://static.wixstatic.com/shapes/ec845c_4f5504ceb3f84cd18f72f779dcad9078.svg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Pornstar Martini",
                            category = "",
                            price = 510,
                            details = "Vanilya Aromalı Vodka, Triple Sec, Lime, Passion Fruit",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Better Call Passion",
                            category = "",
                            price = 500,
                            details = "Vodka, Cardinal Melon, Limon Suyu, Passion Fruit, Karadutlu Soda",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Melon Paradise",
                            category = "",
                            price = 480,
                            details = "Cin, Karamelize Limon Şurubu, Cardinal Melon, Soda",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Silver Sunset",
                            category = "",
                            price = 480,
                            details = "Vodka, Aperol, Triple Sec, Portakal Suyu, Limon Suyu",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Gin Bull",
                            category = "",
                            price = 480,
                            details = "Red Bull Yellow Edition, Limon Suyu, Taze Nane, Lime, Cin",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Jack Apple Fizz",
                            category = "",
                            price = 470,
                            details = "Jack Apple, Lime, Soda",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Limoncello Spritz (Kampanya)",
                            category = "",
                            price = 350,
                            details = "Limoncello, Köpüklü Şarap, Soda",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Aperol Spritz (Kampanya)",
                            category = "",
                            price = 350,
                            details = "Aperol, Köpüklü Şarap, Soda",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Lemon Drop Martini (Kampanya)",
                            category = "",
                            price = 350,
                            details = "Votka, Portakal Likörü ve Limon Suyu",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Ağır Alkoller - Gin",
                    no = 18,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Hendrick's (Shot)",
                            category = "",
                            price = 370,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Hendrick's (6 cl)",
                            category = "",
                            price = 600,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Bombay Sapphire (Shot)",
                            category = "",
                            price = 280,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Bombay Sapphire (6 cl)",
                            category = "",
                            price = 430,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Beefeater (Shot)",
                            category = "",
                            price = 280,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Beefeater (6 cl)",
                            category = "",
                            price = 430,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Gordon's (Shot)",
                            category = "",
                            price = 240,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Gordon's (6 cl)",
                            category = "",
                            price = 380,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Ağır Alkoller - Vodka",
                    no = 19,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Absolut Blue (Shot)",
                            category = "",
                            price = 270,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Absolut Blue (6 cl)",
                            category = "",
                            price = 420,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Smirnoff Red Label (Shot)",
                            category = "",
                            price = 240,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Smirnoff Red Label (6 cl)",
                            category = "",
                            price = 380,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Absolut Blue Enerji",
                            category = "",
                            price = 470,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Smirnoff Red Label Enerji",
                            category = "",
                            price = 430,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Ağır Alkoller - Viski",
                    no = 20,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Macallan 12y (5 cl)",
                            category = "",
                            price = 1220,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Macallan 12y (8 cl)",
                            category = "",
                            price = 1630,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Woodford Reserve (5 cl)",
                            category = "",
                            price = 1220,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Woodford Reserve (8 cl)",
                            category = "",
                            price = 1630,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Glenfiddich 12y (Shot)",
                            category = "",
                            price = 320,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Glenfiddich 12y (5 cl)",
                            category = "",
                            price = 860,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Glenfiddich 12y (8 cl)",
                            category = "",
                            price = 1180,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Benriach (5 cl)",
                            category = "",
                            price = 860,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Benriach (8 cl)",
                            category = "",
                            price = 1180,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Talisker 10y (Shot)",
                            category = "",
                            price = 320,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Talisker 10y (5 cl)",
                            category = "",
                            price = 860,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Talisker 10y (8 cl)",
                            category = "",
                            price = 1180,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Johnnie Walker Double Black (5 cl)",
                            category = "",
                            price = 800,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Johnnie Walker Double Black (8 cl)",
                            category = "",
                            price = 1100,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Johnnie Walker Black Ruby (Shot)",
                            category = "",
                            price = 280,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Johnnie Walker Black Ruby (5 cl)",
                            category = "",
                            price = 480,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Johnnie Walker Black Ruby (8 cl)",
                            category = "",
                            price = 690,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Johnnie Walker Black Label (Shot)",
                            category = "",
                            price = 270,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Johnnie Walker Black Label (5 cl)",
                            category = "",
                            price = 470,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Johnnie Walker Black Label (8 cl)",
                            category = "",
                            price = 680,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Johnnie Walker Red Label (Shot)",
                            category = "",
                            price = 260,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Johnnie Walker Red Label (5 cl)",
                            category = "",
                            price = 430,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Johnnie Walker Red Label (8 cl)",
                            category = "",
                            price = 620,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Chivas Regal 12y (Shot)",
                            category = "",
                            price = 270,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Chivas Regal 12y (5 cl)",
                            category = "",
                            price = 480,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Chivas Regal 12y (8 cl)",
                            category = "",
                            price = 690,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Jack Daniel's (5 cl)",
                            category = "",
                            price = 410,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Jack Daniel's (8 cl)",
                            category = "",
                            price = 590,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Jameson (Shot)",
                            category = "",
                            price = 240,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Jameson (5 cl)",
                            category = "",
                            price = 410,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Jameson (8 cl)",
                            category = "",
                            price = 590,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Jim Beam (Shot)",
                            category = "",
                            price = 240,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Jim Beam (5 cl)",
                            category = "",
                            price = 410,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Jim Beam (8 cl)",
                            category = "",
                            price = 590,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "J&B (Shot)",
                            category = "",
                            price = 240,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "J&B (5 cl)",
                            category = "",
                            price = 410,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "J&B (8 cl)",
                            category = "",
                            price = 590,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Ağır Alkoller - Rom",
                    no = 21,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Havana Club (Shot)",
                            category = "",
                            price = 270,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Havana Club (6 cl)",
                            category = "",
                            price = 500,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Bacardi (Shot)",
                            category = "",
                            price = 270,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Bacardi (6 cl)",
                            category = "",
                            price = 500,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Captain Morgan (Shot)",
                            category = "",
                            price = 240,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Captain Morgan (6 cl)",
                            category = "",
                            price = 430,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Şaraplar - Kırmızı Şaraplar",
                    no = 22,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Casalforte, Şişe",
                            category = "",
                            price = 1800,
                            details = "75cl, Merlot. Veneto, İtalya",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Sobran \"Alaşehir Philedelphia\", Şişe",
                            category = "",
                            price = 1300,
                            details = "75cl, Öküzgözü, Boğazkere, Merlot.",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Kavaklıdere Angora, Şişe",
                            category = "",
                            price = 1100,
                            details = "75cl, Cabarnet Sauvignon, Alicante, Merlot",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Doluca, Şişe",
                            category = "",
                            price = 1000,
                            details = "75cl, Boğazkere, Kalecik Karası, Shiraz",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Kırmızı Kadeh",
                            category = "",
                            price = 250,
                            details = "15cl, Kavaklıdere Angora (Kadeh)",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Şaraplar - Beyaz Şaraplar",
                    no = 23,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Manieri Pinot Grigio Delle Venezie, Şişe",
                            category = "",
                            price = 1600,
                            details = "75cl, Pinot Grigio. Le Tre Venezie, İtalya",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Sobran \"Alaşehir Philedelphia\", Şişe",
                            category = "",
                            price = 1300,
                            details = "75cl, Sultaniye",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Kavaklıdere Angora, Şişe",
                            category = "",
                            price = 1100,
                            details = "75cl, Sultaniye",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Doluca,Beyaz Şişe",
                            category = "",
                            price = 800,
                            details = "75cl, Sultaniye, Emir",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Beyaz Kadeh",
                            category = "",
                            price = 250,
                            details = "15cl, Kavaklıdere Angora (Kadeh)",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Şaraplar - Rose Şaraplar",
                    no = 24,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Manieri Pinot Grigio Blush, Şişe",
                            category = "",
                            price = 1600,
                            details = "75cl, Pinot Grigio. Provincia di Pavia, İtalya.",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Kavaklıdere Angora, Şişe",
                            category = "",
                            price = 1100,
                            details = "75cl, Çal Karası, Öküzgözü",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Doluca,Rose Şişe",
                            category = "",
                            price = 800,
                            details = "75cl, Çal Karası, Grenache",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Rose Kadeh",
                            category = "",
                            price = 250,
                            details = "15cl, Kavaklıdere Angora (Kadeh)",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Şaraplar - Diğer Şaraplar",
                    no = 25,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Sangria",
                            category = "",
                            price = 300,
                            details = "Taze Mevsim Meyveleri, Meyve Suyu, Vodka, Kırmızı Şarap",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Biralar - Fıçı Biralar",
                    no = 26,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Bud (30 cl)",
                            category = "",
                            price = 170,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Bud (50 cl)",
                            category = "",
                            price = 190,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Beck's (30 cl)",
                            category = "",
                            price = 170,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Beck's (50 cl)",
                            category = "",
                            price = 190,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Efes Pilsen (30 cl)",
                            category = "",
                            price = 150,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Efes Pilsen (50 cl)",
                            category = "",
                            price = 170,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Meksika Bardak",
                            category = "",
                            price = 30,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Biralar - Kraft Biralar",
                    no = 27,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "à santé - Double IPA",
                            category = "",
                            price = 250,
                            details = "Tropik ve çam aromalı %8 alkol oranıyla öne çıkan kraft bira",
                            image = "https://static.wixstatic.com/media/ced9d3_065d83b7acfb496da6a4db3e00cc1f01~mv2.avif/v1/fill/w_147,h_214,al_c,q_80,usm_0.66_1.00_0.01,blur_2,enc_auto/ced9d3_065d83b7acfb496da6a4db3e00cc1f01~mv2.avif",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "à santé - Belgian Strong",
                            category = "",
                            price = 250,
                            details = "Muz, karanfil ve karabiber aromalı %8 alkol oranıyla Ale tipi kraft bira",
                            image = "https://static.wixstatic.com/media/ced9d3_0034aa4c9aa545c2b069d9625110eebb~mv2.avif/v1/fill/w_147,h_221,al_c,q_80,usm_0.66_1.00_0.01,blur_2,enc_auto/ced9d3_0034aa4c9aa545c2b069d9625110eebb~mv2.avif",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "à santé - West Coast IPA",
                            category = "",
                            price = 250,
                            details = "Floral, greyfurt ve çam aromalı %6 alkol oranıyla IPA tipi kraft bira",
                            image = "https://static.wixstatic.com/media/ced9d3_7d4c6e2e5e924778be14a04ad6586e29~mv2.avif/v1/fill/w_147,h_221,al_c,q_80,usm_0.66_1.00_0.01,blur_2,enc_auto/ced9d3_7d4c6e2e5e924778be14a04ad6586e29~mv2.avif",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "à santé - Vienna Lager",
                            category = "",
                            price = 250,
                            details = "Kızarmış ekmek ve malt aromalı %5 alkol oranıyla Lager tipi kraft bira",
                            image = "https://static.wixstatic.com/media/ced9d3_88294e8db0c048c5ab3e07b1c57692dd~mv2.avif/v1/fill/w_147,h_221,al_c,q_80,usm_0.66_1.00_0.01,blur_2,enc_auto/ced9d3_88294e8db0c048c5ab3e07b1c57692dd~mv2.avif",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "à santé - New Zealand Pilsner",
                            category = "",
                            price = 250,
                            details = "Floral ve tropik meyve aromalı %5 alkol oranıyla Pilsner tipi kraft bira",
                            image = "https://static.wixstatic.com/media/ced9d3_046ed3fb8d98403b95878db13010f7e0~mv2.avif/v1/fill/w_147,h_221,al_c,q_80,usm_0.66_1.00_0.01,blur_2,enc_auto/ced9d3_046ed3fb8d98403b95878db13010f7e0~mv2.avif",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "à santé - Saison",
                            category = "",
                            price = 250,
                            details = "Muz ve turunçgil aromalı %5 alkol oranıyla çiftlik birası olarak da bilinen kraft bira",
                            image = "https://static.wixstatic.com/media/ced9d3_e91707c98d7d4adcaed0d3028f929a3f~mv2.avif/v1/fill/w_147,h_221,al_c,q_80,usm_0.66_1.00_0.01,blur_2,enc_auto/ced9d3_e91707c98d7d4adcaed0d3028f929a3f~mv2.avif",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "à santé - Summer Lager",
                            category = "",
                            price = 250,
                            details = "Mevsimsel aromaları ve %4.2 alkol oranıyla öne çıkan kraft bira",
                            image = "https://static.wixstatic.com/media/ced9d3_6f16abc6830c4ce5aa6a3ae1642e6a44~mv2.avif/v1/fill/w_147,h_195,al_c,q_80,usm_0.66_1.00_0.01,blur_2,enc_auto/ced9d3_6f16abc6830c4ce5aa6a3ae1642e6a44~mv2.avif",
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Biralar - Şişe Biralar",
                    no = 28,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Stella Artois",
                            category = "",
                            price = 290,
                            details = "44 cl",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Guinness",
                            category = "",
                            price = 310,
                            details = "44 cl",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Amsterdam",
                            category = "",
                            price = 330,
                            details = "50 cl",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Belfast",
                            category = "",
                            price = 250,
                            details = "50 cl",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Bud",
                            category = "",
                            price = 250,
                            details = "50 cl",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Beck's",
                            category = "",
                            price = 250,
                            details = "50 cl",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Bomonti Filtresiz",
                            category = "",
                            price = 250,
                            details = "50 cl",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Efes Pilsen",
                            category = "",
                            price = 220,
                            details = "50 cl",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Efes Malt",
                            category = "",
                            price = 220,
                            details = "50 cl",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Efes Özel Seri",
                            category = "",
                            price = 240,
                            details = "50 cl",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Efes Glutensiz",
                            category = "",
                            price = 240,
                            details = "50 cl",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Erdinger",
                            category = "",
                            price = 300,
                            details = "33 cl",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Corona",
                            category = "",
                            price = 250,
                            details = "33.5 cl",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Miller",
                            category = "",
                            price = 240,
                            details = "33 cl",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Biralar - Alkolsüz Biralar",
                    no = 29,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Clausthaler Koyu Renkli Alkolsüz Bira",
                            category = "",
                            price = 200,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Clausthaler Açık Renkli Alkolsüz Bira",
                            category = "",
                            price = 200,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Clausthaler Limon Aromalı Alkolsüz Bira",
                            category = "",
                            price = 210,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Clausthaler Greyfurt Aromalı Alkolsüz Bira",
                            category = "",
                            price = 210,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Biralar - Çerezler",
                    no = 30,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Turşu Tabağı",
                            category = "",
                            price = 120,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Tuzlu Fıstık",
                            category = "",
                            price = 110,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Patlamış Mısır",
                            category = "",
                            price = 110,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Shotlar ve Likörler - Ninja 🐢 Shakers",
                    no = 31,
                    details = "2-4 kişilik, dostlarınla ninja kaplumbağalara dönüşeceğin 26cl'lik dev shakerlar.",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Donatello",
                            category = "",
                            price = 650,
                            details = "Jagermeister, Vişne Suyu, Meyve Püresi, Blue Curaçao",
                            image = "https://static.wixstatic.com/media/ced9d3_b2a0b16981d54dae9ea927ec3dbe78c3~mv2.png/v1/fill/w_49,h_49,al_c,q_85,usm_0.66_1.00_0.01,blur_2,enc_auto/ced9d3_b2a0b16981d54dae9ea927ec3dbe78c3~mv2.png",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Michelangelo",
                            category = "",
                            price = 650,
                            details = "Tekila, Portakal Suyu, Meyve Püresi, Grenadine",
                            image = "https://static.wixstatic.com/media/ced9d3_890e8ce508684d2ab0b82f3b37eec6bb~mv2.png/v1/fill/w_49,h_49,al_c,q_85,usm_0.66_1.00_0.01,blur_2,enc_auto/ced9d3_890e8ce508684d2ab0b82f3b37eec6bb~mv2.png",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Leonardo",
                            category = "",
                            price = 650,
                            details = "Cin, Ananas Suyu, Meyve Püresi, Blue Curaçao",
                            image = "https://static.wixstatic.com/media/ced9d3_18996760d84b4e709a89decd6b3bf64f~mv2.png/v1/fill/w_49,h_49,al_c,q_85,usm_0.66_1.00_0.01,blur_2,enc_auto/ced9d3_18996760d84b4e709a89decd6b3bf64f~mv2.png",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Raphael",
                            category = "",
                            price = 650,
                            details = "Vodka, Ananas Suyu, Meyve Püresi, Grenadine",
                            image = "https://static.wixstatic.com/media/ced9d3_96abae8f58a4481cb450593b32971f8f~mv2.png/v1/fill/w_49,h_49,al_c,q_85,usm_0.66_1.00_0.01,blur_2,enc_auto/ced9d3_96abae8f58a4481cb450593b32971f8f~mv2.png",
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Shotlar ve Likörler - Shotlar",
                    no = 32,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Jack Daniel's (Tek)",
                            category = "",
                            price = 200,
                            details = "No:7, Apple, Honey, Fire seçenekleri ile",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Jack Daniel's (5'li)",
                            category = "",
                            price = 800,
                            details = "No:7, Apple, Honey, Fire seçenekleri ile",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Jack Daniel's (10'lu)",
                            category = "",
                            price = 1600,
                            details = "No:7, Apple, Honey, Fire seçenekleri ile",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Jägermeister (Tek)",
                            category = "",
                            price = 200,
                            details = "Jägermeister Classic, Orange ve Cold Brew seçenekleri ile",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Jägermeister (5'li)",
                            category = "",
                            price = 800,
                            details = "Jägermeister Classic, Orange ve Cold Brew seçenekleri ile",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Jägermeister (10'lu)",
                            category = "",
                            price = 1600,
                            details = "Jägermeister Classic, Orange ve Cold Brew seçenekleri ile",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Jägermeister Cold Brew",
                            category = "",
                            price = 200,
                            details = "Tek",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Jägermeister Orange",
                            category = "",
                            price = 200,
                            details = "Tek",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Olmeca Silver (Tek)",
                            category = "",
                            price = 200,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Olmeca Silver (5'li)",
                            category = "",
                            price = 800,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Olmeca Silver (10'lu)",
                            category = "",
                            price = 1600,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "7'li Rainbow Likör Shot",
                            category = "",
                            price = 450,
                            details = "Yeşil Elma, Karpuz-Çilek, Lime-Limon, Kırmızı Orman Meyveleri, Tropik Meyveler, Vişne ve Çilek-Agave Aromalı Likör Shotlar.",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "The Jack Daniel's (6'lı)",
                            category = "",
                            price = 900,
                            details = "Jack Daniel's Apple, Honey ve Fire'den ikişer shot. Tüm lezzetler, ikişer doz!",
                            image = "https://static.wixstatic.com/media/ced9d3_f501c3a685d84ecca78e59d0367b607f~mv2.jpg/v1/fill/w_147,h_196,al_c,q_80,usm_0.66_1.00_0.01,blur_2,enc_auto/ced9d3_f501c3a685d84ecca78e59d0367b607f~mv2.jpg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "The Jäger Double Trio (6'lı)",
                            category = "",
                            price = 900,
                            details = "Jägermeister Classic, Orange ve Cold Brew'den ikişer shot. Tüm lezzetler, ikişer doz!",
                            image = "https://static.wixstatic.com/media/ced9d3_5493074646384d12b0b3d78ad75f1656~mv2.jpg/v1/fill/w_147,h_96,al_c,q_80,usm_0.66_1.00_0.01,blur_2,enc_auto/ced9d3_5493074646384d12b0b3d78ad75f1656~mv2.jpg",
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Shotlar ve Likörler - Likörler",
                    no = 33,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Jägermeister (Shot)",
                            category = "",
                            price = 200,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Jägermeister (6 cl)",
                            category = "",
                            price = 400,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Southern Comfort (Shot)",
                            category = "",
                            price = 200,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Southern Comfort (6 cl)",
                            category = "",
                            price = 400,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Cardinal Melon (Shot)",
                            category = "",
                            price = 190,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Cardinal Melon (6 cl)",
                            category = "",
                            price = 380,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Baileys (Shot)",
                            category = "",
                            price = 190,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Baileys (6 cl)",
                            category = "",
                            price = 380,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Safari (Shot)",
                            category = "",
                            price = 190,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Safari (6 cl)",
                            category = "",
                            price = 380,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Malibu (Shot)",
                            category = "",
                            price = 190,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Malibu (6 cl)",
                            category = "",
                            price = 380,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Kahlua (Shot)",
                            category = "",
                            price = 190,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Kahlua (6 cl)",
                            category = "",
                            price = 380,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Shotlar ve Likörler - Diğer Alkoller",
                    no = 34,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Amaretto (Shot)",
                            category = "",
                            price = 190,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Amaretto (6 cl)",
                            category = "",
                            price = 380,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Aperol (Shot)",
                            category = "",
                            price = 190,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Aperol (6 cl)",
                            category = "",
                            price = 380,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Martini (Shot)",
                            category = "",
                            price = 190,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Martini (6 cl)",
                            category = "",
                            price = 380,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Triple Sec. (Shot)",
                            category = "",
                            price = 190,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Triple Sec. (6 cl)",
                            category = "",
                            price = 380,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Kahveler ve Sıcak İçecekler - Kahveler",
                    no = 35,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Espresso (Tek)",
                            category = "",
                            price = 150,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Espresso (Çift)",
                            category = "",
                            price = 170,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Americano (Sıcak)",
                            category = "",
                            price = 170,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Americano (Soğuk)",
                            category = "",
                            price = 190,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Latte (Sıcak)",
                            category = "",
                            price = 200,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Latte (Soğuk)",
                            category = "",
                            price = 220,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Salted Caramel Latte (Sıcak)",
                            category = "",
                            price = 220,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Salted Caramel Latte (Soğuk)",
                            category = "",
                            price = 240,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Cappucino",
                            category = "",
                            price = 200,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Mocha (Sıcak)",
                            category = "",
                            price = 220,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Mocha (Soğuk)",
                            category = "",
                            price = 240,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Kahveler ve Sıcak İçecekler - Alkollü Kahveler",
                    no = 36,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Coffee Kahlua (Sıcak)",
                            category = "",
                            price = 330,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Coffee Kahlua (Soğuk)",
                            category = "",
                            price = 350,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Coffee Baileys (Sıcak)",
                            category = "",
                            price = 330,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Coffee Baileys (Soğuk)",
                            category = "",
                            price = 350,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Coffee Amaretto (Sıcak)",
                            category = "",
                            price = 330,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Coffee Amaretto (Soğuk)",
                            category = "",
                            price = 350,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Coffee Irish (Sıcak)",
                            category = "",
                            price = 360,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Coffee Irish (Soğuk)",
                            category = "",
                            price = 380,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Kahveler ve Sıcak İçecekler - Sıcak İçecekler",
                    no = 37,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Sıcak Çikolata",
                            category = "",
                            price = 250,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Salep",
                            category = "",
                            price = 250,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Kahveler ve Sıcak İçecekler - Çaylar",
                    no = 38,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Çay",
                            category = "",
                            price = 80,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Ihlamur",
                            category = "",
                            price = 200,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Kış Çayı",
                            category = "",
                            price = 200,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Ada Çayı",
                            category = "",
                            price = 200,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Yeşil Çay",
                            category = "",
                            price = 200,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Soft İçecekler",
                    no = 39,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Alkolsüz Mojito",
                            category = "",
                            price = 250,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Alkolsüz Kokteyl",
                            category = "",
                            price = 300,
                            details = "Kuzukulağı, Elma Suyu, Sweet & Sour, Soda, Alkolsüz Superior",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Alkolsüz Kokteyl",
                            category = "",
                            price = 250,
                            details = "Taze Mevsim Meyveleri, Meyve Suyu, Kırmızı Orman Meyve Püresi, Alkolsüz Sangria",
                            image = "https://static.wixstatic.com/shapes/ced9d3_47d0c41a1d16489dbd15409add2b1378.svg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Cool Lime",
                            category = "",
                            price = 200,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Churchill",
                            category = "",
                            price = 150,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Coca Cola & Zero",
                            category = "",
                            price = 130,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Sprite",
                            category = "",
                            price = 130,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Fuse Tea Şeftali",
                            category = "",
                            price = 130,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Fuse Tea Limon",
                            category = "",
                            price = 130,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Red Bull Enerji İçeceği",
                            category = "",
                            price = 180,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Red Bull Sugarfree",
                            category = "",
                            price = 180,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Red Bull Yellow Edition",
                            category = "",
                            price = 180,
                            details = "Sudachi Lime Aromalı",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Red Bull Pink Edition Sugarfree",
                            category = "",
                            price = 180,
                            details = "Ahududu Aromalı",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Soda",
                            category = "",
                            price = 100,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Su",
                            category = "",
                            price = 50,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
            )
            "dynamite-kitchen" -> listOf(
                MenuCategory(
                    name = "ÇORBA",
                    no = 0,
                    details = "",
                    image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-O_qgdTpqJwdPw5m-2tk.jpg?alt=media&token=3cf9f867-c1b9-42eb-b848-101c3bd13a4b",
                    products = listOf(
                        MenuItem(
                            name = "Mercimek Çorbası",
                            category = "",
                            price = 120,
                            details = "",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-O_qgpOgF8CX80WIFgW9.jpg?alt=media&token=7cac82a3-febc-4a35-bf29-4ec913ec4668",
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "AVANTAJLI  MENÜ",
                    no = 1,
                    details = "",
                    image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqmZjWfYWjcTKxlkgH7.jpg?alt=media&token=2bb217bb-7ddb-458d-b9c5-54af20a9b7da",
                    products = listOf(
                        MenuItem(
                            name = "Dynamite Dürüm Menü",
                            category = "",
                            price = 420,
                            details = "Kızarmış Tortilla ekmeğine,Özel sos ile marine edilmiş 175 gr tavuk bonfile parçaları,domates,biber,chedar peyniri,patates kızartması ve seçeceğiniz içecek ile",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqm_9TT4TcbAdwkeWVX.jpg?alt=media&token=04d0780f-5b0c-4a70-9de5-82d614b923ad",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Köfte Dürüm Menü",
                            category = "",
                            price = 465,
                            details = "Kızarmış tortilla ekmeğine,domates,biber,yeşillik,isteğe bağlı soğan,patates kızartması ve seçeceğiniz içecek ile",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqm_PT9HXyLa5fH0HRs.jpg?alt=media&token=06d7d593-a226-471e-ac06-92cd14e9b981",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Çıtır Dürüm Menü",
                            category = "",
                            price = 430,
                            details = "El yapımı şinitzel,ketçap,hardallı ve mayonezli sos,domates,göbek,turşu,patates kızartması ve seçeceğiniz içecek ile",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqm_KAVLE9YcfsOJCHq.jpg?alt=media&token=19e98041-905b-4688-b7a0-dda01617ae70",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Falafel Dürüm Menü",
                            category = "",
                            price = 395,
                            details = "Kızarmış tortilla ekmeğine,falafel,göbek,domates,kapya biber,kekik,patates kızartması ve seçeceğiniz içecek ile",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqm_VTDs_Qaq-A7EOlo.jpg?alt=media&token=ce644225-2472-4b00-9ec8-2702828c36b9",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Dynamite Tavuk Porsiyon Menü",
                            category = "",
                            price = 460,
                            details = "Özel sos ile marine edilmiş 200 gr ızgara tavuk bonfile parçaları,Patates kızartması,pirinç veya meyhane pilavı,mevsim salatası,amerikan salatası ve seçeceğiniz içecek ile",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqm_bMORZ4unZOD9G9A.jpg?alt=media&token=93468889-a9d2-4bce-b8e6-7db841bc114f",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Chedarlı Dynamite Tavuk Porsiyon Menü",
                            category = "",
                            price = 480,
                            details = "Özel sos ile marine edilmiş 200 gr ızgara tavuk bonfile parçaları üzerine chedar peyniri,Patates kızartması,pirinç veya meyhane pilavı,mevsim salatası,amerikan salatası ve seçeceğiniz içecek ile",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqm_esu_6b_Ma4B8DVi.jpg?alt=media&token=cae0c671-98d8-4c7b-8a62-988eebc30bf2",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Izgara Köfte Porsiyon Menü",
                            category = "",
                            price = 510,
                            details = "200gr 6 adet ızgara köfte,Patates kızartması,pirinç veya meyhane pilavı,mevsim salatası,amerikan salatası,köz biber ve domates,acuka sos,maydanozlu ve sumaklı soğan ve seçeceğiniz içecek ile",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqma-dMuqwVAsBr7Z7O.jpg?alt=media&token=76debf1f-f458-4366-b3a6-bed6ef97de2d",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Tavuk Şinitzel Menü",
                            category = "",
                            price = 480,
                            details = "200gr El yapımı şinitzel, Patates kızartması,pirinç pilavı,mevsim,salatası,amerikan salatası,tatlı acı sos ve seçeceğiniz içecek ile",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqma4jwr7NN-3WkzTVb.jpg?alt=media&token=baa00405-da79-4244-8bdd-901007d24aa4",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Izgara Tavuk Göğüs Menü",
                            category = "",
                            price = 470,
                            details = "200gr soslu tavuk bonfile,patates kızartması,pirinç veya meyhane pilavı,mevsim salatası,amerikan salatası ve seçeceğiniz içecek ile",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqma7WzvhWLYGiIeL37.jpg?alt=media&token=051b0a97-2bb7-4158-ad7d-3a1023fc5f40",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Çıtır Tavuk Parçaları Menü",
                            category = "",
                            price = 410,
                            details = "200gr 7-8 parça çıtır tavuk parçaları,patates kızartması sweat chili sos ve seçeceğiniz içecek ile",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqmiYnHAOIgP_pFOrFA.jpg?alt=media&token=dbc519d3-61fc-4e72-af31-c1041e5b822f",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Susamlı Çıtır Tavuk Parçaları Menü",
                            category = "",
                            price = 420,
                            details = "200gr 7-8 parça susamlı çıtır tavuk parçaları,patates kızartması sweat chili sos ve seçeceğiniz içecek ile",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqmiVTVdFRjGHmt4XK5.jpg?alt=media&token=a7139341-6a18-4139-824c-425202be0f75",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Tatlı Acı Soslu Çıtır Tavuk Menü",
                            category = "",
                            price = 420,
                            details = "(200gr 7-8 adet tatlı acı soslu çıtır tavuk parçaları,patates kızartması ve seçeceğiniz İçecek ile",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqnpZKr531T6NmEX6s-.jpg?alt=media&token=8d38010a-05d5-401e-bd70-242de45ab506",
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "DÜRÜM+PATATES KIZARTMASI",
                    no = 2,
                    details = "",
                    image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NtC4_VRi1eQdgnPoD-k.jpg?alt=media&token=6527151b-c156-4e1f-840f-785c7af82fca",
                    products = listOf(
                        MenuItem(
                            name = "Dynamite Dürüm+Patates Kızartması",
                            category = "",
                            price = 360,
                            details = "Kızarmış Tortilla ekmeğine,Özel sos ile marine edilmiş 175 gr tavuk bonfile parçaları,domates,biber,chedar peyniri,patates kızartması",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NtC50dkwKWS3E8AIGy_.jpg?alt=media&token=e6f4e1aa-6725-4016-b266-94e65927bfad",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Çıtır Dürüm+Patates Kızartması",
                            category = "",
                            price = 370,
                            details = "El yapımı şinitzel,ketçap,peri peri sos,domates,göbek,turşu,patates kızartması",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NtC56dGNjJUK7unUQd5.jpg?alt=media&token=beda6f62-2752-479b-9a80-7b903f28a849",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Köfte Dürüm+Patates Kızartması",
                            category = "",
                            price = 395,
                            details = "Kızarmış tortilla ekmeğine,peri peri sos, domates,biber,yeşillik,isteğe bağlı soğan,patates kızartması",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NtC5Abo-CF-nZEu-9wG.jpg?alt=media&token=45d206d4-9b6e-4703-93f8-eac1be781c70",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Falafel Dürüm+Patates Kızartması",
                            category = "",
                            price = 355,
                            details = "Kızarmış tortilla ekmeğine peri peri sos, falafel, göbek, domates, kapya biber, kekik, patates kızartması",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NtC5Q-T-2aQpF-Dd3WU.jpg?alt=media&token=8e3a7f35-835b-4789-a68d-19d8475e21bb",
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "ÇITIR LEZZET",
                    no = 3,
                    details = "",
                    image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqmTXOAnkEmgdINXCUZ.jpg?alt=media&token=1d149354-0098-4960-9ce7-804f3798042a",
                    products = listOf(
                        MenuItem(
                            name = "Çıtır Tavuk Parçaları",
                            category = "",
                            price = 350,
                            details = "200gr 7-8 parça çıtır tavuk parçaları,patates kızartması ve sweat chili sos ile",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiEu99eCFHBoGtc1eb.jpg?alt=media&token=6dccfa09-a83f-4e16-a00f-17dc11d1697f",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Susamlı Çıtır Tavuk",
                            category = "",
                            price = 360,
                            details = "200gr 7-8 parça susamlı çıtır tavuk parçaları,patates kızartması ve sweat chili sos ile",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiF3Iq3_qNnK2NfYJz.jpg?alt=media&token=a6792649-2277-47b6-90c6-0a0f204448ec",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Patates Kızartması",
                            category = "",
                            price = 150,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Permasanlı Patates Kızartması",
                            category = "",
                            price = 175,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Trüflü Patates Kızartması",
                            category = "",
                            price = 175,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Trüflü Permasanlı Patates Kızartması",
                            category = "",
                            price = 200,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Tatlı Acı Soslu Çıtır Tavuk",
                            category = "",
                            price = 360,
                            details = "(200gr 7-8 adet tatlı acı soslu çıtır tavuk parçaları ve patates kızartması",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqnpUqYMU5Wt2FYQ-p0.jpg?alt=media&token=fe80474d-f0cb-448e-bab3-4cd9f62409f4",
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "PORSİYON",
                    no = 4,
                    details = "",
                    image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqmQWicpUYw-b1IL81C.jpg?alt=media&token=434b719c-c096-47ce-b148-616f4bc6ced5",
                    products = listOf(
                        MenuItem(
                            name = "Dynamite Tavuk Porsiyon",
                            category = "",
                            price = 400,
                            details = "Özel sos ile marine edilmiş 200 gr ızgara tavuk bonfile parçaları,Patates kızartması,pirinç veya meyhane pilavı,mevsim salatası,amerikan salatası.",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqmRTV72PtofoIdlL-R.jpg?alt=media&token=1d1776f2-bd38-44ab-ba23-54db7b4507a5",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Chedarlı Dynamite Tavuk Porsiyon",
                            category = "",
                            price = 420,
                            details = "Özel sos ile marine edilmiş 200 gr ızgara tavuk bonfile parçaları üzerine chedar peyniri,Patates kızartması,pirinç veya meyhane pilavı,mevsim salatası,amerikan salatası.",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqmRRH_AauyHVa1ujmS.jpg?alt=media&token=d30860d0-699c-4fe2-b6d8-98f3d7cbf13b",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Izgara Köfte Porsiyon",
                            category = "",
                            price = 450,
                            details = "200gr 6 adet ızgara köfte,Patates kızartması,pirinç veya meyhane pilavı,mevsim salatası,amerikan salatası,köz biber ve domates,acuka sos,maydanozlu ve sumaklı soğan ile",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiDpL-E3zQJZBElmUI.jpg?alt=media&token=3ea5746d-a9c4-4dd6-813b-142b7ba6efd5",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Tavuk Şinitzel",
                            category = "",
                            price = 420,
                            details = "200gr El yapımı şinitzel, Patates kızartması,pirinç pilavı,mevsim,salatası,amerikan salatası,tatlı acı sos ile.",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqmRdWqjVA9uhR055oU.jpg?alt=media&token=7e05912b-11ca-45bd-8694-15d94f5f5f4b",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Izgara Tavuk Göğüs",
                            category = "",
                            price = 410,
                            details = "200gr tavuk bonfile,patates kızartması,pirinç veya meyhane pilavı,mevsim salatası,amerikan salatası.",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiE5mME_AD-oWRkLYT.jpg?alt=media&token=562fd698-438c-41c8-8e59-d749706fa31a",
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "DÜRÜM",
                    no = 5,
                    details = "",
                    image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqmQMgSG5vPRm9TgPUn.jpg?alt=media&token=33f557e3-36b8-41a4-8e40-0f897d202a7a",
                    products = listOf(
                        MenuItem(
                            name = "Dynamite Dürüm",
                            category = "",
                            price = 320,
                            details = "Kızarmış Tortilla ekmeğine,Özel sos ile marine edilmiş 175 gr tavuk bonfile parçaları,domates,biber,chedar peyniri.",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqi0xxMiyKVV_nzAcNy.jpg?alt=media&token=d1745317-7385-476f-9bb6-dcdc6c7931ef",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Köfte Dürüm",
                            category = "",
                            price = 365,
                            details = "Kızarmış tortilla ekmeğine peri peri sos,domates,biber,yeşillik,isteğe bağlı soğan.",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiCGfCbRl1jrt28jsL.jpg?alt=media&token=84e616fa-7429-4449-beab-c8e330b9d178",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Çıtır Dürüm",
                            category = "",
                            price = 330,
                            details = "El yapımı şinitzel,ketçap,peri peri sos ,domates,göbek,turşu.",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiCLmF7YkGsneWWr9W.jpg?alt=media&token=d75b8291-5940-4989-a2d7-c1aa7c6181cf",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Falafel Dürüm",
                            category = "",
                            price = 315,
                            details = "Kızarmış tortilla ekmeğine peri peri sos, falafel, göbek, domates, kapya biber,kekik.",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiCSF2oE3p5RudYVuc.jpg?alt=media&token=38d983f0-f3ba-43eb-afa5-c5e0865ff4bb",
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "BURGER MENÜLERİ",
                    no = 6,
                    details = "",
                    image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqnv7gvkOIT6RofKh-b.jpg?alt=media&token=4efbc4ee-29f5-46dd-a9c8-e9ed58f50b04",
                    products = listOf(
                        MenuItem(
                            name = "Hamburger(140gr) Menü",
                            category = "",
                            price = 445,
                            details = "Patates kızartması,domates,göbek,salatalık turşusu,peri peri sos ve seçeceğiniz içecek ile",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqntdQTGITrvaj4KIDz.jpg?alt=media&token=8eddd985-d701-42ff-a0cb-a46a0942d8ec",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Cheese Burger(140gr) Menü",
                            category = "",
                            price = 465,
                            details = "Patates kızartması,chedar peyniri,domates,göbek,turşu,peri peri sos ve seçeceğiniz içecek ile",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqntolHlIAprpBwtisB.jpg?alt=media&token=613b5f04-1fa9-4032-8369-c371a889b7d1",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Dynamite Burger(175gr) Menü",
                            category = "",
                            price = 505,
                            details = "Patates kızartması,chedar peyniri,domates,göbek,turşu,karamelize soğan,peri peri sos ve seçeceğiniz içecek ile",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqnu7Mv_mKMRU2o_iV5.jpg?alt=media&token=453f46e7-7cea-4f4c-95b5-1b1b540b5861",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Kule Burger(200gr) Menü",
                            category = "",
                            price = 580,
                            details = "Patates kızartması,2 adet hamburger köftesi arasında,köz patlıcan,karamelize soğan,chedar peyniri,domates,göbek,turşu, peri peri sos ve seçeceğiniz içecek ile",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqnu5jhKJwWzK9RMkXt.jpg?alt=media&token=dafc23d4-a797-4d39-b89e-2512f115d4fe",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Tavuk Burger Menü",
                            category = "",
                            price = 400,
                            details = "Patates kızartması,el yapımı tavuk şinitzel,domates,göbek,turşu,peri peri sos ,ketçap ve seçeceğiniz içecek ile",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqnuRNSVB5I7_JQKk8m.jpg?alt=media&token=31529eb2-1343-434f-b1a7-a449d20220bc",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Tatlı Acı Burger Menü",
                            category = "",
                            price = 410,
                            details = "Patates kızartması,el yapımı tavuk şinitzel,domates,göbek,tatlı acı sos ve seçeceğiniz içecek ile",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqnuZs06NwqL4IUPswM.jpg?alt=media&token=1e3c5b67-bf4a-492b-bccd-1609291420db",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Kaşarlı Tavuk Burger Menü",
                            category = "",
                            price = 430,
                            details = "Patates kızartması,el yapımı tavuk şinitzel,chedar peyniri,domates,göbek,turşu,peri peri sos ,ketçap ve seçeceğiniz içecek ile",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqnukKcO-veWGiMEPGV.jpg?alt=media&token=7c366970-65a3-4a2d-8d08-8c85bbb1be78",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Falafel Burger Menü",
                            category = "",
                            price = 390,
                            details = "Patates kızartması,falafel,göbek,domates,turşu,kapya biber,kekik, peri peri sos ve seçeceğiniz içecek ile",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqnuznn7RtRFAJUJOP_.jpg?alt=media&token=8ead4b1a-1c80-4b7a-9aae-9967c86f44af",
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "BURGER",
                    no = 7,
                    details = "",
                    image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqmS0S1kCzbGvi3napt.jpg?alt=media&token=ea522270-d8ec-465e-a4ea-25e26cf4e0c0",
                    products = listOf(
                        MenuItem(
                            name = "Hamburger",
                            category = "",
                            price = 385,
                            details = "140gr,Patates kızartması,domates,göbek,salatalık turşusu,peri peri sos.",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiEQYmPUS7tRBYvk83.jpg?alt=media&token=33dfa327-f9b2-445f-a584-32573cd6d150",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Cheese Burger",
                            category = "",
                            price = 405,
                            details = "140gr,Patates kızartması,chedar peyniri,domates,göbek,turşu,peri peri sos.",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiEVtm0DasagSKtvDF.jpg?alt=media&token=08e420a4-c82f-4189-9b8c-d740f63a91bf",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Dynamite Burger",
                            category = "",
                            price = 445,
                            details = "175gr,patates kızartması,chedar peyniri,domates,göbek,turşu,karamelize soğan,peri peri sos.",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiEYGpqZsQ3Q9RXqd8.jpg?alt=media&token=0378035f-670b-4732-af56-732c2e8d88bf",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Kule Burger",
                            category = "",
                            price = 520,
                            details = "200gr,Patates kızartması,2 adet hamburger köftesi arasında,köz patlıcan,karamelize soğan,chedar peyniri,domates,göbek,turşu ve peri peri sos",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiEcGG4a2O7GGeoxCj.jpg?alt=media&token=9cee06cf-baa6-4741-83fd-f6d137ec64ae",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Tavuk Burger",
                            category = "",
                            price = 340,
                            details = "Patates kızartması,el yapımı tavuk şinitzel,domates,göbek,turşu,peri peri sos,ketçap.",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiEeknZGg7dfo4A_nb.jpg?alt=media&token=06e7e16e-ebfb-4c54-9dd7-a76d50475fcf",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Tatlı Acı Tavuk Burger",
                            category = "",
                            price = 350,
                            details = "Patates kızartması,el yapımı tavuk şinitzel,domates,göbek,tatlı acı sos.",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiEgzeED__za-ufEJf.jpg?alt=media&token=8c749aaa-a1cd-4ed2-8d6d-5d480f571153",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Kaşarlı Tavuk Burger",
                            category = "",
                            price = 370,
                            details = "Patates kızartması,el yapımı tavuk şinitzel,chedar peyniri,domates,göbek,turşu,peri peri sos,ketçap.",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiEjcNWhvEQRPCJw97.jpg?alt=media&token=9f86b9db-41e5-44bc-a094-3b6360f6f9f5",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Falafel Burger",
                            category = "",
                            price = 330,
                            details = "Patates kızartması,falafel,göbek,domates,turşu,kapya biber,kekik ve peri peri sos",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiElecHoHLjyO0xHtE.jpg?alt=media&token=38c608bf-a256-4e9e-876b-fc7e72dbb839",
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "SOS",
                    no = 8,
                    details = "",
                    image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqn-3-ETNr7HaZ8DmNa.jpg?alt=media&token=f5fe902d-c236-4ff2-9894-076b43034291",
                    products = listOf(
                        MenuItem(
                            name = "Sweat Chili",
                            category = "",
                            price = 20,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Dynamite",
                            category = "",
                            price = 20,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Ranch",
                            category = "",
                            price = 20,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Barbekü",
                            category = "",
                            price = 20,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Trüflü Mayonez",
                            category = "",
                            price = 20,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Sriracha",
                            category = "",
                            price = 20,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Sarımsaklı Mayonez",
                            category = "",
                            price = 20,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "SALATA",
                    no = 9,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Dynamite Salata",
                            category = "",
                            price = 300,
                            details = "Dynamite tavuk (200 gr), mevsim yeşillikleri, avokado, kurutulmuş domates, mısır, özel sos ile",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "TATLI",
                    no = 10,
                    details = "",
                    image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-OlcapX9ptSjpBRmdmVm.jpg?alt=media&token=6e65bc79-b286-4bd4-8e04-995a07ab83b2",
                    products = listOf(
                        MenuItem(
                            name = "Fırın Sütlaç",
                            category = "",
                            price = 120,
                            details = "",
                            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-OlcarhUh0uITQ0RVzss.jpg?alt=media&token=0ef63412-70a5-4c80-bc00-98e7eb233fbc",
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "İÇECEK",
                    no = 11,
                    details = "",
                    image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqmzY4gyE4Pql108bh5.jpg?alt=media&token=7573cc17-4c21-446b-a359-2db5cad1dede",
                    products = listOf(
                        MenuItem(
                            name = "Cola",
                            category = "",
                            price = 70,
                            details = "330 ML",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Sprite",
                            category = "",
                            price = 70,
                            details = "330 ML",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "İce Tea",
                            category = "",
                            price = 70,
                            details = "Limon / Mango / Şeftali / Karpuz / Kavun ve Çilek",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Ayran",
                            category = "",
                            price = 50,
                            details = "Sütaş Ayran 300 ML",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Soda",
                            category = "",
                            price = 30,
                            details = "Damla Soda",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Su",
                            category = "",
                            price = 20,
                            details = "Damla Su",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Fanta",
                            category = "",
                            price = 70,
                            details = "330 ML",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Özerhisar Ayran",
                            category = "",
                            price = 70,
                            details = "245 ML",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "SICAK İÇECEK",
                    no = 12,
                    details = "",
                    image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqmziB4xdPPn-pdmpFk.jpg?alt=media&token=2bd2e009-b734-4543-a867-144fd13aa90a",
                    products = listOf(
                        MenuItem(
                            name = "Çay",
                            category = "",
                            price = 40,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Nescafe",
                            category = "",
                            price = 60,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "PAKET İLAVE",
                    no = 13,
                    details = "",
                    image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-OUzn3wbBualMdfmQhHh.jpg?alt=media&token=624a8a7a-5de8-4f50-abd5-238d2ad91175",
                    products = listOf(
                        MenuItem(
                            name = "Lavaş",
                            category = "",
                            price = 20,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Pirinç Pilavı",
                            category = "",
                            price = 50,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Mevsim Salata",
                            category = "",
                            price = 45,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "1.5 Çıtır Tavuk",
                            category = "",
                            price = 530,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "1.5 Susamlı Çıtır Tavuk",
                            category = "",
                            price = 540,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "1.5 Tatlı Acı Soslu Çıtır Tavuk",
                            category = "",
                            price = 540,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Yarım Çıtır Tavuk",
                            category = "",
                            price = 200,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Yarım Susamlı Çıtır Tavuk",
                            category = "",
                            price = 210,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Yarım Tatlı Acı Çıtır Tavuk",
                            category = "",
                            price = 210,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
            )
            "hamburg-burger-hisarustu" -> listOf(
                MenuCategory(
                    name = "Burger Menü",
                    no = 0,
                    details = "",
                    image = "",
                    products = listOf(
                        MenuItem(
                            name = "HAMBURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 310,
                            details = "Dana Burger Köftesi, Karamelize Sogan, Tursu, Özel Dip Sos, BBO Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "CHEESBURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 320,
                            details = "Dana Burger Köftesi, Karamelize Sogan, Tursu, Özel Dip Sos, BBQ Sos, Cheddar Peynir",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "DANA BACONLU CHEDDARLI BURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 355,
                            details = "Dana Burger Köftesi, Dana Bacon, Cheddar Peynir, Karamelize Sogan, Turşu, Özel Dip Sos, BBQ Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "DANA JAMBONLU CHEDDARLI BURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 355,
                            details = "Dana Burger Köftesi, Dana Jambon, Cheddar Peynir, Karamelize Sogan, Tursu, Özel Dip Sos, BBQ Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "ANTRiKOT FÜME ETLI CHEDDARLI BURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 355,
                            details = "Dana Burger Köftesi, Antrikot Füme Et, Cheddar. Peynir, Karamelize Sogan,Tursu, Özel Dip Sos, BBQ Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "KAVURMALI CHEDDARLI BURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 400,
                            details = "Dana Burger Köftesi, Dana Kavurma, Cheddar Peynir, Karamelize Sogan, Tursu, Özel Dip Sos, BBO Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "TEREYAGLI CHEDDARLI BURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 345,
                            details = "Dana Burger Köftesi, Tereyag. Cheddar Peynir, Karamelize Soğan, Tursu, Özel Dip Sos, BBO Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "FÜME ISLi PEYNIRLi BURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 345,
                            details = "Dana Burger Köftesi, Füme isli Peynir, Karamelize Sogan, Tursu, Özel Dip Sos, BBQ Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "HELLIM PEYNIRLi BURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 345,
                            details = "Dana Burger Köftesi, Hellim Peynir, Karamelize Sogan,Tursu, Özel Dip Sos, BBQ Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "ROKFOR PEYNIRLI BURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 365,
                            details = "Dana Burger Köftesi, Rokfor Peynir, Karamelize Sogan, Tursu, Özel Dip Sos, BBQ Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "PASTIRMALI CHEDDARLI BURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 400,
                            details = "Dana Burger Köftesi, Çemensiz Pastirma, Cheddar Peynir, Karamelize Sogan, Tursu, Özel Dip Sos, BBQ Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "FÜME DILLI CHEDDARLI BURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 355,
                            details = "Dana Burger Köftesi, Füme isli Dana Dil, Cheddar Peynir, Karamelize Sogan, Turşu, Özel Dip Sos, BBQ Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "MANTAR KASARLI  BURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 345,
                            details = "Dana Burger Köftesi, Mantar, Kasar, Karamelize Sogan, Turşu, Özel Dip Sos, BBO Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "KÖZ KAPYA BIBERLi CHEDDARLI BURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 335,
                            details = "Dana Burger Köftesi, Köz Kapya Biber, Cheddar Peynir, Karamelize Sogan, Turşu, Özel Dip Sos, BBQ Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "PARMESAN PEYNIRLI BURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 335,
                            details = "Dana Burger Köftesi, Toz Parmesan Peynir, Karamelize Sogan, Tursu, Özel Dip Sos, BBQ Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "SOSLU CHEDDARLI BURGER (Sececeginiz Sos ile) + PATATES KIZARTMASI",
                            category = "",
                            price = 330,
                            details = "Dana Burger Köftesi, (Aci Sos, Ranch Sos, BBQ Sos, Sarimsak Sos, Eksi Tatli Sos, Köri Sos, Pancar Sos, Hardal Sos, Zeytin Ezmesi, Balli Hardal) Karamelize Sogan, Tursu, Ozel Dip Sos, BBQ Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "TEREYAGLI YUMURTALI CHEDDARLI BURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 365,
                            details = "Dana Burger Köftesi, Tereyagli Yumurta, Cheddar Peynir, Karamelize Sogan, Turşu, Özel Dip Sos, BBQ Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "GUACAMOLE SOSLU CHEDDARLI BURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 335,
                            details = "130 gr Dana Burger Köftesi, Guacamole Sos, Cheddar Peynir, Karamelize Sogan, Tursu, Özel Dip Sos, BBQ Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "2 TANE CHEDDAR PEYNİRLİ HOT DOG+2 TANE PATATES KIZARTMASI +2 TANE SEÇECEĞİNİZ ŞİŞE İÇECEK YADA AYRAN",
                            category = "",
                            price = 640,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "CHEDDARLI VEGİE CLOSED BURGER+PATATES KIZARTMASI",
                            category = "",
                            price = 400,
                            details = "240 gram falafel vegie köftesi,3 dilim cheddar peyniri,mantar,karamelize soğan,turşu,trüflü mayonez,bbq sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "CHEDDAR PEYNİRLİ HOTDOG+PATATES KIZARTMASI + ŞİŞE İÇECEK YADA AYRAN",
                            category = "",
                            price = 365,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Veggie Burger +Patates Kızartması",
                            category = "",
                            price = 300,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "120 Gr Cheddarlı Veggie Burger+Patates Kızartması",
                            category = "",
                            price = 310,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "120 Gr Vegie Burger+Patates Kızartması +Şişe içecek veya Ayran",
                            category = "",
                            price = 345,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "KÖZ PATLICANLI CHEDDARLI  BURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 335,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "JALEPENO BİBERLİ CHEDDARLI BURGER+",
                            category = "",
                            price = 335,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Closed Burger Menü",
                    no = 1,
                    details = "",
                    image = "",
                    products = listOf(
                        MenuItem(
                            name = "CHEDDARLI CLOSED BURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 415,
                            details = "180gr Dana Burger köftesi, 3 Dilim Cheddar Peynir, Mantar, Turşu, Karamelize Sogan, BB0 Sos, Özel Dip Sos. Trüflü Mayonez (05.00",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "FÜME ISLI PEYNIRLI CLOSED BURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 435,
                            details = "180gr Dana Burger Köftesi, isli Peynir, Mantar, Tursu, Karamelize Sogan, BBQ Sos, Özel Dip Sos, Trüflü Mayonez",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "MANTAR KASARLI CLOSED BURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 415,
                            details = "180gr Dana Burger Köftesi, 3 Dilim Kasar, Double Mantar, Tursu, Karamelize Sogan, BBQ Sos, Özel Dip Sos, Trüflü Mayonez",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "JALAPENO CLOSED BURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 425,
                            details = "180gr Dana Burger Köftesi, 3 Dilim Cheddar Peynir, Jalapeno Biber, Mantar, Tursu, Karamelize Sogan, BBQ Sos, Özel Dip Sos, Trüflü Mayonez",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "GUACAMOLE SOSLU CLOSED BURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 430,
                            details = "180gr Dana Burger Köftesi, Guacamole Sos, 3 Dilim Cheddar Peynir, Mantar, Tursu, Karamelize Sogan, BBQ Sos, Özel Dip Sos, Trüflü Mayonez",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "FÜME DiLLI CLOSED BURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 455,
                            details = "180gr Dana Burger Köftesi, Tütsülenmis Füme Dil, 3 Dilim Cheddar Peynir, Mantar, Tursu, Karamelize Sogan, BBQ Sos, Ozel Dip Sos, Trüflü Mayonez",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "ROKFOR PEYNIRLI CLOSED BURGER + PATATES KIZARTMAS!",
                            category = "",
                            price = 465,
                            details = "180gr Dana Burger Köftesi, 2 Kat Rokfor Peynir, Mantar, Tursu, Karamelize Sogan, BBQ Sos, Ozel Dip Sos, Trüflü Mavonez",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "DANA BACON CLOSED BURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 455,
                            details = "180gr Dana Burger Köftesi, Dana Bacon, 3 Dilim Cheddar Peynir, Mantar, Tursu, Karamelize Sogan, BBQ Sos, Özel Dip Sos, Trüflü Mayonez",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "ANTRiKOT FÜME ETLi CLOSED BURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 455,
                            details = "180gr Dana Burger Köftesi, Antrikot Füme Et, 3 Dilim Cheddar Peynir, Mantar, Tursu, Karamelize Sogan, BBQ Sos, Ozel Dip Sos, Trüflü Mayonez",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "KAVURMALI CLOSED BURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 485,
                            details = "180gr Dana Burger Köftesi, Dana Kavurma, 3 Dilim Cheddar Peynir, Mantar, Turgu, Karamelize Sogan, BBQ Sos, Özel Dip Sos, Trüflü Mayonez",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "PASTIRMALI CLOSED BURGER + PATATES KIZARTMASI",
                            category = "",
                            price = 485,
                            details = "180gr Dana Burger Köftesi, Dana Pastirma, 3 Dilim Cheddar Peynir, Mantar, Tursu, Karamelize Sogan, BBQ Sos, Özel Dip Sos, Trüflü Mayonez",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "CHİCKEN CLOSED BURGER+PATATES  KIZARTMASI",
                            category = "",
                            price = 390,
                            details = "200-240 gr arası ızgarada pişmiş tavuk pirzola,bbq sos,trüf yağlı mayonez,turşu,karamelize soğan,mantar",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "CHEDDARLI CHİCKEN CLOSED BURGER+PATATES KIZARTMASI",
                            category = "",
                            price = 405,
                            details = "200-240 gr arası ızgarada pişmiş tavuk pirzola,3 dilim cheddar peynir,bbq sos,turşu,trüf yağlı mayonez,karamelize soğan,mantar",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "2 TANE CHEDDAR PEYNİRLİ HOT DOG+2 TANE PATATES KIZARTMASI +2 TANE SEÇECEĞİNİZ ŞİŞE İÇECEK YADA AYRAN",
                            category = "",
                            price = 640,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "CHEDDARLI VEGİE CLOSED BURGER+PATATES KIZARTMASI",
                            category = "",
                            price = 400,
                            details = "240 gram falafel vegie köftesi,3 dilim cheddar peyniri,mantar,karamelize soğan,turşu,trüflü mayonez,bbq sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "CHEDDAR PEYNİRLİ HOTDOG+PATATES KIZARTMASI + ŞİŞE İÇECEK YADA AYRAN",
                            category = "",
                            price = 365,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "HELLİM PEYNİRLİ CLOSED BURGER+PATATES KIZARTMASI",
                            category = "",
                            price = 435,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Tavuk Burger Menü",
                    no = 2,
                    details = "",
                    image = "",
                    products = listOf(
                        MenuItem(
                            name = "Tavuk Burger+Patates Kızartması",
                            category = "",
                            price = 290,
                            details = "180-220 gram tavuk pirzola,bbq sos,özel dip sos,turşu",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Kaşarlı Tavuk Burger+Patates Kıızartması",
                            category = "",
                            price = 305,
                            details = "180-220 Gr Tavuk pirzola,kaşar peynir,bbq sos,turşu,özel dip sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Chedarlı Tavuk Burger+Patates Kızartması",
                            category = "",
                            price = 305,
                            details = "180-220 Gr Tavuk pirzola,cheddar peynir,bbq sos,turşu,özel dip sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Ranch Soslu Chedarlı Tavuk Burger+Patates Kızartması",
                            category = "",
                            price = 315,
                            details = "180-220 Gr Tavuk pirzola,Ranch sos ,cheddar peynir,bbq sos,turşu,özel dip sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Tatlı Ekşi Soslu Cheddarlı Tavuk Burger +Patates Kızartması",
                            category = "",
                            price = 315,
                            details = "180-220 Gr Tavuk pirzola,Tatlı Ekşi sos ,cheddar peynir,bbq sos,turşu,özel dip sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Acı Soslu Cheddarlı Tavuk Burger+Patates Kızartması",
                            category = "",
                            price = 305,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "2 TANE CHEDDAR PEYNİRLİ HOT DOG+2 TANE PATATES KIZARTMASI +2 TANE SEÇECEĞİNİZ ŞİŞE İÇECEK YADA AYRAN",
                            category = "",
                            price = 640,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Sarımsak Soslu Cheddarlı Tavuk Burger+Patates Kızartması",
                            category = "",
                            price = 315,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Tatlı Acı Soslu Cheddarlı Tavuk Burger+Patates Kızartması",
                            category = "",
                            price = 315,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "CHEDDARLI VEGİE CLOSED BURGER+PATATES KIZARTMASI",
                            category = "",
                            price = 400,
                            details = "240 gram falafel vegie köftesi,3 dilim cheddar peyniri,mantar,karamelize soğan,turşu,trüflü mayonez,bbq sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "CHEDDAR PEYNİRLİ HOTDOG+PATATES KIZARTMASI + ŞİŞE İÇECEK YADA AYRAN",
                            category = "",
                            price = 365,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Veggie Burger +Patates Kızartması",
                            category = "",
                            price = 300,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "120 Gr Cheddarlı Veggie Burger+Patates Kızartması",
                            category = "",
                            price = 310,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "120 Gr Vegie Burger+Patates Kızartması +Şişe içecek veya Ayran",
                            category = "",
                            price = 345,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Hot Dog Menü",
                    no = 3,
                    details = "",
                    image = "",
                    products = listOf(
                        MenuItem(
                            name = "HOT DOG + PATATES KIZARTMASI",
                            category = "",
                            price = 280,
                            details = "115gr Hot Dog, Karamelize Sogan, Tursu, Ketçap, Mayonez, Hardal, BBO SoS",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "CHEDDAR PEYNIRLI HOT DOG + PATATES KIZARTMASI",
                            category = "",
                            price = 295,
                            details = "115gr Hot Dog, Cheddar Peynir, Karamelize Sogan, Tursu, Ketçap, Mayonez, Hardal, BBQ Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "HELLiM PEYNIRLi HOT DOG + PATATES KIZARTMASI",
                            category = "",
                            price = 300,
                            details = "115gr Hot Dog, Hellim Peynir, Karamelize Sogan, Tursu, Ketçap, Mayonez, Hardal, BBQ Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "FÜME ISLI PEYNIRLi HOT DOG + PATATES KIZARTMASI",
                            category = "",
                            price = 305,
                            details = "115gr Hot Dog, Füme isli Peynir, Karamelize Sogan, Tursu, Ketçap, Mayonez, Hardal, BBQ Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "TEREYAGLI CHEDDARLI HOT DOG + PATATES KIZARTMASI",
                            category = "",
                            price = 305,
                            details = "115gr Hot Dog, Tereyag, Cheddar Peynir, Karamelize Sogan, Tursu, Ketçap, Mayonez, Hardal, BBQ Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "DANA BACONLU CHEDDARLI HOT DOG + PATATES KIZARTMASI",
                            category = "",
                            price = 325,
                            details = "115gr Hot Dog, Dana Bacon, Cheddar Peynir, Karamelize Sogan, Tursu, Ketçap, Mayonez, Hardal, BBQ Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "PASTIRMALI CHEDDARLI HOT DOG + PATATES KIZARTMASI",
                            category = "",
                            price = 340,
                            details = "115gr Hot Dog, Gemensiz Pastirma, Cheddar Peynir, Karamelize Sogan, Tursu, Ketçap, Mayonez, Hardal, BBQ Sos ANTRiKOT",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "ATRİKOT FÜME ETLi CHEDDARLI HOT DOG + PATATES KIZARTMASI",
                            category = "",
                            price = 325,
                            details = "115gr Hot Dog, Antrikot Füme Et, Cheddar Peynir, Karamelize Sogan, Turgu, Ketçap, Mayonez, Hardal, BBQ Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "FÜME DiLLi CHEDDARLI HOT DOG + PATATES KIZARTMASI",
                            category = "",
                            price = 325,
                            details = "115gr Hot Dog. Dana Füme Dil, Cheddar Peynir, Karamelize Sogan, Tursu, Ketçap, Mayonez, Hardal, BBQ Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "SOSLU CHEDDARLI HOT DOG (Seçeceginiz Sos ile) + PATATES KIZARTMASI",
                            category = "",
                            price = 305,
                            details = "115gr Hot Dog. (Aci Sos, Ranch Sos, BBQ Sos, Sarimsak Sos, Eksi Tatli Sos, Köri Sos, Pancar Sos, Hardal Sos, Zeytin Ezmesi, Balli Hardal) Karamelize Sogan, Tursu, Ketçap, Mayonez, Hardal, BBQ Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "2 TANE CHEDDAR PEYNİRLİ HOT DOG+2 TANE PATATES KIZARTMASI +2 TANE SEÇECEĞİNİZ ŞİŞE İÇECEK YADA AYRAN",
                            category = "",
                            price = 640,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "CHEDDARLI VEGİE CLOSED BURGER+PATATES KIZARTMASI",
                            category = "",
                            price = 400,
                            details = "240 gram falafel vegie köftesi,3 dilim cheddar peyniri,mantar,karamelize soğan,turşu,trüflü mayonez,bbq sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "CHEDDAR PEYNİRLİ HOTDOG+PATATES KIZARTMASI + ŞİŞE İÇECEK YADA AYRAN",
                            category = "",
                            price = 365,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Special Frankfurter Hot Dog Menü",
                    no = 4,
                    details = "",
                    image = "",
                    products = listOf(
                        MenuItem(
                            name = "FRANKFURTER HOT DOG + PATATES KIZARTMASI",
                            category = "",
                            price = 350,
                            details = "100gr Viyana Usulü Dışı Citir Içi Sulu Füme Dana Sosis, Karamelize Sogan, Tursu, BBQ Sos, Hardal, Az Ketçap, Az Mayonez",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "CHEDDARLI FRANKFURTER + PATATES KIZARTMASI",
                            category = "",
                            price = 360,
                            details = "100gr Viyana Usulü Dışı Citir Içi Sulu Füme Dana Sosis, Cheddar Peynir, Karamelize Sogan, Tursu, BBQ Sos, Hardal, Az Ketçap, Az Mayonez",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "DANA BACONLU CHEDDARLI FRANKFURTER + PATATES KIZARTMASI",
                            category = "",
                            price = 380,
                            details = "100gr Viyana Usulü Dig/ Gitir içi Sulu Füme Dana Sosis, Dana Bacon, Cheddar Peynir, Karamelize Sogan, Turgu, BBQ Sos,Hardal, Az Ketçap, Az Mayonez",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "ANTRiKOT FÜME ETLi CHEDDARLI FRANKFURTER + PATATES KIZARTMASI",
                            category = "",
                            price = 380,
                            details = "100gr Viyana Usulü Disi Citir Içi Sulu Füme Dana Sosis, Füme Kuru Et, Cheddar Peynir, Karamelize Sogan, Tursu, BBQ Sos,",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "PASTIRMALI CHEDDARLI FRANKFURTER + PATATES KIZARTMASI",
                            category = "",
                            price = 390,
                            details = "100gr Viyana Usulü Disi Citir ici Sulu Füme Dana Sosis, Cemensiz Pastirma, Cheddar Peynir, Karamelize Soùan, Tursu, BBQ Sos, Hardal, Az Ketçap, Az Mayonez",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "SOSLU CHEDDARLI FRANKFURTER (Seçeceginiz Sos ile) + PATATES KIZARTMASI",
                            category = "",
                            price = 365,
                            details = "100 gr Viyana Usulu Disi Citir içi Sulu Fume Dana Sosis. (Act Sos, Ranch Sos, Sarimsak Sos, Eksi Tatli Sos. Köri Sos, Pancar Sos, Hardal Sos, Zeytin Ezmesi, Balli Hardal) Karamelize Sogan, Tursu, Az Ketçap, Az Mayonez, BBQ Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "BRATWURST HOT DOG + PATATES KIZARTMASI",
                            category = "",
                            price = 350,
                            details = "100gr Alman Usulü Tütsülenmis Jumbo Dana Sosis, Karamelize Sogan, Tursu, BBQ Sos, Hardal, Az Ketçap, Az Mayonez",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "CHEDDARLI BRATWURST + PATATES KIZARTMASI",
                            category = "",
                            price = 360,
                            details = "100gr Alman Usulü Tütsülenmis Jumbo Dana Sosis, Cheddar Peynir, Karamelize Sogan, Tursu, BBQ Sos, Hardal, Az Ketçap, Az Mayonez",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "DANA BACONLU CHEDDARLI BRATWURST + PATATES KIZARTMASI",
                            category = "",
                            price = 380,
                            details = "100gr Alman Usulü Tutsülenmis Jumbo Dana Sosis, Dana Bacon, Cheddar Peynir, Karamelize Sogan, Turgu, BBQ Sos, Hardal, Az Ketçap, Az Mayonez",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "ANTRIKOT FÜME ETLI CHEDDARLI BRATWURST + PATATES KIZARTMASI",
                            category = "",
                            price = 380,
                            details = "100gr Alman Usulü Tütsülenmis Jumbo Dana Sosis, Füme Kuru Et, Cheddar Peynir, Karamelize Sogan, Tursu, BBQ Sos, Hardal, Az Ketçap, Az Mayonez",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "PASTIRMALI CHEDDARLI BRATWURST + PATATES KIZARTMASI",
                            category = "",
                            price = 390,
                            details = "100gr Alman Usulü Tütsülenmis Jumbo Dana Sosis, Cemensiz Pastirma, Cheddar Peynir, Karamelize Sogan, Tursu, BBQ Sos, Hardal, Az Ketçap, Az Mayonez",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "SOSLU CHEDDARLI BRATWURST (Seçeceginiz Sos ile) + PATATES KIZARTMASI",
                            category = "",
                            price = 365,
                            details = "100gr Alman Usulü Tütsulenmis Jumbo Dana Sosis, (Aci Sos, Ranch Sos, Sarimsak Sos, Eksi Tatli Sos, Köri Sos, Pancar Sos, Hardal Sos, Zeytin Ezmesi, Balli Hardal) Karamelize Sogan, Tursu, Az Ketçap, Az Mayonez, BBO Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "2 TANE CHEDDAR PEYNİRLİ HOT DOG+2 TANE PATATES KIZARTMASI +2 TANE SEÇECEĞİNİZ ŞİŞE İÇECEK YADA AYRAN",
                            category = "",
                            price = 640,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "CHEDDARLI VEGİE CLOSED BURGER+PATATES KIZARTMASI",
                            category = "",
                            price = 400,
                            details = "240 gram falafel vegie köftesi,3 dilim cheddar peyniri,mantar,karamelize soğan,turşu,trüflü mayonez,bbq sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "CHEDDAR PEYNİRLİ HOTDOG+PATATES KIZARTMASI + ŞİŞE İÇECEK YADA AYRAN",
                            category = "",
                            price = 365,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Sandviçler",
                    no = 5,
                    details = "",
                    image = "",
                    products = listOf(
                        MenuItem(
                            name = "SOSISLi SANDVIÇ",
                            category = "",
                            price = 120,
                            details = "Sosis, Patates Kizartmasi, Tursu, Ketçap, Mayonez, Hardal, BBQ Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "GORALI SANDVIC",
                            category = "",
                            price = 130,
                            details = "Sosis, Patates Kizartmasi, Amerikan Salata, Tursu, Ketçap, Mayonez, Hardal, BBQ Sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "PATSO",
                            category = "",
                            price = 200,
                            details = "Patates Kizartmasi, Tursu, Ketçap, Mayonez",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "CHEDDARLI PATSO",
                            category = "",
                            price = 220,
                            details = "Patates Kizartmasi, Cheddar Peynir, Tursu, Ketçap, Mayonez",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "TAVUKLU PATSO",
                            category = "",
                            price = 250,
                            details = "Patates Kizartmasi, Izgara Tavuk, Tursu, Ketçap, Mayonez",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "KÖFTELi PATSO",
                            category = "",
                            price = 275,
                            details = "Patates Kizartmasi, Izgara Köfte, Tursu, Ketçap, Mayonez",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "SOSİSLİ PATSO",
                            category = "",
                            price = 220,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "2’Li Sosisli Sandviç+Şişe İçecek",
                            category = "",
                            price = 275,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "2’Li Goralı Sandviç +Şişe İçecek",
                            category = "",
                            price = 295,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "2 TANE CHEDDAR PEYNİRLİ HOT DOG+2 TANE PATATES KIZARTMASI +2 TANE SEÇECEĞİNİZ ŞİŞE İÇECEK YADA AYRAN",
                            category = "",
                            price = 640,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Yan Ürünler",
                    no = 6,
                    details = "",
                    image = "",
                    products = listOf(
                        MenuItem(
                            name = "Patates Kızartması",
                            category = "",
                            price = 120,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Elma Dilim Patates Kızartması",
                            category = "",
                            price = 120,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Cheddarlı Patates Kızartması",
                            category = "",
                            price = 150,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Acı Soslu Patates Kızartması",
                            category = "",
                            price = 130,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "6'lı Soğan Halkası",
                            category = "",
                            price = 120,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "6'lı Patates Kroket",
                            category = "",
                            price = 120,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "6'lı Nugget",
                            category = "",
                            price = 120,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "6'lı Çıtır Tavuk",
                            category = "",
                            price = 180,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "6'lı Mozarella Sticks",
                            category = "",
                            price = 180,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Büyük Karışık Lezzet Paketi",
                            category = "",
                            price = 470,
                            details = "1 Porsiyon Patates Kızartması,4 Soğan Halkası,4 Adet Mozerella Sticks,4 adet Nugget,4 adet Patates Kroket,8 parça Sosis ile beraber",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Mini Karışık Lezzet Paketi",
                            category = "",
                            price = 240,
                            details = "Yarım porsiyon patates kızartması,2 adet Mozerella Sticks,2 adet soğan halkası,2 adet patates kroket,2 adet nugget,4 parça sosis",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "EKSTRA SOSLAR",
                    no = 7,
                    details = "",
                    image = "",
                    products = listOf(
                        MenuItem(
                            name = "Ranch Sos",
                            category = "",
                            price = 20,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Acı Sos",
                            category = "",
                            price = 20,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Tatlı Ekşi Sos",
                            category = "",
                            price = 20,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Sarımsak Sos",
                            category = "",
                            price = 20,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Ballı Hardal",
                            category = "",
                            price = 20,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Barbekü Sos",
                            category = "",
                            price = 20,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Köri Sos",
                            category = "",
                            price = 20,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Hardal",
                            category = "",
                            price = 20,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Pancar Sos",
                            category = "",
                            price = 20,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Guacamole Sos",
                            category = "",
                            price = 30,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Tatlı Acı Sos",
                            category = "",
                            price = 20,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "İçecekler",
                    no = 8,
                    details = "",
                    image = "",
                    products = listOf(
                        MenuItem(
                            name = "300cl Sütaş Ayran",
                            category = "",
                            price = 45,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Limonlu Soda",
                            category = "",
                            price = 30,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Sade Soda",
                            category = "",
                            price = 25,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "500cl Damla Su",
                            category = "",
                            price = 20,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "1Lt İçecek",
                            category = "",
                            price = 100,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Pepsi Cam Şişe Cola",
                            category = "",
                            price = 55,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Pepsi Cam Şişe Zero",
                            category = "",
                            price = 55,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Pepsi Kutu Cola",
                            category = "",
                            price = 60,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Pepsi Kutu Zero",
                            category = "",
                            price = 60,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Kutu Ice Tea Limon",
                            category = "",
                            price = 60,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Kutu Ice Tea Mango",
                            category = "",
                            price = 60,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Kutu Ice Tea Şeftali",
                            category = "",
                            price = 60,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "1 Litre Pepsi Cola",
                            category = "",
                            price = 90,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "1 Litre Pepsi Zero",
                            category = "",
                            price = 90,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "1 Litre Ice Tea Limon",
                            category = "",
                            price = 90,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "1 Litre Ice Tea Şeftali",
                            category = "",
                            price = 90,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "7up",
                            category = "",
                            price = 60,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "200 CC Coca Cola Cam Şişe",
                            category = "",
                            price = 45,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Kutu Coca Cola",
                            category = "",
                            price = 65,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Kutu Fanta",
                            category = "",
                            price = 65,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Kutu Sprite",
                            category = "",
                            price = 65,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Kutu Coca Cola Zero",
                            category = "",
                            price = 65,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Kutu Fuse Tea Şeftali",
                            category = "",
                            price = 65,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Kutu Fuse Tea Limon",
                            category = "",
                            price = 65,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Kutu Fuse Mango",
                            category = "",
                            price = 65,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Niğde Gazozu",
                            category = "",
                            price = 50,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "1 Litre Seven Up",
                            category = "",
                            price = 90,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "VEGİE BURGER MENÜ",
                    no = 9,
                    details = "",
                    image = "",
                    products = listOf(
                        MenuItem(
                            name = "Veggie Burger +Patates Kızartması",
                            category = "",
                            price = 300,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "120 Gr Cheddarlı Veggie Burger+Patates Kızartması",
                            category = "",
                            price = 310,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "120 Gr Vegie Burger+Patates Kızartması +Şişe içecek veya Ayran",
                            category = "",
                            price = 345,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "CHEDDARLI VEGİE CLOSED BURGER+PATATES KIZARTMASI",
                            category = "",
                            price = 400,
                            details = "240 gram falafel vegie köftesi,3 dilim cheddar peyniri,mantar,karamelize soğan,turşu,trüflü mayonez,bbq sos",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
            )
            "miligram-coffee-hisarustu" -> listOf(
                MenuCategory(
                    name = "Soğuk Kahveler",
                    no = 0,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Ice Americano",
                            category = "",
                            price = 190,
                            details = "",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63820caa02523ef3b3c619311681611235052.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Ice Filter Coffee",
                            category = "",
                            price = 190,
                            details = "",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63820caa02523ef3b3c619341681611276051.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Ice Latte",
                            category = "",
                            price = 210,
                            details = "",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63820caa02523ef3b3c619331681391630448.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Ice Caramel Latte",
                            category = "",
                            price = 240,
                            details = "Açıklama",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63bee2f59384bb45b2fdccc21681391670145.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Ice Mocha",
                            category = "",
                            price = 240,
                            details = "Açıklama",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Ice White Mocha",
                            category = "",
                            price = 240,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Ice Monochrome",
                            category = "",
                            price = 250,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Ice Chai Tea Latte",
                            category = "",
                            price = 220,
                            details = "Açıklama",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Ice Salted Caramel Latte",
                            category = "",
                            price = 240,
                            details = "Açıklama",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "İce Ube latte",
                            category = "",
                            price = 210,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "İce spanish latte",
                            category = "",
                            price = 250,
                            details = "İce spanish latte",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "İce espresso",
                            category = "",
                            price = 120,
                            details = "ice espresso",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Soğuk İçecekler",
                    no = 1,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Su",
                            category = "",
                            price = 50,
                            details = "Uludağ premium",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63820caf02523ef3b3c619c61693289389816.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Soda",
                            category = "",
                            price = 120,
                            details = "",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63820caf02523ef3b3c619c41692298986956.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Churchill",
                            category = "",
                            price = 180,
                            details = "",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63820caf02523ef3b3c619bf1681391901645.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Limonata",
                            category = "",
                            price = 230,
                            details = "",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/64664c058c9d530f7ac7baba1752741118336.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Orman MeyveliYakari",
                            category = "",
                            price = 220,
                            details = "Orman meyveleri-sprite-Limon-Nane",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/64397dee87456b7ee30b437f1683190039705.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Coca Cola",
                            category = "",
                            price = 120,
                            details = "",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63820caf02523ef3b3c619c71740560780459.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Coca Cola zero",
                            category = "",
                            price = 120,
                            details = "",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63820caf02523ef3b3c619c81740560962838.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Sprite",
                            category = "",
                            price = 120,
                            details = "Açıklama",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/6439b6ff87456b7ee30b44061681504337954.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Kutu Fanta",
                            category = "",
                            price = 120,
                            details = "Açıklama",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/64562de8a169bdd68307cff41740561015160.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Çilek Yakari",
                            category = "",
                            price = 220,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Çilekli Limonata",
                            category = "",
                            price = 250,
                            details = "",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/64bc32046a30d4173d7dc9f01690055963908.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Mangolu Limonata",
                            category = "",
                            price = 250,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Mango Yakari",
                            category = "",
                            price = 220,
                            details = "",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/685424abead195865efaef621750344948498.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Soğuk çikolatalı süt",
                            category = "",
                            price = 220,
                            details = "Soğuk çikolatalı süt",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "kuzu kulağı",
                            category = "",
                            price = 240,
                            details = "kuzu kulağı",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Sıcak Kahveler",
                    no = 2,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Americano",
                            category = "",
                            price = 140,
                            details = "Americano",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63820cad02523ef3b3c619851707724998707.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Latte",
                            category = "",
                            price = 150,
                            details = "Cafe latte",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63820cad02523ef3b3c6197d1704475923875.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Filtre Kahve",
                            category = "",
                            price = 120,
                            details = "",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63820cad02523ef3b3c619831681391588546.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Cappuccino",
                            category = "",
                            price = 150,
                            details = "Cappuccino",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63820cad02523ef3b3c619821715263891258.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Türk Kahvesi",
                            category = "",
                            price = 100,
                            details = "üstünde miligram logosu bulunan Türk kahvesi fincanı",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63820cad02523ef3b3c619861681391238855.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Double Türk Kahvesi",
                            category = "",
                            price = 140,
                            details = "Double Türk Kahvesi",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63eb91827e318044d518ac541704475637291.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Espresso",
                            category = "",
                            price = 100,
                            details = "Espresso",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63820cad02523ef3b3c619881681391266662.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Double Espresso",
                            category = "",
                            price = 120,
                            details = "Açıklama",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63b5d2da110683fea480335c1681391292945.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Flat White",
                            category = "",
                            price = 150,
                            details = "",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63820cad02523ef3b3c619801681391507756.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Cortado",
                            category = "",
                            price = 140,
                            details = "Cortado",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63820cad02523ef3b3c619871704475847775.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Mocha",
                            category = "",
                            price = 170,
                            details = "Mocha",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63b5d24e110683fea480335b1715264014754.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "White Mocha",
                            category = "",
                            price = 170,
                            details = "White Mocha kremasız",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63820cad02523ef3b3c6197e1715265204549.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Monochrome",
                            category = "",
                            price = 180,
                            details = "Beyaz Çikolata, Bitter Çikolata, Espresso, Süt",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Chai Tea Latte",
                            category = "",
                            price = 150,
                            details = "",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63820cad02523ef3b3c619811681391721453.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Chai Tea Latte Espresso",
                            category = "",
                            price = 170,
                            details = "Açıklama",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63b6e796110683fea48033691681391842652.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Sıcak Çikolata",
                            category = "",
                            price = 150,
                            details = "Sıcak çikolata",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63b6e9aa110683fea480336a1715265134555.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Salted Caramel Latte",
                            category = "",
                            price = 170,
                            details = "Tuzlu karamel-Espresso-süt",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Sıcak Süt",
                            category = "",
                            price = 100,
                            details = "Açıklama",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63b728b8110683fea48033751681391767858.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Büyük Seçim",
                            category = "",
                            price = 25,
                            details = "Büyük bardak seçimi",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Ube Latte",
                            category = "",
                            price = 190,
                            details = "hafif kreması, Genellikle vanilya, hafif fındık veya pişmiş kestane notalarına benzetilir.",
                            image = "https://cdn.chex.com.tr/images/product/644ac8f033330cd1629c97a11776260934653.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "spanish Latte",
                            category = "",
                            price = 190,
                            details = "spanish Latte",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/65998af56b275a32475377ae1768225552656.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Marsmellow'lu sıcak çikolata",
                            category = "",
                            price = 190,
                            details = "Marsmellow'lu sıcak çikolata",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/65998afc6b275a32475377af1764246285693.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Çaylar",
                    no = 3,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Çay",
                            category = "",
                            price = 40,
                            details = "",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63820cab02523ef3b3c619571682270166338.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Büyük Çay",
                            category = "",
                            price = 60,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Green Form",
                            category = "",
                            price = 150,
                            details = "Ananas, Yeşil Çay, Rezene, Lemongrass",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63820cab02523ef3b3c619551704360369659.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Summer Sun",
                            category = "",
                            price = 150,
                            details = "Ananas, Hibiskus, Limon çimi, elma, kuşüzümü, portakal kabuğu",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63820cab02523ef3b3c6195b1704375061940.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Papatya",
                            category = "",
                            price = 150,
                            details = "Saf Papatya çayı",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63820cab02523ef3b3c619601705590241759.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Sansuma",
                            category = "",
                            price = 150,
                            details = "Satsuma, Limon otu, Mint, Portakal kabuğu",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63820cab02523ef3b3c619561759912607801.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "All Seasons",
                            category = "",
                            price = 150,
                            details = "Zencefil, hibiskus, mint, kuşburnu, portakal kabuğu karışık bitki çayı",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63820cab02523ef3b3c619591759912444918.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Fas çayı",
                            category = "",
                            price = 150,
                            details = "Yeşil çay, mint, elma, gül",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63820cab02523ef3b3c6195d1760436524013.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Wınterfell (Kış Çayı)",
                            category = "",
                            price = 150,
                            details = "Zencefilli kış çayı",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Jasmine",
                            category = "",
                            price = 150,
                            details = "yaseminli yeşil çay",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/65620c7c0e6670596d8ad0b21759912569511.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Green",
                            category = "",
                            price = 150,
                            details = "Saf yeşilçay",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Midsommar",
                            category = "",
                            price = 150,
                            details = "Ihlamurlu Bahar Çayı; Ihlamur, kuşburnu, karanfil, elma, melisa, kırmızı karabiber, portakal kabuğu",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Sandviçler",
                    no = 4,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "üç peynirli bagel",
                            category = "",
                            price = 180,
                            details = "",
                            image = "https://cdn.chex.com.tr/images/product/64b908f634bd442845db482e1778678629566.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Gurme peynirli üçgen sandviç",
                            category = "",
                            price = 180,
                            details = "Buğday tahıllı ekmek, beyaz peynir, siyah zeytin, domates, fesleğenli sos kırmızı ve yeşil biber",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/65981d215fafab8e99565ea21717595041488.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Mozerella peynirli Dana jambonlu Sandviç",
                            category = "",
                            price = 200,
                            details = "Tahıllı buğdaylı ekmek, jambon, Mozerella, domates, fesleğenli sos",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/66606d597d8b685524ad81911717596387762.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Kaşarlı cheddarlı Focaccia Sandviç",
                            category = "",
                            price = 190,
                            details = "Focaccia ekmek, cheddar, kaşar peyniri közlenmiş kapya pesto sos, dilim zeytin",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/66606fa57d8b685524ad846c1717596289772.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Cheddarlı Hindi Fümeli Haşhaşlı panini Sandviç",
                            category = "",
                            price = 190,
                            details = "Hindi göğüs, cheddar, krem peynirli Haşhaşlı kekik kuru domates",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/666070e17d8b685524ad859c1717597190678.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Gurme üçgen dana salam",
                            category = "",
                            price = 200,
                            details = "dana salam, chedar, kaşar, yeşil-kırmızı biber",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Tatlılar",
                    no = 5,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Antep fıstıklı marlenka",
                            category = "",
                            price = 270,
                            details = "Antep fıstığı, Bal, Ceviz, Tereyağı",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63b5cbe0110683fea48033571682158797910.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "San Sebastian Cheesecake",
                            category = "",
                            price = 340,
                            details = "San Sebastian Cheesecake",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/641dae925e7efce79cd3a7711744208437118.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Çikolatalı browni",
                            category = "",
                            price = 270,
                            details = "Çikolatalı browni",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/66a0acea9c706df54539f9e91765826424949.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Parça Çikolatalı Cookie",
                            category = "",
                            price = 140,
                            details = "Handmade, Tereyağlı, Dışı Kıtır, İçi Sakızımsı, Sütlü Çikolatalı",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/63eca29b7e318044d518adad1721653352391.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Özel Antep Fıstıklı Mag",
                            category = "",
                            price = 270,
                            details = "Bourbon vanilya fıstık",
                            image = "https://cdn.chex.com.tr/images/product/65f2c14244e8c8b90443a1961776338511449.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Cevizli marlenka",
                            category = "",
                            price = 270,
                            details = "",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/6751d161b05fca6e76dc87531733415474010.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Frozen",
                    no = 6,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Limon Frozen",
                            category = "",
                            price = 220,
                            details = "",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/6692828947074acd0918486e1720877797730.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Kivili Frozen",
                            category = "",
                            price = 220,
                            details = "Kivili Frozen",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/6420462b5e7efce79cd3aad51681391918250.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Çilek Frozen",
                            category = "",
                            price = 220,
                            details = "Açıklama",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Orman Meyveli Frozen",
                            category = "",
                            price = 220,
                            details = "",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/64358407ff3830c148cae2271693578559518.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Limon Kivi Frozen",
                            category = "",
                            price = 220,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Soğuk Çaylar",
                    no = 7,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Cool lime",
                            category = "",
                            price = 210,
                            details = "Misket limonu, nane",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/6485a441ef37eb150c5c0e3a1686487294412.jpg",
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "MATCHA",
                    no = 8,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Ice vanilla matcha latte",
                            category = "",
                            price = 240,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Ice Strawberry Matcha Latte",
                            category = "",
                            price = 240,
                            details = "",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/6838a1be40d6a0765250e5231748542417301.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Ice Matcha Latte",
                            category = "",
                            price = 210,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Matcha Latte",
                            category = "",
                            price = 170,
                            details = "",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/68f5f44ee34cf59672da9fb31760949515843.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Strawberry Matcha Latte",
                            category = "",
                            price = 200,
                            details = "",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/68f5f529e34cf59672daa0391760949678545.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Milkshake",
                    no = 9,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Cici Bebe Milkshake",
                            category = "",
                            price = 230,
                            details = "Açıklama",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/64358470ff3830c148cae2291693606569497.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Çilek Milkshake",
                            category = "",
                            price = 230,
                            details = "Çilek Milkshake",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Orman Meyveli Milkshake",
                            category = "",
                            price = 230,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Ekstralar",
                    no = 10,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Şal",
                            category = "",
                            price = 250,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Büyük seçim",
                            category = "",
                            price = 10,
                            details = "Büyük seçim",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Dondurma ( Tek Top )",
                            category = "",
                            price = 60,
                            details = "Ürünün yanında ekstra olarak top fiyatı",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "vanilya",
                            category = "",
                            price = 24,
                            details = "Açıklama",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "karamel",
                            category = "",
                            price = 24,
                            details = "Açıklama",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "fındık",
                            category = "",
                            price = 24,
                            details = "Açıklama",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "extra shot",
                            category = "",
                            price = 30,
                            details = "Açıklama",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Bal",
                            category = "",
                            price = 30,
                            details = "Bal parmak",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Belçika çikolatası",
                            category = "",
                            price = 60,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Miligram",
                    no = 11,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Patates Kızartması",
                            category = "",
                            price = 110,
                            details = "Patates Kızartması",
                            image = "https://cdn.chex.com.tr/images/product/645f5e0223bdecc2c5f5d2271772806005868.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Menemen",
                            category = "",
                            price = 140,
                            details = "İki yumurtalı Menemen, Dilim Ekmek servis edilir.",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/647ee98d071393074d75d98f1740469325848.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Çırpılmış Yumurta",
                            category = "",
                            price = 120,
                            details = "Çırpılmış Yumurta",
                            image = "https://d1menc1ksg2bot.cloudfront.net/images/product/64a9573350b043134b66ed221740469547945.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Elma Dilim Patates",
                            category = "",
                            price = 150,
                            details = "Elma Dilim Patates",
                            image = "https://cdn.chex.com.tr/images/product/67c59ff6d59ac114856e90151772805666266.jpeg",
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
                MenuCategory(
                    name = "Soslar",
                    no = 13,
                    details = "",
                    image = null,
                    products = listOf(
                        MenuItem(
                            name = "Srirachalı Mayonez",
                            category = "",
                            price = 25,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Trüflü Mayonez",
                            category = "",
                            price = 35,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Sriracha",
                            category = "",
                            price = 25,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                        MenuItem(
                            name = "Burger Sos",
                            category = "",
                            price = 25,
                            details = "",
                            image = null,
                            visibleOnQr = true,
                            passive = false
                        ),
                    )
                ),
            )
            else -> emptyList()
        }

    fun menus(id: String) = menuCategories(id).flatMap { it.products }

    fun reviews(id: String): List<Review> =
        when (id) {
            "babs-hisarustu" -> listOf(
                Review(
                    title = "hey",
                    author = "admin",
                    rating = 5,
                    body = "test"
                ),
                Review(
                    title = "Awesome pub vibe",
                    author = "Berk",
                    rating = 5,
                    body = "Great music selection and drinks are very reasonable for Hisarüstü."
                ),
                Review(
                    title = "Good snacks",
                    author = "Didem",
                    rating = 4,
                    body = "Bar plates are big and à santé beers are highly recommended."
                ),
                Review(
                    title = "aa",
                    author = "admin",
                    rating = 5,
                    body = "a"
                ),
                Review(
                    title = "a",
                    author = "admin",
                    rating = 4,
                    body = "aa"
                ),
            )
            "dynamite-kitchen" -> listOf(
                Review(
                    title = "n",
                    author = "admin",
                    rating = 1,
                    body = "j"
                ),
                Review(
                    title = "Reliable between lectures",
                    author = "Ece",
                    rating = 5,
                    body = "Fast service, clear student discount, and enough tables for groups."
                ),
                Review(
                    title = "Good value",
                    author = "Mert",
                    rating = 4,
                    body = "Menu updates are accurate and the distance estimate is useful."
                ),
            )
            "hamburg-burger-hisarustu" -> listOf(
                Review(
                    title = "Best burgers in Hisarüstü!",
                    author = "Arda",
                    rating = 5,
                    body = "The meat is cooked perfectly, special sauce is amazing. Always hot when served."
                ),
                Review(
                    title = "Great portion size",
                    author = "Zeynep",
                    rating = 4,
                    body = "Good fries and big burgers. The delivery is fast."
                ),
            )
            "miligram-coffee-hisarustu" -> listOf(
                Review(
                    title = "Best cold brew on campus",
                    author = "Sinan",
                    rating = 5,
                    body = "Super friendly staff, delicious cheesecakes and great filters."
                ),
                Review(
                    title = "Cozy space",
                    author = "Melis",
                    rating = 4,
                    body = "Nice seating area to study or hang out with friends."
                ),
            )
            else -> emptyList()
        }

    fun discounts(id: String): List<Discount> =
        when (id) {
            "babs-hisarustu" -> listOf(
            )
            "dynamite-kitchen" -> listOf(
                Discount(
                    title = "Verified student deal",
                    value = "15% off",
                    terms = "Requires active university verification. Cannot be combined with campaigns.",
                    expires = "Valid until Jun 30, 2026"
                ),
            )
            "hamburg-burger-hisarustu" -> listOf(
                Discount(
                    title = "Burger & Drink Combo Deal",
                    value = "10% off",
                    terms = "Valid for menu combos. Automatic checkout discount.",
                    expires = "Valid until Jul 31, 2026"
                ),
            )
            "miligram-coffee-hisarustu" -> listOf(
            )
            else -> emptyList()
        }

    fun allItemReviewsForVenue(venueId: String): List<Review> =
        menuCategories(venueId).flatMap { category ->
            category.products.flatMap { item -> itemReviews(venueId, item.itemId) }
        }

    fun itemReviews(venueId: String, itemId: String): List<Review> =
        when (venueId to itemId) {
            "dynamite-kitchen" to "hamburger" -> listOf(
                Review(
                    title = "Solid classic burger",
                    author = "Ece",
                    rating = 5,
                    body = "The patty is juicy and the caramelized onions make this a reliable order."
                ),
                Review(
                    title = "Good portion",
                    author = "Mert",
                    rating = 4,
                    body = "Comes with fries and coleslaw. Worth it on student nights."
                )
            )
            "dynamite-kitchen" to "cheeseburger" -> listOf(
                Review(
                    title = "Cheesy and filling",
                    author = "Selin",
                    rating = 5,
                    body = "Double cheddar works really well with the house sauce."
                )
            )
            "hamburg-burger-hisarustu" to "hamburg-burger" -> listOf(
                Review(
                    title = "Best burger nearby",
                    author = "Can",
                    rating = 5,
                    body = "Fast service and consistently good quality."
                )
            )
            else -> emptyList()
        }
}
