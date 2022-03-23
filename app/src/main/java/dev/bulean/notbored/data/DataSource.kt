package dev.bulean.notbored.data

class DataSource {
    fun loadData(): List<String> {
        return listOf(
            "education",
            "recreational",
            "social",
            "diy",
            "charity",
            "cooking",
            "relaxation",
            "music",
            "busywork"
        )
    }
}