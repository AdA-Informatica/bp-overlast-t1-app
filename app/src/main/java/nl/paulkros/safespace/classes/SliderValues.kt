package nl.paulkros.safespace.classes
// This class formats the data to the correct type so that the API endpoint will be able to handle this data
data class SliderValues(
    val sliderValues: Map<String, Int>
)