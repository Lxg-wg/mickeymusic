let searchKey = $("#searchKey")
//当用户提交搜索请求并且搜索框为空时,则提交系统给出的热门推荐
$("#search_form").submit(function () {
    if (searchKey.val().trim()===""){
        searchKey.val(searchKey.attr("placeholder"))
    }
})