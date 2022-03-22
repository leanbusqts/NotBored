package dev.bulean.notbored.data

import dev.bulean.notbored.activities.TypesActivities

class DataSource {
    fun loadData(): List<TypesActivities> {
        return listOf<TypesActivities>(
            TypesActivities(1, "education" ),
            TypesActivities(3, "recreational" ),
            TypesActivities(2, "social" ),
            TypesActivities(4, "diy" ),
            TypesActivities(2, "charity" ),
            TypesActivities(1, "cooking" ),
            TypesActivities(2, "relaxation" ),
            TypesActivities(3, "music" ),
            TypesActivities(1, "busywork" ),
        )
    }
}