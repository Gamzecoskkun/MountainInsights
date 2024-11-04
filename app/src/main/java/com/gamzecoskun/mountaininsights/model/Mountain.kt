package com.gamzecoskun.mountaininsights.model

data class Mountain(
    val title: String,
    val description: String,
    val image: String
)

val mountains = listOf(
    Mountain(
        title = "Uludag",
        description = " Uludağ is one of Turkey's largest winter and nature sports centers. Located in the Marmara Region within the boundaries of Bursa province,it stands as the highest mountain in the region, reaching 2,543 meters in elevation. Uludağ is particularly popular during winter for skiing, snowboarding, and other winter sports. The area is protected as Uludağ National Park, home to diverse flora and fauna.In summer, it also attracts visitors for hiking, camping, and picnicking activities.",
        image = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Uludag.JPG/1024px-Uludag.JPG"
    ),
    Mountain(
        title = "Mount Nemrut",
        description = "Mount Nemrut is located in southeastern Turkey, within the Kahta district of Adıyaman province. Known for its height of 2,150 meters, it is listed as a UNESCO World Heritage Site. The mountain hosts the ancient ruins of the Kingdom of Commagene. Massive statues and monumental tombs, built by King Antiochus I in the 1st century BCE, are found at the summit. The statues of gods, along with lion and eagle figures on the eastern and western terraces, are particularly striking. The sunrise and sunset views from Mount Nemrut are especially breathtaking. ",
        image = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a3/Mount_Nemrut_-_East_Terrace_%284961323529%29.jpg/1024px-Mount_Nemrut_-_East_Terrace_%284961323529%29.jpg"
    ),
    Mountain(
        title = "Mount Erciyes",
        description = "Mount Erciyes is a volcanic mountain located in Turkey's Central Anatolia Region, within Kayseri province. Standing at 3,917 meters, it is the fifth-highest mountain in Turkey and an important hub for winter sports. Erciyes is popular for activities like skiing and snowboarding, featuring extensive slopes and modern facilities. While it draws many visitors in winter, it is also suitable for mountaineering, hiking, and camping in the summer months. Mount Erciyes is one of Turkey's prominent attractions for both nature lovers and sports enthusiasts.",
        image = "https://www.kampingturkiye.com/uploads/products/erciyes-dagi-3356462973.png"
    )



    )
