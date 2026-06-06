package com.yigittepe.nearcampus1.data

import com.yigittepe.nearcampus1.model.MenuCategory
import com.yigittepe.nearcampus1.model.MenuItem

internal object DynamiteKitchenMenuData {
    val categories = listOf(
        category(
            id = "-NqOglRRvx5Dq5YdOElb",
            name = "ÇORBA",
            no = 0,
            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-O_qgdTpqJwdPw5m-2tk.jpg?alt=media&token=3cf9f867-c1b9-42eb-b848-101c3bd13a4b",
            products = listOf(
                item("-NqOglRRvx5Dq5YdOEld", "Mercimek Çorbası", "ÇORBA", 120, image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-O_qgpOgF8CX80WIFgW9.jpg?alt=media&token=7cac82a3-febc-4a35-bf29-4ec913ec4668")
            )
        ),
        category(
            id = "-NqmUAcgRgp0jXkBBJdo",
            name = "AVANTAJLI MENÜ",
            no = 1,
            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqmZjWfYWjcTKxlkgH7.jpg?alt=media&token=2bb217bb-7ddb-458d-b9c5-54af20a9b7da",
            products = listOf(
                item("-NqmXPTclUvw384H91_h", "Dynamite Dürüm Menü", "AVANTAJLI MENÜ", 420, "Kızarmış tortilla ekmeği, 175 gr tavuk bonfile, domates, biber, chedar peyniri, patates kızartması ve içecek.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqm_9TT4TcbAdwkeWVX.jpg?alt=media&token=04d0780f-5b0c-4a70-9de5-82d614b923ad"),
                item("-NqmXPWBh4D6SPsGPV-1", "Köfte Dürüm Menü", "AVANTAJLI MENÜ", 465, "Kızarmış tortilla ekmeği, domates, biber, yeşillik, isteğe bağlı soğan, patates kızartması ve içecek.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqm_PT9HXyLa5fH0HRs.jpg?alt=media&token=06d7d593-a226-471e-ac06-92cd14e9b981"),
                item("-NqmXPYZnctR17i0QBTn", "Çıtır Dürüm Menü", "AVANTAJLI MENÜ", 430, "El yapımı şinitzel, ketçap, hardallı ve mayonezli sos, domates, göbek, turşu, patates kızartması ve içecek.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqm_KAVLE9YcfsOJCHq.jpg?alt=media&token=19e98041-905b-4688-b7a0-dda01617ae70"),
                item("-NqmXP_evHd1B2UAX-xB", "Falafel Dürüm Menü", "AVANTAJLI MENÜ", 395, "Falafel, göbek, domates, kapya biber, kekik, patates kızartması ve içecek.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqm_VTDs_Qaq-A7EOlo.jpg?alt=media&token=ce644225-2472-4b00-9ec8-2702828c36b9"),
                item("-NqmXPbXEeH4ozn0dEiV", "Dynamite Tavuk Porsiyon Menü", "AVANTAJLI MENÜ", 460, "200 gr ızgara tavuk bonfile, patates kızartması, pilav, mevsim salatası, amerikan salatası ve içecek.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqm_bMORZ4unZOD9G9A.jpg?alt=media&token=93468889-a9d2-4bce-b8e6-7db841bc114f"),
                item("-NqmXPlN5sc87XkKehBJ", "Chedarlı Dynamite Tavuk Porsiyon Menü", "AVANTAJLI MENÜ", 480, "200 gr ızgara tavuk bonfile üzerine chedar peyniri, patates kızartması, pilav, salatalar ve içecek.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqm_esu_6b_Ma4B8DVi.jpg?alt=media&token=cae0c671-98d8-4c7b-8a62-988eebc30bf2"),
                item("-NqmXPnDTnb_jCLAy9tp", "Izgara Köfte Porsiyon Menü", "AVANTAJLI MENÜ", 510, "200 gr ızgara köfte, patates kızartması, pilav, salatalar, köz biber, domates, acuka ve içecek.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqma-dMuqwVAsBr7Z7O.jpg?alt=media&token=76debf1f-f458-4366-b3a6-bed6ef97de2d"),
                item("-NqmXnppNduYGeqN_qT0", "Tavuk Şinitzel Menü", "AVANTAJLI MENÜ", 480, "200 gr el yapımı şinitzel, patates kızartması, pirinç pilavı, mevsim salatası, amerikan salatası ve içecek.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqma4jwr7NN-3WkzTVb.jpg?alt=media&token=baa00405-da79-4244-8bdd-901007d24aa4"),
                item("-NqmXnrnqc4CHjCJJCRy", "Izgara Tavuk Göğüs Menü", "AVANTAJLI MENÜ", 470, "200 gr soslu tavuk bonfile, patates kızartması, pilav, salatalar ve içecek.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqma7WzvhWLYGiIeL37.jpg?alt=media&token=051b0a97-2bb7-4158-ad7d-3a1023fc5f40"),
                item("-Nqmh7smFUxfWw3wQThd", "Çıtır Tavuk Parçaları Menü", "AVANTAJLI MENÜ", 410, "200 gr çıtır tavuk parçaları, patates kızartması, sweet chili sos ve içecek.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqmiYnHAOIgP_pFOrFA.jpg?alt=media&token=dbc519d3-61fc-4e72-af31-c1041e5b822f"),
                item("-NqmhIboal19XYMdDnSY", "Susamlı Çıtır Tavuk Parçaları Menü", "AVANTAJLI MENÜ", 420, "200 gr susamlı çıtır tavuk parçaları, patates kızartması, sweet chili sos ve içecek.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqmiVTVdFRjGHmt4XK5.jpg?alt=media&token=a7139341-6a18-4139-824c-425202be0f75"),
                item("-NqnoOszj-nSfDFnDvU1", "Tatlı Acı Soslu Çıtır Tavuk Menü", "AVANTAJLI MENÜ", 420, "200 gr tatlı acı soslu çıtır tavuk parçaları, patates kızartması ve içecek.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqnpZKr531T6NmEX6s-.jpg?alt=media&token=8d38010a-05d5-401e-bd70-242de45ab506")
            )
        ),
        category(
            id = "-NtC28HK6Tg-26NPMsNY",
            name = "DÜRÜM + PATATES KIZARTMASI",
            no = 2,
            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NtC4_VRi1eQdgnPoD-k.jpg?alt=media&token=6527151b-c156-4e1f-840f-785c7af82fca",
            products = listOf(
                item("-NtC3Xelsx8e64mRcWzf", "Dynamite Dürüm + Patates Kızartması", "DÜRÜM + PATATES KIZARTMASI", 360, "Tavuk bonfile, domates, biber, chedar peyniri ve patates kızartması.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NtC50dkwKWS3E8AIGy_.jpg?alt=media&token=e6f4e1aa-6725-4016-b266-94e65927bfad"),
                item("-NtC3fPy8beBXZtnHSQK", "Çıtır Dürüm + Patates Kızartması", "DÜRÜM + PATATES KIZARTMASI", 370, "El yapımı şinitzel, ketçap, peri peri sos, domates, göbek, turşu ve patates kızartması.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NtC56dGNjJUK7unUQd5.jpg?alt=media&token=beda6f62-2752-479b-9a80-7b903f28a849"),
                item("-NtC3p3W_flmRqz5aJb9", "Köfte Dürüm + Patates Kızartması", "DÜRÜM + PATATES KIZARTMASI", 395, "Peri peri sos, domates, biber, yeşillik, isteğe bağlı soğan ve patates kızartması.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NtC5Abo-CF-nZEu-9wG.jpg?alt=media&token=45d206d4-9b6e-4703-93f8-eac1be781c70"),
                item("-NtC3zyOxQ7q6_F5ELEc", "Falafel Dürüm + Patates Kızartması", "DÜRÜM + PATATES KIZARTMASI", 355, "Falafel, göbek, domates, kapya biber, kekik and patates kızartması.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NtC5Q-T-2aQpF-Dd3WU.jpg?alt=media&token=8e3a7f35-835b-4789-a68d-19d8475e21bb")
            )
        ),
        category(
            id = "-NqP92y46gFrcZUTgwJb",
            name = "ÇITIR LEZZET",
            no = 3,
            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqmTXOAnkEmgdINXCUZ.jpg?alt=media&token=1d149354-0098-4960-9ce7-804f3798042a",
            products = listOf(
                item("-NqP95enkGYOYkMGlf5b", "Çıtır Tavuk Parçaları", "ÇITIR LEZZET", 350, "200 gr 7-8 parça çıtır tavuk parçaları, patates kızartması ve sweet chili sos.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiEu99eCFHBoGtc1eb.jpg?alt=media&token=6dccfa09-a83f-4e16-a00f-17dc11d1697f"),
                item("-NqP9FrEoLAFIXP3mnyD", "Susamlı Çıtır Tavuk", "ÇITIR LEZZET", 360, "200 gr susamlı çıtır tavuk parçaları, patates kızartması ve sweet chili sos.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiF3Iq3_qNnK2NfYJz.jpg?alt=media&token=a6792649-2277-47b6-90c6-0a0f204448ec"),
                item("-Nqno8yXyBRjHwpgmbtT", "Tatlı Acı Soslu Çıtır Tavuk", "ÇITIR LEZZET", 360, "200 gr tatlı acı soslu çıtır tavuk parçaları ve patates kızartması.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqnpUqYMU5Wt2FYQ-p0.jpg?alt=media&token=fe80474d-f0cb-448e-bab3-4cd9f62409f4"),
                item("-NqP9PgJgEeEv2Op051d", "Patates Kızartması", "ÇITIR LEZZET", 150),
                item("-NqP9TS9bCNX9ZGaN0Xk", "Permasanlı Patates Kızartması", "ÇITIR LEZZET", 175),
                item("-NqP9aIrVvgNPHFcbopU", "Trüflü Patates Kızartması", "ÇITIR LEZZET", 175),
                item("-NqP9gYntdNteBbGXFyd", "Trüflü Permasanlı Patates Kızartması", "ÇITIR LEZZET", 200)
            )
        ),
        category(
            id = "-NqP6sQn6BFIsp-XHKCm",
            name = "PORSİYON",
            no = 4,
            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqmQWicpUYw-b1IL81C.jpg?alt=media&token=434b719c-c096-47ce-b148-616f4bc6ced5",
            products = listOf(
                item("-NqP6vpdmdAD5leq1tad", "Dynamite Tavuk Porsiyon", "PORSİYON", 400, "200 gr ızgara tavuk bonfile, patates kızartması, pilav, mevsim salatası ve amerikan salatası.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqmRTV72PtofoIdlL-R.jpg?alt=media&token=1d1776f2-bd38-44ab-ba23-54db7b4507a5"),
                item("-NqP73H2QjL0rvkRmZw6", "Chedarlı Dynamite Tavuk Porsiyon", "PORSİYON", 420, "200 gr tavuk bonfile üzerine chedar peyniri, patates kızartması, pilav ve salatalar.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqmRRH_AauyHVa1ujmS.jpg?alt=media&token=d30860d0-699c-4fe2-b6d8-98f3d7cbf13b"),
                item("-NqP7Bhc_Gx6w5n1T46o", "Izgara Köfte Porsiyon", "PORSİYON", 450, "200 gr 6 adet ızgara köfte, patates kızartması, pilav, salatalar, köz biber, domates, acuka ve soğan.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiDpL-E3zQJZBElmUI.jpg?alt=media&token=3ea5746d-a9c4-4dd6-813b-142b7ba6efd5"),
                item("-NqP7ELtHbx4jRHSqfWY", "Tavuk Şinitzel", "PORSİYON", 420, "200 gr el yapımı şinitzel, patates kızartması, pirinç pilavı, salatalar ve tatlı acı sos.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqmRdWqjVA9uhR055oU.jpg?alt=media&token=7e05912b-11ca-45bd-8694-15d94f5f5f4b"),
                item("-NqP7JZap3RiiSzPQVlw", "Izgara Tavuk Göğüs", "PORSİYON", 410, "200 gr tavuk bonfile, patates kızartması, pilav ve salatalar.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiE5mME_AD-oWRkLYT.jpg?alt=media&token=562fd698-438c-41c8-8e59-d749706fa31a")
            )
        ),
        category(
            id = "-NqP3xU42DHUwvmyC0S7",
            name = "DÜRÜM",
            no = 5,
            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqmQMgSG5vPRm9TgPUn.jpg?alt=media&token=33f557e3-36b8-41a4-8e40-0f897d202a7a",
            products = listOf(
                item("-NqP667LQI7nHKMztTTP", "Dynamite Dürüm", "DÜRÜM", 320, "Kızarmış tortilla ekmeği, 175 gr tavuk bonfile, domates, biber ve chedar peyniri.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqi0xxMiyKVV_nzAcNy.jpg?alt=media&token=d1745317-7385-476f-9bb6-dcdc6c7931ef"),
                item("-NqP6Hd5iWePKrPkJGJL", "Çıtır Dürüm", "DÜRÜM", 330, "El yapımı şinitzel, ketçap, peri peri sos, domates, göbek and turşu.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiCLmF7YkGsneWWr9W.jpg?alt=media&token=d75b8291-5940-4989-a2d7-c1aa7c6181cf"),
                item("-NqP6AmBrUwS951-3DT7", "Köfte Dürüm", "DÜRÜM", 365, "Peri peri sos, domates, biber, yeşillik and isteğe bağlı soğan.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiCGfCbRl1jrt28jsL.jpg?alt=media&token=84e616fa-7429-4449-beab-c8e330b9d178"),
                item("-NqP6OgWFYFknpgddgrM", "Falafel Dürüm", "DÜRÜM", 315, "Peri peri sos, falafel, göbek, domates, kapya biber and kekik.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiCSF2oE3p5RudYVuc.jpg?alt=media&token=38d983f0-f3ba-43eb-afa5-c5e0865ff4bb")
            )
        ),
        category(
            id = "-Nqnqq0Db8OERG-Ri95s",
            name = "BURGER MENÜLERİ",
            no = 6,
            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqnv7gvkOIT6RofKh-b.jpg?alt=media&token=4efbc4ee-29f5-46dd-a9c8-e9ed58f50b04",
            products = listOf(
                item("-NqnqwMNnEBuZVQ_8ydK", "Hamburger(140gr) Menü", "BURGER MENÜLERİ", 445, "Patates kızartması, domates, göbek, salatalık turşusu, peri peri sos ve içecek.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqntdQTGITrvaj4KIDz.jpg?alt=media&token=8eddd985-d701-42ff-a0cb-a46a0942d8ec"),
                item("-Nqnqzd-EEYbCI4o79KF", "Cheese Burger(140gr) Menü", "BURGER MENÜLERİ", 465, "Patates kızartması, chedar peyniri, domates, göbek, turşu, peri peri sos ve içecek.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqntolHlIAprpBwtisB.jpg?alt=media&token=613b5f04-1fa9-4032-8369-c371a889b7d1"),
                item("-NqnrLcxiqgsXbnTT819", "Dynamite Burger(175gr) Menü", "BURGER MENÜLERİ", 505, "Patates kızartması, chedar peyniri, domates, göbek, turşu, karamelize soğan, peri peri sos ve içecek.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqnu7Mv_mKMRU2o_iV5.jpg?alt=media&token=453f46e7-7cea-4f4c-95b5-1b1b540b5861"),
                item("-NqnrNiUcZx6Feq7FFtK", "Kule Burger(200gr) Menü", "BURGER MENÜLERİ", 580, "İki köfte arasında köz patlıcan, karamelize soğan, chedar peyniri, domates, göbek, turşu, peri peri sos ve içecek.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqnu5jhKJwWzK9RMkXt.jpg?alt=media&token=dafc23d4-a797-4d39-b89e-2512f115d4fe"),
                item("-NqnrNsOZg6Hbs-51IlD", "Tavuk Burger Menü", "BURGER MENÜLERİ", 400, "El yapımı tavuk şinitzel, domates, göbek, turşu, peri peri sos, ketçap and içecek.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqnuRNSVB5I7_JQKk8m.jpg?alt=media&token=31529eb2-1343-434f-b1a7-a449d20220bc"),
                item("-NqnrSChTtV_rd5JRNS-", "Tatlı Acı Burger Menü", "BURGER MENÜLERİ", 410, "El yapımı tavuk şinitzel, domates, göbek, tatlı acı sos ve içecek.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqnuZs06NwqL4IUPswM.jpg?alt=media&token=1e3c5b67-bf4a-492b-bccd-1609291420db"),
                item("-NqnrSM3orwBcLQQOdk8", "Kaşarlı Tavuk Burger Menü", "BURGER MENÜLERİ", 430, "El yapımı tavuk şinitzel, chedar peyniri, domates, göbek, turşu, peri peri sos, ketçap ve içecek.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqnukKcO-veWGiMEPGV.jpg?alt=media&token=7c366970-65a3-4a2d-8d08-8c85bbb1be78"),
                item("-Nqnt31_SJ0cdkKmMqZu", "Falafel Burger Menü", "BURGER MENÜLERİ", 390, "Falafel, göbek, domates, turşu, kapya biber, kekik, peri peri sos and içecek.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqnuznn7RtRFAJUJOP_.jpg?alt=media&token=8ead4b1a-1c80-4b7a-9aae-9967c86f44af")
            )
        ),
        category(
            id = "-NqP6szSqrSB6_77zsAy",
            name = "BURGER",
            no = 7,
            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqmS0S1kCzbGvi3napt.jpg?alt=media&token=ea522270-d8ec-465e-a4ea-25e26cf4e0c0",
            products = listOf(
                item("-NqP7xuVtU7B1Z3tqDFd", "Hamburger", "BURGER", 385, "140 gr, patates kızartması, domates, göbek, salatalık turşusu and peri peri sos.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiEQYmPUS7tRBYvk83.jpg?alt=media&token=33dfa327-f9b2-445f-a584-32573cd6d150"),
                item("-NqP81t2ZlAhbi28RhCB", "Cheese Burger", "BURGER", 405, "140 gr, patates kızartması, chedar peyniri, domates, göbek, turşu and peri peri sos.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiEVtm0DasagSKtvDF.jpg?alt=media&token=08e420a4-c82f-4189-9b8c-d740f63a91bf"),
                item("-NqP87vwSydJeeYv24t-", "Dynamite Burger", "BURGER", 445, "175 gr, patates kızartması, chedar peyniri, domates, göbek, turşu, karamelize soğan and peri peri sos.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiEYGpqZsQ3Q9RXqd8.jpg?alt=media&token=0378035f-670b-4732-af56-732c2e8d88bf"),
                item("-NqP8DriC-L1UNby8vza", "Kule Burger", "BURGER", 520, "200 gr, iki köfte arasında köz patlıcan, karamelize soğan, chedar peyniri, domates, göbek, turşu and peri peri sos.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiEcGG4a2O7GGeoxCj.jpg?alt=media&token=9cee06cf-baa6-4741-83fd-f6d137ec64ae"),
                item("-NqP8Gzn0a9feN22Ltv0", "Tavuk Burger", "BURGER", 340, "Patates kızartması, el yapımı tavuk şinitzel, domates, göbek, turşu, peri peri sos and ketçap.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiEeknZGg7dfo4A_nb.jpg?alt=media&token=06e7e16e-ebfb-4c54-9dd7-a76d50475fcf"),
                item("-NqP8LWF9guypWcFpmc7", "Tatlı Acı Tavuk Burger", "BURGER", 350, "Patates kızartması, el yapımı tavuk şinitzel, domates, göbek and tatlı acı sos.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiEgzeED__za-ufEJf.jpg?alt=media&token=8c749aaa-a1cd-4ed2-8d6d-5d480f571153"),
                item("-NqP8SidAMotQa_19Aak", "Kaşarlı Tavuk Burger", "BURGER", 370, "Patates kızartması, el yapımı tavuk şinitzel, chedar peyniri, domates, göbek, turşu, peri peri sos and ketçap.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiEjcNWhvEQRPCJw97.jpg?alt=media&token=9f86b9db-41e5-44bc-a094-3b6360f6f9f5"),
                item("-NqP8XH80mjFy14QbfPI", "Falafel Burger", "BURGER", 330, "Patates kızartması, falafel, göbek, domates, turşu, kapya biber, kekik and peri peri sos.", "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqiElecHoHLjyO0xHtE.jpg?alt=media&token=38c608bf-a256-4e9e-876b-fc7e72dbb839")
            )
        ),
        category(
            id = "-Nqmr6NyQuuuVauOu-Ro",
            name = "SOS",
            no = 8,
            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-Nqn-3-ETNr7HaZ8DmNa.jpg?alt=media&token=f5fe902d-c236-4ff2-9894-076b43034291",
            products = listOf(
                item("-Nqmr8mGvP4ovdPQZpqL", "Sweet Chili", "SOS", 20),
                item("-NqmrC2Eoax9M65KtQtc", "Dynamite", "SOS", 20),
                item("-NqmrGqLT_2WFRqkguVs", "Ranch", "SOS", 20),
                item("-NqmrIlvh7d6rRU0LOBU", "Barbekü", "SOS", 20),
                item("-NqmrKC5yrIQ33l7ifXX", "Trüflü Mayonez", "SOS", 20),
                item("-NqmrMUf8yBfc5PiqJPb", "Sriracha", "SOS", 20),
                item("-NqmrU3ObskTYUtg0HzP", "Sarımsaklı Mayonez", "SOS", 20)
            )
        ),
        category(
            id = "-NqP8ey7t4u9H6uGnxiB",
            name = "SALATA",
            no = 9,
            visibleOnQr = false,
            products = listOf(
                item("-OVZqnItrFyOxFyvrNu3", "Sezar Salata", "SALATA", 300, "Izgara tavuk göğüs, mevsim yeşillikleri, avokado, fındık, kurutulmuş domates, mısır and sezar sos.", visibleOnQr = false),
                item("-OVZsYrzSUJCH1OZqxI6", "Izgara Tavuklu Salata", "SALATA", 300, "Izgara tavuk göğüs, mevsim yeşillikleri, avokado, fındık, kurutulmuş domates, mısır and özel sos.", visibleOnQr = false),
                item("-OVZrQHm_ywvs2Z14hQR", "Çıtır Tavuklu Salata", "SALATA", 300, "Çıtır tavuk parçaları, mevsim yeşillikleri, avokado, kurutulmuş domates, mısır and özel sos.", visibleOnQr = false),
                item("-OVZszJp2-X_YVzvYPOh", "Şinitzel Salata", "SALATA", 300, "Şinitzel, mevsim yeşillikleri, avokado, kurutulmuş domates, mısır and özel sos.", visibleOnQr = false),
                item("-OVZs9SZg7ASj_nWl9d8", "Ton Balıklı Salata", "SALATA", 300, "Ton balığı, mevsim yeşillikleri, avokado, kurutulmuş domates, mısır and özel sos.", visibleOnQr = false),
                item("-OVZsMkr5sHaAadu15fM", "Izgara Köfteli Salata", "SALATA", 300, "Izgara köfte, mevsim yeşillikleri, soğan, kurutulmuş domates, mısır and özel sos.", visibleOnQr = false),
                item("-OVZsp-z21ZlGjvLP9Bz", "Falafel Salata", "SALATA", 300, "Falafel, mevsim yeşillikleri, avokado, kapya biber, kurutulmuş domates, mısır and özel sos.", visibleOnQr = false),
                item("-OVZt2Mx_pAvTq3QDWw3", "Izgara Hellim Salata", "SALATA", 300, "Hellim peyniri, mevsim yeşillikleri, avokado, ceviz, kurutulmuş domates, mısır and özel sos.", visibleOnQr = false),
                item("-Oo4vPk4AmYP7TriZmuO", "Dynamite Salata", "SALATA", 300, "Dynamite tavuk, mevsim yeşillikleri, avokado, kurutulmuş domates, mısır and özel sos.")
            )
        ),
        category(
            id = "-OlcaRn8TL1yZ7iXIp5y",
            name = "TATLI",
            no = 10,
            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-OlcapX9ptSjpBRmdmVm.jpg?alt=media&token=6e65bc79-b286-4bd4-8e04-995a07ab83b2",
            products = listOf(
                item("-OlcaT05qncampNrkUlM", "Fırın Sütlaç", "TATLI", 120, image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-OlcarhUh0uITQ0RVzss.jpg?alt=media&token=0ef63412-70a5-4c80-bc00-98e7eb233fbc"),
                item("-OmsNhHNTezU-y-p3aDf", "Profiterol", "TATLI", 120, visibleOnQr = false)
            )
        ),
        category(
            id = "-NqP9oLpLQJ0pbfMVkFV",
            name = "İÇECEK",
            no = 11,
            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqmzY4gyE4Pql108bh5.jpg?alt=media&token=7573cc17-4c21-446b-a359-2db5cad1dede",
            products = listOf(
                item("-NqP9roVKKcq1Y9xlT2K", "Cola", "İÇECEK", 70, "330 ML"),
                item("-NqmlddADl42aDoyYeEF", "Fanta", "İÇECEK", 70, "330 ML"),
                item("-NqP9wroiyHyzp9tPpQo", "Sprite", "İÇECEK", 70, "330 ML"),
                item("-NqPA-VWDncQrISdPAly", "İce Tea", "İÇECEK", 70, "Limon / Mango / Şeftali / Karpuz / Kavun ve Çilek"),
                item("-NqPA2CfH-ska4UgTKmf", "Ayran", "İÇECEK", 50, "Sütaş Ayran 300 ML"),
                item("-NvlS4DebD8R2p-LKuPc", "Özerhisar Ayran", "İÇECEK", 70, "245 ML"),
                item("-NqPA4OePmo36ypsOQrK", "Soda", "İÇECEK", 30, "Damla Soda"),
                item("-NqPA8s3JLjqTKlzOhf_", "Su", "İÇECEK", 20, "Damla Su")
            )
        ),
        category(
            id = "-NqPAChFSLvYGQIVwYwe",
            name = "SICAK İÇECEK",
            no = 12,
            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-NqmziB4xdPPn-pdmpFk.jpg?alt=media&token=2bd2e009-b734-4543-a867-144fd13aa90a",
            products = listOf(
                item("-NqPAFt5QtqjuxkApgjk", "Çay", "SICAK İÇECEK", 40),
                item("-NqPAIuJax2i8alu9_55", "Türk Kahvesi", "SICAK İÇECEK", 80, visibleOnQr = false),
                item("-NqPANqr_vEK_frPimro", "Nescafe", "SICAK İÇECEK", 60)
            )
        ),
        category(
            id = "-NqrXQPO_9E_7sJRiXNL",
            name = "PAKET İLAVE",
            no = 13,
            image = "https://firebasestorage.googleapis.com/v0/b/ordertakingsystem-29f8f.appspot.com/o/uploads%2F-NoXKZW6cY0jBVRqGYiq%2F-OUzn3wbBualMdfmQhHh.jpg?alt=media&token=624a8a7a-5de8-4f50-abd5-238d2ad91175",
            products = listOf(
                item("-NqrXS_NNijvHJsrFsJ5", "Lavaş", "PAKET İLAVE", 20),
                item("-ORSQjwAGIsj114DMOAi", "Pirinç Pilavı", "PAKET İLAVE", 50),
                item("-ORXEJGNXROKHRml5lVV", "Mevsim Salata", "PAKET İLAVE", 45),
                item("-Opde0w_2E0fFQFkwSap", "1.5 Çıtır Tavuk", "PAKET İLAVE", 530),
                item("-Opde2pagB5Iyeiy0rQW", "1.5 Susamlı Çıtır Tavuk", "PAKET İLAVE", 540),
                item("-Opdelb2P1UqyGjWYOBk", "1.5 Tatlı Acı Soslu Çıtır Tavuk", "PAKET İLAVE", 540),
                item("-OqkedJxjCrauHJ2pREE", "Yarım Çıtır Tavuk", "PAKET İLAVE", 200),
                item("-OqkefB4x3nTne87aES2", "Yarım Susamlı Çıtır Tavuk", "PAKET İLAVE", 210),
                item("-OqkehLCjOh5Vq8Y-Lll", "Yarım Tatlı Acı Çıtır Tavuk", "PAKET İLAVE", 210)
            )
        )
    ).sortedBy { it.no }

    val visibleCategories = categories
        .filter { it.visibleOnQr }
        .map { category ->
            category.copy(products = category.products.filter { it.visibleOnQr && !it.passive })
        }
        .filter { it.products.isNotEmpty() }

    val visibleProducts = visibleCategories.flatMap { it.products }

    private fun category(
        id: String,
        name: String,
        no: Int,
        details: String = "",
        image: String? = null,
        visibleOnQr: Boolean = true,
        products: List<MenuItem>
    ) = MenuCategory(name, no, details, image, visibleOnQr, products.sortedBy { it.name })

    private fun item(
        id: String,
        name: String,
        category: String,
        price: Int,
        details: String = "",
        image: String? = null,
        visibleOnQr: Boolean = true,
        passive: Boolean = false
    ) = MenuItem(name, category, price, details, image, visibleOnQr, passive)
}
