var isEmpty = function (obj) {
    return obj === undefined || obj === null || obj === ''
}

/**
 * 判断一个对象是否不为空
 * 
 * @param {obj} obj 
 * @returns true when undefined or null or empty, false otherwise.
 */
var isNotEmpty = function (obj) {
    return !isEmpty(obj)
}

/**
 * 根据cookie名称获取cookie的值
 * 
 * @param {cookieName} cookieName 
 * @returns cookieValue
 */
var getCookie = function (cookieName) {
    var strCookie = document.cookie
    var arrCookie = strCookie.split(";")
    for (var i = 0; i < arrCookie.length; i++) {
        var arr = arrCookie[i].split("=")
        if (cookieName == arr[0]) {
            return arr[1]
        }
    }
    return ""
}

export {
    isEmpty,
    isNotEmpty,
    getCookie
}
