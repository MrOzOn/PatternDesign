package creational_patterns.prototype



fun main() {
    val report = Report()
    val reportItems: MutableMap<String, ReportItemPrototype> = mutableMapOf()

    val text = TextItem()
    text.text = "Normal text"
    text.color = Color.Black
    reportItems["Normal text"] = text

    val image = ImageItem()
    image.url = "/image/url"
    image.width = 100
    reportItems["Normal image"] = image

    report.printReport(reportItems)

    val redText = text.clone()
    redText.initializeText("Red text", Color.Red)
    reportItems["Red text"] = redText

    val secondImage = image.clone()
    reportItems["Second image"] = secondImage

    println("\nUpdated report")

    report.printReport(reportItems)

    // OR Using Cache

    println()
    val reportItemsCache = ReportItemsCache()
    reportItemsCache.addItem("item1",text)
    reportItemsCache.addItem("item2",image)

    //get item from registry by key
    val first = reportItemsCache.getItem("item1")
//    val first = reportItemsCache.getItem("item144") // BAD KEY
    when (first) {
        // edit used fields and use it
        is TextItem -> println("text with text=${first.text} color=${first.color}")
        is ImageItem -> println("image with url=${first.url} width=${first.width}")
    }
}