package creational_patterns.prototype

class Report {
    fun printReport(reportItems: MutableMap<String, ReportItemPrototype>) {
        reportItems.forEach { (key, value) ->
            when (value) {
                is TextItem -> println("$key TextItem $value")
                is ImageItem -> println("$key ImageItem $value")
            }
        }
    }
}

//cache OR manager OR registry prototypes
class ReportItemsCache {
    private val reportItems: MutableMap<String, ReportItemPrototype> = mutableMapOf()

    fun addItem(key: String, newItem: ReportItemPrototype){
        reportItems[key] = newItem
    }

    fun getItem(key: String): ReportItemPrototype {
        return reportItems[key]?.clone() ?: throw Exception("no item with this key")
    }
}