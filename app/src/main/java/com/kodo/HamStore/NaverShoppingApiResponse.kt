package com.kodo.HamStore

data class NaverShoppingApiResponse(var total:Int, var display:String, var items:List<ShoppingItem>)

data class ShoppingItem(
    var title:String,
    var link:String,
    var image:String,
    var lprice:String,
    var mallName:String,
    var brand:String,
    var maker:String,
)
