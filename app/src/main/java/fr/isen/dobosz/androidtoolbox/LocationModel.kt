package fr.isen.dobosz.androidtoolbox



class LocationModel {
    var city: String? = null
    var state: String? = null
    var country: String? = null
    var street: StreetModel? = null
}

class StreetModel {
    var name: String? = null
}